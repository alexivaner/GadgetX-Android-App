// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AnswersPreferenceManager
{

    static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
    static final String PREF_STORE_NAME = "settings";
    private final PreferenceStore prefStore;

    AnswersPreferenceManager(PreferenceStore preferencestore)
    {
        prefStore = preferencestore;
    }

    public static AnswersPreferenceManager build(Context context)
    {
        return new AnswersPreferenceManager(new PreferenceStoreImpl(context, "settings"));
    }

    public boolean hasAnalyticsLaunched()
    {
        return prefStore.get().getBoolean("analytics_launched", false);
    }

    public void setAnalyticsLaunched()
    {
        prefStore.save(prefStore.edit().putBoolean("analytics_launched", true));
    }
}
