// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzli, zzlj, zzlg

public class zzlh
    implements SafeParcelable
{
    public static class zza
        implements SafeParcelable
    {

        public static final zzlj CREATOR = new zzlj();
        final String className;
        final int versionCode;
        final ArrayList zzRc;

        private static ArrayList zzE(Map map)
        {
            if (map == null)
            {
                return null;
            }
            ArrayList arraylist = new ArrayList();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); arraylist.add(new zzb(s, (zzld.zza)map.get(s))))
            {
                s = (String)iterator.next();
            }

            return arraylist;
        }

        public int describeContents()
        {
            zzlj zzlj1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzlj zzlj1 = CREATOR;
            zzlj.zza(this, parcel, i);
        }

        HashMap zzjQ()
        {
            HashMap hashmap = new HashMap();
            int j = zzRc.size();
            for (int i = 0; i < j; i++)
            {
                zzb zzb1 = (zzb)zzRc.get(i);
                hashmap.put(zzb1.zzfv, zzb1.zzRd);
            }

            return hashmap;
        }


        zza(int i, String s, ArrayList arraylist)
        {
            versionCode = i;
            className = s;
            zzRc = arraylist;
        }

        zza(String s, Map map)
        {
            versionCode = 1;
            className = s;
            zzRc = zzE(map);
        }
    }

    public static class zzb
        implements SafeParcelable
    {

        public static final zzlg CREATOR = new zzlg();
        final int versionCode;
        final zzld.zza zzRd;
        final String zzfv;

        public int describeContents()
        {
            zzlg zzlg1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzlg zzlg1 = CREATOR;
            zzlg.zza(this, parcel, i);
        }


        zzb(int i, String s, zzld.zza zza1)
        {
            versionCode = i;
            zzfv = s;
            zzRd = zza1;
        }

        zzb(String s, zzld.zza zza1)
        {
            versionCode = 1;
            zzfv = s;
            zzRd = zza1;
        }
    }


    public static final zzli CREATOR = new zzli();
    private final int zzFG;
    private final HashMap zzQZ;
    private final ArrayList zzRa;
    private final String zzRb;

    zzlh(int i, ArrayList arraylist, String s)
    {
        zzFG = i;
        zzRa = null;
        zzQZ = zzc(arraylist);
        zzRb = (String)zzx.zzl(s);
        zzjM();
    }

    public zzlh(Class class1)
    {
        zzFG = 1;
        zzRa = null;
        zzQZ = new HashMap();
        zzRb = class1.getCanonicalName();
    }

    private static HashMap zzc(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            zza zza1 = (zza)arraylist.get(i);
            hashmap.put(zza1.className, zza1.zzjQ());
        }

        return hashmap;
    }

    public int describeContents()
    {
        zzli zzli1 = CREATOR;
        return 0;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = zzQZ.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            stringbuilder.append(((String) (obj))).append(":\n");
            obj = (Map)zzQZ.get(obj);
            Iterator iterator1 = ((Map) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                stringbuilder.append("  ").append(s).append(": ");
                stringbuilder.append(((Map) (obj)).get(s));
            }
        }

        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzli zzli1 = CREATOR;
        zzli.zza(this, parcel, i);
    }

    public void zza(Class class1, Map map)
    {
        zzQZ.put(class1.getCanonicalName(), map);
    }

    public boolean zzb(Class class1)
    {
        return zzQZ.containsKey(class1.getCanonicalName());
    }

    public Map zzbs(String s)
    {
        return (Map)zzQZ.get(s);
    }

    public void zzjM()
    {
        for (Iterator iterator = zzQZ.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            obj = (Map)zzQZ.get(obj);
            Iterator iterator1 = ((Map) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                ((zzld.zza)((Map) (obj)).get((String)iterator1.next())).zza(this);
            }
        }

    }

    public void zzjN()
    {
        String s;
        HashMap hashmap;
        for (Iterator iterator = zzQZ.keySet().iterator(); iterator.hasNext(); zzQZ.put(s, hashmap))
        {
            s = (String)iterator.next();
            Map map = (Map)zzQZ.get(s);
            hashmap = new HashMap();
            String s1;
            for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); hashmap.put(s1, ((zzld.zza)map.get(s1)).zzjC()))
            {
                s1 = (String)iterator1.next();
            }

        }

    }

    ArrayList zzjO()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = zzQZ.keySet().iterator(); iterator.hasNext(); arraylist.add(new zza(s, (Map)zzQZ.get(s))))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public String zzjP()
    {
        return zzRb;
    }

}
