// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            RivalTerdekatActivity

class this._cls2
    implements android.content.aAdapter._cls2._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth0(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth0(_fld1).startActivity(dialoginterface);
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/RivalTerdekatActivity$ListTurunHargaAdapter$2

/* anonymous class */
    class RivalTerdekatActivity.ListTurunHargaAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final RivalTerdekatActivity.ListTurunHargaAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            indexhp = getListModel(position).getId_hp();
            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
            Log.e("getNamalengkap", getListModel(position).getCodename());
            statusLikeHp = "0";
            RivalTerdekatActivity.ListTurunHargaAdapter.access$1(RivalTerdekatActivity.ListTurunHargaAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
            if (userFunctions.isUserLoggedIn(RivalTerdekatActivity.ListTurunHargaAdapter.access$0(RivalTerdekatActivity.ListTurunHargaAdapter.this)))
            {
                pos = position;
                try
                {
                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(RivalTerdekatActivity.ListTurunHargaAdapter.access$1(RivalTerdekatActivity.ListTurunHargaAdapter.this).username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                Log.e("finalurl", finalUrl);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RivalTerdekatActivity.ListTurunHargaAdapter.PostBagusKurangTask(RivalTerdekatActivity.ListTurunHargaAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new RivalTerdekatActivity.ListTurunHargaAdapter.PostBagusKurangTask(RivalTerdekatActivity.ListTurunHargaAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RivalTerdekatActivity.ListTurunHargaAdapter.access$1(RivalTerdekatActivity.ListTurunHargaAdapter.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RivalTerdekatActivity.ListTurunHargaAdapter._cls2._cls1());
                view.setNeutralButton("Register", new RivalTerdekatActivity.ListTurunHargaAdapter._cls2._cls2());
                view.setNegativeButton("Login", new RivalTerdekatActivity.ListTurunHargaAdapter._cls2._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listturunhargaadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/RivalTerdekatActivity$ListTurunHargaAdapter$2$1

/* anonymous class */
        class RivalTerdekatActivity.ListTurunHargaAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RivalTerdekatActivity.ListTurunHargaAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RivalTerdekatActivity.ListTurunHargaAdapter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/RivalTerdekatActivity$ListTurunHargaAdapter$2$3

/* anonymous class */
        class RivalTerdekatActivity.ListTurunHargaAdapter._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RivalTerdekatActivity.ListTurunHargaAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RivalTerdekatActivity.ListTurunHargaAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                RivalTerdekatActivity.ListTurunHargaAdapter.access$0(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RivalTerdekatActivity.ListTurunHargaAdapter._cls2.this;
                        super();
                    }
        }

    }

}
