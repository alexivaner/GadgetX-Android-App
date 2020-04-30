// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.zzc;
import com.google.android.gms.location.places.zzf;

// Referenced classes of package com.google.android.gms.internal:
//            zzpt, zzqh, zzpv

private static class zzle
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

    eport(IBinder ibinder)
    {
        zzle = ibinder;
    }
}
