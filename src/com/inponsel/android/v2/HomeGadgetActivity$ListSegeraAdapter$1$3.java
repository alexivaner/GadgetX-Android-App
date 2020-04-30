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
//            HomeGadgetActivity, LoginActivity, RegisterActivity

class this._cls2
    implements android.content.ter._cls1._cls3
{

    final ion this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth0(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth0(_fld1).startActivityForResult(dialoginterface, 0);
        ss._mth1(_fld1).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$ListSegeraAdapter$1

/* anonymous class */
    class HomeGadgetActivity.ListSegeraAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final HomeGadgetActivity.ListSegeraAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(HomeGadgetActivity.ListSegeraAdapter.access$0(HomeGadgetActivity.ListSegeraAdapter.this)))
            {
                pos = position;
                statusSegera = "1";
                statusLikeHpSegera = "1";
                HomeGadgetActivity.ListSegeraAdapter.access$1(HomeGadgetActivity.ListSegeraAdapter.this).indexhp = getListModel(position).getId_hp();
                ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                HomeGadgetActivity.ListSegeraAdapter.access$1(HomeGadgetActivity.ListSegeraAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                try
                {
                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(HomeGadgetActivity.ListSegeraAdapter.access$1(HomeGadgetActivity.ListSegeraAdapter.this).username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusSegera).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                Log.e("finalurl", finalUrl);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeGadgetActivity.ListSegeraAdapter.PostBagusKurangTask(HomeGadgetActivity.ListSegeraAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeGadgetActivity.ListSegeraAdapter.PostBagusKurangTask(HomeGadgetActivity.ListSegeraAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeGadgetActivity.ListSegeraAdapter.access$0(HomeGadgetActivity.ListSegeraAdapter.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeGadgetActivity.ListSegeraAdapter._cls1._cls1());
                view.setNeutralButton("Register", new HomeGadgetActivity.ListSegeraAdapter._cls1._cls2());
                view.setNegativeButton("Login", new HomeGadgetActivity.ListSegeraAdapter._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listsegeraadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$ListSegeraAdapter$1$1

/* anonymous class */
        class HomeGadgetActivity.ListSegeraAdapter._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeGadgetActivity.ListSegeraAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeGadgetActivity.ListSegeraAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$ListSegeraAdapter$1$2

/* anonymous class */
        class HomeGadgetActivity.ListSegeraAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeGadgetActivity.ListSegeraAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeGadgetActivity.ListSegeraAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                HomeGadgetActivity.ListSegeraAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                HomeGadgetActivity.ListSegeraAdapter.access$1(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeGadgetActivity.ListSegeraAdapter._cls1.this;
                        super();
                    }
        }

    }

}
