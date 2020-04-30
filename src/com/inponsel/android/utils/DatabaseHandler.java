// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;

// Referenced classes of package com.inponsel.android.utils:
//            RestClient, EncodeDecodeAES, Log

public class DatabaseHandler extends SQLiteOpenHelper
{

    public static final String ARTANYA_ID = "id_content";
    public static final String ARTANYA_ID_HP = "id_hp";
    public static final String ARTANYA_TAG = "tag";
    public static final String ARTANYA_TYPE = "type";
    public static final String ARTANYA_codename = "codename";
    public static final String ARTANYA_content = "content";
    public static final String ARTANYA_date = "date";
    public static final String ARTANYA_ext = "ext";
    public static final String ARTANYA_image = "image";
    public static final String ARTANYA_judul = "title";
    public static final String ARTANYA_merk = "merk";
    public static final String ARTANYA_model = "model";
    public static final String ARTUSER_ID = "id_hp";
    public static final String ARTUSER_TAG = "tag";
    public static final String ARTUSER_TYPE = "type";
    public static final String ARTUSER_codename = "codename";
    public static final String ARTUSER_date = "date";
    public static final String ARTUSER_ext = "ext";
    public static final String ARTUSER_image = "image";
    public static final String ARTUSER_isi = "content";
    public static final String ARTUSER_judul = "title";
    public static final String BOX_ID = "id_msg";
    public static final String BOX_from_name = "from_name";
    public static final String BOX_from_photo = "from_photo";
    public static final String BOX_id_from = "id_from";
    public static final String BOX_id_to = "id_to";
    public static final String BOX_last_message = "last_message";
    public static final String BOX_last_seen = "last_seen";
    public static final String BOX_message_me = "message_me";
    public static final String BOX_message_type = "message_type";
    public static final String BOX_post_date = "post_date";
    public static final String BOX_to_name = "to_name";
    public static final String BOX_to_photo = "to_photo";
    public static final String BOX_unread = "unread_msg";
    private static final String DATABASE_NAME = "inponsel_user.db";
    public static final int DATABASE_VERSION = 26;
    public static final String GC_ID = "id_hp";
    public static final String GC_MSG_ID = "id_msg";
    public static final String GC_MSG_ext = "ext";
    public static final String GC_MSG_from_name = "from_name";
    public static final String GC_MSG_from_photo = "from_photo";
    public static final String GC_MSG_id_from = "id_from";
    public static final String GC_MSG_id_to = "id_to";
    public static final String GC_MSG_img_height = "img_height";
    public static final String GC_MSG_img_width = "img_width";
    public static final String GC_MSG_message = "message";
    public static final String GC_MSG_message_me = "message_me";
    public static final String GC_MSG_message_type = "message_type";
    public static final String GC_MSG_post_date = "post_date";
    public static final String GC_MSG_to_name = "to_name";
    public static final String GC_MSG_to_photo = "to_photo";
    public static final String GC_codename = "codename";
    public static final String GC_from_name = "from_name";
    public static final String GC_last_message = "last_message";
    public static final String GC_merk = "merk";
    public static final String GC_message_me = "message_me";
    public static final String GC_message_type = "message_type";
    public static final String GC_model = "model";
    public static final String GC_photo = "hp_photo";
    public static final String GC_post_date = "post_date";
    public static final String GC_unread = "unread_msg";
    public static final String KEY_AVATAR_RSS = "rss_avatar";
    public static final String KEY_AVATAR_TW = "tw_avatar";
    public static final String KEY_CODENAME_HP = "hp_codename";
    public static final String KEY_CODEPONSEL_1 = "codename_1";
    public static final String KEY_CODEPONSEL_2 = "codename_2";
    public static final String KEY_DESC_RSS = "rss_desc";
    public static final String KEY_EMAIL = "user_email";
    public static final String KEY_EMAIL_NOTIF = "user_email_notif";
    public static final String KEY_HUB_CONTENT = "content_hub";
    public static final String KEY_HUB_JUDUL = "title_hub";
    public static final String KEY_HUB_KATHP = "kathp_hub";
    public static final String KEY_HUB_KATOP = "katop_hub";
    public static final String KEY_HUB_KATOS = "katos_hub";
    public static final String KEY_HUB_KATUM = "katum_hub";
    public static final String KEY_HUB_PICTURE = "img_hub";
    public static final String KEY_ID = "id";
    public static final String KEY_ID_HP = "hp_id";
    public static final String KEY_ID_RSS = "rss_id";
    public static final String KEY_ID_TW = "tw_id";
    public static final String KEY_ID_USER = "user_id";
    public static final String KEY_JEKEL = "user_jekel";
    public static final String KEY_JOIN = "user_join_date";
    public static final String KEY_KECAMATAN = "user_kecamatan";
    public static final String KEY_KOMEN_NOTIF = "user_komen_notif";
    public static final String KEY_KOMEN_NOTIF_PUSH = "user_komen_notif_push";
    public static final String KEY_KONTEN_RSS = "rss_content";
    public static final String KEY_KONTEN_TW = "tw_content";
    public static final String KEY_KOTA = "user_kota";
    public static final String KEY_LIKE_NOTIF = "user_like_notif";
    public static final String KEY_LIKE_NOTIF_PUSH = "user_like_notif_push";
    public static final String KEY_MEDIA_RSS = "rss_media";
    public static final String KEY_MEDIA_TW = "tw_media";
    public static final String KEY_MERK_HP = "hp_merk";
    public static final String KEY_MODEL_HP = "hp_model";
    public static final String KEY_MYSTAT_RSS = "rss_mystat";
    public static final String KEY_MYSTAT_TW = "tw_mystat";
    public static final String KEY_NAME = "user_nama_asli";
    public static final String KEY_OPERATOR_1 = "user_operator_1";
    public static final String KEY_OPERATOR_2 = "user_operator_2";
    public static final String KEY_PHOTO = "user_photo";
    public static final String KEY_PHOTO_HP = "hp_photo";
    public static final String KEY_PONSEL_1 = "user_ponsel_1";
    public static final String KEY_PONSEL_2 = "user_ponsel_2";
    public static final String KEY_PROFILE_UPDATE = "user_modified_date";
    public static final String KEY_PROVINSI = "user_provinsi";
    public static final String KEY_PUSH_NOTIF = "user_push_notif";
    public static final String KEY_SRCLINK_RSS = "rss_srclink";
    public static final String KEY_TANGGAP_NOTIF = "user_tanggap_notif";
    public static final String KEY_TANGGAP_NOTIF_PUSH = "user_tanggap_notif_push";
    public static final String KEY_TIME_RSS = "rss_time";
    public static final String KEY_TIME_TW = "tw_time";
    public static final String KEY_TITLE_RSS = "rss_title";
    public static final String KEY_TOTKOM_RSS = "rss_totkom";
    public static final String KEY_TOTKOM_TW = "tw_totkom";
    public static final String KEY_TOTLIKE_RSS = "rss_totlike";
    public static final String KEY_TOTLIKE_TW = "tw_totlike";
    public static final String KEY_TTL = "user_ttl";
    public static final String KEY_USER_AVATAR = "AVATAR";
    public static final String KEY_USER_CODENAME1 = "CODENAME1";
    public static final String KEY_USER_CODENAME2 = "CODENAME2";
    public static final String KEY_USER_HARGAHP1 = "HARGAHP1";
    public static final String KEY_USER_HARGAHP2 = "HARGAHP2";
    public static final String KEY_USER_ID = "USER_ID";
    public static final String KEY_USER_IDHP1 = "IDHP1";
    public static final String KEY_USER_IDHP2 = "IDHP2";
    public static final String KEY_USER_JEKEL = "JEKEL";
    public static final String KEY_USER_JOIN = "JOIN_DATE";
    public static final String KEY_USER_KOTA = "KOTA";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_NAMEHP1 = "NAMEHP1";
    public static final String KEY_USER_NAMEHP2 = "NAMEHP2";
    public static final String KEY_USER_NMLENGKAP = "NAME";
    public static final String KEY_USER_PICHP1 = "PICHP1";
    public static final String KEY_USER_PICHP2 = "PICHP2";
    public static final String KEY_USER_PROV = "PROV";
    public static final String KEY_USER_RSS = "rss_uname";
    public static final String KEY_USER_SIM1 = "SIM1";
    public static final String KEY_USER_SIM2 = "SIM2";
    public static final String KEY_USER_TOTDISLIKE = "TOTDISLIKE";
    public static final String KEY_USER_TOTLIKE = "TOTLIKE";
    public static final String KEY_USER_TOTPOST = "TOTPOST";
    public static final String KEY_USER_TW = "tw_uname";
    public static final String KEY_USER_UNAME = "UNAME";
    public static final String MSG_ID = "id_msg";
    public static final String MSG_ext = "ext";
    public static final String MSG_from_name = "from_name";
    public static final String MSG_from_photo = "from_photo";
    public static final String MSG_id_from = "id_from";
    public static final String MSG_id_to = "id_to";
    public static final String MSG_img_height = "img_height";
    public static final String MSG_img_width = "img_width";
    public static final String MSG_message = "message";
    public static final String MSG_message_me = "message_me";
    public static final String MSG_message_type = "message_type";
    public static final String MSG_post_date = "post_date";
    public static final String MSG_to_name = "to_name";
    public static final String MSG_to_photo = "to_photo";
    public static final String TABLE_FAVHP = "user_hp_bookmark";
    public static final String TABLE_GC_MSG = "gc_msg";
    public static final String TABLE_GROUPCHAT = "groupchat_msg";
    public static final String TABLE_INBOX = "inbox_msg";
    public static final String TABLE_KIRIM_ARTIKEL = "draft_timeline";
    public static final String TABLE_MSG = "private_msg";
    public static final String TABLE_RSS = "user_rss_fav";
    public static final String TABLE_SAVE_HUB = "hub_post_draft";
    public static final String TABLE_SQLSEQ = "sql_sequence";
    public static final String TABLE_TIMELINE_FAV = "timeline_fav";
    public static final String TABLE_TWEET = "user_tw_fav";
    public static final String TABLE_USERPROF = "user_profile";
    public static final String TABLE_VIEW_USER = "view_user";
    String CREATE_ARTANYA_TABLE;
    String CREATE_ARTUSER_TABLE;
    String CREATE_BOX_TABLE;
    String CREATE_GC_MSG_TABLE;
    String CREATE_GROUPCHAT;
    String CREATE_HP_TABLE;
    String CREATE_HUBDRAFT_TABLE;
    String CREATE_MSG_TABLE;
    String CREATE_PROFILE_TABLE;
    String CREATE_RSS_TABLE;
    String CREATE_SQLSEQ_TABLE;
    String CREATE_TW_TABLE;
    String CREATE_VIEWUSER_TABLE;
    String KEY_USER_ME;

    public DatabaseHandler(Context context)
    {
        super(context, "inponsel_user.db", null, 26);
        CREATE_PROFILE_TABLE = "create table user_profile(id integer primary key, user_id text,user_nama_asli text, user_photo text, user_name text, user_email text , user_ttl text, user_provinsi text, user_kota text, user_jekel text, user_ponsel_1 text, user_ponsel_2 text, user_operator_1 text, user_operator_2 text, user_join_date text, user_modified_date text, user_email_notif text , user_push_notif text , user_komen_notif text , user_like_notif text , user_tanggap_notif text, user_komen_notif_push text , user_like_notif_push text , user_tanggap_notif_push text, codename_1 text , codename_2 text,user_kecamatan text)";
        CREATE_HP_TABLE = "create table user_hp_bookmark(id integer primary key, hp_id text,hp_merk text, hp_model text, hp_photo text,hp_codename text)";
        CREATE_SQLSEQ_TABLE = "create table sql_sequence(unread_msg text)";
        CREATE_TW_TABLE = "create table user_tw_fav(id integer primary key, tw_id text,tw_uname text, tw_avatar text,tw_content text, tw_media text, tw_time text,tw_totlike text,tw_totkom text,tw_mystat text)";
        CREATE_RSS_TABLE = "create table user_rss_fav(id integer primary key, rss_id text,rss_uname text, rss_avatar text,rss_title text, rss_desc text, rss_content text, rss_media text, rss_srclink text, rss_time text,rss_totlike text,rss_totkom text,rss_mystat text)";
        CREATE_HUBDRAFT_TABLE = "create table hub_post_draft(id integer primary key, title_hub text,content_hub text, img_hub text, katum_hub text,katos_hub text,katop_hub text,kathp_hub text)";
        KEY_USER_ME = "ME";
        CREATE_VIEWUSER_TABLE = (new StringBuilder("create table view_user(id integer primary key, USER_ID text,NAME text, AVATAR text, UNAME text,PROV text,KOTA text,JEKEL text,IDHP1 text,IDHP2 text,NAMEHP1 text,NAMEHP2 text,HARGAHP1 text,HARGAHP2 text,PICHP1 text,PICHP2 text,SIM1 text,SIM2 text,TOTPOST text,TOTLIKE text,TOTDISLIKE text,")).append(KEY_USER_ME).append(" text,").append("JOIN_DATE").append(" text,").append("CODENAME1").append(" text,").append("CODENAME2").append(" text").append(")").toString();
        CREATE_MSG_TABLE = "create table private_msg(id integer primary key, id_msg integer,id_from text, from_name text, from_photo text,id_to text,to_name text,to_photo text,message text,ext text,message_type text,message_me text,post_date text, img_width text,img_height text)";
        CREATE_GC_MSG_TABLE = "create table gc_msg(id integer primary key, id_msg integer,id_from text, from_name text, from_photo text,id_to text,to_name text,to_photo text,message text,ext text,message_type text,message_me text,post_date text, img_width text,img_height text)";
        CREATE_BOX_TABLE = "create table inbox_msg(id integer primary key, id_msg text,id_from text, from_name text, from_photo text,id_to text,to_name text,to_photo text,last_message text,message_type text,last_seen text,unread_msg text,message_me text,post_date text )";
        CREATE_GROUPCHAT = "create table groupchat_msg(id integer primary key, id_hp text,merk text,model text,codename text,hp_photo text,from_name text, last_message text,message_type text,unread_msg text,message_me text,post_date text )";
        CREATE_ARTUSER_TABLE = "create table draft_timeline(id integer primary key, id_hp text,codename text,type text,title text, tag text, image text, content text,ext text,date text)";
        CREATE_ARTANYA_TABLE = "create table timeline_fav(id integer primary key, id_content text,id_hp text,merk text,model text,codename text,title text, type text, tag text, image text, content text,ext text,date text)";
    }

    public void addArtTanya(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id_content", s);
        contentvalues.put("id_hp", s1);
        contentvalues.put("merk", s2);
        contentvalues.put("model", s3);
        contentvalues.put("codename", s4);
        contentvalues.put("title", s5);
        contentvalues.put("type", s6);
        contentvalues.put("tag", s7);
        contentvalues.put("image", s8);
        contentvalues.put("content", s9);
        contentvalues.put("ext", s10);
        contentvalues.put("date", s11);
        sqlitedatabase.insertWithOnConflict("timeline_fav", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addArtUser(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id_hp", s);
        contentvalues.put("codename", s1);
        contentvalues.put("type", s2);
        contentvalues.put("title", s3);
        contentvalues.put("tag", s4);
        contentvalues.put("image", s5);
        contentvalues.put("content", s6);
        contentvalues.put("ext", s7);
        contentvalues.put("date", s8);
        sqlitedatabase.insertWithOnConflict("draft_timeline", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addGroupChat(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id_hp", s);
        contentvalues.put("merk", s1);
        contentvalues.put("model", s2);
        contentvalues.put("codename", s3);
        contentvalues.put("hp_photo", s4);
        contentvalues.put("from_name", s5);
        contentvalues.put("last_message", s6);
        contentvalues.put("message_type", s7);
        contentvalues.put("unread_msg", s8);
        contentvalues.put("message_me", s9);
        contentvalues.put("post_date", s10);
        sqlitedatabase.insertWithOnConflict("groupchat_msg", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addHP(String s, String s1, String s2, String s3, String s4)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("hp_id", s);
        contentvalues.put("hp_merk", s1);
        contentvalues.put("hp_model", s2);
        contentvalues.put("hp_photo", s3);
        contentvalues.put("hp_codename", s4);
        sqlitedatabase.insertWithOnConflict("user_hp_bookmark", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addHubDraft(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("title_hub", s);
        contentvalues.put("content_hub", s1);
        contentvalues.put("img_hub", s2);
        contentvalues.put("katum_hub", s3);
        contentvalues.put("katos_hub", s4);
        contentvalues.put("katop_hub", s5);
        contentvalues.put("kathp_hub", s6);
        sqlitedatabase.insertWithOnConflict("hub_post_draft", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addInbox(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id_msg", s);
        contentvalues.put("id_from", EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
        contentvalues.put("from_name", s2);
        contentvalues.put("from_photo", s3);
        contentvalues.put("id_to", EncodeDecodeAES.encrypt(RestClient.pelihara, s4));
        contentvalues.put("to_name", s5);
        contentvalues.put("to_photo", s6);
        contentvalues.put("last_message", s7);
        contentvalues.put("last_seen", s9);
        contentvalues.put("message_type", s8);
        contentvalues.put("unread_msg", s10);
        contentvalues.put("message_me", s11);
        contentvalues.put("post_date", s12);
        sqlitedatabase.insertWithOnConflict("inbox_msg", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addMSG(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14)
    {
        s10 = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id_msg", s);
        try
        {
            contentvalues.put("id_from", EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
            contentvalues.put("from_name", s2);
            contentvalues.put("from_photo", s3);
            contentvalues.put("id_to", EncodeDecodeAES.encrypt(RestClient.pelihara, s4));
            contentvalues.put("to_name", s5);
            contentvalues.put("to_photo", s6);
            contentvalues.put("message", s7);
            contentvalues.put("ext", s8);
            contentvalues.put("message_me", s11);
            contentvalues.put("message_type", s9);
            contentvalues.put("post_date", s12);
            contentvalues.put("img_width", s13);
            contentvalues.put("img_height", s14);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        s10.insertWithOnConflict("private_msg", null, contentvalues, 4);
        s10.close();
    }

    public void addMSGHP(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14)
    {
        s10 = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id_msg", s);
        try
        {
            contentvalues.put("id_from", EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
            contentvalues.put("from_name", s2);
            contentvalues.put("from_photo", s3);
            contentvalues.put("id_to", s4);
            contentvalues.put("to_name", s5);
            contentvalues.put("to_photo", s6);
            contentvalues.put("message", s7);
            contentvalues.put("ext", s8);
            contentvalues.put("message_me", s11);
            contentvalues.put("message_type", s9);
            contentvalues.put("post_date", s12);
            contentvalues.put("img_width", s13);
            contentvalues.put("img_height", s14);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        s10.insertWithOnConflict("gc_msg", null, contentvalues, 4);
        s10.close();
    }

    public void addRSS(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11)
    {
        try
        {
            SQLiteDatabase sqlitedatabase = getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("rss_id", s);
            contentvalues.put("rss_uname", s1);
            contentvalues.put("rss_avatar", s2);
            contentvalues.put("rss_title", s3);
            contentvalues.put("rss_desc", s4);
            contentvalues.put("rss_content", s5);
            contentvalues.put("rss_media", s6);
            contentvalues.put("rss_srclink", s7);
            contentvalues.put("rss_time", s8);
            contentvalues.put("rss_totlike", s9);
            contentvalues.put("rss_totkom", s10);
            contentvalues.put("rss_mystat", s11);
            sqlitedatabase.insertWithOnConflict("user_rss_fav", null, contentvalues, 4);
            sqlitedatabase.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void addTW(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("tw_id", s);
        contentvalues.put("tw_uname", s1);
        contentvalues.put("tw_avatar", s2);
        contentvalues.put("tw_content", s3);
        contentvalues.put("tw_media", s4);
        contentvalues.put("tw_time", s5);
        contentvalues.put("tw_totlike", s6);
        contentvalues.put("tw_totkom", s7);
        contentvalues.put("tw_mystat", s8);
        sqlitedatabase.insertWithOnConflict("user_tw_fav", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addUnread(String s)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("unread_msg", s);
        sqlitedatabase.insertWithOnConflict("sql_sequence", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addUser(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, String s17, String s18, String s19, String s20, 
            String s21, String s22, String s23, String s24, String s25)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_id", EncodeDecodeAES.encrypt(RestClient.pelihara, s));
        contentvalues.put("user_nama_asli", s1);
        contentvalues.put("user_photo", s2);
        contentvalues.put("user_name", s3);
        contentvalues.put("user_email", s4);
        contentvalues.put("user_ttl", s5);
        contentvalues.put("user_provinsi", s6);
        contentvalues.put("user_kota", s7);
        contentvalues.put("user_kecamatan", s25);
        contentvalues.put("user_jekel", s8);
        contentvalues.put("user_ponsel_1", s9);
        contentvalues.put("user_ponsel_2", s10);
        contentvalues.put("user_operator_1", s11);
        contentvalues.put("user_operator_2", s12);
        contentvalues.put("user_join_date", s13);
        contentvalues.put("user_modified_date", s14);
        contentvalues.put("user_email_notif", s15);
        contentvalues.put("user_push_notif", s16);
        contentvalues.put("user_komen_notif", s17);
        contentvalues.put("user_like_notif", s18);
        contentvalues.put("user_tanggap_notif", s19);
        contentvalues.put("user_komen_notif_push", s20);
        contentvalues.put("user_like_notif_push", s21);
        contentvalues.put("user_tanggap_notif_push", s22);
        contentvalues.put("codename_1", s23);
        contentvalues.put("codename_2", s24);
        sqlitedatabase.insertWithOnConflict("user_profile", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public void addUserView(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, String s17, String s18, String s19, String s20, 
            String s21, String s22, String s23)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        try
        {
            contentvalues.put("USER_ID", EncodeDecodeAES.encrypt(RestClient.pelihara, s));
            contentvalues.put("NAME", s1);
            contentvalues.put("AVATAR", s2);
            contentvalues.put("UNAME", EncodeDecodeAES.encrypt(RestClient.pelihara, s3));
            contentvalues.put("PROV", s4);
            contentvalues.put("KOTA", s5);
            contentvalues.put("JEKEL", s6);
            contentvalues.put("IDHP1", s7);
            contentvalues.put("IDHP2", s8);
            contentvalues.put("NAMEHP1", s9);
            contentvalues.put("NAMEHP2", s10);
            contentvalues.put("HARGAHP1", s11);
            contentvalues.put("HARGAHP2", s12);
            contentvalues.put("PICHP1", s13);
            contentvalues.put("PICHP2", s14);
            contentvalues.put("SIM1", s15);
            contentvalues.put("SIM2", s16);
            contentvalues.put("TOTPOST", s17);
            contentvalues.put("TOTLIKE", s18);
            contentvalues.put("TOTDISLIKE", s19);
            contentvalues.put(KEY_USER_ME, s20);
            contentvalues.put("JOIN_DATE", s21);
            contentvalues.put("CODENAME1", s22);
            contentvalues.put("CODENAME2", s23);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        sqlitedatabase.insertWithOnConflict("view_user", null, contentvalues, 4);
        sqlitedatabase.close();
    }

    public boolean checkARTJudulIfExist(String s, String s1)
    {
        return getReadableDatabase().rawQuery((new StringBuilder("SELECT * FROM draft_timeline where date = '")).append(s).append("'").toString(), null).getCount() > 0;
    }

    public boolean checkArtIfExist(String s)
    {
        return getReadableDatabase().rawQuery((new StringBuilder("SELECT * FROM draft_timeline where date = '")).append(s).append("'").toString(), null).getCount() > 0;
    }

    public boolean checkGCMSGIfExist(String s)
    {
        Log.e("id_msg", s);
        return getReadableDatabase().query("gc_msg", new String[] {
            "id_msg", "id_msg", "id_msg"
        }, "id_msg=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkIfExist(String s)
    {
        return getReadableDatabase().query("user_hp_bookmark", new String[] {
            "hp_id", "hp_merk", "hp_model"
        }, "hp_id=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkIfExistRSS(String s)
    {
        return getReadableDatabase().query("user_rss_fav", new String[] {
            "rss_id", "rss_uname", "rss_content"
        }, "rss_id=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkIfExistTW(String s)
    {
        return getReadableDatabase().query("user_tw_fav", new String[] {
            "tw_id", "tw_uname", "tw_content"
        }, "tw_id=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkIfExistUserView(String s)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = EncodeDecodeAES.encrypt(RestClient.pelihara, s);
        return sqlitedatabase.query("view_user", new String[] {
            "USER_ID", "UNAME"
        }, "UNAME=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkIfGroupExist(String s)
        throws Exception
    {
        return getReadableDatabase().rawQuery((new StringBuilder("SELECT * FROM groupchat_msg where codename = '")).append(s).append("'").toString(), null).getCount() > 0;
    }

    public boolean checkIfInboxExist(String s)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = EncodeDecodeAES.encrypt(RestClient.pelihara, s);
        return sqlitedatabase.query("inbox_msg", new String[] {
            "id_msg", "id_from", "id_to"
        }, "id_from=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkMSGIfExist(String s)
    {
        Log.e("id_msg", s);
        return getReadableDatabase().query("private_msg", new String[] {
            "id_msg", "id_msg", "id_msg"
        }, "id_msg=?", new String[] {
            s
        }, null, null, null, null).getCount() > 0;
    }

    public boolean checkTimelineExist(String s)
    {
        return getReadableDatabase().rawQuery((new StringBuilder("SELECT * FROM timeline_fav where id_content = '")).append(s).append("'").toString(), null).getCount() > 0;
    }

    public void deleteHP(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_hp_bookmark", "hp_id = ?", new String[] {
            s
        });
        sqlitedatabase.close();
        return;
        s;
        s.printStackTrace();
        sqlitedatabase.close();
        return;
        s;
        sqlitedatabase.close();
        throw s;
    }

    public void deleteIDRSS(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_rss_fav", "rss_id = ?", new String[] {
            s
        });
        sqlitedatabase.close();
        return;
        s;
        s.printStackTrace();
        sqlitedatabase.close();
        return;
        s;
        sqlitedatabase.close();
        throw s;
    }

    public void deleteIDTW(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_tw_fav", "tw_id = ?", new String[] {
            s
        });
        sqlitedatabase.close();
        return;
        s;
        s.printStackTrace();
        sqlitedatabase.close();
        return;
        s;
        sqlitedatabase.close();
        throw s;
    }

    public void delete_TLbyID(String s)
    {
        getWritableDatabase().execSQL((new StringBuilder("DELETE FROM timeline_fav WHERE id_content = '")).append(s).append("'").toString());
    }

    public void delete_byARTID(String s, String s1)
    {
        getWritableDatabase().execSQL((new StringBuilder("DELETE FROM draft_timeline WHERE date = '")).append(s).append("'").toString());
    }

    public void delete_groupchat(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        s = (new StringBuilder("DELETE FROM groupchat_msg WHERE codename = '")).append(s).append("'").toString();
        Log.e("del_GROUPCHAT", s);
        sqlitedatabase.execSQL(s);
    }

    public Cursor getARTID(String s)
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM draft_timeline where date = '")).append(s).append("'").toString(), null);
    }

    public Cursor getAllData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM user_profile", null);
    }

    public int getArtikelCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from draft_timeline", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getArtikelData(String s)
        throws SQLException
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM draft_timeline where type = '")).append(s).append("'").toString(), null);
    }

    public Cursor getEmail()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT user_email FROM user_profile", null);
    }

    public int getGCMSGCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from gc_msg", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getGCMSGData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM gc_msg", null);
    }

    public Cursor getGCMSGData(String s, String s1)
        throws Exception
    {
        s = getWritableDatabase();
        s1 = (new StringBuilder("SELECT * FROM (SELECT * FROM gc_msg where to_name = '")).append(s1).append("' ORDER BY ").append("id_msg").append(" desc LIMIT 0, 20) as hasil ORDER BY  ").append("post_date").append(" ASC").toString();
        Log.e("getMSGData", s1);
        return s.rawQuery(s1, null);
    }

    public Cursor getGCOlderMSGData(String s, String s1, String s2)
        throws Exception
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM (SELECT * FROM gc_msg where  id_msg < ")).append(s2).append(" AND ").append("to_name").append(" = '").append(s1).append("'  ORDER BY ").append("id_msg").append(" desc LIMIT 0, 20) as hasil ORDER BY  ").append("post_date").append(" desc").toString(), null);
    }

    public int getGroupChatCount()
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery("select * from groupchat_msg", null);
        int i = cursor.getCount();
        sqlitedatabase.close();
        cursor.close();
        return i;
    }

    public Cursor getGroupChatData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM groupchat_msg ORDER BY post_date desc", null);
    }

    public int getHPCount()
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery("select * from user_hp_bookmark", null);
        int i = cursor.getCount();
        sqlitedatabase.close();
        cursor.close();
        return i;
    }

    public Cursor getHPData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM user_hp_bookmark", null);
    }

    public HashMap getHPDetails()
    {
        HashMap hashmap = new HashMap();
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery("SELECT * from user_hp_bookmark", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0)
        {
            hashmap.put("hp_id", cursor.getString(1));
            hashmap.put("hp_merk", cursor.getString(2));
            hashmap.put("hp_model", cursor.getString(3));
            hashmap.put("hp_photo", cursor.getString(4));
            hashmap.put("hp_codename", cursor.getString(5));
        }
        cursor.close();
        sqlitedatabase.close();
        return hashmap;
    }

    public int getHubCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from hub_post_draft", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getHubData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM hub_post_draft", null);
    }

    public Cursor getINBOXData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM inbox_msg ORDER BY post_date desc", null);
    }

    public int getInBoxCount()
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery("select * from inbox_msg", null);
        int i = cursor.getCount();
        sqlitedatabase.close();
        cursor.close();
        return i;
    }

    public int getMSGCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from private_msg", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getMSGData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM private_msg", null);
    }

    public Cursor getMSGData(String s, String s1)
        throws Exception
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        s = (new StringBuilder("SELECT * FROM (SELECT * FROM private_msg where ((id_from = '")).append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("' AND ").append("id_to").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s1)).append("') OR (").append("id_from").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s1)).append("' AND ").append("id_to").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("')) ORDER BY ").append("id_msg").append(" desc LIMIT 0, 20) as hasil ORDER BY  ").append("post_date").append(" ASC").toString();
        Log.e("getMSGData", s);
        return sqlitedatabase.rawQuery(s, null);
    }

    public Cursor getName()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT user_nama_asli FROM user_profile", null);
    }

    public Cursor getOlderMSGData(String s, String s1, String s2)
        throws Exception
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM (SELECT * FROM private_msg where  id_msg < ")).append(s2).append(" AND ((").append("id_from").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("' AND ").append("id_to").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s1)).append("') OR (").append("id_from").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s1)).append("' AND ").append("id_to").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("') ) ORDER BY ").append("id_msg").append(" desc LIMIT 0, 20) as hasil ORDER BY  ").append("post_date").append(" desc").toString(), null);
    }

    public int getRSSCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from user_rss_fav", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getRSSData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM user_rss_fav", null);
    }

    public Cursor getRSSIDData(String s)
        throws SQLException
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM user_rss_fav where rss_id = '")).append(s).append("'").toString(), null);
    }

    public int getRowCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from user_profile", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getTIMELINEData(String s)
        throws SQLException
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        s = (new StringBuilder("SELECT * FROM timeline_fav where type = '")).append(s).append("'").toString();
        Log.e("selectQ", s);
        return sqlitedatabase.rawQuery(s, null);
    }

    public Cursor getTIMELINEID(String s)
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM timeline_fav where id_content = '")).append(s).append("'").toString(), null);
    }

    public int getTWCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from user_tw_fav", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getTWData()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT * FROM user_tw_fav", null);
    }

    public int getTimelineCount()
    {
        int j = 0;
        int i = j;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        try
        {
            sqlitedatabase = getReadableDatabase();
        }
        catch (Exception exception)
        {
            return i;
        }
        i = j;
        cursor = sqlitedatabase.rawQuery("select * from timeline_fav", null);
        i = j;
        j = cursor.getCount();
        i = j;
        sqlitedatabase.close();
        i = j;
        cursor.close();
        return j;
    }

    public Cursor getTotalUnread()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT sum(unread_msg) as total  FROM inbox_msg ", null);
    }

    public Cursor getTotalUnreadGroupChat()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT sum(unread_msg) as total  FROM groupchat_msg", null);
    }

    public Cursor getTotalUnreadSQLSEQ()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT unread_msg as total  FROM sql_sequence", null);
    }

    public Cursor getUserData(String s)
        throws Exception
    {
        return getWritableDatabase().rawQuery((new StringBuilder("SELECT * FROM view_user where UNAME = '")).append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("'").toString(), null);
    }

    public HashMap getUserDetails()
    {
        HashMap hashmap = new HashMap();
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery("SELECT * from user_profile", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0)
        {
            hashmap.put("user_id", cursor.getString(1));
            hashmap.put("user_nama_asli", cursor.getString(2));
            hashmap.put("user_photo", cursor.getString(3));
            hashmap.put("user_name", cursor.getString(4));
            hashmap.put("user_email", cursor.getString(5));
            hashmap.put("user_ttl", cursor.getString(6));
            hashmap.put("user_provinsi", cursor.getString(7));
            hashmap.put("user_kota", cursor.getString(8));
            hashmap.put("user_jekel", cursor.getString(9));
            hashmap.put("user_ponsel_1", cursor.getString(10));
            hashmap.put("user_ponsel_2", cursor.getString(11));
            hashmap.put("user_operator_1", cursor.getString(12));
            hashmap.put("user_operator_2", cursor.getString(13));
            hashmap.put("user_join_date", cursor.getString(14));
            hashmap.put("user_modified_date", cursor.getString(15));
            hashmap.put("user_email_notif", cursor.getString(16));
            hashmap.put("user_push_notif", cursor.getString(17));
            hashmap.put("user_komen_notif", cursor.getString(18));
            hashmap.put("user_like_notif", cursor.getString(19));
            hashmap.put("user_tanggap_notif", cursor.getString(20));
        }
        cursor.close();
        sqlitedatabase.close();
        return hashmap;
    }

    public Cursor getUserName()
        throws SQLException
    {
        return getWritableDatabase().rawQuery("SELECT user_name FROM user_profile", null);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(CREATE_PROFILE_TABLE);
        sqlitedatabase.execSQL(CREATE_HP_TABLE);
        sqlitedatabase.execSQL(CREATE_TW_TABLE);
        sqlitedatabase.execSQL(CREATE_RSS_TABLE);
        sqlitedatabase.execSQL(CREATE_VIEWUSER_TABLE);
        sqlitedatabase.execSQL(CREATE_MSG_TABLE);
        sqlitedatabase.execSQL(CREATE_GC_MSG_TABLE);
        sqlitedatabase.execSQL(CREATE_BOX_TABLE);
        sqlitedatabase.execSQL(CREATE_SQLSEQ_TABLE);
        sqlitedatabase.execSQL(CREATE_ARTUSER_TABLE);
        sqlitedatabase.execSQL(CREATE_ARTANYA_TABLE);
        sqlitedatabase.execSQL(CREATE_GROUPCHAT);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Log.e("upgrade", "table");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS user_profile");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS user_hp_bookmark");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS hub_post_draft");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS user_tw_fav");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS user_rss_fav");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS view_user");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS private_msg");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS gc_msg");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS inbox_msg");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS draft_timeline");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS timeline_fav");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS groupchat_msg");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS sql_sequence");
        onCreate(sqlitedatabase);
    }

    public Cursor queueAllHub()
    {
        return getWritableDatabase().query("hub_post_draft", new String[] {
            "title_hub", "content_hub"
        }, null, null, null, null, null);
    }

    public void removeAll()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_profile", null, null);
        sqlitedatabase.delete("user_hp_bookmark", null, null);
        sqlitedatabase.delete("inbox_msg", null, null);
        sqlitedatabase.delete("groupchat_msg", null, null);
        sqlitedatabase.delete("private_msg", null, null);
        sqlitedatabase.delete("gc_msg", null, null);
        sqlitedatabase.delete("sql_sequence", null, null);
        sqlitedatabase.delete("user_rss_fav", null, null);
        sqlitedatabase.delete("user_tw_fav", null, null);
        sqlitedatabase.delete("draft_timeline", null, null);
        sqlitedatabase.delete("timeline_fav", null, null);
    }

    public void removeFavorite()
    {
        getWritableDatabase().delete("user_hp_bookmark", null, null);
    }

    public void removeLastMSG()
    {
        getWritableDatabase().delete("inbox_msg", null, null);
    }

    public void resetGroupChatTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("groupchat_msg", null, null);
        sqlitedatabase.close();
    }

    public void resetHPTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_hp_bookmark", null, null);
        sqlitedatabase.close();
    }

    public void resetInboxTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("inbox_msg", null, null);
        sqlitedatabase.close();
    }

    public void resetRSSTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_rss_fav", null, null);
        sqlitedatabase.close();
    }

    public void resetTLTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("timeline_fav", null, null);
        sqlitedatabase.close();
    }

    public void resetTWTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_tw_fav", null, null);
        sqlitedatabase.close();
    }

    public void resetTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("user_profile", null, null);
        sqlitedatabase.close();
    }

    public void resetUnreadMSGTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("sql_sequence", null, null);
        sqlitedatabase.close();
    }

    public void resetViewUserTables()
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        sqlitedatabase.delete("view_user", null, null);
        sqlitedatabase.close();
    }

    public void updateUserView(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, String s17, String s18, String s19, String s20, 
            String s21, String s22, String s23)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        try
        {
            contentvalues.put("USER_ID", EncodeDecodeAES.encrypt(RestClient.pelihara, s));
            contentvalues.put("NAME", s1);
            contentvalues.put("AVATAR", s2);
            contentvalues.put("UNAME", EncodeDecodeAES.encrypt(RestClient.pelihara, s3));
            contentvalues.put("PROV", s4);
            contentvalues.put("KOTA", s5);
            contentvalues.put("JEKEL", s6);
            contentvalues.put("IDHP1", s7);
            contentvalues.put("IDHP2", s8);
            contentvalues.put("NAMEHP1", s9);
            contentvalues.put("NAMEHP2", s10);
            contentvalues.put("HARGAHP1", s11);
            contentvalues.put("HARGAHP2", s12);
            contentvalues.put("PICHP1", s13);
            contentvalues.put("PICHP2", s14);
            contentvalues.put("SIM1", s15);
            contentvalues.put("SIM2", s16);
            contentvalues.put("TOTPOST", s17);
            contentvalues.put("TOTLIKE", s18);
            contentvalues.put("TOTDISLIKE", s19);
            contentvalues.put(KEY_USER_ME, s20);
            contentvalues.put("JOIN_DATE", s21);
            contentvalues.put("CODENAME1", s22);
            contentvalues.put("CODENAME2", s23);
            sqlitedatabase.update("view_user", contentvalues, (new StringBuilder("USER_ID= '")).append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("'").toString(), null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void update_Email_notif(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_email_notif", s);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_EmailbyID(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_email", s);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_Komen_notif(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_komen_notif", s);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_Like_notif(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_like_notif", s);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_Pengaturan(String s, String s1, String s2, String s3, String s4, String s5)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_komen_notif", s);
        contentvalues.put("user_like_notif", s1);
        contentvalues.put("user_tanggap_notif", s2);
        contentvalues.put("user_komen_notif_push", s3);
        contentvalues.put("user_like_notif_push", s4);
        contentvalues.put("user_tanggap_notif_push", s5);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_Push_notif(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_push_notif", s);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_Tanggap_notif(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_tanggap_notif", s);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_byARTID(String s, String s1, String s2, String s3, String s4, String s5)
    {
        getWritableDatabase().execSQL((new StringBuilder("UPDATE draft_timeline SET title = '")).append(s1).append("', ").append("image").append(" = '").append(s3).append("', ").append("tag").append(" = '").append(s2).append("', ").append("content").append(" = '").append(s4).append("', ").append("ext").append(" = '").append(s5).append("' where (").append("date").append("='").append(s).append("')").toString());
    }

    public void update_byID(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_nama_asli", s);
        contentvalues.put("user_name", s1);
        contentvalues.put("user_email", s2);
        contentvalues.put("user_ttl", s3);
        contentvalues.put("user_provinsi", s4);
        contentvalues.put("user_kota", s5);
        contentvalues.put("user_jekel", s6);
        contentvalues.put("user_ponsel_1", s7);
        contentvalues.put("user_ponsel_2", s8);
        contentvalues.put("user_operator_1", s9);
        contentvalues.put("user_operator_2", s10);
        contentvalues.put("user_join_date", s11);
        contentvalues.put("user_modified_date", s12);
        contentvalues.put("codename_1", s13);
        contentvalues.put("codename_2", s14);
        contentvalues.put("user_kecamatan", s15);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_byImage(String s, String s1)
    {
        s = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_photo", s1);
        s.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_by_site(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("user_nama_asli", s);
        contentvalues.put("user_photo", s1);
        contentvalues.put("user_name", s2);
        contentvalues.put("user_email", s3);
        contentvalues.put("user_ttl", s4);
        contentvalues.put("user_provinsi", s5);
        contentvalues.put("user_kota", s6);
        contentvalues.put("user_jekel", s7);
        contentvalues.put("user_ponsel_1", s8);
        contentvalues.put("user_ponsel_2", s9);
        contentvalues.put("user_operator_1", s10);
        contentvalues.put("user_operator_2", s11);
        contentvalues.put("user_join_date", s12);
        contentvalues.put("user_modified_date", s13);
        contentvalues.put("codename_1", s14);
        contentvalues.put("codename_2", s15);
        contentvalues.put("user_kecamatan", s16);
        sqlitedatabase.update("user_profile", contentvalues, "id= 1", null);
    }

    public void update_groupmsg(String s, String s1, String s2, String s3, String s4, String s5, String s6)
        throws SQLException, Exception
    {
        getWritableDatabase().execSQL((new StringBuilder("UPDATE groupchat_msg SET last_message = '")).append(s2).append("' ,").append("from_name").append(" = '").append(s1).append("' ,").append("message_type").append(" = '").append(s3).append("' ,").append("message_me").append("= '").append(s5).append("' ,").append("unread_msg").append("= '").append(s6).append("' ,").append("post_date").append("= '").append(s4).append("' WHERE ").append("codename").append(" = '").append(s).append("'").toString());
    }

    public void update_msgread(String s)
    {
        s = (new StringBuilder("UPDATE inbox_msg SET unread_msg= '0' WHERE from_name = '")).append(s).append("'").toString();
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        Log.e("update_msgreadid", s);
        sqlitedatabase.execSQL(s);
    }

    public void update_unread_sqlseq(String s)
    {
        getWritableDatabase().execSQL((new StringBuilder("UPDATE sql_sequence SET unread_msg = '")).append(s).append("'").toString());
    }

    public void update_usrmsg(String s, String s1, String s2, String s3, String s4, String s5)
        throws SQLException, Exception
    {
        getWritableDatabase().execSQL((new StringBuilder("UPDATE inbox_msg SET last_message = '")).append(s1).append("' ,").append("message_type").append("= '").append(s2).append("' ,").append("message_me").append("= '").append(s4).append("' ,").append("unread_msg").append("= '").append(s5).append("' ,").append("post_date").append("= '").append(s3).append("' WHERE ").append("id_from").append(" = '").append(EncodeDecodeAES.encrypt(RestClient.pelihara, s)).append("'").toString());
    }
}
