// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.nostra13.universalimageloader.utils:
//            L

public final class StorageUtils
{

    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils()
    {
    }

    public static File getCacheDirectory(Context context)
    {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean flag)
    {
        Object obj1 = null;
        File file;
        Object obj;
        try
        {
            obj = Environment.getExternalStorageState();
        }
        catch (NullPointerException nullpointerexception)
        {
            obj = "";
        }
        catch (IncompatibleClassChangeError incompatibleclasschangeerror)
        {
            obj = "";
        }
        file = obj1;
        if (flag)
        {
            file = obj1;
            if ("mounted".equals(obj))
            {
                file = obj1;
                if (hasExternalStoragePermission(context))
                {
                    file = getExternalCacheDir(context);
                }
            }
        }
        obj = file;
        if (file == null)
        {
            obj = context.getCacheDir();
        }
        file = ((File) (obj));
        if (obj == null)
        {
            context = (new StringBuilder("/data/data/")).append(context.getPackageName()).append("/cache/").toString();
            L.w("Can't define system cache directory! '%s' will be used.", new Object[] {
                context
            });
            file = new File(context);
        }
        return file;
    }

    private static File getExternalCacheDir(Context context)
    {
        File file;
label0:
        {
            file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
            context = file;
            if (!file.exists())
            {
                if (file.mkdirs())
                {
                    break label0;
                }
                L.w("Unable to create external cache directory", new Object[0]);
                context = null;
            }
            return context;
        }
        try
        {
            (new File(file, ".nomedia")).createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            return file;
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context)
    {
        return getIndividualCacheDirectory(context, "uil-images");
    }

    public static File getIndividualCacheDirectory(Context context, String s)
    {
        File file = getCacheDirectory(context);
        s = new File(file, s);
        context = s;
        if (!s.exists())
        {
            context = s;
            if (!s.mkdir())
            {
                context = file;
            }
        }
        return context;
    }

    public static File getOwnCacheDirectory(Context context, String s)
    {
label0:
        {
            Object obj = null;
            File file = obj;
            if ("mounted".equals(Environment.getExternalStorageState()))
            {
                file = obj;
                if (hasExternalStoragePermission(context))
                {
                    file = new File(Environment.getExternalStorageDirectory(), s);
                }
            }
            if (file != null)
            {
                s = file;
                if (file.exists())
                {
                    break label0;
                }
                s = file;
                if (file.mkdirs())
                {
                    break label0;
                }
            }
            s = context.getCacheDir();
        }
        return s;
    }

    public static File getOwnCacheDirectory(Context context, String s, boolean flag)
    {
label0:
        {
            Object obj = null;
            File file = obj;
            if (flag)
            {
                file = obj;
                if ("mounted".equals(Environment.getExternalStorageState()))
                {
                    file = obj;
                    if (hasExternalStoragePermission(context))
                    {
                        file = new File(Environment.getExternalStorageDirectory(), s);
                    }
                }
            }
            if (file != null)
            {
                s = file;
                if (file.exists())
                {
                    break label0;
                }
                s = file;
                if (file.mkdirs())
                {
                    break label0;
                }
            }
            s = context.getCacheDir();
        }
        return s;
    }

    private static boolean hasExternalStoragePermission(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
