// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.zza;

// Referenced classes of package com.google.android.gms.internal:
//            zzuk

private static class zzle
    implements zzuk
{

    private IBinder zzle;

    public IBinder asBinder()
    {
        return zzle;
    }

    public void zza(Status status, zza zza1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        if (status == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        status.writeToParcel(parcel, 0);
_L3:
        if (zza1 == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        parcel.writeInt(1);
        zza1.writeToParcel(parcel, 0);
_L4:
        zzle.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        status;
        parcel.recycle();
        throw status;
        parcel.writeInt(0);
          goto _L4
    }

    public void zzcG(String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        parcel.writeString(s);
        zzle.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    (IBinder ibinder)
    {
        zzle = ibinder;
    }
}
