// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzjj, zzji, zzjb

private static final class zzGI
    implements com.google.android.gms.appindexing.pi.ActionResult
{

    private zzjj zzGG;
    private PendingResult zzGH;
    private Action zzGI;

    public PendingResult end(GoogleApiClient googleapiclient)
    {
        Object obj = googleapiclient.getContext().getPackageName();
        long l = System.currentTimeMillis();
        obj = zzji.zza(zzGI, l, ((String) (obj)), 3);
        return zzGG.zza(googleapiclient, new zzjb[] {
            obj
        });
    }

    public PendingResult getPendingResult()
    {
        return zzGH;
    }

    (zzjj zzjj1, PendingResult pendingresult, Action action)
    {
        zzGG = zzjj1;
        zzGH = pendingresult;
        zzGI = action;
    }
}
