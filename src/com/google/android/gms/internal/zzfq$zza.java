// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.internal:
//            zzfq

public static abstract class zza.zzle extends Binder
    implements zzfq
{
    private static class zza
        implements zzfq
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public IBinder zzc(zzd zzd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            zzd1 = zzd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzd1);
            zzle.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            zzd1 = parcel1.readStrongBinder();
            parcel1.recycle();
            parcel.recycle();
            return zzd1;
            zzd1 = null;
              goto _L1
            zzd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzd1;
        }

        zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public static zzfq zzB(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        if (iinterface != null && (iinterface instanceof zzfq))
        {
            return (zzfq)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            parcel = zzc(com.google.android.gms.dynamic.zau(parcel.readStrongBinder()));
            parcel1.writeNoException();
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }
}
