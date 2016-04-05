package com.example.wayne.dw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wayne on 01-04-2016.
 */
public class ImposterImage extends ActionBarActivity {

    ImageView ii;
    int autho;
    Button apoorva,notapoorva;
    protected void onCreate(Bundle savedInstanceState) {

        Intent i=new Intent(getBaseContext(), MyService.class);
        stopService(i);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.imposter_image);
        ii=(ImageView)findViewById(R.id.ii);
        apoorva=(Button)findViewById(R.id.ap);
        notapoorva=(Button)findViewById(R.id.nap);

        int loader = R.drawable.loader;

        // Imageview to show
        ImageView image = (ImageView) findViewById(R.id.ii);

        // Image url
        String image_url = "http://192.168.2.4/gowtham.jpg";

        // ImageLoader class instance
        ImageLoader imgLoader = new ImageLoader(getApplicationContext());

        // whenever you want to load an image from url
        // call DisplayImage function
        // url - image url to load
        // loader - loader image, will be displayed before getting image
        // image - ImageView
        imgLoader.DisplayImage(image_url, loader, image);
       // new getImage().execute();

        apoorva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autho=1;
                new authorize().execute();
                new closeimage().execute();
            }
        });

        notapoorva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autho=0;
                new authorize().execute();
                new closeimage().execute();
            }
        });}

    private class authorize extends AsyncTask<String,String,Boolean>
    {



        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }


        protected Boolean doInBackground(String... args){


            JSONObject jsonobject;
            final JSONParser jParser2 = new JSONParser();
            List<NameValuePair> params2 = new ArrayList<NameValuePair>();
            if(autho==1){

            params2.add(new BasicNameValuePair("pin","gpin"));
            params2.add(new BasicNameValuePair("value","1"));
            }
            else
            {
                params2.add(new BasicNameValuePair("pin","gpin"));
                params2.add(new BasicNameValuePair("value","3"));

            }
            String url = "http://192.168.2.4/set.php";
            jsonobject = jParser2.makeHttpRequest(url, "GET", params2);

            try{

                String message = jsonobject.getString("success").toString();
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


                Intent i=new Intent(ImposterImage.this, MainActivity.class);
                startActivity(i);


            }
            else{
                // threadCon=0;
            }
        }
    }


    private class closeimage extends AsyncTask<String,String,Boolean>
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
                params2.add(new BasicNameValuePair("value","0"));

            String url = "http://192.168.2.4/set.php";
            jsonobject = jParser2.makeHttpRequest(url, "GET", params2);

            try{

                String message = jsonobject.getString("success").toString();
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





            }
            else{
                // threadCon=0;
            }
        }
    }





















  /*  private class getImage extends AsyncTask<String,String,Bitmap>
    {



        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }


        protected Bitmap doInBackground(String... args){


            JSONObject jsonobject;
            final JSONParser jParser2 = new JSONParser();
            List<NameValuePair> params2 = new ArrayList<NameValuePair>();
            params2.add(new BasicNameValuePair("check","check"));
            String add = "http://192.168.2.3/gowtham.jpg";

            URL url = null;
            Bitmap image = null;
            try {
                url = new URL(add);
                image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return image;


        }

        @Override
        protected void onPostExecute(Bitmap b) {
            super.onPostExecute(b);
            ii.setImageBitmap(b);
        }

    }


*/

}
