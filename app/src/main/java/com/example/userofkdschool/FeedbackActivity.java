package com.example.userofkdschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {
private Button send,cancle;
private EditText name,massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        send=findViewById(R.id.sendFeedback);
        cancle=findViewById(R.id.cancleFeedback);
        name= findViewById(R.id.userNameForFeedback);
        massage= findViewById(R.id.commentForFeedback);

        send.setOnClickListener(this);
        cancle.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


            String name1 = name.getText().toString();
            String message= massage.getText().toString();

        if (name1.isEmpty()){
            name.setError("Required");
            name.requestFocus();
        }else if (message.isEmpty()){
            massage.setError("Required");
            massage.requestFocus();

        }

            else if (v.getId()==R.id.sendFeedback){
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"mehedihasan1998mlmo@gmail.com"}) ;
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name1+"\nMessage : "+message);
                startActivity(Intent.createChooser(intent,"Feedback with"));

            }else if (v.getId()==R.id.cancleFeedback){
                name.setText("");
                massage.setText("");

                startActivity(new Intent(this,UserHomeActivity.class));
                finish();

            }else {
            Toast.makeText(this, "Please check Name and Message field again!", Toast.LENGTH_LONG).show();
        }

    }
}