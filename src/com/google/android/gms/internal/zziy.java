// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class zziy
{

    private static final String zzGf[] = {
        "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"
    };
    private static final Map zzGg;

    public static String zzV(int i)
    {
        if (i < 0 || i >= zzGf.length)
        {
            return null;
        } else
        {
            return zzGf[i];
        }
    }

    public static int zzay(String s)
    {
        Integer integer = (Integer)zzGg.get(s);
        if (integer == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("[").append(s).append("] is not a valid global search section name").toString());
        } else
        {
            return integer.intValue();
        }
    }

    public static int zzgW()
    {
        return zzGf.length;
    }

    static 
    {
        int i = 0;
        zzGg = new HashMap(zzGf.length);
        for (; i < zzGf.length; i++)
        {
            zzGg.put(zzGf[i], Integer.valueOf(i));
        }

    }
}
