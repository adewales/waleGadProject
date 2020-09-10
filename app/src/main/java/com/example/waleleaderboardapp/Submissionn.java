package com.example.waleleaderboardapp;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Submissionn extends AppCompatActivity {
    Button btn_bck;
    Button btnSubmit;
    EditText first_name;
    EditText last_name;
    EditText git;
    EditText email;
    Dialog notSuccessDialog;
    Dialog question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_submissionn);

        notSuccessDialog= new Dialog(this);
        question= new Dialog(this);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.setContentView(R.layout.layout_submit_question);
                question.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Button yesBtn=question.findViewById(R.id.yes);
                question.show();
            }
            public void onclick(){
                notSuccessDialog.setContentView(R.layout.not_successful);
                notSuccessDialog.show();
            }


        });
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Submissionn.this, LeaderBoard.class);
                startActivity(intent);
            }
        });

        btn_bck = findViewById(R.id.btn_bck);
        first_name=findViewById(R.id.first_name);
        last_name= findViewById(R.id.last_name);
        email= findViewById(R.id.email);
        git= findViewById(R.id.git);

    }
}

