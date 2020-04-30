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

public class PersyaratanActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{

    String faq;
    String faq1;
    Intent i;
    PonselBaseApp ponselBaseApp;
    TextView txt_keb;
    WebView webKeb;

    public PersyaratanActivity()
    {
        faq = "";
        faq1 = "<p><strong>Syarat dan Ketentuan Penggunaan</strong></p><p>Selamat datang di layanan INPONSEL, layanan online yang dikelola oleh PT INTELE HUB INDONESIA (selanjutnya disebut 'INPONSEL' atau 'kami'). Syarat dan Ketentuan Penggunaan berikut adalah ketentuan dalam penggunaan situs, konten, layanan dan fitur yang ada pada layanan INPONSEL.</p><p>Harap Anda membaca Syarat dan Ketentuan Penggunaan ini dengan sebaik-baiknya. Dengan mengakses dan menggunakan layanan INPONSEL, berarti Anda telah memahami dan setuju untuk terikat dengan semua peraturan yang berlaku di situs ini.</p><p><strong>Informasi yang diposting untuk umum</strong></p><p>Jika Anda mendaftar sebagai anggota INPONSEL dan membuat posting pada layanan INPONSEL, harap diingat bahwa apapun yang Anda posting berlaku untuk masyarakat umum. Username pengguna yang Anda pilih saat proses pendaftaran dapat dilihat oleh semua pengguna layanan ini. Jika Anda mengunjungi halaman pengguna anggota lain, nama pengguna Anda akan muncul pada halaman tersebut. Halaman pengguna Anda juga akan menunjukkan statistik tertentu mengenai penggunaan Anda pada semua layanan INPONSEL, seperti tanggal Anda menjadi anggota, kapan terakhir kali Anda mengunjungi situs/ aplikasi, kategori materi yang telah Anda posting. INPONSEL tidak mengontrol dan tidak bertanggung jawab untuk penggunaan setiap informasi atau konten yang telah Anda buka kepada publik melalui penggunaan Anda atas layanan INPONSEL.</p><p><strong>Konten Berita</strong></p><p>Materi konten berita yang ditampilkan pada rubrik Berita pada layanan INPONSEL merupakan konten dari website-website di luar INPONSEL yang disalurkan menggunakan layanan RSS (Really Simple Syndication). RSS adalah sebuah teknologi yang dikembangkan untuk menciptakan kemudahan untuk saling berbagi informasi atau konten di internet. Isi konten berita yang ditampilkan di INPONSEL adalah isi keseluruhan artikel seperti yang ditampilkan pada website sumber konten. Kami tidak menjamin dan tidak bertanggungjawab terhadap isi konten berita, termasuk yang berkaitan dengan kualitas, kesesuaian, kebenaran, ketepatan atau kelengkapan dari isi berita yang terdapat dalam layanan INPONSEL.</p><p><strong>Ketentuan Forum</strong></p><p>INPONSEL menyediakan layanan Forum dimana memungkinkan Anda dan pengguna lain untuk mengirim materi teks, gambar, link, atau konten lain. Anda bertanggung jawab atas setiap konten yang Anda buat pada semua layanan INPONSEL.</p><p>Dengan membuat konten pada layanan INPONSEL, Anda memberikan kami hak secara terus-menerus dan bebas royalti dan bebas lisensi (dengan hak untuk mensublisensikan) untuk menggunakan, memodifikasi, melakukan publikasi, mereproduksi, dan menyebarluaskan konten tersebut, secara keseluruhan atau sebagian, dalam berbagai format media dan berbagai saluran media. Anda juga setuju bahwa lisensi ini mencakup hak bagi kami untuk menampilkan konten Anda bagi pengguna lain pada semua layanan INPONSEL.</p><p>Anda menyatakan dan menjamin bahwa: (i) konten yang Anda buat adalah milik Anda atau Anda memiliki hak untuk menggunakannya dan memberikan kami hak dan lisensi, (ii) Anda menyatakan bahwa konten yang Anda buat pada layanan INPONSEL tidak melanggar hak privasi, hak publisitas, hak cipta, hak kontrak atau hak-hak lainnya.</p><p>Kami tidak memiliki kewajiban untuk memonitor akses Anda ke atau penggunaan layanan INPONSEL, tetapi kami memiliki hak untuk meninjau dan menyunting konten Anda untuk tujuan operasional layanan, untuk memastikan kepatuhan pada persyaratan, atau untuk mematuhi hukum yang berlaku atau perintah atau persyaratan pengadilan, lembaga administratif atau badan pemerintah lainnya. Kami berhak setiap saat dan tanpa pemberitahuan sebelumnya, untuk menghapus atau menoaktifkan konten milik Anda yang kami anggap melanggar persyaratan atau berbahaya bagi layanan INPONSEL.</p><p>Anda setuju untuk tidak bergantung pada layanan untuk keperluan akses konten, penyimpanan atau cadangan. INPONSEL tidak akan bertanggung jawab kepada Anda untuk setiap modifikasi, penundaan atau penghentian layanan atau hilangnya materi.</p><p><strong>Membuat perubahan</strong></p><p>Anda dapat meninjau informasi pribadi yang kami miliki dengan cara login dan mengklik Profil di halaman pengguna Anda. Pada halaman tersebut Anda dapat mengubah informasi yang salah dan menghapus informasi tertentu dari profil Anda. Untuk menghapus akun pribadi Anda di INPONSEL, Anda harus menguhubungi kami melalui alamat email <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a> subjek \"Hapus Keanggotaan\". Jika tidak, maka data Anda akan dipertahankan selamanya.</p><p>Harap diingat bahwa konten yang Anda buat pada layanan INPONSEL tidak dapat dihapus, kecuali oleh pihak kami. Selain itu, informasi anonim tidak dapat dilihat atau diubah oleh Anda. Kami dapat mengubah kebijakan ini dari waktu ke waktu. Meskipun kami biasanya akan memberitahukan perubahan-perubahan besar melalui situs atau akun layanan jejaring sosial atau aplikasi kami, Anda juga dimohon untuk mengecek situs/ aplikasi kami dari waktu ke waktu untuk melihat apakah ada kebijakan revisi yang kami posting.</p><p><strong>Update</strong></p><p>Kami dapat memperbaharui Syarat & Ketentuan ini dari waktu ke waktu sebagaimana layanan kami berubah dan berkembang. Jika kami memperbarui Syarat & Ketentuan ini, kami akan memberitahukan Anda perubahan signifikan yang kami buat dengan mengirimkan pemberitahuan ke alamat email yang ada dalam account Anda atau dengan memposting pemberitahuan perubahan tersebut pada situs/ aplikasi atau melalui akun layanan jejaring sosial INPONSEL. Kecuali jika sebaliknya tersedia, revisi akan berlaku pada tanggal pengumuman itu diposting. Setelah perubahan tersebut efektif, kelanjutan penggunaan Anda di situs akan menunjukkan penerimaan Anda terhadap Syarat & Ketentuan yang baru. Jika Anda tidak setuju dengan persyaratan Syarat & Ketentuan ini atau revisi Syarat & Ketentuan lainnya, yang dapat Anda lakukan adalah menghentikan penggunaan layanan ini.</p><p><strong>Pertanyaan</strong></p><p>Jika Anda memiliki pertanyaan tentang kebijakan kami atau keperluan dukungan umum, silahkan hubungi kami melalui alamat email di <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a>.</p>";
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
        menu_Persyaratan.setBackgroundResource(0x7f0201cf);
        menu_Persyaratan.setEnabled(false);
        int j;
        int k;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Syarat & Ketentuan");
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
        bundle.setText("Syarat & Ketentuan");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Syarat & Ketentuan</font>"));
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
