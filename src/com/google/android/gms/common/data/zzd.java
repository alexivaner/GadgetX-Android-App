// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class zzd
{

    protected final DataHolder zzMd;
    protected int zzNQ;
    private int zzNR;

    public zzd(DataHolder dataholder, int i)
    {
        zzMd = (DataHolder)zzx.zzl(dataholder);
        zzav(i);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof zzd)
        {
            obj = (zzd)obj;
            flag = flag1;
            if (zzw.equal(Integer.valueOf(((zzd) (obj)).zzNQ), Integer.valueOf(zzNQ)))
            {
                flag = flag1;
                if (zzw.equal(Integer.valueOf(((zzd) (obj)).zzNR), Integer.valueOf(zzNR)))
                {
                    flag = flag1;
                    if (((zzd) (obj)).zzMd == zzMd)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected boolean getBoolean(String s)
    {
        return zzMd.zzd(s, zzNQ, zzNR);
    }

    protected byte[] getByteArray(String s)
    {
        return zzMd.zzf(s, zzNQ, zzNR);
    }

    protected float getFloat(String s)
    {
        return zzMd.zze(s, zzNQ, zzNR);
    }

    protected int getInteger(String s)
    {
        return zzMd.zzb(s, zzNQ, zzNR);
    }

    protected long getLong(String s)
    {
        return zzMd.zza(s, zzNQ, zzNR);
    }

    protected String getString(String s)
    {
        return zzMd.zzc(s, zzNQ, zzNR);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzNQ), Integer.valueOf(zzNR), zzMd
        });
    }

    public boolean isDataValid()
    {
        return !zzMd.isClosed();
    }

    protected void zza(String s, CharArrayBuffer chararraybuffer)
    {
        zzMd.zza(s, zzNQ, zzNR, chararraybuffer);
    }

    protected void zzav(int i)
    {
        boolean flag;
        if (i >= 0 && i < zzMd.getCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzN(flag);
        zzNQ = i;
        zzNR = zzMd.zzax(zzNQ);
    }

    public boolean zzba(String s)
    {
        return zzMd.zzba(s);
    }

    protected Uri zzbb(String s)
    {
        return zzMd.zzg(s, zzNQ, zzNR);
    }

    protected boolean zzbc(String s)
    {
        return zzMd.zzh(s, zzNQ, zzNR);
    }

    protected int zzix()
    {
        return zzNQ;
    }
}
