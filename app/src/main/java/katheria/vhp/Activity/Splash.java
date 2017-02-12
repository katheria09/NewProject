package katheria.vhp.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import katheria.vhp.Http.HttpCall;
import katheria.vhp.R;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_TIMER = 2500;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = Splash.this;
        inti();
        TimerStart();

    }

    private void inti(){

    }

    private  void TimerStart(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                Intent intent;
                /*if (new AppPreferences().getLoggedIn(Splash.this)){
                    intent = new Intent(Splash.this,LoginActivity.class);
                    new HttpCall().getUserName(Splash.this,intent,"splash",false);

                }else{

                }*/
            }
        };
    }
}
