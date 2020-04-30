// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.nostra13.universalimageloader.core.ImageLoader;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements android.view.ner
{

    final Hal1RSSDetail this$0;

    public void onClick(View view)
    {
        Log.e("count_img", String.valueOf(count_img));
        btn_tampilkan_gambar.setVisibility(8);
        if (count_img > 1)
        {
            web_rss_srclink.getSettings().setBlockNetworkLoads(false);
            web_rss_srclink.getSettings().setLoadsImagesAutomatically(true);
            imgRSS.setVisibility(8);
            return;
        } else
        {
            imgRSS.setVisibility(0);
            web_rss_srclink.getSettings().setBlockNetworkLoads(false);
            web_rss_srclink.getSettings().setLoadsImagesAutomatically(true);
            view = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(view);
            int i = ((DisplayMetrics) (view)).widthPixels;
            imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(str_imgurl.trim()).toString(), imgRSS, Hal1RSSDetail.access$7(Hal1RSSDetail.this), Hal1RSSDetail.access$8(Hal1RSSDetail.this));
            return;
        }
    }

    _cls9()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
