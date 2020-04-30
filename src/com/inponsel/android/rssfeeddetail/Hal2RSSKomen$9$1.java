// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ImagePagerActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen

class val.img_media
    implements Callback
{

    final tActivity this$1;
    private final ImageView val$imgKomentar;
    private final String val$img_media;
    private final RelativeLayout val$ll_img_komen;
    private final ProgressBar val$progressbar_imgkomen;

    public void onError()
    {
        Log.e("ll_img_komen", "onError");
        val$progressbar_imgkomen.setVisibility(8);
        Toast.makeText(getActivity(), "Gagal memuat gambar", 1).show();
    }

    public void onSuccess()
    {
        Log.e("ll_img_komen", "onSuccess");
        val$progressbar_imgkomen.setVisibility(8);
        val$imgKomentar.setVisibility(0);
        val$ll_img_komen.setClickable(false);
        val$imgKomentar.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2RSSKomen._cls9._cls1 this$2;
            private final String val$img_media;

            public void onClick(View view)
            {
                view = new ArrayList();
                Object obj = img_media;
                obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1);
                Log.e("img_real", ((String) (obj)));
                view.add(((String) (obj)).toString().trim());
                view = (String[])view.toArray(new String[view.size()]);
                obj = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                ((Intent) (obj)).putExtra("imgUrl", view);
                ((Intent) (obj)).putExtra("pos", 0);
                startActivity(((Intent) (obj)));
            }

            
            {
                this$2 = Hal2RSSKomen._cls9._cls1.this;
                img_media = s;
                super();
            }
        });
    }


    l.imgKomentar()
    {
        this$1 = final_imgkomentar;
        val$progressbar_imgkomen = progressbar;
        val$imgKomentar = imageview;
        val$ll_img_komen = relativelayout;
        val$img_media = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal2RSSKomen$9

/* anonymous class */
    class Hal2RSSKomen._cls9
        implements android.view.View.OnClickListener
    {

        final Hal2RSSKomen this$0;
        private final ImageView val$imgKomentar;
        private final String val$img_media;
        private final RelativeLayout val$ll_img_komen;
        private final ProgressBar val$progressbar_imgkomen;
        private final TextView val$txtTapImage;

        public void onClick(View view)
        {
            Log.e("ll_img_komen", img_media);
            txtTapImage.setVisibility(8);
            progressbar_imgkomen.setVisibility(0);
            ll_img_komen.setVisibility(0);
            Picasso.with(getActivity()).load(img_media.trim()).into(imgKomentar, img_media. new Hal2RSSKomen._cls9._cls1());
        }


            
            {
                this$0 = final_hal2rsskomen;
                img_media = s;
                txtTapImage = textview;
                progressbar_imgkomen = progressbar;
                ll_img_komen = relativelayout;
                imgKomentar = ImageView.this;
                super();
            }
    }

}
