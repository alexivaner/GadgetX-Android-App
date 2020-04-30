// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzle, zzts

public final class zztr extends zzle
    implements ItemScope
{

    public static final zzts CREATOR = new zzts();
    private static final HashMap zzauW;
    String mName;
    String zzFA;
    final int zzFG;
    String zzZO;
    double zzalQ;
    double zzalR;
    final Set zzauX;
    zztr zzauY;
    List zzauZ;
    String zzavA;
    zztr zzavB;
    zztr zzavC;
    zztr zzavD;
    List zzavE;
    String zzavF;
    String zzavG;
    String zzavH;
    String zzavI;
    zztr zzavJ;
    String zzavK;
    String zzavL;
    String zzavM;
    zztr zzavN;
    String zzavO;
    String zzavP;
    String zzavQ;
    String zzavR;
    zztr zzava;
    String zzavb;
    String zzavc;
    String zzavd;
    List zzave;
    int zzavf;
    List zzavg;
    zztr zzavh;
    List zzavi;
    String zzavj;
    String zzavk;
    zztr zzavl;
    String zzavm;
    String zzavn;
    List zzavo;
    String zzavp;
    String zzavq;
    String zzavr;
    String zzavs;
    String zzavt;
    String zzavu;
    String zzavv;
    String zzavw;
    zztr zzavx;
    String zzavy;
    String zzavz;
    String zzpn;
    String zzxV;
    String zzxX;

    public zztr()
    {
        zzFG = 1;
        zzauX = new HashSet();
    }

    zztr(Set set, int i, zztr zztr1, List list, zztr zztr2, String s, String s1, 
            String s2, List list1, int j, List list2, zztr zztr3, List list3, String s3, 
            String s4, zztr zztr4, String s5, String s6, String s7, List list4, String s8, 
            String s9, String s10, String s11, String s12, String s13, String s14, String s15, 
            String s16, zztr zztr5, String s17, String s18, String s19, String s20, zztr zztr6, 
            double d, zztr zztr7, double d1, String s21, zztr zztr8, 
            List list5, String s22, String s23, String s24, String s25, zztr zztr9, String s26, 
            String s27, String s28, zztr zztr10, String s29, String s30, String s31, String s32, 
            String s33, String s34)
    {
        zzauX = set;
        zzFG = i;
        zzauY = zztr1;
        zzauZ = list;
        zzava = zztr2;
        zzavb = s;
        zzavc = s1;
        zzavd = s2;
        zzave = list1;
        zzavf = j;
        zzavg = list2;
        zzavh = zztr3;
        zzavi = list3;
        zzavj = s3;
        zzavk = s4;
        zzavl = zztr4;
        zzavm = s5;
        zzavn = s6;
        zzpn = s7;
        zzavo = list4;
        zzavp = s8;
        zzavq = s9;
        zzavr = s10;
        zzZO = s11;
        zzavs = s12;
        zzavt = s13;
        zzavu = s14;
        zzavv = s15;
        zzavw = s16;
        zzavx = zztr5;
        zzavy = s17;
        zzavz = s18;
        zzFA = s19;
        zzavA = s20;
        zzavB = zztr6;
        zzalQ = d;
        zzavC = zztr7;
        zzalR = d1;
        mName = s21;
        zzavD = zztr8;
        zzavE = list5;
        zzavF = s22;
        zzavG = s23;
        zzavH = s24;
        zzavI = s25;
        zzavJ = zztr9;
        zzavK = s26;
        zzavL = s27;
        zzavM = s28;
        zzavN = zztr10;
        zzavO = s29;
        zzavP = s30;
        zzxV = s31;
        zzxX = s32;
        zzavQ = s33;
        zzavR = s34;
    }

    public zztr(Set set, zztr zztr1, List list, zztr zztr2, String s, String s1, String s2, 
            List list1, int i, List list2, zztr zztr3, List list3, String s3, String s4, 
            zztr zztr4, String s5, String s6, String s7, List list4, String s8, String s9, 
            String s10, String s11, String s12, String s13, String s14, String s15, String s16, 
            zztr zztr5, String s17, String s18, String s19, String s20, zztr zztr6, double d, zztr zztr7, double d1, String s21, zztr zztr8, List list5, 
            String s22, String s23, String s24, String s25, zztr zztr9, String s26, String s27, 
            String s28, zztr zztr10, String s29, String s30, String s31, String s32, String s33, 
            String s34)
    {
        zzauX = set;
        zzFG = 1;
        zzauY = zztr1;
        zzauZ = list;
        zzava = zztr2;
        zzavb = s;
        zzavc = s1;
        zzavd = s2;
        zzave = list1;
        zzavf = i;
        zzavg = list2;
        zzavh = zztr3;
        zzavi = list3;
        zzavj = s3;
        zzavk = s4;
        zzavl = zztr4;
        zzavm = s5;
        zzavn = s6;
        zzpn = s7;
        zzavo = list4;
        zzavp = s8;
        zzavq = s9;
        zzavr = s10;
        zzZO = s11;
        zzavs = s12;
        zzavt = s13;
        zzavu = s14;
        zzavv = s15;
        zzavw = s16;
        zzavx = zztr5;
        zzavy = s17;
        zzavz = s18;
        zzFA = s19;
        zzavA = s20;
        zzavB = zztr6;
        zzalQ = d;
        zzavC = zztr7;
        zzalR = d1;
        mName = s21;
        zzavD = zztr8;
        zzavE = list5;
        zzavF = s22;
        zzavG = s23;
        zzavH = s24;
        zzavI = s25;
        zzavJ = zztr9;
        zzavK = s26;
        zzavL = s27;
        zzavM = s28;
        zzavN = zztr10;
        zzavO = s29;
        zzavP = s30;
        zzxV = s31;
        zzxX = s32;
        zzavQ = s33;
        zzavR = s34;
    }

    public int describeContents()
    {
        zzts zzts1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof zztr))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (zztr)obj;
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
                    if (((zztr) (obj)).zza(zza1))
                    {
                        if (!zzb(zza1).equals(((zztr) (obj)).zzb(zza1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!((zztr) (obj)).zza(zza1));
            return false;
        }
        return true;
    }

    public Object freeze()
    {
        return zzsc();
    }

    public ItemScope getAbout()
    {
        return zzauY;
    }

    public List getAdditionalName()
    {
        return zzauZ;
    }

    public ItemScope getAddress()
    {
        return zzava;
    }

    public String getAddressCountry()
    {
        return zzavb;
    }

    public String getAddressLocality()
    {
        return zzavc;
    }

    public String getAddressRegion()
    {
        return zzavd;
    }

    public List getAssociated_media()
    {
        return (ArrayList)zzave;
    }

    public int getAttendeeCount()
    {
        return zzavf;
    }

    public List getAttendees()
    {
        return (ArrayList)zzavg;
    }

    public ItemScope getAudio()
    {
        return zzavh;
    }

    public List getAuthor()
    {
        return (ArrayList)zzavi;
    }

    public String getBestRating()
    {
        return zzavj;
    }

    public String getBirthDate()
    {
        return zzavk;
    }

    public ItemScope getByArtist()
    {
        return zzavl;
    }

    public String getCaption()
    {
        return zzavm;
    }

    public String getContentSize()
    {
        return zzavn;
    }

    public String getContentUrl()
    {
        return zzpn;
    }

    public List getContributor()
    {
        return (ArrayList)zzavo;
    }

    public String getDateCreated()
    {
        return zzavp;
    }

    public String getDateModified()
    {
        return zzavq;
    }

    public String getDatePublished()
    {
        return zzavr;
    }

    public String getDescription()
    {
        return zzZO;
    }

    public String getDuration()
    {
        return zzavs;
    }

    public String getEmbedUrl()
    {
        return zzavt;
    }

    public String getEndDate()
    {
        return zzavu;
    }

    public String getFamilyName()
    {
        return zzavv;
    }

    public String getGender()
    {
        return zzavw;
    }

    public ItemScope getGeo()
    {
        return zzavx;
    }

    public String getGivenName()
    {
        return zzavy;
    }

    public String getHeight()
    {
        return zzavz;
    }

    public String getId()
    {
        return zzFA;
    }

    public String getImage()
    {
        return zzavA;
    }

    public ItemScope getInAlbum()
    {
        return zzavB;
    }

    public double getLatitude()
    {
        return zzalQ;
    }

    public ItemScope getLocation()
    {
        return zzavC;
    }

    public double getLongitude()
    {
        return zzalR;
    }

    public String getName()
    {
        return mName;
    }

    public ItemScope getPartOfTVSeries()
    {
        return zzavD;
    }

    public List getPerformers()
    {
        return (ArrayList)zzavE;
    }

    public String getPlayerType()
    {
        return zzavF;
    }

    public String getPostOfficeBoxNumber()
    {
        return zzavG;
    }

    public String getPostalCode()
    {
        return zzavH;
    }

    public String getRatingValue()
    {
        return zzavI;
    }

    public ItemScope getReviewRating()
    {
        return zzavJ;
    }

    public String getStartDate()
    {
        return zzavK;
    }

    public String getStreetAddress()
    {
        return zzavL;
    }

    public String getText()
    {
        return zzavM;
    }

    public ItemScope getThumbnail()
    {
        return zzavN;
    }

    public String getThumbnailUrl()
    {
        return zzavO;
    }

    public String getTickerSymbol()
    {
        return zzavP;
    }

    public String getType()
    {
        return zzxV;
    }

    public String getUrl()
    {
        return zzxX;
    }

    public String getWidth()
    {
        return zzavQ;
    }

    public String getWorstRating()
    {
        return zzavR;
    }

    public boolean hasAbout()
    {
        return zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName()
    {
        return zzauX.contains(Integer.valueOf(3));
    }

    public boolean hasAddress()
    {
        return zzauX.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry()
    {
        return zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality()
    {
        return zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion()
    {
        return zzauX.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media()
    {
        return zzauX.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount()
    {
        return zzauX.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees()
    {
        return zzauX.contains(Integer.valueOf(10));
    }

    public boolean hasAudio()
    {
        return zzauX.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor()
    {
        return zzauX.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating()
    {
        return zzauX.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate()
    {
        return zzauX.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist()
    {
        return zzauX.contains(Integer.valueOf(15));
    }

    public boolean hasCaption()
    {
        return zzauX.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize()
    {
        return zzauX.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl()
    {
        return zzauX.contains(Integer.valueOf(18));
    }

    public boolean hasContributor()
    {
        return zzauX.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated()
    {
        return zzauX.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified()
    {
        return zzauX.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished()
    {
        return zzauX.contains(Integer.valueOf(22));
    }

    public boolean hasDescription()
    {
        return zzauX.contains(Integer.valueOf(23));
    }

    public boolean hasDuration()
    {
        return zzauX.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl()
    {
        return zzauX.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate()
    {
        return zzauX.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName()
    {
        return zzauX.contains(Integer.valueOf(27));
    }

    public boolean hasGender()
    {
        return zzauX.contains(Integer.valueOf(28));
    }

    public boolean hasGeo()
    {
        return zzauX.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName()
    {
        return zzauX.contains(Integer.valueOf(30));
    }

    public boolean hasHeight()
    {
        return zzauX.contains(Integer.valueOf(31));
    }

    public boolean hasId()
    {
        return zzauX.contains(Integer.valueOf(32));
    }

    public boolean hasImage()
    {
        return zzauX.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum()
    {
        return zzauX.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude()
    {
        return zzauX.contains(Integer.valueOf(36));
    }

    public boolean hasLocation()
    {
        return zzauX.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude()
    {
        return zzauX.contains(Integer.valueOf(38));
    }

    public boolean hasName()
    {
        return zzauX.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries()
    {
        return zzauX.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers()
    {
        return zzauX.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType()
    {
        return zzauX.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber()
    {
        return zzauX.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode()
    {
        return zzauX.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue()
    {
        return zzauX.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating()
    {
        return zzauX.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate()
    {
        return zzauX.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress()
    {
        return zzauX.contains(Integer.valueOf(48));
    }

    public boolean hasText()
    {
        return zzauX.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail()
    {
        return zzauX.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl()
    {
        return zzauX.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol()
    {
        return zzauX.contains(Integer.valueOf(52));
    }

    public boolean hasType()
    {
        return zzauX.contains(Integer.valueOf(53));
    }

    public boolean hasUrl()
    {
        return zzauX.contains(Integer.valueOf(54));
    }

    public boolean hasWidth()
    {
        return zzauX.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating()
    {
        return zzauX.contains(Integer.valueOf(56));
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
        zzts zzts1 = CREATOR;
        zzts.zza(this, parcel, i);
    }

    protected boolean zza(zzld.zza zza1)
    {
        return zzauX.contains(Integer.valueOf(zza1.zzjG()));
    }

    protected Object zzb(zzld.zza zza1)
    {
        switch (zza1.zzjG())
        {
        case 35: // '#'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown safe parcelable id=").append(zza1.zzjG()).toString());

        case 2: // '\002'
            return zzauY;

        case 3: // '\003'
            return zzauZ;

        case 4: // '\004'
            return zzava;

        case 5: // '\005'
            return zzavb;

        case 6: // '\006'
            return zzavc;

        case 7: // '\007'
            return zzavd;

        case 8: // '\b'
            return zzave;

        case 9: // '\t'
            return Integer.valueOf(zzavf);

        case 10: // '\n'
            return zzavg;

        case 11: // '\013'
            return zzavh;

        case 12: // '\f'
            return zzavi;

        case 13: // '\r'
            return zzavj;

        case 14: // '\016'
            return zzavk;

        case 15: // '\017'
            return zzavl;

        case 16: // '\020'
            return zzavm;

        case 17: // '\021'
            return zzavn;

        case 18: // '\022'
            return zzpn;

        case 19: // '\023'
            return zzavo;

        case 20: // '\024'
            return zzavp;

        case 21: // '\025'
            return zzavq;

        case 22: // '\026'
            return zzavr;

        case 23: // '\027'
            return zzZO;

        case 24: // '\030'
            return zzavs;

        case 25: // '\031'
            return zzavt;

        case 26: // '\032'
            return zzavu;

        case 27: // '\033'
            return zzavv;

        case 28: // '\034'
            return zzavw;

        case 29: // '\035'
            return zzavx;

        case 30: // '\036'
            return zzavy;

        case 31: // '\037'
            return zzavz;

        case 32: // ' '
            return zzFA;

        case 33: // '!'
            return zzavA;

        case 34: // '"'
            return zzavB;

        case 36: // '$'
            return Double.valueOf(zzalQ);

        case 37: // '%'
            return zzavC;

        case 38: // '&'
            return Double.valueOf(zzalR);

        case 39: // '\''
            return mName;

        case 40: // '('
            return zzavD;

        case 41: // ')'
            return zzavE;

        case 42: // '*'
            return zzavF;

        case 43: // '+'
            return zzavG;

        case 44: // ','
            return zzavH;

        case 45: // '-'
            return zzavI;

        case 46: // '.'
            return zzavJ;

        case 47: // '/'
            return zzavK;

        case 48: // '0'
            return zzavL;

        case 49: // '1'
            return zzavM;

        case 50: // '2'
            return zzavN;

        case 51: // '3'
            return zzavO;

        case 52: // '4'
            return zzavP;

        case 53: // '5'
            return zzxV;

        case 54: // '6'
            return zzxX;

        case 55: // '7'
            return zzavQ;

        case 56: // '8'
            return zzavR;
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

    public zztr zzsc()
    {
        return this;
    }

    static 
    {
        zzauW = new HashMap();
        zzauW.put("about", zzld.zza.zza("about", 2, com/google/android/gms/internal/zztr));
        zzauW.put("additionalName", zzld.zza.zzm("additionalName", 3));
        zzauW.put("address", zzld.zza.zza("address", 4, com/google/android/gms/internal/zztr));
        zzauW.put("addressCountry", zzld.zza.zzl("addressCountry", 5));
        zzauW.put("addressLocality", zzld.zza.zzl("addressLocality", 6));
        zzauW.put("addressRegion", zzld.zza.zzl("addressRegion", 7));
        zzauW.put("associated_media", zzld.zza.zzb("associated_media", 8, com/google/android/gms/internal/zztr));
        zzauW.put("attendeeCount", zzld.zza.zzi("attendeeCount", 9));
        zzauW.put("attendees", zzld.zza.zzb("attendees", 10, com/google/android/gms/internal/zztr));
        zzauW.put("audio", zzld.zza.zza("audio", 11, com/google/android/gms/internal/zztr));
        zzauW.put("author", zzld.zza.zzb("author", 12, com/google/android/gms/internal/zztr));
        zzauW.put("bestRating", zzld.zza.zzl("bestRating", 13));
        zzauW.put("birthDate", zzld.zza.zzl("birthDate", 14));
        zzauW.put("byArtist", zzld.zza.zza("byArtist", 15, com/google/android/gms/internal/zztr));
        zzauW.put("caption", zzld.zza.zzl("caption", 16));
        zzauW.put("contentSize", zzld.zza.zzl("contentSize", 17));
        zzauW.put("contentUrl", zzld.zza.zzl("contentUrl", 18));
        zzauW.put("contributor", zzld.zza.zzb("contributor", 19, com/google/android/gms/internal/zztr));
        zzauW.put("dateCreated", zzld.zza.zzl("dateCreated", 20));
        zzauW.put("dateModified", zzld.zza.zzl("dateModified", 21));
        zzauW.put("datePublished", zzld.zza.zzl("datePublished", 22));
        zzauW.put("description", zzld.zza.zzl("description", 23));
        zzauW.put("duration", zzld.zza.zzl("duration", 24));
        zzauW.put("embedUrl", zzld.zza.zzl("embedUrl", 25));
        zzauW.put("endDate", zzld.zza.zzl("endDate", 26));
        zzauW.put("familyName", zzld.zza.zzl("familyName", 27));
        zzauW.put("gender", zzld.zza.zzl("gender", 28));
        zzauW.put("geo", zzld.zza.zza("geo", 29, com/google/android/gms/internal/zztr));
        zzauW.put("givenName", zzld.zza.zzl("givenName", 30));
        zzauW.put("height", zzld.zza.zzl("height", 31));
        zzauW.put("id", zzld.zza.zzl("id", 32));
        zzauW.put("image", zzld.zza.zzl("image", 33));
        zzauW.put("inAlbum", zzld.zza.zza("inAlbum", 34, com/google/android/gms/internal/zztr));
        zzauW.put("latitude", zzld.zza.zzj("latitude", 36));
        zzauW.put("location", zzld.zza.zza("location", 37, com/google/android/gms/internal/zztr));
        zzauW.put("longitude", zzld.zza.zzj("longitude", 38));
        zzauW.put("name", zzld.zza.zzl("name", 39));
        zzauW.put("partOfTVSeries", zzld.zza.zza("partOfTVSeries", 40, com/google/android/gms/internal/zztr));
        zzauW.put("performers", zzld.zza.zzb("performers", 41, com/google/android/gms/internal/zztr));
        zzauW.put("playerType", zzld.zza.zzl("playerType", 42));
        zzauW.put("postOfficeBoxNumber", zzld.zza.zzl("postOfficeBoxNumber", 43));
        zzauW.put("postalCode", zzld.zza.zzl("postalCode", 44));
        zzauW.put("ratingValue", zzld.zza.zzl("ratingValue", 45));
        zzauW.put("reviewRating", zzld.zza.zza("reviewRating", 46, com/google/android/gms/internal/zztr));
        zzauW.put("startDate", zzld.zza.zzl("startDate", 47));
        zzauW.put("streetAddress", zzld.zza.zzl("streetAddress", 48));
        zzauW.put("text", zzld.zza.zzl("text", 49));
        zzauW.put("thumbnail", zzld.zza.zza("thumbnail", 50, com/google/android/gms/internal/zztr));
        zzauW.put("thumbnailUrl", zzld.zza.zzl("thumbnailUrl", 51));
        zzauW.put("tickerSymbol", zzld.zza.zzl("tickerSymbol", 52));
        zzauW.put("type", zzld.zza.zzl("type", 53));
        zzauW.put("url", zzld.zza.zzl("url", 54));
        zzauW.put("width", zzld.zza.zzl("width", 55));
        zzauW.put("worstRating", zzld.zza.zzl("worstRating", 56));
    }
}
