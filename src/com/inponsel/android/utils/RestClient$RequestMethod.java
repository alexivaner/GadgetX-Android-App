// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;


// Referenced classes of package com.inponsel.android.utils:
//            RestClient

public static final class _cls9 extends Enum
{

    private static final POST ENUM$VALUES[];
    public static final POST GET;
    public static final POST POST;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/inponsel/android/utils/RestClient$RequestMethod, s);
    }

    public static _cls9[] values()
    {
        _cls9 a_lcls9[] = ENUM$VALUES;
        int i = a_lcls9.length;
        _cls9 a_lcls9_1[] = new ENUM.VALUES[i];
        System.arraycopy(a_lcls9, 0, a_lcls9_1, 0, i);
        return a_lcls9_1;
    }

    static 
    {
        GET = new <init>("GET", 0);
        POST = new <init>("POST", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            GET, POST
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
