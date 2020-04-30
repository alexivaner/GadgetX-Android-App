// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

private static abstract class <init> extends <init>
{

    public Result createFailedResult(Status status)
    {
        return zzg(status);
    }

    public eResult zzg(Status status)
    {
        return AppStateManager.zzd(status);
    }

    public eResult(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }
}
