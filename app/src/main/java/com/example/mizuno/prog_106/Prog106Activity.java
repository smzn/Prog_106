package com.example.mizuno.prog_106;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Prog106Activity extends AppCompatActivity implements Runnable{

    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog106);

        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg;
                dlg = new AlertDialog.Builder(Prog106Activity.this);
                dlg.setTitle("メッセージ");
                dlg.setMessage("アラートダイアログ");
                dlg.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"トーストです。",Toast.LENGTH_LONG);
                toast.show();
            }
        });




        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog = new ProgressDialog(Prog106Activity.this);
                mProgressDialog.setTitle("Progress Dialog");
                mProgressDialog.setMessage("しばらくお待ちください");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                mProgressDialog.show();
                Thread thread = new Thread(Prog106Activity.this);
                thread.start();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.co.jp"));
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Prog106Activity.this, Sub106Activity.class);
                startActivity(intent1);

            }
        });

    }

    @Override
    public void run() {
        try{
            mProgressDialog.setMax(5);
            for(int i = 1; i <=5; i++){
                mProgressDialog.setProgress(i);
                Thread.sleep(1*1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        mProgressDialog.dismiss();
    }
}
