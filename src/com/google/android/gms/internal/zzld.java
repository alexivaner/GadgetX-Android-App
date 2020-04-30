// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzma, zzlt, zzmb, zzlf, 
//            zzlk, zzky, zzlh

public abstract class zzld
{
    public static class zza
        implements SafeParcelable
    {

        public static final zzlf CREATOR = new zzlf();
        private final int zzFG;
        protected final int zzQP;
        protected final boolean zzQQ;
        protected final int zzQR;
        protected final boolean zzQS;
        protected final String zzQT;
        protected final int zzQU;
        protected final Class zzQV;
        protected final String zzQW;
        private zzlh zzQX;
        private zzb zzQY;

        public static zza zza(String s, int i, zzb zzb1, boolean flag)
        {
            return new zza(zzb1.zzjx(), flag, zzb1.zzjy(), false, s, i, null, zzb1);
        }

        public static zza zza(String s, int i, Class class1)
        {
            return new zza(11, false, 11, false, s, i, class1, null);
        }

        public static zza zzb(String s, int i, Class class1)
        {
            return new zza(11, true, 11, true, s, i, class1, null);
        }

        static zzb zzc(zza zza1)
        {
            return zza1.zzQY;
        }

        public static zza zzi(String s, int i)
        {
            return new zza(0, false, 0, false, s, i, null, null);
        }

        public static zza zzj(String s, int i)
        {
            return new zza(4, false, 4, false, s, i, null, null);
        }

        public static zza zzk(String s, int i)
        {
            return new zza(6, false, 6, false, s, i, null, null);
        }

        public static zza zzl(String s, int i)
        {
            return new zza(7, false, 7, false, s, i, null, null);
        }

        public static zza zzm(String s, int i)
        {
            return new zza(7, true, 7, true, s, i, null, null);
        }

        public Object convertBack(Object obj)
        {
            return zzQY.convertBack(obj);
        }

        public int describeContents()
        {
            zzlf zzlf1 = CREATOR;
            return 0;
        }

        public int getVersionCode()
        {
            return zzFG;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Field\n");
            stringbuilder.append("            versionCode=").append(zzFG).append('\n');
            stringbuilder.append("                 typeIn=").append(zzQP).append('\n');
            stringbuilder.append("            typeInArray=").append(zzQQ).append('\n');
            stringbuilder.append("                typeOut=").append(zzQR).append('\n');
            stringbuilder.append("           typeOutArray=").append(zzQS).append('\n');
            stringbuilder.append("        outputFieldName=").append(zzQT).append('\n');
            stringbuilder.append("      safeParcelFieldId=").append(zzQU).append('\n');
            stringbuilder.append("       concreteTypeName=").append(zzjI()).append('\n');
            if (zzjH() != null)
            {
                stringbuilder.append("     concreteType.class=").append(zzjH().getCanonicalName()).append('\n');
            }
            StringBuilder stringbuilder1 = stringbuilder.append("          converterName=");
            String s;
            if (zzQY == null)
            {
                s = "null";
            } else
            {
                s = zzQY.getClass().getCanonicalName();
            }
            stringbuilder1.append(s).append('\n');
            return stringbuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzlf zzlf1 = CREATOR;
            zzlf.zza(this, parcel, i);
        }

        public void zza(zzlh zzlh1)
        {
            zzQX = zzlh1;
        }

        public zza zzjC()
        {
            return new zza(zzFG, zzQP, zzQQ, zzQR, zzQS, zzQT, zzQU, zzQW, zzjK());
        }

        public boolean zzjD()
        {
            return zzQQ;
        }

        public boolean zzjE()
        {
            return zzQS;
        }

        public String zzjF()
        {
            return zzQT;
        }

        public int zzjG()
        {
            return zzQU;
        }

        public Class zzjH()
        {
            return zzQV;
        }

        String zzjI()
        {
            if (zzQW == null)
            {
                return null;
            } else
            {
                return zzQW;
            }
        }

        public boolean zzjJ()
        {
            return zzQY != null;
        }

        zzky zzjK()
        {
            if (zzQY == null)
            {
                return null;
            } else
            {
                return zzky.zza(zzQY);
            }
        }

        public Map zzjL()
        {
            zzx.zzl(zzQW);
            zzx.zzl(zzQX);
            return zzQX.zzbs(zzQW);
        }

        public int zzjx()
        {
            return zzQP;
        }

        public int zzjy()
        {
            return zzQR;
        }


        zza(int i, int j, boolean flag, int k, boolean flag1, String s, int l, 
                String s1, zzky zzky1)
        {
            zzFG = i;
            zzQP = j;
            zzQQ = flag;
            zzQR = k;
            zzQS = flag1;
            zzQT = s;
            zzQU = l;
            if (s1 == null)
            {
                zzQV = null;
                zzQW = null;
            } else
            {
                zzQV = com/google/android/gms/internal/zzlk;
                zzQW = s1;
            }
            if (zzky1 == null)
            {
                zzQY = null;
                return;
            } else
            {
                zzQY = zzky1.zzjv();
                return;
            }
        }

        protected zza(int i, boolean flag, int j, boolean flag1, String s, int k, Class class1, 
                zzb zzb1)
        {
            zzFG = 1;
            zzQP = i;
            zzQQ = flag;
            zzQR = j;
            zzQS = flag1;
            zzQT = s;
            zzQU = k;
            zzQV = class1;
            if (class1 == null)
            {
                zzQW = null;
            } else
            {
                zzQW = class1.getCanonicalName();
            }
            zzQY = zzb1;
        }
    }

    public static interface zzb
    {

        public abstract Object convertBack(Object obj);

        public abstract int zzjx();

        public abstract int zzjy();
    }


    public zzld()
    {
    }

    private void zza(StringBuilder stringbuilder, zza zza1, Object obj)
    {
        if (zza1.zzjx() == 11)
        {
            stringbuilder.append(((zzld)zza1.zzjH().cast(obj)).toString());
            return;
        }
        if (zza1.zzjx() == 7)
        {
            stringbuilder.append("\"");
            stringbuilder.append(zzma.zzbt((String)obj));
            stringbuilder.append("\"");
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private void zza(StringBuilder stringbuilder, zza zza1, ArrayList arraylist)
    {
        stringbuilder.append("[");
        int i = 0;
        for (int j = arraylist.size(); i < j; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            Object obj = arraylist.get(i);
            if (obj != null)
            {
                zza(stringbuilder, zza1, obj);
            }
        }

        stringbuilder.append("]");
    }

    public String toString()
    {
        Map map = zzjz();
        StringBuilder stringbuilder = new StringBuilder(100);
        Iterator iterator = map.keySet().iterator();
label0:
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                zza zza1 = (zza)map.get(s);
                if (zza(zza1))
                {
                    Object obj = zza(zza1, zzb(zza1));
                    if (stringbuilder.length() == 0)
                    {
                        stringbuilder.append("{");
                    } else
                    {
                        stringbuilder.append(",");
                    }
                    stringbuilder.append("\"").append(s).append("\":");
                    if (obj == null)
                    {
                        stringbuilder.append("null");
                    } else
                    {
                        switch (zza1.zzjy())
                        {
                        default:
                            if (zza1.zzjD())
                            {
                                zza(stringbuilder, zza1, (ArrayList)obj);
                            } else
                            {
                                zza(stringbuilder, zza1, obj);
                            }
                            break;

                        case 8: // '\b'
                            stringbuilder.append("\"").append(zzlt.zze((byte[])(byte[])obj)).append("\"");
                            break;

                        case 9: // '\t'
                            stringbuilder.append("\"").append(zzlt.zzf((byte[])(byte[])obj)).append("\"");
                            break;

                        case 10: // '\n'
                            zzmb.zza(stringbuilder, (HashMap)obj);
                            break;
                        }
                        continue label0;
                    }
                }
            } while (true);
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("}");
            } else
            {
                stringbuilder.append("{}");
            }
            return stringbuilder.toString();
        } while (true);
    }

    protected Object zza(zza zza1, Object obj)
    {
        Object obj1 = obj;
        if (zza.zzc(zza1) != null)
        {
            obj1 = zza1.convertBack(obj);
        }
        return obj1;
    }

    protected boolean zza(zza zza1)
    {
        if (zza1.zzjy() == 11)
        {
            if (zza1.zzjE())
            {
                return zzbr(zza1.zzjF());
            } else
            {
                return zzbq(zza1.zzjF());
            }
        } else
        {
            return zzbp(zza1.zzjF());
        }
    }

    protected Object zzb(zza zza1)
    {
        String s = zza1.zzjF();
        if (zza1.zzjH() != null)
        {
            boolean flag;
            if (zzbo(zza1.zzjF()) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Concrete field shouldn't be value object: %s", new Object[] {
                zza1.zzjF()
            });
            if (zza1.zzjE())
            {
                zza1 = zzjB();
            } else
            {
                zza1 = zzjA();
            }
            if (zza1 != null)
            {
                return zza1.get(s);
            }
            try
            {
                zza1 = (new StringBuilder()).append("get").append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
                zza1 = ((zza) (getClass().getMethod(zza1, new Class[0]).invoke(this, new Object[0])));
            }
            // Misplaced declaration of an exception variable
            catch (zza zza1)
            {
                throw new RuntimeException(zza1);
            }
            return zza1;
        } else
        {
            return zzbo(zza1.zzjF());
        }
    }

    protected abstract Object zzbo(String s);

    protected abstract boolean zzbp(String s);

    protected boolean zzbq(String s)
    {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzbr(String s)
    {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public HashMap zzjA()
    {
        return null;
    }

    public HashMap zzjB()
    {
        return null;
    }

    public abstract Map zzjz();
}
