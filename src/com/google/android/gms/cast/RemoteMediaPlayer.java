// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaStatus, CastDevice, TextTrackStyle, 
//            Cast

public class RemoteMediaPlayer
    implements Cast.MessageReceivedCallback
{
    public static interface MediaChannelResult
        extends Result
    {

        public abstract JSONObject getCustomData();
    }

    public static interface OnMetadataUpdatedListener
    {

        public abstract void onMetadataUpdated();
    }

    public static interface OnStatusUpdatedListener
    {

        public abstract void onStatusUpdated();
    }

    private class zza
        implements zzke
    {

        private GoogleApiClient zzJJ;
        private long zzJK;
        final RemoteMediaPlayer zzJw;

        public void zza(String s, String s1, long l, String s2)
            throws IOException
        {
            if (zzJJ == null)
            {
                throw new IOException("No GoogleApiClient available");
            } else
            {
                Cast.CastApi.sendMessage(zzJJ, s, s1).setResultCallback(new zza(this, l));
                return;
            }
        }

        public void zzb(GoogleApiClient googleapiclient)
        {
            zzJJ = googleapiclient;
        }

        public long zzhk()
        {
            long l = zzJK + 1L;
            zzJK = l;
            return l;
        }

        public zza()
        {
            zzJw = RemoteMediaPlayer.this;
            super();
            zzJK = 0L;
        }
    }

    private final class zza.zza
        implements ResultCallback
    {

        private final long zzJL;
        final zza zzJM;

        public void onResult(Result result)
        {
            zzi((Status)result);
        }

        public void zzi(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.zze(zzJM.zzJw).zzb(zzJL, status.getStatusCode());
            }
        }

        zza.zza(zza zza1, long l)
        {
            zzJM = zza1;
            super();
            zzJL = l;
        }
    }

    private static abstract class zzb extends zzjr
    {

        zzkf zzJN;

        public Result createFailedResult(Status status)
        {
            return zzj(status);
        }

        public MediaChannelResult zzj(Status status)
        {
            return new MediaChannelResult(this, status) {

                final Status zzGT;
                final zzb zzJO;

                public JSONObject getCustomData()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzGT;
                }

            
            {
                zzJO = zzb1;
                zzGT = status;
                super();
            }
            };
        }

        zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzJN = new _cls1(this);
        }
    }

    private static final class zzc
        implements MediaChannelResult
    {

        private final Status zzHb;
        private final JSONObject zzIX;

        public JSONObject getCustomData()
        {
            return zzIX;
        }

        public Status getStatus()
        {
            return zzHb;
        }

        zzc(Status status, JSONObject jsonobject)
        {
            zzHb = status;
            zzIX = jsonobject;
        }
    }


    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzkd zzJs = new zzkd(null) {

        final RemoteMediaPlayer zzJw;

        protected void onMetadataUpdated()
        {
            RemoteMediaPlayer.zzb(zzJw);
        }

        protected void onStatusUpdated()
        {
            RemoteMediaPlayer.zza(zzJw);
        }

            
            {
                zzJw = RemoteMediaPlayer.this;
                super(s);
            }
    };
    private final zza zzJt = new zza();
    private OnMetadataUpdatedListener zzJu;
    private OnStatusUpdatedListener zzJv;
    private final Object zznh = new Object();

    public RemoteMediaPlayer()
    {
        zzJs.zza(zzJt);
    }

    private void onMetadataUpdated()
    {
        if (zzJu != null)
        {
            zzJu.onMetadataUpdated();
        }
    }

    private void onStatusUpdated()
    {
        if (zzJv != null)
        {
            zzJv.onStatusUpdated();
        }
    }

    static void zza(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onStatusUpdated();
    }

    static void zzb(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onMetadataUpdated();
    }

    static Object zzc(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zznh;
    }

    static zza zzd(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzJt;
    }

    static zzkd zze(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.zzJs;
    }

    public long getApproximateStreamPosition()
    {
        long l;
        synchronized (zznh)
        {
            l = zzJs.getApproximateStreamPosition();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MediaInfo getMediaInfo()
    {
        MediaInfo mediainfo;
        synchronized (zznh)
        {
            mediainfo = zzJs.getMediaInfo();
        }
        return mediainfo;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MediaStatus getMediaStatus()
    {
        MediaStatus mediastatus;
        synchronized (zznh)
        {
            mediastatus = zzJs.getMediaStatus();
        }
        return mediastatus;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getNamespace()
    {
        return zzJs.getNamespace();
    }

    public long getStreamDuration()
    {
        long l;
        synchronized (zznh)
        {
            l = zzJs.getStreamDuration();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo)
    {
        return load(googleapiclient, mediainfo, true, 0L, null, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag)
    {
        return load(googleapiclient, mediainfo, flag, 0L, null, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l)
    {
        return load(googleapiclient, mediainfo, flag, l, null, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
    {
        return load(googleapiclient, mediainfo, flag, l, null, jsonobject);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, long al[], JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, mediainfo, flag, l, al, jsonobject) {

            final MediaInfo zzJA;
            final boolean zzJB;
            final long zzJC;
            final long zzJD[];
            final JSONObject zzJE;
            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJA, zzJB, zzJC, zzJD, zzJE);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJA = mediainfo;
                zzJB = flag;
                zzJC = l;
                zzJD = al;
                zzJE = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        zzJs.zzaI(s1);
    }

    public PendingResult pause(GoogleApiClient googleapiclient)
    {
        return pause(googleapiclient, null);
    }

    public PendingResult pause(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final JSONObject zzJE;
            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJE);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJE = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult play(GoogleApiClient googleapiclient)
    {
        return play(googleapiclient, null);
    }

    public PendingResult play(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final JSONObject zzJE;
            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zzc(zzJN, zzJE);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJE = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient) {

            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zza(zzJN);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                super(googleapiclient);
            }
        });
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l)
    {
        return seek(googleapiclient, l, 0, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i)
    {
        return seek(googleapiclient, l, i, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, l, i, jsonobject) {

            final JSONObject zzJE;
            final long zzJF;
            final int zzJG;
            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJF, zzJG, zzJE);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJF = l;
                zzJG = i;
                zzJE = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setActiveMediaTracks(GoogleApiClient googleapiclient, long al[])
    {
        if (al == null)
        {
            throw new IllegalArgumentException("trackIds cannot be null");
        } else
        {
            return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, al) {

                final RemoteMediaPlayer zzJw;
                final GoogleApiClient zzJx;
                final long zzJy[];

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                {
                    zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                    zzju1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                    RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJy);
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                    zzju1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    setResult(zzj(new Status(2100)));
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                      goto _L1
                    obj;
                    zzju1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                    throw obj;
                }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJy = al;
                super(googleapiclient);
            }
            });
        }
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onmetadataupdatedlistener)
    {
        zzJu = onmetadataupdatedlistener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onstatusupdatedlistener)
    {
        zzJv = onstatusupdatedlistener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag)
    {
        return setStreamMute(googleapiclient, flag, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, flag, jsonobject) {

            final JSONObject zzJE;
            final boolean zzJI;
            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJI, zzJE);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJI = flag;
                zzJE = jsonobject;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d)
        throws IllegalArgumentException
    {
        return setStreamVolume(googleapiclient, d, null);
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        } else
        {
            return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, d, jsonobject) {

                final JSONObject zzJE;
                final double zzJH;
                final RemoteMediaPlayer zzJw;
                final GoogleApiClient zzJx;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                {
                    zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                    zzju1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                    RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJH, zzJE);
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                    zzju1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    setResult(zzj(new Status(2100)));
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                      goto _L1
                    obj;
                    zzju1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    setResult(zzj(new Status(2100)));
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                      goto _L1
                    obj;
                    setResult(zzj(new Status(2100)));
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                      goto _L1
                    obj;
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                    throw obj;
                }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJH = d;
                zzJE = jsonobject;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult setTextTrackStyle(GoogleApiClient googleapiclient, TextTrackStyle texttrackstyle)
    {
        if (texttrackstyle == null)
        {
            throw new IllegalArgumentException("trackStyle cannot be null");
        } else
        {
            return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, texttrackstyle) {

                final RemoteMediaPlayer zzJw;
                final GoogleApiClient zzJx;
                final TextTrackStyle zzJz;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                {
                    zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                    zzju1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                    RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJz);
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                    zzju1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    setResult(zzj(new Status(2100)));
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                      goto _L1
                    obj;
                    zzju1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    RemoteMediaPlayer.zzd(zzJw).zzb(null);
                    throw obj;
                }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJz = texttrackstyle;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult stop(GoogleApiClient googleapiclient)
    {
        return stop(googleapiclient, null);
    }

    public PendingResult stop(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, googleapiclient, jsonobject) {

            final JSONObject zzJE;
            final RemoteMediaPlayer zzJw;
            final GoogleApiClient zzJx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzju)zza1);
            }

            protected void zza(zzju zzju1)
            {
                zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
                zzju1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
                RemoteMediaPlayer.zze(zzJw).zzb(zzJN, zzJE);
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
                zzju1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                setResult(zzj(new Status(2100)));
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                  goto _L1
                obj;
                zzju1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.zzd(zzJw).zzb(null);
                throw obj;
            }

            
            {
                zzJw = RemoteMediaPlayer.this;
                zzJx = googleapiclient1;
                zzJE = jsonobject;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/cast/RemoteMediaPlayer$zzb$1

/* anonymous class */
    class zzb._cls1
        implements zzkf
    {

        final zzb zzJO;

        public void zza(long l, int i, Object obj)
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
            } else
            {
                obj = null;
            }
            zzJO.setResult(new zzc(new Status(i), ((JSONObject) (obj))));
        }

        public void zzn(long l)
        {
            zzJO.setResult(zzJO.zzj(new Status(2103)));
        }

            
            {
                zzJO = zzb1;
                super();
            }
    }

}
