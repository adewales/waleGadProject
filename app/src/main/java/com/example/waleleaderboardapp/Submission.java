package com.example.waleleaderboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Submission extends AppCompatActivity {
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
       setContentView(R.layout.activity_submission);
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
       });

       btn_bck = findViewById(R.id.btn_bck);
       first_name=findViewById(R.id.first_name);
       last_name= findViewById(R.id.last_name);
       email= findViewById(R.id.email);
       git= findViewById(R.id.git);

       btn_bck.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Submission.this, LeaderBoard.class);
               startActivity(intent);
           }
       });

   }

    public void onclick(){
        notSuccessDialog.setContentView(R.layout.not_successful);
        notSuccessDialog.show();
    }
}

