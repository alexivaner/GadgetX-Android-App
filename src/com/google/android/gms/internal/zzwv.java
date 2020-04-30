// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzwr, zzwt, zzxa, zzwy

class zzwv
    implements Cloneable
{

    private zzwt zzaHI;
    private Object zzaHJ;
    private List zzaHK;

    zzwv()
    {
        zzaHK = new ArrayList();
    }

    private byte[] toByteArray()
        throws IOException
    {
        byte abyte0[] = new byte[zzc()];
        zza(zzwr.zzu(abyte0));
        return abyte0;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return zzvP();
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag2;
            if (obj instanceof zzwv)
            {
                obj = (zzwv)obj;
                if (zzaHJ != null && ((zzwv) (obj)).zzaHJ != null)
                {
                    flag = flag2;
                    if (zzaHI == ((zzwv) (obj)).zzaHI)
                    {
                        if (!zzaHI.zzaHC.isArray())
                        {
                            return zzaHJ.equals(((zzwv) (obj)).zzaHJ);
                        }
                        if (zzaHJ instanceof byte[])
                        {
                            return Arrays.equals((byte[])(byte[])zzaHJ, (byte[])(byte[])((zzwv) (obj)).zzaHJ);
                        }
                        if (zzaHJ instanceof int[])
                        {
                            return Arrays.equals((int[])(int[])zzaHJ, (int[])(int[])((zzwv) (obj)).zzaHJ);
                        }
                        if (zzaHJ instanceof long[])
                        {
                            return Arrays.equals((long[])(long[])zzaHJ, (long[])(long[])((zzwv) (obj)).zzaHJ);
                        }
                        if (zzaHJ instanceof float[])
                        {
                            return Arrays.equals((float[])(float[])zzaHJ, (float[])(float[])((zzwv) (obj)).zzaHJ);
                        }
                        if (zzaHJ instanceof double[])
                        {
                            return Arrays.equals((double[])(double[])zzaHJ, (double[])(double[])((zzwv) (obj)).zzaHJ);
                        }
                        if (zzaHJ instanceof boolean[])
                        {
                            return Arrays.equals((boolean[])(boolean[])zzaHJ, (boolean[])(boolean[])((zzwv) (obj)).zzaHJ);
                        } else
                        {
                            return Arrays.deepEquals((Object[])(Object[])zzaHJ, (Object[])(Object[])((zzwv) (obj)).zzaHJ);
                        }
                    }
                } else
                {
                    if (zzaHK != null && ((zzwv) (obj)).zzaHK != null)
                    {
                        return zzaHK.equals(((zzwv) (obj)).zzaHK);
                    }
                    boolean flag1;
                    try
                    {
                        flag1 = Arrays.equals(toByteArray(), ((zzwv) (obj)).toByteArray());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new IllegalStateException(((Throwable) (obj)));
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int i;
        try
        {
            i = Arrays.hashCode(toByteArray());
        }
        catch (IOException ioexception)
        {
            throw new IllegalStateException(ioexception);
        }
        return i + 527;
    }

    void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaHJ != null)
        {
            zzaHI.zza(zzaHJ, zzwr1);
        } else
        {
            Iterator iterator = zzaHK.iterator();
            while (iterator.hasNext()) 
            {
                ((zzxa)iterator.next()).zza(zzwr1);
            }
        }
    }

    void zza(zzxa zzxa1)
    {
        zzaHK.add(zzxa1);
    }

    Object zzb(zzwt zzwt1)
    {
        if (zzaHJ != null)
        {
            if (zzaHI != zzwt1)
            {
                throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
            }
        } else
        {
            zzaHI = zzwt1;
            zzaHJ = zzwt1.zzx(zzaHK);
            zzaHK = null;
        }
        return zzaHJ;
    }

    int zzc()
    {
        if (zzaHJ == null) goto _L2; else goto _L1
_L1:
        int j = zzaHI.zzF(zzaHJ);
_L4:
        return j;
_L2:
        Iterator iterator = zzaHK.iterator();
        int i = 0;
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            i = ((zzxa)iterator.next()).zzc() + i;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final zzwv zzvP()
    {
        Object obj;
        int i;
        i = 0;
        obj = new zzwv();
        obj.zzaHI = zzaHI;
        if (zzaHK != null) goto _L2; else goto _L1
_L1:
        obj.zzaHK = null;
_L4:
        if (zzaHJ == null)
        {
            return ((zzwv) (obj));
        }
        break; /* Loop/switch isn't completed */
_L2:
        try
        {
            ((zzwv) (obj)).zzaHK.addAll(zzaHK);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!(zzaHJ instanceof zzwy))
        {
            break MISSING_BLOCK_LABEL_93;
        }
        obj.zzaHJ = ((zzwy)zzaHJ).zzvN();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj.zzaHJ = ((byte[])(byte[])zzaHJ).clone();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof byte[][])) goto _L6; else goto _L5
_L5:
        Object obj1;
        Object obj2;
        obj1 = (byte[][])(byte[][])zzaHJ;
        obj2 = new byte[obj1.length][];
        obj.zzaHJ = obj2;
        i = 0;
_L8:
        if (i >= obj1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2[i] = (byte[])obj1[i].clone();
        i++;
        if (true) goto _L8; else goto _L7
_L6:
        if (!(zzaHJ instanceof boolean[]))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj.zzaHJ = ((boolean[])(boolean[])zzaHJ).clone();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof int[]))
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj.zzaHJ = ((int[])(int[])zzaHJ).clone();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        obj.zzaHJ = ((long[])(long[])zzaHJ).clone();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj.zzaHJ = ((float[])(float[])zzaHJ).clone();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof double[]))
        {
            break MISSING_BLOCK_LABEL_332;
        }
        obj.zzaHJ = ((double[])(double[])zzaHJ).clone();
        return ((zzwv) (obj));
        if (!(zzaHJ instanceof zzwy[])) goto _L7; else goto _L9
_L9:
        obj1 = (zzwy[])(zzwy[])zzaHJ;
        obj2 = new zzwy[obj1.length];
        obj.zzaHJ = obj2;
_L11:
        if (i >= obj1.length) goto _L7; else goto _L10
_L10:
        obj2[i] = obj1[i].zzvN();
        i++;
          goto _L11
_L7:
        return ((zzwv) (obj));
    }
}
