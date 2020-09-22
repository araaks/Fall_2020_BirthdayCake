package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
                                        SeekBar.OnSeekBarChangeListener, View.OnTouchListener{

    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cv) {
        cakeView = cv;
        cakeModel = cv.getCakeModel();
    }

    @Override
    public void onClick(View blowOut) {
        Log.d("blowOutButton","You Clicked Me!");
        this.cakeModel.isCandleLit = !this.cakeModel.isCandleLit;
        cakeView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean hasCandles) {
        this.cakeModel.hasCandles = !this.cakeModel.hasCandles;
        cakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int seekNum, boolean isCakeFrosted) {
        this.cakeModel.numCandles = seekNum;
        cakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Don't care about this method
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Don't care about this method
    }

    // Checkpoint 2 for Lab 4. Merging using git.
    @Override
    public boolean onTouch(View newCakeView, MotionEvent motionEvent) {
        //set coordinates for the balloon touch event
        cakeView.balloonLeft = motionEvent.getX();
        cakeView.balloonTop = motionEvent.getY();
        //set cakeModel's x and y coord to corresponding touch
        cakeModel.xCoord = (int) motionEvent.getX();
        cakeModel.yCoord = (int) motionEvent.getY();
        cakeView.invalidate();
        Log.i("touched","yes");
        return true;
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        //get coords of tap
        float x = event.getX();
        float y = event.getY();
        Log.d("tap", "tap registered at: (" + x + ", " + y + ")");

        //draw checkerboard at coords
        this.cakeModel.xCoord = x;
        this.cakeModel.yCoord = y;
        this.cakeModel.drawCheck = true;
        cakeView.invalidate();
        return false;
    }
}