package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class NeighbourDetailsActivity extends AppCompatActivity {
    TextView userName1 ;
    TextView userName2 ;
    TextView userAdress ;
    TextView userNumber ;
    TextView userFacebook ;
    TextView getAboutMe ;
    private  int val = 0 ;

    ImageView image ;
    ImageButton imageButton2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.windows2);
        getIntent().getIntExtra("age",0);
        Intent intents = getIntent();
        Neighbour user = (Neighbour)intents.getSerializableExtra("user");
         // user.getName() ;
        // id.nameUser
        // id.adresse
        // id.phoneNumber
        // id.facebook
        userName1 = findViewById(R.id.userName1) ;
        userName2  = findViewById(R.id.userName2) ;
        userAdress  = findViewById(R.id.userAdress) ;
        userNumber  = findViewById(R.id.userNumber) ;
        userFacebook  = findViewById(R.id.userFacebook) ;
        getAboutMe  = findViewById(R.id.getAboutMe);

        imageButton2  = findViewById(R.id.imageButton2) ;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            boolean valeur =    DI.getNeighbourApiService().getfavoritNeighbours().contains(user);

            if(valeur==false)
            {
                DI.getNeighbourApiService().addFavorit(user);
                //ic_star_black_24dp.
            }
            else
            {
                DI.getNeighbourApiService().deletFavorit(user);
            }
            }
        });

       // DI.getNeighbourApiService().addFavorit(user);
        // onclick favorit

        userName1.setText(user.getName());
        userName2.setText(user.getName());
        userAdress.setText(user.getAddress());
        userNumber.setText(user.getPhoneNumber());
        userFacebook.setText("https://www.facebook.com/"+user.getName());
        getAboutMe.setText(user.getAboutMe());
        //textView2  = findViewById(R.id.textView2) ;
       // textView1.setText(user.getName());
       // textView2.setText(user.getAboutMe());
        image = findViewById(R.id.picture_user);
        Glide.with(this)
                .load(user.getAvatarUrl())
                .into(image);
    }
}
