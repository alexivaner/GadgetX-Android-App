// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzj;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzg

private static class zzle
    implements zzg
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void onIndoorBuildingFocused()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        zzle.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zza(zzj zzj1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        if (zzj1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzj1 = zzj1.asBinder();
_L1:
        parcel.writeStrongBinder(zzj1);
        zzle.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzj1 = null;
          goto _L1
        zzj1;
        parcel1.recycle();
        parcel.recycle();
        throw zzj1;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
