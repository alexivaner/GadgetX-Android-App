// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemTwitter;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            TwitterListInPonsel, KomentarTwitter

public class this._cls0 extends AsyncTask
{

    final TwitterListInPonsel this$0;

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
        Object obj = TwitterListInPonsel.this;
        obj.countAllKom = ((TwitterListInPonsel) (obj)).countAllKom + 1;
        obj = TwitterListInPonsel.this;
        obj.countKomOld = ((TwitterListInPonsel) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        TwitterListInPonsel.access$0(TwitterListInPonsel.this).add(0, new ItemTwitter(((JSONObject) (obj)).getString("since_id"), ((JSONObject) (obj)).getString("tweet_content"), ((JSONObject) (obj)).getString("media_url"), ((JSONObject) (obj)).getString("avatar"), ((JSONObject) (obj)).getString("tweet_time"), ((JSONObject) (obj)).getString("real_name"), ((JSONObject) (obj)).getString("screen_name"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_dislike"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_tweet"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_tweet")));
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
                if (i >= TwitterListInPonsel.access$0(TwitterListInPonsel.this).size())
                {
                    txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                        final TwitterListInPonsel.KomentarNextAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                txtbtnheader.setVisibility(8);
                                limit = 0;
                                urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter_list").append(Utility.BASE_FORMAT).append("?slug=").append(listtwitter).append("&screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                                Log.e("urlKomenLast", urlKomenLast);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new TwitterListInPonsel.KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                    return;
                                }
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            (new TwitterListInPonsel.KomentarNextAsycTask()).execute(new String[0]);
                            return;
                        }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                super();
            }
                    });
                    txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                        final TwitterListInPonsel.KomentarNextAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                limit = 0;
                                urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter_list").append(Utility.BASE_FORMAT).append("?slug=").append(listtwitter).append("&screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                                Log.e("urlKomenOld", urlKomenOld);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new TwitterListInPonsel.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                    return;
                                }
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            (new TwitterListInPonsel.KomentarOldAsycTask(this$0)).execute(new String[0]);
                            return;
                        }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
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
                final String since_id = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getSince_id();
                final String tweet_content = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTweet_content();
                final String media_url = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getMedia_url();
                final String avatar = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getAvatar();
                final String tweet_time = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTweet_time();
                String s = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getReal_name();
                final String screen_name = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getScreen_name();
                String s1 = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTotal_like();
                String s2 = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTotal_dislike();
                String s3 = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTotal_komen();
                ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTotal_komen();
                String s4 = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getMy_like_tweet();
                String s5 = ((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getMy_fav_tweet();
                if (listtwitter.equals("media"))
                {
                    bottom_list.setVisibility(0);
                } else
                {
                    bottom_list.setVisibility(8);
                }
                txtIdKom.setText(since_id);
                txtUsername.setText(Html.fromHtml((new StringBuilder("<font color='#000000'>")).append(s).append("</font>").append("<small><font color='#cacaca'>").append("<br>@").append(screen_name).append("</font><small>").toString()));
                txtImgAva.setText(avatar);
                txtImgMedia.setText(media_url);
                txtKomentar.setText(Html.fromHtml(Utility.parseTweet(tweet_content)));
                txtKomentar.setMovementMethod(com.inponsel.android.widget.Method.getInstance());
                txtLikeKom.setText(s1);
                txtdisLikeKom.setText(s2);
                txtTotalKom.setText(s3);
                if (s4.toString().equals("1"))
                {
                    imageview.setBackgroundResource(0x7f020264);
                    list_lay_like.setEnabled(false);
                    list_lay_dislike.setEnabled(true);
                } else
                if (s4.toString().equals("0"))
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
                if (s5.toString().equals("1"))
                {
                    imageview1.setBackgroundResource(0x7f020303);
                } else
                if (s5.toString().equals("0"))
                {
                    imageview1.setBackgroundResource(0x7f020302);
                } else
                {
                    imageview1.setBackgroundResource(0x7f020302);
                }
                try
                {
                    Picasso.with(TwitterListInPonsel.this).load(((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getAvatar().toString().trim()).into(img_kom_picture, new Callback() {

                        final TwitterListInPonsel.KomentarNextAsycTask this$1;

                        public void onError()
                        {
                        }

                        public void onSuccess()
                        {
                            img_kom_picture.setVisibility(0);
                        }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                super();
            }
                    });
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                if (((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getMedia_url().trim().equals(""))
                {
                    imageMedia.setVisibility(8);
                } else
                {
                    try
                    {
                        Picasso.with(TwitterListInPonsel.this).load(((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getMedia_url().toString().trim()).into(imageMedia, new Callback() {

                            final TwitterListInPonsel.KomentarNextAsycTask this$1;

                            public void onError()
                            {
                            }

                            public void onSuccess()
                            {
                                imageMedia.setVisibility(0);
                            }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                super();
            }
                        });
                    }
                    catch (Exception exception1)
                    {
                        exception1.printStackTrace();
                    }
                }
                txtWaktu.setText(Utility.convertDate(((ItemTwitter)TwitterListInPonsel.access$0(TwitterListInPonsel.this).get(i)).getTweet_time()));
                TwitterListInPonsel.access$1(TwitterListInPonsel.this).addView(void1, 0);
                imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

                    final TwitterListInPonsel.KomentarNextAsycTask this$1;
                    private final String val$media_url;

                    public void onClick(View view)
                    {
                        view = new ArrayList();
                        view.add(media_url);
                        view = (String[])view.toArray(new String[view.size()]);
                        Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                        intent.putExtra("imgUrl", view);
                        intent.putExtra("pos", 0);
                        startActivity(intent);
                    }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                media_url = s;
                super();
            }
                });
                img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                    final TwitterListInPonsel.KomentarNextAsycTask this$1;
                    private final String val$avatar;

                    public boolean onLongClick(View view)
                    {
                        view = new ArrayList();
                        view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(avatar.toString().trim()).toString());
                        view = (String[])view.toArray(new String[view.size()]);
                        Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                        intent.putExtra("imgUrl", view);
                        intent.putExtra("pos", 0);
                        startActivity(intent);
                        return false;
                    }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                avatar = s;
                super();
            }
                });
                list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                    final TwitterListInPonsel.KomentarNextAsycTask this$1;
                    private final String val$since_id;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(this$0))
                        {
                            statuslike = "1";
                            idkom_pos = since_id;
                            querylike = (new StringBuilder("status=")).append(statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                            Log.e("querylike", querylike);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new TwitterListInPonsel.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new TwitterListInPonsel.PostBagusKurangTask(this$0)).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(wrapperLight);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final _cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls5.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final _cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls5.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final _cls5 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls5.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                since_id = s;
                super();
            }
                });
                list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final TwitterListInPonsel.KomentarNextAsycTask this$1;
                    private final String val$since_id;

                    public void onClick(View view)
                    {
                        idkom_pos = since_id;
                        if (userFunctions.isUserLoggedIn(this$0))
                        {
                            if (db.checkIfExistTW(idkom_pos))
                            {
                                view = new android.app.AlertDialog.Builder(this$0);
                                view.setMessage("Hapus tweet ini dari favorit?");
                                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                    final _cls6 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                        stat = "0";
                                        (new TwitterListInPonsel.FavoritTask(this$0)).execute(new Void[0]);
                                    }

            
            {
                this$2 = _cls6.this;
                super();
            }
                                });
                                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                    final _cls6 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = _cls6.this;
                super();
            }
                                });
                                view.show();
                                return;
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(this$0);
                                view.setMessage("Favoritkan tweet ini?");
                                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                    final _cls6 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        stat = "1";
                                        (new TwitterListInPonsel.FavoritTask(this$0)).execute(new Void[0]);
                                    }

            
            {
                this$2 = _cls6.this;
                super();
            }
                                });
                                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                    final _cls6 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = _cls6.this;
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

                                final _cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls6.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final _cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls6.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final _cls6 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls6.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                since_id = s;
                super();
            }
                });
                list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                    final TwitterListInPonsel.KomentarNextAsycTask this$1;
                    private final String val$avatar;
                    private final String val$media_url;
                    private final String val$screen_name;
                    private final String val$since_id;
                    private final String val$tweet_content;
                    private final String val$tweet_time;

                    public void onClick(View view)
                    {
                        idkom_pos = since_id;
                        view = new Intent(this$0, com/inponsel/android/details/KomentarTwitter);
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
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = s5;
                super();
            }
                });
                void1.setOnClickListener(new android.view.View.OnClickListener() {

                    final TwitterListInPonsel.KomentarNextAsycTask this$1;
                    private final String val$avatar;
                    private final String val$media_url;
                    private final String val$screen_name;
                    private final String val$since_id;
                    private final String val$tweet_content;
                    private final String val$tweet_time;

                    public void onClick(View view)
                    {
                        idkom_pos = since_id;
                        view = new Intent(this$0, com/inponsel/android/details/KomentarTwitter);
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
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                since_id = s;
                tweet_content = s1;
                media_url = s2;
                avatar = s3;
                tweet_time = s4;
                screen_name = s5;
                super();
            }
                });
                i++;
            } while (true);
        } else
        {
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final TwitterListInPonsel.KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter_list").append(Utility.BASE_FORMAT).append("?slug=").append(listtwitter).append("&screen_name=").append(twitter).append("&since_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenLast", urlKomenLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new TwitterListInPonsel.KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new TwitterListInPonsel.KomentarNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final TwitterListInPonsel.KomentarNextAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter_list").append(Utility.BASE_FORMAT).append("?slug=").append(listtwitter).append("&screen_name=").append(twitter).append("&max_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                        Log.e("urlKomenOld", urlKomenOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new TwitterListInPonsel.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new TwitterListInPonsel.KomentarOldAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = TwitterListInPonsel.KomentarNextAsycTask.this;
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
        TwitterListInPonsel.access$0(TwitterListInPonsel.this).clear();
    }


    public _cls9.this._cls1()
    {
        this$0 = TwitterListInPonsel.this;
        super();
    }
}
