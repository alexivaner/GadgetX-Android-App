// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
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
import com.astuetz.PagerSlidingTabStrip;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.ReplyFormActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull, TestFragmentAdapter, Hal2Spek, DetailsPonsel

public class this._cls0 extends AsyncTask
{

    final Hal3KomentarPull this$0;

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
        Hal3KomentarPull.access$1(Hal3KomentarPull.this).add(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size(), new ItemKomenHp(s.getString("id_komentar"), s.getString("id_hp"), s.getString("codename"), s.getString("nama_komentar"), s.getString("email_komentar"), s.getString("tanggal_komentar"), s.getString("komentarhp"), s.getString("komen_bagus"), s.getString("komen_kurang"), s.getString("usr_pict_komen"), s.getString("reply_to"), s.getString("nama_to"), s.getString("komen_to"), s.getString("tanggal_to"), s.getString("my_like_kom"), s.getString("img_kom"), s.getString("img_kom_rep")));
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
            if (android.os.tarPull.PostKomen >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.lder(avoid)).permitDiskWrites().build());
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
        if (!jum_komen.equals("-"))
        {
            TestFragmentAdapter.CONTENT[2] = (new StringBuilder("<font color='#FFFFFF'>KOMENTAR</font> <font color='#fb8c00'>")).append(jum_komen).append("</font>").toString();
            Hal2Spek.detail_text_komentar.setText(jum_komen);
            DetailsPonsel.tabs.notifyDataSetChanged();
        }
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
        if (i >= Hal3KomentarPull.access$1(Hal3KomentarPull.this).size())
        {
            layout_empty.setVisibility(8);
            break MISSING_BLOCK_LABEL_188;
        } else
        {
            void1 = Hal3KomentarPull.this;
            void1.countRemIndex = ((Hal3KomentarPull) (void1)).countRemIndex + 1;
            void1 = Hal3KomentarPull.this;
            void1.countKomOld = ((Hal3KomentarPull) (void1)).countKomOld + 1;
            void1 = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
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
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
            ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            final String id_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getId_komentar();
            final String id_hp = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getId_hp();
            final String codename = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getCodename();
            final String nama_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_komentar();
            final String email_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getEmail_komentar();
            final String tanggal_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_komentar();
            final String komentarhp = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomentarhp();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_bagus();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_kurang();
            final String usr_pict_komen = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getReply_to();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_to();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_to();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_to();
            ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getMy_like_kom();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getImg_media();
            String s1 = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getImg_media_to();
            Hal3KomentarPull.access$2(Hal3KomentarPull.this, ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s, s1);
            if (((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getReply_to().toString().trim().equals("0"))
            {
                lay_quote.setVisibility(8);
            } else
            {
                lay_quote.setVisibility(0);
            }
            if (((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getMy_like_kom().toString().equals("1"))
            {
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                list_lay_like.setEnabled(false);
                list_lay_dislike.setEnabled(true);
            } else
            if (((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getMy_like_kom().toString().equals("0"))
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
            if (((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                try
                {
                    Picasso.with(getActivity()).load(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

                        final Hal3KomentarPull.PostKomen this$1;

                        public void onError()
                        {
                        }

                        public void onSuccess()
                        {
                            img_kom_picture.setVisibility(0);
                        }

            
            {
                this$1 = Hal3KomentarPull.PostKomen.this;
                super();
            }
                    });
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_bagus().toString());
            txtUsername.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.alLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.alLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_to()));
            Hal3KomentarPull.access$0(Hal3KomentarPull.this).addView(void1, 0);
            img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final Hal3KomentarPull.PostKomen this$1;
                private final String val$usr_pict_komen;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = Hal3KomentarPull.PostKomen.this;
                usr_pict_komen = s;
                super();
            }
            });
            img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal3KomentarPull.PostKomen this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal3KomentarPull.PostKomen.this;
                nama_komentar = s;
                super();
            }
            });
            list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal3KomentarPull.PostKomen this$1;
                private final String val$id_hp;
                private final String val$id_komentar;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komentar;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&id_user=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new Hal3KomentarPull.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new Hal3KomentarPull.PostBagusKurangTask(this$0)).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                this$1 = Hal3KomentarPull.PostKomen.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal3KomentarPull.PostKomen this$1;
                private final String val$id_hp;
                private final String val$id_komentar;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komentar;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&id_user=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new Hal3KomentarPull.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new Hal3KomentarPull.PostBagusKurangTask(this$0)).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                this$1 = Hal3KomentarPull.PostKomen.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
            });
            list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal3KomentarPull.PostKomen this$1;
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
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/ReplyFormActivity);
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
                        startActivityForResult(view, Hal3KomentarPull.access$3());
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final _cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls6.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = Hal3KomentarPull.PostKomen.this;
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

                final Hal3KomentarPull.PostKomen this$1;
                private final String val$codename;
                private final String val$id_hp;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = this$0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new Hal3KomentarPull.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new Hal3KomentarPull.KomentarOldAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = Hal3KomentarPull.PostKomen.this;
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

            final Hal3KomentarPull.PostKomen this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3KomentarPull.PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3KomentarPull.PostKomen()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = Hal3KomentarPull.PostKomen.this;
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
        txtbtnheader.setEnabled(true);
        txtbtnheader.setTextColor(Color.parseColor("#000000"));
        Log.e("postStatus", postStatus);
        if (postStatus.equals("1"))
        {
            mNotificationHelper.completed(namalengkap, mNotificationHelper.SucdiskomStatement);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setText("");
            if (android.os.rEditText.setText >= 11)
            {
                (new sk(Hal3KomentarPull.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new sk(Hal3KomentarPull.this)).execute(new Void[0]);
                return;
            }
        }
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
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        btn_send_komen.setEnabled(false);
        edt_pop_komen.setEnabled(false);
        txtbtnfooter.setEnabled(false);
        txtbtnfooter.setTextColor(Color.parseColor("#cacaca"));
        txtbtnheader.setEnabled(false);
        txtbtnheader.setTextColor(Color.parseColor("#cacaca"));
        edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
        Log.e("mArrayListDataPostKomen", String.valueOf(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()));
        mNotificationHelper.createNotification(namalengkap, mNotificationHelper.komenPostWords);
        Hal3KomentarPull.access$1(Hal3KomentarPull.this).clear();
        Log.e("clearmArrayKomen", String.valueOf(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()));
    }


    public _cls8.this._cls1()
    {
        this$0 = Hal3KomentarPull.this;
        super();
    }
}
