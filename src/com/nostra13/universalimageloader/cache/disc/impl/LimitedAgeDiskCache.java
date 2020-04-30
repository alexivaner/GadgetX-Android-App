// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl:
//            BaseDiskCache

public class LimitedAgeDiskCache extends BaseDiskCache
{

    private final Map loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiskCache(File file, long l)
    {
        this(file, null, DefaultConfigurationFactory.createFileNameGenerator(), l);
    }

    public LimitedAgeDiskCache(File file, File file1, long l)
    {
        this(file, file1, DefaultConfigurationFactory.createFileNameGenerator(), l);
    }

    public LimitedAgeDiskCache(File file, File file1, FileNameGenerator filenamegenerator, long l)
    {
        super(file, file1, filenamegenerator);
        loadingDates = Collections.synchronizedMap(new HashMap());
        maxFileAge = 1000L * l;
    }

    private void rememberUsage(String s)
    {
        s = getFile(s);
        long l = System.currentTimeMillis();
        s.setLastModified(l);
        loadingDates.put(s, Long.valueOf(l));
    }

    public void clear()
    {
        super.clear();
        loadingDates.clear();
    }

    public File get(String s)
    {
        File file = super.get(s);
        if (file != null && file.exists())
        {
            s = (Long)loadingDates.get(file);
            boolean flag;
            if (s == null)
            {
                flag = false;
                s = Long.valueOf(file.lastModified());
            } else
            {
                flag = true;
            }
            if (System.currentTimeMillis() - s.longValue() > maxFileAge)
            {
                file.delete();
                loadingDates.remove(file);
            } else
            if (!flag)
            {
                loadingDates.put(file, s);
                return file;
            }
        }
        return file;
    }

    public boolean remove(String s)
    {
        loadingDates.remove(getFile(s));
        return super.remove(s);
    }

    public boolean save(String s, Bitmap bitmap)
        throws IOException
    {
        boolean flag = super.save(s, bitmap);
        rememberUsage(s);
        return flag;
    }

    public boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener)
        throws IOException
    {
        boolean flag = super.save(s, inputstream, copylistener);
        rememberUsage(s);
        return flag;
    }
}
