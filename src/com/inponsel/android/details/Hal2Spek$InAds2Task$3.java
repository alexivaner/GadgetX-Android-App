// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.v2.SCUserActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls1
    implements android.view.ek.InAds2Task._cls3
{

    final  this$1;

    public void onClick(View view)
    {
        if (cess._mth3(this._cls1.this).link_ads2.contains("play.google.com"))
        {
            try
            {
                cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(cess._mth3(this._cls1.this).link_ads2.substring(cess._mth3(this._cls1.this).link_ads2.lastIndexOf("id=") + 3)).toString())));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(cess._mth3(this._cls1.this).link_ads2.substring(cess._mth3(this._cls1.this).link_ads2.lastIndexOf("id=") + 3)).toString())));
            }
            return;
        }
        if (cess._mth3(this._cls1.this).ads_method2.equals("activity"))
        {
            view = new Intent(cess._mth3(this._cls1.this).getActivity(), com/inponsel/android/v2/SCUserActivity);
            view.putExtra("activity", "main");
            cess._mth3(this._cls1.this).startActivityForResult(view, 0);
            cess._mth3(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        } else
        {
            view = new Intent("android.intent.action.VIEW");
            view.setData(Uri.parse(cess._mth3(this._cls1.this).link_ads2.replaceAll(" ", "")));
            cess._mth3(this._cls1.this).startActivity(view);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
