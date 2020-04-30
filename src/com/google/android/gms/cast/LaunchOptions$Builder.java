// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.zzjv;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            LaunchOptions

public static final class zzIP
{

    private LaunchOptions zzIP;

    public LaunchOptions build()
    {
        return zzIP;
    }

    public zzIP setLocale(Locale locale)
    {
        zzIP.setLanguage(zzjv.zzb(locale));
        return this;
    }

    public age setRelaunchIfRunning(boolean flag)
    {
        zzIP.setRelaunchIfRunning(flag);
        return this;
    }

    public ()
    {
        zzIP = new LaunchOptions();
    }
}
