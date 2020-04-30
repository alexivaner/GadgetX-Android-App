// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzhx, zzdy, zzax, zzdz, 
//            zzdt, zzba

public final class zzdx extends zzds.zza
{

    private final MediationAdapter zzsT;
    private final NetworkExtras zzsU;

    public zzdx(MediationAdapter mediationadapter, NetworkExtras networkextras)
    {
        zzsT = mediationadapter;
        zzsU = networkextras;
    }

    private MediationServerParameters zzb(String s, int i, String s1)
        throws RemoteException
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        try
        {
            obj = new JSONObject(s);
            s1 = new HashMap(((JSONObject) (obj)).length());
            iterator = ((JSONObject) (obj)).keys();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not get MediationServerParameters.", s);
            throw new RemoteException();
        }
        s = s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        s1.put(s, ((JSONObject) (obj)).getString(s));
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_34;
_L2:
        s = new HashMap(0);
_L3:
        obj = zzsT.getServerParametersType();
        s1 = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s1 = (MediationServerParameters)((Class) (obj)).newInstance();
        s1.load(s);
        return s1;
    }

    public void destroy()
        throws RemoteException
    {
        try
        {
            zzsT.destroy();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public zzd getView()
        throws RemoteException
    {
        if (!(zzsT instanceof MediationBannerAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzsT.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzd zzd;
        try
        {
            zzd = zze.zzn(((MediationBannerAdapter)zzsT).getBannerView());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return zzd;
    }

    public void pause()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void resume()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void showInterstitial()
        throws RemoteException
    {
        if (!(zzsT instanceof MediationInterstitialAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzsT.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzhx.zzY("Showing interstitial from adapter.");
        try
        {
            ((MediationInterstitialAdapter)zzsT).showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void zza(zzd zzd, zzax zzax1, String s, zzdt zzdt)
        throws RemoteException
    {
        zza(zzd, zzax1, s, null, zzdt);
    }

    public void zza(zzd zzd, zzax zzax1, String s, String s1, zzdt zzdt)
        throws RemoteException
    {
        if (!(zzsT instanceof MediationInterstitialAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzsT.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzhx.zzY("Requesting interstitial ad from adapter.");
        try
        {
            ((MediationInterstitialAdapter)zzsT).requestInterstitialAd(new zzdy(zzdt), (Activity)zze.zzf(zzd), zzb(s, zzax1.zzoP, s1), com.google.android.gms.internal.zzdz.zzd(zzax1), zzsU);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not request interstitial ad from adapter.", zzd);
        }
        throw new RemoteException();
    }

    public void zza(zzd zzd, zzba zzba, zzax zzax1, String s, zzdt zzdt)
        throws RemoteException
    {
        zza(zzd, zzba, zzax1, s, null, zzdt);
    }

    public void zza(zzd zzd, zzba zzba, zzax zzax1, String s, String s1, zzdt zzdt)
        throws RemoteException
    {
        if (!(zzsT instanceof MediationBannerAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzsT.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzhx.zzY("Requesting banner ad from adapter.");
        try
        {
            ((MediationBannerAdapter)zzsT).requestBannerAd(new zzdy(zzdt), (Activity)zze.zzf(zzd), zzb(s, zzax1.zzoP, s1), zzdz.zzb(zzba), com.google.android.gms.internal.zzdz.zzd(zzax1), zzsU);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not request banner ad from adapter.", zzd);
        }
        throw new RemoteException();
    }
}
