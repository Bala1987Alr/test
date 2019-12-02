package com.etrack.test;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainScreenActivity extends AppCompatActivity {



    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private Button mMatchImage,mFillIn;
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);

     mMatchImage =   findViewById(R.id.move_to_match_image);
        mFillIn =    findViewById(R.id.fill_inthe_blank);

        mMatchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Matching.class);
                Bundle bundle = new Bundle();
                bundle.putString("appType", "alphaToObj");
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        mFillIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Opposite.class);
                Bundle bundle = new Bundle();
                bundle.putString("appType", "fillInTheBlank");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

      /*  public void openMatchingAlpha(View v) {
            Intent intent = new Intent(getApplicationContext(), Matching.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "alphaToObj");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatching(View v) {
            Intent intent = new Intent(getApplicationContext(), Matching.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "alphaToAlpha");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchingShape(View v) {
            Intent intent = new Intent(getApplicationContext(), Matching.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "shapeToshape");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchingAnimal(View v) {
            Intent intent = new Intent(getApplicationContext(), Matching.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "animalAndBaby");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchingAddition(View v) {
            Intent intent = new Intent(getApplicationContext(), Matching.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "addition");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchingOpposite(View v) {
            Intent intent = new Intent(getApplicationContext(), Opposite.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "opposite");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchingFillInTheBlanks(View v) {
            Intent intent = new Intent(getApplicationContext(), Opposite.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "fillInTheBlank");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchingEvenOdd(View v) {
            Intent intent = new Intent(getApplicationContext(), EvenOdd.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "evenodd");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openMatchTheImages(View v) {
            Intent intent = new Intent(getApplicationContext(), Matching.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "matchImages");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openTapCorrectLetter(View v) {
            Intent intent = new Intent(getApplicationContext(), FindCorrectLetter.class);
            Bundle bundle = new Bundle();
            bundle.putString("appType", "findCorrectAlpha");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        public void openOddObj(View v) {
            startActivity(new Intent(getApplicationContext(), OddOneOut.class));
        }

        public void openCountSimObject(View v) {
            startActivity(new Intent(getApplicationContext(), CountSimilarImage.class));
        }

        public void openSingularPlural(View v) {
            startActivity(new Intent(getApplicationContext(), SingularPlural.class));
        }
*/
    }


}