// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;


// Referenced classes of package com.inponsel.android.timelinedetail:
//            ReplyKomTLActivity

class this._cls1
    implements com.inponsel.android.utils.stener
{

    final this._cls1 this$1;

    public void transferred(long l)
    {
        cess._mth3(this._cls1.this, new Integer[] {
            Integer.valueOf((int)(((float)l / (float)cess._mth5(this._cls1.this).totalSize) * 100F))
        });
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
