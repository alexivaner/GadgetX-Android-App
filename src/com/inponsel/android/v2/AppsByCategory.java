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
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
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
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.adapter.ListAppsHorizontalAdapter;
import com.inponsel.android.adapter.ListKategoriApps3Adapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.Header;
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
//            KatAppsReplyFormActivity, PlaystoreKategoriKomen, AddKomentarPicture

public class AppsByCategory extends SherlockFragmentActivity
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
    {

        final AppsByCategory this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
            mArrayListData = new ArrayList();
            as = jsonobject.getJSONArray("InPonsel");
            jum_komen_list = jsonobject.getString("total_komen");
            jum_komen = jsonobject.getString("total_komen");
            statusKomen = jsonobject.getString("statuskomen");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            Log.e("statuskomen", (new StringBuilder("statusKomen")).append(statusKomen).toString());
            str_urlspekshare = jsonobject.getString("url_share");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_362;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_362;
            }
            Object obj = AppsByCategory.this;
            obj.countAllKom = ((AppsByCategory) (obj)).countAllKom + 1;
            obj = AppsByCategory.this;
            obj.countKomOld = ((AppsByCategory) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_kat"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            Log.e("statusKomenTask", statusKomen);
            int j;
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            progressbar_komen.setVisibility(8);
            if (mArrayListData.size() == 0)
            {
                txt_empty_komen.setVisibility(0);
            } else
            if (mArrayListData.size() < 3)
            {
                btn_komenlain.setVisibility(8);
                txt_empty_komen.setVisibility(8);
            } else
            {
                txtLabelKomentar.setText((new StringBuilder("Komentar (")).append(jum_komen).append(")").toString());
                if (Integer.parseInt(jum_komen_list) == 3)
                {
                    btn_komenlain.setVisibility(8);
                    txt_empty_komen.setVisibility(8);
                } else
                {
                    btn_komenlain.setVisibility(0);
                    txt_empty_komen.setVisibility(8);
                }
            }
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            i = 0;
_L8:
            ImageView imageview;
            ImageView imageview1;
            final String id_komrss;
            String s;
            final String komen_rss;
            final String tanggal_kom;
            final String user_photo;
            final String user_name;
            try
            {
                j = mArrayListData.size();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (i < j) goto _L3; else goto _L2
_L2:
            return;
_L3:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
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
            txtLikeKom_list = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like_kom = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike_kom = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep_kom = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            s = ((ItemRSSKomen)mArrayListData.get(i)).getId_user();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user_to();
            komen_rss = ((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss();
            tanggal_kom = ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom();
            user_photo = ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo();
            user_name = ((ItemRSSKomen)mArrayListData.get(i)).getUser_name();
            ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemRSSKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to();
            Log.e("komen_rss", (new StringBuilder("komen_rss")).append(komen_rss).toString());
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s1 = ((ItemRSSKomen)mArrayListData.get(i)).getImg_media();
            String s2 = ((ItemRSSKomen)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s1, s2);
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L5; else goto _L4
_L4:
            lay_quote.setVisibility(8);
_L9:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L7; else goto _L6
_L6:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like_kom.setEnabled(false);
            list_lay_dislike_kom.setEnabled(true);
_L10:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_2038;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L11:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom_list.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
            ll_komentar.addView(void1);
            img_kom_picture.setOnLongClickListener(user_photo. new android.view.View.OnLongClickListener() {

                final KomentarAsycTask this$1;
                private final String val$user_photo;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(user_photo.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_komentarasyctask;
                user_photo = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_user;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", id_user);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasyctask;
                id_user = String.this;
                super();
            }
            });
            list_lay_like_kom.setOnClickListener(id_komrss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(str_SC_ID).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylikeKomen);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangKomenTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangKomenTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                id_komrss = String.this;
                super();
            }
            });
            list_lay_dislike_kom.setOnClickListener(id_komrss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(str_SC_ID).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylikeKomen", querylikeKomen);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangKomenTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangKomenTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                id_komrss = String.this;
                super();
            }
            });
            list_lay_rep_kom.setOnClickListener(user_photo. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    idkom_pos = id_komrss;
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/KatAppsReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", idkom_pos);
                        view.putExtra("id_kat", str_SC_ID);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        view.putExtra("type", str_category);
                        startActivityForResult(view, AppsByCategory.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                id_komrss = s;
                user_name = s1;
                tanggal_kom = s2;
                komen_rss = s3;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(id_komrss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/KatAppsReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", idkom_pos);
                        view.putExtra("id_kat", str_SC_ID);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        view.putExtra("type", str_category);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, AppsByCategory.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                user_name = s;
                tanggal_kom = s1;
                komen_rss = s2;
                user_photo = s3;
                id_komrss = String.this;
                super();
            }
            });
            i++;
              goto _L8
_L5:
            lay_quote.setVisibility(0);
              goto _L9
_L7:
label0:
            {
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like_kom.setEnabled(true);
                list_lay_dislike_kom.setEnabled(false);
            }
              goto _L10
            list_lay_like_kom.setEnabled(true);
            list_lay_dislike_kom.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L10
            img_kom_picture.setImageResource(0x7f020297);
              goto _L11
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("KomentarAsycTask", "onPreExecute");
            progressbar_komen.setVisibility(0);
            txt_empty_komen.setVisibility(8);
            btn_komenlain.setVisibility(8);
            ll_komentar.removeAllViewsInLayout();
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = AppsByCategory.this;
            super();
        }
    }

    public class PostBagusKurangKomenTask extends AsyncTask
    {

        final AppsByCategory this$0;

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
            tot_LikeKom = s.getString("total_like");
            totdis_LikeKom = s.getString("total_dislike");
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("katapps_komen_likedis").append(Utility.BASE_FORMAT).append("?").append(querylikeKomen).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                reslikeKomen = avoid.toString();
                parseJSONLikeKom(reslikeKomen);
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
                break MISSING_BLOCK_LABEL_123;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_106;
            }
            notificationLikeHelper.completed("", "Like komentar terkirim");
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            return;
            try
            {
                notificationLikeHelper.completed("", "Dislike komentar terkirim");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal("", postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal("", postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangKomenTask()
        {
            this$0 = AppsByCategory.this;
            super();
        }
    }

    public class PostKomenSC extends AsyncTask
    {

        final AppsByCategory this$0;

        private void parseJSONSC(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                Log.e("postStatus", postStatus);
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_katapps").append(Utility.BASE_FORMAT).append("?").append(querypopkomensc).toString();
                Log.e("pushsc_krisan", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONSC(res);
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
            if (postStatus.equals("1"))
            {
                edt_pop_komen.setText("");
                mNotificationHelper.completed(str_SC_NAMA, mNotificationHelper.SucdiskomStatement);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new SendMailSCTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else
                {
                    (new SendMailSCTask()).execute(new Void[0]);
                }
            } else
            if (postStatus.equals("040"))
            {
                mNotificationHelper.gagal(str_SC_merk, (new StringBuilder(String.valueOf(mNotificationHelper.gagalkomStatement))).append(" - ").append(postMessage).toString());
                void1 = new android.app.AlertDialog.Builder(AppsByCategory.this);
                void1.setMessage(postMessage);
                void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final PostKomenSC this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = PostKomenSC.this;
                super();
            }
                });
                void1.show();
            } else
            {
                mNotificationHelper.gagal(str_SC_merk, mNotificationHelper.gagalkomStatement);
            }
            btn_send_komen.setEnabled(true);
            edt_pop_komen.setEnabled(true);
            edt_pop_komen.setTextColor(Color.parseColor("#000000"));
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

        protected void onPreExecute()
        {
            super.onPreExecute();
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            mNotificationHelper.createNotification(str_SC_NAMA, mNotificationHelper.komenPostWords);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setEnabled(false);
            edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
        }

        public PostKomenSC()
        {
            this$0 = AppsByCategory.this;
            super();
        }
    }

    public class SendMailSCTask extends AsyncTask
    {

        final AppsByCategory this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_katapps").append(Utility.BASE_FORMAT).append("?").append(querypopkomensc).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("pushURLSCemail", avoid);
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

        public SendMailSCTask()
        {
            this$0 = AppsByCategory.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final AppsByCategory this$0;

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
            this$0 = AppsByCategory.this;
            super();
        }
    }


    private static int POST_STAT = 0;
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    ArrayList arrayListCategoryApps;
    ArrayList arrayListKatApps;
    String bottom_id;
    Button btn_komen_pic;
    Button btn_komenlain;
    Button btn_pop_login;
    Button btn_send_komen;
    int charCount;
    int charCount_list;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    Cursor cursor;
    String dataNotifOnOff;
    String dataSCKomen;
    String dataSCMyKomen;
    String dataSCRating;
    DatabaseHandler db;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    String fav_stat;
    float final_height;
    float final_width;
    LinearLayout headName;
    String id_artikel;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imgKomentar;
    ImageView imgKomentar_rep;
    ImageView img_fav_apps_1;
    ImageView img_koleksi_apps;
    ImageView img_kom_picture;
    ImageView img_like_apps_1;
    InputMethodManager imm;
    JSONArray inponsel;
    MenuItem itemTurnNotif;
    JSONArray jArray;
    String jum_komen;
    String jum_komen_list;
    String kmail_stat;
    String komencount;
    RelativeLayout lay_pop_komen;
    LinearLayout lay_quote;
    ExpandableHeightGridView listApps;
    ListAppsHorizontalAdapter listAppsCateforyAdapter;
    ListKategoriApps3Adapter listKatApps3Adapter;
    ExpandableHeightGridView listKategoriApps;
    RelativeLayout list_lay_dislike_kom;
    RelativeLayout list_lay_kom_kom;
    RelativeLayout list_lay_like_kom;
    RelativeLayout list_lay_rep_kom;
    LinearLayout ll_fav_apps;
    RelativeLayout ll_img_komen;
    RelativeLayout ll_img_komen_rep;
    LinearLayout ll_komentar;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    NotificationKomenHelper mNotificationHelper;
    Menu mainMenu;
    String messageNotif;
    String nama_asli;
    NotificationLikeRSSHelper notificationLikeHelper;
    private DisplayImageOptions options;
    String passlam;
    PonselBaseApp ponselBaseApp;
    TextView pop_txtCountKomen;
    String postMessage;
    String postMessageLikeKom;
    String postMessage_list;
    String postStatus;
    String postStatusLikeKom;
    String postStatus_list;
    CircularProgressBar prog_img_apps;
    SmoothProgressBar progbar_notifHP;
    CircularProgressBar progressbar_appsbycategory;
    CircularProgressBar progressbar_categoryrandom;
    ProgressBar progressbar_imgkomen;
    ProgressBar progressbar_imgkomenrep;
    ProgressBar progressbar_komen;
    String queryFlag;
    String querylikeKomen;
    String querypopkomensc;
    String res;
    String reslikeKomen;
    RelativeLayout rl_like_apps;
    String statusKomen;
    String statuslike;
    String strKonekStat;
    String str_SC_ID;
    String str_SC_NAMA;
    String str_SC_merk;
    String str_background_cat;
    String str_backgroundimg_cat;
    String str_category;
    String str_cont_center;
    String str_contven_center;
    String str_date_cat;
    String str_desc_cat;
    String str_height_img;
    String str_id;
    String str_id_cat;
    String str_jam_opr;
    String str_likestatus_cat;
    String str_sc_almt;
    String str_sc_email;
    String str_sc_fb;
    String str_sc_fb_id;
    String str_sc_telp;
    String str_sc_twitter;
    String str_sc_web;
    String str_sc_ytube;
    String str_share_image;
    String str_tag_cat;
    String str_title_cat;
    String str_totallike_cat;
    String str_urlspekshare;
    String str_width_img;
    String suc;
    String succesStat;
    ScrollView sv_appscategory;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon_list;
    String totdis_LikeKom;
    String totdis_LikePon_list;
    TextView txtIdKom;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLabelKomentar;
    TextView txtLikeKom_list;
    TextView txtTanggapan;
    TextView txtTapImage;
    TextView txtTapImageRep;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_empty_komen;
    TextView txt_fav_kat_apps_1;
    TextView txt_kat_apps_1;
    TextView txt_like_kat_apps_1;
    TextView txt_sub_kat_apps_1;
    TextView txtdisLikeKom;
    String urlAppsKategori;
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

    public AppsByCategory()
    {
        str_id_cat = "";
        str_title_cat = "";
        str_desc_cat = "";
        str_tag_cat = "";
        str_background_cat = "";
        str_backgroundimg_cat = "";
        str_date_cat = "";
        str_totallike_cat = "";
        str_likestatus_cat = "";
        str_width_img = "1024";
        str_height_img = "600";
        urlAppsKategori = "";
        arrayListCategoryApps = null;
        arrayListKatApps = null;
        bottom_id = "";
        top_id = "0";
        jum_komen_list = "0";
        tot_LikePon_list = "";
        jum_komen = "0";
        totdis_LikePon_list = "";
        statusKomen = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strKonekStat = "";
        komencount = "";
        dataNotifOnOff = "0";
        messageNotif = "";
        kmail_stat = "";
        suc = "";
        inponsel = null;
        str_urlspekshare = "";
        res = "";
        postStatus_list = "";
        postMessage_list = "";
        querylikeKomen = "";
        reslikeKomen = "";
        queryFlag = "";
        id_artikel = "";
        str_share_image = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        tot_LikeKom = "0";
        totdis_LikeKom = "0";
        str_category = "";
        str_id = "";
        fav_stat = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        animateFirstListener = new AnimateFirstDisplayListener();
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

                final AppsByCategory this$0;
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

                        final _cls18 this$1;
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
                this$1 = final__pcls18;
                img_media = String.this;
                super();
            }
                    });
                }


            
            {
                this$0 = AppsByCategory.this;
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

            final AppsByCategory this$0;
            private final String val$img_media;
            private final String val$img_media_to;

            public void onClick(View view)
            {
                Log.e("ll_img_komen_rep", img_media);
                view = new ArrayList();
                Object obj = img_media_to;
                view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
                view = (String[])view.toArray(new String[view.size()]);
                obj = new Intent(AppsByCategory.this, com/inponsel/android/v2/ImagePagerActivity);
                ((Intent) (obj)).putExtra("imgUrl", view);
                ((Intent) (obj)).putExtra("pos", 0);
                startActivity(((Intent) (obj)));
            }

            
            {
                this$0 = AppsByCategory.this;
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
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_playkom").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&ktwmail=").append(statusKomen).append("&id_kat=").append(str_id_cat).append("&t=").append(t).toString();
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

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03012a);
        extras = getIntent().getExtras();
        str_category = extras.getString("type");
        str_id = extras.getString("id");
        fav_stat = extras.getString("myfav");
        Log.e("myfav", fav_stat);
        str_id_cat = extras.getString("id");
        str_SC_ID = str_id_cat;
        Log.e("str_SC_ID", str_SC_ID);
        str_title_cat = extras.getString("kategori");
        str_desc_cat = extras.getString("deskripsi");
        str_tag_cat = extras.getString("tag");
        str_background_cat = extras.getString("background");
        str_backgroundimg_cat = extras.getString("background_img");
        Log.e("str_backgroundimg_cat", str_backgroundimg_cat);
        str_date_cat = extras.getString("mod_date");
        str_totallike_cat = extras.getString("total_like");
        str_likestatus_cat = extras.getString("mystat");
        str_width_img = extras.getString("width_img");
        str_height_img = extras.getString("height_img");
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Log.e("str_category", str_category);
        if (str_category.contains("game"))
        {
            bundle.setStatusBarTintResource(0x7f0800ab);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7b1fa2")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Games</font>"));
        } else
        {
            bundle.setStatusBarTintResource(0x7f08011c);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#689f38")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Aplikasi</font>"));
        }
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        t = Utility.session(t);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        progbar_notifHP = (SmoothProgressBar)findViewById(0x7f0b04cb);
        prog_img_apps = (CircularProgressBar)findViewById(0x7f0b085e);
        progbar_notifHP.setVisibility(8);
        ll_fav_apps = (LinearLayout)findViewById(0x7f0b0862);
        listApps = (ExpandableHeightGridView)findViewById(0x7f0b086a);
        listKategoriApps = (ExpandableHeightGridView)findViewById(0x7f0b086c);
        img_koleksi_apps = (ImageView)findViewById(0x7f0b085f);
        img_fav_apps_1 = (ImageView)findViewById(0x7f0b0863);
        img_like_apps_1 = (ImageView)findViewById(0x7f0b0867);
        txt_kat_apps_1 = (TextView)findViewById(0x7f0b0860);
        txt_fav_kat_apps_1 = (TextView)findViewById(0x7f0b0864);
        txt_sub_kat_apps_1 = (TextView)findViewById(0x7f0b0861);
        txt_like_kat_apps_1 = (TextView)findViewById(0x7f0b0866);
        rl_like_apps = (RelativeLayout)findViewById(0x7f0b0865);
        sv_appscategory = (ScrollView)findViewById(0x7f0b085d);
        progressbar_appsbycategory = (CircularProgressBar)findViewById(0x7f0b0869);
        progressbar_categoryrandom = (CircularProgressBar)findViewById(0x7f0b086b);
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        mNotificationHelper = new NotificationKomenHelper(this);
        progressbar_komen = (ProgressBar)findViewById(0x7f0b066d);
        ll_komentar = (LinearLayout)findViewById(0x7f0b0776);
        btn_komenlain = (Button)findViewById(0x7f0b066f);
        txt_empty_komen = (TextView)findViewById(0x7f0b066e);
        txtLabelKomentar = (TextView)findViewById(0x7f0b066c);
        mArrayListData = new ArrayList();
        if (fav_stat.equals("0"))
        {
            img_fav_apps_1.setBackgroundResource(0x7f020302);
        } else
        {
            img_fav_apps_1.setBackgroundResource(0x7f020303);
        }
        txt_kat_apps_1.setText(str_title_cat);
        txt_sub_kat_apps_1.setText(str_desc_cat);
        listApps.setExpanded(true);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        lay_pop_komen = (RelativeLayout)findViewById(0x7f0b04da);
        btn_pop_login = (Button)findViewById(0x7f0b04e1);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        btn_komen_pic = (Button)findViewById(0x7f0b053a);
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final AppsByCategory this$0;

            public void onClick(View view)
            {
                view = new Intent(AppsByCategory.this, com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = AppsByCategory.this;
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
            float f;
            float f1;
            float f2;
            DisplayMetrics displaymetrics;
            int i;
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
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final AppsByCategory this$0;

            public void onClick(View view)
            {
                view = new Intent(AppsByCategory.this, com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", (new StringBuilder("appskategori")).append(str_category).toString());
                view.putExtra("id_kat", str_SC_ID);
                view.putExtra("sc_nama", str_SC_NAMA);
                view.putExtra("top_id", top_id);
                Log.e("top_id", top_id);
                startActivityForResult(view, AppsByCategory.POST_STAT);
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final AppsByCategory this$0;

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

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
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

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
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
                this$0 = AppsByCategory.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final AppsByCategory this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", "0");
                    querypopkomensc = (new StringBuilder("idkat=")).append(str_SC_ID).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PostKomenSC()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PostKomenSC()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        txt_fav_kat_apps_1.setText(fav_stat);
        ll_fav_apps.setOnClickListener(new android.view.View.OnClickListener() {

            final AppsByCategory this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(AppsByCategory.this))
                {
                    Log.e("postfav", txt_fav_kat_apps_1.getText().toString());
                    if (txt_fav_kat_apps_1.getText().toString().equals("1"))
                    {
                        fav_stat = "0";
                    } else
                    {
                        fav_stat = "1";
                    }
                    view = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=").append(t).append("&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(str_id).toString();
                    (new AsyncHttpClient()).get(view, view. new AsyncHttpResponseHandler() {

                        final _cls5 this$1;
                        private final String val$urlPost;

                        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                        {
                        }

                        public void onRetry(int i)
                        {
                        }

                        public void onStart()
                        {
                            if (fav_stat.equals("1"))
                            {
                                notificationLikeHelper.createNotification(str_title_cat, "Menambahkan ke favorit");
                            } else
                            {
                                notificationLikeHelper.createNotification(str_title_cat, "Menghapus ke favorit");
                            }
                            Log.e("urlPost", urlPost);
                        }

                        public void onSuccess(int i, Header aheader[], byte abyte0[])
                        {
                            aheader = new String(abyte0);
                            Log.e("respJson", aheader);
                            try
                            {
                                aheader = new JSONObject(aheader);
                                fav_stat = aheader.getString("success");
                            }
                            // Misplaced declaration of an exception variable
                            catch (Header aheader[]) { }
                            if (fav_stat.equals("0"))
                            {
                                img_fav_apps_1.setBackgroundResource(0x7f020302);
                            } else
                            {
                                img_fav_apps_1.setBackgroundResource(0x7f020303);
                            }
                            if (fav_stat.equals("1"))
                            {
                                notificationLikeHelper.completed(str_title_cat, "Berhasil menambahkan ke favorit");
                            } else
                            {
                                notificationLikeHelper.completed(str_title_cat, "Berhasil menghapus ke favorit");
                            }
                            txt_fav_kat_apps_1.setText(fav_stat);
                            ponselBaseApp.setObserver().setIndexHp(str_id);
                            ponselBaseApp.setObserver().setUpdateType("favappsstore");
                            ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
                        }

            
            {
                this$1 = final__pcls5;
                urlPost = String.this;
                super();
            }
                    });
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(AppsByCategory.this);
                    view.setMessage("Untuk menambah ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        if (str_backgroundimg_cat.contains(".jpeg") || str_backgroundimg_cat.contains(".jpg") || str_backgroundimg_cat.contains(".png"))
        {
            bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
            displaymetrics = new DisplayMetrics();
            bundle.getMetrics(displaymetrics);
            i = displaymetrics.widthPixels;
            f1 = Utility.aspectratio(Float.parseFloat(str_width_img), Float.parseFloat(str_height_img));
            f = Float.parseFloat(str_width_img) / f1;
            f1 = Float.parseFloat(str_height_img) / f1;
            Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
            f2 = i;
            if (f > f1)
            {
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
            } else
            {
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
            }
            img_koleksi_apps.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
            Picasso.with(this).load(str_backgroundimg_cat.trim()).into(img_koleksi_apps, new Callback() {

                final AppsByCategory this$0;

                public void onError()
                {
                    prog_img_apps.setVisibility(8);
                }

                public void onSuccess()
                {
                    img_koleksi_apps.setVisibility(0);
                    prog_img_apps.setVisibility(8);
                }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
            });
        } else
        {
            img_koleksi_apps.setBackgroundColor(Color.parseColor(str_background_cat));
        }
        arrayListCategoryApps = new ArrayList();
        listAppsCateforyAdapter = new ListAppsHorizontalAdapter(this, 0x7f030138, arrayListCategoryApps);
        listApps.setAdapter(listAppsCateforyAdapter);
        arrayListKatApps = new ArrayList();
        listKatApps3Adapter = new ListKategoriApps3Adapter(this, 0x7f03013a, arrayListKatApps);
        listKategoriApps.setAdapter(listKatApps3Adapter);
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("details_category_apps").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&id_kat=").append(str_id_cat).toString(), new AsyncHttpResponseHandler() {

            final AppsByCategory this$0;

            public void onFailure(int j, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int j)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int j, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                j = 0;
_L3:
                int k = aheader.length();
                if (j < k) goto _L2; else goto _L1
_L1:
                if (str_likestatus_cat.equals("0"))
                {
                    img_like_apps_1.setImageResource(0x7f020257);
                    rl_like_apps.setEnabled(true);
                } else
                {
                    img_like_apps_1.setImageResource(0x7f02025b);
                    rl_like_apps.setEnabled(false);
                }
                txt_like_kat_apps_1.setText(str_totallike_cat);
                return;
_L2:
                abyte0 = aheader.getJSONObject(j);
                str_likestatus_cat = abyte0.getString("mystat");
                str_totallike_cat = abyte0.getString("total_like");
                j++;
                  goto _L3
                aheader;
                  goto _L1
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        urlAppsKategori = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_apps_bycategory").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&id_catapps=").append(str_id_cat).toString();
        Log.e("urlAppsKategori", urlAppsKategori);
        (new AsyncHttpClient()).get(urlAppsKategori, new AsyncHttpResponseHandler() {

            final AppsByCategory this$0;

            public void onFailure(int j, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progressbar_appsbycategory.setVisibility(8);
            }

            public void onRetry(int j)
            {
                progressbar_appsbycategory.setVisibility(0);
            }

            public void onStart()
            {
                progressbar_appsbycategory.setVisibility(0);
            }

            public void onSuccess(int j, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                progressbar_appsbycategory.setVisibility(8);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                j = 0;
_L5:
                int k = aheader.length();
                if (j < k) goto _L2; else goto _L1
_L1:
                listAppsCateforyAdapter.notifyDataSetChanged();
                sv_appscategory.scrollTo(0, 0);
                return;
_L2:
                Log.e("iLength", String.valueOf(j));
                abyte0 = aheader.getJSONObject(j);
                Log.e("apprate", (new StringBuilder(String.valueOf(abyte0.getString("app_rate")))).append("(").append(abyte0.getString("app_name")).toString());
                if (abyte0.getString("app_rate") == null || abyte0.getString("app_name").equals(""))
                {
                    break; /* Loop/switch isn't completed */
                }
                try
                {
                    ListModel listmodel = new ListModel();
                    listmodel.setApppackage(abyte0.getString("app_package"));
                    listmodel.setAppname(abyte0.getString("app_name"));
                    listmodel.setAppcover(abyte0.getString("icon_image"));
                    listmodel.setCategory(abyte0.getString("kategori"));
                    listmodel.setAvgrate(abyte0.getString("app_rate"));
                    listmodel.setBanner_image(abyte0.getString("banner_image"));
                    listmodel.setAppsize(abyte0.getString("app_size"));
                    listmodel.setDownloadcount(abyte0.getString("app_download"));
                    listmodel.setAppurl(abyte0.getString("app_url"));
                    arrayListCategoryApps.add(listmodel);
                    break; /* Loop/switch isn't completed */
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
                if (true) goto _L1; else goto _L3
_L3:
                j++;
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_kategori_random4").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&limit=4").append("&type=").append(str_category).toString(), new AsyncHttpResponseHandler() {

            final AppsByCategory this$0;

            public void onFailure(int j, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progressbar_categoryrandom.setVisibility(8);
            }

            public void onRetry(int j)
            {
            }

            public void onStart()
            {
                progressbar_categoryrandom.setVisibility(8);
            }

            public void onSuccess(int j, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                progressbar_categoryrandom.setVisibility(8);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                j = 0;
_L3:
                int k = aheader.length();
                if (j < k) goto _L2; else goto _L1
_L1:
                listKatApps3Adapter.notifyDataSetChanged();
                return;
_L2:
                abyte0 = aheader.getJSONObject(j);
                ListModel listmodel = new ListModel();
                listmodel.setId_apps(abyte0.getString("id"));
                listmodel.setKat_apps_name(abyte0.getString("kategori"));
                listmodel.setKat_apps_desc(abyte0.getString("deskripsi"));
                listmodel.setKat_total_like(abyte0.getString("total_like"));
                listmodel.setKat_apps_background(abyte0.getString("background"));
                listmodel.setKat_apps_background_img(abyte0.getString("background_img"));
                listmodel.setKat_like_status(abyte0.getString("mystat"));
                listmodel.setKat_fav_status(abyte0.getString("myfav"));
                listmodel.setKat_apps_tag(abyte0.getString("tag"));
                listmodel.setKat_apps_date("mod_date");
                listmodel.setKat_img_width(abyte0.getString("width"));
                listmodel.setKat_img_height(abyte0.getString("height"));
                listmodel.setRatio_h(abyte0.getString("ratioH"));
                listmodel.setRatio_w(abyte0.getString("ratioW"));
                listmodel.setKat_type(abyte0.getString("type"));
                arrayListKatApps.add(listmodel);
                j++;
                  goto _L3
                aheader;
                  goto _L1
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("katapps_list_komen3").append(Utility.BASE_FORMAT).append("?idkat=").append(str_SC_ID).append("&lmt=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        listApps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppsByCategory this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsCateforyAdapter.getListModel(j).getAppurl())));
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        listKategoriApps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppsByCategory this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
                adapterview.putExtra("id", listKatApps3Adapter.getListModel(j).getId_apps());
                adapterview.putExtra("kategori", listKatApps3Adapter.getListModel(j).getKat_apps_name());
                adapterview.putExtra("tag", listKatApps3Adapter.getListModel(j).getKat_apps_tag());
                adapterview.putExtra("deskripsi", listKatApps3Adapter.getListModel(j).getKat_apps_desc());
                adapterview.putExtra("mod_date", listKatApps3Adapter.getListModel(j).getKat_apps_date());
                adapterview.putExtra("background", listKatApps3Adapter.getListModel(j).getKat_apps_background());
                adapterview.putExtra("background_img", listKatApps3Adapter.getListModel(j).getKat_apps_background_img());
                adapterview.putExtra("total_like", listKatApps3Adapter.getListModel(j).getKat_total_like());
                adapterview.putExtra("mystat", listKatApps3Adapter.getListModel(j).getKat_like_status());
                adapterview.putExtra("myfav", listKatApps3Adapter.getListModel(j).getKat_fav_status());
                adapterview.putExtra("width_img", listKatApps3Adapter.getListModel(j).getKat_img_width());
                adapterview.putExtra("height_img", listKatApps3Adapter.getListModel(j).getKat_img_height());
                adapterview.putExtra("type", listKatApps3Adapter.getListModel(j).getKat_type());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
        btn_komenlain.setOnClickListener(new android.view.View.OnClickListener() {

            final AppsByCategory this$0;

            public void onClick(View view)
            {
                view = new Intent(AppsByCategory.this, com/inponsel/android/v2/PlaystoreKategoriKomen);
                view.putExtra("id_kat", str_id);
                view.putExtra("type", str_category);
                view.putExtra("title", str_title_cat);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            getSupportMenuInflater().inflate(0x7f0f000f, menu);
        } else
        {
            getSupportMenuInflater().inflate(0x7f0f000f, menu);
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
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            onBackPressed();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            return true;

        case 2131429697: 
            userFunctions = new UserFunctions();
            break;
        }
        if (userFunctions.isUserLoggedIn(this))
        {
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(str_title_cat).append(" ?").toString();
            android.app.AlertDialog.Builder builder;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                menuitem = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(str_title_cat).append(" ?").toString();
            } else
            {
                statusKomen = "1";
                menuitem = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(str_title_cat).append(" ?").toString();
            }
            Log.e("statusKomen", statusKomen);
            builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Perhatian");
            builder.setMessage(menuitem);
            builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
            });
            builder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory this$0;

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
                this$0 = AppsByCategory.this;
                super();
            }
            });
            builder.show();
            return true;
        } else
        {
            menuitem = new android.app.AlertDialog.Builder(this);
            menuitem.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            menuitem.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
            });
            menuitem.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(AppsByCategory.this, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
            });
            menuitem.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(AppsByCategory.this, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = AppsByCategory.this;
                super();
            }
            });
            menuitem.show();
            return true;
        }
    }

    public void update(Observable observable, Object obj)
    {
        if (!ponselBaseApp.getObserver().getUpdateType().equals("liketl") && ponselBaseApp.getObserver().getUpdateType().equals("appskategorikom"))
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else
            {
                (new KomentarAsycTask()).execute(new String[0]);
            }
        }
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
        Log.e("ll_komentar", String.valueOf(ll_komentar.getChildCount()));
        i = 0;
_L2:
        ImageView imageview;
        ImageView imageview1;
        RelativeLayout relativelayout;
        Object obj;
        if (i >= ll_komentar.getChildCount())
        {
            return;
        }
        obj = ll_komentar.getChildAt(i);
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
