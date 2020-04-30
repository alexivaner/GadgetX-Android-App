// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.AddKomentarPicture;
import com.inponsel.android.v2.BaseDrawer;
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
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel, TestFragmentAdapter, Hal2Spek

public class Hal3KomentarPull extends SherlockFragment
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

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
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            jum_komen = jsonobject.getString("jum_komen");
            statusKomen = jsonobject.getString("statuskomen");
            Log.e("statusKomenTask", statusKomen);
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_339;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_339;
            }
            Object obj = Hal3KomentarPull.this;
            obj.countAllKom = ((Hal3KomentarPull) (obj)).countAllKom + 1;
            obj = Hal3KomentarPull.this;
            obj.countKomOld = ((Hal3KomentarPull) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            codename = ((JSONObject) (obj)).getString("codename");
            mArrayListData.add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            TestFragmentAdapter.CONTENT[2] = (new StringBuilder("<font color='#FFFFFF'>KOMENTAR</font> <font color='#fb8c00'>")).append(jum_komen).append("</font>").toString();
            Hal2Spek.detail_text_komentar.setText(jum_komen);
            DetailsPonsel.tabs.notifyDataSetChanged();
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            int i = 0;
_L19:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
            layout_empty.setVisibility(8);
            if (countKomOld >= 15) goto _L6; else goto _L5
_L5:
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(8);
            txtbtnfooter.setVisibility(8);
            layout_footerNext.setVisibility(8);
_L17:
            if (sortkom.equals("1") || sortkom.equals("2"))
            {
                txtbtnfooter.setVisibility(8);
                layout_footerNext.setVisibility(8);
                return;
            }
              goto _L7
_L4:
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            ImageView imageview;
            ImageView imageview1;
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
            imageview = (ImageView)void1.findViewById(0x7f0b054f);
            imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komentar = ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            codename = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            nama_komentar = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            email_komentar = ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            tanggal_komentar = ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            komentarhp = ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            s = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
            String s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L9; else goto _L8
_L8:
            lay_quote.setVisibility(8);
_L14:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L11; else goto _L10
_L10:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L15:
            if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png")) goto _L13; else goto _L12
_L12:
            boolean flag = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg");
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_2009;
            }
_L13:
            Picasso.with(getActivity()).load(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

                final KomentarAsycTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_kom_picture.setVisibility(0);
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
_L16:
            Exception exception;
            try
            {
                txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
                txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
                txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
                txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
                txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
                txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
                txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
                txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
                txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
                mLinearListView.addView(void1);
                img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                    final KomentarAsycTask this$1;
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
                this$1 = final_komentarasyctask;
                usr_pict_komen = String.this;
                super();
            }
                });
                img_kom_picture.setOnClickListener(nama_komentar. new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;
                    private final String val$nama_komentar;

                    public void onClick(View view)
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                        view.putExtra("id_user_view", nama_komentar);
                        startActivityForResult(view, 0);
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_komentarasyctask;
                nama_komentar = String.this;
                super();
            }
                });
                list_lay_like.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;
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
                                (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getActivity());
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = KomentarAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = KomentarAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = KomentarAsycTask._cls4.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_komentarasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
                });
                list_lay_dislike.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;
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
                                (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getActivity());
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = KomentarAsycTask._cls5.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = KomentarAsycTask._cls5.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = KomentarAsycTask._cls5.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_komentarasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
                });
                list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;
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
                            startActivityForResult(view, Hal3KomentarPull.POST_STAT);
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getActivity());
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final KomentarAsycTask._cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_komentarasyctask;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = String.this;
                super();
            }
                });
                void1.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            i++;
            continue; /* Loop/switch isn't completed */
_L9:
            lay_quote.setVisibility(0);
              goto _L14
_L11:
label0:
            {
                if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L15
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L15
            exception;
            exception.printStackTrace();
              goto _L16
            img_kom_picture.setImageResource(0x7f020297);
              goto _L16
_L6:
            txtbtnheader.setVisibility(0);
            layout_header.setVisibility(8);
            txtbtnfooter.setVisibility(0);
            layout_footerNext.setVisibility(8);
              goto _L17
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
            layout_empty.setVisibility(0);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Belum ada komentar");
_L7:
            return;
            if (true) goto _L19; else goto _L18
_L18:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("KomentarAsycTask", "onPreExecute");
            limit = 0;
            Log.e("KomentarAsycTask", "onPreExecute");
            layout_empty.setVisibility(0);
            mLinearListView.removeAllViewsInLayout();
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class KomentarNextAsycTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(strJsonRssRep);
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            if (!jsonobject.getString("bottom_id").equals("-"))
            {
                bottom_id = jsonobject.getString("bottom_id");
            }
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_295;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_295;
            }
            Object obj = Hal3KomentarPull.this;
            obj.countAllKom = ((Hal3KomentarPull) (obj)).countAllKom + 1;
            obj = Hal3KomentarPull.this;
            obj.countKomOld = ((Hal3KomentarPull) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            Log.e("komentarhp", ((JSONObject) (obj)).getString("komentarhp"));
            mArrayListData.add(mArrayListData.size(), new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            txtbtnfooter.setVisibility(0);
            layout_footerNext.setVisibility(8);
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(mArrayListData.size()));
            int i = 0;
_L11:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            void1 = Hal3KomentarPull.this;
            void1.removeNextIndex = ((Hal3KomentarPull) (void1)).removeNextIndex + countRemIndex;
            Log.e("removeNextIndex", String.valueOf(removeNextIndex));
_L15:
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            return;
_L4:
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            ImageView imageview;
            ImageView imageview1;
            void1 = Hal3KomentarPull.this;
            void1.countRemIndex = ((Hal3KomentarPull) (void1)).countRemIndex + 1;
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
            imageview = (ImageView)void1.findViewById(0x7f0b054f);
            imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komentar = ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            codename = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            nama_komentar = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            email_komentar = ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            tanggal_komentar = ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            komentarhp = ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            s = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
            String s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L6; else goto _L5
_L5:
            lay_quote.setVisibility(8);
_L12:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L13:
            if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png")) goto _L10; else goto _L9
_L9:
            boolean flag = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg");
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_1926;
            }
_L10:
            Picasso.with(getActivity()).load(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

                final KomentarNextAsycTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_kom_picture.setVisibility(0);
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
_L14:
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1, 0);
            img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                final KomentarNextAsycTask this$1;
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
                this$1 = final_komentarnextasyctask;
                usr_pict_komen = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(nama_komentar. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnextasyctask;
                nama_komentar = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_hp;
                private final String val$id_komentar;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komentar;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_hp;
                private final String val$id_komentar;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komentar;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls5.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
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
                        startActivityForResult(view, Hal3KomentarPull.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnextasyctask;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = String.this;
                super();
            }
            });
            void1.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            i++;
              goto _L11
_L6:
            lay_quote.setVisibility(0);
              goto _L12
_L8:
label0:
            {
                if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L13
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L13
            Exception exception;
            exception;
            exception.printStackTrace();
              goto _L14
            img_kom_picture.setImageResource(0x7f020297);
              goto _L14
_L2:
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            return;
            void1;
              goto _L15
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtbtnfooter.setVisibility(8);
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
        }


        public KomentarNextAsycTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class KomentarOldAsycTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

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
            Object obj = Hal3KomentarPull.this;
            obj.countAllKom = ((Hal3KomentarPull) (obj)).countAllKom + 1;
            obj = Hal3KomentarPull.this;
            obj.countKomOld = ((Hal3KomentarPull) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(0, new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            if (mArrayListData.size() < 15)
            {
                txtbtnfooter.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            ImageView imageview;
            Exception exception;
            ImageView imageview1;
            String s1;
            String s2;
            boolean flag;
            try
            {
                Log.e("countAllKom", String.valueOf(countAllKom));
                Log.e("mArrayListDataold", String.valueOf(mArrayListData.size()));
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            i = 0;
            if (i >= mArrayListData.size())
            {
                void1 = Hal3KomentarPull.this;
                void1.removeIndex = ((Hal3KomentarPull) (void1)).removeIndex + 3;
                Log.e("removeIndexBef", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                void1 = Hal3KomentarPull.this;
                void1.removeStartOld = ((Hal3KomentarPull) (void1)).removeStartOld + 3;
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
                break MISSING_BLOCK_LABEL_2120;
            }
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
            id_komentar = ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            codename = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            nama_komentar = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            email_komentar = ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            tanggal_komentar = ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            komentarhp = ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            s = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
            s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L2; else goto _L1
_L1:
            lay_quote.setVisibility(8);
_L7:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L4; else goto _L3
_L3:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L8:
            if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png")) goto _L6; else goto _L5
_L5:
            flag = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg");
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_2104;
            }
_L6:
            Picasso.with(getActivity()).load(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

                final KomentarOldAsycTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_kom_picture.setVisibility(0);
                }

            
            {
                this$1 = KomentarOldAsycTask.this;
                super();
            }
            });
_L9:
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            Log.e("counter id_komentar", id_komentar);
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_1825;
            }
            ll_separator_atas.setVisibility(0);
            ll_separator_atas.setBackgroundColor(0xffff0000);
            mLinearListView.addView(void1);
            img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                final KomentarOldAsycTask this$1;
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
                this$1 = final_komentaroldasyctask;
                usr_pict_komen = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(nama_komentar. new android.view.View.OnClickListener() {

                final KomentarOldAsycTask this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentaroldasyctask;
                nama_komentar = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                final KomentarOldAsycTask this$1;
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
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentaroldasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                final KomentarOldAsycTask this$1;
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
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls5.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentaroldasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarOldAsycTask this$1;
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
                        startActivityForResult(view, Hal3KomentarPull.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentaroldasyctask;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = String.this;
                super();
            }
            });
            void1.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarOldAsycTask this$1;

                public void onClick(View view)
                {
                }

            
            {
                this$1 = KomentarOldAsycTask.this;
                super();
            }
            });
            i++;
            break MISSING_BLOCK_LABEL_75;
_L2:
            lay_quote.setVisibility(0);
              goto _L7
_L4:
label0:
            {
                if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L8
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L8
            exception;
            exception.printStackTrace();
              goto _L9
            img_kom_picture.setImageResource(0x7f020297);
              goto _L9
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
            mArrayListData.clear();
        }


        public KomentarOldAsycTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class KomentarReplyAsycTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(strJsonRssRep);
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            if (!jsonobject.getString("top_id").equals("-"))
            {
                top_id = jsonobject.getString("top_id");
            }
            jum_komen = jsonobject.getString("jum_komen");
            Log.e("komlengt", String.valueOf(as.length()));
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_321;
            }
            mArrayListData.clear();
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_321;
            }
            Object obj = Hal3KomentarPull.this;
            obj.countAllKom = ((Hal3KomentarPull) (obj)).countAllKom + 1;
            obj = Hal3KomentarPull.this;
            obj.countKomOld = ((Hal3KomentarPull) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            Log.e("komentarhp", ((JSONObject) (obj)).getString("komentarhp"));
            mArrayListData.add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            Log.e("mArrayListDataRep", String.valueOf(mArrayListData.size()));
            if (!jum_komen.equals("-"))
            {
                TestFragmentAdapter.CONTENT[2] = (new StringBuilder("<font color='#FFFFFF'>KOMENTAR</font> <font color='#fb8c00'>")).append(jum_komen).append("</font>").toString();
                Hal2Spek.detail_text_komentar.setText(jum_komen);
                DetailsPonsel.tabs.notifyDataSetChanged();
            }
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(mArrayListData.size()));
            int i = 0;
_L16:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            void1 = Hal3KomentarPull.this;
            void1.removeNextIndex = ((Hal3KomentarPull) (void1)).removeNextIndex + countRemIndex;
            Log.e("mArrayListDataAfterRep", String.valueOf(mArrayListData.size()));
_L12:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            return;
_L4:
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            ImageView imageview;
            ImageView imageview1;
            void1 = Hal3KomentarPull.this;
            void1.countRemIndex = ((Hal3KomentarPull) (void1)).countRemIndex + 1;
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
            imageview = (ImageView)void1.findViewById(0x7f0b054f);
            imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komentar = ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            codename = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            nama_komentar = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            email_komentar = ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            tanggal_komentar = ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            komentarhp = ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            s = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
            String s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L6; else goto _L5
_L5:
            lay_quote.setVisibility(8);
_L11:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L13:
            if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png")) goto _L10; else goto _L9
_L9:
            boolean flag = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg");
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_1985;
            }
_L10:
            Picasso.with(getActivity()).load(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

                final KomentarReplyAsycTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_kom_picture.setVisibility(0);
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
_L14:
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1, 0);
            list_lay_like.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
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
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls2.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls2.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
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
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
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
                        startActivityForResult(view, Hal3KomentarPull.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = String.this;
                super();
            }
            });
            void1.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            i++;
            continue; /* Loop/switch isn't completed */
_L6:
            lay_quote.setVisibility(0);
              goto _L11
            void1;
            void1.printStackTrace();
              goto _L12
_L8:
label0:
            {
                if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L13
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L13
            Exception exception;
            exception;
            exception.printStackTrace();
              goto _L14
            img_kom_picture.setImageResource(0x7f020297);
              goto _L14
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            return;
            if (true) goto _L16; else goto _L15
_L15:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtbtnheader.setVisibility(8);
            Log.e("mArrayListDataBefore", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
        }


        public KomentarReplyAsycTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

        private void parseJSONLikeKom(String s)
        {
            int i;
            try
            {
                s = new JSONObject(s);
                postStatusLikeKom = s.getString("success");
                postMessageLikeKom = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            i = 0;
            if (i >= jArray.length())
            {
                return;
            }
            s = jArray.getJSONObject(i);
            tot_LikeKom = s.getString("komen_bagus");
            totdis_LikeKom = s.getString("komen_kurang");
            Log.e("tot_LikePon", tot_LikeKom);
            Log.e("totdis_LikePon", totdis_LikeKom);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_50;
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_komentar.php?").append(querylike).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                reslike = avoid.toString();
                parseJSONLikeKom(reslike);
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
            Log.e("postStatusLikeKom", postStatusLikeKom);
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_199;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_149;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.suclikefrontKomen);
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new SendMailLikeDisTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_179;
            try
            {
                notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.sucdislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            (new SendMailLikeDisTask()).execute(new Void[0]);
            return;
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
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
            mArrayListData.add(mArrayListData.size(), new ItemKomenHp(s.getString("id_komentar"), s.getString("id_hp"), s.getString("codename"), s.getString("nama_komentar"), s.getString("email_komentar"), s.getString("tanggal_komentar"), s.getString("komentarhp"), s.getString("komen_bagus"), s.getString("komen_kurang"), s.getString("usr_pict_komen"), s.getString("reply_to"), s.getString("nama_to"), s.getString("komen_to"), s.getString("tanggal_to"), s.getString("my_like_kom"), s.getString("img_kom"), s.getString("img_kom_rep")));
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
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
            if (i >= mArrayListData.size())
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
                final String id_komentar = ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
                final String id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
                final String codename = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
                final String nama_komentar = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
                final String email_komentar = ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
                final String tanggal_komentar = ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
                final String komentarhp = ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
                ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
                ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
                String s = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
                ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
                ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
                ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
                ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
                ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
                ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
                ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
                imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
                imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
                txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
                txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
                progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
                progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
                String s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
                String s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
                check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
                if (((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0"))
                {
                    lay_quote.setVisibility(8);
                } else
                {
                    lay_quote.setVisibility(0);
                }
                if (((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1"))
                {
                    imageview.setBackgroundResource(0x7f02025b);
                    imageview1.setBackgroundResource(0x7f0201a3);
                    list_lay_like.setEnabled(false);
                    list_lay_dislike.setEnabled(true);
                } else
                if (((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
                if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
                {
                    try
                    {
                        Picasso.with(getActivity()).load(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

                            final PostKomen this$1;

                            public void onError()
                            {
                            }

                            public void onSuccess()
                            {
                                img_kom_picture.setVisibility(0);
                            }

            
            {
                this$1 = PostKomen.this;
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
                txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
                txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
                txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
                txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
                txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
                txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
                txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
                txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
                txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
                mLinearListView.addView(void1, 0);
                img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                    final PostKomen this$1;
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
                this$1 = final_postkomen;
                usr_pict_komen = String.this;
                super();
            }
                });
                img_kom_picture.setOnClickListener(nama_komentar. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$nama_komentar;

                    public void onClick(View view)
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                        view.putExtra("id_user_view", nama_komentar);
                        startActivityForResult(view, 0);
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_postkomen;
                nama_komentar = String.this;
                super();
            }
                });
                list_lay_like.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
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
                                (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getActivity());
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = PostKomen._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls4.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_postkomen;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
                });
                list_lay_dislike.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
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
                                (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getActivity());
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = PostKomen._cls5.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls5.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls5.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_postkomen;
                id_komentar = s;
                id_hp = String.this;
                super();
            }
                });
                list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
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
                            startActivityForResult(view, Hal3KomentarPull.POST_STAT);
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getActivity());
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = PostKomen._cls6.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls6.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls6.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_postkomen;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = String.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(codename. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$codename;
                    private final String val$id_hp;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnfooter.setVisibility(8);
                            view = _fld0;
                            view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                            urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                            Log.e("urlKomenOld", urlKomenOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new KomentarOldAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = final_postkomen;
                id_hp = s;
                codename = String.this;
                super();
            }
                });
                i++;
                continue; /* Loop/switch isn't completed */
            }
_L2:
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final PostKomen this$1;

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
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = PostKomen.this;
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new SendMailTask()).execute(new Void[0]);
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
            Log.e("mArrayListDataPostKomen", String.valueOf(mArrayListData.size()));
            mNotificationHelper.createNotification(namalengkap, mNotificationHelper.komenPostWords);
            mArrayListData.clear();
            Log.e("clearmArrayKomen", String.valueOf(mArrayListData.size()));
        }


        public PostKomen()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_com").append(Utility.BASE_FORMAT).append("?").append(querylike).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("mail_like_com", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                res = res.trim();
                res = res.replaceAll("\\s+", "");
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public SendMailLikeDisTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_hp").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("pushURLemail", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                res = res.trim();
                res = res.replaceAll("\\s+", "");
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public SendMailTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final Hal3KomentarPull this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataNotifOnOff, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid != null)
            {
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    messageNotif = avoid.getString("message");
                    kmail_stat = avoid.getString("kmail_stat");
                    Log.e("suc", suc);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
            } else
            {
                Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
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
            progbar_notifHP.setVisibility(8);
            itemTurnNotif.setEnabled(true);
            Log.e("kmail_stat", kmail_stat);
            if (kmail_stat.equals("1"))
            {
                itemTurnNotif.setChecked(true);
                return;
            } else
            {
                itemTurnNotif.setChecked(false);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progbar_notifHP.setVisibility(0);
            itemTurnNotif.setEnabled(false);
        }

        public TurnOnOffNotifTask()
        {
            this$0 = Hal3KomentarPull.this;
            super();
        }
    }


    private static int POST_STAT = 0;
    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    public static String komencount = "";
    public static int scrollX = 0;
    public static int scrollY = -1;
    String bottom_id;
    Button btnRefresh;
    Button btn_komen_pic;
    Button btn_pop_login;
    Button btn_send_komen;
    int charCount;
    ConnectivityManager cm;
    String codename;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    Cursor cursor;
    String dataNotifOnOff;
    DatabaseHandler db;
    String details;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    String email_user;
    Bundle extras;
    String first_exe;
    String gambar;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    LinearLayout headName;
    String host;
    String id_hp;
    String id_kom;
    String idkom_pos;
    ImageView imgKomentar;
    ImageView imgKomentar_rep;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray inponsel;
    String isikomentar;
    MenuItem itemTurnNotif;
    JSONArray jArray;
    String jumSC;
    String jum_komen;
    String kmail_stat;
    RelativeLayout lay_pop_komen;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    LinearLayout layout_footerNext;
    LinearLayout layout_header;
    int limit;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    RelativeLayout list_lay_rep;
    RelativeLayout ll_img_komen;
    RelativeLayout ll_img_komen_rep;
    LinearLayout ll_separator;
    LinearLayout ll_separator_atas;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    private LinearLayout mLinearListView;
    NotificationKomenHelper mNotificationHelper;
    Menu mainMenu;
    String merk;
    String messageNotif;
    String model;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    String notif;
    NotificationLikeHelper notificationLikeHelper;
    String passlam;
    PonselBaseApp ponselBaseApp;
    CircularProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    String postMessage;
    String postMessageLikeKom;
    String postStatus;
    String postStatusLikeKom;
    SmoothProgressBar progbar_notifHP;
    ProgressBar progressbar_imgkomen;
    ProgressBar progressbar_imgkomenrep;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    String scheme;
    ScrollView scrollviewKomen;
    String sortkom;
    String statusKomen;
    String statuslike;
    String strJsonRssRep;
    String strKonekStat;
    String suc;
    String succesStat;
    String t;
    String tanggal;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String tot_komen;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtIdKom;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtTanggapan;
    TextView txtTapImage;
    TextView txtTapImageRep;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txtbtnfooter;
    TextView txtbtnheader;
    TextView txtdisLikeKom;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kota;
    String user_photo;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String userkomen;
    String username;
    String userpict;
    ContextThemeWrapper wrapperLight;

    public Hal3KomentarPull()
    {
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strKonekStat = "";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        strJsonRssRep = "";
        first_exe = "0";
        removeIndex = 0;
        removeStartOld = 0;
        removeNextIndex = 0;
        countRemIndex = 0;
        querylike = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        tot_LikeKom = "0";
        totdis_LikeKom = "0";
        limit = 0;
        querypopkomen = "";
        id_hp = "";
        merk = "";
        model = "";
        gambar = "";
        namalengkap = "";
        codename = "";
        tot_komen = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        statusKomen = "";
        dataNotifOnOff = "0";
        inponsel = null;
        suc = "";
        jumSC = "";
        messageNotif = "";
        kmail_stat = "";
        sortkom = "12";
    }

    private void check_image_komen(final RelativeLayout ll_img_komen, RelativeLayout relativelayout, TextView textview, TextView textview1, final ImageView imgKomentar, ImageView imageview, final ProgressBar progressbar_imgkomen, 
            ProgressBar progressbar, final String img_media, final String img_media_to)
    {
        Log.e("img_media", img_media);
        if (img_media.equals("-") || img_media.equals(""))
        {
            textview.setVisibility(8);
            ll_img_komen.setVisibility(8);
        } else
        {
            textview.setVisibility(0);
            textview.setVisibility(8);
            progressbar_imgkomen.setVisibility(0);
            ll_img_komen.setVisibility(0);
            Picasso.with(getActivity()).load(img_media.trim()).into(imgKomentar, new Callback() {

                final Hal3KomentarPull this$0;
                private final ImageView val$imgKomentar;
                private final String val$img_media;
                private final RelativeLayout val$ll_img_komen;
                private final ProgressBar val$progressbar_imgkomen;

                public void onError()
                {
                    Log.e("ll_img_komen", "onError");
                    progressbar_imgkomen.setVisibility(8);
                }

                public void onSuccess()
                {
                    Log.e("ll_img_komen", "onSuccess");
                    progressbar_imgkomen.setVisibility(8);
                    imgKomentar.setVisibility(0);
                    ll_img_komen.setClickable(false);
                    imgKomentar.setOnClickListener(img_media. new android.view.View.OnClickListener() {

                        final _cls9 this$1;
                        private final String val$img_media;

                        public void onClick(View view)
                        {
                            view = new ArrayList();
                            Object obj = img_media;
                            obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1);
                            Log.e("img_real", ((String) (obj)));
                            view.add(((String) (obj)).toString().trim());
                            view = (String[])view.toArray(new String[view.size()]);
                            obj = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                            ((Intent) (obj)).putExtra("imgUrl", view);
                            ((Intent) (obj)).putExtra("pos", 0);
                            startActivity(((Intent) (obj)));
                        }

            
            {
                this$1 = final__pcls9;
                img_media = String.this;
                super();
            }
                    });
                }


            
            {
                this$0 = Hal3KomentarPull.this;
                progressbar_imgkomen = progressbar;
                imgKomentar = imageview;
                ll_img_komen = relativelayout;
                img_media = s;
                super();
            }
            });
        }
        Log.e("img_media_to", img_media_to);
        if (img_media_to.equals("-") || img_media_to.equals(""))
        {
            textview1.setVisibility(8);
            relativelayout.setVisibility(8);
        } else
        {
            relativelayout.setVisibility(8);
            textview1.setVisibility(0);
        }
        textview1.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull this$0;
            private final String val$img_media;
            private final String val$img_media_to;

            public void onClick(View view)
            {
                Log.e("ll_img_komen_rep", img_media);
                view = new ArrayList();
                Object obj = img_media_to;
                view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
                view = (String[])view.toArray(new String[view.size()]);
                obj = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                ((Intent) (obj)).putExtra("imgUrl", view);
                ((Intent) (obj)).putExtra("pos", 0);
                startActivity(((Intent) (obj)));
            }

            
            {
                this$0 = Hal3KomentarPull.this;
                img_media = s;
                img_media_to = s1;
                super();
            }
        });
    }

    public void TurnOnOffNotifTask()
    {
        Object obj;
        obj = getActivity();
        getActivity();
        loginPreference = ((FragmentActivity) (obj)).getSharedPreferences("com.inponsel.android_preference", 0);
        passlam = EncodeDecodeAES.decrypt(RestClient.pelihara, loginPreference.getString("save", ""));
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        Log.e("passlama", passlam);
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_hp").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&codename=").append(URLEncoder.encode(codename, "utf-8")).append("&khpmail=").append(statusKomen).append("&id_hp=").append(id_hp).append("&t=").append(t).toString();
        Log.e("dataNotifOnOff", dataNotifOnOff);
        obj = new TurnOnOffNotifTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ((TurnOnOffNotifTask) (obj)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        try
        {
            ((TurnOnOffNotifTask) (obj)).execute(new Void[0]);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return;
    }

    public String getJSONUrl(String s)
    {
        StringBuilder stringbuilder;
        Object obj;
        stringbuilder = new StringBuilder();
        obj = new DefaultHttpClient();
        s = new HttpGet(s);
        s = ((HttpClient) (obj)).execute(s);
        if (s.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        s = new BufferedReader(new InputStreamReader(s.getEntity().getContent()));
_L3:
        obj = s.readLine();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
_L2:
        stringbuilder.append(((String) (obj)));
          goto _L3
        try
        {
            Log.e("Log", "Failed to download file..");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
          goto _L1
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Log.e("onActivityResult", "RESULT_OK");
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        intent = intent.getStringExtra("jsonKom");
        Log.e("onActivityResultAct3", intent);
        strJsonRssRep = intent;
        if (intent.equals(""))
        {
            break MISSING_BLOCK_LABEL_100;
        }
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarReplyAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
        (new KomentarReplyAsycTask()).execute(new String[0]);
        return;
        Log.e("onActivityResult", "false");
    }

    public void onCreate(Bundle bundle)
    {
        setRetainInstance(true);
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            menuinflater.inflate(0x7f0f000a, menu);
        } else
        {
            menuinflater.inflate(0x7f0f000c, menu);
        }
        mainMenu = menu;
        itemTurnNotif = menu.findItem(0x7f0b0941);
        Log.e("statusKomenmenu", statusKomen);
        if (statusKomen.equals("1"))
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Field field;
        bundle = ViewConfiguration.get(getActivity());
        field = android/view/ViewConfiguration.getDeclaredField("sHasPermanentMenuKey");
        if (field != null)
        {
            try
            {
                field.setAccessible(true);
                field.setBoolean(bundle, false);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        layoutinflater = layoutinflater.inflate(0x7f03009d, viewgroup, false);
        komencount = "";
        wrapperLight = new ContextThemeWrapper(getActivity(), 0x103006e);
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        imm = (InputMethodManager)getActivity().getSystemService("input_method");
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        t = Utility.session(t);
        extras = getActivity().getIntent().getExtras();
        if (!String.valueOf(DetailsPonsel.dataurlemail).equals("null"))
        {
            scheme = DetailsPonsel.dataurlemail.getScheme();
            host = DetailsPonsel.dataurlemail.getHost();
            viewgroup = DetailsPonsel.dataurlemail.getPathSegments();
            details = (String)viewgroup.get(0);
            id_hp = (String)viewgroup.get(1);
            notif = "email";
        } else
        {
            id_hp = extras.getString("id_hph");
            model = extras.getString("model");
            merk = extras.getString("merk");
            gambar = extras.getString("gambar");
            codename = extras.getString("codename");
            tot_komen = extras.getString("tot_komen");
            namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
            namalengkapbgskrg = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            codename = extras.getString("codename");
        }
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName((new StringBuilder("Komentar ")).append(namalengkap).toString());
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        t = Utility.session(t);
        mLinearListView = (LinearLayout)layoutinflater.findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        mNotificationHelper = new NotificationKomenHelper(getActivity());
        btn_send_komen = (Button)layoutinflater.findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)layoutinflater.findViewById(0x7f0b04de);
        mArrayListData = new ArrayList();
        txtbtnheader = (TextView)layoutinflater.findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)layoutinflater.findViewById(0x7f0b04d9);
        progbar_notifHP = (SmoothProgressBar)layoutinflater.findViewById(0x7f0b04cb);
        progbar_notifHP.setVisibility(8);
        layout_header = (LinearLayout)layoutinflater.findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00be);
        grup_footer.setVisibility(8);
        layout_footerNext = (LinearLayout)layoutinflater.findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)layoutinflater.findViewById(0x7f0b04d3);
        lay_pop_komen = (RelativeLayout)layoutinflater.findViewById(0x7f0b04da);
        btn_pop_login = (Button)layoutinflater.findViewById(0x7f0b04e1);
        pop_txtCountKomen = (TextView)layoutinflater.findViewById(0x7f0b04df);
        btn_komen_pic = (Button)layoutinflater.findViewById(0x7f0b053a);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)layoutinflater.findViewById(0x7f0b052d);
        pop_progressbar_middle = (CircularProgressBar)layoutinflater.findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)layoutinflater.findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        pop_progressbar_middle.setVisibility(8);
        btnRefresh = (Button)layoutinflater.findViewById(0x7f0b04d0);
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
        });
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", "ponsel");
                view.putExtra("top_id", top_id);
                view.putExtra("id_hph", id_hp);
                view.putExtra("merk", merk);
                view.putExtra("model", model);
                view.putExtra("codename", codename);
                view.putExtra("top_id", top_id);
                startActivityForResult(view, Hal3KomentarPull.POST_STAT);
            }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            btn_send_komen.setVisibility(0);
            btn_pop_login.setVisibility(8);
            edt_pop_komen.setVisibility(0);
            lay_pop_komen.setVisibility(0);
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup) { }
            nama_asli = cursor.getString(2);
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        } else
        {
            btn_send_komen.setVisibility(8);
            btn_pop_login.setVisibility(0);
            edt_pop_komen.setVisibility(8);
            pop_txtCountKomen.setVisibility(8);
            lay_pop_komen.setVisibility(8);
        }
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final Hal3KomentarPull this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                Hal3KomentarPull.komencount = edt_pop_komen.getText().toString();
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                } else
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                } else
                {
                    btn_send_komen.setEnabled(true);
                }
                pop_txtCountKomen.setText(String.valueOf(charCount));
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                Hal3KomentarPull.komencount = edt_pop_komen.getText().toString();
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                } else
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                } else
                {
                    btn_send_komen.setEnabled(true);
                }
                pop_txtCountKomen.setText(String.valueOf(charCount));
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                Hal3KomentarPull.komencount = edt_pop_komen.getText().toString();
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                } else
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                } else
                {
                    btn_send_komen.setEnabled(true);
                }
                pop_txtCountKomen.setText(String.valueOf(charCount));
            }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
        });
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup) { }
        layout_empty.setVisibility(0);
        pop_progressbar_middle.setVisibility(0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return layoutinflater;
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
            return layoutinflater;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 4: default 48
    //                   16908332: 54
    //                   2131429695: 76
    //                   2131429696: 266
    //                   2131429697: 446;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        getActivity().finish();
        getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
        return true;
_L3:
        sortkom = "1";
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        Log.e("urlKomen", urlKomen);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        sortkom = "2";
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception1)
        {
            unsupportedencodingexception1.printStackTrace();
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        userFunctions = new UserFunctions();
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            String s;
            android.app.AlertDialog.Builder builder1;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                s = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            } else
            {
                statusKomen = "1";
                s = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            }
            Log.e("statusKomen", statusKomen);
            builder1 = new android.app.AlertDialog.Builder(getActivity());
            builder1.setTitle("Perhatian");
            builder1.setMessage(s);
            builder1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
            });
            builder1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (itemTurnNotif.isChecked())
                    {
                        itemTurnNotif.setChecked(true);
                    } else
                    {
                        itemTurnNotif.setChecked(false);
                    }
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
            });
            builder1.show();
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            builder.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
            });
            builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
            });
            builder.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = Hal3KomentarPull.this;
                super();
            }
            });
            builder.show();
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void update(Observable observable, Object obj)
    {
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            btn_send_komen.setVisibility(0);
            btn_pop_login.setVisibility(8);
            edt_pop_komen.setVisibility(0);
            lay_pop_komen.setVisibility(0);
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Observable observable) { }
            nama_asli = cursor.getString(2);
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
            return;
        } else
        {
            btn_send_komen.setVisibility(8);
            btn_pop_login.setVisibility(0);
            edt_pop_komen.setVisibility(8);
            pop_txtCountKomen.setVisibility(8);
            lay_pop_komen.setVisibility(8);
            return;
        }
    }

    public void updateViewLikeDis(String s)
    {
        int i;
        Log.e("id_kom", s);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L2:
        ImageView imageview;
        ImageView imageview1;
        RelativeLayout relativelayout;
        Object obj;
        if (i >= mLinearListView.getChildCount())
        {
            return;
        }
        obj = mLinearListView.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b0554);
        imageview = (ImageView)((View) (obj)).findViewById(0x7f0b054f);
        imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
        relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
        obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
        if (textview.getText().toString().equals(s))
        {
            textview1.setText(tot_LikeKom);
            textview2.setText(totdis_LikeKom);
            if (!statuslike.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            relativelayout.setEnabled(false);
            ((RelativeLayout) (obj)).setEnabled(true);
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("0")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f020257);
        imageview1.setBackgroundResource(0x7f0201a7);
        relativelayout.setEnabled(true);
        ((RelativeLayout) (obj)).setEnabled(false);
          goto _L4
    }





}
