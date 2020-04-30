// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImageFullActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ListChatMessageAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView imgLocOther;
        ImageView imgMyImage;
        ImageView imgMyLoc;
        ImageView imgOtherImage;
        LinearLayout llJoinLeaveChat;
        RelativeLayout llMyImgMessage;
        LinearLayout llMyLocMessage;
        LinearLayout llMyMessage;
        RelativeLayout llToImgMessage;
        RelativeLayout llToLocMessage;
        LinearLayout llToMessage;
        ProgressBar progbar_myimage;
        ProgressBar progbar_otherimage;
        ProgressBar progressbar_item;
        TextView txtJoinLeaveChat;
        TextView txtMyImgMessageTime;
        TextView txtMyLocMessage;
        TextView txtMyLocMessageTime;
        TextView txtMyLocUsername;
        TextView txtMyMessage;
        TextView txtMyMessageTime;
        TextView txtOtherLocMessage;
        TextView txtOtherLocUsername;
        TextView txtOtherMessage;
        TextView txtToImgMessageTime;
        TextView txtToLocMessageTime;
        TextView txtToMessageTime;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    ConnectivityManager cm;
    Context context;
    private ArrayList lm;
    NetworkInfo netInfo;
    int resource;
    String response;

    public ListChatMessageAdapter(Activity activity1, int i, ArrayList arraylist)
    {
        lm = arraylist;
        activity = activity1;
        resource = i;
        cm = (ConnectivityManager)activity1.getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
label0:
        {
            final ListModel lms;
label1:
            {
                viewgroup = view;
                if (viewgroup == null)
                {
                    viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                    view = new ViewHolder();
                    view.imgMyImage = (ImageView)viewgroup.findViewById(0x7f0b061b);
                    view.imgOtherImage = (ImageView)viewgroup.findViewById(0x7f0b0622);
                    view.txtOtherMessage = (TextView)viewgroup.findViewById(0x7f0b0613);
                    view.txtMyMessage = (TextView)viewgroup.findViewById(0x7f0b0617);
                    view.txtToMessageTime = (TextView)viewgroup.findViewById(0x7f0b0614);
                    view.txtMyMessageTime = (TextView)viewgroup.findViewById(0x7f0b0618);
                    view.txtJoinLeaveChat = (TextView)viewgroup.findViewById(0x7f0b060e);
                    view.llToMessage = (LinearLayout)viewgroup.findViewById(0x7f0b060f);
                    view.llMyMessage = (LinearLayout)viewgroup.findViewById(0x7f0b0615);
                    view.llJoinLeaveChat = (LinearLayout)viewgroup.findViewById(0x7f0b060d);
                    view.llToImgMessage = (RelativeLayout)viewgroup.findViewById(0x7f0b061e);
                    view.llMyImgMessage = (RelativeLayout)viewgroup.findViewById(0x7f0b0619);
                    view.txtToImgMessageTime = (TextView)viewgroup.findViewById(0x7f0b0624);
                    view.txtMyImgMessageTime = (TextView)viewgroup.findViewById(0x7f0b061d);
                    view.progbar_myimage = (ProgressBar)viewgroup.findViewById(0x7f0b061a);
                    view.progbar_otherimage = (ProgressBar)viewgroup.findViewById(0x7f0b0621);
                    view.imgLocOther = (ImageView)viewgroup.findViewById(0x7f0b062b);
                    view.imgMyLoc = (ImageView)viewgroup.findViewById(0x7f0b062d);
                    view.llMyLocMessage = (LinearLayout)viewgroup.findViewById(0x7f0b062c);
                    view.llToLocMessage = (RelativeLayout)viewgroup.findViewById(0x7f0b0625);
                    view.txtOtherLocUsername = (TextView)viewgroup.findViewById(0x7f0b0628);
                    view.txtOtherLocMessage = (TextView)viewgroup.findViewById(0x7f0b0629);
                    view.txtToLocMessageTime = (TextView)viewgroup.findViewById(0x7f0b062a);
                    view.txtMyLocUsername = (TextView)viewgroup.findViewById(0x7f0b062e);
                    view.txtMyLocMessage = (TextView)viewgroup.findViewById(0x7f0b062f);
                    view.txtMyLocMessageTime = (TextView)viewgroup.findViewById(0x7f0b0630);
                    viewgroup.setTag(view);
                } else
                {
                    view = (ViewHolder)viewgroup.getTag();
                }
                lms = (ListModel)lm.get(i);
                if (lm != null)
                {
                    if (!lms.getMe_message().equals("yes"))
                    {
                        break label0;
                    }
                    Drawable drawable = activity.getResources().getDrawable(0x7f020279);
                    drawable.setColorFilter(Color.parseColor("#FFFF7043"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                    if (android.os.Build.VERSION.SDK_INT < 16)
                    {
                        ((ViewHolder) (view)).llMyMessage.setBackgroundDrawable(drawable);
                        ((ViewHolder) (view)).llMyImgMessage.setBackgroundDrawable(drawable);
                        ((ViewHolder) (view)).llMyLocMessage.setBackgroundDrawable(drawable);
                    } else
                    {
                        ((ViewHolder) (view)).llMyMessage.setBackground(drawable);
                        ((ViewHolder) (view)).llMyImgMessage.setBackground(drawable);
                        ((ViewHolder) (view)).llMyLocMessage.setBackground(drawable);
                    }
                    if (!lms.getMessage_type().equals("0"))
                    {
                        break label1;
                    }
                    ((ViewHolder) (view)).llMyMessage.setVisibility(0);
                    ((ViewHolder) (view)).llToMessage.setVisibility(8);
                    ((ViewHolder) (view)).llMyImgMessage.setVisibility(8);
                    ((ViewHolder) (view)).llToImgMessage.setVisibility(8);
                    ((ViewHolder) (view)).llToLocMessage.setVisibility(8);
                    ((ViewHolder) (view)).llMyLocMessage.setVisibility(8);
                    ((ViewHolder) (view)).txtMyMessage.setText(lms.getLast_message());
                    ((ViewHolder) (view)).txtMyMessageTime.setText(Utility.convertDate(lms.getMsg_date()));
                    ((ViewHolder) (view)).txtMyMessage.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                        final ListChatMessageAdapter this$0;
                        private final ListModel val$lms;

                        public boolean onLongClick(View view1)
                        {
                            view1 = new android.app.AlertDialog.Builder(activity);
                            view1.setMessage("Copy pesan ke clipboard?");
                            view1.setPositiveButton("Ya", lms. new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$1;
                                private final ListModel val$lms;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    ((ClipboardManager)activity.getSystemService("clipboard")).setText(lms.getLast_message());
                                    Toast.makeText(activity, "Pesan berhasil dicopy", 1).show();
                                }

            
            {
                this$1 = final__pcls1;
                lms = ListModel.this;
                super();
            }
                            });
                            view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$1;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                            view1.show();
                            return false;
                        }


            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
                    });
                }
                return viewgroup;
            }
            if (lms.getMessage_type().equals("99"))
            {
                ((ViewHolder) (view)).txtJoinLeaveChat.setText(Html.fromHtml(lms.getLast_message()));
                ((ViewHolder) (view)).llJoinLeaveChat.setVisibility(0);
                ((ViewHolder) (view)).llMyMessage.setVisibility(8);
                ((ViewHolder) (view)).llToMessage.setVisibility(8);
                return viewgroup;
            }
            if (lms.getMessage_type().equals("2"))
            {
                ((ViewHolder) (view)).llMyMessage.setVisibility(8);
                ((ViewHolder) (view)).llToMessage.setVisibility(8);
                ((ViewHolder) (view)).llMyImgMessage.setVisibility(8);
                ((ViewHolder) (view)).llToImgMessage.setVisibility(8);
                ((ViewHolder) (view)).llToLocMessage.setVisibility(8);
                ((ViewHolder) (view)).llMyLocMessage.setVisibility(0);
                ((ViewHolder) (view)).txtMyLocMessage.setText(lms.getLast_message());
                ((ViewHolder) (view)).txtMyLocMessageTime.setText(Utility.convertDate(lms.getMsg_date()));
                try
                {
                    Picasso.with(activity).load(lms.getExt().trim().trim()).placeholder(0x7f02033f).error(0x7f0201ec).into(((ViewHolder) (view)).imgMyLoc);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                ((ViewHolder) (view)).imgMyLoc.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListChatMessageAdapter this$0;
                    private final ListModel val$lms;

                    public void onClick(View view1)
                    {
                        view1 = (new StringBuilder("geo:")).append(lms.getKordinat()).append("?q=").append(lms.getKordinat()).toString();
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view1)));
                    }

            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
                });
                ((ViewHolder) (view)).txtMyLocMessage.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                    final ListChatMessageAdapter this$0;
                    private final ListModel val$lms;

                    public boolean onLongClick(View view1)
                    {
                        view1 = new android.app.AlertDialog.Builder(activity);
                        view1.setMessage("Copy pesan ke clipboard?");
                        view1.setPositiveButton("Ya", lms. new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;
                            private final ListModel val$lms;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                ((ClipboardManager)activity.getSystemService("clipboard")).setText(lms.getLast_message());
                                Toast.makeText(activity, "Pesan berhasil dicopy", 1).show();
                            }

            
            {
                this$1 = final__pcls3;
                lms = ListModel.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view1.show();
                        return false;
                    }


            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
                });
                return viewgroup;
            }
            ((ViewHolder) (view)).llMyMessage.setVisibility(8);
            ((ViewHolder) (view)).llToMessage.setVisibility(8);
            ((ViewHolder) (view)).llMyImgMessage.setVisibility(0);
            ((ViewHolder) (view)).llToImgMessage.setVisibility(8);
            ((ViewHolder) (view)).txtMyImgMessageTime.setTextColor(-1);
            ((ViewHolder) (view)).llToLocMessage.setVisibility(8);
            ((ViewHolder) (view)).llMyLocMessage.setVisibility(8);
            ((ViewHolder) (view)).txtMyImgMessageTime.setBackgroundResource(0x106000d);
            ((ViewHolder) (view)).txtMyImgMessageTime.setText(Utility.convertDate(lms.getMsg_date()));
            Object obj;
            if (netInfo != null && netInfo.isConnected())
            {
                obj = (new StringBuilder(String.valueOf(lms.getUrl_thumb()))).append(lms.getLast_message()).toString();
            } else
            {
                obj = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB))).append(lms.getLast_message()).toString();
            }
            Log.e("img_thumb", ((String) (obj)));
            ((ViewHolder) (view)).imgMyImage.getLayoutParams().width = Integer.parseInt(lms.getImg_width());
            ((ViewHolder) (view)).imgMyImage.getLayoutParams().height = Integer.parseInt(lms.getImg_height());
            Exception exception1;
            try
            {
                Picasso.with(activity).load(((String) (obj)).trim()).placeholder(0x7f02033f).error(0x7f0201ec).into(((ViewHolder) (view)).imgMyImage);
            }
            catch (Exception exception2) { }
            ((ViewHolder) (view)).imgMyImage.setOnClickListener(new android.view.View.OnClickListener() {

                final ListChatMessageAdapter this$0;
                private final ListModel val$lms;

                public void onClick(View view1)
                {
                    view1 = new ArrayList();
                    view1.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(lms.getLast_message().toString().trim()).toString());
                    view1 = (String[])view1.toArray(new String[view1.size()]);
                    Intent intent = new Intent(activity, com/inponsel/android/v2/ImageFullActivity);
                    intent.putExtra("imgUrl", view1);
                    intent.putExtra("pos", 0);
                    activity.startActivity(intent);
                }

            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
            });
            return viewgroup;
        }
        obj = activity.getResources().getDrawable(0x7f020278);
        ((Drawable) (obj)).setColorFilter(Color.parseColor("#FFBF360C"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            ((ViewHolder) (view)).llToMessage.setBackgroundDrawable(((Drawable) (obj)));
            ((ViewHolder) (view)).llToImgMessage.setBackgroundDrawable(((Drawable) (obj)));
            ((ViewHolder) (view)).llToLocMessage.setBackgroundDrawable(((Drawable) (obj)));
        } else
        {
            ((ViewHolder) (view)).llToMessage.setBackground(((Drawable) (obj)));
            ((ViewHolder) (view)).llToImgMessage.setBackground(((Drawable) (obj)));
            ((ViewHolder) (view)).llToLocMessage.setBackground(((Drawable) (obj)));
        }
        if (lms.getMessage_type().equals("0"))
        {
            ((ViewHolder) (view)).llMyMessage.setVisibility(8);
            ((ViewHolder) (view)).llToMessage.setVisibility(0);
            ((ViewHolder) (view)).llMyImgMessage.setVisibility(8);
            ((ViewHolder) (view)).llToImgMessage.setVisibility(8);
            ((ViewHolder) (view)).llToLocMessage.setVisibility(8);
            ((ViewHolder) (view)).llMyLocMessage.setVisibility(8);
            ((ViewHolder) (view)).txtOtherMessage.setText(lms.getLast_message());
            ((ViewHolder) (view)).txtToMessageTime.setText(Utility.convertDate(lms.getMsg_date()));
            ((ViewHolder) (view)).txtOtherMessage.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final ListChatMessageAdapter this$0;
                private final ListModel val$lms;

                public boolean onLongClick(View view1)
                {
                    view1 = new android.app.AlertDialog.Builder(activity);
                    view1.setMessage("Copy pesan ke clipboard?");
                    view1.setPositiveButton("Ya", lms. new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;
                        private final ListModel val$lms;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            ((ClipboardManager)activity.getSystemService("clipboard")).setText(lms.getLast_message());
                            Toast.makeText(activity, "Pesan berhasil dicopy", 1).show();
                        }

            
            {
                this$1 = final__pcls5;
                lms = ListModel.this;
                super();
            }
                    });
                    view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view1.show();
                    return false;
                }


            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
            });
            return viewgroup;
        }
        if (lms.getMessage_type().equals("99"))
        {
            ((ViewHolder) (view)).txtJoinLeaveChat.setText(Html.fromHtml(lms.getLast_message()));
            ((ViewHolder) (view)).llJoinLeaveChat.setVisibility(0);
            ((ViewHolder) (view)).llMyMessage.setVisibility(8);
            ((ViewHolder) (view)).llToMessage.setVisibility(8);
            return viewgroup;
        }
        if (lms.getMessage_type().equals("2"))
        {
            ((ViewHolder) (view)).llMyMessage.setVisibility(8);
            ((ViewHolder) (view)).llToMessage.setVisibility(8);
            ((ViewHolder) (view)).llMyImgMessage.setVisibility(8);
            ((ViewHolder) (view)).llToImgMessage.setVisibility(8);
            ((ViewHolder) (view)).llToLocMessage.setVisibility(0);
            ((ViewHolder) (view)).llMyLocMessage.setVisibility(8);
            ((ViewHolder) (view)).txtOtherLocMessage.setText(lms.getLast_message());
            ((ViewHolder) (view)).txtToLocMessageTime.setText(Utility.convertDate(lms.getMsg_date()));
            ((ViewHolder) (view)).txtOtherLocUsername.setText(lms.getFrom_name());
            try
            {
                Picasso.with(activity).load(lms.getExt().trim().trim()).placeholder(0x7f02033f).error(0x7f0201ec).into(((ViewHolder) (view)).imgLocOther);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception1) { }
            ((ViewHolder) (view)).imgLocOther.setOnClickListener(new android.view.View.OnClickListener() {

                final ListChatMessageAdapter this$0;
                private final ListModel val$lms;

                public void onClick(View view1)
                {
                    view1 = (new StringBuilder("geo:")).append(lms.getKordinat()).append("?q=").append(lms.getKordinat()).toString();
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view1)));
                }

            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
            });
            ((ViewHolder) (view)).txtOtherLocMessage.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final ListChatMessageAdapter this$0;
                private final ListModel val$lms;

                public boolean onLongClick(View view1)
                {
                    view1 = new android.app.AlertDialog.Builder(activity);
                    view1.setMessage("Copy pesan ke clipboard?");
                    view1.setPositiveButton("Ya", lms. new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;
                        private final ListModel val$lms;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            ((ClipboardManager)activity.getSystemService("clipboard")).setText(lms.getLast_message());
                            Toast.makeText(activity, "Pesan berhasil dicopy", 1).show();
                        }

            
            {
                this$1 = final__pcls7;
                lms = ListModel.this;
                super();
            }
                    });
                    view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    view1.show();
                    return false;
                }


            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
            });
            return viewgroup;
        }
        ((ViewHolder) (view)).llMyMessage.setVisibility(8);
        ((ViewHolder) (view)).llToMessage.setVisibility(8);
        ((ViewHolder) (view)).llMyImgMessage.setVisibility(8);
        ((ViewHolder) (view)).llToImgMessage.setVisibility(0);
        ((ViewHolder) (view)).txtToImgMessageTime.setTextColor(-1);
        ((ViewHolder) (view)).llToLocMessage.setVisibility(8);
        ((ViewHolder) (view)).llMyLocMessage.setVisibility(8);
        ((ViewHolder) (view)).txtToImgMessageTime.setBackgroundResource(0x106000d);
        ((ViewHolder) (view)).txtToImgMessageTime.setText(Utility.convertDate(lms.getMsg_date()));
        if (netInfo != null && netInfo.isConnected())
        {
            obj = (new StringBuilder(String.valueOf(lms.getUrl_thumb()))).append(lms.getLast_message()).toString();
        } else
        {
            obj = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB))).append(lms.getLast_message()).toString();
        }
        Log.e("img_thumb", ((String) (obj)));
        ((ViewHolder) (view)).imgOtherImage.getLayoutParams().width = Integer.parseInt(lms.getImg_width());
        ((ViewHolder) (view)).imgOtherImage.getLayoutParams().height = Integer.parseInt(lms.getImg_height());
        try
        {
            Picasso.with(activity).load(((String) (obj)).trim()).placeholder(0x7f02033f).error(0x7f0201ec).into(((ViewHolder) (view)).imgOtherImage);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        ((ViewHolder) (view)).imgOtherImage.setOnClickListener(new android.view.View.OnClickListener() {

            final ListChatMessageAdapter this$0;
            private final ListModel val$lms;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(lms.getLast_message().toString().trim()).toString());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(activity, com/inponsel/android/v2/ImageFullActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                activity.startActivity(intent);
            }

            
            {
                this$0 = ListChatMessageAdapter.this;
                lms = listmodel;
                super();
            }
        });
        return viewgroup;
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

}
