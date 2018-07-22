package com.reactcustom.callback;

import android.os.AsyncTask;

import java.util.Calendar;

public class LocalCalcTask extends AsyncTask<Void,Void,String> {
    Calendar mCalender = null;
    TaskReponse callBack = null;
    LocalCalcTask(TaskReponse callBack){
        this.callBack = callBack;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCalender = Calendar.getInstance();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getTimeStr(mCalender)+"<-->"+getTimeStr(Calendar.getInstance());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        callBack.reponse(s);
    }

    private String getTimeStr(Calendar c){
        return c.get(Calendar.YEAR)+"_"
                +c.get(Calendar.MONTH)+"_"
                +c.get(Calendar.DAY_OF_MONTH)+"_"
                +c.get(Calendar.HOUR_OF_DAY)+"_"
                +c.get(Calendar.MINUTE)+"_"
                +c.get(Calendar.SECOND);
    }
}
