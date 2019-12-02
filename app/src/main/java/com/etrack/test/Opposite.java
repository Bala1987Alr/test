package com.etrack.test;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class Opposite extends AppCompatActivity implements OnInitListener {
    static final String[] fillTheBlankAnswer = {"a", "a", "e", "n", "l", "p", "k", "t", "r", "e", "e", "n", "c", "t", "e", "o", "r", "p", "b", "i", "o", "g", "d", "h", "c", "e", "z", "i", "o", "o", "l", "e", "r", "n", "h", "b", "r", "d", "u", "o", "y", "h", "o", "k", "g", "o", "g", "b", "c", "a", "l"};
    static final String[] fillTheBlankQuestion = {"B_g", "F_n", "H_n", "He_", "Ba_l", "_en", "S_ip", "Si_", "Ca_", "Tr_e", "T_a", "De_", "_at", "Ra_", "P_t", "D_g", "_at", "Cu_", "Ba_y", "G_rl", "B_y", "Ba_", "Bir_", "S_irt", "I_e", "Fe_t", "La_y", "B_g", "G_at", "H_t", "Co_d", "Lov_", "Sca_f", "Ki_g", "W_y", "Bar_er", "D_ink", "Sa_", "P_sh", "C_w", "Pla_", "S_ip", "Sh_p", "_ite", "Sin_", "L_w", "Hi_h", "_ad", "Ba_k", "St_nd", "Pul_"};
    static final String[] optionOne = {"Man", "Day", "Woman", "Black", "White", "Hot", "Cold", "Up", "Down", "Soft", "Hard", "Strong", "Weak", "Sit", "Stand", "Cry", "Laugh", "Dry", "Wet", "Fat", "Thin", "Big", "Small", "Full", "Half", "Empty", "Full", "Happy", "Sad", "One", "Many", "Sour", "Sweet", "Push", "Pull", "Tall", "Short", "Rough", "Smooth", "Dirty", "Clean", "Closed", "Open", "In", "Out", "Fresh", "Stale", "Old", "Young", "High", "Low", "Long", "Fast", "Old", "Last", "Heavy", "Front", "True", "Left", "Light", "Dark", "Pass", "Fail", "Near", "Far", "Go", "Come", "Right", "Wrong", "Off", "Good", "Quiet", "Easy", "Rough", "Narrow", "Under", "Hungry", "Awake", "Alive", "Begin", "Start", "Deep", "Cool", "Loose", "Early", "Poor", "Few", "Teach", "Thick", "Inside", "North", "East", "Winter", "Lost", "Work", "Kind", "Boring", "Healthy", "Ill", "Dangerous", "Alone", "Run"};
    static final String[] optionTwo = {"Woman", "Night", "Man", "White", "Black", "Cold", "Hot", "Down", "Up", "Hard", "Soft", "Weak", "Strong", "Stand", "Sit", "Laugh", "Cry", "Wet", "Dry", "Thin", "Fat", "Small", "Big", "Half", "Full", "Full", "Empty", "Sad", "Happy", "Many", "One", "Sweet", "Sour", "Pull", "Push", "Short", "Tall", "Smooth", "Rough", "Clean", "Dirty", "Open", "Closed", "Out", "In", "Stale", "Fresh", "Young", "Old", "Low", "High", "Short", "Slow", "New", "First", "Light", "Back", "False", "Right", "Dark", "Light", "Fail", "Pass", "Far", "Near", "Come", "Go", "Wrong", "Right", "On", "Bad", "Loud", "Hard", "Smooth", "Wide", "Over", "Full", "Asleep", "Dead", "End", "Finish", "Shallow", "Warm", "Tight", "Late", "Rich", "Many", "Learn", "Thin", "Outside", "South", "West", "Summer", "Found", "Play", "Mean", "Fun", "Sick", "Well", "Safe", "Together", "Walk"};
    int SET_SIZE_REQUIRED = 4;
    int adCount;
    String appType;
    List<Integer> arrList;
    public HashMap<String, String[]> arrObjectsMap;
    Set<Integer> arrSet;
    private TextView choice1;
    private TextView choice2;
    private TextView choice3;
    private TextView choice4;
    public int[] colorCode = {R.color.color1, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7};
    public int colorCount = 0;
    private LinearLayout dragLay1;
    private LinearLayout dragLay2;
    private LinearLayout dragLay3;
    private LinearLayout dragLay4;
    private LinearLayout dropLay1;
    private LinearLayout dropLay2;
    private LinearLayout dropLay3;
    private LinearLayout dropLay4;
    MediaPlayer mpFail;
    MediaPlayer mpSuccess;
    private TextView option1;
    private TextView option2;
    private TextView option3;
    private TextView option4;
    int resultCount = 1;
    TextToSpeech tts;

    private class ChoiceDragListener implements OnDragListener {
        private ChoiceDragListener() {
        }

        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case 3:
                    TextView dropTarget = (TextView) v;
                    TextView dropped = (TextView) ((View) event.getLocalState());
                    String str = "";
                    String dragedString = dropTarget.getTag().toString().toLowerCase();
                    if (!dragedString.equalsIgnoreCase(dropped.getTag().toString().toLowerCase())) {
                        Opposite.this.mpFail.start();
                        Opposite.this.tts.speak("Wrong", 0, null);
                        break;
                    } else {
                        Opposite.this.mpSuccess.start();
                        Opposite.this.colorCount++;
                        if (Opposite.this.appType.equalsIgnoreCase("fillInTheBlank")) {
                            String tmpText = dropTarget.getText().toString().replace("_", dragedString);
                            dropTarget.setText(dropTarget.getText().toString() + "\n(" + tmpText + ")");
                            Opposite.this.tts.speak("Correct! Its a " + tmpText, 0, null);
                        }
                        try {
                            if (Opposite.this.colorCount >= Opposite.this.colorCode.length) {
                                Opposite.this.colorCount = 1;
                            }
                            ((View) dropTarget.getParent()).setBackgroundColor(Opposite.this.getResources().getColor(Opposite.this.colorCode[Opposite.this.colorCount]));
                            ((View) dropped.getParent()).setBackgroundColor(Opposite.this.getResources().getColor(Opposite.this.colorCode[Opposite.this.colorCount]));
                        } catch (Exception e) {
                        }
                        Opposite.this.resultCount++;
                        break;
                    }
            }
            if (Opposite.this.resultCount == 5) {
                Opposite.this.showRatingDialogBox();
                Opposite.this.resultCount = 1;
            }
            return true;
        }
    }

    private final class ChoiceTouchListener implements OnTouchListener {
        private ChoiceTouchListener() {
        }

        @SuppressLint({"NewApi"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            view.startDrag(ClipData.newPlainText("", ""), new DragShadowBuilder(view), view, 0);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_opposite);
       // setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.arrSet = new HashSet();
        this.arrList = new ArrayList();
        this.tts = new TextToSpeech(this, this);
        this.mpSuccess = MediaPlayer.create(this, R.raw.applause2);
        this.mpFail = MediaPlayer.create(this, R.raw.fail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.option1.setOnTouchListener(new ChoiceTouchListener());
        this.option2.setOnTouchListener(new ChoiceTouchListener());
        this.option3.setOnTouchListener(new ChoiceTouchListener());
        this.option4.setOnTouchListener(new ChoiceTouchListener());
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.choice1.setOnDragListener(new ChoiceDragListener());
        this.choice2.setOnDragListener(new ChoiceDragListener());
        this.choice3.setOnDragListener(new ChoiceDragListener());
        this.choice4.setOnDragListener(new ChoiceDragListener());
        this.appType = getIntent().getExtras().getString("appType");
        if (this.appType.equals("opposite")) {
            setTitle("Match opposite");
            makeUIShapeToShape("opposite", optionOne.length);
        } else if (this.appType.equals("fillInTheBlank")) {
            setTitle("Fill In The Blank");
            makeUIShapeToShape("fillInTheBlank", fillTheBlankQuestion.length);
        }
    }

    public void onInit(int status) {
        if (status == 0) {
            this.tts.setLanguage(Locale.ENGLISH);
            return;
        }
        this.tts = null;
        Toast.makeText(this, "Failed to initialize TTS engine.", Toast.LENGTH_SHORT).show();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.tts != null) {
            this.tts.stop();
            this.tts.shutdown();
        }
        super.onDestroy();
    }

    public void uniqueNumber(int upto) {
        Random random = new Random();
        this.arrSet = new HashSet(this.SET_SIZE_REQUIRED);
        while (this.arrSet.size() < this.SET_SIZE_REQUIRED) {
            do {
            } while (!this.arrSet.add(Integer.valueOf(random.nextInt(upto))));
        }
    }

    public void makeUIShapeToShape(String appType2, int arrCount) {
        uniqueNumber(arrCount);
        this.arrList.addAll(this.arrSet);
        List<Integer> unsortedList = new ArrayList<>(this.arrList);
        Collections.sort(this.arrList);
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        if (appType2.equalsIgnoreCase("opposite")) {
            this.option1.setTag(optionOne[((Integer) this.arrList.get(0)).intValue()]);
            this.option2.setTag(optionOne[((Integer) this.arrList.get(1)).intValue()]);
            this.option3.setTag(optionOne[((Integer) this.arrList.get(2)).intValue()]);
            this.option4.setTag(optionOne[((Integer) this.arrList.get(3)).intValue()]);
            this.option1.setText(optionOne[((Integer) this.arrList.get(0)).intValue()]);
            this.option2.setText(optionOne[((Integer) this.arrList.get(1)).intValue()]);
            this.option3.setText(optionOne[((Integer) this.arrList.get(2)).intValue()]);
            this.option4.setText(optionOne[((Integer) this.arrList.get(3)).intValue()]);
            this.choice1.setTag(optionOne[((Integer) unsortedList.get(0)).intValue()]);
            this.choice2.setTag(optionOne[((Integer) unsortedList.get(1)).intValue()]);
            this.choice3.setTag(optionOne[((Integer) unsortedList.get(2)).intValue()]);
            this.choice4.setTag(optionOne[((Integer) unsortedList.get(3)).intValue()]);
            this.choice1.setText(optionTwo[((Integer) unsortedList.get(0)).intValue()]);
            this.choice2.setText(optionTwo[((Integer) unsortedList.get(1)).intValue()]);
            this.choice3.setText(optionTwo[((Integer) unsortedList.get(2)).intValue()]);
            this.choice4.setText(optionTwo[((Integer) unsortedList.get(3)).intValue()]);
        } else {
            this.option1.setTag(fillTheBlankAnswer[((Integer) this.arrList.get(0)).intValue()]);
            this.option2.setTag(fillTheBlankAnswer[((Integer) this.arrList.get(1)).intValue()]);
            this.option3.setTag(fillTheBlankAnswer[((Integer) this.arrList.get(2)).intValue()]);
            this.option4.setTag(fillTheBlankAnswer[((Integer) this.arrList.get(3)).intValue()]);
            this.option1.setText(fillTheBlankAnswer[((Integer) this.arrList.get(0)).intValue()]);
            this.option2.setText(fillTheBlankAnswer[((Integer) this.arrList.get(1)).intValue()]);
            this.option3.setText(fillTheBlankAnswer[((Integer) this.arrList.get(2)).intValue()]);
            this.option4.setText(fillTheBlankAnswer[((Integer) this.arrList.get(3)).intValue()]);
            this.choice1.setTag(fillTheBlankAnswer[((Integer) unsortedList.get(0)).intValue()]);
            this.choice2.setTag(fillTheBlankAnswer[((Integer) unsortedList.get(1)).intValue()]);
            this.choice3.setTag(fillTheBlankAnswer[((Integer) unsortedList.get(2)).intValue()]);
            this.choice4.setTag(fillTheBlankAnswer[((Integer) unsortedList.get(3)).intValue()]);
            this.choice1.setText(fillTheBlankQuestion[((Integer) unsortedList.get(0)).intValue()]);
            this.choice2.setText(fillTheBlankQuestion[((Integer) unsortedList.get(1)).intValue()]);
            this.choice3.setText(fillTheBlankQuestion[((Integer) unsortedList.get(2)).intValue()]);
            this.choice4.setText(fillTheBlankQuestion[((Integer) unsortedList.get(3)).intValue()]);
        }
        this.dropLay1 = (LinearLayout) findViewById(R.id.dropLayout1);
        this.dropLay2 = (LinearLayout) findViewById(R.id.dropLayout2);
        this.dropLay3 = (LinearLayout) findViewById(R.id.dropLayout3);
        this.dropLay4 = (LinearLayout) findViewById(R.id.dropLayout4);
    }

    public String getShapeImageToDisplay(int selNumber, String appType2) {
        return optionOne[selNumber];
    }

    public String getShapeBlankImageToDisplay(int selNumber, String appType2) {
        return new StringBuilder(String.valueOf(optionTwo[selNumber])).toString();
    }

    public void clickNext() {
        this.arrSet = new HashSet();
        this.arrList = new ArrayList();
        resetView();
        if (this.appType.equalsIgnoreCase("opposite")) {
            makeUIShapeToShape("opposite", optionOne.length);
        } else {
            makeUIShapeToShape("fillInTheBlank", fillTheBlankQuestion.length);
        }
    }

    public void resetView() {
        this.colorCount = 0;
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.option1.setOnTouchListener(new ChoiceTouchListener());
        this.option2.setOnTouchListener(new ChoiceTouchListener());
        this.option3.setOnTouchListener(new ChoiceTouchListener());
        this.option4.setOnTouchListener(new ChoiceTouchListener());
        this.choice1.setOnDragListener(new ChoiceDragListener());
        this.choice2.setOnDragListener(new ChoiceDragListener());
        this.choice3.setOnDragListener(new ChoiceDragListener());
        this.choice4.setOnDragListener(new ChoiceDragListener());
        this.option1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.dropLay1 = (LinearLayout) findViewById(R.id.dropLayout1);
        this.dropLay1.setBackgroundColor(-1);
        this.dropLay1.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dropLay2 = (LinearLayout) findViewById(R.id.dropLayout2);
        this.dropLay2.setBackgroundColor(-1);
        this.dropLay2.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dropLay3 = (LinearLayout) findViewById(R.id.dropLayout3);
        this.dropLay3.setBackgroundColor(-1);
        this.dropLay3.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dropLay4 = (LinearLayout) findViewById(R.id.dropLayout4);
        this.dropLay4.setBackgroundColor(-1);
        this.dropLay4.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dragLay1 = (LinearLayout) findViewById(R.id.dragLayout1);
        this.dragLay1.setBackgroundColor(-1);
        this.dragLay1.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dragLay2 = (LinearLayout) findViewById(R.id.dragLayout2);
        this.dragLay2.setBackgroundColor(-1);
        this.dragLay2.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dragLay3 = (LinearLayout) findViewById(R.id.dragLayout3);
        this.dragLay3.setBackgroundColor(-1);
        this.dragLay3.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
        this.dragLay4 = (LinearLayout) findViewById(R.id.dragLayout4);
        this.dragLay4.setBackgroundColor(-1);
        this.dragLay4.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
    }

    public void showRatingDialogBox() {
/*        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.resultdialog);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.resImage);
        ((TextView) dialog.findViewById(R.id.txtResult)).setText("Excellent.. Want to continue ?");
        Button dialogButtonYes = (Button) dialog.findViewById(R.id.button3);
        ((Button) dialog.findViewById(R.id.button2)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Opposite.this.finish();
                dialog.dismiss();
            }
        });
        dialogButtonYes.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                Opposite.this.clickNext();
            }
        });
        dialog.show();*/
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
