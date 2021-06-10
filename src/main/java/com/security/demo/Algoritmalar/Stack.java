package com.security.demo.Algoritmalar;

import java.util.Arrays;

public class Stack {
    public static final int MAX_STACK_SIZE=5;
    public boolean full=false;
    public boolean empty=true;
    private String [] dizi=new String[MAX_STACK_SIZE];
    private int size=0;

    public boolean push(String newElement){
        if(!isFull()){
            dizi[size]=newElement;
            size++;
            if(size==5){
                full=true;
            }
            return true;
        }
        return false;
    }

    public String pop(){
        if(!isEmpty()){
            String lastElem=dizi[size-1];
            dizi[size-1]=null;
            size--;
            full=false;
            if(size==0){
                empty=true;
            }
            return lastElem;
        }
        return null;
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isFull(){
        return full;
    }

    public int size(){
        return size;
    }

    public int getCapacity(){
        return MAX_STACK_SIZE;
    }
    public void clear(){
        Arrays.fill(dizi,null);
        size=0;
        empty=true;
        full=false;
    }

    public void showElements(){
        for(String i:dizi){
            System.out.println(i);
        }
    }


}
