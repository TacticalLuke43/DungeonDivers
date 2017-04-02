package com.example.rommo_000.dungeondivers;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdventureTop extends Fragment implements SensorEventListener{

    TextView adventureTopNameView;
    TextView stepsAdventure;
    TextView money;
    TextView classAdventure;
    ImageView coin;
    adventureActivity2 activity2;
    Player player;
    ArrayList<String> playerInfo;
    int moneyOwned;
    int pedometerTotal;

    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;
    MediaPlayer mediaPlayer;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.adventure_top, container, false);
        adventureTopNameView = (TextView) view.findViewById(R.id.adventureTopName);
        stepsAdventure = (TextView) view.findViewById(R.id.stepsAdventure);
        money = (TextView) view.findViewById(R.id.money);
        coin = (ImageView) view.findViewById(R.id.coin);
        classAdventure = (TextView) view.findViewById(R.id.classAdventure);


        activity2 = (adventureActivity2) getActivity();
        //moneyOwned = 0;


        coin.setBackgroundResource(R.drawable.coin_anim);
        AnimationDrawable frameAnimation = (AnimationDrawable) coin.getBackground();
        frameAnimation.start();





        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String name = activity2.getPlayerName();
        adventureTopNameView.setText(name);
        moneyOwned = activity2.getGold();
        //playerInfo = activity2.getPlayerInfo();
        player = activity2.getPlayer();
        classAdventure.setText(player.getJustClass());

        money.setText(" " + moneyOwned + " ");

        //Pedometer
        pedometerTotal = activity2.getStepsTaken();
        stepsAdventure.setText("Steps: " + pedometerTotal);
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        //mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        //sound effects
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.coin2);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        float[] values = sensorEvent.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            pedometerTotal++;
            stepsAdventure.setText("Steps: " + pedometerTotal);

            //  testSteps.setText("Step Counter Detected : " + value);
            if(value % 10 == 0)
            {
                mediaPlayer.start();
                moneyOwned++;

                money.setText(" " + moneyOwned + " ");


            }
            Log.e("step counter detected" , "" + value);

        } //else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // For test only. Only allowed value is 1.0 i.e. for step taken
            // testSteps.setText("Step Detector Detected : " + value);
            //testSteps.setText("Steps: " + value);
           // Log.e("step Detector detected" , "" + value);
        //}
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onPause() {
        super.onPause();
        String allData = player.getAllCharInfo() +"\n" + pedometerTotal + "\n" + moneyOwned;
        player.saveData(allData);

    }

    public void onResume() {

        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,

                SensorManager.SENSOR_DELAY_FASTEST);

    }

    public void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
        String allData = player.getAllCharInfo() +"\n" + pedometerTotal + "\n" + moneyOwned;
        player.saveData(allData);
    }


}
