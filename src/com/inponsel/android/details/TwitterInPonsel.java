// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.util.Base64;
import android.view.ContextThemeWrapper;
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
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemTwitter;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeTwHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter

public class TwitterInPonsel extends SherlockFragmentActivity
    implements Observer
{
    public class FavoritTask extends AsyncTask
    {

        final TwitterInPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idtw=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favtw").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
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
            updateViewTWFav(idkom_pos, res);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (stat.equals("1"))
            {
                mDialog = ProgressDialog.show(TwitterInPonsel.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(TwitterInPonsel.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = TwitterInPonsel.this;
            super();
        }
    }

    public class KomentarAsycTask extends AsyncTask
    {

        final TwitterInPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_279;
            }
            Object obj = TwitterInPonsel.this;
            obj.countAllKom = ((TwitterInPonsel) (obj)).countAllKom + 1;
            obj = TwitterInPonsel.this;
            obj.countKomOld = ((TwitterInPonsel) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemTwitter(((JSONObject) (obj)).getString("since_id"), ((JSONObject) (obj)).getString("tweet_content"), ((JSONObject) (obj)).getString("media_url"), ((JSONObject) (obj)).getString("avatar"), ((JSONObject) (obj)).getString("tweet_time"), ((JSONObject) (obj)).getString("real_name"), ((JSONObject) (obj)).getString("screen_name"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_dislike"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_tweet"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_tweet")));
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
                int i = 0;
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
                                    limit = 0;
                                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                                    limit = 0;
                                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                    void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300cb, null);
                    txtUsername = (TextView)void1.findViewById(0x7f0b0419);
                    img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
                    imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
                    txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
                    txtKomentar = (TextView)void1.findViewById(0x7f0b054e);
                    txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
                    txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
                    txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
                    ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
                    ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
                    txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
                    txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
                    txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
                    bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
                    list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
                    list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
                    list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
                    final String since_id = ((ItemTwitter)mArrayListData.get(i)).getSince_id();
                    final String tweet_content = ((ItemTwitter)mArrayListData.get(i)).getTweet_content();
                    final String media_url = ((ItemTwitter)mArrayListData.get(i)).getMedia_url();
                    final String avatar = ((ItemTwitter)mArrayListData.get(i)).getAvatar();
                    final String tweet_time = ((ItemTwitter)mArrayListData.get(i)).getTweet_time();
                    String s1 = ((ItemTwitter)mArrayListData.get(i)).getReal_name();
                    String s = ((ItemTwitter)mArrayListData.get(i)).getScreen_name();
                    String s2 = ((ItemTwitter)mArrayListData.get(i)).getTotal_like();
                    String s3 = ((ItemTwitter)mArrayListData.get(i)).getTotal_dislike();
                    String s4 = ((ItemTwitter)mArrayListData.get(i)).getTotal_komen();
                    ((ItemTwitter)mArrayListData.get(i)).getTotal_komen();
                    String s5 = ((ItemTwitter)mArrayListData.get(i)).getMy_like_tweet();
                    String s6 = ((ItemTwitter)mArrayListData.get(i)).getMy_fav_tweet();
                    if (twitter.toLowerCase().equals("inponsel"))
                    {
                        bottom_list.setVisibility(0);
                    } else
                    {
                        bottom_list.setVisibility(8);
                    }
                    txtIdKom.setText(since_id);
                    txtUsername.setText(Html.fromHtml((new StringBuilder("<font color='#000000'>")).append(s1).append("</font>").append("<small><font color='#cacaca'>").append("<br>@").append(s).append("</font><small>").toString()));
                    txtImgAva.setText(avatar);
                    txtImgMedia.setText(media_url);
                    txtKomentar.setText(Html.fromHtml(Utility.parseTweet(tweet_content)));
                    txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                    txtLikeKom.setText(s2);
                    txtdisLikeKom.setText(s3);
                    txtTotalKom.setText(s4);
                    if (s5.toString().equals("1"))
                    {
                        imageview.setBackgroundResource(0x7f020264);
                        list_lay_like.setEnabled(false);
                        list_lay_dislike.setEnabled(true);
                    } else
                    if (s5.toString().equals("0"))
                    {
                        imageview.setBackgroundResource(0x7f020265);
                        list_lay_like.setEnabled(true);
                        list_lay_dislike.setEnabled(false);
                    } else
                    {
                        list_lay_like.setEnabled(true);
                        list_lay_dislike.setEnabled(true);
                        imageview.setBackgroundResource(0x7f020265);
                        list_lay_like.setBackgroundResource(0x7f020079);
                        list_lay_dislike.setBackgroundResource(0x7f020079);
                    }
                    if (s6.toString().equals("1"))
                    {
                        imageview1.setBackgroundResource(0x7f020303);
                    } else
                    if (s6.toString().equals("0"))
                    {
                        imageview1.setBackgroundResource(0x7f020302);
                    } else
                    {
                        imageview1.setBackgroundResource(0x7f020302);
                    }
                    try
                    {
                        Picasso.with(TwitterInPonsel.this).load(((ItemTwitter)mArrayListData.get(i)).getAvatar().toString().trim()).into(img_kom_picture, new Callback() {

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
                    if (((ItemTwitter)mArrayListData.get(i)).getMedia_url().trim().equals(""))
                    {
                        imageMedia.setVisibility(8);
                    } else
                    {
                        try
                        {
                            Picasso.with(TwitterInPonsel.this).load(((ItemTwitter)mArrayListData.get(i)).getMedia_url().toString().trim()).into(imageMedia, new Callback() {

                                final KomentarAsycTask this$1;

                                public void onError()
                                {
                                }

                                public void onSuccess()
                                {
                                    imageMedia.setVisibility(0);
                                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
                            });
                        }
                        catch (Exception exception1)
                        {
                            exception1.printStackTrace();
                        }
                    }
                    txtWaktu.setText(Utility.convertDate(((ItemTwitter)mArrayListData.get(i)).getTweet_time()));
                    mLinearListView.addView(void1);
                    imageMedia.setOnClickListener(media_url. new android.view.View.OnClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$media_url;

                        public void onClick(View view)
                        {
                            view = new ArrayList();
                            view.add(media_url);
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                            intent.putExtra("imgUrl", view);
                            intent.putExtra("pos", 0);
                            startActivity(intent);
                        }

            
            {
                this$1 = final_komentarasyctask;
                media_url = String.this;
                super();
            }
                    });
                    img_kom_picture.setOnLongClickListener(avatar. new android.view.View.OnLongClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$avatar;

                        public boolean onLongClick(View view)
                        {
                            view = new ArrayList();
                            view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(avatar.toString().trim()).toString());
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                            intent.putExtra("imgUrl", view);
                            intent.putExtra("pos", 0);
                            startActivity(intent);
                            return false;
                        }

            
            {
                this$1 = final_komentarasyctask;
                avatar = String.this;
                super();
            }
                    });
                    list_lay_like.setOnClickListener(since_id. new android.view.View.OnClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$since_id;

                        public void onClick(View view)
                        {
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                statuslike = "1";
                                idkom_pos = since_id;
                                querylike = (new StringBuilder("status=")).append(statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                since_id = String.this;
                super();
            }
                    });
                    list_lay_dislike.setOnClickListener(since_id. new android.view.View.OnClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$since_id;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                if (db.checkIfExistTW(idkom_pos))
                                {
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setMessage("Hapus tweet ini dari favorit?");
                                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                        final KomentarAsycTask._cls6 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            dialoginterface.dismiss();
                                            stat = "0";
                                            (new FavoritTask()).execute(new Void[0]);
                                        }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                                    });
                                    view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                                    view.show();
                                    return;
                                } else
                                {
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setMessage("Favoritkan tweet ini?");
                                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                        final KomentarAsycTask._cls6 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            stat = "1";
                                            (new FavoritTask()).execute(new Void[0]);
                                        }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                                    });
                                    view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                                    view.show();
                                    return;
                                }
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(wrapperLight);
                                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
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
                since_id = String.this;
                super();
            }
                    });
                    list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$avatar;
                        private final String val$media_url;
                        private final String val$screen_name;
                        private final String val$since_id;
                        private final String val$tweet_content;
                        private final String val$tweet_time;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            view = new Intent(_fld0, com/inponsel/android/details/KomentarTwitter);
                            view.putExtra("tw_name", twitter);
                            view.putExtra("id_tw", idkom_pos);
                            view.putExtra("tweet_content", tweet_content);
                            view.putExtra("media_url", media_url);
                            view.putExtra("avatar", avatar);
                            view.putExtra("tweet_time", tweet_time);
                            view.putExtra("screen_name", screen_name);
                            startActivity(view);
                        }

            
            {
                this$1 = final_komentarasyctask;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = String.this;
                super();
            }
                    });
                    void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarAsycTask this$1;
                        private final String val$avatar;
                        private final String val$media_url;
                        private final String val$screen_name;
                        private final String val$since_id;
                        private final String val$tweet_content;
                        private final String val$tweet_time;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            view = new Intent(_fld0, com/inponsel/android/details/KomentarTwitter);
                            view.putExtra("tw_name", twitter);
                            view.putExtra("id_tw", idkom_pos);
                            view.putExtra("tweet_content", tweet_content);
                            view.putExtra("media_url", media_url);
                            view.putExtra("avatar", avatar);
                            view.putExtra("tweet_time", tweet_time);
                            view.putExtra("screen_name", screen_name);
                            startActivity(view);
                        }

            
            {
                this$1 = final_komentarasyctask;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = String.this;
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
                            limit = 0;
                            urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                            limit = 0;
                            urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            Log.e("KomentarAsycTask", "onPreExecute");
        }


        public KomentarAsycTask()
        {
            this$0 = TwitterInPonsel.this;
            super();
        }
    }

    public class KomentarNextAsycTask extends AsyncTask
    {

        final TwitterInPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenLast));
            as = jsonobject.getJSONArray("InPonsel");
            top_id = jsonobject.getString("top_id");
            Log.e("top_id", top_id);
            countKomOld = 0;
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_247;
            }
            Object obj = TwitterInPonsel.this;
            obj.countAllKom = ((TwitterInPonsel) (obj)).countAllKom + 1;
            obj = TwitterInPonsel.this;
            obj.countKomOld = ((TwitterInPonsel) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(0, new ItemTwitter(((JSONObject) (obj)).getString("since_id"), ((JSONObject) (obj)).getString("tweet_content"), ((JSONObject) (obj)).getString("media_url"), ((JSONObject) (obj)).getString("avatar"), ((JSONObject) (obj)).getString("tweet_time"), ((JSONObject) (obj)).getString("real_name"), ((JSONObject) (obj)).getString("screen_name"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_dislike"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_tweet"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_tweet")));
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
            if (!strKonekStat.equals("-"))
            {
                int i = 0;
                do
                {
                    if (i >= mArrayListData.size())
                    {
                        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarNextAsycTask this$1;

                            public void onClick(View view)
                            {
                                try
                                {
                                    txtbtnheader.setVisibility(8);
                                    limit = 0;
                                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarNextAsycTask this$1;

                            public void onClick(View view)
                            {
                                try
                                {
                                    limit = 0;
                                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                        layout_empty.setVisibility(8);
                        scrollviewKomen.setVisibility(0);
                        return;
                    }
                    void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300cb, null);
                    txtUsername = (TextView)void1.findViewById(0x7f0b0419);
                    img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
                    imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
                    txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
                    txtKomentar = (TextView)void1.findViewById(0x7f0b054e);
                    txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
                    txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
                    txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
                    ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
                    ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
                    txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
                    txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
                    txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
                    bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
                    list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
                    list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
                    list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
                    final String since_id = ((ItemTwitter)mArrayListData.get(i)).getSince_id();
                    final String tweet_content = ((ItemTwitter)mArrayListData.get(i)).getTweet_content();
                    final String media_url = ((ItemTwitter)mArrayListData.get(i)).getMedia_url();
                    final String avatar = ((ItemTwitter)mArrayListData.get(i)).getAvatar();
                    final String tweet_time = ((ItemTwitter)mArrayListData.get(i)).getTweet_time();
                    String s1 = ((ItemTwitter)mArrayListData.get(i)).getReal_name();
                    String s = ((ItemTwitter)mArrayListData.get(i)).getScreen_name();
                    String s2 = ((ItemTwitter)mArrayListData.get(i)).getTotal_like();
                    String s3 = ((ItemTwitter)mArrayListData.get(i)).getTotal_dislike();
                    String s4 = ((ItemTwitter)mArrayListData.get(i)).getTotal_komen();
                    ((ItemTwitter)mArrayListData.get(i)).getTotal_komen();
                    String s5 = ((ItemTwitter)mArrayListData.get(i)).getMy_like_tweet();
                    String s6 = ((ItemTwitter)mArrayListData.get(i)).getMy_fav_tweet();
                    if (twitter.toLowerCase().equals("inponsel"))
                    {
                        bottom_list.setVisibility(0);
                    } else
                    {
                        bottom_list.setVisibility(8);
                    }
                    txtIdKom.setText(since_id);
                    txtUsername.setText(Html.fromHtml((new StringBuilder("<font color='#000000'>")).append(s1).append("</font>").append("<small><font color='#cacaca'>").append("<br>@").append(s).append("</font><small>").toString()));
                    txtImgAva.setText(avatar);
                    txtImgMedia.setText(media_url);
                    txtKomentar.setText(Html.fromHtml(Utility.parseTweet(tweet_content)));
                    txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                    txtLikeKom.setText(s2);
                    txtdisLikeKom.setText(s3);
                    txtTotalKom.setText(s4);
                    if (s5.toString().equals("1"))
                    {
                        imageview.setBackgroundResource(0x7f020264);
                        list_lay_like.setEnabled(false);
                        list_lay_dislike.setEnabled(true);
                    } else
                    if (s5.toString().equals("0"))
                    {
                        imageview.setBackgroundResource(0x7f020265);
                        imageview1.setBackgroundResource(0x7f0201a7);
                        list_lay_like.setEnabled(true);
                        list_lay_dislike.setEnabled(false);
                    } else
                    {
                        list_lay_like.setEnabled(true);
                        list_lay_dislike.setEnabled(true);
                        imageview.setBackgroundResource(0x7f020265);
                        list_lay_like.setBackgroundResource(0x7f020079);
                        list_lay_dislike.setBackgroundResource(0x7f020079);
                    }
                    if (s6.toString().equals("1"))
                    {
                        imageview1.setBackgroundResource(0x7f020303);
                    } else
                    if (s6.toString().equals("0"))
                    {
                        imageview1.setBackgroundResource(0x7f020302);
                    } else
                    {
                        imageview1.setBackgroundResource(0x7f020302);
                    }
                    try
                    {
                        Picasso.with(TwitterInPonsel.this).load(((ItemTwitter)mArrayListData.get(i)).getAvatar().toString().trim()).into(img_kom_picture, new Callback() {

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
                    if (((ItemTwitter)mArrayListData.get(i)).getMedia_url().trim().equals(""))
                    {
                        imageMedia.setVisibility(8);
                    } else
                    {
                        try
                        {
                            Picasso.with(TwitterInPonsel.this).load(((ItemTwitter)mArrayListData.get(i)).getMedia_url().toString().trim()).into(imageMedia, new Callback() {

                                final KomentarNextAsycTask this$1;

                                public void onError()
                                {
                                }

                                public void onSuccess()
                                {
                                    imageMedia.setVisibility(0);
                                }

            
            {
                this$1 = KomentarNextAsycTask.this;
                super();
            }
                            });
                        }
                        catch (Exception exception1)
                        {
                            exception1.printStackTrace();
                        }
                    }
                    txtWaktu.setText(Utility.convertDate(((ItemTwitter)mArrayListData.get(i)).getTweet_time()));
                    mLinearListView.addView(void1, 0);
                    imageMedia.setOnClickListener(media_url. new android.view.View.OnClickListener() {

                        final KomentarNextAsycTask this$1;
                        private final String val$media_url;

                        public void onClick(View view)
                        {
                            view = new ArrayList();
                            view.add(media_url);
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                            intent.putExtra("imgUrl", view);
                            intent.putExtra("pos", 0);
                            startActivity(intent);
                        }

            
            {
                this$1 = final_komentarnextasyctask;
                media_url = String.this;
                super();
            }
                    });
                    img_kom_picture.setOnLongClickListener(avatar. new android.view.View.OnLongClickListener() {

                        final KomentarNextAsycTask this$1;
                        private final String val$avatar;

                        public boolean onLongClick(View view)
                        {
                            view = new ArrayList();
                            view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(avatar.toString().trim()).toString());
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                            intent.putExtra("imgUrl", view);
                            intent.putExtra("pos", 0);
                            startActivity(intent);
                            return false;
                        }

            
            {
                this$1 = final_komentarnextasyctask;
                avatar = String.this;
                super();
            }
                    });
                    list_lay_like.setOnClickListener(since_id. new android.view.View.OnClickListener() {

                        final KomentarNextAsycTask this$1;
                        private final String val$since_id;

                        public void onClick(View view)
                        {
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                statuslike = "1";
                                idkom_pos = since_id;
                                querylike = (new StringBuilder("status=")).append(statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                since_id = String.this;
                super();
            }
                    });
                    list_lay_dislike.setOnClickListener(since_id. new android.view.View.OnClickListener() {

                        final KomentarNextAsycTask this$1;
                        private final String val$since_id;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                if (db.checkIfExistTW(idkom_pos))
                                {
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setMessage("Hapus tweet ini dari favorit?");
                                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                        final KomentarNextAsycTask._cls6 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            dialoginterface.dismiss();
                                            stat = "0";
                                            (new FavoritTask()).execute(new Void[0]);
                                        }

            
            {
                this$2 = KomentarNextAsycTask._cls6.this;
                super();
            }
                                    });
                                    view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                                    view.show();
                                    return;
                                } else
                                {
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setMessage("Favoritkan tweet ini?");
                                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                        final KomentarNextAsycTask._cls6 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            stat = "1";
                                            (new FavoritTask()).execute(new Void[0]);
                                        }

            
            {
                this$2 = KomentarNextAsycTask._cls6.this;
                super();
            }
                                    });
                                    view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                                    view.show();
                                    return;
                                }
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(wrapperLight);
                                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
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
                since_id = String.this;
                super();
            }
                    });
                    list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarNextAsycTask this$1;
                        private final String val$avatar;
                        private final String val$media_url;
                        private final String val$screen_name;
                        private final String val$since_id;
                        private final String val$tweet_content;
                        private final String val$tweet_time;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            view = new Intent(_fld0, com/inponsel/android/details/KomentarTwitter);
                            view.putExtra("tw_name", twitter);
                            view.putExtra("id_tw", idkom_pos);
                            view.putExtra("tweet_content", tweet_content);
                            view.putExtra("media_url", media_url);
                            view.putExtra("avatar", avatar);
                            view.putExtra("tweet_time", tweet_time);
                            view.putExtra("screen_name", screen_name);
                            startActivity(view);
                        }

            
            {
                this$1 = final_komentarnextasyctask;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = String.this;
                super();
            }
                    });
                    void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarNextAsycTask this$1;
                        private final String val$avatar;
                        private final String val$media_url;
                        private final String val$screen_name;
                        private final String val$since_id;
                        private final String val$tweet_content;
                        private final String val$tweet_time;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            view = new Intent(_fld0, com/inponsel/android/details/KomentarTwitter);
                            view.putExtra("tw_name", twitter);
                            view.putExtra("id_tw", idkom_pos);
                            view.putExtra("tweet_content", tweet_content);
                            view.putExtra("media_url", media_url);
                            view.putExtra("avatar", avatar);
                            view.putExtra("tweet_time", tweet_time);
                            view.putExtra("screen_name", screen_name);
                            startActivity(view);
                        }

            
            {
                this$1 = final_komentarnextasyctask;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = String.this;
                super();
            }
                    });
                    i++;
                } while (true);
            } else
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarNextAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarNextAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            limit = 0;
                            urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(0);
            mArrayListData.clear();
        }


        public KomentarNextAsycTask()
        {
            this$0 = TwitterInPonsel.this;
            super();
        }
    }

    public class KomentarOldAsycTask extends AsyncTask
    {

        final TwitterInPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenOld));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_259;
            }
            Object obj = TwitterInPonsel.this;
            obj.countAllKom = ((TwitterInPonsel) (obj)).countAllKom + 1;
            obj = TwitterInPonsel.this;
            obj.countKomOld = ((TwitterInPonsel) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemTwitter(((JSONObject) (obj)).getString("since_id"), ((JSONObject) (obj)).getString("tweet_content"), ((JSONObject) (obj)).getString("media_url"), ((JSONObject) (obj)).getString("avatar"), ((JSONObject) (obj)).getString("tweet_time"), ((JSONObject) (obj)).getString("real_name"), ((JSONObject) (obj)).getString("screen_name"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_dislike"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_tweet"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_tweet")));
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
            Log.e("mArrayListDataOld", String.valueOf(mArrayListData.size()));
            if (!strKonekStat.equals("-"))
            {
                int i = 0;
                do
                {
                    if (i >= mArrayListData.size())
                    {
                        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarOldAsycTask this$1;

                            public void onClick(View view)
                            {
                                try
                                {
                                    txtbtnheader.setVisibility(8);
                                    limit = 0;
                                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                this$1 = KomentarOldAsycTask.this;
                super();
            }
                        });
                        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                            final KomentarOldAsycTask this$1;

                            public void onClick(View view)
                            {
                                try
                                {
                                    limit = 0;
                                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                this$1 = KomentarOldAsycTask.this;
                super();
            }
                        });
                        layout_empty.setVisibility(8);
                        scrollviewKomen.setVisibility(0);
                        return;
                    }
                    void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300cb, null);
                    txtUsername = (TextView)void1.findViewById(0x7f0b0419);
                    img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
                    imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
                    txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
                    txtKomentar = (TextView)void1.findViewById(0x7f0b054e);
                    txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
                    txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
                    txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
                    ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
                    ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
                    txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
                    txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
                    txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
                    bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
                    list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
                    list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
                    list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
                    final String since_id = ((ItemTwitter)mArrayListData.get(i)).getSince_id();
                    final String tweet_content = ((ItemTwitter)mArrayListData.get(i)).getTweet_content();
                    final String media_url = ((ItemTwitter)mArrayListData.get(i)).getMedia_url();
                    final String avatar = ((ItemTwitter)mArrayListData.get(i)).getAvatar();
                    final String tweet_time = ((ItemTwitter)mArrayListData.get(i)).getTweet_time();
                    String s1 = ((ItemTwitter)mArrayListData.get(i)).getReal_name();
                    String s = ((ItemTwitter)mArrayListData.get(i)).getScreen_name();
                    String s2 = ((ItemTwitter)mArrayListData.get(i)).getTotal_like();
                    String s3 = ((ItemTwitter)mArrayListData.get(i)).getTotal_dislike();
                    String s4 = ((ItemTwitter)mArrayListData.get(i)).getTotal_komen();
                    ((ItemTwitter)mArrayListData.get(i)).getTotal_komen();
                    String s5 = ((ItemTwitter)mArrayListData.get(i)).getMy_like_tweet();
                    String s6 = ((ItemTwitter)mArrayListData.get(i)).getMy_fav_tweet();
                    if (twitter.toLowerCase().equals("inponsel"))
                    {
                        bottom_list.setVisibility(0);
                    } else
                    {
                        bottom_list.setVisibility(8);
                    }
                    txtIdKom.setText(since_id);
                    txtUsername.setText(Html.fromHtml((new StringBuilder("<font color='#000000'>")).append(s1).append("</font>").append("<small><font color='#cacaca'>").append("<br>@").append(s).append("</font><small>").toString()));
                    txtImgAva.setText(avatar);
                    txtImgMedia.setText(media_url);
                    txtKomentar.setText(Html.fromHtml(Utility.parseTweet(tweet_content)));
                    txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                    txtLikeKom.setText(s2);
                    txtdisLikeKom.setText(s3);
                    txtTotalKom.setText(s4);
                    if (s5.toString().equals("1"))
                    {
                        imageview.setBackgroundResource(0x7f020264);
                        list_lay_like.setEnabled(false);
                        list_lay_dislike.setEnabled(true);
                    } else
                    if (s5.toString().equals("0"))
                    {
                        imageview.setBackgroundResource(0x7f020265);
                        imageview1.setBackgroundResource(0x7f0201a7);
                        list_lay_like.setEnabled(true);
                        list_lay_dislike.setEnabled(false);
                    } else
                    {
                        list_lay_like.setEnabled(true);
                        list_lay_dislike.setEnabled(true);
                        imageview.setBackgroundResource(0x7f020265);
                        list_lay_like.setBackgroundResource(0x7f020079);
                        list_lay_dislike.setBackgroundResource(0x7f020079);
                    }
                    if (s6.toString().equals("1"))
                    {
                        imageview1.setBackgroundResource(0x7f020303);
                    } else
                    if (s6.toString().equals("0"))
                    {
                        imageview1.setBackgroundResource(0x7f020302);
                    } else
                    {
                        imageview1.setBackgroundResource(0x7f020302);
                    }
                    try
                    {
                        Picasso.with(TwitterInPonsel.this).load(((ItemTwitter)mArrayListData.get(i)).getAvatar().toString().trim()).into(img_kom_picture, new Callback() {

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
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    if (((ItemTwitter)mArrayListData.get(i)).getMedia_url().trim().equals(""))
                    {
                        imageMedia.setVisibility(8);
                    } else
                    {
                        try
                        {
                            Picasso.with(TwitterInPonsel.this).load(((ItemTwitter)mArrayListData.get(i)).getMedia_url().toString().trim()).into(imageMedia, new Callback() {

                                final KomentarOldAsycTask this$1;

                                public void onError()
                                {
                                }

                                public void onSuccess()
                                {
                                    imageMedia.setVisibility(0);
                                }

            
            {
                this$1 = KomentarOldAsycTask.this;
                super();
            }
                            });
                        }
                        catch (Exception exception1)
                        {
                            exception1.printStackTrace();
                        }
                    }
                    txtWaktu.setText(Utility.convertDate(((ItemTwitter)mArrayListData.get(i)).getTweet_time()));
                    mLinearListView.addView(void1, mLinearListView.getChildCount());
                    imageMedia.setOnClickListener(media_url. new android.view.View.OnClickListener() {

                        final KomentarOldAsycTask this$1;
                        private final String val$media_url;

                        public void onClick(View view)
                        {
                            view = new ArrayList();
                            view.add(media_url);
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                            intent.putExtra("imgUrl", view);
                            intent.putExtra("pos", 0);
                            startActivity(intent);
                        }

            
            {
                this$1 = final_komentaroldasyctask;
                media_url = String.this;
                super();
            }
                    });
                    img_kom_picture.setOnLongClickListener(avatar. new android.view.View.OnLongClickListener() {

                        final KomentarOldAsycTask this$1;
                        private final String val$avatar;

                        public boolean onLongClick(View view)
                        {
                            view = new ArrayList();
                            view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(avatar.toString().trim()).toString());
                            view = (String[])view.toArray(new String[view.size()]);
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                            intent.putExtra("imgUrl", view);
                            intent.putExtra("pos", 0);
                            startActivity(intent);
                            return false;
                        }

            
            {
                this$1 = final_komentaroldasyctask;
                avatar = String.this;
                super();
            }
                    });
                    list_lay_like.setOnClickListener(since_id. new android.view.View.OnClickListener() {

                        final KomentarOldAsycTask this$1;
                        private final String val$since_id;

                        public void onClick(View view)
                        {
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                statuslike = "1";
                                idkom_pos = since_id;
                                querylike = (new StringBuilder("status=")).append(statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                since_id = String.this;
                super();
            }
                    });
                    list_lay_dislike.setOnClickListener(since_id. new android.view.View.OnClickListener() {

                        final KomentarOldAsycTask this$1;
                        private final String val$since_id;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            if (userFunctions.isUserLoggedIn(_fld0))
                            {
                                if (db.checkIfExistTW(idkom_pos))
                                {
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setMessage("Hapus tweet ini dari favorit?");
                                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                        final KomentarOldAsycTask._cls6 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            dialoginterface.dismiss();
                                            stat = "0";
                                            (new FavoritTask()).execute(new Void[0]);
                                        }

            
            {
                this$2 = KomentarOldAsycTask._cls6.this;
                super();
            }
                                    });
                                    view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                                    view.show();
                                    return;
                                } else
                                {
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setMessage("Favoritkan tweet ini?");
                                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                        final KomentarOldAsycTask._cls6 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            stat = "1";
                                            (new FavoritTask()).execute(new Void[0]);
                                        }

            
            {
                this$2 = KomentarOldAsycTask._cls6.this;
                super();
            }
                                    });
                                    view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                                    view.show();
                                    return;
                                }
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(wrapperLight);
                                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
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
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
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
                                        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
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
                since_id = String.this;
                super();
            }
                    });
                    list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarOldAsycTask this$1;
                        private final String val$avatar;
                        private final String val$media_url;
                        private final String val$screen_name;
                        private final String val$since_id;
                        private final String val$tweet_content;
                        private final String val$tweet_time;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            view = new Intent(_fld0, com/inponsel/android/details/KomentarTwitter);
                            view.putExtra("tw_name", twitter);
                            view.putExtra("id_tw", idkom_pos);
                            view.putExtra("tweet_content", tweet_content);
                            view.putExtra("media_url", media_url);
                            view.putExtra("avatar", avatar);
                            view.putExtra("tweet_time", tweet_time);
                            view.putExtra("screen_name", screen_name);
                            startActivity(view);
                        }

            
            {
                this$1 = final_komentaroldasyctask;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = String.this;
                super();
            }
                    });
                    void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                        final KomentarOldAsycTask this$1;
                        private final String val$avatar;
                        private final String val$media_url;
                        private final String val$screen_name;
                        private final String val$since_id;
                        private final String val$tweet_content;
                        private final String val$tweet_time;

                        public void onClick(View view)
                        {
                            idkom_pos = since_id;
                            view = new Intent(_fld0, com/inponsel/android/details/KomentarTwitter);
                            view.putExtra("tw_name", twitter);
                            view.putExtra("id_tw", idkom_pos);
                            view.putExtra("tweet_content", tweet_content);
                            view.putExtra("media_url", media_url);
                            view.putExtra("avatar", avatar);
                            view.putExtra("tweet_time", tweet_time);
                            view.putExtra("screen_name", screen_name);
                            startActivity(view);
                        }

            
            {
                this$1 = final_komentaroldasyctask;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = String.this;
                super();
            }
                    });
                    i++;
                } while (true);
            } else
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarOldAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                this$1 = KomentarOldAsycTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final KomentarOldAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            limit = 0;
                            urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
                this$1 = KomentarOldAsycTask.this;
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
            txtbtnfooter.setVisibility(8);
            layout_footerNext.setVisibility(0);
            Log.e("mArrayListDataOld", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataOld", String.valueOf(mArrayListData.size()));
        }


        public KomentarOldAsycTask()
        {
            this$0 = TwitterInPonsel.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final TwitterInPonsel this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_tweet.php?").append(querylike).toString();
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
                break MISSING_BLOCK_LABEL_179;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_134;
            }
            notificationLikeHelper.completed((new StringBuilder("Twitter ")).append(twitter).toString(), notificationLikeHelper.suclikefrontKomen);
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            return;
            try
            {
                notificationLikeHelper.completed((new StringBuilder("Twitter ")).append(twitter).toString(), notificationLikeHelper.sucdislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal((new StringBuilder("Twitter ")).append(twitter).toString(), notificationLikeHelper.gaglikefrontKomen);
                return;
            }
            notificationLikeHelper.gagal((new StringBuilder("Twitter ")).append(twitter).toString(), notificationLikeHelper.gagdislikefrontKomen);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification((new StringBuilder("Twitter ")).append(twitter).toString(), notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification((new StringBuilder("Twitter ")).append(twitter).toString(), notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = TwitterInPonsel.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    String bottom_id;
    LinearLayout bottom_list;
    Button btnRefresh;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    String idkom_pos;
    ImageView imageMedia;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray jArray;
    String jum_komen;
    String komencount;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    LinearLayout layout_footerNext;
    LinearLayout layout_header;
    int limit;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    private ArrayList mArrayListData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListView;
    String nama_asli;
    NotificationLikeTwHelper notificationLikeHelper;
    PonselBaseApp ponselBaseApp;
    ProgressBar pop_progressbar_middle;
    TextView pop_txt_empty;
    String postMessage;
    String postMessageLikeKom;
    String postStatus;
    String postStatusLikeKom;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    ScrollView scrollviewKomen;
    String stat;
    String statuslike;
    String strKonekStat;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String totdis_LikeKom;
    String totdis_LikePon;
    String twitter;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextView txtKomentar;
    TextView txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtTanggapan;
    TextView txtTotalKom;
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

    public TwitterInPonsel()
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
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        stat = "";
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

    public String BitMapToString(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        return Base64.encodeToString(bytearrayoutputstream.toByteArray(), 0);
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
            break MISSING_BLOCK_LABEL_102;
        }
        intent = intent.getStringExtra("postStatus");
        android.util.Log.e("onActivityResultAct", intent);
        if (!intent.equals("1"))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        try
        {
            limit = 0;
            Log.e("urlKomenLastKom", urlKomenLast);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
        (new KomentarNextAsycTask()).execute(new String[0]);
        return;
        Log.e("onActivityResult", "false");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030113);
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
        twitter = extras.getString("twitter");
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Twitter ")).append(twitter).toString());
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
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode((new StringBuilder("Twitter ")).append(twitter).toString())).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(URLDecoder.decode((new StringBuilder("Twitter ")).append(twitter).toString()));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeTwHelper(this);
        mArrayListData = new ArrayList();
        txtbtnheader = (TextView)findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        layout_header = (LinearLayout)findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)findViewById(0x7f0b04d3);
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
        }
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(twitter).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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
        grup_header.setOnClickListener(new android.view.View.OnClickListener() {

            final TwitterInPonsel this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }
            }

            
            {
                this$0 = TwitterInPonsel.this;
                super();
            }
        });
        grup_footer.setOnClickListener(new android.view.View.OnClickListener() {

            final TwitterInPonsel this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new KomentarOldAsycTask()).execute(new String[0]);
                    return;
                }
            }

            
            {
                this$0 = TwitterInPonsel.this;
                super();
            }
        });
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void update(Observable observable, Object obj)
    {
        if (!ponselBaseApp.getObserver().getUpdateType().equals("komentartw")) goto _L2; else goto _L1
_L1:
        int i;
        Log.e("id_twup", ponselBaseApp.getObserver().getIndexTw());
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L5:
        if (i < mLinearListView.getChildCount()) goto _L3; else goto _L2
_L2:
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            TextView textview;
            Object obj1;
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
        return;
_L3:
        obj1 = mLinearListView.getChildAt(i);
        observable = (TextView)((View) (obj1)).findViewById(0x7f0b054d);
        obj = (TextView)((View) (obj1)).findViewById(0x7f0b0551);
        textview = (TextView)((View) (obj1)).findViewById(0x7f0b0554);
        obj1 = (TextView)((View) (obj1)).findViewById(0x7f0b034a);
        if (observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexTw()))
        {
            ((TextView) (obj)).setText(ponselBaseApp.getObserver().getTot_LikeTw());
            textview.setText(ponselBaseApp.getObserver().getTotdis_LikeTw());
            ((TextView) (obj1)).setText(ponselBaseApp.getObserver().getJum_komenLikeTw());
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
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
            imageview.setBackgroundResource(0x7f020264);
            relativelayout.setEnabled(false);
            ((RelativeLayout) (obj)).setEnabled(true);
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("0")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f020265);
        imageview1.setBackgroundResource(0x7f0201a7);
        relativelayout.setEnabled(true);
        ((RelativeLayout) (obj)).setEnabled(false);
          goto _L4
    }

    public void updateViewTWFav(String s, String s1)
    {
        int i;
        Log.e("id_kom", s);
        Log.e("resstat", s1);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L2:
        TextView textview;
        Object obj;
        if (i >= mLinearListView.getChildCount())
        {
            return;
        }
        obj = mLinearListView.getChildAt(i);
        textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0419);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b054e);
        TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b054c);
        TextView textview4 = (TextView)((View) (obj)).findViewById(0x7f0b05e9);
        TextView textview5 = (TextView)((View) (obj)).findViewById(0x7f0b05ea);
        ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f0b046c);
        TextView textview6 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        TextView textview7 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
        obj = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
        if (textview.getText().toString().equals(s))
        {
            if (!s1.equals("1") && !s1.equals("10"))
            {
                break; /* Loop/switch isn't completed */
            }
            if (imageview.getVisibility() == 8)
            {
                db.addTW(textview.getText().toString(), textview1.getText().toString(), textview4.getText().toString(), textview2.getText().toString(), "", textview3.getText().toString(), textview6.getText().toString(), textview7.getText().toString(), "");
            } else
            {
                db.addTW(textview.getText().toString(), textview1.getText().toString(), textview4.getText().toString(), textview2.getText().toString(), textview5.getText().toString(), textview3.getText().toString(), textview6.getText().toString(), textview7.getText().toString(), "");
            }
            if (db.getTWCount() > 0)
            {
                Toast.makeText(this, "Berhasil menambahkan", 1).show();
                ((ImageView) (obj)).setBackgroundResource(0x7f020303);
            } else
            {
                Toast.makeText(this, "Gagal menambahkan", 1).show();
                ((ImageView) (obj)).setBackgroundResource(0x7f020302);
            }
            mDialog.dismiss();
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s1.equals("00") || s1.equals("0"))
        {
            db.deleteHP(textview.getText().toString());
            if (!db.checkIfExist(textview.getText().toString()))
            {
                Toast.makeText(getApplicationContext(), "Berhasil menghapus", 1).show();
                ((ImageView) (obj)).setBackgroundResource(0x7f020302);
            } else
            {
                Toast.makeText(this, "Gagal menghapus", 1).show();
                ((ImageView) (obj)).setBackgroundResource(0x7f020303);
            }
            mDialog.dismiss();
        } else
        if (res.equals("40404"))
        {
            mDialog.dismiss();
        } else
        {
            Toast.makeText(this, "Gagal menambahkan", 1).show();
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }


}
