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
//            HomeNewMainActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ter._cls2._cls1
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

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$ListPendatangAdapter$2

/* anonymous class */
    class HomeNewMainActivity.ListPendatangAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final HomeNewMainActivity.ListPendatangAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(HomeNewMainActivity.ListPendatangAdapter.access$0(HomeNewMainActivity.ListPendatangAdapter.this)))
            {
                pos = position;
                HomeNewMainActivity.ListPendatangAdapter.access$1(HomeNewMainActivity.ListPendatangAdapter.this).indexhp = getListModel(position).getId_hp();
                ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                statusPendatang = "0";
                statusLikeHpPend = "0";
                HomeNewMainActivity.ListPendatangAdapter.access$1(HomeNewMainActivity.ListPendatangAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                try
                {
                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(HomeNewMainActivity.ListPendatangAdapter.access$1(HomeNewMainActivity.ListPendatangAdapter.this).username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusPendatang).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                Log.e("finalurl", finalUrl);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeNewMainActivity.ListPendatangAdapter.PostBagusKurangTask(HomeNewMainActivity.ListPendatangAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeNewMainActivity.ListPendatangAdapter.PostBagusKurangTask(HomeNewMainActivity.ListPendatangAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeNewMainActivity.ListPendatangAdapter.access$0(HomeNewMainActivity.ListPendatangAdapter.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeNewMainActivity.ListPendatangAdapter._cls2._cls1());
                view.setNeutralButton("Register", new HomeNewMainActivity.ListPendatangAdapter._cls2._cls2());
                view.setNegativeButton("Login", new HomeNewMainActivity.ListPendatangAdapter._cls2._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$ListPendatangAdapter$2$2

/* anonymous class */
        class HomeNewMainActivity.ListPendatangAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewMainActivity.ListPendatangAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeNewMainActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                HomeNewMainActivity.ListPendatangAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                HomeNewMainActivity.ListPendatangAdapter.access$1(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeNewMainActivity.ListPendatangAdapter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$ListPendatangAdapter$2$3

/* anonymous class */
        class HomeNewMainActivity.ListPendatangAdapter._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewMainActivity.ListPendatangAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeNewMainActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                HomeNewMainActivity.ListPendatangAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                HomeNewMainActivity.ListPendatangAdapter.access$1(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeNewMainActivity.ListPendatangAdapter._cls2.this;
                        super();
                    }
        }

    }

}
