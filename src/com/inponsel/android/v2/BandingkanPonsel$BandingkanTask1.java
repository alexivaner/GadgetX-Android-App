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
