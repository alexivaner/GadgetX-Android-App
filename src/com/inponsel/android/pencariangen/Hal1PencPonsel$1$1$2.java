// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel

class this._cls2
    implements Runnable
{

    final this._cls2 this$2;

    public void run()
    {
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencariangen/Hal1PencPonsel$1

/* anonymous class */
    class Hal1PencPonsel._cls1
        implements TextWatcher
    {

        final Hal1PencPonsel this$0;

        public void afterTextChanged(Editable editable)
        {
            Hal1PencPonsel.access$0(Hal1PencPonsel.this, new Timer());
            Hal1PencPonsel.access$1(Hal1PencPonsel.this).schedule(new Hal1PencPonsel._cls1._cls1(), 600L);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            if (Hal1PencPonsel.access$1(Hal1PencPonsel.this) != null)
            {
                Hal1PencPonsel.access$1(Hal1PencPonsel.this).cancel();
            }
        }


            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
    }


    // Unreferenced inner class com/inponsel/android/pencariangen/Hal1PencPonsel$1$1

/* anonymous class */
    class Hal1PencPonsel._cls1._cls1 extends TimerTask
    {

        final Hal1PencPonsel._cls1 this$1;

        public void run()
        {
            getActivity().runOnUiThread(new Hal1PencPonsel._cls1._cls1._cls1());
            try
            {
                Thread.sleep(2000L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            getActivity().runOnUiThread(new Hal1PencPonsel._cls1._cls1._cls2());
        }


            
            {
                this$1 = Hal1PencPonsel._cls1.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencariangen/Hal1PencPonsel$1$1$1

/* anonymous class */
        class Hal1PencPonsel._cls1._cls1._cls1
            implements Runnable
        {

            final Hal1PencPonsel._cls1._cls1 this$2;

            public void run()
            {
                Hal1PencPonsel.access$2(this$0);
            }

                    
                    {
                        this$2 = Hal1PencPonsel._cls1._cls1.this;
                        super();
                    }
        }

    }

}
