package jp.cawasemi.stepcounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StepCounterActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mStepDetectorSensor;
    private Sensor mStepCounterSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        //センサーマネージャを取得
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //センサマネージャから TYPE_STEP_DETECTOR についての情報を取得する
        mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        //センサマネージャから TYPE_STEP_COUNTER についての情報を取得する
        mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener (this, mStepCounterSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this,mStepDetectorSensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        long timestamp = event.timestamp;
        //TYPE_STEP_COUNTER
        if(sensor.getType() == Sensor.TYPE_STEP_COUNTER){
            // sensor からの値を取得するなどの処理を行う
            Log.d("type_step_counter",String.valueOf(values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("type_step_counter", sensor.getName());
    }
}
