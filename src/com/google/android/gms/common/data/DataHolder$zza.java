// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public static class <init>
{

    private final String zzNU[];
    private final ArrayList zzOd;
    private final String zzOe;
    private final HashMap zzOf;
    private boolean zzOg;
    private String zzOh;

    static String[] zza(<init> <init>1)
    {
        return <init>1.zzNU;
    }

    static ArrayList zzb(zzNU zznu)
    {
        return zznu.zzOd;
    }

    private (String as[], String s)
    {
        zzNU = (String[])zzx.zzl(as);
        zzOd = new ArrayList();
        zzOe = s;
        zzOf = new HashMap();
        zzOg = false;
        zzOh = null;
    }

    zzOh(String as[], String s, zzOh zzoh)
    {
        this(as, s);
    }
}
