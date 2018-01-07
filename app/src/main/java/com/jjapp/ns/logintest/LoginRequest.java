package com.jjapp.ns.logintest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Jordan on 11/27/2017.
 */

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://10.0.2.2/testConnection/verifyLogin.php";
    private Map<String, String> params;

    public LoginRequest(String racfID, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("racfID", racfID);
        params.put("password", password);
    }

    public Map<String, String> getParams() {
        return params;
    }

}