package katheria.vhp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;

/**
 * Created by shekh on 30-Jan-17.
 */

public class ShowProgressDialog {

    Dai dai;

    public ShowProgressDialog(Context context) {



        dai = new Dai(context);
        dai.setCancelable(false);
        dai.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void show() {
        dai.show();


    }

    public void dismiss() {
        dai.dismiss();


    }
}
