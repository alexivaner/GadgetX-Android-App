// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
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
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

public class FAQActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{

    String a1;
    String a2;
    String a3;
    String a4;
    String a5;
    String a6;
    String a7;
    String a8;
    String a9;
    ActionBar actionBar;
    int actionBarTitleId;
    String customHtml;
    String faq;
    String faq1;
    PonselBaseApp ponselBaseApp;
    String q1;
    String q2;
    String q3;
    String q4;
    String q5;
    String q6;
    String q7;
    String q8;
    String q9;
    TextView txta1;
    TextView txta2;
    TextView txta3;
    TextView txta4;
    TextView txta5;
    TextView txta6;
    TextView txta7;
    TextView txta8;
    TextView txta9;
    TextView txtq1;
    TextView txtq2;
    TextView txtq3;
    TextView txtq4;
    TextView txtq5;
    TextView txtq6;
    TextView txtq7;
    TextView txtq8;
    TextView txtq9;
    private boolean useLogo;
    private WebView webView;

    public FAQActivity()
    {
        q1 = "Apakah InPonsel menjual perangkat ponsel atau tablet pc?";
        a1 = "Tidak. Saat ini kami masih berfokus pada konten database ponsel dan layanan lain terkait didalamnya.";
        q2 = "Apakah acuan harga di situs ini dapat dipercaya?";
        a2 = "Di InPonsel nilai kebenaran akan selalu mendapat prioritas utama. Khusus untuk daftar harga, survai dilakukan mulai dari hulu (distributor, gerai-gerai umum, toko resmi, dan toko online) sampai area hilir yang mencakup penjual perseorangan di komunitas online. Semua sumber tersebut kami pantau terus, untuk kemudian dianalisa secara komprehensif.";
        q3 = "Saya pernah mendapatkan perbedaan harga di situs ini dengan di toko. Kenapa hal ini bisa terjadi?";
        a3 = "Harga ponsel dapat berubah dengan cepat. Acuan kami adalah harga terbaru yang terjadi Jakarta, maka perbedaan dengan di daerah lain mungkin saja terjadi. Untuk kasus ini tim InPonsel secara intensif terus mengembangkan formulasi yang tepat, sehingga nantinya Daftar Harga dapat menjangkau area dan segmen yang lebih luas.";
        q4 = "Bagaimana cara situs ini menentukan harga seken (bekas)?";
        a4 = "Menetapkan harga bekas lebih rumit, sebab dipengaruhi oleh banyak faktor. Tim kami memiliki metoda sendiri, dengan diantaranya mempertimbangkan faktor-faktor berikut: umur produk sejak pertama kali dipasarkan di Indonesia, permintaan pasar, produk pesaing ditingkat harga setara, serta tentunya hasil survai.";
        q5 = "Apakah InPonsel tersedia dalam versi cetak?";
        a5 = "Untuk saat ini InPonsel baru tersedia di platform Android. Kami akan terus bekerja mengembangkan layanan ini ke berbagai platform, sehingga nantinya InPonsel dapat dengan mudah dijangkau oleh semua lapisan elemen masyarakat.";
        q6 = "Kenapa tidak ada rubrik berita?";
        a6 = "Berita pada sebuah situs informasi teknologi tentu saja merupakan elemen penting, namun harus diakui untuk merealisasikannya membutuhkan sumber daya yang tidak sedikit. Setelah semuanya siap, kami akan terjun kesana. Tunggu saja.";
        q7 = "Kenapa tidak ada rubrik uji?";
        a7 = "Seperti halnya berita, segmen review/ uji merupakan aspek penting di industri ini. Tetapi lagi, kami harus berhadapan dengan faktor finansial. Percayalah, jika sumber daya yang dimiliki sudah memungkinkan kami akan segera merealisasikannya.";
        q8 = "Saya ingin berkonsultasi langsung dengan tim InPonsel, bisakah?";
        a8 = "Tentu saja, Anda dapat berinteraksi langsung dengan kami melalui akun Twitter <a href='https://mobile.twitter.com/InPonsel'><b>@InPonsel</b></a>.";
        q9 = "";
        a9 = "";
        faq1 = "<table WIDTH=100% bgcolor=\"#00cbff\" border=\"0\"><tr>\t<td align=\"justify\"><b>Tanya: </b> Apakah InPonsel menjual perangkat ponsel atau tablet pc?</td>\t</tr></table><table WIDTH=100% bgcolor=\"#f7f7f7\" border=\"0\"><tr>\t<td align=\"justify\"><b>Jawab: </b> Tidak. Saat ini kami masih berfokus pada konten database ponsel dan layanan lain terkait didalamannya. Kendati demikian pada prinsipnya InPonsel dibuat untuk memudahkan masyarakat mendapatkan semua kebutuhan akan layanan dan produk telekomunikasi.</td>\t</tr></table> ";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        customHtml = "<p >Berikut akan dijelaskan mengenai hal-hal dasar yang perlu anda ketahui sebagai pengunjung dan pengguna INPONSEL </p><p >&nbsp;</p><p ><strong>Saya sudah mendaftar, tapi belum bisa melakukan posting</strong></p><p ><font color=\"#616161\">Keanggotaan di INPONSEL harus diaktivasi sebagai salah satu syarat untuk melakukan validasi data keanggotaan anda. Berikut langkah-langkah yang perlu dilakukan untuk mengaktivkan akun anda di INPONSEL</font></p><font color=\"#616161\"><ol type=\"1\"><li >Masuk ke email yang anda daftarkan di INPONSEL, kemudian buka folder Inbox.</li><li >Buka email dari INPONSEL dengan subjek \"Aktifkan Akun INPONSEL\", lalu klik tautan AKTIVASI AKUN. Tunggu proses aktivasi hingga muncul keterangan akun anda telah berhasil diaktifkan.</li><li >Apabila email aktivasi tidak ditemukan pada folder Inbox, silahkan cari pada folder Spam.&nbsp;</li></ol></font><p ><strong>Saya sudah melakukan aktivasi akun tetapi belum bisa posting</strong></p><p ><font color=\"#616161\">Untuk mengatasi hal ini silahkan kirimkan email ke <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a> dengan subjek &quot;Tidak Dapat Mengaktifkan Akun&quot;. Jangan lupa tuliskan username dan email yang anda daftarkan pada bagian body email.</font></p><p ><strong>Apakah saya bisa mengganti username?</strong></p><p ><font color=\"#616161\">Username anda di INPONSEL tidak bisa diubah.</font></p><p ><strong>Saya lupa password, bagaimana cara masuk ke INPONSEL?</strong></p><p ><font color=\"#616161\">Anda dapat mengembalikan password INPONSEL anda melalui halaman <a href=\"http://inponsel.co.id/member/reset/kata-sandi\">lupa kata sandi</a></font></p><p ><strong>Saya sudah memasukan username / email dan password dengan benar,tetapi masih tidak dapat login ke INPONSEL</strong></p><p ><font color=\"#616161\">Untuk mengatasi hal ini, silahkan melakukan reset password melalui halaman <a href=\"http://gotolive.inponsel.co.id/member/reset/kata-sandi\">lupa kata sandi</a></font>.</p><p ><strong>Akun saya di hack, apa yang harus saya lakukan?</strong></p><p ><font color=\"#616161\">Silahkan kirim email ke <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a> dengan subjek &quot;Account di Hack&quot;. Selanjutnya pihak INPONSEL akan memberikan informasi langkah-langkah yang perlu anda lakukan.</font></p><p ><strong>Menutup keanggotaan</strong></p><p ><font color=\"#616161\">Untuk menghentikan keanggotaan anda di INPONSEL, silahkan kirimkan email ke <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a> dengan subjek \"Hapus Keanggotaan\". Sertakan username dan email yang anda daftarkan di INPONSEL. Setelah keanggotaan anda ditutup / dinonaktifkan, username dan konten yang telah dipublikasikan terkait akun bersangkutan akan dipertahankan, namun data pribadi anda, seperti email, tanggal lahir dan alamat, akan dibersihkan.</p><p >Apabila anda masih menemukan masalah lainnya, anda dapat menghubungi layanan dukungan INPONSEL melalui email <a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a>.</font></p>";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300a8, null, false);
        mDrawerLayout.addView(bundle, 0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        webView = (WebView)findViewById(0x7f0b058d);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(customHtml, "text/html", "UTF-8");
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("FAQ");
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
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("FAQ");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>FAQ</font>"));
        menu_FAQ.setBackgroundResource(0x7f0201cf);
        menu_FAQ.setEnabled(false);
        txtq1 = (TextView)findViewById(0x7f0b0590);
        txtq1.setText(q1);
        txtq2 = (TextView)findViewById(0x7f0b0592);
        txtq2.setText(q2);
        txtq3 = (TextView)findViewById(0x7f0b0594);
        txtq3.setText(q3);
        txtq4 = (TextView)findViewById(0x7f0b0596);
        txtq4.setText(q4);
        txtq5 = (TextView)findViewById(0x7f0b0598);
        txtq5.setText(q5);
        txtq6 = (TextView)findViewById(0x7f0b059a);
        txtq6.setText(q6);
        txtq7 = (TextView)findViewById(0x7f0b059c);
        txtq7.setText(q7);
        txtq8 = (TextView)findViewById(0x7f0b059e);
        txtq8.setText(q8);
        txtq9 = (TextView)findViewById(0x7f0b05a0);
        txtq9.setText(q9);
        txta1 = (TextView)findViewById(0x7f0b0591);
        txta1.setText(a1);
        txta2 = (TextView)findViewById(0x7f0b0593);
        txta2.setText(a2);
        txta3 = (TextView)findViewById(0x7f0b0595);
        txta3.setText(a3);
        txta4 = (TextView)findViewById(0x7f0b0597);
        txta4.setText(a4);
        txta5 = (TextView)findViewById(0x7f0b0599);
        txta5.setText(a5);
        txta6 = (TextView)findViewById(0x7f0b059b);
        txta6.setText(a6);
        txta7 = (TextView)findViewById(0x7f0b059d);
        txta7.setText(a7);
        txta8 = (TextView)findViewById(0x7f0b059f);
        txta8.setText(Html.fromHtml(a8));
        txta8.setMovementMethod(LinkMovementMethod.getInstance());
        txta9 = (TextView)findViewById(0x7f0b05a1);
        txta9.setText(Html.fromHtml(a9));
        faq = (new StringBuilder("<div align=\"justify\"><font size=3>")).append(faq1).append("<br/><br/>").append(faq1).append("<br/><br/>").append(faq1).append("<br/><br/>").append(faq1).append("</font>  </div>").toString();
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
