// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

// Referenced classes of package com.facebook.internal:
//            FileLruCache, Utility, Logger

class UrlRedirectCache
{

    private static final String REDIRECT_CONTENT_TAG = (new StringBuilder()).append(TAG).append("_Redirect").toString();
    static final String TAG = com/facebook/internal/UrlRedirectCache.getSimpleName();
    private static volatile FileLruCache urlRedirectCache;

    UrlRedirectCache()
    {
    }

    static void cacheUriRedirect(Uri uri, Uri uri1)
    {
        if (uri == null || uri1 == null)
        {
            return;
        }
        Uri uri3 = null;
        Uri uri2 = null;
        try
        {
            uri = getCache().openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            Utility.closeQuietly(uri2);
            return;
        }
        finally
        {
            Utility.closeQuietly(uri3);
        }
        uri2 = uri;
        uri3 = uri;
        uri.write(uri1.toString().getBytes());
        Utility.closeQuietly(uri);
        return;
        throw uri;
    }

    static void clearCache()
    {
        try
        {
            getCache().clearCache();
            return;
        }
        catch (IOException ioexception)
        {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, (new StringBuilder()).append("clearCache failed ").append(ioexception.getMessage()).toString());
        }
    }

    static FileLruCache getCache()
        throws IOException
    {
        com/facebook/internal/UrlRedirectCache;
        JVM INSTR monitorenter ;
        FileLruCache filelrucache;
        if (urlRedirectCache == null)
        {
            urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
        }
        filelrucache = urlRedirectCache;
        com/facebook/internal/UrlRedirectCache;
        JVM INSTR monitorexit ;
        return filelrucache;
        Exception exception;
        exception;
        throw exception;
    }

    static Uri getRedirectedUri(Uri uri)
    {
        Object obj;
        Object obj1;
        if (uri == null)
        {
            return null;
        }
        obj1 = uri.toString();
        obj = null;
        uri = null;
        FileLruCache filelrucache = getCache();
        boolean flag;
        flag = false;
        uri = null;
        obj = obj1;
_L5:
        obj1 = filelrucache.get(((String) (obj)), REDIRECT_CONTENT_TAG);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        flag = true;
        obj1 = new InputStreamReader(((java.io.InputStream) (obj1)));
        uri = ((Uri) (obj1));
        obj = obj1;
        char ac[] = new char[128];
        uri = ((Uri) (obj1));
        obj = obj1;
        StringBuilder stringbuilder = new StringBuilder();
_L4:
        uri = ((Uri) (obj1));
        obj = obj1;
        int i = ((InputStreamReader) (obj1)).read(ac, 0, ac.length);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ((Uri) (obj1));
        obj = obj1;
        stringbuilder.append(ac, 0, i);
        if (true) goto _L4; else goto _L3
        obj;
_L8:
        Utility.closeQuietly(uri);
        return null;
_L3:
        uri = ((Uri) (obj1));
        obj = obj1;
        Utility.closeQuietly(((java.io.Closeable) (obj1)));
        uri = ((Uri) (obj1));
        obj = obj1;
        String s = stringbuilder.toString();
        obj = s;
        uri = ((Uri) (obj1));
          goto _L5
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        obj = Uri.parse(((String) (obj)));
        Utility.closeQuietly(uri);
        return ((Uri) (obj));
        Utility.closeQuietly(uri);
        return null;
        uri;
_L7:
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        throw uri;
        Exception exception;
        exception;
        obj = uri;
        uri = exception;
        if (true) goto _L7; else goto _L6
_L6:
        IOException ioexception;
        ioexception;
          goto _L8
    }

}
