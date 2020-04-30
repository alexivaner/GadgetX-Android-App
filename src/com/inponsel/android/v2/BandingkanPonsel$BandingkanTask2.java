// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BandingkanPonsel

private class <init> extends AsyncTask
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

    private ()
    {
        this$0 = BandingkanPonsel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
