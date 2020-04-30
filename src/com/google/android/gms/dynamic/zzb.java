// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.google.android.gms.dynamic:
//            zze, zzd, zzc

public final class zzb extends zzc.zza
{

    private Fragment zzXZ;

    private zzb(Fragment fragment)
    {
        zzXZ = fragment;
    }

    public static zzb zza(Fragment fragment)
    {
        if (fragment != null)
        {
            return new zzb(fragment);
        } else
        {
            return null;
        }
    }

    public Bundle getArguments()
    {
        return zzXZ.getArguments();
    }

    public int getId()
    {
        return zzXZ.getId();
    }

    public boolean getRetainInstance()
    {
        return zzXZ.getRetainInstance();
    }

    public String getTag()
    {
        return zzXZ.getTag();
    }

    public int getTargetRequestCode()
    {
        return zzXZ.getTargetRequestCode();
    }

    public boolean getUserVisibleHint()
    {
        return zzXZ.getUserVisibleHint();
    }

    public zzd getView()
    {
        return com.google.android.gms.dynamic.zze.zzn(zzXZ.getView());
    }

    public boolean isAdded()
    {
        return zzXZ.isAdded();
    }

    public boolean isDetached()
    {
        return zzXZ.isDetached();
    }

    public boolean isHidden()
    {
        return zzXZ.isHidden();
    }

    public boolean isInLayout()
    {
        return zzXZ.isInLayout();
    }

    public boolean isRemoving()
    {
        return zzXZ.isRemoving();
    }

    public boolean isResumed()
    {
        return zzXZ.isResumed();
    }

    public boolean isVisible()
    {
        return zzXZ.isVisible();
    }

    public void setHasOptionsMenu(boolean flag)
    {
        zzXZ.setHasOptionsMenu(flag);
    }

    public void setMenuVisibility(boolean flag)
    {
        zzXZ.setMenuVisibility(flag);
    }

    public void setRetainInstance(boolean flag)
    {
        zzXZ.setRetainInstance(flag);
    }

    public void setUserVisibleHint(boolean flag)
    {
        zzXZ.setUserVisibleHint(flag);
    }

    public void startActivity(Intent intent)
    {
        zzXZ.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        zzXZ.startActivityForResult(intent, i);
    }

    public void zzd(zzd zzd1)
    {
        zzd1 = (View)com.google.android.gms.dynamic.zze.zzf(zzd1);
        zzXZ.registerForContextMenu(zzd1);
    }

    public void zze(zzd zzd1)
    {
        zzd1 = (View)com.google.android.gms.dynamic.zze.zzf(zzd1);
        zzXZ.unregisterForContextMenu(zzd1);
    }

    public zzd zzlh()
    {
        return com.google.android.gms.dynamic.zze.zzn(zzXZ.getActivity());
    }

    public zzc zzli()
    {
        return zza(zzXZ.getParentFragment());
    }

    public zzd zzlj()
    {
        return com.google.android.gms.dynamic.zze.zzn(zzXZ.getResources());
    }

    public zzc zzlk()
    {
        return zza(zzXZ.getTargetFragment());
    }
}
