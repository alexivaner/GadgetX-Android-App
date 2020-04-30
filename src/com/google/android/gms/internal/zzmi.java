// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.ParentDriveIdSet;
import com.google.android.gms.drive.metadata.internal.zzb;
import com.google.android.gms.drive.metadata.internal.zzg;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzm;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzml, zzmj

public class zzmi
{
    public static class zza extends zzmj
        implements SearchableMetadataField
    {

        public zza(int i)
        {
            super(i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb
        implements SearchableMetadataField
    {

        public zzb(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzc extends zzn
        implements SearchableMetadataField
    {

        public zzc(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzi
        implements SearchableCollectionMetadataField
    {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zzd(dataholder, i, j);
        }

        protected Collection zzd(DataHolder dataholder, int i, int j)
        {
            dataholder = dataholder.zziu();
            ArrayList arraylist = dataholder.getParcelableArrayList("parentsExtra");
            if (arraylist == null)
            {
                return null;
            } else
            {
                long l = dataholder.getLong("dbInstanceId");
                return ((ParentDriveIdSet)arraylist.get(i)).zzs(l);
            }
        }

        protected Object zzl(Bundle bundle)
        {
            return zzq(bundle);
        }

        protected Collection zzq(Bundle bundle)
        {
            bundle = super.zzq(bundle);
            if (bundle == null)
            {
                return null;
            } else
            {
                return new HashSet(bundle);
            }
        }

        public zzd(int i)
        {
            super("parents", Collections.emptySet(), Arrays.asList(new String[] {
                "parentsExtra", "dbInstanceId"
            }), i);
        }
    }

    public static class zze extends com.google.android.gms.drive.metadata.internal.zzg
        implements SortableMetadataField
    {

        public zze(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzi
    {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zzd(dataholder, i, j);
        }

        protected Collection zzd(DataHolder dataholder, int i, int j)
        {
            ArrayList arraylist = new ArrayList();
            if (dataholder.zzd("inDriveSpace", i, j))
            {
                arraylist.add(DriveSpace.zzSl);
            }
            if (dataholder.zzd("isAppData", i, j))
            {
                arraylist.add(DriveSpace.zzSm);
            }
            if (dataholder.zzd("inGooglePhotosSpace", i, j))
            {
                arraylist.add(DriveSpace.zzSn);
            }
            return arraylist;
        }

        public zzf(int i)
        {
            super("spaces", Arrays.asList(new String[] {
                "inDriveSpace", "isAppData", "inGooglePhotosSpace"
            }), Collections.emptySet(), i);
        }
    }

    public static class zzg extends com.google.android.gms.drive.metadata.internal.zzb
        implements SearchableMetadataField
    {

        public zzg(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzh extends zzn
        implements SearchableMetadataField, SortableMetadataField
    {

        public zzh(String s, int i)
        {
            super(s, i);
        }
    }

    public static class zzi extends com.google.android.gms.drive.metadata.internal.zzb
        implements SearchableMetadataField
    {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zze(dataholder, i, j);
        }

        protected Boolean zze(DataHolder dataholder, int i, int j)
        {
            boolean flag;
            if (dataholder.zzb(getName(), i, j) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        }

        public zzi(String s, int i)
        {
            super(s, i);
        }
    }


    public static final MetadataField zzVA = new zzn("indexableText", 0x419ce0);
    public static final MetadataField zzVB = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 0x419ce0);
    public static final MetadataField zzVC = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 0x419ce0);
    public static final MetadataField zzVD = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 0x3e8fa0);
    public static final MetadataField zzVE = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 0x6acfc0) {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zze(dataholder, i, j);
        }

        protected Boolean zze(DataHolder dataholder, int i, int j)
        {
            boolean flag;
            if (dataholder.zzb("trashed", i, j) == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        }

    };
    public static final zzb zzVF = new zzb("isPinned", 0x3e8fa0);
    public static final MetadataField zzVG = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 0x419ce0);
    public static final MetadataField zzVH = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 0x419ce0);
    public static final MetadataField zzVI = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 0x6acfc0);
    public static final MetadataField zzVJ = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 0x6acfc0);
    public static final MetadataField zzVK = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 0x432380);
    public static final MetadataField zzVL = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 0x419ce0);
    public static final zzc zzVM = new zzc("mimeType", 0x3e8fa0);
    public static final MetadataField zzVN = new zzn("originalFilename", 0x419ce0);
    public static final com.google.android.gms.drive.metadata.zzb zzVO = new zzm("ownerNames", 0x419ce0);
    public static final zzo zzVP = new zzo("lastModifyingUser", 0x5b8d80);
    public static final zzo zzVQ = new zzo("sharingUser", 0x5b8d80);
    public static final zzd zzVR = new zzd(0x3e8fa0);
    public static final zze zzVS = new zze("quotaBytesUsed", 0x419ce0);
    public static final zzg zzVT = new zzg("starred", 0x3e8fa0);
    public static final MetadataField zzVU = new zzj("thumbnail", Collections.emptySet(), Collections.emptySet(), 0x432380) {

        protected Object zzc(DataHolder dataholder, int i, int j)
        {
            return zzk(dataholder, i, j);
        }

        protected com.google.android.gms.common.data.zza zzk(DataHolder dataholder, int i, int j)
        {
            throw new IllegalStateException("Thumbnail field is write only");
        }

    };
    public static final zzh zzVV = new zzh("title", 0x3e8fa0);
    public static final zzi zzVW = new zzi("trashed", 0x3e8fa0);
    public static final MetadataField zzVX = new zzn("webContentLink", 0x419ce0);
    public static final MetadataField zzVY = new zzn("webViewLink", 0x419ce0);
    public static final MetadataField zzVZ = new zzn("uniqueIdentifier", 0x4c4b40);
    public static final MetadataField zzVs;
    public static final MetadataField zzVt = new zzn("alternateLink", 0x419ce0);
    public static final zza zzVu = new zza(0x4c4b40);
    public static final MetadataField zzVv = new zzn("description", 0x419ce0);
    public static final MetadataField zzVw = new zzn("embedLink", 0x419ce0);
    public static final MetadataField zzVx = new zzn("fileExtension", 0x419ce0);
    public static final MetadataField zzVy = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 0x419ce0);
    public static final MetadataField zzVz = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 0x419ce0);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzWa = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 0x5b8d80);
    public static final MetadataField zzWb = new zzn("role", 0x5b8d80);
    public static final MetadataField zzWc = new zzn("md5Checksum", 0x6acfc0);
    public static final zzf zzWd = new zzf(0x6acfc0);

    static 
    {
        zzVs = zzml.zzWj;
    }
}
