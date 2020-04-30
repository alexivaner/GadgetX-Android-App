// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.ClickSpan;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.AddKomentarPicture;
import com.inponsel.android.v2.BaseDrawer;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.SCReplyFormActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

// Referenced classes of package com.inponsel.android.scdetail:
//            SCKomenPager

public class Hal1SCDetail extends SherlockFragment
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
    {

        final Hal1SCDetail this$0;

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
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            Log.e("top_id", top_id);
            str_urlspekshare = jsonobject.getString("url_share");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_334;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_334;
            }
            Object obj = Hal1SCDetail.this;
            obj.countAllKom = ((Hal1SCDetail) (obj)).countAllKom + 1;
            obj = Hal1SCDetail.this;
            obj.countKomOld = ((Hal1SCDetail) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_sc"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            progressbar_komen.setVisibility(8);
            int j;
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
            final String tl_id;
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
            void1 = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300ff, null);
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
            tl_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
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
            list_lay_like_kom.setEnabled(false);
            list_lay_dislike_kom.setEnabled(true);
_L10:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1973;
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
            list_lay_like_kom.setOnClickListener(id_komrss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(str_SC_ID).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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
                id_komrss = String.this;
                super();
            }
            });
            list_lay_dislike_kom.setOnClickListener(id_komrss. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(str_SC_ID).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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
                id_komrss = String.this;
                super();
            }
            });
            list_lay_rep_kom.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    idkom_pos = id_komrss;
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", idkom_pos);
                        view.putExtra("id_sc", str_SC_ID);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", str_SC_NAMA);
                        view.putExtra("sc_merk", str_SC_merk);
                        getActivity().startActivityForResult(view, Hal1SCDetail.POST_STAT);
                        return;
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
                id_komrss = s;
                user_name = s1;
                tanggal_kom = s2;
                komen_rss = s3;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$tl_id;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("tl_judul", "");
                        view.putExtra("tl_id", tl_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        view.putExtra("id_sc", str_SC_ID);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal1SCDetail.POST_STAT);
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
                tl_id = s;
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
            Log.e("KomentarAsycTask", "onPreExecute");
            progressbar_komen.setVisibility(0);
            txt_empty_komen.setVisibility(8);
            btn_komenlain.setVisibility(8);
            mLinearListView.removeAllViewsInLayout();
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = Hal1SCDetail.this;
            super();
        }
    }

    public class ListPengalamanAdapter extends BaseAdapter
    {

        private Activity activity;
        Calendar c;
        Context context;
        Cursor cursor;
        int day;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        int month;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final Hal1SCDetail this$0;
        String user;
        UserFunctions userFunctions;
        String username;
        int year;

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
            Object obj;
            viewgroup = view;
            pos = i;
            Date date;
            String s;
            String s1;
            if (viewgroup == null)
            {
                viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                view = new ViewHolder();
                view.img_kom_picture = (ImageView)viewgroup.findViewById(0x7f0b054b);
                view.txtUsername = (TextView)viewgroup.findViewById(0x7f0b0419);
                view.txtWaktu = (TextView)viewgroup.findViewById(0x7f0b054c);
                view.txtKomentar = (TextView)viewgroup.findViewById(0x7f0b054e);
                view.progressbar_item = (ProgressBar)viewgroup.findViewById(0x7f0b00b3);
                view.ratingBar1 = (RatingBar)viewgroup.findViewById(0x7f0b0649);
                viewgroup.setTag(view);
            } else
            {
                view = (ViewHolder)viewgroup.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm == null) goto _L2; else goto _L1
_L1:
            c = Calendar.getInstance();
            year = c.get(1);
            month = c.get(2) + 1;
            day = c.get(5);
            date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(lms.getSckom_date());
            new SimpleDateFormat("dd MMMM yyyy HH:mm");
            obj = new SimpleDateFormat("yyyy-MM-dd");
            s = ((SimpleDateFormat) (obj)).format(date);
            s1 = (new StringBuilder(String.valueOf(String.valueOf(year)))).append("-").append(String.valueOf(month)).append("-").append(String.valueOf(day)).toString();
            if (!((SimpleDateFormat) (obj)).parse(s).equals(((SimpleDateFormat) (obj)).parse(s1))) goto _L4; else goto _L3
_L3:
            obj = new SimpleDateFormat("HH:mm", Locale.US);
_L5:
            obj = ((SimpleDateFormat) (obj)).format(date).replace("January", "Jan").replace("February", "Feb").replace("March", "Mar").replace("April", "Apr").replace("May", "Mei").replace("June", "Jun").replace("July", "Jul").replace("August", "Ags").replace("September", "Sep").replace("October", "Okt").replace("November", "Nov").replace("December", "Des");
            ((ViewHolder) (view)).txtWaktu.setText(((CharSequence) (obj)));
_L6:
            ((ViewHolder) (view)).txtUsername.setText(lms.getSckom_name());
            ((ViewHolder) (view)).txtKomentar.setText(Html.fromHtml(lms.getSckom_kom()));
            ((ViewHolder) (view)).ratingBar1.setVisibility(8);
            imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(lms.getSckom_photo().trim()).toString(), ((ViewHolder) (view)).img_kom_picture, options, animateFirstListener);
_L2:
            return viewgroup;
_L4:
            obj = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.US);
              goto _L5
            ParseException parseexception;
            parseexception;
            parseexception.printStackTrace();
              goto _L6
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListPengalamanAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal1SCDetail.this;
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
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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
            catch (Hal1SCDetail hal1scdetail)
            {
                return;
            }
        }
    }

    class ListPengalamanAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView img_kom_picture;
        ProgressBar progressbar_item;
        RatingBar ratingBar1;
        final ListPengalamanAdapter this$1;
        TextView txtKomentar;
        TextView txtUsername;
        TextView txtWaktu;

        ListPengalamanAdapter.ViewHolder()
        {
            this$1 = ListPengalamanAdapter.this;
            super();
        }
    }

    public class PostBagusKurangKomenTask extends AsyncTask
    {

        final Hal1SCDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_komen_likedis").append(Utility.BASE_FORMAT).append("?").append(querylikeKomen).toString();
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
                break MISSING_BLOCK_LABEL_173;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_136;
            }
            notificationLikeHelper.completed("", "Like komentar terkirim");
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new SendMailLikeDisTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_153;
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
            (new SendMailLikeDisTask()).execute(new Void[0]);
            return;
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
            this$0 = Hal1SCDetail.this;
            super();
        }
    }

    public class PostKomenSC extends AsyncTask
    {

        final Hal1SCDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_sc").append(Utility.BASE_FORMAT).append("?").append(querypopkomensc).toString();
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
            if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
            edt_pop_komen.setText("");
            mNotificationHelper.completed(str_SC_merk, mNotificationHelper.SucdiskomStatement);
            if (android.os.Build.VERSION.SDK_INT < 11) goto _L4; else goto _L3
_L3:
            (new SendMailSCTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L5:
            btn_send_komen.setEnabled(true);
            edt_pop_komen.setEnabled(true);
            edt_pop_komen.setTextColor(Color.parseColor("#000000"));
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_329;
_L4:
            try
            {
                (new SendMailSCTask()).execute(new Void[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L5
_L2:
label0:
            {
                if (!postStatus.equals("040"))
                {
                    break label0;
                }
                mNotificationHelper.gagal(str_SC_merk, (new StringBuilder(String.valueOf(mNotificationHelper.gagalkomStatement))).append(" - ").append(postMessage).toString());
                void1 = new android.app.AlertDialog.Builder(getActivity());
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
            }
              goto _L5
            mNotificationHelper.gagal(str_SC_merk, mNotificationHelper.gagalkomStatement);
              goto _L5
            (new KomentarAsycTask()).execute(new String[0]);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            mNotificationHelper.createNotification(str_SC_NAMA, mNotificationHelper.komenPostWords);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setEnabled(false);
            edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
        }

        public PostKomenSC()
        {
            this$0 = Hal1SCDetail.this;
            super();
        }
    }

    public class PostRateSC extends AsyncTask
    {

        final Hal1SCDetail this$0;

        private void parseJSONSC(String s)
        {
            JSONObject jsonobject;
            int i;
            try
            {
                s = (new JSONObject(s)).getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            i = 0;
            if (i >= s.length())
            {
                return;
            }
            jsonobject = s.getJSONObject(i);
            postStatus = jsonobject.getString("success");
            postMessage = jsonobject.getString("message");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_16;
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_rate").append(Utility.BASE_FORMAT).append("?").append(querypopratesc).toString();
                Log.e("pushURL", avoid);
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
            try
            {
                mDialog.dismiss();
                if (postStatus.equals("1"))
                {
                    Toast.makeText(getActivity(), postMessage, 1).show();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            void1 = new android.app.AlertDialog.Builder(getActivity());
            void1.setMessage(postMessage);
            void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final PostRateSC this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = PostRateSC.this;
                super();
            }
            });
            void1.show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(getActivity(), "", "Posting...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public PostRateSC()
        {
            this$0 = Hal1SCDetail.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final Hal1SCDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_comsc").append(Utility.BASE_FORMAT).append("?").append(querylikeKomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = Hal1SCDetail.this;
            super();
        }
    }

    public class SendMailSCTask extends AsyncTask
    {

        final Hal1SCDetail this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_sc").append(Utility.BASE_FORMAT).append("?").append(querypopkomensc).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = Hal1SCDetail.this;
            super();
        }
    }


    private static int POST_STAT = 0;
    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    Button btnKirimErrorSC;
    Button btn_komen_pic;
    Button btn_komenlain;
    Button btn_pop_login;
    Button btn_send_komen;
    Cursor c;
    CallbackManager callbackManager;
    int charCount;
    int charCountSC;
    int charCount_list;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int counterArray;
    Cursor cursor;
    String dataSCKomen;
    String dataSCMyKomen;
    String dataSCRating;
    String dataSearch;
    DatabaseHandler db;
    EditText edtKoreksiUserSC;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    String fb_array[];
    String getJson;
    LinearLayout headName;
    String id_artikel;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imgKomentar;
    ImageView imgKomentar_rep;
    ImageView imgSC;
    ImageView img_Mykom_picture;
    ImageView img_kom_picture;
    JSONArray inponsel;
    JSONArray jArray;
    String jml;
    String jum_komen;
    String jum_komen_list;
    String komencount;
    LinearLayout lay_SC_ALAMAT;
    LinearLayout lay_SC_BERBAGI;
    LinearLayout lay_SC_CONTACT_center;
    LinearLayout lay_SC_EMAIL;
    LinearLayout lay_SC_FACEBOOK;
    LinearLayout lay_SC_JAM_OPERASIONAL;
    RelativeLayout lay_SC_MyKom;
    LinearLayout lay_SC_PENGALAMAN;
    LinearLayout lay_SC_RATING;
    LinearLayout lay_SC_TELEPON;
    LinearLayout lay_SC_TWITTER;
    LinearLayout lay_SC_WEB;
    LinearLayout lay_SC_YOUTUBE;
    RelativeLayout lay_pop_komen;
    LinearLayout lay_quote;
    LinearLayout lineColorSC;
    ListView listHp;
    ListMerkAdapter listMerkAdapter;
    ArrayList listProvArrayList;
    RelativeLayout list_lay_dislike_kom;
    RelativeLayout list_lay_kom_kom;
    RelativeLayout list_lay_like_kom;
    RelativeLayout list_lay_rep_kom;
    RelativeLayout ll_img_komen;
    RelativeLayout ll_img_komen_rep;
    ImageLoaderConfiguration loaderConfiguration;
    private ArrayList mArrayListData;
    Dialog mDialog;
    private LinearLayout mLinearListView;
    NotificationKomenHelper mNotificationHelper;
    ImageView menu_imgProfil;
    TextView menu_ponsel_pengguna;
    ProgressBar menu_progressbar_item;
    TextView menu_sim_pengguna;
    TextView menu_username;
    ArrayList merkArray;
    ArrayList merkArrayID;
    String merk_hp[];
    String merk_hpID[];
    String merk_ven;
    String merk_venID;
    Calendar myc;
    int myday;
    int mymonth;
    String myrate;
    int myyear;
    String nama_asli;
    String no_cont_center_array[];
    String no_contven_center_array[];
    String no_telp_array[];
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
    ProgressBar progressbar_imgkomen;
    ProgressBar progressbar_imgkomenrep;
    ProgressBar progressbar_komen;
    ProgressBar progressbar_middle_dialog;
    String queryFlag;
    String querylikeKomen;
    String querypopkomensc;
    String querypopratesc;
    TextView rata1s;
    TextView rata2s;
    TextView rata3s;
    TextView rata4s;
    TextView rata5s;
    ProgressBar rating1;
    ProgressBar rating2;
    ProgressBar rating3;
    ProgressBar rating4;
    ProgressBar rating5;
    RatingBar ratingBarAVG;
    RatingBar ratingBarSC;
    RatingBar ratingBarSCDia;
    RatingBar ratingMyBar1;
    String res;
    String reslikeKomen;
    ListPengalamanAdapter sc_pengalamanAdapter;
    ArrayList sc_pengalamanArray;
    String sc_rate1;
    String sc_rate2;
    String sc_rate3;
    String sc_rate4;
    String sc_rate5;
    String sc_rateAvg;
    String sc_total_rate;
    ShareDialog shareDialog;
    String statusKomen;
    String statuslike;
    String strKonekStat;
    String strPencMerek;
    String str_SC_ID;
    String str_SC_NAMA;
    String str_SC_merk;
    String str_cont_center;
    String str_contven_center;
    String str_jam_opr;
    String str_myidkom;
    String str_myimg;
    String str_mykom;
    String str_myname;
    String str_myrate;
    String str_mywaktu;
    String str_rating1;
    String str_rating2;
    String str_rating3;
    String str_rating4;
    String str_rating5;
    String str_ratingAVG;
    String str_sc_almt;
    String str_sc_email;
    String str_sc_fb;
    String str_sc_fb_id;
    String str_sc_telp;
    String str_sc_twitter;
    String str_sc_web;
    String str_sc_ytube;
    String str_share_image;
    String str_urlspekshare;
    String suc;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String tot_LikePon_list;
    String total_rate;
    String totdis_LikeKom;
    String totdis_LikePon;
    String totdis_LikePon_list;
    String tw_array[];
    TextView txtAddRateSC;
    TextView txtCountKomenSC;
    TextView txtEmpty;
    TextView txtIdKom;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLabelKomentar;
    TextView txtLikeKom_list;
    TextViewFixTouchConsume txtMyKomentar;
    TextView txtMyUsername;
    TextView txtMyWaktu;
    TextView txtTanggapan;
    TextView txtTapImage;
    TextView txtTapImageRep;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_SC_NAMA;
    TextView txt_avgRate;
    TextView txt_cont_center;
    TextView txt_empty;
    TextView txt_empty_komen;
    TextView txt_jam_opr;
    TextView txt_rateby;
    TextView txt_sc_almt;
    TextView txt_sc_email;
    TextView txt_sc_fb;
    TextView txt_sc_telp;
    TextView txt_sc_twitter;
    TextView txt_sc_web;
    TextView txt_sc_ytube;
    TextView txtdisLikeKom;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    String urlKomenSC;
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

    public Hal1SCDetail()
    {
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        getJson = "";
        inponsel = null;
        suc = "";
        strPencMerek = "nil";
        user_photo = "";
        username = "";
        animateFirstListener = new AnimateFirstDisplayListener();
        listProvArrayList = null;
        merkArray = null;
        merkArrayID = null;
        jml = "";
        str_share_image = "";
        str_myidkom = "0";
        sc_pengalamanArray = null;
        bottom_id = "";
        top_id = "0";
        jum_komen_list = "0";
        tot_LikePon_list = "";
        totdis_LikePon_list = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strKonekStat = "";
        statusKomen = "";
        tot_LikeKom = "0";
        totdis_LikeKom = "0";
        tot_LikePon = "";
        jum_komen = "0";
        postStatus_list = "";
        postMessage_list = "";
        querylikeKomen = "";
        reslikeKomen = "";
        queryFlag = "";
        id_artikel = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        komencount = "";
        str_urlspekshare = "";
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

                final Hal1SCDetail this$0;
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

                        final _cls14 this$1;
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
                this$1 = final__pcls14;
                img_media = String.this;
                super();
            }
                    });
                }


            
            {
                this$0 = Hal1SCDetail.this;
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

            final Hal1SCDetail this$0;
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
                this$0 = Hal1SCDetail.this;
                img_media = s;
                img_media_to = s1;
                super();
            }
        });
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

    public static float convertDpToPixel(float f, Context context)
    {
        return f * ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static float convertPixelsToDp(float f, Context context)
    {
        return f / ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
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

    public Intent getOpenFacebookIntent(Context context)
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            context = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("fb://profile/")).append(str_sc_fb_id).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://www.facebook.com/")).append(str_sc_fb_id).toString()));
        }
        return context;
    }

    public void onCreate(Bundle bundle)
    {
        setHasOptionsMenu(true);
        super.onCreate(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f0004, menu);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030106, null);
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        mNotificationHelper = new NotificationKomenHelper(getActivity());
        callbackManager = com.facebook.CallbackManager.Factory.create();
        shareDialog = new ShareDialog(getActivity());
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        t = Utility.session(t);
        txt_avgRate = (TextView)layoutinflater.findViewById(0x7f0b0803);
        txt_rateby = (TextView)layoutinflater.findViewById(0x7f0b0805);
        rata5s = (TextView)layoutinflater.findViewById(0x7f0b0807);
        rata4s = (TextView)layoutinflater.findViewById(0x7f0b0809);
        rata3s = (TextView)layoutinflater.findViewById(0x7f0b080b);
        rata2s = (TextView)layoutinflater.findViewById(0x7f0b080d);
        rata1s = (TextView)layoutinflater.findViewById(0x7f0b080f);
        ratingBarAVG = (RatingBar)layoutinflater.findViewById(0x7f0b0804);
        ratingBarSC = (RatingBar)layoutinflater.findViewById(0x7f0b0754);
        rating5 = (ProgressBar)layoutinflater.findViewById(0x7f0b0806);
        rating4 = (ProgressBar)layoutinflater.findViewById(0x7f0b0808);
        rating3 = (ProgressBar)layoutinflater.findViewById(0x7f0b080a);
        rating2 = (ProgressBar)layoutinflater.findViewById(0x7f0b080c);
        rating1 = (ProgressBar)layoutinflater.findViewById(0x7f0b080e);
        notificationLikeHelper = new NotificationLikeRSSHelper(getActivity());
        mLinearListView = (LinearLayout)layoutinflater.findViewById(0x7f0b04d8);
        mArrayListData = new ArrayList();
        txt_empty_komen = (TextView)layoutinflater.findViewById(0x7f0b066e);
        btn_komenlain = (Button)layoutinflater.findViewById(0x7f0b066f);
        progressbar_komen = (ProgressBar)layoutinflater.findViewById(0x7f0b066d);
        txtLabelKomentar = (TextView)layoutinflater.findViewById(0x7f0b066c);
        btn_send_komen = (Button)layoutinflater.findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)layoutinflater.findViewById(0x7f0b04de);
        lay_pop_komen = (RelativeLayout)layoutinflater.findViewById(0x7f0b04da);
        btn_pop_login = (Button)layoutinflater.findViewById(0x7f0b04e1);
        pop_txtCountKomen = (TextView)layoutinflater.findViewById(0x7f0b04df);
        txt_empty_komen = (TextView)layoutinflater.findViewById(0x7f0b066e);
        lay_SC_ALAMAT = (LinearLayout)layoutinflater.findViewById(0x7f0b07f0);
        lay_SC_JAM_OPERASIONAL = (LinearLayout)layoutinflater.findViewById(0x7f0b07f2);
        lay_SC_TELEPON = (LinearLayout)layoutinflater.findViewById(0x7f0b07f4);
        lay_SC_CONTACT_center = (LinearLayout)layoutinflater.findViewById(0x7f0b07f6);
        lay_SC_EMAIL = (LinearLayout)layoutinflater.findViewById(0x7f0b07f7);
        lay_SC_WEB = (LinearLayout)layoutinflater.findViewById(0x7f0b07f9);
        lay_SC_TWITTER = (LinearLayout)layoutinflater.findViewById(0x7f0b07fb);
        lay_SC_FACEBOOK = (LinearLayout)layoutinflater.findViewById(0x7f0b07fd);
        lay_SC_YOUTUBE = (LinearLayout)layoutinflater.findViewById(0x7f0b07ff);
        lay_SC_PENGALAMAN = (LinearLayout)layoutinflater.findViewById(0x7f0b0801);
        lay_SC_RATING = (LinearLayout)layoutinflater.findViewById(0x7f0b0802);
        lay_SC_RATING.setVisibility(8);
        lay_SC_BERBAGI = (LinearLayout)layoutinflater.findViewById(0x7f0b0810);
        lay_SC_MyKom = (RelativeLayout)layoutinflater.findViewById(0x7f0b0811);
        txt_SC_NAMA = (TextView)layoutinflater.findViewById(0x7f0b07ef);
        txt_sc_almt = (TextView)layoutinflater.findViewById(0x7f0b07f1);
        txt_sc_telp = (TextView)layoutinflater.findViewById(0x7f0b07f5);
        txt_jam_opr = (TextView)layoutinflater.findViewById(0x7f0b07f3);
        txt_cont_center = (TextView)layoutinflater.findViewById(0x7f0b0748);
        txt_sc_email = (TextView)layoutinflater.findViewById(0x7f0b07f8);
        txt_sc_web = (TextView)layoutinflater.findViewById(0x7f0b07fa);
        txt_sc_twitter = (TextView)layoutinflater.findViewById(0x7f0b07fc);
        txt_sc_fb = (TextView)layoutinflater.findViewById(0x7f0b07fe);
        txt_sc_ytube = (TextView)layoutinflater.findViewById(0x7f0b0800);
        txtMyWaktu = (TextView)layoutinflater.findViewById(0x7f0b075a);
        txtMyUsername = (TextView)layoutinflater.findViewById(0x7f0b0616);
        txtMyKomentar = (TextViewFixTouchConsume)layoutinflater.findViewById(0x7f0b075b);
        edtKoreksiUserSC = (EditText)layoutinflater.findViewById(0x7f0b075c);
        btnKirimErrorSC = (Button)layoutinflater.findViewById(0x7f0b075d);
        btnKirimErrorSC.setEnabled(false);
        t = Utility.session(t);
        edtKoreksiUserSC.addTextChangedListener(new TextWatcher() {

            final Hal1SCDetail this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edtKoreksiUserSC.getText().length() < 4)
                {
                    btnKirimErrorSC.setEnabled(false);
                    return;
                } else
                {
                    btnKirimErrorSC.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        btn_komenlain.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/scdetail/SCKomenPager);
                view.putExtra("sc_id", str_SC_ID);
                view.putExtra("sc_judul", str_SC_NAMA);
                view.putExtra("sc_logo", "");
                view.putExtra("sc_nama", str_SC_NAMA);
                view.putExtra("sc_merk", str_SC_merk);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        ratingMyBar1 = (RatingBar)layoutinflater.findViewById(0x7f0b0759);
        imgSC = (ImageView)layoutinflater.findViewById(0x7f0b07ee);
        img_Mykom_picture = (ImageView)layoutinflater.findViewById(0x7f0b0758);
        extras = getActivity().getIntent().getExtras();
        str_SC_ID = extras.getString("sc_id");
        str_SC_NAMA = extras.getString("sc_nama");
        str_SC_merk = extras.getString("sc_merk");
        str_sc_almt = extras.getString("sc_alamat");
        str_sc_telp = extras.getString("sc_no_telp");
        str_jam_opr = extras.getString("sc_no_telp_ket");
        str_cont_center = extras.getString("sc_c_center");
        str_contven_center = extras.getString("sc_ven_center");
        str_sc_email = extras.getString("sc_email");
        str_sc_web = extras.getString("sc_web");
        str_sc_twitter = (new StringBuilder("@")).append(extras.getString("sc_tw")).toString();
        str_sc_fb = extras.getString("sc_fb");
        str_sc_ytube = extras.getString("sc_ytube");
        str_share_image = extras.getString("sc_logo").trim();
        Log.e("str_sc_web", str_sc_web);
        str_sc_telp = str_sc_telp.replace(", ", "\n");
        str_cont_center = str_cont_center.replace(", ", "\n").trim();
        str_contven_center = str_contven_center.replace(", ", "\n").trim();
        str_sc_twitter = str_sc_twitter.replace(", ", ", @").trim();
        str_sc_fb_id = extras.getString("sc_fb_id");
        str_ratingAVG = extras.getString("sc_rateAvg");
        str_rating5 = extras.getString("sc_rate5");
        str_rating4 = extras.getString("sc_rate4");
        str_rating3 = extras.getString("sc_rate3");
        str_rating2 = extras.getString("sc_rate2");
        str_rating1 = extras.getString("sc_rate1");
        sc_total_rate = extras.getString("sc_total_rate");
        if (sc_total_rate.equals("0"))
        {
            lay_SC_RATING.setVisibility(8);
        }
        if (str_sc_twitter.equals("null") || str_sc_twitter.equals("") || str_sc_twitter.equals("-") || str_sc_twitter.equals("@"))
        {
            lay_SC_TWITTER.setVisibility(8);
        } else
        {
            lay_SC_TWITTER.setVisibility(0);
        }
        if (str_sc_fb.equals("null") || str_sc_fb.equals("") || str_sc_fb.equals("-"))
        {
            lay_SC_FACEBOOK.setVisibility(8);
        } else
        {
            lay_SC_FACEBOOK.setVisibility(0);
        }
        if (str_sc_ytube.equals("null") || str_sc_ytube.equals("") || str_sc_ytube.equals("-"))
        {
            lay_SC_YOUTUBE.setVisibility(8);
        } else
        {
            lay_SC_YOUTUBE.setVisibility(0);
        }
        imgSC.getLayoutParams().height = (int)convertDpToPixel(53.33F, getActivity());
        imgSC.getLayoutParams().width = (int)convertDpToPixel(124F, getActivity());
        viewgroup = ImageLoader.getInstance();
        bundle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).build();
        viewgroup.init((new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(getActivity())).defaultDisplayImageOptions(bundle).build());
        viewgroup.loadImage(extras.getString("sc_logo").trim(), new SimpleImageLoadingListener() {

            final Hal1SCDetail this$0;

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                imgSC.setImageBitmap(bitmap);
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getActivity()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f02033f).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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
        btnKirimErrorSC.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                view = (new StringBuilder("Koreksi ")).append(str_SC_merk).append(" ").append(str_SC_NAMA).toString();
                String s = edtKoreksiUserSC.getText().toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.EMAIL", new String[] {
                    "support@inponsel.com"
                });
                intent.putExtra("android.intent.extra.SUBJECT", view);
                intent.putExtra("android.intent.extra.TEXT", s);
                startActivity(Intent.createChooser(intent, "Pilih email anda:"));
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        btn_send_komen.setEnabled(false);
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final Hal1SCDetail this$0;

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
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", "0");
                    querypopkomensc = (new StringBuilder("idsc=")).append(str_SC_ID).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).toString();
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
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        if (str_jam_opr.equals(""))
        {
            str_jam_opr = "Tidak ada informasi";
        }
        if (str_sc_telp.equals(""))
        {
            txt_sc_telp.setTextColor(getResources().getColor(0x7f08017f));
            str_sc_telp = "Tidak ada informasi";
        } else
        {
            txt_sc_telp.setTextColor(getResources().getColor(0x7f08017f));
        }
        if (str_contven_center.equals(""))
        {
            lay_SC_CONTACT_center.setVisibility(8);
        }
        if (str_sc_email.equals(""))
        {
            lay_SC_EMAIL.setVisibility(8);
        }
        if (str_sc_web.equals(""))
        {
            lay_SC_WEB.setVisibility(8);
        }
        Log.e("str_SC_NAMA", str_SC_NAMA);
        txt_SC_NAMA.setText((new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString());
        txt_sc_almt.setText(str_sc_almt);
        txt_sc_telp.setText(str_sc_telp);
        txt_jam_opr.setText(str_jam_opr);
        txt_cont_center.setText(str_contven_center);
        txt_sc_email.setText(str_sc_email.trim());
        str_sc_web = str_sc_web.trim().replace("http: //", "");
        txt_sc_web.setText(str_sc_web);
        txt_sc_twitter.setText((new StringBuilder()).append(str_sc_twitter).toString());
        txt_sc_fb.setText(str_sc_fb);
        txt_sc_ytube.setText(str_sc_ytube.trim());
        no_telp_array = str_sc_telp.split("\n");
        no_cont_center_array = str_cont_center.split(",");
        no_contven_center_array = str_contven_center.split("\n");
        fb_array = str_sc_fb.split(",");
        tw_array = str_sc_twitter.split(",");
        txt_sc_telp.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                if (str_sc_telp.equals("Tidak ada informasi"))
                {
                    txt_sc_telp.setTextColor(Color.parseColor("#4F4E4F"));
                    return;
                }
                txt_sc_telp.setTextColor(Color.parseColor("#33B5E5"));
                if (no_telp_array.length > 1)
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle("Nomor Telepon :");
                    view.setSingleChoiceItems(no_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(str_sc_telp.replaceAll("-", "")).toString()));
                    startActivity(view);
                    return;
                }
            }


            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        txt_cont_center.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
label0:
                {
                    if (!str_cont_center.equals("Tidak ada informasi"))
                    {
                        if (no_contven_center_array.length <= 1)
                        {
                            break label0;
                        }
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setTitle("Nomor Telepon :");
                        view.setSingleChoiceItems(no_contven_center_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final _cls8 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_contven_center_array[i].replaceAll("[^0-9]", "")).toString()));
                                startActivity(dialoginterface);
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        });
                        view.show();
                    }
                    return;
                }
                view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(str_contven_center.replaceAll("[^0-9]", "")).toString()));
                startActivity(view);
            }


            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        txt_sc_fb.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                try
                {
                    view = getOpenFacebookIntent(getActivity());
                    startActivity(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(str_sc_fb).toString())));
                }
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        txt_sc_twitter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                if (tw_array.length > 1)
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setSingleChoiceItems(tw_array, -1, new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(tw_array[i].replace("@", "")).toString())));
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(str_sc_twitter).toString())));
                    return;
                }
            }


            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        txt_sc_ytube.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                if (str_sc_ytube.contains("http"))
                {
                    str_sc_ytube = str_sc_ytube.trim().replace("http: //", "");
                    str_sc_ytube = str_sc_ytube.trim().replace("http://", "");
                    str_sc_ytube = str_sc_ytube.trim().replace("http//", "");
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://")).append(str_sc_ytube.trim()).toString())));
                    return;
                } else
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://www.youtube.com/user/")).append(str_sc_ytube).toString())));
                    return;
                }
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName((new StringBuilder("SC ")).append(str_SC_merk).toString());
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_list_komen3").append(Utility.BASE_FORMAT).append("?idsc=").append(str_SC_ID).append("&lmt=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup) { }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        btn_komen_pic = (Button)layoutinflater.findViewById(0x7f0b053a);
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", "servicecenter");
                view.putExtra("id_sc", str_SC_ID);
                view.putExtra("sc_nama", str_SC_NAMA);
                view.putExtra("top_id", top_id);
                Log.e("top_id", top_id);
                startActivityForResult(view, Hal1SCDetail.POST_STAT);
            }

            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
        });
        getActivity().invalidateOptionsMenu();
        return layoutinflater;
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

            final Hal1SCDetail this$0;
            private final ShareIntentListAdapter val$objShareIntentListAdapter;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = (ResolveInfo)objShareIntentListAdapter.getItem(i);
                if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
                {
                    Log.e("share", "facebook");
                    dialoginterface = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle((new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString()).setImageUrl(Uri.parse(str_share_image)).setContentDescription((new StringBuilder("Service center ")).append(str_SC_merk).append(" terlengkap di Indonesia. Dari Sabang sampai Merauke").toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
                    shareDialog.show(dialoginterface);
                    return;
                } else
                {
                    Log.e("share", "other");
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", str_urlspekshare);
                    intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString());
                    Log.e("share", str_urlspekshare);
                    intent.putExtra("android.intent.extra.TITLE", (new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString());
                    startActivity(intent);
                    return;
                }
            }

            
            {
                this$0 = Hal1SCDetail.this;
                objShareIntentListAdapter = shareintentlistadapter;
                super();
            }
        });
        builder.show();
        return true;
    }

    public void update(Observable observable, Object obj)
    {
        if (!ponselBaseApp.getObserver().getUpdateType().equals("liketl") && ponselBaseApp.getObserver().getUpdateType().equals("komentarsc"))
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else
            {
                (new KomentarAsycTask()).execute(new String[0]);
            }
        }
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
