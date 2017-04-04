package csc310.dungeondivers;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageView;


import java.util.ArrayList;

public class adventureActivity2 extends AppCompatActivity{

    ArrayList<String> playerInfo;
    public Player player;
    int idIcon;
    AdventureMap adventureMap;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Boolean inMaps;
    Button charInGameInfoButton;
    ImageView charOnMap1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure2);

        Intent i = getIntent();
        playerInfo = (ArrayList<String>) getIntent().getSerializableExtra("playerInfo");
        player = new Player(playerInfo);

        String img = player.getMapImageInfo();
        idIcon = getResources().getIdentifier(img, "drawable", getPackageName());

       // fragmentManager = getFragmentManager();
       // fragmentTransaction = fragmentManager.beginTransaction();

        //Fragment fragment = new AdventureMap();



        //adventureMap = (AdventureMap) fragmentManager.findFragmentById(R.id.fragment3);

        android.app.Fragment newFrag = new android.app.Fragment();

        FragmentTransaction trans = getFragmentManager().beginTransaction();

        trans.replace(R.id.fragment3, newFrag);
        //trans.addToBackStack(null);

// Commit the transaction
        trans.commit();


        // fragment = (AdventureMap) getSupportFragmentManager().findFragmentById(R.id.fragment3);

       // FragmentManager manager = getFragmentManager();
       // FragmentTransaction transaction = manager.beginTransaction();
       // transaction.replace(R.id.gameLayout, fragment);
       // transaction.commit();
        inMaps = true;


        //charInGameInfoButton = (Button) findViewById(R.id.charInfoInGame);
        charOnMap1 = (ImageView) findViewById(R.id.charOnMap1);
        charOnMap1.setBackgroundResource(getResources().getIdentifier(player.getRaceClassGender(), "drawable", getPackageName()));
        AnimationDrawable frameAnimation = (AnimationDrawable) charOnMap1.getBackground();
        frameAnimation.start();

        if(inMaps == true)
        {
            charOnMap1.setVisibility(View.VISIBLE);
        }
        else
        {
            charOnMap1.setVisibility(View.INVISIBLE);
        }

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

    public void changeFragment(View view)
    {
       // Fragment fragment;

       // if(view == findViewById(R.id.socialButton))
       // {
        if(inMaps == true)
        {
            FragmentTransaction t = this.getFragmentManager().beginTransaction();
            AdventureSocialDemo mFrag = new AdventureSocialDemo();

            t.replace(R.id.fragment3, mFrag);
            t.addToBackStack(null);
            t.commit();
            inMaps = false;

            if(inMaps == true)
            {
                charOnMap1.setVisibility(View.VISIBLE);
            }
            else
            {
                charOnMap1.setVisibility(View.INVISIBLE);
            }
        }

    }

    public void goToCharacterInfo(View view)
    {


            if(inMaps == true)
            {
                FragmentTransaction t = this.getFragmentManager().beginTransaction();

                AdventureModeCharInGame frag = new AdventureModeCharInGame();
                t.replace(R.id.fragment3, frag);
               // t.replace(R.id.fragment3, mFrag);
                t.addToBackStack(null);
                t.commit();
                inMaps = false;

                if(inMaps == true)
                {
                    charOnMap1.setVisibility(View.VISIBLE);
                }
                else
                {
                    charOnMap1.setVisibility(View.INVISIBLE);
                }
            }

    }



/*******************************************************************
 charInGameInfoButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
if(inMaps == true)
{
FragmentTransaction t = getFragmentManager().beginTransaction();
// AdventureSocialDemo mFrag = new AdventureSocialDemo();

t.replace(R.id.fragment3, mFrag);
t.addToBackStack(null);
t.commit();
inMaps = false;
}


}
});
***********************************/
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            inMaps = true;
            if(inMaps == true)
            {
                charOnMap1.setVisibility(View.VISIBLE);
            }
            else
            {
                charOnMap1.setVisibility(View.INVISIBLE);
            }
        } else {
            super.onBackPressed();
        }
    }


}

//  fragment = new AdventureSocialDemo;
//  FragmentManager fm = getFragmentManager();
// FragmentTransaction ft = fm.beginTransaction();
// ft.replace(R.id.adventureMap, fragment);


//}
//  {





//FragmentTransaction t = this.getFragmentManager().beginTransaction();
//AdventureSocialDemo mFrag = new AdventureSocialDemo();
//t.replace(R.id.adventureMap, mFrag );
//t.commit();
//  fragment = new AdventureSocialDemo;
//  FragmentManager fm = getFragmentManager();
//  FragmentTransaction ft = fm.beginTransaction();
//  ft.replace(R.id.adventureMap, fragment);
// }