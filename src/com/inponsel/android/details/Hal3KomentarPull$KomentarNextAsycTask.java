// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.ReplyFormActivity;
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
//            Hal3KomentarPull

public class this._cls0 extends AsyncTask
{

    final Hal3KomentarPull this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        JSONObject jsonobject = new JSONObject(strJsonRssRep);
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        if (!jsonobject.getString("bottom_id").equals("-"))
        {
            bottom_id = jsonobject.getString("bottom_id");
        }
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
        Object obj = Hal3KomentarPull.this;
        obj.countAllKom = ((Hal3KomentarPull) (obj)).countAllKom + 1;
        obj = Hal3KomentarPull.this;
        obj.countKomOld = ((Hal3KomentarPull) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Log.e("komentarhp", ((JSONObject) (obj)).getString("komentarhp"));
        Hal3KomentarPull.access$1(Hal3KomentarPull.this).add(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size(), new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
        Log.e("countAllKom", String.valueOf(countAllKom));
        Log.e("mArrayListDataold", String.valueOf(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()));
        int i = 0;
_L11:
        if (i < Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()) goto _L4; else goto _L3
_L3:
        void1 = Hal3KomentarPull.this;
        void1.removeNextIndex = ((Hal3KomentarPull) (void1)).removeNextIndex + countRemIndex;
        Log.e("removeNextIndex", String.valueOf(removeNextIndex));
_L15:
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnfooter.setVisibility(8);
                    view = this$0;
                    view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal3KomentarPull.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal3KomentarPull.KomentarOldAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal3KomentarPull.KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal3KomentarPull.KomentarNextAsycTask()).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("bottom_id", bottom_id);
                    querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3KomentarPull.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3KomentarPull.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        return;
_L4:
        final String id_komentar;
        final String id_hp;
        final String codename;
        final String nama_komentar;
        final String email_komentar;
        final String tanggal_komentar;
        final String komentarhp;
        final String usr_pict_komen;
        ImageView imageview;
        ImageView imageview1;
        void1 = Hal3KomentarPull.this;
        void1.countRemIndex = ((Hal3KomentarPull) (void1)).countRemIndex + 1;
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
        id_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getId_komentar();
        id_hp = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getId_hp();
        codename = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getCodename();
        nama_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_komentar();
        email_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getEmail_komentar();
        tanggal_komentar = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_komentar();
        komentarhp = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomentarhp();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_bagus();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_kurang();
        usr_pict_komen = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getReply_to();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_to();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_to();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_to();
        ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getMy_like_kom();
        ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
        ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
        imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
        imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
        txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
        txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
        progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
        progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
        String s = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getImg_media();
        String s1 = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getImg_media_to();
        Hal3KomentarPull.access$2(Hal3KomentarPull.this, ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s, s1);
        if (!((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getReply_to().toString().trim().equals("0")) goto _L6; else goto _L5
_L5:
        lay_quote.setVisibility(8);
_L12:
        if (!((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L8; else goto _L7
_L7:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L13:
        if (((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png")) goto _L10; else goto _L9
_L9:
        boolean flag = ((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1926;
        }
_L10:
        Picasso.with(getActivity()).load(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getUsr_pict_komen().toString().trim()).into(img_kom_picture, new Callback() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
                img_kom_picture.setVisibility(0);
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
_L14:
        txtIdKom.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getId_komentar().toString());
        txtdisLikeKom.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_kurang().toString());
        txtLikeKom.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_bagus().toString());
        txtUsername.setText(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_komentar());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomentarhp().toString())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.entMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getNama_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.entMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_komentar()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getTanggal_to()));
        Hal3KomentarPull.access$0(Hal3KomentarPull.this).addView(void1, 0);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;
            private final String val$usr_pict_komen;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;
            private final String val$nama_komentar;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", nama_komentar);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                nama_komentar = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;
            private final String val$id_hp;
            private final String val$id_komentar;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "1";
                    idkom_pos = id_komentar;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal3KomentarPull.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal3KomentarPull.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;
            private final String val$id_hp;
            private final String val$id_komentar;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "0";
                    idkom_pos = id_komentar;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal3KomentarPull.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal3KomentarPull.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                id_komentar = s;
                id_hp = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;
            private final String val$codename;
            private final String val$email_komentar;
            private final String val$id_hp;
            private final String val$id_komentar;
            private final String val$komentarhp;
            private final String val$nama_komentar;
            private final String val$tanggal_komentar;
            private final String val$usr_pict_komen;

            public void onClick(View view)
            {
                Log.e("iRep", (new StringBuilder(String.valueOf(id_hp))).append(" - ").append(id_komentar).append(" - ").append(email_komentar).append(" - ").append(nama_komentar).append(" - ").append(tanggal_komentar).append(" - ").append(komentarhp).append(" - ").append(namalengkap).append(" - ").append(codename).toString());
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ReplyFormActivity);
                    view.putExtra("idhp", id_hp);
                    view.putExtra("idkomen", id_komentar);
                    view.putExtra("email_komentar", email_komentar);
                    view.putExtra("userkomen", nama_komentar);
                    view.putExtra("tanggal", tanggal_komentar);
                    view.putExtra("isikomentar", komentarhp);
                    view.putExtra("nmlengkap", namalengkap);
                    view.putExtra("userpict", usr_pict_komen);
                    view.putExtra("codename", codename);
                    view.putExtra("top_id", top_id);
                    startActivityForResult(view, Hal3KomentarPull.access$3());
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
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
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = s7;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        i++;
          goto _L11
_L6:
        lay_quote.setVisibility(0);
          goto _L12
_L8:
label0:
        {
            if (!((ItemKomenHp)Hal3KomentarPull.access$1(Hal3KomentarPull.this).get(i)).getMy_like_kom().toString().equals("0"))
            {
                break label0;
            }
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a7);
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(false);
        }
          goto _L13
        list_lay_like.setEnabled(true);
        list_lay_dislike.setEnabled(true);
        imageview.setBackgroundResource(0x7f020257);
        imageview1.setBackgroundResource(0x7f0201a3);
          goto _L13
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L14
        img_kom_picture.setImageResource(0x7f020297);
          goto _L14
_L2:
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnfooter.setVisibility(8);
                    view = this$0;
                    view.limit = ((Hal3KomentarPull) (view)).limit + 15;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal3KomentarPull.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal3KomentarPull.KomentarOldAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&code=").append(URLEncoder.encode(codename, "utf-8")).append("&sortkom=").append(sortkom).append("&lmt=").append(limit).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal3KomentarPull.KomentarNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new Hal3KomentarPull.KomentarNextAsycTask()).execute(new String[0]);
                return;
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3KomentarPull.KomentarNextAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("bottom_id", bottom_id);
                    querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3KomentarPull.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3KomentarPull.PostKomen(this$0)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = Hal3KomentarPull.KomentarNextAsycTask.this;
                super();
            }
        });
        return;
        void1;
          goto _L15
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtbtnfooter.setVisibility(8);
        Log.e("mArrayListDataNext", String.valueOf(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()));
        Hal3KomentarPull.access$1(Hal3KomentarPull.this).clear();
        Log.e("mArrayListDataNext", String.valueOf(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()));
    }


    public _cls9.this._cls1()
    {
        this$0 = Hal3KomentarPull.this;
        super();
    }
}
