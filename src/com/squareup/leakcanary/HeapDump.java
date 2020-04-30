// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.leakcanary;

import java.io.File;
import java.io.Serializable;

// Referenced classes of package com.squareup.leakcanary:
//            Preconditions

public final class HeapDump
    implements Serializable
{
    public static interface Listener
    {

        public abstract void analyze(HeapDump heapdump);
    }


    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public final File heapDumpFile;
    public final String referenceKey;
    public final String referenceName;
    public final long watchDurationMs;

    public HeapDump(File file, String s, String s1, long l, long l1, 
            long l2)
    {
        heapDumpFile = (File)Preconditions.checkNotNull(file, "heapDumpFile");
        referenceKey = (String)Preconditions.checkNotNull(s, "referenceKey");
        referenceName = (String)Preconditions.checkNotNull(s1, "referenceName");
        watchDurationMs = l;
        gcDurationMs = l1;
        heapDumpDurationMs = l2;
    }

    public HeapDump renameFile(File file)
    {
        heapDumpFile.renameTo(file);
        return new HeapDump(file, referenceKey, referenceName, watchDurationMs, gcDurationMs, heapDumpDurationMs);
    }
}
