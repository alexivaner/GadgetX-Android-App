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
//            ProfileActivity

class this._cls0
    implements android.view.r
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        if (!edtNamaProfile.getText().toString().equals(nama_asli) || !user_jekel.equals(user_jekel_cb) || !user_ttl.equals(ProfileActivity.access$9(ProfileActivity.this, btnTTLProfile.getText().toString())) || !user_provinsi.equals(btnProvProfile.getText().toString()) || !user_kota.equals(btnKotaProfile.getText().toString()) || !user_kecamatan.equals(btnKecamatan.getText().toString()) || !user_ponsel1.equals(btnHpDigunakanProfile.getText().toString()) || !user_ponsel2.equals(btnHpDigunakan2Profile.getText().toString()) || !user_provider1.equals(btnOperatorDigunakanProfile.getText().toString()) || !user_provider2.equals(btnOperatorDigunakan2Profile.getText().toString())) goto _L2; else goto _L1
_L1:
        Toast.makeText(getApplicationContext(), "Tidak ada perubahan", 1).show();
_L4:
        return;
_L2:
        provinsiProfile = btnProvProfile.getText().toString();
        kotaProfile = btnKotaProfile.getText().toString();
        kecamatanProfile = btnKecamatan.getText().toString();
        hpPenggunaProfile = btnHpDigunakanProfile.getText().toString();
        namaProfile = edtNamaProfile.getText().toString();
        usernamaProfile = edtUserNameProfile.getText().toString();
        passProfile = passlamaUpdate;
        passProfile = Utility.session(passProfile);
        passProfile = Utility.session(passProfile);
        passProfile = Utility.session(passProfile);
        passProfile = Utility.session(passProfile);
        passProfile = Utility.session(passProfile);
        repassProfile = edtPassProfileBaru.getText().toString();
        repassProfile = Utility.session(repassProfile);
        repassProfile = Utility.session(repassProfile);
        repassProfile = Utility.session(repassProfile);
        repassProfile = Utility.session(repassProfile);
        repassProfile = Utility.session(repassProfile);
        emailProfile = edtEmailProfile.getText().toString();
        tggalProfile = btnTTLProfile.getText().toString();
        provider = btnOperatorDigunakanProfile.getText().toString();
        provider2 = btnOperatorDigunakan2Profile.getText().toString();
        if (tggalProfile.equals("*Tanggal lahir"))
        {
            Toast.makeText(ProfileActivity.this, "Tanggal belum diisi", 0).show();
            btnTTLProfile.startAnimation(animation);
            return;
        }
        if (provinsiProfile.equals(""))
        {
            Toast.makeText(ProfileActivity.this, "Anda belum mengisi provinsi", 0).show();
            return;
        }
        if (kotaProfile.equals(""))
        {
            Toast.makeText(ProfileActivity.this, "Anda belum mengisi kota", 0).show();
            return;
        }
        if (kecamatanProfile.equals(""))
        {
            Toast.makeText(ProfileActivity.this, "Anda belum mengisi kecamatan", 0).show();
            return;
        }
        if (hpPenggunaProfile.equals("") || hpPenggunaProfile.equals("Ponsel digunakan*"))
        {
            Toast.makeText(ProfileActivity.this, "Anda belum mengisi hp", 0).show();
            return;
        }
        if (provider.equals(""))
        {
            Toast.makeText(ProfileActivity.this, "Anda belum mengisi provider", 0).show();
            return;
        }
        if (ProfileActivity.access$2(ProfileActivity.this) != 0 || ProfileActivity.access$4(ProfileActivity.this) != 0 || ProfileActivity.access$5(ProfileActivity.this) != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        selectDate = user_ttl;
_L5:
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            if (android.os.NT >= 11)
            {
                (new isterTask(ProfileActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_1113;
        }
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            selectDate = String.valueOf((new StringBuilder(String.valueOf(ProfileActivity.access$2(ProfileActivity.this)))).append("-").append(ProfileActivity.access$4(ProfileActivity.this)).append("-").append(ProfileActivity.access$5(ProfileActivity.this)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        (new isterTask(ProfileActivity.this)).execute(new Void[0]);
        return;
    }

    isterTask()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
