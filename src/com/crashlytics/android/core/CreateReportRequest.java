// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;


// Referenced classes of package com.crashlytics.android.core:
//            Report

class CreateReportRequest
{

    public final String apiKey;
    public final Report report;

    public CreateReportRequest(String s, Report report1)
    {
        apiKey = s;
        report = report1;
    }
}