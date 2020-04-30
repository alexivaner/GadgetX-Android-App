// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzqf
{
    private class zza
        implements Runnable
    {

        final zzqf zzaoZ;

        public void run()
        {
            synchronized (zzqf.zzb(zzaoZ))
            {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", zzqf.zzc(zzaoZ));
                intent.putStringArrayListExtra("METHOD_NAMES", zzqf.zzd(zzaoZ));
                zzqf.zze(zzaoZ).sendBroadcast(intent);
                zzqf.zza(zzaoZ, null);
                zzqf.zzb(zzaoZ, null);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private zza()
        {
            zzaoZ = zzqf.this;
            super();
        }

    }


    private static final String TAG = com/google/android/gms/internal/zzqf.getSimpleName();
    private static final long zzaoU;
    private static zzqf zzaoV;
    private final Context mContext;
    private final Handler mHandler;
    private final Runnable zzaoW;
    private ArrayList zzaoX;
    private ArrayList zzaoY;
    private final Object zznh;

    private zzqf(Context context)
    {
        this((Context)zzx.zzl(context), new Handler(Looper.getMainLooper()));
    }

    zzqf(Context context, Handler handler)
    {
        zzaoW = new zza();
        zznh = new Object();
        zzaoX = null;
        zzaoY = null;
        mContext = context;
        mHandler = handler;
    }

    static ArrayList zza(zzqf zzqf1, ArrayList arraylist)
    {
        zzqf1.zzaoX = arraylist;
        return arraylist;
    }

    public static zzqf zzab(Context context)
    {
        com/google/android/gms/internal/zzqf;
        JVM INSTR monitorenter ;
        int i;
        zzx.zzl(context);
        i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/google/android/gms/internal/zzqf;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (zzaoV == null)
        {
            zzaoV = new zzqf(context.getApplicationContext());
        }
        context = zzaoV;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    static Object zzb(zzqf zzqf1)
    {
        return zzqf1.zznh;
    }

    static ArrayList zzb(zzqf zzqf1, ArrayList arraylist)
    {
        zzqf1.zzaoY = arraylist;
        return arraylist;
    }

    static ArrayList zzc(zzqf zzqf1)
    {
        return zzqf1.zzaoX;
    }

    static ArrayList zzd(zzqf zzqf1)
    {
        return zzqf1.zzaoY;
    }

    static Context zze(zzqf zzqf1)
    {
        return zzqf1.mContext;
    }

    public void zzy(String s, String s1)
    {
        Object obj = zznh;
        obj;
        JVM INSTR monitorenter ;
        if (zzaoX == null)
        {
            zzaoX = new ArrayList();
            zzaoY = new ArrayList();
            mHandler.postDelayed(zzaoW, zzaoU);
        }
        zzaoX.add(s);
        zzaoY.add(s1);
        if (zzaoX.size() >= 10000)
        {
            if (Log.isLoggable(TAG, 5))
            {
                Log.w(TAG, "Event buffer full, flushing");
            }
            zzaoW.run();
            mHandler.removeCallbacks(zzaoW);
            return;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static 
    {
        zzaoU = TimeUnit.SECONDS.toMillis(1L);
    }
}
