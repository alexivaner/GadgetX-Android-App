// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            ProfilPTActivity

private class <init> extends AsyncTask
{

    final ProfilPTActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataProfilPT, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_329;
            }
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                Log.e("suc", suc);
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_336;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_336;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_336;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_336;
        }
        avoid = inponsel.getJSONObject(i);
        id_pt = avoid.getString("id_pt");
        nama_pt = avoid.getString("nama_pt");
        logo_pt = avoid.getString("logo_pt");
        profil_pt = avoid.getString("profil_pt");
        alamat_pt = avoid.getString("alamat_pt");
        negara_pt = avoid.getString("negara_pt");
        c_center_pt = avoid.getString("c_center_pt");
        email_pt = avoid.getString("email_pt");
        web_pt = avoid.getString("web_pt");
        fb_pt = avoid.getString("fb_pt");
        fb_id_pt = avoid.getString("fb_id_pt");
        twitter_pt = avoid.getString("twitter_pt");
        youtube_pt = avoid.getString("youtube_pt");
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_108;
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
        try
        {
            void1 = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.KER);
            void1.setScreenName((new StringBuilder("Profil PT ")).append(nama_pt).toString());
            void1.send((new com.google.android.gms.analytics.stExecute()).stExecute());
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
        }
        ProfilPTActivity.access$0(ProfilPTActivity.this).setProgressBarIndeterminateVisibility(false);
        ProfilPTActivity.access$0(ProfilPTActivity.this).setProgressBarVisibility(false);
        layout_empty.setVisibility(8);
        Log.e("logo_pt", logo_pt);
        Picasso.with(ProfilPTActivity.this).load(logo_pt.trim()).into(imgLogoPT, new Callback() {

            final ProfilPTActivity.ProfilPTTaskTask this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
                imgLogoPT.setVisibility(0);
            }

            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
        });
        fb_array = fb_pt.split(",");
        tw_array = twitter_pt.split(",");
        txt_pt_NAMA.setText(nama_pt);
        txt_pt_desc.setText(profil_pt);
        if (!alamat_pt.equals("")) goto _L2; else goto _L1
_L1:
        txt_pt_almt.setText("Tidak ada informasi");
_L13:
        if (!c_center_pt.equals("")) goto _L4; else goto _L3
_L3:
        txt_cont_center.setText("Tidak ada informasi");
_L14:
        if (!email_pt.equals("")) goto _L6; else goto _L5
_L5:
        txt_pt_email.setText("Tidak ada informasi");
_L15:
        if (!fb_pt.equals("")) goto _L8; else goto _L7
_L7:
        lay_PT_FACEBOOK.setVisibility(8);
_L16:
        if (!twitter_pt.equals("")) goto _L10; else goto _L9
_L9:
        lay_PT_TWITTER.setVisibility(8);
_L17:
        if (!web_pt.equals("")) goto _L12; else goto _L11
_L11:
        lay_PT_WEB.setVisibility(8);
_L18:
        if (!youtube_pt.equals(""))
        {
            break MISSING_BLOCK_LABEL_666;
        }
        lay_PT_YOUTUBE.setVisibility(8);
_L19:
        no_contven_center_array = c_center_pt.split("\n");
        txt_cont_center.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfilPTActivity.ProfilPTTaskTask this$1;

            public void onClick(View view)
            {
label0:
                {
                    if (!c_center_pt.equals("Tidak ada informasi"))
                    {
                        if (no_contven_center_array.length <= 1)
                        {
                            break label0;
                        }
                        view = new android.app.AlertDialog.Builder(this$0);
                        view.setTitle("Nomor Telepon :");
                        view.setSingleChoiceItems(no_contven_center_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_contven_center_array[i].replaceAll("[^0-9]", "")).toString()));
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view.show();
                    }
                    return;
                }
                view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(c_center_pt.replaceAll("[^0-9]", "")).toString()));
                startActivity(view);
            }


            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
        });
        txt_pt_fb.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfilPTActivity.ProfilPTTaskTask this$1;

            public void onClick(View view)
            {
                try
                {
                    view = getOpenFacebookIntent(this$0);
                    startActivity(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(fb_pt).toString())));
                }
            }

            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
        });
        txt_pt_twitter.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfilPTActivity.ProfilPTTaskTask this$1;

            public void onClick(View view)
            {
                if (tw_array.length > 1)
                {
                    view = new android.app.AlertDialog.Builder(this$0);
                    view.setSingleChoiceItems(tw_array, -1, new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(tw_array[i].replace("@", "")).toString())));
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(twitter_pt).toString())));
                    return;
                }
            }


            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
        });
        txt_pt_ytube.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfilPTActivity.ProfilPTTaskTask this$1;

            public void onClick(View view)
            {
                if (youtube_pt.contains("http"))
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://")).append(youtube_pt.trim()).toString())));
                    return;
                } else
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://www.youtube.com/user/")).append(youtube_pt).toString())));
                    return;
                }
            }

            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
        });
        return;
_L2:
        try
        {
            txt_pt_almt.setText(alamat_pt);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L13
_L4:
        c_center_pt = c_center_pt.replace(", ", "\n").trim();
        txt_cont_center.setText(c_center_pt);
          goto _L14
_L6:
        txt_pt_email.setText(email_pt);
          goto _L15
_L8:
        txt_pt_fb.setText(fb_pt);
          goto _L16
_L10:
        txt_pt_twitter.setText(twitter_pt);
          goto _L17
_L12:
        txt_pt_web.setText(web_pt);
          goto _L18
        txt_pt_ytube.setText(youtube_pt);
          goto _L19
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        layout_empty.setVisibility(0);
    }


    private _cls5.this._cls1()
    {
        this$0 = ProfilPTActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
