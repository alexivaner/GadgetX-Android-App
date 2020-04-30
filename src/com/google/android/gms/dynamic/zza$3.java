// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.dynamic:
//            zza, LifecycleDelegate

class zzXU
    implements a
{

    final zza zzXR;
    final Bundle zzXU;

    public int getState()
    {
        return 1;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zza.zzb(zzXR).onCreate(zzXU);
    }

    cleDelegate(zza zza1, Bundle bundle)
    {
        zzXR = zza1;
        zzXU = bundle;
        super();
    }
}
