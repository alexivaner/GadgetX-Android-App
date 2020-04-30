// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zzaa;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.fitness.request.zzr;
import com.google.android.gms.fitness.request.zzy;

public interface zznl
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zznl
    {

        public static zznl zzaI(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (iinterface != null && (iinterface instanceof zznl))
            {
                return (zznl)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                parcel1 = obj;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                parcel1 = obj1;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (zze)zze.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                parcel1 = obj2;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                parcel1 = obj3;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (zzr)zzr.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                parcel1 = obj4;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (zzaa)zzaa.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                parcel1 = obj5;
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzy)zzy.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;
        }
    }

    private static class zza.zza
        implements zznl
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public void zza(DataDeleteRequest datadeleterequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (datadeleterequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            datadeleterequest.writeToParcel(parcel, 0);
_L1:
            zzle.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datadeleterequest;
            parcel.recycle();
            throw datadeleterequest;
        }

        public void zza(DataReadRequest datareadrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (datareadrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            datareadrequest.writeToParcel(parcel, 0);
_L1:
            zzle.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datareadrequest;
            parcel.recycle();
            throw datareadrequest;
        }

        public void zza(zzaa zzaa1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (zzaa1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzaa1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzaa1;
            parcel.recycle();
            throw zzaa1;
        }

        public void zza(zze zze1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (zze1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zze1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zze1;
            parcel.recycle();
            throw zze1;
        }

        public void zza(zzr zzr1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (zzr1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzr1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzr1;
            parcel.recycle();
            throw zzr1;
        }

        public void zza(zzy zzy1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (zzy1 == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            zzy1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzy1;
            parcel.recycle();
            throw zzy1;
        }

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract void zza(DataDeleteRequest datadeleterequest)
        throws RemoteException;

    public abstract void zza(DataReadRequest datareadrequest)
        throws RemoteException;

    public abstract void zza(zzaa zzaa)
        throws RemoteException;

    public abstract void zza(zze zze)
        throws RemoteException;

    public abstract void zza(zzr zzr)
        throws RemoteException;

    public abstract void zza(zzy zzy)
        throws RemoteException;
}
