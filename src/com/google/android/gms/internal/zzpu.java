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
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceReportCreator;
import com.google.android.gms.location.places.zzb;
import com.google.android.gms.location.places.zzc;
import com.google.android.gms.location.places.zzd;
import com.google.android.gms.location.places.zze;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzj;
import com.google.android.gms.location.places.zzk;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.zzg;
import com.google.android.gms.maps.model.zzi;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzqh, zzqo, zzpv, zzqi, 
//            zzqp

public interface zzpu
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzpu
    {

        public static zzpu zzbo(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (iinterface != null && (iinterface instanceof zzpu))
            {
                return (zzpu)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj5 = null;
            Object obj2 = null;
            Object obj = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj1 = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = LatLngBounds.CREATOR.zzdV(parcel);
                } else
                {
                    parcel1 = null;
                }
                i = parcel.readInt();
                obj2 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = PlaceFilter.CREATOR.zzdB(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = zzqh.CREATOR.zzdI(parcel);
                }
                zza(parcel1, i, ((String) (obj2)), ((PlaceFilter) (obj)), ((zzqh) (obj1)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj = parcel.readString();
                parcel1 = obj5;
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzqh.CREATOR.zzdI(parcel);
                }
                zza(((String) (obj)), parcel1, zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = LatLng.CREATOR.zzdW(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = PlaceFilter.CREATOR.zzdB(parcel);
                } else
                {
                    obj = null;
                }
                obj1 = obj2;
                if (parcel.readInt() != 0)
                {
                    obj1 = zzqh.CREATOR.zzdI(parcel);
                }
                zza(parcel1, ((PlaceFilter) (obj)), ((zzqh) (obj1)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = PlaceFilter.CREATOR.zzdB(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = zzqh.CREATOR.zzdI(parcel);
                }
                zzb(parcel1, ((zzqh) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj = parcel.readString();
                parcel1 = obj6;
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzqh.CREATOR.zzdI(parcel);
                }
                zzb(((String) (obj)), parcel1, zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj = parcel.createStringArrayList();
                parcel1 = obj7;
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzqh.CREATOR.zzdI(parcel);
                }
                zza(((List) (obj)), parcel1, zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj = parcel.createStringArrayList();
                parcel1 = obj8;
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzqh.CREATOR.zzdI(parcel);
                }
                zzb(((List) (obj)), parcel1, zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzj.CREATOR.zzdD(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = LatLngBounds.CREATOR.zzdV(parcel);
                } else
                {
                    obj = null;
                }
                obj2 = parcel.createStringArrayList();
                if (parcel.readInt() != 0)
                {
                    obj1 = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    obj1 = null;
                }
                zza(parcel1, ((LatLngBounds) (obj)), ((List) (obj2)), ((zzqh) (obj1)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzf.CREATOR.zzdC(parcel);
                } else
                {
                    parcel1 = null;
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
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel1, ((zzqh) (obj)), parcel);
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel1, parcel);
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzc.CREATOR.zzdA(parcel);
                } else
                {
                    parcel1 = null;
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
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel1, ((zzqh) (obj)), parcel);
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zzb(parcel1, parcel);
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj2 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel1 = LatLngBounds.CREATOR.zzdV(parcel);
                } else
                {
                    parcel1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj = AutocompleteFilter.CREATOR.zzdz(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = zzqh.CREATOR.zzdI(parcel);
                } else
                {
                    obj1 = null;
                }
                zza(((String) (obj2)), parcel1, ((AutocompleteFilter) (obj)), ((zzqh) (obj1)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = (AddPlaceRequest)AddPlaceRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel1 = null;
                }
                obj = obj3;
                if (parcel.readInt() != 0)
                {
                    obj = zzqh.CREATOR.zzdI(parcel);
                }
                zza(parcel1, ((zzqh) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    parcel1 = PlaceReport.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel1 = null;
                }
                obj = obj4;
                if (parcel.readInt() != 0)
                {
                    obj = zzqh.CREATOR.zzdI(parcel);
                }
                zza(parcel1, ((zzqh) (obj)));
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel1 = zzqo.CREATOR.zzdM(parcel);
            } else
            {
                parcel1 = null;
            }
            obj1 = parcel.readString();
            obj2 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                obj = zzqh.CREATOR.zzdI(parcel);
            } else
            {
                obj = null;
            }
            zza(parcel1, ((String) (obj1)), ((String) (obj2)), ((zzqh) (obj)), zzpv.zza.zzbp(parcel.readStrongBinder()));
            return true;
        }
    }

    private static class zza.zza
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

        zza.zza(IBinder ibinder)
        {
            zzle = ibinder;
        }
    }


    public abstract void zza(zzqh zzqh, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(zzqo zzqo, String s, String s1, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(AddPlaceRequest addplacerequest, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(PlaceReport placereport, zzqh zzqh)
        throws RemoteException;

    public abstract void zza(zzc zzc, zzqh zzqh, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(zzf zzf, zzqh zzqh, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(zzj zzj, LatLngBounds latlngbounds, List list, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(LatLng latlng, PlaceFilter placefilter, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(LatLngBounds latlngbounds, int i, String s, PlaceFilter placefilter, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(String s, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zza(List list, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zzb(zzqh zzqh, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zzb(PlaceFilter placefilter, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zzb(String s, zzqh zzqh, zzpv zzpv)
        throws RemoteException;

    public abstract void zzb(List list, zzqh zzqh, zzpv zzpv)
        throws RemoteException;
}
