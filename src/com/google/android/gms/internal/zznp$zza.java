// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzao;

// Referenced classes of package com.google.android.gms.internal:
//            zznp

public static abstract class zza.zzle extends Binder
    implements zznp
{
    private static class zza
        implements zznp
    {

        private IBinder zzle;

        public IBinder asBinder()
        {
            return zzle;
        }

        public void zza(SessionInsertRequest sessioninsertrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessioninsertrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            sessioninsertrequest.writeToParcel(parcel, 0);
_L1:
            zzle.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessioninsertrequest;
            parcel.recycle();
            throw sessioninsertrequest;
        }

        public void zza(SessionReadRequest sessionreadrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessionreadrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            sessionreadrequest.writeToParcel(parcel, 0);
_L1:
            zzle.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionreadrequest;
            parcel.recycle();
            throw sessionreadrequest;
        }

        public void zza(zzai zzai1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (zzai1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzai1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzai1;
            parcel.recycle();
            throw zzai1;
        }

        public void zza(zzak zzak1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (zzak1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzak1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzak1;
            parcel.recycle();
            throw zzak1;
        }

        public void zza(zzam zzam1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (zzam1 == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            zzam1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzam1;
            parcel.recycle();
            throw zzam1;
        }

        public void zza(zzao zzao1)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (zzao1 == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            zzao1.writeToParcel(parcel, 0);
_L1:
            zzle.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            zzao1;
            parcel.recycle();
            throw zzao1;
        }

        zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public static zznp zzaM(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
        if (iinterface != null && (iinterface instanceof zznp))
        {
            return (zznp)iinterface;
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
            parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzak)zzak.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzam)zzam.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            parcel1 = obj2;
            if (parcel.readInt() != 0)
            {
                parcel1 = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            parcel1 = obj3;
            if (parcel.readInt() != 0)
            {
                parcel1 = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            parcel1 = obj4;
            if (parcel.readInt() != 0)
            {
                parcel1 = (zzai)zzai.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            parcel1 = obj5;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (zzao)zzao.CREATOR.createFromParcel(parcel);
        }
        zza(parcel1);
        return true;
    }
}
