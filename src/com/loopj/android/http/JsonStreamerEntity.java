// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            Base64OutputStream, ResponseHandlerInterface, AsyncHttpClient, JsonValueInterface

public class JsonStreamerEntity
    implements HttpEntity
{

    private static final int BUFFER_SIZE = 4096;
    private static final StringBuilder BUILDER = new StringBuilder(128);
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final byte JSON_FALSE[] = "false".getBytes();
    private static final byte JSON_NULL[] = "null".getBytes();
    private static final byte JSON_TRUE[] = "true".getBytes();
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte STREAM_CONTENTS[] = escape("contents");
    private static final byte STREAM_ELAPSED[] = escape("_elapsed");
    private static final byte STREAM_NAME[] = escape("name");
    private static final byte STREAM_TYPE[] = escape("type");
    private final byte buffer[] = new byte[4096];
    private final Header contentEncoding;
    private final Map jsonParams = new HashMap();
    private final ResponseHandlerInterface progressHandler;

    public JsonStreamerEntity(ResponseHandlerInterface responsehandlerinterface, boolean flag)
    {
        progressHandler = responsehandlerinterface;
        if (flag)
        {
            responsehandlerinterface = HEADER_GZIP_ENCODING;
        } else
        {
            responsehandlerinterface = null;
        }
        contentEncoding = responsehandlerinterface;
    }

    private void endMetaData(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(34);
    }

    static byte[] escape(String s)
    {
        if (s == null)
        {
            return JSON_NULL;
        }
        BUILDER.append('"');
        int k = s.length();
        int i = -1;
label0:
        do
        {
            char c;
            int j;
label1:
            {
                j = i + 1;
                if (j >= k)
                {
                    break label0;
                }
                c = s.charAt(j);
                String s1;
                switch (c)
                {
                default:
                    if (c >= 0 && c <= '\037' || c >= '\177' && c <= '\237' || c >= '\u2000' && c <= '\u20FF')
                    {
                        s1 = Integer.toHexString(c);
                        BUILDER.append("\\u");
                        int l = s1.length();
                        for (i = 0; i < 4 - l; i++)
                        {
                            BUILDER.append('0');
                        }

                        break;
                    }
                    break label1;

                case 34: // '"'
                    BUILDER.append("\\\"");
                    i = j;
                    continue;

                case 92: // '\\'
                    BUILDER.append("\\\\");
                    i = j;
                    continue;

                case 8: // '\b'
                    BUILDER.append("\\b");
                    i = j;
                    continue;

                case 12: // '\f'
                    BUILDER.append("\\f");
                    i = j;
                    continue;

                case 10: // '\n'
                    BUILDER.append("\\n");
                    i = j;
                    continue;

                case 13: // '\r'
                    BUILDER.append("\\r");
                    i = j;
                    continue;

                case 9: // '\t'
                    BUILDER.append("\\t");
                    i = j;
                    continue;
                }
                BUILDER.append(s1.toUpperCase(Locale.US));
                i = j;
                continue;
            }
            BUILDER.append(c);
            i = j;
        } while (true);
        BUILDER.append('"');
        s = BUILDER.toString().getBytes();
        BUILDER.setLength(0);
        return s;
        s;
        BUILDER.setLength(0);
        throw s;
    }

    private void writeMetaData(OutputStream outputstream, String s, String s1)
        throws IOException
    {
        outputstream.write(STREAM_NAME);
        outputstream.write(58);
        outputstream.write(escape(s));
        outputstream.write(44);
        outputstream.write(STREAM_TYPE);
        outputstream.write(58);
        outputstream.write(escape(s1));
        outputstream.write(44);
        outputstream.write(STREAM_CONTENTS);
        outputstream.write(58);
        outputstream.write(34);
    }

    private void writeToFromFile(OutputStream outputstream, RequestParams.FileWrapper filewrapper)
        throws IOException
    {
        writeMetaData(outputstream, filewrapper.file.getName(), filewrapper.contentType);
        int i = 0;
        int j = (int)filewrapper.file.length();
        filewrapper = new FileInputStream(filewrapper.file);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        do
        {
            int k = filewrapper.read(buffer);
            if (k != -1)
            {
                base64outputstream.write(buffer, 0, k);
                i += k;
                progressHandler.sendProgressMessage(i, j);
            } else
            {
                AsyncHttpClient.silentCloseOutputStream(base64outputstream);
                endMetaData(outputstream);
                AsyncHttpClient.silentCloseInputStream(filewrapper);
                return;
            }
        } while (true);
    }

    private void writeToFromStream(OutputStream outputstream, RequestParams.StreamWrapper streamwrapper)
        throws IOException
    {
        writeMetaData(outputstream, streamwrapper.name, streamwrapper.contentType);
        Base64OutputStream base64outputstream = new Base64OutputStream(outputstream, 18);
        do
        {
            int i = streamwrapper.inputStream.read(buffer);
            if (i == -1)
            {
                break;
            }
            base64outputstream.write(buffer, 0, i);
        } while (true);
        AsyncHttpClient.silentCloseOutputStream(base64outputstream);
        endMetaData(outputstream);
        if (streamwrapper.autoClose)
        {
            AsyncHttpClient.silentCloseInputStream(streamwrapper.inputStream);
        }
    }

    public void addPart(String s, Object obj)
    {
        jsonParams.put(s, obj);
    }

    public void consumeContent()
        throws IOException, UnsupportedOperationException
    {
    }

    public InputStream getContent()
        throws IOException, UnsupportedOperationException
    {
        throw ERR_UNSUPPORTED;
    }

    public Header getContentEncoding()
    {
        return contentEncoding;
    }

    public long getContentLength()
    {
        return -1L;
    }

    public Header getContentType()
    {
        return HEADER_JSON_CONTENT;
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long l = System.currentTimeMillis();
        if (contentEncoding != null)
        {
            outputstream = new GZIPOutputStream(outputstream, 4096);
        }
        outputstream.write(123);
        Iterator iterator = jsonParams.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = jsonParams.get(s);
            if (obj != null)
            {
                outputstream.write(escape(s));
                outputstream.write(58);
                boolean flag = obj instanceof RequestParams.FileWrapper;
                if (flag || (obj instanceof RequestParams.StreamWrapper))
                {
                    outputstream.write(123);
                    if (flag)
                    {
                        writeToFromFile(outputstream, (RequestParams.FileWrapper)obj);
                    } else
                    {
                        writeToFromStream(outputstream, (RequestParams.StreamWrapper)obj);
                    }
                    outputstream.write(125);
                } else
                if (obj instanceof JsonValueInterface)
                {
                    outputstream.write(((JsonValueInterface)obj).getEscapedJsonValue());
                } else
                if (obj instanceof JSONObject)
                {
                    outputstream.write(((JSONObject)obj).toString().getBytes());
                } else
                if (obj instanceof JSONArray)
                {
                    outputstream.write(((JSONArray)obj).toString().getBytes());
                } else
                if (obj instanceof Boolean)
                {
                    byte abyte0[];
                    if (((Boolean)obj).booleanValue())
                    {
                        abyte0 = JSON_TRUE;
                    } else
                    {
                        abyte0 = JSON_FALSE;
                    }
                    outputstream.write(abyte0);
                } else
                if (obj instanceof Long)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).longValue()).append("").toString().getBytes());
                } else
                if (obj instanceof Double)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).doubleValue()).append("").toString().getBytes());
                } else
                if (obj instanceof Float)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).floatValue()).append("").toString().getBytes());
                } else
                if (obj instanceof Integer)
                {
                    outputstream.write((new StringBuilder()).append(((Number)obj).intValue()).append("").toString().getBytes());
                } else
                {
                    outputstream.write(escape(obj.toString()));
                }
                outputstream.write(44);
            }
        } while (true);
        outputstream.write(STREAM_ELAPSED);
        outputstream.write(58);
        l = System.currentTimeMillis() - l;
        outputstream.write((new StringBuilder()).append(l).append("}").toString().getBytes());
        Log.i("JsonStreamerEntity", (new StringBuilder()).append("Uploaded JSON in ").append(Math.floor(l / 1000L)).append(" seconds").toString());
        outputstream.flush();
        AsyncHttpClient.silentCloseOutputStream(outputstream);
    }

}
