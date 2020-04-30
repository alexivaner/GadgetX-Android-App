// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface, AsyncHttpClient

class SimpleMultipartEntity
    implements HttpEntity
{
    private class FilePart
    {

        public File file;
        public byte header[];
        final SimpleMultipartEntity this$0;

        private byte[] createHeader(String s, String s1, String s2)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            try
            {
                bytearrayoutputstream.write(boundaryLine);
                bytearrayoutputstream.write(createContentDisposition(s, s1));
                bytearrayoutputstream.write(createContentType(s2));
                bytearrayoutputstream.write(SimpleMultipartEntity.TRANSFER_ENCODING_BINARY);
                bytearrayoutputstream.write(SimpleMultipartEntity.CR_LF);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", s);
            }
            return bytearrayoutputstream.toByteArray();
        }

        public long getTotalLength()
        {
            long l = file.length();
            long l1 = SimpleMultipartEntity.CR_LF.length;
            return (long)header.length + (l + l1);
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            outputstream.write(header);
            updateProgress(header.length);
            FileInputStream fileinputstream = new FileInputStream(file);
            byte abyte0[] = new byte[4096];
            do
            {
                int i = fileinputstream.read(abyte0);
                if (i != -1)
                {
                    outputstream.write(abyte0, 0, i);
                    updateProgress(i);
                } else
                {
                    outputstream.write(SimpleMultipartEntity.CR_LF);
                    updateProgress(SimpleMultipartEntity.CR_LF.length);
                    outputstream.flush();
                    AsyncHttpClient.silentCloseInputStream(fileinputstream);
                    return;
                }
            } while (true);
        }

        public FilePart(String s, File file1, String s1)
        {
            this$0 = SimpleMultipartEntity.this;
            super();
            header = createHeader(s, file1.getName(), s1);
            file = file1;
        }

        public FilePart(String s, File file1, String s1, String s2)
        {
            this$0 = SimpleMultipartEntity.this;
            super();
            simplemultipartentity = s2;
            if (TextUtils.isEmpty(s2))
            {
                simplemultipartentity = file1.getName();
            }
            header = createHeader(s, SimpleMultipartEntity.this, s1);
            file = file1;
        }
    }


    private static final byte CR_LF[] = "\r\n".getBytes();
    private static final String LOG_TAG = "SimpleMultipartEntity";
    private static final char MULTIPART_CHARS[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String STR_CR_LF = "\r\n";
    private static final byte TRANSFER_ENCODING_BINARY[] = "Content-Transfer-Encoding: binary\r\n".getBytes();
    private final String boundary;
    private final byte boundaryEnd[];
    private final byte boundaryLine[];
    private int bytesWritten;
    private final List fileParts = new ArrayList();
    private boolean isRepeatable;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ResponseHandlerInterface progressHandler;
    private int totalSize;

    public SimpleMultipartEntity(ResponseHandlerInterface responsehandlerinterface)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++)
        {
            stringbuilder.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }

        boundary = stringbuilder.toString();
        boundaryLine = (new StringBuilder()).append("--").append(boundary).append("\r\n").toString().getBytes();
        boundaryEnd = (new StringBuilder()).append("--").append(boundary).append("--").append("\r\n").toString().getBytes();
        progressHandler = responsehandlerinterface;
    }

    private byte[] createContentDisposition(String s)
    {
        return (new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"").append("\r\n").toString().getBytes();
    }

    private byte[] createContentDisposition(String s, String s1)
    {
        return (new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"").append("; filename=\"").append(s1).append("\"").append("\r\n").toString().getBytes();
    }

    private byte[] createContentType(String s)
    {
        return (new StringBuilder()).append("Content-Type: ").append(normalizeContentType(s)).append("\r\n").toString().getBytes();
    }

    private String normalizeContentType(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "application/octet-stream";
        }
        return s1;
    }

    private void updateProgress(int i)
    {
        bytesWritten = bytesWritten + i;
        progressHandler.sendProgressMessage(bytesWritten, totalSize);
    }

    public void addPart(String s, File file)
    {
        addPart(s, file, null);
    }

    public void addPart(String s, File file, String s1)
    {
        fileParts.add(new FilePart(s, file, normalizeContentType(s1)));
    }

    public void addPart(String s, File file, String s1, String s2)
    {
        fileParts.add(new FilePart(s, file, normalizeContentType(s1), s2));
    }

    public void addPart(String s, String s1)
    {
        addPartWithCharset(s, s1, null);
    }

    public void addPart(String s, String s1, InputStream inputstream, String s2)
        throws IOException
    {
        out.write(boundaryLine);
        out.write(createContentDisposition(s, s1));
        out.write(createContentType(s2));
        out.write(TRANSFER_ENCODING_BINARY);
        out.write(CR_LF);
        s = new byte[4096];
        do
        {
            int i = inputstream.read(s);
            if (i != -1)
            {
                out.write(s, 0, i);
            } else
            {
                out.write(CR_LF);
                out.flush();
                AsyncHttpClient.silentCloseOutputStream(out);
                return;
            }
        } while (true);
    }

    public void addPart(String s, String s1, String s2)
    {
        try
        {
            out.write(boundaryLine);
            out.write(createContentDisposition(s));
            out.write(createContentType(s2));
            out.write(CR_LF);
            out.write(s1.getBytes());
            out.write(CR_LF);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", s);
        }
    }

    public void addPartWithCharset(String s, String s1, String s2)
    {
        String s3 = s2;
        if (s2 == null)
        {
            s3 = "UTF-8";
        }
        addPart(s, s1, (new StringBuilder()).append("text/plain; charset=").append(s3).toString());
    }

    public void consumeContent()
        throws IOException, UnsupportedOperationException
    {
        if (isStreaming())
        {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        } else
        {
            return;
        }
    }

    public InputStream getContent()
        throws IOException, UnsupportedOperationException
    {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }

    public Header getContentEncoding()
    {
        return null;
    }

    public long getContentLength()
    {
        long l = out.size();
        for (Iterator iterator = fileParts.iterator(); iterator.hasNext();)
        {
            long l1 = ((FilePart)iterator.next()).getTotalLength();
            if (l1 < 0L)
            {
                return -1L;
            }
            l += l1;
        }

        return l + (long)boundaryEnd.length;
    }

    public Header getContentType()
    {
        return new BasicHeader("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(boundary).toString());
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return isRepeatable;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void setIsRepeatable(boolean flag)
    {
        isRepeatable = flag;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        bytesWritten = 0;
        totalSize = (int)getContentLength();
        out.writeTo(outputstream);
        updateProgress(out.size());
        for (Iterator iterator = fileParts.iterator(); iterator.hasNext(); ((FilePart)iterator.next()).writeTo(outputstream)) { }
        outputstream.write(boundaryEnd);
        updateProgress(boundaryEnd.length);
    }







}
