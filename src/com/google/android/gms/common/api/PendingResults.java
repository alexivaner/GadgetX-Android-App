// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.common.api:
//            zzg, Result, Status, PendingResult, 
//            AbstractPendingResult

public final class PendingResults
{
    private static final class zza extends AbstractPendingResult
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

        public zza(Result result)
        {
            super(Looper.getMainLooper());
            zzNm = result;
        }
    }

    private static final class zzb extends AbstractPendingResult
    {

        protected Result createFailedResult(Status status)
        {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }

        public zzb()
        {
            super(Looper.getMainLooper());
        }
    }


    private PendingResults()
    {
    }

    public static PendingResult canceledPendingResult()
    {
        zzg zzg1 = new zzg(Looper.getMainLooper());
        zzg1.cancel();
        return zzg1;
    }

    public static PendingResult canceledPendingResult(Result result)
    {
        zzx.zzb(result, "Result must not be null");
        boolean flag;
        if (result.getStatus().getStatusCode() == 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Status code must be CommonStatusCodes.CANCELED");
        result = new zza(result);
        result.cancel();
        return result;
    }

    public static PendingResult immediatePendingResult(Result result)
    {
        zzx.zzb(result, "Result must not be null");
        zzb zzb1 = new zzb();
        zzb1.setResult(result);
        return zzb1;
    }

    public static PendingResult immediatePendingResult(Status status)
    {
        zzx.zzb(status, "Result must not be null");
        zzg zzg1 = new zzg(Looper.getMainLooper());
        zzg1.setResult(status);
        return zzg1;
    }
}
