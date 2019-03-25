package com.example.dell.chatting;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

public class Profileactivity extends AppCompatActivity {

    TextView email,id,name;
    Button button;
    ImageView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        email=findViewById(R.id.email);
        display=findViewById(R.id.display);
        button=findViewById(R.id.button);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if (acct != null) {
            String personName = acct.getDisplayName();

            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
email.setText(personEmail);
            Picasso.get().load(personPhoto).into(display);
            id.setText("YOUR ID : "+personId);
            name.setText("YOUR NAME : "+personName);

        }

    }

    public void proceed(View view) {
        Intent intent=new Intent(Profileactivity.this,chatscreen.class);
        startActivity(intent);
        finish();
    }
}
