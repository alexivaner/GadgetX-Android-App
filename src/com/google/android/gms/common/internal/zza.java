// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzq

public class zza extends zzq.zza
{

    private Context mContext;
    private Account zzFN;
    int zzPm;

    public static Account zzc(zzq zzq1)
    {
        Account account;
        long l;
        account = null;
        if (zzq1 == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        l = Binder.clearCallingIdentity();
        account = zzq1.getAccount();
        Binder.restoreCallingIdentity(l);
        return account;
        zzq1;
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
        return null;
        zzq1;
        Binder.restoreCallingIdentity(l);
        throw zzq1;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof zza))
        {
            return false;
        } else
        {
            return zzFN.equals(((zza)obj).zzFN);
        }
    }

    public Account getAccount()
    {
        int i = Binder.getCallingUid();
        if (i == zzPm)
        {
            return zzFN;
        }
        if (GooglePlayServicesUtil.zzd(mContext, i))
        {
            zzPm = i;
            return zzFN;
        } else
        {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }
}
