// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.crashlytics.android.core:
//            ByteString, CodedOutputStream, LogFileManager

class SessionProtobufHelper
{

    private static final String SIGNAL_DEFAULT = "0";
    private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8("0");
    private static final ByteString UNITY_PLATFORM_BYTE_STRING = ByteString.copyFromUtf8("Unity");

    private SessionProtobufHelper()
    {
    }

    private static int getBinaryImageSize(ByteString bytestring, ByteString bytestring1)
    {
        int j = 0 + CodedOutputStream.computeUInt64Size(1, 0L) + CodedOutputStream.computeUInt64Size(2, 0L) + CodedOutputStream.computeBytesSize(3, bytestring);
        int i = j;
        if (bytestring1 != null)
        {
            i = j + CodedOutputStream.computeBytesSize(4, bytestring1);
        }
        return i;
    }

    private static int getDeviceIdentifierSize(io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType deviceidentifiertype, String s)
    {
        return CodedOutputStream.computeEnumSize(1, deviceidentifiertype.protobufIndex) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
    }

    private static int getEventAppCustomAttributeSize(String s, String s1)
    {
        int i = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(s));
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        return i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
    }

    private static int getEventAppExecutionExceptionSize(Throwable throwable, int i, int j)
    {
        int k;
label0:
        {
            int l = 0 + CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(throwable.getClass().getName()));
            String s = throwable.getLocalizedMessage();
            k = l;
            if (s != null)
            {
                k = l + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(s));
            }
            StackTraceElement astacktraceelement[] = throwable.getStackTrace();
            int i1 = astacktraceelement.length;
            for (l = 0; l < i1; l++)
            {
                int j1 = getFrameSize(astacktraceelement[l], true);
                k += CodedOutputStream.computeTagSize(4) + CodedOutputStream.computeRawVarint32Size(j1) + j1;
            }

            throwable = throwable.getCause();
            l = k;
            if (throwable != null)
            {
                if (i >= j)
                {
                    break label0;
                }
                i = getEventAppExecutionExceptionSize(throwable, i + 1, j);
                l = k + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(i) + i);
            }
            return l;
        }
        for (i = 0; throwable != null; i++)
        {
            throwable = throwable.getCause();
        }

        return k + CodedOutputStream.computeUInt32Size(7, i);
    }

    private static int getEventAppExecutionSignalSize()
    {
        return 0 + CodedOutputStream.computeBytesSize(1, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeBytesSize(2, SIGNAL_DEFAULT_BYTE_STRING) + CodedOutputStream.computeUInt64Size(3, 0L);
    }

    private static int getEventAppExecutionSize(Throwable throwable, Thread thread, StackTraceElement astacktraceelement[], Thread athread[], List list, int i, ByteString bytestring, ByteString bytestring1)
    {
        int j = getThreadSize(thread, astacktraceelement, 4, true);
        j = 0 + (CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(j) + j);
        int i1 = athread.length;
        for (int k = 0; k < i1; k++)
        {
            int j1 = getThreadSize(athread[k], (StackTraceElement[])list.get(k), 0, false);
            j += CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(j1) + j1;
        }

        i = getEventAppExecutionExceptionSize(throwable, 1, i);
        int l = CodedOutputStream.computeTagSize(2);
        i1 = CodedOutputStream.computeRawVarint32Size(i);
        int k1 = getEventAppExecutionSignalSize();
        int l1 = CodedOutputStream.computeTagSize(3);
        int i2 = CodedOutputStream.computeRawVarint32Size(k1);
        int j2 = getBinaryImageSize(bytestring, bytestring1);
        return j + (l + i1 + i) + (l1 + i2 + k1) + (CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(j2) + j2);
    }

    private static int getEventAppSize(Throwable throwable, Thread thread, StackTraceElement astacktraceelement[], Thread athread[], List list, int i, ByteString bytestring, ByteString bytestring1, 
            Map map, android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo, int j)
    {
        i = getEventAppExecutionSize(throwable, thread, astacktraceelement, athread, list, i, bytestring, bytestring1);
        int k = 0 + (CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(i) + i);
        i = k;
        if (map != null)
        {
            throwable = map.entrySet().iterator();
            do
            {
                i = k;
                if (!throwable.hasNext())
                {
                    break;
                }
                thread = (java.util.Map.Entry)throwable.next();
                i = getEventAppCustomAttributeSize((String)thread.getKey(), (String)thread.getValue());
                k += CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(i) + i;
            } while (true);
        }
        k = i;
        if (runningappprocessinfo != null)
        {
            boolean flag;
            if (runningappprocessinfo.importance != 100)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = i + CodedOutputStream.computeBoolSize(3, flag);
        }
        return k + CodedOutputStream.computeUInt32Size(4, j);
    }

    private static int getEventDeviceSize(float f, int i, boolean flag, int j, long l, long l1)
    {
        return 0 + CodedOutputStream.computeFloatSize(1, f) + CodedOutputStream.computeSInt32Size(2, i) + CodedOutputStream.computeBoolSize(3, flag) + CodedOutputStream.computeUInt32Size(4, j) + CodedOutputStream.computeUInt64Size(5, l) + CodedOutputStream.computeUInt64Size(6, l1);
    }

    private static int getEventLogSize(ByteString bytestring)
    {
        return CodedOutputStream.computeBytesSize(1, bytestring);
    }

    private static int getFrameSize(StackTraceElement stacktraceelement, boolean flag)
    {
        byte byte0 = 2;
        int i;
        int j;
        if (stacktraceelement.isNativeMethod())
        {
            i = 0 + CodedOutputStream.computeUInt64Size(1, Math.max(stacktraceelement.getLineNumber(), 0));
        } else
        {
            i = 0 + CodedOutputStream.computeUInt64Size(1, 0L);
        }
        j = i + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8((new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).toString()));
        i = j;
        if (stacktraceelement.getFileName() != null)
        {
            i = j + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(stacktraceelement.getFileName()));
        }
        j = i;
        if (!stacktraceelement.isNativeMethod())
        {
            j = i;
            if (stacktraceelement.getLineNumber() > 0)
            {
                j = i + CodedOutputStream.computeUInt64Size(4, stacktraceelement.getLineNumber());
            }
        }
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        return j + CodedOutputStream.computeUInt32Size(5, i);
    }

    private static int getSessionAppOrgSize(ByteString bytestring)
    {
        return 0 + CodedOutputStream.computeBytesSize(1, bytestring);
    }

    private static int getSessionAppSize(ByteString bytestring, ByteString bytestring1, ByteString bytestring2, ByteString bytestring3, ByteString bytestring4, int i, ByteString bytestring5)
    {
        int j = CodedOutputStream.computeBytesSize(1, bytestring);
        int k = CodedOutputStream.computeBytesSize(2, bytestring2);
        int l = CodedOutputStream.computeBytesSize(3, bytestring3);
        int i1 = getSessionAppOrgSize(bytestring1);
        k = 0 + j + k + l + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(i1) + i1) + CodedOutputStream.computeBytesSize(6, bytestring4);
        j = k;
        if (bytestring5 != null)
        {
            j = k + CodedOutputStream.computeBytesSize(8, UNITY_PLATFORM_BYTE_STRING) + CodedOutputStream.computeBytesSize(9, bytestring5);
        }
        return j + CodedOutputStream.computeEnumSize(10, i);
    }

    private static int getSessionDeviceSize(int i, ByteString bytestring, ByteString bytestring1, int j, long l, long l1, 
            boolean flag, Map map, int k, ByteString bytestring2, ByteString bytestring3)
    {
        int i1 = CodedOutputStream.computeBytesSize(1, bytestring);
        int j1 = CodedOutputStream.computeEnumSize(3, i);
        if (bytestring1 == null)
        {
            i = 0;
        } else
        {
            i = CodedOutputStream.computeBytesSize(4, bytestring1);
        }
        i = 0 + i1 + j1 + i + CodedOutputStream.computeUInt32Size(5, j) + CodedOutputStream.computeUInt64Size(6, l) + CodedOutputStream.computeUInt64Size(7, l1) + CodedOutputStream.computeBoolSize(10, flag);
        j = i;
        if (map != null)
        {
            bytestring = map.entrySet().iterator();
            do
            {
                j = i;
                if (!bytestring.hasNext())
                {
                    break;
                }
                bytestring1 = (java.util.Map.Entry)bytestring.next();
                j = getDeviceIdentifierSize((io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType)bytestring1.getKey(), (String)bytestring1.getValue());
                i += CodedOutputStream.computeTagSize(11) + CodedOutputStream.computeRawVarint32Size(j) + j;
            } while (true);
        }
        i1 = CodedOutputStream.computeUInt32Size(12, k);
        if (bytestring2 == null)
        {
            i = 0;
        } else
        {
            i = CodedOutputStream.computeBytesSize(13, bytestring2);
        }
        if (bytestring3 == null)
        {
            k = 0;
        } else
        {
            k = CodedOutputStream.computeBytesSize(14, bytestring3);
        }
        return j + i1 + i + k;
    }

    private static int getSessionEventSize(long l, String s, Throwable throwable, Thread thread, StackTraceElement astacktraceelement[], Thread athread[], List list, 
            int i, Map map, android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo, int j, ByteString bytestring, ByteString bytestring1, float f, 
            int k, boolean flag, long l1, long l2, ByteString bytestring2)
    {
        int i1 = CodedOutputStream.computeUInt64Size(1, l);
        int j1 = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(s));
        i = getEventAppSize(throwable, thread, astacktraceelement, athread, list, i, bytestring, bytestring1, map, runningappprocessinfo, j);
        int k1 = CodedOutputStream.computeTagSize(3);
        int i2 = CodedOutputStream.computeRawVarint32Size(i);
        j = getEventDeviceSize(f, k, flag, j, l1, l2);
        j = 0 + i1 + j1 + (k1 + i2 + i) + (CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(j) + j);
        i = j;
        if (bytestring2 != null)
        {
            i = getEventLogSize(bytestring2);
            i = j + (CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(i) + i);
        }
        return i;
    }

    private static int getSessionOSSize(ByteString bytestring, ByteString bytestring1, boolean flag)
    {
        return 0 + CodedOutputStream.computeEnumSize(1, 3) + CodedOutputStream.computeBytesSize(2, bytestring) + CodedOutputStream.computeBytesSize(3, bytestring1) + CodedOutputStream.computeBoolSize(4, flag);
    }

    private static int getThreadSize(Thread thread, StackTraceElement astacktraceelement[], int i, boolean flag)
    {
        int j = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(thread.getName())) + CodedOutputStream.computeUInt32Size(2, i);
        int k = astacktraceelement.length;
        for (i = 0; i < k; i++)
        {
            int l = getFrameSize(astacktraceelement[i], flag);
            j += CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(l) + l;
        }

        return j;
    }

    private static ByteString stringToByteString(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return ByteString.copyFromUtf8(s);
        }
    }

    public static void writeBeginSession(CodedOutputStream codedoutputstream, String s, String s1, long l)
        throws Exception
    {
        codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(s1));
        codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(s));
        codedoutputstream.writeUInt64(3, l);
    }

    private static void writeFrame(CodedOutputStream codedoutputstream, int i, StackTraceElement stacktraceelement, boolean flag)
        throws Exception
    {
        byte byte0 = 4;
        codedoutputstream.writeTag(i, 2);
        codedoutputstream.writeRawVarint32(getFrameSize(stacktraceelement, flag));
        if (stacktraceelement.isNativeMethod())
        {
            codedoutputstream.writeUInt64(1, Math.max(stacktraceelement.getLineNumber(), 0));
        } else
        {
            codedoutputstream.writeUInt64(1, 0L);
        }
        codedoutputstream.writeBytes(2, ByteString.copyFromUtf8((new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).toString()));
        if (stacktraceelement.getFileName() != null)
        {
            codedoutputstream.writeBytes(3, ByteString.copyFromUtf8(stacktraceelement.getFileName()));
        }
        if (!stacktraceelement.isNativeMethod() && stacktraceelement.getLineNumber() > 0)
        {
            codedoutputstream.writeUInt64(4, stacktraceelement.getLineNumber());
        }
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        codedoutputstream.writeUInt32(5, i);
    }

    public static void writeSessionApp(CodedOutputStream codedoutputstream, String s, String s1, String s2, String s3, String s4, int i, String s5)
        throws Exception
    {
        ByteString bytestring = ByteString.copyFromUtf8(s);
        s1 = ByteString.copyFromUtf8(s1);
        s2 = ByteString.copyFromUtf8(s2);
        s3 = ByteString.copyFromUtf8(s3);
        s4 = ByteString.copyFromUtf8(s4);
        if (s5 != null)
        {
            s = ByteString.copyFromUtf8(s5);
        } else
        {
            s = null;
        }
        codedoutputstream.writeTag(7, 2);
        codedoutputstream.writeRawVarint32(getSessionAppSize(bytestring, s1, s2, s3, s4, i, s));
        codedoutputstream.writeBytes(1, bytestring);
        codedoutputstream.writeBytes(2, s2);
        codedoutputstream.writeBytes(3, s3);
        codedoutputstream.writeTag(5, 2);
        codedoutputstream.writeRawVarint32(getSessionAppOrgSize(s1));
        codedoutputstream.writeBytes(1, s1);
        codedoutputstream.writeBytes(6, s4);
        if (s != null)
        {
            codedoutputstream.writeBytes(8, UNITY_PLATFORM_BYTE_STRING);
            codedoutputstream.writeBytes(9, s);
        }
        codedoutputstream.writeEnum(10, i);
    }

    public static void writeSessionDevice(CodedOutputStream codedoutputstream, String s, int i, String s1, int j, long l, long l1, boolean flag, Map map, int k, String s2, String s3)
        throws Exception
    {
        s = ByteString.copyFromUtf8(s);
        ByteString bytestring = stringToByteString(s1);
        s1 = stringToByteString(s3);
        s2 = stringToByteString(s2);
        codedoutputstream.writeTag(9, 2);
        codedoutputstream.writeRawVarint32(getSessionDeviceSize(i, s, bytestring, j, l, l1, flag, map, k, s2, s1));
        codedoutputstream.writeBytes(1, s);
        codedoutputstream.writeEnum(3, i);
        codedoutputstream.writeBytes(4, bytestring);
        codedoutputstream.writeUInt32(5, j);
        codedoutputstream.writeUInt64(6, l);
        codedoutputstream.writeUInt64(7, l1);
        codedoutputstream.writeBool(10, flag);
        for (s = map.entrySet().iterator(); s.hasNext(); codedoutputstream.writeBytes(2, ByteString.copyFromUtf8((String)map.getValue())))
        {
            map = (java.util.Map.Entry)s.next();
            codedoutputstream.writeTag(11, 2);
            codedoutputstream.writeRawVarint32(getDeviceIdentifierSize((io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType)map.getKey(), (String)map.getValue()));
            codedoutputstream.writeEnum(1, ((io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType)map.getKey()).protobufIndex);
        }

        codedoutputstream.writeUInt32(12, k);
        if (s2 != null)
        {
            codedoutputstream.writeBytes(13, s2);
        }
        if (s1 != null)
        {
            codedoutputstream.writeBytes(14, s1);
        }
    }

    public static void writeSessionEvent(CodedOutputStream codedoutputstream, long l, String s, Throwable throwable, Thread thread, StackTraceElement astacktraceelement[], Thread athread[], 
            List list, Map map, LogFileManager logfilemanager, android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo, int i, String s1, String s2, 
            float f, int j, boolean flag, long l1, long l2)
        throws Exception
    {
        ByteString bytestring = ByteString.copyFromUtf8(s1);
        if (s2 == null)
        {
            s1 = null;
        } else
        {
            s1 = ByteString.copyFromUtf8(s2.replace("-", ""));
        }
        s2 = logfilemanager.getByteStringForLog();
        if (s2 == null)
        {
            Fabric.getLogger().d("CrashlyticsCore", "No log data to include with this event.");
        }
        logfilemanager.clearLog();
        codedoutputstream.writeTag(10, 2);
        codedoutputstream.writeRawVarint32(getSessionEventSize(l, s, throwable, thread, astacktraceelement, athread, list, 8, map, runningappprocessinfo, i, bytestring, s1, f, j, flag, l1, l2, s2));
        codedoutputstream.writeUInt64(1, l);
        codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(s));
        writeSessionEventApp(codedoutputstream, throwable, thread, astacktraceelement, athread, list, 8, bytestring, s1, map, runningappprocessinfo, i);
        writeSessionEventDevice(codedoutputstream, f, j, flag, i, l1, l2);
        writeSessionEventLog(codedoutputstream, s2);
    }

    private static void writeSessionEventApp(CodedOutputStream codedoutputstream, Throwable throwable, Thread thread, StackTraceElement astacktraceelement[], Thread athread[], List list, int i, ByteString bytestring, 
            ByteString bytestring1, Map map, android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo, int j)
        throws Exception
    {
        codedoutputstream.writeTag(3, 2);
        codedoutputstream.writeRawVarint32(getEventAppSize(throwable, thread, astacktraceelement, athread, list, i, bytestring, bytestring1, map, runningappprocessinfo, j));
        writeSessionEventAppExecution(codedoutputstream, throwable, thread, astacktraceelement, athread, list, i, bytestring, bytestring1);
        if (map != null && !map.isEmpty())
        {
            writeSessionEventAppCustomAttributes(codedoutputstream, map);
        }
        if (runningappprocessinfo != null)
        {
            boolean flag;
            if (runningappprocessinfo.importance != 100)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            codedoutputstream.writeBool(3, flag);
        }
        codedoutputstream.writeUInt32(4, j);
    }

    private static void writeSessionEventAppCustomAttributes(CodedOutputStream codedoutputstream, Map map)
        throws Exception
    {
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); codedoutputstream.writeBytes(2, ByteString.copyFromUtf8(map)))
        {
            map = (java.util.Map.Entry)iterator.next();
            codedoutputstream.writeTag(2, 2);
            codedoutputstream.writeRawVarint32(getEventAppCustomAttributeSize((String)map.getKey(), (String)map.getValue()));
            codedoutputstream.writeBytes(1, ByteString.copyFromUtf8((String)map.getKey()));
            String s = (String)map.getValue();
            map = s;
            if (s == null)
            {
                map = "";
            }
        }

    }

    private static void writeSessionEventAppExecution(CodedOutputStream codedoutputstream, Throwable throwable, Thread thread, StackTraceElement astacktraceelement[], Thread athread[], List list, int i, ByteString bytestring, 
            ByteString bytestring1)
        throws Exception
    {
        codedoutputstream.writeTag(1, 2);
        codedoutputstream.writeRawVarint32(getEventAppExecutionSize(throwable, thread, astacktraceelement, athread, list, i, bytestring, bytestring1));
        writeThread(codedoutputstream, thread, astacktraceelement, 4, true);
        int k = athread.length;
        for (int j = 0; j < k; j++)
        {
            writeThread(codedoutputstream, athread[j], (StackTraceElement[])list.get(j), 0, false);
        }

        writeSessionEventAppExecutionException(codedoutputstream, throwable, 1, i, 2);
        codedoutputstream.writeTag(3, 2);
        codedoutputstream.writeRawVarint32(getEventAppExecutionSignalSize());
        codedoutputstream.writeBytes(1, SIGNAL_DEFAULT_BYTE_STRING);
        codedoutputstream.writeBytes(2, SIGNAL_DEFAULT_BYTE_STRING);
        codedoutputstream.writeUInt64(3, 0L);
        codedoutputstream.writeTag(4, 2);
        codedoutputstream.writeRawVarint32(getBinaryImageSize(bytestring, bytestring1));
        codedoutputstream.writeUInt64(1, 0L);
        codedoutputstream.writeUInt64(2, 0L);
        codedoutputstream.writeBytes(3, bytestring);
        if (bytestring1 != null)
        {
            codedoutputstream.writeBytes(4, bytestring1);
        }
    }

    private static void writeSessionEventAppExecutionException(CodedOutputStream codedoutputstream, Throwable throwable, int i, int j, int k)
        throws Exception
    {
label0:
        {
            codedoutputstream.writeTag(k, 2);
            codedoutputstream.writeRawVarint32(getEventAppExecutionExceptionSize(throwable, 1, j));
            codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(throwable.getClass().getName()));
            String s = throwable.getLocalizedMessage();
            if (s != null)
            {
                codedoutputstream.writeBytes(3, ByteString.copyFromUtf8(s));
            }
            StackTraceElement astacktraceelement[] = throwable.getStackTrace();
            int l = astacktraceelement.length;
            for (k = 0; k < l; k++)
            {
                writeFrame(codedoutputstream, 4, astacktraceelement[k], true);
            }

            throwable = throwable.getCause();
            if (throwable != null)
            {
                if (i >= j)
                {
                    break label0;
                }
                writeSessionEventAppExecutionException(codedoutputstream, throwable, i + 1, j, 6);
            }
            return;
        }
        for (i = 0; throwable != null; i++)
        {
            throwable = throwable.getCause();
        }

        codedoutputstream.writeUInt32(7, i);
    }

    private static void writeSessionEventDevice(CodedOutputStream codedoutputstream, float f, int i, boolean flag, int j, long l, long l1)
        throws Exception
    {
        codedoutputstream.writeTag(5, 2);
        codedoutputstream.writeRawVarint32(getEventDeviceSize(f, i, flag, j, l, l1));
        codedoutputstream.writeFloat(1, f);
        codedoutputstream.writeSInt32(2, i);
        codedoutputstream.writeBool(3, flag);
        codedoutputstream.writeUInt32(4, j);
        codedoutputstream.writeUInt64(5, l);
        codedoutputstream.writeUInt64(6, l1);
    }

    private static void writeSessionEventLog(CodedOutputStream codedoutputstream, ByteString bytestring)
        throws Exception
    {
        if (bytestring != null)
        {
            codedoutputstream.writeTag(6, 2);
            codedoutputstream.writeRawVarint32(getEventLogSize(bytestring));
            codedoutputstream.writeBytes(1, bytestring);
        }
    }

    public static void writeSessionOS(CodedOutputStream codedoutputstream, boolean flag)
        throws Exception
    {
        ByteString bytestring = ByteString.copyFromUtf8(android.os.Build.VERSION.RELEASE);
        ByteString bytestring1 = ByteString.copyFromUtf8(android.os.Build.VERSION.CODENAME);
        codedoutputstream.writeTag(8, 2);
        codedoutputstream.writeRawVarint32(getSessionOSSize(bytestring, bytestring1, flag));
        codedoutputstream.writeEnum(1, 3);
        codedoutputstream.writeBytes(2, bytestring);
        codedoutputstream.writeBytes(3, bytestring1);
        codedoutputstream.writeBool(4, flag);
    }

    public static void writeSessionUser(CodedOutputStream codedoutputstream, String s, String s1, String s2)
        throws Exception
    {
        Object obj = s;
        if (s == null)
        {
            obj = "";
        }
        s = ByteString.copyFromUtf8(((String) (obj)));
        obj = stringToByteString(s1);
        ByteString bytestring = stringToByteString(s2);
        int j = 0 + CodedOutputStream.computeBytesSize(1, s);
        int i = j;
        if (s1 != null)
        {
            i = j + CodedOutputStream.computeBytesSize(2, ((ByteString) (obj)));
        }
        j = i;
        if (s2 != null)
        {
            j = i + CodedOutputStream.computeBytesSize(3, bytestring);
        }
        codedoutputstream.writeTag(6, 2);
        codedoutputstream.writeRawVarint32(j);
        codedoutputstream.writeBytes(1, s);
        if (s1 != null)
        {
            codedoutputstream.writeBytes(2, ((ByteString) (obj)));
        }
        if (s2 != null)
        {
            codedoutputstream.writeBytes(3, bytestring);
        }
    }

    private static void writeThread(CodedOutputStream codedoutputstream, Thread thread, StackTraceElement astacktraceelement[], int i, boolean flag)
        throws Exception
    {
        codedoutputstream.writeTag(1, 2);
        codedoutputstream.writeRawVarint32(getThreadSize(thread, astacktraceelement, i, flag));
        codedoutputstream.writeBytes(1, ByteString.copyFromUtf8(thread.getName()));
        codedoutputstream.writeUInt32(2, i);
        int j = astacktraceelement.length;
        for (i = 0; i < j; i++)
        {
            writeFrame(codedoutputstream, 3, astacktraceelement[i], flag);
        }

    }

}
