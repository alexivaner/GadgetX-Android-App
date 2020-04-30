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
//            zzle, zztw, zzug, zzla

public static final class mValue extends zzle
    implements com.google.android.gms.plus.model.people.ls
{

    public static final zzug CREATOR = new zzug();
    private static final HashMap zzauW;
    String mValue;
    final int zzFG;
    int zzJp;
    final Set zzauX;
    String zzawC;
    private final int zzawD;

    public int describeContents()
    {
        zzug zzug1 = CREATOR;
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
        return zzsp();
    }

    public String getLabel()
    {
        return zzawC;
    }

    public int getType()
    {
        return zzJp;
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean hasLabel()
    {
        return zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasType()
    {
        return zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasValue()
    {
        return zzauX.contains(Integer.valueOf(4));
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
        zzug zzug1 = CREATOR;
        zzug.zza(this, parcel, i);
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

        case 5: // '\005'
            return zzawC;

        case 6: // '\006'
            return Integer.valueOf(zzJp);

        case 4: // '\004'
            return mValue;
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

    public int zzso()
    {
        return 4;
    }

    public zzauW zzsp()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("label", zzl("label", 5));
        zzauW.put("type", zza("type", 6, (new zzla()).zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh("profile", 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
        zzauW.put("value", zzl("value", 4));
    }

    public Person.Urls()
    {
        zzawD = 4;
        zzFG = 1;
        zzauX = new HashSet();
    }

    zzauX(Set set, int i, String s, int j, String s1, int k)
    {
        zzawD = 4;
        zzauX = set;
        zzFG = i;
        zzawC = s;
        zzJp = j;
        mValue = s1;
    }
}
