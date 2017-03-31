package katheria.vhp.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import katheria.vhp.Http.DataParser;
import katheria.vhp.Http.HttpCall;
import katheria.vhp.Model.Model_userDetails;
import katheria.vhp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private Context context;
    EditText email,name, phone, address,block,district,state;
    String Email,Name,Phone,Address,Block,State,District,Designation;
    Button next;
    Spinner Spinner_designation,Spinner_designation2;
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
        Name = dp.getArrayList().get(0).name;
        Phone = dp.getArrayList().get(0).mobile;
        Designation=dp.getArrayList().get(0).designation;
        Address=dp.getArrayList().get(0).village;
        Block=dp.getArrayList().get(0).block;
        District=dp.getArrayList().get(0).district;
        State=dp.getArrayList().get(0).state;




        setDetails();
        return view;

    }

    private void init(View view) {

        name = (EditText) view.findViewById(R.id.frag_name);
        phone = (EditText) view.findViewById(R.id.frag_phone);
        email = (EditText) view.findViewById(R.id.frag_email);
        email.setEnabled(false);
        state = (EditText) view.findViewById(R.id.frag_state);
        state.setEnabled(false);
        district = (EditText) view.findViewById(R.id.frag_district);
        district.setEnabled(false);
        Spinner_designation = (Spinner) view.findViewById(R.id.spinner_designation);
        Spinner_designation2 = (Spinner) view.findViewById(R.id.spinner_designation2);
        address= (EditText) view.findViewById(R.id.address);
        block= (EditText) view.findViewById(R.id.block);
        next = (Button)view.findViewById(R.id.save);


    }

    private void setDetails() {


        email.setText(Email);
        name.setText(Name);
        phone.setText(Phone);
        address.setText(Address);
        block.setText(Block);
        state.setText(State);
        district.setText(District);


    }



}
