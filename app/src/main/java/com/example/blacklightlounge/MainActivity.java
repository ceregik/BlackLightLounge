package com.example.blacklightlounge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser User;

    private FirebaseFirestore db1;

    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        db1 = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
        User = mAuth.getCurrentUser();

        enter=findViewById(R.id.btn_enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TEST CODE
                db1.collection("users")
                        .document("+79778085487")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {
                                        enter.setText("OK");


                                    }else {
                                        enter.setText("NO");
                                        /*Map<String, Object> user = new HashMap<>();
                                        user.put("points", 0);
                                        db.collection("users")
                                                .document(User.getPhoneNumber())
                                                .set(user)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {

                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Log.d(TAG, "DocumentSnapshot successfully written!");
                                                        Intent homeIntent = new Intent(lohin_step2.this, end_qr.class);
                                                        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                        startActivity(homeIntent);
                                                        finish();

                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Log.w(TAG, "Error writing document", e);
                                                        enter.setText("Error");
                                                    }
                                                });
                                        Intent next = new Intent(lohin_step2.this, MainActivity.class);
                                        startActivity(next);*/
                                    }
                                }else {
                                    enter.setText("re");}
                            }
                        })
                        .addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {
                                enter.setText("cancel");
                            }
                        });
                /*if(User == null) { WORK CODE
                    Intent homeIntent = new Intent(MainActivity.this, lohin_step1.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(homeIntent);
                    finish();
                } else{
                    Intent homeIntent = new Intent(MainActivity.this, end_qr.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(homeIntent);
                    finish();
                }*/
            }
        });
    }
}
