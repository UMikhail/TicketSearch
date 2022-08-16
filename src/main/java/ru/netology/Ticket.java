package ru.netology;
public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int cost;
    protected String from;
    protected String to;
    protected int travelTime;

    public Ticket(int id, int cost, String from, String to, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    //public void setId(int id) {
        //this.id = id;
    //}

    //public int getCost() {
        //return cost;
    //}

    //public void setCost(int cost) {
        //this.cost = cost;
    //}

    public String getFrom() {
        return from;
    }

    //public void setFrom(String from) {
        //this.from = from;
    //}

    public String getTo() {
        return to;
    }

    // void setTo(String to) {
        //this.to = to;
    //}

    //public int getTravelTime() {
        //return travelTime;
    //}

    //public void setTravelTime(int travelTime) {
        //this.travelTime = travelTime;
    //}

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
