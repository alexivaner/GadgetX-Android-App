// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import java.util.Locale;

// Referenced classes of package com.nostra13.universalimageloader.core.download:
//            ImageDownloader

public static final class uriPrefix extends Enum
{

    public static final UNKNOWN ASSETS;
    public static final UNKNOWN CONTENT;
    public static final UNKNOWN DRAWABLE;
    private static final UNKNOWN ENUM$VALUES[];
    public static final UNKNOWN FILE;
    public static final UNKNOWN HTTP;
    public static final UNKNOWN HTTPS;
    public static final UNKNOWN UNKNOWN;
    private String scheme;
    private String uriPrefix;

    private boolean belongsTo(String s)
    {
        return s.toLowerCase(Locale.US).startsWith(uriPrefix);
    }

    public static uriPrefix ofUri(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        uriPrefix auriprefix[];
        int i;
        int j;
        auriprefix = values();
        j = auriprefix.length;
        i = 0;
_L7:
        if (i < j) goto _L3; else goto _L2
_L2:
        uriPrefix uriprefix = UNKNOWN;
_L5:
        return uriprefix;
_L3:
        uriPrefix uriprefix1;
        uriprefix1 = auriprefix[i];
        uriprefix = uriprefix1;
        if (uriprefix1.belongsTo(s)) goto _L5; else goto _L4
_L4:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static belongsTo valueOf(String s)
    {
        return (belongsTo)Enum.valueOf(com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme, s);
    }

    public static belongsTo[] values()
    {
        belongsTo abelongsto[] = ENUM$VALUES;
        int i = abelongsto.length;
        belongsTo abelongsto1[] = new ENUM.VALUES[i];
        System.arraycopy(abelongsto, 0, abelongsto1, 0, i);
        return abelongsto1;
    }

    public String crop(String s)
    {
        if (!belongsTo(s))
        {
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] {
                s, scheme
            }));
        } else
        {
            return s.substring(uriPrefix.length());
        }
    }

    public String wrap(String s)
    {
        return (new StringBuilder(String.valueOf(uriPrefix))).append(s).toString();
    }

    static 
    {
        HTTP = new <init>("HTTP", 0, "http");
        HTTPS = new <init>("HTTPS", 1, "https");
        FILE = new <init>("FILE", 2, "file");
        CONTENT = new <init>("CONTENT", 3, "content");
        ASSETS = new <init>("ASSETS", 4, "assets");
        DRAWABLE = new <init>("DRAWABLE", 5, "drawable");
        UNKNOWN = new <init>("UNKNOWN", 6, "");
        ENUM$VALUES = (new ENUM.VALUES[] {
            HTTP, HTTPS, FILE, CONTENT, ASSETS, DRAWABLE, UNKNOWN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        scheme = s1;
        uriPrefix = (new StringBuilder(String.valueOf(s1))).append("://").toString();
    }
}
