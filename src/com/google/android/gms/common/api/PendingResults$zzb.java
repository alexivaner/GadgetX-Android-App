// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;

// Referenced classes of package com.google.android.gms.common.api:
//            AbstractPendingResult, PendingResults, Status, Result

private static final class lt extends AbstractPendingResult
{

    protected Result createFailedResult(Status status)
    {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }

    public lt()
    {
        super(Looper.getMainLooper());
    }
}
