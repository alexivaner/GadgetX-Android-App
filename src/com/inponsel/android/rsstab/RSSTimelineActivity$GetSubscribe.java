// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

private class <init> extends AsyncTask
{

    final RSSTimelineActivity this$0;

    private void setButtonConfig()
    {
        if (str_LangganAndroid.equals("1"))
        {
            str_LangganAndroid = "1";
            btn_LangganAndroid.setText("Hapus");
            btn_LangganAndroid.setBackgroundResource(0x7f02013a);
            Exception exception;
            try
            {
                btn_LangganAndroid.setTextColor(colorsHapus);
            }
            catch (Exception exception1) { }
        } else
        {
            str_LangganAndroid = "0";
            btn_LangganAndroid.setText("Langganan");
            btn_LangganAndroid.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganAndroid.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganBlackBerry.equals("1"))
        {
            str_LangganBlackBerry = "1";
            btn_LangganBlackBerry.setText("Hapus");
            btn_LangganBlackBerry.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganBlackBerry.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganBlackBerry = "0";
            btn_LangganBlackBerry.setText("Langganan");
            btn_LangganBlackBerry.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganBlackBerry.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganIOS.equals("1"))
        {
            str_LangganIOS = "1";
            btn_LangganIOS.setText("Hapus");
            btn_LangganIOS.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganIOS.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganIOS = "0";
            btn_LangganIOS.setText("Langganan");
            btn_LangganIOS.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganIOS.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganWindowsPhone.equals("1"))
        {
            str_LangganWindowsPhone = "1";
            btn_LangganWindowsPhone.setText("Hapus");
            btn_LangganWindowsPhone.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganWindowsPhone.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganWindowsPhone = "0";
            btn_LangganWindowsPhone.setText("Langganan");
            btn_LangganWindowsPhone.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganWindowsPhone.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganTelkomsel.equals("1"))
        {
            str_LangganTelkomsel = "1";
            btn_LangganTelkomsel.setText("Hapus");
            btn_LangganTelkomsel.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganTelkomsel.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganTelkomsel = "0";
            btn_LangganTelkomsel.setText("Langganan");
            btn_LangganTelkomsel.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganTelkomsel.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganXL.equals("1"))
        {
            str_LangganXL = "1";
            btn_LangganXL.setText("Hapus");
            btn_LangganXL.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganXL.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganXL = "0";
            btn_LangganXL.setText("Langganan");
            btn_LangganXL.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganXL.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganIndosat.equals("1"))
        {
            str_LangganIndosat = "1";
            btn_LangganIndosat.setText("Hapus");
            btn_LangganIndosat.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganIndosat.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganIndosat = "0";
            btn_LangganIndosat.setText("Langganan");
            btn_LangganIndosat.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganIndosat.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganTri.equals("1"))
        {
            str_LangganTri = "1";
            btn_LangganTri.setText("Hapus");
            btn_LangganTri.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganTri.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganTri = "0";
            btn_LangganTri.setText("Langganan");
            btn_LangganTri.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganTri.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganAxis.equals("1"))
        {
            str_LangganAxis = "1";
            btn_LangganAxis.setText("Hapus");
            btn_LangganAxis.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganAxis.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganAxis = "0";
            btn_LangganAxis.setText("Langganan");
            btn_LangganAxis.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganAxis.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganSmartfren.equals("1"))
        {
            str_LangganSmartfren = "1";
            btn_LangganSmartfren.setText("Hapus");
            btn_LangganSmartfren.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganSmartfren.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganSmartfren = "0";
            btn_LangganSmartfren.setText("Langganan");
            btn_LangganSmartfren.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganSmartfren.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganCeria.equals("1"))
        {
            str_LangganCeria = "1";
            btn_LangganCeria.setText("Hapus");
            btn_LangganCeria.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganCeria.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganCeria = "0";
            btn_LangganCeria.setText("Langganan");
            btn_LangganCeria.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganCeria.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganEsia.equals("1"))
        {
            str_LangganEsia = "1";
            btn_LangganEsia.setText("Hapus");
            btn_LangganEsia.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganEsia.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganEsia = "0";
            btn_LangganEsia.setText("Langganan");
            btn_LangganEsia.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganEsia.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganTelkom.equals("1"))
        {
            str_LangganTelkom = "1";
            btn_LangganTelkom.setText("Hapus");
            btn_LangganTelkom.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganTelkom.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganTelkom = "0";
            btn_LangganTelkom.setText("Langganan");
            btn_LangganTelkom.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganTelkom.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganAplikasi.equals("1"))
        {
            str_LangganAplikasi = "1";
            btn_LangganAplikasi.setText("Hapus");
            btn_LangganAplikasi.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganAplikasi.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganAplikasi = "0";
            btn_LangganAplikasi.setText("Langganan");
            btn_LangganAplikasi.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganAplikasi.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganGame.equals("1"))
        {
            str_LangganGame = "1";
            btn_LangganGame.setText("Hapus");
            btn_LangganGame.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganGame.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganGame = "0";
            btn_LangganGame.setText("Langganan");
            btn_LangganGame.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganGame.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganTips.equals("1"))
        {
            str_LangganTips = "1";
            btn_LangganTips.setText("Hapus");
            btn_LangganTips.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganTips.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganTips = "0";
            btn_LangganTips.setText("Langganan");
            btn_LangganTips.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganTips.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganInternet.equals("1"))
        {
            str_LangganInternet = "1";
            btn_LangganInternet.setText("Hapus");
            btn_LangganInternet.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganInternet.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganInternet = "0";
            btn_LangganInternet.setText("Langganan");
            btn_LangganInternet.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganInternet.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganFirmware.equals("1"))
        {
            str_LangganFirmware = "1";
            btn_LangganFirmware.setText("Hapus");
            btn_LangganFirmware.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganFirmware.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganFirmware = "0";
            btn_LangganFirmware.setText("Langganan");
            btn_LangganFirmware.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganFirmware.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganGadget.equals("1"))
        {
            str_LangganGadget = "1";
            btn_LangganGadget.setText("Hapus");
            btn_LangganGadget.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganGadget.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganGadget = "0";
            btn_LangganGadget.setText("Langganan");
            btn_LangganGadget.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganGadget.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganECommerce.equals("1"))
        {
            str_LangganECommerce = "1";
            btn_LangganECommerce.setText("Hapus");
            btn_LangganECommerce.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganECommerce.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganECommerce = "0";
            btn_LangganECommerce.setText("Langganan");
            btn_LangganECommerce.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganECommerce.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganTeknologi.equals("1"))
        {
            str_LangganTeknologi = "1";
            btn_LangganTeknologi.setText("Hapus");
            btn_LangganTeknologi.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganTeknologi.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganTeknologi = "0";
            btn_LangganTeknologi.setText("Langganan");
            btn_LangganTeknologi.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganTeknologi.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganBisnis.equals("1"))
        {
            str_LangganBisnis = "1";
            btn_LangganBisnis.setText("Hapus");
            btn_LangganBisnis.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganBisnis.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganBisnis = "0";
            btn_LangganBisnis.setText("Langganan");
            btn_LangganBisnis.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganBisnis.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganPemerintah.equals("1"))
        {
            str_LangganPemerintah = "1";
            btn_LangganPemerintah.setText("Hapus");
            btn_LangganPemerintah.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganPemerintah.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganPemerintah = "0";
            btn_LangganPemerintah.setText("Langganan");
            btn_LangganPemerintah.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganPemerintah.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganGayaHidup.equals("1"))
        {
            str_LangganGayaHidup = "1";
            btn_LangganGayaHidup.setText("Hapus");
            btn_LangganGayaHidup.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganGayaHidup.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganGayaHidup = "0";
            btn_LangganGayaHidup.setText("Langganan");
            btn_LangganGayaHidup.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganGayaHidup.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganTokoh.equals("1"))
        {
            str_LangganTokoh = "1";
            btn_LangganTokoh.setText("Hapus");
            btn_LangganTokoh.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganTokoh.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganTokoh = "0";
            btn_LangganTokoh.setText("Langganan");
            btn_LangganTokoh.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganTokoh.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganKomunitas.equals("1"))
        {
            str_LangganKomunitas = "1";
            btn_LangganKomunitas.setText("Hapus");
            btn_LangganKomunitas.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganKomunitas.setTextColor(colorsHapus);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        } else
        {
            str_LangganKomunitas = "0";
            btn_LangganKomunitas.setText("Langganan");
            btn_LangganKomunitas.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganKomunitas.setTextColor(colorsIkuti);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (str_LangganStartup.equals("1"))
        {
            str_LangganStartup = "1";
            btn_LangganStartup.setText("Hapus");
            btn_LangganStartup.setBackgroundResource(0x7f02013a);
            try
            {
                btn_LangganStartup.setTextColor(colorsHapus);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                return;
            }
        }
        str_LangganStartup = "0";
        btn_LangganStartup.setText("Langganan");
        btn_LangganStartup.setBackgroundResource(0x7f020137);
        try
        {
            btn_LangganStartup.setTextColor(colorsIkuti);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return;
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = (new ServiceHandler()).makeServiceCall(dataSubscribe, 1);
        Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
        if (avoid == null) goto _L2; else goto _L1
_L1:
        avoid = new JSONObject(avoid);
        inponsel = avoid.getJSONArray("InPonsel");
        success = avoid.getString("success");
        stat = avoid.getString("stat");
        Log.e("success", success);
        if (!success.equals("1")) goto _L4; else goto _L3
_L3:
        int i = 0;
_L60:
        if (i < inponsel.length()) goto _L5; else goto _L4
_L5:
        avoid = inponsel.getJSONObject(i);
        if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("2")) goto _L7; else goto _L6
_L6:
        str_LangganAndroid = avoid.getString("status");
          goto _L8
_L7:
        if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("4")) goto _L10; else goto _L9
_L9:
        str_LangganBlackBerry = avoid.getString("status");
          goto _L8
        avoid;
        avoid.printStackTrace();
          goto _L4
_L10:
        if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("5")) goto _L12; else goto _L11
_L11:
        str_LangganIOS = avoid.getString("status");
          goto _L8
        avoid;
        avoid.printStackTrace();
          goto _L4
_L12:
        if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("14")) goto _L14; else goto _L13
_L13:
        str_LangganWindowsPhone = avoid.getString("status");
          goto _L8
_L14:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("1")) goto _L16; else goto _L15
_L15:
        str_LangganAxis = avoid.getString("status");
          goto _L8
_L16:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("2")) goto _L18; else goto _L17
_L17:
        str_LangganEsia = avoid.getString("status");
          goto _L8
_L18:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("3")) goto _L20; else goto _L19
_L19:
        str_LangganCeria = avoid.getString("status");
          goto _L8
_L20:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("4")) goto _L22; else goto _L21
_L21:
        str_LangganIndosat = avoid.getString("status");
          goto _L8
_L22:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("5")) goto _L24; else goto _L23
_L23:
        str_LangganSmartfren = avoid.getString("status");
          goto _L8
_L24:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("6")) goto _L26; else goto _L25
_L25:
        str_LangganTelkom = avoid.getString("status");
          goto _L8
_L26:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("7")) goto _L28; else goto _L27
_L27:
        str_LangganTelkomsel = avoid.getString("status");
          goto _L8
_L28:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("8")) goto _L30; else goto _L29
_L29:
        str_LangganTri = avoid.getString("status");
          goto _L8
_L30:
        if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("9")) goto _L32; else goto _L31
_L31:
        str_LangganXL = avoid.getString("status");
          goto _L8
_L32:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("teknoscience")) goto _L34; else goto _L33
_L33:
        str_LangganTeknologi = avoid.getString("status");
          goto _L8
_L34:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("inetsocmed")) goto _L36; else goto _L35
_L35:
        str_LangganInternet = avoid.getString("status");
          goto _L8
_L36:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("appgame")) goto _L38; else goto _L37
_L37:
        str_LangganAplikasi = avoid.getString("status");
          goto _L8
_L38:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("permainan")) goto _L40; else goto _L39
_L39:
        str_LangganGame = avoid.getString("status");
          goto _L8
_L40:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("firmware")) goto _L42; else goto _L41
_L41:
        str_LangganFirmware = avoid.getString("status");
          goto _L8
_L42:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("bisniscorporate")) goto _L44; else goto _L43
_L43:
        str_LangganBisnis = avoid.getString("status");
          goto _L8
_L44:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("pemerintah")) goto _L46; else goto _L45
_L45:
        str_LangganPemerintah = avoid.getString("status");
          goto _L8
_L46:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("gayahidup")) goto _L48; else goto _L47
_L47:
        str_LangganGayaHidup = avoid.getString("status");
          goto _L8
_L48:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("ecommerce")) goto _L50; else goto _L49
_L49:
        str_LangganECommerce = avoid.getString("status");
          goto _L8
_L50:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("gadget")) goto _L52; else goto _L51
_L51:
        str_LangganGadget = avoid.getString("status");
          goto _L8
_L52:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("tipstrik")) goto _L54; else goto _L53
_L53:
        str_LangganTips = avoid.getString("status");
          goto _L8
_L54:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("tokomstartup")) goto _L56; else goto _L55
_L55:
        str_LangganTokoh = avoid.getString("status");
          goto _L8
_L56:
        if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("komunitas")) goto _L58; else goto _L57
_L57:
        str_LangganKomunitas = avoid.getString("status");
          goto _L8
_L58:
        if (avoid.getString("type").equals("general") && avoid.getString("id_subs").equals("start_up"))
        {
            str_LangganStartup = avoid.getString("status");
        }
          goto _L8
_L2:
        Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
_L4:
        return null;
_L8:
        i++;
        if (true) goto _L60; else goto _L59
_L59:
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
            setButtonConfig();
            slidingView.findViewById(0x7f0b05db).setVisibility(4);
            btn_LangganAndroid.setVisibility(0);
            btn_LangganBlackBerry.setVisibility(0);
            btn_LangganIOS.setVisibility(0);
            btn_LangganWindowsPhone.setVisibility(0);
            btn_LangganPlatformLain.setVisibility(4);
            btn_LangganTelkomsel.setVisibility(0);
            btn_LangganXL.setVisibility(0);
            btn_LangganIndosat.setVisibility(0);
            btn_LangganTri.setVisibility(0);
            btn_LangganAxis.setVisibility(0);
            btn_LangganSmartfren.setVisibility(0);
            btn_LangganCeria.setVisibility(0);
            btn_LangganEsia.setVisibility(0);
            btn_LangganTelkom.setVisibility(0);
            btn_LangganAplikasi.setVisibility(0);
            btn_LangganGame.setVisibility(0);
            btn_LangganTips.setVisibility(0);
            btn_LangganInternet.setVisibility(0);
            btn_LangganFirmware.setVisibility(0);
            btn_LangganGadget.setVisibility(0);
            btn_LangganECommerce.setVisibility(0);
            btn_LangganTeknologi.setVisibility(0);
            btn_LangganBisnis.setVisibility(0);
            btn_LangganPemerintah.setVisibility(0);
            btn_LangganGayaHidup.setVisibility(0);
            btn_LangganTokoh.setVisibility(0);
            btn_LangganKomunitas.setVisibility(0);
            btn_LangganStartup.setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        slidingView.findViewById(0x7f0b05db).setVisibility(0);
        btn_LangganAndroid.setVisibility(8);
        btn_LangganBlackBerry.setVisibility(8);
        btn_LangganIOS.setVisibility(8);
        btn_LangganWindowsPhone.setVisibility(8);
        btn_LangganPlatformLain.setVisibility(8);
        btn_LangganTelkomsel.setVisibility(8);
        btn_LangganXL.setVisibility(8);
        btn_LangganIndosat.setVisibility(8);
        btn_LangganTri.setVisibility(8);
        btn_LangganAxis.setVisibility(8);
        btn_LangganSmartfren.setVisibility(8);
        btn_LangganCeria.setVisibility(8);
        btn_LangganEsia.setVisibility(8);
        btn_LangganTelkom.setVisibility(8);
        btn_LangganAplikasi.setVisibility(8);
        btn_LangganGame.setVisibility(8);
        btn_LangganTips.setVisibility(8);
        btn_LangganInternet.setVisibility(8);
        btn_LangganFirmware.setVisibility(8);
        btn_LangganGadget.setVisibility(8);
        btn_LangganECommerce.setVisibility(8);
        btn_LangganTeknologi.setVisibility(8);
        btn_LangganBisnis.setVisibility(8);
        btn_LangganPemerintah.setVisibility(8);
        btn_LangganGayaHidup.setVisibility(8);
        btn_LangganTokoh.setVisibility(8);
        btn_LangganKomunitas.setVisibility(8);
        btn_LangganStartup.setVisibility(8);
    }

    private ()
    {
        this$0 = RSSTimelineActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
