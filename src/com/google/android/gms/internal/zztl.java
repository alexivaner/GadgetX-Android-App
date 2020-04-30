// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            zzti, zztg, zzte, zzwy, 
//            zztj, zztf

public class zztl extends zzk
{

    private final String zzFO;
    private final zzti zzauc;
    private final zztg zzaud = new zztg();
    private boolean zzaue;
    private final Object zznh = new Object();

    public zztl(Context context, Looper looper, zzti zzti1, zzf zzf)
    {
        super(context, looper, 24, zzti1, zzti1, zzf);
        zzFO = context.getPackageName();
        zzauc = (zzti)zzx.zzl(zzti1);
        zzauc.zza(this);
        zzaue = true;
    }

    private void zzc(zztj zztj1, zztf zztf)
    {
        zzaud.zza(zztj1, zztf);
    }

    private void zzd(zztj zztj1, zztf zztf)
    {
        try
        {
            zzrI();
            ((zzte)zzjb()).zza(zzFO, zztj1, zztf);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(zztj1, zztf);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
        }
        zzc(zztj1, zztf);
    }

    private void zzrI()
    {
        Object obj;
        ArrayList arraylist;
        zztg.zza zza;
        Iterator iterator;
        boolean flag;
        if (!zzaue)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzN(flag);
        if (zzaud.isEmpty()) goto _L2; else goto _L1
_L1:
        obj = null;
        arraylist = new ArrayList();
        iterator = zzaud.zzrG().iterator();
_L5:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        zza = (zztg.zza)iterator.next();
        if (zza.zzatT == null) goto _L4; else goto _L3
_L3:
        ((zzte)zzjb()).zza(zzFO, zza.zzatR, com.google.android.gms.internal.zzwy.zzf(zza.zzatT));
          goto _L5
_L2:
        return;
_L4:
label0:
        {
            if (!zza.zzatR.equals(obj))
            {
                break label0;
            }
            arraylist.add(zza.zzatS);
        }
          goto _L5
        if (!arraylist.isEmpty())
        {
            ((zzte)zzjb()).zza(zzFO, ((zztj) (obj)), arraylist);
            arraylist.clear();
        }
        obj = zza.zzatR;
        arraylist.add(zza.zzatS);
          goto _L5
        try
        {
            if (!arraylist.isEmpty())
            {
                ((zzte)zzjb()).zza(zzFO, ((zztj) (obj)), arraylist);
            }
            zzaud.clear();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
        }
          goto _L2
    }

    public void start()
    {
label0:
        {
            synchronized (zznh)
            {
                if (!isConnecting() && !isConnected())
                {
                    break label0;
                }
            }
            return;
        }
        zzauc.zzad(true);
        connect();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void stop()
    {
        synchronized (zznh)
        {
            zzauc.zzad(false);
            disconnect();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void zzae(boolean flag)
    {
        Object obj = zznh;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1;
        flag1 = zzaue;
        zzaue = flag;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        if (!zzaue)
        {
            zzrI();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(zztj zztj1, zztf zztf)
    {
        Object obj = zznh;
        obj;
        JVM INSTR monitorenter ;
        if (!zzaue)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        zzc(zztj1, zztf);
_L2:
        return;
        zzd(zztj1, zztf);
        if (true) goto _L2; else goto _L1
_L1:
        zztj1;
        obj;
        JVM INSTR monitorexit ;
        throw zztj1;
    }

    protected String zzcF()
    {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    protected zzte zzcv(IBinder ibinder)
    {
        return zzte.zza.zzcu(ibinder);
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzcv(ibinder);
    }
}
