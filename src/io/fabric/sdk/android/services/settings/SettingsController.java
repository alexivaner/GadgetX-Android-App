// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.settings;


// Referenced classes of package io.fabric.sdk.android.services.settings:
//            SettingsData, SettingsCacheBehavior

public interface SettingsController
{

    public abstract SettingsData loadSettingsData();

    public abstract SettingsData loadSettingsData(SettingsCacheBehavior settingscachebehavior);
}