// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class HargaAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        CheckBox checkBox;
        TextView homeMerek;
        TextView homeTipe;
        ImageView imageHp;
        ProgressBar progressbar_item;
        RatingBar rateRate;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    int hargaBaru;
    int hargaBekas;
    String hrg_baru;
    String hrg_bekas;
    private ArrayList lm;
    int resource;
    String response;

    public HargaAdapter(Activity activity1, int i, ArrayList arraylist)
    {
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
        lm = arraylist;
        activity = activity1;
        resource = i;
    }

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
        ListModel listmodel;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            holder.homeMerek = (TextView)view.findViewById(0x7f0b0464);
            ((ViewHolder) (holder)).homeMerek.setTextSize(12F);
            holder.homeTipe = (TextView)view.findViewById(0x7f0b00c8);
            ((ViewHolder) (holder)).homeTipe.setTextSize(11F);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            ((ViewHolder) (holder)).homeTipe.setVisibility(0);
            holder.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (holder)).homeMerek.setTextSize(15F);
        ((ViewHolder) (holder)).homeTipe.setTextSize(13F);
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            hrg_baru = listmodel.getHrg_baru();
            hrg_bekas = listmodel.getHrg_bekas();
            ((ViewHolder) (holder)).homeTipe.setTextColor(Color.parseColor("#727272"));
            ((ViewHolder) (holder)).homeMerek.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
            if (hrg_bekas.equals("0") && hrg_baru.equals("0") || hrg_bekas.equals("null") && hrg_baru.equals("null"))
            {
                ((ViewHolder) (holder)).homeTipe.setText("Baru\t: -");
            } else
            if (hrg_bekas.equals("0") || hrg_bekas.equals("null"))
            {
                formatToRupiahBaru();
                ((ViewHolder) (holder)).homeTipe.setText((new StringBuilder("Baru\t: Rp. ")).append(hrg_baru).toString());
            } else
            if (hrg_baru.equals("0") || hrg_baru.equals("null"))
            {
                formatToRupiahBekas();
                ((ViewHolder) (holder)).homeTipe.setText("Baru\t: -");
            } else
            {
                formatToRupiah();
                ((ViewHolder) (holder)).homeTipe.setText((new StringBuilder("Baru\t: Rp. ")).append(hrg_baru).toString());
            }
            try
            {
                Picasso.with(activity).load(listmodel.getGambar().trim()).into(((ViewHolder) (holder)).imageHp, new Callback() {

                    final HargaAdapter this$0;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                        holder.progressbar_item.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

            
            {
                this$0 = HargaAdapter.this;
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
}
