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
//            zzjf, zzjb, zziw

public interface zzje
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzje
    {

        public static zzje zzI(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (iinterface != null && (iinterface instanceof zzje))
            {
                return (zzje)iinterface;
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
                parcel1.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zza(com.google.android.gms.internal.zzjf.zza.zzJ(parcel.readStrongBinder()), parcel.readString(), (zzjb[])parcel.createTypedArray(zzjb.CREATOR));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zza(com.google.android.gms.internal.zzjf.zza.zzJ(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zzb(com.google.android.gms.internal.zzjf.zza.zzJ(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zzjf zzjf = com.google.android.gms.internal.zzjf.zza.zzJ(parcel.readStrongBinder());
                boolean flag;
                if (parcel.readInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zza(zzjf, flag);
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zziv.zza zza1;
                if (parcel.readInt() != 0)
                {
                    zza1 = zziv.zza.CREATOR.zzp(parcel);
                } else
                {
                    zza1 = null;
                }
                zza(zza1, com.google.android.gms.internal.zzjf.zza.zzJ(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                zza(com.google.android.gms.internal.zzjf.zza.zzJ(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static class zza.zza
        implements zzje
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public void zza(zziv.zza zza1, zzjf zzjf1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (zza1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zza1.writeToParcel(parcel, 0);
_L3:
            if (zzjf1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            zza1 = zzjf1.asBinder();
_L4:
            parcel.writeStrongBinder(zza1);
            zzle.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            zza1;
            parcel1.recycle();
            parcel.recycle();
            throw zza1;
            zza1 = null;
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

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract void zza(zziv.zza zza1, zzjf zzjf)
        throws RemoteException;

    public abstract void zza(zzjf zzjf)
        throws RemoteException;

    public abstract void zza(zzjf zzjf, String s, String s1)
        throws RemoteException;

    public abstract void zza(zzjf zzjf, String s, zzjb azzjb[])
        throws RemoteException;

    public abstract void zza(zzjf zzjf, boolean flag)
        throws RemoteException;

    public abstract void zzb(zzjf zzjf)
        throws RemoteException;
}
