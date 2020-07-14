package com.nextgenlabs.myapplication.ui.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nextgenlabs.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    EditText loginId,password;
    Button loginBtn,transitionBtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginId = findViewById(R.id.loginEmailId);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginButton);
        transitionBtn = findViewById(R.id.loginToSignInBtn);
        mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginBtnClick(v,loginId,password,mAuth);
            }
        });

        transitionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTransitionBtnClick(v);
            }
        });

    }

    private void onLoginBtnClick(View view,EditText loginIdView,EditText passwordView,FirebaseAuth mAuth){
        String loginId =  loginIdView.getText().toString();
        String password = passwordView.getText().toString();

        mAuth.signInWithEmailAndPassword(loginId,password).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent n = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(n);
                            Log.d("LoginActivity","User Successfully Logged In");
                            Toast.makeText(LoginActivity.this,"LoginSuccessful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Log.w("LoginActivity",task.getException());
                            Toast.makeText(LoginActivity.this,"Login UnSuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onTransitionBtnClick(View view){
        Intent n = new Intent(this,SignInActivity.class);
        startActivity(n);
    }
}