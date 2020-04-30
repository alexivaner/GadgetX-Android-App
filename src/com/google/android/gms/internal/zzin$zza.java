// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zzir

public static class 
{

    private List zzFK;
    private String zzFL;
    private boolean zzFM;
    private Account zzFN;

    public  zzH(boolean flag)
    {
        zzFM = flag;
        return this;
    }

    public zzFM zza(Account account)
    {
        zzFN = account;
        return this;
    }

    public zzFN zza(zzir zzir1)
    {
        if (zzFK == null)
        {
            zzFK = new ArrayList();
        }
        zzFK.add(zzir1);
        return this;
    }

    public zzFK zzax(String s)
    {
        zzFL = s;
        return this;
    }

    public zzin zzgU()
    {
        String s = zzFL;
        boolean flag = zzFM;
        Account account = zzFN;
        zzir azzir[];
        if (zzFK != null)
        {
            azzir = (zzir[])zzFK.toArray(new zzir[zzFK.size()]);
        } else
        {
            azzir = null;
        }
        return new zzin(s, flag, account, azzir);
    }

    public ()
    {
    }
}
