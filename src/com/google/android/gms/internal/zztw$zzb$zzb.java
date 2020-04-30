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
//            zzle, zztw, zzub

public static final class zzli extends zzle
    implements com.google.android.gms.plus.model.people.CoverPhoto
{

    public static final zzub CREATOR = new zzub();
    private static final HashMap zzauW;
    final int zzFG;
    final Set zzauX;
    int zzli;
    int zzlj;
    String zzxX;

    public int describeContents()
    {
        zzub zzub1 = CREATOR;
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
        return zzsj();
    }

    public int getHeight()
    {
        return zzlj;
    }

    public String getUrl()
    {
        return zzxX;
    }

    public int getWidth()
    {
        return zzli;
    }

    public boolean hasHeight()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasUrl()
    {
        return zzauX.contains(Integer.valueOf(3));
    }

    public boolean hasWidth()
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
        zzub zzub1 = CREATOR;
        zzub.zza(this, parcel, i);
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
            return Integer.valueOf(zzlj);

        case 3: // '\003'
            return zzxX;

        case 4: // '\004'
            return Integer.valueOf(zzli);
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

    public zzauW zzsj()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("height", zzauW("height", 2));
        zzauW.put("url", zzauW("url", 3));
        zzauW.put("width", zzauW("width", 4));
    }

    public on.Cover.CoverPhoto()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    zzauX(Set set, int i, int j, String s, int k)
    {
        zzauX = set;
        zzFG = i;
        zzlj = j;
        zzxX = s;
        zzli = k;
    }
}
