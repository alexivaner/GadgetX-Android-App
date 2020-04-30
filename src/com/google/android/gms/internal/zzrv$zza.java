// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrv, zzsa, zzse, zzsc, 
//            zzsg

public static abstract class zza.zzle extends Binder
    implements zzrv
{
    private static class zza
        implements zzrv
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public void zza(zzsa zzsa1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (zzsa1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzsa1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzsa1;
            parcel.recycle();
            throw zzsa1;
        }

        public void zza(zzsc zzsc1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (zzsc1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzsc1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzsc1;
            parcel.recycle();
            throw zzsc1;
        }

        public void zza(zzse zzse1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (zzse1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzse1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzse1;
            parcel.recycle();
            throw zzse1;
        }

        public void zza(zzsg zzsg1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (zzsg1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzsg1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzsg1;
            parcel.recycle();
            throw zzsg1;
        }

        zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public static zzrv zzcl(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (iinterface != null && (iinterface instanceof zzrv))
        {
            return (zzrv)iinterface;
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
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzsa)zzsa.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzse)zzse.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj2;
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzsc)zzsc.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj3;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (zzsg)zzsg.CREATOR.createFromParcel(parcel);
        }
        zza(parcel1);
        return true;
    }
}
