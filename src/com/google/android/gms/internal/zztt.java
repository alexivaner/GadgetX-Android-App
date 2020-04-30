// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzle, zztu, zztr

public final class zztt extends zzle
    implements Moment
{

    public static final zztu CREATOR = new zztu();
    private static final HashMap zzauW;
    String zzFA;
    final int zzFG;
    final Set zzauX;
    String zzavK;
    zztr zzavS;
    zztr zzavT;
    String zzxV;

    public zztt()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    zztt(Set set, int i, String s, zztr zztr1, String s1, zztr zztr2, String s2)
    {
        zzauX = set;
        zzFG = i;
        zzFA = s;
        zzavS = zztr1;
        zzavK = s1;
        zzavT = zztr2;
        zzxV = s2;
    }

    public zztt(Set set, String s, zztr zztr1, String s1, zztr zztr2, String s2)
    {
        zzauX = set;
        zzFG = 1;
        zzFA = s;
        zzavS = zztr1;
        zzavK = s1;
        zzavT = zztr2;
        zzxV = s2;
    }

    public int describeContents()
    {
        zztu zztu1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof zztt))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (zztt)obj;
            zzld.zza zza1;
label1:
            do
            {
                for (Iterator iterator = zzauW.values().iterator(); iterator.hasNext();)
                {
                    zza1 = (zzld.zza)iterator.next();
                    if (!zza(zza1))
                    {
                        continue label1;
                    }
                    if (((zztt) (obj)).zza(zza1))
                    {
                        if (!zzb(zza1).equals(((zztt) (obj)).zzb(zza1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zztt) (obj)).zza(zza1));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzsd();
    }

    public String getId()
    {
        return zzFA;
    }

    public ItemScope getResult()
    {
        return zzavS;
    }

    public String getStartDate()
    {
        return zzavK;
    }

    public ItemScope getTarget()
    {
        return zzavT;
    }

    public String getType()
    {
        return zzxV;
    }

    public boolean hasId()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasResult()
    {
        return zzauX.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate()
    {
        return zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasTarget()
    {
        return zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasType()
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
            zzld.zza zza1 = (zzld.zza)iterator.next();
            if (zza(zza1))
            {
                int j = zza1.zzjG();
                i = zzb(zza1).hashCode() + (i + j);
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
        zztu zztu1 = CREATOR;
        zztu.zza(this, parcel, i);
    }

    protected boolean zza(zzld.zza zza1)
    {
        return zzauX.contains(Integer.valueOf(zza1.zzjG()));
    }

    protected Object zzb(zzld.zza zza1)
    {
        switch (zza1.zzjG())
        {
        case 3: // '\003'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zza1.zzjG()).toString());

        case 2: // '\002'
            return zzFA;

        case 4: // '\004'
            return zzavS;

        case 5: // '\005'
            return zzavK;

        case 6: // '\006'
            return zzavT;

        case 7: // '\007'
            return zzxV;
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

    public zztt zzsd()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("id", zzld.zza.zzl("id", 2));
        zzauW.put("result", zzld.zza.zza("result", 4, com/google/android/gms/internal/zztr));
        zzauW.put("startDate", zzld.zza.zzl("startDate", 5));
        zzauW.put("target", zzld.zza.zza("target", 6, com/google/android/gms/internal/zztr));
        zzauW.put("type", zzld.zza.zzl("type", 7));
    }
}
