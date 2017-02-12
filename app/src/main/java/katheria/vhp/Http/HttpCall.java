package katheria.vhp.Http;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import katheria.vhp.Activity.AccoutnActivity;
import katheria.vhp.Model.Model_register;
import katheria.vhp.ShowProgressDialog;



/**
 * Created by shekh on 30-Jan-17.
 */

public class HttpCall {

    int result;
    ShowProgressDialog showProgressDialog;

    private void defineDialog(Context context) {
        showProgressDialog = new ShowProgressDialog(context);
    }

    public void getDistrictList (final Context context, String state, final Spinner spndistrict) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("state", state);
        defineDialog(context);

        EndPoints.getDistrictList(requestParams,new JsonHttpResponseHandler(){




            @Override
            public void onStart() {
                showProgressDialog.show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                showProgressDialog.dismiss();
                Log.d("ABc","onsuccess");

                new DataParser().parseDistrictList(context, response,spndistrict);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Toast.makeText(context, "Please try again later", Toast.LENGTH_SHORT).show();
                showProgressDialog.dismiss();
            }


                }
        );
    }

    public void checkUniquePhone(final Context context, final String phone, final EditText ph, final Button next,
                                 final boolean b, final Model_register model_register) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("phone", phone);

        defineDialog(context);

        EndPoints.checkUniquePhone(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        showProgressDialog.show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        showProgressDialog.dismiss();

                        result = new DataParser().praseUniqueEmail(context, response);
                        if (result == 0 && !ph.getText().toString().contains(" ")) {
                            ph.setError(null);

                            Log.e("not reg","2");
                            new HttpCall().register(context,model_register);

                        } else if (result == 1) {

                            Log.d("Reg","2");
                            ph.setError("User Already Registered");
                        } else if (ph.getText().toString().contains(" ")) {
                            ph.setError("Phone Number should not contain spaces");

                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          Throwable throwable, JSONObject errorResponse) {
                        showProgressDialog.dismiss();
                    }
                }
        );
    }
    public void checkEmail(final Context context, String email,
                              final EditText Email, final Button next) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("email", email);

        EndPoints.checkEmail(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {



                        result = new DataParser().parseCheckEmail(context, response);
                        if (result == 0 && !Email.getText().toString().contains(" ")) {

                            next.setVisibility(View.VISIBLE);
                            Email.setError(null);
                        } else if (result == 1) {
                            next.setVisibility(View.GONE);
                            Email.setError("Email Already Registered");
                        } else if (Email.getText().toString().contains(" ")) {
                            Email.setError("Email should not contain spaces");
                            next.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    }
                }
        );
    }

    public void register(final Context context, final Model_register model_register) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("email", model_register.email);
        requestParams.put("password", model_register.password);
        requestParams.put("phone", model_register.phone);
        requestParams.put("name", model_register.name);
        requestParams.put("state", model_register.state);
        requestParams.put("district", model_register.district);
        requestParams.put("block", model_register.block);
        requestParams.put("village", model_register.address);
        requestParams.put("designation", model_register.designation+" "+model_register.designation2);


        defineDialog(context);

        EndPoints.register(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        showProgressDialog.show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        showProgressDialog.dismiss();

                        result = new DataParser().praseRegister(context,
                                response, false);
                        if (result == 1) {
                            Log.e("ABc","Registered Successfully");


                            //new HttpCall().addNotificationToken(context, new AppPreferences().getToken(context));


                           new HttpCall().getUserDetails(context, new Intent(context, AccoutnActivity.class), model_register.email.toString());
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          Throwable throwable, JSONObject errorResponse) {
                        Log.e("error", errorResponse.toString() + " ");

                        showProgressDialog.dismiss();
                    }

                }
        );

        return;
    }
    public void getUserDetails(final Context context, final Intent intent,
                               String email) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("email", email);

        defineDialog(context);


      /*  EndPoints.getUserDetails(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        //showProgressDialog.show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                        //   showProgressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          Throwable throwable, JSONObject errorResponse) {

                    }
                }
        );*/
    }
}
