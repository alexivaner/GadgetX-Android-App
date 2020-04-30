// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.app.ProgressDialog;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            Util, MonitoredActivity

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        cess._mth0(this._cls1.this).removeLifeCycleListener(this._cls1.this);
        if (cess._mth1(this._cls1.this).getWindow() != null)
        {
            cess._mth1(this._cls1.this).dismiss();
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
