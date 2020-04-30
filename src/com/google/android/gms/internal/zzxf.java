// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzww, zzwq, zzxb, 
//            zzwr, zzwy

public interface zzxf
{
    public static final class zza extends zzws
    {

        public String zzaIP[];
        public String zzaIQ[];
        public int zzaIR[];

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof zza)
                {
                    obj = (zza)obj;
                    flag = flag1;
                    if (zzww.equals(zzaIP, ((zza) (obj)).zzaIP))
                    {
                        flag = flag1;
                        if (zzww.equals(zzaIQ, ((zza) (obj)).zzaIQ))
                        {
                            flag = flag1;
                            if (zzww.equals(zzaIR, ((zza) (obj)).zzaIR))
                            {
                                return zza(((zzws) (obj)));
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return (((zzww.hashCode(zzaIP) + 527) * 31 + zzww.hashCode(zzaIQ)) * 31 + zzww.hashCode(zzaIR)) * 31 + zzvL();
        }

        public zza zzK(zzwq zzwq1)
            throws IOException
        {
            do
            {
                int i = zzwq1.zzvu();
                switch (i)
                {
                default:
                    if (zza(zzwq1, i))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    int j1 = zzxb.zzc(zzwq1, 10);
                    String as[];
                    int j;
                    if (zzaIP == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaIP.length;
                    }
                    as = new String[j1 + j];
                    j1 = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaIP, 0, as, 0, j);
                        j1 = j;
                    }
                    for (; j1 < as.length - 1; j1++)
                    {
                        as[j1] = zzwq1.readString();
                        zzwq1.zzvu();
                    }

                    as[j1] = zzwq1.readString();
                    zzaIP = as;
                    break;

                case 18: // '\022'
                    int k1 = zzxb.zzc(zzwq1, 18);
                    String as1[];
                    int k;
                    if (zzaIQ == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zzaIQ.length;
                    }
                    as1 = new String[k1 + k];
                    k1 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zzaIQ, 0, as1, 0, k);
                        k1 = k;
                    }
                    for (; k1 < as1.length - 1; k1++)
                    {
                        as1[k1] = zzwq1.readString();
                        zzwq1.zzvu();
                    }

                    as1[k1] = zzwq1.readString();
                    zzaIQ = as1;
                    break;

                case 24: // '\030'
                    int l1 = zzxb.zzc(zzwq1, 24);
                    int ai[];
                    int l;
                    if (zzaIR == null)
                    {
                        l = 0;
                    } else
                    {
                        l = zzaIR.length;
                    }
                    ai = new int[l1 + l];
                    l1 = l;
                    if (l != 0)
                    {
                        System.arraycopy(zzaIR, 0, ai, 0, l);
                        l1 = l;
                    }
                    for (; l1 < ai.length - 1; l1++)
                    {
                        ai[l1] = zzwq1.zzvx();
                        zzwq1.zzvu();
                    }

                    ai[l1] = zzwq1.zzvx();
                    zzaIR = ai;
                    break;

                case 26: // '\032'
                    int j2 = zzwq1.zzip(zzwq1.zzvB());
                    int i1 = zzwq1.getPosition();
                    int i2;
                    for (i2 = 0; zzwq1.zzvG() > 0; i2++)
                    {
                        zzwq1.zzvx();
                    }

                    zzwq1.zzir(i1);
                    int ai1[];
                    if (zzaIR == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = zzaIR.length;
                    }
                    ai1 = new int[i2 + i1];
                    i2 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(zzaIR, 0, ai1, 0, i1);
                        i2 = i1;
                    }
                    for (; i2 < ai1.length; i2++)
                    {
                        ai1[i2] = zzwq1.zzvx();
                    }

                    zzaIR = ai1;
                    zzwq1.zziq(j2);
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            boolean flag = false;
            if (zzaIP != null && zzaIP.length > 0)
            {
                for (int i = 0; i < zzaIP.length; i++)
                {
                    String s = zzaIP[i];
                    if (s != null)
                    {
                        zzwr1.zzb(1, s);
                    }
                }

            }
            if (zzaIQ != null && zzaIQ.length > 0)
            {
                for (int j = 0; j < zzaIQ.length; j++)
                {
                    String s1 = zzaIQ[j];
                    if (s1 != null)
                    {
                        zzwr1.zzb(2, s1);
                    }
                }

            }
            if (zzaIR != null && zzaIR.length > 0)
            {
                for (int k = ((flag) ? 1 : 0); k < zzaIR.length; k++)
                {
                    zzwr1.zzy(3, zzaIR[k]);
                }

            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzK(zzwq1);
        }

        protected int zzc()
        {
            boolean flag = false;
            int k2 = super.zzc();
            int i;
            int k;
            if (zzaIP != null && zzaIP.length > 0)
            {
                i = 0;
                int j = 0;
                int l;
                int k1;
                for (l = 0; i < zzaIP.length; l = k1)
                {
                    String s = zzaIP[i];
                    int i2 = j;
                    k1 = l;
                    if (s != null)
                    {
                        k1 = l + 1;
                        i2 = j + zzwr.zzdM(s);
                    }
                    i++;
                    j = i2;
                }

                i = k2 + j + l * 1;
            } else
            {
                i = k2;
            }
            k = i;
            if (zzaIQ != null)
            {
                k = i;
                if (zzaIQ.length > 0)
                {
                    k = 0;
                    int i1 = 0;
                    int l1;
                    int j2;
                    for (l1 = 0; k < zzaIQ.length; l1 = j2)
                    {
                        String s1 = zzaIQ[k];
                        k2 = i1;
                        j2 = l1;
                        if (s1 != null)
                        {
                            j2 = l1 + 1;
                            k2 = i1 + zzwr.zzdM(s1);
                        }
                        k++;
                        i1 = k2;
                    }

                    k = i + i1 + l1 * 1;
                }
            }
            i = k;
            if (zzaIR != null)
            {
                i = k;
                if (zzaIR.length > 0)
                {
                    int j1 = 0;
                    for (i = ((flag) ? 1 : 0); i < zzaIR.length; i++)
                    {
                        j1 += zzwr.zziw(zzaIR[i]);
                    }

                    i = k + j1 + zzaIR.length * 1;
                }
            }
            return i;
        }

        public zza zzwo()
        {
            zzaIP = zzxb.zzaHT;
            zzaIQ = zzxb.zzaHT;
            zzaIR = zzxb.zzaHO;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzwo();
        }
    }

    public static final class zzb extends zzws
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
            if (!(obj instanceof zzb)) goto _L4; else goto _L3
_L3:
            obj = (zzb)obj;
            flag = flag1;
            if (zzaIS != ((zzb) (obj)).zzaIS) goto _L4; else goto _L5
_L5:
            if (zzaIT != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zzb) (obj)).zzaIT != null) goto _L4; else goto _L8
_L8:
            if (version != null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            flag = flag1;
            if (((zzb) (obj)).version != null) goto _L4; else goto _L9
_L9:
            return zza(((zzws) (obj)));
_L7:
            if (!zzaIT.equals(((zzb) (obj)).zzaIT))
            {
                return false;
            }
              goto _L8
            if (!version.equals(((zzb) (obj)).version))
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

        public zzb zzL(zzwq zzwq1)
            throws IOException
        {
_L6:
            int i = zzwq1.zzvu();
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       0: 57
        //                       8: 59
        //                       18: 195
        //                       26: 206;
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

        public zzb zzwp()
        {
            zzaIS = 0;
            zzaIT = "";
            version = "";
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zzb()
        {
            zzwp();
        }
    }

    public static final class zzc extends zzws
    {

        public byte zzaIU[];
        public byte zzaIV[][];
        public boolean zzaIW;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof zzc)
                {
                    obj = (zzc)obj;
                    flag = flag1;
                    if (Arrays.equals(zzaIU, ((zzc) (obj)).zzaIU))
                    {
                        flag = flag1;
                        if (zzww.zza(zzaIV, ((zzc) (obj)).zzaIV))
                        {
                            flag = flag1;
                            if (zzaIW == ((zzc) (obj)).zzaIW)
                            {
                                return zza(((zzws) (obj)));
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            int i = Arrays.hashCode(zzaIU);
            int j = zzww.zza(zzaIV);
            char c;
            if (zzaIW)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            return (c + ((i + 527) * 31 + j) * 31) * 31 + zzvL();
        }

        public zzc zzM(zzwq zzwq1)
            throws IOException
        {
            do
            {
                int i = zzwq1.zzvu();
                switch (i)
                {
                default:
                    if (zza(zzwq1, i))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    zzaIU = zzwq1.readBytes();
                    break;

                case 18: // '\022'
                    int k = zzxb.zzc(zzwq1, 18);
                    byte abyte0[][];
                    int j;
                    if (zzaIV == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaIV.length;
                    }
                    abyte0 = new byte[k + j][];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaIV, 0, abyte0, 0, j);
                        k = j;
                    }
                    for (; k < abyte0.length - 1; k++)
                    {
                        abyte0[k] = zzwq1.readBytes();
                        zzwq1.zzvu();
                    }

                    abyte0[k] = zzwq1.readBytes();
                    zzaIV = abyte0;
                    break;

                case 24: // '\030'
                    zzaIW = zzwq1.zzvy();
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (!Arrays.equals(zzaIU, zzxb.zzaHV))
            {
                zzwr1.zza(1, zzaIU);
            }
            if (zzaIV != null && zzaIV.length > 0)
            {
                for (int i = 0; i < zzaIV.length; i++)
                {
                    byte abyte0[] = zzaIV[i];
                    if (abyte0 != null)
                    {
                        zzwr1.zza(2, abyte0);
                    }
                }

            }
            if (zzaIW)
            {
                zzwr1.zzb(3, zzaIW);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzM(zzwq1);
        }

        protected int zzc()
        {
            boolean flag = false;
            int j = super.zzc();
            int i = j;
            if (!Arrays.equals(zzaIU, zzxb.zzaHV))
            {
                i = j + zzwr.zzb(1, zzaIU);
            }
            j = i;
            if (zzaIV != null)
            {
                j = i;
                if (zzaIV.length > 0)
                {
                    int k = 0;
                    int l = 0;
                    for (j = ((flag) ? 1 : 0); j < zzaIV.length;)
                    {
                        byte abyte0[] = zzaIV[j];
                        int j1 = k;
                        int i1 = l;
                        if (abyte0 != null)
                        {
                            i1 = l + 1;
                            j1 = k + zzwr.zzw(abyte0);
                        }
                        j++;
                        k = j1;
                        l = i1;
                    }

                    j = i + k + l * 1;
                }
            }
            i = j;
            if (zzaIW)
            {
                i = j + zzwr.zzc(3, zzaIW);
            }
            return i;
        }

        public zzc zzwq()
        {
            zzaIU = zzxb.zzaHV;
            zzaIV = zzxb.zzaHU;
            zzaIW = false;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zzc()
        {
            zzwq();
        }
    }

    public static final class zzd extends zzws
    {

        public String tag;
        public long zzaIX;
        public int zzaIY;
        public int zzaIZ;
        public boolean zzaJa;
        public zze zzaJb[];
        public zzb zzaJc;
        public byte zzaJd[];
        public byte zzaJe[];
        public byte zzaJf[];
        public zza zzaJg;
        public String zzaJh;
        public long zzaJi;
        public zzc zzaJj;

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
            if (!(obj instanceof zzd)) goto _L4; else goto _L3
_L3:
            obj = (zzd)obj;
            flag = flag1;
            if (zzaIX != ((zzd) (obj)).zzaIX) goto _L4; else goto _L5
_L5:
            if (tag != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zzd) (obj)).tag != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (zzaIY != ((zzd) (obj)).zzaIY) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (zzaIZ != ((zzd) (obj)).zzaIZ) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (zzaJa != ((zzd) (obj)).zzaJa) goto _L4; else goto _L11
_L11:
            flag = flag1;
            if (!zzww.equals(zzaJb, ((zzd) (obj)).zzaJb)) goto _L4; else goto _L12
_L12:
            if (zzaJc != null) goto _L14; else goto _L13
_L13:
            flag = flag1;
            if (((zzd) (obj)).zzaJc != null) goto _L4; else goto _L15
_L15:
            flag = flag1;
            if (!Arrays.equals(zzaJd, ((zzd) (obj)).zzaJd)) goto _L4; else goto _L16
_L16:
            flag = flag1;
            if (!Arrays.equals(zzaJe, ((zzd) (obj)).zzaJe)) goto _L4; else goto _L17
_L17:
            flag = flag1;
            if (!Arrays.equals(zzaJf, ((zzd) (obj)).zzaJf)) goto _L4; else goto _L18
_L18:
            if (zzaJg != null) goto _L20; else goto _L19
_L19:
            flag = flag1;
            if (((zzd) (obj)).zzaJg != null) goto _L4; else goto _L21
_L21:
            if (zzaJh != null) goto _L23; else goto _L22
_L22:
            flag = flag1;
            if (((zzd) (obj)).zzaJh != null) goto _L4; else goto _L24
_L24:
            flag = flag1;
            if (zzaJi != ((zzd) (obj)).zzaJi) goto _L4; else goto _L25
_L25:
            if (zzaJj != null)
            {
                break MISSING_BLOCK_LABEL_306;
            }
            flag = flag1;
            if (((zzd) (obj)).zzaJj != null) goto _L4; else goto _L26
_L26:
            return zza(((zzws) (obj)));
_L7:
            if (!tag.equals(((zzd) (obj)).tag))
            {
                return false;
            }
              goto _L8
_L14:
            if (!zzaJc.equals(((zzd) (obj)).zzaJc))
            {
                return false;
            }
              goto _L15
_L20:
            if (!zzaJg.equals(((zzd) (obj)).zzaJg))
            {
                return false;
            }
              goto _L21
_L23:
            if (!zzaJh.equals(((zzd) (obj)).zzaJh))
            {
                return false;
            }
              goto _L24
            if (!zzaJj.equals(((zzd) (obj)).zzaJj))
            {
                return false;
            }
              goto _L26
        }

        public int hashCode()
        {
            int i1 = 0;
            int j1 = (int)(zzaIX ^ zzaIX >>> 32);
            int i;
            char c;
            int j;
            int k;
            int l;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            if (tag == null)
            {
                i = 0;
            } else
            {
                i = tag.hashCode();
            }
            k1 = zzaIY;
            l1 = zzaIZ;
            if (zzaJa)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            i2 = zzww.hashCode(zzaJb);
            if (zzaJc == null)
            {
                j = 0;
            } else
            {
                j = zzaJc.hashCode();
            }
            j2 = Arrays.hashCode(zzaJd);
            k2 = Arrays.hashCode(zzaJe);
            l2 = Arrays.hashCode(zzaJf);
            if (zzaJg == null)
            {
                k = 0;
            } else
            {
                k = zzaJg.hashCode();
            }
            if (zzaJh == null)
            {
                l = 0;
            } else
            {
                l = zzaJh.hashCode();
            }
            i3 = (int)(zzaJi ^ zzaJi >>> 32);
            if (zzaJj != null)
            {
                i1 = zzaJj.hashCode();
            }
            return (((l + (k + ((((j + ((c + (((i + (j1 + 527) * 31) * 31 + k1) * 31 + l1) * 31) * 31 + i2) * 31) * 31 + j2) * 31 + k2) * 31 + l2) * 31) * 31) * 31 + i3) * 31 + i1) * 31 + zzvL();
        }

        public zzd zzN(zzwq zzwq1)
            throws IOException
        {
            do
            {
                int i = zzwq1.zzvu();
                switch (i)
                {
                default:
                    if (zza(zzwq1, i))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 8: // '\b'
                    zzaIX = zzwq1.zzvw();
                    break;

                case 18: // '\022'
                    tag = zzwq1.readString();
                    break;

                case 26: // '\032'
                    int k = zzxb.zzc(zzwq1, 26);
                    zze azze[];
                    int j;
                    if (zzaJb == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaJb.length;
                    }
                    azze = new zze[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaJb, 0, azze, 0, j);
                        k = j;
                    }
                    for (; k < azze.length - 1; k++)
                    {
                        azze[k] = new zze();
                        zzwq1.zza(azze[k]);
                        zzwq1.zzvu();
                    }

                    azze[k] = new zze();
                    zzwq1.zza(azze[k]);
                    zzaJb = azze;
                    break;

                case 50: // '2'
                    zzaJd = zzwq1.readBytes();
                    break;

                case 58: // ':'
                    if (zzaJg == null)
                    {
                        zzaJg = new zza();
                    }
                    zzwq1.zza(zzaJg);
                    break;

                case 66: // 'B'
                    zzaJe = zzwq1.readBytes();
                    break;

                case 74: // 'J'
                    if (zzaJc == null)
                    {
                        zzaJc = new zzb();
                    }
                    zzwq1.zza(zzaJc);
                    break;

                case 80: // 'P'
                    zzaJa = zzwq1.zzvy();
                    break;

                case 88: // 'X'
                    zzaIY = zzwq1.zzvx();
                    break;

                case 96: // '`'
                    zzaIZ = zzwq1.zzvx();
                    break;

                case 106: // 'j'
                    zzaJf = zzwq1.readBytes();
                    break;

                case 114: // 'r'
                    zzaJh = zzwq1.readString();
                    break;

                case 120: // 'x'
                    zzaJi = zzwq1.zzvA();
                    break;

                case 130: 
                    if (zzaJj == null)
                    {
                        zzaJj = new zzc();
                    }
                    zzwq1.zza(zzaJj);
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (zzaIX != 0L)
            {
                zzwr1.zzb(1, zzaIX);
            }
            if (!tag.equals(""))
            {
                zzwr1.zzb(2, tag);
            }
            if (zzaJb != null && zzaJb.length > 0)
            {
                for (int i = 0; i < zzaJb.length; i++)
                {
                    zze zze1 = zzaJb[i];
                    if (zze1 != null)
                    {
                        zzwr1.zza(3, zze1);
                    }
                }

            }
            if (!Arrays.equals(zzaJd, zzxb.zzaHV))
            {
                zzwr1.zza(6, zzaJd);
            }
            if (zzaJg != null)
            {
                zzwr1.zza(7, zzaJg);
            }
            if (!Arrays.equals(zzaJe, zzxb.zzaHV))
            {
                zzwr1.zza(8, zzaJe);
            }
            if (zzaJc != null)
            {
                zzwr1.zza(9, zzaJc);
            }
            if (zzaJa)
            {
                zzwr1.zzb(10, zzaJa);
            }
            if (zzaIY != 0)
            {
                zzwr1.zzy(11, zzaIY);
            }
            if (zzaIZ != 0)
            {
                zzwr1.zzy(12, zzaIZ);
            }
            if (!Arrays.equals(zzaJf, zzxb.zzaHV))
            {
                zzwr1.zza(13, zzaJf);
            }
            if (!zzaJh.equals(""))
            {
                zzwr1.zzb(14, zzaJh);
            }
            if (zzaJi != 0x2bf20L)
            {
                zzwr1.zzc(15, zzaJi);
            }
            if (zzaJj != null)
            {
                zzwr1.zza(16, zzaJj);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzN(zzwq1);
        }

        protected int zzc()
        {
            int i = super.zzc();
            int j = i;
            if (zzaIX != 0L)
            {
                j = i + com.google.android.gms.internal.zzwr.zzd(1, zzaIX);
            }
            i = j;
            if (!tag.equals(""))
            {
                i = j + com.google.android.gms.internal.zzwr.zzj(2, tag);
            }
            j = i;
            if (zzaJb != null)
            {
                j = i;
                if (zzaJb.length > 0)
                {
                    for (j = 0; j < zzaJb.length;)
                    {
                        zze zze1 = zzaJb[j];
                        int k = i;
                        if (zze1 != null)
                        {
                            k = i + com.google.android.gms.internal.zzwr.zzc(3, zze1);
                        }
                        j++;
                        i = k;
                    }

                    j = i;
                }
            }
            i = j;
            if (!Arrays.equals(zzaJd, zzxb.zzaHV))
            {
                i = j + com.google.android.gms.internal.zzwr.zzb(6, zzaJd);
            }
            j = i;
            if (zzaJg != null)
            {
                j = i + com.google.android.gms.internal.zzwr.zzc(7, zzaJg);
            }
            i = j;
            if (!Arrays.equals(zzaJe, zzxb.zzaHV))
            {
                i = j + com.google.android.gms.internal.zzwr.zzb(8, zzaJe);
            }
            j = i;
            if (zzaJc != null)
            {
                j = i + com.google.android.gms.internal.zzwr.zzc(9, zzaJc);
            }
            i = j;
            if (zzaJa)
            {
                i = j + com.google.android.gms.internal.zzwr.zzc(10, zzaJa);
            }
            j = i;
            if (zzaIY != 0)
            {
                j = i + com.google.android.gms.internal.zzwr.zzA(11, zzaIY);
            }
            i = j;
            if (zzaIZ != 0)
            {
                i = j + com.google.android.gms.internal.zzwr.zzA(12, zzaIZ);
            }
            j = i;
            if (!Arrays.equals(zzaJf, zzxb.zzaHV))
            {
                j = i + com.google.android.gms.internal.zzwr.zzb(13, zzaJf);
            }
            i = j;
            if (!zzaJh.equals(""))
            {
                i = j + com.google.android.gms.internal.zzwr.zzj(14, zzaJh);
            }
            j = i;
            if (zzaJi != 0x2bf20L)
            {
                j = i + com.google.android.gms.internal.zzwr.zze(15, zzaJi);
            }
            i = j;
            if (zzaJj != null)
            {
                i = j + com.google.android.gms.internal.zzwr.zzc(16, zzaJj);
            }
            return i;
        }

        public zzd zzwr()
        {
            zzaIX = 0L;
            tag = "";
            zzaIY = 0;
            zzaIZ = 0;
            zzaJa = false;
            zzaJb = zze.zzws();
            zzaJc = null;
            zzaJd = zzxb.zzaHV;
            zzaJe = zzxb.zzaHV;
            zzaJf = zzxb.zzaHV;
            zzaJg = null;
            zzaJh = "";
            zzaJi = 0x2bf20L;
            zzaJj = null;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zzd()
        {
            zzwr();
        }
    }

    public static final class zze extends zzws
    {

        private static volatile zze zzaJk[];
        public String value;
        public String zzfv;

        public static zze[] zzws()
        {
            if (zzaJk == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzaJk == null)
                    {
                        zzaJk = new zze[0];
                    }
                }
            }
            return zzaJk;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

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
            if (!(obj instanceof zze)) goto _L4; else goto _L3
_L3:
            obj = (zze)obj;
            if (zzfv != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zze) (obj)).zzfv != null) goto _L4; else goto _L7
_L7:
            if (value != null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            flag = flag1;
            if (((zze) (obj)).value != null) goto _L4; else goto _L8
_L8:
            return zza(((zzws) (obj)));
_L6:
            if (!zzfv.equals(((zze) (obj)).zzfv))
            {
                return false;
            }
              goto _L7
            if (!value.equals(((zze) (obj)).value))
            {
                return false;
            }
              goto _L8
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (zzfv == null)
            {
                i = 0;
            } else
            {
                i = zzfv.hashCode();
            }
            if (value != null)
            {
                j = value.hashCode();
            }
            return ((i + 527) * 31 + j) * 31 + zzvL();
        }

        public zze zzO(zzwq zzwq1)
            throws IOException
        {
            do
            {
                int i = zzwq1.zzvu();
                switch (i)
                {
                default:
                    if (zza(zzwq1, i))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    zzfv = zzwq1.readString();
                    break;

                case 18: // '\022'
                    value = zzwq1.readString();
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (!zzfv.equals(""))
            {
                zzwr1.zzb(1, zzfv);
            }
            if (!value.equals(""))
            {
                zzwr1.zzb(2, value);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzO(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (!zzfv.equals(""))
            {
                i = j + zzwr.zzj(1, zzfv);
            }
            j = i;
            if (!value.equals(""))
            {
                j = i + zzwr.zzj(2, value);
            }
            return j;
        }

        public zze zzwt()
        {
            zzfv = "";
            value = "";
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zze()
        {
            zzwt();
        }
    }

}
