// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzGT
    implements hannelResult
{

    final Status zzGT;
    final zzGT zzJO;

    public JSONObject getCustomData()
    {
        return null;
    }

    public Status getStatus()
    {
        return zzGT;
    }

    hannelResult(hannelResult hannelresult, Status status)
    {
        zzJO = hannelresult;
        zzGT = status;
        super();
    }
}
