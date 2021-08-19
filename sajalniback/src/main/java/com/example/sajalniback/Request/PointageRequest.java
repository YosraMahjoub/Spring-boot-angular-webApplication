package com.example.sajalniback.Request;

public class PointageRequest {
    private long iddemref;
    private long iddemacc;
    private long iddos;
    private String refbf;

    public void setRefbf(String refbf) {
        this.refbf = refbf;
    }

    public String getRefbf() {
        return refbf;
    }

    public void setIddemref(long iddemref) {
        this.iddemref = iddemref;
    }

    public void setIddemacc(long iddemacc) {
        this.iddemacc = iddemacc;
    }

    public void setIddos(long iddos) {
        this.iddos = iddos;
    }

    public long getIddemref() {
        return iddemref;
    }

    public long getIddemacc() {
        return iddemacc;
    }

    public long getIddos() {
        return iddos;
    }

    public PointageRequest(long iddemref, long iddemacc, long iddos, String refbf) {
        this.iddemref = iddemref;
        this.iddemacc = iddemacc;
        this.iddos = iddos;
        this.refbf=refbf;
    }
}
