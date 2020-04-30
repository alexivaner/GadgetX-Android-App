// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzl;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zze

private static class zzle
    implements zze
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public Bitmap zza(zzl zzl1, int i, int j)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowRenderer");
        if (zzl1 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        zzl1 = zzl1.asBinder();
_L1:
        parcel.writeStrongBinder(zzl1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        zzle.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzl1 = obj;
        if (parcel1.readInt() != 0)
        {
            zzl1 = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return zzl1;
        zzl1 = null;
          goto _L1
        zzl1;
        parcel1.recycle();
        parcel.recycle();
        throw zzl1;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
