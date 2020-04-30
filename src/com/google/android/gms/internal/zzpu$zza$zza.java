// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.zzc;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzj;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpu, zzqh, zzqo, zzpv

private static class zzle
    implements zzpu
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(zzqh zzqh1, PendingIntent pendingintent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (zzqh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L3:
        if (pendingintent == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        parcel.writeInt(1);
        pendingintent.writeToParcel(parcel, 0);
_L4:
        zzle.transact(10, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        zzqh1;
        parcel.recycle();
        throw zzqh1;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(zzqo zzqo1, String s, String s1, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (zzqo1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqo1.writeToParcel(parcel, 0);
_L3:
        parcel.writeString(s);
        parcel.writeString(s1);
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        zzqo1 = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        zzqo1 = zzpv1.asBinder();
        parcel.writeStrongBinder(zzqo1);
        zzle.transact(16, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        zzqo1;
        parcel.recycle();
        throw zzqo1;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(AddPlaceRequest addplacerequest, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (addplacerequest == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        addplacerequest.writeToParcel(parcel, 0);
_L3:
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        addplacerequest = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        addplacerequest = zzpv1.asBinder();
        parcel.writeStrongBinder(addplacerequest);
        zzle.transact(14, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        addplacerequest;
        parcel.recycle();
        throw addplacerequest;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(PlaceReport placereport, zzqh zzqh1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (placereport == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        placereport.writeToParcel(parcel, 0);
_L3:
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        zzle.transact(15, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        placereport;
        parcel.recycle();
        throw placereport;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(zzc zzc1, zzqh zzqh1, PendingIntent pendingintent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (zzc1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzc1.writeToParcel(parcel, 0);
_L5:
        if (zzqh1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L6:
        if (pendingintent == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        parcel.writeInt(1);
        pendingintent.writeToParcel(parcel, 0);
_L7:
        zzle.transact(11, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        zzc1;
        parcel.recycle();
        throw zzc1;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcel.writeInt(0);
          goto _L7
    }

    public void zza(zzf zzf1, zzqh zzqh1, PendingIntent pendingintent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (zzf1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzf1.writeToParcel(parcel, 0);
_L5:
        if (zzqh1 == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L6:
        if (pendingintent == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        parcel.writeInt(1);
        pendingintent.writeToParcel(parcel, 0);
_L7:
        zzle.transact(9, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        zzf1;
        parcel.recycle();
        throw zzf1;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcel.writeInt(0);
          goto _L7
    }

    public void zza(zzj zzj1, LatLngBounds latlngbounds, List list, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (zzj1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzj1.writeToParcel(parcel, 0);
_L5:
        if (latlngbounds == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L6:
        parcel.writeStringList(list);
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L7:
        zzj1 = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        zzj1 = zzpv1.asBinder();
        parcel.writeStrongBinder(zzj1);
        zzle.transact(8, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        zzj1;
        parcel.recycle();
        throw zzj1;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcel.writeInt(0);
          goto _L7
    }

    public void zza(LatLng latlng, PlaceFilter placefilter, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (latlng == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        latlng.writeToParcel(parcel, 0);
_L5:
        if (placefilter == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        placefilter.writeToParcel(parcel, 0);
_L6:
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L7:
        latlng = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        latlng = zzpv1.asBinder();
        parcel.writeStrongBinder(latlng);
        zzle.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        latlng;
        parcel.recycle();
        throw latlng;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcel.writeInt(0);
          goto _L7
    }

    public void zza(LatLngBounds latlngbounds, int i, String s, PlaceFilter placefilter, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (latlngbounds == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L5:
        parcel.writeInt(i);
        parcel.writeString(s);
        if (placefilter == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        placefilter.writeToParcel(parcel, 0);
_L6:
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L7:
        latlngbounds = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        latlngbounds = zzpv1.asBinder();
        parcel.writeStrongBinder(latlngbounds);
        zzle.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        latlngbounds;
        parcel.recycle();
        throw latlngbounds;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcel.writeInt(0);
          goto _L7
    }

    public void zza(String s, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        parcel.writeString(s);
        if (zzqh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        s = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s = zzpv1.asBinder();
        parcel.writeStrongBinder(s);
        zzle.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        parcel.recycle();
        throw s;
    }

    public void zza(String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        parcel.writeString(s);
        if (latlngbounds == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        latlngbounds.writeToParcel(parcel, 0);
_L5:
        if (autocompletefilter == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        autocompletefilter.writeToParcel(parcel, 0);
_L6:
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L7:
        s = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        s = zzpv1.asBinder();
        parcel.writeStrongBinder(s);
        zzle.transact(13, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L5
        s;
        parcel.recycle();
        throw s;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcel.writeInt(0);
          goto _L7
    }

    public void zza(List list, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        parcel.writeStringList(list);
        if (zzqh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        list = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        list = zzpv1.asBinder();
        parcel.writeStrongBinder(list);
        zzle.transact(7, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        list;
        parcel.recycle();
        throw list;
    }

    public void zzb(zzqh zzqh1, PendingIntent pendingintent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (zzqh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L3:
        if (pendingintent == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        parcel.writeInt(1);
        pendingintent.writeToParcel(parcel, 0);
_L4:
        zzle.transact(12, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        zzqh1;
        parcel.recycle();
        throw zzqh1;
        parcel.writeInt(0);
          goto _L4
    }

    public void zzb(PlaceFilter placefilter, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (placefilter == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        placefilter.writeToParcel(parcel, 0);
_L3:
        if (zzqh1 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        placefilter = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        placefilter = zzpv1.asBinder();
        parcel.writeStrongBinder(placefilter);
        zzle.transact(5, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        placefilter;
        parcel.recycle();
        throw placefilter;
        parcel.writeInt(0);
          goto _L4
    }

    public void zzb(String s, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        parcel.writeString(s);
        if (zzqh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        s = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s = zzpv1.asBinder();
        parcel.writeStrongBinder(s);
        zzle.transact(6, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        parcel.recycle();
        throw s;
    }

    public void zzb(List list, zzqh zzqh1, zzpv zzpv1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        parcel.writeStringList(list);
        if (zzqh1 == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        zzqh1.writeToParcel(parcel, 0);
_L4:
        list = obj;
        if (zzpv1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        list = zzpv1.asBinder();
        parcel.writeStrongBinder(list);
        zzle.transact(17, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
        if (true) goto _L4; else goto _L3
_L3:
        list;
        parcel.recycle();
        throw list;
    }

    ilter(IBinder ibinder)
    {
        zzle = ibinder;
    }
}
