// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.share.widget.ShareDialog;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class apter
    implements android.content.OnClickListener
{

    final Hal1SCDetail this$0;
    private final ShareIntentListAdapter val$objShareIntentListAdapter;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (ResolveInfo)val$objShareIntentListAdapter.getItem(i);
        if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
        {
            Log.e("share", "facebook");
            dialoginterface = ((com.facebook.share.model..Builder)(new com.facebook.share.model..Builder()).setContentTitle((new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString()).setImageUrl(Uri.parse(str_share_image)).setContentDescription((new StringBuilder("Service center ")).append(str_SC_merk).append(" terlengkap di Indonesia. Dari Sabang sampai Merauke").toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
            shareDialog.show(dialoginterface);
            return;
        } else
        {
            Log.e("share", "other");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str_urlspekshare);
            intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString());
            Log.e("share", str_urlspekshare);
            intent.putExtra("android.intent.extra.TITLE", (new StringBuilder(String.valueOf(str_SC_merk))).append(" ").append(str_SC_NAMA).toString());
            startActivity(intent);
            return;
        }
    }

    apter()
    {
        this$0 = final_hal1scdetail;
        val$objShareIntentListAdapter = ShareIntentListAdapter.this;
        super();
    }
}
