// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class this._cls0
    implements android.widget.heckedChangeListener
{

    final PostGlobalForum this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (cb_ForumIOS.isChecked())
        {
            compoundbutton = PostGlobalForum.this;
            compoundbutton.forum_tag = (new StringBuilder(String.valueOf(((PostGlobalForum) (compoundbutton)).forum_tag))).append("ios,").toString();
        } else
        {
            forum_tag = forum_tag.replace("ios,", "");
        }
        if (cb_ForumAndroid.isChecked() || cb_ForumBlackberry.isChecked() || cb_ForumIOS.isChecked() || cb_ForumWP.isChecked())
        {
            btnPostForumNext.setEnabled(true);
            return;
        } else
        {
            btnPostForumNext.setEnabled(false);
            return;
        }
    }

    er()
    {
        this$0 = PostGlobalForum.this;
        super();
    }
}
