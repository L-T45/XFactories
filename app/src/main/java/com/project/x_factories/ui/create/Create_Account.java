package com.project.x_factories.ui.create;

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
import com.google.firebase.auth.FirebaseUser;
import com.project.x_factories.R;
import com.project.x_factories.ui.accueil.AccueilActivity;
import com.project.x_factories.ui.login.LoginActivity;

public class Create_Account extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        final Button loginButton2 = findViewById(R.id.ok);
        final EditText usernameEditText2 = findViewById(R.id.EMail);
        final EditText passwordEditText2 = findViewById(R.id.MDP);
        final EditText passwordEditText3 = findViewById(R.id.CMDP);

        loginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call2(usernameEditText2.getText().toString(),
                        passwordEditText2.getText().toString(),
                        passwordEditText3.getText().toString());

            }
        });
    }
    public void call2(String email2, String password2, String password3){
        if (password2.equals(password3)){
    mAuth.createUserWithEmailAndPassword(email2, password2)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign up success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success");
                    Toast.makeText(Create_Account.this, "Votre compte à bien été créé",
                            Toast.LENGTH_SHORT).show();

                } else {
                    // If sign up fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(Create_Account.this, "Echec de la création du compte",
                            Toast.LENGTH_SHORT).show();
                }
            }

            // ...

    });
}}}
