// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.Context;
import android.content.Intent;
import com.inponsel.android.utils.Util;

public final class CommonUtilities
{

    public static final String DISPLAY_MESSAGE_ACTION = "com.inponsel.android.DISPLAY_MESSAGE";
    public static final String EXTRA_MESSAGE = "message";
    static final String EXTRA_TITLE = "title";
    public static final String SENDER_ID = "546843258034";
    public static final String SERVER_URL;
    static final String TAG = "InPonesl GCM";

    public CommonUtilities()
    {
    }

    static void displayMessage(Context context, String s, String s1)
    {
        Intent intent = new Intent("com.inponsel.android.DISPLAY_MESSAGE");
        intent.putExtra("message", s);
        intent.putExtra("title", s1);
        context.sendBroadcast(intent);
    }

    static 
    {
        SERVER_URL = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("gcminponsel/register.php").toString();
    }
}
