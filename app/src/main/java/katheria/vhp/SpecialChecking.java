package katheria.vhp;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shekh on 11-Feb-17.
 */

public class SpecialChecking {
    public boolean specialChecking(Context context, EditText add1){
        String text =add1.getText().toString() ;
        if (text.contains("'") || text.contains("\"") || text.contains("$") || text.contains(".")
                || text.contains(";"))
        {
            Toast.makeText(context,"Address/Name should not contain special characters",Toast.LENGTH_SHORT).show();
            return false;
        }else
        {
            return true;
        }
    }
}
