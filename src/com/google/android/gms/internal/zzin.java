// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzio, zziy, zzir

public class zzin
    implements SafeParcelable
{
    public static class zza
    {

        private List zzFK;
        private String zzFL;
        private boolean zzFM;
        private Account zzFN;

        public zza zzH(boolean flag)
        {
            zzFM = flag;
            return this;
        }

        public zza zza(Account account1)
        {
            zzFN = account1;
            return this;
        }

        public zza zza(zzir zzir1)
        {
            if (zzFK == null)
            {
                zzFK = new ArrayList();
            }
            zzFK.add(zzir1);
            return this;
        }

        public zza zzax(String s)
        {
            zzFL = s;
            return this;
        }

        public zzin zzgU()
        {
            String s = zzFL;
            boolean flag = zzFM;
            Account account1 = zzFN;
            zzir azzir[];
            if (zzFK != null)
            {
                azzir = (zzir[])zzFK.toArray(new zzir[zzFK.size()]);
            } else
            {
                azzir = null;
            }
            return new zzin(s, flag, account1, azzir);
        }

        public zza()
        {
        }
    }


    public static final zzio CREATOR = new zzio();
    public final Account account;
    final int zzFG;
    final zzir zzFH[];
    public final String zzFI;
    public final boolean zzFJ;

    zzin(int i, zzir azzir[], String s, boolean flag, Account account1)
    {
        zzFG = i;
        zzFH = azzir;
        zzFI = s;
        zzFJ = flag;
        account = account1;
    }

    transient zzin(String s, boolean flag, Account account1, zzir azzir[])
    {
        this(1, azzir, s, flag, account1);
        s = new BitSet(zziy.zzgW());
        for (int i = 0; i < azzir.length; i++)
        {
            int j = azzir[i].zzFV;
            if (j == -1)
            {
                continue;
            }
            if (s.get(j))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Duplicate global search section type ").append(zziy.zzV(j)).toString());
            }
            s.set(j);
        }

    }

    public int describeContents()
    {
        zzio zzio1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzio zzio1 = CREATOR;
        zzio.zza(this, parcel, i);
    }

}
