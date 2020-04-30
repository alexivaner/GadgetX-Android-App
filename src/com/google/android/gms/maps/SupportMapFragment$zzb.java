// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            SupportMapFragment, MapsInitializer, OnMapReadyCallback

static class zzPt extends zza
{

    private final Fragment zzPt;
    protected zzf zzaqa;
    private final List zzaqb = new ArrayList();
    private Activity zzoi;

    private void setActivity(Activity activity)
    {
        zzoi = activity;
        zzqs();
    }

    static void zza(zzqs zzqs1, Activity activity)
    {
        zzqs1.setActivity(activity);
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        if (zzlg() != null)
        {
            ((zzlg)zzlg()).getMapAsync(onmapreadycallback);
            return;
        } else
        {
            zzaqb.add(onmapreadycallback);
            return;
        }
    }

    protected void zza(zzf zzf1)
    {
        zzaqa = zzf1;
        zzqs();
    }

    public void zzqs()
    {
        if (zzoi == null || zzaqa == null || zzlg() != null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        try
        {
            MapsInitializer.initialize(zzoi);
            com.google.android.gms.maps.internal.IMapFragmentDelegate imapfragmentdelegate = zzx.zzac(zzoi).zzj(zze.zzn(zzoi));
            zzaqa.zza(new <init>(zzPt, imapfragmentdelegate));
            OnMapReadyCallback onmapreadycallback;
            for (Iterator iterator = zzaqb.iterator(); iterator.hasNext(); ((zzaqb)zzlg()).getMapAsync(onmapreadycallback))
            {
                onmapreadycallback = (OnMapReadyCallback)iterator.next();
            }

        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            return;
        }
        zzaqb.clear();
    }

    AvailableException(Fragment fragment)
    {
        zzPt = fragment;
    }
}
