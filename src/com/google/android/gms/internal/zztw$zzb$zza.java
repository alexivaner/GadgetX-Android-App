// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzle, zztw, zzua

public static final class zzawu extends zzle
    implements com.google.android.gms.plus.model.people.CoverInfo
{

    public static final zzua CREATOR = new zzua();
    private static final HashMap zzauW;
    final int zzFG;
    final Set zzauX;
    int zzawt;
    int zzawu;

    public int describeContents()
    {
        zzua zzua1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (CREATOR)obj;
            CREATOR creator;
label1:
            do
            {
                for (Iterator iterator = zzauW.values().iterator(); iterator.hasNext();)
                {
                    creator = (zzauW)iterator.next();
                    if (!zza(creator))
                    {
                        continue label1;
                    }
                    if (((zza) (obj)).zza(creator))
                    {
                        if (!zzb(creator).equals(((zzb) (obj)).zzb(creator)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zzb) (obj)).zza(creator));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzsi();
    }

    public int getLeftImageOffset()
    {
        return zzawt;
    }

    public int getTopImageOffset()
    {
        return zzawu;
    }

    public boolean hasLeftImageOffset()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasTopImageOffset()
    {
        return zzauX.contains(Integer.valueOf(3));
    }

    public int hashCode()
    {
        Iterator iterator = zzauW.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            zzauX zzaux = (zzauW)iterator.next();
            if (zza(zzaux))
            {
                int j = zzaux.();
                i = zzb(zzaux).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzua zzua1 = CREATOR;
        zzua.zza(this, parcel, i);
    }

    protected boolean zza(CREATOR creator)
    {
        return zzauX.contains(Integer.valueOf(creator.()));
    }

    protected Object zzb( )
    {
        switch (.())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(.()).toString());

        case 2: // '\002'
            return Integer.valueOf(zzawt);

        case 3: // '\003'
            return Integer.valueOf(zzawu);
        }
    }

    public Map zzjz()
    {
        return zzsb();
    }

    public HashMap zzsb()
    {
        return zzauW;
    }

    public zzauW zzsi()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("leftImageOffset", zzauW("leftImageOffset", 2));
        zzauW.put("topImageOffset", zzauW("topImageOffset", 3));
    }

    public on.Cover.CoverInfo()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    zzauX(Set set, int i, int j, int k)
    {
        zzauX = set;
        zzFG = i;
        zzawt = j;
        zzawu = k;
    }
}
