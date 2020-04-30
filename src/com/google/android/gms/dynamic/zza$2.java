// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.dynamic:
//            zza, LifecycleDelegate

class zzXU
    implements a
{

    final zza zzXR;
    final Activity zzXS;
    final Bundle zzXT;
    final Bundle zzXU;

    public int getState()
    {
        return 0;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zza.zzb(zzXR).onInflate(zzXS, zzXT, zzXU);
    }

    cleDelegate(zza zza1, Activity activity, Bundle bundle, Bundle bundle1)
    {
        zzXR = zza1;
        zzXS = activity;
        zzXT = bundle;
        zzXU = bundle1;
        super();
    }
}
