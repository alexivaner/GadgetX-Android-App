// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarAktivitasUser, ImagePagerActivity

public class this._cls0 extends AsyncTask
{

    final KomentarAktivitasUser this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        Log.e("KomentarRefreshAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        bottom_id = jsonobject.getString("lastid_kom");
        top_id = jsonobject.getString("firstid_kom");
        jum_komen = jsonobject.getString("jum_komen");
        Log.e("responsejum_komen", jum_komen);
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_313;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_313;
        }
        Object obj = KomentarAktivitasUser.this;
        obj.countAllKom = ((KomentarAktivitasUser) (obj)).countAllKom + 1;
        obj = KomentarAktivitasUser.this;
        obj.countKomOld = ((KomentarAktivitasUser) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
        i++;
          goto _L1
        as;
        as.printStackTrace();
        strKonekStat = "0";
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        int i;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_1202;
        }
        KomentarAktivitasUser.access$0(KomentarAktivitasUser.this).removeAllViewsInLayout();
        i = 0;
_L3:
        if (i < KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).size()) goto _L2; else goto _L1
_L1:
        scrollviewKomen.setVisibility(0);
_L4:
        pop_progressbar_middle.setVisibility(8);
        progressbar_Komenbutton.setVisibility(8);
        return;
_L2:
        void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fb, null);
        txtNamaHp = (TextView)void1.findViewById(0x7f0b0765);
        txtUsername = (TextView)void1.findViewById(0x7f0b0419);
        lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
        img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
        txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
        txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
        txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
        txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
        txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
        txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
        txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
        final String id_hp = (ImageView)void1.findViewById(0x7f0b054f);
        id_hp = (ImageView)void1.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getId_komentar();
        id_hp = ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getId_hp();
        final String codename = ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getCodename();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getNama_komentar();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getEmail_komentar();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getTanggal_komentar();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomentarhp();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomen_bagus();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomen_kurang();
        final String usr_pict_komen = ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getUsr_pict_komen();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getReply_to();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getNama_to();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomen_to();
        ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getTanggal_to();
        final String my_like_kom = ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getMy_like_kom();
        if (((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
        {
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarAktivitasUser.access$2(KomentarAktivitasUser.this), KomentarAktivitasUser.access$3(KomentarAktivitasUser.this));
        } else
        {
            img_kom_picture.setImageResource(0x7f020297);
        }
        txtIdKom.setText(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getId_komentar().toString());
        txtdisLikeKom.setText(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomen_kurang().toString());
        txtLikeKom.setText(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomen_bagus().toString());
        txtNamaHp.setText(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getMy_like_kom().toString());
        txtUsername.setText(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getNama_komentar());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomentarhp().toString())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.d.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getNama_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.d.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getTanggal_komentar()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).get(i)).getTanggal_to()));
        KomentarAktivitasUser.access$0(KomentarAktivitasUser.this).addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarAktivitasUser.KomentarRefreshAsycTask this$1;
            private final String val$usr_pict_komen;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$1 = KomentarAktivitasUser.KomentarRefreshAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarAktivitasUser.KomentarRefreshAsycTask this$1;
            private final String val$codename;
            private final String val$id_hp;
            private final String val$my_like_kom;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", my_like_kom);
                view.putExtra("codename", codename);
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("hrg_baru", "");
                view.putExtra("hrg_bekas", "");
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                view.putExtra("actfrom", "komen");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarAktivitasUser.KomentarRefreshAsycTask.this;
                id_hp = s;
                my_like_kom = s1;
                codename = s2;
                super();
            }
        });
        i++;
          goto _L3
        pop_progressbar_middle.setVisibility(8);
          goto _L4
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        limit = 0;
        Log.e("KomentarRefreshAsycTask", "onPreExecute");
        KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).clear();
        pop_progressbar_middle.setVisibility(0);
        txtMorekomenhp.setVisibility(8);
        imgKomenRefresh.setVisibility(8);
        progressbar_Komenbutton.setVisibility(0);
        KomentarAktivitasUser.access$1(KomentarAktivitasUser.this).clear();
    }


    public _cls2.val.codename()
    {
        this$0 = KomentarAktivitasUser.this;
        super();
    }
}
