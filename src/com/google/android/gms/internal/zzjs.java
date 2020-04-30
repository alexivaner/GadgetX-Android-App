// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzjt

public abstract class zzjs extends zzjt
{
    private class zza
        implements Runnable
    {

        final zzjs zzKd;

        public void run()
        {
            zzKd.zzKc = false;
            long l = SystemClock.elapsedRealtime();
            boolean flag = zzKd.zzo(l);
            zzKd.zzK(flag);
        }

        private zza()
        {
            zzKd = zzjs.this;
            super();
        }

    }


    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    protected final long zzKa;
    protected final Runnable zzKb = new zza();
    protected boolean zzKc;

    public zzjs(String s, String s1, String s2, long l)
    {
        super(s, s1, s2);
        zzKa = l;
        zzK(false);
    }

    protected final void zzK(boolean flag)
    {
label0:
        {
            if (zzKc != flag)
            {
                zzKc = flag;
                if (!flag)
                {
                    break label0;
                }
                mHandler.postDelayed(zzKb, zzKa);
            }
            return;
        }
        mHandler.removeCallbacks(zzKb);
    }

    public void zzhm()
    {
        zzK(false);
    }

    protected abstract boolean zzo(long l);
}
