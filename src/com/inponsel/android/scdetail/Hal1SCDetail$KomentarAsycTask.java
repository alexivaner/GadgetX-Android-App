// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.SCReplyFormActivity;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

public class this._cls0 extends AsyncTask
{

    final Hal1SCDetail this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        Log.e("KomentarAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
        Hal1SCDetail.access$3(Hal1SCDetail.this, new ArrayList());
        as = jsonobject.getJSONArray("InPonsel");
        jum_komen_list = jsonobject.getString("total_komen");
        jum_komen = jsonobject.getString("total_komen");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        Log.e("top_id", top_id);
        str_urlspekshare = jsonobject.getString("url_share");
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_334;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_334;
        }
        Object obj = Hal1SCDetail.this;
        obj.countAllKom = ((Hal1SCDetail) (obj)).countAllKom + 1;
        obj = Hal1SCDetail.this;
        obj.countKomOld = ((Hal1SCDetail) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Hal1SCDetail.access$2(Hal1SCDetail.this).add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_sc"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        progressbar_komen.setVisibility(8);
        int j;
        if (Hal1SCDetail.access$2(Hal1SCDetail.this).size() == 0)
        {
            txt_empty_komen.setVisibility(0);
        } else
        if (Hal1SCDetail.access$2(Hal1SCDetail.this).size() < 3)
        {
            btn_komenlain.setVisibility(8);
            txt_empty_komen.setVisibility(8);
        } else
        {
            txtLabelKomentar.setText((new StringBuilder("Komentar (")).append(jum_komen).append(")").toString());
            if (Integer.parseInt(jum_komen_list) == 3)
            {
                btn_komenlain.setVisibility(8);
                txt_empty_komen.setVisibility(8);
            } else
            {
                btn_komenlain.setVisibility(0);
                txt_empty_komen.setVisibility(8);
            }
        }
        if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
        i = 0;
_L8:
        ImageView imageview;
        ImageView imageview1;
        final String id_komrss;
        final String tl_id;
        final String id_user;
        final String komen_rss;
        final String tanggal_kom;
        final String user_photo;
        final String user_name;
        try
        {
            j = Hal1SCDetail.access$2(Hal1SCDetail.this).size();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        void1 = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300ff, null);
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
        txtLikeKom_list = (TextView)void1.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
        headName = (LinearLayout)void1.findViewById(0x7f0b0549);
        list_lay_like_kom = (RelativeLayout)void1.findViewById(0x7f0b0342);
        list_lay_dislike_kom = (RelativeLayout)void1.findViewById(0x7f0b0345);
        list_lay_rep_kom = (RelativeLayout)void1.findViewById(0x7f0b063f);
        list_lay_kom_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
        id_komrss = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getId_komrss();
        tl_id = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getId_komrss();
        id_user = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getId_user();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getId_user_to();
        komen_rss = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getKomen_rss();
        tanggal_kom = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTanggal_kom();
        user_photo = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_photo();
        user_name = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_name();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTanggal_to();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTotal_like();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTotal_dislike();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getMy_like_kom();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getKomen_to();
        ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_name_to();
        ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
        ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
        imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
        imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
        txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
        txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
        progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
        progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
        String s = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getImg_media();
        String s1 = ((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getImg_media_to();
        Hal1SCDetail.access$4(Hal1SCDetail.this, ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s, s1);
        if (!((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_name_to().toString().trim().equals("")) goto _L5; else goto _L4
_L4:
        lay_quote.setVisibility(8);
_L9:
        if (!((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L7; else goto _L6
_L6:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like_kom.setEnabled(false);
        list_lay_dislike_kom.setEnabled(true);
_L10:
        if (!((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_1973;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, Hal1SCDetail.access$5(Hal1SCDetail.this), Hal1SCDetail.access$0(Hal1SCDetail.this));
_L11:
        txtIdKom.setText(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getId_komrss().toString());
        txtdisLikeKom.setText(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTotal_dislike().toString());
        txtLikeKom_list.setText(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTotal_like().toString());
        txtUsername.setText(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_name());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getKomen_rss())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.inkMovementMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.inkMovementMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getTanggal_to()));
        Hal1SCDetail.access$1(Hal1SCDetail.this).addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final Hal1SCDetail.KomentarAsycTask this$1;
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
                this$1 = Hal1SCDetail.KomentarAsycTask.this;
                user_photo = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail.KomentarAsycTask this$1;
            private final String val$id_user;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", id_user);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = Hal1SCDetail.KomentarAsycTask.this;
                id_user = s;
                super();
            }
        });
        list_lay_like_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail.KomentarAsycTask this$1;
            private final String val$id_komrss;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "1";
                    idkom_pos = id_komrss;
                    querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(str_SC_ID).append("&idusr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylikeKomen);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal1SCDetail.PostBagusKurangKomenTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal1SCDetail.PostBagusKurangKomenTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
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
                this$1 = Hal1SCDetail.KomentarAsycTask.this;
                id_komrss = s;
                super();
            }
        });
        list_lay_dislike_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail.KomentarAsycTask this$1;
            private final String val$id_komrss;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "0";
                    idkom_pos = id_komrss;
                    querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(str_SC_ID).append("&idusr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylikeKomen", querylikeKomen);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal1SCDetail.PostBagusKurangKomenTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal1SCDetail.PostBagusKurangKomenTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
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
                this$1 = Hal1SCDetail.KomentarAsycTask.this;
                id_komrss = s;
                super();
            }
        });
        list_lay_rep_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail.KomentarAsycTask this$1;
            private final String val$id_komrss;
            private final String val$komen_rss;
            private final String val$tanggal_kom;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
                idkom_pos = id_komrss;
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                    view.putExtra("top_id", top_id);
                    view.putExtra("idkomen", idkom_pos);
                    view.putExtra("id_sc", str_SC_ID);
                    view.putExtra("userkomen", user_name);
                    view.putExtra("tanggal", tanggal_kom);
                    view.putExtra("isikomentar", komen_rss);
                    view.putExtra("userpict", user_photo);
                    view.putExtra("sc_nama", str_SC_NAMA);
                    view.putExtra("sc_merk", str_SC_merk);
                    getActivity().startActivityForResult(view, Hal1SCDetail.access$6());
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
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
                this$1 = Hal1SCDetail.KomentarAsycTask.this;
                id_komrss = s;
                user_name = s1;
                tanggal_kom = s2;
                komen_rss = s3;
                user_photo = s4;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCDetail.KomentarAsycTask this$1;
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
                    view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                    view.putExtra("tl_judul", "");
                    view.putExtra("tl_id", tl_id);
                    view.putExtra("id_komrss", id_komrss);
                    view.putExtra("user_id", user_id);
                    view.putExtra("user_name", user_name);
                    view.putExtra("tanggal_kom", tanggal_kom);
                    view.putExtra("komen_rss", komen_rss);
                    view.putExtra("user_photo", user_photo);
                    view.putExtra("top_id", top_id);
                    view.putExtra("id_sc", str_SC_ID);
                    Log.e("id_komrss_to", id_komrss);
                    startActivityForResult(view, Hal1SCDetail.access$6());
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
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
                this$1 = Hal1SCDetail.KomentarAsycTask.this;
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
          goto _L8
_L5:
        lay_quote.setVisibility(0);
          goto _L9
_L7:
label0:
        {
            if (!((ItemRSSKomen)Hal1SCDetail.access$2(Hal1SCDetail.this).get(i)).getMy_like_kom().toString().equals("0"))
            {
                break label0;
            }
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a7);
            list_lay_like_kom.setEnabled(true);
            list_lay_dislike_kom.setEnabled(false);
        }
          goto _L10
        list_lay_like_kom.setEnabled(true);
        list_lay_dislike_kom.setEnabled(true);
        imageview.setBackgroundResource(0x7f020257);
        imageview1.setBackgroundResource(0x7f0201a3);
          goto _L10
        img_kom_picture.setImageResource(0x7f020297);
          goto _L11
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.e("KomentarAsycTask", "onPreExecute");
        Log.e("KomentarAsycTask", "onPreExecute");
        progressbar_komen.setVisibility(0);
        txt_empty_komen.setVisibility(8);
        btn_komenlain.setVisibility(8);
        Hal1SCDetail.access$1(Hal1SCDetail.this).removeAllViewsInLayout();
        Hal1SCDetail.access$2(Hal1SCDetail.this).clear();
    }


    public _cls6.val.user_photo()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
