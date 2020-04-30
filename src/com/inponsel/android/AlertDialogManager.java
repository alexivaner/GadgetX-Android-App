// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager
{

    public AlertDialogManager()
    {
    }

    public void showAlertDialog(Context context, String s, String s1, Boolean boolean1)
    {
        context = (new android.app.AlertDialog.Builder(context)).create();
        context.setTitle(s);
        context.setMessage(s1);
        if (boolean1 != null)
        {
            if (!boolean1.booleanValue());
            context.setIcon(0x7f020208);
        }
        context.setButton("OK", new android.content.DialogInterface.OnClickListener() {

            final AlertDialogManager this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = AlertDialogManager.this;
                super();
            }
        });
        context.show();
    }
}
