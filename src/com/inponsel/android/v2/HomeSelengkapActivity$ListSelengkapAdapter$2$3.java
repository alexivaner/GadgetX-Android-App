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
//            HomeSelengkapActivity, LoginActivity, RegisterActivity

class this._cls2
    implements android.content.ter._cls2._cls3
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

    // Unreferenced inner class com/inponsel/android/v2/HomeSelengkapActivity$ListSelengkapAdapter$2

/* anonymous class */
    class HomeSelengkapActivity.ListSelengkapAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final HomeSelengkapActivity.ListSelengkapAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            indexhp = getListModel(position).getId_hp();
            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
            Log.e("getNamalengkap", getListModel(position).getCodename());
            statusLikeHp = "1";
            HomeSelengkapActivity.ListSelengkapAdapter.access$1(HomeSelengkapActivity.ListSelengkapAdapter.this).namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
            if (userFunctions.isUserLoggedIn(HomeSelengkapActivity.ListSelengkapAdapter.access$0(HomeSelengkapActivity.ListSelengkapAdapter.this)))
            {
                pos = position;
                try
                {
                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(HomeSelengkapActivity.ListSelengkapAdapter.access$1(HomeSelengkapActivity.ListSelengkapAdapter.this).username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                Log.e("finalurl", finalUrl);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeSelengkapActivity.ListSelengkapAdapter.PostBagusKurangTask(HomeSelengkapActivity.ListSelengkapAdapter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeSelengkapActivity.ListSelengkapAdapter.PostBagusKurangTask(HomeSelengkapActivity.ListSelengkapAdapter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeSelengkapActivity.ListSelengkapAdapter.access$0(HomeSelengkapActivity.ListSelengkapAdapter.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeSelengkapActivity.ListSelengkapAdapter._cls2._cls1());
                view.setNeutralButton("Register", new HomeSelengkapActivity.ListSelengkapAdapter._cls2._cls2());
                view.setNegativeButton("Login", new HomeSelengkapActivity.ListSelengkapAdapter._cls2._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listselengkapadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeSelengkapActivity$ListSelengkapAdapter$2$1

/* anonymous class */
        class HomeSelengkapActivity.ListSelengkapAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeSelengkapActivity.ListSelengkapAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeSelengkapActivity.ListSelengkapAdapter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeSelengkapActivity$ListSelengkapAdapter$2$2

/* anonymous class */
        class HomeSelengkapActivity.ListSelengkapAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeSelengkapActivity.ListSelengkapAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeSelengkapActivity.ListSelengkapAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                HomeSelengkapActivity.ListSelengkapAdapter.access$0(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = HomeSelengkapActivity.ListSelengkapAdapter._cls2.this;
                        super();
                    }
        }

    }

}
