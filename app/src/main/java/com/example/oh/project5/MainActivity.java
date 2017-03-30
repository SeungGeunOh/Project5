package com.example.oh.project5;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toast toast;
    Button b1, b2, b3, b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("토스트");
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Toast.makeText(getApplicationContext(), "일반 메세지 창입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                toast = Toast.makeText(getApplicationContext(), "위치 지정 메세지 입니다.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.LEFT | Gravity.TOP, 10, 20);
                toast.show();
                break;
            case R.id.button3:
                v = getLayoutInflater().inflate(R.layout.mytoast,null);
                TextView msg = (TextView)v.findViewById(R.id.textView3);
                msg.setText("레이아웃으로 만든 토스트 창입니다.");

                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,100);
                toast.setView(v);
                toast.show();
                break;
            case R.id.button4:
                Snackbar.make(v, "SnackBar로 보여주는 메세지에요.", Snackbar.LENGTH_SHORT).setAction("확인", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();

                break;
        }
    }

}
