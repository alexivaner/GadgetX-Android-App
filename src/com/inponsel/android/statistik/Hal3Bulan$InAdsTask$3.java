// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.v2.SCUserActivity;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal3Bulan

class this._cls1
    implements android.view.Bulan.InAdsTask._cls3
{

    final y this$1;

    public void onClick(View view)
    {
        if (cess._mth3(this._cls1.this).link_ads.contains("play.google.com"))
        {
            try
            {
                cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(cess._mth3(this._cls1.this).link_ads.substring(cess._mth3(this._cls1.this).link_ads.lastIndexOf("id=") + 3)).toString())));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(cess._mth3(this._cls1.this).link_ads.substring(cess._mth3(this._cls1.this).link_ads.lastIndexOf("id=") + 3)).toString())));
            }
            return;
        }
        if (cess._mth3(this._cls1.this).ads_method.equals("activity"))
        {
            view = new Intent(cess._mth3(this._cls1.this).getActivity(), com/inponsel/android/v2/SCUserActivity);
            view.putExtra("activity", "main");
            cess._mth3(this._cls1.this).startActivityForResult(view, 0);
            cess._mth3(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (cess._mth3(this._cls1.this).ads_method.toLowerCase().equals("ponsel"))
        {
            view = new Intent(cess._mth3(this._cls1.this).getActivity(), com/inponsel/android/details/DetailsPonsel);
            view.putExtra("id_hph", cess._mth3(this._cls1.this).link_ads);
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
            cess._mth3(this._cls1.this).startActivityForResult(view, 0);
            cess._mth3(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        } else
        {
            view = new Intent("android.intent.action.VIEW");
            view.setData(Uri.parse(cess._mth3(this._cls1.this).link_ads.replaceAll(" ", "")));
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
