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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel

class this._cls0
    implements android.view.er
{

    final RoomPostArtikel this$0;

    public void onClick(View view)
    {
        if (netInfo != null && netInfo.isConnected())
        {
            btnPostAskHp.setEnabled(false);
            if (tag_artikel.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Kategori artikel belum dipilih", 1).show();
                return;
            }
            if (photo_upload == null)
            {
                Log.e("photo", "not");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                RoomPostArtikel.access$8(RoomPostArtikel.this, (NotificationManager)getSystemService("notification"));
                RoomPostArtikel.access$9(RoomPostArtikel.this, new android.support.v4.app..Builder(RoomPostArtikel.this));
                RoomPostArtikel.access$0(RoomPostArtikel.this).setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Memperbarui artikel... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    RoomPostArtikel.access$2(RoomPostArtikel.this, id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), str_img_url, t);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                return;
            }
            if (tag_artikel.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Kategori artikel belum dipilih", 1).show();
                return;
            }
            Log.e("photo", "oke");
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            RoomPostArtikel.access$8(RoomPostArtikel.this, (NotificationManager)getSystemService("notification"));
            RoomPostArtikel.access$9(RoomPostArtikel.this, new android.support.v4.app..Builder(RoomPostArtikel.this));
            RoomPostArtikel.access$0(RoomPostArtikel.this).setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Memperbarui artikel... - 0%").setSmallIcon(0x7f0201e4);
            if (android.os.INT >= 11)
            {
                (new loadImage(RoomPostArtikel.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new loadImage(RoomPostArtikel.this, null)).execute(new Void[0]);
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
        this$0 = RoomPostArtikel.this;
        super();
    }
}
