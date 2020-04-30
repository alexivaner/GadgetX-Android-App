// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzde;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzb

public class zzvl
{
    public static class zza
    {

        private final zzd.zza zzaAo;
        private final Map zzaCj;

        public static zzb zzuu()
        {
            return new zzb();
        }

        public String toString()
        {
            return (new StringBuilder()).append("Properties: ").append(zzuv()).append(" pushAfterEvaluate: ").append(zzaAo).toString();
        }

        public void zza(String s, zzd.zza zza1)
        {
            zzaCj.put(s, zza1);
        }

        public zzd.zza zztK()
        {
            return zzaAo;
        }

        public Map zzuv()
        {
            return Collections.unmodifiableMap(zzaCj);
        }

        private zza(Map map, zzd.zza zza1)
        {
            zzaCj = map;
            zzaAo = zza1;
        }

    }

    public static class zzb
    {

        private zzd.zza zzaAo;
        private final Map zzaCj;

        public zzb zzb(String s, zzd.zza zza1)
        {
            zzaCj.put(s, zza1);
            return this;
        }

        public zzb zzq(zzd.zza zza1)
        {
            zzaAo = zza1;
            return this;
        }

        public zza zzuw()
        {
            return new zza(zzaCj, zzaAo);
        }

        private zzb()
        {
            zzaCj = new HashMap();
        }

    }

    public static class zzc
    {

        private final String zzYw;
        private final List zzaCk;
        private final Map zzaCl;
        private final int zzaCm;

        public static zzd zzux()
        {
            return new zzd();
        }

        public String getVersion()
        {
            return zzYw;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Rules: ").append(zzuy()).append("  Macros: ").append(zzaCl).toString();
        }

        public List zzuy()
        {
            return zzaCk;
        }

        public Map zzuz()
        {
            return zzaCl;
        }

        private zzc(List list, Map map, String s, int i)
        {
            zzaCk = Collections.unmodifiableList(list);
            zzaCl = Collections.unmodifiableMap(map);
            zzYw = s;
            zzaCm = i;
        }

    }

    public static class zzd
    {

        private String zzYw;
        private final List zzaCk;
        private final Map zzaCl;
        private int zzaCm;

        public zzd zzb(zze zze1)
        {
            zzaCk.add(zze1);
            return this;
        }

        public zzd zzc(zza zza1)
        {
            String s = zzde.zzg((zzd.zza)zza1.zzuv().get(com.google.android.gms.internal.zzb.zzdf.toString()));
            List list = (List)zzaCl.get(s);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                zzaCl.put(s, obj);
            }
            ((List) (obj)).add(zza1);
            return this;
        }

        public zzd zzdy(String s)
        {
            zzYw = s;
            return this;
        }

        public zzd zzhk(int i)
        {
            zzaCm = i;
            return this;
        }

        public zzc zzuA()
        {
            return new zzc(zzaCk, zzaCl, zzYw, zzaCm);
        }

        private zzd()
        {
            zzaCk = new ArrayList();
            zzaCl = new HashMap();
            zzYw = "";
            zzaCm = 0;
        }

    }

    public static class zze
    {

        private final List zzaCn;
        private final List zzaCo;
        private final List zzaCp;
        private final List zzaCq;
        private final List zzaCr;
        private final List zzaCs;
        private final List zzaCt;
        private final List zzaCu;
        private final List zzaCv;
        private final List zzaCw;

        public static zzf zzuB()
        {
            return new zzf();
        }

        public String toString()
        {
            return (new StringBuilder()).append("Positive predicates: ").append(zzuC()).append("  Negative predicates: ").append(zzuD()).append("  Add tags: ").append(zzuE()).append("  Remove tags: ").append(zzuF()).append("  Add macros: ").append(zzuG()).append("  Remove macros: ").append(zzuL()).toString();
        }

        public List zzuC()
        {
            return zzaCn;
        }

        public List zzuD()
        {
            return zzaCo;
        }

        public List zzuE()
        {
            return zzaCp;
        }

        public List zzuF()
        {
            return zzaCq;
        }

        public List zzuG()
        {
            return zzaCr;
        }

        public List zzuH()
        {
            return zzaCt;
        }

        public List zzuI()
        {
            return zzaCu;
        }

        public List zzuJ()
        {
            return zzaCv;
        }

        public List zzuK()
        {
            return zzaCw;
        }

        public List zzuL()
        {
            return zzaCs;
        }

        private zze(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
                List list7, List list8, List list9)
        {
            zzaCn = Collections.unmodifiableList(list);
            zzaCo = Collections.unmodifiableList(list1);
            zzaCp = Collections.unmodifiableList(list2);
            zzaCq = Collections.unmodifiableList(list3);
            zzaCr = Collections.unmodifiableList(list4);
            zzaCs = Collections.unmodifiableList(list5);
            zzaCt = Collections.unmodifiableList(list6);
            zzaCu = Collections.unmodifiableList(list7);
            zzaCv = Collections.unmodifiableList(list8);
            zzaCw = Collections.unmodifiableList(list9);
        }

    }

    public static class zzf
    {

        private final List zzaCn;
        private final List zzaCo;
        private final List zzaCp;
        private final List zzaCq;
        private final List zzaCr;
        private final List zzaCs;
        private final List zzaCt;
        private final List zzaCu;
        private final List zzaCv;
        private final List zzaCw;

        public zzf zzd(zza zza1)
        {
            zzaCn.add(zza1);
            return this;
        }

        public zzf zzdA(String s)
        {
            zzaCw.add(s);
            return this;
        }

        public zzf zzdB(String s)
        {
            zzaCt.add(s);
            return this;
        }

        public zzf zzdC(String s)
        {
            zzaCu.add(s);
            return this;
        }

        public zzf zzdz(String s)
        {
            zzaCv.add(s);
            return this;
        }

        public zzf zze(zza zza1)
        {
            zzaCo.add(zza1);
            return this;
        }

        public zzf zzf(zza zza1)
        {
            zzaCp.add(zza1);
            return this;
        }

        public zzf zzg(zza zza1)
        {
            zzaCq.add(zza1);
            return this;
        }

        public zzf zzh(zza zza1)
        {
            zzaCr.add(zza1);
            return this;
        }

        public zzf zzi(zza zza1)
        {
            zzaCs.add(zza1);
            return this;
        }

        public zze zzuM()
        {
            return new zze(zzaCn, zzaCo, zzaCp, zzaCq, zzaCr, zzaCs, zzaCt, zzaCu, zzaCv, zzaCw);
        }

        private zzf()
        {
            zzaCn = new ArrayList();
            zzaCo = new ArrayList();
            zzaCp = new ArrayList();
            zzaCq = new ArrayList();
            zzaCr = new ArrayList();
            zzaCs = new ArrayList();
            zzaCt = new ArrayList();
            zzaCu = new ArrayList();
            zzaCv = new ArrayList();
            zzaCw = new ArrayList();
        }

    }

    public static class zzg extends Exception
    {

        public zzg(String s)
        {
            super(s);
        }
    }


    private static zzd.zza zza(int i, zzc.zzf zzf1, zzd.zza azza[], Set set)
        throws zzg
    {
        Object obj;
        zzd.zza zza1;
        int j1;
        int i2;
        int l2;
        i2 = 0;
        l2 = 0;
        j1 = 0;
        if (set.contains(Integer.valueOf(i)))
        {
            zzdw((new StringBuilder()).append("Value cycle detected.  Current value reference: ").append(i).append(".").append("  Previous value references: ").append(set).append(".").toString());
        }
        zza1 = (zzd.zza)zza(((Object []) (zzf1.zzfG)), i, "values");
        if (azza[i] != null)
        {
            return azza[i];
        }
        obj = null;
        set.add(Integer.valueOf(i));
        zza1.type;
        JVM INSTR tableswitch 1 8: default 152
    //                   1 653
    //                   2 199
    //                   3 291
    //                   4 525
    //                   5 653
    //                   6 653
    //                   7 557
    //                   8 653;
           goto _L1 _L2 _L3 _L4 _L5 _L2 _L2 _L6 _L2
_L1:
        if (obj == null)
        {
            zzdw((new StringBuilder()).append("Invalid value: ").append(zza1).toString());
        }
        azza[i] = ((zzd.zza) (obj));
        set.remove(Integer.valueOf(i));
        return ((zzd.zza) (obj));
_L3:
        obj = zzp(zza1);
        zzd.zza zza2 = zzo(zza1);
        zza2.zzgw = new zzd.zza[((zzc.zzh) (obj)).zzgh.length];
        int ai[] = ((zzc.zzh) (obj)).zzgh;
        i2 = ai.length;
        int j = 0;
        do
        {
            obj = zza2;
            if (j1 >= i2)
            {
                continue; /* Loop/switch isn't completed */
            }
            l2 = ai[j1];
            zza2.zzgw[j] = zza(l2, zzf1, azza, set);
            j1++;
            j++;
        } while (true);
_L4:
        zzd.zza zza3 = zzo(zza1);
        obj = zzp(zza1);
        if (((zzc.zzh) (obj)).zzgi.length != ((zzc.zzh) (obj)).zzgj.length)
        {
            zzdw((new StringBuilder()).append("Uneven map keys (").append(((zzc.zzh) (obj)).zzgi.length).append(") and map values (").append(((zzc.zzh) (obj)).zzgj.length).append(")").toString());
        }
        zza3.zzgx = new zzd.zza[((zzc.zzh) (obj)).zzgi.length];
        zza3.zzgy = new zzd.zza[((zzc.zzh) (obj)).zzgi.length];
        int ai1[] = ((zzc.zzh) (obj)).zzgi;
        l2 = ai1.length;
        int k1 = 0;
        for (int k = 0; k1 < l2; k++)
        {
            int j3 = ai1[k1];
            zza3.zzgx[k] = zza(j3, zzf1, azza, set);
            k1++;
        }

        ai1 = ((zzc.zzh) (obj)).zzgj;
        l2 = ai1.length;
        int l = 0;
        k1 = i2;
        do
        {
            obj = zza3;
            if (k1 >= l2)
            {
                continue; /* Loop/switch isn't completed */
            }
            int j2 = ai1[k1];
            zza3.zzgy[l] = zza(j2, zzf1, azza, set);
            k1++;
            l++;
        } while (true);
_L5:
        obj = zzo(zza1);
        obj.zzgz = zzde.zzg(zza(zzp(zza1).zzgm, zzf1, azza, set));
        continue; /* Loop/switch isn't completed */
_L6:
        zzd.zza zza4 = zzo(zza1);
        obj = zzp(zza1);
        zza4.zzgD = new zzd.zza[((zzc.zzh) (obj)).zzgl.length];
        int ai2[] = ((zzc.zzh) (obj)).zzgl;
        int k2 = ai2.length;
        int i1 = 0;
        int l1 = l2;
        do
        {
            obj = zza4;
            if (l1 >= k2)
            {
                continue; /* Loop/switch isn't completed */
            }
            int i3 = ai2[l1];
            zza4.zzgD[i1] = zza(i3, zzf1, azza, set);
            l1++;
            i1++;
        } while (true);
_L2:
        obj = zza1;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private static zza zza(zzc.zzb zzb1, zzc.zzf zzf1, zzd.zza azza[], int i)
        throws zzg
    {
        zzb zzb2 = zza.zzuu();
        zzb1 = zzb1.zzfq;
        int j = zzb1.length;
        i = 0;
        while (i < j) 
        {
            int k = zzb1[i];
            Object obj = (zzc.zze)zza(((Object []) (zzf1.zzfH)), Integer.valueOf(k).intValue(), "properties");
            String s = (String)zza(((Object []) (zzf1.zzfF)), ((zzc.zze) (obj)).key, "keys");
            obj = (zzd.zza)zza(((Object []) (azza)), ((zzc.zze) (obj)).value, "values");
            if (com.google.android.gms.internal.zzb.zzec.toString().equals(s))
            {
                zzb2.zzq(((zzd.zza) (obj)));
            } else
            {
                zzb2.zzb(s, ((zzd.zza) (obj)));
            }
            i++;
        }
        return zzb2.zzuw();
    }

    private static zze zza(zzc.zzg zzg1, List list, List list1, List list2, zzc.zzf zzf1)
    {
        zzf zzf2 = zze.zzuB();
        int ai[] = zzg1.zzfV;
        int k2 = ai.length;
        for (int i = 0; i < k2; i++)
        {
            zzf2.zzd((zza)list2.get(Integer.valueOf(ai[i]).intValue()));
        }

        ai = zzg1.zzfW;
        k2 = ai.length;
        for (int j = 0; j < k2; j++)
        {
            zzf2.zze((zza)list2.get(Integer.valueOf(ai[j]).intValue()));
        }

        list2 = zzg1.zzfX;
        k2 = list2.length;
        for (int k = 0; k < k2; k++)
        {
            zzf2.zzf((zza)list.get(Integer.valueOf(list2[k]).intValue()));
        }

        list2 = zzg1.zzfZ;
        k2 = list2.length;
        for (int l = 0; l < k2; l++)
        {
            int l2 = list2[l];
            zzf2.zzdz(zzf1.zzfG[Integer.valueOf(l2).intValue()].zzgv);
        }

        list2 = zzg1.zzfY;
        k2 = list2.length;
        for (int i1 = 0; i1 < k2; i1++)
        {
            zzf2.zzg((zza)list.get(Integer.valueOf(list2[i1]).intValue()));
        }

        list = zzg1.zzga;
        k2 = list.length;
        for (int j1 = 0; j1 < k2; j1++)
        {
            int i3 = list[j1];
            zzf2.zzdA(zzf1.zzfG[Integer.valueOf(i3).intValue()].zzgv);
        }

        list = zzg1.zzgb;
        k2 = list.length;
        for (int k1 = 0; k1 < k2; k1++)
        {
            zzf2.zzh((zza)list1.get(Integer.valueOf(list[k1]).intValue()));
        }

        list = zzg1.zzgd;
        k2 = list.length;
        for (int l1 = 0; l1 < k2; l1++)
        {
            int j3 = list[l1];
            zzf2.zzdB(zzf1.zzfG[Integer.valueOf(j3).intValue()].zzgv);
        }

        list = zzg1.zzgc;
        k2 = list.length;
        for (int i2 = 0; i2 < k2; i2++)
        {
            zzf2.zzi((zza)list1.get(Integer.valueOf(list[i2]).intValue()));
        }

        zzg1 = zzg1.zzge;
        k2 = zzg1.length;
        for (int j2 = 0; j2 < k2; j2++)
        {
            int k3 = zzg1[j2];
            zzf2.zzdC(zzf1.zzfG[Integer.valueOf(k3).intValue()].zzgv);
        }

        return zzf2.zzuM();
    }

    private static Object zza(Object aobj[], int i, String s)
        throws zzg
    {
        if (i < 0 || i >= aobj.length)
        {
            zzdw((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return aobj[i];
    }

    public static zzc zzb(zzc.zzf zzf1)
        throws zzg
    {
        boolean flag = false;
        Object aobj[] = new zzd.zza[zzf1.zzfG.length];
        for (int i = 0; i < zzf1.zzfG.length; i++)
        {
            zza(i, zzf1, ((zzd.zza []) (aobj)), new HashSet(0));
        }

        zzd zzd1 = zzc.zzux();
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < zzf1.zzfJ.length; j++)
        {
            arraylist.add(zza(zzf1.zzfJ[j], zzf1, ((zzd.zza []) (aobj)), j));
        }

        ArrayList arraylist1 = new ArrayList();
        for (int k = 0; k < zzf1.zzfK.length; k++)
        {
            arraylist1.add(zza(zzf1.zzfK[k], zzf1, ((zzd.zza []) (aobj)), k));
        }

        ArrayList arraylist2 = new ArrayList();
        for (int l = 0; l < zzf1.zzfI.length; l++)
        {
            zza zza1 = zza(zzf1.zzfI[l], zzf1, ((zzd.zza []) (aobj)), l);
            zzd1.zzc(zza1);
            arraylist2.add(zza1);
        }

        aobj = zzf1.zzfL;
        int j1 = aobj.length;
        for (int i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
        {
            zzd1.zzb(zza(aobj[i1], arraylist, arraylist2, arraylist1, zzf1));
        }

        zzd1.zzdy(zzf1.version);
        zzd1.zzhk(zzf1.zzfT);
        return zzd1.zzuA();
    }

    public static void zzc(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }

    private static void zzdw(String s)
        throws zzg
    {
        zzbf.zzZ(s);
        throw new zzg(s);
    }

    public static zzd.zza zzo(zzd.zza zza1)
    {
        zzd.zza zza2 = new zzd.zza();
        zza2.type = zza1.type;
        zza2.zzgE = (int[])zza1.zzgE.clone();
        if (zza1.zzgF)
        {
            zza2.zzgF = zza1.zzgF;
        }
        return zza2;
    }

    private static zzc.zzh zzp(zzd.zza zza1)
        throws zzg
    {
        if ((zzc.zzh)zza1.zza(zzc.zzh.zzgf) == null)
        {
            zzdw((new StringBuilder()).append("Expected a ServingValue and didn't get one. Value is: ").append(zza1).toString());
        }
        return (zzc.zzh)zza1.zza(zzc.zzh.zzgf);
    }
}
