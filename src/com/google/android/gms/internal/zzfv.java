// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzfr, zzhx

public class zzfv
    implements InAppPurchaseResult
{

    private final zzfr zzvx;

    public zzfv(zzfr zzfr1)
    {
        zzvx = zzfr1;
    }

    public void finishPurchase()
    {
        try
        {
            zzvx.finishPurchase();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward finishPurchase to InAppPurchaseResult", remoteexception);
        }
    }

    public String getProductId()
    {
        String s;
        try
        {
            s = zzvx.getProductId();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward getProductId to InAppPurchaseResult", remoteexception);
            return null;
        }
        return s;
    }

    public Intent getPurchaseData()
    {
        Intent intent;
        try
        {
            intent = zzvx.getPurchaseData();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward getPurchaseData to InAppPurchaseResult", remoteexception);
            return null;
        }
        return intent;
    }

    public int getResultCode()
    {
        int i;
        try
        {
            i = zzvx.getResultCode();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward getPurchaseData to InAppPurchaseResult", remoteexception);
            return 0;
        }
        return i;
    }

    public boolean isVerified()
    {
        boolean flag;
        try
        {
            flag = zzvx.isVerified();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward isVerified to InAppPurchaseResult", remoteexception);
            return false;
        }
        return flag;
    }
}
