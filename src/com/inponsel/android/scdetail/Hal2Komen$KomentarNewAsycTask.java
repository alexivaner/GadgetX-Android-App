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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.timelinedetail.ReplyKomTLActivity;
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
//            Hal2Komen

public class this._cls0 extends AsyncTask
{

    final Hal2Komen this$0;

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
            break MISSING_BLOCK_LABEL_262;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_262;
        }
        Object obj = Hal2Komen.this;
        obj.countAllKom = ((Hal2Komen) (obj)).countAllKom + 1;
        obj = Hal2Komen.this;
        obj.countKomOld = ((Hal2Komen) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Hal2Komen.access$1(Hal2Komen.this).add(0, new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_sc"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
        layout_header.setVisibility(8);
        int i;
        if (Hal2Komen.access$1(Hal2Komen.this).size() < 15)
        {
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(8);
        } else
        {
            txtbtnheader.setVisibility(0);
        }
        ImageView imageview;
        ImageView imageview1;
        final String id_komrss;
        final String sc_id;
        final String id_user;
        final String komen_rss;
        final String tanggal_kom;
        final String user_photo;
        final String user_name;
        try
        {
            Log.e("countAllKom", String.valueOf(countAllKom));
            Log.e("mArrayListDataold", String.valueOf(Hal2Komen.access$1(Hal2Komen.this).size()));
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        i = 0;
        if (i >= Hal2Komen.access$1(Hal2Komen.this).size())
        {
            void1 = Hal2Komen.this;
            void1.removeIndex = ((Hal2Komen) (void1)).removeIndex + 3;
            Log.e("removeIndexBef", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
            void1 = Hal2Komen.this;
            void1.removeStartOld = ((Hal2Komen) (void1)).removeStartOld + 3;
            Log.e("removeIndexAft", String.valueOf((new StringBuilder(String.valueOf(removeStartOld))).append(",").append(removeIndex).toString()));
            return;
        }
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
        id_komrss = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getId_komrss();
        sc_id = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getId_rss();
        id_user = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getId_user();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getId_user_to();
        komen_rss = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getKomen_rss();
        tanggal_kom = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTanggal_kom();
        user_photo = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_photo();
        user_name = ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_name();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTanggal_to();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTotal_like();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTotal_dislike();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getMy_like_kom();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getKomen_to();
        ((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_name_to();
        if (!((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_name_to().toString().trim().equals("")) goto _L2; else goto _L1
_L1:
        lay_quote.setVisibility(8);
_L5:
        if (!((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getMy_like_kom().toString().equals("1")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f02025b);
        imageview1.setBackgroundResource(0x7f0201a3);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L6:
        if (!((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_1749;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, Hal2Komen.access$3(Hal2Komen.this), Hal2Komen.access$4(Hal2Komen.this));
_L7:
        txtIdKom.setText(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getId_komrss().toString());
        txtdisLikeKom.setText(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTotal_dislike().toString());
        txtLikeKom.setText(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTotal_like().toString());
        txtUsername.setText(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_name());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getKomen_rss())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.inkMovementMethod.getInstance());
        txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getUser_name_to()));
        txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getKomen_to().toString())));
        txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.inkMovementMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTanggal_kom()));
        txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getTanggal_to()));
        Log.e("counter old", String.valueOf(i));
        Hal2Komen.access$0(Hal2Komen.this).addView(void1, 0);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final Hal2Komen.KomentarNewAsycTask this$1;
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
                this$1 = Hal2Komen.KomentarNewAsycTask.this;
                user_photo = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen.KomentarNewAsycTask this$1;
            private final String val$id_user;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", id_user);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = Hal2Komen.KomentarNewAsycTask.this;
                id_user = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen.KomentarNewAsycTask this$1;
            private final String val$id_komrss;
            private final String val$sc_id;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "1";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2Komen.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal2Komen.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                this$1 = Hal2Komen.KomentarNewAsycTask.this;
                id_komrss = s;
                sc_id = s1;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen.KomentarNewAsycTask this$1;
            private final String val$id_komrss;
            private final String val$sc_id;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "0";
                    idkom_pos = id_komrss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&idkomen=").append(idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2Komen.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal2Komen.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                this$1 = Hal2Komen.KomentarNewAsycTask.this;
                id_komrss = s;
                sc_id = s1;
                super();
            }
        });
        list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen.KomentarNewAsycTask this$1;
            private final String val$id_komrss;
            private final String val$komen_rss;
            private final String val$sc_id;
            private final String val$tanggal_kom;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                    view.putExtra("top_id", top_id);
                    view.putExtra("idkomen", id_komrss);
                    view.putExtra("id_sc", sc_id);
                    view.putExtra("userkomen", user_name);
                    view.putExtra("tanggal", tanggal_kom);
                    view.putExtra("isikomentar", komen_rss);
                    view.putExtra("userpict", user_photo);
                    view.putExtra("sc_nama", "");
                    view.putExtra("sc_merk", "");
                    getActivity().startActivityForResult(view, Hal2Komen.access$5());
                    return;
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
                this$1 = Hal2Komen.KomentarNewAsycTask.this;
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Komen.KomentarNewAsycTask this$1;
            private final String val$id_komrss;
            private final String val$komen_rss;
            private final String val$sc_id;
            private final String val$tanggal_kom;
            private final String val$user_name;
            private final String val$user_photo;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    view = new Intent(getActivity(), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                    view.putExtra("sc_judul", sc_judul);
                    view.putExtra("sc_id", sc_id);
                    view.putExtra("id_komrss", id_komrss);
                    view.putExtra("user_id", user_id);
                    view.putExtra("user_name", user_name);
                    view.putExtra("tanggal_kom", tanggal_kom);
                    view.putExtra("komen_rss", komen_rss);
                    view.putExtra("user_photo", user_photo);
                    view.putExtra("bottom_id", bottom_id);
                    Log.e("id_komrss_to", id_komrss);
                    startActivityForResult(view, Hal2Komen.access$5());
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
                this$1 = Hal2Komen.KomentarNewAsycTask.this;
                sc_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
                super();
            }
        });
        i++;
        break MISSING_BLOCK_LABEL_87;
_L2:
        lay_quote.setVisibility(0);
          goto _L5
_L4:
label0:
        {
            if (!((ItemRSSKomen)Hal2Komen.access$1(Hal2Komen.this).get(i)).getMy_like_kom().toString().equals("0"))
            {
                break label0;
            }
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a7);
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(false);
        }
          goto _L6
        list_lay_like.setEnabled(true);
        list_lay_dislike.setEnabled(true);
        imageview.setBackgroundResource(0x7f020257);
        imageview1.setBackgroundResource(0x7f0201a3);
          goto _L6
        img_kom_picture.setImageResource(0x7f020297);
          goto _L7
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtbtnheader.setVisibility(8);
        layout_header.setVisibility(0);
        Hal2Komen.access$1(Hal2Komen.this).clear();
    }


    public _cls6.val.user_photo()
    {
        this$0 = Hal2Komen.this;
        super();
    }
}
