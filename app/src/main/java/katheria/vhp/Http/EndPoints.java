package katheria.vhp.Http;

import android.os.Looper;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

/**
 * Created by shekh on 30-Jan-17.
 */

public class EndPoints {


    public static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    public static AsyncHttpClient syncHttpClient = new SyncHttpClient();

    private static AsyncHttpClient getClient() {
        if (Looper.myLooper() == null) {
            return syncHttpClient;
        } else {
            return asyncHttpClient;
        }

    }

    public static void getDistrictList(RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        getClient().post(Config.URL_GET_CITY_NAME, requestParams, asyncHttpResponseHandler);
    }
    public static void checkUniquePhone(RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        getClient().post(Config.URL_CHECK_UNIQUE_PHONE, requestParams, asyncHttpResponseHandler);
    }
    public static void  checkEmail (RequestParams requestParams,AsyncHttpResponseHandler asyncHttpResponseHandler){
        getClient().post(Config.URL_CHECK_EMAIL, requestParams, asyncHttpResponseHandler);
    }
    public static void  register (RequestParams requestParams,AsyncHttpResponseHandler asyncHttpResponseHandler){
        getClient().post(Config.URL_REGISTER, requestParams, asyncHttpResponseHandler);
    }




}

