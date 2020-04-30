// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzjs, zzjv, zzkg, zzkc, 
//            zzkf

public class zzkd extends zzjs
{

    private static final String NAMESPACE = zzjv.zzaL("com.google.cast.media");
    private long zzKV;
    private MediaStatus zzKW;
    private final List zzKX = new ArrayList();
    private final zzkg zzKY = new zzkg(0x5265c00L);
    private final zzkg zzKZ = new zzkg(0x5265c00L);
    private final zzkg zzLa = new zzkg(0x5265c00L);
    private final zzkg zzLb = new zzkg(0x5265c00L);
    private final zzkg zzLc = new zzkg(0x5265c00L);
    private final zzkg zzLd = new zzkg(0x5265c00L);
    private final zzkg zzLe = new zzkg(0x5265c00L);
    private final zzkg zzLf = new zzkg(0x5265c00L);
    private final zzkg zzLg = new zzkg(0x5265c00L);
    private final zzkg zzLh = new zzkg(0x5265c00L);

    public zzkd(String s)
    {
        super(NAMESPACE, "MediaControlChannel", s, 1000L);
        zzKX.add(zzKY);
        zzKX.add(zzKZ);
        zzKX.add(zzLa);
        zzKX.add(zzLb);
        zzKX.add(zzLc);
        zzKX.add(zzLd);
        zzKX.add(zzLe);
        zzKX.add(zzLf);
        zzKX.add(zzLg);
        zzKX.add(zzLh);
    }

    private void zza(long l, JSONObject jsonobject)
        throws JSONException
    {
        int i;
        int j;
label0:
        {
            j = 1;
            boolean flag1 = zzKY.zzq(l);
            boolean flag;
            if (zzLc.zzhI() && !zzLc.zzq(l))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (zzLd.zzhI())
            {
                flag = j;
                if (!zzLd.zzq(l))
                {
                    break label0;
                }
            }
            if (zzLe.zzhI() && !zzLe.zzq(l))
            {
                flag = j;
            } else
            {
                flag = false;
            }
        }
        if (i != 0)
        {
            i = 2;
        } else
        {
            i = 0;
        }
        j = i;
        if (flag)
        {
            j = i | 1;
        }
        if (flag1 || zzKW == null)
        {
            zzKW = new MediaStatus(jsonobject);
            zzKV = SystemClock.elapsedRealtime();
            i = 7;
        } else
        {
            i = zzKW.zza(jsonobject, j);
        }
        if ((i & 1) != 0)
        {
            zzKV = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0)
        {
            zzKV = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0)
        {
            onMetadataUpdated();
        }
        for (jsonobject = zzKX.iterator(); jsonobject.hasNext(); ((zzkg)jsonobject.next()).zzc(l, 0)) { }
    }

    public long getApproximateStreamPosition()
    {
        long l;
        long l1;
        MediaInfo mediainfo;
        for (mediainfo = getMediaInfo(); mediainfo == null || zzKV == 0L;)
        {
            return 0L;
        }

        double d = zzKW.getPlaybackRate();
        long l2 = zzKW.getStreamPosition();
        int i = zzKW.getPlayerState();
        if (d == 0.0D || i != 2)
        {
            return l2;
        }
        l = SystemClock.elapsedRealtime() - zzKV;
        if (l < 0L)
        {
            l = 0L;
        }
        if (l == 0L)
        {
            return l2;
        }
        l1 = mediainfo.getStreamDuration();
        l = l2 + (long)((double)l * d);
        if (l1 <= 0L || l <= l1) goto _L2; else goto _L1
_L1:
        l = l1;
_L4:
        return l;
_L2:
        if (l < 0L)
        {
            l = 0L;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public MediaInfo getMediaInfo()
    {
        if (zzKW == null)
        {
            return null;
        } else
        {
            return zzKW.getMediaInfo();
        }
    }

    public MediaStatus getMediaStatus()
    {
        return zzKW;
    }

    public long getStreamDuration()
    {
        MediaInfo mediainfo = getMediaInfo();
        if (mediainfo != null)
        {
            return mediainfo.getStreamDuration();
        } else
        {
            return 0L;
        }
    }

    protected void onMetadataUpdated()
    {
    }

    protected void onStatusUpdated()
    {
    }

    public long zza(zzkf zzkf)
        throws IOException
    {
        JSONObject jsonobject = new JSONObject();
        long l = zzhn();
        zzLf.zza(l, zzkf);
        zzK(true);
        try
        {
            jsonobject.put("requestId", l);
            jsonobject.put("type", "GET_STATUS");
            if (zzKW != null)
            {
                jsonobject.put("mediaSessionId", zzKW.zzhj());
            }
        }
        // Misplaced declaration of an exception variable
        catch (zzkf zzkf) { }
        zza(jsonobject.toString(), l, null);
        return l;
    }

    public long zza(zzkf zzkf, double d, JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        }
        jsonobject1 = new JSONObject();
        l = zzhn();
        zzLd.zza(l, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", zzhj());
        zzkf = new JSONObject();
        zzkf.put("level", d);
        jsonobject1.put("volume", zzkf);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzkf zzkf, long l, int i, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = zzhn();
        zzLc.zza(l1, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "SEEK");
        jsonobject1.put("mediaSessionId", zzhj());
        jsonobject1.put("currentTime", zzjv.zzp(l));
        if (i != 1) goto _L2; else goto _L1
_L1:
        jsonobject1.put("resumeState", "PLAYBACK_START");
_L4:
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l1, null);
        return l1;
_L2:
        if (i != 2) goto _L4; else goto _L3
_L3:
        jsonobject1.put("resumeState", "PLAYBACK_PAUSE");
          goto _L4
    }

    public long zza(zzkf zzkf, MediaInfo mediainfo, boolean flag, long l, long al[], JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = zzhn();
        zzKY.zza(l1, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "LOAD");
        jsonobject1.put("media", mediainfo.toJson());
        jsonobject1.put("autoplay", flag);
        jsonobject1.put("currentTime", zzjv.zzp(l));
        if (al == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        zzkf = new JSONArray();
        int i = 0;
_L2:
        if (i >= al.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzkf.put(i, al[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject1.put("activeTrackIds", zzkf);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l1, null);
        return l1;
    }

    public long zza(zzkf zzkf, TextTrackStyle texttrackstyle)
        throws IOException
    {
        JSONObject jsonobject;
        long l;
        jsonobject = new JSONObject();
        l = zzhn();
        zzLh.zza(l, zzkf);
        zzK(true);
        jsonobject.put("requestId", l);
        jsonobject.put("type", "EDIT_TRACKS_INFO");
        if (texttrackstyle == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        jsonobject.put("textTrackStyle", texttrackstyle.toJson());
        jsonobject.put("mediaSessionId", zzhj());
_L2:
        zza(jsonobject.toString(), l, null);
        return l;
        zzkf;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public long zza(zzkf zzkf, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzhn();
        zzKZ.zza(l, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PAUSE");
        jsonobject1.put("mediaSessionId", zzhj());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzkf zzkf, boolean flag, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzhn();
        zzLe.zza(l, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", zzhj());
        zzkf = new JSONObject();
        zzkf.put("muted", flag);
        jsonobject1.put("volume", zzkf);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zza(zzkf zzkf, long al[])
        throws IOException
    {
        JSONObject jsonobject;
        long l;
        jsonobject = new JSONObject();
        l = zzhn();
        zzLg.zza(l, zzkf);
        zzK(true);
        jsonobject.put("requestId", l);
        jsonobject.put("type", "EDIT_TRACKS_INFO");
        jsonobject.put("mediaSessionId", zzhj());
        zzkf = new JSONArray();
        int i = 0;
_L2:
        if (i >= al.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzkf.put(i, al[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            jsonobject.put("activeTrackIds", zzkf);
        }
        // Misplaced declaration of an exception variable
        catch (zzkf zzkf) { }
        zza(jsonobject.toString(), l, null);
        return l;
    }

    public final void zzaI(String s)
    {
        zzKe.zzb("message received: %s", new Object[] {
            s
        });
        Object obj;
        Object obj1;
        long l;
        obj = new JSONObject(s);
        obj1 = ((JSONObject) (obj)).getString("type");
        l = ((JSONObject) (obj)).optLong("requestId", -1L);
        if (!((String) (obj1)).equals("MEDIA_STATUS"))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = ((JSONObject) (obj)).getJSONArray("status");
        if (((JSONArray) (obj)).length() > 0)
        {
            zza(l, ((JSONArray) (obj)).getJSONObject(0));
            return;
        }
        try
        {
            zzKW = null;
            onStatusUpdated();
            onMetadataUpdated();
            zzLf.zzc(l, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzKe.zzd("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
        }
        return;
        if (((String) (obj1)).equals("INVALID_PLAYER_STATE"))
        {
            zzKe.zzd("received unexpected error: Invalid Player State.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (obj1 = zzKX.iterator(); ((Iterator) (obj1)).hasNext(); ((zzkg)((Iterator) (obj1)).next()).zzb(l, 2100, obj)) { }
            break MISSING_BLOCK_LABEL_342;
        }
        if (((String) (obj1)).equals("LOAD_FAILED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            zzKY.zzb(l, 2100, obj);
            return;
        }
        if (((String) (obj1)).equals("LOAD_CANCELLED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            zzKY.zzb(l, 2101, obj);
            return;
        }
        if (((String) (obj1)).equals("INVALID_REQUEST"))
        {
            zzKe.zzd("received unexpected error: Invalid Request.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            for (Iterator iterator = zzKX.iterator(); iterator.hasNext(); ((zzkg)iterator.next()).zzb(l, 2100, obj)) { }
        }
    }

    public long zzb(zzkf zzkf, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzhn();
        zzLb.zza(l, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "STOP");
        jsonobject1.put("mediaSessionId", zzhj());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public void zzb(long l, int i)
    {
        for (Iterator iterator = zzKX.iterator(); iterator.hasNext(); ((zzkg)iterator.next()).zzc(l, i)) { }
    }

    public long zzc(zzkf zzkf, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = zzhn();
        zzLa.zza(l, zzkf);
        zzK(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PLAY");
        jsonobject1.put("mediaSessionId", zzhj());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (zzkf zzkf) { }
        }
        zza(jsonobject1.toString(), l, null);
        return l;
    }

    public long zzhj()
        throws IllegalStateException
    {
        if (zzKW == null)
        {
            throw new IllegalStateException("No current media session");
        } else
        {
            return zzKW.zzhj();
        }
    }

    protected boolean zzo(long l)
    {
        for (Iterator iterator = zzKX.iterator(); iterator.hasNext(); ((zzkg)iterator.next()).zzd(l, 2102)) { }
        Object obj = zzkg.zzLm;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator1 = zzKX.iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((zzkg)iterator1.next()).zzhI()) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
