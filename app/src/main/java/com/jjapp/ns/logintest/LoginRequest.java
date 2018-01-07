package com.jjapp.ns.logintest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Jordan on 11/27/2017.
 */

public class LoginRequest extends StringRequest {

    /*
    The IP Address 10.0.2.2 is used instead of localhost because the emulator runs its own
    localhost. The aformentioned IP Address is used to access your machine's local webserver
    if you are testing with a local web server.
     */
    private static final String LOGIN_REQUEST_URL = "http://10.0.2.2/testConnection/verifyLogin.php";
    private Map<String, String> params;

    //A class that takes the user input and passes it to the Volley constructor
    public LoginRequest(String racfID, String password, Response.Listener<String> listener){

        /*
        The passed information is posted to the URL where it is verified and a jsonOjbect response
        (for the listener) is returned.
         */
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("racfID", racfID);
        params.put("password", password);
    }

    public Map<String, String> getParams() {
        return params;
    }

}