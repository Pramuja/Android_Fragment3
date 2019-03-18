package id.sch.smktelkom_mlg.www.fragment3;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton buttonAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAlarm = (ImageButton) findViewById(R.id.btnJam);

        buttonAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarm("Waktu Pulang", 16, 30);
            }

            private void createAlarm(String massage, int hour, int minutes) {
                Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, massage);
                alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);

                if (alarmIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(alarmIntent);
            }
        });
    }
}
