// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzju

class zzKJ
    implements Runnable
{

    final zzju zzKI;
    final int zzKJ;
    final zzKJ zzKK;

    public void run()
    {
        if (zzju.zze(zzKI) != null)
        {
            zzju.zze(zzKI).onApplicationDisconnected(zzKJ);
        }
    }

    ( , zzju zzju1, int i)
    {
        zzKK = ;
        zzKI = zzju1;
        zzKJ = i;
        super();
    }
}
