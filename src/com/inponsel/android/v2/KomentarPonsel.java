// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
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
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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

// Referenced classes of package com.inponsel.android.v2:
//            ImagePagerActivity, ProfileOtherUser, RegisterActivity, LoginActivity, 
//            ReplyFormActivity, AddKomentarPicture

public class KomentarPonsel extends SherlockFragmentActivity
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
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
                    if (i >= mArrayListData.size())
                    {
                        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarAsycTask this$1;

                            public void onClick(View view)
                            {
                                try
                                {
                                    txtbtnfooter.setVisibility(8);
                                    view = _fld0;
                                    view.limit = ((KomentarPonsel) (view)).limit + 15;
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
                        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarAsycTask this$1;

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
                this$1 = KomentarAsycTask.this;
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
                        String s;
                        final String usr_pict_komen;
                        String s1;
                        String s2;
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
                    id_komentar = ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
                    id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
                    codename = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
                    nama_komentar = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
                    email_komentar = ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
                    tanggal_komentar = ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
                    s = ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
                    usr_pict_komen = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
                    ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
                    s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
                    s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
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
                        imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
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
                    mLinearListView.addView(void1);
                    img_kom_picture.setOnLongClickListener(usr_pict_komen. new android.view.View.OnLongClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$usr_pict_komen;

                        public boolean onLongClick(View view)
                        {
                            view = new ArrayList();
                            view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
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
                            view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                            view.putExtra("id_user_view", nama_komentar);
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
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
                            if (userFunctions.isUserLoggedIn(_fld0))
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

                                    final KomentarAsycTask._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = KomentarAsycTask._cls3.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final KomentarAsycTask._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                        startActivity(dialoginterface);
                                    }

            
            {
                this$2 = KomentarAsycTask._cls3.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final KomentarAsycTask._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        startActivity(dialoginterface);
                                    }

            
            {
                this$2 = KomentarAsycTask._cls3.this;
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
                            if (userFunctions.isUserLoggedIn(_fld0))
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
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                            Log.e("iRep", (new StringBuilder(String.valueOf(id_hp))).append(" - ").append(id_komentar).append(" - ").append(email_komentar).append(" - ").append(nama_komentar).append(" - ").append(tanggal_komentar).append(" - ").append(usr_pict_komen).append(" - ").append(namalengkap).append(" - ").append(codename).toString());
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                view = new Intent(_fld0, com/inponsel/android/v2/ReplyFormActivity);
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
                                startActivityForResult(view, KomentarPonsel.POST_STAT);
                                return;
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(wrapperLight);
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
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                usr_pict_komen = s5;
                codename = s6;
                komentarhp = String.this;
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
                    i++;
                } while (true);
            } else
            {
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnfooter.setVisibility(8);
                            view = _fld0;
                            view.limit = ((KomentarPonsel) (view)).limit + 15;
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
                btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;

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
                this$1 = KomentarAsycTask.this;
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
            mLinearListView.removeAllViewsInLayout();
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class KomentarNextAsycTask extends AsyncTask
    {

        final KomentarPonsel this$0;

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
            Object obj = KomentarPonsel.this;
            obj.countAllKom = ((KomentarPonsel) (obj)).countAllKom + 1;
            obj = KomentarPonsel.this;
            obj.countKomOld = ((KomentarPonsel) (obj)).countKomOld + 1;
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
_L9:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            void1 = KomentarPonsel.this;
            void1.removeNextIndex = ((KomentarPonsel) (void1)).removeNextIndex + countRemIndex;
            Log.e("removeNextIndex", String.valueOf(removeNextIndex));
_L13:
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((KomentarPonsel) (view)).limit + 15;
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
            ImageView imageview;
            ImageView imageview1;
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            void1 = KomentarPonsel.this;
            void1.countRemIndex = ((KomentarPonsel) (void1)).countRemIndex + 1;
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
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
_L10:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L11:
            if (!((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1921;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L12:
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
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
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
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
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
                    if (userFunctions.isUserLoggedIn(_fld0))
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

                            final KomentarNextAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls3.this;
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
                    if (userFunctions.isUserLoggedIn(_fld0))
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/ReplyFormActivity);
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
                        startActivityForResult(view, KomentarPonsel.POST_STAT);
                        return;
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
              goto _L9
_L6:
            lay_quote.setVisibility(0);
              goto _L10
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
              goto _L11
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L11
            img_kom_picture.setImageResource(0x7f020297);
              goto _L12
_L2:
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((KomentarPonsel) (view)).limit + 15;
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
              goto _L13
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
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class KomentarOldAsycTask extends AsyncTask
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
            ImageView imageview;
            ImageView imageview1;
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            String s1;
            String s2;
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
            s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
            s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L2; else goto _L1
_L1:
            lay_quote.setVisibility(8);
_L5:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L4; else goto _L3
_L3:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L6:
            if (!((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_2099;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L7:
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
                break MISSING_BLOCK_LABEL_1828;
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
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
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
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
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
                    if (userFunctions.isUserLoggedIn(_fld0))
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

                            final KomentarOldAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarOldAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarOldAsycTask._cls3.this;
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
                    if (userFunctions.isUserLoggedIn(_fld0))
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/ReplyFormActivity);
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
                        startActivityForResult(view, KomentarPonsel.POST_STAT);
                        return;
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
              goto _L5
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
            mArrayListData.clear();
        }


        public KomentarOldAsycTask()
        {
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class KomentarReplyAsycTask extends AsyncTask
    {

        final KomentarPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarReplyAsycTask", strJsonRssRep);
            JSONObject jsonobject = new JSONObject(strJsonRssRep);
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            if (!jsonobject.getString("top_id").equals("-"))
            {
                top_id = jsonobject.getString("top_id");
            }
            jum_komen = jsonobject.getString("jum_komen");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_311;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_311;
            }
            Object obj = KomentarPonsel.this;
            obj.countAllKom = ((KomentarPonsel) (obj)).countAllKom + 1;
            obj = KomentarPonsel.this;
            obj.countKomOld = ((KomentarPonsel) (obj)).countKomOld + 1;
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
            jum_komen.equals("-");
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(mArrayListData.size()));
            int i = 0;
_L9:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            void1 = KomentarPonsel.this;
            void1.removeNextIndex = ((KomentarPonsel) (void1)).removeNextIndex + countRemIndex;
            Log.e("mArrayListDataAfterRep", String.valueOf(mArrayListData.size()));
            mLinearListView.removeViewAt(mLinearListView.getChildCount());
_L13:
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((KomentarPonsel) (view)).limit + 15;
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
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

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
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            layout_empty.setVisibility(8);
            return;
_L4:
            ImageView imageview;
            ImageView imageview1;
            final String id_komentar;
            final String id_hp;
            final String codename;
            final String nama_komentar;
            final String email_komentar;
            final String tanggal_komentar;
            final String komentarhp;
            String s;
            void1 = KomentarPonsel.this;
            void1.countRemIndex = ((KomentarPonsel) (void1)).countRemIndex + 1;
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
            String s1 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media();
            String s2 = ((ItemKomenHp)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L6; else goto _L5
_L5:
            lay_quote.setVisibility(8);
_L10:
            if (!((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L11:
            Log.e("avatarpict", ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim());
            if (!((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1979;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L12:
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
                    if (userFunctions.isUserLoggedIn(_fld0))
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
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls1.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls1.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarReplyAsycTask._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarReplyAsycTask._cls1.this;
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
                    if (userFunctions.isUserLoggedIn(_fld0))
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
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/ReplyFormActivity);
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
                        startActivityForResult(view, KomentarPonsel.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
              goto _L9
_L6:
            lay_quote.setVisibility(0);
              goto _L10
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
              goto _L11
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L11
            img_kom_picture.setImageResource(0x7f020297);
              goto _L12
_L2:
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnfooter.setVisibility(8);
                        view = _fld0;
                        view.limit = ((KomentarPonsel) (view)).limit + 15;
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
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

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
                this$1 = KomentarReplyAsycTask.this;
                super();
            }
            });
            return;
            void1;
              goto _L13
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(0);
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
        }


        public KomentarReplyAsycTask()
        {
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final KomentarPonsel this$0;

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
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
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
                    imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
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
                list_lay_like.setOnClickListener(id_hp. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_hp;
                    private final String val$id_komentar;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
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

                                final PostKomen._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = PostKomen._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls1.this;
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
                        if (userFunctions.isUserLoggedIn(_fld0))
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

                                final PostKomen._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = PostKomen._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls2.this;
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
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            view = new Intent(_fld0, com/inponsel/android/v2/ReplyFormActivity);
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
                            startActivityForResult(view, KomentarPonsel.POST_STAT);
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = PostKomen._cls3.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls3.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final PostKomen._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = PostKomen._cls3.this;
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
                            view.limit = ((KomentarPonsel) (view)).limit + 15;
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
            Log.e("mArrayListDataPostKomen", String.valueOf(mArrayListData.size()));
            mNotificationHelper.createNotification(namalengkap, mNotificationHelper.komenPostWords);
            mArrayListData.clear();
            Log.e("clearmArrayKomen", String.valueOf(mArrayListData.size()));
        }


        public PostKomen()
        {
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final KomentarPonsel this$0;

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
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final KomentarPonsel this$0;

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
            this$0 = KomentarPonsel.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final KomentarPonsel this$0;

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
            this$0 = KomentarPonsel.this;
            super();
        }
    }


    private static int POST_STAT = 0;
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
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
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    String email_user;
    Bundle extras;
    String gambar;
    LinearLayout grup_footer;
    LinearLayout headName;
    String id_hp;
    String id_kom;
    String idkom_pos;
    ImageLoader imageLoader2;
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
    String komencount;
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
    private Menu mainMenu;
    String merk;
    String messageNotif;
    String model;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    NotificationLikeHelper notificationLikeHelper;
    private DisplayImageOptions options;
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
    private boolean useLogo;
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

    public KomentarPonsel()
    {
        statusKomen = "";
        dataNotifOnOff = "0";
        inponsel = null;
        suc = "";
        jumSC = "";
        messageNotif = "";
        kmail_stat = "";
        strJsonRssRep = "";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strKonekStat = "";
        top_id = "";
        bottom_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        animateFirstListener = new AnimateFirstDisplayListener();
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
        komencount = "";
        sortkom = "12";
        querypopkomen = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        tot_komen = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
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
            Picasso.with(getApplicationContext()).load(img_media.trim()).into(imgKomentar, new Callback() {

                final KomentarPonsel this$0;
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
                            obj = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
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
                this$0 = KomentarPonsel.this;
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

            final KomentarPonsel this$0;
            private final String val$img_media;
            private final String val$img_media_to;

            public void onClick(View view)
            {
                Log.e("ll_img_komen_rep", img_media);
                view = new ArrayList();
                Object obj = img_media_to;
                view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
                view = (String[])view.toArray(new String[view.size()]);
                obj = new Intent(KomentarPonsel.this, com/inponsel/android/v2/ImagePagerActivity);
                ((Intent) (obj)).putExtra("imgUrl", view);
                ((Intent) (obj)).putExtra("pos", 0);
                startActivity(((Intent) (obj)));
            }

            
            {
                this$0 = KomentarPonsel.this;
                img_media = s;
                img_media_to = s1;
                super();
            }
        });
    }

    private void setTranslucentStatus(boolean flag)
    {
        Window window = getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        if (flag)
        {
            layoutparams.flags = layoutparams.flags | 0x4000000;
        } else
        {
            layoutparams.flags = layoutparams.flags & 0xfbffffff;
        }
        window.setAttributes(layoutparams);
    }

    public void TurnOnOffNotifTask()
    {
        TurnOnOffNotifTask turnonoffnotiftask;
        loginPreference = getSharedPreferences("com.inponsel.android_preference", 0);
        passlam = EncodeDecodeAES.decrypt(RestClient.pelihara, loginPreference.getString("save", ""));
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        Log.e("passlama", passlam);
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_hp").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&codename=").append(URLEncoder.encode(codename, "utf-8")).append("&khpmail=").append(statusKomen).append("&id_hp=").append(id_hp).append("&t=").append(t).toString();
        Log.e("dataNotifOnOff", dataNotifOnOff);
        turnonoffnotiftask = new TurnOnOffNotifTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            turnonoffnotiftask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        try
        {
            turnonoffnotiftask.execute(new Void[0]);
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

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Log.e("onActivityResult", "RESULT_OK");
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        intent = intent.getStringExtra("jsonKom");
        Log.e("onActivityResultAct", intent);
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

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03009d);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        Field field;
        bundle = ViewConfiguration.get(this);
        field = android/view/ViewConfiguration.getDeclaredField("sHasPermanentMenuKey");
        int i;
        int j;
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
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        extras = getIntent().getExtras();
        id_hp = extras.getString("id_hph");
        model = extras.getString("model");
        merk = extras.getString("merk");
        gambar = extras.getString("gambar");
        codename = extras.getString("codename");
        tot_komen = extras.getString("tot_komen");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkapbgskrg = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Komentar ")).append(namalengkap).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode(namalengkap)).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(URLDecoder.decode(namalengkap));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        btn_komen_pic = (Button)findViewById(0x7f0b053a);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeHelper(this);
        mNotificationHelper = new NotificationKomenHelper(this);
        progbar_notifHP = (SmoothProgressBar)findViewById(0x7f0b04cb);
        progbar_notifHP.setVisibility(8);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        mArrayListData = new ArrayList();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        txtbtnheader = (TextView)findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        txtbtnfooter.setVisibility(8);
        layout_header = (LinearLayout)findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)findViewById(0x7f0b00c0);
        lay_pop_komen = (RelativeLayout)findViewById(0x7f0b04da);
        btn_pop_login = (Button)findViewById(0x7f0b04e1);
        btn_pop_login.setSelected(true);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)findViewById(0x7f0b052d);
        pop_progressbar_middle = (CircularProgressBar)findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        btnRefresh = (Button)findViewById(0x7f0b04d0);
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel this$0;

            public void onClick(View view)
            {
                view = new Intent(KomentarPonsel.this, com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(this))
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
            catch (Bundle bundle) { }
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

            final KomentarPonsel this$0;

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
                komencount = edt_pop_komen.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                komencount = edt_pop_komen.getText().toString();
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
        });
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        layout_empty.setVisibility(0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarPonsel this$0;

            public void onClick(View view)
            {
                view = new Intent(KomentarPonsel.this, com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", "ponsel");
                view.putExtra("top_id", top_id);
                view.putExtra("id_hph", id_hp);
                view.putExtra("merk", merk);
                view.putExtra("model", model);
                view.putExtra("codename", codename);
                view.putExtra("top_id", top_id);
                startActivityForResult(view, KomentarPonsel.POST_STAT);
            }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
        });
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f000a, menu);
        mainMenu = menu;
        itemTurnNotif = menu.findItem(0x7f0b0941);
        if (statusKomen.equals("1"))
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 82 82: default 28
    //                   82 35;
           goto _L2 _L3
_L2:
        return super.onKeyUp(i, keyevent);
_L3:
        mainMenu.performIdentifierAction(0x7f0b093a, 0);
        return true;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 4: default 48
    //                   16908332: 50
    //                   2131429695: 67
    //                   2131429696: 257
    //                   2131429697: 437;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        continue; /* Loop/switch isn't completed */
_L3:
        sortkom = "1";
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        }
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            menuitem.printStackTrace();
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
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            menuitem.printStackTrace();
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
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            android.app.AlertDialog.Builder builder;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                menuitem = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            } else
            {
                statusKomen = "1";
                menuitem = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            }
            Log.e("statusKomen", statusKomen);
            builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Perhatian");
            builder.setMessage(menuitem);
            builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
            });
            builder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int j)
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
                this$0 = KomentarPonsel.this;
                super();
            }
            });
            builder.show();
        } else
        {
            menuitem = new android.app.AlertDialog.Builder(wrapperLight);
            menuitem.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            menuitem.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
            });
            menuitem.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface = new Intent(KomentarPonsel.this, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
            });
            menuitem.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface = new Intent(KomentarPonsel.this, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = KomentarPonsel.this;
                super();
            }
            });
            menuitem.show();
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void update(Observable observable, Object obj)
    {
label0:
        {
            if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(this))
            {
                cursor = db.getAllData();
                cursor.moveToFirst();
                try
                {
                    user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                }
                // Misplaced declaration of an exception variable
                catch (Observable observable) { }
                nama_asli = cursor.getString(2);
                user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
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
            }
            if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
            {
                if (!userFunctions.isUserLoggedIn(this))
                {
                    break label0;
                }
                btn_send_komen.setVisibility(0);
                btn_pop_login.setVisibility(8);
                edt_pop_komen.setVisibility(0);
                lay_pop_komen.setVisibility(0);
            }
            return;
        }
        btn_send_komen.setVisibility(8);
        btn_pop_login.setVisibility(0);
        edt_pop_komen.setVisibility(8);
        pop_txtCountKomen.setVisibility(8);
        lay_pop_komen.setVisibility(8);
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
