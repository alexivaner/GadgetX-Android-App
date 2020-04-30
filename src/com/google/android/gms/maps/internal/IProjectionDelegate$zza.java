// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.maps.model.zzi;
import com.google.android.gms.maps.model.zzy;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IProjectionDelegate, zzy, zzz

public static abstract class zza.zzle extends Binder
    implements IProjectionDelegate
{
    private static class zza
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
           