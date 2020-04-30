// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ImagePagerActivity;
import com.squareup.picasso.Callback;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class val.img_media
    implements Callback
{

    final Hal1TLDetailActivity this$0;
    private final ImageView val$imgKomentar;
    private final String val$img_media;
    private final RelativeLayout val$ll_img_komen;
    private final ProgressBar val$progressbar_imgkomen;

    public void onError()
    {
        Log.e("ll_img_komen", "onError");
        val$progressbar_imgkomen.setVisibility(8);
    }

    public void onSuccess()
    {
        Log.e("ll_img_komen", "onSuccess");
        val$progressbar_imgkomen.setVisibility(8);
        val$imgKomentar.setVisibility(0);
        val$ll_img_komen.setClickable(false);
        val$imgKomentar.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1TLDetailActivity._cls24 this$1;
            private final String val$img_media;

            public void onClick(View view)
            {
                view = new ArrayList();
                Object obj = img_media;
                obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1);
                Log.e("img_real", ((String) (obj)));
                view.add(((String) (obj)).toString().trim());
                view = (String[])view.toArray(new String[view.size()]);
                obj = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
                ((Intent) (obj)).putExtra("imgUrl", view);
                ((Intent) (obj)).putExtra("pos", 0);
                startActivity(((Intent) (obj)));
            }

            
            {
                this$1 = Hal1TLDetailActivity._cls24.this;
                img_media = s;
                super();
            }
        });
    }


    _cls1.val.img_media()
    {
        this$0 = final_hal1tldetailactivity;
        val$progressbar_imgkomen = progressbar;
        val$imgKomentar = imageview;
        val$ll_img_komen = relativelayout;
        val$img_media = String.this;
        super();
    }
}
