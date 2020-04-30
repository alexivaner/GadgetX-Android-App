// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzjn, zzjm

private static class zzle
    implements zzjn
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(zzjm zzjm1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        zzle.transact(5005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public void zza(zzjm zzjm1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        parcel.writeInt(i);
        zzle.transact(5004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public void zza(zzjm zzjm1, int i, String s, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeByteArray(abyte0);
        zzle.transact(5006, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public void zza(zzjm zzjm1, int i, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        parcel.writeInt(i);
        parcel.writeByteArray(abyte0);
        zzle.transact(5003, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public void zzb(zzjm zzjm1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        zzle.transact(5008, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public void zzb(zzjm zzjm1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        parcel.writeInt(i);
        zzle.transact(5007, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public void zzc(zzjm zzjm1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (zzjm1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        zzjm1 = zzjm1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjm1);
        zzle.transact(5009, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjm1 = null;
          goto _L1
        zzjm1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjm1;
    }

    public int zzhd()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        zzle.transact(5001, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int zzhe()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        zzle.transact(5002, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
