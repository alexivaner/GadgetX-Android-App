// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ItemTwKomen;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter, ReplyKomTwActivity

public class this._cls0 extends AsyncTask
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
        KomentarTwitter.access$0(KomentarTwitter.this).add(KomentarTwitter.access$0(KomentarTwitter.this).size(), new ItemTwKomen(s.getString("id_komtw"), s.getString("id_tw"), s.getString("id_user"), s.getString("id_user_to"), s.getString("komen_tw"), s.getString("tanggal_kom"), s.getString("user_photo"), s.getString("user_name"), s.getString("tanggal_to"), s.getString("total_like"), s.getString("total_dislike"), s.getString("my_like_kom"), s.getString("user_name_to"), s.getString("komen_to")));
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
            if (android.os.Twitter.PostKomen >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.ilder(avoid)).permitDiskWrites().build());
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
        if (KomentarTwitter.access$1(KomentarTwitter.this).getChildCount() < 15)
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
        if (i >= KomentarTwitter.access$0(KomentarTwitter.this).size())
        {
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;

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
                            (new KomentarTwitter.KomentarNewAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarTwitter.KomentarNewAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                        Log.e("urlKomenTwLast", urlKomenTwLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarTwitter.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new KomentarTwitter.KomentarNextAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;

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
                        (new KomentarTwitter.PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new KomentarTwitter.PostKomen()).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
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
            final String id_komtw = ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getId_komtw();
            final String id_tw = ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getId_tw();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getId_user();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getId_user_to();
            final String komen_tw = ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getKomen_tw();
            final String tanggal_kom = ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_kom();
            final String user_photo = ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo();
            final String user_name = ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_to();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTotal_like();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTotal_dislike();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getMy_like_kom();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getKomen_to();
            ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name_to();
            if (((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name_to().toString().trim().equals(""))
            {
                lay_quote.setVisibility(8);
            } else
            {
                lay_quote.setVisibility(0);
            }
            if (((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getMy_like_kom().toString().equals("1"))
            {
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                list_lay_like.setEnabled(false);
                list_lay_dislike.setEnabled(true);
            } else
            if (((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getMy_like_kom().toString().equals("0"))
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
            if (((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                try
                {
                    Picasso.with(KomentarTwitter.this).load(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

                        final KomentarTwitter.PostKomen this$1;

                        public void onError()
                        {
                        }

                        public void onSuccess()
                        {
                            img_kom_picture.setVisibility(0);
                        }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
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
            txtIdKom.setText(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getId_komtw().toString());
            txtdisLikeKom.setText(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseTweet(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getKomen_tw())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.calLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.calLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_to()));
            KomentarTwitter.access$1(KomentarTwitter.this).addView(void1, 0);
            img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final KomentarTwitter.PostKomen this$1;
                private final String val$user_photo;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(user_photo.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                user_photo = s;
                super();
            }
            });
            img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;
                private final String val$user_name;

                public void onClick(View view)
                {
                    view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", user_name);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                user_name = s;
                super();
            }
            });
            list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(this$0))
                    {
                        statuslike = "1";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarTwitter.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new KomentarTwitter.PostBagusKurangTask(this$0)).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                id_komtw = s;
                id_tw = s1;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;
                private final String val$id_komtw;
                private final String val$id_tw;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(this$0))
                    {
                        statuslike = "0";
                        idkom_pos = id_komtw;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new KomentarTwitter.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new KomentarTwitter.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                this$1 = KomentarTwitter.PostKomen.this;
                id_komtw = s;
                id_tw = s1;
                super();
            }
            });
            list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;
                private final String val$id_komtw;
                private final String val$id_tw;
                private final String val$komen_tw;
                private final String val$tanggal_kom;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(this$0))
                    {
                        view = new Intent(this$0, com/inponsel/android/details/ReplyKomTwActivity);
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
                        startActivityForResult(view, KomentarTwitter.access$2());
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
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
                this$1 = KomentarTwitter.PostKomen.this;
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = s5;
                super();
            }
            });
            void1.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.PostKomen this$1;

                public void onClick(View view)
                {
                }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                super();
            }
            });
            i++;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.PostKomen this$1;

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
                        (new KomentarTwitter.KomentarNewAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarTwitter.KomentarNewAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.PostKomen this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                    Log.e("urlKomenTwLast", urlKomenTwLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarTwitter.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarTwitter.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.PostKomen this$1;

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
                    (new KomentarTwitter.PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarTwitter.PostKomen()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = KomentarTwitter.PostKomen.this;
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
            if (android.os.erEditText.setText >= 11)
            {
                (new sk(KomentarTwitter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new sk(KomentarTwitter.this)).execute(new Void[0]);
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
        Log.e("mArrayListDataPostKomen", String.valueOf(KomentarTwitter.access$0(KomentarTwitter.this).size()));
        mNotificationHelper.createNotification(tw_name, mNotificationHelper.komenPostWords);
        KomentarTwitter.access$0(KomentarTwitter.this).clear();
        Log.e("clearmArrayKomen", String.valueOf(KomentarTwitter.access$0(KomentarTwitter.this).size()));
    }


    public _cls9.this._cls1()
    {
        this$0 = KomentarTwitter.this;
        super();
    }
}
