package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
                                        SeekBar.OnSeekBarChangeListener{

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
}