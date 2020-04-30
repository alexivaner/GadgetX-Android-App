// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.internal:
//            WorkQueue, ImageRequest, ImageResponseCache, UrlRedirectCache, 
//            Utility, ImageResponse

public class ImageDownloader
{
    private static class CacheReadWorkItem
        implements Runnable
    {

        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        public void run()
        {
            ImageDownloader.readFromCache(key, context, allowCachedRedirects);
        }

        CacheReadWorkItem(Context context1, RequestKey requestkey, boolean flag)
        {
            context = context1;
            key = requestkey;
            allowCachedRedirects = flag;
        }
    }

    private static class DownloadImageWorkItem
        implements Runnable
    {

        private Context context;
        private RequestKey key;

        public void run()
        {
            ImageDownloader.download(key, context);
        }

        DownloadImageWorkItem(Context context1, RequestKey requestkey)
        {
            context = context1;
            key = requestkey;
        }
    }

    private static class DownloaderContext
    {

        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext()
        {
        }

    }

    private static class RequestKey
    {

        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        Uri uri;

        public boolean equals(Object obj)
        {
label0:
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if (obj instanceof RequestKey)
                    {
                        obj = (RequestKey)obj;
                        if (((RequestKey) (obj)).uri != uri || ((RequestKey) (obj)).tag != tag)
                        {
                            break label0;
                        }
                        flag = true;
                    }
                }
                return flag;
            }
            return false;
        }

        public int hashCode()
        {
            return (uri.hashCode() + 1073) * 37 + tag.hashCode();
        }

        RequestKey(Uri uri1, Object obj)
        {
            uri = uri1;
            tag = obj;
        }
    }


    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static Handler handler;
    private static final Map pendingRequests = new HashMap();

    public ImageDownloader()
    {
    }

    public static boolean cancelRequest(ImageRequest imagerequest)
    {
        RequestKey requestkey;
        boolean flag;
        flag = false;
        requestkey = new RequestKey(imagerequest.getImageUri(), imagerequest.getCallerTag());
        imagerequest = pendingRequests;
        imagerequest;
        JVM INSTR monitorenter ;
        DownloaderContext downloadercontext = (DownloaderContext)pendingRequests.get(requestkey);
        if (downloadercontext == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        flag = true;
        if (!downloadercontext.workItem.cancel())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        pendingRequests.remove(requestkey);
_L1:
        imagerequest;
        JVM INSTR monitorexit ;
        return flag;
        downloadercontext.isCancelled = true;
          goto _L1
        Exception exception;
        exception;
        imagerequest;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void clearCache(Context context)
    {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
    }

    private static void download(RequestKey requestkey, Context context)
    {
        Object obj;
        Object obj1;
        HttpURLConnection httpurlconnection;
        HttpURLConnection httpurlconnection1;
        Object obj4;
        Object obj5;
        char ac[];
        Object obj6;
        Object obj7;
        Object obj8;
        boolean flag;
        boolean flag1;
        boolean flag2;
        httpurlconnection1 = null;
        httpurlconnection = null;
        obj7 = null;
        obj8 = null;
        obj6 = null;
        ac = null;
        obj5 = null;
        obj4 = null;
        flag2 = true;
        flag1 = true;
        flag = flag1;
        obj = obj6;
        obj1 = obj8;
        HttpURLConnection httpurlconnection2 = (HttpURLConnection)(new URL(requestkey.uri.toString())).openConnection();
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        httpurlconnection2.setInstanceFollowRedirects(false);
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        httpurlconnection2.getResponseCode();
        JVM INSTR lookupswitch 3: default 805
    //                   200: 634
    //                   301: 351
    //                   302: 351;
           goto _L1 _L2 _L3 _L3
_L1:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        Object obj3 = httpurlconnection2.getErrorStream();
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        Object obj2 = new StringBuilder();
        if (obj3 == null) goto _L5; else goto _L4
_L4:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        context = new InputStreamReader(((java.io.InputStream) (obj3)));
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        ac = new char[128];
_L7:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        int i = context.read(ac, 0, ac.length);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        ((StringBuilder) (obj2)).append(ac, 0, i);
        if (true) goto _L7; else goto _L6
        context;
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        Utility.disconnectQuietly(httpurlconnection);
        obj2 = context;
        context = obj4;
_L8:
        if (flag)
        {
            issueResponse(requestkey, ((Exception) (obj2)), context, false);
        }
        return;
_L3:
        i = 0;
        flag2 = false;
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        Object obj9 = httpurlconnection2.getHeaderField("location");
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        context = obj5;
        obj2 = ac;
        flag1 = i;
        obj3 = obj7;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        if (Utility.isNullOrEmpty(((String) (obj9))))
        {
            break MISSING_BLOCK_LABEL_617;
        }
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        obj9 = Uri.parse(((String) (obj9)));
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        UrlRedirectCache.cacheUriRedirect(requestkey.uri, ((Uri) (obj9)));
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        DownloaderContext downloadercontext = removePendingRequest(requestkey);
        context = obj5;
        obj2 = ac;
        flag1 = i;
        obj3 = obj7;
        if (downloadercontext == null)
        {
            break MISSING_BLOCK_LABEL_617;
        }
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        context = obj5;
        obj2 = ac;
        flag1 = i;
        obj3 = obj7;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        if (downloadercontext.isCancelled)
        {
            break MISSING_BLOCK_LABEL_617;
        }
        httpurlconnection = httpurlconnection2;
        flag = flag2;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        enqueueCacheRead(downloadercontext.request, new RequestKey(((Uri) (obj9)), requestkey.tag), false);
        obj3 = obj7;
        flag1 = i;
        obj2 = ac;
        context = obj5;
_L9:
        Utility.closeQuietly(((java.io.Closeable) (obj3)));
        Utility.disconnectQuietly(httpurlconnection2);
        flag = flag1;
          goto _L8
_L2:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj6;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj8;
        obj3 = ImageResponseCache.interceptAndCacheImageStream(context, httpurlconnection2);
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        context = BitmapFactory.decodeStream(((java.io.InputStream) (obj3)));
        obj2 = ac;
        flag1 = flag2;
          goto _L9
_L6:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        Utility.closeQuietly(context);
_L10:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        obj2 = new FacebookException(((StringBuilder) (obj2)).toString());
        context = obj5;
        flag1 = flag2;
          goto _L9
_L5:
        httpurlconnection = httpurlconnection2;
        flag = flag1;
        obj = obj3;
        httpurlconnection1 = httpurlconnection2;
        obj1 = obj3;
        ((StringBuilder) (obj2)).append(context.getString(com.facebook.R.string.com_facebook_image_download_unknown_error));
          goto _L10
        requestkey;
        Utility.closeQuietly(((java.io.Closeable) (obj1)));
        Utility.disconnectQuietly(httpurlconnection1);
        throw requestkey;
          goto _L9
    }

    public static void downloadAsync(ImageRequest imagerequest)
    {
        RequestKey requestkey;
        if (imagerequest == null)
        {
            return;
        }
        requestkey = new RequestKey(imagerequest.getImageUri(), imagerequest.getCallerTag());
        Map map = pendingRequests;
        map;
        JVM INSTR monitorenter ;
        DownloaderContext downloadercontext = (DownloaderContext)pendingRequests.get(requestkey);
        if (downloadercontext == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        downloadercontext.request = imagerequest;
        downloadercontext.isCancelled = false;
        downloadercontext.workItem.moveToFront();
_L1:
        map;
        JVM INSTR monitorexit ;
        return;
        imagerequest;
        map;
        JVM INSTR monitorexit ;
        throw imagerequest;
        enqueueCacheRead(imagerequest, requestkey, imagerequest.isCachedRedirectAllowed());
          goto _L1
    }

    private static void enqueueCacheRead(ImageRequest imagerequest, RequestKey requestkey, boolean flag)
    {
        enqueueRequest(imagerequest, requestkey, cacheReadQueue, new CacheReadWorkItem(imagerequest.getContext(), requestkey, flag));
    }

    private static void enqueueDownload(ImageRequest imagerequest, RequestKey requestkey)
    {
        enqueueRequest(imagerequest, requestkey, downloadQueue, new DownloadImageWorkItem(imagerequest.getContext(), requestkey));
    }

    private static void enqueueRequest(ImageRequest imagerequest, RequestKey requestkey, WorkQueue workqueue, Runnable runnable)
    {
        synchronized (pendingRequests)
        {
            DownloaderContext downloadercontext = new DownloaderContext();
            downloadercontext.request = imagerequest;
            pendingRequests.put(requestkey, downloadercontext);
            downloadercontext.workItem = workqueue.addActiveWorkItem(runnable);
        }
        return;
        imagerequest;
        map;
        JVM INSTR monitorexit ;
        throw imagerequest;
    }

    private static Handler getHandler()
    {
        com/facebook/internal/ImageDownloader;
        JVM INSTR monitorenter ;
        Handler handler1;
        if (handler == null)
        {
            handler = new Handler(Looper.getMainLooper());
        }
        handler1 = handler;
        com/facebook/internal/ImageDownloader;
        JVM INSTR monitorexit ;
        return handler1;
        Exception exception;
        exception;
        throw exception;
    }

    private static void issueResponse(RequestKey requestkey, Exception exception, Bitmap bitmap, boolean flag)
    {
        requestkey = removePendingRequest(requestkey);
        if (requestkey != null && !((DownloaderContext) (requestkey)).isCancelled)
        {
            requestkey = ((DownloaderContext) (requestkey)).request;
            ImageRequest.Callback callback = requestkey.getCallback();
            if (callback != null)
            {
                getHandler().post(new Runnable(requestkey, exception, flag, bitmap, callback) {

                    final Bitmap val$bitmap;
                    final ImageRequest.Callback val$callback;
                    final Exception val$error;
                    final boolean val$isCachedRedirect;
                    final ImageRequest val$request;

                    public void run()
                    {
                        ImageResponse imageresponse = new ImageResponse(request, error, isCachedRedirect, bitmap);
                        callback.onCompleted(imageresponse);
                    }

            
            {
                request = imagerequest;
                error = exception;
                isCachedRedirect = flag;
                bitmap = bitmap1;
                callback = callback1;
                super();
            }
                });
            }
        }
    }

    public static void prioritizeRequest(ImageRequest imagerequest)
    {
        Object obj = new RequestKey(imagerequest.getImageUri(), imagerequest.getCallerTag());
        imagerequest = pendingRequests;
        imagerequest;
        JVM INSTR monitorenter ;
        obj = (DownloaderContext)pendingRequests.get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        ((DownloaderContext) (obj)).workItem.moveToFront();
        imagerequest;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        imagerequest;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void readFromCache(RequestKey requestkey, Context context, boolean flag)
    {
        Object obj = null;
        boolean flag2 = false;
        java.io.InputStream inputstream = obj;
        boolean flag1 = flag2;
        if (flag)
        {
            Uri uri = UrlRedirectCache.getRedirectedUri(requestkey.uri);
            inputstream = obj;
            flag1 = flag2;
            if (uri != null)
            {
                inputstream = ImageResponseCache.getCachedImageStream(uri, context);
                if (inputstream != null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
        }
        if (!flag1)
        {
            inputstream = ImageResponseCache.getCachedImageStream(requestkey.uri, context);
        }
        if (inputstream != null)
        {
            context = BitmapFactory.decodeStream(inputstream);
            Utility.closeQuietly(inputstream);
            issueResponse(requestkey, null, context, flag1);
        } else
        {
            context = removePendingRequest(requestkey);
            if (context != null && !((DownloaderContext) (context)).isCancelled)
            {
                enqueueDownload(((DownloaderContext) (context)).request, requestkey);
                return;
            }
        }
    }

    private static DownloaderContext removePendingRequest(RequestKey requestkey)
    {
        synchronized (pendingRequests)
        {
            requestkey = (DownloaderContext)pendingRequests.remove(requestkey);
        }
        return requestkey;
        requestkey;
        map;
        JVM INSTR monitorexit ;
        throw requestkey;
    }



}
