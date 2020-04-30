// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzwx, zzwo

public abstract class zzqj extends zzd
{

    private final String TAG = "SafeDataBufferRef";

    public zzqj(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    protected int zzC(String s, int i)
    {
        int j = i;
        if (zzba(s))
        {
            j = i;
            if (!zzbc(s))
            {
                j = getInteger(s);
            }
        }
        return j;
    }

    protected float zza(String s, float f)
    {
        float f1 = f;
        if (zzba(s))
        {
            f1 = f;
            if (!zzbc(s))
            {
                f1 = getFloat(s);
            }
        }
        return f1;
    }

    protected SafeParcelable zza(String s, android.os.Parcelable.Creator creator)
    {
        s = zzd(s, null);
        if (s == null)
        {
            return null;
        } else
        {
            return zzc.zza(s, creator);
        }
    }

    protected List zza(String s, android.os.Parcelable.Creator creator, List list)
    {
        s = zzd(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        zzwo zzwo1;
        return list;
_L2:
        byte abyte0[][];
        int j;
        if ((zzwo1 = zzwo.zzr(s)).zzaHn == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = new ArrayList(zzwo1.zzaHn.length);
        abyte0 = zzwo1.zzaHn;
        j = abyte0.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s.add(zzc.zza(abyte0[i], creator));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        return s;
        s;
        if (Log.isLoggable("SafeDataBufferRef", 6))
        {
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", s);
            return list;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected List zza(String s, List list)
    {
        s = zzd(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        return list;
_L2:
        ArrayList arraylist;
        if (((zzwo) (s = zzwo.zzr(s))).zzaHm == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist = new ArrayList(((zzwo) (s)).zzaHm.length);
        int i = 0;
_L4:
        if (i >= ((zzwo) (s)).zzaHm.length)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Integer.valueOf(((zzwo) (s)).zzaHm[i]));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        return arraylist;
        s;
        if (Log.isLoggable("SafeDataBufferRef", 6))
        {
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", s);
            return list;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected List zzb(String s, List list)
    {
        s = zzd(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        return list;
_L2:
        if (((zzwo) (s = zzwo.zzr(s))).zzaHl == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = Arrays.asList(((zzwo) (s)).zzaHl);
        return s;
        s;
        if (Log.isLoggable("SafeDataBufferRef", 6))
        {
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", s);
            return list;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected byte[] zzd(String s, byte abyte0[])
    {
        byte abyte1[] = abyte0;
        if (zzba(s))
        {
            abyte1 = abyte0;
            if (!zzbc(s))
            {
                abyte1 = getByteArray(s);
            }
        }
        return abyte1;
    }

    protected boolean zzj(String s, boolean flag)
    {
        boolean flag1 = flag;
        if (zzba(s))
        {
            flag1 = flag;
            if (!zzbc(s))
            {
                flag1 = getBoolean(s);
            }
        }
        return flag1;
    }

    protected String zzz(String s, String s1)
    {
        String s2 = s1;
        if (zzba(s))
        {
            s2 = s1;
            if (!zzbc(s))
            {
                s2 = getString(s);
            }
        }
        return s2;
    }
}
