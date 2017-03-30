package com.example.oh.project5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4;
    AlertDialog.Builder dlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("토스트");
        b1 = (Button)findViewById(R.id.button5);
        b2 = (Button)findViewById(R.id.button6);
        b3 = (Button)findViewById(R.id.button7);
        b4 = (Button)findViewById(R.id.button8);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                dlg = new AlertDialog.Builder(this);
                dlg.setTitle("제목")
                        .setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
            case R.id.button6:
                dlg = new AlertDialog.Builder(this);

                final String data[] = {"치킨", "피자", "짜장", "탕슉"};
                final boolean checked[] = {true, false, true, false};
                dlg.setTitle("먹고싶은 메뉴는?")
                        .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    checked[which] = isChecked;
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
            case R.id.button7:
                v = View.inflate(this, R.layout.example, null);
                final EditText et = (EditText)v.findViewById(R.id.editText3);

                dlg = new AlertDialog.Builder(this);
                dlg.setTitle("먹고싶은 메뉴는?")
                        .setView(v)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), et.getText().toString() + " 입니다", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
            case R.id.button8:
                break;

        }
    }
}
