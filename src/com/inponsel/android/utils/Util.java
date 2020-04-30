// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.io.InputStream;
import java.io.OutputStream;

public class Util
{

    public static String BASE_PATH2 = "http://www.inponsel.co.id/inponsel_android/v232/";
    public static String BASE_PATH_AVATAR = "";
    public static String BASE_PATH_BRANDS = "";
    public static String BASE_PATH_FULL = "";
    public static String BASE_PATH_Gallery = "";
    public static String BASE_PATH_IKADV = "";
    public static String BASE_PATH_MSG = "http://www.inponsel.co.id/inponsel_android/message/";
    public static String BASE_PATH_NEWIMAGE = "";
    public static String BASE_PATH_STORE = "http://www.inponsel.co.id/instore/";
    public static String BASE_PATH_UPLIMG = "http://inponsel.co.id/images/avatar/";
    public static String BASE_PATH_UPLIMGMSG = "http://inponsel.co.id/inponsel_android_bak/message/";
    public static String BASE_URL_THUMB = "http://www.inponsel.co.id/inponsel_android/thumb.php?w=250&src=";
    public static String BASE_URL_THUMB2 = "http://www.inponsel.co.id/inponsel_android/thumb";
    public static String BASE_URL_THUMB_ORI = "http://www.inponsel.co.id/inponsel_android/thumb.php?";
    public static String BASE_U_R_L = "http://www.inponsel.co.id/inponsel_android/v232/";
    public static int deviceSize = 270;
    public static String line1 = ")(/brmja4648)(";
    public static String line2 = ")(brmja4648)(";
    public static int tabletSize = 350;

    public Util()
    {
    }

    public static void CopyStream(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
_L1:
        int i = inputstream.read(abyte0, 0, 1024);
        if (i == -1)
        {
            return;
        }
        try
        {
            outputstream.write(abyte0, 0, i);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
          goto _L1
    }

}
