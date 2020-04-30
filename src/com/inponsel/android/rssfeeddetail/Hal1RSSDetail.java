// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
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
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.adapter.ItemRSSTag;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.details.DetailsPonsel;
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
import com.inponsel.android.v2.AddKomentarPicture;
import com.inponsel.android.v2.BaseDrawer;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RSSFeedByTag;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            ReplyKomRSSActivity, RSSDetailTab, RSSKomenTab

public class Hal1RSSDetail extends SherlockFragment
    implements Observer, android.view.animation.Animation.AnimationListener
{
    public class FavoritTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idrss=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(statFav).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
                parseJSONAddFav(res);
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
            ponselBaseApp.getObserver().setUpdateType("favrss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            if (postStatusAddRss.equals("1") || postStatusAddRss.equals("10"))
            {
                if (rss_img.equals(""))
                {
                    db.addRSS(id_rss, rss_portal, rss_img_ava, rss_title, rss_desc, rss_content, "", rss_srclink, rss_date, txtLikeKom.getText().toString(), total_komen, "");
                } else
                {
                    db.addRSS(id_rss, rss_portal, rss_img_ava, rss_title, rss_desc, rss_content, rss_img, rss_srclink, rss_date, txtLikeKom.getText().toString(), total_komen, "");
                }
            } else
            if (postStatusAddRss.equals("00") || postStatusAddRss.equals("0"))
            {
                Toast.makeText(getActivity(), "Berhasil menghapus", 1).show();
                db.deleteIDRSS(id_rss);
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    list_img_favorite.setBackgroundDrawable(drwStarGaris);
                } else
                {
                    list_img_favorite.setBackground(drwStarGaris);
                }
            } else
            if (res.equals("40404"))
            {
                mDialog.dismiss();
            } else
            {
                Toast.makeText(getActivity(), postMessageAddRss, 1).show();
            }
            mDialog.dismiss();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statFav.equals("1"))
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
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class KomentarAsycTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
            strKonekStat = jsonobject.getString("success");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            jum_komen = jsonobject.getString("total_komen");
            statusKomen = jsonobject.getString("statuskomen");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_332;
            }
            mArrayListData.clear();
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_332;
            }
            Object obj = Hal1RSSDetail.this;
            obj.countAllKom = ((Hal1RSSDetail) (obj)).countAllKom + 1;
            obj = Hal1RSSDetail.this;
            obj.countKomOld = ((Hal1RSSDetail) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_komrss"), ((JSONObject) (obj)).getString("id_rss"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komen_rss"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("top_id", top_id);
            int j;
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            progressbar_komen.setVisibility(4);
            mLinearListView.removeAllViewsInLayout();
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
                if (Integer.parseInt(jum_komen) == 3)
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
            final String id_rss;
            String s;
            final String komen_rss;
            final String tanggal_kom;
            String s1;
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
            txtLikeKomList = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like_list = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            id_rss = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
            s = ((ItemRSSKomen)mArrayListData.get(i)).getId_user();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user_to();
            komen_rss = ((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss();
            tanggal_kom = ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom();
            s1 = ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo();
            user_name = ((ItemRSSKomen)mArrayListData.get(i)).getUser_name();
            ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemRSSKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s2 = ((ItemRSSKomen)mArrayListData.get(i)).getImg_media();
            String s3 = ((ItemRSSKomen)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s2, s3);
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L5; else goto _L4
_L4:
            lay_quote.setVisibility(8);
_L9:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L7; else goto _L6
_L6:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like_list.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L10:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_2053;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L11:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKomList.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1);
            img_kom_picture.setOnLongClickListener(s1. new android.view.View.OnLongClickListener() {

                final KomentarAsycTask this$1;
                private final String val$user_photo;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(user_photo.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
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
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", id_user);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasyctask;
                id_user = String.this;
                super();
            }
            });
            list_lay_like_list.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$id_rss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
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
                        view = new android.app.AlertDialog.Builder(getActivity());
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                id_komrss = s;
                id_rss = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$id_rss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
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
                id_komrss = s;
                id_rss = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$id_rss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
                        view.putExtra("rss_title", rss_title);
                        view.putExtra("id_rss", id_rss);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal1RSSDetail.POST_STAT);
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
                id_rss = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$id_rss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
                        view.putExtra("rss_title", rss_title);
                        view.putExtra("id_rss", id_rss);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal1RSSDetail.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
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
                id_rss = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
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
                list_lay_like_list.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L10
            list_lay_like_list.setEnabled(true);
            list_lay_dislike.setEnabled(true);
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
        }


        public KomentarAsycTask()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class PostBagusKurangKomenTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_komen_rss.php?").append(querylike).toString();
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
            notificationLikeHelper.completed(rss_title, notificationLikeHelper.suclikefrontKomen);
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
                notificationLikeHelper.completed(rss_title, notificationLikeHelper.sucdislikefrontKomen);
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
                notificationLikeHelper.gagal(rss_title, postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal(rss_title, postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification(rss_title, notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification(rss_title, notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangKomenTask()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
            jum_komen = s.getString("total_komen");
            tot_LikeRSS = s.getString("total_like");
            totdis_LikeKom = s.getString("total_dislike");
            Log.e("tot_LikePon", tot_LikeRSS);
            Log.e("totdis_LikePon", totdis_LikeKom);
            ponselBaseApp.getObserver().setJum_komenLikeRSS(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeRSS(tot_LikeRSS);
            ponselBaseApp.getObserver().setIndexRSS(id_rss);
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_rss.php?").append(querylike).toString();
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
            Log.e("index_komposlike", tot_LikeRSS);
            ponselBaseApp.getObserver().setUpdateType("likerss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            Log.e("postStatusLikeKom", postStatusLikeKom);
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_203;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_154;
            }
            notificationLikeHelper.completed("Berita RSS", notificationLikeHelper.suclikefrontKomen);
_L1:
            txtLikeKom.setText(tot_LikeRSS);
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                list_img_like.setBackgroundDrawable(drwLoveFull);
                return;
            }
            break MISSING_BLOCK_LABEL_185;
            try
            {
                notificationLikeHelper.completed("Berita RSS", notificationLikeHelper.sucdislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L1
            list_img_like.setBackground(drwLoveFull);
            return;
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal("Berita RSS", notificationLikeHelper.gaglikefrontKomen);
                return;
            }
            notificationLikeHelper.gagal("Berita RSS", notificationLikeHelper.gagdislikefrontKomen);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("Berita RSS", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("Berita RSS", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class PostHits extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
            if (!userFunctions.isUserLoggedIn(getActivity())) goto _L2; else goto _L1
_L1:
            Object obj = user_id;
_L8:
            avoid = (new StringBuilder("idrss=")).append(id_rss).append("&user=").append(((String) (obj))).append("&hits=1&t=").append(t).toString();
            HttpPush.getResponse((new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("hits_rss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString()).toString().trim().replaceAll("\\s+", "");
_L6:
            return null;
_L2:
            obj = avoid;
            Account aaccount[] = AccountManager.get(getActivity()).getAccounts();
            obj = avoid;
            int j = aaccount.length;
            int i = 0;
_L4:
            Object obj1;
            Account account;
            obj = avoid;
            if (i >= j)
            {
                continue; /* Loop/switch isn't completed */
            }
            account = aaccount[i];
            obj1 = avoid;
            obj = avoid;
            if (!account.name.endsWith("gmail.com"))
            {
                break MISSING_BLOCK_LABEL_225;
            }
            obj = avoid;
            obj1 = account.name;
            i++;
            avoid = ((Void []) (obj1));
            if (true) goto _L4; else goto _L3
_L3:
            avoid;
            avoid.printStackTrace();
            if (true) goto _L6; else goto _L5
_L5:
            avoid;
            if (true) goto _L8; else goto _L7
_L7:
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
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
    {

        final Hal1RSSDetail this$0;

        private void parseJSONKom(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                statusKomen = s.getString("statuskomen");
                tot_LikePon = s.getString("total_like");
                totdis_LikePon = s.getString("total_dislike");
                jum_komen = s.getString("total_komen");
                ponselBaseApp.getObserver().setJum_komenLikeRSS(jum_komen);
                ponselBaseApp.getObserver().setTot_LikeRSS(tot_LikePon);
                Log.e("id_rss", id_rss);
                ponselBaseApp.getObserver().setIndexRSS(id_rss);
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("plus_kom_rss").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
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
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            ponselBaseApp.getObserver().setUpdateType("komentarrss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            btn_send_komen.setEnabled(true);
            edt_pop_komen.setEnabled(true);
            edt_pop_komen.setTextColor(Color.parseColor("#000000"));
            Log.e("postStatus", postStatus);
            if (postStatus.equals("1"))
            {
                mNotificationHelper.completed(rss_title, mNotificationHelper.SucdiskomStatement);
                edt_pop_komen.setText("");
                try
                {
                    urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_rss3").append(Utility.BASE_FORMAT).append("?id_rss=").append(id_rss).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append("12").toString();
                    Log.e("urlKomen3", urlKomen);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                } else
                {
                    (new KomentarAsycTask()).execute(new String[0]);
                }
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
            if (postStatus.equals("040"))
            {
                mNotificationHelper.gagal(rss_title, postMessage);
                return;
            } else
            {
                mNotificationHelper.gagal(rss_title, mNotificationHelper.gagalkomStatement);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setEnabled(false);
            edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
            mNotificationHelper.createNotification(rss_title, mNotificationHelper.komenPostWords);
        }

        public PostKomen()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    private class RSSTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataRSS, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_989;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    Log.e("suc", suc);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    show_popup = true;
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_1006;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    show_popup = true;
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_1006;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_1006;
            }
            avoid = inponsel.getJSONObject(i);
            str_id = avoid.getString("id");
            str_rssid = avoid.getString("rss_id");
            str_sumber = avoid.getString("rss_portal");
            str_title = avoid.getString("rss_title");
            str_tanggal = avoid.getString("rss_date");
            str_content = avoid.getString("rss_content");
            str_srclink = avoid.getString("rss_srclink");
            rss_srclink = str_srclink;
            str_detlink = avoid.getString("rss_detlink");
            str_imgurl = avoid.getString("rss_img");
            rss_img = avoid.getString("rss_img");
            count_img = avoid.getInt("rss_img_count");
            tag_brands = avoid.getString("rss_tag_brands");
            tag_brands_subs = avoid.getString("rss_tag_brand_subs");
            tag_devices = avoid.getString("rss_tag_hp");
            tag_devices_subs = avoid.getString("rss_tag_hp_subs");
            tag_general = avoid.getString("rss_tag_general");
            tag_general_subs = avoid.getString("rss_tag_general_subs");
            tag_operators = avoid.getString("rss_tag_opr");
            tag_operators_subs = avoid.getString("rss_tag_op_subs");
            tag_os = avoid.getString("rss_tag_os");
            tag_os_subs = avoid.getString("rss_tag_os_subs");
            rss_general = avoid.getString("rss_general");
            rss_brands = avoid.getString("rss_brands");
            rss_devices = avoid.getString("rss_hp");
            rss_operators = avoid.getString("rss_opr");
            rss_os = avoid.getString("rss_os");
            rss_hpid = avoid.getString("rss_hp_id");
            Log.e("rss_devices", rss_devices);
            if (!rss_brands.equals(""))
            {
                arr_rss_brands = rss_brands.split("\\s*,\\s*");
                arr_tag_brands = tag_brands.split("\\s*,\\s*");
                arr_tag_brand_subs = tag_brands_subs.split("\\s*,\\s*");
            }
            if (!rss_devices.equals(""))
            {
                arr_rss_devices = rss_devices.split("\\s*,\\s*");
                arr_tag_devices = tag_devices.split("\\s*,\\s*");
                arr_rss_hpsid = rss_hpid.split("\\s*,\\s*");
                arr_tag_hp_subs = tag_devices_subs.split("\\s*,\\s*");
            }
            Log.e("tag_general", tag_general);
            Log.e("rss_general", rss_general);
            if (!tag_general.equals(""))
            {
                arr_rss_general = rss_general.split("\\s*,,\\s*");
                arr_tag_general = tag_general.split("\\s*,\\s*");
                arr_tag_general_subs = tag_general_subs.split("\\s*,\\s*");
            }
            if (!rss_operators.equals(""))
            {
                arr_rss_operators = rss_operators.split("\\s*,\\s*");
                arr_tag_operators = tag_operators.split("\\s*,\\s*");
                arr_tag_op_subs = tag_operators_subs.split("\\s*,\\s*");
            }
            if (!rss_os.equals(""))
            {
                arr_rss_os = rss_os.split("\\s*,\\s*");
                arr_tag_os = tag_os.split("\\s*,\\s*");
                arr_tag_os_subs = tag_os_subs.split("\\s*,\\s*");
            }
            total_like = avoid.getJSONObject("likedislike").getString("total_like");
            total_komen = avoid.getJSONObject("likedislike").getString("total_komen");
            like_stat = avoid.getJSONObject("likedislike").getString("my_like_rss");
            fav_stat = avoid.getJSONObject("likedislike").getString("my_fav_rss");
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            show_popup = true;
            Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            progressbar_middle.setVisibility(8);
            layout_empty.setVisibility(8);
            if (show_popup)
            {
                show_popup("Perhatian", "Berita tidak tersedia");
            } else
            {
                Log.e("str_id", str_id);
            }
            if (count_img == 0)
            {
                btn_tampilkan_gambar.setVisibility(8);
            } else
            {
                btn_tampilkan_gambar.setVisibility(0);
            }
            beritaTerkaitList();
            if (!like_stat.equals("1")) goto _L2; else goto _L1
_L1:
            if (android.os.Build.VERSION.SDK_INT >= 16) goto _L4; else goto _L3
_L3:
            list_img_like.setBackgroundDrawable(drwLoveFull);
_L9:
            list_img_like.setEnabled(false);
_L10:
            if (!fav_stat.equals("1")) goto _L6; else goto _L5
_L5:
            if (android.os.Build.VERSION.SDK_INT >= 16) goto _L8; else goto _L7
_L7:
            list_img_favorite.setBackgroundDrawable(drwStarFull);
_L12:
            txtLikeKom.setText(total_like);
            txtSumber.setText(str_sumber);
            txtRssTanggal.setText(Utility.convertDate(str_tanggal));
            Log.e("rss_content", str_content);
            web_rss_srclink.getSettings().setJavaScriptEnabled(true);
            web_rss_srclink.loadDataWithBaseURL("", (new StringBuilder("<style>img{display: inline;height: auto;max-width: 100%;} iframe{display: inline;height: auto;max-width: 100%;}</style>")).append(str_content).toString(), "text/html", "UTF-8", "");
            txt_rss_srclink.setText(str_srclink);
            txt_rss_title.setText(Html.fromHtml(str_title));
            return;
_L4:
            try
            {
                list_img_like.setBackground(drwLoveFull);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L9
_L2:
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                break MISSING_BLOCK_LABEL_430;
            }
            list_img_like.setBackgroundDrawable(drwLoveGaris);
_L11:
            list_img_like.setEnabled(true);
              goto _L10
            list_img_like.setBackground(drwLoveGaris);
              goto _L11
_L8:
            list_img_favorite.setBackground(drwStarFull);
              goto _L12
_L6:
label0:
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    break label0;
                }
                list_img_favorite.setBackgroundDrawable(drwStarGaris);
            }
              goto _L12
            list_img_favorite.setBackground(drwStarGaris);
              goto _L12
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Hal1RSSDetail hal1rssdetail = Hal1RSSDetail.this;
            int i = hal1rssdetail.countertask;
            hal1rssdetail.countertask = i + 1;
            Log.e("counter task", String.valueOf(i));
            progressbar_middle.setVisibility(0);
            layout_empty.setVisibility(0);
        }

        private RSSTask()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }

        RSSTask(RSSTask rsstask)
        {
            this();
        }
    }

    private class RSSTaskDB extends AsyncTask
    {

        final Hal1RSSDetail this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataRSS, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_958;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    Log.e("suc", suc);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_967;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_967;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_967;
            }
            avoid = inponsel.getJSONObject(i);
            str_id = avoid.getString("id");
            str_rssid = avoid.getString("rss_id");
            str_sumber = avoid.getString("rss_portal");
            str_title = avoid.getString("rss_title");
            str_tanggal = avoid.getString("rss_date");
            str_content = avoid.getString("rss_content");
            str_srclink = avoid.getString("rss_srclink");
            str_detlink = avoid.getString("rss_detlink");
            str_imgurl = avoid.getString("rss_img");
            count_img = avoid.getInt("rss_img_count");
            rss_img = avoid.getString("rss_img");
            tag_brands = avoid.getString("rss_tag_brands");
            tag_brands_subs = avoid.getString("rss_tag_brand_subs");
            tag_devices = avoid.getString("rss_tag_hp");
            tag_devices_subs = avoid.getString("rss_tag_hp_subs");
            tag_general = avoid.getString("rss_tag_general");
            tag_general_subs = avoid.getString("rss_tag_general_subs");
            tag_operators = avoid.getString("rss_tag_opr");
            tag_operators_subs = avoid.getString("rss_tag_op_subs");
            tag_os = avoid.getString("rss_tag_os");
            tag_os_subs = avoid.getString("rss_tag_os_subs");
            rss_general = avoid.getString("rss_general");
            rss_brands = avoid.getString("rss_brands");
            rss_devices = avoid.getString("rss_hp");
            rss_operators = avoid.getString("rss_opr");
            rss_os = avoid.getString("rss_os");
            rss_hpid = avoid.getString("rss_hp_id");
            Log.e("rss_devices", rss_devices);
            if (!rss_brands.equals(""))
            {
                arr_rss_brands = rss_brands.split("\\s*,\\s*");
                arr_tag_brands = tag_brands.split("\\s*,\\s*");
                arr_tag_brand_subs = tag_brands_subs.split("\\s*,\\s*");
            }
            if (!rss_devices.equals(""))
            {
                arr_rss_devices = rss_devices.split("\\s*,\\s*");
                arr_tag_devices = tag_devices.split("\\s*,\\s*");
                arr_rss_hpsid = rss_hpid.split("\\s*,\\s*");
                arr_tag_hp_subs = tag_devices_subs.split("\\s*,\\s*");
            }
            Log.e("tag_general", tag_general);
            Log.e("rss_general", rss_general);
            if (!tag_general.equals(""))
            {
                arr_rss_general = rss_general.split("\\s*,,\\s*");
                arr_tag_general = tag_general.split("\\s*,\\s*");
                arr_tag_general_subs = tag_general_subs.split("\\s*,\\s*");
            }
            if (!rss_operators.equals(""))
            {
                arr_rss_operators = rss_operators.split("\\s*,\\s*");
                arr_tag_operators = tag_operators.split("\\s*,\\s*");
                arr_tag_op_subs = tag_operators_subs.split("\\s*,\\s*");
            }
            if (!rss_os.equals(""))
            {
                arr_rss_os = rss_os.split("\\s*,\\s*");
                arr_tag_os = tag_os.split("\\s*,\\s*");
                arr_tag_os_subs = tag_os_subs.split("\\s*,\\s*");
            }
            total_like = avoid.getJSONObject("likedislike").getString("total_like");
            total_komen = avoid.getJSONObject("likedislike").getString("total_komen");
            like_stat = avoid.getJSONObject("likedislike").getString("my_like_rss");
            fav_stat = avoid.getJSONObject("likedislike").getString("my_fav_rss");
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            progressbar_middle.setVisibility(8);
            layout_empty.setVisibility(8);
            beritaTerkaitList();
            if (!like_stat.equals("1")) goto _L2; else goto _L1
_L1:
            if (android.os.Build.VERSION.SDK_INT >= 16) goto _L4; else goto _L3
_L3:
            list_img_like.setBackgroundDrawable(drwLoveFull);
_L9:
            list_img_like.setEnabled(false);
_L10:
            if (!fav_stat.equals("1")) goto _L6; else goto _L5
_L5:
            if (android.os.Build.VERSION.SDK_INT >= 16) goto _L8; else goto _L7
_L7:
            list_img_favorite.setBackgroundDrawable(drwStarFull);
_L12:
            txtLikeKom.setText(total_like);
            txtSumber.setText(str_sumber);
            txtRssTanggal.setText(Utility.convertDate(str_tanggal));
            Log.e("rss_content", str_content);
            web_rss_srclink.getSettings().setJavaScriptEnabled(true);
            web_rss_srclink.loadDataWithBaseURL("", (new StringBuilder("<style>img{display: inline;height: auto;max-width: 100%;} iframe{display: inline;height: auto;max-width: 100%;}</style>")).append(str_content).toString(), "text/html", "UTF-8", "");
            txt_rss_srclink.setText(str_srclink);
            txt_rss_title.setText(str_title);
            return;
_L4:
            try
            {
                list_img_like.setBackground(drwLoveFull);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L9
_L2:
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                break MISSING_BLOCK_LABEL_352;
            }
            list_img_like.setBackgroundDrawable(drwLoveGaris);
_L11:
            list_img_like.setEnabled(true);
              goto _L10
            list_img_like.setBackground(drwLoveGaris);
              goto _L11
_L8:
            list_img_favorite.setBackground(drwStarFull);
              goto _L12
_L6:
label0:
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    break label0;
                }
                list_img_favorite.setBackgroundDrawable(drwStarGaris);
            }
              goto _L12
            list_img_favorite.setBackground(drwStarGaris);
              goto _L12
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private RSSTaskDB()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }

        RSSTaskDB(RSSTaskDB rsstaskdb)
        {
            this();
        }
    }

    public class RSSTerkaitAsycTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("RSSTerkaitAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
            Log.e("RSSTerkaitAsycTask", String.valueOf(jsonobject));
            as = jsonobject.getJSONArray("InPonsel");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_261;
            }
            mArrayListRSSData.clear();
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_261;
            }
            Object obj = Hal1RSSDetail.this;
            obj.countAllKom = ((Hal1RSSDetail) (obj)).countAllKom + 1;
            obj = Hal1RSSDetail.this;
            obj.countKomOld = ((Hal1RSSDetail) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListRSSData.add(new ItemRSS(((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), "", "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), "", ((JSONObject) (obj)).getString("rss_img"), "", "", "", "", ""));
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
            if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
            int i = 0;
_L5:
            if (i >= mArrayListRSSData.size())
            {
                return;
            }
            final String id_rss;
            final String rss_id;
            String s;
            void1 = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300c7, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
            txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
            id_rss = (ImageView)void1.findViewById(0x7f0b054f);
            id_rss = (ImageView)void1.findViewById(0x7f0b0552);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_rss = ((ItemRSS)mArrayListRSSData.get(i)).getId();
            rss_id = ((ItemRSS)mArrayListRSSData.get(i)).getRss_id();
            s = ((ItemRSS)mArrayListRSSData.get(i)).getRss_title();
            String s1 = ((ItemRSS)mArrayListRSSData.get(i)).getRss_portal();
            String s2 = ((ItemRSS)mArrayListRSSData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_content();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_srclink();
            String s3 = ((ItemRSS)mArrayListRSSData.get(i)).getRss_date();
            String s4 = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img_ava();
            String s5 = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_like();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_like_stat();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_komen();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_fav_stat();
            txtTitle.setText(Html.fromHtml(s));
            txtIdKom.setText(id_rss);
            txtUsername.setText((new StringBuilder(String.valueOf(s1))).append(" - ").append(s3).toString());
            txtImgAva.setText(s4);
            txtImgMedia.setText(s5);
            txtKomentar.setText((new StringBuilder()).append(Html.fromHtml(Utility.parseUrl(s2))).toString());
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtKomentar.setVisibility(8);
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListRSSData.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            if (!((ItemRSS)mArrayListRSSData.get(i)).getRss_img().trim().equals("") && !((ItemRSS)mArrayListRSSData.get(i)).getRss_img().trim().equals("http://inponsel.co.id/cache/image/fit/50/aHR0cDovL3N0YXRpYy5pbnBvbnNlbC5jby5pZC9pbWFnZXMvbG9nby9sb2dvLW5vLWJvcmRlci1ncmV5LnBuZw=="))
            {
                break MISSING_BLOCK_LABEL_929;
            }
            imageMedia.setVisibility(0);
            imageMedia.setImageResource(0x7f020243);
_L3:
            txtWaktu.setText(((ItemRSS)mArrayListRSSData.get(i)).getRss_date());
            listBerita.addView(void1);
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSTerkaitAsycTask this$1;
                private final String val$id_rss;
                private final String val$rss_id;
                private final String val$rss_title;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("id_rss", rss_id);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("notif", "gcm");
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("act", "firsttab");
                    getActivity().startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_rssterkaitasyctask;
                id_rss = s;
                rss_id = s1;
                rss_title = String.this;
                super();
            }
            });
            i++;
            continue; /* Loop/switch isn't completed */
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListRSSData.get(i)).getRss_img().toString().trim()).toString(), imageMedia, options, animateFirstListener);
              goto _L3
            void1;
_L2:
            return;
            if (true) goto _L5; else goto _L4
_L4:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSTerkaitAsycTask", "onPreExecute");
        }


        public RSSTerkaitAsycTask()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_comrss").append(Utility.BASE_FORMAT).append("?").append(querylike).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_rss").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURLsubscribe", avoid);
                avoid = HttpPush.getResponse(avoid);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                avoid = avoid.toString();
                Log.e("url ", avoid);
                parseJSONSubsNews(avoid);
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
            if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10")) goto _L2; else goto _L1
_L1:
            Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
            if (!type.equals("general")) goto _L4; else goto _L3
_L3:
            int i;
            Log.e("tag_id", String.valueOf(mLinearListViewRSSGenTag.getChildCount()));
            i = 0;
_L9:
            if (i < mLinearListViewRSSGenTag.getChildCount()) goto _L6; else goto _L5
_L5:
            mDialog.dismiss();
            return;
_L6:
            Object obj = mLinearListViewRSSGenTag.getChildAt(i);
            void1 = (TextView)((View) (obj)).findViewById(0x7f0b0774);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0775);
            ((ImageView)((View) (obj)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
            obj = (Button)((View) (obj)).findViewById(0x7f0b0771);
            ((Button) (obj)).setVisibility(0);
            Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
            if (void1.getText().toString().equals(tag_id))
            {
                if (subs_status.equals("1"))
                {
                    textview.setText("1");
                    ((Button) (obj)).setBackground(drwKurang);
                } else
                {
                    textview.setText("0");
                    ((Button) (obj)).setBackground(drw);
                }
            }
            i++;
            continue; /* Loop/switch isn't completed */
_L4:
            if (type.equals("brand"))
            {
                Log.e("tag_id", String.valueOf(mLinearListViewRSSBrandTag.getChildCount()));
                int j = 0;
                while (j < mLinearListViewRSSBrandTag.getChildCount()) 
                {
                    Object obj1 = mLinearListViewRSSBrandTag.getChildAt(j);
                    void1 = (TextView)((View) (obj1)).findViewById(0x7f0b0774);
                    TextView textview1 = (TextView)((View) (obj1)).findViewById(0x7f0b0775);
                    ((ImageView)((View) (obj1)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                    obj1 = (Button)((View) (obj1)).findViewById(0x7f0b0771);
                    ((Button) (obj1)).setVisibility(0);
                    Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                    if (void1.getText().toString().equals(tag_id))
                    {
                        if (subs_status.equals("1"))
                        {
                            textview1.setText("1");
                            ((Button) (obj1)).setBackground(drwKurang);
                        } else
                        {
                            textview1.setText("0");
                            ((Button) (obj1)).setBackground(drw);
                        }
                    }
                    j++;
                }
            } else
            if (type.equals("os"))
            {
                Log.e("tag_id", String.valueOf(mLinearListViewRSSOSTag.getChildCount()));
                int k = 0;
                while (k < mLinearListViewRSSOSTag.getChildCount()) 
                {
                    Object obj2 = mLinearListViewRSSOSTag.getChildAt(k);
                    void1 = (TextView)((View) (obj2)).findViewById(0x7f0b0774);
                    TextView textview2 = (TextView)((View) (obj2)).findViewById(0x7f0b0775);
                    ((ImageView)((View) (obj2)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                    obj2 = (Button)((View) (obj2)).findViewById(0x7f0b0771);
                    ((Button) (obj2)).setVisibility(0);
                    Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                    if (void1.getText().toString().equals(tag_id))
                    {
                        if (subs_status.equals("1"))
                        {
                            textview2.setText("1");
                            ((Button) (obj2)).setBackground(drwKurang);
                        } else
                        {
                            textview2.setText("0");
                            ((Button) (obj2)).setBackground(drw);
                        }
                    }
                    k++;
                }
            } else
            {
                if (!type.equals("op"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                Log.e("tag_id", String.valueOf(mLinearListViewRSSOprTag.getChildCount()));
                int l = 0;
                while (l < mLinearListViewRSSOprTag.getChildCount()) 
                {
                    Object obj3 = mLinearListViewRSSOprTag.getChildAt(l);
                    void1 = (TextView)((View) (obj3)).findViewById(0x7f0b0774);
                    TextView textview3 = (TextView)((View) (obj3)).findViewById(0x7f0b0775);
                    ((ImageView)((View) (obj3)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                    obj3 = (Button)((View) (obj3)).findViewById(0x7f0b0771);
                    ((Button) (obj3)).setVisibility(0);
                    Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                    if (void1.getText().toString().equals(tag_id))
                    {
                        if (subs_status.equals("1"))
                        {
                            textview3.setText("1");
                            ((Button) (obj3)).setBackground(drwKurang);
                        } else
                        {
                            textview3.setText("0");
                            ((Button) (obj3)).setBackground(drw);
                        }
                    }
                    l++;
                }
            }
            continue; /* Loop/switch isn't completed */
            if (!type.equals("hp")) goto _L5; else goto _L7
_L7:
            Log.e("tag_id", String.valueOf(mLinearListViewRSSHPTag.getChildCount()));
            int i1 = 0;
            while (i1 < mLinearListViewRSSHPTag.getChildCount()) 
            {
                Object obj4 = mLinearListViewRSSHPTag.getChildAt(i1);
                void1 = (TextView)((View) (obj4)).findViewById(0x7f0b0774);
                TextView textview4 = (TextView)((View) (obj4)).findViewById(0x7f0b0775);
                ((ImageView)((View) (obj4)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                obj4 = (Button)((View) (obj4)).findViewById(0x7f0b0771);
                ((Button) (obj4)).setVisibility(0);
                Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                if (void1.getText().toString().equals(tag_id))
                {
                    if (subs_status.equals("1"))
                    {
                        textview4.setText("1");
                        ((Button) (obj4)).setBackground(drwKurang);
                    } else
                    {
                        textview4.setText("0");
                        ((Button) (obj4)).setBackground(drw);
                    }
                }
                i1++;
            }
            if (true) goto _L5; else goto _L2
_L2:
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
                statSubNews.equals("1");
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
            return;
            if (true) goto _L9; else goto _L8
_L8:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (subs_status.equals("1"))
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
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final Hal1RSSDetail this$0;

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
            itemTurnNotif.setEnabled(false);
        }

        public TurnOnOffNotifTask()
        {
            this$0 = Hal1RSSDetail.this;
            super();
        }
    }


    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static int POST_STAT = 0;
    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    public static Uri dataurlemail;
    String actfrom;
    private ImageLoadingListener animateFirstListener;
    String arr_rss_brands[];
    String arr_rss_devices[];
    String arr_rss_general[];
    String arr_rss_hpsid[];
    String arr_rss_operators[];
    String arr_rss_os[];
    String arr_tag_brand_subs[];
    String arr_tag_brands[];
    String arr_tag_devices[];
    String arr_tag_general[];
    String arr_tag_general_subs[];
    String arr_tag_hp_subs[];
    String arr_tag_op_subs[];
    String arr_tag_operators[];
    String arr_tag_os[];
    String arr_tag_os_subs[];
    String bottom_id;
    LinearLayout bottom_list;
    Button btnSourceLink;
    Button btn_komen_pic;
    Button btn_komenlain;
    Button btn_pop_login;
    Button btn_send_komen;
    Button btn_tampilkan_gambar;
    CallbackManager callbackManager;
    int charCount;
    int countAllKom;
    int countKomOld;
    int count_img;
    int countertask;
    Cursor curRSS;
    Cursor cursor;
    String dataNotifOnOff;
    String dataRSS;
    DatabaseHandler db;
    String details;
    Drawable drw;
    Drawable drwCopas;
    Drawable drwKurang;
    Drawable drwLoveFull;
    Drawable drwLoveGaris;
    Drawable drwShare;
    Drawable drwStarFull;
    Drawable drwStarGaris;
    Drawable drwUrl;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    String fav_stat;
    LinearLayout headName;
    String host;
    String id_rss;
    String id_subs;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imageMedia;
    ImageView imgCopas;
    ImageView imgKomentar;
    ImageView imgKomentar_rep;
    ImageView imgRSS;
    ImageView imgShare;
    ImageView imgWeblink;
    ImageView img_kom_picture;
    ImageView img_kontenarrow;
    InputMethodManager imm;
    JSONArray inponsel;
    MenuItem itemTurnNotif;
    JSONArray jArray;
    String jum_komen;
    String kategori_tag;
    String kmail_stat;
    String komencount;
    LinearLayout lay_RSS;
    RelativeLayout lay_pop_komen;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    String like_stat;
    LinearLayout listBerita;
    ImageView list_img_favorite;
    ImageView list_img_like;
    RelativeLayout list_lay_copas;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_favorite;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    RelativeLayout list_lay_like_list;
    RelativeLayout list_lay_rep;
    RelativeLayout list_lay_share;
    RelativeLayout list_lay_weblink;
    RelativeLayout ll_img_komen;
    RelativeLayout ll_img_komen_rep;
    LinearLayout ll_kontenlain;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    private ArrayList mArrayListDataTagBrandRSS;
    private ArrayList mArrayListDataTagGenRSS;
    private ArrayList mArrayListDataTagHPRSS;
    private ArrayList mArrayListDataTagHPSpekRSS;
    private ArrayList mArrayListDataTagOSRSS;
    private ArrayList mArrayListDataTagOprRSS;
    private ArrayList mArrayListRSSData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListView;
    private LinearLayout mLinearListViewRSSBrandTag;
    private LinearLayout mLinearListViewRSSGenTag;
    private LinearLayout mLinearListViewRSSHPSpekTag;
    private LinearLayout mLinearListViewRSSHPTag;
    private LinearLayout mLinearListViewRSSOSTag;
    private LinearLayout mLinearListViewRSSOprTag;
    NotificationKomenHelper mNotificationHelper;
    Menu mainMenu;
    String messageNotif;
    LinearLayout myrootlinlist;
    String nama_asli;
    String notif;
    NotificationLikeRSSHelper notificationLikeHelper;
    private DisplayImageOptions options;
    String passlam;
    PonselBaseApp ponselBaseApp;
    TextView pop_txtCountKomen;
    String postMessage;
    String postMessageAddRss;
    String postMessageLikeKom;
    String postMessageSubsNews;
    String postStatus;
    String postStatusAddRss;
    String postStatusLikeKom;
    String postStatusSubsNews;
    ProgressBar progressbar_imgkomen;
    ProgressBar progressbar_imgkomenrep;
    ProgressBar progressbar_komen;
    ProgressBar progressbar_middle;
    String query;
    String querylike;
    String querypopkomen;
    String res;
    String reslike;
    String rss_brands;
    String rss_content;
    String rss_date;
    String rss_desc;
    String rss_devices;
    String rss_general;
    String rss_hpid;
    String rss_id;
    String rss_img;
    String rss_img_ava;
    String rss_operators;
    String rss_os;
    String rss_portal;
    String rss_srclink;
    String rss_title;
    String scheme;
    ShareDialog shareDialog;
    boolean show_popup;
    String statFav;
    String statSubNews;
    String statusKomen;
    String statuslike;
    String strJsonRssRep;
    String strKonekStat;
    String str_content;
    String str_desc;
    String str_detlink;
    String str_id;
    String str_imgurl;
    String str_rssid;
    String str_srclink;
    String str_sumber;
    String str_tanggal;
    String str_title;
    String subs_status;
    String subs_status_push;
    String suc;
    String succesStat;
    String t;
    String tag_brands;
    String tag_brands_subs;
    String tag_devices;
    String tag_devices_subs;
    String tag_general;
    String tag_general_subs;
    String tag_id;
    String tag_operators;
    String tag_operators_subs;
    String tag_os;
    String tag_os_subs;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String tot_LikeRSS;
    String total_komen;
    String total_like;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLabelKomentar;
    TextView txtLikeKom;
    TextView txtLikeKomList;
    TextView txtRssTanggal;
    TextView txtSumber;
    TextView txtTanggapan;
    TextView txtTapImage;
    TextView txtTapImageRep;
    TextView txtTitle;
    TextView txtTotalKom;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_empty_komen;
    TextView txt_rss_srclink;
    TextView txt_rss_title;
    TextView txtdisLikeKom;
    TextView txtfavoriteKom;
    TextView txtweblinkKom;
    String type;
    String type_tag;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    String urlRSS;
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
    WebView web_rss_srclink;
    ContextThemeWrapper wrapperLight;

    public Hal1RSSDetail()
    {
        inponsel = null;
        suc = "";
        countertask = 0;
        animateFirstListener = new AnimateFirstDisplayListener();
        show_popup = false;
        count_img = 0;
        actfrom = "";
        statSubNews = "";
        id_subs = "";
        type = "";
        type_tag = "";
        rss_img = "";
        urlRSS = "";
        t = Utility.session(RestClient.pelihara);
        komencount = "";
        querypopkomen = "";
        postStatus = "";
        postMessage = "";
        statusKomen = "";
        tot_LikeRSS = "0";
        totdis_LikeKom = "0";
        tot_LikePon = "";
        jum_komen = "0";
        tot_LikeKom = "0";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        dataNotifOnOff = "0";
        kmail_stat = "";
        messageNotif = "";
        user_id = "";
        user_photo = "";
        username = "";
        nama_asli = "";
        email_user = "";
        user_ttl = "";
        user_kota = "";
        user_provinsi = "";
        user_jekel = "";
        user_ponsel1 = "";
        user_ponsel2 = "";
        user_provider1 = "";
        user_provider2 = "";
        user_joindate = "";
        user_profile_update = "";
        querylike = "";
        postStatusAddRss = "";
        postMessageAddRss = "";
        tag_general = "";
        arr_tag_general = new String[0];
        tag_general_subs = "";
        arr_tag_general_subs = new String[0];
        tag_os = "";
        arr_tag_os = new String[0];
        tag_os_subs = "";
        arr_tag_os_subs = new String[0];
        tag_brands = "";
        arr_tag_brands = new String[0];
        tag_brands_subs = "";
        arr_tag_brand_subs = new String[0];
        tag_devices = "";
        arr_tag_devices = new String[0];
        tag_devices_subs = "";
        arr_tag_hp_subs = new String[0];
        tag_operators = "";
        arr_tag_operators = new String[0];
        tag_operators_subs = "";
        arr_tag_op_subs = new String[0];
        rss_general = "";
        arr_rss_general = new String[0];
        rss_os = "";
        arr_rss_os = new String[0];
        rss_brands = "";
        arr_rss_brands = new String[0];
        rss_devices = "";
        arr_rss_devices = new String[0];
        rss_operators = "";
        arr_rss_operators = new String[0];
        rss_hpid = "";
        arr_rss_hpsid = new String[0];
        subs_status_push = "";
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strJsonRssRep = "";
        strKonekStat = "";
        bottom_id = "";
        top_id = "0";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        query = "";
        tag_id = "";
        subs_status = "";
    }

    private void beritaTerkaitList()
    {
        mArrayListDataTagHPSpekRSS = new ArrayList();
        mArrayListDataTagGenRSS = new ArrayList();
        mArrayListDataTagBrandRSS = new ArrayList();
        mArrayListDataTagHPRSS = new ArrayList();
        mArrayListDataTagOprRSS = new ArrayList();
        mArrayListDataTagOSRSS = new ArrayList();
        Log.e("arr_rss_brands.length", String.valueOf(arr_rss_brands.length));
        Log.e("arr_rss_devices.length", String.valueOf(arr_rss_devices.length));
        Log.e("arr_rss_general.length", String.valueOf(arr_rss_general.length));
        Log.e("arr_rss_operators.length", String.valueOf(arr_rss_operators.length));
        Log.e("arr_rss_os.length", String.valueOf(arr_rss_os.length));
        if (arr_rss_brands.length != 0 || arr_rss_devices.length != 0 || arr_rss_general.length != 0 || arr_rss_operators.length != 0 || arr_rss_os.length != 0) goto _L2; else goto _L1
_L1:
        myrootlinlist.setVisibility(8);
_L29:
        return;
_L2:
        myrootlinlist.setVisibility(0);
        Log.e("arr_rss_general", String.valueOf(arr_rss_general.length));
        if (arr_rss_general.length == 0) goto _L4; else goto _L3
_L3:
        int i;
        mArrayListDataTagGenRSS.clear();
        mLinearListViewRSSGenTag.removeAllViewsInLayout();
        mArrayListDataTagBrandRSS.clear();
        mArrayListDataTagHPRSS.clear();
        mArrayListDataTagHPSpekRSS.clear();
        mArrayListDataTagOprRSS.clear();
        mLinearListViewRSSOprTag.removeAllViewsInLayout();
        mArrayListDataTagOSRSS.clear();
        mLinearListViewRSSOSTag.removeAllViewsInLayout();
        i = 0;
_L36:
        if (i < arr_tag_general.length) goto _L6; else goto _L5
_L5:
        Log.e("mArrayListDataTagGenRSS", String.valueOf(mArrayListDataTagGenRSS.size()));
        i = 0;
_L37:
        int j = arr_tag_general.length;
        if (i < j) goto _L7; else goto _L4
_L4:
        if (arr_rss_devices.length == 0) goto _L9; else goto _L8
_L8:
        i = 0;
_L39:
        if (i < arr_rss_devices.length) goto _L11; else goto _L10
_L10:
        i = 0;
_L40:
        j = mArrayListDataTagHPRSS.size();
        if (i < j) goto _L12; else goto _L9
_L9:
        if (arr_rss_devices.length == 0) goto _L14; else goto _L13
_L13:
        i = 0;
_L42:
        if (i < arr_rss_hpsid.length) goto _L16; else goto _L15
_L15:
        i = 0;
_L43:
        j = mArrayListDataTagHPSpekRSS.size();
        if (i < j) goto _L17; else goto _L14
_L14:
        if (arr_rss_brands.length == 0) goto _L19; else goto _L18
_L18:
        i = 0;
_L44:
        if (i < arr_rss_brands.length) goto _L21; else goto _L20
_L20:
        i = 0;
_L45:
        j = mArrayListDataTagBrandRSS.size();
        if (i < j) goto _L22; else goto _L19
_L19:
        if (arr_rss_operators.length == 0) goto _L24; else goto _L23
_L23:
        i = 0;
_L47:
        if (i < arr_rss_operators.length) goto _L26; else goto _L25
_L25:
        i = 0;
_L48:
        j = mArrayListDataTagOprRSS.size();
        if (i < j) goto _L27; else goto _L24
_L24:
        if (arr_rss_os.length == 0) goto _L29; else goto _L28
_L28:
        i = 0;
_L50:
        if (i < arr_rss_os.length) goto _L31; else goto _L30
_L30:
        i = 0;
_L35:
        if (i >= mArrayListDataTagOSRSS.size()) goto _L29; else goto _L32
_L32:
        Object obj;
        final TextView txt_sub_status;
        Object obj1;
        final String lName;
        final String TagName;
        final String title;
        final String tag_name;
        Object obj2;
        obj = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fe, null);
        obj2 = (TextView)((View) (obj)).findViewById(0x7f0b0773);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0774);
        txt_sub_status = (TextView)((View) (obj)).findViewById(0x7f0b0775);
        ((ImageView)((View) (obj)).findViewById(0x7f0b0772)).setImageResource(0x7f020327);
        obj1 = (Button)((View) (obj)).findViewById(0x7f0b0771);
        ((Button) (obj1)).setVisibility(0);
        String s = ((ItemRSSTag)mArrayListDataTagOSRSS.get(i)).getmRealName();
        lName = ((ItemRSSTag)mArrayListDataTagOSRSS.get(i)).getmTagName();
        TagName = ((ItemRSSTag)mArrayListDataTagOSRSS.get(i)).getmRealName();
        title = ((ItemRSSTag)mArrayListDataTagOSRSS.get(i)).getmRealName();
        tag_name = ((ItemRSSTag)mArrayListDataTagOSRSS.get(i)).getmTagName();
        ((TextView) (obj2)).setText((new StringBuilder("Berita ")).append(s).toString());
        textview.setText(lName);
        obj2 = ((ItemRSSTag)mArrayListDataTagOSRSS.get(i)).getSub_status();
        txt_sub_status.setText(((CharSequence) (obj2)));
        subs_status_push = "";
        if (!((String) (obj2)).equals("1")) goto _L34; else goto _L33
_L33:
        subs_status_push = "0";
        ((Button) (obj1)).setBackground(drwKurang);
_L51:
        mLinearListViewRSSOSTag.addView(((View) (obj)));
        ((Button) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$lName;
            private final String val$tag_name;
            private final String val$title;
            private final TextView val$txt_sub_status;

            public void onClick(View view)
            {
                Log.e("txt_sub_status", txt_sub_status.getText().toString());
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    Log.e("txt_sub_status", txt_sub_status.getText().toString());
                    if (txt_sub_status.getText().toString().equals("1"))
                    {
                        subs_status_push = "0";
                    } else
                    {
                        subs_status_push = "1";
                    }
                    Log.e("subs_statusbtn", subs_status_push);
                    showPopUpLangganan(title, tag_name, lName, subs_status_push, "os");
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls25.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls25.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls25.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1RSSDetail.this;
                txt_sub_status = textview;
                title = s;
                tag_name = s1;
                lName = s2;
                super();
            }
        });
        ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$TagName;
            private final String val$lName;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "3");
                view.putExtra("tag_key", (new StringBuilder("os:")).append(lName).toString());
                view.putExtra("kategori_tag", TagName);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                lName = s;
                TagName = s1;
                super();
            }
        });
        i++;
          goto _L35
_L6:
        mArrayListDataTagGenRSS.add(new ItemRSSTag(arr_rss_general[i], arr_tag_general[i], "", arr_tag_general_subs[i]));
        i++;
          goto _L36
_L7:
        final TextView txt_sub_status;
        TextView textview1;
        obj1 = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fe, null);
        obj2 = (TextView)((View) (obj1)).findViewById(0x7f0b0773);
        textview1 = (TextView)((View) (obj1)).findViewById(0x7f0b0774);
        txt_sub_status = (TextView)((View) (obj1)).findViewById(0x7f0b0775);
        ((ImageView)((View) (obj1)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
        TagName = (Button)((View) (obj1)).findViewById(0x7f0b0771);
        TagName.setVisibility(0);
        txt_sub_status = ((ItemRSSTag)mArrayListDataTagGenRSS.get(i)).getmRealName();
        title = ((ItemRSSTag)mArrayListDataTagGenRSS.get(i)).getmRealName();
        tag_name = ((ItemRSSTag)mArrayListDataTagGenRSS.get(i)).getmTagName();
        obj = txt_sub_status;
        final String TagName;
        final String lName;
        if (txt_sub_status.endsWith(","))
        {
            obj = (new StringBuilder(String.valueOf(txt_sub_status.substring(0, txt_sub_status.length() - 1)))).append(" ").toString();
        }
        TagName = ((ItemRSSTag)mArrayListDataTagGenRSS.get(i)).getmRealName();
        lName = ((ItemRSSTag)mArrayListDataTagGenRSS.get(i)).getmTagName();
        ((TextView) (obj2)).setText((new StringBuilder("Berita ")).append(((String) (obj))).toString());
        textview1.setText(lName);
        obj = ((ItemRSSTag)mArrayListDataTagGenRSS.get(i)).getSub_status();
        txt_sub_status.setText(((CharSequence) (obj)));
        subs_status_push = "";
        if (!((String) (obj)).equals("1"))
        {
            break MISSING_BLOCK_LABEL_1244;
        }
        subs_status_push = "0";
        TagName.setBackground(drwKurang);
_L38:
        Log.e("subs_statuslinear", subs_status_push);
        mLinearListViewRSSGenTag.addView(((View) (obj1)));
        TagName.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$lName;
            private final String val$tag_name;
            private final String val$title;
            private final TextView val$txt_sub_status;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    Log.e("txt_sub_status", txt_sub_status.getText().toString());
                    if (txt_sub_status.getText().toString().equals("1"))
                    {
                        subs_status_push = "0";
                    } else
                    {
                        subs_status_push = "1";
                    }
                    Log.e("subs_statusbtn", subs_status_push);
                    showPopUpLangganan(title, tag_name, lName, subs_status_push, "general");
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
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
                this$0 = Hal1RSSDetail.this;
                txt_sub_status = textview;
                title = s;
                tag_name = s1;
                lName = s2;
                super();
            }
        });
        ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$TagName;
            private final String val$lName;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "0");
                view.putExtra("tag_key", (new StringBuilder("gn:")).append(lName).toString());
                view.putExtra("kategori_tag", TagName);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                lName = s;
                TagName = s1;
                super();
            }
        });
        i++;
          goto _L37
        subs_status_push = "1";
        TagName.setBackground(drw);
          goto _L38
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L4
_L11:
        mArrayListDataTagHPRSS.add(new ItemRSSTag(arr_rss_devices[i], arr_rss_hpsid[i], arr_rss_hpsid[i], arr_tag_hp_subs[i]));
        i++;
          goto _L39
_L12:
        exception = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fe, null);
        Object obj3 = (TextView)exception.findViewById(0x7f0b0773);
        TextView textview2 = (TextView)exception.findViewById(0x7f0b0774);
        TagName = (TextView)exception.findViewById(0x7f0b0775);
        ((ImageView)exception.findViewById(0x7f0b0772)).setImageResource(0x7f020327);
        obj1 = (Button)exception.findViewById(0x7f0b0771);
        ((Button) (obj1)).setVisibility(0);
        String s1 = ((ItemRSSTag)mArrayListDataTagHPRSS.get(i)).getmRealName();
        txt_sub_status = ((ItemRSSTag)mArrayListDataTagHPRSS.get(i)).getmTagName();
        TagName = ((ItemRSSTag)mArrayListDataTagHPRSS.get(i)).getmRealName();
        title = ((ItemRSSTag)mArrayListDataTagHPRSS.get(i)).getmRealName();
        tag_name = ((ItemRSSTag)mArrayListDataTagHPRSS.get(i)).getmTagName();
        ((TextView) (obj3)).setText((new StringBuilder("Berita ")).append(s1).toString());
        textview2.setText(txt_sub_status);
        obj3 = ((ItemRSSTag)mArrayListDataTagHPRSS.get(i)).getSub_status();
        TagName.setText(((CharSequence) (obj3)));
        subs_status_push = "";
        if (!((String) (obj3)).equals("1"))
        {
            break MISSING_BLOCK_LABEL_1634;
        }
        subs_status_push = "0";
        ((Button) (obj1)).setBackground(drwKurang);
_L41:
        mLinearListViewRSSHPTag.addView(exception);
        ((Button) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$lName;
            private final String val$tag_name;
            private final String val$title;
            private final TextView val$txt_sub_status;

            public void onClick(View view)
            {
                Log.e("txt_sub_status", txt_sub_status.getText().toString());
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    Log.e("txt_sub_status", txt_sub_status.getText().toString());
                    if (txt_sub_status.getText().toString().equals("1"))
                    {
                        subs_status_push = "0";
                    } else
                    {
                        subs_status_push = "1";
                    }
                    Log.e("subs_statusbtn", subs_status_push);
                    showPopUpLangganan(title, tag_name, lName, subs_status_push, "hp");
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls18 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
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
                this$0 = Hal1RSSDetail.this;
                txt_sub_status = textview;
                title = s;
                tag_name = s1;
                lName = s2;
                super();
            }
        });
        exception.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$TagName;
            private final String val$lName;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "6");
                view.putExtra("tag_key", (new StringBuilder("hp:")).append(lName).toString());
                view.putExtra("kategori_tag", TagName);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                lName = s;
                TagName = s1;
                super();
            }
        });
        i++;
          goto _L40
        subs_status_push = "1";
        ((Button) (obj1)).setBackground(drw);
          goto _L41
        exception;
        exception.printStackTrace();
          goto _L9
_L16:
        mArrayListDataTagHPSpekRSS.add(new ItemRSSTag(arr_rss_devices[i], arr_rss_hpsid[i], "", ""));
        i++;
          goto _L42
_L17:
        exception = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fe, null);
        TagName = (TextView)exception.findViewById(0x7f0b0773);
        obj1 = (TextView)exception.findViewById(0x7f0b0774);
        ((ImageView)exception.findViewById(0x7f0b0772)).setImageResource(0x7f020329);
        final String fName = ((ItemRSSTag)mArrayListDataTagHPSpekRSS.get(i)).getmRealName();
        final String lName = ((ItemRSSTag)mArrayListDataTagHPSpekRSS.get(i)).getmTagName();
        final String codeName = ((ItemRSSTag)mArrayListDataTagHPSpekRSS.get(i)).getCodeTagName();
        TagName.setText((new StringBuilder("Spesifikasi ")).append(fName).toString());
        ((TextView) (obj1)).setText((new StringBuilder("Spesifikasi ")).append(lName).toString());
        mLinearListViewRSSHPSpekTag.addView(exception);
        exception.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$codeName;
            private final String val$fName;
            private final String val$lName;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", lName);
                view.putExtra("namalengkap", fName);
                view.putExtra("codename", "");
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("hrg_baru", "");
                view.putExtra("hrg_bekas", "");
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                view.putExtra("actfrom", "spek");
                Log.e("codeName", codeName);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                lName = s;
                fName = s1;
                codeName = s2;
                super();
            }
        });
        i++;
          goto _L43
        exception;
        exception.printStackTrace();
          goto _L14
_L21:
        mArrayListDataTagBrandRSS.add(new ItemRSSTag(arr_rss_brands[i], arr_tag_brands[i], "", arr_tag_brand_subs[i]));
        i++;
          goto _L44
_L22:
        exception = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fe, null);
        Object obj4 = (TextView)exception.findViewById(0x7f0b0773);
        TextView textview3 = (TextView)exception.findViewById(0x7f0b0774);
        TagName = (TextView)exception.findViewById(0x7f0b0775);
        ((ImageView)exception.findViewById(0x7f0b0772)).setImageResource(0x7f02032b);
        obj1 = (Button)exception.findViewById(0x7f0b0771);
        ((Button) (obj1)).setVisibility(0);
        String s2 = ((ItemRSSTag)mArrayListDataTagBrandRSS.get(i)).getmRealName();
        fName = ((ItemRSSTag)mArrayListDataTagBrandRSS.get(i)).getmTagName();
        lName = ((ItemRSSTag)mArrayListDataTagBrandRSS.get(i)).getmRealName();
        codeName = ((ItemRSSTag)mArrayListDataTagBrandRSS.get(i)).getmRealName();
        tag_name = ((ItemRSSTag)mArrayListDataTagBrandRSS.get(i)).getmTagName();
        ((TextView) (obj4)).setText((new StringBuilder("Berita ")).append(s2).toString());
        textview3.setText(fName);
        obj4 = ((ItemRSSTag)mArrayListDataTagBrandRSS.get(i)).getSub_status();
        TagName.setText(((CharSequence) (obj4)));
        subs_status_push = "";
        if (!((String) (obj4)).equals("1"))
        {
            break MISSING_BLOCK_LABEL_2260;
        }
        subs_status_push = "0";
        ((Button) (obj1)).setBackground(drwKurang);
_L46:
        mLinearListViewRSSBrandTag.addView(exception);
        ((Button) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$lName;
            private final String val$tag_name;
            private final String val$title;
            private final TextView val$txt_sub_status;

            public void onClick(View view)
            {
                Log.e("txt_sub_status", txt_sub_status.getText().toString());
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    Log.e("txt_sub_status", txt_sub_status.getText().toString());
                    if (txt_sub_status.getText().toString().equals("1"))
                    {
                        subs_status_push = "0";
                    } else
                    {
                        subs_status_push = "1";
                    }
                    Log.e("subs_statusbtn", subs_status_push);
                    showPopUpLangganan(title, tag_name, lName, subs_status_push, "brand");
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
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
                this$0 = Hal1RSSDetail.this;
                txt_sub_status = textview;
                title = s;
                tag_name = s1;
                lName = s2;
                super();
            }
        });
        exception.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$TagName;
            private final String val$lName;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "2");
                view.putExtra("tag_key", (new StringBuilder("br:")).append(lName).toString());
                view.putExtra("kategori_tag", TagName);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                lName = s;
                TagName = s1;
                super();
            }
        });
        i++;
          goto _L45
        subs_status_push = "1";
        ((Button) (obj1)).setBackground(drw);
          goto _L46
        exception;
        exception.printStackTrace();
          goto _L19
_L26:
        mArrayListDataTagOprRSS.add(new ItemRSSTag(arr_rss_operators[i], arr_tag_operators[i], "", arr_tag_op_subs[i]));
        i++;
          goto _L47
_L27:
        exception = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300fe, null);
        Object obj5 = (TextView)exception.findViewById(0x7f0b0773);
        TextView textview4 = (TextView)exception.findViewById(0x7f0b0774);
        TagName = (TextView)exception.findViewById(0x7f0b0775);
        ((ImageView)exception.findViewById(0x7f0b0772)).setImageResource(0x7f020328);
        obj1 = (Button)exception.findViewById(0x7f0b0771);
        ((Button) (obj1)).setVisibility(0);
        String s3 = ((ItemRSSTag)mArrayListDataTagOprRSS.get(i)).getmRealName();
        fName = ((ItemRSSTag)mArrayListDataTagOprRSS.get(i)).getmTagName();
        lName = ((ItemRSSTag)mArrayListDataTagOprRSS.get(i)).getmRealName();
        codeName = ((ItemRSSTag)mArrayListDataTagOprRSS.get(i)).getmRealName();
        tag_name = ((ItemRSSTag)mArrayListDataTagOprRSS.get(i)).getmTagName();
        ((TextView) (obj5)).setText((new StringBuilder("Berita ")).append(s3).toString());
        textview4.setText(fName);
        obj5 = ((ItemRSSTag)mArrayListDataTagOprRSS.get(i)).getSub_status();
        TagName.setText(((CharSequence) (obj5)));
        subs_status_push = "";
        if (!((String) (obj5)).equals("1"))
        {
            break MISSING_BLOCK_LABEL_2645;
        }
        subs_status_push = "0";
        ((Button) (obj1)).setBackground(drwKurang);
_L49:
        mLinearListViewRSSOprTag.addView(exception);
        ((Button) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$lName;
            private final String val$tag_name;
            private final String val$title;
            private final TextView val$txt_sub_status;

            public void onClick(View view)
            {
                Log.e("txt_sub_status", txt_sub_status.getText().toString());
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    Log.e("txt_sub_status", txt_sub_status.getText().toString());
                    if (txt_sub_status.getText().toString().equals("1"))
                    {
                        subs_status_push = "0";
                    } else
                    {
                        subs_status_push = "1";
                    }
                    Log.e("subs_statusbtn", subs_status_push);
                    showPopUpLangganan(title, tag_name, lName, subs_status_push, "op");
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1RSSDetail.this;
                txt_sub_status = textview;
                title = s;
                tag_name = s1;
                lName = s2;
                super();
            }
        });
        exception.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;
            private final String val$TagName;
            private final String val$lName;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "4");
                view.putExtra("tag_key", (new StringBuilder("op:")).append(lName).toString());
                view.putExtra("kategori_tag", TagName);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                lName = s;
                TagName = s1;
                super();
            }
        });
        i++;
          goto _L48
        subs_status_push = "1";
        ((Button) (obj1)).setBackground(drw);
          goto _L49
        exception;
        exception.printStackTrace();
          goto _L24
_L31:
        mArrayListDataTagOSRSS.add(new ItemRSSTag(arr_rss_os[i], arr_tag_os[i], "", arr_tag_os_subs[i]));
        i++;
          goto _L50
_L34:
        subs_status_push = "1";
        ((Button) (obj1)).setBackground(drw);
          goto _L51
        exception;
        exception.printStackTrace();
        return;
          goto _L35
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

                final Hal1RSSDetail this$0;
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

                        final _cls33 this$1;
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
                this$1 = final__pcls33;
                img_media = String.this;
                super();
            }
                    });
                }


            
            {
                this$0 = Hal1RSSDetail.this;
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

            final Hal1RSSDetail this$0;
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
                this$0 = Hal1RSSDetail.this;
                img_media = s;
                img_media_to = s1;
                super();
            }
        });
    }

    private void parseJSONAddFav(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusAddRss = s.getString("success");
            postMessageAddRss = s.getString("message");
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
            ponselBaseApp.getObserver().setFav_stat_rss(statFav);
            ponselBaseApp.getObserver().setIndexRSS(id_rss);
            return;
        }
        s = jArray.getJSONObject(i);
        if (!statFav.equals("0"))
        {
            rss_content = s.getString("rss_content");
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_44;
        }
    }

    private void showPopUpLangganan(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("id_subs", (new StringBuilder(String.valueOf(s1))).append("=").append(s3).append("=").append(s4).toString());
        type = s4;
        query = (new StringBuilder("idhp=")).append(s1).append("&idusr=").append(user_id).append("&stat=").append(s3).append("&type=").append(s4).append("&t=").append(t).toString();
        tag_id = s2;
        subs_status = s3;
        s1 = new android.app.AlertDialog.Builder(wrapperLight);
        Log.e("subs_status", subs_status);
        if (subs_status.equals("1"))
        {
            s1.setMessage((new StringBuilder("Langganan berita untuk ")).append(s).append("?").toString());
        } else
        {
            s1.setMessage((new StringBuilder("Berhenti langganan berita untuk ")).append(s).append("?").toString());
        }
        s1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                (new SubsNewsTask()).execute(new Void[0]);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        s1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        s1.show();
    }

    private void show_popup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setCancelable(false);
        builder.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                getActivity().finish();
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        builder.show();
    }

    public static String toSlug(String s)
    {
        s = Normalizer.normalize(WHITESPACE.matcher(s).replaceAll("-"), java.text.Normalizer.Form.NFD);
        return NONLATIN.matcher(s).replaceAll("").toLowerCase(Locale.ENGLISH);
    }

    public void RSSTask()
    {
        dataRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_detail").append(Utility.BASE_FORMAT).append("?rss_id=").append(id_rss).append("&idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        Log.e("dataRSS", dataRSS);
        RSSTask rsstask = new RSSTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            rsstask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            rsstask.execute(new Void[0]);
            return;
        }
    }

    public void RSSTaskDB()
    {
        dataRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_detail").append(Utility.BASE_FORMAT).append("?rss_id=").append(id_rss).append("&idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        Log.e("dataRSS", dataRSS);
        RSSTaskDB rsstaskdb = new RSSTaskDB(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            rsstaskdb.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            rsstaskdb.execute(new Void[0]);
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
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_rsskom").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&ktwmail=").append(statusKomen).append("&id_rss=").append(id_rss).append("&t=").append(t).toString();
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

    public android.text.Html.ImageGetter getImageHTML()
    {
        return new android.text.Html.ImageGetter() {

            final Hal1RSSDetail this$0;

            public Drawable getDrawable(String s)
            {
                try
                {
                    s = Drawable.createFromStream((new URL(s)).openStream(), "src name");
                    s.setBounds(0, 0, s.getIntrinsicWidth(), s.getIntrinsicHeight());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.v("IOException", s.getMessage());
                    return null;
                }
                return s;
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        };
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

    public void onAnimationEnd(Animation animation)
    {
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            menuinflater.inflate(0x7f0f000f, menu);
        } else
        {
            menuinflater.inflate(0x7f0f000f, menu);
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
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030100, null);
        notificationLikeHelper = new NotificationLikeRSSHelper(getActivity());
        wrapperLight = new ContextThemeWrapper(getActivity(), 0x103006e);
        extras = getActivity().getIntent().getExtras();
        dataurlemail = getActivity().getIntent().getData();
        t = Utility.session(t);
        drw = getActivity().getResources().getDrawable(0x7f020240);
        drw.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwKurang = getActivity().getResources().getDrawable(0x7f0201ea);
        drwKurang.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwLoveGaris = getResources().getDrawable(0x7f020267);
        drwLoveGaris.setColorFilter(getResources().getColor(0x7f08017f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwLoveFull = getResources().getDrawable(0x7f020266);
        drwLoveFull.setColorFilter(getResources().getColor(0x7f08017f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwStarGaris = getResources().getDrawable(0x7f020304);
        drwStarGaris.setColorFilter(getResources().getColor(0x7f08017f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwStarFull = getResources().getDrawable(0x7f020305);
        drwStarFull.setColorFilter(getResources().getColor(0x7f08017f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwCopas = getResources().getDrawable(0x7f020198);
        drwCopas.setColorFilter(getResources().getColor(0x7f08017e), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwUrl = getResources().getDrawable(0x7f020348);
        drwUrl.setColorFilter(getResources().getColor(0x7f08017f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwShare = getResources().getDrawable(0x7f0202fc);
        drwShare.setColorFilter(getResources().getColor(0x7f08017f), android.graphics.PorterDuff.Mode.SRC_ATOP);
        btn_tampilkan_gambar = (Button)layoutinflater.findViewById(0x7f0b0778);
        btnSourceLink = (Button)layoutinflater.findViewById(0x7f0b0788);
        imgCopas = (ImageView)layoutinflater.findViewById(0x7f0b0781);
        imgWeblink = (ImageView)layoutinflater.findViewById(0x7f0b0783);
        imgShare = (ImageView)layoutinflater.findViewById(0x7f0b0785);
        btn_komen_pic = (Button)layoutinflater.findViewById(0x7f0b053a);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            imgCopas.setBackgroundDrawable(drwCopas);
        } else
        {
            imgCopas.setBackground(drwCopas);
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            imgWeblink.setBackgroundDrawable(drwUrl);
        } else
        {
            imgWeblink.setBackground(drwUrl);
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            imgShare.setBackgroundDrawable(drwShare);
        } else
        {
            imgShare.setBackground(drwShare);
        }
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", "berita");
                view.putExtra("id_rss", id_rss);
                view.putExtra("user_id", user_id);
                view.putExtra("top_id", top_id);
                startActivityForResult(view, Hal1RSSDetail.POST_STAT);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        lay_RSS = (LinearLayout)layoutinflater.findViewById(0x7f0b077a);
        myrootlinlist = (LinearLayout)layoutinflater.findViewById(0x7f0b0789);
        ll_kontenlain = (LinearLayout)layoutinflater.findViewById(0x7f0b078b);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        layout_empty.setVisibility(0);
        imgRSS = (ImageView)layoutinflater.findViewById(0x7f0b0779);
        txtSumber = (TextView)layoutinflater.findViewById(0x7f0b077c);
        txt_empty_komen = (TextView)layoutinflater.findViewById(0x7f0b066e);
        txtLabelKomentar = (TextView)layoutinflater.findViewById(0x7f0b066c);
        btn_komenlain = (Button)layoutinflater.findViewById(0x7f0b066f);
        img_kontenarrow = (ImageView)layoutinflater.findViewById(0x7f0b078a);
        progressbar_komen = (ProgressBar)layoutinflater.findViewById(0x7f0b066d);
        mLinearListView = (LinearLayout)layoutinflater.findViewById(0x7f0b04d8);
        mArrayListData = new ArrayList();
        list_lay_copas = (RelativeLayout)layoutinflater.findViewById(0x7f0b0780);
        list_lay_share = (RelativeLayout)layoutinflater.findViewById(0x7f0b0667);
        txtRssTanggal = (TextView)layoutinflater.findViewById(0x7f0b077d);
        txt_rss_srclink = (TextView)layoutinflater.findViewById(0x7f0b0786);
        txt_rss_title = (TextView)layoutinflater.findViewById(0x7f0b077b);
        listBerita = (LinearLayout)layoutinflater.findViewById(0x7f0b0220);
        mArrayListRSSData = new ArrayList();
        web_rss_srclink = (WebView)layoutinflater.findViewById(0x7f0b077f);
        web_rss_srclink.setWebViewClient(new WebViewClient() {

            final Hal1RSSDetail this$0;

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s.endsWith("</iframe>") || s.endsWith(".flv") || s.endsWith("wmv") || s.endsWith("avi"))
                {
                    webview = new Intent("android.intent.action.VIEW");
                    webview.setData(Uri.parse(s));
                    getActivity().startActivity(webview);
                    return true;
                }
                if (s != null && s.startsWith("http://"))
                {
                    webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        mLinearListViewRSSHPSpekTag = (LinearLayout)layoutinflater.findViewById(0x7f0b0791);
        mLinearListViewRSSGenTag = (LinearLayout)layoutinflater.findViewById(0x7f0b0790);
        mLinearListViewRSSHPTag = (LinearLayout)layoutinflater.findViewById(0x7f0b078d);
        mLinearListViewRSSBrandTag = (LinearLayout)layoutinflater.findViewById(0x7f0b078c);
        mLinearListViewRSSOSTag = (LinearLayout)layoutinflater.findViewById(0x7f0b078e);
        mLinearListViewRSSOprTag = (LinearLayout)layoutinflater.findViewById(0x7f0b078f);
        progressbar_middle = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getActivity()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f02033f).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        t = Utility.session(t);
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        mNotificationHelper = new NotificationKomenHelper(getActivity());
        btn_send_komen = (Button)layoutinflater.findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)layoutinflater.findViewById(0x7f0b04de);
        lay_pop_komen = (RelativeLayout)layoutinflater.findViewById(0x7f0b04da);
        btn_pop_login = (Button)layoutinflater.findViewById(0x7f0b04e1);
        pop_txtCountKomen = (TextView)layoutinflater.findViewById(0x7f0b04df);
        txtLikeKom = (TextView)layoutinflater.findViewById(0x7f0b0551);
        txtfavoriteKom = (TextView)layoutinflater.findViewById(0x7f0b0666);
        txtweblinkKom = (TextView)layoutinflater.findViewById(0x7f0b0784);
        list_img_like = (ImageView)layoutinflater.findViewById(0x7f0b054f);
        list_img_favorite = (ImageView)layoutinflater.findViewById(0x7f0b05f1);
        list_lay_like = (RelativeLayout)layoutinflater.findViewById(0x7f0b0342);
        list_lay_favorite = (RelativeLayout)layoutinflater.findViewById(0x7f0b0665);
        list_lay_weblink = (RelativeLayout)layoutinflater.findViewById(0x7f0b0782);
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            scheme = dataurlemail.getScheme();
            host = dataurlemail.getHost();
            viewgroup = dataurlemail.getPathSegments();
            id_rss = (String)viewgroup.get(1);
            if (((String)viewgroup.get(1)).equals("d"))
            {
                id_rss = (String)viewgroup.get(2);
            } else
            {
                id_rss = (String)viewgroup.get(1);
            }
            rss_title = "";
            notif = "email";
            rss_id = "";
            rss_portal = "";
            rss_desc = "";
            rss_srclink = "";
            rss_date = "";
            rss_img_ava = "";
            rss_img = "";
            total_like = "";
            like_stat = "";
            total_komen = "";
            fav_stat = "";
            kategori_tag = "";
            Log.e("scheme", scheme);
            Log.e("host", host);
            Log.e("id_rss", id_rss);
            Log.e("rss_title", rss_title);
        } else
        {
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            if (notif.equals("gcm"))
            {
                id_rss = extras.getString("id_rss");
                rss_title = extras.getString("rss_title");
                RSSTask();
            } else
            {
                id_rss = extras.getString("id_rss");
                rss_id = extras.getString("rss_id");
                rss_title = extras.getString("rss_title");
                rss_portal = extras.getString("rss_portal");
                rss_desc = extras.getString("rss_desc");
                rss_srclink = extras.getString("rss_srclink");
                rss_date = extras.getString("rss_date");
                rss_img_ava = extras.getString("rss_img_ava");
                rss_img = extras.getString("rss_img");
                total_like = extras.getString("total_like");
                like_stat = extras.getString("like_stat");
                total_komen = extras.getString("total_komen");
                fav_stat = extras.getString("fav_stat");
                kategori_tag = extras.getString("kategori_tag");
            }
        }
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        imm = (InputMethodManager)getActivity().getSystemService("input_method");
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
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
            }
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
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        Log.e("user_id", user_id);
        ll_kontenlain.setVisibility(0);
        btn_komenlain.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSKomenTab);
                view.putExtra("actfrom", "rssfeed");
                view.putExtra("act", "komen");
                view.putExtra("rss_id", rss_id);
                view.putExtra("kategori_tag", kategori_tag);
                view.putExtra("id_rss", id_rss);
                view.putExtra("rss_title", rss_title);
                view.putExtra("rss_portal", rss_portal);
                view.putExtra("rss_desc", rss_desc);
                view.putExtra("rss_srclink", rss_srclink);
                view.putExtra("rss_date", rss_date);
                view.putExtra("rss_img_ava", rss_img_ava);
                view.putExtra("rss_img", rss_img);
                view.putExtra("total_like", total_like);
                view.putExtra("like_stat", like_stat);
                view.putExtra("total_komen", total_komen);
                view.putExtra("fav_stat", fav_stat);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        myrootlinlist.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                if (ll_kontenlain.getVisibility() == 0)
                {
                    ll_kontenlain.setVisibility(8);
                    return;
                } else
                {
                    ll_kontenlain.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        list_lay_copas.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                str_detlink = str_detlink.replace("news/", "berita/d/");
                ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(str_detlink);
                Toast.makeText(getActivity(), (new StringBuilder("Link URL berita tercopy : ")).append(str_detlink).toString(), 1).show();
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        callbackManager = com.facebook.CallbackManager.Factory.create();
        shareDialog = new ShareDialog(getActivity());
        list_lay_share.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                str_detlink = str_detlink.replace("news/", "berita/d/");
                Log.e("text/plain", str_detlink);
                view = new Intent("android.intent.action.SEND");
                view.setType("text/plain");
                view = getActivity().getPackageManager().queryIntentActivities(view, 0);
                view = new ShareIntentListAdapter(getActivity(), view.toArray());
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
                builder.setTitle("Bagikan ke");
                builder.setAdapter(view, view. new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;
                    private final ShareIntentListAdapter val$objShareIntentListAdapter;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = (ResolveInfo)objShareIntentListAdapter.getItem(i);
                        if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
                        {
                            Log.e("share", "facebook");
                            if (str_imgurl.contains(".jpg") || str_imgurl.contains(".jpeg") || str_imgurl.contains(".png"))
                            {
                                dialoginterface = str_imgurl;
                            } else
                            {
                                dialoginterface = "http://static.inponsel.co.id/images/logo/logo-no-border-orange.png";
                            }
                            dialoginterface = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle(str_title).setImageUrl(Uri.parse(dialoginterface)).setContentDescription(rss_desc).setContentUrl(Uri.parse(str_detlink))).build();
                            shareDialog.show(dialoginterface);
                            return;
                        } else
                        {
                            Log.e("share", "other");
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder(String.valueOf(str_title))).append(" ").append(str_detlink).toString());
                            intent.putExtra("android.intent.extra.SUBJECT", rss_title);
                            intent.putExtra("android.intent.extra.TITLE", str_title);
                            startActivity(intent);
                            return;
                        }
                    }

            
            {
                this$1 = final__pcls7;
                objShareIntentListAdapter = ShareIntentListAdapter.this;
                super();
            }
                });
                builder.show();
            }


            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        btn_send_komen.setEnabled(false);
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final Hal1RSSDetail this$0;

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

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
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
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", "0");
                    querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_rss=").append(id_rss).append("&top_id=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_rss3").append(Utility.BASE_FORMAT).append("?id_rss=").append(id_rss).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append("12").toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        list_lay_weblink.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(rss_srclink)));
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        btnSourceLink.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(rss_srclink)));
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        Log.e("checkIfExistRSS", id_rss);
        if (db.checkIfExistRSS(id_rss))
        {
            curRSS = db.getRSSIDData(id_rss);
            curRSS.moveToFirst();
            rss_id = curRSS.getString(1);
            rss_portal = curRSS.getString(2);
            rss_title = curRSS.getString(4);
            rss_content = curRSS.getString(6);
            rss_date = curRSS.getString(9);
            rss_img = curRSS.getString(7);
            rss_srclink = curRSS.getString(8);
            total_like = curRSS.getString(10);
            total_komen = curRSS.getString(11);
            like_stat = curRSS.getString(12);
            if (like_stat.equals("1"))
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    list_img_like.setBackgroundDrawable(drwLoveFull);
                } else
                {
                    list_img_like.setBackground(drwLoveFull);
                }
                list_img_like.setEnabled(false);
            } else
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    list_img_like.setBackgroundDrawable(drwLoveGaris);
                } else
                {
                    list_img_like.setBackground(drwLoveGaris);
                }
                list_img_like.setEnabled(true);
            }
            txtLikeKom.setText(total_like);
            txtSumber.setText(rss_portal);
            txtRssTanggal.setText(Utility.convertDate(rss_date));
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                list_img_favorite.setBackgroundDrawable(drwStarFull);
            } else
            {
                list_img_favorite.setBackground(drwStarFull);
            }
            web_rss_srclink.getSettings().setJavaScriptEnabled(true);
            web_rss_srclink.loadDataWithBaseURL("", (new StringBuilder("<style>img{display: inline;height: auto;max-width: 100%;} iframe{display: inline;height: auto;max-width: 100%;}</style>")).append(rss_content).toString(), "text/html", "UTF-8", "");
            txt_rss_srclink.setText(rss_srclink);
            txt_rss_title.setText(rss_title);
            imgRSS.setVisibility(8);
            progressbar_middle.setVisibility(8);
            layout_empty.setVisibility(8);
            Log.e("checkIfExistRSS", "exist");
            viewgroup = ((ConnectivityManager)getActivity().getSystemService("connectivity")).getActiveNetworkInfo();
            if (viewgroup != null && viewgroup.isConnected())
            {
                RSSTaskDB();
            }
        } else
        if (!notif.equals("gcm"))
        {
            RSSTask();
        }
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "1";
                    idkom_pos = id_rss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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

                        final _cls12 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls12 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls12 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        list_lay_favorite.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                idkom_pos = id_rss;
                str_srclink = rss_srclink;
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    if (db.checkIfExistRSS(idkom_pos) || fav_stat.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Hapus berita ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls13 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statFav = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls13 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Favoritkan berita ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls13 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statFav = "1";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls13 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls13 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls13 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls13 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        (new Handler()).postDelayed(new Runnable() {

            final Hal1RSSDetail this$0;

            public void run()
            {
                (new PostHits()).execute(new Void[0]);
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        }, 3000L);
        urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_terkait").append(Utility.BASE_FORMAT).append("?").append("idrss=").append(id_rss).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").toString();
        Log.e("urlRSS", urlRSS);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new RSSTerkaitAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new RSSTerkaitAsycTask()).execute(new String[0]);
        }
        web_rss_srclink.getSettings().setLoadsImagesAutomatically(false);
        btn_tampilkan_gambar.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail this$0;

            public void onClick(View view)
            {
                Log.e("count_img", String.valueOf(count_img));
                btn_tampilkan_gambar.setVisibility(8);
                if (count_img > 1)
                {
                    web_rss_srclink.getSettings().setBlockNetworkLoads(false);
                    web_rss_srclink.getSettings().setLoadsImagesAutomatically(true);
                    imgRSS.setVisibility(8);
                    return;
                } else
                {
                    imgRSS.setVisibility(0);
                    web_rss_srclink.getSettings().setBlockNetworkLoads(false);
                    web_rss_srclink.getSettings().setLoadsImagesAutomatically(true);
                    view = new DisplayMetrics();
                    getActivity().getWindowManager().getDefaultDisplay().getMetrics(view);
                    int i = ((DisplayMetrics) (view)).widthPixels;
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(str_imgurl.trim()).toString(), imgRSS, options, animateFirstListener);
                    return;
                }
            }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
        });
        return layoutinflater;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 38
    //                   2131429697: 61;
           goto _L1 _L2 _L3
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        getActivity().finish();
        getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
        continue; /* Loop/switch isn't completed */
_L3:
        userFunctions = new UserFunctions();
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(rss_title).append(" ?").toString();
            String s;
            android.app.AlertDialog.Builder builder1;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                s = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(rss_title).append(" ?").toString();
            } else
            {
                statusKomen = "1";
                s = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(rss_title).append(" ?").toString();
            }
            Log.e("statusKomen", statusKomen);
            builder1 = new android.app.AlertDialog.Builder(getActivity());
            builder1.setTitle("Perhatian");
            builder1.setMessage(s);
            builder1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
            });
            builder1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail this$0;

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
                this$0 = Hal1RSSDetail.this;
                super();
            }
            });
            builder1.show();
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            builder.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
            });
            builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
            });
            builder.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }
            });
            builder.show();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onPause()
    {
        super.onPause();
        try
        {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(web_rss_srclink, null);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            return;
        }
    }

    public Bitmap rotateImage(Bitmap bitmap, float f)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, (int)Utility.convertPixelsToDp(bitmap.getWidth(), getActivity()), (int)Utility.convertPixelsToDp(bitmap.getHeight(), getActivity()), matrix, true);
    }

    public void update(Observable observable, Object obj)
    {
        userFunctions = new UserFunctions();
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
        } else
        {
            btn_send_komen.setVisibility(8);
            btn_pop_login.setVisibility(0);
            edt_pop_komen.setVisibility(8);
            pop_txtCountKomen.setVisibility(8);
            lay_pop_komen.setVisibility(8);
        }
        if (!ponselBaseApp.getObserver().getUpdateType().equals("likerss")) goto _L2; else goto _L1
_L1:
        Log.e("totlike", ponselBaseApp.getObserver().getTot_LikeRSS());
        txtLikeKom.setText(ponselBaseApp.getObserver().getTot_LikeRSS());
        if (android.os.Build.VERSION.SDK_INT >= 16) goto _L4; else goto _L3
_L3:
        list_img_like.setBackgroundDrawable(drwLoveFull);
_L6:
        return;
_L4:
        list_img_like.setBackground(drwLoveFull);
        return;
_L2:
        if (!ponselBaseApp.getObserver().getUpdateType().equals("favrss"))
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.e("rssidmatchdet", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexRSS()))).append("=").append(str_id).toString());
        if (!str_id.toString().equals(ponselBaseApp.getObserver().getIndexRSS())) goto _L6; else goto _L5
_L5:
        if (ponselBaseApp.getObserver().getFav_stat_rss().toString().equals("1"))
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                list_img_favorite.setBackgroundDrawable(drwStarFull);
                return;
            } else
            {
                list_img_favorite.setBackground(drwStarFull);
                return;
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            list_img_favorite.setBackgroundDrawable(drwStarGaris);
            return;
        } else
        {
            list_img_favorite.setBackground(drwStarGaris);
            return;
        }
        if (!ponselBaseApp.getObserver().getUpdateType().equals("komentarrss")) goto _L6; else goto _L7
_L7:
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
