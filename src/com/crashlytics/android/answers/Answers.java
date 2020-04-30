// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManager, AddToCartEvent, ContentViewEvent, CustomEvent, 
//            InviteEvent, LevelEndEvent, LevelStartEvent, LoginEvent, 
//            PurchaseEvent, RatingEvent, SearchEvent, ShareEvent, 
//            SignUpEvent, StartCheckoutEvent

public class Answers extends Kit
{

    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    public static final String TAG = "Answers";
    SessionAnalyticsManager analyticsManager;

    public Answers()
    {
    }

    public static Answers getInstance()
    {
        return (Answers)Fabric.getKit(com/crashlytics/android/answers/Answers);
    }

    protected Boolean doInBackground()
    {
        SettingsData settingsdata;
        try
        {
            settingsdata = Settings.getInstance().awaitSettingsData();
        }
        catch (Exception exception)
        {
            Fabric.getLogger().e("Answers", "Error dealing with settings", exception);
            return Boolean.valueOf(false);
        }
        if (settingsdata != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        Fabric.getLogger().e("Answers", "Failed to retrieve settings");
        return Boolean.valueOf(false);
        if (settingsdata.featuresData.collectAnalytics)
        {
            Fabric.getLogger().d("Answers", "Analytics collection enabled");
            analyticsManager.setAnalyticsSettingsData(settingsdata.analyticsSettingsData, getOverridenSpiEndpoint());
            return Boolean.valueOf(true);
        }
        Fabric.getLogger().d("Answers", "Analytics collection disabled");
        analyticsManager.disable();
        return Boolean.valueOf(false);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android:answers";
    }

    String getOverridenSpiEndpoint()
    {
        return CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
    }

    public String getVersion()
    {
        return "1.3.6.97";
    }

    public void logAddToCart(AddToCartEvent addtocartevent)
    {
        if (addtocartevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(addtocartevent);
        }
    }

    public void logContentView(ContentViewEvent contentviewevent)
    {
        if (contentviewevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(contentviewevent);
        }
    }

    public void logCustom(CustomEvent customevent)
    {
        if (customevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onCustom(customevent);
        }
    }

    public void logInvite(InviteEvent inviteevent)
    {
        if (inviteevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(inviteevent);
        }
    }

    public void logLevelEnd(LevelEndEvent levelendevent)
    {
        if (levelendevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(levelendevent);
        }
    }

    public void logLevelStart(LevelStartEvent levelstartevent)
    {
        if (levelstartevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(levelstartevent);
        }
    }

    public void logLogin(LoginEvent loginevent)
    {
        if (loginevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(loginevent);
        }
    }

    public void logPurchase(PurchaseEvent purchaseevent)
    {
        if (purchaseevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(purchaseevent);
        }
    }

    public void logRating(RatingEvent ratingevent)
    {
        if (ratingevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(ratingevent);
        }
    }

    public void logSearch(SearchEvent searchevent)
    {
        if (searchevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(searchevent);
        }
    }

    public void logShare(ShareEvent shareevent)
    {
        if (shareevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(shareevent);
        }
    }

    public void logSignUp(SignUpEvent signupevent)
    {
        if (signupevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(signupevent);
        }
    }

    public void logStartCheckout(StartCheckoutEvent startcheckoutevent)
    {
        if (startcheckoutevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(startcheckoutevent);
        }
    }

    public void onException(io.fabric.sdk.android.services.common.Crash.FatalException fatalexception)
    {
        if (analyticsManager != null)
        {
            analyticsManager.onCrash(fatalexception.getSessionId());
        }
    }

    public void onException(io.fabric.sdk.android.services.common.Crash.LoggedException loggedexception)
    {
        if (analyticsManager != null)
        {
            analyticsManager.onError(loggedexception.getSessionId());
        }
    }

    protected boolean onPreExecute()
    {
        Context context;
        PackageManager packagemanager;
        String s1;
        PackageInfo packageinfo;
        String s2;
        context = getContext();
        packagemanager = context.getPackageManager();
        s1 = context.getPackageName();
        packageinfo = packagemanager.getPackageInfo(s1, 0);
        s2 = Integer.toString(packageinfo.versionCode);
        String s;
        long l;
        if (packageinfo.versionName == null)
        {
            s = "0.0";
        } else
        {
            try
            {
                s = packageinfo.versionName;
            }
            catch (Exception exception)
            {
                Fabric.getLogger().e("Answers", "Error retrieving app properties", exception);
                return false;
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        l = packageinfo.firstInstallTime;
_L1:
        analyticsManager = SessionAnalyticsManager.build(this, context, getIdManager(), s2, s, l);
        analyticsManager.enable();
        return true;
        l = (new File(packagemanager.getApplicationInfo(s1, 0).sourceDir)).lastModified();
          goto _L1
    }
}
