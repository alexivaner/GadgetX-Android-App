// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.zzjv;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaTrack

public static class zzJr
{

    private final MediaTrack zzJr;

    public MediaTrack build()
    {
        return zzJr;
    }

    public zzJr setContentId(String s)
    {
        zzJr.setContentId(s);
        return this;
    }

    public ntId setContentType(String s)
    {
        zzJr.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        zzJr.setCustomData(jsonobject);
        return this;
    }

    public mData setLanguage(String s)
    {
        zzJr.setLanguage(s);
        return this;
    }

    public age setLanguage(Locale locale)
    {
        zzJr.setLanguage(zzjv.zzb(locale));
        return this;
    }

    public age setName(String s)
    {
        zzJr.setName(s);
        return this;
    }

    public zzJr setSubtype(int i)
        throws IllegalArgumentException
    {
        zzJr.zzaf(i);
        return this;
    }

    public (long l, int i)
        throws IllegalArgumentException
    {
        zzJr = new MediaTrack(l, i);
    }
}
