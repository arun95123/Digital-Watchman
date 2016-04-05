package com.example.wayne.dw;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wayne on 01-04-2016.
 */





public class MyService extends Service {


    int threadCon=0;

    @Override
    public void onCreate() {


    }


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {



                for (int i = 0; i < 20; i++) {
                    try {

                        Thread.sleep(6000);


                    } catch (Exception e) {
                    }
                   if(threadCon==0)
                      new poll().execute();
                }


            }
        }).start();



        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Stopped ", Toast.LENGTH_LONG).show();
    }




    private class poll extends AsyncTask<String,String,Boolean>
    {



        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }


        protected Boolean doInBackground(String... args){


            JSONObject jsonobject;
            final JSONParser jParser2 = new JSONParser();
            List<NameValuePair> params2 = new ArrayList<NameValuePair>();
            params2.add(new BasicNameValuePair("pin","vpin"));
            String url = "http://192.168.2.4/get.php";
            jsonobject = jParser2.makeHttpRequest(url, "GET", params2);

            try{

                String message = jsonobject.getString("pinvalue").toString();
                if( message.equals("0")){

                    return false;
                }

                else{
                    return true;
                }


            }catch (Exception e){
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return false;

        }

        protected void onPostExecute(Boolean th){

            if(th != false){

                threadCon=1;
                Intent i=new Intent(getBaseContext(), ImposterImage.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);


            }
            else{
               // threadCon=0;
            }
        }
    }





}
