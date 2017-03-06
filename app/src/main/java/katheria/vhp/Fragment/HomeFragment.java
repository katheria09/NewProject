package katheria.vhp.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import katheria.vhp.Activity.NewUserInputActivity;
import katheria.vhp.Activity.SearchUserActivity;
import katheria.vhp.Http.DataParser;
import katheria.vhp.Model.Model_userDetails;
import katheria.vhp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    TextView t_email;
    Button newuser, searchuser;
    private Context context;
    String Email,Name;
    public static DataParser dp;




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        context = getContext();


        init(view);
        dp=new DataParser();
        //Email= dp.getArrayList().get(0).email;

        setDetails();

        return view;


    }

    private void init(View view) {

        t_email = (TextView) view.findViewById(R.id.user_email);
        newuser = (Button) view.findViewById(R.id.newuser);
        searchuser = (Button) view.findViewById(R.id.searchuser);
        newuser.setVisibility(View.VISIBLE);
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewUserInputActivity.class);
                startActivity(intent);
            }
        });
        searchuser.setVisibility(View.VISIBLE);
        searchuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchUserActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setDetails() {
        t_email.setText(Email);
    }

}
