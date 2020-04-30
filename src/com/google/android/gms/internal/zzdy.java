// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;

// Referenced classes of package com.google.android.gms.internal:
//            zzhx, zzbe, zzhw, zzdt, 
//            zzdz

public final class zzdy
    implements MediationBannerListener, MediationInterstitialListener
{

    private final zzdt zzsS;

    public zzdy(zzdt zzdt1)
    {
        zzsS = zzdt1;
    }

    static zzdt zza(zzdy zzdy1)
    {
        return zzdy1.zzsS;
    }

    public void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        zzhx.zzY("Adapter called onClick.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onClick must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdClicked();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdClicked.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdClicked();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzhx.zzd("Could not call onAdClicked.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onDismissScreen must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzhx.zzd("Could not call onAdClosed.", mediationbanneradapter);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onDismissScreen must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdClosed();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdClosed.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdClosed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzhx.zzd("Could not call onAdClosed.", mediationinterstitialadapter);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzhx.zzY((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error. ").append(errorcode).toString());
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable(errorcode) {

                final zzdy zzsV;
                final com.google.ads.AdRequest.ErrorCode zzsW;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdFailedToLoad(zzdz.zza(zzsW));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                zzsW = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdFailedToLoad(zzdz.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzhx.zzd("Could not call onAdFailedToLoad.", mediationbanneradapter);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter mediationinterstitialadapter, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        zzhx.zzY((new StringBuilder()).append("Adapter called onFailedToReceiveAd with error ").append(errorcode).append(".").toString());
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable(errorcode) {

                final zzdy zzsV;
                final com.google.ads.AdRequest.ErrorCode zzsW;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdFailedToLoad(zzdz.zza(zzsW));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdFailedToLoad.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                zzsW = errorcode;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdFailedToLoad(zzdz.zza(errorcode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzhx.zzd("Could not call onAdFailedToLoad.", mediationinterstitialadapter);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzhx.zzd("Could not call onAdLeftApplication.", mediationbanneradapter);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdLeftApplication();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdLeftApplication.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdLeftApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzhx.zzd("Could not call onAdLeftApplication.", mediationinterstitialadapter);
        }
    }

    public void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onPresentScreen must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzhx.zzd("Could not call onAdOpened.", mediationbanneradapter);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onPresentScreen must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdOpened();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdOpened.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdOpened();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzhx.zzd("Could not call onAdOpened.", mediationinterstitialadapter);
        }
    }

    public void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onReceivedAd must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationBannerAdapter mediationbanneradapter)
        {
            zzhx.zzd("Could not call onAdLoaded.", mediationbanneradapter);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter mediationinterstitialadapter)
    {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (!zzbe.zzbD().zzeC())
        {
            zzhx.zzac("onReceivedAd must be called on the main UI thread.");
            zzhw.zzzG.post(new Runnable() {

                final zzdy zzsV;

                public void run()
                {
                    try
                    {
                        zzdy.zza(zzsV).onAdLoaded();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        zzhx.zzd("Could not call onAdLoaded.", remoteexception);
                    }
                }

            
            {
                zzsV = zzdy.this;
                super();
            }
            });
            return;
        }
        try
        {
            zzsS.onAdLoaded();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediationInterstitialAdapter mediationinterstitialadapter)
        {
            zzhx.zzd("Could not call onAdLoaded.", mediationinterstitialadapter);
        }
    }
}
