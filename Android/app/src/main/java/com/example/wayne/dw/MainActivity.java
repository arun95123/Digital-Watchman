package com.example.wayne.dw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {

        Intent i=new Intent(getBaseContext(), MyService.class);
        startService(i);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );
        Button bt=(Button)findViewById(R.id.btnCapturePicture);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

    }
}
