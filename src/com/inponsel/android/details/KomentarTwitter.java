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
import com.inponsel.android.adapter.ItemTwKomen;
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
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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

// Referenced classes of package com.inponsel.android.details:
//            ReplyKomTwActivity

public class KomentarTwitter extends SherlockFragmentActivity
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
    {

        final KomentarTwitter this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenTw));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_270;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_270;
            }
            Object obj = KomentarTwitter.this;
            obj.countAllKom = ((KomentarTwitter) (obj)).countAllKom + 1;
            obj = KomentarTwitter.this;
            obj.countKomOld = ((KomentarTwitter) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemTwKomen(((JSONObject) (obj)).getString("id_komtw"), ((JSONObject) (obj)).getString("id_tw"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komen_tw"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to")));
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
            grup_footer.setVisibility(0);
            if (countKomOld < 15)
            {
                txtbtnfooter.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1651;
            }
            i = 0;
_L3:
            ImageView imageview;
            ImageView imageview1;
            if (i >= mArrayListData.size())
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                            Log.e("urlKomenTwOld", urlKomenTwOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
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
                        try
                        {
                            limit = 0;
                            urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                            Log.e("urlKomenTwLast", urlKomenTwLast);
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
                            Log.e("top_id", top_id);
                            querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                return;
            }
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
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            final String id_komtw = ((ItemTwKomen)mArrayListData.get(i)).getId_komtw();
            final String id_tw = ((ItemTwKomen)mArrayListData.get(i)).getId_tw();
            ((ItemTwKomen)mArrayListData.get(i)).getId_user();
            ((ItemTwKomen)mArrayListData.get(i)).getId_user_to();
            final String komen_tw = ((ItemTwKomen)mArrayListData.get(i)).getKomen_tw();
            final String tanggal_kom = ((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom();
            String s = ((ItemTwKomen)mArrayListData.get(i)).getUser_photo();
            final String user_name = ((ItemTwKomen)mArrayListData.get(i)).getUser_name();
            ((ItemTwKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemTwKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemTwKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to();
            if (((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals(""))
            {
                lay_quote.setVisibility(8);
            } else
            {
                lay_quote.setVisibility(0);
            }
            if (!((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L2; else goto _L1
_L1:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L4:
            if (((ItemTwKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                try
                {
                    Picasso.with(KomentarTwitter.this).load(((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

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
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemTwKomen)mArrayListData.get(i)).getId_komtw().toString());
            txtdisLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemTwKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseTweet(((ItemTwKomen)mArrayListData.get(i)).getKomen_tw())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            Log.e("tanggal_kom", ((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom());
            txtWaktu.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1);
            img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

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
            img_kom_picture.setOnClickListener(user_name. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$user_name;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", user_name);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasyctask;
                user_name = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "0";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;
                private final String val$komen_tw;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/details/ReplyKomTwActivity);
                        view.putExtra("tw_name", tw_name);
                        view.putExtra("id_tw", id_tw);
                        view.putExtra("id_komtw", id_komtw);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_tw", komen_tw);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        Log.e("id_komtw_to", id_komtw);
                        startActivityForResult(view, KomentarTwitter.POST_STAT);
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
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = String.this;
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
            if (true) goto _L3; else goto _L2
_L2:
            if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
              goto _L4
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwOld", urlKomenTwOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
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
                    try
                    {
                        limit = 0;
                        urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwLast", urlKomenTwLast);
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
        }


        public KomentarAsycTask()
        {
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class KomentarNewAsycTask extends AsyncTask
    {

        final KomentarTwitter this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenTwOld));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            top_id = jsonobject.getString("top_id");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_250;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_250;
            }
            Object obj = KomentarTwitter.this;
            obj.countAllKom = ((KomentarTwitter) (obj)).countAllKom + 1;
            obj = KomentarTwitter.this;
            obj.countKomOld = ((KomentarTwitter) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(0, new ItemTwKomen(((JSONObject) (obj)).getString("id_komtw"), ((JSONObject) (obj)).getString("id_tw"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komen_tw"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to")));
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
            Log.e("countKomOld", String.valueOf(countKomOld));
            layout_header.setVisibility(8);
            if (countKomOld < 15)
            {
                txtbtnheader.setVisibility(8);
            } else
            {
                txtbtnheader.setVisibility(0);
            }
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1644;
            }
            i = 0;
_L3:
            ImageView imageview;
            ImageView imageview1;
            if (i >= mArrayListData.size())
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarNewAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                            Log.e("urlKomenTwOld", urlKomenTwOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new KomentarNewAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = KomentarNewAsycTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarNewAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            limit = 0;
                            urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                            Log.e("urlKomenTwLast", urlKomenTwLast);
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
                this$1 = KomentarNewAsycTask.this;
                super();
            }
                });
                btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarNewAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                            Log.e("top_id", top_id);
                            querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                this$1 = KomentarNewAsycTask.this;
                super();
            }
                });
                return;
            }
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
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            final String id_komtw = ((ItemTwKomen)mArrayListData.get(i)).getId_komtw();
            final String id_tw = ((ItemTwKomen)mArrayListData.get(i)).getId_tw();
            ((ItemTwKomen)mArrayListData.get(i)).getId_user();
            ((ItemTwKomen)mArrayListData.get(i)).getId_user_to();
            final String komen_tw = ((ItemTwKomen)mArrayListData.get(i)).getKomen_tw();
            final String tanggal_kom = ((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom();
            String s = ((ItemTwKomen)mArrayListData.get(i)).getUser_photo();
            final String user_name = ((ItemTwKomen)mArrayListData.get(i)).getUser_name();
            ((ItemTwKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemTwKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemTwKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to();
            if (((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals(""))
            {
                lay_quote.setVisibility(8);
            } else
            {
                lay_quote.setVisibility(0);
            }
            if (!((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L2; else goto _L1
_L1:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L4:
            if (((ItemTwKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                try
                {
                    Picasso.with(KomentarTwitter.this).load(((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

                        final KomentarNewAsycTask this$1;

                        public void onError()
                        {
                        }

                        public void onSuccess()
                        {
                            img_kom_picture.setVisibility(0);
                        }

            
            {
                this$1 = KomentarNewAsycTask.this;
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
            txtIdKom.setText(((ItemTwKomen)mArrayListData.get(i)).getId_komtw().toString());
            txtdisLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemTwKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseTweet(((ItemTwKomen)mArrayListData.get(i)).getKomen_tw())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_to()));
            Log.e("counter old", String.valueOf(i));
            mLinearListView.addView(void1, 0);
            img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                final KomentarNewAsycTask this$1;
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
                this$1 = final_komentarnewasyctask;
                user_photo = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(user_name. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$user_name;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", user_name);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnewasyctask;
                user_name = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "0";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;
                private final String val$komen_tw;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/details/ReplyKomTwActivity);
                        view.putExtra("tw_name", tw_name);
                        view.putExtra("id_tw", id_tw);
                        view.putExtra("id_komtw", id_komtw);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_tw", komen_tw);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        Log.e("id_komtw_to", id_komtw);
                        startActivityForResult(view, KomentarTwitter.POST_STAT);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;

                public void onClick(View view)
                {
                }

            
            {
                this$1 = KomentarNewAsycTask.this;
                super();
            }
            });
            i++;
            if (true) goto _L3; else goto _L2
_L2:
            if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
              goto _L4
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwOld", urlKomenTwOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNewAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarNewAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwLast", urlKomenTwLast);
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
                this$1 = KomentarNewAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNewAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                this$1 = KomentarNewAsycTask.this;
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
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(0);
            mArrayListData.clear();
        }


        public KomentarNewAsycTask()
        {
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class KomentarNextAsycTask extends AsyncTask
    {

        final KomentarTwitter this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenTwLast));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            if (!jsonobject.getString("bottom_id").equals("-"))
            {
                bottom_id = jsonobject.getString("bottom_id");
            }
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_273;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_273;
            }
            Object obj = KomentarTwitter.this;
            obj.countAllKom = ((KomentarTwitter) (obj)).countAllKom + 1;
            obj = KomentarTwitter.this;
            obj.countKomOld = ((KomentarTwitter) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(mArrayListData.size(), new ItemTwKomen(((JSONObject) (obj)).getString("id_komtw"), ((JSONObject) (obj)).getString("id_tw"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komen_tw"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to")));
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
            if (countKomOld < 15)
            {
                grup_footer.setVisibility(8);
                txtbtnfooter.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
            Log.e("countKomOld", String.valueOf(countKomOld));
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1716;
            }
            i = 0;
_L3:
            if (i < mArrayListData.size()) goto _L2; else goto _L1
_L1:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwOld", urlKomenTwOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
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
                    try
                    {
                        limit = 0;
                        urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwLast", urlKomenTwLast);
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
_L4:
            txtbtnfooter.setVisibility(0);
            layout_footerNext.setVisibility(8);
            return;
_L2:
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
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
            ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            ll_separator_atas = (LinearLayout)void1.findViewById(0x7f0b0766);
            final String id_komtw = ((ItemTwKomen)mArrayListData.get(i)).getId_komtw();
            final String id_tw = ((ItemTwKomen)mArrayListData.get(i)).getId_tw();
            ((ItemTwKomen)mArrayListData.get(i)).getId_user();
            ((ItemTwKomen)mArrayListData.get(i)).getId_user_to();
            final String komen_tw = ((ItemTwKomen)mArrayListData.get(i)).getKomen_tw();
            final String tanggal_kom = ((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom();
            String s = ((ItemTwKomen)mArrayListData.get(i)).getUser_photo();
            final String user_name = ((ItemTwKomen)mArrayListData.get(i)).getUser_name();
            ((ItemTwKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemTwKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemTwKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to();
            if (((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals(""))
            {
                lay_quote.setVisibility(8);
            } else
            {
                lay_quote.setVisibility(0);
            }
            if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1"))
            {
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                list_lay_like.setEnabled(false);
                list_lay_dislike.setEnabled(true);
            } else
            if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
            if (((ItemTwKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                try
                {
                    Picasso.with(KomentarTwitter.this).load(((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

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
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemTwKomen)mArrayListData.get(i)).getId_komtw().toString());
            txtdisLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemTwKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseTweet(((ItemTwKomen)mArrayListData.get(i)).getKomen_tw())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_to()));
            if (i == 0)
            {
                ll_separator_atas.setVisibility(0);
                ll_separator_atas.setBackgroundColor(0xffff0000);
            } else
            {
                ll_separator_atas.setVisibility(8);
            }
            mLinearListView.addView(void1);
            img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                final KomentarNextAsycTask this$1;
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
                this$1 = final_komentarnextasyctask;
                user_photo = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(user_name. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$user_name;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", user_name);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnextasyctask;
                user_name = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "0";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
            });
            list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;
                private final String val$id_komtw;
                private final String val$id_tw;
                private final String val$komen_tw;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/details/ReplyKomTwActivity);
                        view.putExtra("tw_name", tw_name);
                        view.putExtra("id_tw", id_tw);
                        view.putExtra("id_komtw", id_komtw);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_tw", komen_tw);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        Log.e("id_komtw_to", id_komtw);
                        startActivityForResult(view, KomentarTwitter.POST_STAT);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = String.this;
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
              goto _L3
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwOld", urlKomenTwOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
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
                    try
                    {
                        limit = 0;
                        urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwLast", urlKomenTwLast);
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
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
            layout_empty.setVisibility(8);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Belum ada komentar");
              goto _L4
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
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final KomentarTwitter this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_komen_tw.php?").append(querylike).toString();
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
            notificationLikeHelper.completed(tw_name, notificationLikeHelper.suclikefrontKomen);
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
                notificationLikeHelper.completed(tw_name, notificationLikeHelper.sucdislikefrontKomen);
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
                notificationLikeHelper.gagal(tw_name, postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal(tw_name, postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification(tw_name, notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification(tw_name, notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
    {

        final KomentarTwitter this$0;

        private void parseJSONKom(String s)
        {
            s = new JSONObject(s);
            postStatus = s.getString("success");
            postMessage = s.getString("message");
            Log.e("postStatus", postStatus);
            if (!postStatus.equals("1"))
            {
                break MISSING_BLOCK_LABEL_352;
            }
            top_id = s.getString("top_id");
            jArray = s.getJSONArray("InPonsel");
            statusKomen = s.getString("statuskomen");
            tot_LikePon = s.getString("total_like");
            totdis_LikePon = s.getString("total_dislike");
            jum_komen = s.getString("total_komen");
            ponselBaseApp.getObserver().setJum_komenLikeTw(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeTw(tot_LikePon);
            ponselBaseApp.getObserver().setIndexTw(id_tw);
            int i = 0;
_L2:
            if (i >= jArray.length())
            {
                return;
            }
            s = jArray.getJSONObject(i);
            mArrayListData.add(mArrayListData.size(), new ItemTwKomen(s.getString("id_komtw"), s.getString("id_tw"), s.getString("id_user"), s.getString("id_user_to"), s.getString("komen_tw"), s.getString("tanggal_kom"), s.getString("user_photo"), s.getString("user_name"), s.getString("tanggal_to"), s.getString("total_like"), s.getString("total_dislike"), s.getString("my_like_kom"), s.getString("user_name_to"), s.getString("komen_to")));
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("plus_kom_tw").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
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
            txtbtnheader.setVisibility(0);
            layout_header.setVisibility(8);
            if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
            int i;
            if (mLinearListView.getChildCount() < 15)
            {
                txtbtnheader.setVisibility(8);
            }
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            ponselBaseApp.getObserver().setUpdateType("komentartw");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            countKomOld = 0;
            i = 0;
_L4:
            if (i >= mArrayListData.size())
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                            Log.e("urlKomenTwOld", urlKomenTwOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new KomentarNewAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = PostKomen.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            limit = 0;
                            urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                            Log.e("urlKomenTwLast", urlKomenTwLast);
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
                this$1 = PostKomen.this;
                super();
            }
                });
                btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                            Log.e("top_id", top_id);
                            querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                layout_empty.setVisibility(8);
                break MISSING_BLOCK_LABEL_218;
            } else
            {
                void1 = KomentarTwitter.this;
                void1.countRemIndex = ((KomentarTwitter) (void1)).countRemIndex + 1;
                void1 = KomentarTwitter.this;
                void1.countKomOld = ((KomentarTwitter) (void1)).countKomOld + 1;
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
                ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
                ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
                txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
                txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
                headName = (LinearLayout)void1.findViewById(0x7f0b0549);
                list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
                list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
                list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
                final String id_komtw = ((ItemTwKomen)mArrayListData.get(i)).getId_komtw();
                final String id_tw = ((ItemTwKomen)mArrayListData.get(i)).getId_tw();
                ((ItemTwKomen)mArrayListData.get(i)).getId_user();
                ((ItemTwKomen)mArrayListData.get(i)).getId_user_to();
                final String komen_tw = ((ItemTwKomen)mArrayListData.get(i)).getKomen_tw();
                final String tanggal_kom = ((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom();
                String s = ((ItemTwKomen)mArrayListData.get(i)).getUser_photo();
                final String user_name = ((ItemTwKomen)mArrayListData.get(i)).getUser_name();
                ((ItemTwKomen)mArrayListData.get(i)).getTanggal_to();
                ((ItemTwKomen)mArrayListData.get(i)).getTotal_like();
                ((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike();
                ((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom();
                ((ItemTwKomen)mArrayListData.get(i)).getKomen_to();
                ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to();
                if (((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals(""))
                {
                    lay_quote.setVisibility(8);
                } else
                {
                    lay_quote.setVisibility(0);
                }
                if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1"))
                {
                    imageview.setBackgroundResource(0x7f02025b);
                    imageview1.setBackgroundResource(0x7f0201a3);
                    list_lay_like.setEnabled(false);
                    list_lay_dislike.setEnabled(true);
                } else
                if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
                if (((ItemTwKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
                {
                    try
                    {
                        Picasso.with(KomentarTwitter.this).load(((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

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
                txtIdKom.setText(((ItemTwKomen)mArrayListData.get(i)).getId_komtw().toString());
                txtdisLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike().toString());
                txtLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_like().toString());
                txtUsername.setText(((ItemTwKomen)mArrayListData.get(i)).getUser_name());
                txtKomentar.setText(Html.fromHtml(Utility.parseTweet(((ItemTwKomen)mArrayListData.get(i)).getKomen_tw())));
                txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)mArrayListData.get(i)).getUser_name_to()));
                txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)mArrayListData.get(i)).getKomen_to().toString())));
                txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                txtWaktu.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom()));
                txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_to()));
                mLinearListView.addView(void1, 0);
                img_kom_picture.setOnLongClickListener(s. new android.view.View.OnLongClickListener() {

                    final PostKomen this$1;
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
                this$1 = final_postkomen;
                user_photo = String.this;
                super();
            }
                });
                img_kom_picture.setOnClickListener(user_name. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$user_name;

                    public void onClick(View view)
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                        view.putExtra("id_user_view", user_name);
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_postkomen;
                user_name = String.this;
                super();
            }
                });
                list_lay_like.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_komtw;
                    private final String val$id_tw;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            statuslike = "1";
                            idkom_pos = id_komtw;
                            querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
                });
                list_lay_dislike.setOnClickListener(id_tw. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_komtw;
                    private final String val$id_tw;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            statuslike = "0";
                            idkom_pos = id_komtw;
                            querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_komtw = s;
                id_tw = String.this;
                super();
            }
                });
                list_lay_rep.setOnClickListener(s. new android.view.View.OnClickListener() {

                    final PostKomen this$1;
                    private final String val$id_komtw;
                    private final String val$id_tw;
                    private final String val$komen_tw;
                    private final String val$tanggal_kom;
                    private final String val$user_name;
                    private final String val$user_photo;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            view = new Intent(_fld0, com/inponsel/android/details/ReplyKomTwActivity);
                            view.putExtra("tw_name", tw_name);
                            view.putExtra("id_tw", id_tw);
                            view.putExtra("id_komtw", id_komtw);
                            view.putExtra("user_id", user_id);
                            view.putExtra("user_name", user_name);
                            view.putExtra("tanggal_kom", tanggal_kom);
                            view.putExtra("komen_tw", komen_tw);
                            view.putExtra("user_photo", user_photo);
                            view.putExtra("top_id", top_id);
                            Log.e("id_komtw_to", id_komtw);
                            startActivityForResult(view, KomentarTwitter.POST_STAT);
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(wrapperLight);
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
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = String.this;
                super();
            }
                });
                void1.setOnClickListener(new android.view.View.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = PostKomen.this;
                super();
            }
                });
                i++;
                continue; /* Loop/switch isn't completed */
            }
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final PostKomen this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwOld", urlKomenTwOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarNewAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = PostKomen.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final PostKomen this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwLast", urlKomenTwLast);
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
                this$1 = PostKomen.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final PostKomen this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                        Log.e("top_id", top_id);
                        querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                layout_empty.setVisibility(8);
                mNotificationHelper.completed((new StringBuilder("Twitter ")).append(tw_name).toString(), mNotificationHelper.SucdiskomStatement);
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
                mNotificationHelper.gagal(tw_name, postMessage);
                return;
            }
            mNotificationHelper.gagal(tw_name, mNotificationHelper.gagalkomStatement);
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
            txtbtnheader.setEnabled(false);
            txtbtnheader.setTextColor(Color.parseColor("#cacaca"));
            edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
            Log.e("mArrayListDataPostKomen", String.valueOf(mArrayListData.size()));
            mNotificationHelper.createNotification(tw_name, mNotificationHelper.komenPostWords);
            mArrayListData.clear();
            Log.e("clearmArrayKomen", String.valueOf(mArrayListData.size()));
        }


        public PostKomen()
        {
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final KomentarTwitter this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_comtw").append(Utility.BASE_FORMAT).append("?").append(querylike).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final KomentarTwitter this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_tw").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = KomentarTwitter.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final KomentarTwitter this$0;

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
            this$0 = KomentarTwitter.this;
            super();
        }
    }


    private static int POST_STAT = 0;
    ActionBar actionBar;
    int actionBarTitleId;
    String avatar;
    String bottom_id;
    Button btnRefresh;
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
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    LinearLayout headName;
    String id_kom;
    String id_tw;
    String idkom_pos;
    ImageView imageMediaHead;
    ImageView img_kom_picture;
    ImageView img_kom_pictureHead;
    InputMethodManager imm;
    JSONArray inponsel;
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
    RelativeLayout list_lay_like;
    RelativeLayout list_lay_rep;
    private LinearLayout ll_separator_atas;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    private LinearLayout mLinearListView;
    NotificationKomenHelper mNotificationHelper;
    private Menu mainMenu;
    String media_url;
    String messageNotif;
    String nama_asli;
    NotificationLikeHelper notificationLikeHelper;
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
    String screen_name;
    ScrollView scrollviewKomen;
    String statusKomen;
    String statuslike;
    String strJsonRssRep;
    String strKonekStat;
    String suc;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String totdis_LikeKom;
    String totdis_LikePon;
    String tw_name;
    String tweet_content;
    String tweet_time;
    TextView txtIdKom;
    TextView txtIdKomHead;
    TextViewFixTouchConsume txtKomentar;
    TextView txtKomentarHead;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtTanggapan;
    TextView txtUsername;
    TextView txtUsernameHead;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuHead;
    TextView txtWaktuQoute;
    TextView txtbtnfooter;
    TextView txtbtnheader;
    TextView txtdisLikeKom;
    String urlKomenTw;
    String urlKomenTwLast;
    String urlKomenTwOld;
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

    public KomentarTwitter()
    {
        urlKomenTw = "";
        urlKomenTwOld = "";
        urlKomenTwLast = "";
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
        removeIndex = 0;
        removeStartOld = 0;
        removeNextIndex = 0;
        countRemIndex = 0;
        querylike = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        tot_LikeKom = "0";
        totdis_LikeKom = "0";
        statusKomen = "";
        dataNotifOnOff = "0";
        inponsel = null;
        suc = "";
        jumSC = "";
        messageNotif = "";
        kmail_stat = "";
        strJsonRssRep = "";
        limit = 0;
        komencount = "";
        querypopkomen = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        id_tw = "";
        tw_name = "";
        tweet_content = "";
        media_url = "";
        avatar = "";
        tweet_time = "";
        screen_name = "";
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
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_twkom").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&ktwmail=").append(statusKomen).append("&id_tw=").append(id_tw).append("&t=").append(t).toString();
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
        if (j != -1) goto _L2; else goto _L1
_L1:
        intent = intent.getStringExtra("jsonKom");
        android.util.Log.e("onActivityResultAct", intent);
        strJsonRssRep = intent;
        if (intent.equals("")) goto _L4; else goto _L3
_L3:
        mArrayListData.clear();
        JSONObject jsonobject = new JSONObject(strJsonRssRep);
        intent = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        top_id = jsonobject.getString("top_id");
        countKomOld = 0;
        if (strKonekStat.equals("-")) goto _L6; else goto _L5
_L5:
        i = 0;
_L14:
        try
        {
            j = intent.length();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
            strKonekStat = "0";
            continue; /* Loop/switch isn't completed */
        }
        if (i < j) goto _L7; else goto _L6
_L6:
        Log.e("countKomOld", String.valueOf(countKomOld));
        layout_header.setVisibility(8);
        JSONObject jsonobject1;
        if (countKomOld < 15)
        {
            txtbtnheader.setVisibility(8);
        } else
        {
            txtbtnheader.setVisibility(0);
        }
        if (strKonekStat.equals("-")) goto _L9; else goto _L8
_L8:
        i = 0;
_L12:
        if (i < mArrayListData.size()) goto _L11; else goto _L10
_L10:
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    limit = 0;
                    urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                    Log.e("urlKomenTwOld", urlKomenTwOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarNewAsycTask()).execute(new String[0]);
                return;
            }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                    Log.e("urlKomenTwLast", urlKomenTwLast);
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
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                this$0 = KomentarTwitter.this;
                super();
            }
        });
_L4:
        return;
_L7:
        countAllKom = countAllKom + 1;
        countKomOld = countKomOld + 1;
        jsonobject1 = intent.getJSONObject(i);
        mArrayListData.add(0, new ItemTwKomen(jsonobject1.getString("id_komtw"), jsonobject1.getString("id_tw"), jsonobject1.getString("id_user"), jsonobject1.getString("id_user_to"), jsonobject1.getString("komen_tw"), jsonobject1.getString("tanggal_kom"), jsonobject1.getString("user_photo"), jsonobject1.getString("user_name"), jsonobject1.getString("tanggal_to"), jsonobject1.getString("total_like"), jsonobject1.getString("total_dislike"), jsonobject1.getString("my_like_kom"), jsonobject1.getString("user_name_to"), jsonobject1.getString("komen_to")));
        i++;
        continue; /* Loop/switch isn't completed */
_L11:
        intent = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fc, null);
        txtUsername = (TextView)intent.findViewById(0x7f0b0419);
        lay_quote = (LinearLayout)intent.findViewById(0x7f0b063a);
        img_kom_picture = (ImageView)intent.findViewById(0x7f0b054b);
        txtIdKom = (TextView)intent.findViewById(0x7f0b054d);
        txtKomentar = (TextViewFixTouchConsume)intent.findViewById(0x7f0b054e);
        txtUsernameQoute = (TextView)intent.findViewById(0x7f0b063b);
        txtKomentarQoute = (TextViewFixTouchConsume)intent.findViewById(0x7f0b063d);
        txtWaktu = (TextView)intent.findViewById(0x7f0b054c);
        txtWaktuQoute = (TextView)intent.findViewById(0x7f0b063c);
        txtTanggapan = (TextView)intent.findViewById(0x7f0b0555);
        ImageView imageview = (ImageView)intent.findViewById(0x7f0b054f);
        ImageView imageview1 = (ImageView)intent.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)intent.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)intent.findViewById(0x7f0b0554);
        headName = (LinearLayout)intent.findViewById(0x7f0b0549);
        list_lay_like = (RelativeLayout)intent.findViewById(0x7f0b0342);
        list_lay_dislike = (RelativeLayout)intent.findViewById(0x7f0b0345);
        list_lay_rep = (RelativeLayout)intent.findViewById(0x7f0b063f);
        final String id_komtw = ((ItemTwKomen)mArrayListData.get(i)).getId_komtw();
        final String id_tw = ((ItemTwKomen)mArrayListData.get(i)).getId_tw();
        ((ItemTwKomen)mArrayListData.get(i)).getId_user();
        ((ItemTwKomen)mArrayListData.get(i)).getId_user_to();
        final String komen_tw = ((ItemTwKomen)mArrayListData.get(i)).getKomen_tw();
        final String tanggal_kom = ((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom();
        final String user_photo = ((ItemTwKomen)mArrayListData.get(i)).getUser_photo();
        final String user_name = ((ItemTwKomen)mArrayListData.get(i)).getUser_name();
        ((ItemTwKomen)mArrayListData.get(i)).getTanggal_to();
        ((ItemTwKomen)mArrayListData.get(i)).getTotal_like();
        ((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike();
        ((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom();
        ((ItemTwKomen)mArrayListData.get(i)).getKomen_to();
        ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to();
        if (((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemTwKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals(""))
        {
            lay_quote.setVisibility(8);
        } else
        {
            lay_quote.setVisibility(0);
        }
        if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1"))
        {
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
        } else
        if (((ItemTwKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
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
        if (((ItemTwKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
        {
            try
            {
                Picasso.with(this).load(((ItemTwKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

                    final KomentarTwitter this$0;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        img_kom_picture.setVisibility(0);
                    }

            
            {
                this$0 = KomentarTwitter.this;
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
        txtIdKom.setText(((ItemTwKomen)mArrayListData.get(i)).getId_komtw().toString());
        txtdisLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_dislike().toString());
        txtLikeKom.setText(((ItemTwKomen)mArrayListData.get(i)).getTotal_like().toString());
        txtUsername.setText(((ItemTwKomen)mArrayListData.get(i)).getUser_name());
        txtKomentar.setText(Html.fromHtml(Utility.parseTweet(((ItemTwKomen)mArrayListData.get(i)).getKomen_tw())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)mArrayListData.get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)mArrayListData.get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)mArrayListData.get(i)).getTanggal_to()));
        Log.e("counter old", String.valueOf(i));
        mLinearListView.addView(intent, 0);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarTwitter this$0;
            private final String val$user_photo;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(user_photo.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent1 = new Intent(KomentarTwitter.this, com/inponsel/android/v2/ImagePagerActivity);
                intent1.putExtra("imgUrl", view);
                intent1.putExtra("pos", 0);
                startActivity(intent1);
                return false;
            }

            
            {
                this$0 = KomentarTwitter.this;
                user_photo = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;
            private final String val$user_name;

            public void onClick(View view)
            {
                view = new Intent(KomentarTwitter.this, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", user_name);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = KomentarTwitter.this;
                user_name = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;
            private final String val$id_komtw;
            private final String val$id_tw;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(KomentarTwitter.this))
                {
                    statuslike = "1";
                    idkom_pos = id_komtw;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = KomentarTwitter.this;
                id_komtw = s;
                id_tw = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;
            private final String val$id_komtw;
            private final String val$id_tw;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(KomentarTwitter.this))
                {
                    statuslike = "0";
                    idkom_pos = id_komtw;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = KomentarTwitter.this;
                id_komtw = s;
                id_tw = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;
            private final String val$id_komtw;
            private final String val$id_tw;
            private final String val$komen_tw;
            private final String val$tanggal_kom;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(KomentarTwitter.this))
                {
                    view = new Intent(KomentarTwitter.this, com/inponsel/android/details/ReplyKomTwActivity);
                    view.putExtra("tw_name", tw_name);
                    view.putExtra("id_tw", id_tw);
                    view.putExtra("id_komtw", id_komtw);
                    view.putExtra("user_id", user_id);
                    view.putExtra("user_name", user_name);
                    view.putExtra("tanggal_kom", tanggal_kom);
                    view.putExtra("komen_tw", komen_tw);
                    view.putExtra("user_photo", user_photo);
                    view.putExtra("top_id", top_id);
                    Log.e("id_komtw_to", id_komtw);
                    startActivityForResult(view, KomentarTwitter.POST_STAT);
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = KomentarTwitter.this;
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = s5;
                super();
            }
        });
        intent.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        i++;
        if (true) goto _L12; else goto _L9
_L9:
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    limit = 0;
                    urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                    Log.e("urlKomenTwOld", urlKomenTwOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarNewAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarNewAsycTask()).execute(new String[0]);
                return;
            }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                    Log.e("urlKomenTwLast", urlKomenTwLast);
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
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
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
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        layout_empty.setVisibility(0);
        pop_progressbar_middle.setVisibility(8);
        pop_txt_empty.setVisibility(0);
        pop_txt_empty.setText("Belum ada komentar");
        return;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("onActivityResult", "false");
        return;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300a0);
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
        id_tw = extras.getString("id_tw");
        tw_name = extras.getString("tw_name");
        tweet_content = extras.getString("tweet_content");
        media_url = extras.getString("media_url");
        avatar = extras.getString("avatar");
        tweet_time = extras.getString("tweet_time");
        screen_name = extras.getString("screen_name");
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Komentar ")).append(tw_name).toString());
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
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode((new StringBuilder("Komentar ")).append(tw_name).toString())).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(URLDecoder.decode((new StringBuilder("Komentar ")).append(tw_name).toString()));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeHelper(this);
        mNotificationHelper = new NotificationKomenHelper(this);
        progbar_notifHP = (SmoothProgressBar)findViewById(0x7f0b04cb);
        progbar_notifHP.setVisibility(8);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        mArrayListData = new ArrayList();
        txtbtnheader = (TextView)findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        layout_header = (LinearLayout)findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)findViewById(0x7f0b04d3);
        lay_pop_komen = (RelativeLayout)findViewById(0x7f0b04da);
        btn_pop_login = (Button)findViewById(0x7f0b04e1);
        btn_pop_login.setSelected(true);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)findViewById(0x7f0b052d);
        pop_progressbar_middle = (ProgressBar)findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        btnRefresh = (Button)findViewById(0x7f0b04d0);
        txtUsernameHead = (TextView)findViewById(0x7f0b0419);
        img_kom_pictureHead = (ImageView)findViewById(0x7f0b054b);
        imageMediaHead = (ImageView)findViewById(0x7f0b046c);
        txtIdKomHead = (TextView)findViewById(0x7f0b054d);
        txtKomentarHead = (TextView)findViewById(0x7f0b054e);
        txtWaktuHead = (TextView)findViewById(0x7f0b054c);
        txtUsernameHead.setText(screen_name);
        txtIdKomHead.setText(id_tw);
        txtKomentarHead.setText(Html.fromHtml(Utility.parseTweet(tweet_content)));
        txtKomentarHead.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtWaktuHead.setText(Utility.convertDate(tweet_time));
        Log.e("avatartw", avatar);
        try
        {
            Picasso.with(this).load(avatar.trim()).into(img_kom_pictureHead, new Callback() {

                final KomentarTwitter this$0;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_kom_pictureHead.setVisibility(0);
                }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        if (media_url.equals("") || media_url.equals("-"))
        {
            imageMediaHead.setVisibility(8);
        } else
        {
            try
            {
                Picasso.with(this).load(media_url.trim()).into(imageMediaHead, new Callback() {

                    final KomentarTwitter this$0;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        imageMediaHead.setVisibility(0);
                    }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter this$0;

            public void onClick(View view)
            {
                view = new Intent(KomentarTwitter.this, com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = KomentarTwitter.this;
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

            final KomentarTwitter this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    komencount = edt_pop_komen.getText().toString();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
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
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    komencount = edt_pop_komen.getText().toString();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
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
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
        });
        try
        {
            urlKomenTw = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
            Log.e("urlKomenTw", urlKomenTw);
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
        getSupportMenuInflater().inflate(0x7f0f000d, menu);
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
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 34
    //                   2131429697: 51;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        continue; /* Loop/switch isn't completed */
_L3:
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            android.app.AlertDialog.Builder builder;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                menuitem = "Non aktifkan notifikasi komentar untuk tweet ini ?";
            } else
            {
                statusKomen = "1";
                menuitem = "Aktifkan notifikasi komentar untuk tweet ini ?";
            }
            Log.e("statusKomen", statusKomen);
            builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Perhatian");
            builder.setMessage(menuitem);
            builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
            });
            builder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter this$0;

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
                this$0 = KomentarTwitter.this;
                super();
            }
            });
            builder.show();
        } else
        {
            menuitem = new android.app.AlertDialog.Builder(wrapperLight);
            menuitem.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            menuitem.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
            });
            menuitem.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface = new Intent(KomentarTwitter.this, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
            });
            menuitem.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface = new Intent(KomentarTwitter.this, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = KomentarTwitter.this;
                super();
            }
            });
            menuitem.show();
        }
        if (true) goto _L1; else goto _L4
_L4:
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
