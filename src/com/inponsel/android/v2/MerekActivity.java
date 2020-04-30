// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.andraskindler.quickscroll.QuickScroll;
import com.andraskindler.quickscroll.Scrollable;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.ProfilPTActivity;
import com.inponsel.android.details.TwitterInPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.SampleScrollListener;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, RegisterActivity, LoginActivity, DaftarPonselMerkActivity, 
//            RSSFeedByTag, SCMerkActivity

public class MerekActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    public class ListPendatangAdapter extends BaseAdapter
        implements Scrollable
    {

        private Activity activity;
        String brandFav;
        String brandSubNews;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String fb_array[];
        String finalUrl;
        ViewHolder holder;
        String id_brand;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        int pos;
        String postMessageSubsNews;
        String postStatusSubsNews;
        String pushURL;
        String query;
        String res;
        int resource;
        String response;
        String statFavNews;
        String statSubNews;
        String status;
        String str_sc_fb;
        String str_sc_fb_id;
        String str_sc_twitter;
        String t;
        final MerekActivity this$0;
        String tw_array[];
        String user;
        UserFunctions userFunctions;
        String username;

        public int getCount()
        {
            return lm.size();
        }

        public String getIndicatorForPosition(int i, int j)
        {
            return ((ListModel)lm.get(i)).getIndicator();
        }

        public Object getItem(int i)
        {
            return lm.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public Intent getOpenFacebookIntent(Context context1)
        {
            try
            {
                context1.getPackageManager().getPackageInfo("com.facebook.katana", 0);
                context1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("fb://page/")).append(str_sc_fb_id).toString()));
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://www.facebook.com/")).append(str_sc_fb_id).toString()));
            }
            return context1;
        }

        public int getScrollPosition(int i, int j)
        {
            return i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (i == 10000)
            {
                viewgroup = viewgroup.inflate(0x7f0300be, null);
            } else
            {
                if (view == null)
                {
                    view = viewgroup.inflate(resource, null);
                    holder = new ViewHolder();
                    holder.img_merek = (ImageView)view.findViewById(0x7f0b00b5);
                    holder.txt_merek = (TextView)view.findViewById(0x7f0b00b6);
                    holder.txtBrandFB = (TextView)view.findViewById(0x7f0b0604);
                    holder.txtBrandTwitter = (TextView)view.findViewById(0x7f0b0601);
                    holder.txtFavStatBrand = (TextView)view.findViewById(0x7f0b0605);
                    holder.txtSubStatBrand = (TextView)view.findViewById(0x7f0b060a);
                    holder.txtLanggananBrand = (TextView)view.findViewById(0x7f0b060b);
                    holder.imgLanggananBerita = (Button)view.findViewById(0x7f0b0606);
                    holder.imgLanggananBeritaOff = (Button)view.findViewById(0x7f0b060c);
                    holder.imgFavoritBrand = (Button)view.findViewById(0x7f0b0608);
                    holder.imgFavoritBrandOff = (Button)view.findViewById(0x7f0b0609);
                    holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                    holder.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                    holder.itemBrandProduk = (LinearLayout)view.findViewById(0x7f0b05fd);
                    holder.itemBrandProfile = (LinearLayout)view.findViewById(0x7f0b05fe);
                    holder.itemBrandBerita = (LinearLayout)view.findViewById(0x7f0b05ff);
                    holder.itemBrandTwitter = (LinearLayout)view.findViewById(0x7f0b0600);
                    holder.itemBrandSC = (LinearLayout)view.findViewById(0x7f0b0602);
                    holder.itemBrandFacebook = (LinearLayout)view.findViewById(0x7f0b0603);
                    view.setTag(holder);
                } else
                {
                    holder = (ViewHolder)view.getTag();
                }
                lms = (ListModel)lm.get(i);
                viewgroup = view;
                if (lm != null)
                {
                    viewgroup = activity.getResources().getDrawable(0x7f020240);
                    viewgroup.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                    Drawable drawable = activity.getResources().getDrawable(0x7f0201ea);
                    drawable.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                    if (android.os.Build.VERSION.SDK_INT < 16)
                    {
                        holder.imgLanggananBerita.setBackgroundDrawable(drawable);
                        holder.imgLanggananBeritaOff.setBackgroundDrawable(viewgroup);
                        holder.imgFavoritBrand.setBackgroundDrawable(drawable);
                        holder.imgFavoritBrandOff.setBackgroundDrawable(viewgroup);
                    } else
                    {
                        holder.imgLanggananBerita.setBackground(drawable);
                        holder.imgLanggananBeritaOff.setBackground(viewgroup);
                        holder.imgFavoritBrand.setBackground(drawable);
                        holder.imgFavoritBrandOff.setBackground(viewgroup);
                    }
                    hrg_baru = lms.getHrg_baru();
                    hrg_bekas = lms.getHrg_bekas();
                    holder.txtLanggananBrand.setText((new StringBuilder("Langganan berita ")).append(lms.getMerk()).toString());
                    holder.txt_merek.setText(lms.getMerk());
                    holder.txtFavStatBrand.setText(lms.getFav_status());
                    holder.txtSubStatBrand.setText(lms.getSubs_status());
                    if (lms.getTwitter().toString().equals("") || lms.getTwitter().toString().equals("-"))
                    {
                        holder.txtBrandTwitter.setTextColor(Color.parseColor("#cacaca"));
                        holder.itemBrandTwitter.setClickable(false);
                        holder.itemBrandTwitter.setBackgroundResource(0x106000d);
                    } else
                    {
                        holder.txtBrandTwitter.setTextColor(Color.parseColor("#4c4c4c"));
                    }
                    holder.txt_merek.setVisibility(0);
                    if (lms.getFav_status().equals("1"))
                    {
                        holder.imgFavoritBrand.setVisibility(0);
                        holder.imgFavoritBrandOff.setVisibility(8);
                    } else
                    {
                        holder.imgFavoritBrand.setVisibility(8);
                        holder.imgFavoritBrandOff.setVisibility(0);
                    }
                    if (lms.getSubs_status().equals("1"))
                    {
                        holder.imgLanggananBerita.setVisibility(0);
                        holder.imgLanggananBeritaOff.setVisibility(8);
                    } else
                    {
                        holder.imgLanggananBerita.setVisibility(8);
                        holder.imgLanggananBeritaOff.setVisibility(0);
                    }
                    holder.imgLanggananBerita.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            id_brand = getListModel(position).getId_merk();
                            Log.e("substattext", id_brand);
                            statSubNews = getListModel(position).getSubs_status();
                            brandSubNews = getListModel(position).getMerk();
                            if (userFunctions.isUserLoggedIn(activity))
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Hentikan langganan berita merek ini?");
                                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                        statSubNews = "0";
                                        (new ListPendatangAdapter.SubsNewsTask()).execute(new Void[0]);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                                });
                                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                                });
                                view.show();
                                return;
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                                view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                                });
                                view.show();
                                return;
                            }
                        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.imgLanggananBeritaOff.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            id_brand = getListModel(position).getId_merk();
                            Log.e("substattext", id_brand);
                            statSubNews = getListModel(position).getSubs_status();
                            brandSubNews = getListModel(position).getMerk();
                            if (userFunctions.isUserLoggedIn(activity))
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Langganan berita merek ini?");
                                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        statSubNews = "1";
                                        (new ListPendatangAdapter.SubsNewsTask()).execute(new Void[0]);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                                });
                                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                                });
                                view.show();
                                return;
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                                view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                                });
                                view.show();
                                return;
                            }
                        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.imgFavoritBrand.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            id_brand = getListModel(position).getId_merk();
                            Log.e("substattext", id_brand);
                            statFavNews = getListModel(position).getFav_status();
                            brandFav = getListModel(position).getMerk();
                            if (userFunctions.isUserLoggedIn(activity))
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Hapus merek ini dari favorit?");
                                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                        statFavNews = "0";
                                        (new ListPendatangAdapter.FavHPTask()).execute(new Void[0]);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls3.this;
                super();
            }
                                });
                                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls3.this;
                super();
            }
                                });
                                view.show();
                                return;
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Untuk menambahkan ke favorit, diharuskan login.");
                                view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls3.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls3.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls3 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls3.this;
                super();
            }
                                });
                                view.show();
                                return;
                            }
                        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.imgFavoritBrandOff.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            id_brand = getListModel(position).getId_merk();
                            Log.e("substattext", id_brand);
                            statFavNews = getListModel(position).getFav_status();
                            brandFav = getListModel(position).getMerk();
                            if (userFunctions.isUserLoggedIn(activity))
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Favoritkan merek ini?");
                                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls4 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        statFavNews = "1";
                                        (new ListPendatangAdapter.FavHPTask()).execute(new Void[0]);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls4.this;
                super();
            }
                                });
                                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls4 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls4.this;
                super();
            }
                                });
                                view.show();
                                return;
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Untuk menambahkan ke favorit, diharuskan login.");
                                view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls4 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls4.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls4 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls4.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final ListPendatangAdapter._cls4 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        startActivityForResult(dialoginterface, 0);
                                        activity.overridePendingTransition(0x7f040003, 0x7f040004);
                                    }

            
            {
                this$2 = ListPendatangAdapter._cls4.this;
                super();
            }
                                });
                                view.show();
                                return;
                            }
                        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    if (lms.getFacebook().toString().equals("") || lms.getFacebook().toString().equals("-"))
                    {
                        holder.txtBrandFB.setTextColor(Color.parseColor("#cacaca"));
                        holder.itemBrandFacebook.setClickable(false);
                        holder.itemBrandFacebook.setBackgroundResource(0x106000d);
                    } else
                    {
                        holder.txtBrandFB.setTextColor(Color.parseColor("#4c4c4c"));
                    }
                    holder.itemBrandProduk.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            merk = getListModel(position).getId_merk().toString();
                            titlemerek = getListModel(position).getMerk().toString();
                            view = new Intent(getApplicationContext(), com/inponsel/android/v2/DaftarPonselMerkActivity);
                            view.putExtra("merk", merk);
                            view.putExtra("titlemerek", titlemerek);
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.itemBrandBerita.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            view = new Intent(getApplicationContext(), com/inponsel/android/v2/RSSFeedByTag);
                            view.putExtra("tag_code", "2");
                            view.putExtra("tag_key", (new StringBuilder("br:")).append(getListModel(position).getId_merk().toString()).toString());
                            view.putExtra("kategori_tag", getListModel(position).getMerk().toString());
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.itemBrandProfile.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            view = new Intent(getApplicationContext(), com/inponsel/android/details/ProfilPTActivity);
                            view.putExtra("id_merk", getListModel(position).getId_merk().toString());
                            view.putExtra("titlemerek", merk);
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.itemBrandTwitter.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
label0:
                            {
                                str_sc_twitter = getListModel(position).getTwitter().toString();
                                tw_array = str_sc_twitter.split(",");
                                if (!str_sc_twitter.equals("") && !str_sc_twitter.equals("-"))
                                {
                                    if (tw_array.length <= 1)
                                    {
                                        break label0;
                                    }
                                    view = new android.app.AlertDialog.Builder(_fld0);
                                    view.setTitle("Pilih Twitter");
                                    view.setSingleChoiceItems(tw_array, -1, new android.content.DialogInterface.OnClickListener() {

                                        final ListPendatangAdapter._cls8 this$2;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/details/TwitterInPonsel);
                                            dialoginterface.putExtra("twitter", tw_array[i].replace(" ", ""));
                                            startActivityForResult(dialoginterface, 0);
                                            overridePendingTransition(0x7f040003, 0x7f040004);
                                        }

            
            {
                this$2 = ListPendatangAdapter._cls8.this;
                super();
            }
                                    });
                                    view.show();
                                }
                                return;
                            }
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(str_sc_twitter).toString())));
                        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.itemBrandSC.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            view = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMerkActivity);
                            view.putExtra("sc_id_merk", getListModel(position).getId_merk().toString());
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    holder.itemBrandFacebook.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListPendatangAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            str_sc_fb = getListModel(position).getFacebook().toString();
                            str_sc_fb_id = getListModel(position).getFacebook_id().toString();
                            fb_array = str_sc_fb.split(",");
                            if (str_sc_fb.equals("") || str_sc_fb.equals("-"))
                            {
                                break MISSING_BLOCK_LABEL_126;
                            }
                            view = getOpenFacebookIntent(getApplicationContext());
                            startActivity(view);
                            return;
                            view;
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(str_sc_fb).toString())));
                            return;
                        }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                    });
                    try
                    {
                        viewgroup = lms.getLogo().trim();
                        Log.e("urllogo", viewgroup);
                        Picasso.with(activity.getApplicationContext()).load(viewgroup).tag(activity).into(holder.img_merek, new Callback() {

                            final ListPendatangAdapter this$1;

                            public void onError()
                            {
                                holder.progressbar_item.setVisibility(8);
                                holder.img_merek.setImageResource(0x7f02033f);
                            }

                            public void onSuccess()
                            {
                                Log.e("load_logo", lms.getMerk());
                                holder.progressbar_item.setVisibility(8);
                                holder.img_merek.setVisibility(0);
                                holder.txt_merek.setVisibility(0);
                            }

            
            {
                this$1 = ListPendatangAdapter.this;
                super();
            }
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (ViewGroup viewgroup)
                    {
                        holder.progressbar_item.setVisibility(8);
                        return view;
                    }
                    return view;
                }
            }
            return viewgroup;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }



        public ListPendatangAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = MerekActivity.this;
            super();
            statSubNews = "";
            statFavNews = "";
            brandSubNews = "";
            brandFav = "";
            pushURL = "";
            query = "";
            id_brand = "";
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MerekActivity merekactivity)
            {
                return;
            }
        }
    }

    public class ListPendatangAdapter.FavHPTask extends AsyncTask
    {

        final ListPendatangAdapter this$1;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                query = (new StringBuilder("idhp=")).append(id_brand).append("&idusr=").append(user_id).append("&stat=").append(statFavNews).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_fav_brand").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                res = avoid.toString();
                Log.e("url ", res);
                parseJSONSubsNews(res);
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
            super.onPostExecute(void1);
            Log.e("postStatusSubsNews", postStatusSubsNews);
            Log.e("statFavNews", statFavNews);
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                updateViewFavBrand(brandFav, statFavNews);
                mDialog.dismiss();
                ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                ponselBaseApp.getObserver().setLoginStat("1");
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                holder.imgFavoritBrand.setBackgroundResource(0x7f020240);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statFavNews.equals("1"))
            {
                mDialog = ProgressDialog.show(activity, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(activity, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListPendatangAdapter.FavHPTask()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    public class ListPendatangAdapter.SubsNewsTask extends AsyncTask
    {

        final ListPendatangAdapter this$1;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                query = (new StringBuilder("idhp=")).append(id_brand).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_brand").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                res = avoid.toString();
                Log.e("url ", res);
                parseJSONSubsNews(res);
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
            super.onPostExecute(void1);
            Log.e("postStatusSubsNews", postStatusSubsNews);
            Log.e("statSubNews", statSubNews);
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                updateViewSubsBrand(brandSubNews, statSubNews);
                mDialog.dismiss();
                ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                ponselBaseApp.getObserver().setLoginStat("1");
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                holder.imgLanggananBerita.setBackgroundResource(0x7f020240);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(activity, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(activity, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListPendatangAdapter.SubsNewsTask()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    class ListPendatangAdapter.ViewHolder
    {

        Button imgFavoritBrand;
        Button imgFavoritBrandOff;
        Button imgLanggananBerita;
        Button imgLanggananBeritaOff;
        ImageView img_merek;
        LinearLayout itemBrandBerita;
        LinearLayout itemBrandFacebook;
        LinearLayout itemBrandProduk;
        LinearLayout itemBrandProfile;
        LinearLayout itemBrandSC;
        LinearLayout itemBrandTwitter;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListPendatangAdapter this$1;
        TextView txtBrandFB;
        TextView txtBrandTwitter;
        TextView txtFavStatBrand;
        TextView txtLanggananBrand;
        TextView txtSubStatBrand;
        TextView txt_merek;

        ListPendatangAdapter.ViewHolder()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    private class MerekTask extends AsyncTask
    {

        final MerekActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataMerek, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_283;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_290;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_290;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_290;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_290;
            }
            avoid = MerekActivity.this;
            avoid.counterArray = ((MerekActivity) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_merk(avoid.getString("id_merk"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setTwitter(avoid.getString("twitter"));
            listmodel.setFacebook(avoid.getString("facebook"));
            listmodel.setFacebook_id(avoid.getString("facebook_id"));
            listmodel.setLogo(avoid.getString("logo"));
            listmodel.setSubs_status(avoid.getString("subs_stat"));
            listmodel.setFav_status(avoid.getString("fav_stat"));
            merekHpArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_116;
            }
            Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            listPonselOS.setVisibility(0);
            layout_empty.setVisibility(8);
            try
            {
                Log.e("taskLst", "pendatang");
                Log.e("data", dataMerek);
                counterArray = 0;
                listPonselOS.setVisibility(0);
                ponselOsAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(merekHpArray.size()));
                getSherlock().setProgressBarIndeterminateVisibility(false);
                getSherlock().setProgressBarVisibility(false);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                layout_empty.setVisibility(0);
            }
            progressbar_middle.setVisibility(8);
            txt_empty.setVisibility(8);
            getSherlock().setProgressBarIndeterminateVisibility(false);
            getSherlock().setProgressBarVisibility(false);
            btnMerekRefresh.setVisibility(0);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            btnMerekRefresh.setVisibility(8);
            progressbar_middle.setVisibility(0);
            txt_empty.setVisibility(0);
            layout_empty.setVisibility(0);
        }

        private MerekTask()
        {
            this$0 = MerekActivity.this;
            super();
        }

        MerekTask(MerekTask merektask)
        {
            this();
        }
    }


    Button btnMemuatLagi;
    Button btnMerekRefresh;
    Button btn_pop_komen;
    Button btn_pop_login;
    int charCount;
    ConnectivityManager cm;
    String codename;
    int counterArray;
    String dataMerek;
    EditText edt_pop_komen;
    Bundle extras;
    String gambar;
    LinearLayout grup_header_footer;
    String hrg_baru;
    String hrg_bekas;
    String id_hph;
    JSONArray inponsel;
    JSONArray jArray;
    JSONObject json;
    LinearLayout lay_quickscroll;
    LinearLayout layout_empty;
    LinearLayout layout_footer;
    int limit;
    ListView listKomen;
    ListView listPonselOS;
    ProgressDialog mDialog;
    public ArrayList merekHpArray;
    String merk;
    String model;
    String namalengkap;
    public ListPendatangAdapter ponselOsAdapter;
    ArrayList popKomenArray;
    ProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    ProgressBar progressbar_middle;
    String querypopkomen;
    String res;
    String status;
    String suc;
    String t;
    String titlemerek;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    TextView txt_empty;
    TextView txt_footer;
    String urlKomen;
    String urlSearch;

    public MerekActivity()
    {
        merekHpArray = null;
        querypopkomen = "";
        inponsel = null;
        suc = "";
        limit = 0;
        t = Utility.session(RestClient.pelihara);
    }

    private ViewGroup createAlphabetTrack()
    {
        LinearLayout linearlayout = new LinearLayout(this);
        Object obj = new android.widget.RelativeLayout.LayoutParams((int)(30F * getResources().getDisplayMetrics().density), -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        linearlayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        linearlayout.setOrientation(1);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj.weight = 1.0F;
        linearlayout.setWeightSum(26F);
        char c = 'a';
        do
        {
            if (c > 'z')
            {
                return linearlayout;
            }
            TextView textview = new TextView(this);
            textview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            textview.setGravity(1);
            textview.setText(Character.toString(c));
            linearlayout.addView(textview);
            c++;
        } while (true);
    }

    public void MerekTask()
    {
        MerekTask merektask;
label0:
        {
            merektask = new MerekTask(null);
            if (merekHpArray.size() == 0)
            {
                if (android.os.Build.VERSION.SDK_INT < 11)
                {
                    break label0;
                }
                merektask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
            return;
        }
        merektask.execute(new Void[0]);
    }

    public void onBackPressed()
    {
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            Log.e("vis", "off");
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300b0, null, false);
        mDrawerLayout.addView(bundle, 0);
        menu_katalog.setBackgroundResource(0x7f0201cf);
        menu_katalog.setEnabled(false);
        int i;
        int k;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Katalog Produk");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        i = android.os.Build.VERSION.SDK_INT;
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = k;
        if (k == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Katalog Produk</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        listPonselOS = (ListView)findViewById(0x7f0b052e);
        listPonselOS.setOnScrollListener(new SampleScrollListener(this));
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty.setText("Memuat...");
        btnMerekRefresh = (Button)findViewById(0x7f0b05de);
        btnMerekRefresh.setVisibility(8);
        merekHpArray = new ArrayList();
        ponselOsAdapter = new ListPendatangAdapter(this, 0x7f0300ba, merekHpArray);
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        extras = getIntent().getExtras();
        lay_quickscroll = (LinearLayout)findViewById(0x7f0b05df);
        btnMemuatLagi = (Button)findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        t = Utility.session(t);
        layout_footer = (LinearLayout)findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)findViewById(0x7f0b00b7);
        txt_footer = (TextView)findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        listPonselOS.setAdapter(ponselOsAdapter);
        bundle = (QuickScroll)com/andraskindler/quickscroll/QuickScroll.cast(findViewById(0x7f0b05e0));
        bundle.init(0, listPonselOS, ponselOsAdapter, 0);
        bundle.setFixedSize(2);
        bundle.setPopupColor(QuickScroll.BLUE_LIGHT, QuickScroll.BLUE_LIGHT_SEMITRANSPARENT, 1, -1, 1.0F);
        lay_quickscroll.addView(createAlphabetTrack());
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            int j = android.os.Build.VERSION.SDK_INT;
            limit = 0;
            dataMerek = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
            MerekTask();
        } else
        {
            getSherlock().setProgressBarIndeterminateVisibility(false);
            getSherlock().setProgressBarVisibility(false);
        }
        btnMerekRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final MerekActivity this$0;

            public void onClick(View view)
            {
                MerekTask();
            }

            
            {
                this$0 = MerekActivity.this;
                super();
            }
        });
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final MerekActivity this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                int l = android.os.Build.VERSION.SDK_INT;
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    view = MerekActivity.this;
                    view.limit = ((MerekActivity) (view)).limit + 10;
                    dataMerek = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString();
                    Log.e("data", dataMerek);
                    MerekTask();
                    return;
                } else
                {
                    getSherlock().setProgressBarIndeterminateVisibility(false);
                    getSherlock().setProgressBarVisibility(false);
                    return;
                }
            }

            
            {
                this$0 = MerekActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return super.onKeyDown(i, keyevent);

        case 82: // 'R'
            break;
        }
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
        } else
        {
            mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
    }

    public void updateViewFavBrand(String s, String s1)
    {
        int i;
        Log.e("indexbrand", s);
        Log.e("favStatus", s1);
        Log.e("indexArrayListCarpon", String.valueOf(listPonselOS.getChildCount()));
        i = 0;
_L2:
        TextView textview1;
        Button button;
        Object obj;
        if (i >= listPonselOS.getChildCount())
        {
            return;
        }
        Log.e("int i", String.valueOf(i));
        obj = listPonselOS.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b00b6);
        textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0605);
        button = (Button)((View) (obj)).findViewById(0x7f0b0608);
        obj = (Button)((View) (obj)).findViewById(0x7f0b0609);
        if (textview.getText().toString().equals(s))
        {
            if (!s1.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            button.setVisibility(0);
            ((Button) (obj)).setVisibility(8);
            textview1.setText("1");
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!s1.equals("0")) goto _L4; else goto _L3
_L3:
        button.setVisibility(8);
        ((Button) (obj)).setVisibility(0);
        textview1.setText("0");
          goto _L4
    }

    public void updateViewSubsBrand(String s, String s1)
    {
        int i;
        Log.e("indexbrand", s);
        Log.e("indexArrayListCarpon", String.valueOf(listPonselOS.getChildCount()));
        i = 0;
_L2:
        TextView textview1;
        Button button;
        Object obj;
        if (i >= listPonselOS.getChildCount())
        {
            return;
        }
        Log.e("int i", String.valueOf(i));
        obj = listPonselOS.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b00b6);
        textview1 = (TextView)((View) (obj)).findViewById(0x7f0b060a);
        button = (Button)((View) (obj)).findViewById(0x7f0b0606);
        obj = (Button)((View) (obj)).findViewById(0x7f0b060c);
        if (textview.getText().toString().equals(s))
        {
            if (!s1.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            button.setVisibility(0);
            ((Button) (obj)).setVisibility(8);
            textview1.setText("1");
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!s1.equals("0")) goto _L4; else goto _L3
_L3:
        button.setVisibility(8);
        ((Button) (obj)).setVisibility(0);
        textview1.setText("0");
          goto _L4
    }

}
