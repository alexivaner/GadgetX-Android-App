// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zztr

public class zzts
    implements android.os.Parcelable.Creator
{

    public zzts()
    {
    }

    static void zza(zztr zztr1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        Set set = zztr1.zzauX;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, zztr1.zzFG);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zza(parcel, 2, zztr1.zzauY, i, true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zzb(parcel, 3, zztr1.zzauZ, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zza(parcel, 4, zztr1.zzava, i, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            zzb.zza(parcel, 5, zztr1.zzavb, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            zzb.zza(parcel, 6, zztr1.zzavc, true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            zzb.zza(parcel, 7, zztr1.zzavd, true);
        }
        if (set.contains(Integer.valueOf(8)))
        {
            zzb.zzc(parcel, 8, zztr1.zzave, true);
        }
        if (set.contains(Integer.valueOf(9)))
        {
            zzb.zzc(parcel, 9, zztr1.zzavf);
        }
        if (set.contains(Integer.valueOf(10)))
        {
            zzb.zzc(parcel, 10, zztr1.zzavg, true);
        }
        if (set.contains(Integer.valueOf(11)))
        {
            zzb.zza(parcel, 11, zztr1.zzavh, i, true);
        }
        if (set.contains(Integer.valueOf(12)))
        {
            zzb.zzc(parcel, 12, zztr1.zzavi, true);
        }
        if (set.contains(Integer.valueOf(13)))
        {
            zzb.zza(parcel, 13, zztr1.zzavj, true);
        }
        if (set.contains(Integer.valueOf(14)))
        {
            zzb.zza(parcel, 14, zztr1.zzavk, true);
        }
        if (set.contains(Integer.valueOf(15)))
        {
            zzb.zza(parcel, 15, zztr1.zzavl, i, true);
        }
        if (set.contains(Integer.valueOf(17)))
        {
            zzb.zza(parcel, 17, zztr1.zzavn, true);
        }
        if (set.contains(Integer.valueOf(16)))
        {
            zzb.zza(parcel, 16, zztr1.zzavm, true);
        }
        if (set.contains(Integer.valueOf(19)))
        {
            zzb.zzc(parcel, 19, zztr1.zzavo, true);
        }
        if (set.contains(Integer.valueOf(18)))
        {
            zzb.zza(parcel, 18, zztr1.zzpn, true);
        }
        if (set.contains(Integer.valueOf(21)))
        {
            zzb.zza(parcel, 21, zztr1.zzavq, true);
        }
        if (set.contains(Integer.valueOf(20)))
        {
            zzb.zza(parcel, 20, zztr1.zzavp, true);
        }
        if (set.contains(Integer.valueOf(23)))
        {
            zzb.zza(parcel, 23, zztr1.zzZO, true);
        }
        if (set.contains(Integer.valueOf(22)))
        {
            zzb.zza(parcel, 22, zztr1.zzavr, true);
        }
        if (set.contains(Integer.valueOf(25)))
        {
            zzb.zza(parcel, 25, zztr1.zzavt, true);
        }
        if (set.contains(Integer.valueOf(24)))
        {
            zzb.zza(parcel, 24, zztr1.zzavs, true);
        }
        if (set.contains(Integer.valueOf(27)))
        {
            zzb.zza(parcel, 27, zztr1.zzavv, true);
        }
        if (set.contains(Integer.valueOf(26)))
        {
            zzb.zza(parcel, 26, zztr1.zzavu, true);
        }
        if (set.contains(Integer.valueOf(29)))
        {
            zzb.zza(parcel, 29, zztr1.zzavx, i, true);
        }
        if (set.contains(Integer.valueOf(28)))
        {
            zzb.zza(parcel, 28, zztr1.zzavw, true);
        }
        if (set.contains(Integer.valueOf(31)))
        {
            zzb.zza(parcel, 31, zztr1.zzavz, true);
        }
        if (set.contains(Integer.valueOf(30)))
        {
            zzb.zza(parcel, 30, zztr1.zzavy, true);
        }
        if (set.contains(Integer.valueOf(34)))
        {
            zzb.zza(parcel, 34, zztr1.zzavB, i, true);
        }
        if (set.contains(Integer.valueOf(32)))
        {
            zzb.zza(parcel, 32, zztr1.zzFA, true);
        }
        if (set.contains(Integer.valueOf(33)))
        {
            zzb.zza(parcel, 33, zztr1.zzavA, true);
        }
        if (set.contains(Integer.valueOf(38)))
        {
            zzb.zza(parcel, 38, zztr1.zzalR);
        }
        if (set.contains(Integer.valueOf(39)))
        {
            zzb.zza(parcel, 39, zztr1.mName, true);
        }
        if (set.contains(Integer.valueOf(36)))
        {
            zzb.zza(parcel, 36, zztr1.zzalQ);
        }
        if (set.contains(Integer.valueOf(37)))
        {
            zzb.zza(parcel, 37, zztr1.zzavC, i, true);
        }
        if (set.contains(Integer.valueOf(42)))
        {
            zzb.zza(parcel, 42, zztr1.zzavF, true);
        }
        if (set.contains(Integer.valueOf(43)))
        {
            zzb.zza(parcel, 43, zztr1.zzavG, true);
        }
        if (set.contains(Integer.valueOf(40)))
        {
            zzb.zza(parcel, 40, zztr1.zzavD, i, true);
        }
        if (set.contains(Integer.valueOf(41)))
        {
            zzb.zzc(parcel, 41, zztr1.zzavE, true);
        }
        if (set.contains(Integer.valueOf(46)))
        {
            zzb.zza(parcel, 46, zztr1.zzavJ, i, true);
        }
        if (set.contains(Integer.valueOf(47)))
        {
            zzb.zza(parcel, 47, zztr1.zzavK, true);
        }
        if (set.contains(Integer.valueOf(44)))
        {
            zzb.zza(parcel, 44, zztr1.zzavH, true);
        }
        if (set.contains(Integer.valueOf(45)))
        {
            zzb.zza(parcel, 45, zztr1.zzavI, true);
        }
        if (set.contains(Integer.valueOf(51)))
        {
            zzb.zza(parcel, 51, zztr1.zzavO, true);
        }
        if (set.contains(Integer.valueOf(50)))
        {
            zzb.zza(parcel, 50, zztr1.zzavN, i, true);
        }
        if (set.contains(Integer.valueOf(49)))
        {
            zzb.zza(parcel, 49, zztr1.zzavM, true);
        }
        if (set.contains(Integer.valueOf(48)))
        {
            zzb.zza(parcel, 48, zztr1.zzavL, true);
        }
        if (set.contains(Integer.valueOf(55)))
        {
            zzb.zza(parcel, 55, zztr1.zzavQ, true);
        }
        if (set.contains(Integer.valueOf(54)))
        {
            zzb.zza(parcel, 54, zztr1.zzxX, true);
        }
        if (set.contains(Integer.valueOf(53)))
        {
            zzb.zza(parcel, 53, zztr1.zzxV, true);
        }
        if (set.contains(Integer.valueOf(52)))
        {
            zzb.zza(parcel, 52, zztr1.zzavP, true);
        }
        if (set.contains(Integer.valueOf(56)))
        {
            zzb.zza(parcel, 56, zztr1.zzavR, true);
        }
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzez(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgM(i);
    }

    public zztr zzez(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        zztr zztr10 = null;
        java.util.ArrayList arraylist5 = null;
        zztr zztr9 = null;
        String s34 = null;
        String s33 = null;
        String s32 = null;
        java.util.ArrayList arraylist4 = null;
        int i = 0;
        java.util.ArrayList arraylist3 = null;
        zztr zztr8 = null;
        java.util.ArrayList arraylist2 = null;
        String s31 = null;
        String s30 = null;
        zztr zztr7 = null;
        String s29 = null;
        String s28 = null;
        String s27 = null;
        java.util.ArrayList arraylist1 = null;
        String s26 = null;
        String s25 = null;
        String s24 = null;
        String s23 = null;
        String s22 = null;
        String s21 = null;
        String s20 = null;
        String s19 = null;
        String s18 = null;
        zztr zztr6 = null;
        String s17 = null;
        String s16 = null;
        String s15 = null;
        String s14 = null;
        zztr zztr5 = null;
        double d1 = 0.0D;
        zztr zztr4 = null;
        double d = 0.0D;
        String s13 = null;
        zztr zztr3 = null;
        java.util.ArrayList arraylist = null;
        String s12 = null;
        String s11 = null;
        String s10 = null;
        String s9 = null;
        zztr zztr2 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        zztr zztr1 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(l))
                {
                case 35: // '#'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    zztr10 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    arraylist5 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, l);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    zztr9 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s34 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    s33 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    s32 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(7));
                    break;

                case 8: // '\b'
                    arraylist4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(8));
                    break;

                case 9: // '\t'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(9));
                    break;

                case 10: // '\n'
                    arraylist3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(10));
                    break;

                case 11: // '\013'
                    zztr8 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(11));
                    break;

                case 12: // '\f'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(12));
                    break;

                case 13: // '\r'
                    s31 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(13));
                    break;

                case 14: // '\016'
                    s30 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(14));
                    break;

                case 15: // '\017'
                    zztr7 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(15));
                    break;

                case 17: // '\021'
                    s28 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(17));
                    break;

                case 16: // '\020'
                    s29 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(16));
                    break;

                case 19: // '\023'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(19));
                    break;

                case 18: // '\022'
                    s27 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(18));
                    break;

                case 21: // '\025'
                    s25 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(21));
                    break;

                case 20: // '\024'
                    s26 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(20));
                    break;

                case 23: // '\027'
                    s23 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(23));
                    break;

                case 22: // '\026'
                    s24 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(22));
                    break;

                case 25: // '\031'
                    s21 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(25));
                    break;

                case 24: // '\030'
                    s22 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(24));
                    break;

                case 27: // '\033'
                    s19 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(27));
                    break;

                case 26: // '\032'
                    s20 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(26));
                    break;

                case 29: // '\035'
                    zztr6 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(29));
                    break;

                case 28: // '\034'
                    s18 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(28));
                    break;

                case 31: // '\037'
                    s16 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(31));
                    break;

                case 30: // '\036'
                    s17 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(30));
                    break;

                case 34: // '"'
                    zztr5 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(34));
                    break;

                case 32: // ' '
                    s15 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(32));
                    break;

                case 33: // '!'
                    s14 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(33));
                    break;

                case 38: // '&'
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, l);
                    hashset.add(Integer.valueOf(38));
                    break;

                case 39: // '\''
                    s13 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(39));
                    break;

                case 36: // '$'
                    d1 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, l);
                    hashset.add(Integer.valueOf(36));
                    break;

                case 37: // '%'
                    zztr4 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(37));
                    break;

                case 42: // '*'
                    s12 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(42));
                    break;

                case 43: // '+'
                    s11 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(43));
                    break;

                case 40: // '('
                    zztr3 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(40));
                    break;

                case 41: // ')'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(41));
                    break;

                case 46: // '.'
                    zztr2 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(46));
                    break;

                case 47: // '/'
                    s8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(47));
                    break;

                case 44: // ','
                    s10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(44));
                    break;

                case 45: // '-'
                    s9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(45));
                    break;

                case 51: // '3'
                    s5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(51));
                    break;

                case 50: // '2'
                    zztr1 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztr.CREATOR);
                    hashset.add(Integer.valueOf(50));
                    break;

                case 49: // '1'
                    s6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(49));
                    break;

                case 48: // '0'
                    s7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(48));
                    break;

                case 55: // '7'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(55));
                    break;

                case 54: // '6'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(54));
                    break;

                case 53: // '5'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(53));
                    break;

                case 52: // '4'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(52));
                    break;

                case 56: // '8'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(56));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != k)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
                }
                return new zztr(hashset, j, zztr10, arraylist5, zztr9, s34, s33, s32, arraylist4, i, arraylist3, zztr8, arraylist2, s31, s30, zztr7, s29, s28, s27, arraylist1, s26, s25, s24, s23, s22, s21, s20, s19, s18, zztr6, s17, s16, s15, s14, zztr5, d1, zztr4, d, s13, zztr3, arraylist, s12, s11, s10, s9, zztr2, s8, s7, s6, zztr1, s5, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public zztr[] zzgM(int i)
    {
        return new zztr[i];
    }
}
