// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

public class this._cls0 extends AsyncTask
{

    final HomeNewsActivity this$0;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusSubsNews = s.getString("success");
            postMessageSubsNews = s.getString("message");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = (new StringBuilder("idhp=")).append(id_subs).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&type=").append(type).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
            avoid = s.toString();
            Log.e("url ", avoid);
            parseJSONSubsNews(avoid);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
label0:
        {
label1:
            {
                {
                    super.onPostExecute(void1);
                    if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10"))
                    {
                        break label0;
                    }
                    Toast.makeText(HomeNewsActivity.this, postMessageSubsNews, 1).show();
                    if (!type.equals("os") || !type_tag.toLowerCase().equals("android"))
                    {
                        break label1;
                    }
                    if (str_LangganAndroid.equals("1"))
                    {
                        str_LangganAndroid = "1";
                        btn_LangganAndroid.setText("Hapus");
                        btn_LangganAndroid.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganAndroid.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
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
                        catch (Void void1) { }
                    }
                }
                mDialog.dismiss();
                return;
            }
            if (type.equals("os") && type_tag.toLowerCase().equals("blackberry"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("os") && type_tag.toLowerCase().equals("ios"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("os") && type_tag.toLowerCase().equals("windowsphone"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("os") && type_tag.toLowerCase().equals("platformlain"))
            {
                if (str_LangganPlatformLain.equals("1"))
                {
                    str_LangganPlatformLain = "1";
                    btn_LangganPlatformLain.setText("Hapus");
                    btn_LangganPlatformLain.setBackgroundResource(0x7f020137);
                    try
                    {
                        void1 = getResources().getXml(0x7f080197);
                        void1 = ColorStateList.createFromXml(getResources(), void1);
                        btn_LangganPlatformLain.setTextColor(void1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1) { }
                } else
                {
                    str_LangganPlatformLain = "0";
                    btn_LangganPlatformLain.setText("Langganan");
                    btn_LangganPlatformLain.setBackgroundResource(0x7f02013a);
                    try
                    {
                        void1 = getResources().getXml(0x7f080194);
                        void1 = ColorStateList.createFromXml(getResources(), void1);
                        btn_LangganPlatformLain.setTextColor(void1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("telkomsel"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("xl"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("indosat"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("tri"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("axis"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("smartfren"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("ceria"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("esia"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("op") && type_tag.toLowerCase().equals("telkom"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("appgame"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("permainan"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("tipstrik"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("inetsocmed"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("firmware"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("gadget"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("ecommerce"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("teknoscience"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("bisniscorporate"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("pemerintah"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("gayahidup"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("tokomstartup"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("komunitas"))
            {
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
                    catch (Void void1) { }
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
                    catch (Void void1) { }
                }
            } else
            if (type.equals("general") && type_tag.toLowerCase().equals("start_up"))
            {
                if (str_LangganStartup.equals("1"))
                {
                    str_LangganStartup = "1";
                    btn_LangganStartup.setText("Hapus");
                    btn_LangganStartup.setBackgroundResource(0x7f02013a);
                    try
                    {
                        btn_LangganStartup.setTextColor(colorsHapus);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1) { }
                } else
                {
                    str_LangganStartup = "0";
                    btn_LangganStartup.setText("Langganan");
                    btn_LangganStartup.setBackgroundResource(0x7f020137);
                    try
                    {
                        btn_LangganStartup.setTextColor(colorsIkuti);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1) { }
                }
            }
            if (true)
            {
                break MISSING_BLOCK_LABEL_151;
            }
        }
        if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
        {
            Toast.makeText(HomeNewsActivity.this, postMessageSubsNews, 1).show();
            statSubNews.equals("1");
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("40404"))
        {
            mDialog.dismiss();
            return;
        } else
        {
            Toast.makeText(HomeNewsActivity.this, postMessageSubsNews, 1).show();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statSubNews.equals("1"))
        {
            mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
