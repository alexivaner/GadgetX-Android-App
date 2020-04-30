// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzlb, zzlc

public final class zzla
    implements SafeParcelable, zzld.zzb
{
    public static final class zza
        implements SafeParcelable
    {

        public static final zzlc CREATOR = new zzlc();
        final int versionCode;
        final String zzQN;
        final int zzQO;

        public int describeContents()
        {
            zzlc zzlc1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzlc zzlc1 = CREATOR;
            zzlc.zza(this, parcel, i);
        }


        zza(int i, String s, int j)
        {
            versionCode = i;
            zzQN = s;
            zzQO = j;
        }

        zza(String s, int i)
        {
            versionCode = 1;
            zzQN = s;
            zzQO = i;
        }
    }


    public static final zzlb CREATOR = new zzlb();
    private final int zzFG;
    private final HashMap zzQK;
    private final HashMap zzQL;
    private final ArrayList zzQM;

    public zzla()
    {
        zzFG = 1;
        zzQK = new HashMap();
        zzQL = new HashMap();
        zzQM = null;
    }

    zzla(int i, ArrayList arraylist)
    {
        zzFG = i;
        zzQK = new HashMap();
        zzQL = new HashMap();
        zzQM = null;
        zzb(arraylist);
    }

    private void zzb(ArrayList arraylist)
    {
        zza zza1;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); zzh(zza1.zzQN, zza1.zzQO))
        {
            zza1 = (zza)arraylist.next();
        }

    }

    public Object convertBack(Object obj)
    {
        return zzb((Integer)obj);
    }

    public int describeContents()
    {
        zzlb zzlb1 = CREATOR;
        return 0;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzlb zzlb1 = CREATOR;
        zzlb.zza(this, parcel, i);
    }

    public String zzb(Integer integer)
    {
        String s = (String)zzQL.get(integer);
        integer = s;
        if (s == null)
        {
            integer = s;
            if (zzQK.containsKey("gms_unknown"))
            {
                integer = "gms_unknown";
            }
        }
        return integer;
    }

    public zzla zzh(String s, int i)
    {
        zzQK.put(s, Integer.valueOf(i));
        zzQL.put(Integer.valueOf(i), s);
        return this;
    }

    ArrayList zzjw()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = zzQK.keySet().iterator(); iterator.hasNext(); arraylist.add(new zza(s, ((Integer)zzQK.get(s)).intValue())))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public int zzjx()
    {
        return 7;
    }

    public int zzjy()
    {
        return 0;
    }

}
