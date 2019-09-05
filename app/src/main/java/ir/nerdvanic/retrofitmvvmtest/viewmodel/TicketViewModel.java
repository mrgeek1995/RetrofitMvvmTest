package ir.nerdvanic.retrofitmvvmtest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import ir.nerdvanic.retrofitmvvmtest.model.Ticket;
import ir.nerdvanic.retrofitmvvmtest.remote.RetroClass;

public class TicketViewModel extends ViewModel {

    private Ticket ticket;
    private RetroClass retroClass = new RetroClass();
    private LiveData<Ticket> liveData;


    public Ticket getTicketVal(){

        if (ticket == null){
            ticket = retroClass.getTicket();
        }
        return ticket;
    }

    public LiveData<Ticket> getLiveDataVal(){
        if (liveData == null){
            liveData = retroClass.getTicketLiveData();

        }

        return liveData;
    }
}
