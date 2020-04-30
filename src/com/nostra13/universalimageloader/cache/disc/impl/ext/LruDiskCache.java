// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache

public class LruDiskCache
    implements DiskCache
{

    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final android.graphics.Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected DiskLruCache cache;
    protected android.graphics.Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator filenamegenerator, long l)
        throws IOException
    {
        this(file, null, filenamegenerator, l, 0);
    }

    public LruDiskCache(File file, File file1, FileNameGenerator filenamegenerator, long l, int i)
        throws IOException
    {
        bufferSize = 32768;
        compressFormat = DEFAULT_COMPRESS_FORMAT;
        compressQuality = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (filenamegenerator == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long l1 = l;
        if (l == 0L)
        {
            l1 = 0x7fffffffffffffffL;
        }
        int j = i;
        if (i == 0)
        {
            j = 0x7fffffff;
        }
        reserveCacheDir = file1;
        fileNameGenerator = filenamegenerator;
        initCache(file, file1, l1, j);
    }

    private String getKey(String s)
    {
        return fileNameGenerator.generate(s);
    }

    private void initCache(File file, File file1, long l, int i)
        throws IOException
    {
        cache = DiskLruCache.open(file, 1, 1, l, i);
_L1:
        return;
        file;
        L.e(file);
        if (file1 != null)
        {
            initCache(file1, null, l, i);
        }
        if (cache == null)
        {
            throw file;
        }
          goto _L1
    }

    public void clear()
    {
        try
        {
            cache.delete();
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
        }
        try
        {
            initCache(cache.getDirectory(), reserveCacheDir, cache.getMaxSize(), cache.getMaxFileCount());
            return;
        }
        catch (IOException ioexception1)
        {
            L.e(ioexception1);
        }
    }

    public void close()
    {
        try
        {
            cache.close();
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
        }
        cache = null;
    }

    public File get(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        File file;
        obj2 = null;
        file = null;
        obj1 = null;
        obj = null;
        s = cache.get(getKey(s));
        if (s != null) goto _L2; else goto _L1
_L1:
        obj = file;
_L6:
        obj1 = obj;
        if (s != null)
        {
            s.close();
            obj1 = obj;
        }
_L4:
        return ((File) (obj1));
_L2:
        obj = s;
        obj1 = s;
        file = s.getFile(0);
        obj = file;
        continue; /* Loop/switch isn't completed */
        s;
        obj1 = obj;
        L.e(s);
        obj1 = obj2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((DiskLruCache.Snapshot) (obj)).close();
        return null;
        s;
        if (obj1 != null)
        {
            ((DiskLruCache.Snapshot) (obj1)).close();
        }
        throw s;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public File getDirectory()
    {
        return cache.getDirectory();
    }

    public boolean remove(String s)
    {
        boolean flag;
        try
        {
            flag = cache.remove(getKey(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            L.e(s);
            return false;
        }
        return flag;
    }

    public boolean save(String s, Bitmap bitmap)
        throws IOException
    {
        DiskLruCache.Editor editor;
        editor = cache.edit(getKey(s));
        if (editor == null)
        {
            return false;
        }
        s = new BufferedOutputStream(editor.newOutputStream(0), bufferSize);
        boolean flag = bitmap.compress(compressFormat, compressQuality, s);
        IoUtils.closeSilently(s);
        if (flag)
        {
            editor.commit();
            return flag;
        } else
        {
            editor.abort();
            return flag;
        }
        bitmap;
        IoUtils.closeSilently(s);
        throw bitmap;
    }

    public boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener)
        throws IOException
    {
        BufferedOutputStream bufferedoutputstream;
        s = cache.edit(getKey(s));
        if (s == null)
        {
            return false;
        }
        bufferedoutputstream = new BufferedOutputStream(s.newOutputStream(0), bufferSize);
        boolean flag = IoUtils.copyStream(inputstream, bufferedoutputstream, copylistener, bufferSize);
        IoUtils.closeSilently(bufferedoutputstream);
        if (flag)
        {
            s.commit();
            return flag;
        } else
        {
            s.abort();
            return flag;
        }
        inputstream;
        IoUtils.closeSilently(bufferedoutputstream);
        if (false)
        {
            s.commit();
        } else
        {
            s.abort();
        }
        throw inputstream;
    }

    public void setBufferSize(int i)
    {
        bufferSize = i;
    }

    public void setCompressFormat(android.graphics.Bitmap.CompressFormat compressformat)
    {
        compressFormat = compressformat;
    }

    public void setCompressQuality(int i)
    {
        compressQuality = i;
    }

    static 
    {
        DEFAULT_COMPRESS_FORMAT = android.graphics.Bitmap.CompressFormat.PNG;
    }
}
