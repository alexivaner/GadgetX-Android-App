// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, GoogleMap, OnMapReadyCallback

public class MapView extends FrameLayout
{
    static class zza
        implements MapLifecycleDelegate
    {

        private final ViewGroup zzaqd;
        private final IMapViewDelegate zzaqe;
        private View zzaqf;

        public void getMapAsync(OnMapReadyCallback onmapreadycallback)
        {
            try
            {
                zzaqe.getMapAsync(new com.google.android.gms.maps.internal.zzm.zza(this, onmapreadycallback) {

                    final OnMapReadyCallback zzapY;
                    final zza zzaqg;

                    public void zza(IGoogleMapDelegate igooglemapdelegate)
                        throws RemoteException
                    {
                        zzapY.onMapReady(new GoogleMap(igooglemapdelegate));
                    }

            
            {
                zzaqg = zza1;
                zzapY = onmapreadycallback;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapReadyCallback onmapreadycallback)
            {
                throw new RuntimeRemoteException(onmapreadycallback);
            }
        }

        public void onCreate(Bundle bundle)
        {
            try
            {
                zzaqe.onCreate(bundle);
                zzaqf = (View)zze.zzf(zzaqe.getView());
                zzaqd.removeAllViews();
                zzaqd.addView(zzaqf);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy()
        {
            try
            {
                zzaqe.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onDestroyView()
        {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory()
        {
            try
            {
                zzaqe.onLowMemory();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onPause()
        {
            try
            {
                zzaqe.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                zzaqe.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                zzaqe.onSaveInstanceState(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public IMapViewDelegate zzqt()
        {
            return zzaqe;
        }

        public zza(ViewGroup viewgroup, IMapViewDelegate imapviewdelegate)
        {
            zzaqe = (IMapViewDelegate)zzx.zzl(imapviewdelegate);
            zzaqd = (ViewGroup)zzx.zzl(viewgroup);
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza
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
                ((zza)zzlg()).getMapAsync(onmapreadycallback);
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
                IMapViewDelegate imapviewdelegate = com.google.android.gms.maps.internal.zzx.zzac(mContext).zza(zze.zzn(mContext), zzaqi);
                zzaqa.zza(new zza(zzaqh, imapviewdelegate));
                OnMapReadyCallback onmapreadycallback;
                for (Iterator iterator = zzaqb.iterator(); iterator.hasNext(); ((zza)zzlg()).getMapAsync(onmapreadycallback))
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

        zzb(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
        {
            zzaqh = viewgroup;
            mContext = context;
            zzaqi = googlemapoptions;
        }
    }


    private GoogleMap zzapW;
    private final zzb zzaqc;

    public MapView(Context context)
    {
        super(context);
        zzaqc = new zzb(this, context, null);
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zzaqc = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeset));
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zzaqc = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeset));
    }

    public MapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context);
        zzaqc = new zzb(this, context, googlemapoptions);
    }

    public final GoogleMap getMap()
    {
        if (zzapW != null)
        {
            return zzapW;
        }
        zzaqc.zzqs();
        if (zzaqc.zzlg() == null)
        {
            return null;
        }
        try
        {
            zzapW = new GoogleMap(((zza)zzaqc.zzlg()).zzqt().getMap());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return zzapW;
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        zzx.zzbd("getMapAsync() must be called on the main thread");
        zzaqc.getMapAsync(onmapreadycallback);
    }

    public final void onCreate(Bundle bundle)
    {
        zzaqc.onCreate(bundle);
        if (zzaqc.zzlg() == null)
        {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy()
    {
        zzaqc.onDestroy();
    }

    public final void onLowMemory()
    {
        zzaqc.onLowMemory();
    }

    public final void onPause()
    {
        zzaqc.onPause();
    }

    public final void onResume()
    {
        zzaqc.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        zzaqc.onSaveInstanceState(bundle);
    }
}
