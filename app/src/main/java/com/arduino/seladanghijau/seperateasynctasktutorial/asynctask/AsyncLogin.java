package com.arduino.seladanghijau.seperateasynctasktutorial.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.arduino.seladanghijau.seperateasynctasktutorial.interfaces.ILogin;

/**
 * Created by seladanghijau on 17/7/2016.
 */
public class AsyncLogin extends AsyncTask<Void, Void, Integer> {
    private ProgressDialog progressDialog;
    private Context context;
    private ILogin iLogin;
    private String username;
    private String password;

    public AsyncLogin(Context context, String username, String password, ILogin iLogin) {
        this.context = context;
        this.username = username;
        this.password = password;
        this.iLogin = iLogin;
    }

    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Please wait...");
        progressDialog.show();
    }

    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        switch(result) {
            case 0:
                iLogin.processFinished("You have logged in " + username);
                break;
            case 1:
                iLogin.processFinished("You cannot log in " + username);
                break;
        }

        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    protected Integer doInBackground(Void... params) {
        if(username.equals(password))
            return 0;
        else
            return 1;
    }
}
