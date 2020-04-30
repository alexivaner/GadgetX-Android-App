// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.BitmapFactory;
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
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomMyDraftPost

public class t extends BaseAdapter
{
    class ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final RoomMyDraftPost.ListartikelAdapter this$1;

        ViewHolder()
        {
            this$1 = RoomMyDraftPost.ListartikelAdapter.this;
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
    String komen;
    private ArrayList lm;
    ListModel lms;
    ProgressDialog mDialog;
    int pos;
    String res;
    int resource;
    String response;
    String status;
    String t;
    final RoomMyDraftPost this$0;
    String user;
    UserFunctions userFunctions;
    String username;

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

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        pos = position;
        view = (LayoutInflater)activity.getSystemService("layout_inflater");
        if (viewgroup == null)
        {
            viewgroup = view.inflate(resource, null);
            view = new ViewHolder();
            view.imageHp = (ImageView)viewgroup.findViewById(0x7f0b023d);
            view.list_txtMerek = (TextView)viewgroup.findViewById(0x7f0b033c);
            view.list_txtHarga = (TextView)viewgroup.findViewById(0x7f0b033d);
            view.progressbar_item = (ProgressBar)viewgroup.findViewById(0x7f0b00b3);
            view.rateRate = (RatingBar)viewgroup.findViewById(0x7f0b00c9);
            view.imgIklan = (ImageView)viewgroup.findViewById(0x7f0b0484);
            view.headIklan = (LinearLayout)viewgroup.findViewById(0x7f0b0482);
            view.progressbar_item_iklan = (ProgressBar)viewgroup.findViewById(0x7f0b0483);
            view.headHp = (LinearLayout)viewgroup.findViewById(0x7f0b0481);
            view.separator = (LinearLayout)viewgroup.findViewById(0x7f0b0340);
            view.bottom_list = (LinearLayout)viewgroup.findViewById(0x7f0b0341);
            view.headImage = (LinearLayout)viewgroup.findViewById(0x7f0b029f);
            view.list_txtBigRight = (TextView)viewgroup.findViewById(0x7f0b034d);
            view.leftdel = (RelativeLayout)viewgroup.findViewById(0x7f0b0480);
            viewgroup.setTag(view);
        } else
        {
            view = (ViewHolder)viewgroup.getTag();
        }
        lms = (ListModel)lm.get(position);
        if (lm != null)
        {
            ((ViewHolder) (view)).bottom_list.setVisibility(8);
            ((ViewHolder) (view)).separator.setVisibility(8);
            ((ViewHolder) (view)).list_txtBigRight.setVisibility(8);
            ((ViewHolder) (view)).progressbar_item.setVisibility(8);
            ((ViewHolder) (view)).imageHp.setVisibility(0);
            String as[] = lms.getCodename().split("-");
            ((ViewHolder) (view)).list_txtMerek.setText((new StringBuilder(String.valueOf(as[0]))).append(" - ").append(lms.getRoom_title()).toString());
            ((ViewHolder) (view)).list_txtHarga.setText(lms.getRoom_content());
            Object obj = new File(lms.getRoom_path_image());
            if (((File) (obj)).exists())
            {
                obj = BitmapFactory.decodeFile(((File) (obj)).getAbsolutePath());
                ((ViewHolder) (view)).imageHp.setImageBitmap(((android.graphics.Bitmap) (obj)));
            } else
            {
                ((ViewHolder) (view)).imageHp.setImageResource(0x7f020073);
            }
            ((ViewHolder) (view)).leftdel.setOnClickListener(new android.view.View.OnClickListener() {

                final RoomMyDraftPost.ListartikelAdapter this$1;
                private final int val$position;

                public void onClick(View view1)
                {
                    id_del = getListModel(position).getId_content();
                    Log.e("id_hp_del", id_del);
                    view1 = new android.app.AlertDialog.Builder(this$0);
                    view1.setTitle("Peringatan");
                    view1.setMessage("Hapus artikel ini?");
                    view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            statdel = "0";
                            db.delete_byARTID(lms.getRoom_date(), lms.getRoom_title());
                            onResume();
                        }

            
            {
                this$2 = _cls1.this;
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
                }


            
            {
                this$1 = RoomMyDraftPost.ListartikelAdapter.this;
                position = i;
                super();
            }
            });
        }
        return viewgroup;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }


    public _cls1.val.position(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = RoomMyDraftPost.this;
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
            t = Utility.session(t);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomMyDraftPost roommydraftpost)
        {
            return;
        }
    }
}
