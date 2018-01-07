package com.jjapp.ns.logintest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.Map;


/**
 * Created by Jordan on 11/27/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "";
    private Map<String, String> params;

    public RegisterRequest(int ein, String firstName, String lastName, String racfID, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
    }

}
