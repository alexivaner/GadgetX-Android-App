// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zziw, zzix

public class zziv
{
    public static class zza
        implements SafeParcelable
    {

        public static final zziw CREATOR = new zziw();
        final int zzFG;
        public final Account zzFY;
        public final boolean zzFZ;
        public final boolean zzGa;
        public final boolean zzGb;

        public int describeContents()
        {
            zziw zziw1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zziw zziw1 = CREATOR;
            zziw.zza(this, parcel, i);
        }


        public zza()
        {
            this(null, false, false, false);
        }

        zza(int i, Account account, boolean flag, boolean flag1, boolean flag2)
        {
            zzFG = i;
            zzFY = account;
            zzFZ = flag;
            zzGa = flag1;
            zzGb = flag2;
        }

        public zza(Account account, boolean flag, boolean flag1, boolean flag2)
        {
            this(1, account, flag, flag1, flag2);
        }
    }

    public static class zzb
        implements Result, SafeParcelable
    {

        public static final zzix CREATOR = new zzix();
        final int zzFG;
        public Status zzGc;
        public List zzGd;
        public String zzGe[];

        public int describeContents()
        {
            zzix zzix1 = CREATOR;
            return 0;
        }

        public Status getStatus()
        {
            return zzGc;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzix zzix1 = CREATOR;
            zzix.zza(this, parcel, i);
        }


        public zzb()
        {
            zzFG = 1;
        }

        zzb(int i, Status status, List list, String as[])
        {
            zzFG = i;
            zzGc = status;
            zzGd = list;
            zzGe = as;
        }
    }

}
