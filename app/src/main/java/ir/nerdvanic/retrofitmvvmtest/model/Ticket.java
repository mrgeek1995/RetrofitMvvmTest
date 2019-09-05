package ir.nerdvanic.retrofitmvvmtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName("ticketid")
    @Expose
    public String ticketid;

    @SerializedName("ticketname")
    @Expose
    public String ticketname;

    @SerializedName("ticketdesc")
    @Expose
    public String ticketdesc;

    public Ticket() {
    }

    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public String getTicketname() {
        return ticketname;
    }

    public void setTicketname(String ticketname) {
        this.ticketname = ticketname;
    }

    public String getTicketdesc() {
        return ticketdesc;
    }

    public void setTicketdesc(String ticketdesc) {
        this.ticketdesc = ticketdesc;
    }
}
