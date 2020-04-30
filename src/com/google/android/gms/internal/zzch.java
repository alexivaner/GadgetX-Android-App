// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzci, zzhx

public class zzch
    implements CustomRenderedAd
{

    private final zzci zzrj;

    public zzch(zzci zzci1)
    {
        zzrj = zzci1;
    }

    public String getBaseUrl()
    {
        String s;
        try
        {
            s = zzrj.zzcv();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not delegate getBaseURL to CustomRenderedAd", remoteexception);
            return null;
        }
        return s;
    }

    public String getContent()
    {
        String s;
        try
        {
            s = zzrj.getContent();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not delegate getContent to CustomRenderedAd", remoteexception);
            return null;
        }
        return s;
    }

    public void onAdRendered(View view)
    {
        zzci zzci1;
        try
        {
            zzci1 = zzrj;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            zzhx.zzd("Could not delegate onAdRendered to CustomRenderedAd", view);
            return;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        view = zze.zzn(view);
_L1:
        zzci1.zza(view);
        return;
        view = null;
          goto _L1
    }

    public void recordClick()
    {
        try
        {
            zzrj.recordClick();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not delegate recordClick to CustomRenderedAd", remoteexception);
        }
    }

    public void recordImpression()
    {
        try
        {
            zzrj.recordImpression();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not delegate recordImpression to CustomRenderedAd", remoteexception);
        }
    }
}
