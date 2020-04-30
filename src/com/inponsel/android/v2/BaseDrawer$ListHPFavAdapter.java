// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, RegisterActivity, LoginActivity

public class db extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imageHp;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final BaseDrawer.ListHPFavAdapter this$1;
        TextView txt_NotifHp;

        ViewHolder()
        {
            this$1 = BaseDrawer.ListHPFavAdapter.this;
            super();
        }
    }


    private Activity activity;
    private ArrayList arraylm;
    Context context;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    String finalUrl;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    int hargaBaru;
    int hargaBekas;
    String hrg_baru;
    String hrg_bekas;
    ImageLoader imageLoader2;
    String indexhp;
    String komen;
    ListModel lms;
    private DisplayImageOptions options;
    PonselBaseApp ponselBaseApp;
    int pos;
    String res;
    int resource;
    String response;
    String statSubNews;
    String statusLikeHp;
    String t;
    final BaseDrawer this$0;
    String user;
    UserFunctions userFunctions;

    public int getCount()
    {
        return arraylm.size();
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
        return (ListModel)arraylm.get(i);
    }

    public View getView(final int position, View view, final ViewGroup holder)
    {
        pos = position;
        holder = (LayoutInflater)activity.getSystemService("layout_inflater");
        if (view == null)
        {
            view = holder.inflate(resource, null);
            holder = new ViewHolder();
            holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            holder.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
            holder.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
            holder.txt_NotifHp = (TextView)view.findViewById(0x7f0b0651);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        lms = (ListModel)arraylm.get(position);
        if (arraylm != null)
        {
            hrg_baru = lms.getHrg_baru();
            hrg_bekas = lms.getHrg_bekas();
            ((ViewHolder) (holder)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
            ((ViewHolder) (holder)).list_txtCodename.setText(lms.getCodename());
            if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
            {
                ((ViewHolder) (holder)).list_txtHarga.setVisibility(8);
            } else
            {
                ((ViewHolder) (holder)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (holder)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
            }
            ((ViewHolder) (holder)).txt_NotifHp.setText("Hapus");
            ((ViewHolder) (holder)).txt_NotifHp.setOnClickListener(new android.view.View.OnClickListener() {

                final BaseDrawer.ListHPFavAdapter this$1;
                private final int val$position;

                public void onClick(View view1)
                {
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        view1 = new android.app.AlertDialog.Builder(getApplicationContext());
                        view1.setMessage("Hentikan langganan forum perangkat ini?");
                        view1.setPositiveButton("Ya", position. new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;
                            private final int val$position;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                id_hp_del = getListModel(position).getId_hp();
                                statSubNews = "0";
                                (new BaseDrawer.DeleteHpFavTask(this$0)).execute(new Void[0]);
                            }

            
            {
                this$2 = final__pcls1;
                position = I.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                        view1.show();
                        return;
                    } else
                    {
                        view1 = new android.app.AlertDialog.Builder(getApplicationContext());
                        view1.setMessage("Untuk berlangganan forum, diharuskan login.");
                        view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                        view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/RegisterActivity);
                                startActivityForResult(dialoginterface, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivityForResult(dialoginterface, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                }


            
            {
                this$1 = BaseDrawer.ListHPFavAdapter.this;
                position = i;
                super();
            }
            });
            try
            {
                imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (holder)).imageHp, options, new ImageLoadingListener() {

                    final BaseDrawer.ListHPFavAdapter this$1;
                    private final ViewHolder val$holder;

                    public void onLoadingCancelled(String s, View view1)
                    {
                    }

                    public void onLoadingComplete(String s, View view1, Bitmap bitmap)
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

                    public void onLoadingFailed(String s, View view1, FailReason failreason)
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

                    public void onLoadingStarted(String s, View view1)
                    {
                        holder.progressbar_item.setVisibility(0);
                        holder.imageHp.setVisibility(8);
                    }

            
            {
                this$1 = BaseDrawer.ListHPFavAdapter.this;
                holder = viewholder;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (final ViewGroup holder)
            {
                return view;
            }
        }
        return view;
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        arraylm = arraylist;
    }


    public caleType(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = BaseDrawer.this;
        super();
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
        t = Utility.session(RestClient.pelihara);
        user = "";
        komen = "";
        email_user = "";
        indexhp = "";
        finalUrl = "";
        statSubNews = "";
        t = Utility.session(t);
        arraylm = arraylist;
        activity = activity1;
        resource = i;
        t = Utility.session(t);
        try
        {
            imageLoader2 = ImageLoader.getInstance();
            imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
            options = (new com.nostra13.universalimageloader.core.<init>()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Config).build();
            userFunctions = new UserFunctions();
            db = new DatabaseHandler(activity1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BaseDrawer basedrawer)
        {
            return;
        }
    }
}
