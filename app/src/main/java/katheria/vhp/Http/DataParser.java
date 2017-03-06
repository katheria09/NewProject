package katheria.vhp.Http;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import katheria.vhp.Fragment.ProfileFragment;
import katheria.vhp.Model.Model_userDetails;


/**
 * Created by shekh on 30-Jan-17.
 */

public class DataParser {
    String email;
    private static ArrayList<Model_userDetails> arrayList;
    Model_userDetails modalIUserDetails;



    public void parseDistrictList(Context context, JSONObject jsonObject,Spinner spndistrict) {

        ArrayList<String> district = new ArrayList<>();
        district.add("--Select district (select state first)--");
        try {
            {

                JSONArray message = jsonObject.getJSONArray("data");

                boolean success = false;

                for (int i = 0; i < message.length(); i++) {

                    JSONObject temp = message.getJSONObject(i);
                    if (i == 0) {
                        if (temp.getString("success").equals("1")) {
                            success = true;
                        }
                    }
                    if (i != 0 && success) {
                        int a=i;
                        String city = temp.getString("city_name");
                        district.add(city);

                    }
                }
                spndistrict.setAdapter(new ArrayAdapter<String>(context
                        , android.R.layout.simple_list_item_1,district));

                return ;
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }




    }

    public int praseUniqueEmail(Context context, JSONObject jsonObject) {
        try {
            {

                JSONArray message = jsonObject.getJSONArray("data");

                for (int i = 0; i < message.length(); i++) {

                    JSONObject temp = message.getJSONObject(i);
                    if (temp.getString("success").equals("1")) {
                        return 1;
                    } else {
                        return 0;
                    }

                }

                return 0;
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


        return 0;
    }
    public int parseCheckEmail(Context context, JSONObject jsonObject) {
        try {
            {

                JSONArray message = jsonObject.getJSONArray("data");

                for (int i = 0; i < message.length(); i++) {

                    JSONObject temp = message.getJSONObject(i);
                    if (temp.getString("success").equals("1")) {
                        return 1;
                    } else {
                        return 0;
                    }

                }

                return 0;
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


        return 0;
    }

    public int parseRegister(Context context, JSONObject jsonObject) {
        try {
            {

                JSONArray message = jsonObject.getJSONArray("data");
                boolean success = false;

                for (int i = 0; i < message.length(); i++) {

                    JSONObject temp = message.getJSONObject(i);
                    if (i == 0) {
                        if (temp.getString("success").equals("1")) {
                            email = temp.getString("email");

                            return 1;
                        }
                    }
                    if (i != 0 && success) {


                    }
                }

                return 0;
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


        return 0;
    }

    public void getUserDetails(Context context, JSONObject jsonObject) {
        Log.e("ABC1", "data parser");

        arrayList = new ArrayList<>();

        try {
            {

                JSONArray message = jsonObject.getJSONArray("data");

                boolean success = false;

                for (int i = 0; i < message.length(); i++) {

                    JSONObject temp = message.getJSONObject(i);
                    if (i == 0) {
                        if (temp.getString("success").equals("1")) {
                            success = true;
                        }
                    }
                    if (i != 0 && success) {
                        modalIUserDetails = new Model_userDetails();
                        modalIUserDetails.email = temp.getString("email");
                        modalIUserDetails.name = temp.getString("name");
                        modalIUserDetails.mobile = temp.getString("mobile");
                        modalIUserDetails.state = temp.getString("state");
                        modalIUserDetails.district = temp.getString("district");
                        modalIUserDetails.block = temp.getString("block");
                        modalIUserDetails.village = temp.getString("village");
                        modalIUserDetails.designation = temp.getString("designation");


                        arrayList.add(modalIUserDetails);

                        Log.e("abc", arrayList.get(0).email);
                    }

                }


            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


    }
    public static ArrayList<Model_userDetails> getArrayList()
    {
        return arrayList;
    }


}
