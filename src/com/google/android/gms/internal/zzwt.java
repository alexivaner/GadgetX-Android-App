// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzxa, zzwq, zzxb, zzwy, 
//            zzwr

public class zzwt
{

    public final int tag;
    protected final int type;
    protected final Class zzaHC;
    protected final boolean zzaHD;

    private zzwt(int i, Class class1, int j, boolean flag)
    {
        type = i;
        zzaHC = class1;
        tag = j;
        zzaHD = flag;
    }

    public static zzwt zza(int i, Class class1, int j)
    {
        return new zzwt(i, class1, j, false);
    }

    private Object zzy(List list)
    {
        ArrayList arraylist;
        boolean flag;
        int k;
        flag = false;
        arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            zzxa zzxa1 = (zzxa)list.get(i);
            if (zzxa1.zzaHN.length != 0)
            {
                zza(zzxa1, arraylist);
            }
        }

        k = arraylist.size();
        if (k != 0) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        Object obj = zzaHC.cast(Array.newInstance(zzaHC.getComponentType(), k));
        int j = ((flag) ? 1 : 0);
        do
        {
            list = ((List) (obj));
            if (j >= k)
            {
                continue;
            }
            Array.set(obj, j, arraylist.get(j));
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Object zzz(List list)
    {
        if (list.isEmpty())
        {
            return null;
        } else
        {
            list = (zzxa)list.get(list.size() - 1);
            return zzaHC.cast(zzz(zzwq.zzt(((zzxa) (list)).zzaHN)));
        }
    }

    int zzF(Object obj)
    {
        if (zzaHD)
        {
            return zzG(obj);
        } else
        {
            return zzH(obj);
        }
    }

    protected int zzG(Object obj)
    {
        int j = 0;
        int l = Array.getLength(obj);
        for (int i = 0; i < l;)
        {
            int k = j;
            if (Array.get(obj, i) != null)
            {
                k = j + zzH(Array.get(obj, i));
            }
            i++;
            j = k;
        }

        return j;
    }

    protected int zzH(Object obj)
    {
        int i = zzxb.zziI(tag);
        switch (type)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(type).toString());

        case 10: // '\n'
            return zzwr.zzb(i, (zzwy)obj);

        case 11: // '\013'
            return zzwr.zzc(i, (zzwy)obj);
        }
    }

    protected void zza(zzxa zzxa1, List list)
    {
        list.add(zzz(zzwq.zzt(zzxa1.zzaHN)));
    }

    void zza(Object obj, zzwr zzwr1)
        throws IOException
    {
        if (zzaHD)
        {
            zzc(obj, zzwr1);
            return;
        } else
        {
            zzb(obj, zzwr1);
            return;
        }
    }

    protected void zzb(Object obj, zzwr zzwr1)
    {
        zzwr1.zziA(tag);
        type;
        JVM INSTR tableswitch 10 11: default 110
    //                   10 76
    //                   11 101;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(type).toString());
_L2:
        try
        {
            obj = (zzwy)obj;
            int i = zzxb.zziI(tag);
            zzwr1.zzb(((zzwy) (obj)));
            zzwr1.zzC(i, 4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
_L3:
        zzwr1.zzc((zzwy)obj);
        return;
    }

    protected void zzc(Object obj, zzwr zzwr1)
    {
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1 != null)
            {
                zzb(obj1, zzwr1);
            }
        }

    }

    final Object zzx(List list)
    {
        if (list == null)
        {
            return null;
        }
        if (zzaHD)
        {
            return zzy(list);
        } else
        {
            return zzz(list);
        }
    }

    protected Object zzz(zzwq zzwq1)
    {
        Class class1;
        if (zzaHD)
        {
            class1 = zzaHC.getComponentType();
        } else
        {
            class1 = zzaHC;
        }
        type;
        JVM INSTR tableswitch 10 11: default 185
    //                   10 107
    //                   11 129;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(type).toString());
_L2:
        zzwy zzwy1;
        try
        {
            zzwy1 = (zzwy)class1.newInstance();
            zzwq1.zza(zzwy1, zzxb.zziI(tag));
        }
        // Misplaced declaration of an exception variable
        catch (zzwq zzwq1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Error creating instance of class ").append(class1).toString(), zzwq1);
        }
        // Misplaced declaration of an exception variable
        catch (zzwq zzwq1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Error creating instance of class ").append(class1).toString(), zzwq1);
        }
        // Misplaced declaration of an exception variable
        catch (zzwq zzwq1)
        {
            throw new IllegalArgumentException("Error reading extension field", zzwq1);
        }
        return zzwy1;
_L3:
        zzwy1 = (zzwy)class1.newInstance();
        zzwq1.zza(zzwy1);
        return zzwy1;
    }
}
