package ir.nerdvanic.retrofitmvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ir.nerdvanic.retrofitmvvmtest.viewmodel.TicketViewModel;

public class MainActivity extends AppCompatActivity {

    private TicketViewModel ticketViewModel;

    private TextView txtId, txtName, txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtDesc = findViewById(R.id.txtDesc);

        ticketViewModel = ViewModelProviders.of(this).get(TicketViewModel.class);
        //ticketViewModel.getTicketVal();

        ticketViewModel.getLiveDataVal();
    }

    public void getTokenView(View view){
        //String ticketidval = ticketViewModel.getTicketVal().getTicketid();
        String ticketidval = ticketViewModel.getLiveDataVal().getValue().getTicketid();
        txtId.setText(ticketidval);

        //String ticketnameval = ticketViewModel.getTicketVal().getTicketname();
        String ticketnameval = ticketViewModel.getLiveDataVal().getValue().getTicketname();
        txtName.setText(ticketnameval);

        //String ticketdescval = ticketViewModel.getTicketVal().getTicketdesc();
        String ticketdescval = ticketViewModel.getLiveDataVal().getValue().getTicketdesc();
        txtDesc.setText(ticketdescval);
    }
}
