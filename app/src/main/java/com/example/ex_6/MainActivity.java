package com.example.ex_6;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.text.Editable;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    String otp,n1;
    String details;
    Editable s1;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e= (EditText) findViewById(R.id.editText);
        EditText e1= (EditText) findViewById(R.id.editText2);

        Button b1= (Button) findViewById(R.id.button);
        Random rand = new Random();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.setText("");
                e1.setText("");
                b1.setText("Generate Another OTP");
                int n = 6; // Number of threads
                for (i = 0; i < n; i++) {

                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            int rand_int1 = rand.nextInt(10);
                            otp=Integer.toString(rand_int1);
                            s1 = e.getText();
                            n1=Integer.toString(i+1);
                            details= String.valueOf(e1.getText());
                            details=details+"Thread"+n1+": Generated -> "+otp+"\n";
                            e1.setText(details);
                            e.setText(s1+otp);
                        }
                    });
                }
            }
        });


    }
}



