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

public class SignInActivity extends AppCompatActivity {
    EditText SignInId,password;
    Button SignInBtn,transitionBtn;
    FirebaseAuth mAuth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_sign_in);
        SignInId = findViewById(R.id.SignInEmailId);
        password = findViewById(R.id.SignInPassword);
        SignInBtn = findViewById(R.id.SignInButton);
        transitionBtn = findViewById(R.id.SignInToLoginInBtn);
        mAuth = FirebaseAuth.getInstance();

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        transitionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTransitionBtnClick(v);
            }
        });
    }
    private void onSignInBtnClick(View view,EditText SignInIdView,EditText passwordView,FirebaseAuth mAuth){
        String SignInId =  SignInIdView.getText().toString();
        String password = passwordView.getText().toString();

        mAuth.createUserWithEmailAndPassword(SignInId,password).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d("SignInActivity","User Successfully signedIn In");
                            Toast.makeText(SignInActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                            Intent n = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(n);
                        }
                        else {
                            Log.w("SignInActivity",task.getException());
                            Toast.makeText(SignInActivity.this, "User not Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onTransitionBtnClick(View view){
        Intent n = new Intent(this,LoginActivity.class);
        startActivity(n);
    }
}