// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemTwKomen;
import com.inponsel.android.utils.Log;
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
        KomentarTwitter.access$0(KomentarTwitter.this).add(new ItemTwKomen(((JSONObject) (obj)).getString("id_komtw"), ((JSONObject) (obj)).getString("id_tw"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komen_tw"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to")));
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
        if (i >= KomentarTwitter.access$0(KomentarTwitter.this).size())
        {
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.KomentarAsycTask this$1;

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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.KomentarAsycTask this$1;

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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                super();
            }
            });
            btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

                final KomentarTwitter.KomentarAsycTask this$1;

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
                        (new KomentarTwitter.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new KomentarTwitter.PostKomen(this$0)).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = KomentarTwitter.KomentarAsycTask.this;
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
        if (!((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L4:
        if (((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().trim().contains(".jpg") || ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
        {
            try
            {
                Picasso.with(KomentarTwitter.this).load(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

                    final KomentarTwitter.KomentarAsycTask this$1;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        img_kom_picture.setVisibility(0);
                    }

            
            {
                this$1 = KomentarTwitter.KomentarAsycTask.this;
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
        txtKomentar.setMovementMethod(com.inponsel.android.widget.MovementMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.MovementMethod.getInstance());
        Log.e("tanggal_kom", ((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_kom());
        txtWaktu.setText(Utility.convertDate(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemTwKomen)KomentarTwitter.access$0(KomentarTwitter.this).get(i)).getTanggal_to()));
        KomentarTwitter.access$1(KomentarTwitter.this).addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;
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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                user_photo = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;
            private final String val$user_name;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", user_name);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                user_name = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;
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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                id_komtw = s;
                id_tw = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;
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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                id_komtw = s;
                id_tw = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;
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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
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

            final KomentarTwitter.KomentarAsycTask this$1;

            public void onClick(View view)
            {
            }

            
            {
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                super();
            }
        });
        i++;
        if (true) goto _L3; else goto _L2
_L2:
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
          goto _L4
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;

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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;

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
                this$1 = KomentarTwitter.KomentarAsycTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarTwitter.KomentarAsycTask this$1;

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
                    (new KomentarTwitter.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarTwitter.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = KomentarTwitter.KomentarAsycTask.this;
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


    public _cls9.this._cls1()
    {
        this$0 = KomentarTwitter.this;
        super();
    }
}
