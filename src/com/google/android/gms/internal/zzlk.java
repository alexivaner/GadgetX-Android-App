// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzld, zzll, zzlh, zzma, 
//            zzlt, zzmb, zzls

public class zzlk extends zzld
    implements SafeParcelable
{

    public static final zzll CREATOR = new zzll();
    private final String mClassName;
    private final int zzFG;
    private final zzlh zzQX;
    private final Parcel zzRe;
    private final int zzRf;
    private int zzRg;
    private int zzRh;

    zzlk(int i, Parcel parcel, zzlh zzlh1)
    {
        zzFG = i;
        zzRe = (Parcel)zzx.zzl(parcel);
        zzRf = 2;
        zzQX = zzlh1;
        if (zzQX == null)
        {
            mClassName = null;
        } else
        {
            mClassName = zzQX.zzjP();
        }
        zzRg = 2;
    }

    private zzlk(SafeParcelable safeparcelable, zzlh zzlh1, String s)
    {
        zzFG = 1;
        zzRe = Parcel.obtain();
        safeparcelable.writeToParcel(zzRe, 0);
        zzRf = 1;
        zzQX = (zzlh)zzx.zzl(zzlh1);
        mClassName = (String)zzx.zzl(s);
        zzRg = 2;
    }

    private static HashMap zzF(Map map)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(Integer.valueOf(((zzld.zza)entry.getValue()).zzjG()), entry))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return hashmap;
    }

    public static zzlk zza(zzld zzld1)
    {
        String s = zzld1.getClass().getCanonicalName();
        zzlh zzlh1 = zzb(zzld1);
        return new zzlk((SafeParcelable)zzld1, zzlh1, s);
    }

    private static void zza(zzlh zzlh1, zzld zzld1)
    {
        Object obj = zzld1.getClass();
        if (!zzlh1.zzb(((Class) (obj))))
        {
            Map map = zzld1.zzjz();
            zzlh1.zza(((Class) (obj)), map);
            obj = map.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                zzld1 = (zzld.zza)map.get((String)((Iterator) (obj)).next());
                Class class1 = zzld1.zzjH();
                if (class1 != null)
                {
                    try
                    {
                        zza(zzlh1, (zzld)class1.newInstance());
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzlh zzlh1)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Could not instantiate an object of type ").append(zzld1.zzjH().getCanonicalName()).toString(), zzlh1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzlh zzlh1)
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Could not access object of type ").append(zzld1.zzjH().getCanonicalName()).toString(), zzlh1);
                    }
                }
            } while (true);
        }
    }

    private void zza(StringBuilder stringbuilder, int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown type = ").append(i).toString());

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            stringbuilder.append(obj);
            return;

        case 7: // '\007'
            stringbuilder.append("\"").append(zzma.zzbt(obj.toString())).append("\"");
            return;

        case 8: // '\b'
            stringbuilder.append("\"").append(zzlt.zze((byte[])(byte[])obj)).append("\"");
            return;

        case 9: // '\t'
            stringbuilder.append("\"").append(zzlt.zzf((byte[])(byte[])obj));
            stringbuilder.append("\"");
            return;

        case 10: // '\n'
            com.google.android.gms.internal.zzmb.zza(stringbuilder, (HashMap)obj);
            return;

        case 11: // '\013'
            throw new IllegalArgumentException("Method does not accept concrete type.");
        }
    }

    private void zza(StringBuilder stringbuilder, zzld.zza zza1, Parcel parcel, int i)
    {
        switch (zza1.zzjy())
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown field out type = ").append(zza1.zzjy()).toString());

        case 0: // '\0'
            zzb(stringbuilder, zza1, zza(zza1, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i))));
            return;

        case 1: // '\001'
            zzb(stringbuilder, zza1, zza(zza1, com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i)));
            return;

        case 2: // '\002'
            zzb(stringbuilder, zza1, zza(zza1, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i))));
            return;

        case 3: // '\003'
            zzb(stringbuilder, zza1, zza(zza1, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i))));
            return;

        case 4: // '\004'
            zzb(stringbuilder, zza1, zza(zza1, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, i))));
            return;

        case 5: // '\005'
            zzb(stringbuilder, zza1, zza(zza1, com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i)));
            return;

        case 6: // '\006'
            zzb(stringbuilder, zza1, zza(zza1, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i))));
            return;

        case 7: // '\007'
            zzb(stringbuilder, zza1, zza(zza1, com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i)));
            return;

        case 8: // '\b'
        case 9: // '\t'
            zzb(stringbuilder, zza1, zza(zza1, com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i)));
            return;

        case 10: // '\n'
            zzb(stringbuilder, zza1, zza(zza1, zzk(com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i))));
            return;

        case 11: // '\013'
            throw new IllegalArgumentException("Method does not accept concrete type.");
        }
    }

    private void zza(StringBuilder stringbuilder, String s, zzld.zza zza1, Parcel parcel, int i)
    {
        stringbuilder.append("\"").append(s).append("\":");
        if (zza1.zzjJ())
        {
            zza(stringbuilder, zza1, parcel, i);
            return;
        } else
        {
            zzb(stringbuilder, zza1, parcel, i);
            return;
        }
    }

    private void zza(StringBuilder stringbuilder, Map map, Parcel parcel)
    {
        map = zzF(map);
        stringbuilder.append('{');
        int i = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        boolean flag = false;
        do
        {
            if (parcel.dataPosition() >= i)
            {
                break;
            }
            int j = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            java.util.Map.Entry entry = (java.util.Map.Entry)map.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzaP(j)));
            if (entry != null)
            {
                if (flag)
                {
                    stringbuilder.append(",");
                }
                zza(stringbuilder, (String)entry.getKey(), (zzld.zza)entry.getValue(), parcel, j);
                flag = true;
            }
        } while (true);
        if (parcel.dataPosition() != i)
        {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(i).toString(), parcel);
        } else
        {
            stringbuilder.append('}');
            return;
        }
    }

    private static zzlh zzb(zzld zzld1)
    {
        zzlh zzlh1 = new zzlh(zzld1.getClass());
        zza(zzlh1, zzld1);
        zzlh1.zzjN();
        zzlh1.zzjM();
        return zzlh1;
    }

    private void zzb(StringBuilder stringbuilder, zzld.zza zza1, Parcel parcel, int i)
    {
        if (!zza1.zzjE()) goto _L2; else goto _L1
_L1:
        stringbuilder.append("[");
        zza1.zzjy();
        JVM INSTR tableswitch 0 11: default 80
    //                   0 91
    //                   1 110
    //                   2 123
    //                   3 136
    //                   4 149
    //                   5 162
    //                   6 175
    //                   7 188
    //                   8 201
    //                   9 201
    //                   10 201
    //                   11 212;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L12 _L12 _L13
_L3:
        throw new IllegalStateException("Unknown field type out.");
_L4:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, i));
_L14:
        stringbuilder.append("]");
        return;
_L5:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, i));
        continue; /* Loop/switch isn't completed */
_L6:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, i));
        continue; /* Loop/switch isn't completed */
_L7:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzx(parcel, i));
        continue; /* Loop/switch isn't completed */
_L8:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzy(parcel, i));
        continue; /* Loop/switch isn't completed */
_L9:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzz(parcel, i));
        continue; /* Loop/switch isn't completed */
_L10:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, i));
        continue; /* Loop/switch isn't completed */
_L11:
        com.google.android.gms.internal.zzls.zza(stringbuilder, com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, i));
        if (true) goto _L14; else goto _L12
_L12:
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
_L13:
        parcel = com.google.android.gms.common.internal.safeparcel.zza.zzE(parcel, i);
        int j = parcel.length;
        i = 0;
        while (i < j) 
        {
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            parcel[i].setDataPosition(0);
            zza(stringbuilder, zza1.zzjL(), parcel[i]);
            i++;
        }
        if (true) goto _L14; else goto _L2
_L2:
        switch (zza1.zzjy())
        {
        default:
            throw new IllegalStateException("Unknown field type out");

        case 0: // '\0'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
            return;

        case 1: // '\001'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i));
            return;

        case 2: // '\002'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
            return;

        case 3: // '\003'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
            return;

        case 4: // '\004'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, i));
            return;

        case 5: // '\005'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i));
            return;

        case 6: // '\006'
            stringbuilder.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
            return;

        case 7: // '\007'
            zza1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i);
            stringbuilder.append("\"").append(zzma.zzbt(zza1)).append("\"");
            return;

        case 8: // '\b'
            zza1 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i);
            stringbuilder.append("\"").append(zzlt.zze(zza1)).append("\"");
            return;

        case 9: // '\t'
            zza1 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i);
            stringbuilder.append("\"").append(zzlt.zzf(zza1));
            stringbuilder.append("\"");
            return;

        case 10: // '\n'
            zza1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i);
            parcel = zza1.keySet();
            parcel.size();
            stringbuilder.append("{");
            parcel = parcel.iterator();
            for (i = 1; parcel.hasNext(); i = 0)
            {
                String s = (String)parcel.next();
                if (i == 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append("\"").append(s).append("\"");
                stringbuilder.append(":");
                stringbuilder.append("\"").append(zzma.zzbt(zza1.getString(s))).append("\"");
            }

            stringbuilder.append("}");
            return;

        case 11: // '\013'
            parcel = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, i);
            parcel.setDataPosition(0);
            zza(stringbuilder, zza1.zzjL(), parcel);
            return;
        }
    }

    private void zzb(StringBuilder stringbuilder, zzld.zza zza1, Object obj)
    {
        if (zza1.zzjD())
        {
            zzb(stringbuilder, zza1, (ArrayList)obj);
            return;
        } else
        {
            zza(stringbuilder, zza1.zzjx(), obj);
            return;
        }
    }

    private void zzb(StringBuilder stringbuilder, zzld.zza zza1, ArrayList arraylist)
    {
        stringbuilder.append("[");
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            if (i != 0)
            {
                stringbuilder.append(",");
            }
            zza(stringbuilder, zza1.zzjx(), arraylist.get(i));
        }

        stringbuilder.append("]");
    }

    public static HashMap zzk(Bundle bundle)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); hashmap.put(s, bundle.getString(s)))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public int describeContents()
    {
        zzll zzll1 = CREATOR;
        return 0;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public String toString()
    {
        zzx.zzb(zzQX, "Cannot convert to JSON on client side.");
        Parcel parcel = zzjR();
        parcel.setDataPosition(0);
        StringBuilder stringbuilder = new StringBuilder(100);
        zza(stringbuilder, zzQX.zzbs(mClassName), parcel);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzll zzll1 = CREATOR;
        com.google.android.gms.internal.zzll.zza(this, parcel, i);
    }

    protected Object zzbo(String s)
    {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean zzbp(String s)
    {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel zzjR()
    {
        zzRg;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 33
    //                   1 63;
           goto _L1 _L2 _L3
_L1:
        return zzRe;
_L2:
        zzRh = com.google.android.gms.common.internal.safeparcel.zzb.zzK(zzRe);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(zzRe, zzRh);
        zzRg = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(zzRe, zzRh);
        zzRg = 2;
        if (true) goto _L1; else goto _L4
_L4:
    }

    zzlh zzjS()
    {
        switch (zzRf)
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid creation type: ").append(zzRf).toString());

        case 0: // '\0'
            return null;

        case 1: // '\001'
            return zzQX;

        case 2: // '\002'
            return zzQX;
        }
    }

    public Map zzjz()
    {
        if (zzQX == null)
        {
            return null;
        } else
        {
            return zzQX.zzbs(mClassName);
        }
    }

}
