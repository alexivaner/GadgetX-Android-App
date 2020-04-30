// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

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

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel

class this._cls2
    implements android.content.carianAdapter._cls1._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth0(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth0(_fld1).startActivity(dialoginterface);
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencariangen/Hal1PencPonsel$ListPencarianAdapter$1

/* anonymous class */
    class Hal1PencPonsel.ListPencarianAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final Hal1PencPonsel.ListPencarianAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            Hal1PencPonsel.ListPencarianAdapter.access$1(Hal1PencPonsel.ListPencarianAdapter.this).indexhp = getListModel(position).getId_hp();
            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
            Log.e("getNamalengkap", getListModel(position).getCodename());
            statusLikeHp = "1";
            Hal1PencPonsel.ListPencarianAdapter.access$1(Hal1PencPonsel.ListPencarianAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
            ponselBaseApp.getObserver().setId_hp(Hal1PencPonsel.ListPencarianAdapter.access$1(Hal1PencPonsel.ListPencarianAdapter.this).indexhp);
            if (userFunctions.isUserLoggedIn(Hal1PencPonsel.ListPencarianAdapter.access$0(Hal1PencPonsel.ListPencarianAdapter.this)))
            {
                pos = position;
                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(Hal1PencPonsel.ListPencarianAdapter.access$1(Hal1PencPonsel.ListPencarianAdapter.this).username).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                Log.e("finalurl", finalUrl);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal1PencPonsel.ListPencarianAdapter.PostBagusKurangTask(Hal1PencPonsel.ListPencarianAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal1PencPonsel.ListPencarianAdapter.PostBagusKurangTask(Hal1PencPonsel.ListPencarianAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal1PencPonsel.ListPencarianAdapter.access$0(Hal1PencPonsel.ListPencarianAdapter.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1PencPonsel.ListPencarianAdapter._cls1._cls1());
                view.setNeutralButton("Register", new Hal1PencPonsel.ListPencarianAdapter._cls1._cls2());
                view.setNegativeButton("Login", new Hal1PencPonsel.ListPencarianAdapter._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencariangen/Hal1PencPonsel$ListPencarianAdapter$1$1

/* anonymous class */
        class Hal1PencPonsel.ListPencarianAdapter._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1PencPonsel.ListPencarianAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal1PencPonsel.ListPencarianAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal1PencPonsel$ListPencarianAdapter$1$2

/* anonymous class */
        class Hal1PencPonsel.ListPencarianAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1PencPonsel.ListPencarianAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1PencPonsel.ListPencarianAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                Hal1PencPonsel.ListPencarianAdapter.access$0(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1PencPonsel.ListPencarianAdapter._cls1.this;
                        super();
                    }
        }

    }

}
