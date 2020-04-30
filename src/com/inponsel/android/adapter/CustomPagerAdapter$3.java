// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.inponsel.android.statistik.StatistikPonsel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.DaftarPonselMerkActivity;
import com.inponsel.android.v2.RSSFeedByTag;
import com.inponsel.android.v2.SCMerkActivity;
import com.inponsel.android.v2.TurunHargaPonselActivity;

// Referenced classes of package com.inponsel.android.adapter:
//            CustomPagerAdapter, ListModel

class val.lms
    implements android.view.mPagerAdapter._cls3
{

    final CustomPagerAdapter this$0;
    private final ListModel val$lms;

    public void onClick(View view)
    {
        Log.e("method", val$lms.getAds_link().toLowerCase());
        if (!val$lms.getAds_method().toLowerCase().contains("activity")) goto _L2; else goto _L1
_L1:
        if (!val$lms.getAds_link().toLowerCase().contains("pencarian/rinci")) goto _L4; else goto _L3
_L3:
        view = new Intent(activity, com/inponsel/android/v2/DaftarPonselMerkActivity);
        view.putExtra("merk", "");
        view.putExtra("titlemerek", val$lms.getAds_link());
        view.putExtra("cover_img", val$lms.getAds_cover());
        activity.startActivityForResult(view, 0);
        activity.overridePendingTransition(0x7f040003, 0x7f040004);
_L6:
        return;
_L4:
        if (val$lms.getAds_link().toLowerCase().contains("turun-harga"))
        {
            view = new Intent(activity, com/inponsel/android/v2/TurunHargaPonselActivity);
            activity.startActivityForResult(view, 0);
            activity.overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (val$lms.getAds_link().toLowerCase().contains("news_"))
        {
            String as[] = val$lms.getAds_link().split("_");
            view = as[1];
            String s = as[2];
            Intent intent2 = new Intent(activity, com/inponsel/android/v2/RSSFeedByTag);
            intent2.putExtra("tag_code", "0");
            intent2.putExtra("tag_key", view);
            intent2.putExtra("kategori_tag", s);
            activity.startActivityForResult(intent2, 0);
            activity.overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (val$lms.getAds_link().toLowerCase().contains("pencarian/service-center"))
        {
            view = val$lms.getAds_link().split("vendor=")[1];
            Intent intent = new Intent(activity, com/inponsel/android/v2/SCMerkActivity);
            intent.putExtra("sc_id_merk", view);
            activity.startActivityForResult(intent, 0);
            activity.overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (val$lms.getAds_link().toLowerCase().contains("statistikhp"))
        {
            view = val$lms.getAds_link().split("statistikhp_")[1];
            Intent intent1 = new Intent(activity, com/inponsel/android/statistik/StatistikPonsel);
            intent1.putExtra("pager_pos", view);
            activity.startActivityForResult(intent1, 0);
            activity.overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (val$lms.getAds_method().toLowerCase().contains("download"))
        {
            view = val$lms.getAds_link().split("details?id=")[1];
            try
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(view).toString())));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(val$lms.getAds_link())));
            }
            return;
        }
        if (val$lms.getAds_method().toLowerCase().contains("email"))
        {
            view = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", val$lms.getAds_link(), null));
            view.putExtra("android.intent.extra.SUBJECT", "");
            view.putExtra("android.intent.extra.TEXT", "");
            activity.startActivity(Intent.createChooser(view, "Send email..."));
            return;
        }
        if (val$lms.getAds_method().toLowerCase().contains("direct"))
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(val$lms.getAds_link())));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        this$0 = final_custompageradapter;
        val$lms = ListModel.this;
        super();
    }
}
