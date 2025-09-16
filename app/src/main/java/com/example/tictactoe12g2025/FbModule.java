package com.example.tictactoe12g2025;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FbModule {
    private Context context;
    //private GameActivity gameActivity;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    public FbModule(Context context) {
        this.context = context;


        firebaseDatabase = FirebaseDatabase.getInstance("https://tictactoe12g2025new-default-rtdb.firebaseio.com/");
        reference = firebaseDatabase.getReference("play");
        initFirebaseListener();
    }

    private void initFirebaseListener() {

        setPositionInFirebase(null);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Position position = snapshot.getValue(Position.class);
                if(position != null) // בדיקה שלא קוראים מצומת לא קיים בפיירבייס
                    ((GameActivity)context).setPositionFromFb(position);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void setPositionInFirebase(Position position)
    {
        reference.setValue(position);
    }

}
