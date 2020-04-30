// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
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
//            MapView, OnMapReadyCallback, GoogleMapOptions

static class zzaqi extends zza
{

    private final Context mContext;
    protected zzf zzaqa;
    private final List zzaqb = new ArrayList();
    private final ViewGroup zzaqh;
    private final GoogleMapOptions zzaqi;

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
        if (zzaqa == null || zzlg() != null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        try
        {
            com.google.android.gms.maps.internal.IMapViewDelegate imapviewdelegate = zzx.zzac(mContext).zza(zze.zzn(mContext), zzaqi);
            zzaqa.zza(new <init>(zzaqh, imapviewdelegate));
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

    ions(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
    {
        zzaqh = viewgroup;
        mContext = context;
        zzaqi = googlemapoptions;
    }
}
