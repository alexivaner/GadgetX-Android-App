// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URLDecoder;
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
//            BaseDrawer, ImagePagerActivity, ProfileOtherUser

public class KomentarBaruLainPonsel extends SherlockFragmentActivity
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
    {

        final KomentarBaruLainPonsel this$0;

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
            Object obj = KomentarBaruLainPonsel.this;
            obj.countAllKom = ((KomentarBaruLainPonsel) (obj)).countAllKom + 1;
            obj = KomentarBaruLainPonsel.this;
            obj.countKomOld = ((KomentarBaruLainPonsel) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            if (!strKonekStat.equals("-"))
            {
                int i;
                if (counterLoad == 2)
                {
                    grup_footer.setVisibility(8);
                } else
                if (mArrayListData.size() < 15)
                {
                    grup_footer.setVisibility(8);
                } else
                {
                    grup_footer.setVisibility(0);
                }
                i = 0;
                do
                {
                    if (i >= mArrayListData.size())
                    {
                        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarAsycTask this$1;

                            public void onClick(View view)
                            {
                                try
                                {
                                    txtbtnheader.setVisibility(8);
                                    view = _fld0;
                                    view.limit = ((KomentarBaruLainPonsel) (view)).limit + 15;
                                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&top_id=").append(top_id).toString();
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
                                    view = _fld0;
                                    view.counterLoad = ((KomentarBaruLainPonsel) (view)).counterLoad + 0;
                                    limit = 0;
                                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&bottom_id=").append(bottom_id).toString();
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
                        layout_empty.setVisibility(8);
                        scrollviewKomen.setVisibility(0);
                        return;
                    }
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
                    ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
                    id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
                    String s = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
                    String s1 = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
                    ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
                    ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
                    String s2 = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
                    ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
                    ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
                    final String my_like_kom = ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
                    if (((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0"))
                    {
                        lay_quote.setVisibility(8);
                    } else
                    {
                        lay_quote.setVisibility(0);
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
                    txtNamaHp.setText(((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString());
                    txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
                    txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
                    txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                    txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
                    txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
                    txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                    txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
                    txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
                    mLinearListView.addView(void1);
                    img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

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
                    img_kom_picture.setOnClickListener(s1. new android.view.View.OnClickListener() {

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
                    void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarAsycTask this$1;
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
                this$1 = final_komentarasyctask;
                id_hp = s;
                my_like_kom = s1;
                codename = String.this;
                super();
            }
                    });
                    i++;
                } while (true);
            } else
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            view = _fld0;
                            view.limit = ((KomentarBaruLainPonsel) (view)).limit + 15;
                            urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&top_id=").append(top_id).toString();
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
                            view = _fld0;
                            view.counterLoad = ((KomentarBaruLainPonsel) (view)).counterLoad + 1;
                            limit = 0;
                            urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&bottom_id=").append(bottom_id).toString();
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
                scrollviewKomen.setVisibility(8);
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
            scrollviewKomen.setVisibility(8);
            layout_empty.setVisibility(0);
            mLinearListView.removeAllViewsInLayout();
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = KomentarBaruLainPonsel.this;
            super();
        }
    }

    public class KomentarNextAsycTask extends AsyncTask
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
            mArrayListData.add(0, new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            String s;
            String s1;
            String s2;
            final String my_like_kom;
            int i;
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
            ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            s = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            s1 = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            s2 = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            my_like_kom = ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L4; else goto _L3
_L3:
            lay_quote.setVisibility(8);
_L9:
            if (!((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1325;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L5:
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtNamaHp.setText(((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1, 0);
            img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

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
            img_kom_picture.setOnClickListener(s1. new android.view.View.OnClickListener() {

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
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
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
                this$1 = final_komentarnextasyctask;
                id_hp = s;
                my_like_kom = s1;
                codename = String.this;
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
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
        }


        public KomentarNextAsycTask()
        {
            this$0 = KomentarBaruLainPonsel.this;
            super();
        }
    }

    public class KomentarOldAsycTask extends AsyncTask
    {

        final KomentarBaruLainPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("urlKomenOld", urlKomenOld);
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenOld));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            bottom_id = jsonobject.getString("bottom_id");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_280;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_280;
            }
            Object obj = KomentarBaruLainPonsel.this;
            obj.countAllKom = ((KomentarBaruLainPonsel) (obj)).countAllKom + 1;
            obj = KomentarBaruLainPonsel.this;
            obj.countKomOld = ((KomentarBaruLainPonsel) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            if (counterLoad != 2) goto _L2; else goto _L1
_L1:
            grup_footer.setVisibility(8);
_L4:
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(mArrayListData.size()));
            int i = 0;
_L7:
            final String id_hp;
            String s;
            String s1;
            String s2;
            final String my_like_kom;
            try
            {
                if (i >= mArrayListData.size())
                {
                    void1 = KomentarBaruLainPonsel.this;
                    void1.removeIndex = ((KomentarBaruLainPonsel) (void1)).removeIndex + 3;
                    Log.e("removeIndexBef", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                    void1 = KomentarBaruLainPonsel.this;
                    void1.removeStartOld = ((KomentarBaruLainPonsel) (void1)).removeStartOld + 3;
                    Log.e("removeIndexAft", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                    txtbtnfooter.setVisibility(0);
                    layout_footerNext.setVisibility(8);
                    txtbtnheader.setVisibility(0);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
_L2:
label0:
            {
                if (mArrayListData.size() >= 15)
                {
                    break label0;
                }
                grup_footer.setVisibility(8);
            }
              goto _L4
            grup_footer.setVisibility(0);
              goto _L4
_L3:
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
            ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            s = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            s1 = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            s2 = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            my_like_kom = ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            if (!((ItemKomenHp)mArrayListData.get(i)).getReply_to().toString().trim().equals("0")) goto _L6; else goto _L5
_L5:
            lay_quote.setVisibility(8);
_L8:
            if (!((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1459;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L9:
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtNamaHp.setText(((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1);
            img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

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
            img_kom_picture.setOnClickListener(s1. new android.view.View.OnClickListener() {

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
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarOldAsycTask this$1;
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
                this$1 = final_komentaroldasyctask;
                id_hp = s;
                my_like_kom = s1;
                codename = String.this;
                super();
            }
            });
            i++;
              goto _L7
_L6:
            lay_quote.setVisibility(0);
              goto _L8
            img_kom_picture.setImageResource(0x7f020297);
              goto _L9
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
            this$0 = KomentarBaruLainPonsel.this;
            super();
        }
    }


    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    Button btnRefresh;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    int counterLoad;
    Cursor cursor;
    String dataNotifOnOff;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray inponsel;
    JSONArray jArray;
    String jumSC;
    String jum_komen;
    String kmail_stat;
    String komencount;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    LinearLayout layout_footerNext;
    LinearLayout layout_header;
    int limit;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    private LinearLayout mLinearListView;
    String messageNotif;
    String nama_asli;
    private DisplayImageOptions options;
    String passlam;
    PonselBaseApp ponselBaseApp;
    ProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    String postMessage;
    String postMessageLikeKom;
    String postStatus;
    String postStatusLikeKom;
    SmoothProgressBar progbar_notifHP;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    ScrollView scrollviewKomen;
    String sortkom;
    String statuslike;
    String strJsonRssRep;
    String strKonekStat;
    String str_id_user;
    String suc;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtIdKom;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtNamaHp;
    TextView txtTanggapan;
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
    String username;
    ContextThemeWrapper wrapperLight;

    public KomentarBaruLainPonsel()
    {
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
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        counterLoad = 1;
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
        top_id = "";
        bottom_id = "";
        limit = 0;
        komencount = "";
        sortkom = "12";
        querypopkomen = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        str_id_user = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
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

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300ce);
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
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        extras = getIntent().getExtras();
        str_id_user = extras.getString("str_id_user");
        Log.e("str_id_user", str_id_user);
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Interaksi di perangkat");
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
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode("Interaksi di perangkat")).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(URLDecoder.decode("Interaksi di perangkat"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        progbar_notifHP = (SmoothProgressBar)findViewById(0x7f0b04cb);
        progbar_notifHP.setVisibility(8);
        mArrayListData = new ArrayList();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        txtbtnheader = (TextView)findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        layout_header = (LinearLayout)findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)findViewById(0x7f0b04d3);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)findViewById(0x7f0b052d);
        pop_progressbar_middle = (ProgressBar)findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        scrollviewKomen.setVisibility(8);
        btnRefresh = (Button)findViewById(0x7f0b04d0);
        if (userFunctions.isUserLoggedIn(this))
        {
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
            pop_txtCountKomen.setVisibility(8);
        }
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        layout_empty.setVisibility(0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0014, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 34
    //                   2131429682: 51;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        continue; /* Loop/switch isn't completed */
_L3:
        startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void update(Observable observable, Object obj)
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
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && !userFunctions.isUserLoggedIn(this))
        {
            pop_txtCountKomen.setVisibility(8);
        }
    }





}
