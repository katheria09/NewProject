package katheria.vhp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import katheria.vhp.Http.DataParser;
import katheria.vhp.Model.Model_userDetails;
import katheria.vhp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    TextView name,phone,email;
    String Email,Name;
    public static DataParser dp;




    public ProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        init(view);

        dp=new DataParser();
        Email= dp.getArrayList().get(0).email;
//        Name = dp.getArrayList().get(1).name;

        setDetails();
        return view;

    }

    private void init(View view) {

        name = (TextView) view.findViewById(R.id.frag_name);
        phone = (TextView) view.findViewById(R.id.frag_phone);
        email = (TextView) view.findViewById(R.id.frag_email);


    }

    private void setDetails() {
        email.setText(Email);
    }

}
