// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.graphics.drawable.Drawable;
import com.inponsel.android.utils.Log;
import java.io.IOException;
import java.net.URL;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements android.text.tail.Hal1RSSDetail._cls27
{

    final Hal1RSSDetail this$0;

    public Drawable getDrawable(String s)
    {
        try
        {
            s = Drawable.createFromStream((new URL(s)).openStream(), "src name");
            s.setBounds(0, 0, s.getIntrinsicWidth(), s.getIntrinsicHeight());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.v("IOException", s.getMessage());
            return null;
        }
        return s;
    }

    _cls9()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
