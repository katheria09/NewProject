package katheria.vhp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import katheria.vhp.Model.Model_userDetails;
import katheria.vhp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    TextView name,phone,email;
    String Name,Phone,Email;

    Model_userDetails model_userDetails = new Model_userDetails();


    public ProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        init(view);
        return view;
    }

    private void init(View view) {

        name = (TextView) view.findViewById(R.id.name);
        phone = (TextView) view.findViewById(R.id.phone);
        email = (TextView) view.findViewById(R.id.email);

        Name = model_userDetails.name;
        name.setText(Name);
      //  Log.e("ABCD",Name);
        Phone = model_userDetails.mobile;
        phone.setText(Phone);
        Email = model_userDetails.email;
        email.setText(Email);










    }

}
