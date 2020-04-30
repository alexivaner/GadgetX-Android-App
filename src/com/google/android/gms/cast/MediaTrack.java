// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
    public static class Builder
    {

        private final MediaTrack zzJr;

        public MediaTrack build()
        {
            return zzJr;
        }

        public Builder setContentId(String s)
        {
            zzJr.setContentId(s);
            return this;
        }

        public Builder setContentType(String s)
        {
            zzJr.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzJr.setCustomData(jsonobject);
            return this;
        }

        public Builder setLanguage(String s)
        {
            zzJr.setLanguage(s);
            return this;
        }

        public Builder setLanguage(Locale locale)
        {
            zzJr.setLanguage(zzjv.zzb(locale));
            return this;
        }

        public Builder setName(String s)
        {
            zzJr.setName(s);
            return this;
        }

        public Builder setSubtype(int i)
            throws IllegalArgumentException
        {
            zzJr.zzaf(i);
            return this;
        }

        public Builder(long l, int i)
            throws IllegalArgumentException
        {
            zzJr = new MediaTrack(l, i);
        }
    }


    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzHf;
    private String zzIO;
    private String zzIQ;
    private String zzIS;
    private JSONObject zzIX;
    private int zzJp;
    private int zzJq;

    MediaTrack(long l, int i)
        throws IllegalArgumentException
    {
        clear();
        zzHf = l;
        if (i <= 0 || i > 3)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type ").append(i).toString());
        } else
        {
            zzJp = i;
            return;
        }
    }

    MediaTrack(JSONObject jsonobject)
        throws JSONException
    {
        zzd(jsonobject);
    }

    private void clear()
    {
        zzHf = 0L;
        zzJp = 0;
        zzIQ = null;
        mName = null;
        zzIO = null;
        zzJq = -1;
        zzIX = null;
    }

    private void zzd(JSONObject jsonobject)
        throws JSONException
    {
        clear();
        zzHf = jsonobject.getLong("trackId");
        String s = jsonobject.getString("type");
        if ("TEXT".equals(s))
        {
            zzJp = 1;
        } else
        if ("AUDIO".equals(s))
        {
            zzJp = 2;
        } else
        if ("VIDEO".equals(s))
        {
            zzJp = 3;
        } else
        {
            throw new JSONException((new StringBuilder()).append("invalid type: ").append(s).toString());
        }
        zzIQ = jsonobject.optString("trackContentId", null);
        zzIS = jsonobject.optString("trackContentType", null);
        mName = jsonobject.optString("name", null);
        zzIO = jsonobject.optString("language", null);
        if (jsonobject.has("subtype"))
        {
            s = jsonobject.getString("subtype");
            if ("SUBTITLES".equals(s))
            {
                zzJq = 1;
            } else
            if ("CAPTIONS".equals(s))
            {
                zzJq = 2;
            } else
            if ("DESCRIPTIONS".equals(s))
            {
                zzJq = 3;
            } else
            if ("CHAPTERS".equals(s))
            {
                zzJq = 4;
            } else
            if ("METADATA".equals(s))
            {
                zzJq = 5;
            } else
            {
                throw new JSONException((new StringBuilder()).append("invalid subtype: ").append(s).toString());
            }
        } else
        {
            zzJq = 0;
        }
        zzIX = jsonobject.optJSONObject("customData");
    }

    public boolean equals(Object obj)
    {
        boolean flag4;
        boolean flag5;
        flag4 = true;
        flag5 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag5;
        if (!(obj instanceof MediaTrack)) goto _L4; else goto _L3
_L3:
        obj = (MediaTrack)obj;
        boolean flag;
        boolean flag1;
        if (zzIX == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaTrack) (obj)).zzIX == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzIX == null || ((MediaTrack) (obj)).zzIX == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzma.zzd(zzIX, ((MediaTrack) (obj)).zzIX)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzHf == ((MediaTrack) (obj)).zzHf && zzJp == ((MediaTrack) (obj)).zzJp && zzjv.zza(zzIQ, ((MediaTrack) (obj)).zzIQ) && zzjv.zza(zzIS, ((MediaTrack) (obj)).zzIS) && zzjv.zza(mName, ((MediaTrack) (obj)).mName) && zzjv.zza(zzIO, ((MediaTrack) (obj)).zzIO) && zzJq == ((MediaTrack) (obj)).zzJq)
        {
            flag3 = flag4;
        } else
        {
            flag3 = false;
        }
        return flag3;
    }

    public String getContentId()
    {
        return zzIQ;
    }

    public String getContentType()
    {
        return zzIS;
    }

    public JSONObject getCustomData()
    {
        return zzIX;
    }

    public long getId()
    {
        return zzHf;
    }

    public String getLanguage()
    {
        return zzIO;
    }

    public String getName()
    {
        return mName;
    }

    public int getSubtype()
    {
        return zzJq;
    }

    public int getType()
    {
        return zzJp;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzHf), Integer.valueOf(zzJp), zzIQ, zzIS, mName, zzIO, Integer.valueOf(zzJq), zzIX
        });
    }

    public void setContentId(String s)
    {
        zzIQ = s;
    }

    public void setContentType(String s)
    {
        zzIS = s;
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzIX = jsonobject;
    }

    void setLanguage(String s)
    {
        zzIO = s;
    }

    void setName(String s)
    {
        mName = s;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("trackId", zzHf);
        zzJp;
        JVM INSTR tableswitch 1 3: default 276
    //                   1 180
    //                   2 192
    //                   3 204;
           goto _L1 _L2 _L3 _L4
_L1:
        if (zzIQ != null)
        {
            jsonobject.put("trackContentId", zzIQ);
        }
        if (zzIS != null)
        {
            jsonobject.put("trackContentType", zzIS);
        }
        if (mName != null)
        {
            jsonobject.put("name", mName);
        }
        if (!TextUtils.isEmpty(zzIO))
        {
            jsonobject.put("language", zzIO);
        }
        zzJq;
        JVM INSTR tableswitch 1 5: default 279
    //                   1 216
    //                   2 228
    //                   3 240
    //                   4 252
    //                   5 264;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (zzIX == null) goto _L12; else goto _L11
_L11:
        jsonobject.put("customData", zzIX);
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("type", "TEXT");
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        jsonobject.put("type", "AUDIO");
        continue; /* Loop/switch isn't completed */
_L4:
        jsonobject.put("type", "VIDEO");
        continue; /* Loop/switch isn't completed */
_L6:
        jsonobject.put("subtype", "SUBTITLES");
          goto _L5
_L7:
        jsonobject.put("subtype", "CAPTIONS");
          goto _L5
_L8:
        jsonobject.put("subtype", "DESCRIPTIONS");
          goto _L5
_L9:
        jsonobject.put("subtype", "CHAPTERS");
          goto _L5
_L10:
        jsonobject.put("subtype", "METADATA");
          goto _L5
_L12:
        return jsonobject;
        if (true) goto _L1; else goto _L13
_L13:
    }

    void zzaf(int i)
        throws IllegalArgumentException
    {
        if (i <= -1 || i > 5)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid subtype ").append(i).toString());
        }
        if (i != 0 && zzJp != 1)
        {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        } else
        {
            zzJq = i;
            return;
        }
    }
}
