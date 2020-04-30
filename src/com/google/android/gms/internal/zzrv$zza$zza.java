// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrv, zzsa, zzsc, zzse, 
//            zzsg

private static class zzle
    implements zzrv
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(zzsa zzsa1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (zzsa1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        zzsa1.writeToParcel(parcel, 0);
_L1:
        zzle.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        zzsa1;
        parcel.recycle();
        throw zzsa1;
    }

    public void zza(zzsc zzsc1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (zzsc1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        zzsc1.writeToParcel(parcel, 0);
_L1:
        zzle.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        zzsc1;
        parcel.recycle();
        throw zzsc1;
    }

    public void zza(zzse zzse1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (zzse1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        zzse1.writeToParcel(parcel, 0);
_L1:
        zzle.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        zzse1;
        parcel.recycle();
        throw zzse1;
    }

    public void zza(zzsg zzsg1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (zzsg1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        zzsg1.writeToParcel(parcel, 0);
_L1:
        zzle.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        zzsg1;
        parcel.recycle();
        throw zzsg1;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
