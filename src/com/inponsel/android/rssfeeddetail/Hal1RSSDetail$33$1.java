// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ImagePagerActivity;
import com.squareup.picasso.Callback;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class val.img_media
    implements android.view.r
{

    final Activity this$1;
    private final String val$img_media;

    public void onClick(View view)
    {
        view = new ArrayList();
        Object obj = val$img_media;
        obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1);
        Log.e("img_real", ((String) (obj)));
        view.add(((String) (obj)).toString().trim());
        view = (String[])view.toArray(new String[view.size()]);
        obj = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
        ((Intent) (obj)).putExtra("imgUrl", view);
        ((Intent) (obj)).putExtra("pos", 0);
        startActivity(((Intent) (obj)));
    }

    l.img_media()
    {
        this$1 = final_img_media1;
        val$img_media = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$33

/* anonymous class */
    class Hal1RSSDetail._cls33
        implements Callback
    {

        final Hal1RSSDetail this$0;
        private final ImageView val$imgKomentar;
        private final String val$img_media;
        private final RelativeLayout val$ll_img_komen;
        private final ProgressBar val$progressbar_imgkomen;

        public void onError()
        {
            Log.e("ll_img_komen", "onError");
            progressbar_imgkomen.setVisibility(8);
        }

        public void onSuccess()
        {
            Log.e("ll_img_komen", "onSuccess");
            progressbar_imgkomen.setVisibility(8);
            imgKomentar.setVisibility(0);
            ll_img_komen.setClickable(false);
            imgKomentar.setOnClickListener(img_media. new Hal1RSSDetail._cls33._cls1());
        }


            
            {
                this$0 = final_hal1rssdetail;
                progressbar_imgkomen = progressbar;
                imgKomentar = imageview;
                ll_img_komen = relativelayout;
                img_media = String.this;
                super();
            }
    }

}
