// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemInteraksiKomen;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.timelinedetail.ReplyKomTLActivity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSInteraksiActivity

public class this._cls0 extends AsyncTask
{

    final RSSInteraksiActivity this$0;

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
            break MISSING_BLOCK_LABEL_258;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_258;
        }
        Object obj = RSSInteraksiActivity.this;
        obj.countAllKom = ((RSSInteraksiActivity) (obj)).countAllKom + 1;
        obj = RSSInteraksiActivity.this;
        obj.countKomOld = ((RSSInteraksiActivity) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).add(0, new ItemInteraksiKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_rss"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("judul"), ""));
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
        if (countKomOld >= 15) goto _L2; else goto _L1
_L1:
        txtbtnheader.setVisibility(8);
        layout_header.setVisibility(8);
_L4:
        Log.e("countAllKom", String.valueOf(countAllKom));
        Log.e("mArrayListDataold", String.valueOf(RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).size()));
        int i = 0;
_L9:
        ImageView imageview;
        ImageView imageview1;
        final String id_komrss;
        final String tl_id;
        final String tl_judul_art;
        final String id_user;
        final String komen_rss;
        final String tanggal_kom;
        final String user_photo;
        final String user_name;
        try
        {
            if (i >= RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).size())
            {
                void1 = RSSInteraksiActivity.this;
                void1.removeIndex = ((RSSInteraksiActivity) (void1)).removeIndex + 3;
                Log.e("removeIndexBef", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                void1 = RSSInteraksiActivity.this;
                void1.removeStartOld = ((RSSInteraksiActivity) (void1)).removeStartOld + 3;
                Log.e("removeIndexAft", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L3
_L2:
        txtbtnheader.setVisibility(0);
        layout_header.setVisibility(8);
          goto _L4
_L3:
        void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fa, null);
        txtUsername = (TextView)void1.findViewById(0x7f0b0419);
        txtTitleArtikel = (TextView)void1.findViewById(0x7f0b0764);
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
        myroot = (LinearLayout)void1.findViewById(0x7f0b0063);
        list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
        list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
        list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
        list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
        id_komrss = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getId_komrss();
        tl_id = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getId_rss();
        tl_judul_art = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getJudul();
        id_user = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getId_user();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getId_user_to();
        komen_rss = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getKomen_rss();
        tanggal_kom = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTanggal_kom();
        user_photo = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_photo();
        user_name = ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_name();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTanggal_to();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTotal_like();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTotal_dislike();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getMy_like_kom();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getKomen_to();
        ((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_name_to();
        if (!((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_name_to().toString().trim().equals("")) goto _L6; else goto _L5
_L5:
        lay_quote.setVisibility(8);
_L10:
        if (!((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L11:
        if (!((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_photo().trim().contains(".jpg") && !((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_1809;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, RSSInteraksiActivity.access$2(RSSInteraksiActivity.this), RSSInteraksiActivity.access$3(RSSInteraksiActivity.this));
_L12:
        txtIdKom.setText(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getId_komrss().toString());
        txtdisLikeKom.setText(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTotal_dislike().toString());
        txtLikeKom.setText(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTotal_like().toString());
        txtUsername.setText(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_name());
        txtTitleArtikel.setText(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getJudul());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getKomen_rss())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.Method.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.Method.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getTanggal_to()));
        RSSInteraksiActivity.access$0(RSSInteraksiActivity.this).addView(void1, 0);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final RSSInteraksiActivity.KomentarOldAsycTask this$1;
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
                this$1 = RSSInteraksiActivity.KomentarOldAsycTask.this;
                user_photo = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSInteraksiActivity.KomentarOldAsycTask this$1;
            private final String val$id_user;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", id_user);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = RSSInteraksiActivity.KomentarOldAsycTask.this;
                id_user = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSInteraksiActivity.KomentarOldAsycTask this$1;
            private final String val$id_komrss;
            private final String val$tl_id;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "1";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new RSSInteraksiActivity.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new RSSInteraksiActivity.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                this$1 = RSSInteraksiActivity.KomentarOldAsycTask.this;
                id_komrss = s;
                tl_id = s1;
                super();
            }
        });
        myroot.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSInteraksiActivity.KomentarOldAsycTask this$1;
            private final String val$tl_id;
            private final String val$tl_judul_art;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view.putExtra("id_rss", tl_id);
                view.putExtra("rss_title", tl_judul_art);
                view.putExtra("notif", "gcm");
                view.putExtra("actfrom", "rssfeed");
                view.putExtra("act", "firsttab");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = RSSInteraksiActivity.KomentarOldAsycTask.this;
                tl_id = s;
                tl_judul_art = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSInteraksiActivity.KomentarOldAsycTask this$1;
            private final String val$id_komrss;
            private final String val$tl_id;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "0";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new RSSInteraksiActivity.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new RSSInteraksiActivity.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(this$0);
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
                this$1 = RSSInteraksiActivity.KomentarOldAsycTask.this;
                id_komrss = s;
                tl_id = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSInteraksiActivity.KomentarOldAsycTask this$1;
            private final String val$id_komrss;
            private final String val$komen_rss;
            private final String val$tanggal_kom;
            private final String val$tl_id;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    view = new Intent(this$0, com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                    view.putExtra("tl_judul", tl_judul);
                    view.putExtra("tl_type", tl_type);
                    view.putExtra("tl_id", tl_id);
                    view.putExtra("id_komrss", id_komrss);
                    view.putExtra("user_id", user_id);
                    view.putExtra("user_name", user_name);
                    view.putExtra("tanggal_kom", tanggal_kom);
                    view.putExtra("komen_rss", komen_rss);
                    view.putExtra("user_photo", user_photo);
                    view.putExtra("top_id", top_id);
                    view.putExtra("bottom_id", bottom_id);
                    Log.e("id_komrss_to", id_komrss);
                    Log.e("tl_id", tl_id);
                    startActivityForResult(view, RSSInteraksiActivity.access$4());
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk membalas komentar harus login terlebih dahulu.");
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
                this$1 = RSSInteraksiActivity.KomentarOldAsycTask.this;
                tl_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
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
            if (!((ItemInteraksiKomen)RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).get(i)).getMy_like_kom().toString().equals("0"))
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
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtbtnheader.setVisibility(8);
        layout_header.setVisibility(0);
        RSSInteraksiActivity.access$1(RSSInteraksiActivity.this).clear();
    }


    public _cls6.val.user_photo()
    {
        this$0 = RSSInteraksiActivity.this;
        super();
    }
}
