// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.internal.zzl;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzd

private static class zzle
    implements com.google.android.gms.maps.internal.zzd
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public zzd zzf(zzl zzl1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        if (zzl1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        zzl1 = zzl1.asBinder();
_L1:
        parcel.writeStrongBinder(zzl1);
        zzle.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzl1 = com.google.android.gms.dynamic.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return zzl1;
        zzl1 = null;
          goto _L1
        zzl1;
        parcel1.recycle();
        parcel.recycle();
        throw zzl1;
    }

    public zzd zzg(zzl zzl1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        if (zzl1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        zzl1 = zzl1.asBinder();
_L1:
        parcel.writeStrongBinder(zzl1);
        zzle.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        zzl1 = com.google.android.gms.dynamic.(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return zzl1;
        zzl1 = null;
          goto _L1
        zzl1;
        parcel1.recycle();
        parcel.recycle();
        throw zzl1;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
