package com.weprogram.chandankumar.switchit;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class MainActivity extends AppCompatActivity {
    Integer mode=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changemode();
        //fab button click
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest("REFRESH");
                Snackbar.make(view, "Refreshing switches. Please wait", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        RadioButton wifibutton=(RadioButton)findViewById(R.id.wifimode);
        wifibutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mode=1;
                changemode();
            }
        });
        RadioButton irbutton=(RadioButton)findViewById(R.id.irmode);
        irbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mode=2;
                changemode();
            }
        });


        //switches
        final Switch swi1=(Switch)findViewById(R.id.switch1);
        final Switch swi2=(Switch)findViewById(R.id.switch2);
        final Switch swi3=(Switch)findViewById(R.id.switch3);
        final Switch swi4=(Switch)findViewById(R.id.switch4);

        swi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swi1.isChecked()){
                    sendRequest("SWI1_ON");
                    Toast.makeText(getBaseContext(),"Request sent ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    sendRequest("SWI1_OFF");
                    Toast.makeText(getBaseContext(),"Request sent OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
        swi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swi2.isChecked()){
                    sendRequest("SWI2_ON");
                    Toast.makeText(getBaseContext(),"Request sent ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    sendRequest("SWI2_OFF");
                    Toast.makeText(getBaseContext(),"Request sent OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
        swi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swi3.isChecked()){
                    sendRequest("SWI3_ON");
                    Toast.makeText(getBaseContext(),"Request sent ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    sendRequest("SWI3_OFF");
                    Toast.makeText(getBaseContext(),"Request sent OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
        swi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swi4.isChecked()){
                    sendRequest("SWI4_ON");
                    Toast.makeText(getBaseContext(),"Request sent ON",Toast.LENGTH_SHORT).show();
                }
                else{
                    sendRequest("SWI3_OFF");
                    Toast.makeText(getBaseContext(),"Request sent OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void changemode(){
        if(mode==1){
            RadioButton wifimode=(RadioButton)findViewById(R.id.wifimode);
            wifimode.setChecked(true);
            RadioButton irmode=(RadioButton)findViewById(R.id.irmode);
            irmode.setChecked(false);
        }
        else{
            RadioButton irmode=(RadioButton)findViewById(R.id.irmode);
            irmode.setChecked(true);
            RadioButton wifimode=(RadioButton)findViewById(R.id.wifimode);
            wifimode.setChecked(false);
        }
     }

     public void sendRequest(String swi){
         String data=null;
         RequestQueue queue = Volley.newRequestQueue(this);
         String url ="http://192.168.4.1/"+swi;

         StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         Toast.makeText(getBaseContext(),"Response is: "+ response.substring(0,10),Toast.LENGTH_LONG).show();
                     }
                 }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 Toast.makeText(getBaseContext(),"Connection failed",Toast.LENGTH_SHORT).show();
             }
         });
         queue.add(stringRequest);


     }





}




