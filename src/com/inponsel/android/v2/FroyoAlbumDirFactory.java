// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.Environment;
import java.io.File;

// Referenced classes of package com.inponsel.android.v2:
//            AlbumStorageDirFactory

public final class FroyoAlbumDirFactory extends AlbumStorageDirFactory
{

    public FroyoAlbumDirFactory()
    {
    }

    public File getAlbumStorageDir(String s)
    {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), s);
    }
}
