// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.share.widget.ShareDialog;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class istAdapter
    implements android.content.ace.OnClickListener
{

    final Hal2Spek this$0;
    private final ShareIntentListAdapter val$objShareIntentListAdapter;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (ResolveInfo)val$objShareIntentListAdapter.getItem(i);
        if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
        {
            Log.e("share", "facebook");
            dialoginterface = ((com.facebook.share.model.tent.Builder)(new com.facebook.share.model.tent.Builder()).setContentTitle((new StringBuilder(String.valueOf(namalengkap))).append(" - Berita, Spesifikasi, Review, Galeri foto, Harga, Service Center").toString()).setImageUrl(Uri.parse(gambar)).setContentDescription((new StringBuilder("Spesifikasi lengkap ")).append(namalengkap).append(". Diumumkan pada ").append(str_share_diumumkan).append(". Fitur ").append(str_share_desc).toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
            shareDialog.show(dialoginterface);
            return;
        } else
        {
            Log.e("share", "other");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString());
            intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder("Spesifikasi ")).append(namalengkap).toString());
            Log.e("share", str_urlspekshare);
            intent.putExtra("android.intent.extra.TITLE", (new StringBuilder("Spesifikasi ")).append(namalengkap).toString());
            startActivity(intent);
            return;
        }
    }

    istAdapter()
    {
        this$0 = final_hal2spek;
        val$objShareIntentListAdapter = ShareIntentListAdapter.this;
        super();
    }
}
