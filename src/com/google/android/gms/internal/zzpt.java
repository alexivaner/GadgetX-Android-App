// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceReportCreator;
import com.google.android.gms.location.places.zzc;
import com.google.android.gms.location.places.zzd;
import com.google.android.gms.location.places.zze;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzg;

// Referenced classes of package com.google.android.gms.internal:
//            zzqh, zzpv, zzqi

public interface zzpt
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzpt
    {

        public static zzpt zzbn(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (iinterface != null && (iinterface instanceof zzpt))
            {
                return (zzpt)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            PendingIntent pendingintent = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                zzf zzf1;
                if (parcel.readInt() != 0)
                {
                    zzf1 = zzf.CREATOR.zzdC(parcel);
                } else
                {
                    zzf1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    pendingintent = null;
                }
                zza(zzf1, ((zzqh) (obj)), pendingintent, zzpv.zza.zzbp(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                zzqh zzqh1;
                if (parcel.readInt() != 0)
                {
                    zzqh1 = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    zzqh1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                zza(zzqh1, ((PendingIntent) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                zzc zzc1;
                if (parcel.readInt() != 0)
                {
                    zzc1 = zzc.CREATOR.zzdA(parcel);
                } else
                {
                    zzc1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    pendingintent = null;
                }
                zza(zzc1, ((zzqh) (obj)), pendingintent, zzpv.zza.zzbp(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                zzqh zzqh2;
                if (parcel.readInt() != 0)
                {
                    zzqh2 = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    zzqh2 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                zzb(zzqh2, ((PendingIntent) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                PlaceFilter placefilter;
                if (parcel.readInt() != 0)
                {
                    placefilter = PlaceFilter.CREATOR.zzdB(parcel);
                } else
                {
                    placefilter = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = zzqh.CREATOR.zzdI(parcel);
                }
                zza(placefilter, ((zzqh) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
                break;
            }
            PlaceReport placereport;
            if (parcel.readInt() != 0)
            {
                placereport = PlaceReport.CREATOR.createFromParcel(parcel);
            } else
            {
                placereport = null;
            }
            obj = pendingintent;
            if (parcel.readInt() != 0)
            {
                obj = zzqh.CREATOR.zzdI(parcel);
            }
            zza(placereport, ((zzqh) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzpt
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public void zza(zzqh zzqh1, PendingIntent pendingintent, zzpv zzpv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (zzqh1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zzqh1.writeToParcel(parcel, 0);
_L5:
            if (pendingintent == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L6:
            if (zzpv1 == null)
            {
                break MISSING_BLOCK_LABEL_131;
            }
            zzqh1 = zzpv1.asBinder();
_L7:
            parcel.writeStrongBinder(zzqh1);
            zzle.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            zzqh1;
            parcel1.recycle();
            parcel.recycle();
            throw zzqh1;
_L4:
            parcel.writeInt(0);
              goto _L6
            zzqh1 = null;
              goto _L7
        }

        public void zza(PlaceFilter placefilter, zzqh zzqh1, zzpv zzpv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placefilter == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L5:
            if (zzqh1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            zzqh1.writeToParcel(parcel, 0);
_L6:
            if (zzpv1 == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            placefilter = zzpv1.asBinder();
_L7:
            parcel.writeStrongBinder(placefilter);
            zzle.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            placefilter;
            parcel1.recycle();
            parcel.recycle();
            throw placefilter;
_L4:
            parcel.writeInt(0);
              goto _L6
            placefilter = null;
              goto _L7
        }

        public void zza(PlaceReport placereport, zzqh zzqh1, zzpv zzpv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placereport == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placereport.writeToParcel(parcel, 0);
_L5:
            if (zzqh1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            zzqh1.writeToParcel(parcel, 0);
_L6:
            if (zzpv1 == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            placereport = zzpv1.asBinder();
_L7:
            parcel.writeStrongBinder(placereport);
            zzle.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            placereport;
            parcel1.recycle();
            parcel.recycle();
            throw placereport;
_L4:
            parcel.writeInt(0);
              goto _L6
            placereport = null;
              goto _L7
        }

        public void zza(zzc zzc1, zzqh zzqh1, PendingIntent pendingintent, zzpv zzpv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (zzc1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zzc1.writeToParcel(parcel, 0);
_L7:
            if (zzqh1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            zzqh1.writeToParcel(parcel, 0);
_L8:
            if (pendingintent == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L9:
            if (zzpv1 == null)
            {
                break MISSING_BLOCK_LABEL_159;
            }
            zzc1 = zzpv1.asBinder();
_L10:
            parcel.writeStrongBinder(zzc1);
            zzle.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            zzc1;
            parcel1.recycle();
            parcel.recycle();
            throw zzc1;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            zzc1 = null;
              goto _L10
        }

        public void zza(zzf zzf1, zzqh zzqh1, PendingIntent pendingintent, zzpv zzpv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (zzf1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zzf1.writeToParcel(parcel, 0);
_L7:
            if (zzqh1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            zzqh1.writeToParcel(parcel, 0);
_L8:
            if (pendingintent == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L9:
            if (zzpv1 == null)
            {
                break MISSING_BLOCK_LABEL_159;
            }
            zzf1 = zzpv1.asBinder();
_L10:
            parcel.writeStrongBinder(zzf1);
            zzle.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            zzf1;
            parcel1.recycle();
            parcel.recycle();
            throw zzf1;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            zzf1 = null;
              goto _L10
        }

        public void zzb(zzqh zzqh1, PendingIntent pendingintent, zzpv zzpv1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (zzqh1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zzqh1.writeToParcel(parcel, 0);
_L5:
            if (pendingintent == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L6:
            if (zzpv1 == null)
            {
                break MISSING_BLOCK_LABEL_131;
            }
            zzqh1 = zzpv1.asBinder();
_L7:
            parcel.writeStrongBinder(zzqh1);
            zzle.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            zzqh1;
            parcel1.recycle();
            parcel.recycle();
            throw zzqh1;
_L4:
            parcel.writeInt(0);
              goto _L6
            zzqh1 = null;
              goto _L7
        }

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract void zza(zzqh zzqh, PendingIntent pendingintent, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(PlaceFilter placefilter, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(PlaceReport placereport, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(zzc zzc, zzqh zzqh, PendingIntent pendingintent, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(zzf zzf, zzqh zzqh, PendingIntent pendingintent, zzpv zzpv)
        throws RemoteException;

    public abstract void zzb(zzqh zzqh, PendingIntent pendingintent, zzpv zzpv)
        throws RemoteException;
}
