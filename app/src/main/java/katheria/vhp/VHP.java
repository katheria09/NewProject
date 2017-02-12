package katheria.vhp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by KunwarShekhar on 13-Jan-17.
 */

public class VHP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
