// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.Log;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbg

public class zzx
    implements zzbg
{

    private int zzBJ;

    public zzx()
    {
        zzBJ = 5;
    }

    public void setLogLevel(int i)
    {
        zzBJ = i;
    }

    public void zzY(String s)
    {
        if (zzBJ <= 3)
        {
            Log.d("GoogleTagManager", s);
        }
    }

    public void zzZ(String s)
    {
        if (zzBJ <= 6)
        {
            Log.e("GoogleTagManager", s);
        }
    }

    public void zzaa(String s)
    {
        if (zzBJ <= 4)
        {
            Log.i("GoogleTagManager", s);
        }
    }

    public void zzab(String s)
    {
        if (zzBJ <= 2)
        {
            Log.v("GoogleTagManager", s);
        }
    }

    public void zzac(String s)
    {
        if (zzBJ <= 5)
        {
            Log.w("GoogleTagManager", s);
        }
    }

    public void zzb(String s, Throwable throwable)
    {
        if (zzBJ <= 6)
        {
            Log.e("GoogleTagManager", s, throwable);
        }
    }

    public void zzd(String s, Throwable throwable)
    {
        if (zzBJ <= 5)
        {
            Log.w("GoogleTagManager", s, throwable);
        }
    }
}
