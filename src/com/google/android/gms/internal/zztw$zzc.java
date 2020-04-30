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
//            zzle, zztw, zzuc

public static final class zzxX extends zzle
    implements com.google.android.gms.plus.model.people.age
{

    public static final zzuc CREATOR = new zzuc();
    private static final HashMap zzauW;
    final int zzFG;
    final Set zzauX;
    String zzxX;

    public int describeContents()
    {
        zzuc zzuc1 = CREATOR;
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
        return zzsk();
    }

    public String getUrl()
    {
        return zzxX;
    }

    public boolean hasUrl()
    {
        return zzauX.contains(Integer.valueOf(2));
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
                int j = zzaux.zzjG();
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
        zzuc zzuc1 = CREATOR;
        zzuc.zza(this, parcel, i);
    }

    protected boolean zza(CREATOR creator)
    {
        return zzauX.contains(Integer.valueOf(creator.zzjG()));
    }

    protected Object zzb(zzjG zzjg)
    {
        switch (zzjg.zzjG())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zzjg.zzjG()).toString());

        case 2: // '\002'
            return zzxX;
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

    public zzauW zzsk()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("url", zzl("url", 2));
    }

    public Person.Image()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    public zzauX(String s)
    {
        zzauX = new HashSet();
        zzFG = 1;
        zzxX = s;
        zzauX.add(Integer.valueOf(2));
    }

    zzauX(Set set, int i, String s)
    {
        zzauX = set;
        zzFG = i;
        zzxX = s;
    }
}
