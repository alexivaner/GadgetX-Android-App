// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;


// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            ContentLoadingSmoothProgressBar

class this._cls0
    implements Runnable
{

    final ContentLoadingSmoothProgressBar this$0;

    public void run()
    {
        ContentLoadingSmoothProgressBar.access$2(ContentLoadingSmoothProgressBar.this, false);
        if (!ContentLoadingSmoothProgressBar.access$3(ContentLoadingSmoothProgressBar.this))
        {
            ContentLoadingSmoothProgressBar.access$1(ContentLoadingSmoothProgressBar.this, System.currentTimeMillis());
            setVisibility(0);
        }
    }

    ()
    {
        this$0 = ContentLoadingSmoothProgressBar.this;
        super();
    }
}
