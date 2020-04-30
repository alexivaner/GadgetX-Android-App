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
//            zzle, zztw, zzud

public static final class zzawy extends zzle
    implements com.google.android.gms.plus.model.people.me
{

    public static final zzud CREATOR = new zzud();
    private static final HashMap zzauW;
    final int zzFG;
    final Set zzauX;
    String zzavv;
    String zzavy;
    String zzawv;
    String zzaww;
    String zzawx;
    String zzawy;

    public int describeContents()
    {
        zzud zzud1 = CREATOR;
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
        return zzsl();
    }

    public String getFamilyName()
    {
        return zzavv;
    }

    public String getFormatted()
    {
        return zzawv;
    }

    public String getGivenName()
    {
        return zzavy;
    }

    public String getHonorificPrefix()
    {
        return zzaww;
    }

    public String getHonorificSuffix()
    {
        return zzawx;
    }

    public String getMiddleName()
    {
        return zzawy;
    }

    public boolean hasFamilyName()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasFormatted()
    {
        return zzauX.contains(Integer.valueOf(3));
    }

    public boolean hasGivenName()
    {
        return zzauX.contains(Integer.valueOf(4));
    }

    public boolean hasHonorificPrefix()
    {
        return zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasHonorificSuffix()
    {
        return zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasMiddleName()
    {
        return zzauX.contains(Integer.valueOf(7));
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
        zzud zzud1 = CREATOR;
        zzud.zza(this, parcel, i);
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
            return zzavv;

        case 3: // '\003'
            return zzawv;

        case 4: // '\004'
            return zzavy;

        case 5: // '\005'
            return zzaww;

        case 6: // '\006'
            return zzawx;

        case 7: // '\007'
            return zzawy;
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

    public zzauW zzsl()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("familyName", zzl("familyName", 2));
        zzauW.put("formatted", zzl("formatted", 3));
        zzauW.put("givenName", zzl("givenName", 4));
        zzauW.put("honorificPrefix", zzl("honorificPrefix", 5));
        zzauW.put("honorificSuffix", zzl("honorificSuffix", 6));
        zzauW.put("middleName", zzl("middleName", 7));
    }

    public Person.Name()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    zzauX(Set set, int i, String s, String s1, String s2, String s3, String s4, 
            String s5)
    {
        zzauX = set;
        zzFG = i;
        zzavv = s;
        zzawv = s1;
        zzavy = s2;
        zzaww = s3;
        zzawx = s4;
        zzawy = s5;
    }
}
