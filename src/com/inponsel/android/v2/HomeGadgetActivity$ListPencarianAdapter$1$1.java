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
//            HomeGadgetActivity, RegisterActivity, LoginActivity

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

    // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$ListPencarianAdapter$1

/* anonymous class */
    class HomeGadgetActivity.ListPencarianAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final HomeGadgetActivity.ListPencarianAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(HomeGadgetActivity.ListPencarianAdapter.access$0(HomeGadgetActivity.ListPencarianAdapter.this)))
            {
                HomeGadgetActivity.ListPencarianAdapter.access$1(HomeGadgetActivity.ListPencarianAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                pos = position;
                statusPencarian = "1";
                statusLikeHpPencarian = "1";
                HomeGadgetActivity.ListPencarianAdapter.access$1(HomeGadgetActivity.ListPencarianAdapter.this).indexhp = getListModel(position).getId_hp();
                ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                try
                {
                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(HomeGadgetActivity.ListPencarianAdapter.access$1(HomeGadgetActivity.ListPencarianAdapter.this).username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusPencarian).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                Log.e("finalurl", finalUrl);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeGadgetActivity.ListPencarianAdapter.PostBagusKurangTask(HomeGadgetActivity.ListPencarianAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeGadgetActivity.ListPencarianAdapter.PostBagusKurangTask(HomeGadgetActivity.ListPencarianAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeGadgetActivity.ListPencarianAdapter.access$0(HomeGadgetActivity.ListPencarianAdapter.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeGadgetActivity.ListPencarianAdapter._cls1._cls1());
                view.setNeutralButton("Register", new HomeGadgetActivity.ListPencarianAdapter._cls1._cls2());
                view.setNegativeButton("Login", new HomeGadgetActivity.ListPencarianAdapter._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$ListPencarianAdapter$1$2

/* anonymous class */
        class HomeGadgetActivity.ListPencarianAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeGadgetActivity.ListPencarianAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeGadgetActivity.ListPencarianAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                HomeGadgetActivity.ListPencarianAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                HomeGadgetActivity.ListPencarianAdapter.access$1(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeGadgetActivity.ListPencarianAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$ListPencarianAdapter$1$3

/* anonymous class */
        class HomeGadgetActivity.ListPencarianAdapter._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeGadgetActivity.ListPencarianAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeGadgetActivity.ListPencarianAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                HomeGadgetActivity.ListPencarianAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                HomeGadgetActivity.ListPencarianAdapter.access$1(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeGadgetActivity.ListPencarianAdapter._cls1.this;
                        super();
                    }
        }

    }

}
