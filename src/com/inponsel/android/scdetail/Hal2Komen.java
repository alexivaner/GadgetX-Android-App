// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

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
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.timelinedetail.ReplyKomTLActivity;
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
import com.inponsel.android.v2.AddKomentarPicture;
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
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
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

public class Hal2Komen extends SherlockFragment
    implements Observer
{
    public class KomentarAsycAfterTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
            jum_komen = jsonobject.getString("total_komen");
            statusKomen = jsonobject.getString("statuskomen");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_308;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_308;
            }
            Object obj = Hal2Komen.this;
            obj.countAllKom = ((Hal2Komen) (obj)).countAllKom + 1;
            obj = Hal2Komen.this;
            obj.countKomOld = ((Hal2Komen) (obj)).countKomOld + 1;
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
            Log.e("statusKomenAfter", statusKomen);
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            if (mArrayListData.size() < 15)
            {
                txtbtnheader.setVisibility(8);
            } else
            {
                txtbtnheader.setVisibility(0);
            }
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            i = 0;
_L16:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycAfterTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;

                public void onClick(View view)
                {
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycAfterTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                this$1 = KomentarAsycAfterTask.this;
                super();
            }
            });
            layout_empty.setVisibility(8);
            if (countKomOld < 15)
            {
                txtbtnheader.setVisibility(8);
                layout_header.setVisibility(8);
                return;
            }
              goto _L5
_L4:
            ImageView imageview;
            ImageView imageview1;
            final String id_komrss;
            final String sc_id;
            String s;
            final String komen_rss;
            final String tanggal_kom;
            String s1;
            final String user_name;
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
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            sc_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
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
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L7; else goto _L6
_L6:
            lay_quote.setVisibility(8);
_L13:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L9; else goto _L8
_L8:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L14:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg")) goto _L11; else goto _L10
_L10:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L15:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
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

                final KomentarAsycAfterTask this$1;
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
                this$1 = final_komentarasycaftertask;
                user_photo = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;
                private final String val$id_user;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", id_user);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasycaftertask;
                id_user = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&idsc=").append(sc_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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

                            final KomentarAsycAfterTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&idsc=").append(sc_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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

                            final KomentarAsycAfterTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", id_komrss);
                        view.putExtra("id_sc", sc_id);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        getActivity().startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls5.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls5.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls5.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("sc_judul", sc_judul);
                        view.putExtra("sc_id", sc_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("bottom_id", bottom_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls6.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycAfterTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycAfterTask._cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasycaftertask;
                sc_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            i++;
              goto _L12
_L7:
            lay_quote.setVisibility(0);
              goto _L13
_L9:
label0:
            {
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L14
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L14
_L11:
            img_kom_picture.setImageResource(0x7f020297);
              goto _L15
_L5:
            try
            {
                txtbtnheader.setVisibility(0);
                layout_header.setVisibility(8);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
_L12:
            if (true) goto _L16; else goto _L2
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycAfterTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;

                public void onClick(View view)
                {
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarAsycAfterTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycAfterTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                this$1 = KomentarAsycAfterTask.this;
                super();
            }
            });
            layout_empty.setVisibility(0);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Belum ada komentar");
            return;
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


        public KomentarAsycAfterTask()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class KomentarAsycTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
            jum_komen = jsonobject.getString("total_komen");
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
            Object obj = Hal2Komen.this;
            obj.countAllKom = ((Hal2Komen) (obj)).countAllKom + 1;
            obj = Hal2Komen.this;
            obj.countKomOld = ((Hal2Komen) (obj)).countKomOld + 1;
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
            grup_footer.setVisibility(0);
            if (mArrayListData.size() < 15)
            {
                txtbtnfooter.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            i = 0;
_L16:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
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
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_apps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("idsc=")).append(sc_id).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).toString();
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
            if (countKomOld < 15)
            {
                txtbtnheader.setVisibility(8);
                layout_header.setVisibility(8);
                return;
            }
              goto _L5
_L4:
            ImageView imageview;
            ImageView imageview1;
            final String id_komrss;
            final String sc_id;
            String s;
            final String komen_rss;
            final String tanggal_kom;
            String s1;
            final String user_name;
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
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            sc_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
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
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L7; else goto _L6
_L6:
            lay_quote.setVisibility(8);
_L13:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L9; else goto _L8
_L8:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L14:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg")) goto _L11; else goto _L10
_L10:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L15:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
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
            list_lay_like.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&idsc=").append(sc_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                sc_id = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&idsc=").append(sc_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", id_komrss);
                        view.putExtra("id_sc", sc_id);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        getActivity().startActivityForResult(view, Hal2Komen.POST_STAT);
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
                id_komrss = s;
                sc_id = s1;
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
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("sc_judul", sc_judul);
                        view.putExtra("sc_id", sc_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("bottom_id", bottom_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal2Komen.POST_STAT);
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
                sc_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            i++;
              goto _L12
_L7:
            lay_quote.setVisibility(0);
              goto _L13
_L9:
label0:
            {
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(false);
            }
              goto _L14
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L14
_L11:
            img_kom_picture.setImageResource(0x7f020297);
              goto _L15
_L5:
            try
            {
                txtbtnheader.setVisibility(0);
                layout_header.setVisibility(8);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
_L12:
            if (true) goto _L16; else goto _L2
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
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
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class KomentarNewAsycTask extends AsyncTask
    {

        final Hal2Komen this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenOld));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            top_id = jsonobject.getString("top_id");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_262;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_262;
            }
            Object obj = Hal2Komen.this;
            obj.countAllKom = ((Hal2Komen) (obj)).countAllKom + 1;
            obj = Hal2Komen.this;
            obj.countKomOld = ((Hal2Komen) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(0, new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_sc"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            layout_header.setVisibility(8);
            int i;
            if (mArrayListData.size() < 15)
            {
                txtbtnheader.setVisibility(8);
                layout_header.setVisibility(8);
            } else
            {
                txtbtnheader.setVisibility(0);
            }
            ImageView imageview;
            ImageView imageview1;
            final String id_komrss;
            final String sc_id;
            String s;
            final String komen_rss;
            final String tanggal_kom;
            String s1;
            final String user_name;
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
                void1 = Hal2Komen.this;
                void1.removeIndex = ((Hal2Komen) (void1)).removeIndex + 3;
                Log.e("removeIndexBef", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                void1 = Hal2Komen.this;
                void1.removeStartOld = ((Hal2Komen) (void1)).removeStartOld + 3;
                Log.e("removeIndexAft", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                return;
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
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            sc_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
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
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L2; else goto _L1
_L1:
            lay_quote.setVisibility(8);
_L5:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L4; else goto _L3
_L3:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L6:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1749;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L7:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
            Log.e("counter old", String.valueOf(i));
            mLinearListView.addView(void1, 0);
            img_kom_picture.setOnLongClickListener(s1. new android.view.View.OnLongClickListener() {

                final KomentarNewAsycTask this$1;
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
                this$1 = final_komentarnewasyctask;
                user_photo = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_user;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", id_user);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnewasyctask;
                id_user = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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

                            final KomentarNewAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnewasyctask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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

                            final KomentarNewAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnewasyctask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", id_komrss);
                        view.putExtra("id_sc", sc_id);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        getActivity().startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls5.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnewasyctask;
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("sc_judul", sc_judul);
                        view.putExtra("sc_id", sc_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("bottom_id", bottom_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNewAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNewAsycTask._cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnewasyctask;
                sc_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            i++;
            break MISSING_BLOCK_LABEL_87;
_L2:
            lay_quote.setVisibility(0);
              goto _L5
_L4:
label0:
            {
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(0);
            mArrayListData.clear();
        }


        public KomentarNewAsycTask()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class KomentarNextAsycTask extends AsyncTask
    {

        final Hal2Komen this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenLast));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            if (!jsonobject.getString("bottom_id").equals("-"))
            {
                bottom_id = jsonobject.getString("bottom_id");
            }
            jum_komen = jsonobject.getString("total_komen");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_298;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_298;
            }
            Object obj = Hal2Komen.this;
            obj.countAllKom = ((Hal2Komen) (obj)).countAllKom + 1;
            obj = Hal2Komen.this;
            obj.countKomOld = ((Hal2Komen) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(mArrayListData.size(), new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_sc"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            txtbtnfooter.setVisibility(0);
            layout_footerNext.setVisibility(8);
            jum_komen.equals("-");
            if (mArrayListData.size() < 15)
            {
                txtbtnfooter.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(mArrayListData.size()));
            i = 0;
_L9:
            if (i < mArrayListData.size()) goto _L4; else goto _L3
_L3:
            void1 = Hal2Komen.this;
            void1.removeNextIndex = ((Hal2Komen) (void1)).removeNextIndex + countRemIndex;
            Log.e("removeNextIndex", String.valueOf(removeNextIndex));
_L13:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            final String id_komrss;
            final String sc_id;
            final String komen_rss;
            final String tanggal_kom;
            String s;
            final String user_name;
            void1 = Hal2Komen.this;
            void1.countRemIndex = ((Hal2Komen) (void1)).countRemIndex + 1;
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
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            sc_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user_to();
            komen_rss = ((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss();
            tanggal_kom = ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom();
            s = ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo();
            user_name = ((ItemRSSKomen)mArrayListData.get(i)).getUser_name();
            ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemRSSKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to();
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L6; else goto _L5
_L5:
            lay_quote.setVisibility(8);
_L10:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L11:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1759;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L12:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
            ll_separator_atas = (LinearLayout)void1.findViewById(0x7f0b0766);
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_1520;
            }
            ll_separator_atas.setVisibility(0);
            ll_separator_atas.setBackgroundColor(0xffff0000);
            mLinearListView.addView(void1);
            list_lay_like.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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

                            final KomentarNextAsycTask._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls1.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls1.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls1.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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

                            final KomentarNextAsycTask._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls2.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarNextAsycTask._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarNextAsycTask._cls2.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", id_komrss);
                        view.putExtra("id_sc", sc_id);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        getActivity().startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("sc_judul", sc_judul);
                        view.putExtra("sc_id", sc_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("bottom_id", bottom_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
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
                sc_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
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
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            layout_footerNext.setVisibility(0);
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
        }


        public KomentarNextAsycTask()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class KomentarReplyAsycTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
            jum_komen = jsonobject.getString("total_komen");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_282;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_282;
            }
            Object obj = Hal2Komen.this;
            obj.countAllKom = ((Hal2Komen) (obj)).countAllKom + 1;
            obj = Hal2Komen.this;
            obj.countKomOld = ((Hal2Komen) (obj)).countKomOld + 1;
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
            void1 = Hal2Komen.this;
            void1.removeNextIndex = ((Hal2Komen) (void1)).removeNextIndex + countRemIndex;
            Log.e("mArrayListDataAfterRep", String.valueOf(mArrayListData.size()));
            mLinearListView.removeViewAt(mLinearListView.getChildCount());
_L13:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
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
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            ImageView imageview;
            ImageView imageview1;
            final String id_komrss;
            final String sc_id;
            final String komen_rss;
            final String tanggal_kom;
            String s;
            final String user_name;
            void1 = Hal2Komen.this;
            void1.countRemIndex = ((Hal2Komen) (void1)).countRemIndex + 1;
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
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            sc_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user_to();
            komen_rss = ((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss();
            tanggal_kom = ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom();
            s = ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo();
            user_name = ((ItemRSSKomen)mArrayListData.get(i)).getUser_name();
            ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemRSSKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to();
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L6; else goto _L5
_L5:
            lay_quote.setVisibility(8);
_L10:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L11:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_1714;
            }
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
_L12:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1, 0);
            list_lay_like.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
                private final String val$id_komrss;
                private final String val$sc_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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
                id_komrss = s;
                sc_id = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", id_komrss);
                        view.putExtra("id_sc", sc_id);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        getActivity().startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
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
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$sc_id;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(getActivity()))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("sc_judul", sc_judul);
                        view.putExtra("sc_id", sc_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("bottom_id", bottom_id);
                        Log.e("id_komrss_to", id_komrss);
                        startActivityForResult(view, Hal2Komen.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
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
                sc_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
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
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarReplyAsycTask this$1;

                public void onClick(View view)
                {
                    txtbtnheader.setVisibility(8);
                    view = _fld0;
                    view.limit = ((Hal2Komen) (view)).limit + 15;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_228;
                    }
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_358;
                    try
                    {
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
                    (new KomentarNewAsycTask()).execute(new String[0]);
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
                    limit = 0;
                    if (!komen_type.equals("katapps"))
                    {
                        break MISSING_BLOCK_LABEL_205;
                    }
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_335;
                    try
                    {
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                      goto _L1
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataNext", String.valueOf(mArrayListData.size()));
        }


        public KomentarReplyAsycTask()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
            ponselBaseApp.getObserver().setUpdateType("komentarsc");
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
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            if (!komen_type.equals("katapps")) goto _L2; else goto _L1
_L1:
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_komen_katapps").append(Utility.BASE_FORMAT).append("?").append(querylike).toString();
_L4:
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            reslike = avoid.toString();
            parseJSONLikeKom(reslike);
            break MISSING_BLOCK_LABEL_178;
_L2:
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_komen_likedis").append(Utility.BASE_FORMAT).append("?").append(querylike).toString();
            if (true) goto _L4; else goto _L3
_L3:
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
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            Log.e("postStatusLikeKom", postStatusLikeKom);
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_214;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_164;
            }
            notificationLikeHelper.completed(sc_judul, notificationLikeHelper.suclikefrontKomen);
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new SendMailLikeDisTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_194;
            try
            {
                notificationLikeHelper.completed(sc_judul, notificationLikeHelper.sucdislikefrontKomen);
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
                notificationLikeHelper.gagal(sc_judul, postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal(sc_judul, postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification(sc_judul, notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification(sc_judul, notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
    {

        final Hal2Komen this$0;

        private void parseJSONKom(String s)
        {
            s = new JSONObject(s);
            postStatus = s.getString("success");
            postMessage = s.getString("message");
            ponselBaseApp.getObserver().setIndexKomSC(idkom_pos);
            Log.e("postStatus", postStatus);
            if (!postStatus.equals("1"))
            {
                break MISSING_BLOCK_LABEL_272;
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
            mArrayListData.add(mArrayListData.size(), new ItemRSSKomen(s.getString("id_kom"), s.getString("id_sc"), s.getString("id_user"), s.getString("id_user_to"), s.getString("komentar"), s.getString("tanggal_kom"), s.getString("user_photo"), s.getString("user_name"), s.getString("tanggal_to"), s.getString("total_like"), s.getString("total_dislike"), s.getString("my_like_kom"), s.getString("user_name_to"), s.getString("komen_to"), s.getString("img_kom"), s.getString("img_kom_rep")));
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
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            if (!komen_type.equals("katapps")) goto _L2; else goto _L1
_L1:
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_katapps").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
_L4:
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            Log.e("responseKomen", res);
            parseJSONKom(res);
            break MISSING_BLOCK_LABEL_193;
_L2:
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_sc").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
            if (true) goto _L4; else goto _L3
_L3:
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
            ponselBaseApp.getObserver().setUpdateType("komentarsc");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            jum_komen.equals("-");
            if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
            int i;
            Log.e("notifkomen", statusKomen);
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
                break MISSING_BLOCK_LABEL_146;
            } else
            {
                void1 = Hal2Komen.this;
                void1.countRemIndex = ((Hal2Komen) (void1)).countRemIndex + 1;
                void1 = Hal2Komen.this;
                void1.countKomOld = ((Hal2Komen) (void1)).countKomOld + 1;
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
                final String id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
                final String sc_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
                String s = ((ItemRSSKomen)mArrayListData.get(i)).getId_user();
                ((ItemRSSKomen)mArrayListData.get(i)).getId_user_to();
                final String komen_rss = ((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss();
                final String tanggal_kom = ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom();
                String s1 = ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo();
                final String user_name = ((ItemRSSKomen)mArrayListData.get(i)).getUser_name();
                ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to();
                ((ItemRSSKomen)mArrayListData.get(i)).getTotal_like();
                ((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike();
                ((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom();
                ((ItemRSSKomen)mArrayListData.get(i)).getKomen_to();
                ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to();
                if (((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals(""))
                {
                    lay_quote.setVisibility(8);
                } else
                {
                    lay_quote.setVisibility(0);
                }
                if (((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1"))
                {
                    imageview.setBackgroundResource(0x7f02025b);
                    imageview1.setBackgroundResource(0x7f0201a3);
                    list_lay_like.setEnabled(false);
                    list_lay_dislike.setEnabled(true);
                } else
                if (((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
                if (((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") || ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
                {
                    imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
                } else
                {
                    img_kom_picture.setImageResource(0x7f020297);
                }
                txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
                txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
                txtLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
                txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
                txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
                txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
                txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
                txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
                txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
                mLinearListView.addView(void1, 0);
                img_kom_picture.setOnLongClickListener(s1. new android.view.View.OnLongClickListener() {

                    final PostKomen this$1;
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
                this$1 = final_postkomen;
                user_photo = String.this;
                super();
            }
                });
                img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_user;

                    public void onClick(View view)
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                        view.putExtra("id_user_view", id_user);
                        startActivityForResult(view, 0);
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_postkomen;
                id_user = String.this;
                super();
            }
                });
                list_lay_like.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_komrss;
                    private final String val$sc_id;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(getActivity()))
                        {
                            statuslike = "1";
                            idkom_pos = id_komrss;
                            querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                id_komrss = s;
                sc_id = String.this;
                super();
            }
                });
                list_lay_dislike.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_komrss;
                    private final String val$sc_id;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(getActivity()))
                        {
                            statuslike = "0";
                            idkom_pos = id_komrss;
                            querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
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
                id_komrss = s;
                sc_id = String.this;
                super();
            }
                });
                list_lay_rep.setOnClickListener(s1. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_komrss;
                    private final String val$komen_rss;
                    private final String val$sc_id;
                    private final String val$tanggal_kom;
                    private final String val$user_name;
                    private final String val$user_photo;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(getActivity()))
                        {
                            view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                            view.putExtra("top_id", top_id);
                            view.putExtra("idkomen", id_komrss);
                            view.putExtra("id_sc", sc_id);
                            view.putExtra("userkomen", user_name);
                            view.putExtra("tanggal", tanggal_kom);
                            view.putExtra("isikomentar", komen_rss);
                            view.putExtra("userpict", user_photo);
                            view.putExtra("sc_nama", "");
                            view.putExtra("sc_merk", "");
                            getActivity().startActivityForResult(view, Hal2Komen.POST_STAT);
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(wrapperLight);
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
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(sc_id. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$sc_id;

                    public void onClick(View view)
                    {
                        limit = 0;
                        if (!komen_type.equals("katapps"))
                        {
                            break MISSING_BLOCK_LABEL_199;
                        }
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L1:
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                        break MISSING_BLOCK_LABEL_323;
                        try
                        {
                            urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                          goto _L1
                        (new KomentarNextAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = final_postkomen;
                sc_id = String.this;
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
                        querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(sc_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                mNotificationHelper.completed(sc_judul, mNotificationHelper.SucdiskomStatement);
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
                mNotificationHelper.gagal(sc_judul, postMessage);
                return;
            }
            mNotificationHelper.gagal(sc_judul, mNotificationHelper.gagalkomStatement);
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
            txtbtnheader.setEnabled(false);
            txtbtnheader.setTextColor(Color.parseColor("#cacaca"));
            edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
            Log.e("mArrayListDataPostKomen", String.valueOf(mArrayListData.size()));
            mNotificationHelper.createNotification(sc_judul, mNotificationHelper.komenPostWords);
            mArrayListData.clear();
            Log.e("clearmArrayKomen", String.valueOf(mArrayListData.size()));
        }


        public PostKomen()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_comsc").append(Utility.BASE_FORMAT).append("?").append(querylike).toString();
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
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_sc").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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

        public SendMailTask()
        {
            this$0 = Hal2Komen.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final Hal2Komen this$0;

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
            this$0 = Hal2Komen.this;
            super();
        }
    }


    private static int POST_STAT = 0;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    Button btnRefresh;
    Button btn_komen_pic;
    Button btn_pop_login;
    Button btn_send_komen;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    Cursor cursor;
    String dataNotifOnOff;
    DatabaseHandler db;
    String details;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    LinearLayout headName;
    String host;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imgKomentar;
    ImageView imgKomentar_rep;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray inponsel;
    MenuItem itemTurnNotif;
    JSONArray jArray;
    String jumSC;
    String jum_komen;
    String kmail_stat;
    String komen_type;
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
    private LinearLayout ll_separator_atas;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    private LinearLayout mLinearListView;
    NotificationKomenHelper mNotificationHelper;
    Menu mainMenu;
    String messageNotif;
    String nama_asli;
    String notif;
    NotificationLikeHelper notificationLikeHelper;
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
    ProgressBar progressbar_imgkomen;
    ProgressBar progressbar_imgkomenrep;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    String sc_codename;
    String sc_content;
    String sc_date;
    String sc_id;
    String sc_id_hp;
    String sc_id_user;
    String sc_img_url;
    String sc_judul;
    String sc_tag;
    String sc_type;
    String sc_username;
    String sc_userphoto;
    String scheme;
    ScrollView scrollviewKomen;
    String sortkom;
    String statusKomen;
    String statuslike;
    String strJsonRssRep;
    String strKonekStat;
    String str_SC_merk;
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
    String username;
    ContextThemeWrapper wrapperLight;

    public Hal2Komen()
    {
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strJsonRssRep = "";
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
        querypopkomen = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        dataNotifOnOff = "0";
        inponsel = null;
        suc = "";
        jumSC = "";
        messageNotif = "";
        kmail_stat = "";
        sortkom = "12";
        statusKomen = "";
        komen_type = "";
    }

    private void check_image_komen(final RelativeLayout ll_img_komen, RelativeLayout relativelayout, final TextView txtTapImage, TextView textview, final ImageView imgKomentar, ImageView imageview, final ProgressBar progressbar_imgkomen, 
            ProgressBar progressbar, final String img_media, final String img_media_to)
    {
        Log.e("img_media", img_media);
        if (img_media.equals("-") || img_media.equals(""))
        {
            txtTapImage.setVisibility(8);
            ll_img_komen.setVisibility(8);
        } else
        {
            txtTapImage.setVisibility(0);
            txtTapImage.setVisibility(8);
            progressbar_imgkomen.setVisibility(0);
            ll_img_komen.setVisibility(0);
        }
        Log.e("img_media_to", img_media_to);
        if (img_media_to.equals("-") || img_media_to.equals(""))
        {
            textview.setVisibility(8);
            relativelayout.setVisibility(8);
        } else
        {
            relativelayout.setVisibility(8);
            textview.setVisibility(0);
        }
        txtTapImage.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen this$0;
            private final ImageView val$imgKomentar;
            private final String val$img_media;
            private final RelativeLayout val$ll_img_komen;
            private final ProgressBar val$progressbar_imgkomen;
            private final TextView val$txtTapImage;

            public void onClick(View view)
            {
                Log.e("ll_img_komen", img_media);
                txtTapImage.setVisibility(8);
                progressbar_imgkomen.setVisibility(0);
                ll_img_komen.setVisibility(0);
                Picasso.with(getActivity()).load(img_media.trim()).into(imgKomentar, img_media. new Callback() {

                    final _cls9 this$1;
                    private final ImageView val$imgKomentar;
                    private final String val$img_media;
                    private final RelativeLayout val$ll_img_komen;
                    private final ProgressBar val$progressbar_imgkomen;

                    public void onError()
                    {
                        Log.e("ll_img_komen", "onError");
                        progressbar_imgkomen.setVisibility(8);
                        Toast.makeText(getActivity(), "Gagal memuat gambar", 1).show();
                    }

                    public void onSuccess()
                    {
                        Log.e("ll_img_komen", "onSuccess");
                        progressbar_imgkomen.setVisibility(8);
                        imgKomentar.setVisibility(0);
                        ll_img_komen.setClickable(false);
                        imgKomentar.setOnClickListener(img_media. new android.view.View.OnClickListener() {

                            final _cls1 this$2;
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
                this$2 = final__pcls1;
                img_media = String.this;
                super();
            }
                        });
                    }


            
            {
                this$1 = final__pcls9;
                progressbar_imgkomen = progressbar;
                imgKomentar = imageview;
                ll_img_komen = relativelayout;
                img_media = String.this;
                super();
            }
                });
            }


            
            {
                this$0 = Hal2Komen.this;
                img_media = s;
                txtTapImage = textview;
                progressbar_imgkomen = progressbar;
                ll_img_komen = relativelayout;
                imgKomentar = imageview;
                super();
            }
        });
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen this$0;
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
                this$0 = Hal2Komen.this;
                img_media = s;
                img_media_to = s1;
                super();
            }
        });
    }

    public void KomentarNextAsycTask()
    {
        if (mLinearListView.getChildCount() == 0)
        {
            try
            {
                urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                Log.e("urlKomen", urlKomen);
            }
            catch (Exception exception) { }
            layout_empty.setVisibility(0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarAsycAfterTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            } else
            {
                (new KomentarAsycAfterTask()).execute(new String[0]);
                return;
            }
        }
        try
        {
            limit = 0;
            urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
            Log.e("urlKomenLast", urlKomenLast);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        catch (Exception exception1)
        {
            return;
        }
        (new KomentarNextAsycTask()).execute(new String[0]);
        return;
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
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_sckom").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&ktwmail=").append(statusKomen).append("&idsc=").append(sc_id).append("&t=").append(t).toString();
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
        super.onActivityResult(i, j, intent);
        Log.e("onActivityResult", "RESULT_OK");
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        intent = intent.getStringExtra("jsonKom");
        Log.e("Hal3Result", intent);
        strJsonRssRep = intent;
        if (intent.equals(""))
        {
            break MISSING_BLOCK_LABEL_107;
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
        Log.e("Hal3Result", "false");
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
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        wrapperLight = new ContextThemeWrapper(getActivity(), 0x103006e);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        imm = (InputMethodManager)getActivity().getSystemService("input_method");
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        t = Utility.session(t);
        extras = getActivity().getIntent().getExtras();
        komen_type = extras.getString("komen_type");
        sc_judul = extras.getString("sc_judul");
        sc_content = extras.getString("sc_content");
        sc_codename = extras.getString("sc_codename");
        sc_date = extras.getString("sc_date");
        sc_id = extras.getString("sc_id");
        sc_id_hp = extras.getString("sc_id_hp");
        sc_id_user = extras.getString("sc_id_user");
        sc_img_url = extras.getString("sc_img_url");
        sc_tag = extras.getString("sc_tag");
        sc_type = extras.getString("sc_type");
        sc_username = extras.getString("sc_username");
        sc_userphoto = extras.getString("sc_userphoto");
        str_SC_merk = extras.getString("sc_merk");
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName((new StringBuilder("SC ")).append(str_SC_merk).append(" Komentar").toString());
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
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getActivity()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showStubImage(0x7f020297).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        txtbtnheader = (TextView)layoutinflater.findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)layoutinflater.findViewById(0x7f0b04d9);
        progbar_notifHP = (SmoothProgressBar)layoutinflater.findViewById(0x7f0b04cb);
        progbar_notifHP.setVisibility(8);
        layout_header = (LinearLayout)layoutinflater.findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)layoutinflater.findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)layoutinflater.findViewById(0x7f0b04d3);
        lay_pop_komen = (RelativeLayout)layoutinflater.findViewById(0x7f0b04da);
        btn_pop_login = (Button)layoutinflater.findViewById(0x7f0b04e1);
        pop_txtCountKomen = (TextView)layoutinflater.findViewById(0x7f0b04df);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)layoutinflater.findViewById(0x7f0b052d);
        pop_progressbar_middle = (ProgressBar)layoutinflater.findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)layoutinflater.findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        btnRefresh = (Button)layoutinflater.findViewById(0x7f0b04d0);
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = Hal2Komen.this;
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
        btn_send_komen.setEnabled(false);
        btn_komen_pic = (Button)layoutinflater.findViewById(0x7f0b053a);
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", "servicecenter");
                view.putExtra("id_sc", sc_id);
                view.putExtra("sc_nama", sc_judul);
                view.putExtra("top_id", top_id);
                startActivityForResult(view, Hal2Komen.POST_STAT);
            }

            
            {
                this$0 = Hal2Komen.this;
                super();
            }
        });
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final Hal2Komen this$0;

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
                this$0 = Hal2Komen.this;
                super();
            }
        });
        if (!komen_type.equals("katapps")) goto _L2; else goto _L1
_L1:
        urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
_L3:
        Log.e("urlKomen", urlKomen);
_L4:
        layout_empty.setVisibility(0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return layoutinflater;
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
            return layoutinflater;
        }
_L2:
        urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
          goto _L3
        viewgroup;
          goto _L4
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 4: default 48
    //                   16908332: 54
    //                   2131429695: 76
    //                   2131429696: 326
    //                   2131429697: 566;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        getActivity().finish();
        getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
        return true;
_L3:
        sortkom = "1";
        if (komen_type.equals("katapps"))
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
        } else
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
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
        if (komen_type.equals("katapps"))
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
        } else
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(sc_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
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
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(sc_judul).append(" ?").toString();
            String s;
            android.app.AlertDialog.Builder builder1;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                s = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(sc_judul).append(" ?").toString();
            } else
            {
                statusKomen = "1";
                s = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(sc_judul).append(" ?").toString();
            }
            Log.e("statusKomen", statusKomen);
            builder1 = new android.app.AlertDialog.Builder(getActivity());
            builder1.setTitle("Perhatian");
            builder1.setMessage(s);
            builder1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = Hal2Komen.this;
                super();
            }
            });
            builder1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen this$0;

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
                this$0 = Hal2Komen.this;
                super();
            }
            });
            builder1.show();
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            builder.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = Hal2Komen.this;
                super();
            }
            });
            builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = Hal2Komen.this;
                super();
            }
            });
            builder.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = Hal2Komen.this;
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
        Log.e("tot_LikeKom", tot_LikeKom);
        Log.e("totdis_LikeKom", totdis_LikeKom);
        Log.e("txtidkom", (new StringBuilder(String.valueOf(textview.getText().toString()))).append("=").append(textview.getText().toString()).toString());
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
