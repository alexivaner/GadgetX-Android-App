// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.persistence;

import java.io.File;

public interface FileStore
{

    public abstract File getCacheDir();

    public abstract File getExternalCacheDir();

    public abstract File getExternalFilesDir();

    public abstract File getFilesDir();
}
