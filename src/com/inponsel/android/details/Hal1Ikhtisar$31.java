// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import com.inponsel.android.v2.SCUserActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar, DetailsPonsel

class this._cls0
    implements android.view.ener
{

    final Hal1Ikhtisar this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (link_ads.contains("play.google.com"))
        {
            try
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                return false;
            }
            return false;
        }
        if (ads_method.equals("activity"))
        {
            view = new Intent(getActivity(), com/inponsel/android/v2/SCUserActivity);
            view.putExtra("activity", "main");
            startActivityForResult(view, 0);
            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return false;
        }
        if (ads_method.toLowerCase().equals("ponsel"))
        {
            view = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
            view.putExtra("id_hph", link_ads);
            view.putExtra("namalengkap", "");
            view.putExtra("codename", "");
            view.putExtra("model", "");
            view.putExtra("merk", "");
            view.putExtra("gambar", "");
            view.putExtra("hrg_baru", "");
            view.putExtra("hrg_bekas", "");
            view.putExtra("tot_like", "");
            view.putExtra("tot_dislike", "");
            view.putExtra("tot_komen", "");
            startActivityForResult(view, 0);
            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return false;
        } else
        {
            view = new Intent("android.intent.action.VIEW");
            view.setData(Uri.parse(link_ads.replaceAll(" ", "")));
            startActivity(view);
            return false;
        }
    }

    ()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
