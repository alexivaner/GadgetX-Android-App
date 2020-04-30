// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;

// Referenced classes of package com.google.android.gms.common.api:
//            AbstractPendingResult, PendingResults, Status, Result

private static final class zzNm extends AbstractPendingResult
{

    private final Result zzNm;

    protected Result createFailedResult(Status status)
    {
        if (status.getStatusCode() != zzNm.getStatus().getStatusCode())
        {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        } else
        {
            return zzNm;
        }
    }

    public lt(Result result)
    {
        super(Looper.getMainLooper());
        zzNm = result;
    }
}
