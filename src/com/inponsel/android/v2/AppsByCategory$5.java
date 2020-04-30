// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory, RegisterActivity, LoginActivity

class this._cls0
    implements android.view.ner
{

    final AppsByCategory this$0;

    public void onClick(final View urlPost)
    {
        if (userFunctions.isUserLoggedIn(AppsByCategory.this))
        {
            Log.e("postfav", txt_fav_kat_apps_1.getText().toString());
            if (txt_fav_kat_apps_1.getText().toString().equals("1"))
            {
                fav_stat = "0";
            } else
            {
                fav_stat = "1";
            }
            urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=").append(t).append("&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(str_id).toString();
            (new AsyncHttpClient()).get(urlPost, new AsyncHttpResponseHandler() {

                final AppsByCategory._cls5 this$1;
                private final String val$urlPost;

                public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                {
                }

                public void onRetry(int i)
                {
                }

                public void onStart()
                {
                    if (fav_stat.equals("1"))
                    {
                        notificationLikeHelper.createNotification(str_title_cat, "Menambahkan ke favorit");
                    } else
                    {
                        notificationLikeHelper.createNotification(str_title_cat, "Menghapus ke favorit");
                    }
                    Log.e("urlPost", urlPost);
                }

                public void onSuccess(int i, Header aheader[], byte abyte0[])
                {
                    aheader = new String(abyte0);
                    Log.e("respJson", aheader);
                    try
                    {
                        aheader = new JSONObject(aheader);
                        fav_stat = aheader.getString("success");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Header aheader[]) { }
                    if (fav_stat.equals("0"))
                    {
                        img_fav_apps_1.setBackgroundResource(0x7f020302);
                    } else
                    {
                        img_fav_apps_1.setBackgroundResource(0x7f020303);
                    }
                    if (fav_stat.equals("1"))
                    {
                        notificationLikeHelper.completed(str_title_cat, "Berhasil menambahkan ke favorit");
                    } else
                    {
                        notificationLikeHelper.completed(str_title_cat, "Berhasil menghapus ke favorit");
                    }
                    txt_fav_kat_apps_1.setText(fav_stat);
                    ponselBaseApp.setObserver().setIndexHp(str_id);
                    ponselBaseApp.setObserver().setUpdateType("favappsstore");
                    ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
                }

            
            {
                this$1 = AppsByCategory._cls5.this;
                urlPost = s;
                super();
            }
            });
            return;
        } else
        {
            urlPost = new android.app.er(AppsByCategory.this);
            urlPost.setMessage("Untuk menambah ke favorit harus login terlebih dahulu.");
            urlPost.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory._cls5 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = AppsByCategory._cls5.this;
                super();
            }
            });
            urlPost.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory._cls5 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = AppsByCategory._cls5.this;
                super();
            }
            });
            urlPost.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final AppsByCategory._cls5 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = AppsByCategory._cls5.this;
                super();
            }
            });
            urlPost.show();
            return;
        }
    }


    _cls4.this._cls1()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
