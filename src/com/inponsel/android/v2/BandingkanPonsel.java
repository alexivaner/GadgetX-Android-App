// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

public class BandingkanPonsel extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    private class BandingkanTask1 extends AsyncTask
    {

        final BandingkanPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPonsel1, 1);
                Log.d("Response: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_1003;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_1012;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_1012;
            }
            avoid = inponsel.getJSONObject(i);
            id_hp_1 = avoid.getString("id_hp");
            slug_1 = avoid.getString("slug");
            str_urlbandingkan = avoid.getString("url_bandingkan");
            hrg_barup1 = avoid.getString("hrg_baru");
            hrg_bekasp1 = avoid.getString("hrg_bekas");
            update_harga_1 = avoid.getString("update_harga");
            status_garansi_1 = avoid.getString("status_garansi");
            jaringan_2g_gsm_1 = avoid.getString("jaringan_2g_gsm");
            jaringan_2g_cdma_1 = avoid.getString("jaringan_2g_cdma");
            jaringan_3g_1 = avoid.getString("jaringan_3g");
            jaringan_4g_1 = avoid.getString("jaringan_4g");
            jaringan_gprs_1 = avoid.getString("jaringan_gprs");
            jaringan_edge_1 = avoid.getString("jaringan_edge");
            jaringan_bandwidth_1 = avoid.getString("jaringan_bandwidth");
            jaringan_simcard_1 = avoid.getString("jaringan_simcard");
            jaringan_multi_sim_1 = avoid.getString("jaringan_multi_sim");
            umum_dimensi_1 = avoid.getString("umum_dimensi");
            umum_bobot_1 = avoid.getString("umum_bobot");
            umum_warna_ponsel_1 = avoid.getString("umum_warna_ponsel");
            umum_diumumkan_1 = avoid.getString("umum_diumumkan");
            umum_status_1 = avoid.getString("umum_status");
            layar_tipe_1 = avoid.getString("layar_tipe");
            layar_ukuran_1 = avoid.getString("layar_ukuran");
            layar_multitouch_1 = avoid.getString("layar_multitouch");
            layar_sensor_1 = avoid.getString("layar_sensor");
            layar_proteksi_1 = avoid.getString("layar_proteksi");
            layar_ext_1 = avoid.getString("layar_ext");
            layar_tambahan_1 = avoid.getString("layar_tambahan");
            memori_internal_1 = avoid.getString("memori_internal");
            memori_ram_1 = avoid.getString("memori_ram");
            memori_rom_1 = avoid.getString("memori_rom");
            memori_all_1 = avoid.getString("memori_all");
            memori_eksternal_1 = avoid.getString("memori_eksternal");
            memori_eksternal_kap_1 = avoid.getString("memori_eksternal_kap");
            memori_phonebook_1 = avoid.getString("memori_phonebook");
            hardware_info_1 = avoid.getString("hardware_info");
            hardware_chipset_1 = avoid.getString("hardware_chipset");
            hardware_cpu_1 = avoid.getString("hardware_cpu");
            hardware_gpu_1 = avoid.getString("hardware_gpu");
            software_os_1 = avoid.getString("software_os");
            software_java_1 = avoid.getString("software_java");
            kamera_utama_1 = avoid.getString("kamera_utama");
            kamera_lampu_kilat_1 = avoid.getString("kamera_lampu_kilat");
            kamera_fitur_1 = avoid.getString("kamera_fitur");
            kamera_video_1 = avoid.getString("kamera_video");
            kamera_depan_1 = avoid.getString("kamera_depan");
            konektivitas_bluetooth_1 = avoid.getString("konektivitas_bluetooth");
            konektivitas_usb_1 = avoid.getString("konektivitas_usb");
            konektivitas_35mm_jack_1 = avoid.getString("konektivitas_35mm_jack");
            konektivitas_wlan_1 = avoid.getString("konektivitas_wlan");
            konektivitas_nfc_1 = avoid.getString("konektivitas_nfc");
            konektivitas_hdmi_1 = avoid.getString("konektivitas_hdmi");
            konektivitas_tvoutput_1 = avoid.getString("konektivitas_tvoutput");
            konektivitas_infrared_1 = avoid.getString("konektivitas_infrared");
            lain_musik_1 = avoid.getString("lain_musik");
            lain_radio_1 = avoid.getString("lain_radio");
            lain_gps_1 = avoid.getString("lain_gps");
            lain_browser_1 = avoid.getString("lain_browser");
            lain_pesan_1 = avoid.getString("lain_pesan");
            lain_tvanalog_1 = avoid.getString("lain_tvanalog");
            lain_lain_1 = avoid.getString("lain_lain");
            baterai_kapasitas_1 = avoid.getString("baterai_kapasitas");
            baterai_bicara_1 = avoid.getString("baterai_bicara");
            baterai_siaga_1 = avoid.getString("baterai_siaga");
            baterai_musik_1 = avoid.getString("baterai_musik");
            info_tambahan_1 = avoid.getString("info_tambahan");
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            Log.e("ServiceHandler", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (id_hp_1.equals("")) goto _L2; else goto _L1
_L1:
            statusTask1 = "1";
_L10:
            if (!statusTask1.equals("1") || !statusTask2.equals("1")) goto _L4; else goto _L3
_L3:
            layout_empty.setVisibility(8);
            lay_banding_konten.setVisibility(0);
_L11:
            if (jaringan_2g_gsm_1.equals("") || jaringan_2g_cdma_1.equals("")) goto _L6; else goto _L5
_L5:
            void1 = (new StringBuilder(String.valueOf(jaringan_2g_gsm_1))).append("\n").append(jaringan_2g_cdma_1).toString();
_L12:
            edtJar2g.setText(void1);
            edtJar3g.setText(jaringan_3g_1);
            edtJar4g.setText(jaringan_4g_1);
            edtJarGPRS.setText(jaringan_gprs_1);
            edtJarEdge.setText(jaringan_edge_1);
            edtJarBandwidth.setText(jaringan_bandwidth_1);
            edtJarSimCard.setText(jaringan_simcard_1);
            edtJarMultiSimCard.setText(jaringan_multi_sim_1);
            edtUmumDim.setText(umum_dimensi_1);
            edtUmumBobot.setText(umum_bobot_1);
            edtUmumWarna.setText(umum_warna_ponsel_1);
            void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(umum_diumumkan_1);
            void1 = (new SimpleDateFormat("MMMM yyyy", Locale.US)).format(void1).replace("January", "Januari,").replace("February", "Februari,").replace("March", "Maret,").replace("April", "April,").replace("May", "Mei,").replace("June", "Juni,").replace("July", "Juli,").replace("August", "Agustus,").replace("September", "September,").replace("October", "Oktober,").replace("November", "November,").replace("December", "Desember,");
            edtUmumDiUm.setText(void1);
_L13:
            edtUmumStatus.setText(umum_status_1);
            edtLayarTipe.setText(layar_tipe_1);
            edtLayarUkuran.setText(layar_ukuran_1);
            edtLayarMultitouch.setText(layar_multitouch_1);
            edtLayarSensor.setText(layar_sensor_1);
            edtLayarProteksi.setText(layar_proteksi_1);
            edtHardChipset.setText(hardware_chipset_1);
            edtHardCPU.setText(hardware_cpu_1);
            edtHardGPU.setText(hardware_gpu_1);
            edtSoftOS.setText(software_os_1);
            edtSoftJava.setText(software_java_1);
            edtKameraUtama.setText(kamera_utama_1);
            edtKameraLamKil.setText(kamera_lampu_kilat_1);
            edtKameraFitKam.setText(kamera_fitur_1);
            edtKameraVidRec.setText(kamera_video_1);
            edtKameraDepan.setText(kamera_depan_1);
            edtMemoriInternal.setText(memori_all_1);
            edtMemoriExternal.setText(memori_eksternal_1);
            edtMemoriPhoneBook.setText(memori_phonebook_1);
            edtKonekBlue.setText(konektivitas_bluetooth_1);
            edtKonekUSB.setText(konektivitas_usb_1);
            edtKonek35Jack.setText(konektivitas_35mm_jack_1);
            edtKonekWLAN.setText(konektivitas_wlan_1);
            edtKonekNFC.setText(konektivitas_nfc_1);
            edtKonekHDMI.setText(konektivitas_hdmi_1);
            edtKonekTV.setText(konektivitas_tvoutput_1);
            edtKonekInfrared.setText(konektivitas_infrared_1);
            edtLain2Musik.setText(lain_musik_1);
            edtLain2Radio.setText(lain_radio_1);
            edtLain2Analog.setText(lain_tvanalog_1);
            edtLain2GPS.setText(lain_gps_1);
            edtLain2Browser.setText(lain_browser_1);
            edtLain2Pesan.setText(lain_pesan_1);
            edtLain2Fiturlain.setText(lain_lain_1);
            edtBatJenis.setText(baterai_kapasitas_1);
            edtBatBicara.setText(baterai_bicara_1);
            edtBatSiaga.setText(baterai_siaga_1);
            if ((!hrg_bekasp1.equals("0") || !hrg_barup1.equals("0")) && (!hrg_bekasp1.equals("-") || !hrg_barup1.equals("-")) && (!hrg_bekasp1.equals("-") || !hrg_barup1.equals("0")) && (!hrg_bekasp1.equals("0") || !hrg_barup1.equals("-"))) goto _L8; else goto _L7
_L7:
            edtHargaBaru.setText("-");
            edtHargaBekas.setText("-");
_L14:
            try
            {
                void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(update_harga_1);
                SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMMM yyyy", Locale.US);
                newDateStr_1 = simpledateformat.format(void1);
                newDateStr_1 = newDateStr_1.replace("January", "Januari");
                newDateStr_1 = newDateStr_1.replace("February", "Februari");
                newDateStr_1 = newDateStr_1.replace("March", "Maret");
                newDateStr_1 = newDateStr_1.replace("April", "April");
                newDateStr_1 = newDateStr_1.replace("May", "Mei");
                newDateStr_1 = newDateStr_1.replace("June", "Juni");
                newDateStr_1 = newDateStr_1.replace("July", "Juli");
                newDateStr_1 = newDateStr_1.replace("August", "Agustus");
                newDateStr_1 = newDateStr_1.replace("September", "September");
                newDateStr_1 = newDateStr_1.replace("October", "Oktober");
                newDateStr_1 = newDateStr_1.replace("November", "November");
                newDateStr_1 = newDateStr_1.replace("December", "Desember");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            try
            {
                if (umum_status_1.equals("Dihentikan") && (hrg_bekasp1.equals("") || hrg_bekasp1 == null))
                {
                    spek_head_Garansi.setVisibility(8);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L9
_L2:
            statusTask1 = "gone";
              goto _L10
_L4:
            layout_empty.setVisibility(0);
            lay_banding_konten.setVisibility(8);
              goto _L11
_L6:
label0:
            {
                if (jaringan_2g_gsm_1.equals("") || !jaringan_2g_cdma_1.equals(""))
                {
                    break label0;
                }
                void1 = jaringan_2g_gsm_1;
            }
              goto _L12
            if (!jaringan_2g_gsm_1.equals("") || jaringan_2g_cdma_1.equals(""))
            {
                break MISSING_BLOCK_LABEL_2517;
            }
            void1 = jaringan_2g_cdma_1;
              goto _L12
            void1;
            void1.printStackTrace();
              goto _L13
_L8:
label1:
            {
                if (!hrg_bekasp1.equals("0") && !hrg_bekasp1.equals("-"))
                {
                    break label1;
                }
                edtHargaBaru.setText((new StringBuilder()).append(hrg_barup1).toString());
                edtHargaBekas.setText("-");
            }
              goto _L14
label2:
            {
                if (!hrg_barup1.equals("0") && !hrg_barup1.equals("-") && !hrg_barup1.equals("0") && !umum_status_1.equals("Dihentikan"))
                {
                    break label2;
                }
                edtHargaBaru.setText("-");
                edtHargaBekas.setText((new StringBuilder()).append(hrg_bekasp1).toString());
            }
              goto _L14
            edtHargaBaru.setText((new StringBuilder()).append(hrg_barup1).toString());
            edtHargaBekas.setText((new StringBuilder()).append(hrg_bekasp1).toString());
              goto _L14
_L9:
            if (update_harga_1.equals("") || update_harga_1.equals("null") || update_harga_1.equals("-") || update_harga_1.equals("0000-00-00"))
            {
                edtHargaGaransi.setText("-");
                return;
            }
            if ((status_garansi_1.equals("NA") || status_garansi_1.equals("null") || status_garansi_1.equals("-")) && (!update_harga_1.equals("null") || !update_harga_1.equals("") || !update_harga_1.equals("-")))
            {
                edtHargaGaransi.setText((new StringBuilder("Diperbarui ")).append(newDateStr_1).toString());
                return;
            }
            if ((!status_garansi_1.equals("0") || !status_garansi_1.equals("null") || !status_garansi_1.equals("-")) && info_tambahan_1.equals(""))
            {
                edtHargaGaransi.setText((new StringBuilder(String.valueOf(status_garansi_1))).append("; Diperbarui ").append(newDateStr_1).toString());
                return;
            }
            if ((!status_garansi_1.equals("0") || !status_garansi_1.equals("null") || !status_garansi_1.equals("-")) && !info_tambahan_1.equals(""))
            {
                edtHargaGaransi.setText((new StringBuilder(String.valueOf(status_garansi_1))).append(" (").append(info_tambahan_1).append("); Diperbarui ").append(newDateStr_1).toString());
                return;
            }
            edtHargaGaransi.setText("");
            edtHargaGaransi.setVisibility(8);
            return;
            void1 = "-";
              goto _L12
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            layout_empty.setVisibility(0);
            lay_banding_konten.setVisibility(8);
        }

        private BandingkanTask1()
        {
            this$0 = BandingkanPonsel.this;
            super();
        }

        BandingkanTask1(BandingkanTask1 bandingkantask1)
        {
            this();
        }
    }

    private class BandingkanTask2 extends AsyncTask
    {

        final BandingkanPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPonsel2, 1);
                Log.d("Response: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_1003;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_1012;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_1012;
            }
            avoid = inponsel.getJSONObject(i);
            id_hp_2 = avoid.getString("id_hp");
            slug_2 = avoid.getString("slug");
            str_urlbandingkan = avoid.getString("url_bandingkan");
            hrg_barup2 = avoid.getString("hrg_baru");
            hrg_bekasp2 = avoid.getString("hrg_bekas");
            update_harga_2 = avoid.getString("update_harga");
            status_garansi_2 = avoid.getString("status_garansi");
            jaringan_2g_gsm_2 = avoid.getString("jaringan_2g_gsm");
            jaringan_2g_cdma_2 = avoid.getString("jaringan_2g_cdma");
            jaringan_3g_2 = avoid.getString("jaringan_3g");
            jaringan_4g_2 = avoid.getString("jaringan_4g");
            jaringan_gprs_2 = avoid.getString("jaringan_gprs");
            jaringan_edge_2 = avoid.getString("jaringan_edge");
            jaringan_bandwidth_2 = avoid.getString("jaringan_bandwidth");
            jaringan_simcard_2 = avoid.getString("jaringan_simcard");
            jaringan_multi_sim_2 = avoid.getString("jaringan_multi_sim");
            umum_dimensi_2 = avoid.getString("umum_dimensi");
            umum_bobot_2 = avoid.getString("umum_bobot");
            umum_warna_ponsel_2 = avoid.getString("umum_warna_ponsel");
            umum_diumumkan_2 = avoid.getString("umum_diumumkan");
            umum_status_2 = avoid.getString("umum_status");
            layar_tipe_2 = avoid.getString("layar_tipe");
            layar_ukuran_2 = avoid.getString("layar_ukuran");
            layar_multitouch_2 = avoid.getString("layar_multitouch");
            layar_sensor_2 = avoid.getString("layar_sensor");
            layar_proteksi_2 = avoid.getString("layar_proteksi");
            layar_ext_2 = avoid.getString("layar_ext");
            layar_tambahan_2 = avoid.getString("layar_tambahan");
            memori_internal_2 = avoid.getString("memori_internal");
            memori_ram_2 = avoid.getString("memori_ram");
            memori_rom_2 = avoid.getString("memori_rom");
            memori_all_2 = avoid.getString("memori_all");
            memori_eksternal_2 = avoid.getString("memori_eksternal");
            memori_eksternal_kap_2 = avoid.getString("memori_eksternal_kap");
            memori_phonebook_2 = avoid.getString("memori_phonebook");
            hardware_info_2 = avoid.getString("hardware_info");
            hardware_chipset_2 = avoid.getString("hardware_chipset");
            hardware_cpu_2 = avoid.getString("hardware_cpu");
            hardware_gpu_2 = avoid.getString("hardware_gpu");
            software_os_2 = avoid.getString("software_os");
            software_java_2 = avoid.getString("software_java");
            kamera_utama_2 = avoid.getString("kamera_utama");
            kamera_lampu_kilat_2 = avoid.getString("kamera_lampu_kilat");
            kamera_fitur_2 = avoid.getString("kamera_fitur");
            kamera_video_2 = avoid.getString("kamera_video");
            kamera_depan_2 = avoid.getString("kamera_depan");
            konektivitas_bluetooth_2 = avoid.getString("konektivitas_bluetooth");
            konektivitas_usb_2 = avoid.getString("konektivitas_usb");
            konektivitas_35mm_jack_2 = avoid.getString("konektivitas_35mm_jack");
            konektivitas_wlan_2 = avoid.getString("konektivitas_wlan");
            konektivitas_nfc_2 = avoid.getString("konektivitas_nfc");
            konektivitas_hdmi_2 = avoid.getString("konektivitas_hdmi");
            konektivitas_tvoutput_2 = avoid.getString("konektivitas_tvoutput");
            konektivitas_infrared_2 = avoid.getString("konektivitas_infrared");
            lain_musik_2 = avoid.getString("lain_musik");
            lain_radio_2 = avoid.getString("lain_radio");
            lain_gps_2 = avoid.getString("lain_gps");
            lain_browser_2 = avoid.getString("lain_browser");
            lain_pesan_2 = avoid.getString("lain_pesan");
            lain_tvanalog_2 = avoid.getString("lain_tvanalog");
            lain_lain_2 = avoid.getString("lain_lain");
            baterai_kapasitas_2 = avoid.getString("baterai_kapasitas");
            baterai_bicara_2 = avoid.getString("baterai_bicara");
            baterai_siaga_2 = avoid.getString("baterai_siaga");
            baterai_musik_2 = avoid.getString("baterai_musik");
            info_tambahan_2 = avoid.getString("info_tambahan");
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            Log.e("ServiceHandler", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if ((jaringan_4g_1.equals("Tidak") || jaringan_4g_1.equals("-")) && (jaringan_4g_2.equals("Tidak") || jaringan_4g_2.equals("-")))
            {
                spek_head_4g.setVisibility(8);
            }
            if (jaringan_edge_1.equals("-") && jaringan_edge_2.equals("-"))
            {
                spek_head_EDGE.setVisibility(8);
            }
            if (jaringan_bandwidth_1.equals("-") && jaringan_bandwidth_2.equals("-"))
            {
                spek_head_Bandwidth.setVisibility(8);
            }
            if ((layar_multitouch_1.equals("Tidak") || layar_multitouch_1.equals("-")) && (layar_multitouch_2.equals("Tidak") || layar_multitouch_2.equals("-")))
            {
                spek_head_Multitouch.setVisibility(8);
            }
            if (layar_sensor_1.equals("-") && layar_sensor_2.equals("-"))
            {
                spek_head_Sensor.setVisibility(8);
            }
            if (jaringan_multi_sim_1.equals("-") && jaringan_multi_sim_2.equals("-"))
            {
                spek_head_MultiSIM.setVisibility(8);
            }
            if (layar_proteksi_1.equals("Tidak") && layar_proteksi_2.equals("Tidak"))
            {
                spek_head_Proteksi.setVisibility(8);
            }
            if (hardware_info_1.equals("Tidak") && hardware_info_1.equals("Tidak"))
            {
                parentHardware.setVisibility(8);
            }
            if (hardware_chipset_1.equals("-") && hardware_chipset_2.equals("-"))
            {
                spek_head_Chipset.setVisibility(8);
            }
            if (hardware_cpu_1.equals("-") && hardware_cpu_2.equals("-"))
            {
                spek_head_CPU.setVisibility(8);
            }
            if (hardware_gpu_1.equals("-") && hardware_gpu_2.equals("-"))
            {
                spek_head_GPU.setVisibility(8);
            }
            if (kamera_lampu_kilat_1.equals("-") && kamera_lampu_kilat_2.equals("-"))
            {
                spek_head_LamKil.setVisibility(8);
            }
            if (kamera_fitur_1.equals("-") && kamera_fitur_2.equals("-"))
            {
                spek_head_FitKam.setVisibility(8);
            }
            if ((kamera_video_1.equals("Tidak") || kamera_video_1.equals("-")) && (kamera_video_2.equals("Tidak") || kamera_video_2.equals("-")))
            {
                spek_head_VidRec.setVisibility(8);
            }
            if (konektivitas_wlan_1.equals("Tidak") && konektivitas_wlan_2.equals("Tidak"))
            {
                spek_head_WLAN.setVisibility(8);
            }
            if ((konektivitas_nfc_1.equals("Tidak") || konektivitas_nfc_1.equals("-")) && (konektivitas_nfc_2.equals("Tidak") || konektivitas_nfc_2.equals("-")))
            {
                spek_head_NFC.setVisibility(8);
            }
            if ((konektivitas_hdmi_1.equals("Tidak") || konektivitas_hdmi_1.equals("-")) && (konektivitas_hdmi_2.equals("Tidak") || konektivitas_hdmi_2.equals("-")))
            {
                spek_head_HDMI.setVisibility(8);
            }
            if ((konektivitas_tvoutput_1.equals("Tidak") || konektivitas_tvoutput_1.equals("-")) && (konektivitas_tvoutput_2.equals("Tidak") || konektivitas_tvoutput_2.equals("-")))
            {
                spek_head_TV.setVisibility(8);
            }
            if ((konektivitas_infrared_1.equals("Tidak") || konektivitas_infrared_1.equals("-")) && (konektivitas_infrared_2.equals("Tidak") || konektivitas_infrared_2.equals("-")))
            {
                spek_head_Infrared.setVisibility(8);
            }
            if (lain_tvanalog_1.equals("Tidak") && lain_tvanalog_1.equals("Tidak"))
            {
                spek_head_TVAnalog.setVisibility(8);
            }
            if (id_hp_2.equals("")) goto _L2; else goto _L1
_L1:
            statusTask2 = "1";
_L10:
            if (!statusTask1.equals("1") || !statusTask2.equals("1")) goto _L4; else goto _L3
_L3:
            layout_empty.setVisibility(8);
            lay_banding_konten.setVisibility(0);
_L11:
            if (jaringan_2g_gsm_2.equals("") || jaringan_2g_cdma_2.equals("")) goto _L6; else goto _L5
_L5:
            void1 = (new StringBuilder(String.valueOf(jaringan_2g_gsm_2))).append("\n").append(jaringan_2g_cdma_2).toString();
_L12:
            edtJar2gHp2.setText(void1);
            edtJar3gHp2.setText(jaringan_3g_2);
            edtJar4gHp2.setText(jaringan_4g_2);
            edtJarGPRSHp2.setText(jaringan_gprs_2);
            edtJarEdgeHp2.setText(jaringan_edge_2);
            edtJarBandwidthHp2.setText(jaringan_bandwidth_2);
            edtJarSimCardHp2.setText(jaringan_simcard_2);
            edtJarMultiSimCardHp2.setText(jaringan_multi_sim_2);
            edtUmumDimHp2.setText(umum_dimensi_2);
            edtUmumBobotHp2.setText(umum_bobot_2);
            edtUmumWarnaHp2.setText(umum_warna_ponsel_2);
            void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(umum_diumumkan_2);
            void1 = (new SimpleDateFormat("MMMM yyyy", Locale.US)).format(void1).replace("January", "Januari,").replace("February", "Februari,").replace("March", "Maret,").replace("April", "April,").replace("May", "Mei,").replace("June", "Juni,").replace("July", "Juli,").replace("August", "Agustus,").replace("September", "September,").replace("October", "Oktober,").replace("November", "November,").replace("December", "Desember,");
            edtUmumDiUmHp2.setText(void1);
_L13:
            edtUmumStatusHp2.setText(umum_status_2);
            edtLayarTipeHp2.setText(layar_tipe_2);
            edtLayarUkuranHp2.setText(layar_ukuran_2);
            edtLayarMultitouchHp2.setText(layar_multitouch_2);
            edtLayarSensorHp2.setText(layar_sensor_2);
            edtLayarProteksiHp2.setText(layar_proteksi_2);
            edtHardChipsetHp2.setText(hardware_chipset_2);
            edtHardCPUHp2.setText(hardware_cpu_2);
            edtHardGPUHp2.setText(hardware_gpu_2);
            edtSoftOSHp2.setText(software_os_2);
            edtSoftJavaHp2.setText(software_java_2);
            edtKameraUtamaHp2.setText(kamera_utama_2);
            edtKameraLamKilHp2.setText(kamera_lampu_kilat_2);
            edtKameraFitKamHp2.setText(kamera_fitur_2);
            edtKameraVidRecHp2.setText(kamera_video_2);
            edtKameraDepanHp2.setText(kamera_depan_2);
            edtMemoriInternalHp2.setText(memori_all_2);
            edtMemoriExternalHp2.setText(memori_eksternal_2);
            edtMemoriPhoneBookHp2.setText(memori_phonebook_2);
            edtKonekBlueHp2.setText(konektivitas_bluetooth_2);
            edtKonekUSBHp2.setText(konektivitas_usb_2);
            edtKonek35JackHp2.setText(konektivitas_35mm_jack_2);
            edtKonekWLANHp2.setText(konektivitas_wlan_2);
            edtKonekNFCHp2.setText(konektivitas_nfc_2);
            edtKonekHDMIHp2.setText(konektivitas_hdmi_2);
            edtKonekTVHp2.setText(konektivitas_tvoutput_2);
            edtKonekInfraredHp2.setText(konektivitas_infrared_2);
            edtLain2MusikHp2.setText(lain_musik_2);
            edtLain2RadioHp2.setText(lain_radio_2);
            edtLain2AnalogHp2.setText(lain_tvanalog_2);
            edtLain2GPSHp2.setText(lain_gps_2);
            edtLain2BrowserHp2.setText(lain_browser_2);
            edtLain2PesanHp2.setText(lain_pesan_2);
            edtLain2FiturlainHp2.setText(lain_lain_2);
            edtBatJenisHp2.setText(baterai_kapasitas_2);
            edtBatBicaraHp2.setText(baterai_bicara_2);
            edtBatSiagaHp2.setText(baterai_siaga_2);
            if ((!hrg_bekasp2.equals("0") || !hrg_barup2.equals("0")) && (!hrg_bekasp2.equals("-") || !hrg_barup2.equals("-")) && (!hrg_bekasp2.equals("-") || !hrg_barup2.equals("0")) && (!hrg_bekasp2.equals("0") || !hrg_barup2.equals("-"))) goto _L8; else goto _L7
_L7:
            edtHargaBaruHp2.setText("-");
            edtHargaBekasHp2.setText("-");
_L14:
            try
            {
                void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(update_harga_2);
                SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMMM yyyy", Locale.US);
                newDateStr_2 = simpledateformat.format(void1);
                newDateStr_2 = newDateStr_2.replace("January", "Januari");
                newDateStr_2 = newDateStr_2.replace("February", "Februari");
                newDateStr_2 = newDateStr_2.replace("March", "Maret");
                newDateStr_2 = newDateStr_2.replace("April", "April");
                newDateStr_2 = newDateStr_2.replace("May", "Mei");
                newDateStr_2 = newDateStr_2.replace("June", "Juni");
                newDateStr_2 = newDateStr_2.replace("July", "Juli");
                newDateStr_2 = newDateStr_2.replace("August", "Agustus");
                newDateStr_2 = newDateStr_2.replace("September", "September");
                newDateStr_2 = newDateStr_2.replace("October", "Oktober");
                newDateStr_2 = newDateStr_2.replace("November", "November");
                newDateStr_2 = newDateStr_2.replace("December", "Desember");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            try
            {
                if (umum_status_2.equals("Dihentikan") && (hrg_bekasp2.equals("") || hrg_bekasp1 == null))
                {
                    spek_head_Garansi.setVisibility(8);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L9
_L2:
            statusTask2 = "gone";
              goto _L10
_L4:
            layout_empty.setVisibility(0);
            lay_banding_konten.setVisibility(8);
              goto _L11
_L6:
label0:
            {
                if (jaringan_2g_gsm_2.equals("") || !jaringan_2g_cdma_2.equals(""))
                {
                    break label0;
                }
                void1 = jaringan_2g_gsm_2;
            }
              goto _L12
            if (!jaringan_2g_gsm_2.equals("") || jaringan_2g_cdma_2.equals(""))
            {
                break MISSING_BLOCK_LABEL_3621;
            }
            void1 = jaringan_2g_cdma_2;
              goto _L12
            void1;
            void1.printStackTrace();
              goto _L13
_L8:
label1:
            {
                if (!hrg_bekasp2.equals("0") && !hrg_bekasp2.equals("-"))
                {
                    break label1;
                }
                edtHargaBaruHp2.setText((new StringBuilder()).append(hrg_barup2).toString());
                edtHargaBekasHp2.setText("-");
            }
              goto _L14
label2:
            {
                if (!hrg_barup2.equals("0") && !hrg_barup2.equals("-") && !hrg_barup2.equals("0") && !umum_status_2.equals("Dihentikan"))
                {
                    break label2;
                }
                edtHargaBaruHp2.setText("-");
                edtHargaBekasHp2.setText((new StringBuilder()).append(hrg_bekasp2).toString());
            }
              goto _L14
            edtHargaBaruHp2.setText((new StringBuilder()).append(hrg_barup2).toString());
            edtHargaBekasHp2.setText((new StringBuilder()).append(hrg_bekasp2).toString());
              goto _L14
_L9:
            if (update_harga_2.equals("") || update_harga_2.equals("null") || update_harga_2.equals("-") || update_harga_2.equals("0000-00-00"))
            {
                edtHargaGaransiHp2.setText("-");
                return;
            }
            if ((status_garansi_2.equals("NA") || status_garansi_2.equals("null") || status_garansi_2.equals("-")) && (!update_harga_2.equals("null") || !update_harga_2.equals("") || !update_harga_2.equals("-")))
            {
                edtHargaGaransiHp2.setText((new StringBuilder("Diperbarui ")).append(newDateStr_2).toString());
                return;
            }
            if ((!status_garansi_2.equals("0") || !status_garansi_2.equals("null") || !status_garansi_2.equals("-")) && info_tambahan_2.equals(""))
            {
                edtHargaGaransiHp2.setText((new StringBuilder(String.valueOf(status_garansi_2))).append("; Diperbarui ").append(newDateStr_2).toString());
                return;
            }
            if ((!status_garansi_2.equals("0") || !status_garansi_2.equals("null") || !status_garansi_2.equals("-")) && !info_tambahan_2.equals(""))
            {
                edtHargaGaransiHp2.setText((new StringBuilder(String.valueOf(status_garansi_2))).append(" (").append(info_tambahan_2).append("); Diperbarui ").append(newDateStr_2).toString());
                return;
            }
            edtHargaGaransiHp2.setText("");
            edtHargaGaransiHp2.setVisibility(8);
            return;
            void1 = "-";
              goto _L12
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private BandingkanTask2()
        {
            this$0 = BandingkanPonsel.this;
            super();
        }

        BandingkanTask2(BandingkanTask2 bandingkantask2)
        {
            this();
        }
    }


    String baterai_bicara_1;
    String baterai_bicara_2;
    String baterai_kapasitas_1;
    String baterai_kapasitas_2;
    String baterai_musik_1;
    String baterai_musik_2;
    String baterai_siaga_1;
    String baterai_siaga_2;
    CallbackManager callbackManager;
    String codenamep1;
    String codenamep2;
    String dataPonsel1;
    String dataPonsel2;
    int decimalPlace;
    int decmem;
    TextView detail_text_dislike;
    TextView detail_text_dislike2;
    TextView detail_text_komentar;
    TextView detail_text_komentar2;
    TextView detail_text_like;
    TextView detail_text_like2;
    EditText edtBatBicara;
    EditText edtBatBicaraHp2;
    EditText edtBatIsiBox;
    EditText edtBatIsiBoxHp2;
    EditText edtBatJenis;
    EditText edtBatJenisHp2;
    EditText edtBatSiaga;
    EditText edtBatSiagaHp2;
    EditText edtHardCPU;
    EditText edtHardCPUHp2;
    EditText edtHardChipset;
    EditText edtHardChipsetHp2;
    EditText edtHardGPU;
    EditText edtHardGPUHp2;
    EditText edtHargaBaru;
    EditText edtHargaBaruHp2;
    EditText edtHargaBekas;
    EditText edtHargaBekasHp2;
    EditText edtHargaGaransi;
    EditText edtHargaGaransiHp2;
    EditText edtHargaInfoTamb;
    EditText edtHargaInfoTambHp2;
    EditText edtJar2g;
    EditText edtJar2gHp2;
    EditText edtJar3g;
    EditText edtJar3gHp2;
    EditText edtJar4g;
    EditText edtJar4gHp2;
    EditText edtJarBandwidth;
    EditText edtJarBandwidthHp2;
    EditText edtJarEdge;
    EditText edtJarEdgeHp2;
    EditText edtJarGPRS;
    EditText edtJarGPRSHp2;
    EditText edtJarMultiSimCard;
    EditText edtJarMultiSimCardHp2;
    EditText edtJarSimCard;
    EditText edtJarSimCardHp2;
    EditText edtKameraDepan;
    EditText edtKameraDepanHp2;
    EditText edtKameraFitKam;
    EditText edtKameraFitKamHp2;
    EditText edtKameraLamKil;
    EditText edtKameraLamKilHp2;
    EditText edtKameraUtama;
    EditText edtKameraUtamaHp2;
    EditText edtKameraVidRec;
    EditText edtKameraVidRecHp2;
    EditText edtKeteranganTambahan;
    EditText edtKeteranganTambahanHp2;
    EditText edtKonek35Jack;
    EditText edtKonek35JackHp2;
    EditText edtKonekBlue;
    EditText edtKonekBlueHp2;
    EditText edtKonekHDMI;
    EditText edtKonekHDMIHp2;
    EditText edtKonekInfrared;
    EditText edtKonekInfraredHp2;
    EditText edtKonekNFC;
    EditText edtKonekNFCHp2;
    EditText edtKonekTV;
    EditText edtKonekTVHp2;
    EditText edtKonekUSB;
    EditText edtKonekUSBHp2;
    EditText edtKonekWLAN;
    EditText edtKonekWLANHp2;
    EditText edtLain2Analog;
    EditText edtLain2AnalogHp2;
    EditText edtLain2Browser;
    EditText edtLain2BrowserHp2;
    EditText edtLain2Fiturlain;
    EditText edtLain2FiturlainHp2;
    EditText edtLain2GPS;
    EditText edtLain2GPSHp2;
    EditText edtLain2Musik;
    EditText edtLain2MusikHp2;
    EditText edtLain2Pesan;
    EditText edtLain2PesanHp2;
    EditText edtLain2Radio;
    EditText edtLain2RadioHp2;
    EditText edtLayarMultitouch;
    EditText edtLayarMultitouchHp2;
    EditText edtLayarProteksi;
    EditText edtLayarProteksiHp2;
    EditText edtLayarSensor;
    EditText edtLayarSensorHp2;
    EditText edtLayarTipe;
    EditText edtLayarTipeHp2;
    EditText edtLayarUkuran;
    EditText edtLayarUkuranHp2;
    EditText edtMemoriExternal;
    EditText edtMemoriExternalHp2;
    EditText edtMemoriInternal;
    EditText edtMemoriInternalHp2;
    EditText edtMemoriPhoneBook;
    EditText edtMemoriPhoneBookHp2;
    EditText edtNatVidCall;
    EditText edtNatVidCallHp2;
    EditText edtSoftJava;
    EditText edtSoftJavaHp2;
    EditText edtSoftOS;
    EditText edtSoftOSHp2;
    EditText edtUmumBobot;
    EditText edtUmumBobotHp2;
    EditText edtUmumDiUm;
    EditText edtUmumDiUmHp2;
    EditText edtUmumDim;
    EditText edtUmumDimHp2;
    EditText edtUmumModelHp;
    EditText edtUmumModelHpHp2;
    EditText edtUmumStatus;
    EditText edtUmumStatusHp2;
    EditText edtUmumWarna;
    EditText edtUmumWarnaHp2;
    Bundle extras;
    String gambarp1;
    String gambarp2;
    String hardware_chipset_1;
    String hardware_chipset_2;
    String hardware_cpu_1;
    String hardware_cpu_2;
    String hardware_gpu_1;
    String hardware_gpu_2;
    String hardware_info_1;
    String hardware_info_2;
    int hargaBaru1;
    int hargaBaru2;
    int hargaBekas1;
    int hargaBekas2;
    String hrg_barup1;
    String hrg_barup2;
    String hrg_bekasp1;
    String hrg_bekasp2;
    String id_hp_1;
    String id_hp_2;
    String id_hpp1;
    String id_hpp2;
    ImageLoader imageLoader2;
    ImageView imgPenilaian;
    ImageView imgPenilaian2;
    String info_tambahan_1;
    String info_tambahan_2;
    JSONArray inponsel;
    String jaringan_2g_cdma_1;
    String jaringan_2g_cdma_2;
    String jaringan_2g_gsm2;
    String jaringan_2g_gsm_1;
    String jaringan_2g_gsm_2;
    String jaringan_3g_1;
    String jaringan_3g_2;
    String jaringan_4g_1;
    String jaringan_4g_2;
    String jaringan_bandwidth_1;
    String jaringan_bandwidth_2;
    String jaringan_edge_1;
    String jaringan_edge_2;
    String jaringan_gprs_1;
    String jaringan_gprs_2;
    String jaringan_multi_sim_1;
    String jaringan_multi_sim_2;
    String jaringan_simcard_1;
    String jaringan_simcard_2;
    String jml_komentar;
    String jml_komentar2;
    String kamera_depan_1;
    String kamera_depan_2;
    String kamera_fitur_1;
    String kamera_fitur_2;
    String kamera_lampu_kilat_1;
    String kamera_lampu_kilat_2;
    String kamera_utama_1;
    String kamera_utama_2;
    String kamera_video_1;
    String kamera_video_2;
    String keterangan_tambahan_1;
    String keterangan_tambahan_2;
    String konektivitas_35mm_jack_1;
    String konektivitas_35mm_jack_2;
    String konektivitas_bluetooth_1;
    String konektivitas_bluetooth_2;
    String konektivitas_hdmi_1;
    String konektivitas_hdmi_2;
    String konektivitas_infrared_1;
    String konektivitas_infrared_2;
    String konektivitas_nfc_1;
    String konektivitas_nfc_2;
    String konektivitas_tvoutput_1;
    String konektivitas_tvoutput_2;
    String konektivitas_usb_1;
    String konektivitas_usb_2;
    String konektivitas_wlan_1;
    String konektivitas_wlan_2;
    String lain_browser_1;
    String lain_browser_2;
    String lain_gps_1;
    String lain_gps_2;
    String lain_lain_1;
    String lain_lain_2;
    String lain_musik_1;
    String lain_musik_2;
    String lain_pesan_1;
    String lain_pesan_2;
    String lain_radio_1;
    String lain_radio_2;
    String lain_tvanalog_1;
    String lain_tvanalog_2;
    LinearLayout lay_banding_konten;
    String layar_ext_1;
    String layar_ext_2;
    String layar_multitouch_1;
    String layar_multitouch_2;
    String layar_proteksi_1;
    String layar_proteksi_2;
    String layar_sensor_1;
    String layar_sensor_2;
    String layar_tambahan_1;
    String layar_tambahan_2;
    String layar_tipe_1;
    String layar_tipe_2;
    String layar_ukuran_1;
    String layar_ukuran_2;
    LinearLayout layout_empty;
    TextView loadingText;
    ProgressBar mProgressBar;
    String memori_all_1;
    String memori_all_2;
    String memori_eksternal_1;
    String memori_eksternal_2;
    String memori_eksternal_kap_1;
    String memori_eksternal_kap_2;
    String memori_internal_1;
    String memori_internal_2;
    String memori_phonebook_1;
    String memori_phonebook_2;
    String memori_ram_1;
    String memori_ram_2;
    String memori_rom_1;
    String memori_rom_2;
    TextView merkmodelhp;
    TextView merkmodelhp2;
    String merkp1;
    String merkp2;
    String modelp1;
    String modelp2;
    String namalengkapp1;
    String namalengkapp2;
    String newDateStr_1;
    String newDateStr_2;
    private DisplayImageOptions options;
    LinearLayout parentHardware;
    ProgressBar progBarBottom;
    ProgressBar progressbar_item;
    ProgressBar progressbar_item2;
    ProgressBar progressbar_middle;
    ShareDialog shareDialog;
    RelativeLayout slideDBProdukPop;
    RelativeLayout slideDaftarHargaPop;
    RelativeLayout slideFAQPop;
    RelativeLayout slideHomePop;
    RelativeLayout slideKebijakanPop;
    RelativeLayout slideLoginPop;
    RelativeLayout slidePencRinciPop;
    RelativeLayout slidePencarianPop;
    RelativeLayout slideProfilePop;
    RelativeLayout slideRegisterPop;
    RelativeLayout slideStatPop;
    RelativeLayout slideTentangPop;
    String slug_1;
    String slug_2;
    String software_java_1;
    String software_java_2;
    String software_os_1;
    String software_os_2;
    LinearLayout spek_head_2g;
    LinearLayout spek_head_35jack;
    LinearLayout spek_head_3g;
    LinearLayout spek_head_4g;
    LinearLayout spek_head_Bandwidth;
    LinearLayout spek_head_BateraiIsiBox;
    LinearLayout spek_head_BateraiJenis;
    LinearLayout spek_head_BateraiSiaga;
    LinearLayout spek_head_BateraiWakBic;
    LinearLayout spek_head_Bluetooth;
    LinearLayout spek_head_Bobot;
    LinearLayout spek_head_Browser;
    LinearLayout spek_head_CPU;
    LinearLayout spek_head_Chipset;
    LinearLayout spek_head_Dimensi;
    LinearLayout spek_head_Diumumkan;
    LinearLayout spek_head_EDGE;
    LinearLayout spek_head_FitKam;
    LinearLayout spek_head_GPRS;
    LinearLayout spek_head_GPS;
    LinearLayout spek_head_GPU;
    LinearLayout spek_head_Garansi;
    LinearLayout spek_head_HDMI;
    LinearLayout spek_head_HargaBaru;
    LinearLayout spek_head_HargaBekas;
    LinearLayout spek_head_InfoTamb;
    LinearLayout spek_head_Infrared;
    LinearLayout spek_head_Java;
    LinearLayout spek_head_KamDepan;
    LinearLayout spek_head_KamUtama;
    LinearLayout spek_head_Lain2Fit;
    LinearLayout spek_head_LamKil;
    LinearLayout spek_head_MemExternal;
    LinearLayout spek_head_MemInternal;
    LinearLayout spek_head_MemPhoneBook;
    LinearLayout spek_head_ModelHP;
    LinearLayout spek_head_MultiSIM;
    LinearLayout spek_head_Multitouch;
    LinearLayout spek_head_Musik;
    LinearLayout spek_head_NFC;
    LinearLayout spek_head_NatVidCall;
    LinearLayout spek_head_OS;
    LinearLayout spek_head_Pesan;
    LinearLayout spek_head_Proteksi;
    LinearLayout spek_head_Radio;
    LinearLayout spek_head_SIM;
    LinearLayout spek_head_Sensor;
    LinearLayout spek_head_Status;
    LinearLayout spek_head_TV;
    LinearLayout spek_head_TVAnalog;
    LinearLayout spek_head_TipeHP;
    LinearLayout spek_head_USB;
    LinearLayout spek_head_Ukuran;
    LinearLayout spek_head_VidRec;
    LinearLayout spek_head_WLAN;
    LinearLayout spek_head_Warna;
    LinearLayout spek_head_ketamb;
    String statusTask1;
    String statusTask2;
    String status_garansi_1;
    String status_garansi_2;
    String str_urlbandingkan;
    String str_urlspekshare;
    String suc;
    String t;
    String tgglHarga;
    String tgglHarga2;
    String tnggp_bgs;
    String tnggp_bgs2;
    String tnggp_krg;
    String tnggp_krg2;
    String tot_dislikep1;
    String tot_dislikep2;
    String tot_komenp1;
    String tot_komenp2;
    String tot_likep1;
    String tot_likep2;
    String total_hits;
    String total_hits2;
    TextView txtDet;
    TextView txtEmpty;
    TextView txtLoginProfile;
    TextView txt_empty;
    String umum_bobot_1;
    String umum_bobot_2;
    String umum_dimensi_1;
    String umum_dimensi_2;
    String umum_diumumkan_1;
    String umum_diumumkan_2;
    String umum_status_1;
    String umum_status_2;
    String umum_warna_ponsel_1;
    String umum_warna_ponsel_2;
    String update_harga_1;
    String update_harga_2;
    String urlSearch;

    public BandingkanPonsel()
    {
        decimalPlace = 2;
        decmem = 0;
        statusTask1 = "gone";
        statusTask2 = "gone";
        str_urlspekshare = "";
        str_urlbandingkan = "";
        t = Utility.session(RestClient.pelihara);
        inponsel = null;
        suc = "";
        id_hp_1 = "";
        slug_1 = "";
        status_garansi_1 = "";
        update_harga_1 = "";
        keterangan_tambahan_1 = "";
        jaringan_2g_gsm_1 = "";
        jaringan_2g_cdma_1 = "";
        jaringan_3g_1 = "";
        jaringan_4g_1 = "";
        jaringan_gprs_1 = "";
        jaringan_edge_1 = "";
        jaringan_bandwidth_1 = "";
        jaringan_simcard_1 = "";
        jaringan_multi_sim_1 = "";
        umum_dimensi_1 = "";
        umum_bobot_1 = "";
        umum_warna_ponsel_1 = "";
        umum_diumumkan_1 = "";
        umum_status_1 = "";
        layar_tipe_1 = "";
        layar_ukuran_1 = "";
        layar_multitouch_1 = "";
        layar_sensor_1 = "";
        layar_proteksi_1 = "";
        layar_ext_1 = "";
        layar_tambahan_1 = "";
        memori_internal_1 = "";
        memori_ram_1 = "";
        memori_rom_1 = "";
        memori_all_1 = "";
        memori_eksternal_1 = "";
        memori_eksternal_kap_1 = "";
        memori_phonebook_1 = "";
        hardware_info_1 = "";
        hardware_chipset_1 = "";
        hardware_cpu_1 = "";
        hardware_gpu_1 = "";
        software_os_1 = "";
        software_java_1 = "";
        kamera_utama_1 = "";
        kamera_lampu_kilat_1 = "";
        kamera_fitur_1 = "";
        kamera_video_1 = "";
        kamera_depan_1 = "";
        konektivitas_bluetooth_1 = "";
        konektivitas_usb_1 = "";
        konektivitas_35mm_jack_1 = "";
        konektivitas_wlan_1 = "";
        konektivitas_nfc_1 = "";
        konektivitas_hdmi_1 = "";
        konektivitas_tvoutput_1 = "";
        konektivitas_infrared_1 = "";
        lain_musik_1 = "";
        lain_radio_1 = "";
        lain_gps_1 = "";
        lain_browser_1 = "";
        lain_pesan_1 = "";
        lain_tvanalog_1 = "";
        lain_lain_1 = "";
        baterai_kapasitas_1 = "";
        baterai_bicara_1 = "";
        baterai_siaga_1 = "";
        baterai_musik_1 = "";
        info_tambahan_1 = "";
        id_hp_2 = "";
        slug_2 = "";
        status_garansi_2 = "";
        update_harga_2 = "";
        keterangan_tambahan_2 = "";
        jaringan_2g_gsm_2 = "";
        jaringan_2g_cdma_2 = "";
        jaringan_3g_2 = "";
        jaringan_4g_2 = "";
        jaringan_gprs_2 = "";
        jaringan_edge_2 = "";
        jaringan_bandwidth_2 = "";
        jaringan_simcard_2 = "";
        jaringan_multi_sim_2 = "";
        umum_dimensi_2 = "";
        umum_bobot_2 = "";
        umum_warna_ponsel_2 = "";
        umum_status_2 = "";
        umum_diumumkan_2 = "";
        layar_tipe_2 = "";
        layar_ukuran_2 = "";
        layar_multitouch_2 = "";
        layar_sensor_2 = "";
        layar_proteksi_2 = "";
        layar_ext_2 = "";
        layar_tambahan_2 = "";
        memori_internal_2 = "";
        memori_ram_2 = "";
        memori_rom_2 = "";
        memori_all_2 = "";
        memori_eksternal_2 = "";
        memori_eksternal_kap_2 = "";
        memori_phonebook_2 = "";
        hardware_info_2 = "";
        hardware_chipset_2 = "";
        hardware_cpu_2 = "";
        hardware_gpu_2 = "";
        software_os_2 = "";
        software_java_2 = "";
        kamera_utama_2 = "";
        kamera_lampu_kilat_2 = "";
        kamera_fitur_2 = "";
        kamera_video_2 = "";
        kamera_depan_2 = "";
        konektivitas_bluetooth_2 = "";
        konektivitas_usb_2 = "";
        konektivitas_35mm_jack_2 = "";
        konektivitas_wlan_2 = "";
        konektivitas_nfc_2 = "";
        konektivitas_hdmi_2 = "";
        konektivitas_tvoutput_2 = "";
        konektivitas_infrared_2 = "";
        lain_musik_2 = "";
        lain_radio_2 = "";
        lain_gps_2 = "";
        lain_browser_2 = "";
        lain_pesan_2 = "";
        lain_tvanalog_2 = "";
        lain_lain_2 = "";
        baterai_kapasitas_2 = "";
        baterai_bicara_2 = "";
        baterai_siaga_2 = "";
        baterai_musik_2 = "";
        info_tambahan_2 = "";
        jaringan_2g_gsm2 = "";
    }

    private void BandingkanTask1()
    {
        BandingkanTask1 bandingkantask1 = new BandingkanTask1(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            bandingkantask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            bandingkantask1.execute(new Void[0]);
            return;
        }
    }

    private void BandingkanTask2()
    {
        BandingkanTask2 bandingkantask2 = new BandingkanTask2(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            bandingkantask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            bandingkantask2.execute(new Void[0]);
            return;
        }
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030095, null, false);
        mDrawerLayout.addView(bundle, 0);
        t = Utility.session(t);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        t = Utility.session(t);
        callbackManager = com.facebook.CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(getString(0x7f0c0035));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020209).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        extras = getIntent().getExtras();
        namalengkapp1 = extras.getString("namalengkap1");
        id_hpp1 = extras.getString("id_hp1");
        modelp1 = extras.getString("model1");
        merkp1 = extras.getString("merk1");
        gambarp1 = extras.getString("gambar1");
        tot_likep1 = extras.getString("tot_like1");
        tot_dislikep1 = extras.getString("tot_dislike1");
        tot_komenp1 = extras.getString("tot_komen1");
        namalengkapp2 = extras.getString("namalengkap2");
        id_hpp2 = extras.getString("id_hp2");
        modelp2 = extras.getString("model2");
        merkp2 = extras.getString("merk2");
        gambarp2 = extras.getString("gambar2");
        tot_likep2 = extras.getString("tot_like2");
        tot_dislikep2 = extras.getString("tot_dislike2");
        tot_komenp2 = extras.getString("tot_komen2");
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Bandingkan ")).append(URLDecoder.decode(namalengkapp1)).append(" VS ").append(URLDecoder.decode(namalengkapp2)).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        dataPonsel1 = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ponsel_bandingkan").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hpp1).append("&t=").append(t).toString();
        dataPonsel2 = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ponsel_bandingkan").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hpp2).append("&t=").append(t).toString();
        Log.e("gambarp1", gambarp1);
        Log.e("gambarp2", gambarp2);
        Log.e("dataPonsel1", dataPonsel1);
        Log.e("dataPonsel2", dataPonsel2);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        lay_banding_konten = (LinearLayout)findViewById(0x7f0b0119);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        progressbar_item2 = (ProgressBar)findViewById(0x7f0b0524);
        parentHardware = (LinearLayout)findViewById(0x7f0b0152);
        spek_head_ketamb = (LinearLayout)findViewById(0x7f0b0557);
        spek_head_2g = (LinearLayout)findViewById(0x7f0b011a);
        spek_head_3g = (LinearLayout)findViewById(0x7f0b011d);
        spek_head_4g = (LinearLayout)findViewById(0x7f0b0120);
        spek_head_GPRS = (LinearLayout)findViewById(0x7f0b0123);
        spek_head_EDGE = (LinearLayout)findViewById(0x7f0b0126);
        spek_head_Bandwidth = (LinearLayout)findViewById(0x7f0b0129);
        spek_head_SIM = (LinearLayout)findViewById(0x7f0b012c);
        spek_head_MultiSIM = (LinearLayout)findViewById(0x7f0b012f);
        spek_head_ModelHP = (LinearLayout)findViewById(0x7f0b0132);
        spek_head_Dimensi = (LinearLayout)findViewById(0x7f0b0134);
        spek_head_Bobot = (LinearLayout)findViewById(0x7f0b0137);
        spek_head_Warna = (LinearLayout)findViewById(0x7f0b013a);
        spek_head_Diumumkan = (LinearLayout)findViewById(0x7f0b013d);
        spek_head_Status = (LinearLayout)findViewById(0x7f0b0140);
        spek_head_TipeHP = (LinearLayout)findViewById(0x7f0b0143);
        spek_head_Ukuran = (LinearLayout)findViewById(0x7f0b0146);
        spek_head_Multitouch = (LinearLayout)findViewById(0x7f0b0149);
        spek_head_Sensor = (LinearLayout)findViewById(0x7f0b014c);
        spek_head_Proteksi = (LinearLayout)findViewById(0x7f0b014f);
        spek_head_Chipset = (LinearLayout)findViewById(0x7f0b0153);
        spek_head_CPU = (LinearLayout)findViewById(0x7f0b0156);
        spek_head_GPU = (LinearLayout)findViewById(0x7f0b0159);
        spek_head_OS = (LinearLayout)findViewById(0x7f0b015c);
        spek_head_Java = (LinearLayout)findViewById(0x7f0b015f);
        spek_head_KamUtama = (LinearLayout)findViewById(0x7f0b0162);
        spek_head_LamKil = (LinearLayout)findViewById(0x7f0b0165);
        spek_head_FitKam = (LinearLayout)findViewById(0x7f0b0168);
        spek_head_VidRec = (LinearLayout)findViewById(0x7f0b016b);
        spek_head_KamDepan = (LinearLayout)findViewById(0x7f0b016e);
        spek_head_NatVidCall = (LinearLayout)findViewById(0x7f0b0171);
        spek_head_MemInternal = (LinearLayout)findViewById(0x7f0b0174);
        spek_head_MemExternal = (LinearLayout)findViewById(0x7f0b0177);
        spek_head_MemPhoneBook = (LinearLayout)findViewById(0x7f0b017a);
        spek_head_Bluetooth = (LinearLayout)findViewById(0x7f0b017d);
        spek_head_HDMI = (LinearLayout)findViewById(0x7f0b018c);
        spek_head_TV = (LinearLayout)findViewById(0x7f0b018f);
        spek_head_Infrared = (LinearLayout)findViewById(0x7f0b0192);
        spek_head_Musik = (LinearLayout)findViewById(0x7f0b0195);
        spek_head_Radio = (LinearLayout)findViewById(0x7f0b0198);
        spek_head_TVAnalog = (LinearLayout)findViewById(0x7f0b019b);
        spek_head_NFC = (LinearLayout)findViewById(0x7f0b0189);
        spek_head_GPS = (LinearLayout)findViewById(0x7f0b019e);
        spek_head_Browser = (LinearLayout)findViewById(0x7f0b01a1);
        spek_head_Pesan = (LinearLayout)findViewById(0x7f0b01a4);
        spek_head_Lain2Fit = (LinearLayout)findViewById(0x7f0b01a7);
        spek_head_BateraiJenis = (LinearLayout)findViewById(0x7f0b01aa);
        spek_head_BateraiWakBic = (LinearLayout)findViewById(0x7f0b01ad);
        spek_head_BateraiSiaga = (LinearLayout)findViewById(0x7f0b01b0);
        spek_head_BateraiIsiBox = (LinearLayout)findViewById(0x7f0b01b3);
        spek_head_HargaBaru = (LinearLayout)findViewById(0x7f0b01b6);
        spek_head_HargaBekas = (LinearLayout)findViewById(0x7f0b01b9);
        spek_head_Garansi = (LinearLayout)findViewById(0x7f0b01bc);
        spek_head_InfoTamb = (LinearLayout)findViewById(0x7f0b01bf);
        spek_head_WLAN = (LinearLayout)findViewById(0x7f0b0186);
        spek_head_35jack = (LinearLayout)findViewById(0x7f0b0183);
        detail_text_like = (TextView)findViewById(0x7f0b04a0);
        detail_text_dislike = (TextView)findViewById(0x7f0b04a3);
        detail_text_komentar = (TextView)findViewById(0x7f0b04a6);
        detail_text_like2 = (TextView)findViewById(0x7f0b0526);
        detail_text_dislike2 = (TextView)findViewById(0x7f0b0527);
        detail_text_komentar2 = (TextView)findViewById(0x7f0b0528);
        merkmodelhp = (TextView)findViewById(0x7f0b0529);
        merkmodelhp2 = (TextView)findViewById(0x7f0b052a);
        merkmodelhp.setText(Html.fromHtml((new StringBuilder("<font color=\"#1565C0\">")).append(namalengkapp1).append("</font>").append(" ").append("<font color=\"#5D4037\">").append(namalengkapp2).append("</font>").toString()));
        merkmodelhp2.setText(namalengkapp2);
        edtJar2g = (EditText)findViewById(0x7f0b011b);
        edtJar3g = (EditText)findViewById(0x7f0b011e);
        edtJar4g = (EditText)findViewById(0x7f0b0121);
        edtJarGPRS = (EditText)findViewById(0x7f0b0124);
        edtJarEdge = (EditText)findViewById(0x7f0b0127);
        edtJarBandwidth = (EditText)findViewById(0x7f0b012a);
        edtJarSimCard = (EditText)findViewById(0x7f0b012d);
        edtJarMultiSimCard = (EditText)findViewById(0x7f0b0130);
        edtUmumDim = (EditText)findViewById(0x7f0b0135);
        edtUmumBobot = (EditText)findViewById(0x7f0b0138);
        edtUmumWarna = (EditText)findViewById(0x7f0b013b);
        edtUmumDiUm = (EditText)findViewById(0x7f0b013e);
        edtUmumStatus = (EditText)findViewById(0x7f0b0141);
        edtLayarTipe = (EditText)findViewById(0x7f0b0144);
        edtLayarUkuran = (EditText)findViewById(0x7f0b0147);
        edtLayarMultitouch = (EditText)findViewById(0x7f0b014a);
        edtLayarSensor = (EditText)findViewById(0x7f0b014d);
        edtLayarProteksi = (EditText)findViewById(0x7f0b0150);
        edtHardChipset = (EditText)findViewById(0x7f0b0154);
        edtHardCPU = (EditText)findViewById(0x7f0b0157);
        edtHardGPU = (EditText)findViewById(0x7f0b015a);
        edtSoftOS = (EditText)findViewById(0x7f0b015d);
        edtSoftJava = (EditText)findViewById(0x7f0b0160);
        edtKameraUtama = (EditText)findViewById(0x7f0b0163);
        edtKameraLamKil = (EditText)findViewById(0x7f0b0166);
        edtKameraFitKam = (EditText)findViewById(0x7f0b0169);
        edtKameraVidRec = (EditText)findViewById(0x7f0b016c);
        edtKameraDepan = (EditText)findViewById(0x7f0b016f);
        edtNatVidCall = (EditText)findViewById(0x7f0b0172);
        edtMemoriInternal = (EditText)findViewById(0x7f0b0175);
        edtMemoriExternal = (EditText)findViewById(0x7f0b0178);
        edtMemoriPhoneBook = (EditText)findViewById(0x7f0b017b);
        edtKonekBlue = (EditText)findViewById(0x7f0b017e);
        edtKonekUSB = (EditText)findViewById(0x7f0b0181);
        edtKonek35Jack = (EditText)findViewById(0x7f0b0184);
        edtKonekWLAN = (EditText)findViewById(0x7f0b0187);
        edtKonekNFC = (EditText)findViewById(0x7f0b018a);
        edtKonekHDMI = (EditText)findViewById(0x7f0b018d);
        edtKonekTV = (EditText)findViewById(0x7f0b0190);
        edtKonekInfrared = (EditText)findViewById(0x7f0b0193);
        edtLain2Musik = (EditText)findViewById(0x7f0b0196);
        edtLain2Radio = (EditText)findViewById(0x7f0b0199);
        edtLain2Analog = (EditText)findViewById(0x7f0b019c);
        edtLain2GPS = (EditText)findViewById(0x7f0b019f);
        edtLain2Browser = (EditText)findViewById(0x7f0b01a2);
        edtLain2Pesan = (EditText)findViewById(0x7f0b01a5);
        edtLain2Fiturlain = (EditText)findViewById(0x7f0b01a8);
        edtBatJenis = (EditText)findViewById(0x7f0b01ab);
        edtBatBicara = (EditText)findViewById(0x7f0b01ae);
        edtBatSiaga = (EditText)findViewById(0x7f0b01b1);
        edtBatIsiBox = (EditText)findViewById(0x7f0b01b4);
        edtHargaBaru = (EditText)findViewById(0x7f0b01b7);
        edtHargaBekas = (EditText)findViewById(0x7f0b01ba);
        edtHargaGaransi = (EditText)findViewById(0x7f0b01bd);
        edtHargaInfoTamb = (EditText)findViewById(0x7f0b01c0);
        edtJar2gHp2 = (EditText)findViewById(0x7f0b011c);
        edtJar3gHp2 = (EditText)findViewById(0x7f0b011f);
        edtJar4gHp2 = (EditText)findViewById(0x7f0b0122);
        edtJarGPRSHp2 = (EditText)findViewById(0x7f0b0125);
        edtJarEdgeHp2 = (EditText)findViewById(0x7f0b0128);
        edtJarBandwidthHp2 = (EditText)findViewById(0x7f0b012b);
        edtJarSimCardHp2 = (EditText)findViewById(0x7f0b012e);
        edtJarMultiSimCardHp2 = (EditText)findViewById(0x7f0b0131);
        edtUmumDimHp2 = (EditText)findViewById(0x7f0b0136);
        edtUmumBobotHp2 = (EditText)findViewById(0x7f0b0139);
        edtUmumWarnaHp2 = (EditText)findViewById(0x7f0b013c);
        edtUmumDiUmHp2 = (EditText)findViewById(0x7f0b013f);
        edtUmumStatusHp2 = (EditText)findViewById(0x7f0b0142);
        edtLayarTipeHp2 = (EditText)findViewById(0x7f0b0145);
        edtLayarUkuranHp2 = (EditText)findViewById(0x7f0b0148);
        edtLayarMultitouchHp2 = (EditText)findViewById(0x7f0b014b);
        edtLayarSensorHp2 = (EditText)findViewById(0x7f0b014e);
        edtLayarProteksiHp2 = (EditText)findViewById(0x7f0b0151);
        edtHardChipsetHp2 = (EditText)findViewById(0x7f0b0155);
        edtHardCPUHp2 = (EditText)findViewById(0x7f0b0158);
        edtHardGPUHp2 = (EditText)findViewById(0x7f0b015b);
        edtSoftOSHp2 = (EditText)findViewById(0x7f0b015e);
        edtSoftJavaHp2 = (EditText)findViewById(0x7f0b0161);
        edtKameraUtamaHp2 = (EditText)findViewById(0x7f0b0164);
        edtKameraLamKilHp2 = (EditText)findViewById(0x7f0b0167);
        edtKameraFitKamHp2 = (EditText)findViewById(0x7f0b016a);
        edtKameraVidRecHp2 = (EditText)findViewById(0x7f0b016d);
        edtKameraDepanHp2 = (EditText)findViewById(0x7f0b0170);
        edtNatVidCallHp2 = (EditText)findViewById(0x7f0b0173);
        edtMemoriInternalHp2 = (EditText)findViewById(0x7f0b0176);
        edtMemoriExternalHp2 = (EditText)findViewById(0x7f0b0179);
        edtMemoriPhoneBookHp2 = (EditText)findViewById(0x7f0b017c);
        edtKonekBlueHp2 = (EditText)findViewById(0x7f0b017f);
        edtKonekUSBHp2 = (EditText)findViewById(0x7f0b0182);
        edtKonek35JackHp2 = (EditText)findViewById(0x7f0b0185);
        edtKonekWLANHp2 = (EditText)findViewById(0x7f0b0188);
        edtKonekNFCHp2 = (EditText)findViewById(0x7f0b018b);
        edtKonekHDMIHp2 = (EditText)findViewById(0x7f0b018e);
        edtKonekTVHp2 = (EditText)findViewById(0x7f0b0191);
        edtKonekInfraredHp2 = (EditText)findViewById(0x7f0b0194);
        edtLain2MusikHp2 = (EditText)findViewById(0x7f0b0197);
        edtLain2RadioHp2 = (EditText)findViewById(0x7f0b019a);
        edtLain2AnalogHp2 = (EditText)findViewById(0x7f0b019d);
        edtLain2GPSHp2 = (EditText)findViewById(0x7f0b01a0);
        edtLain2BrowserHp2 = (EditText)findViewById(0x7f0b01a3);
        edtLain2PesanHp2 = (EditText)findViewById(0x7f0b01a6);
        edtLain2FiturlainHp2 = (EditText)findViewById(0x7f0b01a9);
        edtBatJenisHp2 = (EditText)findViewById(0x7f0b01ac);
        edtBatBicaraHp2 = (EditText)findViewById(0x7f0b01af);
        edtBatSiagaHp2 = (EditText)findViewById(0x7f0b01b2);
        edtBatIsiBoxHp2 = (EditText)findViewById(0x7f0b01b5);
        edtHargaBaruHp2 = (EditText)findViewById(0x7f0b01b8);
        edtHargaBekasHp2 = (EditText)findViewById(0x7f0b01bb);
        edtHargaGaransiHp2 = (EditText)findViewById(0x7f0b01be);
        edtHargaInfoTambHp2 = (EditText)findViewById(0x7f0b01c1);
        edtHargaBaru = (EditText)findViewById(0x7f0b01b7);
        edtHargaBekas = (EditText)findViewById(0x7f0b01ba);
        edtHargaGaransi = (EditText)findViewById(0x7f0b01bd);
        edtHargaInfoTamb = (EditText)findViewById(0x7f0b01c0);
        edtHargaBaruHp2 = (EditText)findViewById(0x7f0b01b8);
        edtHargaBekasHp2 = (EditText)findViewById(0x7f0b01bb);
        edtHargaGaransiHp2 = (EditText)findViewById(0x7f0b01be);
        edtHargaInfoTambHp2 = (EditText)findViewById(0x7f0b01c1);
        edtHargaGaransi = (EditText)findViewById(0x7f0b01bd);
        edtHargaInfoTamb = (EditText)findViewById(0x7f0b01c0);
        edtHargaGaransiHp2 = (EditText)findViewById(0x7f0b01be);
        edtHargaInfoTambHp2 = (EditText)findViewById(0x7f0b01c1);
        edtJar2g.setText("-");
        edtJar3g.setText("-");
        edtJar4g.setText("-");
        edtJarGPRS.setText("-");
        edtJarEdge.setText("-");
        edtJarBandwidth.setText("-");
        edtJarSimCard.setText("-");
        edtJarMultiSimCard.setText("-");
        edtUmumDim.setText("-");
        edtUmumBobot.setText("-");
        edtUmumWarna.setText("-");
        edtUmumDiUm.setText("-");
        edtUmumStatus.setText("-");
        edtLayarTipe.setText("-");
        edtLayarUkuran.setText("-");
        edtLayarMultitouch.setText("-");
        edtLayarSensor.setText("-");
        edtLayarProteksi.setText("-");
        edtHardChipset.setText("-");
        edtHardCPU.setText("-");
        edtHardGPU.setText("-");
        edtSoftOS.setText("-");
        edtSoftJava.setText("-");
        edtKameraUtama.setText("-");
        edtKameraLamKil.setText("-");
        edtKameraFitKam.setText("-");
        edtKameraVidRec.setText("-");
        edtKameraDepan.setText("-");
        edtNatVidCall.setText("-");
        edtMemoriInternal.setText("-");
        edtMemoriExternal.setText("-");
        edtMemoriPhoneBook.setText("-");
        edtKonekBlue.setText("-");
        edtKonekUSB.setText("-");
        edtKonek35Jack.setText("-");
        edtKonekWLAN.setText("-");
        edtKonekNFC.setText("-");
        edtKonekHDMI.setText("-");
        edtKonekTV.setText("-");
        edtKonekInfrared.setText("-");
        edtLain2Musik.setText("-");
        edtLain2Radio.setText("-");
        edtLain2Analog.setText("-");
        edtLain2GPS.setText("-");
        edtLain2Browser.setText("-");
        edtLain2Pesan.setText("-");
        edtLain2Fiturlain.setText("-");
        edtBatJenis.setText("-");
        edtBatBicara.setText("-");
        edtBatSiaga.setText("-");
        edtBatIsiBox.setText("-");
        edtHargaBaru.setText("-");
        edtHargaBekas.setText("-");
        edtHargaGaransi.setText("-");
        edtHargaInfoTamb.setText("-");
        edtJar2gHp2.setText("-");
        edtJar3gHp2.setText("-");
        edtJar4gHp2.setText("-");
        edtJarGPRSHp2.setText("-");
        edtJarEdgeHp2.setText("-");
        edtJarBandwidthHp2.setText("-");
        edtJarSimCardHp2.setText("-");
        edtJarMultiSimCardHp2.setText("-");
        edtUmumDimHp2.setText("-");
        edtUmumBobotHp2.setText("-");
        edtUmumWarnaHp2.setText("-");
        edtUmumDiUmHp2.setText("-");
        edtUmumStatusHp2.setText("-");
        edtLayarTipeHp2.setText("-");
        edtLayarUkuranHp2.setText("-");
        edtLayarMultitouchHp2.setText("-");
        edtLayarSensorHp2.setText("-");
        edtLayarProteksiHp2.setText("-");
        edtHardChipsetHp2.setText("-");
        edtHardCPUHp2.setText("-");
        edtHardGPUHp2.setText("-");
        edtSoftOSHp2.setText("-");
        edtSoftJavaHp2.setText("-");
        edtKameraUtamaHp2.setText("-");
        edtKameraLamKilHp2.setText("-");
        edtKameraFitKamHp2.setText("-");
        edtKameraVidRecHp2.setText("-");
        edtKameraDepanHp2.setText("-");
        edtNatVidCallHp2.setText("-");
        edtMemoriInternalHp2.setText("-");
        edtMemoriExternalHp2.setText("-");
        edtMemoriPhoneBookHp2.setText("-");
        edtKonekBlueHp2.setText("-");
        edtKonekUSBHp2.setText("-");
        edtKonek35JackHp2.setText("-");
        edtKonekWLANHp2.setText("-");
        edtKonekNFCHp2.setText("-");
        edtKonekHDMIHp2.setText("-");
        edtKonekTVHp2.setText("-");
        edtKonekInfraredHp2.setText("-");
        edtLain2MusikHp2.setText("-");
        edtLain2RadioHp2.setText("-");
        edtLain2AnalogHp2.setText("-");
        edtLain2GPSHp2.setText("-");
        edtLain2BrowserHp2.setText("-");
        edtLain2PesanHp2.setText("-");
        edtLain2FiturlainHp2.setText("-");
        edtBatJenisHp2.setText("-");
        edtBatBicaraHp2.setText("-");
        edtBatSiagaHp2.setText("-");
        edtBatIsiBoxHp2.setText("-");
        edtHargaBaruHp2.setText("-");
        edtHargaBekasHp2.setText("-");
        edtHargaGaransiHp2.setText("-");
        edtHargaInfoTambHp2.setText("-");
        edtHargaBaru.setText("-");
        edtHargaBekas.setText("-");
        edtHargaGaransi.setText("-");
        edtHargaInfoTamb.setText("-");
        edtHargaBaruHp2.setText("-");
        edtHargaBekasHp2.setText("-");
        edtHargaGaransiHp2.setText("-");
        edtHargaInfoTambHp2.setText("-");
        edtHargaGaransi.setText("-");
        edtHargaInfoTamb.setText("-");
        edtHargaGaransiHp2.setText("-");
        edtHargaInfoTambHp2.setText("-");
        detail_text_like.setText(tot_likep1);
        detail_text_dislike.setText(tot_dislikep1);
        detail_text_komentar.setText(tot_komenp1);
        detail_text_like2.setText(tot_likep2);
        detail_text_dislike2.setText(tot_dislikep2);
        detail_text_komentar2.setText(tot_komenp2);
        imgPenilaian = (ImageView)findViewById(0x7f0b0523);
        imgPenilaian2 = (ImageView)findViewById(0x7f0b0525);
        try
        {
            imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(gambarp1.trim()).toString(), imgPenilaian, options, new ImageLoadingListener() {

                final BandingkanPonsel this$0;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    progressbar_item.setVisibility(8);
                    imgPenilaian.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    progressbar_item.setVisibility(8);
                    imgPenilaian.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    progressbar_item.setVisibility(0);
                    imgPenilaian.setVisibility(0);
                }

            
            {
                this$0 = BandingkanPonsel.this;
                super();
            }
            });
            imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(gambarp2.trim()).toString(), imgPenilaian2, options, new ImageLoadingListener() {

                final BandingkanPonsel this$0;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    progressbar_item2.setVisibility(8);
                    imgPenilaian2.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    progressbar_item2.setVisibility(8);
                    imgPenilaian2.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    progressbar_item2.setVisibility(0);
                    imgPenilaian2.setVisibility(8);
                }

            
            {
                this$0 = BandingkanPonsel.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        BandingkanTask1();
        BandingkanTask2();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0004, menu);
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

    public boolean onOptionsItemSelected(final MenuItem objShareIntentListAdapter)
    {
        switch (objShareIntentListAdapter.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(objShareIntentListAdapter);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            return true;

        case 2131429683: 
            str_urlspekshare = (new StringBuilder(String.valueOf(str_urlbandingkan))).append(id_hp_1).append("/").append(slug_1).append("/vs/").append(id_hp_2).append("/").append(slug_2).toString();
            break;
        }
        Log.e("str_urlspekshare", str_urlspekshare);
        objShareIntentListAdapter = new Intent("android.intent.action.SEND");
        objShareIntentListAdapter.setType("text/plain");
        objShareIntentListAdapter = new ShareIntentListAdapter(this, getPackageManager().queryIntentActivities(objShareIntentListAdapter, 0).toArray());
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Bagikan ke");
        builder.setAdapter(objShareIntentListAdapter, new android.content.DialogInterface.OnClickListener() {

            final BandingkanPonsel this$0;
            private final ShareIntentListAdapter val$objShareIntentListAdapter;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = (ResolveInfo)objShareIntentListAdapter.getItem(i);
                if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
                {
                    Log.e("share", "facebook");
                    dialoginterface = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle((new StringBuilder(String.valueOf(namalengkapp1))).append(" vs ").append(namalengkapp2).toString()).setImageUrl(Uri.parse(gambarp1)).setContentDescription((new StringBuilder("Komparasi lengkap ")).append(namalengkapp1).append(" vs ").append(namalengkapp2).toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
                    shareDialog.show(dialoginterface);
                    return;
                } else
                {
                    Log.e("share", "other");
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", str_urlspekshare);
                    intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder("Komparasi lengkap ")).append(namalengkapp1).append(" vs ").append(namalengkapp2).toString());
                    Log.e("share", str_urlspekshare);
                    intent.putExtra("android.intent.extra.TITLE", (new StringBuilder(String.valueOf(namalengkapp1))).append(" vs ").append(namalengkapp2).toString());
                    startActivity(intent);
                    return;
                }
            }

            
            {
                this$0 = BandingkanPonsel.this;
                objShareIntentListAdapter = shareintentlistadapter;
                super();
            }
        });
        builder.show();
        return true;
    }
}
