// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.internal:
//            zzbx, zzki

static final class nit> extends zzbx
{

    public Object zza(Bundle bundle)
    {
        return zzb(bundle);
    }

    public Boolean zzb(Bundle bundle)
    {
        return Boolean.valueOf(bundle.getBoolean(getKey(), ((Boolean)zzbY()).booleanValue()));
    }

    public zzki zzbZ()
    {
        return zzki.zzg(getKey(), ((Boolean)zzbY()).booleanValue());
    }

    (String s, Boolean boolean1)
    {
        super(s, boolean1, null);
    }
}
