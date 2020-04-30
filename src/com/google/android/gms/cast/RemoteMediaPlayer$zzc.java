// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private static final class zzIX
    implements aChannelResult
{

    private final Status zzHb;
    private final JSONObject zzIX;

    public JSONObject getCustomData()
    {
        return zzIX;
    }

    public Status getStatus()
    {
        return zzHb;
    }

    aChannelResult(Status status, JSONObject jsonobject)
    {
        zzHb = status;
        zzIX = jsonobject;
    }
}
