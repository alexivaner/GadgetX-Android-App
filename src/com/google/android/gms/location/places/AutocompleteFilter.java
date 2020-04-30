// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zzb

public class AutocompleteFilter
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    final int zzFG;
    final boolean zzanx;
    final List zzany;
    private final Set zzanz;

    AutocompleteFilter(int i, boolean flag, Collection collection)
    {
        zzFG = i;
        zzanx = flag;
        if (collection == null)
        {
            collection = Collections.emptyList();
        } else
        {
            collection = new ArrayList(collection);
        }
        zzany = collection;
        if (zzany.isEmpty())
        {
            zzanz = Collections.emptySet();
            return;
        } else
        {
            zzanz = Collections.unmodifiableSet(new HashSet(zzany));
            return;
        }
    }

    public static AutocompleteFilter create(Collection collection)
    {
        return zza(true, collection);
    }

    public static AutocompleteFilter zza(boolean flag, Collection collection)
    {
        return new AutocompleteFilter(0, flag, collection);
    }

    public int describeContents()
    {
        zzb zzb1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AutocompleteFilter))
            {
                return false;
            }
            obj = (AutocompleteFilter)obj;
            if (!zzanz.equals(((AutocompleteFilter) (obj)).zzanz) || zzanx != ((AutocompleteFilter) (obj)).zzanx)
            {
                return false;
            }
        }
        return true;
    }

    public Set getPlaceTypes()
    {
        return zzanz;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Boolean.valueOf(zzanx), zzanz
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzk(this);
        if (!zzanx)
        {
            zza1.zza("restrictedToPlaces", Boolean.valueOf(zzanx));
        }
        zza1.zza("placeTypes", zzanz);
        return zza1.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb zzb1 = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public boolean zzpF()
    {
        return zzanx;
    }

}
