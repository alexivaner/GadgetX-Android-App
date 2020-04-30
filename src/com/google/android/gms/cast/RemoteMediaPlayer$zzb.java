// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzkf;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private static abstract class zzj extends zzjr
{

    zzkf zzJN;

    public Result createFailedResult(Status status)
    {
        return zzj(status);
    }

    public aChannelResult zzj(Status status)
    {
        return new RemoteMediaPlayer.MediaChannelResult(status) {

            final Status zzGT;
            final RemoteMediaPlayer.zzb zzJO;

            public JSONObject getCustomData()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzGT;
            }

            
            {
                zzJO = RemoteMediaPlayer.zzb.this;
                zzGT = status;
                super();
            }
        };
    }

    _cls2.zzGT(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzJN = new zzkf() {

            final RemoteMediaPlayer.zzb zzJO;

            public void zza(long l, int i, Object obj)
            {
                if (obj instanceof JSONObject)
                {
                    obj = (JSONObject)obj;
                } else
                {
                    obj = null;
                }
                zzJO.setResult(new RemoteMediaPlayer.zzc(new Status(i), ((JSONObject) (obj))));
            }

            public void zzn(long l)
            {
                zzJO.setResult(zzJO.zzj(new Status(2103)));
            }

            
            {
                zzJO = RemoteMediaPlayer.zzb.this;
                super();
            }
        };
    }
}
