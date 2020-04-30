// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zze, Place

public final class PlaceFilter
    implements SafeParcelable
{
    public static final class zza
    {

        private boolean zzanC;
        private Collection zzanH;
        private Collection zzanI;
        private String zzanJ[];

        public PlaceFilter zzpK()
        {
            List list = null;
            ArrayList arraylist;
            ArrayList arraylist1;
            if (zzanH != null)
            {
                arraylist = new ArrayList(zzanH);
            } else
            {
                arraylist = null;
            }
            if (zzanI != null)
            {
                arraylist1 = new ArrayList(zzanI);
            } else
            {
                arraylist1 = null;
            }
            if (zzanJ != null)
            {
                list = Arrays.asList(zzanJ);
            }
            return new PlaceFilter(arraylist, zzanC, list, arraylist1);
        }

        private zza()
        {
            zzanH = null;
            zzanC = false;
            zzanI = null;
            zzanJ = null;
        }

    }


    public static final zze CREATOR = new zze();
    final int zzFG;
    final boolean zzanC;
    final List zzanD;
    final List zzanE;
    private final Set zzanF;
    private final Set zzanG;
    final List zzany;
    private final Set zzanz;

    public PlaceFilter()
    {
        this(false, null);
    }

    PlaceFilter(int i, List list, boolean flag, List list1, List list2)
    {
        zzFG = i;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        zzany = list;
        zzanC = flag;
        if (list2 == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list2);
        }
        zzanD = list;
        if (list1 == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list1);
        }
        zzanE = list;
        zzanz = zzn(zzany);
        zzanF = zzn(zzanD);
        zzanG = zzn(zzanE);
    }

    public PlaceFilter(Collection collection, boolean flag, Collection collection1, Collection collection2)
    {
        this(0, zzc(collection), flag, zzc(collection1), zzc(collection2));
    }

    public PlaceFilter(boolean flag, Collection collection)
    {
        this(null, flag, collection, null);
    }

    private static List zzc(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            return Collections.emptyList();
        } else
        {
            return new ArrayList(collection);
        }
    }

    private static Set zzn(List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptySet();
        } else
        {
            return Collections.unmodifiableSet(new HashSet(list));
        }
    }

    public static PlaceFilter zzpJ()
    {
        return (new zza()).zzpK();
    }

    public int describeContents()
    {
        zze zze1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof PlaceFilter))
            {
                return false;
            }
            obj = (PlaceFilter)obj;
            if (!zzanz.equals(((PlaceFilter) (obj)).zzanz) || zzanC != ((PlaceFilter) (obj)).zzanC || !zzanF.equals(((PlaceFilter) (obj)).zzanF) || !zzanG.equals(((PlaceFilter) (obj)).zzanG))
            {
                return false;
            }
        }
        return true;
    }

    public Set getPlaceIds()
    {
        return zzanG;
    }

    public Set getPlaceTypes()
    {
        return zzanz;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanz, Boolean.valueOf(zzanC), zzanF, zzanG
        });
    }

    public boolean isRestrictedToPlacesOpenNow()
    {
        return zzanC;
    }

    public boolean matches(Place place)
    {
        Set set;
        boolean flag;
        if (isRestrictedToPlacesOpenNow() && place.zzpI())
        {
            return false;
        }
        set = getPlaceTypes();
        if (set.isEmpty())
        {
            flag = true;
            break MISSING_BLOCK_LABEL_35;
        }
        iterator = place.getPlaceTypes().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!set.contains((Integer)iterator.next())) goto _L4; else goto _L3
_L3:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        Iterator iterator;
        if (!flag)
        {
            return false;
        }
        set = getPlaceIds();
        if (set.isEmpty() || set.contains(place.getId()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzk(this);
        if (!zzanz.isEmpty())
        {
            zza1.zza("types", zzanz);
        }
        zza1.zza("requireOpenNow", Boolean.valueOf(zzanC));
        if (!zzanG.isEmpty())
        {
            zza1.zza("placeIds", zzanG);
        }
        if (!zzanF.isEmpty())
        {
            zza1.zza("requestedUserDataTypes", zzanF);
        }
        return zza1.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze zze1 = CREATOR;
        zze.zza(this, parcel, i);
    }

}
