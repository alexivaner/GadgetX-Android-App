// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzje, zzjf, zzjb

private static class zzle
    implements zzje
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(zzle zzle1, zzjf zzjf1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (zzle1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzle1.eToParcel(parcel, 0);
_L3:
        if (zzjf1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        zzle1 = zzjf1.asBinder();
_L4:
        parcel.writeStrongBinder(zzle1);
        zzle.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        zzle1;
        parcel1.recycle();
        parcel.recycle();
        throw zzle1;
        zzle1 = null;
          goto _L4
    }

    public void zza(zzjf zzjf1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (zzjf1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzjf1 = zzjf1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjf1);
        zzle.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjf1 = null;
          goto _L1
        zzjf1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjf1;
    }

    public void zza(zzjf zzjf1, String s, String s1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (zzjf1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        zzjf1 = zzjf1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjf1);
        parcel.writeString(s);
        parcel.writeString(s1);
        zzle.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjf1 = null;
          goto _L1
        zzjf1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjf1;
    }

    public void zza(zzjf zzjf1, String s, zzjb azzjb[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (zzjf1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        zzjf1 = zzjf1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjf1);
        parcel.writeString(s);
        parcel.writeTypedArray(azzjb, 0);
        zzle.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjf1 = null;
          goto _L1
        zzjf1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjf1;
    }

    public void zza(zzjf zzjf1, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (zzjf1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        zzjf1 = zzjf1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjf1);
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        zzle.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjf1 = null;
          goto _L1
        zzjf1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjf1;
    }

    public void zzb(zzjf zzjf1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (zzjf1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzjf1 = zzjf1.asBinder();
_L1:
        parcel.writeStrongBinder(zzjf1);
        zzle.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzjf1 = null;
          goto _L1
        zzjf1;
        parcel1.recycle();
        parcel.recycle();
        throw zzjf1;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
