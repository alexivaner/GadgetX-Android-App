// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseImageActivity extends FragmentActivity
{

    private boolean instanceStateSaved;

    public BaseImageActivity()
    {
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        instanceStateSaved = true;
    }
}
