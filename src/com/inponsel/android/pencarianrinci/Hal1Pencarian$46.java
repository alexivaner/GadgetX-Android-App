// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian, BasePencarianActivity, Hal2HasilPencarian

class this._cls0
    implements android.view.ner
{

    final Hal1Pencarian this$0;

    public void onClick(View view)
    {
        queryUrl = (new StringBuilder("&merek=")).append(Hal1Pencarian.strPencMerek).append("&umu_status=").append(Hal1Pencarian.strPencStatus).append("&hrg_baru=").append(Hal1Pencarian.strPencHarga).append("&jar_2g_status=").append(Hal1Pencarian.strPenc2G).append("&jar_3g_status=").append(Hal1Pencarian.strPenc3G).append("&jar_4g_status=").append(Hal1Pencarian.strPenc4G).append("&jar_gprs_status=").append(Hal1Pencarian.strPencGPRS).append("&jar_edge_status=").append(Hal1Pencarian.strPencEDGE).append("&jar_2g_cdma_status=").append(Hal1Pencarian.strPencCDMA).append("&jar_sc=").append(Hal1Pencarian.strPencSIM).append("&jar_multi_status=").append(Hal1Pencarian.strPencMulti).append("&jar_multi_tipe2=").append(Hal1Pencarian.strPencGSMCDMA).append("&kam_nat_vcall=").append(Hal1Pencarian.strPencNative).append("&umu_model=").append(Hal1Pencarian.strPencModel).append("&umu_dim_panjang=").append(Hal1Pencarian.strPencPanjang).append("&umu_dim_lebar=").append(Hal1Pencarian.strPencLebar).append("&umu_dim_tebal=").append(Hal1Pencarian.strPencTebal).append("&umu_bobot=").append(Hal1Pencarian.strPencBobot).append("&sof_os=").append(Hal1Pencarian.strPencSistem).append("&har_cpu_clock=").append(Hal1Pencarian.strPencProsessor).append("&har_cpu_core=").append(Hal1Pencarian.strPencCore).append("&mem_ram=").append(Hal1Pencarian.strPencRAM).append("&mem_internal=").append(Hal1Pencarian.strPencInternal).append("&mem_eksternal=").append(Hal1Pencarian.strPencEksternal).append("&lay_size_diagonal=").append(Hal1Pencarian.strPencUkuranLayar).append("&lay_size_ppi=").append(Hal1Pencarian.strPencKerapatanLayar).append("&lay_touchscreen_status=").append(Hal1Pencarian.strPencLayarSentuh).append("&lay_touchscreen=").append(Hal1Pencarian.strPencJenisSentuh).append("&kam_utama=").append(Hal1Pencarian.strPencKamera).append("&kam_depan_status=").append(Hal1Pencarian.strPencKameraDepan).append("&kam_led_flash_status=").append(Hal1Pencarian.strPencLampu).append("&kam_video=").append(Hal1Pencarian.strPencVideoRecorder).append("&kon_bluetooth_status=").append(Hal1Pencarian.strPencBluetooth).append("&kon_usb_status=").append(Hal1Pencarian.strPencUSB).append("&kon_35mm_jack=").append(Hal1Pencarian.strPenc35).append("&kon_wlan_status=").append(Hal1Pencarian.strPencWiFi).append("&kon_nfc_status=").append(Hal1Pencarian.strPencNFC).append("&kon_hdmi_status=").append(Hal1Pencarian.strPencHDMI).append("&kon_tvoutput_status=").append(Hal1Pencarian.strPencTVOut).append("&kon_infrared=").append(Hal1Pencarian.strPencInfrared).append("&fit_musik_status=").append(Hal1Pencarian.strPencMusik).append("&fit_radio_status=").append(Hal1Pencarian.strPencRadio).append("&fit_tvanalog=").append(Hal1Pencarian.strPencTVAnalog).append("&fit_gps_status=").append(Hal1Pencarian.strPencGPS).append("&bat_kapasitas=").append(Hal1Pencarian.strPencBaterai).toString();
        view = ((BasePencarianActivity)getActivity()).getHal2HasilPenc();
        ((Hal2HasilPencarian)getActivity().getSupportFragmentManager().findFragmentByTag(view)).StatistikTask();
        BasePencarianActivity.mPager.setCurrentItem(1, true);
    }

    n()
    {
        this$0 = Hal1Pencarian.this;
        super();
    }
}
