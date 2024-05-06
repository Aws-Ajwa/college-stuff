package com.star.mrpotatohead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public static final int PARTS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView[] imageViews = new ImageView[PARTS];
        CheckBox[] checkBoxes = new CheckBox[PARTS];

        imageViews[0] = (ImageView) findViewById(R.id.hat);
        imageViews[1] = (ImageView) findViewById(R.id.eyes);
        imageViews[2] = (ImageView) findViewById(R.id.eyebrows);
        imageViews[3] = (ImageView) findViewById(R.id.glasses);
        imageViews[4] = (ImageView) findViewById(R.id.nose);
        imageViews[5] = (ImageView) findViewById(R.id.mouth);
        imageViews[6] = (ImageView) findViewById(R.id.mustache);
        imageViews[7] = (ImageView) findViewById(R.id.ears);
        imageViews[8] = (ImageView) findViewById(R.id.arms);
        imageViews[9] = (ImageView) findViewById(R.id.shoes);

        checkBoxes[0] = (CheckBox) findViewById(R.id.hatCheckBox);
        checkBoxes[1] = (CheckBox) findViewById(R.id.eyesCheckBox);
        checkBoxes[2] = (CheckBox) findViewById(R.id.eyebrowsCheckBox);
        checkBoxes[3] = (CheckBox) findViewById(R.id.glassesCheckBox);
        checkBoxes[4] = (CheckBox) findViewById(R.id.noseCheckBox);
        checkBoxes[5] = (CheckBox) findViewById(R.id.mouthCheckBox);
        checkBoxes[6] = (CheckBox) findViewById(R.id.mustacheCheckBox);
        checkBoxes[7] = (CheckBox) findViewById(R.id.earsCheckBox);
        checkBoxes[8] = (CheckBox) findViewById(R.id.armsCheckBox);
        checkBoxes[9] = (CheckBox) findViewById(R.id.shoesCheckBox);

        for (int i = 0; i < PARTS; i++) {
            final int finalI = i;
            checkBoxes[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        imageViews[finalI].setVisibility(View.VISIBLE);
                    } else {
                        imageViews[finalI].setVisibility(View.INVISIBLE);
                    }

                }
            });
        }

    }

}
