package com.example.rommo_000.dungeondivers;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.gesture.Gesture;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.GestureDetector.*;

public class BattleScreen extends AppCompatActivity implements
    OnGestureListener, OnDoubleTapListener{

    ArrayList<String> playerInfo;
    Player monster = new Player(100, 0, 0, 5, 0, 7, 0, 1, "Ghoul", "mm");
    private GestureDetectorCompat GestureDetect;
    public Player player;
    int monsterHP;
    ProgressBar healthBar;
    TextView monsterLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen);
        Intent i = getIntent();
        playerInfo = (ArrayList<String>) getIntent().getSerializableExtra("playerInfo");
        player = new Player(playerInfo);
        monsterHP = monster.getHp();
        GestureDetect = new GestureDetectorCompat(this, this);
        healthBar = (ProgressBar) findViewById(R.id.monsterHealth);
        healthBar.setProgress(monsterHP);
        GestureDetect.setOnDoubleTapListener(this);

        monsterLevel = (TextView) findViewById(R.id.monsterLevel);
        monsterLevel.setText(Integer.toString(monsterHP));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        GestureDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        monsterHP = (monster.getHp()+monster.getDefense()-player.getStrength());
        if(monsterHP>monster.getHp()) //dont let them get healed by weak hits
        {
            monsterHP = monster.getHp();
        }
        monsterLevel.setText(Integer.toString(monsterHP));
        healthBar.setProgress(monsterHP);
        if(monsterHP <= 0)
        {

            Intent intent = new Intent(getApplicationContext(), PostBattleScreen.class);
            intent.putExtra("playerInfo", playerInfo);
            startActivity(intent);
        }
        else
            monster.setHp(monsterHP);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        monsterHP = (monster.getHp()+monster.getResistance()-player.getIntelligence());
        if(monsterHP>monster.getHp()) //dont let them get healed by weak hits
        {
            monsterHP = monster.getHp();
        }
        monsterLevel.setText(Integer.toString(monsterHP));
        healthBar.setProgress(monsterHP);
        if(monsterHP <= 0)
        {
            Intent intent = new Intent(getApplicationContext(), PostBattleScreen.class);
            intent.putExtra("playerInfo", playerInfo);
            startActivity(intent);
        }
        else
            monster.setHp(monsterHP);
        return false;
    }

    //extra touch event types
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }


}
