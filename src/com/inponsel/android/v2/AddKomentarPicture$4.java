// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            AddKomentarPicture

class this._cls0
    implements android.content.ckListener
{

    final AddKomentarPicture this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        AddKomentarPicture.access$5(AddKomentarPicture.this, AddKomentarPicture.access$4(AddKomentarPicture.this));
        AddKomentarPicture.access$5(AddKomentarPicture.this, AddKomentarPicture.access$6(AddKomentarPicture.this));
        if (i == 0)
        {
            AddKomentarPicture.access$7(AddKomentarPicture.this);
        } else
        {
            AddKomentarPicture.access$8(AddKomentarPicture.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    er()
    {
        this$0 = AddKomentarPicture.this;
        super();
    }
}
