// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
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
//            KomentarPonsel, RegisterActivity, LoginActivity, ReplyFormActivity

public class this._cls0 extends AsyncTask
{

    final KomentarPonsel this$0;

    private void parseJSONKom(String s)
    {
        s = new JSONObject(s);
        postStatus = s.getString("success");
        postMessage = s.getString("message");
        statusKomen = s.getString("statuskomen");
        tot_LikePon = s.getString("total_like");
        totdis_LikePon = s.getString("total_dislike");
        jum_komen = s.getString("jum_komen");
        ponselBaseApp.getObserver().setJum_komenLikePon(jum_komen);
        ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
        ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
        ponselBaseApp.getObserver().setIndexHp(codename);
        Log.e("postStatus", postStatus);
        if (!postStatus.equals("1"))
        {
            break MISSING_BLOCK_LABEL_401;
        }
        top_id = s.getString("top_id");
        jArray = s.getJSONArray("InPonsel");
        int i = 0;
_L2:
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        Log.e("komentarhp", s.getString("komentarhp"));
        KomentarPonsel.access$1(KomentarPonsel.this).add(KomentarPonsel.access$1(KomentarPonsel.this).size(), new ItemKomenHp(s.getString("id_komentar"), s.getString("id_hp"), s.getString("codename"), s.getString("nama_komentar"), s.getString("email_komentar"), s.getString("tanggal_komentar"), s.getString("komentarhp"), s.getString("komen_bagus"), s.getString("komen_kurang"), s.getString("usr_pict_komen"), s.getString("reply_to"), s.getString("nama_to"), s.getString("komen_to"), s.getString("tanggal_to"), s.getString("my_like_kom"), s.getString("img_kom"), s.getString("img_kom_rep")));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.el.PostKomen >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.uilder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            Log.e("responseKomen", res);
            parseJSONKom(res);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        ponselBaseApp.getObserver().setUpdateType("komentar");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
        int i;
        if (statusKomen.equals("1"))
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        countKomOld = 0;
        i = 0;
_L4:
        if (i >= KomentarPonsel.access$1(KomentarPonsel.this).size())
        {
            layout_empty.setVisibility(8);
            break MISSING_BLOCK_LABEL_119;
        } else
        {
            void1 = KomentarPonsel.this;
            void1.countRemIndex = ((KomentarPonsel) (void1)).countRemIndex + 1;
            void1 = KomentarPonsel.this;
            void1.countKomOld = ((KomentarPonsel) (void1)).countKomOld + 1;
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
            txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
            txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
            ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            final String id_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getId_komentar();
            final String id_hp = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getId_hp();
            final String codename = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getCodename();
            final String nama_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_komentar();
            final String email_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getEmail_komentar();
            final String tanggal_komentar = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_komentar();
            final String komentarhp = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomentarhp();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_bagus();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_kurang();
            final String usr_pict_komen = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getUsr_pict_komen();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getReply_to();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_to();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_to();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_to();
            ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getMy_like_kom();
            String s = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getImg_media();
            String s1 = ((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getImg_media_to();
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
            txtKomentar.setMovementMethod(com.inponsel.android.widget.ocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.ocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)KomentarPonsel.access$1(KomentarPonsel.this).get(i)).getTanggal_to()));
            KomentarPonsel.access$0(KomentarPonsel.this).addView(void1, 0);
            list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.PostKomen this$1;
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

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = KomentarPonsel.PostKomen.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.PostKomen this$1;
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

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = KomentarPonsel.PostKomen.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
            });
            list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.PostKomen this$1;
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
                        view = new android.app.AlertDialog.Builder(this$0);
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
                this$1 = KomentarPonsel.PostKomen.this;
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
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarPonsel.PostKomen this$1;
                private final String val$codename;
                private final String val$id_hp;

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
                this$1 = KomentarPonsel.PostKomen.this;
                id_hp = s;
                codename = s1;
                super();
            }
            });
            i++;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel.PostKomen this$1;

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
                    (new KomentarPonsel.PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarPonsel.PostKomen()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = KomentarPonsel.PostKomen.this;
                super();
            }
        });
        layout_empty.setVisibility(0);
        pop_progressbar_middle.setVisibility(8);
        pop_txt_empty.setVisibility(0);
        pop_txt_empty.setText("Belum ada komentar");
        btn_send_komen.setEnabled(true);
        edt_pop_komen.setEnabled(true);
        txtbtnfooter.setEnabled(true);
        txtbtnfooter.setTextColor(Color.parseColor("#000000"));
        edt_pop_komen.setTextColor(Color.parseColor("#000000"));
        Log.e("postStatus", postStatus);
        if (postStatus.equals("1"))
        {
            mNotificationHelper.completed(namalengkap, mNotificationHelper.SucdiskomStatement);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setText("");
            if (android.os.terEditText.setText >= 11)
            {
                (new sk(KomentarPonsel.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new sk(KomentarPonsel.this)).execute(new Void[0]);
                return;
            }
        }
        Log.e("postStatus040", "040");
        layout_empty.setVisibility(8);
        if (postStatus.equals("040"))
        {
            mNotificationHelper.gagal(namalengkap, postMessage);
            return;
        }
        mNotificationHelper.gagal(namalengkap, mNotificationHelper.gagalkomStatement);
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        btn_send_komen.setEnabled(false);
        edt_pop_komen.setEnabled(false);
        txtbtnfooter.setEnabled(false);
        txtbtnfooter.setTextColor(Color.parseColor("#cacaca"));
        edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
        Log.e("mArrayListDataPostKomen", String.valueOf(KomentarPonsel.access$1(KomentarPonsel.this).size()));
        mNotificationHelper.createNotification(namalengkap, mNotificationHelper.komenPostWords);
        KomentarPonsel.access$1(KomentarPonsel.this).clear();
        Log.e("clearmArrayKomen", String.valueOf(KomentarPonsel.access$1(KomentarPonsel.this).size()));
    }


    public _cls5.this._cls1()
    {
        this$0 = KomentarPonsel.this;
        super();
    }
}
