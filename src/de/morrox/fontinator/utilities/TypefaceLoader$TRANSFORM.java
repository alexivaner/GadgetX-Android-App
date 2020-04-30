// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.morrox.fontinator.utilities;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package de.morrox.fontinator.utilities:
//            TypefaceLoader

public static final class value extends Enum
{

    private static final value ENUM$VALUES[];
    public static final value LOWERCASE;
    public static final value NONE;
    public static final value UPPERCASE;
    private static Map map;
    private final int value;

    static value findByValue(int i)
    {
        return (value)map.get(Integer.valueOf(i));
    }

    public static map valueOf(String s)
    {
        return (map)Enum.valueOf(de/morrox/fontinator/utilities/TypefaceLoader$TRANSFORM, s);
    }

    public static map[] values()
    {
        map amap[] = ENUM$VALUES;
        int i = amap.length;
        map amap1[] = new ENUM.VALUES[i];
        System.arraycopy(amap, 0, amap1, 0, i);
        return amap1;
    }

    static 
    {
        int i = 0;
        NONE = new <init>("NONE", 0, 0);
        UPPERCASE = new <init>("UPPERCASE", 1, 1);
        LOWERCASE = new <init>("LOWERCASE", 2, 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            NONE, UPPERCASE, LOWERCASE
        });
        map = new HashMap();
        ENUM.VALUES avalues[] = values();
        int j = avalues.length;
        do
        {
            if (i >= j)
            {
                return;
            }
            ENUM.VALUES values1 = avalues[i];
            map.put(Integer.valueOf(values1.value), values1);
            i++;
        } while (true);
    }


    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
