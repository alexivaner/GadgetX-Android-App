// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwx, zzwr, zzwq, zzwz

public abstract class zzwy
{

    protected volatile int zzaHM;

    public zzwy()
    {
        zzaHM = -1;
    }

    public static final zzwy zza(zzwy zzwy1, byte abyte0[])
        throws zzwx
    {
        return zzb(zzwy1, abyte0, 0, abyte0.length);
    }

    public static final void zza(zzwy zzwy1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = zzwr.zzb(abyte0, i, j);
            zzwy1.zza(((zzwr) (abyte0)));
            abyte0.zzvK();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzwy zzwy1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", zzwy1);
        }
    }

    public static final zzwy zzb(zzwy zzwy1, byte abyte0[], int i, int j)
        throws zzwx
    {
        try
        {
            abyte0 = zzwq.zza(abyte0, i, j);
            zzwy1.zzb(((zzwq) (abyte0)));
            abyte0.zzim(0);
        }
        // Misplaced declaration of an exception variable
        catch (zzwy zzwy1)
        {
            throw zzwy1;
        }
        // Misplaced declaration of an exception variable
        catch (zzwy zzwy1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return zzwy1;
    }

    public static final byte[] zzf(zzwy zzwy1)
    {
        byte abyte0[] = new byte[zzwy1.zzvY()];
        zza(zzwy1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return zzvN();
    }

    public String toString()
    {
        return zzwz.zzg(this);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
    }

    public abstract zzwy zzb(zzwq zzwq1)
        throws IOException;

    protected int zzc()
    {
        return 0;
    }

    public zzwy zzvN()
        throws CloneNotSupportedException
    {
        return (zzwy)super.clone();
    }

    public int zzvX()
    {
        if (zzaHM < 0)
        {
            zzvY();
        }
        return zzaHM;
    }

    public int zzvY()
    {
        int i = zzc();
        zzaHM = i;
        return i;
    }
}
