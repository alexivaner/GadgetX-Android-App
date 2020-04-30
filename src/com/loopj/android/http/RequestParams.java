// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.loopj.android.http:
//            JsonStreamerEntity, SimpleMultipartEntity, ResponseHandlerInterface

public class RequestParams
    implements Serializable
{
    public static class FileWrapper
    {

        public final String contentType;
        public final String customFileName;
        public final File file;

        public FileWrapper(File file1, String s, String s1)
        {
            file = file1;
            contentType = s;
            customFileName = s1;
        }
    }

    public static class StreamWrapper
    {

        public final boolean autoClose;
        public final String contentType;
        public final InputStream inputStream;
        public final String name;

        static StreamWrapper newInstance(InputStream inputstream, String s, String s1, boolean flag)
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "application/octet-stream";
            }
            return new StreamWrapper(inputstream, s, s2, flag);
        }

        public StreamWrapper(InputStream inputstream, String s, String s1, boolean flag)
        {
            inputStream = inputstream;
            name = s;
            contentType = s1;
            autoClose = flag;
        }
    }


    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    protected boolean autoCloseInputStreams;
    protected String contentEncoding;
    protected final ConcurrentHashMap fileParams;
    protected boolean isRepeatable;
    protected final ConcurrentHashMap streamParams;
    protected final ConcurrentHashMap urlParams;
    protected final ConcurrentHashMap urlParamsWithObjects;
    protected boolean useJsonStreamer;

    public RequestParams()
    {
        this((Map)null);
    }

    public RequestParams(final String key, final String value)
    {
        this(((Map) (new HashMap() {

            final String val$key;
            final String val$value;

            
            {
                key = s;
                value = s1;
                super();
                put(key, value);
            }
        })));
    }

    public RequestParams(Map map)
    {
        urlParams = new ConcurrentHashMap();
        streamParams = new ConcurrentHashMap();
        fileParams = new ConcurrentHashMap();
        urlParamsWithObjects = new ConcurrentHashMap();
        contentEncoding = "UTF-8";
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); put((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
    }

    public transient RequestParams(Object aobj[])
    {
        urlParams = new ConcurrentHashMap();
        streamParams = new ConcurrentHashMap();
        fileParams = new ConcurrentHashMap();
        urlParamsWithObjects = new ConcurrentHashMap();
        contentEncoding = "UTF-8";
        int j = aobj.length;
        if (j % 2 != 0)
        {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < j; i += 2)
        {
            put(String.valueOf(aobj[i]), String.valueOf(aobj[i + 1]));
        }

    }

    private HttpEntity createFormEntity()
    {
        UrlEncodedFormEntity urlencodedformentity;
        try
        {
            urlencodedformentity = new UrlEncodedFormEntity(getParamsList(), contentEncoding);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.e("RequestParams", "createFormEntity failed", unsupportedencodingexception);
            return null;
        }
        return urlencodedformentity;
    }

    private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface responsehandlerinterface)
        throws IOException
    {
        boolean flag;
        if (!fileParams.isEmpty() || !streamParams.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        responsehandlerinterface = new JsonStreamerEntity(responsehandlerinterface, flag);
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); responsehandlerinterface.addPart((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        java.util.Map.Entry entry1;
        for (Iterator iterator1 = urlParamsWithObjects.entrySet().iterator(); iterator1.hasNext(); responsehandlerinterface.addPart((String)entry1.getKey(), entry1.getValue()))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        java.util.Map.Entry entry2;
        for (Iterator iterator2 = fileParams.entrySet().iterator(); iterator2.hasNext(); responsehandlerinterface.addPart((String)entry2.getKey(), entry2.getValue()))
        {
            entry2 = (java.util.Map.Entry)iterator2.next();
        }

        Iterator iterator3 = streamParams.entrySet().iterator();
        do
        {
            if (!iterator3.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator3.next();
            StreamWrapper streamwrapper = (StreamWrapper)entry3.getValue();
            if (streamwrapper.inputStream != null)
            {
                responsehandlerinterface.addPart((String)entry3.getKey(), StreamWrapper.newInstance(streamwrapper.inputStream, streamwrapper.name, streamwrapper.contentType, streamwrapper.autoClose));
            }
        } while (true);
        return responsehandlerinterface;
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface responsehandlerinterface)
        throws IOException
    {
        responsehandlerinterface = new SimpleMultipartEntity(responsehandlerinterface);
        responsehandlerinterface.setIsRepeatable(isRepeatable);
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); responsehandlerinterface.addPartWithCharset((String)entry.getKey(), (String)entry.getValue(), contentEncoding))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        BasicNameValuePair basicnamevaluepair;
        for (Iterator iterator1 = getParamsList(null, urlParamsWithObjects).iterator(); iterator1.hasNext(); responsehandlerinterface.addPartWithCharset(basicnamevaluepair.getName(), basicnamevaluepair.getValue(), contentEncoding))
        {
            basicnamevaluepair = (BasicNameValuePair)iterator1.next();
        }

        Iterator iterator2 = streamParams.entrySet().iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator2.next();
            StreamWrapper streamwrapper = (StreamWrapper)entry1.getValue();
            if (streamwrapper.inputStream != null)
            {
                responsehandlerinterface.addPart((String)entry1.getKey(), streamwrapper.name, streamwrapper.inputStream, streamwrapper.contentType);
            }
        } while (true);
        java.util.Map.Entry entry2;
        FileWrapper filewrapper;
        for (Iterator iterator3 = fileParams.entrySet().iterator(); iterator3.hasNext(); responsehandlerinterface.addPart((String)entry2.getKey(), filewrapper.file, filewrapper.contentType, filewrapper.customFileName))
        {
            entry2 = (java.util.Map.Entry)iterator3.next();
            filewrapper = (FileWrapper)entry2.getValue();
        }

        return responsehandlerinterface;
    }

    private List getParamsList(String s, Object obj)
    {
        LinkedList linkedlist = new LinkedList();
        if (obj instanceof Map)
        {
            Map map = (Map)obj;
            obj = new ArrayList(map.keySet());
            if (((List) (obj)).size() > 0 && (((List) (obj)).get(0) instanceof Comparable))
            {
                Collections.sort(((List) (obj)));
            }
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = iterator.next();
                if (obj instanceof String)
                {
                    Object obj1 = map.get(obj);
                    if (obj1 != null)
                    {
                        if (s == null)
                        {
                            obj = (String)obj;
                        } else
                        {
                            obj = String.format("%s[%s]", new Object[] {
                                s, obj
                            });
                        }
                        linkedlist.addAll(getParamsList(((String) (obj)), obj1));
                    }
                }
            } while (true);
        } else
        if (obj instanceof List)
        {
            obj = (List)obj;
            int k = ((List) (obj)).size();
            for (int i = 0; i < k; i++)
            {
                linkedlist.addAll(getParamsList(String.format("%s[%d]", new Object[] {
                    s, Integer.valueOf(i)
                }), ((List) (obj)).get(i)));
            }

        } else
        if (obj instanceof Object[])
        {
            obj = ((Object) ((Object[])(Object[])obj));
            int l = obj.length;
            for (int j = 0; j < l; j++)
            {
                linkedlist.addAll(getParamsList(String.format("%s[%d]", new Object[] {
                    s, Integer.valueOf(j)
                }), obj[j]));
            }

        } else
        if (obj instanceof Set)
        {
            for (obj = ((Set)obj).iterator(); ((Iterator) (obj)).hasNext(); linkedlist.addAll(getParamsList(s, ((Iterator) (obj)).next()))) { }
        } else
        {
            linkedlist.add(new BasicNameValuePair(s, obj.toString()));
        }
        return linkedlist;
    }

    public void add(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            Object obj1 = urlParamsWithObjects.get(s);
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = new HashSet();
                put(s, obj);
            }
            if (obj instanceof List)
            {
                ((List)obj).add(s1);
            } else
            if (obj instanceof Set)
            {
                ((Set)obj).add(s1);
                return;
            }
        }
    }

    public HttpEntity getEntity(ResponseHandlerInterface responsehandlerinterface)
        throws IOException
    {
        if (useJsonStreamer)
        {
            return createJsonStreamerEntity(responsehandlerinterface);
        }
        if (streamParams.isEmpty() && fileParams.isEmpty())
        {
            return createFormEntity();
        } else
        {
            return createMultipartEntity(responsehandlerinterface);
        }
    }

    protected String getParamString()
    {
        return URLEncodedUtils.format(getParamsList(), contentEncoding);
    }

    protected List getParamsList()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        linkedlist.addAll(getParamsList(null, urlParamsWithObjects));
        return linkedlist;
    }

    public boolean has(String s)
    {
        return urlParams.get(s) != null || streamParams.get(s) != null || fileParams.get(s) != null || urlParamsWithObjects.get(s) != null;
    }

    public void put(String s, int i)
    {
        if (s != null)
        {
            urlParams.put(s, String.valueOf(i));
        }
    }

    public void put(String s, long l)
    {
        if (s != null)
        {
            urlParams.put(s, String.valueOf(l));
        }
    }

    public void put(String s, File file)
        throws FileNotFoundException
    {
        put(s, file, null, null);
    }

    public void put(String s, File file, String s1)
        throws FileNotFoundException
    {
        put(s, file, s1, null);
    }

    public void put(String s, File file, String s1, String s2)
        throws FileNotFoundException
    {
        if (file == null || !file.exists())
        {
            throw new FileNotFoundException();
        }
        if (s != null)
        {
            fileParams.put(s, new FileWrapper(file, s1, s2));
        }
    }

    public void put(String s, InputStream inputstream)
    {
        put(s, inputstream, ((String) (null)));
    }

    public void put(String s, InputStream inputstream, String s1)
    {
        put(s, inputstream, s1, null);
    }

    public void put(String s, InputStream inputstream, String s1, String s2)
    {
        put(s, inputstream, s1, s2, autoCloseInputStreams);
    }

    public void put(String s, InputStream inputstream, String s1, String s2, boolean flag)
    {
        if (s != null && inputstream != null)
        {
            streamParams.put(s, StreamWrapper.newInstance(inputstream, s1, s2, flag));
        }
    }

    public void put(String s, Object obj)
    {
        if (s != null && obj != null)
        {
            urlParamsWithObjects.put(s, obj);
        }
    }

    public void put(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            urlParams.put(s, s1);
        }
    }

    public void put(String s, String s1, File file)
        throws FileNotFoundException
    {
        put(s, file, null, s1);
    }

    public void remove(String s)
    {
        urlParams.remove(s);
        streamParams.remove(s);
        fileParams.remove(s);
        urlParamsWithObjects.remove(s);
    }

    public void setAutoCloseInputStreams(boolean flag)
    {
        autoCloseInputStreams = flag;
    }

    public void setContentEncoding(String s)
    {
        if (s != null)
        {
            contentEncoding = s;
            return;
        } else
        {
            Log.d("RequestParams", "setContentEncoding called with null attribute");
            return;
        }
    }

    public void setHttpEntityIsRepeatable(boolean flag)
    {
        isRepeatable = flag;
    }

    public void setUseJsonStreamer(boolean flag)
    {
        useJsonStreamer = flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator1 = streamParams.entrySet().iterator(); iterator1.hasNext(); stringbuilder.append("STREAM"))
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry1.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator2 = fileParams.entrySet().iterator(); iterator2.hasNext(); stringbuilder.append("FILE"))
        {
            java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry2.getKey());
            stringbuilder.append("=");
        }

        BasicNameValuePair basicnamevaluepair;
        for (Iterator iterator3 = getParamsList(null, urlParamsWithObjects).iterator(); iterator3.hasNext(); stringbuilder.append(basicnamevaluepair.getValue()))
        {
            basicnamevaluepair = (BasicNameValuePair)iterator3.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(basicnamevaluepair.getName());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }
}
