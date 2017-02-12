package katheria.vhp.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import katheria.vhp.R;

public class AccoutnActivity extends AppCompatActivity {

    String name,email;
    TextView t_name,t_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accoutn);
        //Bundle bundle =getIntent().getExtras();
        //name=bundle.getString("Name");
        //email=bundle.getString("Email");
       /* t_name = (TextView) findViewById(R.id.user_name);
        t_email= (TextView) findViewById(R.id.user_email);
        t_name.setText(name);
        t_email.setText(email);*/


    }
}
