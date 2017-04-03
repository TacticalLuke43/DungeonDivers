package csc310.dungeondivers;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostBattleScreen extends AppCompatActivity {

    ArrayList<String> playerInfo;
    public Player player;
    ImageView charSpriteImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_battle_screen);
        Intent i = getIntent();
        playerInfo = (ArrayList<String>) getIntent().getSerializableExtra("playerInfo");
        player = new Player(playerInfo);
        //update player sprite on screen
        charSpriteImage = (ImageView) findViewById(R.id.charSprite);
        String playerIcon = player.getRaceClassGender();
        charSpriteImage.setBackgroundResource(getResources().getIdentifier(playerIcon, "drawable", getApplicationContext().getPackageName()));
        AnimationDrawable frameAnimation = (AnimationDrawable) charSpriteImage.getBackground();
        frameAnimation.start();
    }

    public void continueButton(View view)
    {
        Intent intent = new Intent(getApplicationContext(), adventureActivity2.class);
        intent.putExtra("playerInfo", playerInfo);
        startActivity(intent);
    }
}
