// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.crashlytics.android.answers:
//            CustomEvent, PredefinedEvent, SessionEventMetadata

final class SessionEvent
{
    static class Builder
    {

        Map customAttributes;
        String customType;
        Map details;
        Map predefinedAttributes;
        String predefinedType;
        final long timestamp = System.currentTimeMillis();
        final Type type;

        public SessionEvent build(SessionEventMetadata sessioneventmetadata)
        {
            return new SessionEvent(sessioneventmetadata, timestamp, type, details, customType, customAttributes, predefinedType, predefinedAttributes);
        }

        public Builder customAttributes(Map map)
        {
            customAttributes = map;
            return this;
        }

        public Builder customType(String s)
        {
            customType = s;
            return this;
        }

        public Builder details(Map map)
        {
            details = map;
            return this;
        }

        public Builder predefinedAttributes(Map map)
        {
            predefinedAttributes = map;
            return this;
        }

        public Builder predefinedType(String s)
        {
            predefinedType = s;
            return this;
        }

        public Builder(Type type1)
        {
            type = type1;
            details = null;
            customType = null;
            customAttributes = null;
            predefinedType = null;
            predefinedAttributes = null;
        }
    }

    static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type CRASH;
        public static final Type CUSTOM;
        public static final Type INSTALL;
        public static final Type PAUSE;
        public static final Type PREDEFINED;
        public static final Type RESUME;
        public static final Type START;
        public static final Type STOP;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/crashlytics/android/answers/SessionEvent$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            START = new Type("START", 0);
            RESUME = new Type("RESUME", 1);
            PAUSE = new Type("PAUSE", 2);
            STOP = new Type("STOP", 3);
            CRASH = new Type("CRASH", 4);
            INSTALL = new Type("INSTALL", 5);
            CUSTOM = new Type("CUSTOM", 6);
            PREDEFINED = new Type("PREDEFINED", 7);
            $VALUES = (new Type[] {
                START, RESUME, PAUSE, STOP, CRASH, INSTALL, CUSTOM, PREDEFINED
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    static final String ACTIVITY_KEY = "activity";
    static final String SESSION_ID_KEY = "sessionId";
    public final Map customAttributes;
    public final String customType;
    public final Map details;
    public final Map predefinedAttributes;
    public final String predefinedType;
    public final SessionEventMetadata sessionEventMetadata;
    private String stringRepresentation;
    public final long timestamp;
    public final Type type;

    private SessionEvent(SessionEventMetadata sessioneventmetadata, long l, Type type1, Map map, String s, Map map1, 
            String s1, Map map2)
    {
        sessionEventMetadata = sessioneventmetadata;
        timestamp = l;
        type = type1;
        details = map;
        customType = s;
        customAttributes = map1;
        predefinedType = s1;
        predefinedAttributes = map2;
    }

    SessionEvent(SessionEventMetadata sessioneventmetadata, long l, Type type1, Map map, String s, Map map1, 
            String s1, Map map2, _cls1 _pcls1)
    {
        this(sessioneventmetadata, l, type1, map, s, map1, s1, map2);
    }

    public static Builder crashEventBuilder(String s)
    {
        s = Collections.singletonMap("sessionId", s);
        return (new Builder(Type.CRASH)).details(s);
    }

    public static Builder customEventBuilder(CustomEvent customevent)
    {
        return (new Builder(Type.CUSTOM)).customType(customevent.getCustomType()).customAttributes(customevent.getCustomAttributes());
    }

    public static Builder installEventBuilder()
    {
        return new Builder(Type.INSTALL);
    }

    public static Builder lifecycleEventBuilder(Type type1, Activity activity)
    {
        activity = Collections.singletonMap("activity", activity.getClass().getName());
        return (new Builder(type1)).details(activity);
    }

    public static Builder predefinedEventBuilder(PredefinedEvent predefinedevent)
    {
        return (new Builder(Type.PREDEFINED)).predefinedType(predefinedevent.getPredefinedType()).predefinedAttributes(predefinedevent.getPredefinedAttributes()).customAttributes(predefinedevent.getCustomAttributes());
    }

    public String toString()
    {
        if (stringRepresentation == null)
        {
            stringRepresentation = (new StringBuilder()).append("[").append(getClass().getSimpleName()).append(": ").append("timestamp=").append(timestamp).append(", type=").append(type).append(", details=").append(details).append(", customType=").append(customType).append(", customAttributes=").append(customAttributes).append(", predefinedType=").append(predefinedType).append(", predefinedAttributes=").append(predefinedAttributes).append(", metadata=[").append(sessionEventMetadata).append("]]").toString();
        }
        return stringRepresentation;
    }
}
