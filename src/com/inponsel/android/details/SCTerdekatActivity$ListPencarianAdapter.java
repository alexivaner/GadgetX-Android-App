// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

public class t extends BaseAdapter
{
    class ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final SCTerdekatActivity.ListPencarianAdapter this$1;

        ViewHolder()
        {
            this$1 = SCTerdekatActivity.ListPencarianAdapter.this;
            super();
        }
    }


    private Activity activity;
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
    String komen;
    private ArrayList lm;
    ListModel lms;
    ProgressDialog mDialog;
    int pos;
    String res;
    int resource;
    String response;
    String statusPenc;
    String t;
    final SCTerdekatActivity this$0;
    String user;
    UserFunctions userFunctions;
    String username;

    public void formatToRupiah()
    {
        fmts.setGroupingSeparator('.');
        fmt.setGroupingSize(3);
        fmt.setGroupingUsed(true);
        fmt.setDecimalFormatSymbols(fmts);
        hargaBaru = Integer.parseInt(hrg_baru);
        hargaBekas = Integer.parseInt(hrg_bekas);
        hrg_baru = fmt.format(hargaBaru);
        hrg_bekas = fmt.format(hargaBekas);
    }

    public void formatToRupiahBaru()
    {
        fmts.setGroupingSeparator('.');
        fmt.setGroupingSize(3);
        fmt.setGroupingUsed(true);
        fmt.setDecimalFormatSymbols(fmts);
        hargaBaru = Integer.parseInt(hrg_baru);
        hrg_baru = fmt.format(hargaBaru);
    }

    public void formatToRupiahBekas()
    {
        hargaBekas = Integer.parseInt(hrg_bekas);
        hrg_bekas = fmt.format(hargaBekas);
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

    public View getView(int i, View view, final ViewGroup holder)
    {
        pos = i;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            holder.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
            holder.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
            holder.list_text_like = (TextView)view.findViewById(0x7f0b0344);
            holder.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
            holder.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
            holder.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
            holder.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
            holder.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
            holder.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(i);
        if (lm != null)
        {
            hrg_baru = lms.getHrg_baru();
            hrg_bekas = lms.getHrg_bekas();
            ((ViewHolder) (holder)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
            ((ViewHolder) (holder)).list_lay_like.setVisibility(8);
            ((ViewHolder) (holder)).list_lay_dislike.setVisibility(8);
            ((ViewHolder) (holder)).list_lay_kom.setVisibility(8);
            if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
            {
                ((ViewHolder) (holder)).list_txtHarga.setVisibility(8);
            } else
            {
                formatToRupiahBaru();
                ((ViewHolder) (holder)).list_txtHarga.setVisibility(0);
                ((ViewHolder) (holder)).list_txtHarga.setText((new StringBuilder("Baru\t: Rp. ")).append(hrg_baru).toString());
            }
            try
            {
                Picasso.with(activity).load(lms.getGambar().trim()).into(((ViewHolder) (holder)).imageHp, new Callback() {

                    final SCTerdekatActivity.ListPencarianAdapter this$1;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

            
            {
                this$1 = SCTerdekatActivity.ListPencarianAdapter.this;
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
        lm = arraylist;
    }

    public _cls1.val.holder(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = SCTerdekatActivity.this;
        super();
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
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
        catch (SCTerdekatActivity scterdekatactivity)
        {
            return;
        }
    }
}
