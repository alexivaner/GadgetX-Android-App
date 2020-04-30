// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            ImageFullActivity

class this._cls0
    implements android.view.
{

    final ImageFullActivity this$0;

    public void onClick(View view)
    {
        lastSlash = imageUrls[pagerPosition].toString().lastIndexOf('/');
        lastSlash = imageUrls[pagerPosition].toString().lastIndexOf('_');
        fileName = "file.bin";
        if (lastSlash >= 0)
        {
            fileName = imageUrls[pagerPosition].toString().substring(lastSlash + 1);
        }
        if (fileName.equals(""))
        {
            fileName = "file.bin";
        }
        ImageFullActivity.access$5(ImageFullActivity.this, (NotificationManager)getSystemService("notification"));
        ImageFullActivity.access$6(ImageFullActivity.this, new android.support.v4.app.uilder(ImageFullActivity.this));
        ImageFullActivity.access$1(ImageFullActivity.this).setContentTitle("InPonsel").setContentText("Download image in progress").setSmallIcon(0x7f02023f).setLargeIcon(ImageFullActivity.getBitmapFromURL(imageUrls[pagerPosition], getApplicationContext()));
        (new wnloadFileFromURL(ImageFullActivity.this)).execute(new String[] {
            imageUrls[pagerPosition]
        });
    }

    wnloadFileFromURL()
    {
        this$0 = ImageFullActivity.this;
        super();
    }
}
