// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.inponsel.android.favorit.FavoritArtikelBerita;
import com.inponsel.android.favorit.FavoritPonselMerek;
import com.inponsel.android.favorit.LanggananBeritaAll;
import com.inponsel.android.globalforum.ForumGlobalActivity;
import com.inponsel.android.statistik.StatistikPonsel;
import com.inponsel.android.tlforum.InteraksiForumHP;
import com.readystatesoftware.systembartint.SystemBarTintManager;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity, HomeSelengkapActivity, PonselRekomendasiActivity, HomeNewsActivity, 
//            SCMerkActivity, SCUserActivity, ProfileActivity, InboxMessageActivity, 
//            RoomGroupChatListActivity

public class HomeNewV4Activity extends SherlockFragmentActivity
    implements android.view.View.OnClickListener
{

    ActionBar actionBar;
    int actionBarTitleId;
    private ImageButton btnCari;
    private Button btnHpDigunakan;
    private Button btnHpDigunakan2;
    private Button btnRangeHarga;
    private ImageButton btnRangeHargaSearch;
    private EditText edtHarga;
    private Button edtOS;
    Intent i;
    private ImageView imgBaruDirilis;
    private ImageView imgBerita;
    private ImageView imgBerlangganan;
    private ImageView imgBrand;
    private ImageView imgCariManual;
    private ImageView imgChatroom;
    private ImageView imgFavorit;
    private ImageView imgForum;
    private ImageView imgForumFollow;
    private ImageView imgForumMyHP;
    private ImageView imgGadget;
    private ImageView imgInbox;
    private ImageView imgMyHP;
    private ImageView imgMySimCard;
    private ImageView imgNewsFavorit;
    private ImageView imgPendatangBaru;
    private ImageView imgPilihKategori;
    private ImageView imgPopuler;
    private ImageView imgPosting;
    private ImageView imgRekomendasi;
    private ImageView imgRumor;
    private ImageView imgSCProv;
    private ImageView imgSegeraHadir;
    private ImageView imgServiceCenter;
    private ImageView imgTerbaru;
    private ImageView imgTerkomentari;
    private ImageView imgTerpopuler;
    private ImageView imgTimeline;
    private ImageView imgUsername;
    private LinearLayout llHomeForum;
    private LinearLayout llHomeGadget;
    private LinearLayout llHomeInteraksi;
    private LinearLayout llHomeNews;
    private RelativeLayout menuBaruDirilis;
    private RelativeLayout menuBerita;
    private RelativeLayout menuBerlangganan;
    private RelativeLayout menuBrand;
    private RelativeLayout menuCariManual;
    private RelativeLayout menuChatroom;
    private RelativeLayout menuFavorit;
    private RelativeLayout menuForum;
    private RelativeLayout menuForumFollow;
    private RelativeLayout menuForumMyHP;
    private RelativeLayout menuGadget;
    private RelativeLayout menuInbox;
    private RelativeLayout menuMyHP;
    private RelativeLayout menuMySimCard;
    private RelativeLayout menuNewsFavorit;
    private RelativeLayout menuPendatangBaru;
    private RelativeLayout menuPilihKategori;
    private RelativeLayout menuPopuler;
    private RelativeLayout menuPosting;
    private RelativeLayout menuRekomendasi;
    private RelativeLayout menuRumor;
    private RelativeLayout menuSCProv;
    private RelativeLayout menuSegeraHadir;
    private RelativeLayout menuServiceCenter;
    private RelativeLayout menuTerbaru;
    private RelativeLayout menuTerkomentari;
    private RelativeLayout menuTerpopuler;
    private RelativeLayout menuTimeline;
    private RelativeLayout menuUsername;
    private RadioButton rbPonsel;
    private RadioButton rbPonselTablet;
    private RadioButton rbTablet;
    private RadioGroup rgDevices;
    private LinearLayout tabHarga;
    private TextView txtHomeCountInbox;
    private TextView txtPencarianHarga;
    private boolean useLogo;

    public HomeNewV4Activity()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
    }

    private void setTranslucentStatus(boolean flag)
    {
        Window window = getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        if (flag)
        {
            layoutparams.flags = layoutparams.flags | 0x4000000;
        } else
        {
            layoutparams.flags = layoutparams.flags & 0xfbffffff;
        }
        window.setAttributes(layoutparams);
    }

    public void onClick(View view)
    {
        if (view != rbPonselTablet && view != rbPonsel && view != rbTablet && view != edtOS && view != btnCari && view != btnRangeHarga && view != btnRangeHargaSearch && view != btnHpDigunakan && view != btnHpDigunakan2)
        {
            if (view == menuGadget)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            } else
            {
                if (view == menuPendatangBaru)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                    i.putExtra("status", "pendatang");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuBaruDirilis)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                    i.putExtra("status", "rilis");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuSegeraHadir)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                    i.putExtra("status", "segera");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuPopuler)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/statistik/StatistikPonsel);
                    i.putExtra("pager_pos", "0");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuRumor)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                    i.putExtra("status", "rumor");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuRekomendasi)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/PonselRekomendasiActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuFavorit)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritPonselMerek);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuBrand)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view == menuBerita)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                    i.putExtra("tag_timeline", "terbaru");
                    i.putExtra("tag_code", "tagall");
                    i.putExtra("tag_page", "1");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view != menuPilihKategori)
                {
                    if (view == menuTerbaru)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                        i.putExtra("tag_timeline", "terbaru");
                        i.putExtra("tag_code", "tagall");
                        i.putExtra("tag_page", "1");
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuTerpopuler)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                        i.putExtra("tag_timeline", "terpopuler");
                        i.putExtra("tag_code", "Terpopuler");
                        i.putExtra("tag_page", "1");
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuTerkomentari)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                        i.putExtra("tag_timeline", "terkomentari");
                        i.putExtra("tag_code", "Terkomentari");
                        i.putExtra("tag_page", "1");
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuBerlangganan)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/LanggananBeritaAll);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuNewsFavorit)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritArtikelBerita);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuServiceCenter)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMerkActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuSCProv)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/SCUserActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuCariManual)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/SCUserActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuForum)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/globalforum/ForumGlobalActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view == menuTimeline)
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/globalforum/ForumGlobalActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (view != menuPosting && view != menuForumMyHP && view != menuForumFollow)
                    {
                        if (view == menuUsername)
                        {
                            i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                            startActivityForResult(i, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            return;
                        }
                        if (view == menuInbox)
                        {
                            i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                            startActivityForResult(i, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            return;
                        }
                        if (view == menuChatroom)
                        {
                            i = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomGroupChatListActivity);
                            startActivityForResult(i, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            return;
                        }
                        if (view != menuMyHP && view != menuMySimCard)
                        {
                            if (view == llHomeGadget)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                return;
                            }
                            if (view == llHomeNews)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                                i.putExtra("tag_timeline", "terbaru");
                                i.putExtra("tag_code", "tagall");
                                i.putExtra("tag_page", "1");
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                return;
                            }
                            if (view == llHomeForum)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/globalforum/ForumGlobalActivity);
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                return;
                            }
                            if (view == llHomeInteraksi)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/tlforum/InteraksiForumHP);
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030147);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        (new SystemBarTintManager(this)).setStatusBarTintEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        int k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        llHomeGadget = (LinearLayout)findViewById(0x7f0b00f2);
        txtHomeCountInbox = (TextView)findViewById(0x7f0b00f3);
        llHomeNews = (LinearLayout)findViewById(0x7f0b00f4);
        llHomeForum = (LinearLayout)findViewById(0x7f0b00f5);
        llHomeInteraksi = (LinearLayout)findViewById(0x7f0b00f6);
        rgDevices = (RadioGroup)findViewById(0x7f0b00dd);
        rbPonselTablet = (RadioButton)findViewById(0x7f0b00de);
        rbPonsel = (RadioButton)findViewById(0x7f0b00df);
        rbTablet = (RadioButton)findViewById(0x7f0b00e0);
        edtOS = (Button)findViewById(0x7f0b00e1);
        tabHarga = (LinearLayout)findViewById(0x7f0b00e2);
        edtHarga = (EditText)findViewById(0x7f0b00e4);
        btnCari = (ImageButton)findViewById(0x7f0b00e5);
        btnRangeHarga = (Button)findViewById(0x7f0b00e3);
        btnRangeHargaSearch = (ImageButton)findViewById(0x7f0b00e6);
        txtPencarianHarga = (TextView)findViewById(0x7f0b00e7);
        btnHpDigunakan = (Button)findViewById(0x7f0b00cd);
        btnHpDigunakan2 = (Button)findViewById(0x7f0b00ce);
        menuGadget = (RelativeLayout)findViewById(0x7f0b00f7);
        imgGadget = (ImageView)findViewById(0x7f0b00f8);
        menuPendatangBaru = (RelativeLayout)findViewById(0x7f0b00f9);
        imgPendatangBaru = (ImageView)findViewById(0x7f0b00fa);
        menuBaruDirilis = (RelativeLayout)findViewById(0x7f0b00fb);
        imgBaruDirilis = (ImageView)findViewById(0x7f0b00fc);
        menuSegeraHadir = (RelativeLayout)findViewById(0x7f0b00fd);
        imgSegeraHadir = (ImageView)findViewById(0x7f0b00fe);
        menuPopuler = (RelativeLayout)findViewById(0x7f0b00ff);
        imgPopuler = (ImageView)findViewById(0x7f0b0100);
        menuRumor = (RelativeLayout)findViewById(0x7f0b0101);
        imgRumor = (ImageView)findViewById(0x7f0b0102);
        menuRekomendasi = (RelativeLayout)findViewById(0x7f0b0103);
        imgRekomendasi = (ImageView)findViewById(0x7f0b0104);
        menuFavorit = (RelativeLayout)findViewById(0x7f0b0105);
        imgFavorit = (ImageView)findViewById(0x7f0b0106);
        menuBrand = (RelativeLayout)findViewById(0x7f0b0107);
        imgBrand = (ImageView)findViewById(0x7f0b0108);
        menuBerita = (RelativeLayout)findViewById(0x7f0b00cf);
        imgBerita = (ImageView)findViewById(0x7f0b00d0);
        menuPilihKategori = (RelativeLayout)findViewById(0x7f0b00d1);
        imgPilihKategori = (ImageView)findViewById(0x7f0b00d2);
        menuTerbaru = (RelativeLayout)findViewById(0x7f0b00d3);
        imgTerbaru = (ImageView)findViewById(0x7f0b00d4);
        menuTerpopuler = (RelativeLayout)findViewById(0x7f0b00d5);
        imgTerpopuler = (ImageView)findViewById(0x7f0b00d6);
        menuTerkomentari = (RelativeLayout)findViewById(0x7f0b00d7);
        imgTerkomentari = (ImageView)findViewById(0x7f0b00d8);
        menuBerlangganan = (RelativeLayout)findViewById(0x7f0b00d9);
        imgBerlangganan = (ImageView)findViewById(0x7f0b00da);
        menuNewsFavorit = (RelativeLayout)findViewById(0x7f0b00db);
        imgNewsFavorit = (ImageView)findViewById(0x7f0b00dc);
        menuForum = (RelativeLayout)findViewById(0x7f0b00e8);
        imgForum = (ImageView)findViewById(0x7f0b00e9);
        menuTimeline = (RelativeLayout)findViewById(0x7f0b00ea);
        imgTimeline = (ImageView)findViewById(0x7f0b00eb);
        menuPosting = (RelativeLayout)findViewById(0x7f0b00ec);
        imgPosting = (ImageView)findViewById(0x7f0b00ed);
        menuForumMyHP = (RelativeLayout)findViewById(0x7f0b00ee);
        imgForumMyHP = (ImageView)findViewById(0x7f0b00ef);
        menuForumFollow = (RelativeLayout)findViewById(0x7f0b00f0);
        imgForumFollow = (ImageView)findViewById(0x7f0b00f1);
        menuServiceCenter = (RelativeLayout)findViewById(0x7f0b0113);
        imgServiceCenter = (ImageView)findViewById(0x7f0b0114);
        menuSCProv = (RelativeLayout)findViewById(0x7f0b0115);
        imgSCProv = (ImageView)findViewById(0x7f0b0116);
        menuCariManual = (RelativeLayout)findViewById(0x7f0b0117);
        imgCariManual = (ImageView)findViewById(0x7f0b0118);
        menuUsername = (RelativeLayout)findViewById(0x7f0b0109);
        imgUsername = (ImageView)findViewById(0x7f0b010a);
        menuInbox = (RelativeLayout)findViewById(0x7f0b010b);
        imgInbox = (ImageView)findViewById(0x7f0b010c);
        menuChatroom = (RelativeLayout)findViewById(0x7f0b010d);
        imgChatroom = (ImageView)findViewById(0x7f0b010e);
        menuMyHP = (RelativeLayout)findViewById(0x7f0b010f);
        imgMyHP = (ImageView)findViewById(0x7f0b0110);
        menuMySimCard = (RelativeLayout)findViewById(0x7f0b0111);
        imgMySimCard = (ImageView)findViewById(0x7f0b0112);
        btnHpDigunakan.setOnClickListener(this);
        btnHpDigunakan2.setOnClickListener(this);
        rbPonselTablet.setOnClickListener(this);
        rbPonsel.setOnClickListener(this);
        rbTablet.setOnClickListener(this);
        edtOS.setOnClickListener(this);
        btnCari.setOnClickListener(this);
        btnRangeHarga.setOnClickListener(this);
        btnRangeHargaSearch.setOnClickListener(this);
        menuGadget.setOnClickListener(this);
        menuPendatangBaru.setOnClickListener(this);
        menuBaruDirilis.setOnClickListener(this);
        menuSegeraHadir.setOnClickListener(this);
        menuPopuler.setOnClickListener(this);
        menuRumor.setOnClickListener(this);
        menuRekomendasi.setOnClickListener(this);
        menuFavorit.setOnClickListener(this);
        menuBrand.setOnClickListener(this);
        menuBerita.setOnClickListener(this);
        menuTerbaru.setOnClickListener(this);
        menuTerpopuler.setOnClickListener(this);
        menuTerkomentari.setOnClickListener(this);
        menuBerlangganan.setOnClickListener(this);
        menuNewsFavorit.setOnClickListener(this);
        menuServiceCenter.setOnClickListener(this);
        menuSCProv.setOnClickListener(this);
        menuCariManual.setOnClickListener(this);
        menuForum.setOnClickListener(this);
        menuTimeline.setOnClickListener(this);
        menuUsername.setOnClickListener(this);
        menuInbox.setOnClickListener(this);
        menuChatroom.setOnClickListener(this);
        llHomeGadget.setOnClickListener(this);
        llHomeNews.setOnClickListener(this);
        llHomeForum.setOnClickListener(this);
        llHomeInteraksi.setOnClickListener(this);
    }
}
