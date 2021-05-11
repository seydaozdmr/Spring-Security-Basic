package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

public class TicketManager {
    private int tickets;
    private static TicketManager instance;

    private TicketManager(){}
    static synchronized TicketManager getInstance(){
        if(instance==null) instance=new TicketManager();
        return instance;
    }

    public int getTicketCount() {return tickets;}
    public void addTickets(int value) {
        tickets+=value;
    }
    public void sellTickets(int value){
        synchronized (this){
            tickets-=value;
        }
    }




}
