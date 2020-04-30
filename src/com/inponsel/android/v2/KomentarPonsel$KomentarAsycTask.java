// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
        Log.e("KomentarAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        top_id = jsonobject.getString("top_id");
        bottom_id = jsonobject.getString("bottom_id");
        jum_komen = jsonobject.getString("jum_komen");
        statusKomen = jsonobject.getString("statuskomen");
        Log.e("responsejum_komen", jum_komen);
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_326;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_326;
        }
        Object obj = KomentarPonsel.this;
        obj.countAllKom = ((KomentarPonsel) (obj)).countAllKom + 1;
        obj = KomentarPonsel.this;
        obj.countKomOld = ((KomentarPonsel) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        KomentarPonsel.access$1(KomentarPonsel.this).add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        grup_footer.setVisibility(0);
        if (statusKomen.equals("1"))
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        if (!strKonekStat.equals("-"))
        {
            int i = 0;
            do
            {
                if (i >= KomentarPonsel.access$1(KomentarPonsel.this).size())
                {
                    txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                        final KomentarPonsel.KomentarAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                txtbtnfooter.setVisibility(8);
                                view = this$0;
                                view.limit = ((KomentarPonsel) (view)).limit + 15;
                                urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                                Log.e("urlKomenOld", urlKomenOld);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new KomentarPonsel.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                    return;
                                }
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            (new KomentarPonsel.KomentarOldAsycTask(this$0)).execute(new String[0]);
                            return;
                        }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
                    });
                    txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                        final KomentarPonsel.KomentarAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                limit = 0;
                                urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                                Log.e("urlKomenLast", urlKomenLast);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new KomentarPonsel.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                    return;
                                }
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            (new KomentarPonsel.KomentarNextAsycTask(this$0)).execute(new String[0]);
                            return;
                        }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
                    });
                    btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                        final KomentarPonsel.KomentarAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                                Log.e("bottom_id", bottom_id);
                                querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new KomentarPonsel.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new KomentarPonsel.PostKomen(this$0)).execute(new Void[0]);
                                return;
                            }
                        }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
                    });
                    layout_empty.setVisibility(8);
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
                    if (countKomOld < 15)
                    {
                        txtbtnfooter.setVisibility(8);
                        layout_footerNext.setVisibility(8);
                    } else
                    {
                        txtbtnfooter.setVisibility(0);
                        layout_footerNext.setVisibility(8);
                    }
                    if (sortkom.equals("1") || sortkom.equals("2"))
                    {
                        txtbtnfooter.setVisibility(8);
                        layout_footerNext.setVisibility(8);
                    }
                    return;
                }
                void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
                txtUsername = (TextView)void1.findViewById(0x7f0b0419);
                lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
                ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
                ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
                imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
                imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
                img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
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
                if (((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getReply_to().toString().trim().equals("0"))
                {
                    lay_quote.setVisibility(8);
                } else
                {
                    lay_quote.setVisibility(0);
                }
                if (((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getMy_like_kom().toString().equals("1"))
                {
                    imageview.setBackgroundResource(0x7f02025b);
                    imageview1.setBackgroundResource(0x7f0201a3);
                    list_lay_like.setEnabled(false);
                    list_lay_dislike.setEnabled(true);
                } else
                if (((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getMy_like_kom().toString().equals("0"))
                {
                    imageview.setBackgroundResource(0x7f020257);
                    imageview1.setBackgroundResource(0x7f0201a7);
                    list_lay_like.setEnabled(true);
                    list_lay_dislike.setEnabled(false);
                } else
                {
                    list_lay_like.setEnabled(true);
                    list_lay_dislike.setEnabled(true);
                    imageview.setBackgroundResource(0x7f020257);
                    imageview1.setBackgroundResource(0x7f0201a3);
                }
                if (((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
                {
                    imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarPonsel.access$3(KomentarPonsel.this), KomentarPonsel.access$4(KomentarPonsel.this));
                } else
                {
                    img_kom_picture.setImageResource(0x7f020297);
                }
                txtIdKom.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getId_komentar().toString());
                txtdisLikeKom.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_kurang().toString());
                txtLikeKom.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_bagus().toString());
                txtUsername.setText(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_komentar());
                txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomentarhp().toString())));
                txtKomentar.setMovementMethod(com.inponsel.android.widget.kMovementMethod.getInstance());
                txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_to()));
                txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_to().toString())));
                txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.kMovementMethod.getInstance());
                txtWaktu.setText(Utility.convertDate(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_komentar()));
                txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_to()));
                KomentarPonsel.access$0(KomentarPonsel.this).addView(void1);
                img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                    final KomentarPonsel.KomentarAsycTask this$1;
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
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                usr_pict_komen = s;
                super();
            }
                });
                img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarPonsel.KomentarAsycTask this$1;
                    private final String val$nama_komentar;

                    public void onClick(View view)
                    {
                        view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                        view.putExtra("id_user_view", nama_komentar);
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                nama_komentar = s;
                super();
            }
                });
                list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarPonsel.KomentarAsycTask this$1;
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
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
                });
                list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarPonsel.KomentarAsycTask this$1;
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
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
                });
                list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarPonsel.KomentarAsycTask this$1;
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
                        Log.e("iRep", (new StringBuilder(String.valueOf(id_hp))).append(" - ").append(id_komentar).append(" - ").append(email_komentar).append(" - ").append(nama_komentar).append(" - ").append(tanggal_komentar).append(" - ").append(usr_pict_komen).append(" - ").append(namalengkap).append(" - ").append(codename).toString());
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
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                usr_pict_komen = s5;
                codename = s6;
                komentarhp = s7;
                super();
            }
                });
                void1.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarPonsel.KomentarAsycTask this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
                });
                i++;
            } while (true);
        } else
        {
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = this$0;
                        view.limit = ((KomentarPonsel) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarPonsel.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarPonsel.KomentarOldAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
            });
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarPonsel.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarPonsel.KomentarNextAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                        Log.e("bottom_id", bottom_id);
                        querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarPonsel.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new KomentarPonsel.PostKomen(this$0)).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarPonsel.KomentarAsycTask.this;
                super();
            }
            });
            layout_empty.setVisibility(0);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Belum ada komentar");
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        limit = 0;
        Log.e("KomentarAsycTask", "onPreExecute");
        layout_empty.setVisibility(0);
        KomentarPonsel.access$0(KomentarPonsel.this).removeAllViewsInLayout();
        KomentarPonsel.access$1(KomentarPonsel.this).clear();
    }


    public _cls9.this._cls1()
    {
        this$0 = KomentarPonsel.this;
        super();
    }
}
