// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal2TLKomen, ReplyKomTLActivity

public class this._cls0 extends AsyncTask
{

    final Hal2TLKomen this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        JSONObject jsonobject = new JSONObject(strJsonRssRep);
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        top_id = jsonobject.getString("top_id");
        if (!jsonobject.getString("top_id").equals("-"))
        {
            top_id = jsonobject.getString("top_id");
        }
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
        Object obj = Hal2TLKomen.this;
        obj.countAllKom = ((Hal2TLKomen) (obj)).countAllKom + 1;
        obj = Hal2TLKomen.this;
        obj.countKomOld = ((Hal2TLKomen) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Hal2TLKomen.access$1(Hal2TLKomen.this).add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_artanya"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        Log.e("mArrayListDataRep", String.valueOf(Hal2TLKomen.access$1(Hal2TLKomen.this).size()));
        jum_komen.equals("-");
        if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
        Log.e("countAllKom", String.valueOf(countAllKom));
        Log.e("mArrayListDataold", String.valueOf(Hal2TLKomen.access$1(Hal2TLKomen.this).size()));
        int i = 0;
_L9:
        if (i < Hal2TLKomen.access$1(Hal2TLKomen.this).size()) goto _L4; else goto _L3
_L3:
        void1 = Hal2TLKomen.this;
        void1.removeNextIndex = ((Hal2TLKomen) (void1)).removeNextIndex + countRemIndex;
        Log.e("mArrayListDataAfterRep", String.valueOf(Hal2TLKomen.access$1(Hal2TLKomen.this).size()));
        Hal2TLKomen.access$0(Hal2TLKomen.this).removeViewAt(Hal2TLKomen.access$0(Hal2TLKomen.this).getChildCount());
_L13:
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    view = this$0;
                    view.limit = ((Hal2TLKomen) (view)).limit + 15;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2TLKomen.KomentarNewAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal2TLKomen.KomentarNewAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2TLKomen.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal2TLKomen.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&tl_id=").append(tl_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal2TLKomen.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal2TLKomen.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                super();
            }
        });
        return;
_L4:
        ImageView imageview;
        ImageView imageview1;
        final String id_komrss;
        final String tl_id;
        final String komen_rss;
        final String tanggal_kom;
        final String user_photo;
        final String user_name;
        void1 = Hal2TLKomen.this;
        void1.countRemIndex = ((Hal2TLKomen) (void1)).countRemIndex + 1;
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
        id_komrss = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_komrss();
        tl_id = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_rss();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_user();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_user_to();
        komen_rss = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_rss();
        tanggal_kom = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_kom();
        user_photo = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo();
        user_name = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_to();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_like();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_dislike();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getMy_like_kom();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_to();
        ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to();
        if (!((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to().toString().trim().equals("")) goto _L6; else goto _L5
_L5:
        lay_quote.setVisibility(8);
_L10:
        if (!((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L11:
        if (!((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_1714;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, Hal2TLKomen.access$3(Hal2TLKomen.this), Hal2TLKomen.access$4(Hal2TLKomen.this));
_L12:
        txtIdKom.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_komrss().toString());
        txtdisLikeKom.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_dislike().toString());
        txtLikeKom.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_like().toString());
        txtUsername.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_rss())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.ovementMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.ovementMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_to()));
        Hal2TLKomen.access$0(Hal2TLKomen.this).addView(void1, 0);
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;
            private final String val$id_komrss;
            private final String val$tl_id;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "1";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2TLKomen.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal2TLKomen.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                id_komrss = s;
                tl_id = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;
            private final String val$id_komrss;
            private final String val$tl_id;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "0";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2TLKomen.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal2TLKomen.PostBagusKurangTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                id_komrss = s;
                tl_id = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;
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
                    view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
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
                    Log.e("id_komrss_to", id_komrss);
                    Log.e("tl_id", tl_id);
                    startActivityForResult(view, Hal2TLKomen.access$5());
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk membalas komentar harus login terlebih dahulu.");
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                tl_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;
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
                    view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
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
                    Log.e("id_komrss_to", id_komrss);
                    Log.e("tl_id", tl_id);
                    startActivityForResult(view, Hal2TLKomen.access$5());
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk membalas komentar harus login terlebih dahulu.");
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
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
            if (!((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getMy_like_kom().toString().equals("0"))
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

            final Hal2TLKomen.KomentarReplyAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    view = this$0;
                    view.limit = ((Hal2TLKomen) (view)).limit + 15;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2TLKomen.KomentarNewAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal2TLKomen.KomentarNewAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append(sortkom).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2TLKomen.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal2TLKomen.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.KomentarReplyAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", top_id);
                    querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&tl_id=").append(tl_id).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal2TLKomen.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal2TLKomen.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = Hal2TLKomen.KomentarReplyAsycTask.this;
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
        Log.e("mArrayListDataNext", strJsonRssRep);
        Hal2TLKomen.access$1(Hal2TLKomen.this).clear();
        Log.e("mArrayListDataNext", String.valueOf(Hal2TLKomen.access$1(Hal2TLKomen.this).size()));
    }


    public _cls9.this._cls1()
    {
        this$0 = Hal2TLKomen.this;
        super();
    }
}
