package csc310.dungeondivers;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;

public class adventureActivity2 extends AppCompatActivity{

    ArrayList<String> playerInfo;
    public Player player;
    int idIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure2);

        Intent i = getIntent();
        playerInfo = (ArrayList<String>) getIntent().getSerializableExtra("playerInfo");
        player = new Player(playerInfo);
       // Toast.makeText(this, player.getName(),Toast.LENGTH_LONG).show();
        String img = player.getMapImageInfo();
        idIcon = getResources().getIdentifier(img, "drawable", getPackageName());
    }

    public String getPlayerName()
    {
        return player.getName();
    }
    public String getCharIcon() {return player.getRaceClassGender();}
    public int getIconId() {return idIcon;}
    public int getStepsTaken() {return player.getStepsTaken();}
    public int getGold() {return player.getGold();}
    public Player getPlayer() {return player;}

    public ArrayList<String> getPlayerInfo() {
        return playerInfo;
    }
}
