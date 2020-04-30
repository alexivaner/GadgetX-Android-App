// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.crashlytics.android.core:
//            UnityVersionProvider

class ManifestUnityVersionProvider
    implements UnityVersionProvider
{

    static final String FABRIC_UNITY_CRASHLYTICS_VERSION_KEY = "io.fabric.unity.crashlytics.version";
    private final Context context;
    private final String packageName;

    public ManifestUnityVersionProvider(Context context1, String s)
    {
        context = context1;
        packageName = s;
    }

    public String getUnityVersion()
    {
        String s = null;
        Object obj = context.getPackageManager();
        try
        {
            obj = ((PackageManager) (obj)).getApplicationInfo(packageName, 128).metaData;
        }
        catch (Exception exception)
        {
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        s = ((Bundle) (obj)).getString("io.fabric.unity.crashlytics.version");
        return s;
    }
}
