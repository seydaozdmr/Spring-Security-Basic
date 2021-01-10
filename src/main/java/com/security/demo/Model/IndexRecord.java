package com.security.demo.Model;

public class IndexRecord {
    private int startByte;
    private int lenght;

    public IndexRecord(int startByte, int lenght) {
        this.startByte = startByte;
        this.lenght = lenght;
    }

    public int getStartByte() {
        return startByte;
    }

    public void setStartByte(int startByte) {
        this.startByte = startByte;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
