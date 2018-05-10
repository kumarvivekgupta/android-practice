package com.example.vivek.rainanimation;

import com.github.jinatonic.confetti.CommonConfetti;
import com.github.jinatonic.confetti.ConfettiManager;

/**
 * Created by Vivek on 4/5/2018.
 */

public class RainFallingActivity extends RainActivity {


    @Override
    protected ConfettiManager generateOnce() {
        return CommonConfetti.rainingConfetti(container, colors)
                .oneShot();
    }

    @Override
    protected ConfettiManager generateStream() {
        return CommonConfetti.rainingConfetti(container, colors)
                .stream(5000);
    }

    @Override
    protected ConfettiManager generateInfinite() {
        return CommonConfetti.rainingConfetti(container, colors)
                .infinite();
    }
}

