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

class val.img_media_to
    implements android.view.etailActivity._cls24._cls1._cls1
{

    final tivity this$2;
    private final String val$img_media_to;

    public void onClick(View view)
    {
        view = new ArrayList();
        Object obj = val$img_media_to;
        view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
        view = (String[])view.toArray(new String[view.size()]);
        obj = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
        ((Intent) (obj)).putExtra("imgUrl", view);
        ((Intent) (obj)).putExtra("pos", 0);
        startActivity(((Intent) (obj)));
    }

    imgKomentar_rep()
    {
        this$2 = final_imgkomentar_rep;
        val$img_media_to = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$24

/* anonymous class */
    class ConversationDetailActivity._cls24
        implements android.view.View.OnClickListener
    {

        final ConversationDetailActivity this$0;
        private final ImageView val$imgKomentar_rep;
        private final String val$img_media;
        private final String val$img_media_to;
        private final RelativeLayout val$ll_img_komen_rep;
        private final ProgressBar val$progressbar_imgkomenrep;
        private final TextView val$txtTapImageRep;

        public void onClick(View view)
        {
            Log.e("ll_img_komen_rep", img_media);
            ll_img_komen_rep.setVisibility(0);
            txtTapImageRep.setVisibility(8);
            progressbar_imgkomenrep.setVisibility(0);
            try
            {
                Picasso.with(getApplicationContext()).load(img_media_to.trim()).into(imgKomentar_rep, img_media_to. new ConversationDetailActivity._cls24._cls1());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
        }


            
            {
                this$0 = final_conversationdetailactivity;
                img_media = s;
                ll_img_komen_rep = relativelayout;
                txtTapImageRep = textview;
                progressbar_imgkomenrep = progressbar;
                img_media_to = s1;
                imgKomentar_rep = ImageView.this;
                super();
            }
    }


    // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$24$1

/* anonymous class */
    class ConversationDetailActivity._cls24._cls1
        implements Callback
    {

        final ConversationDetailActivity._cls24 this$1;
        private final ImageView val$imgKomentar_rep;
        private final String val$img_media_to;
        private final RelativeLayout val$ll_img_komen_rep;
        private final ProgressBar val$progressbar_imgkomenrep;
        private final TextView val$txtTapImageRep;

        public void onError()
        {
            Log.e("ll_img_komen_rep", "onError");
            txtTapImageRep.setVisibility(0);
            progressbar_imgkomenrep.setVisibility(8);
            Toast.makeText(getApplicationContext(), "Gagal memuat gambar", 1).show();
        }

        public void onSuccess()
        {
            Log.e("ll_img_komen_rep", "onSuccess");
            txtTapImageRep.setVisibility(8);
            progressbar_imgkomenrep.setVisibility(8);
            imgKomentar_rep.setVisibility(0);
            ll_img_komen_rep.setClickable(false);
            imgKomentar_rep.setOnClickListener(img_media_to. new ConversationDetailActivity._cls24._cls1._cls1());
        }


            
            {
                this$1 = final__pcls24;
                txtTapImageRep = textview;
                progressbar_imgkomenrep = progressbar;
                imgKomentar_rep = imageview;
                ll_img_komen_rep = relativelayout;
                img_media_to = String.this;
                super();
            }
    }

}
