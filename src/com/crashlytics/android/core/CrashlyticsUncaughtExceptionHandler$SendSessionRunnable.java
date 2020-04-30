// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.Settings;
import java.io.File;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsUncaughtExceptionHandler, CrashlyticsCore, ReportUploader, SessionReport

private static final class fileToSend
    implements Runnable
{

    private final CrashlyticsCore crashlyticsCore;
    private final File fileToSend;

    public void run()
    {
        if (CommonUtils.canTryConnection(crashlyticsCore.getContext()))
        {
            Fabric.getLogger().d("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            Object obj = Settings.getInstance().awaitSettingsData();
            obj = crashlyticsCore.getCreateReportSpiCall(((io.fabric.sdk.android.services.settings.SettingsData) (obj)));
            if (obj != null)
            {
                (new ReportUploader(((CreateReportSpiCall) (obj)))).forceUpload(new SessionReport(fileToSend, CrashlyticsUncaughtExceptionHandler.access$1300()));
                return;
            }
        }
    }

    public (CrashlyticsCore crashlyticscore, File file)
    {
        crashlyticsCore = crashlyticscore;
        fileToSend = file;
    }
}
