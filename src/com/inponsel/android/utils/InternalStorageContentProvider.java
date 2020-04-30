// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.inponsel.android.v2.ProfileActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class InternalStorageContentProvider extends ContentProvider
{

    public static final Uri CONTENT_URI = Uri.parse("content://eu.janmuller.android.simplecropimage.example/");
    private static final HashMap MIME_TYPES;

    public InternalStorageContentProvider()
    {
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        uri = uri.toString();
        Iterator iterator = MIME_TYPES.keySet().iterator();
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }
            s = (String)iterator.next();
        } while (!uri.endsWith(s));
        return (String)MIME_TYPES.get(s);
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        try
        {
            File file = new File(getContext().getFilesDir(), ProfileActivity.TEMP_PHOTO_FILE_NAME);
            if (!file.exists())
            {
                file.createNewFile();
                getContext().getContentResolver().notifyChange(CONTENT_URI, null);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s)
        throws FileNotFoundException
    {
        s = new File(getContext().getFilesDir(), ProfileActivity.TEMP_PHOTO_FILE_NAME);
        if (s.exists())
        {
            return ParcelFileDescriptor.open(s, 0x30000000);
        } else
        {
            throw new FileNotFoundException(uri.getPath());
        }
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        return null;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }

    static 
    {
        MIME_TYPES = new HashMap();
        MIME_TYPES.put(".jpg", "image/jpeg");
        MIME_TYPES.put(".jpeg", "image/jpeg");
    }
}
