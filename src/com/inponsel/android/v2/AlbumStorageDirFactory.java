// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import java.io.File;

abstract class AlbumStorageDirFactory
{

    AlbumStorageDirFactory()
    {
    }

    public abstract File getAlbumStorageDir(String s);
}
