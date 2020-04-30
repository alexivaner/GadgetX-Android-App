// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.animation.Animator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.ClickSpan;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.BaseDrawer;
import com.inponsel.android.v2.DaftarPonselMerkActivity;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RSSFeedByTag;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.RoomChatActivity;
import com.inponsel.android.v2.SCUserActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
//            DetailsPonsel, RivalTerdekatActivity, GalleriFotoHp, ProfilPTActivity, 
//            SCTerdekatActivity, TwitterInPonsel, PilihPonselBanding

public class Hal1Ikhtisar extends SherlockFragment
    implements Observer
{
    public class FavoritTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                query = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favhp").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                res = avoid.toString();
                Log.e("url ", res);
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
            ponselBaseApp.getObserver().setUpdateType("sidemenufav");
            ponselBaseApp.getObserver().setLoginStat("1");
            if (res.equals("1") || res.equals("10"))
            {
                try
                {
                    db.addHP(id_hp, URLDecoder.decode(merk, "utf-8"), URLDecoder.decode(model, "utf-8"), gambar, codename);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
                if (db.getHPCount() > 0)
                {
                    Toast.makeText(getActivity(), "Berhasil menambahkan", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favorite.setBackground(drwKurang);
                    }
                } else
                {
                    Toast.makeText(getActivity(), "Gagal menambahkan", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drw);
                    } else
                    {
                        detail_favorite.setBackground(drw);
                    }
                }
                mDialog.dismiss();
                return;
            }
            if (res.equals("00") || res.equals("0"))
            {
                db.deleteHP(id_hp);
                if (!db.checkIfExist(id_hp))
                {
                    Toast.makeText(getActivity(), "Berhasil menghapus", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drw);
                    } else
                    {
                        detail_favorite.setBackground(drw);
                    }
                } else
                {
                    Toast.makeText(getActivity(), "Gagal menghapus", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favorite.setBackground(drwKurang);
                    }
                }
                mDialog.dismiss();
                return;
            }
            if (res.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(getActivity(), "Gagal menambahkan", 1).show();
            if (sdk < 16)
            {
                detail_favorite.setBackgroundDrawable(drw);
                return;
            } else
            {
                detail_favorite.setBackground(drw);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (stat.equals("1"))
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    public class GetMyNilai extends AsyncTask
    {

        JSONArray jArray;
        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            int i;
            int j;
            j = as.length;
            i = 0;
_L3:
            if (i >= j)
            {
                return null;
            }
            Object obj = new RestClient(as[i]);
            ((RestClient) (obj)).Execute(com.inponsel.android.utils.RestClient.RequestMethod.GET);
_L1:
            Exception exception1;
            try
            {
                obj = ((RestClient) (obj)).getResponse();
                getJson = ((String) (obj));
                parseJSON(((String) (obj)));
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_65;
            exception1;
            exception1.printStackTrace();
              goto _L1
            i++;
            if (true) goto _L3; else goto _L2
_L2:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            try
            {
                btnDesainRate.setText(nilbtnDesain);
                btnLayarRate.setText(nilbtnLayar);
                btnKinerjaRate.setText(nilbtnKinerja);
                btnKameraRate.setText(nilbtnKamera);
                btnBateraiRate.setText(nilbtnBaterai);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        void parseJSON(String s)
        {
            int i;
            try
            {
                jArray = (new JSONObject(s)).getJSONArray("InPonsel");
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
            nilbtnDesain = s.getString("rating_hp_desain");
            nilbtnLayar = s.getString("rating_hp_layar");
            nilbtnKinerja = s.getString("rating_hp_kinerja");
            nilbtnKamera = s.getString("rating_hp_kamera");
            nilbtnBaterai = s.getString("rating_hp_baterai");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_19;
            }
        }

        public GetMyNilai()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    private class IkhtisarTask extends AsyncTask
    {

        Response response;
        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataIktisar);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataIktisar).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
            Log.e("success", (new JSONObject(response.toString())).getString("0"));
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            scrollIkhtisar.setVisibility(0);
            void1 = response.InPonsel.iterator();
_L25:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            txtBigRoom.setText((new StringBuilder("Forum ")).append(namalengkap).toString());
            namalengkapbgskrg = namalengkap;
            txtBigBerita.setText((new StringBuilder("Berita ")).append(namalengkap).toString());
            txtBigHpLain.setText((new StringBuilder("Ponsel ")).append(merk).append(" lainnya").toString());
            if (!statSubNews.equals("1")) goto _L4; else goto _L3
_L3:
            if (sdk >= 16) goto _L6; else goto _L5
_L5:
            detail_favoritenews.setBackgroundDrawable(drwKurang);
_L27:
            if (!statusKomen.equals("1")) goto _L8; else goto _L7
_L7:
            chkNotifKomenHp.setChecked(true);
_L28:
            Log.e("total_likepersen", (new StringBuilder(String.valueOf(total_votes))).append("=").append(likepersen).toString());
            if (!total_votes.equals("") && !total_votes.equals("0") || !likepersen.equals("0")) goto _L10; else goto _L9
_L9:
            lay_ringkasan.setVisibility(8);
            txtNotPengunjung.setVisibility(0);
_L29:
            if (!total_votes.equals("0")) goto _L12; else goto _L11
_L11:
            lay_ReviewFitur.setVisibility(8);
            txtValueReviewFitur.setText(Html.fromHtml("<b>Belum ada review pengunjung</b>"));
            Log.e("nilai_overall", (new StringBuilder(String.valueOf(String.valueOf(Math.round(Float.parseFloat(nilai_overall)))))).append(" : ").append(String.valueOf(10 - Math.round(Float.parseFloat(nilai_overall)))).toString());
            ratingReviewFitur.setProgress(0);
_L30:
            if (!likepersen.equals("")) goto _L14; else goto _L13
_L13:
            lay_Ketertarikan.setVisibility(8);
_L31:
            if (!twitter.equals("")) goto _L16; else goto _L15
_L15:
            layout_Twitter.setEnabled(false);
            txtBigTwitter.setTextColor(Color.parseColor("#cacaca"));
_L32:
            if (!my_like_pon.equals("1")) goto _L18; else goto _L17
_L17:
            detail_like.setBackgroundResource(0x7f020259);
            detail_dislike.setBackgroundResource(0x7f0201a6);
            detail_lay_like.setEnabled(false);
            detail_lay_dislike.setEnabled(true);
_L33:
            Log.e("likedis", (new StringBuilder(String.valueOf(tnggp_bgs))).append(":").append(tnggp_krg).toString());
            if (!tnggp_bgs.toString().equals("0") || !tnggp_krg.toString().equals("0")) goto _L20; else goto _L19
_L19:
            ratingLikeDis.setProgress(50);
            Log.e("likedis", "50");
_L34:
            if (!userFunction.isUserLoggedIn(getActivity())) goto _L22; else goto _L21
_L21:
            sclabel = (new StringBuilder("Service center ")).append(merk).append(" di ").append(user_kota).toString();
_L35:
            Picasso.with(getActivity()).load(gambar.trim()).into(imgHpDetail, new Callback() {

                final IkhtisarTask this$1;

                public void onError()
                {
                    det_prog_item.setVisibility(8);
                }

                public void onSuccess()
                {
                    det_prog_item.setVisibility(8);
                    imgHpDetail.setVisibility(0);
                }

            
            {
                this$1 = IkhtisarTask.this;
                super();
            }
            });
_L36:
            Log.e("total_hitsikh", total_hits);
            detail_text_like.setText(tnggp_bgs);
            detail_text_dislike.setText(tnggp_krg);
            detail_text_komentar.setText(jml_komentar);
            if (ikhtisarArray.size() != 0) goto _L24; else goto _L23
_L23:
            txt_empty.setText("Gagal terhubung ke server");
            progressbar_middle.setVisibility(8);
_L26:
            (new Handler()).postDelayed(new Runnable() {

                final IkhtisarTask this$1;

                public void run()
                {
                    (new PostHits()).execute(new Void[0]);
                }

            
            {
                this$1 = IkhtisarTask.this;
                super();
            }
            }, 5000L);
            return;
_L2:
            ListModel listmodel = (ListModel)void1.next();
            id_hp = listmodel.getId_hp();
            gambar = listmodel.getGambar();
            model = listmodel.getModel();
            codename = listmodel.getCodename();
            merk = listmodel.getMerk();
            id_merk = listmodel.getId_merk();
            namalengkap = listmodel.getNamalengkap();
            jml_komentar = listmodel.getJml_komentar();
            tnggp_bgs = listmodel.getTnggp_bgs().toString();
            tnggp_krg = listmodel.getTnggp_krg().toString();
            likepersen = listmodel.getLikepersen().toString();
            nilai_overall = listmodel.getNilai_overall();
            total_votes = listmodel.getTotal_votes();
            total_hits = listmodel.getTotal_hits().toString();
            str_urlspekshare = listmodel.getUrl_share().toString();
            lay_size_diagonal = listmodel.getLay_size_diagonal();
            umu_status = listmodel.getUmu_status();
            hrg_baru = listmodel.getHrg_baru();
            hrg_bekas = listmodel.getHrg_bekas();
            har_infotmbh = listmodel.getInfo_tambahan();
            sta_garansi = listmodel.getSta_garansi();
            update_harga = listmodel.getUpdate_harga();
            my_like_pon = listmodel.getMy_like_pon();
            twitter = listmodel.getTwitter();
            statusKomen = listmodel.getStatuskomen();
            statSubNews = listmodel.getSubs_status();
            ikhtisarArray.add(listmodel);
              goto _L25
            void1;
            void1.printStackTrace();
            layout_empty.setVisibility(0);
            progressbar_middle.setVisibility(8);
            txt_empty.setVisibility(8);
            btnRefresh.setVisibility(0);
              goto _L26
_L6:
            detail_favoritenews.setBackground(drwKurang);
              goto _L27
_L4:
label0:
            {
                if (sdk >= 16)
                {
                    break label0;
                }
                detail_favoritenews.setBackgroundDrawable(drw);
            }
              goto _L27
            detail_favoritenews.setBackground(drw);
              goto _L27
_L8:
            chkNotifKomenHp.setChecked(false);
              goto _L28
_L10:
            lay_ringkasan.setVisibility(0);
            txtNotPengunjung.setVisibility(8);
              goto _L29
_L12:
            txtValueReviewFitur.setText(Html.fromHtml((new StringBuilder("<b>Review pengunjung</b> ")).append(nilai_overall).append(" (").append(total_votes).append(" suara)").toString()));
            Log.e("nilai_overall", (new StringBuilder(String.valueOf(String.valueOf(Math.round(Float.parseFloat(nilai_overall)))))).append(" : ").append(String.valueOf(10 - Math.round(Float.parseFloat(nilai_overall)))).toString());
            ratingReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
              goto _L30
_L14:
            txtKetertarikan.setText(Html.fromHtml((new StringBuilder("<b>Ketertarikan   </b>")).append(likepersen).append("% (").append(tnggp_bgs).append(" likes, ").append(tnggp_krg).append(" dislikes)").toString()));
            txtValueKetertarikan.setText(Html.fromHtml((new StringBuilder("<b>Ketertarikan</b> ")).append(likepersen).append("% (").append(tnggp_bgs).append(" likes, ").append(tnggp_krg).append(" dislikes)").toString()));
              goto _L31
_L16:
            txtBigTwitter.setText((new StringBuilder("Twitter ")).append(twitter).toString());
              goto _L32
_L18:
label1:
            {
                if (!my_like_pon.equals("0"))
                {
                    break label1;
                }
                detail_like.setBackgroundResource(0x7f02025a);
                detail_dislike.setBackgroundResource(0x7f0201a5);
                detail_lay_like.setEnabled(true);
                detail_lay_dislike.setEnabled(false);
            }
              goto _L33
            detail_like.setBackgroundResource(0x7f02025a);
            detail_dislike.setBackgroundResource(0x7f0201a6);
            detail_lay_like.setEnabled(true);
            detail_lay_dislike.setEnabled(true);
              goto _L33
_L20:
            float f = Integer.parseInt(tnggp_bgs);
            f /= f + (float)Integer.parseInt(tnggp_krg);
            Log.e("likedis", String.valueOf(f));
            ratintLikeDis = Math.round(100F * f);
            ratingLikeDis.setProgress(ratintLikeDis);
              goto _L34
_L22:
            sclabel = (new StringBuilder("Service center ")).append(merk).append(" di Kota anda").toString();
              goto _L35
            void1;
            void1.printStackTrace();
              goto _L36
_L24:
            layout_empty.setVisibility(8);
            try
            {
                void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(update_harga);
                SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMMM yyyy", Locale.US);
                newDateStr = simpledateformat.format(void1);
                newDateStr = newDateStr.replace("January", "Januari");
                newDateStr = newDateStr.replace("February", "Februari");
                newDateStr = newDateStr.replace("March", "Maret");
                newDateStr = newDateStr.replace("April", "April");
                newDateStr = newDateStr.replace("May", "Mei");
                newDateStr = newDateStr.replace("June", "Juni");
                newDateStr = newDateStr.replace("July", "Juli");
                newDateStr = newDateStr.replace("August", "Agustus");
                newDateStr = newDateStr.replace("September", "September");
                newDateStr = newDateStr.replace("October", "Oktober");
                newDateStr = newDateStr.replace("November", "November");
                newDateStr = newDateStr.replace("December", "Desember");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            if (!umu_status.equals("Dihentikan") || !hrg_bekas.equals("") && hrg_bekas != null) goto _L38; else goto _L37
_L37:
            spek_head_Garansi.setVisibility(8);
_L39:
            detail_txtMerek.setText(namalengkap);
            edtHargaBaru.setText((new StringBuilder()).append(hrg_baru).toString());
            edtHargaBekas.setText((new StringBuilder()).append(hrg_bekas).toString());
            merk = URLEncoder.encode(merk, "utf-8");
_L40:
            dataLain = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_lain").append(Utility.BASE_FORMAT).append("?merk=").append(merk).append("&idmodel=").append(id_hp).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("dataLain", dataLain);
            InAdsTask();
            userFunction.isUserLoggedIn(getActivity());
            if (!hrg_baru.equals("0") && !hrg_baru.equals("-") && !hrg_baru.equals(""))
            {
                break MISSING_BLOCK_LABEL_3177;
            }
            layout_RivalTerdekat.setEnabled(false);
            txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
              goto _L26
_L38:
label2:
            {
                if (!update_harga.equals("") && !update_harga.equals("null") && !update_harga.equals("-") && !update_harga.equals("0000-00-00"))
                {
                    break label2;
                }
                edtHargaGaransi.setText("");
                edtHargaGaransi.setVisibility(8);
            }
              goto _L39
label3:
            {
                if (!sta_garansi.equals("NA") && !sta_garansi.equals("null") && !sta_garansi.equals("-") || update_harga.equals("null") && update_harga.equals("") && update_harga.equals("-"))
                {
                    break label3;
                }
                edtHargaGaransi.setText((new StringBuilder("Diperbarui ")).append(newDateStr).toString());
            }
              goto _L39
label4:
            {
                if (sta_garansi.equals("0") && sta_garansi.equals("null") && sta_garansi.equals("-") || !har_infotmbh.equals(""))
                {
                    break label4;
                }
                edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append("; Diperbarui ").append(newDateStr).toString());
            }
              goto _L39
label5:
            {
                if (sta_garansi.equals("0") && sta_garansi.equals("null") && sta_garansi.equals("-") || har_infotmbh.equals(""))
                {
                    break label5;
                }
                edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append(" (").append(har_infotmbh).append("); Diperbarui ").append(newDateStr).toString());
            }
              goto _L39
            edtHargaGaransi.setText("");
            edtHargaGaransi.setVisibility(8);
              goto _L39
            void1;
            void1.printStackTrace();
              goto _L40
            disAtas = Float.parseFloat(lay_size_diagonal);
            void1 = Hal1Ikhtisar.this;
            void1.disAtas = ((Hal1Ikhtisar) (void1)).disAtas + 0.20000000000000001D;
            disBawah = Float.parseFloat(lay_size_diagonal);
            void1 = Hal1Ikhtisar.this;
            void1.disBawah = ((Hal1Ikhtisar) (void1)).disBawah - 0.20000000000000001D;
            model = URLEncoder.encode(model, "utf-8");
_L41:
            dataRival = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_rival").append(Utility.BASE_FORMAT).append("?hmin=").append(hargaBawah).append("&hmax=").append(hargaAtas).append("&lmin=").append(disBawah).append("&lmax=").append(disAtas).append("&idhp=").append(id_hp).append("&limit=").append("0").append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("urlRival", dataRival);
            if (!umu_status.equals("3") && !umu_status.equals("Dihentikan") && !edtHargaBaru.getText().toString().equals(""))
            {
                break MISSING_BLOCK_LABEL_3569;
            }
            layout_RivalTerdekat.setVisibility(0);
            layout_RivalTerdekat.setEnabled(false);
            txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
            Log.e("RivalTask", "0");
_L42:
            layout_RivalTerdekat.setOnClickListener(new android.view.View.OnClickListener() {

                final IkhtisarTask this$1;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/details/RivalTerdekatActivity);
                    view.putExtra("codename", codename);
                    view.putExtra("model", model);
                    view.putExtra("merk", merk);
                    view.putExtra("gambar", gambar);
                    view.putExtra("hrg_baru", hrg_baru);
                    view.putExtra("hrg_bekas", hrg_bekas);
                    view.putExtra("jsonRival", jsonRival);
                    view.putExtra("id_hp", id_hp);
                    getActivity().startActivity(view);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = IkhtisarTask.this;
                super();
            }
            });
              goto _L26
            void1;
            void1.printStackTrace();
              goto _L41
            Log.e("RivalTask", "1");
            (new RivalTask()).execute(new Void[0]);
              goto _L42
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            layout_empty.setVisibility(0);
            scrollIkhtisar.setVisibility(8);
        }


        private IkhtisarTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }

        IkhtisarTask(IkhtisarTask ikhtisartask)
        {
            this();
        }
    }

    private class InAdsTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataInAds, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_332;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    sucads = avoid.getString("success");
                    Log.e("sucadsNative", sucads);
                    inponsel = avoid.getJSONArray("InPonsel");
                    if (!sucads.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_339;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_339;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_339;
            }
            avoid = inponsel.getJSONObject(i);
            id_ads = avoid.getString("id_ads");
            id_user = avoid.getString("id_user");
            publisher_name = avoid.getString("publisher_name");
            title_ads = avoid.getString("ads_title");
            campaign = avoid.getString("ads_campaign");
            no_ads = avoid.getString("ads_no");
            logo_pub = avoid.getString("logo_pub");
            image_ads = (new StringBuilder(String.valueOf(Util.BASE_PATH_IKADV))).append(avoid.getString("ads_image")).toString();
            link_ads = avoid.getString("ads_link");
            ads_method = avoid.getString("ads_method");
            ads_start = avoid.getString("ads_start");
            ads_finish = avoid.getString("ads_finish");
            ads_status = avoid.getString("ads_status");
            ad_type = avoid.getString("ads_type");
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            Log.e("ServiceHandler", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (sucads.equals("1"))
            {
                Log.e("title_ads", title_ads);
                if (ad_type.equals("1"))
                {
                    inadView = inflaterInAd.inflate(0x7f03002b, ll_inad_native);
                } else
                if (ad_type.equals("2"))
                {
                    inadView = inflaterInAd.inflate(0x7f030041, ll_inad_native);
                } else
                if (ad_type.equals("3"))
                {
                    inadView = inflaterInAd.inflate(0x7f03002f, ll_inad_native);
                } else
                if (ad_type.equals("4"))
                {
                    inadView = inflaterInAd.inflate(0x7f030030, ll_inad_native);
                } else
                if (ad_type.equals("5"))
                {
                    inadView = inflaterInAd.inflate(0x7f030032, ll_inad_native);
                } else
                {
                    inadView = inflaterInAd.inflate(0x7f030033, ll_inad_native);
                }
                showIn_AD(inadView);
            }
            Log.e("image_ads", image_ads.replaceAll(" ", ""));
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private InAdsTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }

        InAdsTask(InAdsTask inadstask)
        {
            this();
        }
    }

    public class ListSCAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        String no_telp_array[];
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final Hal1Ikhtisar this$0;
        String user;
        UserFunctions userFunctions;
        String username;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtAlamat = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
                ((ViewHolder) (viewgroup)).list_txtAlamat.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
                ((ViewHolder) (viewgroup)).list_txtAlamat.setSelected(true);
                no_telp_array = lms.getSc_no_telp().trim().split(",");
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCAdapter this$1;

                    public void onClick(View view)
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setTitle("Nomor Telepon :");
                        view.setSingleChoiceItems(no_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final ListSCAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = ListSCAdapter._cls1.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = ListSCAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCAdapter.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListSCAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal1Ikhtisar.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Hal1Ikhtisar hal1ikhtisar)
            {
                return;
            }
        }
    }

    class ListSCAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        TextView list_txtAlamat;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListSCAdapter this$1;

        ListSCAdapter.ViewHolder()
        {
            this$1 = ListSCAdapter.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusLikePon = jsonobject.getString("success");
                postMessageLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePon = s.getString("total_kom");
            tot_LikePon = s.getString("total_like");
            totdis_LikePon = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePon);
            Log.e("tot_LikePon", tot_LikePon);
            Log.e("totdis_LikePon", totdis_LikePon);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePon);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusLikePon);
            if (!postStatusLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_107;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHp.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHp.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    public class PostHits extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (android.os.Build.VERSION.SDK_INT > 9)
            {
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
            }
            avoid = "-";
            if (!userFunction.isUserLoggedIn(getActivity())) goto _L2; else goto _L1
_L1:
            Object obj = email_user;
_L4:
            avoid = URLEncoder.encode(namalengkap, "utf-8");
            avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(((String) (obj))).append("&hits=1&namalengkap=").append(avoid).append("&t=").append(t).toString();
            HttpPush.getResponse((new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("hits_hp").append(Utility.BASE_FORMAT).append("?").append(avoid).toString()).toString().trim().replaceAll("\\s+", "");
            break MISSING_BLOCK_LABEL_246;
_L2:
            Account aaccount[];
            int j;
            aaccount = AccountManager.get(getActivity()).getAccounts();
            j = aaccount.length;
            int i = 0;
_L5:
            obj = avoid;
            if (i >= j) goto _L4; else goto _L3
_L3:
            obj = aaccount[i];
            if (((Account) (obj)).name.endsWith("gmail.com"))
            {
                avoid = ((Account) (obj)).name;
            }
            i++;
              goto _L5
            avoid;
            avoid.printStackTrace();
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

        public PostHits()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    public class PostNilaiTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (android.os.Build.VERSION.SDK_INT > 9)
            {
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
            }
            namalengkap = URLEncoder.encode(namalengkap, "utf-8");
_L2:
            avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(username).append("&namalengkap=").append(namalengkap).append("&").append("desain=").append(nilbtnDesain).append("&layar=").append(nilbtnLayar).append("&kinerja=").append(nilbtnKinerja).append("&apps=").append("0").append("&kamera=").append(nilbtnKamera).append("&audio=").append("0").append("&baterai=").append(nilbtnBaterai).append("&harga=").append("0").append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ratingnilaihp").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            res = res.trim();
            res = res.replaceAll("\\s+", "");
            break MISSING_BLOCK_LABEL_334;
            avoid;
            avoid.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
            avoid;
            avoid.printStackTrace();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            try
            {
                if (res.equals("1"))
                {
                    Toast.makeText(getActivity(), 0x7f0c0061, 1).show();
                    notificationLikeHelper.completed(namalengkapbgskrg, getString(0x7f0c0061));
                    RatingAVGTask();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (res.equals("4"))
            {
                notificationLikeHelper.completed(namalengkapbgskrg, getString(0x7f0c0061));
                RatingAVGTask();
                return;
            }
            if (res.equals("3"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
                return;
            }
            if (res.equals("1209"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, "Anda telah memberikan nilai sama sebelumnya");
                return;
            }
            if (res.equals("K404"))
            {
                break MISSING_BLOCK_LABEL_274;
            }
            if (res.equals("U404"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, "Username anda tidak terdaftar");
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.nilaiStatement);
        }

        public PostNilaiTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    private class RatingAVGTask extends AsyncTask
    {

        Response response;
        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataRatingAVG);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataRatingAVG).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            void1 = response.InPonsel.iterator();
_L1:
            if (!void1.hasNext())
            {
                rata2Desain = nilai_desain;
                rata2Layar = nilai_layar;
                rata2Kinerja = nilai_kinerja;
                rata2Kamera = nilai_kamera;
                rata2Baterai = nilai_baterai;
                rataDesain.setText(oneDForm.format(Double.parseDouble(nilai_desain)));
                rataLayar.setText(oneDForm.format(Double.parseDouble(nilai_layar)));
                rataKinerja.setText(oneDForm.format(Double.parseDouble(nilai_kinerja)));
                rataKamera.setText(oneDForm.format(Double.parseDouble(nilai_kamera)));
                rataBaterai.setText(oneDForm.format(Double.parseDouble(nilai_baterai)));
                ratdobDesain = Double.parseDouble(rata2Desain) * 10D;
                ratintDesain = (int)ratdobDesain;
                ratdobLayar = Double.parseDouble(rata2Layar) * 10D;
                ratintLayar = (int)ratdobLayar;
                ratdobKinerja = Double.parseDouble(rata2Kinerja) * 10D;
                ratintKinerja = (int)ratdobKinerja;
                ratdobApps = Double.parseDouble(rata2Apps) * 10D;
                ratintApps = (int)ratdobApps;
                ratdobKamera = Double.parseDouble(rata2Kamera) * 10D;
                ratintKamera = (int)ratdobKamera;
                ratdobAudio = Double.parseDouble(rata2Audio) * 10D;
                ratintAudio = (int)ratdobAudio;
                ratdobBaterai = Double.parseDouble(rata2Baterai) * 10D;
                ratintBaterai = (int)ratdobBaterai;
                ratdobHarga = Double.parseDouble(rata2Harga) * 10D;
                ratintHarga = (int)ratdobHarga;
                ratingDesain.setAnimation(animationin);
                if (ratintDesain < 67)
                {
                    if (ratintDesain >= 34);
                }
                ratingDesain.setProgress(ratintDesain);
                ratingLayar.setAnimation(animationin);
                if (ratintLayar < 67)
                {
                    if (ratintLayar >= 34);
                }
                ratingLayar.setProgress(ratintLayar);
                ratingKinerja.setAnimation(animationin);
                if (ratintKinerja < 67)
                {
                    if (ratintKinerja >= 34);
                }
                ratingKinerja.setProgress(ratintKinerja);
                ratingKamera.setAnimation(animationin);
                if (ratintKamera < 67)
                {
                    if (ratintKamera >= 34);
                }
                ratingKamera.setProgress(ratintKamera);
                ratingBaterai.setAnimation(animationin);
                if (ratintBaterai < 67)
                {
                    if (ratintBaterai >= 34);
                }
                ratingBaterai.setProgress(ratintBaterai);
                totalVotes.isSelected();
                Log.e("total_votes", total_votes);
                if (total_votes.equals("0"))
                {
                    txtValueReviewFitur.setText(Html.fromHtml("<b>Belum ada review pengunjung</b>"));
                    ratingReviewFitur.setProgress(0);
                    return;
                }
                break MISSING_BLOCK_LABEL_987;
            }
            try
            {
                ListModel listmodel = (ListModel)void1.next();
                nilai_desain = listmodel.getNilai_desain();
                nilai_layar = listmodel.getNilai_layar();
                nilai_kinerja = listmodel.getNilai_kinerja();
                nilai_kamera = listmodel.getNilai_kamera();
                nilai_baterai = listmodel.getNilai_baterai();
                nilai_overall = listmodel.getNilai_overall();
                total_votes = listmodel.getTotal_votes();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L1
            txtValueReviewFitur.setText(Html.fromHtml((new StringBuilder("<b>Review pengunjung</b> ")).append(nilai_overall).append(" (").append(total_votes).append(" suara)").toString()));
            Log.e("nilai_overall", (new StringBuilder(String.valueOf(nilai_overall))).append(" : ").append(String.valueOf(10F - Float.parseFloat(nilai_overall))).toString());
            ratingReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private RatingAVGTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }

        RatingAVGTask(RatingAVGTask ratingavgtask)
        {
            this();
        }
    }

    public class RivalTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataRival, 1);
            jsonRival = avoid;
            Log.e("ResponseRival: ", (new StringBuilder("> ")).append(jsonRival).toString());
            if (avoid != null)
            {
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
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
            try
            {
                if (suc.equals("1"))
                {
                    layout_RivalTerdekat.setEnabled(true);
                    txtBigRivalTerdekat.setTextColor(Color.parseColor("#616161"));
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            layout_RivalTerdekat.setEnabled(false);
            txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public RivalTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
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
                query = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                res = avoid.toString();
                Log.e("url ", res);
                parseJSONSubsNews(res);
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
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
            if (sdk < 16)
            {
                detail_favorite.setBackgroundDrawable(drw);
                return;
            } else
            {
                detail_favorite.setBackground(drw);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final Hal1Ikhtisar this$0;

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
            chkNotifKomenHp.setEnabled(true);
            if (kmail_stat.equals("1"))
            {
                chkNotifKomenHp.setChecked(true);
                return;
            } else
            {
                chkNotifKomenHp.setChecked(false);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progbar_notifHP.setVisibility(0);
            chkNotifKomenHp.setEnabled(false);
        }

        public TurnOnOffNotifTask()
        {
            this$0 = Hal1Ikhtisar.this;
            super();
        }
    }


    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    public static String komencount = "";
    double DratdobApps;
    double DratdobAudio;
    double DratdobBaterai;
    double DratdobDesain;
    double DratdobHarga;
    double DratdobKamera;
    double DratdobKinerja;
    double DratdobLayar;
    double DratdobLikeDis;
    Account accounts[];
    String ad_type;
    Bitmap adsBitmap;
    String ads_finish;
    String ads_method;
    String ads_start;
    String ads_status;
    Animation animation;
    Animation animationin;
    Animation animationout;
    String bat_bicara;
    String bat_kapasitas;
    String bat_kapasitas_s;
    String bat_model;
    String bat_musik;
    String bat_siaga;
    Button btnBateraiRate;
    Button btnCancel;
    Button btnDesainRate;
    Button btnKameraRate;
    Button btnKinerjaRate;
    Button btnKirimNilai;
    Button btnLayarRate;
    Button btnLoadMore;
    Button btnLoadMoreNext;
    Button btnRefresh;
    Button btnSubmit;
    Button btn_pop_komen;
    Button btn_pop_login;
    CallbackManager callbackManager;
    String campaign;
    int charCount;
    CheckBox chkNotifKomenHp;
    ConnectivityManager cm;
    String codename;
    String codenameKomen;
    Context context;
    int countAllKom;
    int countKomOld;
    Cursor cursor;
    String dataIktisar;
    String dataInAds;
    String dataKomen;
    String dataLain;
    String dataNilai;
    String dataNotifOnOff;
    String dataRatingAVG;
    String dataRival;
    String dataSCKota;
    DatabaseHandler db;
    int decimalPlace;
    ProgressBar det_prog_item;
    ImageView detail_dislike;
    ImageView detail_favorite;
    ImageView detail_favoritenews;
    RelativeLayout detail_lay_dislike;
    RelativeLayout detail_lay_kom;
    RelativeLayout detail_lay_like;
    ImageView detail_like;
    TextView detail_text_dislike;
    TextView detail_text_komentar;
    TextView detail_text_like;
    TextView detail_txtHarga;
    TextView detail_txtMerek;
    String details;
    double disAtas;
    double disBawah;
    Drawable drw;
    Drawable drwKurang;
    EditText edtComment;
    EditText edtHargaBaru;
    EditText edtHargaBekas;
    EditText edtHargaGaransi;
    EditText edtHargaInfoTamb;
    EditText edtUser;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    String email_user;
    Bundle extras;
    String fit_browser;
    String fit_browser_status;
    String fit_gps;
    String fit_gps_status;
    String fit_lain;
    String fit_musik;
    String fit_musik_status;
    String fit_pesan;
    String fit_radio;
    String fit_radio_status;
    String fit_tvanalog;
    String fit_tvanalog_ket;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    LinearLayout footerView;
    String gambar;
    String getJson;
    String getJsonLain;
    String har_chipset;
    String har_cpu_clock;
    String har_cpu_core;
    String har_cpu_jenpros;
    String har_gpu;
    String har_info;
    String har_infotmbh;
    int hargaAtas;
    int hargaBaru;
    int hargaBawah;
    int hargaBekas;
    int hasilQ;
    LinearLayout headPonsel;
    LinearLayout headerView;
    String host;
    LinearLayout hpLain;
    String hrg_baru;
    String hrg_bekas;
    String hrg_garansi;
    String id_ads;
    String id_hp;
    String id_hp_lain;
    String id_hpkom;
    String id_kom;
    String id_merk;
    String id_user;
    public ArrayList ikhtisarArray;
    String image_ads;
    ImageView imgHpDetail;
    protected View inadView;
    String indexhp;
    LayoutInflater inflaterInAd;
    JSONArray inponsel;
    String internal;
    String isikomentar;
    JSONArray jArray;
    String jar_2g_cdma;
    String jar_2g_cdma_status;
    String jar_2g_gsm;
    String jar_2g_gsm_status;
    String jar_2g_status;
    String jar_3g;
    String jar_3g_status;
    String jar_4g;
    String jar_4g_status;
    String jar_bwidth;
    String jar_dualon;
    String jar_edge;
    String jar_edge_status;
    String jar_gprs;
    String jar_gprs_status;
    String jar_multi_status;
    String jar_multi_tipe1;
    String jar_multi_tipe2;
    String jar_sc;
    int jml;
    String jml_komentar;
    int jmlgal;
    String jsonRival;
    String jumSC;
    String jum_komenLikePon;
    String kam_depan;
    String kam_depan_status;
    String kam_fitur;
    String kam_led_flash;
    String kam_led_flash_status;
    String kam_nat_vcall;
    String kam_utama;
    String kam_utama2;
    String kam_utama_status;
    String kam_video;
    String kam_video_hd;
    String kam_video_status;
    String ketamb;
    String kmail_stat;
    String komen;
    String kon_35mm_jack;
    String kon_bluetooth;
    String kon_bluetooth_status;
    String kon_hdmi;
    String kon_hdmi_status;
    String kon_infrared;
    String kon_nfc;
    String kon_nfc_status;
    String kon_tvoutput;
    String kon_tvoutput_status;
    String kon_usb;
    String kon_usb_status;
    String kon_wlan;
    String kon_wlan_status;
    String lastid;
    LinearLayout lay_Ketertarikan;
    LinearLayout lay_ReviewFitur;
    String lay_multitouch;
    String lay_multitouch_status;
    LinearLayout lay_pop_komen;
    String lay_proteksi;
    String lay_proteksi_status;
    LinearLayout lay_ringkasan;
    String lay_sensor;
    String lay_sensor_status;
    String lay_size_diagonal;
    String lay_size_horizontal;
    String lay_size_ppi;
    String lay_size_status;
    String lay_size_vertikal;
    String lay_tipe_layar;
    String lay_touchscreen;
    String lay_touchscreen_status;
    String lay_warna_layar;
    LayoutInflater layoutInflater;
    LinearLayout layout_Bandingkan;
    LinearLayout layout_Berita;
    LinearLayout layout_ChatRoom;
    LinearLayout layout_Forum;
    LinearLayout layout_GalleriFoto;
    LinearLayout layout_HpLain;
    LinearLayout layout_KomentarHp;
    LinearLayout layout_RivalTerdekat;
    LinearLayout layout_Room;
    LinearLayout layout_SCTerdekat;
    LinearLayout layout_Twitter;
    LinearLayout layout_VendorProf;
    LinearLayout layout_empty;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    LinearLayout layout_sc_kota;
    String likepersen;
    int limit;
    LinearLayout lineColor;
    String link_ads;
    ListView listKomen;
    protected LinearLayout ll_inad_native;
    SharedPreferences loginPreference;
    String logo_pub;
    private float mActionBarHeight;
    int mCurCheckPosition;
    ProgressDialog mDialog;
    String mem_eksternal;
    String mem_eksternal_kap;
    String mem_eksternal_s;
    String mem_internal;
    String mem_phonebook;
    String mem_ram;
    String mem_rom;
    String merk;
    String messageNotif;
    String model;
    String my_like_pon;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    int newBmapHeight;
    int newBmapWidth;
    String newDateStr;
    String nilai_baterai;
    String nilai_desain;
    String nilai_kamera;
    String nilai_kinerja;
    String nilai_layar;
    String nilai_overall;
    String nilbtnApps;
    String nilbtnAudio;
    String nilbtnBaterai;
    String nilbtnDesain;
    String nilbtnHarga;
    String nilbtnKamera;
    String nilbtnKinerja;
    String nilbtnLayar;
    String no_ads;
    String notif;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    DecimalFormat oneDForm;
    String passlam;
    PonselBaseApp ponselBaseApp;
    ArrayList popKomenArray;
    LinearLayout pop_layout_empty;
    ProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    int poslike;
    String postMessage;
    String postMessageLikePon;
    String postMessageSubsNews;
    String postStatus;
    String postStatusLikePon;
    String postStatusSubsNews;
    SmoothProgressBar progbar_notifHP;
    CircularProgressBar progressbar_middle;
    String publisher_name;
    String pushURL;
    String query;
    String querylike;
    String querypopkomen;
    String rata2Apps;
    String rata2Audio;
    String rata2Baterai;
    String rata2Desain;
    String rata2Harga;
    String rata2Kamera;
    String rata2Kinerja;
    String rata2Layar;
    TextView rataBaterai;
    TextView rataDesain;
    TextView rataKamera;
    TextView rataKinerja;
    TextView rataLayar;
    double ratdobApps;
    double ratdobAudio;
    double ratdobBaterai;
    double ratdobDesain;
    double ratdobHarga;
    double ratdobKamera;
    double ratdobKinerja;
    double ratdobLayar;
    double ratdobLikeDis;
    ProgressBar ratingBaterai;
    ProgressBar ratingDesain;
    ProgressBar ratingKamera;
    ProgressBar ratingKinerja;
    ProgressBar ratingLayar;
    ProgressBar ratingLikeDis;
    ProgressBar ratingReviewFitur;
    int ratintApps;
    int ratintAudio;
    int ratintBaterai;
    int ratintDesain;
    int ratintHarga;
    int ratintKamera;
    int ratintKinerja;
    int ratintLayar;
    int ratintLikeDis;
    String res;
    String reslike;
    String room_kota;
    String room_kota_id;
    String room_prov;
    View root;
    ListSCAdapter scAdapter;
    ArrayList scKotaArray;
    String scheme;
    String sclabel;
    ScrollView scrollIkhtisar;
    int sdk;
    ShareDialog shareDialog;
    String slug;
    String smerekmodel;
    String sof_java;
    String sof_java_status;
    String sof_os;
    String sof_os_versi;
    LinearLayout spek_head_Garansi;
    String sta_garansi;
    String stat;
    String statSubNews;
    String statusKomen;
    String statusLikeHp;
    String statuslikeKomen;
    String str_urlspekshare;
    String strdialog;
    String suc;
    String sucads;
    String sucads2;
    String t;
    String tanggal;
    String title_ads;
    String tnggp_bgs;
    String tnggp_krg;
    String tot_LikePon;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    TextView totalVotes;
    String total_hits;
    String total_votes;
    String totdis_LikePon;
    String twitter;
    TextView txtBagus;
    TextView txtBigBerita;
    TextView txtBigHpLain;
    TextView txtBigKomentarHp;
    TextView txtBigRivalTerdekat;
    TextView txtBigRoom;
    TextView txtBigTwitter;
    TextView txtKetertarikan;
    TextView txtKurang;
    TextView txtNotPengunjung;
    TextView txtReviewFitur;
    TextView txtValueKetertarikan;
    TextView txtValueReviewFitur;
    TextView txt_empty;
    String umu_bobot;
    String umu_bobot_ket;
    String umu_dim_lebar;
    String umu_dim_panjang;
    String umu_dim_tebal;
    String umu_diumumkan;
    String umu_diumumkan_sta;
    String umu_model;
    String umu_status;
    String umu_status_ket;
    String umu_tags;
    String umu_warna_ponsel;
    String update_harga;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    UserFunctions userFunction;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kecamatan;
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
    ContextThemeWrapper wrapper;

    public Hal1Ikhtisar()
    {
        postStatusLikePon = "";
        postMessageLikePon = "";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        indexhp = "";
        user_photo = "";
        username = "";
        scKotaArray = null;
        inponsel = null;
        suc = "";
        jumSC = "";
        messageNotif = "";
        kmail_stat = "";
        dataNotifOnOff = "0";
        getJson = "";
        getJsonLain = "";
        ikhtisarArray = null;
        t = Utility.session(RestClient.pelihara);
        hargaAtas = 0;
        hargaBawah = 0;
        querypopkomen = "";
        strdialog = "";
        limit = 0;
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        postStatus = "";
        postMessage = "";
        countKomOld = 0;
        countAllKom = 0;
        statSubNews = "";
        room_kota = "";
        room_kota_id = "";
        room_prov = "";
        tot_komen = "";
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        decimalPlace = 2;
        komen = "";
        oneDForm = new DecimalFormat("#.#");
        publisher_name = "";
        title_ads = "";
        campaign = "";
        logo_pub = "";
        image_ads = "";
        link_ads = "";
        ads_status = "";
        ad_type = "";
        sucads = "0";
        sucads2 = "0";
        animation = null;
        nilbtnDesain = "6";
        nilbtnLayar = "6";
        nilbtnKinerja = "6";
        nilbtnApps = "6";
        nilbtnKamera = "6";
        nilbtnAudio = "6";
        nilbtnBaterai = "6";
        nilbtnHarga = "6";
        internal = "";
        rata2Desain = "7.1";
        rata2Layar = "4.5";
        rata2Kinerja = "10";
        rata2Apps = "5.8";
        rata2Kamera = "7.5";
        rata2Audio = "7.8";
        rata2Baterai = "3.3";
        rata2Harga = "6.1";
        sdk = android.os.Build.VERSION.SDK_INT;
        str_urlspekshare = "";
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        builder.show();
    }

    private void OnlineStatGroup(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_status_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_conv=").append(codename).append("&stat=").append(s2).append("&t=").append(s3).toString();
        Log.e("OnlineStatGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final Hal1Ikhtisar this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("responseGroup", jsonobject.toString());
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final Hal1Ikhtisar this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "jobj_req");
    }

    public static void clickify(TextView textview, String s, com.inponsel.android.utils.ClickSpan.OnClickListener onclicklistener)
    {
        CharSequence charsequence = textview.getText();
        String s1 = charsequence.toString();
        onclicklistener = new ClickSpan(onclicklistener);
        int i = s1.indexOf(s);
        int j = i + s.length();
        if (i != -1)
        {
            if (charsequence instanceof Spannable)
            {
                ((Spannable)charsequence).setSpan(onclicklistener, i, j, 33);
            } else
            {
                s = SpannableString.valueOf(charsequence);
                s.setSpan(onclicklistener, i, j, 33);
                textview.setText(s);
            }
            s = textview.getMovementMethod();
            if (s == null || !(s instanceof LinkMovementMethod))
            {
                textview.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
        }
    }

    public void IkhtisarTask()
    {
        IkhtisarTask ikhtisartask = new IkhtisarTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ikhtisartask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            ikhtisartask.execute(new Void[0]);
            return;
        }
    }

    public void InAdsTask()
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        dataInAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("inads").append(Utility.BASE_FORMAT).append("?pver=").append(String.valueOf(getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode)).append("&hal=P14-01").append("&t=").append(t).toString();
        Log.e("dataInAds", dataInAds);
        InAdsTask inadstask = new InAdsTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            inadstask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            inadstask.execute(new Void[0]);
            return;
        }
    }

    public void RatingAVGTask()
    {
        dataRatingAVG = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ratingnilaihpavg").append(Utility.BASE_FORMAT).append("?id=").append(id_hp).append("&t=").append(t).toString();
        Log.e("url", dataRatingAVG);
        RatingAVGTask ratingavgtask = new RatingAVGTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ratingavgtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            ratingavgtask.execute(new Void[0]);
            return;
        }
    }

    public void RivalTask()
    {
        RivalTask rivaltask = new RivalTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            rivaltask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            rivaltask.execute(new Void[0]);
            return;
        }
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

    public android.animation.Animator.AnimatorListener getAnimationListener()
    {
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            return new android.animation.Animator.AnimatorListener() {

                final Hal1Ikhtisar this$0;

                public void onAnimationCancel(Animator animator)
                {
                    Log.d("piefrag", "anim cancel");
                }

                public void onAnimationEnd(Animator animator)
                {
                    Log.d("piefrag", "anim end");
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
            };
        } else
        {
            return null;
        }
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

    public void inflateAd_In(View view, final Context vAdUnit)
    {
        vAdUnit = (RelativeLayout)view.findViewById(0x7f0b00a6);
        ImageView imageview = (ImageView)view.findViewById(0x7f0b00a7);
        TextView textview = (TextView)view.findViewById(0x7f0b00a9);
        RatingBar ratingbar = (RatingBar)view.findViewById(0x7f0b00aa);
        TextView textview1 = (TextView)view.findViewById(0x7f0b00ab);
        final ImageView nativeAdImage = (ImageView)view.findViewById(0x7f0b00ad);
        TextView textview2 = (TextView)view.findViewById(0x7f0b00ae);
        Button button = (Button)view.findViewById(0x7f0b00af);
        vAdUnit.setVisibility(0);
        ratingbar.setVisibility(8);
        if (ad_type.equals("3") || ad_type.equals("4"))
        {
            vAdUnit = (RelativeLayout)view.findViewById(0x7f0b00a5);
        } else
        {
            vAdUnit = (LinearLayout)view.findViewById(0x7f0b00a5);
        }
        try
        {
            vAdUnit.setBackgroundColor(getActivity().getResources().getColor(0x7f080176));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        textview2.setText(title_ads);
        button.setVisibility(0);
        textview.setText(title_ads);
        textview1.setText(campaign);
        if (ads_method.equals(""))
        {
            button.setVisibility(8);
        } else
        if (ads_method.contains("Download"))
        {
            button.setText("Download");
        } else
        if (ads_method.equals("activity"))
        {
            button.setText("Arahkan");
            if (ad_type.equals("1") || ad_type.equals("4") || ad_type.equals("5"))
            {
                ((TextView)view.findViewById(0x7f0b00ac)).setVisibility(8);
            }
        } else
        {
            button.setText("Arahkan");
            if (ad_type.equals("1") || ad_type.equals("4") || ad_type.equals("5"))
            {
                ((TextView)view.findViewById(0x7f0b00ac)).setVisibility(8);
            }
        }
        nativeAdImage.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(image_ads.replaceAll(" ", "").trim());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        vAdUnit.setOnTouchListener(new android.view.View.OnTouchListener() {

            final Hal1Ikhtisar this$0;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (link_ads.contains("play.google.com"))
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                        return false;
                    }
                    return false;
                }
                if (ads_method.equals("activity"))
                {
                    view1 = new Intent(getActivity(), com/inponsel/android/v2/SCUserActivity);
                    view1.putExtra("activity", "main");
                    startActivityForResult(view1, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    return false;
                }
                if (ads_method.toLowerCase().equals("ponsel"))
                {
                    view1 = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
                    view1.putExtra("id_hph", link_ads);
                    view1.putExtra("namalengkap", "");
                    view1.putExtra("codename", "");
                    view1.putExtra("model", "");
                    view1.putExtra("merk", "");
                    view1.putExtra("gambar", "");
                    view1.putExtra("hrg_baru", "");
                    view1.putExtra("hrg_bekas", "");
                    view1.putExtra("tot_like", "");
                    view1.putExtra("tot_dislike", "");
                    view1.putExtra("tot_komen", "");
                    startActivityForResult(view1, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    return false;
                } else
                {
                    view1 = new Intent("android.intent.action.VIEW");
                    view1.setData(Uri.parse(link_ads.replaceAll(" ", "")));
                    startActivity(view1);
                    return false;
                }
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        try
        {
            Picasso.with(getActivity()).load(logo_pub).into(imageview, new Callback() {

                final Hal1Ikhtisar this$0;

                public void onError()
                {
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        Log.e("image_ads", image_ads);
        view = new Target() {

            final Hal1Ikhtisar this$0;
            private final ImageView val$nativeAdImage;
            private final View val$vAdUnit;

            public void onBitmapFailed(Drawable drawable)
            {
            }

            public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
            {
                DisplayMetrics displaymetrics;
                int k;
                int l;
                k = bitmap.getWidth();
                l = bitmap.getHeight();
                loadedfrom = ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay();
                displaymetrics = new DisplayMetrics();
                loadedfrom.getMetrics(displaymetrics);
                if (!ad_type.equals("5")) goto _L2; else goto _L1
_L1:
                int i;
                int j;
                j = displaymetrics.widthPixels - (int)Utility.convertDpToPixel(30F, getActivity());
                i = displaymetrics.heightPixels - (int)Utility.convertDpToPixel(30F, getActivity());
_L3:
                if (!ad_type.equals("3") && !ad_type.equals("4"))
                {
                    break MISSING_BLOCK_LABEL_298;
                }
                if (ad_type.equals("3"))
                {
                    vAdUnit.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
                }
                nativeAdImage.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
_L4:
                nativeAdImage.setImageBitmap(bitmap);
                return;
_L2:
label0:
                {
                    if (!ad_type.equals("4"))
                    {
                        break label0;
                    }
                    j = displaymetrics.widthPixels - (int)Utility.convertDpToPixel(30F, getActivity());
                    i = displaymetrics.heightPixels - (int)Utility.convertDpToPixel(30F, getActivity());
                }
                  goto _L3
                try
                {
                    j = displaymetrics.widthPixels;
                    i = displaymetrics.heightPixels;
                }
                // Misplaced declaration of an exception variable
                catch (Bitmap bitmap)
                {
                    bitmap.printStackTrace();
                    return;
                }
                  goto _L3
                if (ad_type.equals("3"))
                {
                    vAdUnit.setLayoutParams(new android.widget.LinearLayout.LayoutParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
                }
                nativeAdImage.setLayoutParams(new android.widget.LinearLayout.LayoutParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
                  goto _L4
            }

            public void onPrepareLoad(Drawable drawable)
            {
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                vAdUnit = view;
                nativeAdImage = imageview;
                super();
            }
        };
        try
        {
            Picasso.with(getActivity()).load(image_ads).into(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        ll_inad_native.setVisibility(0);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        if (bundle != null)
        {
            mCurCheckPosition = bundle.getInt("curChoice", 0);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        i = configuration.orientation;
    }

    public void onCreate(Bundle bundle)
    {
        setRetainInstance(true);
        super.onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f0004, menu);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            bundle = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Hal1Ikhtisar");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        inflaterInAd = layoutinflater;
        root = layoutinflater.inflate(0x7f03009f, viewgroup, false);
        drw = getActivity().getResources().getDrawable(0x7f020240);
        drw.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwKurang = getActivity().getResources().getDrawable(0x7f0201ea);
        drwKurang.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        callbackManager = com.facebook.CallbackManager.Factory.create();
        shareDialog = new ShareDialog(getActivity());
        wrapper = new ContextThemeWrapper(getActivity(), 0x103006e);
        userFunction = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        ikhtisarArray = new ArrayList();
        progbar_notifHP = (SmoothProgressBar)root.findViewById(0x7f0b04cb);
        progbar_notifHP.setVisibility(8);
        chkNotifKomenHp = (CheckBox)root.findViewById(0x7f0b032e);
        txtValueKetertarikan = (TextView)root.findViewById(0x7f0b023f);
        txtValueReviewFitur = (TextView)root.findViewById(0x7f0b04ad);
        layout_ChatRoom = (LinearLayout)root.findViewById(0x7f0b0333);
        layout_Forum = (LinearLayout)root.findViewById(0x7f0b0334);
        txtReviewFitur = (TextView)root.findViewById(0x7f0b0545);
        txtKetertarikan = (TextView)root.findViewById(0x7f0b0240);
        txtNotPengunjung = (TextView)root.findViewById(0x7f0b0540);
        lay_ReviewFitur = (LinearLayout)root.findViewById(0x7f0b0543);
        lay_Ketertarikan = (LinearLayout)root.findViewById(0x7f0b0546);
        lay_ringkasan = (LinearLayout)root.findViewById(0x7f0b0542);
        txtBigKomentarHp = (TextView)root.findViewById(0x7f0b0338);
        txtBigHpLain = (TextView)root.findViewById(0x7f0b0326);
        txtBigTwitter = (TextView)root.findViewById(0x7f0b0322);
        txtBigRivalTerdekat = (TextView)root.findViewById(0x7f0b0316);
        txtBigBerita = (TextView)root.findViewById(0x7f0b0312);
        txtBigRoom = (TextView)root.findViewById(0x7f0b0332);
        layout_Room = (LinearLayout)root.findViewById(0x7f0b032f);
        layout_KomentarHp = (LinearLayout)root.findViewById(0x7f0b0335);
        layout_KomentarHp.setVisibility(8);
        layout_GalleriFoto = (LinearLayout)root.findViewById(0x7f0b030b);
        layout_RivalTerdekat = (LinearLayout)root.findViewById(0x7f0b0313);
        layout_Bandingkan = (LinearLayout)root.findViewById(0x7f0b031b);
        layout_Berita = (LinearLayout)root.findViewById(0x7f0b030f);
        layout_Twitter = (LinearLayout)root.findViewById(0x7f0b031f);
        layout_SCTerdekat = (LinearLayout)root.findViewById(0x7f0b0317);
        layout_HpLain = (LinearLayout)root.findViewById(0x7f0b0323);
        layout_VendorProf = (LinearLayout)root.findViewById(0x7f0b0327);
        detail_favorite = (ImageView)root.findViewById(0x7f0b04b0);
        detail_favoritenews = (ImageView)root.findViewById(0x7f0b04b3);
        ll_inad_native = (LinearLayout)root.findViewById(0x7f0b0339);
        chkNotifKomenHp.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
                android.app.AlertDialog.Builder builder;
                if (chkNotifKomenHp.isChecked())
                {
                    statusKomen = "1";
                    view = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
                } else
                {
                    statusKomen = "0";
                    view = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
                }
                builder = new android.app.AlertDialog.Builder(wrapper);
                builder.setTitle("Perhatian");
                builder.setMessage(view);
                builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        TurnOnOffNotifTask();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                builder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (chkNotifKomenHp.isChecked())
                        {
                            chkNotifKomenHp.setChecked(false);
                        } else
                        {
                            chkNotifKomenHp.setChecked(true);
                        }
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                builder.show();
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (LayoutInflater layoutinflater) { }
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
            cursor.close();
            txtBigRoom.setEnabled(true);
        } else
        {
            txtBigRoom.setEnabled(false);
        }
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        extras = getActivity().getIntent().getExtras();
        DetailsPonsel.dataurlemail = getActivity().getIntent().getData();
        Log.e("DetailsPonsel.dataurlemail", String.valueOf(DetailsPonsel.dataurlemail));
        if (!String.valueOf(DetailsPonsel.dataurlemail).equals("null"))
        {
            scheme = DetailsPonsel.dataurlemail.getScheme();
            host = DetailsPonsel.dataurlemail.getHost();
            layoutinflater = DetailsPonsel.dataurlemail.getPathSegments();
            details = (String)layoutinflater.get(0);
            id_hp = (String)layoutinflater.get(1);
            notif = "email";
            Log.e("scheme", scheme);
            Log.e("host", host);
            Log.e("id_hph", id_hp);
        } else
        {
            namalengkap = extras.getString("namalengkap");
            id_hp = extras.getString("id_hph");
            model = extras.getString("model");
            merk = extras.getString("merk");
            gambar = extras.getString("gambar");
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            codename = extras.getString("codename");
            tot_komen = extras.getString("tot_komen");
            txtBigRoom.setText((new StringBuilder("Forum ")).append(namalengkap).toString());
            namalengkapbgskrg = namalengkap;
            txtBigBerita.setText((new StringBuilder("Berita ")).append(namalengkap).toString());
        }
        if (tot_komen.equals("") || tot_komen == null)
        {
            tot_komen = "-";
        }
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            if (db.checkIfExist(id_hp))
            {
                if (sdk < 16)
                {
                    detail_favorite.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favorite.setBackground(drwKurang);
                }
            } else
            if (sdk < 16)
            {
                detail_favorite.setBackgroundDrawable(drw);
            } else
            {
                detail_favorite.setBackground(drw);
            }
        } else
        if (sdk < 16)
        {
            detail_favorite.setBackgroundDrawable(drw);
        } else
        {
            detail_favorite.setBackground(drw);
        }
        detail_favorite.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    if (db.checkIfExist(id_hp))
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Hapus perangkat ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Favoritkan perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                stat = "1";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        detail_favoritenews.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    if (statSubNews.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Hentikan langganan berita perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statSubNews = "0";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Langganan berita perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statSubNews = "1";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk berlangganan berita, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        txtBigHpLain.setText((new StringBuilder("Ponsel ")).append(merk).append(" lainnya").toString());
        txtBigKomentarHp.setText((new StringBuilder("Komentar (")).append(tot_komen).append(")").toString());
        layout_Twitter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/TwitterInPonsel);
                view.putExtra("twitter", twitter);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_KomentarHp.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_Bandingkan.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/PilihPonselBanding);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("hrg_baru", hrg_baru);
                view.putExtra("hrg_bekas", hrg_bekas);
                view.putExtra("tot_like", tnggp_bgs);
                view.putExtra("tot_dislike", tnggp_krg);
                view.putExtra("tot_komen", jml_komentar);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_Berita.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "5");
                view.putExtra("tag_key", (new StringBuilder("hp:")).append(id_hp).toString());
                view.putExtra("kategori_tag", namalengkap);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_ChatRoom.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/RoomChatActivity);
                    view.putExtra("id_from", user_id);
                    view.putExtra("from_name", username);
                    view.putExtra("from_photo", user_photo);
                    view.putExtra("to_photo", gambar);
                    view.putExtra("merk", merk);
                    view.putExtra("model", model);
                    view.putExtra("codename", (new StringBuilder(String.valueOf(codename))).append("-").append(codename).toString());
                    view.putExtra("id_hph", id_hp);
                    OnlineStatGroup(user_id, codename, "1", t, "");
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    LoginPopup("Perhatian", "Untuk masuk ke chat room diharuskan login dahulu");
                    return;
                }
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_Forum.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/tlforum/ForumHPActivity);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("kota", room_kota);
                view.putExtra("kota_id", room_kota_id);
                view.putExtra("prov", room_prov);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_GalleriFoto.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/GalleriFotoHp);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_HpLain.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/DaftarPonselMerkActivity);
                view.putExtra("merk", id_merk);
                view.putExtra("titlemerek", merk);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_VendorProf.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/ProfilPTActivity);
                view.putExtra("id_merk", id_merk);
                view.putExtra("titlemerek", merk);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        layout_SCTerdekat.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/SCTerdekatActivity);
                view.putExtra("id_merk", id_merk);
                view.putExtra("titlemerek", merk);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        t = Utility.session(t);
        btnRefresh = (Button)root.findViewById(0x7f0b04d0);
        scrollIkhtisar = (ScrollView)root.findViewById(0x7f0b053d);
        layoutinflater = getActivity().getTheme().obtainStyledAttributes(new int[] {
            0x10102eb
        });
        mActionBarHeight = layoutinflater.getDimension(0, 0.0F);
        layoutinflater.recycle();
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        progressbar_middle = (CircularProgressBar)root.findViewById(0x7f0b00ca);
        txt_empty = (TextView)root.findViewById(0x7f0b0093);
        txt_empty.setText(0x7f0c0053);
        edtHargaBaru = (EditText)root.findViewById(0x7f0b01b7);
        edtHargaBekas = (EditText)root.findViewById(0x7f0b01ba);
        edtHargaGaransi = (EditText)root.findViewById(0x7f0b01bd);
        edtHargaInfoTamb = (EditText)root.findViewById(0x7f0b01c0);
        layout_empty = (LinearLayout)root.findViewById(0x7f0b0091);
        layout_empty.setVisibility(0);
        spek_head_Garansi = (LinearLayout)root.findViewById(0x7f0b01bc);
        imgHpDetail = (ImageView)root.findViewById(0x7f0b049d);
        detail_txtMerek = (TextView)root.findViewById(0x7f0b0535);
        detail_txtMerek.setSelected(true);
        headPonsel = (LinearLayout)root.findViewById(0x7f0b049a);
        headPonsel.setVisibility(0);
        detail_lay_like = (RelativeLayout)root.findViewById(0x7f0b049e);
        detail_lay_dislike = (RelativeLayout)root.findViewById(0x7f0b04a1);
        detail_lay_kom = (RelativeLayout)root.findViewById(0x7f0b04a4);
        detail_like = (ImageView)root.findViewById(0x7f0b049f);
        detail_dislike = (ImageView)root.findViewById(0x7f0b04a2);
        detail_text_like = (TextView)root.findViewById(0x7f0b04a0);
        detail_text_dislike = (TextView)root.findViewById(0x7f0b04a3);
        detail_text_komentar = (TextView)root.findViewById(0x7f0b04a6);
        det_prog_item = (ProgressBar)root.findViewById(0x7f0b049c);
        ratingLikeDis = (ProgressBar)root.findViewById(0x7f0b04a7);
        ratingReviewFitur = (ProgressBar)root.findViewById(0x7f0b04a8);
        t = Utility.session(t);
        layout_sc_kota = (LinearLayout)root.findViewById(0x7f0b0825);
        scKotaArray = new ArrayList();
        scAdapter = new ListSCAdapter(getActivity(), 0x7f030121, scKotaArray);
        rataDesain = (TextView)root.findViewById(0x7f0b01e6);
        rataLayar = (TextView)root.findViewById(0x7f0b01e9);
        rataKinerja = (TextView)root.findViewById(0x7f0b01ec);
        rataKamera = (TextView)root.findViewById(0x7f0b01ef);
        rataBaterai = (TextView)root.findViewById(0x7f0b01f2);
        btnDesainRate = (Button)root.findViewById(0x7f0b01e7);
        btnLayarRate = (Button)root.findViewById(0x7f0b01ea);
        btnKinerjaRate = (Button)root.findViewById(0x7f0b01ed);
        btnKameraRate = (Button)root.findViewById(0x7f0b01f0);
        btnBateraiRate = (Button)root.findViewById(0x7f0b01f3);
        btnKirimNilai = (Button)root.findViewById(0x7f0b01f5);
        totalVotes = (TextView)root.findViewById(0x7f0b01f4);
        ratingBaterai = (ProgressBar)root.findViewById(0x7f0b01f1);
        ratingKamera = (ProgressBar)root.findViewById(0x7f0b01ee);
        ratingKinerja = (ProgressBar)root.findViewById(0x7f0b01eb);
        ratingLayar = (ProgressBar)root.findViewById(0x7f0b01e8);
        ratingDesain = (ProgressBar)root.findViewById(0x7f0b01e5);
        animationin = AnimationUtils.loadAnimation(getActivity(), 0x7f040011);
        animationin.setDuration(500L);
        btnDesainRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Desain :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnDesainRate.setText(items[i]);
                            nilbtnDesain = items[i];
                        }

            
            {
                this$1 = final__pcls14;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        btnLayarRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Layar :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnLayarRate.setText(items[i]);
                            nilbtnLayar = items[i];
                        }

            
            {
                this$1 = final__pcls15;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        btnKinerjaRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Kinerja :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnKinerjaRate.setText(items[i]);
                            nilbtnKinerja = items[i];
                        }

            
            {
                this$1 = final__pcls16;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        btnKameraRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Kamera :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnKameraRate.setText(items[i]);
                            nilbtnKamera = items[i];
                        }

            
            {
                this$1 = final__pcls17;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        btnBateraiRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Baterai :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnBateraiRate.setText(items[i]);
                            nilbtnBaterai = items[i];
                        }

            
            {
                this$1 = final__pcls18;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        btnKirimNilai.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle((new StringBuilder("Penilaian ")).append(namalengkap).toString());
                    view.setMessage((new StringBuilder("Desain : ")).append(nilbtnDesain).append("\nLayar : ").append(nilbtnLayar).append("\nKinerja : ").append(nilbtnKinerja).append("\nKamera : ").append(nilbtnKamera).append("\nBaterai : ").append(nilbtnBaterai).toString());
                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls19 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostNilaiTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            }
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostNilaiTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostNilaiTask()).execute(new Void[0]);
                                return;
                            }
                        }

            
            {
                this$1 = _cls19.this;
                super();
            }
                    });
                    view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls19 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls19.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls19 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls19.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls19 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls19.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls19 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls19.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        accounts = AccountManager.get(getActivity()).getAccounts();
        btnRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                layout_empty.setVisibility(0);
                scrollIkhtisar.setVisibility(8);
                IkhtisarTask();
                try
                {
                    view = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("my_vote_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
                    Log.e("getnilai", view);
                    (new GetMyNilai()).execute(new String[] {
                        view
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
        fmts.setGroupingSeparator('.');
        fmt.setGroupingSize(3);
        fmt.setGroupingUsed(true);
        fmt.setDecimalFormatSymbols(fmts);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        Log.e("whgetother", String.valueOf((new StringBuilder(String.valueOf(Utility.getBmapWidth(getActivity())))).append("x").append(Utility.getBmapHeight(getActivity())).toString()));
        detail_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                ponselBaseApp.getObserver().setIndexHp(codename);
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    statusLikeHp = "1";
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
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        detail_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar this$0;

            public void onClick(View view)
            {
                ponselBaseApp.getObserver().setIndexHp(codename);
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    statusLikeHp = "0";
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
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }
        });
        dataIktisar = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("spek_ikhtisar").append(Utility.BASE_FORMAT).append("?id=").append(id_hp).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("url", dataIktisar);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            progressbar_middle.setVisibility(0);
            txt_empty.setText("Memuat");
            IkhtisarTask();
        } else
        {
            layout_empty.setVisibility(0);
            progressbar_middle.setVisibility(8);
            txt_empty.setVisibility(8);
            btnRefresh.setVisibility(0);
        }
        return root;
    }

    public boolean onOptionsItemSelected(final MenuItem objShareIntentListAdapter)
    {
        switch (objShareIntentListAdapter.getItemId())
        {
        default:
            return true;

        case 16908332: 
            getActivity().finish();
            getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
            return true;

        case 2131429682: 
            objShareIntentListAdapter = new Intent(getActivity(), com/inponsel/android/pencariangen/TabPencarian);
            getActivity().startActivityForResult(objShareIntentListAdapter, 0);
            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return true;

        case 2131429683: 
            Log.e("str_urlspekshare", str_urlspekshare);
            break;
        }
        objShareIntentListAdapter = new Intent("android.intent.action.SEND");
        objShareIntentListAdapter.setType("text/plain");
        objShareIntentListAdapter = getActivity().getPackageManager().queryIntentActivities(objShareIntentListAdapter, 0);
        objShareIntentListAdapter = new ShareIntentListAdapter(getActivity(), objShareIntentListAdapter.toArray());
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Bagikan ke");
        builder.setAdapter(objShareIntentListAdapter, new android.content.DialogInterface.OnClickListener() {

            final Hal1Ikhtisar this$0;
            private final ShareIntentListAdapter val$objShareIntentListAdapter;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = (ResolveInfo)objShareIntentListAdapter.getItem(i);
                if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
                {
                    Log.e("share", "facebook");
                    dialoginterface = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle((new StringBuilder(String.valueOf(namalengkap))).append(" - Berita, Spesifikasi, Review, Galeri foto, Harga, Service Center").toString()).setImageUrl(Uri.parse(gambar)).setContentDescription((new StringBuilder("Temukan informasi lengkap ponsel ")).append(namalengkap).append(" di INPONSEL.").toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
                    shareDialog.show(dialoginterface);
                    return;
                } else
                {
                    Log.e("share", "other");
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", str_urlspekshare);
                    intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder("Spesifikasi ")).append(namalengkap).toString());
                    Log.e("share", str_urlspekshare);
                    intent.putExtra("android.intent.extra.TITLE", (new StringBuilder("Spesifikasi ")).append(namalengkap).toString());
                    startActivity(intent);
                    return;
                }
            }

            
            {
                this$0 = Hal1Ikhtisar.this;
                objShareIntentListAdapter = shareintentlistadapter;
                super();
            }
        });
        builder.show();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("curChoice", mCurCheckPosition);
    }

    protected void showIn_AD(View view)
    {
        Log.e("campaign", campaign);
        inflateAd_In(view, getActivity());
    }

    public void update(Observable observable, Object obj)
    {
        Log.e("BaseAppIkhtisar", ponselBaseApp.getObserver().getIndexHp());
        if (ponselBaseApp.getObserver().getUpdateType().equals("likedisPonsel") && ponselBaseApp.getObserver().getIndexHp().equals(codename))
        {
            detail_text_like.setText(ponselBaseApp.getObserver().getTot_LikePon().toString());
            detail_text_dislike.setText(ponselBaseApp.getObserver().getTotdis_LikePon().toString());
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
            {
                detail_like.setBackgroundResource(0x7f020259);
                detail_dislike.setBackgroundResource(0x7f0201a6);
                detail_lay_like.setEnabled(false);
                detail_lay_dislike.setEnabled(true);
            } else
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                detail_like.setBackgroundResource(0x7f02025a);
                detail_dislike.setBackgroundResource(0x7f0201a5);
                detail_lay_like.setEnabled(true);
                detail_lay_dislike.setEnabled(false);
            }
        }
        if (userFunction.isUserLoggedIn(getActivity()))
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
            user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
        }
    }



}
