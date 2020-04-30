// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            AbstractPendingResult, PendingResult, BatchResult, Status, 
//            Result, GoogleApiClient, BatchResultToken

public final class Batch extends AbstractPendingResult
{
    public static final class Builder
    {

        private List zzMb;
        private Looper zzMc;

        public BatchResultToken add(PendingResult pendingresult)
        {
            BatchResultToken batchresulttoken = new BatchResultToken(zzMb.size());
            zzMb.add(pendingresult);
            return batchresulttoken;
        }

        public Batch build()
        {
            return new Batch(zzMb, zzMc);
        }

        public Builder(GoogleApiClient googleapiclient)
        {
            zzMb = new ArrayList();
            zzMc = googleapiclient.getLooper();
        }
    }


    private int zzLW;
    private boolean zzLX;
    private boolean zzLY;
    private final PendingResult zzLZ[];
    private final Object zznh;

    private Batch(List list, Looper looper)
    {
        super(new AbstractPendingResult.CallbackHandler(looper));
        zznh = new Object();
        zzLW = list.size();
        zzLZ = new PendingResult[zzLW];
        for (int i = 0; i < list.size(); i++)
        {
            looper = (PendingResult)list.get(i);
            zzLZ[i] = looper;
            looper.addBatchCallback(new PendingResult.BatchCallback() {

                final Batch zzMa;

                public void zzl(Status status)
                {
label0:
                    {
                        synchronized (Batch.zza(zzMa))
                        {
                            if (!zzMa.isCanceled())
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    if (!status.isCanceled()) goto _L2; else goto _L1
_L1:
                    Batch.zza(zzMa, true);
_L8:
                    Batch.zzb(zzMa);
                    if (Batch.zzc(zzMa) != 0) goto _L4; else goto _L3
_L3:
                    if (!Batch.zzd(zzMa)) goto _L6; else goto _L5
_L5:
                    Batch.zze(zzMa);
_L4:
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    status;
                    obj;
                    JVM INSTR monitorexit ;
                    throw status;
_L2:
                    if (status.isSuccess()) goto _L8; else goto _L7
_L7:
                    Batch.zzb(zzMa, true);
                      goto _L8
_L6:
                    if (!Batch.zzf(zzMa))
                    {
                        break MISSING_BLOCK_LABEL_146;
                    }
                    status = new Status(13);
_L9:
                    zzMa.setResult(new BatchResult(status, Batch.zzg(zzMa)));
                      goto _L4
                    status = Status.zzNo;
                      goto _L9
                }

            
            {
                zzMa = Batch.this;
                super();
            }
            });
        }

    }


    static Object zza(Batch batch)
    {
        return batch.zznh;
    }

    static boolean zza(Batch batch, boolean flag)
    {
        batch.zzLY = flag;
        return flag;
    }

    static int zzb(Batch batch)
    {
        int i = batch.zzLW;
        batch.zzLW = i - 1;
        return i;
    }

    static boolean zzb(Batch batch, boolean flag)
    {
        batch.zzLX = flag;
        return flag;
    }

    static int zzc(Batch batch)
    {
        return batch.zzLW;
    }

    static boolean zzd(Batch batch)
    {
        return batch.zzLY;
    }

    static void zze(Batch batch)
    {
        batch.AbstractPendingResult.cancel();
    }

    static boolean zzf(Batch batch)
    {
        return batch.zzLX;
    }

    static PendingResult[] zzg(Batch batch)
    {
        return batch.zzLZ;
    }

    public void cancel()
    {
        super.cancel();
        PendingResult apendingresult[] = zzLZ;
        int j = apendingresult.length;
        for (int i = 0; i < j; i++)
        {
            apendingresult[i].cancel();
        }

    }

    public BatchResult createFailedResult(Status status)
    {
        return new BatchResult(status, zzLZ);
    }

    public volatile Result createFailedResult(Status status)
    {
        return createFailedResult(status);
    }
}
