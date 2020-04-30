// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package io.fabric.sdk.android.services.settings:
//            SettingsSpiCall, SettingsRequest

class DefaultSettingsSpiCall extends AbstractSpiCall
    implements SettingsSpiCall
{

    static final String BUILD_VERSION_PARAM = "build_version";
    static final String DISPLAY_VERSION_PARAM = "display_version";
    static final String HEADER_ADVERTISING_TOKEN = "X-CRASHLYTICS-ADVERTISING-TOKEN";
    static final String HEADER_ANDROID_ID = "X-CRASHLYTICS-ANDROID-ID";
    static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
    static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
    static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
    static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
    static final String ICON_HASH = "icon_hash";
    static final String INSTANCE_PARAM = "instance";
    static final String SOURCE_PARAM = "source";

    public DefaultSettingsSpiCall(Kit kit, String s, String s1, HttpRequestFactory httprequestfactory)
    {
        this(kit, s, s1, httprequestfactory, HttpMethod.GET);
    }

    DefaultSettingsSpiCall(Kit kit, String s, String s1, HttpRequestFactory httprequestfactory, HttpMethod httpmethod)
    {
        super(kit, s, s1, httprequestfactory, httpmethod);
    }

    private HttpRequest applyHeadersTo(HttpRequest httprequest, SettingsRequest settingsrequest)
    {
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-API-KEY", settingsrequest.apiKey);
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion());
        applyNonNullHeader(httprequest, "Accept", "application/json");
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsrequest.deviceModel);
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsrequest.osBuildVersion);
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsrequest.osDisplayVersion);
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", settingsrequest.advertisingId);
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsrequest.installationId);
        applyNonNullHeader(httprequest, "X-CRASHLYTICS-ANDROID-ID", settingsrequest.androidId);
        return httprequest;
    }

    private void applyNonNullHeader(HttpRequest httprequest, String s, String s1)
    {
        if (s1 != null)
        {
            httprequest.header(s, s1);
        }
    }

    private JSONObject getJsonObjectFrom(String s)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(s);
        }
        catch (Exception exception)
        {
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Failed to parse settings JSON from ").append(getUrl()).toString(), exception);
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Settings response ").append(s).toString());
            return null;
        }
        return jsonobject;
    }

    private Map getQueryParamsFor(SettingsRequest settingsrequest)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("build_version", settingsrequest.buildVersion);
        hashmap.put("display_version", settingsrequest.displayVersion);
        hashmap.put("source", Integer.toString(settingsrequest.source));
        if (settingsrequest.iconHash != null)
        {
            hashmap.put("icon_hash", settingsrequest.iconHash);
        }
        settingsrequest = settingsrequest.instanceId;
        if (!CommonUtils.isNullOrEmpty(settingsrequest))
        {
            hashmap.put("instance", settingsrequest);
        }
        return hashmap;
    }

    JSONObject handleResponse(HttpRequest httprequest)
    {
        int i = httprequest.code();
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Settings result was: ").append(i).toString());
        if (requestWasSuccessful(i))
        {
            return getJsonObjectFrom(httprequest.body());
        } else
        {
            Fabric.getLogger().e("Fabric", (new StringBuilder()).append("Failed to retrieve settings from ").append(getUrl()).toString());
            return null;
        }
    }

    public JSONObject invoke(SettingsRequest settingsrequest)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        Map map = getQueryParamsFor(settingsrequest);
        obj = obj1;
        obj1 = getHttpRequest(map);
        obj = obj1;
        settingsrequest = applyHeadersTo(((HttpRequest) (obj1)), settingsrequest);
        obj = settingsrequest;
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Requesting settings from ").append(getUrl()).toString());
        obj = settingsrequest;
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Settings query params were: ").append(map).toString());
        obj = settingsrequest;
        obj1 = handleResponse(settingsrequest);
        if (settingsrequest != null)
        {
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Settings request ID: ").append(settingsrequest.header("X-REQUEST-ID")).toString());
        }
        return ((JSONObject) (obj1));
        settingsrequest;
        if (obj != null)
        {
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Settings request ID: ").append(((HttpRequest) (obj)).header("X-REQUEST-ID")).toString());
        }
        throw settingsrequest;
    }

    boolean requestWasSuccessful(int i)
    {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }
}
