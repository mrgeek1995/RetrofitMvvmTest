package ir.nerdvanic.retrofitmvvmtest.remote;

import ir.nerdvanic.retrofitmvvmtest.model.Ticket;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/test/b.json")
    Call<Ticket> getTicketJSON();
}
