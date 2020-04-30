// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;

// Referenced classes of package com.inponsel.android.v2:
//            AddKomentarPicture

class this._cls0
    implements android.view.rPicture._cls3
{

    final AddKomentarPicture this$0;

    public void onClick(View view)
    {
        if (netInfo != null && netInfo.isConnected())
        {
            if (photo_upload == null)
            {
                btnPostAskHp.setEnabled(false);
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                AddKomentarPicture.access$2(AddKomentarPicture.this, (NotificationManager)getSystemService("notification"));
                AddKomentarPicture.access$3(AddKomentarPicture.this, new android.support.v4.app.ilder(AddKomentarPicture.this));
                AddKomentarPicture.access$0(AddKomentarPicture.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    url_PostKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).append("&pf=").append(str_tag_komen).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                (new stKomen(AddKomentarPicture.this)).execute(new Void[0]);
                return;
            }
            if (resp.contains(".jpg") || resp.contains(".jpeg"))
            {
                Log.e("str_tag_komen", str_tag_komen);
                if (str_tag_komen.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Tag belum dipilih", 0).show();
                    return;
                }
                btnPostAskHp.setEnabled(false);
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                AddKomentarPicture.access$2(AddKomentarPicture.this, (NotificationManager)getSystemService("notification"));
                AddKomentarPicture.access$3(AddKomentarPicture.this, new android.support.v4.app.ilder(AddKomentarPicture.this));
                AddKomentarPicture.access$0(AddKomentarPicture.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    url_PostKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).append("&pf=").append(str_tag_komen).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                (new stKomen(AddKomentarPicture.this)).execute(new Void[0]);
                return;
            }
            if (str_tag_komen.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Tag belum dipilih", 0).show();
                return;
            } else
            {
                btnPostAskHp.setEnabled(false);
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                AddKomentarPicture.access$2(AddKomentarPicture.this, (NotificationManager)getSystemService("notification"));
                AddKomentarPicture.access$3(AddKomentarPicture.this, new android.support.v4.app.ilder(AddKomentarPicture.this));
                AddKomentarPicture.access$0(AddKomentarPicture.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                (new loadImage(AddKomentarPicture.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        } else
        {
            Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", 1).show();
            return;
        }
    }

    loadImage()
    {
        this$0 = AddKomentarPicture.this;
        super();
    }
}
