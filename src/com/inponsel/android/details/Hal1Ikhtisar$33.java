// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Target;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class val.nativeAdImage
    implements Target
{

    final Hal1Ikhtisar this$0;
    private final ImageView val$nativeAdImage;
    private final View val$vAdUnit;

    public void onBitmapFailed(Drawable drawable)
    {
    }

    public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.om om)
    {
        DisplayMetrics displaymetrics;
        int k;
        int l;
        k = bitmap.getWidth();
        l = bitmap.getHeight();
        om = ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay();
        displaymetrics = new DisplayMetrics();
        om.getMetrics(displaymetrics);
        if (!ad_type.equals("5")) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = displaymetrics.widthPixels - (int)Utility.convertDpToPixel(30F, getActivity());
        i = displaymetrics.heightPixels - (int)Utility.convertDpToPixel(30F, getActivity());
_L3:
        if (!ad_type.equals("3") && !ad_type.equals("4"))
        {
            break MISSING_BLOCK_LABEL_298;
        }
        if (ad_type.equals("3"))
        {
            val$vAdUnit.setLayoutParams(new android.widget.ayoutParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
        }
        val$nativeAdImage.setLayoutParams(new android.widget.ayoutParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
_L4:
        val$nativeAdImage.setImageBitmap(bitmap);
        return;
_L2:
label0:
        {
            if (!ad_type.equals("4"))
            {
                break label0;
            }
            j = displaymetrics.widthPixels - (int)Utility.convertDpToPixel(30F, getActivity());
            i = displaymetrics.heightPixels - (int)Utility.convertDpToPixel(30F, getActivity());
        }
          goto _L3
        try
        {
            j = displaymetrics.widthPixels;
            i = displaymetrics.heightPixels;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return;
        }
          goto _L3
        if (ad_type.equals("3"))
        {
            val$vAdUnit.setLayoutParams(new android.widget.outParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
        }
        val$nativeAdImage.setLayoutParams(new android.widget.outParams(j, Math.min((int)(((double)j / (double)k) * (double)l), i / 3)));
          goto _L4
    }

    public void onPrepareLoad(Drawable drawable)
    {
    }

    ()
    {
        this$0 = final_hal1ikhtisar;
        val$vAdUnit = view;
        val$nativeAdImage = ImageView.this;
        super();
    }
}
