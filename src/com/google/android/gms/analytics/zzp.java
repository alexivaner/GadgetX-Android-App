// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.util.Log;

// Referenced classes of package com.google.android.gms.analytics:
//            Logger

class zzp
    implements Logger
{

    private int zzBJ;

    zzp()
    {
        zzBJ = 2;
    }

    private String zzal(String s)
    {
        return (new StringBuilder()).append(Thread.currentThread().toString()).append(": ").append(s).toString();
    }

    public void error(Exception exception)
    {
        if (zzBJ <= 3)
        {
            Log.e("GAV4", null, exception);
        }
    }

    public void error(String s)
    {
        if (zzBJ <= 3)
        {
            Log.e("GAV4", zzal(s));
        }
    }

    public int getLogLevel()
    {
        return zzBJ;
    }

    public void info(String s)
    {
        if (zzBJ <= 1)
        {
            Log.i("GAV4", zzal(s));
        }
    }

    public void setLogLevel(int i)
    {
        zzBJ = i;
    }

    public void verbose(String s)
    {
        if (zzBJ <= 0)
        {
            Log.v("GAV4", zzal(s));
        }
    }

    public void warn(String s)
    {
        if (zzBJ <= 2)
        {
            Log.w("GAV4", zzal(s));
        }
    }
}
