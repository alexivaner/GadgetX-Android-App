// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

public class KebijakanActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{

    String faq;
    String faq1;
    Intent i;
    PonselBaseApp ponselBaseApp;
    TextView txt_keb;
    WebView webKeb;

    public KebijakanActivity()
    {
        faq = "";
        faq1 = "<p><strong>Kebijakan Privasi</strong></p><p>Kebijakan Privasi ini menjelaskan kebijakan penanganan data-data pribadi pengguna pada layanan INPONSEL. Maka, mohon meluangkan waktu untuk membaca perjanjian ini.</p><p>Dengan mengakses INPONSEL, berarti Anda menyetujui untuk menerima syarat dan kondisi dari Kebijakan Privasi ini dan menyadari bahwa kebijakan kami dapat berkembang/ berubah di masa mendatang seperti yang diindikasikan di bawah ini.<br />&nbsp;</p><p><strong>Apa yang kami kumpulkan</strong></p><p>Kami mengumpulkan informasi identifikasi seperti nama, alamat email, jenis kelamin, tanggal lahir, alamat tempat tinggal, jenis perangkat yang dipakai, SIM card &nbsp;yang digunakan, ataupun informasi lain yang dapat digunakan untuk menghubungi atau mengidentifikasi Anda sebagai individu.</p><p>Dari waktu ke waktu di masa mendatang, kami mungkin menawarkan fitur tambahan, layanan, dan kesempatan promosi yang akan memerlukan kerjasama Anda untuk mengirimkan informasi identifikasi individu untuk berpartisipasi. Kami juga mengumpulkan informasi anonim, seperti alamat IP (Internet Protocol), jenis perangkat yang dipakai, dan iklan yang telah Anda klik. Informasi pribadi Anda terhubung dengan informasi anonim Anda.<br /><br />Seperti situs/ aplikasi internet pada umumnya, kami juga menggunakan &quot;cookies&quot; untuk mengumpulkan informasi. Cookies adalah file data kecil yang kami transfer ke komputer Anda dan tersimpan pada hard drive Anda. Ketika Anda mengunjungi situs/ aplikasi kami, cookies mengidentifikasi perangkat Anda kepada kami sehingga Anda tidak perlu mendaftar ulang setiap kali Anda berkunjung. Kami juga dapat menggunakan cookies untuk menghitung traffic ke situs kami dan menghitung penggunaan layanan dan fitur yang berbeda dari situs.</p><p>Pemasang iklan yang muncul di INPONSEL dapat menempatkan cookies di komputer Anda dan pemakaian informasi yang tersimpan pada cookies tersebut merupakan kebijakan privasi mereka sendiri. Anda harus mengunjungi situs mereka untuk mempelajari tentang kebijakan pemakaian informasi mereka. Pemasang iklan atau perusahaan lain tidak memiliki akses ke cookies di INPONSEL.<br /&nbsp;</p><p><strong>Bagaimana kami menggunakan informasi yang kami kumpulkan</strong></p><p>Kami menggunakan informasi pribadi yang Anda berikan untuk berkomunikasi dengan Anda, untuk menyesuaikan iklan dan materi yang tersedia di INPONSEL, untuk mengadakan penelitian untuk kepentingan internal, dan menggunakan informasi tersebut untuk meningkatkan layanan kami dan INPONSEL. Dengan mendaftarkan diri dan mengirimkan karya ke INPONSEL, Anda juga telah mengesahkan INPONSEL untuk menggunakan nama dan materi biografi secara luas untuk tujuan iklan dan promosi.<br /><br />Jika Anda memilih demikian, kami juga akan menggunakannya untuk mengirimkan informasi tentang produk dan layanan yang mungkin menarik bagi Anda. Nantinya dalam Kebijakan Privasi ini, kami akan memberikan Anda informasi lebih lanjut tentang pilihan apa saja yang Anda miliki.<br /><br />Kami menggunakan informasi yang tidak bisa diidentifikasi secara pribadi untuk menentukan bagaimana orang menggunakan situs web dan layanan kami. Misalnya, data ini memberitahu kami informasi meliputi seberapa sering pengguna mengklik iklan kami, file mana yang paling sering diunduh, dan area mana dari situs kami yang paling populer. Menganalisa data ini memungkinkan kami untuk meningkatkan penawaran dan kinerja situs kami. Dengan menggunakan alamat IP Anda, kami juga dapat menentukan lokasi fisik secara umum dari pengguna dan terkadang kami dapat menggunakan informasi ini untuk menargetkan iklan yang lebih baik kepada pengguna.<br />&nbsp;</p><p><strong>Bagaimana kami berbagi informasi</strong></p><p>Terkecuali yang disebutkan di bawah ini, INPONSEL tidak berbagi informasi pribadi Anda dengan pihak ketiga kecuali jika Anda memberikan izin atau kami perlu untuk berbagi informasi tersebut untuk menyediakan produk atau layanan yang Anda minta. Sebagai contoh, kami melibatkan pihak ketiga untuk membantu kami dengan melacak jumlah pengunjung ke situs/ aplikasi yang memiliki &quot;clicked-through&quot; dari promosi tertentu pada situs pihak ketiga dan aktivitas para pengunjung tersebut di situs/ aplikasi INPONSEL. Ketika kami memberikan informasi pribadi Anda ke pihak ketiga, kami meminta mereka untuk menggunakannya hanya untuk kepentingan bantuan yang mereka berikan kepada kami.<br /><br />Bila Anda melihat beberapa bagian dari situs kami terdapat merek terkemuka dari perusahaan lain, informasi yang Anda berikan (atau mengizinkan untuk digunakan) di bagian situs tersebut akan dibagi dengan perusahaan lain yang bekerja sama dalam memberikan layanan. Silahkan mengunjungi situs perusahaan tersebut untuk mempelajari lebih lanjut mengenai kebijakan pemakaian informasi mereka.<br /><br />Kami mengagregasi informasi anonim yang kami kumpulkan dan menukarnya dengan pengiklan dan pihak lain yang tertarik pada layanan kami. Kami akan mengungkap informasi pribadi Anda jika diperlukan oleh hukum atau berdasarkan keyakinan bahwa pemberian informasi tersebut diperlukan untuk mematuhi hukum yang berlaku, memenuhi panggilan dari pengadilan, perintah pengadilan atau proses hukum yang berlaku di INPONSEL, untuk membentuk atau menggunakan hak hukum kami atau membela klaim hukum, dan untuk melindungi kekayaan atau kepentingan INPONSEL, agen dan karyawan, keselamatan pribadi, atau masyarakat. Dalam keadaan seperti itu, INPONSEL mungkin akan dilarang oleh hukum, perintah pengadilan atau proses hukum lainnya untuk menyertakan pemberitahuan atas pegungkapan informasi tersebut, dan INPONSEL berhak untuk tidak memberikan pemberitahuan tersebut atas kebijakannya sendiri.</p><p>Jika kami menjadi bagian dari organisasi lain, termasuk tanpa batasan, melalui penggabungan usaha, perubahan pengendalian, penjualan aset, atau akuisisi lainnya, organisasi yang mengakusisi akan mendapatkan dan memiliki akses ke informasi pribadi yang dikumpulkan oleh INPONSEL. Jika kami berhenti beroperasi, informasi Anda mungkin ditransfer ke dan digunakan oleh perusahaan lain yang menawarkan produk atau jasa yang serupa atau berkaitan. Meskipun kami tidak dapat memprediksi banyak tentang keadaan yang tak mungkin terjadi, kami berharap ini bisa memberikan Anda kontinuitas pelayanan.<br />&nbsp;</p><p><strong>Membuat perubahan</strong></p><p>Anda dapat meninjau informasi pribadi yang kami miliki dengan cara login dan mengklik Profil di halaman pengguna Anda. Pada halaman tersebut Anda dapat mengubah informasi yang salah dan menghapus informasi tertentu dari profil Anda. Untuk menghapus akun pribadi Anda di INPONSEL, Anda harus menguhubungi kami melalui alamat email <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a> dengan subjek &ldquo;Hapus Keanggotaan&rdquo;. Jika tidak, maka data Anda akan dipertahankan selamanya.</p><p>Harap diingat bahwa konten yang Anda buat pada layanan INPONSEL tidak dapat dihapus, kecuali oleh pihak kami. Selain itu, informasi anonim tidak dapat dilihat atau diubah oleh Anda. Kami dapat mengubah kebijakan ini dari waktu ke waktu. Meskipun kami biasanya akan memberitahukan perubahan-perubahan besar melalui situs atau akun layanan jejaring sosial atau aplikasi kami, Anda juga dimohon untuk mengecek situs/ aplikasi kami dari waktu ke waktu untuk melihat apakah ada kebijakan revisi yang kami posting.</p><p>&nbsp;</p><p><strong>Update</strong></p><p>Kami dapat memperbaharui Kebijakan Privasi ini dari waktu ke waktu sebagaimana layanan kami berubah dan berkembang. Jika kami memperbarui Kebijakan Privasi ini, kami akan memberitahukan Anda perubahan signifikan yang kami buat dengan mengirimkan pemberitahuan ke alamat email yang ada dalam account Anda atau dengan memposting pemberitahuan perubahan tersebut pada situs/ aplikasi atau melalui akun layanan jejaring sosial INPONSEL. Kecuali jika sebaliknya tersedia, revisi akan berlaku pada tanggal pengumuman itu diposting. Setelah perubahan tersebut efektif, kelanjutan penggunaan Anda di situs akan menunjukkan penerimaan Anda terhadap Kebijakan Privasi yang baru. Jika Anda tidak setuju dengan persyaratan Kebijakan Privasi ini atau revisi Kebijakan Privasi lainnya, yang dapat Anda lakukan adalah menghentikan penggunaan layanan ini.<br />&nbsp;</p><p><strong>Pertanyaan</strong></p><p>Jika Anda memiliki pertanyaan tentang kebijakan kami atau keperluan dukungan umum, silahkan hubungi kami melalui alamat email di <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a>.</p>";
    }

    private String getHtmlData(Context context, String s)
    {
        return (new StringBuilder("<html><body>")).append(s).append("</body></html>").toString();
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300d9, null, false);
        mDrawerLayout.addView(bundle, 0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        menu_KebijakanPrivasi.setBackgroundResource(0x7f0201cf);
        menu_KebijakanPrivasi.setEnabled(false);
        int j;
        int k;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Kebijakan Privasi");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Kebijakan Privasi");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Kebijakan Privasi</font>"));
        txt_keb = (TextView)findViewById(0x7f0b05a2);
        webKeb = (WebView)findViewById(0x7f0b06ad);
        webKeb.setBackgroundColor(Color.parseColor("#f7f7f7"));
        faq = (new StringBuilder("<div align=\"justify\"><font size=3>")).append(faq1).append("<br/><br/>").append("</font>  </div>").toString();
        txt_keb.setText(Html.fromHtml(faq1));
        txt_keb.setMovementMethod(LinkMovementMethod.getInstance());
        webKeb.loadDataWithBaseURL("file:///android_asset/", getHtmlData(this, faq), "text/html", "utf-8", "");
        webKeb.setVisibility(8);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }
}
