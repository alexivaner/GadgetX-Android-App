// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzma;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata, MediaTrack, TextTrackStyle

public final class MediaInfo
{
    public static class Builder
    {

        private final MediaInfo zzIY;

        public MediaInfo build()
            throws IllegalArgumentException
        {
            zzIY.zzhi();
            return zzIY;
        }

        public Builder setContentType(String s)
            throws IllegalArgumentException
        {
            zzIY.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzIY.setCustomData(jsonobject);
            return this;
        }

        public Builder setMediaTracks(List list)
        {
            zzIY.zzg(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediametadata)
        {
            zzIY.zza(mediametadata);
            return this;
        }

        public Builder setStreamDuration(long l)
            throws IllegalArgumentException
        {
            zzIY.zzm(l);
            return this;
        }

        public Builder setStreamType(int i)
            throws IllegalArgumentException
        {
            zzIY.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle texttrackstyle)
        {
            zzIY.setTextTrackStyle(texttrackstyle);
            return this;
        }

        public Builder(String s)
            throws IllegalArgumentException
        {
            if (TextUtils.isEmpty(s))
            {
                throw new IllegalArgumentException("Content ID cannot be empty");
            } else
            {
                zzIY = new MediaInfo(s);
                return;
            }
        }
    }


    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1L;
    private final String zzIQ;
    private int zzIR;
    private String zzIS;
    private MediaMetadata zzIT;
    private long zzIU;
    private List zzIV;
    private TextTrackStyle zzIW;
    private JSONObject zzIX;

    MediaInfo(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            zzIQ = s;
            zzIR = -1;
            zzIU = -1L;
            return;
        }
    }

    MediaInfo(JSONObject jsonobject)
        throws JSONException
    {
        int i = 0;
        super();
        zzIQ = jsonobject.getString("contentId");
        Object obj = jsonobject.getString("streamType");
        if ("NONE".equals(obj))
        {
            zzIR = 0;
        } else
        if ("BUFFERED".equals(obj))
        {
            zzIR = 1;
        } else
        if ("LIVE".equals(obj))
        {
            zzIR = 2;
        } else
        {
            zzIR = -1;
        }
        zzIS = jsonobject.getString("contentType");
        if (jsonobject.has("metadata"))
        {
            obj = jsonobject.getJSONObject("metadata");
            zzIT = new MediaMetadata(((JSONObject) (obj)).getInt("metadataType"));
            zzIT.zzd(((JSONObject) (obj)));
        }
        zzIU = -1L;
        if (jsonobject.has("duration") && !jsonobject.isNull("duration"))
        {
            double d = jsonobject.optDouble("duration", 0.0D);
            if (!Double.isNaN(d) && !Double.isInfinite(d))
            {
                zzIU = zzjv.zzb(d);
            }
        }
        if (jsonobject.has("tracks"))
        {
            zzIV = new ArrayList();
            for (obj = jsonobject.getJSONArray("tracks"); i < ((JSONArray) (obj)).length(); i++)
            {
                MediaTrack mediatrack = new MediaTrack(((JSONArray) (obj)).getJSONObject(i));
                zzIV.add(mediatrack);
            }

        } else
        {
            zzIV = null;
        }
        if (jsonobject.has("textTrackStyle"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("textTrackStyle");
            TextTrackStyle texttrackstyle = new TextTrackStyle();
            texttrackstyle.zzd(jsonobject1);
            zzIW = texttrackstyle;
        } else
        {
            zzIW = null;
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
        if (!(obj instanceof MediaInfo)) goto _L4; else goto _L3
_L3:
        obj = (MediaInfo)obj;
        boolean flag;
        boolean flag1;
        if (zzIX == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaInfo) (obj)).zzIX == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzIX == null || ((MediaInfo) (obj)).zzIX == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzma.zzd(zzIX, ((MediaInfo) (obj)).zzIX)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzjv.zza(zzIQ, ((MediaInfo) (obj)).zzIQ) && zzIR == ((MediaInfo) (obj)).zzIR && zzjv.zza(zzIS, ((MediaInfo) (obj)).zzIS) && zzjv.zza(zzIT, ((MediaInfo) (obj)).zzIT) && zzIU == ((MediaInfo) (obj)).zzIU)
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

    public List getMediaTracks()
    {
        return zzIV;
    }

    public MediaMetadata getMetadata()
    {
        return zzIT;
    }

    public long getStreamDuration()
    {
        return zzIU;
    }

    public int getStreamType()
    {
        return zzIR;
    }

    public TextTrackStyle getTextTrackStyle()
    {
        return zzIW;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzIQ, Integer.valueOf(zzIR), zzIS, zzIT, Long.valueOf(zzIU), String.valueOf(zzIX)
        });
    }

    void setContentType(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else
        {
            zzIS = s;
            return;
        }
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzIX = jsonobject;
    }

    void setStreamType(int i)
        throws IllegalArgumentException
    {
        if (i < -1 || i > 2)
        {
            throw new IllegalArgumentException("invalid stream type");
        } else
        {
            zzIR = i;
            return;
        }
    }

    public void setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        zzIW = texttrackstyle;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("contentId", zzIQ);
        zzIR;
        JVM INSTR tableswitch 1 2: default 232
    //                   1 241
    //                   2 247;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_247;
_L12:
        Object obj;
        jsonobject.put("streamType", obj);
        if (zzIS != null)
        {
            jsonobject.put("contentType", zzIS);
        }
        if (zzIT != null)
        {
            jsonobject.put("metadata", zzIT.toJson());
        }
        if (zzIU > -1L) goto _L5; else goto _L4
_L4:
        jsonobject.put("duration", JSONObject.NULL);
_L9:
        if (zzIV == null) goto _L7; else goto _L6
_L6:
        obj = new JSONArray();
        for (Iterator iterator = zzIV.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(((MediaTrack)iterator.next()).toJson())) { }
          goto _L8
_L5:
        jsonobject.put("duration", zzjv.zzp(zzIU));
          goto _L9
_L8:
        jsonobject.put("tracks", obj);
_L7:
        if (zzIW != null)
        {
            jsonobject.put("textTrackStyle", zzIW.toJson());
        }
        if (zzIX == null) goto _L11; else goto _L10
_L10:
        jsonobject.put("customData", zzIX);
        return jsonobject;
_L1:
        obj = "NONE";
          goto _L12
        obj;
_L11:
        return jsonobject;
_L2:
        obj = "BUFFERED";
          goto _L12
        obj = "LIVE";
          goto _L12
    }

    void zza(MediaMetadata mediametadata)
    {
        zzIT = mediametadata;
    }

    void zzg(List list)
    {
        zzIV = list;
    }

    void zzhi()
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(zzIQ))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(zzIS))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (zzIR == -1)
        {
            throw new IllegalArgumentException("a valid stream type must be specified");
        } else
        {
            return;
        }
    }

    void zzm(long l)
        throws IllegalArgumentException
    {
        if (l < 0L && l != -1L)
        {
            throw new IllegalArgumentException("Invalid stream duration");
        } else
        {
            zzIU = l;
            return;
        }
    }
}
