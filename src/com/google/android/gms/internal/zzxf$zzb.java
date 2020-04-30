// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzxf, zzwq, zzwr, 
//            zzwy

public static final class zzwp extends zzws
{

    public String version;
    public int zzaIS;
    public String zzaIT;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof zzwp)) goto _L4; else goto _L3
_L3:
        obj = (zzwp)obj;
        flag = flag1;
        if (zzaIS != ((zzaIS) (obj)).zzaIS) goto _L4; else goto _L5
_L5:
        if (zzaIT != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((zzaIT) (obj)).zzaIT != null) goto _L4; else goto _L8
_L8:
        if (version != null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = flag1;
        if (((version) (obj)).version != null) goto _L4; else goto _L9
_L9:
        return zza(((zzws) (obj)));
_L7:
        if (!zzaIT.equals(((zzaIT) (obj)).zzaIT))
        {
            return false;
        }
          goto _L8
        if (!version.equals(((version) (obj)).version))
        {
            return false;
        }
          goto _L9
    }

    public int hashCode()
    {
        int j = 0;
        int k = zzaIS;
        int i;
        if (zzaIT == null)
        {
            i = 0;
        } else
        {
            i = zzaIT.hashCode();
        }
        if (version != null)
        {
            j = version.hashCode();
        }
        return ((i + (k + 527) * 31) * 31 + j) * 31 + zzvL();
    }

    public zzvL zzL(zzwq zzwq1)
        throws IOException
    {
_L6:
        int i = zzwq1.zzvu();
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   0: 57
    //                   8: 59
    //                   18: 195
    //                   26: 206;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (zza(zzwq1, i)) goto _L6; else goto _L2
_L2:
        return this;
_L3:
        int j = zzwq1.zzvx();
        switch (j)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
            zzaIS = j;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        zzaIT = zzwq1.readString();
        continue; /* Loop/switch isn't completed */
_L5:
        version = zzwq1.readString();
        if (true) goto _L6; else goto _L7
_L7:
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaIS != 0)
        {
            zzwr1.zzy(1, zzaIS);
        }
        if (!zzaIT.equals(""))
        {
            zzwr1.zzb(2, zzaIT);
        }
        if (!version.equals(""))
        {
            zzwr1.zzb(3, version);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzL(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (zzaIS != 0)
        {
            i = j + zzwr.zzA(1, zzaIS);
        }
        j = i;
        if (!zzaIT.equals(""))
        {
            j = i + zzwr.zzj(2, zzaIT);
        }
        i = j;
        if (!version.equals(""))
        {
            i = j + zzwr.zzj(3, version);
        }
        return i;
    }

    public version zzwp()
    {
        zzaIS = 0;
        zzaIT = "";
        version = "";
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwp();
    }
}
