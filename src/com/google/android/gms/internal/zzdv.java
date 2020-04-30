// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzhx, zzax, zzdu, zzdw, 
//            zzba, zzdt

public final class zzdv extends zzds.zza
{

    private final MediationAdapter zzsR;

    public zzdv(MediationAdapter mediationadapter)
    {
        zzsR = mediationadapter;
    }

    private Bundle zza(String s, int i, String s1)
        throws RemoteException
    {
        Bundle bundle;
        zzhx.zzac((new StringBuilder()).append("Server parameters: ").append(s).toString());
        Iterator iterator;
        String s2;
        try
        {
            bundle = new Bundle();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not get Server Parameters Bundle.", s);
            throw new RemoteException();
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        s = new JSONObject(s);
        bundle = new Bundle();
        for (iterator = s.keys(); iterator.hasNext(); bundle.putString(s2, s.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        if (zzsR instanceof AdMobAdapter)
        {
            bundle.putString("adJson", s1);
            bundle.putInt("tagForChildDirectedTreatment", i);
        }
        return bundle;
    }

    public void destroy()
        throws RemoteException
    {
        try
        {
            zzsR.onDestroy();
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
        if (!(zzsR instanceof MediationBannerAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzsR.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzd zzd;
        try
        {
            zzd = zze.zzn(((MediationBannerAdapter)zzsR).getBannerView());
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
        try
        {
            zzsR.onPause();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not pause adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void resume()
        throws RemoteException
    {
        try
        {
            zzsR.onResume();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not resume adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void showInterstitial()
        throws RemoteException
    {
        if (!(zzsR instanceof MediationInterstitialAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzsR.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzhx.zzY("Showing interstitial from adapter.");
        try
        {
            ((MediationInterstitialAdapter)zzsR).showInterstitial();
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
        if (!(zzsR instanceof MediationInterstitialAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzsR.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzhx.zzY("Requesting interstitial ad from adapter.");
        MediationInterstitialAdapter mediationinterstitialadapter = (MediationInterstitialAdapter)zzsR;
        if (zzax1.zzoN == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(zzax1.zzoN);
_L5:
        zzdu zzdu1 = new zzdu(new Date(zzax1.zzoL), zzax1.zzoM, ((java.util.Set) (obj)), zzax1.zzoT, zzax1.zzoO, zzax1.zzoP);
        if (zzax1.zzoV == null) goto _L4; else goto _L3
_L3:
        obj = zzax1.zzoV.getBundle(mediationinterstitialadapter.getClass().getName());
_L6:
        mediationinterstitialadapter.requestInterstitialAd((Context)zze.zzf(zzd), new zzdw(zzdt), zza(s, zzax1.zzoP, s1), zzdu1, ((Bundle) (obj)));
        return;
_L2:
        obj = null;
          goto _L5
_L4:
        obj = null;
          goto _L6
        zzd;
        com.google.android.gms.internal.zzhx.zzd("Could not request interstitial ad from adapter.", zzd);
        throw new RemoteException();
          goto _L5
    }

    public void zza(zzd zzd, zzba zzba1, zzax zzax1, String s, zzdt zzdt)
        throws RemoteException
    {
        zza(zzd, zzba1, zzax1, s, null, zzdt);
    }

    public void zza(zzd zzd, zzba zzba1, zzax zzax1, String s, String s1, zzdt zzdt)
        throws RemoteException
    {
        Object obj1;
        obj1 = null;
        if (!(zzsR instanceof MediationBannerAdapter))
        {
            zzhx.zzac((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzsR.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzhx.zzY("Requesting banner ad from adapter.");
        Object obj;
        MediationBannerAdapter mediationbanneradapter;
        mediationbanneradapter = (MediationBannerAdapter)zzsR;
        if (zzax1.zzoN == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = new HashSet(zzax1.zzoN);
_L1:
        zzdu zzdu1 = new zzdu(new Date(zzax1.zzoL), zzax1.zzoM, ((java.util.Set) (obj)), zzax1.zzoT, zzax1.zzoO, zzax1.zzoP);
        obj = obj1;
        try
        {
            if (zzax1.zzoV != null)
            {
                obj = zzax1.zzoV.getBundle(mediationbanneradapter.getClass().getName());
            }
            mediationbanneradapter.requestBannerAd((Context)zze.zzf(zzd), new zzdw(zzdt), zza(s, zzax1.zzoP, s1), com.google.android.gms.ads.zza.zza(zzba1.width, zzba1.height, zzba1.zzpa), zzdu1, ((Bundle) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.internal.zzhx.zzd("Could not request banner ad from adapter.", zzd);
        }
        break MISSING_BLOCK_LABEL_221;
        obj = null;
          goto _L1
        throw new RemoteException();
    }
}
