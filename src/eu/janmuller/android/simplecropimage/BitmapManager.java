// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class BitmapManager
{
    private static final class State extends Enum
    {

        public static final State ALLOW;
        public static final State CANCEL;
        private static final State ENUM$VALUES[];

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(eu/janmuller/android/simplecropimage/BitmapManager$State, s);
        }

        public static State[] values()
        {
            State astate[] = ENUM$VALUES;
            int i = astate.length;
            State astate1[] = new State[i];
            System.arraycopy(astate, 0, astate1, 0, i);
            return astate1;
        }

        static 
        {
            CANCEL = new State("CANCEL", 0);
            ALLOW = new State("ALLOW", 1);
            ENUM$VALUES = (new State[] {
                CANCEL, ALLOW
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ThreadSet
        implements Iterable
    {

        private final WeakHashMap mWeakCollection = new WeakHashMap();

        public void add(Thread thread)
        {
            mWeakCollection.put(thread, null);
        }

        public Iterator iterator()
        {
            return mWeakCollection.keySet().iterator();
        }

        public void remove(Thread thread)
        {
            mWeakCollection.remove(thread);
        }

        public ThreadSet()
        {
        }
    }

    private static class ThreadStatus
    {

        public android.graphics.BitmapFactory.Options mOptions;
        public State mState;

        public String toString()
        {
            String s;
            if (mState == State.CANCEL)
            {
                s = "Cancel";
            } else
            if (mState == State.ALLOW)
            {
                s = "Allow";
            } else
            {
                s = "?";
            }
            return (new StringBuilder("thread state = ")).append(s).append(", options = ").append(mOptions).toString();
        }

        private ThreadStatus()
        {
            mState = State.ALLOW;
        }

        ThreadStatus(ThreadStatus threadstatus)
        {
            this();
        }
    }


    private static final String TAG = "BitmapManager";
    private static BitmapManager sManager = null;
    private final WeakHashMap mThreadStatus = new WeakHashMap();

    private BitmapManager()
    {
    }

    private ThreadStatus getOrCreateThreadStatus(Thread thread)
    {
        this;
        JVM INSTR monitorenter ;
        ThreadStatus threadstatus1 = (ThreadStatus)mThreadStatus.get(thread);
        ThreadStatus threadstatus;
        threadstatus = threadstatus1;
        if (threadstatus1 != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        threadstatus = new ThreadStatus(null);
        mThreadStatus.put(thread, threadstatus);
        this;
        JVM INSTR monitorexit ;
        return threadstatus;
        thread;
        throw thread;
    }

    public static BitmapManager instance()
    {
        eu/janmuller/android/simplecropimage/BitmapManager;
        JVM INSTR monitorenter ;
        BitmapManager bitmapmanager;
        if (sManager == null)
        {
            sManager = new BitmapManager();
        }
        bitmapmanager = sManager;
        eu/janmuller/android/simplecropimage/BitmapManager;
        JVM INSTR monitorexit ;
        return bitmapmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private void setDecodingOptions(Thread thread, android.graphics.BitmapFactory.Options options)
    {
        this;
        JVM INSTR monitorenter ;
        getOrCreateThreadStatus(thread).mOptions = options;
        this;
        JVM INSTR monitorexit ;
        return;
        thread;
        throw thread;
    }

    public void allowThreadDecoding(ThreadSet threadset)
    {
        this;
        JVM INSTR monitorenter ;
        threadset = threadset.iterator();
_L1:
        boolean flag = threadset.hasNext();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        allowThreadDecoding((Thread)threadset.next());
          goto _L1
        threadset;
        throw threadset;
    }

    public void allowThreadDecoding(Thread thread)
    {
        this;
        JVM INSTR monitorenter ;
        getOrCreateThreadStatus(thread).mState = State.ALLOW;
        this;
        JVM INSTR monitorexit ;
        return;
        thread;
        throw thread;
    }

    public boolean canThreadDecoding(Thread thread)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        thread = (ThreadStatus)mThreadStatus.get(thread);
        if (thread != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        State state;
        thread = ((ThreadStatus) (thread)).mState;
        state = State.CANCEL;
        if (thread == state)
        {
            flag = false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        thread;
        throw thread;
    }

    public void cancelThreadDecoding(ThreadSet threadset)
    {
        this;
        JVM INSTR monitorenter ;
        threadset = threadset.iterator();
_L1:
        boolean flag = threadset.hasNext();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        cancelThreadDecoding((Thread)threadset.next());
          goto _L1
        threadset;
        throw threadset;
    }

    public void cancelThreadDecoding(Thread thread)
    {
        this;
        JVM INSTR monitorenter ;
        thread = getOrCreateThreadStatus(thread);
        thread.mState = State.CANCEL;
        if (((ThreadStatus) (thread)).mOptions != null)
        {
            ((ThreadStatus) (thread)).mOptions.requestCancelDecode();
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        thread;
        throw thread;
    }

    public Bitmap decodeFileDescriptor(FileDescriptor filedescriptor, android.graphics.BitmapFactory.Options options)
    {
        Thread thread;
        if (!options.mCancel)
        {
            if (canThreadDecoding(thread = Thread.currentThread()))
            {
                setDecodingOptions(thread, options);
                filedescriptor = BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
                removeDecodingOptions(thread);
                return filedescriptor;
            }
        }
        return null;
    }

    public void dump()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = mThreadStatus.entrySet().iterator();
_L1:
        boolean flag = iterator.hasNext();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        Log.v("BitmapManager", (new StringBuilder("[Dump] Thread ")).append(entry.getKey()).append(" (").append(((Thread)entry.getKey()).getId()).append(")'s status is ").append(entry.getValue()).toString());
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    android.graphics.BitmapFactory.Options getDecodingOptions(Thread thread)
    {
        this;
        JVM INSTR monitorenter ;
        thread = (ThreadStatus)mThreadStatus.get(thread);
        if (thread == null) goto _L2; else goto _L1
_L1:
        thread = ((ThreadStatus) (thread)).mOptions;
_L4:
        this;
        JVM INSTR monitorexit ;
        return thread;
_L2:
        thread = null;
        if (true) goto _L4; else goto _L3
_L3:
        thread;
        throw thread;
    }

    void removeDecodingOptions(Thread thread)
    {
        this;
        JVM INSTR monitorenter ;
        ((ThreadStatus)mThreadStatus.get(thread)).mOptions = null;
        this;
        JVM INSTR monitorexit ;
        return;
        thread;
        throw thread;
    }

}
