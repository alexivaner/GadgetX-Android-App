// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import java.util.Observable;

public class ModelObserver extends Observable
{

    String fav_stat_TL;
    String fav_stat_rss;
    public String id_hp;
    public String indexHp;
    public String indexKom;
    public String indexKomSC;
    String indexRSS;
    String indexTL;
    String indexTw;
    public String jum_komenLikeKom;
    public String jum_komenLikePon;
    String jum_komenLikeRSS;
    String jum_komenLikeTL;
    String jum_komenLikeTw;
    public String loginStat;
    public String status_like_ponsel;
    public String tot_LikeKom;
    public String tot_LikePon;
    String tot_LikeRSS;
    String tot_LikeTL;
    String tot_LikeTw;
    public String totdis_LikeKom;
    public String totdis_LikePon;
    String totdis_LikeRSS;
    String totdis_LikeTL;
    String totdis_LikeTw;
    public String updateType;

    public ModelObserver()
    {
        status_like_ponsel = "";
        indexHp = "";
        updateType = "";
        loginStat = "";
        indexKom = "";
        indexKomSC = "";
    }

    public String getFav_stat_TL()
    {
        return fav_stat_TL;
    }

    public String getFav_stat_rss()
    {
        return fav_stat_rss;
    }

    public String getId_hp()
    {
        return id_hp;
    }

    public String getIndexHp()
    {
        return indexHp;
    }

    public String getIndexKom()
    {
        return indexKom;
    }

    public String getIndexKomSC()
    {
        return indexKomSC;
    }

    public String getIndexRSS()
    {
        return indexRSS;
    }

    public String getIndexTL()
    {
        return indexTL;
    }

    public String getIndexTw()
    {
        return indexTw;
    }

    public String getJum_komenLikeKom()
    {
        return jum_komenLikeKom;
    }

    public String getJum_komenLikePon()
    {
        return jum_komenLikePon;
    }

    public String getJum_komenLikeRSS()
    {
        return jum_komenLikeRSS;
    }

    public String getJum_komenLikeTL()
    {
        return jum_komenLikeTL;
    }

    public String getJum_komenLikeTw()
    {
        return jum_komenLikeTw;
    }

    public String getLoginStat()
    {
        return loginStat;
    }

    public String getStatus_like_ponsel()
    {
        return status_like_ponsel;
    }

    public String getTot_LikeKom()
    {
        return tot_LikeKom;
    }

    public String getTot_LikePon()
    {
        return tot_LikePon;
    }

    public String getTot_LikeRSS()
    {
        return tot_LikeRSS;
    }

    public String getTot_LikeTL()
    {
        return tot_LikeTL;
    }

    public String getTot_LikeTw()
    {
        return tot_LikeTw;
    }

    public String getTotdis_LikeKom()
    {
        return totdis_LikeKom;
    }

    public String getTotdis_LikePon()
    {
        return totdis_LikePon;
    }

    public String getTotdis_LikeRSS()
    {
        return totdis_LikeRSS;
    }

    public String getTotdis_LikeTL()
    {
        return totdis_LikeTL;
    }

    public String getTotdis_LikeTw()
    {
        return totdis_LikeTw;
    }

    public String getUpdateType()
    {
        return updateType;
    }

    public void setFav_stat_TL(String s)
    {
        fav_stat_TL = s;
    }

    public void setFav_stat_rss(String s)
    {
        fav_stat_rss = s;
    }

    public void setId_hp(String s)
    {
        id_hp = s;
    }

    public void setIndexHp(String s)
    {
        indexHp = s;
    }

    public void setIndexKom(String s)
    {
        indexKom = s;
    }

    public void setIndexKomSC(String s)
    {
        indexKomSC = s;
    }

    public void setIndexRSS(String s)
    {
        indexRSS = s;
    }

    public void setIndexTL(String s)
    {
        indexTL = s;
    }

    public void setIndexTw(String s)
    {
        indexTw = s;
    }

    public void setJum_komenLikeKom(String s)
    {
        jum_komenLikeKom = s;
    }

    public void setJum_komenLikePon(String s)
    {
        jum_komenLikePon = s;
    }

    public void setJum_komenLikeRSS(String s)
    {
        jum_komenLikeRSS = s;
    }

    public void setJum_komenLikeTL(String s)
    {
        jum_komenLikeTL = s;
    }

    public void setJum_komenLikeTw(String s)
    {
        jum_komenLikeTw = s;
    }

    public void setLoginStat(String s)
    {
        loginStat = s;
        setChanged();
        notifyObservers();
    }

    public void setStatus_like_ponsel(String s)
    {
        status_like_ponsel = s;
        setChanged();
        notifyObservers();
    }

    public void setTot_LikeKom(String s)
    {
        tot_LikeKom = s;
    }

    public void setTot_LikePon(String s)
    {
        tot_LikePon = s;
    }

    public void setTot_LikeRSS(String s)
    {
        tot_LikeRSS = s;
    }

    public void setTot_LikeTL(String s)
    {
        tot_LikeTL = s;
    }

    public void setTot_LikeTw(String s)
    {
        tot_LikeTw = s;
    }

    public void setTotdis_LikeKom(String s)
    {
        totdis_LikeKom = s;
    }

    public void setTotdis_LikePon(String s)
    {
        totdis_LikePon = s;
    }

    public void setTotdis_LikeRSS(String s)
    {
        totdis_LikeRSS = s;
    }

    public void setTotdis_LikeTL(String s)
    {
        totdis_LikeTL = s;
    }

    public void setTotdis_LikeTw(String s)
    {
        totdis_LikeTw = s;
    }

    public void setUpdateType(String s)
    {
        updateType = s;
    }
}
