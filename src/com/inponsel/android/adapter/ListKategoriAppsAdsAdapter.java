// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.adapter:
//            PonselBaseApp, ModelObserver, ListModel

public class ListKategoriAppsAdsAdapter extends BaseAdapter
    implements Observer
{
    class ViewHolder
    {

        ImageView img_fav_apps_1;
        ImageView img_kat_apps_1;
        ImageView img_like_apps_1;
        LinearLayout ll_fav_apps;
        LinearLayout ll_kat_apps_1;
        LinearLayout rl_like_apps;
        final ListKategoriAppsAdsAdapter this$0;
        TextView txt_fav_kat_apps_1;
        TextView txt_id_applist;
        TextView txt_kat_apps_1;
        TextView txt_like_kat_apps_1;
        TextView txt_sub_kat_apps_1;

        ViewHolder()
        {
            this$0 = ListKategoriAppsAdsAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    int count_number;
    protected Cursor cursor;
    protected DatabaseHandler db;
    protected String email_user;
    String fav_stat;
    private ArrayList lm;
    protected String nama_asli;
    NotificationLikeHelper notificationLikeHelper;
    PonselBaseApp ponselBaseApp;
    String response;
    protected UserFunctions userFunctions;
    protected String user_id;
    protected String user_jekel;
    protected String user_joindate;
    protected String user_kecamatan;
    protected String user_kota;
    protected String user_photo;
    protected String user_ponsel1;
    protected String user_ponsel2;
    protected String user_profile_update;
    protected String user_provider1;
    protected String user_provider2;
    protected String user_provinsi;
    protected String user_ttl;
    protected String username;

    public ListKategoriAppsAdsAdapter(Activity activity1, ArrayList arraylist)
    {
        fav_stat = "";
        count_number = 0;
        user_id = "";
        user_photo = "";
        username = "";
        nama_asli = "";
        email_user = "";
        user_ttl = "";
        user_kota = "";
        user_kecamatan = "";
        user_provinsi = "";
        user_jekel = "";
        user_ponsel1 = "";
        user_ponsel2 = "";
        user_provider1 = "";
        user_provider2 = "";
        user_joindate = "";
        user_profile_update = "";
        lm = arraylist;
        activity = activity1;
        db = new DatabaseHandler(activity1);
        userFunctions = new UserFunctions();
        ponselBaseApp = (PonselBaseApp)activity1.getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        notificationLikeHelper = new NotificationLikeHelper(activity1);
        if (userFunctions.isUserLoggedIn(activity1))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity1) { }
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
        }
    }

    public int getCount()
    {
        return lm.size();
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public ListModel getListModel(int i)
    {
        return (ListModel)lm.get(i);
    }

    public View getView(final int position, final View holder, ViewGroup viewgroup)
    {
        viewgroup = holder;
        ListModel listmodel;
        if (viewgroup == null)
        {
            viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(0x7f03013e, null);
            holder = new ViewHolder();
            holder.rl_like_apps = (LinearLayout)viewgroup.findViewById(0x7f0b0865);
            holder.ll_fav_apps = (LinearLayout)viewgroup.findViewById(0x7f0b0862);
            holder.img_fav_apps_1 = (ImageView)viewgroup.findViewById(0x7f0b0863);
            holder.txt_id_applist = (TextView)viewgroup.findViewById(0x7f0b08f0);
            holder.txt_kat_apps_1 = (TextView)viewgroup.findViewById(0x7f0b0860);
            holder.txt_sub_kat_apps_1 = (TextView)viewgroup.findViewById(0x7f0b0861);
            holder.txt_like_kat_apps_1 = (TextView)viewgroup.findViewById(0x7f0b0866);
            holder.txt_fav_kat_apps_1 = (TextView)viewgroup.findViewById(0x7f0b0864);
            holder.ll_kat_apps_1 = (LinearLayout)viewgroup.findViewById(0x7f0b0907);
            holder.img_kat_apps_1 = (ImageView)viewgroup.findViewById(0x7f0b0908);
            holder.img_like_apps_1 = (ImageView)viewgroup.findViewById(0x7f0b0867);
            viewgroup.setTag(holder);
        } else
        {
            holder = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(position);
        if (lm != null && !listmodel.getId_apps().contains("iklan"))
        {
            ((ViewHolder) (holder)).ll_kat_apps_1.setVisibility(0);
            ((ViewHolder) (holder)).txt_id_applist.setText(listmodel.getId_apps());
            ((ViewHolder) (holder)).txt_fav_kat_apps_1.setText(listmodel.getKat_fav_status());
            ((ViewHolder) (holder)).txt_kat_apps_1.setText(listmodel.getKat_apps_name());
            ((ViewHolder) (holder)).txt_sub_kat_apps_1.setText(listmodel.getKat_apps_desc());
            ((ViewHolder) (holder)).txt_like_kat_apps_1.setText(listmodel.getKat_total_like());
            Display display = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            display.getMetrics(displaymetrics);
            int i = displaymetrics.widthPixels - (int)Utility.convertDpToPixel(10F, activity);
            int j = displaymetrics.heightPixels;
            int k = (int)Utility.convertDpToPixel(10F, activity);
            ((ViewHolder) (holder)).img_kat_apps_1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(i, Math.min((int)(((double)i / (double)Integer.parseInt(listmodel.getKat_img_width())) * (double)Integer.parseInt(listmodel.getKat_img_height())), (j - k) / 3)));
            if (listmodel.getKat_apps_background_img().contains(".jpeg") || listmodel.getKat_apps_background_img().contains(".jpg") || listmodel.getKat_apps_background_img().contains(".png"))
            {
                ((ViewHolder) (holder)).img_kat_apps_1.setBackgroundColor(Color.parseColor(listmodel.getKat_apps_background()));
                Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(listmodel.getKat_apps_background_img().trim()).toString()).tag(this).into(((ViewHolder) (holder)).img_kat_apps_1, new Callback() {

                    final ListKategoriAppsAdsAdapter this$0;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        holder.img_kat_apps_1.setVisibility(0);
                    }

            
            {
                this$0 = ListKategoriAppsAdsAdapter.this;
                holder = viewholder;
                super();
            }
                });
            } else
            {
                ((ViewHolder) (holder)).img_kat_apps_1.setBackgroundColor(Color.parseColor(listmodel.getKat_apps_background()));
            }
            if (listmodel.getKat_like_status().equals("0"))
            {
                ((ViewHolder) (holder)).img_like_apps_1.setBackgroundResource(0x7f020257);
                ((ViewHolder) (holder)).rl_like_apps.setEnabled(true);
            } else
            {
                ((ViewHolder) (holder)).rl_like_apps.setEnabled(false);
                ((ViewHolder) (holder)).img_like_apps_1.setBackgroundResource(0x7f02025b);
            }
            if (listmodel.getKat_fav_status().equals("0"))
            {
                ((ViewHolder) (holder)).img_fav_apps_1.setBackgroundResource(0x7f020302);
            } else
            {
                ((ViewHolder) (holder)).img_fav_apps_1.setBackgroundResource(0x7f020303);
            }
            ((ViewHolder) (holder)).rl_like_apps.setOnClickListener(new android.view.View.OnClickListener() {

                final ListKategoriAppsAdsAdapter this$0;
                private final int val$position;

                public void onClick(final View urlPost)
                {
                    Log.e("postlike", getListModel(position).getKat_apps_name());
                    urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("post_like_applist.php?").append("t=f7c1ffed723d0578eca7f57388c8054d4fed52a7&id_user=").append(user_id).append("&id_kat=").append(getListModel(position).getId_apps()).toString();
                    (new AsyncHttpClient()).get(urlPost, position. new AsyncHttpResponseHandler() {

                        final _cls2 this$1;
                        private final int val$position;
                        private final String val$urlPost;

                        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                        {
                        }

                        public void onRetry(int i)
                        {
                        }

                        public void onStart()
                        {
                            Log.e("urlPost", urlPost);
                        }

                        public void onSuccess(int i, Header aheader[], byte abyte0[])
                        {
                            aheader = new String(abyte0);
                            Log.e("respJson", aheader);
                            aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                            i = 0;
_L3:
                            int j = aheader.length();
                            if (i < j) goto _L2; else goto _L1
_L1:
                            ponselBaseApp.setObserver().setIndexHp(getListModel(position).getId_apps());
                            ponselBaseApp.setObserver().setUpdateType("appsstore");
                            ponselBaseApp.setObserver().setStatus_like_ponsel("1");
                            return;
_L2:
                            abyte0 = aheader.getJSONObject(i);
                            ponselBaseApp.getObserver().setTot_LikePon(abyte0.getString("total_like"));
                            i++;
                              goto _L3
                            aheader;
                              goto _L1
                        }

            
            {
                this$1 = final__pcls2;
                urlPost = s;
                position = I.this;
                super();
            }
                    });
                }


            
            {
                this$0 = ListKategoriAppsAdsAdapter.this;
                position = i;
                super();
            }
            });
            ((ViewHolder) (holder)).ll_fav_apps.setOnClickListener(new android.view.View.OnClickListener() {

                final ListKategoriAppsAdsAdapter this$0;
                private final ViewHolder val$holder;
                private final int val$position;

                public void onClick(final View urlPost)
                {
                    Log.e("postfav", holder.txt_fav_kat_apps_1.getText().toString());
                    if (holder.txt_fav_kat_apps_1.getText().toString().equals("1"))
                    {
                        fav_stat = "0";
                    } else
                    {
                        fav_stat = "1";
                    }
                    urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=f7c1ffed723d0578eca7f57388c8054d4fed52a7&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(getListModel(position).getId_apps()).toString();
                    (new AsyncHttpClient()).get(urlPost, holder. new AsyncHttpResponseHandler() {

                        final _cls3 this$1;
                        private final ViewHolder val$holder;
                        private final int val$position;
                        private final String val$urlPost;

                        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                        {
                        }

                        public void onRetry(int i)
                        {
                        }

                        public void onStart()
                        {
                            if (fav_stat.equals("1"))
                            {
                                notificationLikeHelper.createNotification(getListModel(position).getKat_apps_name(), "Menambahkan ke favorit");
                            } else
                            {
                                notificationLikeHelper.createNotification(getListModel(position).getKat_apps_name(), "Menghapus ke favorit");
                            }
                            Log.e("urlPost", urlPost);
                        }

                        public void onSuccess(int i, Header aheader[], byte abyte0[])
                        {
                            aheader = new String(abyte0);
                            Log.e("respJson", aheader);
                            try
                            {
                                aheader = new JSONObject(aheader);
                                fav_stat = aheader.getString("success");
                            }
                            // Misplaced declaration of an exception variable
                            catch (Header aheader[]) { }
                            if (fav_stat.equals("0"))
                            {
                                holder.img_fav_apps_1.setBackgroundResource(0x7f020302);
                            } else
                            {
                                holder.img_fav_apps_1.setBackgroundResource(0x7f020303);
                            }
                            if (fav_stat.equals("1"))
                            {
                                notificationLikeHelper.completed(getListModel(position).getKat_apps_name(), "Berhasil menambahkan ke favorit");
                            } else
                            {
                                notificationLikeHelper.completed(getListModel(position).getKat_apps_name(), "Berhasil menghapus ke favorit");
                            }
                            ponselBaseApp.setObserver().setIndexHp(getListModel(position).getId_apps());
                            ponselBaseApp.setObserver().setUpdateType("favappsstore");
                            ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
                        }

            
            {
                this$1 = final__pcls3;
                position = i;
                urlPost = s;
                holder = ViewHolder.this;
                super();
            }
                    });
                }


            
            {
                this$0 = ListKategoriAppsAdsAdapter.this;
                holder = viewholder;
                position = i;
                super();
            }
            });
            count_number = count_number + 1;
        }
        return viewgroup;
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public void update(Observable observable, Object obj)
    {
    }
}
