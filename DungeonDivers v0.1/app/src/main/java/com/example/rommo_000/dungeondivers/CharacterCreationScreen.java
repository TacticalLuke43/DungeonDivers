package com.example.rommo_000.dungeondivers;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CharacterCreationScreen extends AppCompatActivity implements SensorEventListener{

    ImageView charAnimation;


    private TextView testSteps;

    private SensorManager mSensorManager;

    private Sensor mStepCounterSensor;

    private Sensor mStepDetectorSensor;

    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testSteps = (TextView) findViewById(R.id.testSteps);
        setContentView(R.layout.activity_character_creation_screen);
        charAnimation = (ImageView)findViewById(R.id.charAnim);
        charAnimation.setBackgroundResource(R.drawable.whm);
        AnimationDrawable frameAnimation = (AnimationDrawable) charAnimation.getBackground();
        frameAnimation.start();



        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.coin2);
        //  mediaPlayer.start();



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        float[] values = sensorEvent.values;
        //values[0] = 0;
        //values[0]++;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

       // Toast.makeText(this, "" + value, Toast.LENGTH_SHORT).show();
        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
          //  testSteps.setText("Step Counter Detected : " + value);
            Log.e("step counter detected" , "" + value);
            if (value  % 10 == 0)
            {
                mediaPlayer.start();
            }

        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // For test only. Only allowed value is 1.0 i.e. for step taken
           // testSteps.setText("Step Detector Detected : " + value);
           // testSteps.setText("Steps: " + value);
           // Log.e("step Detector detected" , "" + value);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    protected void onResume() {

        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,

                SensorManager.SENSOR_DELAY_FASTEST);

    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
    }
}
