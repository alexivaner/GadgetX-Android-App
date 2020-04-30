// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.settings;


public class SettingsRequest
{

    public final String advertisingId;
    public final String androidId;
    public final String apiKey;
    public final String buildVersion;
    public final String deviceModel;
    public final String displayVersion;
    public final String iconHash;
    public final String installationId;
    public final String instanceId;
    public final String osBuildVersion;
    public final String osDisplayVersion;
    public final int source;

    public SettingsRequest(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, int i, String s10)
    {
        apiKey = s;
        deviceModel = s1;
        osBuildVersion = s2;
        osDisplayVersion = s3;
        advertisingId = s4;
        installationId = s5;
        androidId = s6;
        instanceId = s7;
        displayVersion = s8;
        buildVersion = s9;
        source = i;
        iconHash = s10;
    }
}
