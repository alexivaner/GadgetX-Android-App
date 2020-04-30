// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

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

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class val.imgKomentar
    implements android.view.ionDetailActivity._cls23
{

    final ConversationDetailActivity this$0;
    private final ImageView val$imgKomentar;
    private final String val$img_media;
    private final RelativeLayout val$ll_img_komen;
    private final ProgressBar val$progressbar_imgkomen;
    private final TextView val$txtTapImage;

    public void onClick(View view)
    {
        Log.e("ll_img_komen", val$img_media);
        val$txtTapImage.setVisibility(8);
        val$progressbar_imgkomen.setVisibility(0);
        val$ll_img_komen.setVisibility(0);
        Picasso.with(getApplicationContext()).load(val$img_media.trim()).into(val$imgKomentar, new Callback() {

            final ConversationDetailActivity._cls23 this$1;
            private final ImageView val$imgKomentar;
            private final String val$img_media;
            private final RelativeLayout val$ll_img_komen;
            private final ProgressBar val$progressbar_imgkomen;

            public void onError()
            {
                Log.e("ll_img_komen", "onError");
                progressbar_imgkomen.setVisibility(8);
                Toast.makeText(getApplicationContext(), "Gagal memuat gambar", 1).show();
            }

            public void onSuccess()
            {
                Log.e("ll_img_komen", "onSuccess");
                progressbar_imgkomen.setVisibility(8);
                imgKomentar.setVisibility(0);
                ll_img_komen.setClickable(false);
                imgKomentar.setOnClickListener(img_media. new android.view.View.OnClickListener() {

                    final _cls1 this$2;
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
                this$2 = final__pcls1;
                img_media = String.this;
                super();
            }
                });
            }


            
            {
                this$1 = ConversationDetailActivity._cls23.this;
                progressbar_imgkomen = progressbar;
                imgKomentar = imageview;
                ll_img_komen = relativelayout;
                img_media = s;
                super();
            }
        });
    }


    _cls1.val.img_media()
    {
        this$0 = final_conversationdetailactivity;
        val$img_media = s;
        val$txtTapImage = textview;
        val$progressbar_imgkomen = progressbar;
        val$ll_img_komen = relativelayout;
        val$imgKomentar = ImageView.this;
        super();
    }
}
