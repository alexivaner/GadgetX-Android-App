// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            LifecycleDelegate, zzf

public abstract class com.google.android.gms.dynamic.zza
{
    private static interface zza
    {

        public abstract int getState();

        public abstract void zzb(LifecycleDelegate lifecycledelegate);
    }


    private LifecycleDelegate zzXN;
    private Bundle zzXO;
    private LinkedList zzXP;
    private final zzf zzXQ = new zzf() {

        final com.google.android.gms.dynamic.zza zzXR;

        public void zza(LifecycleDelegate lifecycledelegate)
        {
            com.google.android.gms.dynamic.zza.zza(zzXR, lifecycledelegate);
            for (lifecycledelegate = com.google.android.gms.dynamic.zza.zza(zzXR).iterator(); lifecycledelegate.hasNext(); ((zza)lifecycledelegate.next()).zzb(com.google.android.gms.dynamic.zza.zzb(zzXR))) { }
            com.google.android.gms.dynamic.zza.zza(zzXR).clear();
            com.google.android.gms.dynamic.zza.zza(zzXR, null);
        }

            
            {
                zzXR = com.google.android.gms.dynamic.zza.this;
                super();
            }
    };

    public com.google.android.gms.dynamic.zza()
    {
    }

    static Bundle zza(com.google.android.gms.dynamic.zza zza1, Bundle bundle)
    {
        zza1.zzXO = bundle;
        return bundle;
    }

    static LifecycleDelegate zza(com.google.android.gms.dynamic.zza zza1, LifecycleDelegate lifecycledelegate)
    {
        zza1.zzXN = lifecycledelegate;
        return lifecycledelegate;
    }

    static LinkedList zza(com.google.android.gms.dynamic.zza zza1)
    {
        return zza1.zzXP;
    }

    private void zza(Bundle bundle, zza zza1)
    {
        if (zzXN != null)
        {
            zza1.zzb(zzXN);
            return;
        }
        if (zzXP == null)
        {
            zzXP = new LinkedList();
        }
        zzXP.add(zza1);
        if (bundle != null)
        {
            if (zzXO == null)
            {
                zzXO = (Bundle)bundle.clone();
            } else
            {
                zzXO.putAll(bundle);
            }
        }
        zza(zzXQ);
    }

    static LifecycleDelegate zzb(com.google.android.gms.dynamic.zza zza1)
    {
        return zza1.zzXN;
    }

    public static void zzb(FrameLayout framelayout)
    {
        Context context = framelayout.getContext();
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String s1 = GooglePlayServicesUtil.zze(context, i);
        String s = GooglePlayServicesUtil.zzf(context, i);
        LinearLayout linearlayout = new LinearLayout(framelayout.getContext());
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.addView(linearlayout);
        framelayout = new TextView(framelayout.getContext());
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.setText(s1);
        linearlayout.addView(framelayout);
        if (s != null)
        {
            framelayout = new Button(context);
            framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            framelayout.setText(s);
            linearlayout.addView(framelayout);
            framelayout.setOnClickListener(new android.view.View.OnClickListener(context, i) {

                final int zzXY;
                final Context zznK;

                public void onClick(View view)
                {
                    zznK.startActivity(GooglePlayServicesUtil.zzan(zzXY));
                }

            
            {
                zznK = context;
                zzXY = i;
                super();
            }
            });
        }
    }

    private void zzdd(int i)
    {
        for (; !zzXP.isEmpty() && ((zza)zzXP.getLast()).getState() >= i; zzXP.removeLast()) { }
    }

    public void onCreate(Bundle bundle)
    {
        zza(bundle, new zza(bundle) {

            final com.google.android.gms.dynamic.zza zzXR;
            final Bundle zzXU;

            public int getState()
            {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.zza.zzb(zzXR).onCreate(zzXU);
            }

            
            {
                zzXR = com.google.android.gms.dynamic.zza.this;
                zzXU = bundle;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FrameLayout framelayout = new FrameLayout(layoutinflater.getContext());
        zza(bundle, new zza(framelayout, layoutinflater, viewgroup, bundle) {

            final com.google.android.gms.dynamic.zza zzXR;
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
                zzXV.addView(com.google.android.gms.dynamic.zza.zzb(zzXR).onCreateView(zzXW, zzXX, zzXU));
            }

            
            {
                zzXR = com.google.android.gms.dynamic.zza.this;
                zzXV = framelayout;
                zzXW = layoutinflater;
                zzXX = viewgroup;
                zzXU = bundle;
                super();
            }
        });
        if (zzXN == null)
        {
            zza(framelayout);
        }
        return framelayout;
    }

    public void onDestroy()
    {
        if (zzXN != null)
        {
            zzXN.onDestroy();
            return;
        } else
        {
            zzdd(1);
            return;
        }
    }

    public void onDestroyView()
    {
        if (zzXN != null)
        {
            zzXN.onDestroyView();
            return;
        } else
        {
            zzdd(2);
            return;
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        zza(bundle1, new zza(activity, bundle, bundle1) {

            final com.google.android.gms.dynamic.zza zzXR;
            final Activity zzXS;
            final Bundle zzXT;
            final Bundle zzXU;

            public int getState()
            {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.zza.zzb(zzXR).onInflate(zzXS, zzXT, zzXU);
            }

            
            {
                zzXR = com.google.android.gms.dynamic.zza.this;
                zzXS = activity;
                zzXT = bundle;
                zzXU = bundle1;
                super();
            }
        });
    }

    public void onLowMemory()
    {
        if (zzXN != null)
        {
            zzXN.onLowMemory();
        }
    }

    public void onPause()
    {
        if (zzXN != null)
        {
            zzXN.onPause();
            return;
        } else
        {
            zzdd(5);
            return;
        }
    }

    public void onResume()
    {
        zza(((Bundle) (null)), new zza() {

            final com.google.android.gms.dynamic.zza zzXR;

            public int getState()
            {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.zza.zzb(zzXR).onResume();
            }

            
            {
                zzXR = com.google.android.gms.dynamic.zza.this;
                super();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (zzXN != null)
        {
            zzXN.onSaveInstanceState(bundle);
        } else
        if (zzXO != null)
        {
            bundle.putAll(zzXO);
            return;
        }
    }

    public void onStart()
    {
        zza(((Bundle) (null)), new zza() {

            final com.google.android.gms.dynamic.zza zzXR;

            public int getState()
            {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycledelegate)
            {
                com.google.android.gms.dynamic.zza.zzb(zzXR).onStart();
            }

            
            {
                zzXR = com.google.android.gms.dynamic.zza.this;
                super();
            }
        });
    }

    public void onStop()
    {
        if (zzXN != null)
        {
            zzXN.onStop();
            return;
        } else
        {
            zzdd(4);
            return;
        }
    }

    protected void zza(FrameLayout framelayout)
    {
        zzb(framelayout);
    }

    protected abstract void zza(zzf zzf);

    public LifecycleDelegate zzlg()
    {
        return zzXN;
    }
}
