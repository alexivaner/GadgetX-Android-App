// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// Referenced classes of package com.google.android.gms.internal:
//            zzwe, zzwc, zzwb

public class zzwj extends zzg
{

    private static zzwj zzaFa;

    protected zzwj()
    {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static zzwb zza(Activity activity, zzc zzc, WalletFragmentOptions walletfragmentoptions, zzwc zzwc)
        throws GooglePlayServicesNotAvailableException
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (i != 0)
        {
            throw new GooglePlayServicesNotAvailableException(i);
        }
        try
        {
            activity = ((zzwe)zzuU().zzS(activity)).zza(zze.zzn(activity), zzc, walletfragmentoptions, zzwc);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        return activity;
    }

    private static zzwj zzuU()
    {
        if (zzaFa == null)
        {
            zzaFa = new zzwj();
        }
        return zzaFa;
    }

    protected zzwe zzcO(IBinder ibinder)
    {
        return zzwe.zza.zzcK(ibinder);
    }

    protected Object zzd(IBinder ibinder)
    {
        return zzcO(ibinder);
    }
}
