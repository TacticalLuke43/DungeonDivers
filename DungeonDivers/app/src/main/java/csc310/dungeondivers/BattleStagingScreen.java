package csc310.dungeondivers;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.pm.PackageManager;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class BattleStagingScreen extends AppCompatActivity {
    ArrayList<String> playerInfo;
    public Player player;
    ImageView charSpriteImage;
    TextView charNameText;
    TextView charLevelText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_staging_screen);
        Intent i = getIntent();
        playerInfo = (ArrayList<String>) getIntent().getSerializableExtra("playerInfo");
        player = new Player(playerInfo);
        //update player sprite on screen
        charSpriteImage = (ImageView) findViewById(R.id.charSprite);
        String playerIcon = player.getRaceClassGender();
        charSpriteImage.setBackgroundResource(getResources().getIdentifier(playerIcon, "drawable", getApplicationContext().getPackageName()));
        AnimationDrawable frameAnimation = (AnimationDrawable) charSpriteImage.getBackground();
        frameAnimation.start();
        //update player name
        charNameText = (TextView) findViewById(R.id.charName);
        charNameText.setText(player.getName());
        //update player level
        charLevelText = (TextView) findViewById(R.id.charLevel);
        charLevelText.setText(Integer.toString(player.getLevel()));
    }

    public void fightButton(View view)
    {
        Intent intent = new Intent(getApplicationContext(), BattleScreen.class);
        intent.putExtra("playerInfo", playerInfo);
        startActivity(intent);
    }

    public void runButton(View view)
    {
        Intent intent = new Intent(getApplicationContext(), adventureActivity2.class);
        intent.putExtra("playerInfo", playerInfo);
        startActivity(intent);
    }
}
