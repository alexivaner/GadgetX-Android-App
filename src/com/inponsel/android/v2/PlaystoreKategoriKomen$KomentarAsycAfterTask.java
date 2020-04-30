// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

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
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, ImagePagerActivity, ProfileOtherUser, RegisterActivity, 
//            LoginActivity, KatAppsReplyFormActivity

public class this._cls0 extends AsyncTask
{

    final PlaystoreKategoriKomen this$0;

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
        Object obj = PlaystoreKategoriKomen.this;
        obj.countAllKom = ((PlaystoreKategoriKomen) (obj)).countAllKom + 1;
        obj = PlaystoreKategoriKomen.this;
        obj.countKomOld = ((PlaystoreKategoriKomen) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_kat"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        if (PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).size() < 15)
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
        if (i < PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).size()) goto _L4; else goto _L3
_L3:
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    view = this$0;
                    view.limit = ((PlaystoreKategoriKomen) (view)).limit + 15;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_playkat").append(Utility.BASE_FORMAT).append("?id_kat=").append(id_kat).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PlaystoreKategoriKomen.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new PlaystoreKategoriKomen.KomentarOldAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_playkat").append(Utility.BASE_FORMAT).append("?id_kat=").append(id_kat).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PlaystoreKategoriKomen.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new PlaystoreKategoriKomen.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("idkat=")).append(id_kat).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
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
        final String id_kat;
        final String id_user;
        final String komen_rss;
        final String tanggal_kom;
        final String user_photo;
        final String user_name;
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
        list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
        id_komrss = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getId_komrss();
        id_kat = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getId_rss();
        id_user = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getId_user();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getId_user_to();
        komen_rss = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getKomen_rss();
        tanggal_kom = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTanggal_kom();
        user_photo = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_photo();
        user_name = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_name();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTanggal_to();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTotal_like();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTotal_dislike();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getMy_like_kom();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getKomen_to();
        ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_name_to();
        ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
        ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
        imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
        imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
        txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
        txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
        progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
        progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
        String s = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getImg_media();
        String s1 = ((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getImg_media_to();
        PlaystoreKategoriKomen.access$2(PlaystoreKategoriKomen.this, ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s, s1);
        if (!((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_name_to().toString().trim().equals("")) goto _L7; else goto _L6
_L6:
        lay_quote.setVisibility(8);
_L13:
        if (!((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L9; else goto _L8
_L8:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L14:
        if (!((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_photo().toString().trim().contains(".jpeg")) goto _L11; else goto _L10
_L10:
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, PlaystoreKategoriKomen.access$3(PlaystoreKategoriKomen.this), PlaystoreKategoriKomen.access$4(PlaystoreKategoriKomen.this));
_L15:
        txtIdKom.setText(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getId_komrss().toString());
        txtdisLikeKom.setText(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTotal_dislike().toString());
        txtLikeKom.setText(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTotal_like().toString());
        txtUsername.setText(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_name());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getKomen_rss())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.od.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.od.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getTanggal_to()));
        PlaystoreKategoriKomen.access$0(PlaystoreKategoriKomen.this).addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
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
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                user_photo = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
            private final String val$id_user;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", id_user);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                id_user = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
            private final String val$id_kat;
            private final String val$id_komrss;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "1";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PlaystoreKategoriKomen.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PlaystoreKategoriKomen.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(this$0);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls3.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls3.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls3.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                id_komrss = s;
                id_kat = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
            private final String val$id_kat;
            private final String val$id_komrss;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "0";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PlaystoreKategoriKomen.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PlaystoreKategoriKomen.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(this$0);
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
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                id_komrss = s;
                id_kat = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
            private final String val$id_kat;
            private final String val$id_komrss;
            private final String val$komen_rss;
            private final String val$tanggal_kom;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
label0:
                {
                    if (userFunctions.isUserLoggedIn(this$0))
                    {
                        idkom_pos = id_komrss;
                        if (!userFunctions.isUserLoggedIn(this$0))
                        {
                            break label0;
                        }
                        view = new Intent(this$0, com/inponsel/android/v2/KatAppsReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", idkom_pos);
                        view.putExtra("id_kat", id_kat);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        view.putExtra("type", str_category);
                        startActivityForResult(view, PlaystoreKategoriKomen.access$5());
                    }
                    return;
                }
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
            }


            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                id_komrss = s;
                id_kat = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
            private final String val$id_kat;
            private final String val$id_komrss;
            private final String val$komen_rss;
            private final String val$tanggal_kom;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
label0:
                {
                    if (userFunctions.isUserLoggedIn(this$0))
                    {
                        idkom_pos = id_komrss;
                        if (!userFunctions.isUserLoggedIn(this$0))
                        {
                            break label0;
                        }
                        view = new Intent(this$0, com/inponsel/android/v2/KatAppsReplyFormActivity);
                        view.putExtra("top_id", top_id);
                        view.putExtra("idkomen", idkom_pos);
                        view.putExtra("id_kat", id_kat);
                        view.putExtra("userkomen", user_name);
                        view.putExtra("tanggal", tanggal_kom);
                        view.putExtra("isikomentar", komen_rss);
                        view.putExtra("userpict", user_photo);
                        view.putExtra("sc_nama", "");
                        view.putExtra("sc_merk", "");
                        view.putExtra("type", str_category);
                        startActivityForResult(view, PlaystoreKategoriKomen.access$5());
                    }
                    return;
                }
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
            }


            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                id_komrss = s;
                id_kat = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
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
            if (!((ItemRSSKomen)PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).get(i)).getMy_like_kom().toString().equals("0"))
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

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    view = this$0;
                    view.limit = ((PlaystoreKategoriKomen) (view)).limit + 15;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_playkat").append(Utility.BASE_FORMAT).append("?id_kat=").append(id_kat).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PlaystoreKategoriKomen.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new PlaystoreKategoriKomen.KomentarOldAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_playkat").append(Utility.BASE_FORMAT).append("?id_kat=").append(id_kat).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PlaystoreKategoriKomen.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new PlaystoreKategoriKomen.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("idkat=")).append(id_kat).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = PlaystoreKategoriKomen.KomentarAsycAfterTask.this;
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
        PlaystoreKategoriKomen.access$0(PlaystoreKategoriKomen.this).removeAllViewsInLayout();
        PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).clear();
    }


    public _cls9.this._cls1()
    {
        this$0 = PlaystoreKategoriKomen.this;
        super();
    }
}
