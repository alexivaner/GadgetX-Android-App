// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

// Referenced classes of package com.google.android.gms.internal:
//            zzfn, zzhx

public class zzfw
    implements InAppPurchase
{

    private final zzfn zzvi;

    public zzfw(zzfn zzfn1)
    {
        zzvi = zzfn1;
    }

    public String getProductId()
    {
        String s;
        try
        {
            s = zzvi.getProductId();
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward getProductId to InAppPurchase", remoteexception);
            return null;
        }
        return s;
    }

    public void recordPlayBillingResolution(int i)
    {
        try
        {
            zzvi.recordPlayBillingResolution(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", remoteexception);
        }
    }

    public void recordResolution(int i)
    {
        try
        {
            zzvi.recordResolution(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not forward recordResolution to InAppPurchase", remoteexception);
        }
    }
}
