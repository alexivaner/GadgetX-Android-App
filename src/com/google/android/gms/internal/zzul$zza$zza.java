// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzul, zzuk

private static class zzle
    implements zzul
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(zzuk zzuk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (zzuk1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzuk1 = zzuk1.asBinder();
_L1:
        parcel.writeStrongBinder(zzuk1);
        zzle.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzuk1 = null;
          goto _L1
        zzuk1;
        parcel1.recycle();
        parcel.recycle();
        throw zzuk1;
    }

    public void zza(zzuk zzuk1, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (zzuk1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        zzuk1 = zzuk1.asBinder();
_L1:
        parcel.writeStrongBinder(zzuk1);
        parcel.writeByteArray(abyte0);
        zzle.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzuk1 = null;
          goto _L1
        zzuk1;
        parcel1.recycle();
        parcel.recycle();
        throw zzuk1;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
