// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;
import java.util.Collections;

public class zzmj extends zzj
{

    public zzmj(int i)
    {
        super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[] {
            "customPropertiesExtra"
        }), i);
    }

    protected Object zzc(DataHolder dataholder, int i, int j)
    {
        return zzl(dataholder, i, j);
    }

    protected AppVisibleCustomProperties zzl(DataHolder dataholder, int i, int j)
    {
        return (AppVisibleCustomProperties)dataholder.zziu().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.zzVl);
    }
}
