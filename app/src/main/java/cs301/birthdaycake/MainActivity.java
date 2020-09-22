package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView newCakeView = (CakeView) findViewById(R.id.cakeview);

        CakeController newCakeController = new CakeController(newCakeView);

        // Set the On Touch Listener
        newCakeView.setOnTouchListener(newCakeController);

        Button blowOut = (Button) findViewById(R.id.blowOutButton);
        blowOut.setOnClickListener(newCakeController);

        Switch candleSwitch = (Switch) findViewById(R.id.switchCandles);
        candleSwitch.setOnCheckedChangeListener(newCakeController);

        SeekBar numCandlesSeek = (SeekBar) findViewById(R.id.seekBar);
        numCandlesSeek.setOnSeekBarChangeListener(newCakeController);

        //implementing the onTouch command
        newCakeView.setOnTouchListener(newCakeController);

    }

    public void goodbye(View button) {
        Log.i("button", "Goodbye");
    }
}
