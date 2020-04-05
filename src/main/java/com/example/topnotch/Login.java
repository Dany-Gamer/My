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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText em,pass;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        em = findViewById(R.id.email_in);
        pass = findViewById(R.id.pass_in);
        tvSignUp = findViewById(R.id.logInAlert);
        btnSignIn = findViewById(R.id.RegisterAccoun);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser  = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null){
                    Toast.makeText(Login.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(Login.this,Renter.class);
                    startActivity(i);

                }

                else{
                    Toast.makeText(Login.this,"Please Log in",Toast.LENGTH_SHORT).show();


                }
            }
        };

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = em.getText().toString().trim();
                String pwd = pass.getText().toString();
                if(email.isEmpty()){
                    em.setError("Please enter email id");
                    em.requestFocus();
                }
                else if(pwd.isEmpty()){
                    pass.setError("Please Enter your password");
                    pass.requestFocus();
                }

                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Login.this,"Fields are Empty!",Toast.LENGTH_SHORT).show();
                }

                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){

                                Toast.makeText(Login.this,"Login Error,Please log in again",Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Intent intToRenter = new Intent(Login.this,Renter.class);
                                startActivity(intToRenter);
                            }
                        }
                    });    }

                else{
                    Toast.makeText(Login.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }


            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent(Login.this, Register.class);
                startActivity(intSignUp);
            }
        });

            }

}
