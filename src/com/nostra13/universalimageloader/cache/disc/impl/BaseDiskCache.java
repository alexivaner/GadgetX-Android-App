// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class BaseDiskCache
    implements DiskCache
{

    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final android.graphics.Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NULL = " argument must be not null";
    private static final String TEMP_IMAGE_POSTFIX = ".tmp";
    protected int bufferSize;
    protected final File cacheDir;
    protected android.graphics.Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    protected final File reserveCacheDir;

    public BaseDiskCache(File file)
    {
        this(file, null);
    }

    public BaseDiskCache(File file, File file1)
    {
        this(file, file1, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiskCache(File file, File file1, FileNameGenerator filenamegenerator)
    {
        bufferSize = 32768;
        compressFormat = DEFAULT_COMPRESS_FORMAT;
        compressQuality = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (filenamegenerator == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else
        {
            cacheDir = file;
            reserveCacheDir = file1;
            fileNameGenerator = filenamegenerator;
            return;
        }
    }

    public void clear()
    {
        File afile[] = cacheDir.listFiles();
        if (afile == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = afile.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        afile[i].delete();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void close()
    {
    }

    public File get(String s)
    {
        return getFile(s);
    }

    public File getDirectory()
    {
        return cacheDir;
    }

    protected File getFile(String s)
    {
        String s1;
label0:
        {
            s1 = fileNameGenerator.generate(s);
            File file = cacheDir;
            s = file;
            if (cacheDir.exists())
            {
                break label0;
            }
            s = file;
            if (cacheDir.mkdirs())
            {
                break label0;
            }
            s = file;
            if (reserveCacheDir == null)
            {
                break label0;
            }
            if (!reserveCacheDir.exists())
            {
                s = file;
                if (!reserveCacheDir.mkdirs())
                {
                    break label0;
                }
            }
            s = reserveCacheDir;
        }
        return new File(s, s1);
    }

    public boolean remove(String s)
    {
        return getFile(s).delete();
    }

    public boolean save(String s, Bitmap bitmap)
        throws IOException
    {
        File file;
        BufferedOutputStream bufferedoutputstream;
        s = getFile(s);
        file = new File((new StringBuilder(String.valueOf(s.getAbsolutePath()))).append(".tmp").toString());
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file), bufferSize);
        boolean flag = bitmap.compress(compressFormat, compressQuality, bufferedoutputstream);
        IoUtils.closeSilently(bufferedoutputstream);
        boolean flag1 = flag;
        if (flag)
        {
            flag1 = flag;
            if (!file.renameTo(s))
            {
                flag1 = false;
            }
        }
        if (!flag1)
        {
            file.delete();
        }
        bitmap.recycle();
        return flag1;
        bitmap;
        IoUtils.closeSilently(bufferedoutputstream);
        if (false)
        {
            if (file.renameTo(s));
        }
        if (true)
        {
            file.delete();
        }
        throw bitmap;
    }

    public boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener)
        throws IOException
    {
        File file;
        boolean flag;
        boolean flag1;
        s = getFile(s);
        file = new File((new StringBuilder(String.valueOf(s.getAbsolutePath()))).append(".tmp").toString());
        flag1 = false;
        flag = flag1;
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file), bufferSize);
        flag = IoUtils.copyStream(inputstream, bufferedoutputstream, copylistener, bufferSize);
        flag1 = flag;
        flag = flag1;
        IoUtils.closeSilently(bufferedoutputstream);
        flag = flag1;
        if (flag1)
        {
            flag = flag1;
            if (!file.renameTo(s))
            {
                flag = false;
            }
        }
        if (!flag)
        {
            file.delete();
        }
        return flag;
        inputstream;
        flag = flag1;
        IoUtils.closeSilently(bufferedoutputstream);
        flag = flag1;
        throw inputstream;
        inputstream;
        boolean flag2 = flag;
        if (flag)
        {
            flag2 = flag;
            if (!file.renameTo(s))
            {
                flag2 = false;
            }
        }
        if (!flag2)
        {
            file.delete();
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
