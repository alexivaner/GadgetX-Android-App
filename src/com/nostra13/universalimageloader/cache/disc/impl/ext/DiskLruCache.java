// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            Util, StrictLineReader

final class DiskLruCache
    implements Closeable
{
    public final class Editor
    {

        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        final DiskLruCache this$0;
        private final boolean written[];

        public void abort()
            throws IOException
        {
            completeEdit(this, false);
        }

        public void abortUnlessCommitted()
        {
            if (committed)
            {
                break MISSING_BLOCK_LABEL_11;
            }
            abort();
            return;
            IOException ioexception;
            ioexception;
        }

        public void commit()
            throws IOException
        {
            if (hasErrors)
            {
                completeEdit(this, false);
                remove(entry.key);
            } else
            {
                completeEdit(this, true);
            }
            committed = true;
        }

        public String getString(int i)
            throws IOException
        {
            InputStream inputstream = newInputStream(i);
            if (inputstream != null)
            {
                return DiskLruCache.inputStreamToString(inputstream);
            } else
            {
                return null;
            }
        }

        public InputStream newInputStream(int i)
            throws IOException
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            disklrucache;
            JVM INSTR monitorexit ;
            throw obj;
            if (entry.readable)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
            FileInputStream fileinputstream = new FileInputStream(entry.getCleanFile(i));
            disklrucache;
            JVM INSTR monitorexit ;
            return fileinputstream;
            fileinputstream;
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
        }

        public OutputStream newOutputStream(int i)
            throws IOException
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            disklrucache;
            JVM INSTR monitorexit ;
            throw obj;
            File file;
            if (!entry.readable)
            {
                written[i] = true;
            }
            file = entry.getDirtyFile(i);
            Object obj1 = new FileOutputStream(file);
_L1:
            obj1 = new FaultHidingOutputStream(((OutputStream) (obj1)), null);
            disklrucache;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
            obj1;
            directory.mkdirs();
            obj1 = new FileOutputStream(file);
              goto _L1
            obj1;
            obj1 = DiskLruCache.NULL_OUTPUT_STREAM;
            disklrucache;
            JVM INSTR monitorexit ;
            return ((OutputStream) (obj1));
        }

        public void set(int i, String s)
            throws IOException
        {
            Object obj1 = null;
            Object obj = new OutputStreamWriter(newOutputStream(i), Util.UTF_8);
            ((Writer) (obj)).write(s);
            Util.closeQuietly(((Closeable) (obj)));
            return;
            obj;
            s = obj1;
_L2:
            Util.closeQuietly(s);
            throw obj;
            Exception exception;
            exception;
            s = ((String) (obj));
            obj = exception;
            if (true) goto _L2; else goto _L1
_L1:
        }




        private Editor(Entry entry1)
        {
            this$0 = DiskLruCache.this;
            super();
            entry = entry1;
            if (entry1.readable)
            {
                disklrucache = null;
            } else
            {
                disklrucache = new boolean[valueCount];
            }
            written = DiskLruCache.this;
        }

        Editor(Entry entry1, Editor editor)
        {
            this(entry1);
        }
    }

    private class Editor.FaultHidingOutputStream extends FilterOutputStream
    {

        final Editor this$1;

        public void close()
        {
            try
            {
                out.close();
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
            }
        }

        public void flush()
        {
            try
            {
                out.flush();
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
            }
        }

        public void write(int i)
        {
            try
            {
                out.write(i);
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
            }
        }

        public void write(byte abyte0[], int i, int j)
        {
            try
            {
                out.write(abyte0, i, j);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                hasErrors = true;
            }
        }

        private Editor.FaultHidingOutputStream(OutputStream outputstream)
        {
            this$1 = Editor.this;
            super(outputstream);
        }

        Editor.FaultHidingOutputStream(OutputStream outputstream, Editor.FaultHidingOutputStream faulthidingoutputstream)
        {
            this(outputstream);
        }
    }

    private final class Entry
    {

        private Editor currentEditor;
        private final String key;
        private final long lengths[];
        private boolean readable;
        private long sequenceNumber;
        final DiskLruCache this$0;

        private IOException invalidLengths(String as[])
            throws IOException
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
        }

        private void setLengths(String as[])
            throws IOException
        {
            int i;
            if (as.length != valueCount)
            {
                throw invalidLengths(as);
            }
            i = 0;
_L1:
            try
            {
                if (i >= as.length)
                {
                    return;
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                throw invalidLengths(as);
            }
            lengths[i] = Long.parseLong(as[i]);
            i++;
              goto _L1
        }

        public File getCleanFile(int i)
        {
            return new File(directory, (new StringBuilder(String.valueOf(key))).append(i).toString());
        }

        public File getDirtyFile(int i)
        {
            return new File(directory, (new StringBuilder(String.valueOf(key))).append(i).append(".tmp").toString());
        }

        public String getLengths()
            throws IOException
        {
            StringBuilder stringbuilder = new StringBuilder();
            long al[] = lengths;
            int j = al.length;
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return stringbuilder.toString();
                }
                long l = al[i];
                stringbuilder.append(' ').append(l);
                i++;
            } while (true);
        }










        private Entry(String s)
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            lengths = new long[valueCount];
        }

        Entry(String s, Entry entry)
        {
            this(s);
        }
    }

    public final class Snapshot
        implements Closeable
    {

        private File files[];
        private final InputStream ins[];
        private final String key;
        private final long lengths[];
        private final long sequenceNumber;
        final DiskLruCache this$0;

        public void close()
        {
            InputStream ainputstream[] = ins;
            int j = ainputstream.length;
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return;
                }
                Util.closeQuietly(ainputstream[i]);
                i++;
            } while (true);
        }

        public Editor edit()
            throws IOException
        {
            return DiskLruCache.this.edit(key, sequenceNumber);
        }

        public File getFile(int i)
        {
            return files[i];
        }

        public InputStream getInputStream(int i)
        {
            return ins[i];
        }

        public long getLength(int i)
        {
            return lengths[i];
        }

        public String getString(int i)
            throws IOException
        {
            return DiskLruCache.inputStreamToString(getInputStream(i));
        }

        private Snapshot(String s, long l, File afile[], InputStream ainputstream[], long al[])
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            sequenceNumber = l;
            files = afile;
            ins = ainputstream;
            lengths = al;
        }

        Snapshot(String s, long l, File afile[], InputStream ainputstream[], long al[], 
                Snapshot snapshot)
        {
            this(s, l, afile, ainputstream, al);
        }
    }


    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {

        public void write(int i)
            throws IOException
        {
        }

    };
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable cleanupCallable = new Callable() {

        final DiskLruCache this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
label0:
            {
                synchronized (DiskLruCache.this)
                {
                    if (journalWriter != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            trimToSize();
            trimToFileCount();
            if (journalRebuildRequired())
            {
                rebuildJournal();
                redundantOpCount = 0;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = DiskLruCache.this;
                super();
            }
    };
    private final File directory;
    final ThreadPoolExecutor executorService;
    private int fileCount;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private int maxFileCount;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private DiskLruCache(File file, int i, int j, long l, int k)
    {
        size = 0L;
        fileCount = 0;
        nextSequenceNumber = 0L;
        executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        journalFileBackup = new File(file, "journal.bkp");
        valueCount = j;
        maxSize = l;
        maxFileCount = k;
    }

    private void checkNotClosed()
    {
        if (journalWriter == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    private void completeEdit(Editor editor, boolean flag)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        entry = editor.entry;
        if (entry.currentEditor != editor)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_28;
        editor;
        this;
        JVM INSTR monitorexit ;
        throw editor;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (entry.readable) goto _L2; else goto _L3
_L3:
        int i = 0;
_L13:
        if (i < valueCount) goto _L4; else goto _L2
_L12:
        if (i < valueCount) goto _L6; else goto _L5
_L5:
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag)) goto _L8; else goto _L7
_L7:
        entry.readable = true;
        journalWriter.write((new StringBuilder("CLEAN ")).append(entry.key).append(entry.getLengths()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        long l = nextSequenceNumber;
        nextSequenceNumber = 1L + l;
        entry.sequenceNumber = l;
_L11:
        journalWriter.flush();
        if (size > maxSize || fileCount > maxFileCount || journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
_L10:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!editor.written[i])
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i).toString());
        }
        if (entry.getDirtyFile(i).exists())
        {
            break; /* Loop/switch isn't completed */
        }
        editor.abort();
        if (true) goto _L10; else goto _L9
_L6:
        editor = entry.getDirtyFile(i);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_350;
        }
        if (editor.exists())
        {
            File file = entry.getCleanFile(i);
            editor.renameTo(file);
            long l1 = entry.lengths[i];
            long l2 = file.length();
            entry.lengths[i] = l2;
            size = (size - l1) + l2;
            fileCount = fileCount + 1;
        }
        break MISSING_BLOCK_LABEL_419;
        deleteIfExists(editor);
        break MISSING_BLOCK_LABEL_419;
_L8:
        lruEntries.remove(entry.key);
        journalWriter.write((new StringBuilder("REMOVE ")).append(entry.key).append('\n').toString());
          goto _L11
_L2:
        i = 0;
          goto _L12
_L9:
        i++;
          goto _L13
        i++;
          goto _L12
    }

    private static void deleteIfExists(File file)
        throws IOException
    {
        if (file.exists() && !file.delete())
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private Editor edit(String s, long l)
        throws IOException
    {
        Editor editor = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (l == -1L) goto _L2; else goto _L1
_L1:
        Object obj = editor;
        if (entry == null) goto _L4; else goto _L3
_L3:
        long l1 = entry.sequenceNumber;
        if (l1 == l) goto _L2; else goto _L5
_L5:
        obj = editor;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Editor) (obj));
_L2:
        if (entry != null) goto _L7; else goto _L6
_L6:
        obj = new Entry(s, null);
        lruEntries.put(s, obj);
_L9:
        editor = new Editor(((Entry) (obj)), null);
        obj.currentEditor = editor;
        journalWriter.write((new StringBuilder("DIRTY ")).append(s).append('\n').toString());
        journalWriter.flush();
        obj = editor;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L7:
        Editor editor1 = entry.currentEditor;
        obj = entry;
        if (editor1 == null) goto _L9; else goto _L8
_L8:
        obj = editor;
        if (true) goto _L4; else goto _L10
_L10:
    }

    private static String inputStreamToString(InputStream inputstream)
        throws IOException
    {
        return Util.readFully(new InputStreamReader(inputstream, Util.UTF_8));
    }

    private boolean journalRebuildRequired()
    {
        return redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size();
    }

    public static DiskLruCache open(File file, int i, int j, long l, int k)
        throws IOException
    {
        Object obj;
        if (l <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (k <= 0)
        {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        obj = new File(file, "journal.bkp");
        if (((File) (obj)).exists())
        {
            File file1 = new File(file, "journal");
            if (file1.exists())
            {
                ((File) (obj)).delete();
            } else
            {
                renameTo(((File) (obj)), file1, false);
            }
        }
        obj = new DiskLruCache(file, i, j, l, k);
        if (!((DiskLruCache) (obj)).journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_229;
        }
        ((DiskLruCache) (obj)).readJournal();
        ((DiskLruCache) (obj)).processJournal();
        obj.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((DiskLruCache) (obj)).journalFile, true), Util.US_ASCII));
        return ((DiskLruCache) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder("DiskLruCache ")).append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((DiskLruCache) (obj)).delete();
        file.mkdirs();
        file = new DiskLruCache(file, i, j, l, k);
        file.rebuildJournal();
        return file;
    }

    private void processJournal()
        throws IOException
    {
        Iterator iterator;
        deleteIfExists(journalFileTmp);
        iterator = lruEntries.values().iterator();
_L2:
        Entry entry;
        int j;
        if (!iterator.hasNext())
        {
            return;
        }
        entry = (Entry)iterator.next();
        if (entry.currentEditor == null)
        {
            int i = 0;
            while (i < valueCount) 
            {
                size = size + entry.lengths[i];
                fileCount = fileCount + 1;
                i++;
            }
            continue; /* Loop/switch isn't completed */
        }
        entry.currentEditor = null;
        j = 0;
_L3:
label0:
        {
            if (j < valueCount)
            {
                break label0;
            }
            iterator.remove();
        }
        if (true) goto _L2; else goto _L1
_L1:
        deleteIfExists(entry.getCleanFile(j));
        deleteIfExists(entry.getDirtyFile(j));
        j++;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private void readJournal()
        throws IOException
    {
        StrictLineReader strictlinereader = new StrictLineReader(new FileInputStream(journalFile), Util.US_ASCII);
        String s = strictlinereader.readLine();
        String s1 = strictlinereader.readLine();
        String s2 = strictlinereader.readLine();
        String s3 = strictlinereader.readLine();
        String s4 = strictlinereader.readLine();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(appVersion).equals(s2) || !Integer.toString(valueCount).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_179;
        Object obj;
        obj;
        Util.closeQuietly(strictlinereader);
        throw obj;
        int i = 0;
_L2:
        readJournalLine(strictlinereader.readLine());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        redundantOpCount = i - lruEntries.size();
        Util.closeQuietly(strictlinereader);
        return;
    }

    private void readJournalLine(String s)
        throws IOException
    {
        int i;
        int j;
        int k;
        i = s.indexOf(' ');
        if (i == -1)
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s).toString());
        }
        j = i + 1;
        k = s.indexOf(' ', j);
        if (k != -1) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        s2 = s.substring(j);
        s1 = s2;
        if (i != "REMOVE".length()) goto _L4; else goto _L3
_L3:
        s1 = s2;
        if (!s.startsWith("REMOVE")) goto _L4; else goto _L5
_L5:
        lruEntries.remove(s2);
_L7:
        return;
_L2:
        s1 = s.substring(j, k);
_L4:
        Entry entry1 = (Entry)lruEntries.get(s1);
        Entry entry = entry1;
        if (entry1 == null)
        {
            entry = new Entry(s1, null);
            lruEntries.put(s1, entry);
        }
        if (k != -1 && i == "CLEAN".length() && s.startsWith("CLEAN"))
        {
            s = s.substring(k + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(s);
            return;
        }
        if (k == -1 && i == "DIRTY".length() && s.startsWith("DIRTY"))
        {
            entry.currentEditor = new Editor(entry, null);
            return;
        }
        if (k != -1 || i != "READ".length() || !s.startsWith("READ"))
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s).toString());
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void rebuildJournal()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (journalWriter != null)
        {
            journalWriter.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFileTmp), Util.US_ASCII));
        Iterator iterator;
        ((Writer) (obj)).write("libcore.io.DiskLruCache");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("1");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(appVersion));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(valueCount));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("\n");
        iterator = lruEntries.values().iterator();
_L1:
        boolean flag = iterator.hasNext();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        ((Writer) (obj)).close();
        if (journalFile.exists())
        {
            renameTo(journalFile, journalFileBackup, true);
        }
        renameTo(journalFileTmp, journalFile, false);
        journalFileBackup.delete();
        journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFile, true), Util.US_ASCII));
        this;
        JVM INSTR monitorexit ;
        return;
        Entry entry;
        entry = (Entry)iterator.next();
        if (entry.currentEditor == null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        ((Writer) (obj)).write((new StringBuilder("DIRTY ")).append(entry.key).append('\n').toString());
          goto _L1
        Exception exception;
        exception;
        ((Writer) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder("CLEAN ")).append(entry.key).append(entry.getLengths()).append('\n').toString());
          goto _L1
    }

    private static void renameTo(File file, File file1, boolean flag)
        throws IOException
    {
        if (flag)
        {
            deleteIfExists(file1);
        }
        if (!file.renameTo(file1))
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private void trimToFileCount()
        throws IOException
    {
        do
        {
            if (fileCount <= maxFileCount)
            {
                return;
            }
            remove((String)((java.util.Map.Entry)lruEntries.entrySet().iterator().next()).getKey());
        } while (true);
    }

    private void trimToSize()
        throws IOException
    {
        do
        {
            if (size <= maxSize)
            {
                return;
            }
            remove((String)((java.util.Map.Entry)lruEntries.entrySet().iterator().next()).getKey());
        } while (true);
    }

    private void validateKey(String s)
    {
        if (!LEGAL_KEY_PATTERN.matcher(s).matches())
        {
            throw new IllegalArgumentException((new StringBuilder("keys must match regex [a-z0-9_-]{1,64}: \"")).append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = journalWriter;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = (new ArrayList(lruEntries.values())).iterator();
_L4:
        if (((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        trimToSize();
        trimToFileCount();
        journalWriter.close();
        journalWriter = null;
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Entry entry = (Entry)((Iterator) (obj)).next();
        if (entry.currentEditor != null)
        {
            entry.currentEditor.abort();
        }
          goto _L4
    }

    public void delete()
        throws IOException
    {
        close();
        Util.deleteContents(directory);
    }

    public Editor edit(String s)
        throws IOException
    {
        return edit(s, -1L);
    }

    public long fileCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = fileCount;
        long l = i;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void flush()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        checkNotClosed();
        trimToSize();
        trimToFileCount();
        journalWriter.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Snapshot get(String s)
        throws IOException
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (entry != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Snapshot) (obj));
_L2:
        obj = obj1;
        if (!entry.readable) goto _L4; else goto _L3
_L3:
        InputStream ainputstream[];
        obj = new File[valueCount];
        ainputstream = new InputStream[valueCount];
        int i = 0;
_L5:
        int j = valueCount;
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        redundantOpCount = redundantOpCount + 1;
        journalWriter.append((new StringBuilder("READ ")).append(s).append('\n').toString());
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        obj = new Snapshot(s, entry.sequenceNumber, ((File []) (obj)), ainputstream, entry.lengths, null);
          goto _L4
        s;
        throw s;
        File file = entry.getCleanFile(i);
        obj[i] = file;
        ainputstream[i] = new FileInputStream(file);
        i++;
          goto _L5
        s;
        i = 0;
_L8:
        obj = obj1;
        if (i >= valueCount) goto _L4; else goto _L6
_L6:
        obj = obj1;
        if (ainputstream[i] == null) goto _L4; else goto _L7
_L7:
        Util.closeQuietly(ainputstream[i]);
        i++;
          goto _L8
    }

    public File getDirectory()
    {
        return directory;
    }

    public int getMaxFileCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = maxFileCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public long getMaxSize()
    {
        this;
        JVM INSTR monitorenter ;
        long l = maxSize;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = journalWriter;
        boolean flag;
        if (writer == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean remove(String s)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (entry == null) goto _L2; else goto _L1
_L1:
        Editor editor = entry.currentEditor;
        if (editor == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        int i = 0;
_L5:
        if (i >= valueCount)
        {
            redundantOpCount = redundantOpCount + 1;
            journalWriter.append((new StringBuilder("REMOVE ")).append(s).append('\n').toString());
            lruEntries.remove(s);
            if (journalRebuildRequired())
            {
                executorService.submit(cleanupCallable);
            }
            break; /* Loop/switch isn't completed */
        }
        File file = entry.getCleanFile(i);
        if (file.exists() && !file.delete())
        {
            throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
        }
        break MISSING_BLOCK_LABEL_178;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        size = size - entry.lengths[i];
        fileCount = fileCount - 1;
        entry.lengths[i] = 0L;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setMaxSize(long l)
    {
        this;
        JVM INSTR monitorenter ;
        maxSize = l;
        executorService.submit(cleanupCallable);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long size()
    {
        this;
        JVM INSTR monitorenter ;
        long l = size;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }













}
