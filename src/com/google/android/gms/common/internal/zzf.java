// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.internal.zzus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zzf
{

    private final Account zzFN;
    private final List zzMM;
    private final int zzMf;
    private final View zzMg;
    private final String zzMh;
    private final String zzMi;
    private final zzus zzPr;
    private Integer zzPs;

    public zzf(Account account, Collection collection, int i, View view, String s, String s1, zzus zzus)
    {
        zzFN = account;
        if (collection == null)
        {
            account = Collections.EMPTY_LIST;
        } else
        {
            account = Collections.unmodifiableList(new ArrayList(collection));
        }
        zzMM = account;
        zzMg = view;
        zzMf = i;
        zzMh = s;
        zzMi = s1;
        zzPr = zzus;
    }

    public Account getAccount()
    {
        return zzFN;
    }

    public String getAccountName()
    {
        if (zzFN != null)
        {
            return zzFN.name;
        } else
        {
            return null;
        }
    }

    public void zza(Integer integer)
    {
        zzPs = integer;
    }

    public String zziM()
    {
        return zziN().name;
    }

    public Account zziN()
    {
        if (zzFN != null)
        {
            return zzFN;
        } else
        {
            return new Account("<<default account>>", "com.google");
        }
    }

    public int zziO()
    {
        return zzMf;
    }

    public List zziP()
    {
        return zzMM;
    }

    public String[] zziQ()
    {
        return (String[])zzMM.toArray(new String[zzMM.size()]);
    }

    public String zziR()
    {
        return zzMh;
    }

    public String zziS()
    {
        return zzMi;
    }

    public View zziT()
    {
        return zzMg;
    }

    public zzus zziU()
    {
        return zzPr;
    }

    public Integer zziV()
    {
        return zzPs;
    }
}
