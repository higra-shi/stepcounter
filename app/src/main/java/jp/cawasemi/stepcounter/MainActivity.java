package jp.cawasemi.stepcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStepCounter = (Button) findViewById(R.id.btnStepCounter);
        btnStepCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StepCounterActivity.class);
                startActivity(intent);
            }
        });

        Button btnAccelerometer = (Button) findViewById(R.id.btnAccelerometer);
        btnAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccelerometerActivity.class);
                startActivity(intent);
            }
        });
    }

}
