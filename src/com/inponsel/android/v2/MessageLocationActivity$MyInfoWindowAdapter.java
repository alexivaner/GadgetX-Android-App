// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.inponsel.android.v2:
//            MessageLocationActivity

class myContentsView
    implements com.google.android.gms.maps.ntentsView
{

    private final View myContentsView;
    final MessageLocationActivity this$0;

    public View getInfoContents(Marker marker)
    {
        ((TextView)myContentsView.findViewById(0x7f0b0084)).setText(marker.getTitle());
        ((TextView)myContentsView.findViewById(0x7f0b0085)).setText(marker.getSnippet());
        return myContentsView;
    }

    public View getInfoWindow(Marker marker)
    {
        return null;
    }

    I()
    {
        this$0 = MessageLocationActivity.this;
        super();
        myContentsView = getLayoutInflater().inflate(0x7f030022, null);
    }
}
