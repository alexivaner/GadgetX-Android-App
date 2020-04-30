// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarPonsel, ImagePagerActivity, ProfileOtherUser, RegisterActivity, 
//            LoginActivity, ReplyFormActivity

public class this._cls0 extends AsyncTask
{

    final KomentarPonsel this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenOld));
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        bottom_id = jsonobject.getString("bottom_id");
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_268;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_268;
        }
        Object obj = KomentarPonsel.this;
        obj.countAllKom = ((KomentarPonsel) (obj)).countAllKom + 1;
        obj = KomentarPonsel.this;
        obj.countKomOld = ((KomentarPonsel) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        KomentarPonsel.access$1(KomentarPonsel.this).add(0, new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        layout_footerNext.setVisibility(8);
        int i;
        if (KomentarPonsel.access$1(KomentarPonsel.this).size() < 15)
        {
            txtbtnfooter.setVisibility(8);
        } else
        {
            txtbtnfooter.setVisibility(0);
        }
        ImageView imageview;
        ImageView imageview1;
        final String id_komentar;
        final String id_hp;
        final String codename;
        final String nama_komentar;
        final String email_komentar;
        final String tanggal_komentar;
        final String komentarhp;
        final String usr_pict_komen;
        String s;
        String s1;
        try
        {
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(KomentarPonsel.access$1(KomentarPonsel.this).size()));
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        i = 0;
        if (i >= KomentarPonsel.access$1(KomentarPonsel.this).size())
        {
            void1 = KomentarPonsel.this;
            void1.removeIndex = ((KomentarPonsel) (void1)).removeIndex + 3;
            Log.e("removeIndexBef", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
            void1 = KomentarPonsel.this;
            void1.removeStartOld = ((KomentarPonsel) (void1)).removeStartOld + 3;
            Log.e("removeIndexAft", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
            txtbtnfooter.setVisibility(0);
            layout_footerNext.setVisibility(8);
            if (countKomOld < 15)
            {
                txtbtnfooter.setVisibility(8);
                layout_footerNext.setVisibility(8);
                txtbtnfooter.setVisibility(8);
                layout_footerNext.setVisibility(8);
                return;
            }
            break MISSING_BLOCK_LABEL_2115;
        }
        void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
        txtUsername = (TextView)void1.findViewById(0x7f0b0419);
        lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
        img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
        ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
        ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
        imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
        imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
        txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
        txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
        progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
        progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
        txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
        txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
        txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
        txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
        txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
        txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
        txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
        imageview = (ImageView)void1.findViewById(0x7f0b054f);
        imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
        headName = (LinearLayout)void1.findViewById(0x7f0b0549);
        ll_separator = (LinearLayout)void1.findViewById(0x7f0b065e);
        ll_separator_atas = (LinearLayout)void1.findViewById(0x7f0b0766);
        list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
        list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
        list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
        list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
        id_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getId_komentar();
        id_hp = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getId_hp();
        codename = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getCodename();
        nama_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_komentar();
        email_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getEmail_komentar();
        tanggal_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_komentar();
        komentarhp = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomentarhp();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_bagus();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_kurang();
        usr_pict_komen = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getReply_to();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_to();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_to();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_to();
        ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getMy_like_kom();
        s = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getImg_media();
        s1 = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getImg_media_to();
        KomentarPonsel.access$2(KomentarPonsel.this, ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s, s1);
        if (!((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getReply_to().toString().trim().equals("0")) goto _L2; else goto _L1
_L1:
        lay_quote.setVisibility(8);
_L5:
        if (!((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L6:
        if (!((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_2099;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarPonsel.access$3(KomentarPonsel.this), KomentarPonsel.access$4(KomentarPonsel.this));
_L7:
        txtIdKom.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getId_komentar().toString());
        txtdisLikeKom.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_kurang().toString());
        txtLikeKom.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_bagus().toString());
        txtUsername.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_komentar());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomentarhp().toString())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.vementMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.vementMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_komentar()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_to()));
        Log.e("counter id_komentar", id_komentar);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_1828;
        }
        ll_separator_atas.setVisibility(0);
        ll_separator_atas.setBackgroundColor(0xffff0000);
        KomentarPonsel.access$0(KomentarPonsel.this).addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarPonsel.KomentarOldAsycTask this$1;
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
                this$1 = KomentarPonsel.KomentarOldAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel.KomentarOldAsycTask this$1;
            private final String val$nama_komentar;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", nama_komentar);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarPonsel.KomentarOldAsycTask.this;
                nama_komentar = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel.KomentarOldAsycTask this$1;
            private final String val$id_hp;
            private final String val$id_komentar;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "1";
                    idkom_pos = id_komentar;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&id_user=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarPonsel.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new KomentarPonsel.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls3.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls3.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls3.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = KomentarPonsel.KomentarOldAsycTask.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel.KomentarOldAsycTask this$1;
            private final String val$id_hp;
            private final String val$id_komentar;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "0";
                    idkom_pos = id_komentar;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&id_user=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarPonsel.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new KomentarPonsel.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = KomentarPonsel.KomentarOldAsycTask.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel.KomentarOldAsycTask this$1;
            private final String val$codename;
            private final String val$email_komentar;
            private final String val$id_hp;
            private final String val$id_komentar;
            private final String val$komentarhp;
            private final String val$nama_komentar;
            private final String val$tanggal_komentar;
            private final String val$usr_pict_komen;

            public void onClick(View view)
            {
                Log.e("iRep", (new StringBuilder(String.valueOf(id_hp))).append(" - ").append(id_komentar).append(" - ").append(email_komentar).append(" - ").append(nama_komentar).append(" - ").append(tanggal_komentar).append(" - ").append(komentarhp).append(" - ").append(namalengkap).append(" - ").append(codename).toString());
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    view = new Intent(this$0, com/inponsel/android/v2/ReplyFormActivity);
                    view.putExtra("idhp", id_hp);
                    view.putExtra("idkomen", id_komentar);
                    view.putExtra("email_komentar", email_komentar);
                    view.putExtra("userkomen", nama_komentar);
                    view.putExtra("tanggal", tanggal_komentar);
                    view.putExtra("isikomentar", komentarhp);
                    view.putExtra("nmlengkap", namalengkap);
                    view.putExtra("userpict", usr_pict_komen);
                    view.putExtra("codename", codename);
                    view.putExtra("top_id", top_id);
                    startActivityForResult(view, KomentarPonsel.access$5());
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls5.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls5.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls5.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = KomentarPonsel.KomentarOldAsycTask.this;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = s7;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel.KomentarOldAsycTask this$1;

            public void onClick(View view)
            {
            }

            
            {
                this$1 = KomentarPonsel.KomentarOldAsycTask.this;
                super();
            }
        });
        i++;
        break MISSING_BLOCK_LABEL_75;
_L2:
        lay_quote.setVisibility(0);
          goto _L5
_L4:
label0:
        {
            if (!((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getMy_like_kom().toString().equals("0"))
            {
                break label0;
            }
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a7);
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(false);
        }
          goto _L6
        list_lay_like.setEnabled(true);
        list_lay_dislike.setEnabled(true);
        imageview.setBackgroundResource(0x7f020257);
        imageview1.setBackgroundResource(0x7f0201a3);
          goto _L6
        img_kom_picture.setImageResource(0x7f020297);
          goto _L7
        txtbtnfooter.setVisibility(0);
        layout_footerNext.setVisibility(8);
        return;
        break MISSING_BLOCK_LABEL_75;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtbtnfooter.setVisibility(8);
        layout_footerNext.setVisibility(0);
        KomentarPonsel.access$1(KomentarPonsel.this).clear();
    }


    public _cls6.this._cls1()
    {
        this$0 = KomentarPonsel.this;
        super();
    }
}
