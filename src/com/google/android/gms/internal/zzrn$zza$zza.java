// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.connection.AppMetadata;

// Referenced classes of package com.google.android.gms.internal:
//            zzrn, zzrm

private static class zzle
    implements zzrn
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zzB(long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeLong(l);
        zzle.transact(1002, parcel, parcel1, 0);
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

    public void zzC(long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeLong(l);
        zzle.transact(1006, parcel, parcel1, 0);
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

    public void zzD(long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeLong(l);
        zzle.transact(1013, parcel, parcel1, 0);
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

    public String zzE(long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeLong(l);
        zzle.transact(1015, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zza(zzrm zzrm1, int i, long l, long l1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (zzrm1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        zzrm1 = zzrm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzrm1);
        parcel.writeInt(i);
        parcel.writeLong(l);
        parcel.writeLong(l1);
        zzle.transact(1005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzrm1 = null;
          goto _L1
        zzrm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzrm1;
    }

    public void zza(zzrm zzrm1, String s, long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (zzrm1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        zzrm1 = zzrm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzrm1);
        parcel.writeString(s);
        parcel.writeLong(l);
        zzle.transact(1009, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzrm1 = null;
          goto _L1
        zzrm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzrm1;
    }

    public void zza(zzrm zzrm1, String s, long l, long l1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (zzrm1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        zzrm1 = zzrm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzrm1);
        parcel.writeString(s);
        parcel.writeLong(l);
        parcel.writeLong(l1);
        zzle.transact(1003, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzrm1 = null;
          goto _L1
        zzrm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzrm1;
    }

    public void zza(zzrm zzrm1, String s, AppMetadata appmetadata, long l, long l1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (zzrm1 == null) goto _L2; else goto _L1
_L1:
        zzrm1 = zzrm1.asBinder();
_L5:
        parcel.writeStrongBinder(zzrm1);
        parcel.writeString(s);
        if (appmetadata == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        appmetadata.writeToParcel(parcel, 0);
_L6:
        parcel.writeLong(l);
        parcel.writeLong(l1);
        zzle.transact(1001, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        zzrm1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        zzrm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzrm1;
          goto _L5
    }

    public void zza(zzrm zzrm1, String s, String s1, byte abyte0[], long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (zzrm1 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        zzrm1 = zzrm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzrm1);
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeByteArray(abyte0);
        parcel.writeLong(l);
        zzle.transact(1007, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzrm1 = null;
          goto _L1
        zzrm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzrm1;
    }

    public void zza(zzrm zzrm1, String s, byte abyte0[], long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        if (zzrm1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        zzrm1 = zzrm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzrm1);
        parcel.writeString(s);
        parcel.writeByteArray(abyte0);
        parcel.writeLong(l);
        zzle.transact(1008, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzrm1 = null;
          goto _L1
        zzrm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzrm1;
    }

    public void zza(String as[], byte abyte0[], long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeStringArray(as);
        parcel.writeByteArray(abyte0);
        parcel.writeLong(l);
        zzle.transact(1010, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        as;
        parcel1.recycle();
        parcel.recycle();
        throw as;
    }

    public void zzb(String s, long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeString(s);
        parcel.writeLong(l);
        zzle.transact(1004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void zzb(String as[], byte abyte0[], long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeStringArray(as);
        parcel.writeByteArray(abyte0);
        parcel.writeLong(l);
        zzle.transact(1011, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        as;
        parcel1.recycle();
        parcel.recycle();
        throw as;
    }

    public void zzc(String s, long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeString(s);
        parcel.writeLong(l);
        zzle.transact(1012, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public String zzrl()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        zzle.transact(1016, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zzu(long l)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        parcel.writeLong(l);
        zzle.transact(1014, parcel, parcel1, 0);
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

    etadata(IBinder ibinder)
    {
        zzle = ibinder;
    }
}
