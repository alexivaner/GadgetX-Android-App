// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzle, zztw, zztz, zzla, 
//            zzua, zzub

public static final class zzaws extends zzle
    implements com.google.android.gms.plus.model.people.ver
{
    public static final class zza extends zzle
        implements com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
    {

        public static final zzua CREATOR = new zzua();
        private static final HashMap zzauW;
        final int zzFG;
        final Set zzauX;
        int zzawt;
        int zzawu;

        public int describeContents()
        {
            zzua zzua1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zza))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zza)obj;
                zzld.zza zza1;
label1:
                do
                {
                    for (Iterator iterator = zzauW.values().iterator(); iterator.hasNext();)
                    {
                        zza1 = (zzld.zza)iterator.next();
                        if (!zza(zza1))
                        {
                            continue label1;
                        }
                        if (((zza) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zza) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zza) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsi();
        }

        public int getLeftImageOffset()
        {
            return zzawt;
        }

        public int getTopImageOffset()
        {
            return zzawu;
        }

        public boolean hasLeftImageOffset()
        {
            return zzauX.contains(Integer.valueOf(2));
        }

        public boolean hasTopImageOffset()
        {
            return zzauX.contains(Integer.valueOf(3));
        }

        public int hashCode()
        {
            Iterator iterator = zzauW.values().iterator();
            int i = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                zzld.zza zza1 = (zzld.zza)iterator.next();
                if (zza(zza1))
                {
                    int j = zza1.zzjG();
                    i = zzb(zza1).hashCode() + (i + j);
                }
            } while (true);
            return i;
        }

        public boolean isDataValid()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzua zzua1 = CREATOR;
            zzua.zza(this, parcel, i);
        }

        protected boolean zza(zzld.zza zza1)
        {
            return zzauX.contains(Integer.valueOf(zza1.zzjG()));
        }

        protected Object zzb(zzld.zza zza1)
        {
            switch (zza1.zzjG())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zza1.zzjG()).toString());

            case 2: // '\002'
                return Integer.valueOf(zzawt);

            case 3: // '\003'
                return Integer.valueOf(zzawu);
            }
        }

        public Map zzjz()
        {
            return zzsb();
        }

        public HashMap zzsb()
        {
            return zzauW;
        }

        public zza zzsi()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("leftImageOffset", zzld.zza.zzi("leftImageOffset", 2));
            zzauW.put("topImageOffset", zzld.zza.zzi("topImageOffset", 3));
        }

        public zza()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zza(Set set, int i, int j, int k)
        {
            zzauX = set;
            zzFG = i;
            zzawt = j;
            zzawu = k;
        }
    }

    public static final class zzb extends zzle
        implements com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
    {

        public static final zzub CREATOR = new zzub();
        private static final HashMap zzauW;
        final int zzFG;
        final Set zzauX;
        int zzli;
        int zzlj;
        String zzxX;

        public int describeContents()
        {
            zzub zzub1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zzb))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzb)obj;
                zzld.zza zza1;
label1:
                do
                {
                    for (Iterator iterator = zzauW.values().iterator(); iterator.hasNext();)
                    {
                        zza1 = (zzld.zza)iterator.next();
                        if (!zza(zza1))
                        {
                            continue label1;
                        }
                        if (((zzb) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzb) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzb) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsj();
        }

        public int getHeight()
        {
            return zzlj;
        }

        public String getUrl()
        {
            return zzxX;
        }

        public int getWidth()
        {
            return zzli;
        }

        public boolean hasHeight()
        {
            return zzauX.contains(Integer.valueOf(2));
        }

        public boolean hasUrl()
        {
            return zzauX.contains(Integer.valueOf(3));
        }

        public boolean hasWidth()
        {
            return zzauX.contains(Integer.valueOf(4));
        }

        public int hashCode()
        {
            Iterator iterator = zzauW.values().iterator();
            int i = 0;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                zzld.zza zza1 = (zzld.zza)iterator.next();
                if (zza(zza1))
                {
                    int j = zza1.zzjG();
                    i = zzb(zza1).hashCode() + (i + j);
                }
            } while (true);
            return i;
        }

        public boolean isDataValid()
        {
            return true;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzub zzub1 = CREATOR;
            zzub.zza(this, parcel, i);
        }

        protected boolean zza(zzld.zza zza1)
        {
            return zzauX.contains(Integer.valueOf(zza1.zzjG()));
        }

        protected Object zzb(zzld.zza zza1)
        {
            switch (zza1.zzjG())
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zza1.zzjG()).toString());

            case 2: // '\002'
                return Integer.valueOf(zzlj);

            case 3: // '\003'
                return zzxX;

            case 4: // '\004'
                return Integer.valueOf(zzli);
            }
        }

        public Map zzjz()
        {
            return zzsb();
        }

        public HashMap zzsb()
        {
            return zzauW;
        }

        public zzb zzsj()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("height", zzld.zza.zzi("height", 2));
            zzauW.put("url", zzld.zza.zzl("url", 3));
            zzauW.put("width", zzld.zza.zzi("width", 4));
        }

        public zzb()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzb(Set set, int i, int j, String s, int k)
        {
            zzauX = set;
            zzFG = i;
            zzlj = j;
            zzxX = s;
            zzli = k;
        }
    }


    public static final zztz CREATOR = new zztz();
    private static final HashMap zzauW;
    final int zzFG;
    final Set zzauX;
    zza zzawq;
    zzb zzawr;
    int zzaws;

    public int describeContents()
    {
        zztz zztz1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (CREATOR)obj;
            CREATOR creator;
label1:
            do
            {
                for (Iterator iterator = zzauW.values().iterator(); iterator.hasNext();)
                {
                    creator = (zzauW)iterator.next();
                    if (!zza(creator))
                    {
                        continue label1;
                    }
                    if (((zza) (obj)).zza(creator))
                    {
                        if (!zzb(creator).equals(((zzb) (obj)).zzb(creator)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zzb) (obj)).zza(creator));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzsh();
    }

    public com.google.android.gms.plus.model.people.ver.CoverInfo getCoverInfo()
    {
        return zzawq;
    }

    public com.google.android.gms.plus.model.people.ver.CoverPhoto getCoverPhoto()
    {
        return zzawr;
    }

    public int getLayout()
    {
        return zzaws;
    }

    public boolean hasCoverInfo()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
        return zzauX.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
        return zzauX.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
        Iterator iterator = zzauW.values().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            zzauX zzaux = (zzauW)iterator.next();
            if (zza(zzaux))
            {
                int j = zzaux.zzjG();
                i = zzb(zzaux).hashCode() + (i + j);
            }
        } while (true);
        return i;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zztz zztz1 = CREATOR;
        zztz.zza(this, parcel, i);
    }

    protected boolean zza(CREATOR creator)
    {
        return zzauX.contains(Integer.valueOf(creator.zzjG()));
    }

    protected Object zzb(zzjG zzjg)
    {
        switch (zzjg.zzjG())
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zzjg.zzjG()).toString());

        case 2: // '\002'
            return zzawq;

        case 3: // '\003'
            return zzawr;

        case 4: // '\004'
            return Integer.valueOf(zzaws);
        }
    }

    public Map zzjz()
    {
        return zzsb();
    }

    public HashMap zzsb()
    {
        return zzauW;
    }

    public zzauW zzsh()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("coverInfo", zza("coverInfo", 2, com/google/android/gms/internal/zztw$zzb$zza));
        zzauW.put("coverPhoto", zza("coverPhoto", 3, com/google/android/gms/internal/zztw$zzb$zzb));
        zzauW.put("layout", zza("layout", 4, (new zzla()).zzh("banner", 0), false));
    }

    public zzb()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    zzb(Set set, int i, zza zza1, zzb zzb1, int j)
    {
        zzauX = set;
        zzFG = i;
        zzawq = zza1;
        zzawr = zzb1;
        zzaws = j;
    }
}
