// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package org.apache.http.message:
//            LineParser, ParserCursor, BasicRequestLine, BasicStatusLine, 
//            BufferedHeader

public class BasicLineParser
    implements LineParser
{

    public static final BasicLineParser DEFAULT = new BasicLineParser();
    public static final BasicLineParser INSTANCE = new BasicLineParser();
    protected final ProtocolVersion protocol;

    public BasicLineParser()
    {
        this(null);
    }

    public BasicLineParser(ProtocolVersion protocolversion)
    {
        if (protocolversion == null)
        {
            protocolversion = HttpVersion.HTTP_1_1;
        }
        protocol = protocolversion;
    }

    public static Header parseHeader(String s, LineParser lineparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        if (lineparser == null)
        {
            lineparser = INSTANCE;
        }
        return lineparser.parseHeader(chararraybuffer);
    }

    public static ProtocolVersion parseProtocolVersion(String s, LineParser lineparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (lineparser == null)
        {
            lineparser = INSTANCE;
        }
        return lineparser.parseProtocolVersion(chararraybuffer, s);
    }

    public static RequestLine parseRequestLine(String s, LineParser lineparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (lineparser == null)
        {
            lineparser = INSTANCE;
        }
        return lineparser.parseRequestLine(chararraybuffer, s);
    }

    public static StatusLine parseStatusLine(String s, LineParser lineparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (lineparser == null)
        {
            lineparser = INSTANCE;
        }
        return lineparser.parseStatusLine(chararraybuffer, s);
    }

    protected ProtocolVersion createProtocolVersion(int i, int j)
    {
        return protocol.forVersion(i, j);
    }

    protected RequestLine createRequestLine(String s, String s1, ProtocolVersion protocolversion)
    {
        return new BasicRequestLine(s, s1, protocolversion);
    }

    protected StatusLine createStatusLine(ProtocolVersion protocolversion, int i, String s)
    {
        return new BasicStatusLine(protocolversion, i, s);
    }

    public boolean hasProtocolVersion(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
    {
        int j;
        int k;
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        j = parsercursor.getPos();
        parsercursor = protocol.getProtocol();
        k = parsercursor.length();
        if (chararraybuffer.length() >= k + 4) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (j >= 0) goto _L4; else goto _L3
_L3:
        int i = chararraybuffer.length() - 4 - k;
_L6:
        boolean flag;
        if (i + k + 4 <= chararraybuffer.length())
        {
            flag = true;
            j = 0;
            while (flag && j < k) 
            {
                if (chararraybuffer.charAt(i + j) == parsercursor.charAt(j))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j++;
            }
            break MISSING_BLOCK_LABEL_172;
        }
        if (true) goto _L1; else goto _L4
_L4:
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        i = j;
        if (j >= chararraybuffer.length()) goto _L6; else goto _L7
_L7:
        i = j;
        if (!HTTP.isWhitespace(chararraybuffer.charAt(j))) goto _L6; else goto _L8
_L8:
        j++;
          goto _L5
        boolean flag1 = flag;
        if (flag)
        {
            if (chararraybuffer.charAt(i + k) == '/')
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        return flag1;
    }

    public Header parseHeader(CharArrayBuffer chararraybuffer)
        throws ParseException
    {
        return new BufferedHeader(chararraybuffer);
    }

    public ProtocolVersion parseProtocolVersion(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException
    {
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        String s = protocol.getProtocol();
        int i1 = s.length();
        int l = parsercursor.getPos();
        int k = parsercursor.getUpperBound();
        skipWhitespace(chararraybuffer, parsercursor);
        int j1 = parsercursor.getPos();
        if (j1 + i1 + 4 > k)
        {
            throw new ParseException((new StringBuilder()).append("Not a valid protocol version: ").append(chararraybuffer.substring(l, k)).toString());
        }
        boolean flag = true;
        int j = 0;
        while (flag && j < i1) 
        {
            if (chararraybuffer.charAt(j1 + j) == s.charAt(j))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j++;
        }
        boolean flag1 = flag;
        if (flag)
        {
            if (chararraybuffer.charAt(j1 + i1) == '/')
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (!flag1)
        {
            throw new ParseException((new StringBuilder()).append("Not a valid protocol version: ").append(chararraybuffer.substring(l, k)).toString());
        }
        flag1 = j1 + (i1 + 1);
        int i = chararraybuffer.indexOf(46, flag1, k);
        if (i == -1)
        {
            throw new ParseException((new StringBuilder()).append("Invalid protocol version number: ").append(chararraybuffer.substring(l, k)).toString());
        }
        try
        {
            i1 = Integer.parseInt(chararraybuffer.substringTrimmed(flag1, i));
        }
        // Misplaced declaration of an exception variable
        catch (ParserCursor parsercursor)
        {
            throw new ParseException((new StringBuilder()).append("Invalid protocol major version number: ").append(chararraybuffer.substring(l, k)).toString());
        }
        j1 = i + 1;
        flag1 = chararraybuffer.indexOf(32, j1, k);
        i = ((flag1) ? 1 : 0);
        if (flag1 == -1)
        {
            i = k;
        }
        try
        {
            flag1 = Integer.parseInt(chararraybuffer.substringTrimmed(j1, i));
        }
        // Misplaced declaration of an exception variable
        catch (ParserCursor parsercursor)
        {
            throw new ParseException((new StringBuilder()).append("Invalid protocol minor version number: ").append(chararraybuffer.substring(l, k)).toString());
        }
        parsercursor.updatePos(i);
        return createProtocolVersion(i1, flag1);
    }

    public RequestLine parseRequestLine(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException
    {
        int i;
        int j;
        int k;
        int l;
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        i = parsercursor.getPos();
        j = parsercursor.getUpperBound();
        try
        {
            skipWhitespace(chararraybuffer, parsercursor);
            k = parsercursor.getPos();
            l = chararraybuffer.indexOf(32, k, j);
        }
        // Misplaced declaration of an exception variable
        catch (ParserCursor parsercursor)
        {
            throw new ParseException((new StringBuilder()).append("Invalid request line: ").append(chararraybuffer.substring(i, j)).toString());
        }
        if (l >= 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        throw new ParseException((new StringBuilder()).append("Invalid request line: ").append(chararraybuffer.substring(i, j)).toString());
        String s;
        s = chararraybuffer.substringTrimmed(k, l);
        parsercursor.updatePos(l);
        skipWhitespace(chararraybuffer, parsercursor);
        k = parsercursor.getPos();
        l = chararraybuffer.indexOf(32, k, j);
        if (l >= 0)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        throw new ParseException((new StringBuilder()).append("Invalid request line: ").append(chararraybuffer.substring(i, j)).toString());
        String s1 = chararraybuffer.substringTrimmed(k, l);
        parsercursor.updatePos(l);
        ProtocolVersion protocolversion = parseProtocolVersion(chararraybuffer, parsercursor);
        skipWhitespace(chararraybuffer, parsercursor);
        if (!parsercursor.atEnd())
        {
            throw new ParseException((new StringBuilder()).append("Invalid request line: ").append(chararraybuffer.substring(i, j)).toString());
        }
        parsercursor = createRequestLine(s, s1, protocolversion);
        return parsercursor;
    }

    public StatusLine parseStatusLine(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
        throws ParseException
    {
        ProtocolVersion protocolversion;
        int i;
        int j;
        int k;
        int l;
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        l = parsercursor.getPos();
        k = parsercursor.getUpperBound();
        int i1;
        try
        {
            protocolversion = parseProtocolVersion(chararraybuffer, parsercursor);
            skipWhitespace(chararraybuffer, parsercursor);
            i1 = parsercursor.getPos();
            j = chararraybuffer.indexOf(32, i1, k);
        }
        // Misplaced declaration of an exception variable
        catch (ParserCursor parsercursor)
        {
            throw new ParseException((new StringBuilder()).append("Invalid status line: ").append(chararraybuffer.substring(l, k)).toString());
        }
        i = j;
        if (j < 0)
        {
            i = k;
        }
        parsercursor = chararraybuffer.substringTrimmed(i1, i);
        j = 0;
_L2:
        if (j >= parsercursor.length())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!Character.isDigit(parsercursor.charAt(j)))
        {
            throw new ParseException((new StringBuilder()).append("Status line contains invalid status code: ").append(chararraybuffer.substring(l, k)).toString());
        }
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        j = Integer.parseInt(parsercursor);
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        parsercursor = chararraybuffer.substringTrimmed(i, k);
_L3:
        return createStatusLine(protocolversion, j, parsercursor);
        parsercursor;
        throw new ParseException((new StringBuilder()).append("Status line contains invalid status code: ").append(chararraybuffer.substring(l, k)).toString());
        parsercursor = "";
          goto _L3
    }

    protected void skipWhitespace(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
    {
        int i = parsercursor.getPos();
        for (int j = parsercursor.getUpperBound(); i < j && HTTP.isWhitespace(chararraybuffer.charAt(i)); i++) { }
        parsercursor.updatePos(i);
    }

}
