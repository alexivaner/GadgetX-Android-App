// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class CrashlyticsFileMarker
{

    private final FileStore fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String s, FileStore filestore)
    {
        markerName = s;
        fileStore = filestore;
    }

    private File getMarkerFile()
    {
        return new File(fileStore.getFilesDir(), markerName);
    }

    public boolean create()
    {
        boolean flag;
        try
        {
            flag = getMarkerFile().createNewFile();
        }
        catch (IOException ioexception)
        {
            Fabric.getLogger().e("CrashlyticsCore", (new StringBuilder()).append("Error creating marker: ").append(markerName).toString(), ioexception);
            return false;
        }
        return flag;
    }

    public boolean isPresent()
    {
        return getMarkerFile().exists();
    }

    public boolean remove()
    {
        return getMarkerFile().delete();
    }
}
