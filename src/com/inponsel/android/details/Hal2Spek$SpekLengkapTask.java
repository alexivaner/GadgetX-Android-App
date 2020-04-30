// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.CircleProgressBar;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

public class this._cls0 extends AsyncTask
{

    Response response;
    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataSpek);
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
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataSpek).toString());
        return null;
        obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
        response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        void1 = response.InPonsel.iterator();
_L20:
        if (void1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!twitter.equals("")) goto _L4; else goto _L3
_L3:
        layout_Twitter.setEnabled(false);
        txtBigTwitter.setTextColor(Color.parseColor("#cacaca"));
_L21:
        if (!my_like_pon.equals("1")) goto _L6; else goto _L5
_L5:
        detail_like.setBackgroundResource(0x7f02025b);
        detail_dislike.setBackgroundResource(0x7f0201a3);
        detail_lay_like.setEnabled(false);
        detail_lay_dislike.setEnabled(true);
_L22:
        if (!tnggp_bgs.toString().equals("0") || !tnggp_krg.toString().equals("0")) goto _L8; else goto _L7
_L7:
        ratingLikeDis.setProgress(50);
        circle_LikeDis.setProgress(50F);
        Log.e("likedis", "50");
_L23:
        totalVotes.isSelected();
        Log.e("total_votes", total_votes);
        if (!statSubNews.equals("1")) goto _L10; else goto _L9
_L9:
        if (sdk >= 16) goto _L12; else goto _L11
_L11:
        detail_favoritenews.setBackgroundDrawable(drwKurang);
_L24:
        if (!total_votes.equals("0")) goto _L14; else goto _L13
_L13:
        txtValueReviewFitur.setText(Html.fromHtml("<b>Belum ada review pengunjung</b>"));
        ratingReviewFitur.setProgress(0);
        circle_ReviewFitur.setProgress(0.0F);
_L25:
        rata2Desain = nilai_desain;
        rata2Layar = nilai_layar;
        rata2Kinerja = nilai_kinerja;
        rata2Kamera = nilai_kamera;
        rata2Baterai = nilai_baterai;
        rataDesain.setText(oneDForm.format(Double.parseDouble(nilai_desain)));
        rataLayar.setText(oneDForm.format(Double.parseDouble(nilai_layar)));
        rataKinerja.setText(oneDForm.format(Double.parseDouble(nilai_kinerja)));
        rataKamera.setText(oneDForm.format(Double.parseDouble(nilai_kamera)));
        rataBaterai.setText(oneDForm.format(Double.parseDouble(nilai_baterai)));
        ratdobDesain = Double.parseDouble(rata2Desain) * 10D;
        ratintDesain = (int)ratdobDesain;
        ratdobLayar = Double.parseDouble(rata2Layar) * 10D;
        ratintLayar = (int)ratdobLayar;
        ratdobKinerja = Double.parseDouble(rata2Kinerja) * 10D;
        ratintKinerja = (int)ratdobKinerja;
        ratdobApps = Double.parseDouble(rata2Apps) * 10D;
        ratintApps = (int)ratdobApps;
        ratdobKamera = Double.parseDouble(rata2Kamera) * 10D;
        ratintKamera = (int)ratdobKamera;
        ratdobAudio = Double.parseDouble(rata2Audio) * 10D;
        ratintAudio = (int)ratdobAudio;
        ratdobBaterai = Double.parseDouble(rata2Baterai) * 10D;
        ratintBaterai = (int)ratdobBaterai;
        ratdobHarga = Double.parseDouble(rata2Harga) * 10D;
        ratintHarga = (int)ratdobHarga;
        ratingDesain.setAnimation(animationin);
        if (ratintDesain < 67)
        {
            if (ratintDesain >= 34);
        }
        ratingDesain.setProgress(ratintDesain);
        ratingLayar.setAnimation(animationin);
        if (ratintLayar < 67)
        {
            if (ratintLayar >= 34);
        }
        ratingLayar.setProgress(ratintLayar);
        ratingKinerja.setAnimation(animationin);
        if (ratintKinerja < 67)
        {
            if (ratintKinerja >= 34);
        }
        ratingKinerja.setProgress(ratintKinerja);
        ratingKamera.setAnimation(animationin);
        if (ratintKamera < 67)
        {
            if (ratintKamera >= 34);
        }
        ratingKamera.setProgress(ratintKamera);
        ratingBaterai.setAnimation(animationin);
        if (ratintBaterai < 67)
        {
            if (ratintBaterai >= 34);
        }
        ratingBaterai.setProgress(ratintBaterai);
        totalVotes.isSelected();
        if (!total_votes.equals("0")) goto _L16; else goto _L15
_L15:
        totalVotes.setText("Total: 0 suara");
_L26:
        detail_txtMerek.setText(namalengkap);
        imageLoader2.displayImage(gambar.trim(), imgHpDetail, Hal2Spek.access$0(Hal2Spek.this), new ImageLoadingListener() {

            final Hal2Spek.SpekLengkapTask this$1;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                det_prog_item.setVisibility(8);
                imgHpDetail.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                det_prog_item.setVisibility(8);
                imgHpDetail.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                det_prog_item.setVisibility(0);
                imgHpDetail.setVisibility(8);
            }

            
            {
                this$1 = Hal2Spek.SpekLengkapTask.this;
                super();
            }
        });
        Log.e("total_hitspek", total_hits);
        detail_text_like.setText(tnggp_bgs);
        detail_text_dislike.setText(tnggp_krg);
        Hal2Spek.detail_text_komentar.setText(jml_komentar);
        btnKomentarHp.setText((new StringBuilder("Komentar (")).append(jml_komentar).append(")").toString());
        txtBigKomentarHp.setText((new StringBuilder("Komentar (")).append(jml_komentar).append(")").toString());
        if (jar_2g_status.equals("1"))
        {
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append("2G").toString();
        }
        if (jar_3g_status.equals("1"))
        {
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(". 3G").toString();
        }
        if (jar_4g_status.equals("1"))
        {
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(". 4G").toString();
        }
        if (!lay_size_diagonal.equals("") && !lay_size_diagonal.equals("-") && !lay_size_ppi.equals("-") && !lay_size_ppi.equals("")) goto _L18; else goto _L17
_L17:
        edtLayarUkuran.setText("");
_L27:
        if (id_hp.equals("-"))
        {
            txt_empty.setText("Gagal terhubung ke server");
            midProgressBar.setVisibility(8);
            return;
        }
          goto _L19
_L2:
        try
        {
            ListModel listmodel = (ListModel)void1.next();
            id_hp = listmodel.getId_hp();
            gambar = listmodel.getGambar();
            model = listmodel.getModel();
            id_merk = listmodel.getId_merk();
            twitter = listmodel.getTwitter();
            merk = listmodel.getMerk();
            codename = listmodel.getCodename();
            namalengkap = listmodel.getNamalengkap();
            jml_komentar = listmodel.getJml_komentar();
            tot_komen = listmodel.getJml_komentar();
            tnggp_bgs = listmodel.getTnggp_bgs().toString();
            tnggp_krg = listmodel.getTnggp_krg().toString();
            str_urlspekshare = listmodel.getUrl_share().toString();
            my_like_pon = listmodel.getMy_like_pon();
            total_hits = listmodel.getTotal_hits();
            ketamb = listmodel.getKetamb();
            jar_2g_status = listmodel.getJar_2g_status();
            jar_2g_gsm_status = listmodel.getJar_2g_gsm_status();
            jar_2g_gsm = listmodel.getJar_2g_gsm();
            jar_2g_cdma_status = listmodel.getJar_2g_cdma_status();
            jar_2g_cdma = listmodel.getJar_2g_cdma();
            jar_3g_status = listmodel.getJar_3g_status();
            jar_3g = listmodel.getJar_3g();
            jar_4g_status = listmodel.getJar_4g_status();
            jar_4g = listmodel.getJar_4g();
            jar_gprs_status = listmodel.getJar_gprs_status();
            jar_gprs = listmodel.getJar_gprs();
            jar_edge_status = listmodel.getJar_edge_status();
            jar_edge = listmodel.getJar_edge();
            jar_multi_status = listmodel.getJar_multi_status();
            jar_multi_ket = listmodel.getJar_multi_ket();
            jar_multi_tipe1 = listmodel.getJar_multi_tipe1();
            jar_multi_tipe2 = listmodel.getJar_multi_tipe2();
            jar_dualon = listmodel.getJar_dualon();
            jar_sc = listmodel.getJar_sc();
            jar_sc_ket = listmodel.getJar_sc_ket();
            jar_bwidth = listmodel.getJar_bwidth();
            umu_dim_panjang = listmodel.getUmu_dim_panjang();
            umu_dim_lebar = listmodel.getUmu_dim_lebar();
            umu_dim_tebal = listmodel.getUmu_dim_tebal();
            umu_dim_ket = listmodel.getUmu_dim_ket();
            umu_bobot = listmodel.getUmu_bobot();
            umu_bobot_ket = listmodel.getUmu_bobot_ket();
            umu_diumumkan_sta = listmodel.getUmu_diumumkan_sta();
            umu_diumumkan = listmodel.getUmu_diumumkan();
            umu_status = listmodel.getUmu_status();
            umu_status_ket = listmodel.getUmu_status_ket();
            umu_model = listmodel.getUmu_model();
            umu_warna_ponsel = listmodel.getUmu_warna_ponsel();
            lay_size_diagonal = listmodel.getLay_size_diagonal();
            lay_size_vertikal = listmodel.getLay_size_vertikal();
            lay_size_horizontal = listmodel.getLay_size_horizontal();
            lay_size_diagonal_ket = listmodel.getLay_size_diagonal_ket();
            lay_size_ppi = listmodel.getLay_size_ppi();
            lay_tipe_layar = listmodel.getLay_tipe_layar();
            lay_size_status = listmodel.getLay_size_status();
            lay_touchscreen = listmodel.getLay_touchscreen();
            lay_touchscreen_status = listmodel.getLay_touchscreen_status();
            lay_warna_layar = listmodel.getLay_warna_layar();
            lay_warna_ket = listmodel.getLay_warna_ket();
            lay_sensor = listmodel.getLay_sensor();
            lay_sensor_status = listmodel.getLay_sensor_status();
            lay_proteksi = listmodel.getLay_proteksi();
            lay_proteksi_status = listmodel.getLay_proteksi_status();
            lay_multitouch = listmodel.getLay_multitouch();
            lay_multitouch_status = listmodel.getLay_multitouch_status();
            lay_ext = listmodel.getLay_ext();
            lay_tambahan = listmodel.getLay_tambahan();
            mem_all_ket = listmodel.getMem_all_ket();
            hard_all_ket = listmodel.getHard_all_ket();
            har_info = listmodel.getHar_info();
            har_chipset = listmodel.getHar_chipset();
            har_cpu_core = listmodel.getHar_cpu_core();
            har_cpu_clock = listmodel.getHar_cpu_clock();
            har_cpu_jenpros = listmodel.getHar_cpu_jenpros();
            har_gpu = listmodel.getHar_gpu();
            sof_os = listmodel.getSof_os();
            sof_os_versi = listmodel.getSof_os_versi();
            sof_java = listmodel.getSof_java();
            sof_java_status = listmodel.getSof_java_status();
            kam_utama = listmodel.getKam_utama();
            kam_utama_ket = listmodel.getKam_utama_ket();
            kam_utama2 = listmodel.getKam_utama2();
            kam_utama_status = listmodel.getKam_utama_status();
            kam_led_flash_status = listmodel.getKam_led_flash_status();
            kam_led_flash = listmodel.getKam_led_flash();
            kam_fitur = listmodel.getKam_fitur();
            kam_video = listmodel.getKam_video();
            kam_video_status = listmodel.getKam_video_status();
            kam_video_hd = listmodel.getKam_video_hd();
            kam_depan = listmodel.getKam_depan();
            kam_depan_status = listmodel.getKam_depan_status();
            kam_nat_vcall = listmodel.getKam_nat_vcall();
            mem_internal = listmodel.getMem_internal();
            mem_eksternal = listmodel.getMem_eksternal();
            mem_eksternal_kap = listmodel.getMem_eksternal_kap();
            mem_eksternal_s = listmodel.getMem_eksternal_s();
            mem_ram = listmodel.getMem_ram();
            mem_rom = listmodel.getMem_rom();
            mem_internal_ket = listmodel.getMem_internal_ket();
            mem_ram_ket = listmodel.getMem_ram_ket();
            mem_rom_ket = listmodel.getMem_rom_ket();
            mem_ekternal_ket = listmodel.getMem_ekternal_ket();
            internal = listmodel.getMem_all();
            mem_phonebook = listmodel.getMem_phonebook();
            kon_wlan = listmodel.getKon_wlan();
            kon_wlan_status = listmodel.getKon_wlan_status();
            kon_bluetooth = listmodel.getKon_bluetooth();
            kon_bluetooth_status = listmodel.getKon_bluetooth_status();
            kon_usb = listmodel.getKon_usb();
            kon_usb_status = listmodel.getKon_usb_status();
            kon_35mm_jack = listmodel.getKon_35mm_jack();
            kon_35mm_jack_ket = listmodel.getKon_35mm_jack_ket();
            kon_infrared = listmodel.getKon_infrared();
            kon_infrared_ket = listmodel.getKon_infrared_ket();
            kon_hdmi_status = listmodel.getKon_hdmi_status();
            kon_hdmi = listmodel.getKon_hdmi();
            kon_tvoutput_status = listmodel.getKon_tvoutput_status();
            kon_tvoutput = listmodel.getKon_tvoutput();
            kon_nfc = listmodel.getKon_nfc();
            kon_nfc_status = listmodel.getKon_nfc_status();
            fit_musik_status = listmodel.getFit_musik_status();
            fit_musik = listmodel.getFit_musik();
            fit_radio_status = listmodel.getFit_radio_status();
            fit_radio = listmodel.getFit_radio();
            fit_gps_status = listmodel.getFit_gps_status();
            fit_gps = listmodel.getFit_gps();
            fit_tvanalog = listmodel.getFit_tvanalog();
            fit_tvanalog_ket = listmodel.getFit_tvanalog_ket();
            fit_browser_status = listmodel.getFit_browser_status();
            fit_browser = listmodel.getFit_browser();
            fit_pesan = listmodel.getFit_pesan();
            fit_lain = listmodel.getFit_lain();
            bat_kapasitas = listmodel.getBat_kapasitas();
            bat_kapasitas_s = listmodel.getBat_kapasitas_s();
            bat_model = listmodel.getBat_model();
            bat_bicara = listmodel.getBat_bicara();
            bat_siaga = listmodel.getBat_siaga();
            bat_musik = listmodel.getBat_musik();
            hrg_baru = listmodel.getHrg_baru();
            hrg_bekas = listmodel.getHrg_bekas();
            har_infotmbh = listmodel.getInfo_tambahan();
            sta_garansi = listmodel.getSta_garansi();
            update_harga = listmodel.getUpdate_harga();
            nilai_desain = listmodel.getNilai_desain();
            nilai_layar = listmodel.getNilai_layar();
            nilai_kinerja = listmodel.getNilai_kinerja();
            nilai_kamera = listmodel.getNilai_kamera();
            nilai_baterai = listmodel.getNilai_baterai();
            nilai_overall = listmodel.getNilai_overall();
            total_votes = listmodel.getTotal_votes();
            total_hits = listmodel.getTotal_hits();
            statSubNews = listmodel.getSubs_status();
            likepersen = listmodel.getLikepersen().toString();
            spekArray.add(listmodel);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            layout_empty.setVisibility(0);
            midProgressBar.setVisibility(8);
            txt_empty.setVisibility(8);
            btnRefresh.setVisibility(0);
            return;
        }
          goto _L20
_L4:
        txtBigTwitter.setText((new StringBuilder("Twitter ")).append(twitter).toString());
          goto _L21
_L6:
label0:
        {
            if (!my_like_pon.equals("0"))
            {
                break label0;
            }
            detail_like.setBackgroundResource(0x7f020257);
            detail_dislike.setBackgroundResource(0x7f0201a7);
            detail_lay_like.setEnabled(true);
            detail_lay_dislike.setEnabled(false);
        }
          goto _L22
        detail_like.setBackgroundResource(0x7f020257);
        detail_dislike.setBackgroundResource(0x7f0201a3);
        detail_lay_like.setEnabled(true);
        detail_lay_dislike.setEnabled(true);
          goto _L22
_L8:
        float f = Integer.parseInt(tnggp_bgs);
        f /= f + (float)Integer.parseInt(tnggp_krg);
        Log.e("likedis", String.valueOf(f));
        ratintLikeDis = Math.round(100F * f);
        ratingLikeDis.setProgress(ratintLikeDis);
        circle_LikeDis.setProgress(ratintLikeDis);
          goto _L23
_L12:
        detail_favoritenews.setBackground(drwKurang);
          goto _L24
_L10:
label1:
        {
            if (sdk >= 16)
            {
                break label1;
            }
            detail_favoritenews.setBackgroundDrawable(drw);
        }
          goto _L24
        detail_favoritenews.setBackground(drw);
          goto _L24
_L14:
        txtValueReviewFitur.setText(Html.fromHtml((new StringBuilder("<b>Review pengunjung</b> ")).append(nilai_overall).append(" (").append(total_votes).append(" suara)").toString()));
        Log.e("nilai_overall", (new StringBuilder(String.valueOf(nilai_overall))).append(" : ").append(String.valueOf(10F - Float.parseFloat(nilai_overall))).toString());
        txtPercentReviewFitur.setText(nilai_overall);
        ratingReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
        circle_ReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
          goto _L25
_L16:
        totalVotes.setText((new StringBuilder("Total : ")).append(nilai_overall).append(", dari ").append(total_votes).append(" suara").toString());
          goto _L26
_L18:
label2:
        {
            int i = Math.round(Float.parseFloat(lay_size_ppi));
            lay_size_ppi = String.valueOf(i);
            if (!lay_size_diagonal_ket.equals(""))
            {
                break label2;
            }
            edtLayarUkuran.setText((new StringBuilder(String.valueOf(lay_size_diagonal))).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_size_diagonal).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").toString();
        }
          goto _L27
        edtLayarUkuran.setText((new StringBuilder(String.valueOf(lay_size_diagonal))).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").append(" (").append(lay_size_diagonal_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_size_diagonal).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").append(" (").append(lay_size_diagonal_ket).append(")").toString();
          goto _L27
_L19:
        layout_empty.setVisibility(8);
        linIkhtisar.setVisibility(0);
        btnShowComment.setText((new StringBuilder("Baca komentar (")).append(jml_komentar).append(")").toString());
        if (ketamb.equals("") || ketamb.equals("-"))
        {
            spek_head_ketamb.setVisibility(8);
        }
        ketamb = ketamb.replace("\n", "\n\u2022 ");
        edtKeteranganTambahan.setText((new StringBuilder("\u2022 ")).append(ketamb).toString());
        if (!jar_2g_gsm_status.equals("1") || !jar_2g_cdma_status.equals("1")) goto _L29; else goto _L28
_L28:
        edtJar2g.setText((new StringBuilder("GSM ")).append(jar_2g_gsm).append("\nCDMA ").append(jar_2g_cdma).toString());
_L136:
        if (!jar_3g_status.equals("2") && !jar_3g_status.equals("3")) goto _L31; else goto _L30
_L30:
        edtJar3g.setText("Tidak");
_L137:
        if (jar_4g_status.equals("2") || jar_4g_status.equals("3"))
        {
            spek_head_4g.setVisibility(8);
        }
        edtJar4g.setText((new StringBuilder(String.valueOf(jar_4g))).toString());
        if (!jar_gprs_status.equals("2")) goto _L33; else goto _L32
_L32:
        edtJarGPRS.setText("Tidak");
_L138:
        if (!jar_edge_status.equals("2")) goto _L35; else goto _L34
_L34:
        edtJarEdge.setText("Tidak");
_L139:
        if (jar_bwidth.equals(""))
        {
            spek_head_Bandwidth.setVisibility(8);
        }
        edtJarBandwidth.setText(jar_bwidth);
        if (jar_sc.equals(""))
        {
            spek_head_SIM.setVisibility(8);
        }
        if (!jar_sc_ket.equals("")) goto _L37; else goto _L36
_L36:
        edtJarSimCard.setText(jar_sc);
_L140:
        if (!jar_multi_status.equals("2")) goto _L39; else goto _L38
_L38:
        spek_head_MultiSIM.setVisibility(8);
_L141:
        umu_model = umu_model.replace("1", "Bar");
        umu_model = umu_model.replace("2", "Flip");
        umu_model = umu_model.replace("3", "Swivel");
        umu_model = umu_model.replace("4", "Slide");
        umu_model = umu_model.replace("5", "QWERTY");
        umu_model = umu_model.replace("6", "Full Touchscreen");
        umu_model = umu_model.replace("7", "Touchscreen & Keyboard");
        umu_model = umu_model.replace("8", "Tablet PC");
        if (!umu_dim_panjang.equals("") && !umu_dim_lebar.equals("") && !umu_dim_tebal.equals("") && !umu_dim_panjang.equals("-") && !umu_dim_lebar.equals("-") && !umu_dim_tebal.equals("-")) goto _L41; else goto _L40
_L40:
        edtUmumDim.setText("");
_L142:
        if (!umu_bobot.equals("") && !umu_bobot.equals("-")) goto _L43; else goto _L42
_L42:
        edtUmumBobot.setText("");
        spek_head_Bobot.setVisibility(8);
_L143:
        if (umu_warna_ponsel.equals(""))
        {
            spek_head_Warna.setVisibility(8);
        }
        edtUmumWarna.setText(umu_warna_ponsel);
        if (!umu_status.equals("5") && !umu_status.toLowerCase().equals("rumor")) goto _L45; else goto _L44
_L44:
        edtUmumDiUm.setText("");
_L144:
        edtUmumStatus.setText(umu_status);
        if (!lay_tipe_layar.equals("")) goto _L47; else goto _L46
_L46:
        if (!lay_warna_ket.equals("")) goto _L49; else goto _L48
_L48:
        edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_touchscreen))).append(lay_warna_layar).toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_touchscreen).append(lay_warna_layar).toString();
_L145:
        if (!lay_multitouch_status.equals("1") || lay_multitouch.equals("")) goto _L51; else goto _L50
_L50:
        edtLayarMultitouch.setText((new StringBuilder("Ya, ")).append(lay_multitouch).toString());
_L146:
        if (mem_all_ket.equals("")) goto _L53; else goto _L52
_L52:
        spek_head_MemoriAllKet.setVisibility(0);
        mem_all_ket = mem_all_ket.replace("\n", "\n\u2022 ");
        edtMemoriAllKet.setText((new StringBuilder("\u2022 ")).append(mem_all_ket).toString());
_L150:
        if (hard_all_ket.equals("")) goto _L55; else goto _L54
_L54:
        spek_head_hard_ket.setVisibility(0);
        hard_all_ket = hard_all_ket.replace("\n", "\n\u2022 ");
        edtHardAllKet.setText((new StringBuilder("\u2022 ")).append(hard_all_ket).toString());
_L151:
        if (lay_ext.equals("")) goto _L57; else goto _L56
_L56:
        spek_head_Lay_EXT.setVisibility(0);
        lay_ext = lay_ext.replace("\n", "\n\u2022 ");
        edtLayarEXT.setText((new StringBuilder("\u2022 ")).append(lay_ext).toString());
_L152:
        if (lay_tambahan.equals("")) goto _L59; else goto _L58
_L58:
        spek_head_Lay_Tambahan.setVisibility(0);
        lay_tambahan = lay_tambahan.replace("\n", "\n\u2022 ");
        edtLayarTambahan.setText((new StringBuilder("\u2022 ")).append(lay_tambahan).toString());
_L153:
        if (!lay_sensor.equals("")) goto _L61; else goto _L60
_L60:
        spek_head_Sensor.setVisibility(8);
_L154:
        if (!lay_proteksi_status.equals("1")) goto _L63; else goto _L62
_L62:
        edtLayarProteksi.setText((new StringBuilder("Ya, ")).append(lay_proteksi).toString());
_L155:
        if (har_info.equals("2"))
        {
            parentHardware.setVisibility(8);
        }
        if (!har_chipset.equals("")) goto _L65; else goto _L64
_L64:
        spek_head_Chipset.setVisibility(8);
_L156:
        if (!har_gpu.equals("")) goto _L67; else goto _L66
_L66:
        spek_head_GPU.setVisibility(8);
_L157:
        edtSoftOS.setText((new StringBuilder(String.valueOf(sof_os))).append(sof_os_versi).toString());
        if (!sof_java_status.equals("1") || sof_java.equals("")) goto _L69; else goto _L68
_L68:
        edtSoftJava.setText((new StringBuilder("Ya, ")).append(sof_java).toString());
_L158:
        if (kam_utama_status.equals("2")) goto _L71; else goto _L70
_L70:
        if (!kam_utama.equals("0.3")) goto _L73; else goto _L72
_L72:
        if (!kam_utama_ket.equals("")) goto _L75; else goto _L74
_L74:
        edtKameraUtama.setText("VGA");
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", VGA").toString();
_L159:
        if (!har_cpu_clock.equals("") || !har_cpu_jenpros.equals("")) goto _L77; else goto _L76
_L76:
        edtHardCPU.setText("");
_L160:
        if (!kam_led_flash_status.equals("1")) goto _L79; else goto _L78
_L78:
        if (kam_led_flash.equals("")) goto _L81; else goto _L80
_L80:
        edtKameraLamKil.setText((new StringBuilder("Ya, ")).append(kam_led_flash).toString());
_L161:
        if (!kam_fitur.equals("")) goto _L83; else goto _L82
_L82:
        spek_head_FitKam.setVisibility(8);
_L162:
        if (!kam_video_status.equals("1") || kam_video.equals("") || kam_video_hd.equals("") && kam_video_hd.equals("N/A")) goto _L85; else goto _L84
_L84:
        edtKameraVidRec.setText((new StringBuilder("Ya, ")).append(kam_video).toString());
_L163:
        if (!kam_depan_status.equals("2")) goto _L87; else goto _L86
_L86:
        edtKameraDepan.setText("Tidak");
_L167:
        if (!kam_nat_vcall.equals("1")) goto _L89; else goto _L88
_L88:
        edtNatVidCall.setText("Ya");
_L168:
        edtMemoriInternal.setText(internal);
        Log.e("mem_eksternal_s", mem_eksternal_s);
        if (!mem_eksternal_s.equals("2")) goto _L91; else goto _L90
_L90:
        edtMemoriExternal.setText("Tidak");
_L171:
        spek_head_MemPhoneBook.setVisibility(8);
        if (!kon_bluetooth_status.equals("1") || !kon_bluetooth.equals("")) goto _L93; else goto _L92
_L92:
        edtKonekBlue.setText("Ya");
_L176:
        if (!kon_usb_status.equals("1") || !kon_usb.equals("")) goto _L95; else goto _L94
_L94:
        edtKonekUSB.setText("Ya");
_L177:
        if (!kon_35mm_jack.equals("1")) goto _L97; else goto _L96
_L96:
        if (!kon_35mm_jack_ket.equals("")) goto _L99; else goto _L98
_L98:
        edtKonek35Jack.setText("Ya");
_L178:
        if (!kon_wlan_status.equals("1") || !kon_wlan.equals("")) goto _L101; else goto _L100
_L100:
        edtKonekWLAN.setText("Ya");
_L179:
        if (!kon_nfc_status.equals("3")) goto _L103; else goto _L102
_L102:
        spek_head_NFC.setVisibility(8);
_L180:
        if (!kon_hdmi_status.equals("3")) goto _L105; else goto _L104
_L104:
        spek_head_HDMI.setVisibility(8);
_L184:
        if (!kon_tvoutput_status.equals("3")) goto _L107; else goto _L106
_L106:
        spek_head_TV.setVisibility(8);
_L188:
        if (!kon_infrared.equals("1")) goto _L109; else goto _L108
_L108:
        if (!kon_infrared_ket.equals("")) goto _L111; else goto _L110
_L110:
        edtKonekInfrared.setText("Ya");
_L192:
        if (!fit_musik_status.equals("1") || fit_musik.equals("")) goto _L113; else goto _L112
_L112:
        edtLain2Musik.setText((new StringBuilder("Ya, ")).append(fit_musik).toString());
_L193:
        if (!fit_radio_status.equals("1") || fit_radio.equals("")) goto _L115; else goto _L114
_L114:
        edtLain2Radio.setText((new StringBuilder("Ya, ")).append(fit_radio).toString());
_L194:
        if (!fit_tvanalog.equals("1") || fit_tvanalog_ket.equals("")) goto _L117; else goto _L116
_L116:
        edtLain2Analog.setText((new StringBuilder("Ya (")).append(fit_tvanalog_ket).append(")").toString());
_L195:
        if (!fit_gps_status.equals("1") || fit_gps.equals("")) goto _L119; else goto _L118
_L118:
        edtLain2GPS.setText((new StringBuilder("GPS Built-in, ")).append(fit_gps).toString());
_L196:
        if (!fit_browser_status.equals("1") || fit_browser.equals("")) goto _L121; else goto _L120
_L120:
        edtLain2Browser.setText((new StringBuilder()).append(fit_browser).toString());
_L197:
        if (fit_pesan.equals("")) goto _L123; else goto _L122
_L122:
        edtLain2Pesan.setText((new StringBuilder()).append(fit_pesan).toString());
_L198:
        if (!fit_lain.equals("")) goto _L125; else goto _L124
_L124:
        edtLain2Fiturlain.setText("");
_L199:
        if (bat_kapasitas.equals("")) goto _L127; else goto _L126
_L126:
        edtBatJenis.setText((new StringBuilder(String.valueOf(bat_kapasitas_s))).append(" ").append(bat_kapasitas).append(" mAh").toString());
_L200:
        if (!bat_bicara.equals("")) goto _L129; else goto _L128
_L128:
        edtBatBicara.setText("Tidak ada informasi");
_L201:
        if (!bat_siaga.equals("")) goto _L131; else goto _L130
_L130:
        edtBatSiaga.setText("Tidak ada informasi");
_L202:
        if (!bat_musik.equals("")) goto _L133; else goto _L132
_L132:
        spek_head_BateraiIsiBox.setVisibility(8);
_L203:
        try
        {
            void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(update_harga);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMMM yyyy", Locale.US);
            tgglHarga = simpledateformat.format(void1);
            tgglHarga = tgglHarga.replace("January", "Januari");
            tgglHarga = tgglHarga.replace("February", "Februari");
            tgglHarga = tgglHarga.replace("March", "Maret");
            tgglHarga = tgglHarga.replace("April", "April");
            tgglHarga = tgglHarga.replace("May", "Mei");
            tgglHarga = tgglHarga.replace("June", "Juni");
            tgglHarga = tgglHarga.replace("July", "Juli");
            tgglHarga = tgglHarga.replace("August", "Agustus");
            tgglHarga = tgglHarga.replace("September", "September");
            tgglHarga = tgglHarga.replace("October", "Oktober");
            tgglHarga = tgglHarga.replace("November", "November");
            tgglHarga = tgglHarga.replace("December", "Desember");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1) { }
        if (!umu_status.equals("Dihentikan") || !hrg_bekas.equals("") && hrg_bekas != null) goto _L135; else goto _L134
_L134:
        spek_head_Garansi.setVisibility(8);
_L204:
        if (!likepersen.equals(""))
        {
            break MISSING_BLOCK_LABEL_14994;
        }
        lay_Ketertarikan.setVisibility(8);
_L205:
        txtBigHpLain.setText((new StringBuilder("Ponsel ")).append(merk).append(" lainnya").toString());
        ll_tinjauan_pengunjung.setVisibility(0);
        ll_menu_bottom_spek.setVisibility(0);
        ll_report_hp.setVisibility(8);
        edtHargaBaru.setText((new StringBuilder()).append(hrg_baru).toString());
        edtHargaBekas.setText((new StringBuilder()).append(hrg_bekas).toString());
        dataRival = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_rival").append(Utility.BASE_FORMAT).append("?hmin=").append(hargaBawah).append("&hmax=").append(hargaAtas).append("&lmin=").append(disBawah).append("&lmax=").append(disAtas).append("&idhp=").append(id_hp).append("&limit=").append("0").append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("urlRival", dataRival);
        if (umu_status.equals("3") || umu_status.equals("Dihentikan") || edtHargaBaru.getText().toString().equals(""))
        {
            layout_RivalTerdekat.setVisibility(0);
            layout_RivalTerdekat.setEnabled(false);
            txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
            Log.e("RivalTask", "0");
            return;
        }
        break MISSING_BLOCK_LABEL_15107;
_L29:
label3:
        {
            if (!jar_2g_gsm_status.equals("1"))
            {
                break label3;
            }
            edtJar2g.setText((new StringBuilder("GSM ")).append(jar_2g_gsm).toString());
        }
          goto _L136
label4:
        {
            if (!jar_2g_cdma_status.equals("1"))
            {
                break label4;
            }
            edtJar2g.setText((new StringBuilder("CDMA ")).append(jar_2g_cdma).toString());
        }
          goto _L136
        edtJar2g.setText("Tidak");
          goto _L136
_L31:
        edtJar3g.setText((new StringBuilder(String.valueOf(jar_3g))).toString());
          goto _L137
_L33:
label5:
        {
            if (!jar_gprs_status.equals("3"))
            {
                break label5;
            }
            edtJarGPRS.setText("");
        }
          goto _L138
label6:
        {
            if (!jar_gprs.equals(""))
            {
                break label6;
            }
            edtJarGPRS.setText("Ya");
        }
          goto _L138
        edtJarGPRS.setText((new StringBuilder("Ya, ")).append(jar_gprs).toString());
          goto _L138
_L35:
label7:
        {
            if (!jar_edge_status.equals("3"))
            {
                break label7;
            }
            edtJarEdge.setText("");
        }
          goto _L139
label8:
        {
            if (!jar_edge.equals(""))
            {
                break label8;
            }
            edtJarEdge.setText("Ya");
        }
          goto _L139
        edtJarEdge.setText((new StringBuilder("Ya, ")).append(jar_edge).toString());
          goto _L139
_L37:
        edtJarSimCard.setText((new StringBuilder(String.valueOf(jar_sc))).append(" (").append(jar_sc_ket).append(")").toString());
          goto _L140
_L39:
label9:
        {
            if (!jar_multi_status.equals("3"))
            {
                break label9;
            }
            edtJarMultiSimCard.setText("");
        }
          goto _L141
label10:
        {
            if (!jar_multi_tipe1.equals("0"))
            {
                break label10;
            }
            spek_head_MultiSIM.setVisibility(8);
        }
          goto _L141
label11:
        {
            if (!jar_multi_ket.equals(""))
            {
                break label11;
            }
            edtJarMultiSimCard.setText((new StringBuilder()).append(jar_multi_tipe2).append(jar_dualon).toString());
        }
          goto _L141
        edtJarMultiSimCard.setText((new StringBuilder()).append(jar_multi_tipe2).append(jar_dualon).append(" (").append(jar_multi_ket).append(")").toString());
          goto _L141
_L41:
label12:
        {
            if (!umu_dim_ket.equals(""))
            {
                break label12;
            }
            edtUmumDim.setText((new StringBuilder(String.valueOf(umu_dim_panjang))).append(" x ").append(umu_dim_lebar).append(" x ").append(umu_dim_tebal).append(" mm").toString());
        }
          goto _L142
        edtUmumDim.setText((new StringBuilder(String.valueOf(umu_dim_panjang))).append(" x ").append(umu_dim_lebar).append(" x ").append(umu_dim_tebal).append(" mm").append(" (").append(umu_dim_ket).append(")").toString());
          goto _L142
_L43:
        edtUmumBobot.setText((new StringBuilder(String.valueOf(umu_bobot))).append(" gram").toString());
          goto _L143
_L45:
        try
        {
            void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(umu_diumumkan);
            void1 = (new SimpleDateFormat("MMMM yyyy", Locale.US)).format(void1).replace("January", "Januari,").replace("February", "Februari,").replace("March", "Maret,").replace("April", "April,").replace("May", "Mei,").replace("June", "Juni,").replace("July", "Juli,").replace("August", "Agustus,").replace("September", "September,").replace("October", "Oktober,").replace("November", "November,").replace("December", "Desember,");
            str_share_diumumkan = void1;
            edtUmumDiUm.setText(void1);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1) { }
          goto _L144
_L49:
        edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_touchscreen))).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString();
          goto _L145
_L47:
label13:
        {
            if (!lay_touchscreen.equals(""))
            {
                break MISSING_BLOCK_LABEL_9699;
            }
            if (!lay_warna_ket.equals(""))
            {
                break label13;
            }
            edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString();
        }
          goto _L145
        edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString();
          goto _L145
label14:
        {
            if (!lay_warna_ket.equals(""))
            {
                break label14;
            }
            edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString();
        }
          goto _L145
        edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString();
          goto _L145
_L51:
label15:
        {
            if (!lay_multitouch.equals("") || !lay_multitouch_status.equals("1"))
            {
                break label15;
            }
            edtLayarMultitouch.setText("Ya");
        }
          goto _L146
        if (!lay_multitouch_status.equals("2") && !lay_touchscreen_status.equals("2")) goto _L148; else goto _L147
_L147:
        spek_head_Multitouch.setVisibility(8);
          goto _L146
_L148:
        if (!lay_multitouch_status.equals("3")) goto _L146; else goto _L149
_L149:
        spek_head_Multitouch.setVisibility(8);
          goto _L146
_L53:
        spek_head_MemoriAllKet.setVisibility(8);
          goto _L150
_L55:
        spek_head_hard_ket.setVisibility(8);
          goto _L151
_L57:
        spek_head_Lay_EXT.setVisibility(8);
          goto _L152
_L59:
        spek_head_Lay_Tambahan.setVisibility(8);
          goto _L153
_L61:
label16:
        {
            if (!lay_sensor.equals("2"))
            {
                break label16;
            }
            spek_head_Sensor.setVisibility(8);
        }
          goto _L154
        lay_sensor = lay_sensor.replace("1", "Accelerometer");
        lay_sensor = lay_sensor.replace("2", "");
        lay_sensor = lay_sensor.replace("3", "Proximity");
        lay_sensor = lay_sensor.replace("4", "Ambient");
        lay_sensor = lay_sensor.replace("5", "Gyro Sensor");
        lay_sensor = lay_sensor.replace("6", "Compass");
        lay_sensor = lay_sensor.replace("7", "Barometer");
        lay_sensor = lay_sensor.replace("8", "RGB Sensor");
        lay_sensor = lay_sensor.replace("9", "Magnetometer");
        edtLayarSensor.setText(lay_sensor);
          goto _L154
_L63:
label17:
        {
            if (!lay_proteksi_status.equals("2") && !lay_proteksi_status.equals("3"))
            {
                break label17;
            }
            spek_head_Proteksi.setVisibility(8);
        }
          goto _L155
        spek_head_Proteksi.setVisibility(8);
          goto _L155
_L65:
        edtHardChipset.setText(har_chipset);
          goto _L156
_L67:
        edtHardGPU.setText(har_gpu);
          goto _L157
_L69:
label18:
        {
            if (!sof_java_status.equals("1") || !sof_java.equals(""))
            {
                break label18;
            }
            edtSoftJava.setText("Ya");
        }
          goto _L158
label19:
        {
            if (!sof_java_status.equals("2"))
            {
                break label19;
            }
            edtSoftJava.setText("Tidak");
        }
          goto _L158
        edtSoftJava.setText("");
          goto _L158
_L75:
        edtKameraUtama.setText((new StringBuilder("VGA (")).append(kam_utama_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", VGA (").append(kam_utama_ket).append(")").toString();
          goto _L159
_L73:
label20:
        {
            if (kam_utama_status.equals("2") || !kam_utama.equals(""))
            {
                break MISSING_BLOCK_LABEL_10841;
            }
            if (!kam_utama_ket.equals(""))
            {
                break label20;
            }
            edtKameraUtama.setText("Ya");
        }
          goto _L159
        edtKameraUtama.setText((new StringBuilder("Ya (")).append(kam_utama_ket).append(")").toString());
          goto _L159
label21:
        {
            if (kam_utama.equals("") || !kam_utama2.equals(""))
            {
                break MISSING_BLOCK_LABEL_11104;
            }
            if (!kam_utama_ket.equals(""))
            {
                break label21;
            }
            edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP").toString();
        }
          goto _L159
        edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP").append(" (").append(kam_utama_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP").append(" (").append(kam_utama_ket).append(")").toString();
          goto _L159
label22:
        {
            if (!kam_utama_ket.equals(""))
            {
                break label22;
            }
            edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP, ").append(kam_utama2).append(" pixels").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP, ").append(kam_utama2).append(" pixels").toString();
        }
          goto _L159
        edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP, ").append(kam_utama2).append(" pixels").append(" (").append(kam_utama_ket).append(")").toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP, ").append(kam_utama2).append(" pixels").append(" (").append(kam_utama_ket).append(")").toString();
          goto _L159
_L71:
        edtKameraUtama.setText("Tidak");
          goto _L159
_L77:
label23:
        {
            if (!har_cpu_jenpros.equals(""))
            {
                break label23;
            }
            edtHardCPU.setText((new StringBuilder(String.valueOf(har_cpu_core))).append(" ").append(har_cpu_clock).toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(har_cpu_core).append(" ").append(har_cpu_clock).toString();
        }
          goto _L160
        edtHardCPU.setText((new StringBuilder(String.valueOf(har_cpu_core))).append(" ").append(har_cpu_clock).append(", ").append(har_cpu_jenpros).toString());
        void1 = Hal2Spek.this;
        void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(har_cpu_core).append(" ").append(har_cpu_clock).append(", ").append(har_cpu_jenpros).toString();
          goto _L160
_L81:
label24:
        {
            if (!kam_led_flash_status.equals("2"))
            {
                break label24;
            }
            edtKameraLamKil.setText("Tidak");
        }
          goto _L161
label25:
        {
            if (!kam_led_flash.equals(""))
            {
                break label25;
            }
            edtKameraLamKil.setText("Ya");
        }
          goto _L161
        spek_head_LamKil.setVisibility(8);
          goto _L161
_L79:
label26:
        {
            if (!kam_led_flash_status.equals("2"))
            {
                break label26;
            }
            edtKameraLamKil.setText("Tidak");
        }
          goto _L161
        spek_head_LamKil.setVisibility(8);
          goto _L161
_L83:
        edtKameraFitKam.setText(kam_fitur);
          goto _L162
_L85:
label27:
        {
            if (!kam_video_status.equals("1") || kam_video.equals(""))
            {
                break label27;
            }
            edtKameraVidRec.setText((new StringBuilder("Ya, ")).append(kam_video).toString());
        }
          goto _L163
label28:
        {
            if (!kam_video_status.equals("1") || !kam_video.equals(""))
            {
                break label28;
            }
            edtKameraVidRec.setText("Ya");
        }
          goto _L163
        if (!kam_video_status.equals("2")) goto _L165; else goto _L164
_L164:
        spek_head_VidRec.setVisibility(8);
          goto _L163
_L165:
        if (!kam_video_status.equals("3")) goto _L163; else goto _L166
_L166:
        spek_head_VidRec.setVisibility(8);
          goto _L163
_L87:
label29:
        {
            if (!kam_depan_status.equals("1") || !kam_nat_vcall.equals("1") || kam_depan.equals(""))
            {
                break label29;
            }
            edtKameraDepan.setText((new StringBuilder("Ya, ")).append(kam_depan).append(", ").append("mendukung native video call").toString());
        }
          goto _L167
label30:
        {
            if (!kam_depan_status.equals("1") || !kam_nat_vcall.equals("1"))
            {
                break label30;
            }
            edtKameraDepan.setText("Ya, mendukung native video call");
        }
          goto _L167
label31:
        {
            if (!kam_depan_status.equals("1") || kam_depan.equals(""))
            {
                break label31;
            }
            edtKameraDepan.setText((new StringBuilder("Ya, ")).append(kam_depan).toString());
        }
          goto _L167
label32:
        {
            if (!kam_depan_status.equals("1"))
            {
                break label32;
            }
            edtKameraDepan.setText("Ya");
        }
          goto _L167
        edtKameraDepan.setText("");
          goto _L167
_L89:
label33:
        {
            if (!kam_nat_vcall.equals("2"))
            {
                break label33;
            }
            spek_head_NatVidCall.setVisibility(8);
        }
          goto _L168
        spek_head_NatVidCall.setVisibility(8);
          goto _L168
_L91:
        if (!mem_eksternal_kap.equals("1")) goto _L170; else goto _L169
_L169:
        mem_eksternal_kap = "2 GB";
_L172:
        if (mem_eksternal.equals("") || mem_eksternal_kap.equals(""))
        {
            break MISSING_BLOCK_LABEL_12773;
        }
        if (!mem_ekternal_ket.equals(""))
        {
            break MISSING_BLOCK_LABEL_12702;
        }
        edtMemoriExternal.setText((new StringBuilder(String.valueOf(mem_eksternal))).append(", hingga ").append(mem_eksternal_kap).toString());
          goto _L171
_L170:
label34:
        {
            if (!mem_eksternal_kap.equals("2"))
            {
                break label34;
            }
            mem_eksternal_kap = "4 GB";
        }
          goto _L172
label35:
        {
            if (!mem_eksternal_kap.equals("3"))
            {
                break label35;
            }
            mem_eksternal_kap = "8 GB";
        }
          goto _L172
label36:
        {
            if (!mem_eksternal_kap.equals("4"))
            {
                break label36;
            }
            mem_eksternal_kap = "16 GB";
        }
          goto _L172
label37:
        {
            if (!mem_eksternal_kap.equals("5"))
            {
                break label37;
            }
            mem_eksternal_kap = "32 GB";
        }
          goto _L172
label38:
        {
            if (!mem_eksternal_kap.equals("6"))
            {
                break label38;
            }
            mem_eksternal_kap = "64 GB";
        }
          goto _L172
label39:
        {
            if (!mem_eksternal_kap.equals("7"))
            {
                break label39;
            }
            mem_eksternal_kap = "128 GB";
        }
          goto _L172
label40:
        {
            if (!mem_eksternal_kap.equals("8"))
            {
                break label40;
            }
            mem_eksternal_kap = "256 GB";
        }
          goto _L172
label41:
        {
            if (!mem_eksternal_kap.equals("9"))
            {
                break label41;
            }
            mem_eksternal_kap = "512 GB";
        }
          goto _L172
        if (!mem_eksternal_kap.equals("10")) goto _L174; else goto _L173
_L173:
        mem_eksternal_kap = "1 TB";
          goto _L172
_L174:
        if (!mem_eksternal_kap.equals("100")) goto _L172; else goto _L175
_L175:
        mem_eksternal_kap = "";
          goto _L172
        edtMemoriExternal.setText((new StringBuilder(String.valueOf(mem_eksternal))).append(", hingga ").append(mem_eksternal_kap).append(" (").append(mem_ekternal_ket).append(")").toString());
          goto _L171
label42:
        {
            if (!mem_eksternal_s.equals("2"))
            {
                break label42;
            }
            edtMemoriExternal.setText("Tidak");
        }
          goto _L171
label43:
        {
            if (!mem_eksternal_kap.equals(""))
            {
                break MISSING_BLOCK_LABEL_12910;
            }
            if (!mem_ekternal_ket.equals(""))
            {
                break label43;
            }
            edtMemoriExternal.setText(mem_eksternal);
        }
          goto _L171
        edtMemoriExternal.setText((new StringBuilder(String.valueOf(mem_eksternal))).append(" (").append(mem_ekternal_ket).append(")").toString());
          goto _L171
        edtMemoriExternal.setText("");
          goto _L171
_L93:
label44:
        {
            if (!kon_bluetooth_status.equals("1") || kon_bluetooth.equals(""))
            {
                break label44;
            }
            edtKonekBlue.setText((new StringBuilder("Ya, ")).append(kon_bluetooth).toString());
        }
          goto _L176
label45:
        {
            if (!kon_bluetooth_status.equals("2"))
            {
                break label45;
            }
            edtKonekBlue.setText("Tidak");
        }
          goto _L176
        edtKonekBlue.setText("");
          goto _L176
_L95:
label46:
        {
            if (!kon_usb_status.equals("1") || kon_usb.equals(""))
            {
                break label46;
            }
            edtKonekUSB.setText((new StringBuilder("Ya, ")).append(kon_usb).toString());
        }
          goto _L177
label47:
        {
            if (!kon_usb_status.equals("2"))
            {
                break label47;
            }
            edtKonekUSB.setText("Tidak");
        }
          goto _L177
        edtKonekUSB.setText("");
          goto _L177
_L99:
        edtKonek35Jack.setText((new StringBuilder("Ya (")).append(kon_35mm_jack_ket).append(")").toString());
          goto _L178
_L97:
label48:
        {
            if (!kon_35mm_jack.equals("2"))
            {
                break label48;
            }
            edtKonek35Jack.setText("Tidak");
        }
          goto _L178
        edtKonek35Jack.setText("");
          goto _L178
_L101:
label49:
        {
            if (!kon_wlan_status.equals("1") || kon_wlan.equals(""))
            {
                break label49;
            }
            edtKonekWLAN.setText((new StringBuilder()).append(kon_wlan).toString());
        }
          goto _L179
label50:
        {
            if (!kon_wlan_status.equals("2"))
            {
                break label50;
            }
            edtKonekWLAN.setText("Tidak");
        }
          goto _L179
        edtKonekWLAN.setText("");
          goto _L179
_L103:
label51:
        {
            if (!kon_nfc_status.equals("1") || kon_nfc.equals(""))
            {
                break label51;
            }
            edtKonekNFC.setText((new StringBuilder("Ya, ")).append(kon_nfc).toString());
        }
          goto _L180
        if (!kon_nfc_status.equals("1")) goto _L182; else goto _L181
_L181:
        edtKonekNFC.setText("Ya");
          goto _L180
_L182:
        if (!kon_nfc_status.equals("2")) goto _L180; else goto _L183
_L183:
        spek_head_NFC.setVisibility(8);
          goto _L180
_L105:
label52:
        {
            if (!kon_hdmi_status.equals("1") || kon_hdmi.equals(""))
            {
                break label52;
            }
            edtKonekHDMI.setText((new StringBuilder("Ya, ")).append(kon_hdmi).toString());
        }
          goto _L184
        if (!kon_hdmi_status.equals("1")) goto _L186; else goto _L185
_L185:
        edtKonekHDMI.setText("Ya");
          goto _L184
_L186:
        if (!kon_hdmi_status.equals("2")) goto _L184; else goto _L187
_L187:
        spek_head_HDMI.setVisibility(8);
          goto _L184
_L107:
label53:
        {
            if (!kon_tvoutput_status.equals("1") || kon_tvoutput.equals(""))
            {
                break label53;
            }
            edtKonekTV.setText((new StringBuilder("Ya, ")).append(kon_tvoutput).toString());
        }
          goto _L188
        if (!kon_tvoutput_status.equals("1")) goto _L190; else goto _L189
_L189:
        edtKonekTV.setText("Ya");
          goto _L188
_L190:
        if (!kon_tvoutput_status.equals("2")) goto _L188; else goto _L191
_L191:
        spek_head_TV.setVisibility(8);
          goto _L188
_L111:
        edtKonekInfrared.setText((new StringBuilder("Ya (")).append(kon_infrared_ket).append(")").toString());
          goto _L192
_L109:
label54:
        {
            if (!kon_infrared.equals("2"))
            {
                break label54;
            }
            spek_head_Infrared.setVisibility(8);
        }
          goto _L192
        spek_head_Infrared.setVisibility(8);
          goto _L192
_L113:
label55:
        {
            if (!fit_musik_status.equals("1") || !fit_musik.equals(""))
            {
                break label55;
            }
            edtLain2Musik.setText("Ya");
        }
          goto _L193
label56:
        {
            if (!fit_musik_status.equals("2"))
            {
                break label56;
            }
            edtLain2Musik.setText("Tidak");
        }
          goto _L193
        edtLain2Musik.setText("");
          goto _L193
_L115:
label57:
        {
            if (!fit_radio_status.equals("1") || !fit_radio.equals(""))
            {
                break label57;
            }
            edtLain2Radio.setText("Ya");
        }
          goto _L194
label58:
        {
            if (!fit_radio_status.equals("2"))
            {
                break label58;
            }
            edtLain2Radio.setText("Tidak");
        }
          goto _L194
        edtLain2Radio.setText("");
          goto _L194
_L117:
label59:
        {
            if (!fit_tvanalog.equals("1") || !fit_tvanalog_ket.equals(""))
            {
                break label59;
            }
            edtLain2Analog.setText("Ya");
        }
          goto _L195
label60:
        {
            if (!fit_tvanalog.equals("2"))
            {
                break label60;
            }
            spek_head_TVAnalog.setVisibility(8);
        }
          goto _L195
        spek_head_TVAnalog.setVisibility(8);
          goto _L195
_L119:
label61:
        {
            if (!fit_gps_status.equals("1") || !fit_gps.equals(""))
            {
                break label61;
            }
            edtLain2GPS.setText("Ya");
        }
          goto _L196
label62:
        {
            if (!fit_gps_status.equals("2"))
            {
                break label62;
            }
            edtLain2GPS.setText("Tidak");
        }
          goto _L196
        edtLain2GPS.setText("");
          goto _L196
_L121:
label63:
        {
            if (!fit_browser_status.equals("1") || !fit_browser.equals(""))
            {
                break label63;
            }
            edtLain2Browser.setText("Ya");
        }
          goto _L197
label64:
        {
            if (!fit_browser_status.equals("2"))
            {
                break label64;
            }
            edtLain2Browser.setText("Tidak");
        }
          goto _L197
        edtLain2Browser.setText("");
          goto _L197
_L123:
label65:
        {
            if (!fit_pesan.equals(""))
            {
                break label65;
            }
            edtLain2Pesan.setText("Ya");
        }
          goto _L198
        edtLain2Pesan.setText("Tidak");
          goto _L198
_L125:
        fit_lain = fit_lain.replace("\n", "\n\u2022 ");
        edtLain2Fiturlain.setText((new StringBuilder("\u2022 ")).append(fit_lain).toString());
          goto _L199
_L127:
label66:
        {
            if (bat_model.equals("") || bat_model.equals(""))
            {
                break label66;
            }
            edtBatJenis.setText((new StringBuilder(String.valueOf(bat_kapasitas_s))).append(" ").append(bat_kapasitas).append(" mAh, ").append(bat_model).toString());
        }
          goto _L200
        edtBatJenis.setText("");
          goto _L200
_L129:
        edtBatBicara.setText(bat_bicara);
          goto _L201
_L131:
        edtBatSiaga.setText(bat_siaga);
          goto _L202
_L133:
        spek_head_BateraiIsiBox.setVisibility(0);
        edtBatIsiBox.setText(bat_musik);
          goto _L203
_L135:
label67:
        {
            if (!update_harga.equals("") && !update_harga.equals("-") && !update_harga.equals("0000-00-00"))
            {
                break label67;
            }
            edtHargaGaransi.setText("");
            spek_head_Garansi.setVisibility(8);
        }
          goto _L204
label68:
        {
            if (!sta_garansi.equals("NA") && !sta_garansi.equals("-") || update_harga.equals("-") && update_harga.equals(""))
            {
                break label68;
            }
            edtHargaGaransi.setText((new StringBuilder("Diperbarui ")).append(tgglHarga).toString());
        }
          goto _L204
label69:
        {
            if (sta_garansi.equals("0") && sta_garansi.equals("") && sta_garansi.equals("-") || !har_infotmbh.equals(""))
            {
                break label69;
            }
            edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append("; Diperbarui ").append(tgglHarga).toString());
        }
          goto _L204
label70:
        {
            if (sta_garansi.equals("0") && sta_garansi.equals("-") || har_infotmbh.equals(""))
            {
                break label70;
            }
            edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append(" (").append(har_infotmbh).append("); Diperbarui ").append(tgglHarga).toString());
        }
          goto _L204
        edtHargaGaransi.setText("");
        spek_head_Garansi.setVisibility(8);
          goto _L204
        txtValueKetertarikan.setText(Html.fromHtml((new StringBuilder("<b>Ketertarikan</b> ")).append(likepersen).append("% (").append(tnggp_bgs).append(" likes, ").append(tnggp_krg).append(" dislikes)").toString()));
        txtPercentKetertarikan.setText((new StringBuilder(String.valueOf(likepersen))).append("%").toString());
          goto _L205
        Log.e("RivalTask", "1");
        (new (Hal2Spek.this)).e(new Void[0]);
        return;
          goto _L20
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    public _cls1.this._cls1()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
