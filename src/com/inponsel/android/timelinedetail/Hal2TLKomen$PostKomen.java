// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
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
import com.inponsel.android.adapter.ItemRSSKomen;
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

    private void parseJSONKom(String s)
    {
        s = new JSONObject(s);
        postStatus = s.getString("success");
        postMessage = s.getString("message");
        statusKomen = s.getString("statuskomen");
        tot_LikePon = s.getString("total_like");
        totdis_LikePon = s.getString("total_dislike");
        jum_komen = s.getString("total_komen");
        ponselBaseApp.getObserver().setJum_komenLikeTL(jum_komen);
        ponselBaseApp.getObserver().setTot_LikeTL(tot_LikePon);
        ponselBaseApp.getObserver().setIndexTL(tl_id);
        Log.e("postStatus", postStatus);
        if (!postStatus.equals("1"))
        {
            break MISSING_BLOCK_LABEL_364;
        }
        top_id = s.getString("top_id");
        jArray = s.getJSONArray("InPonsel");
        int i = 0;
_L2:
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        Hal2TLKomen.access$1(Hal2TLKomen.this).add(Hal2TLKomen.access$1(Hal2TLKomen.this).size(), new ItemRSSKomen(s.getString("id_kom"), s.getString("id_artanya"), s.getString("id_user"), s.getString("id_user_to"), s.getString("komentar"), s.getString("tanggal_kom"), s.getString("user_photo"), s.getString("user_name"), s.getString("tanggal_to"), s.getString("total_like"), s.getString("total_dislike"), s.getString("my_like_kom"), s.getString("user_name_to"), s.getString("komen_to"), s.getString("img_kom"), s.getString("img_kom_rep")));
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
            if (android.os.y >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.y.Builder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_forum").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
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
        int i;
        super.onPostExecute(void1);
        ponselBaseApp.getObserver().setUpdateType("komentartl");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        jum_komen.equals("-");
        Log.e("notifkomen", statusKomen);
        if (statusKomen.equals("1"))
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
        countKomOld = 0;
        i = 0;
_L4:
        if (i >= Hal2TLKomen.access$1(Hal2TLKomen.this).size())
        {
            layout_empty.setVisibility(8);
            break MISSING_BLOCK_LABEL_146;
        } else
        {
            void1 = Hal2TLKomen.this;
            void1.countRemIndex = ((Hal2TLKomen) (void1)).countRemIndex + 1;
            void1 = Hal2TLKomen.this;
            void1.countKomOld = ((Hal2TLKomen) (void1)).countKomOld + 1;
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
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054f);
            ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            final String id_komrss = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_komrss();
            final String tl_id = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_rss();
            final String id_user = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_user();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_user_to();
            final String komen_rss = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_rss();
            final String tanggal_kom = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_kom();
            final String user_photo = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo();
            final String user_name = ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_to();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_like();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_dislike();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getMy_like_kom();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_to();
            ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to();
            if (((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to().toString().trim().equals("-") || ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to().toString().trim().equals(""))
            {
                lay_quote.setVisibility(8);
            } else
            {
                lay_quote.setVisibility(0);
            }
            if (((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getMy_like_kom().toString().equals("1"))
            {
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                list_lay_like.setEnabled(false);
                list_lay_dislike.setEnabled(true);
            } else
            if (((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getMy_like_kom().toString().equals("0"))
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
            if (((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().trim().contains(".jpg") || ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().toString().trim().contains(".png") || ((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                imageLoader2.displayImage((new StringBuilder()).append(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_photo().toString().trim()).toString(), img_kom_picture, Hal2TLKomen.access$3(Hal2TLKomen.this), Hal2TLKomen.access$4(Hal2TLKomen.this));
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_dislike().toString());
            txtLikeKom.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.e.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.e.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)Hal2TLKomen.access$1(Hal2TLKomen.this).get(i)).getTanggal_to()));
            Hal2TLKomen.access$0(Hal2TLKomen.this).addView(void1, 0);
            img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final Hal2TLKomen.PostKomen this$1;
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
                this$1 = Hal2TLKomen.PostKomen.this;
                user_photo = s;
                super();
            }
            });
            img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2TLKomen.PostKomen this$1;
                private final String val$id_user;

                public void onClick(View view)
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", id_user);
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal2TLKomen.PostKomen.this;
                id_user = s;
                super();
            }
            });
            list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2TLKomen.PostKomen this$1;
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
                this$1 = Hal2TLKomen.PostKomen.this;
                id_komrss = s;
                tl_id = s1;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2TLKomen.PostKomen this$1;
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
                this$1 = Hal2TLKomen.PostKomen.this;
                id_komrss = s;
                tl_id = s1;
                super();
            }
            });
            list_lay_rep.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2TLKomen.PostKomen this$1;
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
                this$1 = Hal2TLKomen.PostKomen.this;
                tl_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = s5;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2TLKomen.PostKomen this$1;
                private final String val$tl_id;

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
                this$1 = Hal2TLKomen.PostKomen.this;
                tl_id = s;
                super();
            }
            });
            i++;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2TLKomen.PostKomen this$1;

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
                    (new Hal2TLKomen.PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal2TLKomen.PostKomen()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$1 = Hal2TLKomen.PostKomen.this;
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
            mNotificationHelper.completed(tl_judul, mNotificationHelper.SucdiskomStatement);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setText("");
            if (android.os.WriterEditText.setText >= 11)
            {
                (new sk(Hal2TLKomen.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new sk(Hal2TLKomen.this)).execute(new Void[0]);
                return;
            }
        }
        layout_empty.setVisibility(8);
        if (postStatus.equals("040"))
        {
            mNotificationHelper.gagal(tl_judul, postMessage);
            return;
        }
        mNotificationHelper.gagal(tl_judul, mNotificationHelper.gagalkomStatement);
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        btn_send_komen.setEnabled(false);
        edt_pop_komen.setEnabled(false);
        txtbtnheader.setEnabled(false);
        txtbtnheader.setTextColor(Color.parseColor("#cacaca"));
        edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
        Log.e("mArrayListDataPostKomen", String.valueOf(Hal2TLKomen.access$1(Hal2TLKomen.this).size()));
        mNotificationHelper.createNotification(tl_judul, mNotificationHelper.komenPostWords);
        Hal2TLKomen.access$1(Hal2TLKomen.this).clear();
        Log.e("clearmArrayKomen", String.valueOf(Hal2TLKomen.access$1(Hal2TLKomen.this).size()));
    }


    public _cls7.this._cls1()
    {
        this$0 = Hal2TLKomen.this;
        super();
    }
}
