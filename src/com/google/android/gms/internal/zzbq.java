// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

// Referenced classes of package com.google.android.gms.internal:
//            zzaz, zzdq, zzbe, zzba, 
//            zzaw, zzav, zzbi, zzau, 
//            zzbc, zzft, zzfx, zzck, 
//            zzhx, zzbo, zzat

public class zzbq
{

    private final Context mContext;
    private zzat zzoJ;
    private AdListener zzoK;
    private final zzdq zzpD;
    private final zzaz zzpE;
    private zzbi zzpG;
    private String zzpH;
    private InAppPurchaseListener zzpJ;
    private PlayStorePurchaseListener zzpK;
    private OnCustomRenderedAdLoadedListener zzpL;
    private PublisherInterstitialAd zzpM;
    private AppEventListener zzpd;
    private String zzpf;

    public zzbq(Context context)
    {
        this(context, zzaz.zzbA(), null);
    }

    public zzbq(Context context, PublisherInterstitialAd publisherinterstitialad)
    {
        this(context, zzaz.zzbA(), publisherinterstitialad);
    }

    public zzbq(Context context, zzaz zzaz1, PublisherInterstitialAd publisherinterstitialad)
    {
        zzpD = new zzdq();
        mContext = context;
        zzpE = zzaz1;
        zzpM = publisherinterstitialad;
    }

    private void zzy(String s)
        throws RemoteException
    {
        if (zzpf == null)
        {
            zzz(s);
        }
        zzpG = zzbe.zzbE().zza(mContext, new zzba(), zzpf, zzpD);
        if (zzoK != null)
        {
            zzpG.zza(new zzav(zzoK));
        }
        if (zzoJ != null)
        {
            zzpG.zza(new zzau(zzoJ));
        }
        if (zzpd != null)
        {
            zzpG.zza(new zzbc(zzpd));
        }
        if (zzpJ != null)
        {
            zzpG.zza(new zzft(zzpJ));
        }
        if (zzpK != null)
        {
            zzpG.zza(new zzfx(zzpK), zzpH);
        }
        if (zzpL != null)
        {
            zzpG.zza(new zzck(zzpL));
        }
    }

    private void zzz(String s)
    {
        if (zzpG == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("The ad unit ID must be set on InterstitialAd before ").append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public AdListener getAdListener()
    {
        return zzoK;
    }

    public String getAdUnitId()
    {
        return zzpf;
    }

    public AppEventListener getAppEventListener()
    {
        return zzpd;
    }

    public InAppPurchaseListener getInAppPurchaseListener()
    {
        return zzpJ;
    }

    public String getMediationAdapterClassName()
    {
        String s;
        if (zzpG == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        s = zzpG.getMediationAdapterClassName();
        return s;
        RemoteException remoteexception;
        remoteexception;
        zzhx.zzd("Failed to get the mediation adapter class name.", remoteexception);
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
    {
        return zzpL;
    }

    public boolean isLoaded()
    {
        if (zzpG == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zzpG.isReady();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Failed to check if ad is ready.", remoteexception);
            return false;
        }
        return flag;
    }

    public void setAdListener(AdListener adlistener)
    {
        zzoK = adlistener;
        if (zzpG == null) goto _L2; else goto _L1
_L1:
        zzbi zzbi1 = zzpG;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new zzav(adlistener);
_L3:
        zzbi1.zza(adlistener);
_L2:
        return;
        adlistener = null;
          goto _L3
        adlistener;
        zzhx.zzd("Failed to set the AdListener.", adlistener);
        return;
    }

    public void setAdUnitId(String s)
    {
        if (zzpf != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            zzpf = s;
            return;
        }
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        zzpd = appeventlistener;
        if (zzpG == null) goto _L2; else goto _L1
_L1:
        zzbi zzbi1 = zzpG;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        appeventlistener = new zzbc(appeventlistener);
_L3:
        zzbi1.zza(appeventlistener);
_L2:
        return;
        appeventlistener = null;
          goto _L3
        appeventlistener;
        zzhx.zzd("Failed to set the AppEventListener.", appeventlistener);
        return;
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inapppurchaselistener)
    {
        if (zzpK != null)
        {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        zzpJ = inapppurchaselistener;
        if (zzpG == null) goto _L2; else goto _L1
_L1:
        zzbi zzbi1 = zzpG;
        if (inapppurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        inapppurchaselistener = new zzft(inapppurchaselistener);
_L3:
        zzbi1.zza(inapppurchaselistener);
_L2:
        return;
        inapppurchaselistener = null;
          goto _L3
        inapppurchaselistener;
        zzhx.zzd("Failed to set the InAppPurchaseListener.", inapppurchaselistener);
        return;
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener oncustomrenderedadloadedlistener)
    {
        zzpL = oncustomrenderedadloadedlistener;
        if (zzpG == null) goto _L2; else goto _L1
_L1:
        zzbi zzbi1 = zzpG;
        if (oncustomrenderedadloadedlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        oncustomrenderedadloadedlistener = new zzck(oncustomrenderedadloadedlistener);
_L3:
        zzbi1.zza(oncustomrenderedadloadedlistener);
_L2:
        return;
        oncustomrenderedadloadedlistener = null;
          goto _L3
        oncustomrenderedadloadedlistener;
        zzhx.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", oncustomrenderedadloadedlistener);
        return;
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        if (zzpJ != null)
        {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        zzpK = playstorepurchaselistener;
        zzpH = s;
        if (zzpG == null) goto _L2; else goto _L1
_L1:
        zzbi zzbi1 = zzpG;
        if (playstorepurchaselistener == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        playstorepurchaselistener = new zzfx(playstorepurchaselistener);
_L3:
        zzbi1.zza(playstorepurchaselistener, s);
_L2:
        return;
        playstorepurchaselistener = null;
          goto _L3
        playstorepurchaselistener;
        zzhx.zzd("Failed to set the play store purchase parameter.", playstorepurchaselistener);
        return;
    }

    public void show()
    {
        try
        {
            zzz("show");
            zzpG.showInterstitial();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Failed to show interstitial.", remoteexception);
        }
    }

    public void zza(zzat zzat)
    {
        zzoJ = zzat;
        if (zzpG == null) goto _L2; else goto _L1
_L1:
        zzbi zzbi1 = zzpG;
        if (zzat == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        zzat = new zzau(zzat);
_L3:
        zzbi1.zza(zzat);
_L2:
        return;
        zzat = null;
          goto _L3
        zzat;
        zzhx.zzd("Failed to set the AdClickListener.", zzat);
        return;
    }

    public void zza(zzbo zzbo1)
    {
        try
        {
            if (zzpG == null)
            {
                zzy("loadAd");
            }
            if (zzpG.zza(zzpE.zza(mContext, zzbo1)))
            {
                zzpD.zze(zzbo1.zzbJ());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzbo zzbo1)
        {
            zzhx.zzd("Failed to load ad.", zzbo1);
        }
    }
}
