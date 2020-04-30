// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.zzd;

// Referenced classes of package com.google.android.gms.internal:
//            zzwd, zzwg, zzvx, zzwf

private static class zzle
    implements zzwd
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        bundle = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        bundle = zzwg1.asBinder();
        parcel.writeStrongBinder(bundle);
        zzle.transact(5, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        bundle;
        parcel.recycle();
        throw bundle;
    }

    public void zza(zzvx zzvx1, Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (zzvx1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzvx1.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        zzvx1 = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        zzvx1 = zzwg1.asBinder();
        parcel.writeStrongBinder(zzvx1);
        zzle.transact(8, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        zzvx1;
        parcel.recycle();
        throw zzvx1;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(FullWalletRequest fullwalletrequest, Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (fullwalletrequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        fullwalletrequest.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        fullwalletrequest = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        fullwalletrequest = zzwg1.asBinder();
        parcel.writeStrongBinder(fullwalletrequest);
        zzle.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        fullwalletrequest;
        parcel.recycle();
        throw fullwalletrequest;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(MaskedWalletRequest maskedwalletrequest, Bundle bundle, zzwf zzwf1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (maskedwalletrequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        maskedwalletrequest.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        maskedwalletrequest = obj;
        if (zzwf1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        maskedwalletrequest = zzwf1.asBinder();
        parcel.writeStrongBinder(maskedwalletrequest);
        zzle.transact(7, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        maskedwalletrequest;
        parcel.recycle();
        throw maskedwalletrequest;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(MaskedWalletRequest maskedwalletrequest, Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (maskedwalletrequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        maskedwalletrequest.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        maskedwalletrequest = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        maskedwalletrequest = zzwg1.asBinder();
        parcel.writeStrongBinder(maskedwalletrequest);
        zzle.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        maskedwalletrequest;
        parcel.recycle();
        throw maskedwalletrequest;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(NotifyTransactionStatusRequest notifytransactionstatusrequest, Bundle bundle)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (notifytransactionstatusrequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        notifytransactionstatusrequest.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        zzle.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        notifytransactionstatusrequest;
        parcel.recycle();
        throw notifytransactionstatusrequest;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(zzd zzd1, Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (zzd1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzd1.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        zzd1 = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        zzd1 = zzwg1.asBinder();
        parcel.writeStrongBinder(zzd1);
        zzle.transact(6, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        zzd1;
        parcel.recycle();
        throw zzd1;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(String s, String s1, Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        parcel.writeString(s);
        parcel.writeString(s1);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        s = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        s = zzwg1.asBinder();
        parcel.writeStrongBinder(s);
        zzle.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        parcel.recycle();
        throw s;
    }

    public void zzb(Bundle bundle, zzwg zzwg1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        bundle = obj;
        if (zzwg1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        bundle = zzwg1.asBinder();
        parcel.writeStrongBinder(bundle);
        zzle.transact(11, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        bundle;
        parcel.recycle();
        throw bundle;
    }

    public void zzv(Bundle bundle)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        zzle.transact(9, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel.recycle();
        throw bundle;
    }

    public void zzw(Bundle bundle)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L1:
        zzle.transact(10, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bundle;
        parcel.recycle();
        throw bundle;
    }

    onStatusRequest(IBinder ibinder)
    {
        zzle = ibinder;
    }
}
