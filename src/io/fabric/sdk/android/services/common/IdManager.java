// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package io.fabric.sdk.android.services.common:
//            InstallerPackageNameProvider, AdvertisingInfoProvider, CommonUtils, AdvertisingInfo, 
//            DeviceIdentifierProvider

public class IdManager
{
    public static final class DeviceIdentifierType extends Enum
    {

        private static final DeviceIdentifierType $VALUES[];
        public static final DeviceIdentifierType ANDROID_ADVERTISING_ID;
        public static final DeviceIdentifierType ANDROID_DEVICE_ID;
        public static final DeviceIdentifierType ANDROID_ID;
        public static final DeviceIdentifierType ANDROID_SERIAL;
        public static final DeviceIdentifierType BLUETOOTH_MAC_ADDRESS;
        public static final DeviceIdentifierType FONT_TOKEN;
        public static final DeviceIdentifierType WIFI_MAC_ADDRESS;
        public final int protobufIndex;

        public static DeviceIdentifierType valueOf(String s)
        {
            return (DeviceIdentifierType)Enum.valueOf(io/fabric/sdk/android/services/common/IdManager$DeviceIdentifierType, s);
        }

        public static DeviceIdentifierType[] values()
        {
            return (DeviceIdentifierType[])$VALUES.clone();
        }

        static 
        {
            WIFI_MAC_ADDRESS = new DeviceIdentifierType("WIFI_MAC_ADDRESS", 0, 1);
            BLUETOOTH_MAC_ADDRESS = new DeviceIdentifierType("BLUETOOTH_MAC_ADDRESS", 1, 2);
            FONT_TOKEN = new DeviceIdentifierType("FONT_TOKEN", 2, 53);
            ANDROID_ID = new DeviceIdentifierType("ANDROID_ID", 3, 100);
            ANDROID_DEVICE_ID = new DeviceIdentifierType("ANDROID_DEVICE_ID", 4, 101);
            ANDROID_SERIAL = new DeviceIdentifierType("ANDROID_SERIAL", 5, 102);
            ANDROID_ADVERTISING_ID = new DeviceIdentifierType("ANDROID_ADVERTISING_ID", 6, 103);
            $VALUES = (new DeviceIdentifierType[] {
                WIFI_MAC_ADDRESS, BLUETOOTH_MAC_ADDRESS, FONT_TOKEN, ANDROID_ID, ANDROID_DEVICE_ID, ANDROID_SERIAL, ANDROID_ADVERTISING_ID
            });
        }

        private DeviceIdentifierType(String s, int i, int j)
        {
            super(s, i);
            protobufIndex = j;
        }
    }


    private static final String BAD_ANDROID_ID = "9774d56d682e549c";
    public static final String COLLECT_DEVICE_IDENTIFIERS = "com.crashlytics.CollectDeviceIdentifiers";
    public static final String COLLECT_USER_IDENTIFIERS = "com.crashlytics.CollectUserIdentifiers";
    public static final String DEFAULT_VERSION_NAME = "0.0";
    private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    private static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    AdvertisingInfo advertisingInfo;
    AdvertisingInfoProvider advertisingInfoProvider;
    private final Context appContext;
    private final String appIdentifier;
    private final String appInstallIdentifier;
    private final boolean collectHardwareIds;
    private final boolean collectUserIds;
    boolean fetchedAdvertisingInfo;
    private final ReentrantLock installationIdLock = new ReentrantLock();
    private final InstallerPackageNameProvider installerPackageNameProvider = new InstallerPackageNameProvider();
    private final Collection kits;

    public IdManager(Context context, String s, String s1, Collection collection)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null)
        {
            throw new IllegalArgumentException("kits must not be null");
        }
        appContext = context;
        appIdentifier = s;
        appInstallIdentifier = s1;
        kits = collection;
        advertisingInfoProvider = new AdvertisingInfoProvider(context);
        collectHardwareIds = CommonUtils.getBooleanResourceValue(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!collectHardwareIds)
        {
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Device ID collection disabled for ").append(context.getPackageName()).toString());
        }
        collectUserIds = CommonUtils.getBooleanResourceValue(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!collectUserIds)
        {
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("User information collection disabled for ").append(context.getPackageName()).toString());
        }
    }

    private String createInstallationUUID(SharedPreferences sharedpreferences)
    {
        installationIdLock.lock();
        String s1 = sharedpreferences.getString("crashlytics.installation.id", null);
        String s;
        s = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        s = formatId(UUID.randomUUID().toString());
        sharedpreferences.edit().putString("crashlytics.installation.id", s).commit();
        installationIdLock.unlock();
        return s;
        sharedpreferences;
        installationIdLock.unlock();
        throw sharedpreferences;
    }

    private String formatId(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return ID_PATTERN.matcher(s).replaceAll("").toLowerCase(Locale.US);
        }
    }

    private void putNonNullIdInto(Map map, DeviceIdentifierType deviceidentifiertype, String s)
    {
        if (s != null)
        {
            map.put(deviceidentifiertype, s);
        }
    }

    private String removeForwardSlashesIn(String s)
    {
        return s.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public boolean canCollectUserIds()
    {
        return collectUserIds;
    }

    public String createIdHeaderValue(String s, String s1)
    {
        return "";
    }

    public String getAdvertisingId()
    {
        Object obj = null;
        String s = obj;
        if (collectHardwareIds)
        {
            AdvertisingInfo advertisinginfo = getAdvertisingInfo();
            s = obj;
            if (advertisinginfo != null)
            {
                s = advertisinginfo.advertisingId;
            }
        }
        return s;
    }

    AdvertisingInfo getAdvertisingInfo()
    {
        this;
        JVM INSTR monitorenter ;
        AdvertisingInfo advertisinginfo;
        if (!fetchedAdvertisingInfo)
        {
            advertisingInfo = advertisingInfoProvider.getAdvertisingInfo();
            fetchedAdvertisingInfo = true;
        }
        advertisinginfo = advertisingInfo;
        this;
        JVM INSTR monitorexit ;
        return advertisinginfo;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAndroidId()
    {
        Object obj = null;
        String s = obj;
        if (collectHardwareIds)
        {
            String s1 = android.provider.Settings.Secure.getString(appContext.getContentResolver(), "android_id");
            s = obj;
            if (!"9774d56d682e549c".equals(s1))
            {
                s = formatId(s1);
            }
        }
        return s;
    }

    public String getAppIdentifier()
    {
        return appIdentifier;
    }

    public String getAppInstallIdentifier()
    {
        String s1 = appInstallIdentifier;
        String s = s1;
        if (s1 == null)
        {
            SharedPreferences sharedpreferences = CommonUtils.getSharedPrefs(appContext);
            String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
            s = s2;
            if (s2 == null)
            {
                s = createInstallationUUID(sharedpreferences);
            }
        }
        return s;
    }

    public String getBluetoothMacAddress()
    {
        return null;
    }

    public Map getDeviceIdentifiers()
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = kits.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (Kit)iterator.next();
            if (obj instanceof DeviceIdentifierProvider)
            {
                obj = ((DeviceIdentifierProvider)obj).getDeviceIdentifiers().entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    putNonNullIdInto(hashmap, (DeviceIdentifierType)entry.getKey(), (String)entry.getValue());
                }
            }
        } while (true);
        putNonNullIdInto(hashmap, DeviceIdentifierType.ANDROID_ID, getAndroidId());
        putNonNullIdInto(hashmap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, getAdvertisingId());
        return Collections.unmodifiableMap(hashmap);
    }

    public String getDeviceUUID()
    {
        String s = "";
        if (collectHardwareIds)
        {
            String s1 = getAndroidId();
            s = s1;
            if (s1 == null)
            {
                SharedPreferences sharedpreferences = CommonUtils.getSharedPrefs(appContext);
                String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
                s = s2;
                if (s2 == null)
                {
                    s = createInstallationUUID(sharedpreferences);
                }
            }
        }
        return s;
    }

    public String getInstallerPackageName()
    {
        return installerPackageNameProvider.getInstallerPackageName(appContext);
    }

    public String getModelName()
    {
        return String.format(Locale.US, "%s/%s", new Object[] {
            removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL)
        });
    }

    public String getOsBuildVersionString()
    {
        return removeForwardSlashesIn(android.os.Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString()
    {
        return removeForwardSlashesIn(android.os.Build.VERSION.RELEASE);
    }

    public String getOsVersionString()
    {
        return (new StringBuilder()).append(getOsDisplayVersionString()).append("/").append(getOsBuildVersionString()).toString();
    }

    public String getSerialNumber()
    {
        return null;
    }

    public String getTelephonyId()
    {
        return null;
    }

    public String getWifiMacAddress()
    {
        return null;
    }

    public Boolean isLimitAdTrackingEnabled()
    {
        Object obj = null;
        Boolean boolean1 = obj;
        if (collectHardwareIds)
        {
            AdvertisingInfo advertisinginfo = getAdvertisingInfo();
            boolean1 = obj;
            if (advertisinginfo != null)
            {
                boolean1 = Boolean.valueOf(advertisinginfo.limitAdTrackingEnabled);
            }
        }
        return boolean1;
    }

}
