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
//            KomentarBaruLainPonsel, ImagePagerActivity, ProfileOtherUser

public class this._cls0 extends AsyncTask
{

    final KomentarBaruLainPonsel this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        JSONObject jsonobject = new JSONObject(urlKomenLast);
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        if (!jsonobject.getString("top_id_kom").equals("-"))
        {
            top_id = jsonobject.getString("top_id");
        }
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_286;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_286;
        }
        Object obj = KomentarBaruLainPonsel.this;
        obj.countAllKom = ((KomentarBaruLainPonsel) (obj)).countAllKom + 1;
        obj = KomentarBaruLainPonsel.this;
        obj.countKomOld = ((KomentarBaruLainPonsel) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Log.e("komentarhp", ((JSONObject) (obj)).getString("komentarhp"));
        KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).add(0, new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        txtbtnheader.setVisibility(0);
        layout_header.setVisibility(8);
        if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
        final String id_hp;
        final String codename;
        final String nama_komentar;
        final String usr_pict_komen;
        final String my_like_kom;
        int i;
        try
        {
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).size()));
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        i = 0;
        if (i >= KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).size())
        {
            void1 = KomentarBaruLainPonsel.this;
            void1.removeNextIndex = ((KomentarBaruLainPonsel) (void1)).removeNextIndex + countRemIndex;
            Log.e("removeNextIndex", String.valueOf(removeNextIndex));
            return;
        }
        void1 = KomentarBaruLainPonsel.this;
        void1.countRemIndex = ((KomentarBaruLainPonsel) (void1)).countRemIndex + 1;
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
        id_hp = (ImageView)void1.findViewById(0x7f0b054f);
        id_hp = (ImageView)void1.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getId_komentar();
        id_hp = ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getId_hp();
        codename = ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getCodename();
        nama_komentar = ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getNama_komentar();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getEmail_komentar();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getTanggal_komentar();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomentarhp();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomen_bagus();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomen_kurang();
        usr_pict_komen = ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getUsr_pict_komen();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getReply_to();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getNama_to();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomen_to();
        ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getTanggal_to();
        my_like_kom = ((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getMy_like_kom();
        if (!((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getReply_to().toString().trim().equals("0")) goto _L4; else goto _L3
_L3:
        lay_quote.setVisibility(8);
_L9:
        if (!((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_1325;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarBaruLainPonsel.access$2(KomentarBaruLainPonsel.this), KomentarBaruLainPonsel.access$3(KomentarBaruLainPonsel.this));
_L5:
        txtIdKom.setText(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getId_komentar().toString());
        txtdisLikeKom.setText(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomen_kurang().toString());
        txtLikeKom.setText(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomen_bagus().toString());
        txtNamaHp.setText(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getMy_like_kom().toString());
        txtUsername.setText(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getNama_komentar());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomentarhp().toString())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.hod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getNama_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.hod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getTanggal_komentar()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).get(i)).getTanggal_to()));
        KomentarBaruLainPonsel.access$0(KomentarBaruLainPonsel.this).addView(void1, 0);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarBaruLainPonsel.KomentarNextAsycTask this$1;
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
                this$1 = KomentarBaruLainPonsel.KomentarNextAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainPonsel.KomentarNextAsycTask this$1;
            private final String val$nama_komentar;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", nama_komentar);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarBaruLainPonsel.KomentarNextAsycTask.this;
                nama_komentar = s;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainPonsel.KomentarNextAsycTask this$1;
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
                this$1 = KomentarBaruLainPonsel.KomentarNextAsycTask.this;
                id_hp = s;
                my_like_kom = s1;
                codename = s2;
                super();
            }
        });
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        lay_quote.setVisibility(0);
        continue; /* Loop/switch isn't completed */
        img_kom_picture.setImageResource(0x7f020297);
          goto _L5
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L7:
        break MISSING_BLOCK_LABEL_74;
_L6:
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtbtnheader.setVisibility(8);
        layout_header.setVisibility(0);
        Log.e("mArrayListDataNext", String.valueOf(KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).size()));
        KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).clear();
        Log.e("mArrayListDataNext", String.valueOf(KomentarBaruLainPonsel.access$1(KomentarBaruLainPonsel.this).size()));
    }


    public _cls3.val.codename()
    {
        this$0 = KomentarBaruLainPonsel.this;
        super();
    }
}
