// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzmi

public class zzml extends zzj
{

    public static final zzml zzWj = new zzml();

    private zzml()
    {
        super("driveId", Arrays.asList(new String[] {
            "sqlId", "resourceId"
        }), Arrays.asList(new String[] {
            "dbInstanceId"
        }), 0x3e8fa0);
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzm(dataholder, i, j);
    }

    protected DriveId zzm(DataHolder dataholder, int i, int j)
    {
        long l = dataholder.zziu().getLong("dbInstanceId");
        String s;
        String s1;
        int k;
        if ("application/vnd.google-apps.folder".equals(dataholder.zzc(zzmi.zzVM.getName(), i, j)))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        s1 = dataholder.zzc("resourceId", i, j);
        s = s1;
        if (s1 != null)
        {
            s = s1;
            if (s1.startsWith("generated-android-"))
            {
                s = null;
            }
        }
        return new DriveId(s, Long.valueOf(dataholder.zza("sqlId", i, j)).longValue(), l, k);
    }

}
