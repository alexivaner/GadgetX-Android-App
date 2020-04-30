// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaMetadata, TextTrackStyle

public static class zzIY
{

    private final MediaInfo zzIY;

    public MediaInfo build()
        throws IllegalArgumentException
    {
        zzIY.zzhi();
        return zzIY;
    }

    public zzIY setContentType(String s)
        throws IllegalArgumentException
    {
        zzIY.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        zzIY.setCustomData(jsonobject);
        return this;
    }

    public mData setMediaTracks(List list)
    {
        zzIY.zzg(list);
        return this;
    }

    public zzIY setMetadata(MediaMetadata mediametadata)
    {
        zzIY.zza(mediametadata);
        return this;
    }

    public zzIY setStreamDuration(long l)
        throws IllegalArgumentException
    {
        zzIY.zzm(l);
        return this;
    }

    public zzIY setStreamType(int i)
        throws IllegalArgumentException
    {
        zzIY.setStreamType(i);
        return this;
    }

    public mType setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        zzIY.setTextTrackStyle(texttrackstyle);
        return this;
    }

    public (String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Content ID cannot be empty");
        } else
        {
            zzIY = new MediaInfo(s);
            return;
        }
    }
}
