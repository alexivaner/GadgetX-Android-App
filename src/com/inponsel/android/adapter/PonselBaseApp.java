// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.HashMap;

// Referenced classes of package com.inponsel.android.adapter:
//            ModelObserver

public class PonselBaseApp extends Application
{
    public static final class TrackerName extends Enum
    {

        public static final TrackerName APP_TRACKER;
        public static final TrackerName ECOMMERCE_TRACKER;
        private static final TrackerName ENUM$VALUES[];
        public static final TrackerName GLOBAL_TRACKER;

        public static TrackerName valueOf(String s)
        {
            return (TrackerName)Enum.valueOf(com/inponsel/android/adapter/PonselBaseApp$TrackerName, s);
        }

        public static TrackerName[] values()
        {
            TrackerName atrackername[] = ENUM$VALUES;
            int i = atrackername.length;
            TrackerName atrackername1[] = new TrackerName[i];
            System.arraycopy(atrackername, 0, atrackername1, 0, i);
            return atrackername1;
        }

        static 
        {
            APP_TRACKER = new TrackerName("APP_TRACKER", 0);
            GLOBAL_TRACKER = new TrackerName("GLOBAL_TRACKER", 1);
            ECOMMERCE_TRACKER = new TrackerName("ECOMMERCE_TRACKER", 2);
            ENUM$VALUES = (new TrackerName[] {
                APP_TRACKER, GLOBAL_TRACKER, ECOMMERCE_TRACKER
            });
        }

        private TrackerName(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String PROPERTY_ID = "UA-39928332-1";
    public static final String TAG = com/inponsel/android/adapter/PonselBaseApp.getSimpleName();
    private static PonselBaseApp mInstance;
    private RequestQueue mRequestQueue;
    ModelObserver mTest;
    HashMap mTrackers;
    private RefWatcher refWatcher;

    public PonselBaseApp()
    {
        mTrackers = new HashMap();
    }

    public static PonselBaseApp getInstance()
    {
        com/inponsel/android/adapter/PonselBaseApp;
        JVM INSTR monitorenter ;
        PonselBaseApp ponselbaseapp = mInstance;
        com/inponsel/android/adapter/PonselBaseApp;
        JVM INSTR monitorexit ;
        return ponselbaseapp;
        Exception exception;
        exception;
        throw exception;
    }

    public static RefWatcher getRefWatcher(Context context)
    {
        return ((PonselBaseApp)context.getApplicationContext()).refWatcher;
    }

    public void addToRequestQueue(Request request)
    {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void addToRequestQueue(Request request, String s)
    {
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = TAG;
        }
        request.setTag(s1);
        getRequestQueue().add(request);
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
    }

    public void cancelPendingRequests(Object obj)
    {
        if (mRequestQueue != null)
        {
            mRequestQueue.cancelAll(obj);
        }
    }

    public ModelObserver getObserver()
    {
        return mTest;
    }

    public RequestQueue getRequestQueue()
    {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public Tracker getTracker(TrackerName trackername)
    {
        this;
        JVM INSTR monitorenter ;
        if (mTrackers.containsKey(trackername)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = GoogleAnalytics.getInstance(this);
        ((GoogleAnalytics) (obj)).getLogger().setLogLevel(0);
        if (trackername != TrackerName.APP_TRACKER) goto _L4; else goto _L3
_L3:
        obj = ((GoogleAnalytics) (obj)).newTracker("UA-39928332-1");
_L5:
        ((Tracker) (obj)).enableAdvertisingIdCollection(true);
        mTrackers.put(trackername, obj);
_L2:
        trackername = (Tracker)mTrackers.get(trackername);
        this;
        JVM INSTR monitorexit ;
        return trackername;
_L4:
label0:
        {
            if (trackername != TrackerName.GLOBAL_TRACKER)
            {
                break label0;
            }
            obj = ((GoogleAnalytics) (obj)).newTracker(0x7f050001);
        }
          goto _L5
        obj = ((GoogleAnalytics) (obj)).newTracker(0x7f050000);
          goto _L5
        trackername;
        throw trackername;
    }

    public void onCreate()
    {
        super.onCreate();
        Fabric.with(this, new Kit[] {
            new Crashlytics()
        });
        FacebookSdk.sdkInitialize(this);
        LeakCanary.install(this);
        refWatcher = LeakCanary.install(this);
        mTest = new ModelObserver();
        mInstance = this;
    }

    public ModelObserver setObserver()
    {
        return mTest;
    }

}
