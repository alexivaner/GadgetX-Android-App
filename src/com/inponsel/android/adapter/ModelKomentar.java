// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ModelKomentar
{

    private String email_komentar;
    private String id_handphone_komentar;
    private String id_komentar;
    private String jml_tanggapan;
    private String komen_bagus;
    private String komen_kurang;
    private String komentarhp;
    private String nama_komentar;
    private String parent_id_komentar;
    private boolean selected;
    private String tanggal_komentar;
    private String usr_pict_komen;

    public ModelKomentar(String s, String s1)
    {
        nama_komentar = s;
        usr_pict_komen = s1;
    }

    public String getEmail_komentar()
    {
        return email_komentar;
    }

    public String getId_handphone_komentar()
    {
        return id_handphone_komentar;
    }

    public String getId_komentar()
    {
        return id_komentar;
    }

    public String getJml_tanggapan()
    {
        return jml_tanggapan;
    }

    public String getKomen_bagus()
    {
        return komen_bagus;
    }

    public String getKomen_kurang()
    {
        return komen_kurang;
    }

    public String getKomentarhp()
    {
        return komentarhp;
    }

    public String getNama_komentar()
    {
        return nama_komentar;
    }

    public String getParent_id_komentar()
    {
        return parent_id_komentar;
    }

    public String getTanggal_komentar()
    {
        return tanggal_komentar;
    }

    public String getUsr_pict_komen()
    {
        return usr_pict_komen;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setEmail_komentar(String s)
    {
        email_komentar = s;
    }

    public void setId_handphone_komentar(String s)
    {
        id_handphone_komentar = s;
    }

    public void setId_komentar(String s)
    {
        id_komentar = s;
    }

    public void setJml_tanggapan(String s)
    {
        jml_tanggapan = s;
    }

    public void setKomen_bagus(String s)
    {
        komen_bagus = s;
    }

    public void setKomen_kurang(String s)
    {
        komen_kurang = s;
    }

    public void setKomentarhp(String s)
    {
        komentarhp = s;
    }

    public void setNama_komentar(String s)
    {
        nama_komentar = s;
    }

    public void setParent_id_komentar(String s)
    {
        parent_id_komentar = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setTanggal_komentar(String s)
    {
        tanggal_komentar = s;
    }

    public void setUsr_pict_komen(String s)
    {
        usr_pict_komen = s;
    }
}
