// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;


// Referenced classes of package com.crashlytics.android.answers:
//            SessionEvent

static final class  extends Enum
{

    private static final PREDEFINED $VALUES[];
    public static final PREDEFINED CRASH;
    public static final PREDEFINED CUSTOM;
    public static final PREDEFINED INSTALL;
    public static final PREDEFINED PAUSE;
    public static final PREDEFINED PREDEFINED;
    public static final PREDEFINED RESUME;
    public static final PREDEFINED START;
    public static final PREDEFINED STOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/crashlytics/android/answers/SessionEvent$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        START = new <init>("START", 0);
        RESUME = new <init>("RESUME", 1);
        PAUSE = new <init>("PAUSE", 2);
        STOP = new <init>("STOP", 3);
        CRASH = new <init>("CRASH", 4);
        INSTALL = new <init>("INSTALL", 5);
        CUSTOM = new <init>("CUSTOM", 6);
        PREDEFINED = new <init>("PREDEFINED", 7);
        $VALUES = (new .VALUES[] {
            START, RESUME, PAUSE, STOP, CRASH, INSTALL, CUSTOM, PREDEFINED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
