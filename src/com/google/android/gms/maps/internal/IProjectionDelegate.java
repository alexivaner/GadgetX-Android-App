// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.maps.model.zzi;
import com.google.android.gms.maps.model.zzy;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzy, zzz

public interface IProjectionDelegate
    extends IInterface
{
    public static abstract class zza extends Binder
        implements IProjectionDelegate
    {

        public static IProjectionDelegate zzbQ(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (iinterface != null && (iinterface instanceof IProjectionDelegate))
            {
                return (IProjectionDelegate)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            zzd zzd1 = null;
            Object obj1 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                parcel = fromScreenLocation(com.google.android.gms.dynamic.zzd.zza.zzau(parcel.readStrongBinder()));
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                if (parcel.readInt() != 0)
                {
                    parcel = LatLng.CREATOR.zzdW(parcel);
                } else
                {
                    parcel = null;
                }
                zzd1 = toScreenLocation(parcel);
                parcel1.writeNoException();
                parcel = ((Parcel) (obj));
                if (zzd1 != null)
                {
                    parcel = zzd1.asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                parcel = getVisibleRegion();
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                obj = zzd1;
                if (parcel.readInt() != 0)
                {
                    obj = zzy.CREATOR.zzdR(parcel);
                }
                parcel = fromScreenLocation2(((com.google.android.gms.maps.internal.zzy) (obj)));
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                obj = obj1;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = LatLng.CREATOR.zzdW(parcel);
            }
            parcel = toScreenLocation2(((LatLng) (obj)));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;
        }
    }

    private static class zza.zza
        implements IProjectionDelegate
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public LatLng fromScreenLocation(zzd zzd1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_83;
            }
            zzd1 = zzd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzd1);
            zzle.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            zzd1 = obj;
            if (parcel1.readInt() != 0)
            {
                zzd1 = LatLng.CREATOR.zzdW(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return zzd1;
            zzd1 = null;
              goto _L1
            zzd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzd1;
        }

        public LatLng fromScreenLocation2(com.google.android.gms.maps.internal.zzy zzy1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (zzy1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zzy1.writeToParcel(parcel, 0);
_L3:
            zzle.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            zzy1 = LatLng.CREATOR.zzdW(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return zzy1;
_L2:
            parcel.writeInt(0);
              goto _L3
            zzy1;
            parcel1.recycle();
            parcel.recycle();
            throw zzy1;
            zzy1 = null;
              goto _L4
        }

        public VisibleRegion getVisibleRegion()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            zzle.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            VisibleRegion visibleregion = VisibleRegion.CREATOR.zzeg(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return visibleregion;
_L2:
            visibleregion = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public zzd toScreenLocation(LatLng latlng)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (latlng == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L1:
            zzle.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            latlng = com.google.android.gms.dynamic.zzd.zza.zzau(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return latlng;
            parcel.writeInt(0);
              goto _L1
            latlng;
            parcel1.recycle();
            parcel.recycle();
            throw latlng;
        }

        public com.google.android.gms.maps.internal.zzy toScreenLocation2(LatLng latlng)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (latlng == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L3:
            zzle.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            latlng = zzy.CREATOR.zzdR(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return latlng;
_L2:
            parcel.writeInt(0);
              goto _L3
            latlng;
            parcel1.recycle();
            parcel.recycle();
            throw latlng;
            latlng = null;
              goto _L4
        }

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract LatLng fromScreenLocation(zzd zzd)
        throws RemoteException;

    public abstract LatLng fromScreenLocation2(com.google.android.gms.maps.internal.zzy zzy)
        throws RemoteException;

    public abstract VisibleRegion getVisibleRegion()
        throws RemoteException;

    public abstract zzd toScreenLocation(LatLng latlng)
        throws RemoteException;

    public abstract com.google.android.gms.maps.internal.zzy toScreenLocation2(LatLng latlng)
        throws RemoteException;
}
