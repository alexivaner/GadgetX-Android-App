// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            TwitterInPonsel

class val.since_id
    implements android.view.rNextAsycTask._cls6
{

    final this._cls1 this$1;
    private final String val$since_id;

    public void onClick(View view)
    {
        cess._mth2(this._cls1.this).idkom_pos = val$since_id;
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            if (cess._mth2(this._cls1.this).db.checkIfExistTW(cess._mth2(this._cls1.this).idkom_pos))
            {
                view = new android.app.pos(cess._mth2(this._cls1.this));
                view.arNextAsycTask("Hapus tweet ini dari favorit?");
                view.arNextAsycTask("Ya", new android.content.DialogInterface.OnClickListener() {

                    final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        TwitterInPonsel.KomentarNextAsycTask.access$2(this$1).stat = "0";
                        (new TwitterInPonsel.FavoritTask(TwitterInPonsel.KomentarNextAsycTask.access$2(this$1))).execute(new Void[0]);
                    }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
                });
                view._mth6("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
                });
                view._mth6();
                return;
            } else
            {
                view = new android.app.arNextAsycTask._cls6(cess._mth2(this._cls1.this));
                view.arNextAsycTask("Favoritkan tweet ini?");
                view.arNextAsycTask("Ya", new android.content.DialogInterface.OnClickListener() {

                    final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        TwitterInPonsel.KomentarNextAsycTask.access$2(this$1).stat = "1";
                        (new TwitterInPonsel.FavoritTask(TwitterInPonsel.KomentarNextAsycTask.access$2(this$1))).execute(new Void[0]);
                    }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
                });
                view._mth6("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
                });
                view._mth6();
                return;
            }
        } else
        {
            view = new android.app.arNextAsycTask._cls6(cess._mth2(this._cls1.this).wrapperLight);
            view.rLight("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.rLight("Tutup", new android.content.DialogInterface.OnClickListener() {

                final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Register", new android.content.DialogInterface.OnClickListener() {

                final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(TwitterInPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    TwitterInPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Login", new android.content.DialogInterface.OnClickListener() {

                final TwitterInPonsel.KomentarNextAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(TwitterInPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    TwitterInPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = TwitterInPonsel.KomentarNextAsycTask._cls6.this;
                super();
            }
            });
            view._mth6();
            return;
        }
    }


    _cls7.this._cls2()
    {
        this$1 = final__pcls2;
        val$since_id = String.this;
        super();
    }
}