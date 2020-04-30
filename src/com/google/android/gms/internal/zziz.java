// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzja, zzit

public class zziz
    implements SafeParcelable
{
    public static final class zza
    {

        private final String mName;
        private String zzGo;
        private boolean zzGp;
        private int zzGq;
        private boolean zzGr;
        private String zzGs;
        private final List zzGt = new ArrayList();
        private BitSet zzGu;
        private String zzGv;

        public zza zzI(boolean flag)
        {
            zzGp = flag;
            return this;
        }

        public zza zzJ(boolean flag)
        {
            zzGr = flag;
            return this;
        }

        public zza zzW(int i)
        {
            if (zzGu == null)
            {
                zzGu = new BitSet();
            }
            zzGu.set(i);
            return this;
        }

        public zza zzaA(String s)
        {
            zzGv = s;
            return this;
        }

        public zza zzaz(String s)
        {
            zzGo = s;
            return this;
        }

        public zziz zzgX()
        {
            int i = 0;
            int ai[] = null;
            if (zzGu != null)
            {
                int ai1[] = new int[zzGu.cardinality()];
                int j = zzGu.nextSetBit(0);
                do
                {
                    ai = ai1;
                    if (j < 0)
                    {
                        break;
                    }
                    ai1[i] = j;
                    j = zzGu.nextSetBit(j + 1);
                    i++;
                } while (true);
            }
            return new zziz(mName, zzGo, zzGp, zzGq, zzGr, zzGs, (zzit[])zzGt.toArray(new zzit[zzGt.size()]), ai, zzGv);
        }

        public zza(String s)
        {
            mName = s;
            zzGq = 1;
        }
    }


    public static final zzja CREATOR = new zzja();
    public final String name;
    public final int weight;
    final int zzFG;
    public final String zzGh;
    public final boolean zzGi;
    public final boolean zzGj;
    public final String zzGk;
    public final zzit zzGl[];
    final int zzGm[];
    public final String zzGn;

    zziz(int i, String s, String s1, boolean flag, int j, boolean flag1, String s2, 
            zzit azzit[], int ai[], String s3)
    {
        zzFG = i;
        name = s;
        zzGh = s1;
        zzGi = flag;
        weight = j;
        zzGj = flag1;
        zzGk = s2;
        zzGl = azzit;
        zzGm = ai;
        zzGn = s3;
    }

    zziz(String s, String s1, boolean flag, int i, boolean flag1, String s2, zzit azzit[], 
            int ai[], String s3)
    {
        this(2, s, s1, flag, i, flag1, s2, azzit, ai, s3);
    }

    public int describeContents()
    {
        zzja zzja1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof zziz)
        {
            obj = (zziz)obj;
            flag = flag1;
            if (name.equals(((zziz) (obj)).name))
            {
                flag = flag1;
                if (zzGh.equals(((zziz) (obj)).zzGh))
                {
                    flag = flag1;
                    if (zzGi == ((zziz) (obj)).zzGi)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzja zzja1 = CREATOR;
        zzja.zza(this, parcel, i);
    }

}
