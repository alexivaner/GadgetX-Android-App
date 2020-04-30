// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls0
    implements android.view.
{

    final RegisterActivity this$0;

    public void onClick(View view)
    {
        if (edtKotaLain.getVisibility() == 0)
        {
            kota = edtKotaLain.getText().toString();
        }
        if (edtHpDigunakan.getVisibility() == 0)
        {
            hpPengguna = edtHpDigunakan.getText().toString();
        } else
        {
            hpPengguna = namaHp;
        }
        nama = edtNama.getText().toString();
        usernama = edtUserName.getText().toString();
        pass = edtPass.getText().toString();
        pass = Utility.session(pass);
        pass = Utility.session(pass);
        pass = Utility.session(pass);
        pass = Utility.session(pass);
        pass = Utility.session(pass);
        repass = edtRePass.getText().toString();
        repass = Utility.session(repass);
        repass = Utility.session(repass);
        repass = Utility.session(repass);
        repass = Utility.session(repass);
        repass = Utility.session(repass);
        email = edtEmail.getText().toString();
        tggal = btnTTL.getText().toString();
        if (checkUsername(usernama)) goto _L2; else goto _L1
_L1:
        Toast.makeText(RegisterActivity.this, "username harus diawali huruf, tanpa spasi dan karakter yang diperbolehkan hanya . atau _", 1).show();
        edtUserName.startAnimation(animation);
_L4:
        return;
_L2:
        if (usernama.contains("admin"))
        {
            Toast.makeText(RegisterActivity.this, "Username tidak boleh mengandung kata admin", 0).show();
            return;
        }
        if (!pass.equals(repass))
        {
            Toast.makeText(RegisterActivity.this, "Password tidak cocok", 0).show();
            edtPass.startAnimation(animation);
            edtRePass.startAnimation(animation);
            return;
        }
        if (!RegisterActivity.checkEmail(email))
        {
            Toast.makeText(RegisterActivity.this, "email tidak valid", 0).show();
            return;
        }
        if (tggal.contains("Tanggal"))
        {
            Toast.makeText(RegisterActivity.this, "Tanggal belum diisi", 0).show();
            btnTTL.startAnimation(animation);
            return;
        }
        if (provinsi.equals(""))
        {
            Toast.makeText(RegisterActivity.this, "Anda belum mengisi provinsi", 0).show();
            btnProv.startAnimation(animation);
            return;
        }
        if (kota.equals(""))
        {
            Toast.makeText(RegisterActivity.this, "Anda belum mengisi kota", 0).show();
            btnKota.startAnimation(animation);
            return;
        }
        if (kecamatan.equals(""))
        {
            Toast.makeText(RegisterActivity.this, "Anda belum mengisi kecamatan", 0).show();
            btnKecamatan.startAnimation(animation);
            return;
        }
        if (hpPengguna.equals("") || hpPengguna.contains("Ponsel digunakan"))
        {
            Toast.makeText(RegisterActivity.this, "Anda belum mengisi hp", 0).show();
            btnHpDigunakan.startAnimation(animation);
            return;
        }
        if (provider.equals(""))
        {
            Toast.makeText(RegisterActivity.this, "Anda belum mengisi provider", 0).show();
            btnOperatorDigunakan.startAnimation(animation);
            return;
        }
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L4; else goto _L3
_L3:
        if (android.os.T >= 11)
        {
            (new isterTask(RegisterActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        try
        {
            (new isterTask(RegisterActivity.this)).execute(new Void[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    isterTask()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
