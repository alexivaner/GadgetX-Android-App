// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzwn

public final class zzwm
{
    public static class zza
    {

        public final zzwn zzaGQ;
        public final List zzaGR;

        public zza(zzwn zzwn1, List list)
        {
            zzaGQ = zzwn1;
            zzaGR = list;
        }
    }


    private static int zza(String s, zzwn.zza.zza azza[])
    {
        int i;
        int j;
        int l;
        l = azza.length;
        i = 0;
        j = 14;
_L5:
        zzwn.zza.zza zza1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        zza1 = azza[i];
        if (j != 14) goto _L2; else goto _L1
_L1:
        if (zza1.type != 9 && zza1.type != 2 && zza1.type != 6) goto _L4; else goto _L3
_L3:
        int k = zza1.type;
_L7:
        i++;
        j = k;
          goto _L5
_L4:
        k = j;
        if (zza1.type == 14) goto _L7; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Unexpected TypedValue type: ").append(zza1.type).append(" for key ").append(s).toString());
_L2:
        k = j;
        if (zza1.type == j) goto _L7; else goto _L8
_L8:
        throw new IllegalArgumentException((new StringBuilder()).append("The ArrayList elements should all be the same type, but ArrayList with key ").append(s).append(" contains items of type ").append(j).append(" and ").append(zza1.type).toString());
        return j;
    }

    static int zza(List list, Asset asset)
    {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap datamap)
    {
        zzwn zzwn1 = new zzwn();
        ArrayList arraylist = new ArrayList();
        zzwn1.zzaGS = zza(datamap, ((List) (arraylist)));
        return new zza(zzwn1, arraylist);
    }

    private static zzwn.zza.zza zza(List list, Object obj)
    {
        zzwn.zza.zza zza1;
        zza1 = new zzwn.zza.zza();
        if (obj == null)
        {
            zza1.type = 14;
            return zza1;
        }
        zza1.zzaGW = new zzwn.zza.zza.zza();
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        zza1.type = 2;
        zza1.zzaGW.zzaGY = (String)obj;
_L8:
        return zza1;
_L2:
        ArrayList arraylist;
        zzwn.zza.zza azza1[];
        int j;
        int k;
        int l;
        if (obj instanceof Integer)
        {
            zza1.type = 6;
            zza1.zzaGW.zzaHc = ((Integer)obj).intValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Long)
        {
            zza1.type = 5;
            zza1.zzaGW.zzaHb = ((Long)obj).longValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Double)
        {
            zza1.type = 3;
            zza1.zzaGW.zzaGZ = ((Double)obj).doubleValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Float)
        {
            zza1.type = 4;
            zza1.zzaGW.zzaHa = ((Float)obj).floatValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Boolean)
        {
            zza1.type = 8;
            zza1.zzaGW.zzaHe = ((Boolean)obj).booleanValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Byte)
        {
            zza1.type = 7;
            zza1.zzaGW.zzaHd = ((Byte)obj).byteValue();
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof byte[])
        {
            zza1.type = 1;
            zza1.zzaGW.zzaGX = (byte[])(byte[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof String[])
        {
            zza1.type = 11;
            zza1.zzaGW.zzaHh = (String[])(String[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof long[])
        {
            zza1.type = 12;
            zza1.zzaGW.zzaHi = (long[])(long[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof float[])
        {
            zza1.type = 15;
            zza1.zzaGW.zzaHj = (float[])(float[])obj;
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Asset)
        {
            zza1.type = 13;
            zza1.zzaGW.zzaHk = zza(list, (Asset)obj);
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof DataMap)
        {
            zza1.type = 9;
            obj = (DataMap)obj;
            Object obj2 = ((DataMap) (obj)).keySet();
            zzwn.zza azza[] = new zzwn.zza[((Set) (obj2)).size()];
            obj2 = ((Set) (obj2)).iterator();
            for (int i = 0; ((Iterator) (obj2)).hasNext(); i++)
            {
                String s = (String)((Iterator) (obj2)).next();
                azza[i] = new zzwn.zza();
                azza[i].name = s;
                azza[i].zzaGU = zza(list, ((DataMap) (obj)).get(s));
            }

            zza1.zzaGW.zzaHf = azza;
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof ArrayList))
        {
            break; /* Loop/switch isn't completed */
        }
        zza1.type = 10;
        arraylist = (ArrayList)obj;
        azza1 = new zzwn.zza.zza[arraylist.size()];
        obj = null;
        l = arraylist.size();
        k = 0;
        j = 14;
_L4:
        Object obj1;
        zzwn.zza.zza zza2;
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_740;
        }
        obj1 = arraylist.get(k);
        zza2 = zza(list, obj1);
        if (zza2.type != 14 && zza2.type != 2 && zza2.type != 6 && zza2.type != 9)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a ").append(obj1.getClass()).toString());
        }
        if (j != 14 || zza2.type == 14)
        {
            break; /* Loop/switch isn't completed */
        }
        j = zza2.type;
        obj = obj1;
_L6:
        azza1[k] = zza2;
        k++;
        if (true) goto _L4; else goto _L3
_L3:
        if (zza2.type == j) goto _L6; else goto _L5
_L5:
        throw new IllegalArgumentException((new StringBuilder()).append("ArrayList elements must all be of the sameclass, but this one contains a ").append(obj.getClass()).append(" and a ").append(obj1.getClass()).toString());
        zza1.zzaGW.zzaHg = azza1;
        if (true) goto _L8; else goto _L7
_L7:
        throw new RuntimeException((new StringBuilder()).append("newFieldValueFromValue: unexpected value ").append(obj.getClass().getSimpleName()).toString());
    }

    public static DataMap zza(zza zza1)
    {
        DataMap datamap = new DataMap();
        zzwn.zza azza[] = zza1.zzaGQ.zzaGS;
        int j = azza.length;
        for (int i = 0; i < j; i++)
        {
            zzwn.zza zza2 = azza[i];
            zza(zza1.zzaGR, datamap, zza2.name, zza2.zzaGU);
        }

        return datamap;
    }

    private static ArrayList zza(List list, zzwn.zza.zza.zza zza1, int i)
    {
        ArrayList arraylist = new ArrayList(zza1.zzaHg.length);
        zza1 = zza1.zzaHg;
        int l = zza1.length;
        int j = 0;
        while (j < l) 
        {
            zzwn.zza azza[] = zza1[j];
            if (((zzwn.zza.zza) (azza)).type == 14)
            {
                arraylist.add(null);
            } else
            if (i == 9)
            {
                DataMap datamap = new DataMap();
                azza = ((zzwn.zza.zza) (azza)).zzaGW.zzaHf;
                int i1 = azza.length;
                for (int k = 0; k < i1; k++)
                {
                    zzwn.zza zza2 = azza[k];
                    zza(list, datamap, zza2.name, zza2.zzaGU);
                }

                arraylist.add(datamap);
            } else
            if (i == 2)
            {
                arraylist.add(((zzwn.zza.zza) (azza)).zzaGW.zzaGY);
            } else
            if (i == 6)
            {
                arraylist.add(Integer.valueOf(((zzwn.zza.zza) (azza)).zzaGW.zzaHc));
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected typeOfArrayList: ").append(i).toString());
            }
            j++;
        }
        return arraylist;
    }

    private static void zza(List list, DataMap datamap, String s, zzwn.zza.zza zza1)
    {
        int i = zza1.type;
        if (i == 14)
        {
            datamap.putString(s, null);
            return;
        }
        Object obj = zza1.zzaGW;
        if (i == 1)
        {
            datamap.putByteArray(s, ((zzwn.zza.zza.zza) (obj)).zzaGX);
            return;
        }
        if (i == 11)
        {
            datamap.putStringArray(s, ((zzwn.zza.zza.zza) (obj)).zzaHh);
            return;
        }
        if (i == 12)
        {
            datamap.putLongArray(s, ((zzwn.zza.zza.zza) (obj)).zzaHi);
            return;
        }
        if (i == 15)
        {
            datamap.putFloatArray(s, ((zzwn.zza.zza.zza) (obj)).zzaHj);
            return;
        }
        if (i == 2)
        {
            datamap.putString(s, ((zzwn.zza.zza.zza) (obj)).zzaGY);
            return;
        }
        if (i == 3)
        {
            datamap.putDouble(s, ((zzwn.zza.zza.zza) (obj)).zzaGZ);
            return;
        }
        if (i == 4)
        {
            datamap.putFloat(s, ((zzwn.zza.zza.zza) (obj)).zzaHa);
            return;
        }
        if (i == 5)
        {
            datamap.putLong(s, ((zzwn.zza.zza.zza) (obj)).zzaHb);
            return;
        }
        if (i == 6)
        {
            datamap.putInt(s, ((zzwn.zza.zza.zza) (obj)).zzaHc);
            return;
        }
        if (i == 7)
        {
            datamap.putByte(s, (byte)((zzwn.zza.zza.zza) (obj)).zzaHd);
            return;
        }
        if (i == 8)
        {
            datamap.putBoolean(s, ((zzwn.zza.zza.zza) (obj)).zzaHe);
            return;
        }
        if (i == 13)
        {
            if (list == null)
            {
                throw new RuntimeException((new StringBuilder()).append("populateBundle: unexpected type for: ").append(s).toString());
            } else
            {
                datamap.putAsset(s, (Asset)list.get((int)((zzwn.zza.zza.zza) (obj)).zzaHk));
                return;
            }
        }
        if (i == 9)
        {
            zza1 = new DataMap();
            obj = ((zzwn.zza.zza.zza) (obj)).zzaHf;
            int j = obj.length;
            for (i = 0; i < j; i++)
            {
                Object obj1 = obj[i];
                zza(list, ((DataMap) (zza1)), ((zzwn.zza) (obj1)).name, ((zzwn.zza) (obj1)).zzaGU);
            }

            datamap.putDataMap(s, zza1);
            return;
        }
        if (i == 10)
        {
            i = zza(s, ((zzwn.zza.zza.zza) (obj)).zzaHg);
            list = zza(list, ((zzwn.zza.zza.zza) (obj)), i);
            if (i == 14)
            {
                datamap.putStringArrayList(s, list);
                return;
            }
            if (i == 9)
            {
                datamap.putDataMapArrayList(s, list);
                return;
            }
            if (i == 2)
            {
                datamap.putStringArrayList(s, list);
                return;
            }
            if (i == 6)
            {
                datamap.putIntegerArrayList(s, list);
                return;
            } else
            {
                throw new IllegalStateException((new StringBuilder()).append("Unexpected typeOfArrayList: ").append(i).toString());
            }
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("populateBundle: unexpected type ").append(i).toString());
        }
    }

    private static zzwn.zza[] zza(DataMap datamap, List list)
    {
        Object obj = datamap.keySet();
        zzwn.zza azza[] = new zzwn.zza[((Set) (obj)).size()];
        obj = ((Set) (obj)).iterator();
        for (int i = 0; ((Iterator) (obj)).hasNext(); i++)
        {
            String s = (String)((Iterator) (obj)).next();
            Object obj1 = datamap.get(s);
            azza[i] = new zzwn.zza();
            azza[i].name = s;
            azza[i].zzaGU = zza(list, obj1);
        }

        return azza;
    }
}
