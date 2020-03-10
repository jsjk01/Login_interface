package com.example.Skype_DEMO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
    private EditText edit1,edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.loginbtn);
        btn2 = (Button) findViewById(R.id.exitbtn);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edit1.getText().toString();
                String passwd = edit2.getText().toString();
                if(username.equals("admin") && passwd.equals("666666")){
                    edit1.setText("");
                    edit2.setText("");
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                    edit1.setText("");
                    edit2.setText("");
                }

            }
        });

        btn2.setOnClickListener(new ButtonListener());


/*
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"程序即将退出",Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                },2000);
            }
        });
*/

    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View V){
            Toast.makeText(getApplicationContext(),"程序即将退出",Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            },2000);
        }
    }
}
