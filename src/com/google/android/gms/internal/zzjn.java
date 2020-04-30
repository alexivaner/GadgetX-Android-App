// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzjm

public interface zzjn
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzjn
    {

        public static zzjn zzN(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            if (iinterface != null && (iinterface instanceof zzjn))
            {
                return (zzjn)iinterface;
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
                parcel1.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                return true;

            case 5001: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                i = zzhd();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 5002: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                i = zzhe();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 5003: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zza(zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
                parcel1.writeNoException();
                return true;

            case 5004: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zza(zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5005: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zza(zzjm.zza.zzM(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5006: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zza(zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
                parcel1.writeNoException();
                return true;

            case 5007: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zzb(zzjm.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5008: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zzb(zzjm.zza.zzM(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5009: 
                parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                zzc(zzjm.zza.zzM(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class zza.zza
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

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract void zza(zzjm zzjm)
        throws RemoteException;

    public abstract void zza(zzjm zzjm, int i)
        throws RemoteException;

    public abstract void zza(zzjm zzjm, int i, String s, byte abyte0[])
        throws RemoteException;

    public abstract void zza(zzjm zzjm, int i, byte abyte0[])
        throws RemoteException;

    public abstract void zzb(zzjm zzjm)
        throws RemoteException;

    public abstract void zzb(zzjm zzjm, int i)
        throws RemoteException;

    public abstract void zzc(zzjm zzjm)
        throws RemoteException;

    public abstract int zzhd()
        throws RemoteException;

    public abstract int zzhe()
        throws RemoteException;
}
