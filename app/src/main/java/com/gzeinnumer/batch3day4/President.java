package com.gzeinnumer.batch3day4;

public class President {
    private String nama;
    private String start;
    private String end;

    public President(String nama, String start, String end) {
        this.nama = nama;
        this.start = start;
        this.end = end;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
