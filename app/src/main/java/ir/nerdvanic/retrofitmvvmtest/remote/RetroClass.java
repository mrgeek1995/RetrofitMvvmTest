package ir.nerdvanic.retrofitmvvmtest.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import ir.nerdvanic.retrofitmvvmtest.model.Ticket;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static final String ROOTURL = "Your_URL";

    private static Retrofit getRetroInstance(){

        return new Retrofit.Builder().baseUrl(ROOTURL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APIService getAPIService(){

        return getRetroInstance().create(APIService.class);
    }

    public Ticket getTicket(){
        final Ticket ticket = new Ticket();
        APIService apiService = RetroClass.getAPIService();

        apiService.getTicketJSON().enqueue(new Callback<Ticket>() {
            @Override
            public void onResponse(Call<Ticket> call, Response<Ticket> response) {

                Ticket tik = response.body();
                ticket.setTicketid(tik.ticketid);
                ticket.setTicketname(tik.ticketname);
                ticket.setTicketdesc(tik.ticketdesc);
            }

            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {

            }
        });

        return ticket;
    }

    public LiveData<Ticket> getTicketLiveData(){
        final MutableLiveData<Ticket> mutableLiveData = new MutableLiveData<>();

        APIService apiService = RetroClass.getAPIService();
        apiService.getTicketJSON().enqueue(new Callback<Ticket>() {
            @Override
            public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                Ticket tic = response.body();
                mutableLiveData.setValue(tic);
            }

            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
