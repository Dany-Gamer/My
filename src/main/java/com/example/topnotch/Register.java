package com.example.topnotch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText emailId,pass;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email_input);
        pass = findViewById(R.id.pass_input);
        tvSignIn = findViewById(R.id.SignUpAlert);
        btnSignUp = findViewById(R.id.RegisterAcc);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString().trim();
                String pwd = pass.getText().toString();
                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()){
                    pass.setError("Please Enter your password");
                    pass.requestFocus();
                }

                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Register.this,"Fields are Empty!",Toast.LENGTH_SHORT).show();
                }

                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Register.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Register.this,"register Unsuccessfull,Please try again!",Toast.LENGTH_SHORT).show();

                            }

                            else{
                                startActivity(new Intent(Register.this,Home.class));
                            }
                        }
                    });
                }

                else{
                    Toast.makeText(Register.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this,Login.class);
                startActivity(i);

            }
        });


    }
}
