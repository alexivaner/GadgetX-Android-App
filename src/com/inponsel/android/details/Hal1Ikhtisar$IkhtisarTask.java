// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar, RivalTerdekatActivity

private class <init> extends AsyncTask
{

    Response response;
    final Hal1Ikhtisar this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataIktisar);
        Object obj;
        int i;
        try
        {
            obj = (new DefaultHttpClient()).execute(avoid);
            i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        }
        catch (IOException ioexception)
        {
            avoid.abort();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return null;
        }
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataIktisar).toString());
        return null;
        obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
        response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
        Log.e("success", (new JSONObject(response.toString())).getString("0"));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        scrollIkhtisar.setVisibility(0);
        void1 = response.InPonsel.iterator();
_L25:
        if (void1.hasNext()) goto _L2; else goto _L1
_L1:
        txtBigRoom.setText((new StringBuilder("Forum ")).append(namalengkap).toString());
        namalengkapbgskrg = namalengkap;
        txtBigBerita.setText((new StringBuilder("Berita ")).append(namalengkap).toString());
        txtBigHpLain.setText((new StringBuilder("Ponsel ")).append(merk).append(" lainnya").toString());
        if (!statSubNews.equals("1")) goto _L4; else goto _L3
_L3:
        if (sdk >= 16) goto _L6; else goto _L5
_L5:
        detail_favoritenews.setBackgroundDrawable(drwKurang);
_L27:
        if (!statusKomen.equals("1")) goto _L8; else goto _L7
_L7:
        chkNotifKomenHp.setChecked(true);
_L28:
        Log.e("total_likepersen", (new StringBuilder(String.valueOf(total_votes))).append("=").append(likepersen).toString());
        if (!total_votes.equals("") && !total_votes.equals("0") || !likepersen.equals("0")) goto _L10; else goto _L9
_L9:
        lay_ringkasan.setVisibility(8);
        txtNotPengunjung.setVisibility(0);
_L29:
        if (!total_votes.equals("0")) goto _L12; else goto _L11
_L11:
        lay_ReviewFitur.setVisibility(8);
        txtValueReviewFitur.setText(Html.fromHtml("<b>Belum ada review pengunjung</b>"));
        Log.e("nilai_overall", (new StringBuilder(String.valueOf(String.valueOf(Math.round(Float.parseFloat(nilai_overall)))))).append(" : ").append(String.valueOf(10 - Math.round(Float.parseFloat(nilai_overall)))).toString());
        ratingReviewFitur.setProgress(0);
_L30:
        if (!likepersen.equals("")) goto _L14; else goto _L13
_L13:
        lay_Ketertarikan.setVisibility(8);
_L31:
        if (!twitter.equals("")) goto _L16; else goto _L15
_L15:
        layout_Twitter.setEnabled(false);
        txtBigTwitter.setTextColor(Color.parseColor("#cacaca"));
_L32:
        if (!my_like_pon.equals("1")) goto _L18; else goto _L17
_L17:
        detail_like.setBackgroundResource(0x7f020259);
        detail_dislike.setBackgroundResource(0x7f0201a6);
        detail_lay_like.setEnabled(false);
        detail_lay_dislike.setEnabled(true);
_L33:
        Log.e("likedis", (new StringBuilder(String.valueOf(tnggp_bgs))).append(":").append(tnggp_krg).toString());
        if (!tnggp_bgs.toString().equals("0") || !tnggp_krg.toString().equals("0")) goto _L20; else goto _L19
_L19:
        ratingLikeDis.setProgress(50);
        Log.e("likedis", "50");
_L34:
        if (!userFunction.isUserLoggedIn(getActivity())) goto _L22; else goto _L21
_L21:
        sclabel = (new StringBuilder("Service center ")).append(merk).append(" di ").append(user_kota).toString();
_L35:
        Picasso.with(getActivity()).load(gambar.trim()).into(imgHpDetail, new Callback() {

            final Hal1Ikhtisar.IkhtisarTask this$1;

            public void onError()
            {
                det_prog_item.setVisibility(8);
            }

            public void onSuccess()
            {
                det_prog_item.setVisibility(8);
                imgHpDetail.setVisibility(0);
            }

            
            {
                this$1 = Hal1Ikhtisar.IkhtisarTask.this;
                super();
            }
        });
_L36:
        Log.e("total_hitsikh", total_hits);
        detail_text_like.setText(tnggp_bgs);
        detail_text_dislike.setText(tnggp_krg);
        detail_text_komentar.setText(jml_komentar);
        if (ikhtisarArray.size() != 0) goto _L24; else goto _L23
_L23:
        txt_empty.setText("Gagal terhubung ke server");
        progressbar_middle.setVisibility(8);
_L26:
        (new Handler()).postDelayed(new Runnable() {

            final Hal1Ikhtisar.IkhtisarTask this$1;

            public void run()
            {
                (new Hal1Ikhtisar.PostHits(this$0)).execute(new Void[0]);
            }

            
            {
                this$1 = Hal1Ikhtisar.IkhtisarTask.this;
                super();
            }
        }, 5000L);
        return;
_L2:
        ListModel listmodel = (ListModel)void1.next();
        id_hp = listmodel.getId_hp();
        gambar = listmodel.getGambar();
        model = listmodel.getModel();
        codename = listmodel.getCodename();
        merk = listmodel.getMerk();
        id_merk = listmodel.getId_merk();
        namalengkap = listmodel.getNamalengkap();
        jml_komentar = listmodel.getJml_komentar();
        tnggp_bgs = listmodel.getTnggp_bgs().toString();
        tnggp_krg = listmodel.getTnggp_krg().toString();
        likepersen = listmodel.getLikepersen().toString();
        nilai_overall = listmodel.getNilai_overall();
        total_votes = listmodel.getTotal_votes();
        total_hits = listmodel.getTotal_hits().toString();
        str_urlspekshare = listmodel.getUrl_share().toString();
        lay_size_diagonal = listmodel.getLay_size_diagonal();
        umu_status = listmodel.getUmu_status();
        hrg_baru = listmodel.getHrg_baru();
        hrg_bekas = listmodel.getHrg_bekas();
        har_infotmbh = listmodel.getInfo_tambahan();
        sta_garansi = listmodel.getSta_garansi();
        update_harga = listmodel.getUpdate_harga();
        my_like_pon = listmodel.getMy_like_pon();
        twitter = listmodel.getTwitter();
        statusKomen = listmodel.getStatuskomen();
        statSubNews = listmodel.getSubs_status();
        ikhtisarArray.add(listmodel);
          goto _L25
        void1;
        void1.printStackTrace();
        layout_empty.setVisibility(0);
        progressbar_middle.setVisibility(8);
        txt_empty.setVisibility(8);
        btnRefresh.setVisibility(0);
          goto _L26
_L6:
        detail_favoritenews.setBackground(drwKurang);
          goto _L27
_L4:
label0:
        {
            if (sdk >= 16)
            {
                break label0;
            }
            detail_favoritenews.setBackgroundDrawable(drw);
        }
          goto _L27
        detail_favoritenews.setBackground(drw);
          goto _L27
_L8:
        chkNotifKomenHp.setChecked(false);
          goto _L28
_L10:
        lay_ringkasan.setVisibility(0);
        txtNotPengunjung.setVisibility(8);
          goto _L29
_L12:
        txtValueReviewFitur.setText(Html.fromHtml((new StringBuilder("<b>Review pengunjung</b> ")).append(nilai_overall).append(" (").append(total_votes).append(" suara)").toString()));
        Log.e("nilai_overall", (new StringBuilder(String.valueOf(String.valueOf(Math.round(Float.parseFloat(nilai_overall)))))).append(" : ").append(String.valueOf(10 - Math.round(Float.parseFloat(nilai_overall)))).toString());
        ratingReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
          goto _L30
_L14:
        txtKetertarikan.setText(Html.fromHtml((new StringBuilder("<b>Ketertarikan   </b>")).append(likepersen).append("% (").append(tnggp_bgs).append(" likes, ").append(tnggp_krg).append(" dislikes)").toString()));
        txtValueKetertarikan.setText(Html.fromHtml((new StringBuilder("<b>Ketertarikan</b> ")).append(likepersen).append("% (").append(tnggp_bgs).append(" likes, ").append(tnggp_krg).append(" dislikes)").toString()));
          goto _L31
_L16:
        txtBigTwitter.setText((new StringBuilder("Twitter ")).append(twitter).toString());
          goto _L32
_L18:
label1:
        {
            if (!my_like_pon.equals("0"))
            {
                break label1;
            }
            detail_like.setBackgroundResource(0x7f02025a);
            detail_dislike.setBackgroundResource(0x7f0201a5);
            detail_lay_like.setEnabled(true);
            detail_lay_dislike.setEnabled(false);
        }
          goto _L33
        detail_like.setBackgroundResource(0x7f02025a);
        detail_dislike.setBackgroundResource(0x7f0201a6);
        detail_lay_like.setEnabled(true);
        detail_lay_dislike.setEnabled(true);
          goto _L33
_L20:
        float f = Integer.parseInt(tnggp_bgs);
        f /= f + (float)Integer.parseInt(tnggp_krg);
        Log.e("likedis", String.valueOf(f));
        ratintLikeDis = Math.round(100F * f);
        ratingLikeDis.setProgress(ratintLikeDis);
          goto _L34
_L22:
        sclabel = (new StringBuilder("Service center ")).append(merk).append(" di Kota anda").toString();
          goto _L35
        void1;
        void1.printStackTrace();
          goto _L36
_L24:
        layout_empty.setVisibility(8);
        try
        {
            void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(update_harga);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMMM yyyy", Locale.US);
            newDateStr = simpledateformat.format(void1);
            newDateStr = newDateStr.replace("January", "Januari");
            newDateStr = newDateStr.replace("February", "Februari");
            newDateStr = newDateStr.replace("March", "Maret");
            newDateStr = newDateStr.replace("April", "April");
            newDateStr = newDateStr.replace("May", "Mei");
            newDateStr = newDateStr.replace("June", "Juni");
            newDateStr = newDateStr.replace("July", "Juli");
            newDateStr = newDateStr.replace("August", "Agustus");
            newDateStr = newDateStr.replace("September", "September");
            newDateStr = newDateStr.replace("October", "Oktober");
            newDateStr = newDateStr.replace("November", "November");
            newDateStr = newDateStr.replace("December", "Desember");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1) { }
        if (!umu_status.equals("Dihentikan") || !hrg_bekas.equals("") && hrg_bekas != null) goto _L38; else goto _L37
_L37:
        spek_head_Garansi.setVisibility(8);
_L39:
        detail_txtMerek.setText(namalengkap);
        edtHargaBaru.setText((new StringBuilder()).append(hrg_baru).toString());
        edtHargaBekas.setText((new StringBuilder()).append(hrg_bekas).toString());
        merk = URLEncoder.encode(merk, "utf-8");
_L40:
        dataLain = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_lain").append(Utility.BASE_FORMAT).append("?merk=").append(merk).append("&idmodel=").append(id_hp).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("dataLain", dataLain);
        InAdsTask();
        userFunction.isUserLoggedIn(getActivity());
        if (!hrg_baru.equals("0") && !hrg_baru.equals("-") && !hrg_baru.equals(""))
        {
            break MISSING_BLOCK_LABEL_3177;
        }
        layout_RivalTerdekat.setEnabled(false);
        txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
          goto _L26
_L38:
label2:
        {
            if (!update_harga.equals("") && !update_harga.equals("null") && !update_harga.equals("-") && !update_harga.equals("0000-00-00"))
            {
                break label2;
            }
            edtHargaGaransi.setText("");
            edtHargaGaransi.setVisibility(8);
        }
          goto _L39
label3:
        {
            if (!sta_garansi.equals("NA") && !sta_garansi.equals("null") && !sta_garansi.equals("-") || update_harga.equals("null") && update_harga.equals("") && update_harga.equals("-"))
            {
                break label3;
            }
            edtHargaGaransi.setText((new StringBuilder("Diperbarui ")).append(newDateStr).toString());
        }
          goto _L39
label4:
        {
            if (sta_garansi.equals("0") && sta_garansi.equals("null") && sta_garansi.equals("-") || !har_infotmbh.equals(""))
            {
                break label4;
            }
            edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append("; Diperbarui ").append(newDateStr).toString());
        }
          goto _L39
label5:
        {
            if (sta_garansi.equals("0") && sta_garansi.equals("null") && sta_garansi.equals("-") || har_infotmbh.equals(""))
            {
                break label5;
            }
            edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append(" (").append(har_infotmbh).append("); Diperbarui ").append(newDateStr).toString());
        }
          goto _L39
        edtHargaGaransi.setText("");
        edtHargaGaransi.setVisibility(8);
          goto _L39
        void1;
        void1.printStackTrace();
          goto _L40
        disAtas = Float.parseFloat(lay_size_diagonal);
        void1 = Hal1Ikhtisar.this;
        void1.disAtas = ((Hal1Ikhtisar) (void1)).disAtas + 0.20000000000000001D;
        disBawah = Float.parseFloat(lay_size_diagonal);
        void1 = Hal1Ikhtisar.this;
        void1.disBawah = ((Hal1Ikhtisar) (void1)).disBawah - 0.20000000000000001D;
        model = URLEncoder.encode(model, "utf-8");
_L41:
        dataRival = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_rival").append(Utility.BASE_FORMAT).append("?hmin=").append(hargaBawah).append("&hmax=").append(hargaAtas).append("&lmin=").append(disBawah).append("&lmax=").append(disAtas).append("&idhp=").append(id_hp).append("&limit=").append("0").append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("urlRival", dataRival);
        if (!umu_status.equals("3") && !umu_status.equals("Dihentikan") && !edtHargaBaru.getText().toString().equals(""))
        {
            break MISSING_BLOCK_LABEL_3569;
        }
        layout_RivalTerdekat.setVisibility(0);
        layout_RivalTerdekat.setEnabled(false);
        txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
        Log.e("RivalTask", "0");
_L42:
        layout_RivalTerdekat.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Ikhtisar.IkhtisarTask this$1;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/RivalTerdekatActivity);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("hrg_baru", hrg_baru);
                view.putExtra("hrg_bekas", hrg_bekas);
                view.putExtra("jsonRival", jsonRival);
                view.putExtra("id_hp", id_hp);
                getActivity().startActivity(view);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = Hal1Ikhtisar.IkhtisarTask.this;
                super();
            }
        });
          goto _L26
        void1;
        void1.printStackTrace();
          goto _L41
        Log.e("RivalTask", "1");
        (new it>(Hal1Ikhtisar.this)).cute(new Void[0]);
          goto _L42
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        layout_empty.setVisibility(0);
        scrollIkhtisar.setVisibility(8);
    }


    private _cls3.this._cls1()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
