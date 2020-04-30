// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

// Referenced classes of package com.google.android.gms.dynamic:
//            zza, LifecycleDelegate

class zzXU
    implements a
{

    final zza zzXR;
    final Bundle zzXU;
    final FrameLayout zzXV;
    final LayoutInflater zzXW;
    final ViewGroup zzXX;

    public int getState()
    {
        return 2;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zzXV.removeAllViews();
        zzXV.addView(zza.zzb(zzXR).onCreateView(zzXW, zzXX, zzXU));
    }

    cleDelegate(zza zza1, FrameLayout framelayout, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        zzXR = zza1;
        zzXV = framelayout;
        zzXW = layoutinflater;
        zzXX = viewgroup;
        zzXU = bundle;
        super();
    }
}
