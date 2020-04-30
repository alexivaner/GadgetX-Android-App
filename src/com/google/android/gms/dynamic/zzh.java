// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

// Referenced classes of package com.google.android.gms.dynamic:
//            zze, zzd, zzc

public final class zzh extends zzc.zza
{

    private Fragment zzPt;

    private zzh(Fragment fragment)
    {
        zzPt = fragment;
    }

    public static zzh zza(Fragment fragment)
    {
        if (fragment != null)
        {
            return new zzh(fragment);
        } else
        {
            return null;
        }
    }

    public Bundle getArguments()
    {
        return zzPt.getArguments();
    }

    public int getId()
    {
        return zzPt.getId();
    }

    public boolean getRetainInstance()
    {
        return zzPt.getRetainInstance();
    }

    public String getTag()
    {
        return zzPt.getTag();
    }

    public int getTargetRequestCode()
    {
        return zzPt.getTargetRequestCode();
    }

    public boolean getUserVisibleHint()
    {
        return zzPt.getUserVisibleHint();
    }

    public zzd getView()
    {
        return com.google.android.gms.dynamic.zze.zzn(zzPt.getView());
    }

    public boolean isAdded()
    {
        return zzPt.isAdded();
    }

    public boolean isDetached()
    {
        return zzPt.isDetached();
    }

    public boolean isHidden()
    {
        return zzPt.isHidden();
    }

    public boolean isInLayout()
    {
        return zzPt.isInLayout();
    }

    public boolean isRemoving()
    {
        return zzPt.isRemoving();
    }

    public boolean isResumed()
    {
        return zzPt.isResumed();
    }

    public boolean isVisible()
    {
        return zzPt.isVisible();
    }

    public void setHasOptionsMenu(boolean flag)
    {
        zzPt.setHasOptionsMenu(flag);
    }

    public void setMenuVisibility(boolean flag)
    {
        zzPt.setMenuVisibility(flag);
    }

    public void setRetainInstance(boolean flag)
    {
        zzPt.setRetainInstance(flag);
    }

    public void setUserVisibleHint(boolean flag)
    {
        zzPt.setUserVisibleHint(flag);
    }

    public void startActivity(Intent intent)
    {
        zzPt.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        zzPt.startActivityForResult(intent, i);
    }

    public void zzd(zzd zzd1)
    {
        zzd1 = (View)com.google.android.gms.dynamic.zze.zzf(zzd1);
        zzPt.registerForContextMenu(zzd1);
    }

    public void zze(zzd zzd1)
    {
        zzd1 = (View)com.google.android.gms.dynamic.zze.zzf(zzd1);
        zzPt.unregisterForContextMenu(zzd1);
    }

    public zzd zzlh()
    {
        return com.google.android.gms.dynamic.zze.zzn(zzPt.getActivity());
    }

    public zzc zzli()
    {
        return zza(zzPt.getParentFragment());
    }

    public zzd zzlj()
    {
        return com.google.android.gms.dynamic.zze.zzn(zzPt.getResources());
    }

    public zzc zzlk()
    {
        return zza(zzPt.getTargetFragment());
    }
}
