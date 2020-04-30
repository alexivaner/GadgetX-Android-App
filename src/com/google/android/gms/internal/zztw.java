// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzle, zztx, zzla, zzty, 
//            zztz, zzua, zzub, zzuc, 
//            zzud, zzue, zzuf, zzug

public final class zztw extends zzle
    implements Person
{
    public static final class zza extends zzle
        implements com.google.android.gms.plus.model.people.Person.AgeRange
    {

        public static final zzty CREATOR = new zzty();
        private static final HashMap zzauW;
        final int zzFG;
        final Set zzauX;
        int zzawo;
        int zzawp;

        public int describeContents()
        {
            zzty zzty1 = CREATOR;
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
            return zzsg();
        }

        public int getMax()
        {
            return zzawo;
        }

        public int getMin()
        {
            return zzawp;
        }

        public boolean hasMax()
        {
            return zzauX.contains(Integer.valueOf(2));
        }

        public boolean hasMin()
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
            zzty zzty1 = CREATOR;
            zzty.zza(this, parcel, i);
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
                return Integer.valueOf(zzawo);

            case 3: // '\003'
                return Integer.valueOf(zzawp);
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

        public zza zzsg()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("max", zzld.zza.zzi("max", 2));
            zzauW.put("min", zzld.zza.zzi("min", 3));
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
            zzawo = j;
            zzawp = k;
        }
    }

    public static final class zzb extends zzle
        implements com.google.android.gms.plus.model.people.Person.Cover
    {

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
            return zzsh();
        }

        public com.google.android.gms.plus.model.people.Person.Cover.CoverInfo getCoverInfo()
        {
            return zzawq;
        }

        public com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto getCoverPhoto()
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
            zztz zztz1 = CREATOR;
            zztz.zza(this, parcel, i);
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

        public zzb zzsh()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("coverInfo", zzld.zza.zza("coverInfo", 2, com/google/android/gms/internal/zztw$zzb$zza));
            zzauW.put("coverPhoto", zzld.zza.zza("coverPhoto", 3, com/google/android/gms/internal/zztw$zzb$zzb));
            zzauW.put("layout", zzld.zza.zza("layout", 4, (new zzla()).zzh("banner", 0), false));
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

    public static final class zzb.zza extends zzle
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
                if (!(obj instanceof zzb.zza))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzb.zza)obj;
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
                        if (((zzb.zza) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzb.zza) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzb.zza) (obj)).zza(zza1));
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

        public zzb.zza zzsi()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("leftImageOffset", zzld.zza.zzi("leftImageOffset", 2));
            zzauW.put("topImageOffset", zzld.zza.zzi("topImageOffset", 3));
        }

        public zzb.zza()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzb.zza(Set set, int i, int j, int k)
        {
            zzauX = set;
            zzFG = i;
            zzawt = j;
            zzawu = k;
        }
    }

    public static final class zzb.zzb extends zzle
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
                if (!(obj instanceof zzb.zzb))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzb.zzb)obj;
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
                        if (((zzb.zzb) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzb.zzb) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzb.zzb) (obj)).zza(zza1));
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

        public zzb.zzb zzsj()
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

        public zzb.zzb()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzb.zzb(Set set, int i, int j, String s, int k)
        {
            zzauX = set;
            zzFG = i;
            zzlj = j;
            zzxX = s;
            zzli = k;
        }
    }

    public static final class zzc extends zzle
        implements com.google.android.gms.plus.model.people.Person.Image
    {

        public static final zzuc CREATOR = new zzuc();
        private static final HashMap zzauW;
        final int zzFG;
        final Set zzauX;
        String zzxX;

        public int describeContents()
        {
            zzuc zzuc1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zzc))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzc)obj;
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
                        if (((zzc) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzc) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzc) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsk();
        }

        public String getUrl()
        {
            return zzxX;
        }

        public boolean hasUrl()
        {
            return zzauX.contains(Integer.valueOf(2));
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
            zzuc zzuc1 = CREATOR;
            zzuc.zza(this, parcel, i);
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
                return zzxX;
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

        public zzc zzsk()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("url", zzld.zza.zzl("url", 2));
        }

        public zzc()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        public zzc(String s)
        {
            zzauX = new HashSet();
            zzFG = 1;
            zzxX = s;
            zzauX.add(Integer.valueOf(2));
        }

        zzc(Set set, int i, String s)
        {
            zzauX = set;
            zzFG = i;
            zzxX = s;
        }
    }

    public static final class zzd extends zzle
        implements com.google.android.gms.plus.model.people.Person.Name
    {

        public static final zzud CREATOR = new zzud();
        private static final HashMap zzauW;
        final int zzFG;
        final Set zzauX;
        String zzavv;
        String zzavy;
        String zzawv;
        String zzaww;
        String zzawx;
        String zzawy;

        public int describeContents()
        {
            zzud zzud1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zzd))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzd)obj;
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
                        if (((zzd) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzd) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzd) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsl();
        }

        public String getFamilyName()
        {
            return zzavv;
        }

        public String getFormatted()
        {
            return zzawv;
        }

        public String getGivenName()
        {
            return zzavy;
        }

        public String getHonorificPrefix()
        {
            return zzaww;
        }

        public String getHonorificSuffix()
        {
            return zzawx;
        }

        public String getMiddleName()
        {
            return zzawy;
        }

        public boolean hasFamilyName()
        {
            return zzauX.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted()
        {
            return zzauX.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName()
        {
            return zzauX.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix()
        {
            return zzauX.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix()
        {
            return zzauX.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName()
        {
            return zzauX.contains(Integer.valueOf(7));
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
            zzud zzud1 = CREATOR;
            zzud.zza(this, parcel, i);
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
                return zzavv;

            case 3: // '\003'
                return zzawv;

            case 4: // '\004'
                return zzavy;

            case 5: // '\005'
                return zzaww;

            case 6: // '\006'
                return zzawx;

            case 7: // '\007'
                return zzawy;
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

        public zzd zzsl()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("familyName", zzld.zza.zzl("familyName", 2));
            zzauW.put("formatted", zzld.zza.zzl("formatted", 3));
            zzauW.put("givenName", zzld.zza.zzl("givenName", 4));
            zzauW.put("honorificPrefix", zzld.zza.zzl("honorificPrefix", 5));
            zzauW.put("honorificSuffix", zzld.zza.zzl("honorificSuffix", 6));
            zzauW.put("middleName", zzld.zza.zzl("middleName", 7));
        }

        public zzd()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzd(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                String s5)
        {
            zzauX = set;
            zzFG = i;
            zzavv = s;
            zzawv = s1;
            zzavy = s2;
            zzaww = s3;
            zzawx = s4;
            zzawy = s5;
        }
    }

    public static class zze
    {

        public static int zzcF(String s)
        {
            if (s.equals("person"))
            {
                return 0;
            }
            if (s.equals("page"))
            {
                return 1;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unknown objectType string: ").append(s).toString());
            }
        }
    }

    public static final class zzf extends zzle
        implements com.google.android.gms.plus.model.people.Person.Organizations
    {

        public static final zzue CREATOR = new zzue();
        private static final HashMap zzauW;
        String mName;
        final int zzFG;
        int zzJp;
        String zzSy;
        String zzZO;
        final Set zzauX;
        String zzavK;
        String zzavu;
        String zzawA;
        boolean zzawB;
        String zzawz;

        public int describeContents()
        {
            zzue zzue1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zzf))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzf)obj;
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
                        if (((zzf) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzf) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzf) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsm();
        }

        public String getDepartment()
        {
            return zzawz;
        }

        public String getDescription()
        {
            return zzZO;
        }

        public String getEndDate()
        {
            return zzavu;
        }

        public String getLocation()
        {
            return zzawA;
        }

        public String getName()
        {
            return mName;
        }

        public String getStartDate()
        {
            return zzavK;
        }

        public String getTitle()
        {
            return zzSy;
        }

        public int getType()
        {
            return zzJp;
        }

        public boolean hasDepartment()
        {
            return zzauX.contains(Integer.valueOf(2));
        }

        public boolean hasDescription()
        {
            return zzauX.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate()
        {
            return zzauX.contains(Integer.valueOf(4));
        }

        public boolean hasLocation()
        {
            return zzauX.contains(Integer.valueOf(5));
        }

        public boolean hasName()
        {
            return zzauX.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary()
        {
            return zzauX.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate()
        {
            return zzauX.contains(Integer.valueOf(8));
        }

        public boolean hasTitle()
        {
            return zzauX.contains(Integer.valueOf(9));
        }

        public boolean hasType()
        {
            return zzauX.contains(Integer.valueOf(10));
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

        public boolean isPrimary()
        {
            return zzawB;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzue zzue1 = CREATOR;
            zzue.zza(this, parcel, i);
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
                return zzawz;

            case 3: // '\003'
                return zzZO;

            case 4: // '\004'
                return zzavu;

            case 5: // '\005'
                return zzawA;

            case 6: // '\006'
                return mName;

            case 7: // '\007'
                return Boolean.valueOf(zzawB);

            case 8: // '\b'
                return zzavK;

            case 9: // '\t'
                return zzSy;

            case 10: // '\n'
                return Integer.valueOf(zzJp);
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

        public zzf zzsm()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("department", zzld.zza.zzl("department", 2));
            zzauW.put("description", zzld.zza.zzl("description", 3));
            zzauW.put("endDate", zzld.zza.zzl("endDate", 4));
            zzauW.put("location", zzld.zza.zzl("location", 5));
            zzauW.put("name", zzld.zza.zzl("name", 6));
            zzauW.put("primary", zzld.zza.zzk("primary", 7));
            zzauW.put("startDate", zzld.zza.zzl("startDate", 8));
            zzauW.put("title", zzld.zza.zzl("title", 9));
            zzauW.put("type", zzld.zza.zza("type", 10, (new zzla()).zzh("work", 0).zzh("school", 1), false));
        }

        public zzf()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzf(Set set, int i, String s, String s1, String s2, String s3, String s4, 
                boolean flag, String s5, String s6, int j)
        {
            zzauX = set;
            zzFG = i;
            zzawz = s;
            zzZO = s1;
            zzavu = s2;
            zzawA = s3;
            mName = s4;
            zzawB = flag;
            zzavK = s5;
            zzSy = s6;
            zzJp = j;
        }
    }

    public static final class zzg extends zzle
        implements com.google.android.gms.plus.model.people.Person.PlacesLived
    {

        public static final zzuf CREATOR = new zzuf();
        private static final HashMap zzauW;
        String mValue;
        final int zzFG;
        final Set zzauX;
        boolean zzawB;

        public int describeContents()
        {
            zzuf zzuf1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zzg))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzg)obj;
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
                        if (((zzg) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzg) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzg) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsn();
        }

        public String getValue()
        {
            return mValue;
        }

        public boolean hasPrimary()
        {
            return zzauX.contains(Integer.valueOf(2));
        }

        public boolean hasValue()
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

        public boolean isPrimary()
        {
            return zzawB;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzuf zzuf1 = CREATOR;
            zzuf.zza(this, parcel, i);
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
                return Boolean.valueOf(zzawB);

            case 3: // '\003'
                return mValue;
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

        public zzg zzsn()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("primary", zzld.zza.zzk("primary", 2));
            zzauW.put("value", zzld.zza.zzl("value", 3));
        }

        public zzg()
        {
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzg(Set set, int i, boolean flag, String s)
        {
            zzauX = set;
            zzFG = i;
            zzawB = flag;
            mValue = s;
        }
    }

    public static final class zzh extends zzle
        implements com.google.android.gms.plus.model.people.Person.Urls
    {

        public static final zzug CREATOR = new zzug();
        private static final HashMap zzauW;
        String mValue;
        final int zzFG;
        int zzJp;
        final Set zzauX;
        String zzawC;
        private final int zzawD;

        public int describeContents()
        {
            zzug zzug1 = CREATOR;
            return 0;
        }

        public boolean equals(Object obj)
        {
label0:
            {
                if (!(obj instanceof zzh))
                {
                    return false;
                }
                if (this == obj)
                {
                    return true;
                }
                obj = (zzh)obj;
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
                        if (((zzh) (obj)).zza(zza1))
                        {
                            if (!zzb(zza1).equals(((zzh) (obj)).zzb(zza1)))
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    }

                    break label0;
                } while (!((zzh) (obj)).zza(zza1));
                return false;
            }
            return true;
        }

        public Object freeze()
        {
            return zzsp();
        }

        public String getLabel()
        {
            return zzawC;
        }

        public int getType()
        {
            return zzJp;
        }

        public String getValue()
        {
            return mValue;
        }

        public boolean hasLabel()
        {
            return zzauX.contains(Integer.valueOf(5));
        }

        public boolean hasType()
        {
            return zzauX.contains(Integer.valueOf(6));
        }

        public boolean hasValue()
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
            zzug zzug1 = CREATOR;
            zzug.zza(this, parcel, i);
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

            case 5: // '\005'
                return zzawC;

            case 6: // '\006'
                return Integer.valueOf(zzJp);

            case 4: // '\004'
                return mValue;
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

        public int zzso()
        {
            return 4;
        }

        public zzh zzsp()
        {
            return this;
        }

        static 
        {
            zzauW = new HashMap();
            zzauW.put("label", zzld.zza.zzl("label", 5));
            zzauW.put("type", zzld.zza.zza("type", 6, (new zzla()).zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh("profile", 3).zzh("other", 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzauW.put("value", zzld.zza.zzl("value", 4));
        }

        public zzh()
        {
            zzawD = 4;
            zzFG = 1;
            zzauX = new HashSet();
        }

        zzh(Set set, int i, String s, int j, String s1, int k)
        {
            zzawD = 4;
            zzauX = set;
            zzFG = i;
            zzawC = s;
            zzJp = j;
            mValue = s1;
        }
    }


    public static final zztx CREATOR = new zztx();
    private static final HashMap zzauW;
    String zzFA;
    final int zzFG;
    String zzIO;
    String zzSJ;
    final Set zzauX;
    String zzavV;
    zza zzavW;
    String zzavX;
    String zzavY;
    int zzavZ;
    zzb zzawa;
    String zzawb;
    zzc zzawc;
    boolean zzawd;
    zzd zzawe;
    String zzawf;
    int zzawg;
    List zzawh;
    List zzawi;
    int zzawj;
    int zzawk;
    String zzawl;
    List zzawm;
    boolean zzawn;
    int zzpo;
    String zzxX;

    public zztw()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    public zztw(String s, String s1, zzc zzc1, int i, String s2)
    {
        zzFG = 1;
        zzauX = new HashSet();
        zzSJ = s;
        zzauX.add(Integer.valueOf(9));
        zzFA = s1;
        zzauX.add(Integer.valueOf(14));
        zzawc = zzc1;
        zzauX.add(Integer.valueOf(15));
        zzawg = i;
        zzauX.add(Integer.valueOf(21));
        zzxX = s2;
        zzauX.add(Integer.valueOf(27));
    }

    zztw(Set set, int i, String s, zza zza1, String s1, String s2, int j, 
            zzb zzb1, String s3, String s4, int k, String s5, zzc zzc1, boolean flag, 
            String s6, zzd zzd1, String s7, int l, List list, List list1, int i1, 
            int j1, String s8, String s9, List list2, boolean flag1)
    {
        zzauX = set;
        zzFG = i;
        zzavV = s;
        zzavW = zza1;
        zzavX = s1;
        zzavY = s2;
        zzavZ = j;
        zzawa = zzb1;
        zzawb = s3;
        zzSJ = s4;
        zzpo = k;
        zzFA = s5;
        zzawc = zzc1;
        zzawd = flag;
        zzIO = s6;
        zzawe = zzd1;
        zzawf = s7;
        zzawg = l;
        zzawh = list;
        zzawi = list1;
        zzawj = i1;
        zzawk = j1;
        zzawl = s8;
        zzxX = s9;
        zzawm = list2;
        zzawn = flag1;
    }

    public static zztw zzj(byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        abyte0 = CREATOR.zzeB(parcel);
        parcel.recycle();
        return abyte0;
    }

    public int describeContents()
    {
        zztx zztx1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof zztw))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (zztw)obj;
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
                    if (((zztw) (obj)).zza(zza1))
                    {
                        if (!zzb(zza1).equals(((zztw) (obj)).zzb(zza1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zztw) (obj)).zza(zza1));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzsf();
    }

    public String getAboutMe()
    {
        return zzavV;
    }

    public com.google.android.gms.plus.model.people.Person.AgeRange getAgeRange()
    {
        return zzavW;
    }

    public String getBirthday()
    {
        return zzavX;
    }

    public String getBraggingRights()
    {
        return zzavY;
    }

    public int getCircledByCount()
    {
        return zzavZ;
    }

    public com.google.android.gms.plus.model.people.Person.Cover getCover()
    {
        return zzawa;
    }

    public String getCurrentLocation()
    {
        return zzawb;
    }

    public String getDisplayName()
    {
        return zzSJ;
    }

    public int getGender()
    {
        return zzpo;
    }

    public String getId()
    {
        return zzFA;
    }

    public com.google.android.gms.plus.model.people.Person.Image getImage()
    {
        return zzawc;
    }

    public String getLanguage()
    {
        return zzIO;
    }

    public com.google.android.gms.plus.model.people.Person.Name getName()
    {
        return zzawe;
    }

    public String getNickname()
    {
        return zzawf;
    }

    public int getObjectType()
    {
        return zzawg;
    }

    public List getOrganizations()
    {
        return (ArrayList)zzawh;
    }

    public List getPlacesLived()
    {
        return (ArrayList)zzawi;
    }

    public int getPlusOneCount()
    {
        return zzawj;
    }

    public int getRelationshipStatus()
    {
        return zzawk;
    }

    public String getTagline()
    {
        return zzawl;
    }

    public String getUrl()
    {
        return zzxX;
    }

    public List getUrls()
    {
        return (ArrayList)zzawm;
    }

    public boolean hasAboutMe()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange()
    {
        return zzauX.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday()
    {
        return zzauX.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights()
    {
        return zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount()
    {
        return zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasCover()
    {
        return zzauX.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation()
    {
        return zzauX.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName()
    {
        return zzauX.contains(Integer.valueOf(9));
    }

    public boolean hasGender()
    {
        return zzauX.contains(Integer.valueOf(12));
    }

    public boolean hasId()
    {
        return zzauX.contains(Integer.valueOf(14));
    }

    public boolean hasImage()
    {
        return zzauX.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser()
    {
        return zzauX.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage()
    {
        return zzauX.contains(Integer.valueOf(18));
    }

    public boolean hasName()
    {
        return zzauX.contains(Integer.valueOf(19));
    }

    public boolean hasNickname()
    {
        return zzauX.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType()
    {
        return zzauX.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations()
    {
        return zzauX.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived()
    {
        return zzauX.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount()
    {
        return zzauX.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus()
    {
        return zzauX.contains(Integer.valueOf(25));
    }

    public boolean hasTagline()
    {
        return zzauX.contains(Integer.valueOf(26));
    }

    public boolean hasUrl()
    {
        return zzauX.contains(Integer.valueOf(27));
    }

    public boolean hasUrls()
    {
        return zzauX.contains(Integer.valueOf(28));
    }

    public boolean hasVerified()
    {
        return zzauX.contains(Integer.valueOf(29));
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

    public boolean isPlusUser()
    {
        return zzawd;
    }

    public boolean isVerified()
    {
        return zzawn;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zztx zztx1 = CREATOR;
        zztx.zza(this, parcel, i);
    }

    protected boolean zza(zzld.zza zza1)
    {
        return zzauX.contains(Integer.valueOf(zza1.zzjG()));
    }

    protected Object zzb(zzld.zza zza1)
    {
        switch (zza1.zzjG())
        {
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
        case 17: // '\021'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zza1.zzjG()).toString());

        case 2: // '\002'
            return zzavV;

        case 3: // '\003'
            return zzavW;

        case 4: // '\004'
            return zzavX;

        case 5: // '\005'
            return zzavY;

        case 6: // '\006'
            return Integer.valueOf(zzavZ);

        case 7: // '\007'
            return zzawa;

        case 8: // '\b'
            return zzawb;

        case 9: // '\t'
            return zzSJ;

        case 12: // '\f'
            return Integer.valueOf(zzpo);

        case 14: // '\016'
            return zzFA;

        case 15: // '\017'
            return zzawc;

        case 16: // '\020'
            return Boolean.valueOf(zzawd);

        case 18: // '\022'
            return zzIO;

        case 19: // '\023'
            return zzawe;

        case 20: // '\024'
            return zzawf;

        case 21: // '\025'
            return Integer.valueOf(zzawg);

        case 22: // '\026'
            return zzawh;

        case 23: // '\027'
            return zzawi;

        case 24: // '\030'
            return Integer.valueOf(zzawj);

        case 25: // '\031'
            return Integer.valueOf(zzawk);

        case 26: // '\032'
            return zzawl;

        case 27: // '\033'
            return zzxX;

        case 28: // '\034'
            return zzawm;

        case 29: // '\035'
            return Boolean.valueOf(zzawn);
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

    public zztw zzsf()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("aboutMe", zzld.zza.zzl("aboutMe", 2));
        zzauW.put("ageRange", zzld.zza.zza("ageRange", 3, com/google/android/gms/internal/zztw$zza));
        zzauW.put("birthday", zzld.zza.zzl("birthday", 4));
        zzauW.put("braggingRights", zzld.zza.zzl("braggingRights", 5));
        zzauW.put("circledByCount", zzld.zza.zzi("circledByCount", 6));
        zzauW.put("cover", zzld.zza.zza("cover", 7, com/google/android/gms/internal/zztw$zzb));
        zzauW.put("currentLocation", zzld.zza.zzl("currentLocation", 8));
        zzauW.put("displayName", zzld.zza.zzl("displayName", 9));
        zzauW.put("gender", zzld.zza.zza("gender", 12, (new zzla()).zzh("male", 0).zzh("female", 1).zzh("other", 2), false));
        zzauW.put("id", zzld.zza.zzl("id", 14));
        zzauW.put("image", zzld.zza.zza("image", 15, com/google/android/gms/internal/zztw$zzc));
        zzauW.put("isPlusUser", zzld.zza.zzk("isPlusUser", 16));
        zzauW.put("language", zzld.zza.zzl("language", 18));
        zzauW.put("name", zzld.zza.zza("name", 19, com/google/android/gms/internal/zztw$zzd));
        zzauW.put("nickname", zzld.zza.zzl("nickname", 20));
        zzauW.put("objectType", zzld.zza.zza("objectType", 21, (new zzla()).zzh("person", 0).zzh("page", 1), false));
        zzauW.put("organizations", zzld.zza.zzb("organizations", 22, com/google/android/gms/internal/zztw$zzf));
        zzauW.put("placesLived", zzld.zza.zzb("placesLived", 23, com/google/android/gms/internal/zztw$zzg));
        zzauW.put("plusOneCount", zzld.zza.zzi("plusOneCount", 24));
        zzauW.put("relationshipStatus", zzld.zza.zza("relationshipStatus", 25, (new zzla()).zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzauW.put("tagline", zzld.zza.zzl("tagline", 26));
        zzauW.put("url", zzld.zza.zzl("url", 27));
        zzauW.put("urls", zzld.zza.zzb("urls", 28, com/google/android/gms/internal/zztw$zzh));
        zzauW.put("verified", zzld.zza.zzk("verified", 29));
    }
}
