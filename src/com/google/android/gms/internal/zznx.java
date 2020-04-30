// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class zznx
    implements PendingResult
{

    private final Result zzZX;

    zznx(Result result)
    {
        zzZX = result;
    }

    public void addBatchCallback(com.google.android.gms.common.api.PendingResult.BatchCallback batchcallback)
    {
        batchcallback.zzl(zzZX.getStatus());
    }

    public Result await()
    {
        return zzZX;
    }

    public Result await(long l, TimeUnit timeunit)
    {
        return zzZX;
    }

    public void cancel()
    {
    }

    public boolean isCanceled()
    {
        return false;
    }

    public void setResultCallback(ResultCallback resultcallback)
    {
        resultcallback.onResult(zzZX);
    }

    public void setResultCallback(ResultCallback resultcallback, long l, TimeUnit timeunit)
    {
        resultcallback.onResult(zzZX);
    }
}
