// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.share.widget.ShareDialog;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            BandingkanPonsel

class tAdapter
    implements android.content.lickListener
{

    final BandingkanPonsel this$0;
    private final ShareIntentListAdapter val$objShareIntentListAdapter;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (ResolveInfo)val$objShareIntentListAdapter.getItem(i);
        if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
        {
            Log.e("share", "facebook");
            dialoginterface = ((com.facebook.share.model.ilder)(new com.facebook.share.model.ilder()).setContentTitle((new StringBuilder(String.valueOf(namalengkapp1))).append(" vs ").append(namalengkapp2).toString()).setImageUrl(Uri.parse(gambarp1)).setContentDescription((new StringBuilder("Komparasi lengkap ")).append(namalengkapp1).append(" vs ").append(namalengkapp2).toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
            shareDialog.show(dialoginterface);
            return;
        } else
        {
            Log.e("share", "other");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str_urlspekshare);
            intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder("Komparasi lengkap ")).append(namalengkapp1).append(" vs ").append(namalengkapp2).toString());
            Log.e("share", str_urlspekshare);
            intent.putExtra("android.intent.extra.TITLE", (new StringBuilder(String.valueOf(namalengkapp1))).append(" vs ").append(namalengkapp2).toString());
            startActivity(intent);
            return;
        }
    }

    tAdapter()
    {
        this$0 = final_bandingkanponsel;
        val$objShareIntentListAdapter = ShareIntentListAdapter.this;
        super();
    }
}
