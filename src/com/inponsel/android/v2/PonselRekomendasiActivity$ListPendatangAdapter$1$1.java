// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.v2:
//            PonselRekomendasiActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ter._cls1._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/PonselRekomendasiActivity$ListPendatangAdapter$1

/* anonymous class */
    class PonselRekomendasiActivity.ListPendatangAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final PonselRekomendasiActivity.ListPendatangAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            indexhp = getListModel(position).getId_hp();
            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
            Log.e("getNamalengkap", getListModel(position).getCodename());
            statusLikeHp = "1";
            PonselRekomendasiActivity.ListPendatangAdapter.access$1(PonselRekomendasiActivity.ListPendatangAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
            if (userFunctions.isUserLoggedIn(PonselRekomendasiActivity.ListPendatangAdapter.access$0(PonselRekomendasiActivity.ListPendatangAdapter.this)))
            {
                pos = position;
                try
                {
                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(PonselRekomendasiActivity.ListPendatangAdapter.access$1(PonselRekomendasiActivity.ListPendatangAdapter.this).username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                Log.e("finalurlpos", String.valueOf(pos));
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PonselRekomendasiActivity.ListPendatangAdapter.PostBagusKurangTask(PonselRekomendasiActivity.ListPendatangAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PonselRekomendasiActivity.ListPendatangAdapter.PostBagusKurangTask(PonselRekomendasiActivity.ListPendatangAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(PonselRekomendasiActivity.ListPendatangAdapter.access$0(PonselRekomendasiActivity.ListPendatangAdapter.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PonselRekomendasiActivity.ListPendatangAdapter._cls1._cls1());
                view.setNeutralButton("Register", new PonselRekomendasiActivity.ListPendatangAdapter._cls1._cls2());
                view.setNegativeButton("Login", new PonselRekomendasiActivity.ListPendatangAdapter._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PonselRekomendasiActivity$ListPendatangAdapter$1$2

/* anonymous class */
        class PonselRekomendasiActivity.ListPendatangAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PonselRekomendasiActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PonselRekomendasiActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                PonselRekomendasiActivity.ListPendatangAdapter.access$0(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PonselRekomendasiActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PonselRekomendasiActivity$ListPendatangAdapter$1$3

/* anonymous class */
        class PonselRekomendasiActivity.ListPendatangAdapter._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PonselRekomendasiActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PonselRekomendasiActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PonselRekomendasiActivity.ListPendatangAdapter.access$0(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PonselRekomendasiActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }

    }

}
