// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls1
    implements Runnable
{

    final form this$1;

    public void run()
    {
        passform.setVisibility(8);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$6

/* anonymous class */
    class ProfileActivity._cls6
        implements android.view.View.OnClickListener
    {

        final ProfileActivity this$0;

        public void onClick(View view)
        {
            imgArrowPass.setBackgroundColor(0);
            if (passform.getVisibility() == 0)
            {
                animationout.setDuration(500L);
                passform.startAnimation(animationout);
                backrotateView(imgArrowPass);
                (new Handler()).postDelayed(new ProfileActivity._cls6._cls1(), 400L);
                return;
            } else
            {
                animationin.setDuration(500L);
                passform.startAnimation(animationin);
                rotateView(imgArrowPass);
                (new Handler()).postDelayed(new ProfileActivity._cls6._cls2(), 200L);
                return;
            }
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$6$2

/* anonymous class */
        class ProfileActivity._cls6._cls2
            implements Runnable
        {

            final ProfileActivity._cls6 this$1;

            public void run()
            {
                passform.setVisibility(0);
            }

                    
                    {
                        this$1 = ProfileActivity._cls6.this;
                        super();
                    }
        }

    }

}
