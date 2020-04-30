// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzu;

public interface zznj
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zznj
    {

        public static zznj zzaG(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (iinterface != null && (iinterface instanceof zznj))
            {
                return (zznj)iinterface;
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
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                parcel1 = obj;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                parcel1 = obj1;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (zzar)zzar.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                parcel1 = obj2;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (zzb)zzb.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                parcel1 = obj3;
                if (parcel.readInt() != 0)
                {
                    parcel1 = (zzav)zzav.CREATOR.createFromParcel(parcel);
                }
                zza(parcel1);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                parcel1 = obj4;
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzu)zzu.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;
        }
    }

    private static class zza.zza
        implements zznj
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public void zza(StartBleScanRequest startblescanrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (startblescanrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            startblescanrequest.writeToParcel(parcel, 0);
_L1:
            zzle.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            startblescanrequest;
            parcel.recycle();
            throw startblescanrequest;
        }

        public void zza(zzar zzar1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (zzar1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzar1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzar1;
            parcel.recycle();
            throw zzar1;
        }

        public void zza(zzav zzav1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (zzav1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzav1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzav1;
            parcel.recycle();
            throw zzav1;
        }

        public void zza(zzb zzb1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (zzb1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzb1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzb1;
            parcel.recycle();
            throw zzb1;
        }

        public void zza(zzu zzu1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (zzu1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzu1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzu1;
            parcel.recycle();
            throw zzu1;
        }

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract void zza(StartBleScanRequest startblescanrequest)
        throws RemoteException;

    public abstract void zza(zzar zzar)
        throws RemoteException;

    public abstract void zza(zzav zzav)
        throws RemoteException;

    public abstract void zza(zzb zzb)
        throws RemoteException;

    public abstract void zza(zzu zzu)
        throws RemoteException;
}
