// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzof

private static class  extends 
{

    private final com.google.android.gms.common.api.zd zzHa;
    private final  zzaaB;

    public void zzi(Status status)
    {
        if (zzaaB != null && status.isSuccess())
        {
            zzaaB.zzlN();
        }
        zzHa.zd(status);
    }

    private (com.google.android.gms.common.api. ,  1)
    {
        zzHa = ;
        zzaaB = 1;
    }

    (com.google.android.gms.common.api.aaB aab,  ,  1)
    {
        this(aab, );
    }
}
