package com.etrack.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Typeface;
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
import android.widget.Toolbar;

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

import java.util.ArrayList;

public class Matching extends AppCompatActivity implements OnInitListener {
    static final String[] a = {"aeroplane", "ant", "alligator", "apple"};
    static final String alphaSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String[] animalBabyImages = {"zebra_baby", "tiger_baby", "sheep_baby", "alligator_baby", "hen_baby", "bird_baby", "deer_baby", "lion_baby", "goat_baby", "horse_baby", "elephant_baby", "duck_baby", "rat_baby", "cow_baby", "bear_baby", "cat_baby", "dog_baby", "swan_baby", "pig_baby", "donkey_baby", "jaguar_baby", "rabbit_baby", "kangaroo_baby"};
    static final String[] animalImages = {"zebra_p", "tiger_p", "sheep_p", "alligator_p", "hen_p", "bird_p", "deer_p", "lion_p", "goat_p", "horse_p", "elephant_p", "duck_p", "rat_p", "cow_p", "bear_p", "cat_p", "dog_p", "swan_p", "pig_p", "donkey_p", "jaguar_p", "rabbit_p", "kangaroo_p"};
    static final String[] b = {"ball", "banjo", "basket", "bat", "bee", "butterfly"};
    static final String[] c = {"cat", "cycle", "cap", "car", "cow", "cone"};
    static final String[] d = {"dog", "drum", "doll", "dolphin"};
    static final String[] e = {"elephant", "escalator"};
    static final String[] f = {"fish", "frog", "fan"};
    static final String[] g = {"guava", "guitar", "goat", "gun"};
    static final String[] h = {"horse", "hen", "house", "harp"};
    static final String[] i = {"inkpot", "igloo"};
    static final String[] j = {"jug", "joker"};
    static final String[] k = {"kite", "knife"};
    static final String[] l = {"lion", "lizard"};
    static final String[] m = {"monkey", "microphone", "mirror"};
    static final String[] n = {"nest", "nurse"};
    static final String[] o = {"owl", "orange"};
    static final String[] p = {"parrot", "piano", "peacock", "pengion", "pencile"};
    static final String[] q = {"queen"};
    static final String[] r = {"rat", "rain", "rainbow"};
    static final String[] randomImages = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap", "aq", "ar", "as", "at", "au", "av", "aw", "ax", "ay", "az", "ba", "bb"};
    static final String[] s = {"sun", "sexophone", "ship"};
    static final String[] shapeWithColor = {"triangle", "cone", "cresent", "cube", "cuboid", "curve", "cylinder", "diamond", "heart", "hexagon", "leftarrow", "rightarrow", "ligtning", "line", "octagon", "ovel", "pentagon", "pyramid", "rectangle", "roundedrectangle", "semicircle", "sphere", "square", "starfive", "starsixpoint", "arrowdown", "arrowup"};
    static final String smallAlphaSet = "abcdefghijklmnopqrstuvwxyz";
    static final String[] t = {"tiger", "trumpet", "table", "triangle"};
    static final String[] u = {"umbrella", "uniform"};
    static final String[] v = {"van", "violin"};
    static final String[] w = {"watch", "watermelon", "whale"};
    static final String[] x = {"xmas", "xylophone"};
    static final String[] y = {"yak", "yoyo", "yacht"};
    static final String[] z = {"zebra", "zip", "zebra_p"};
    int SET_SIZE_REQUIRED = 5;
    int adCount;
    String appType;
    List<Integer> arrList;
    public HashMap<String, String[]> arrObjectsMap;
    Set<Integer> arrSet;
    private TextView choice1;
    private TextView choice2;
    private TextView choice3;
    private TextView choice4;
    private TextView choice5;
    public int[] colorCode = {R.color.color1, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7};
    public int colorCount = 0;
    private LinearLayout dragLay1;
    private LinearLayout dragLay2;
    private LinearLayout dragLay3;
    private LinearLayout dragLay4;
    private LinearLayout dragLay5;
    private LinearLayout dropLay1;
    private LinearLayout dropLay2;
    private LinearLayout dropLay3;
    private LinearLayout dropLay4;
    private LinearLayout dropLay5;
    ImageView imageView;
    MediaPlayer mpFail;
    MediaPlayer mpSuccess;
    private TextView option1;
    private TextView option2;
    private TextView option3;
    private TextView option4;
    private TextView option5;
    int resultCount = 1;
    TextToSpeech tts;

    private class ChoiceDragListener implements OnDragListener {
        private ChoiceDragListener() {
        }

        public boolean onDrag(View v, DragEvent event) {
            String dragedString;
            switch (event.getAction()) {
                case 3:
                    try {
                        TextView dropTarget = (TextView) v;
                        TextView dropped = (TextView) ((View) event.getLocalState());
                        String str = "";
                        if (Matching.this.appType.equals("alphaToAlpha")) {
                            dragedString = dropTarget.getTag().toString().toLowerCase();
                        } else if (Matching.this.appType.equals("shapeToshape") || Matching.this.appType.equals("animalAndBaby") || Matching.this.appType.equals("matchImages")) {
                            dragedString = dropTarget.getTag().toString();
                        } else {
                            dragedString = dropTarget.getTag().toString();
                        }
                        if (!Matching.this.appType.equalsIgnoreCase("shapeToshape") && !Matching.this.appType.equals("animalAndBaby") && !Matching.this.appType.equals("matchImages")) {
                            if (dragedString.charAt(0) == dropped.getTag().toString().toLowerCase().charAt(0)) {
                                if (!Matching.this.appType.equals("alphaToAlpha")) {
                                    Matching.this.colorCount++;
                                    ((View) dropTarget.getParent()).setBackgroundColor(Matching.this.getResources().getColor(Matching.this.colorCode[Matching.this.colorCount]));
                                    ((View) dropped.getParent()).setBackgroundColor(Matching.this.getResources().getColor(Matching.this.colorCode[Matching.this.colorCount]));
                                    dropTarget.setOnDragListener(null);
                                    dropped.setOnDragListener(null);
                                    Matching.this.mpSuccess.start();
                                    Matching.this.resultCount++;
                                    Toast.makeText(Matching.this, new StringBuilder(String.valueOf(dropped.getTag().toString())).append(" For ").append(dragedString).toString(), Toast.LENGTH_LONG).show();
                                    Matching.this.tts.speak(new StringBuilder(String.valueOf(dropped.getTag().toString())).append(" For ").append(dragedString).toString(), 0, null);
                                    break;
                                } else {
                                    Matching.this.colorCount++;
                                    ((View) dropTarget.getParent()).setBackgroundColor(Matching.this.getResources().getColor(Matching.this.colorCode[Matching.this.colorCount]));
                                    ((View) dropped.getParent()).setBackgroundColor(Matching.this.getResources().getColor(Matching.this.colorCode[Matching.this.colorCount]));
                                    dropTarget.setOnDragListener(null);
                                    dropped.setOnDragListener(null);
                                    Matching.this.mpSuccess.start();
                                    Matching.this.resultCount++;
                                    break;
                                }
                            } else {
                                Matching.this.mpFail.start();
                                Toast.makeText(Matching.this, "Wrong! " + dropped.getTag().toString() + " is not " + dragedString, Toast.LENGTH_LONG).show();
                                Matching.this.tts.speak("Wrong", 0, null);
                                break;
                            }
                        } else {
                            String dragChar2 = dropped.getTag().toString().toLowerCase();
                            if (!Matching.this.appType.equals("shapeToshape")) {
                                if (!Matching.this.appType.equals("matchImages")) {
                                    if (Matching.this.appType.equals("animalAndBaby")) {
                                        if (dragedString.split("_")[0].equals(String.valueOf(dragChar2.split("_")[0]))) {
                                            Matching.this.colorCount++;
                                            ((View) dropTarget.getParent()).setBackgroundColor(Matching.this.getResources().getColor(Matching.this.colorCode[Matching.this.colorCount]));
                                            ((View) dropped.getParent()).setBackgroundColor(Matching.this.getResources().getColor(Matching.this.colorCode[Matching.this.colorCount]));
                                            dropTarget.setOnDragListener(null);
                                            dropped.setOnDragListener(null);
                                            Matching.this.mpSuccess.start();
                                            Matching.this.resultCount++;
                                            break;
                                        } else {
                                            Matching.this.tts.speak("Wrong its not a " + dragChar2.split("_")[0] + " baby", 0, null);
                                            Matching.this.mpFail.start();
                                            break;
                                        }
                                    }
                                } else if (dragedString.split("_")[0].equals(String.valueOf(dragChar2.split("_")[0]))) {
                                    dropTarget.setBackgroundResource(Matching.this.getResources().getIdentifier(dragChar2.split("_")[0] + "_c", "drawable", Matching.this.getPackageName()));
                                    dropTarget.setOnDragListener(null);
                                    dropped.setOnDragListener(null);
                                    Matching.this.tts.speak("Correct", 0, null);
                                    Matching.this.mpSuccess.start();
                                    Matching.this.resultCount++;
                                    break;
                                } else {
                                    Matching.this.tts.speak("Wrong its a " + dragedString.substring(0, dragedString.length() - 2), 0, null);
                                    Matching.this.mpFail.start();
                                    break;
                                }
                            } else if (dragedString.equals(new StringBuilder(String.valueOf(dragChar2)).append("_b").toString())) {
                                dropTarget.setBackgroundResource(Matching.this.getResources().getIdentifier(dragChar2, "drawable", Matching.this.getPackageName()));
                                dropTarget.setOnDragListener(null);
                                dropped.setOnDragListener(null);
                                Matching.this.tts.speak("Correct its a " + dragChar2, 0, null);
                                Matching.this.mpSuccess.start();
                                Matching.this.resultCount++;
                                break;
                            } else {
                                Matching.this.tts.speak("Wrong its a " + dragedString.substring(0, dragedString.length() - 2), 0, null);
                                Matching.this.mpFail.start();
                                break;
                            }
                        }
                    } catch (Exception e) {
                        break;
                    }
                    break;
            }
            if (Matching.this.resultCount == 6) {
                Matching.this.showRatingDialogBox();
                Matching.this.resultCount = 1;
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
        this.arrObjectsMap = new HashMap<>();
        this.arrSet = new HashSet();
        this.arrList = new ArrayList();
        this.tts = new TextToSpeech(this, this);
        this.appType = "";
        this.mpSuccess = MediaPlayer.create(this,R.raw.applause2);
        this.mpFail = MediaPlayer.create(this, R.raw.fail);
       if (this.appType.equals("alphaToAlpha")) {
            setContentView((int) R.layout.activity_matching);
            setTitle("Match the following");
       }
        else if (this.appType.equals("shapeToshape")) {
            setContentView((int) R.layout.activity_shape_matching);
            setTitle("Match the following");
        } else if (this.appType.equals("animalAndBaby")) {
            setContentView((int) R.layout.activity_shape_matching);
            setTitle("Identify animals baby");
        } else if (this.appType.equals("matchImages")) {
            setContentView((int) R.layout.activity_shape_matching);
            setTitle("Match the images");
        } else {
            setContentView((int) R.layout.activity_matching);
            setTitle("Drag the alphabets to its image");
        }
       // setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.option5 = (TextView) findViewById(R.id.dragImg5);
        this.option1.setOnTouchListener(new ChoiceTouchListener());
        this.option2.setOnTouchListener(new ChoiceTouchListener());
        this.option3.setOnTouchListener(new ChoiceTouchListener());
        this.option4.setOnTouchListener(new ChoiceTouchListener());
        this.option5.setOnTouchListener(new ChoiceTouchListener());
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.choice5 = (TextView) findViewById(R.id.dropImg5);
        this.choice1.setOnDragListener(new ChoiceDragListener());
        this.choice2.setOnDragListener(new ChoiceDragListener());
        this.choice3.setOnDragListener(new ChoiceDragListener());
        this.choice4.setOnDragListener(new ChoiceDragListener());
        this.choice5.setOnDragListener(new ChoiceDragListener());
   if (this.appType.equals("alphaToAlpha")) {
            makeUIAlphaToAlpha();
        }
     else if (this.appType.equals("shapeToshape")) {
            makeUIShapeToShape("shapeToshape", shapeWithColor.length);
        } else if (this.appType.equals("animalAndBaby")) {
            makeUIShapeToShape("animalAndBaby", animalBabyImages.length);
        } else if (this.appType.equals("matchImages")) {
            makeUIShapeToShape("matchImages", randomImages.length);
        } else {
            makeUI();
        }
    }

    public boolean onTouch(View v2) {
        this.tts.speak(((LinearLayout) v2).getTag().toString(), 0, null);
        return true;
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

    public void makeUIAlphaToAlpha() {
        uniqueNumber(25);
        this.arrList.addAll(this.arrSet);
        List<Integer> unsortedList = new ArrayList<>(this.arrList);
        Collections.sort(this.arrList);
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.option5 = (TextView) findViewById(R.id.dragImg5);
        this.option1.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(0)).intValue()) + "_s"), "drawable", getPackageName()));
        this.option2.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(1)).intValue())) + "_s", "drawable", getPackageName()));
        this.option3.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(2)).intValue())) + "_s", "drawable", getPackageName()));
        this.option4.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(3)).intValue())) + "_s", "drawable", getPackageName()));
        this.option5.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(4)).intValue())) + "_s", "drawable", getPackageName()));
        this.option1.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(0)).intValue())));
        this.option2.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(1)).intValue())));
        this.option3.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(2)).intValue())));
        this.option4.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(3)).intValue())));
        this.option5.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(4)).intValue())));
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.choice5 = (TextView) findViewById(R.id.dropImg5);
        this.choice1.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(0)).intValue())), "drawable", getPackageName()));
        this.choice2.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(1)).intValue())), "drawable", getPackageName()));
        this.choice3.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(2)).intValue())), "drawable", getPackageName()));
        this.choice4.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(3)).intValue())), "drawable", getPackageName()));
        this.choice5.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(4)).intValue())), "drawable", getPackageName()));
        this.choice1.setTag(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(0)).intValue())));
        this.choice2.setTag(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(1)).intValue())));
        this.choice3.setTag(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(2)).intValue())));
        this.choice4.setTag(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(3)).intValue())));
        this.choice5.setTag(String.valueOf(smallAlphaSet.charAt(((Integer) unsortedList.get(4)).intValue())));
        this.dropLay1 = (LinearLayout) findViewById(R.id.dropLayout1);
        this.dropLay1.setTag("");
        this.dropLay2 = (LinearLayout) findViewById(R.id.dropLayout2);
        this.dropLay2.setTag("");
        this.dropLay3 = (LinearLayout) findViewById(R.id.dropLayout3);
        this.dropLay3.setTag("");
        this.dropLay4 = (LinearLayout) findViewById(R.id.dropLayout4);
        this.dropLay4.setTag("");
        this.dropLay5 = (LinearLayout) findViewById(R.id.dropLayout5);
        this.dropLay5.setTag("");
    }

    public void makeUI() {
        uniqueNumber(25);
        createObjectMap();
        this.arrList.addAll(this.arrSet);
        List<Integer> unsortedList = new ArrayList<>(this.arrList);
        Collections.sort(this.arrList);
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.option5 = (TextView) findViewById(R.id.dragImg5);
        this.option1.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(0)).intValue())), "drawable", getPackageName()));
        this.option2.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(1)).intValue())), "drawable", getPackageName()));
        this.option3.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(2)).intValue())), "drawable", getPackageName()));
        this.option4.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(3)).intValue())), "drawable", getPackageName()));
        this.option5.setBackgroundResource(getResources().getIdentifier(String.valueOf(smallAlphaSet.charAt(((Integer) this.arrList.get(4)).intValue())), "drawable", getPackageName()));
        this.option1.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(0)).intValue())));
        this.option2.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(1)).intValue())));
        this.option3.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(2)).intValue())));
        this.option4.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(3)).intValue())));
        this.option5.setTag(String.valueOf(alphaSet.charAt(((Integer) this.arrList.get(4)).intValue())));
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.choice5 = (TextView) findViewById(R.id.dropImg5);
        String imgToShow1 = getImageToDisplay(((Integer) unsortedList.get(0)).intValue());
        String imgToShow2 = getImageToDisplay(((Integer) unsortedList.get(1)).intValue());
        String imgToShow3 = getImageToDisplay(((Integer) unsortedList.get(2)).intValue());
        String imgToShow4 = getImageToDisplay(((Integer) unsortedList.get(3)).intValue());
        String imgToShow5 = getImageToDisplay(((Integer) unsortedList.get(4)).intValue());
        this.choice1.setTag(imgToShow1);
        this.choice2.setTag(imgToShow2);
        this.choice3.setTag(imgToShow3);
        this.choice4.setTag(imgToShow4);
        this.choice5.setTag(imgToShow5);
        this.choice1.setBackgroundResource(getResources().getIdentifier(imgToShow1, "drawable", getPackageName()));
        this.choice2.setBackgroundResource(getResources().getIdentifier(imgToShow2, "drawable", getPackageName()));
        this.choice3.setBackgroundResource(getResources().getIdentifier(imgToShow3, "drawable", getPackageName()));
        this.choice4.setBackgroundResource(getResources().getIdentifier(imgToShow4, "drawable", getPackageName()));
        this.choice5.setBackgroundResource(getResources().getIdentifier(imgToShow5, "drawable", getPackageName()));
        this.dropLay1 = (LinearLayout) findViewById(R.id.dropLayout1);
        this.dropLay1.setTag(imgToShow1);
        this.dropLay2 = (LinearLayout) findViewById(R.id.dropLayout2);
        this.dropLay2.setTag(imgToShow2);
        this.dropLay3 = (LinearLayout) findViewById(R.id.dropLayout3);
        this.dropLay3.setTag(imgToShow3);
        this.dropLay4 = (LinearLayout) findViewById(R.id.dropLayout4);
        this.dropLay4.setTag(imgToShow4);
        this.dropLay5 = (LinearLayout) findViewById(R.id.dropLayout5);
        this.dropLay5.setTag(imgToShow5);
    }

    public String getImageToDisplay(int selNumber) {
        String[] imgArr = (String[]) this.arrObjectsMap.get(String.valueOf(alphaSet.charAt(selNumber)).toLowerCase());
        return imgArr[getRandomImageNumber(imgArr)];
    }

    public int getRandonNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public int getRandomImageNumber(String[] arr) {
        return getRandonNumber(0, arr.length - 1);
    }

    public String getShapeImageToDisplay(int selNumber, String appType2) {
        if (appType2.equalsIgnoreCase("animalAndBaby")) {
            return animalImages[selNumber];
        }
        if (appType2.equalsIgnoreCase("matchImages")) {
            return randomImages[selNumber] + "_c";
        }
        return shapeWithColor[selNumber];
    }

    public String getShapeBlankImageToDisplay(int selNumber, String appType2) {
        if (appType2.equalsIgnoreCase("animalAndBaby")) {
            return new StringBuilder(String.valueOf(animalBabyImages[selNumber])).toString();
        }
        if (appType2.equalsIgnoreCase("matchImages")) {
            return new StringBuilder(randomImages[selNumber] + "_b").toString();
        }
        return new StringBuilder(String.valueOf(shapeWithColor[selNumber])).append("_b").toString();
    }

    public void createObjectMap() {
        this.arrObjectsMap.put("a", a);
        this.arrObjectsMap.put("b", b);
        this.arrObjectsMap.put("c", c);
        this.arrObjectsMap.put("d", d);
        this.arrObjectsMap.put("e", e);
        this.arrObjectsMap.put("f", f);
        this.arrObjectsMap.put("g", g);
        this.arrObjectsMap.put("h", h);
        this.arrObjectsMap.put("i", i);
        this.arrObjectsMap.put("j", j);
        this.arrObjectsMap.put("k", k);
        this.arrObjectsMap.put("l", l);
        this.arrObjectsMap.put("m", m);
        this.arrObjectsMap.put("n", n);
        this.arrObjectsMap.put("o", o);
        this.arrObjectsMap.put("p", p);
        this.arrObjectsMap.put("q", q);
        this.arrObjectsMap.put("r", r);
        this.arrObjectsMap.put("s", s);
        this.arrObjectsMap.put("t", t);
        this.arrObjectsMap.put("u", u);
        this.arrObjectsMap.put("v", v);
        this.arrObjectsMap.put("w", w);
        this.arrObjectsMap.put("x", x);
        this.arrObjectsMap.put("y", y);
        this.arrObjectsMap.put("z", z);
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
        this.option5 = (TextView) findViewById(R.id.dragImg5);
        String imgToShow1 = getShapeImageToDisplay(((Integer) this.arrList.get(0)).intValue(), appType2);
        String imgToShow2 = getShapeImageToDisplay(((Integer) this.arrList.get(1)).intValue(), appType2);
        String imgToShow3 = getShapeImageToDisplay(((Integer) this.arrList.get(2)).intValue(), appType2);
        String imgToShow4 = getShapeImageToDisplay(((Integer) this.arrList.get(3)).intValue(), appType2);
        String imgToShow5 = getShapeImageToDisplay(((Integer) this.arrList.get(4)).intValue(), appType2);
        this.option1.setTag(imgToShow1);
        this.option2.setTag(imgToShow2);
        this.option3.setTag(imgToShow3);
        this.option4.setTag(imgToShow4);
        this.option5.setTag(imgToShow5);
        this.option1.setBackgroundResource(getResources().getIdentifier(imgToShow1, "drawable", getPackageName()));
        this.option2.setBackgroundResource(getResources().getIdentifier(imgToShow2, "drawable", getPackageName()));
        this.option3.setBackgroundResource(getResources().getIdentifier(imgToShow3, "drawable", getPackageName()));
        this.option4.setBackgroundResource(getResources().getIdentifier(imgToShow4, "drawable", getPackageName()));
        this.option5.setBackgroundResource(getResources().getIdentifier(imgToShow5, "drawable", getPackageName()));
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.choice5 = (TextView) findViewById(R.id.dropImg5);
        String imgToShow12 = getShapeBlankImageToDisplay(((Integer) unsortedList.get(0)).intValue(), appType2);
        String imgToShow22 = getShapeBlankImageToDisplay(((Integer) unsortedList.get(1)).intValue(), appType2);
        String imgToShow32 = getShapeBlankImageToDisplay(((Integer) unsortedList.get(2)).intValue(), appType2);
        String imgToShow42 = getShapeBlankImageToDisplay(((Integer) unsortedList.get(3)).intValue(), appType2);
        String imgToShow52 = getShapeBlankImageToDisplay(((Integer) unsortedList.get(4)).intValue(), appType2);
        this.choice1.setTag(imgToShow12);
        this.choice2.setTag(imgToShow22);
        this.choice3.setTag(imgToShow32);
        this.choice4.setTag(imgToShow42);
        this.choice5.setTag(imgToShow52);
        this.choice1.setBackgroundResource(getResources().getIdentifier(imgToShow12, "drawable", getPackageName()));
        this.choice2.setBackgroundResource(getResources().getIdentifier(imgToShow22, "drawable", getPackageName()));
        this.choice3.setBackgroundResource(getResources().getIdentifier(imgToShow32, "drawable", getPackageName()));
        this.choice4.setBackgroundResource(getResources().getIdentifier(imgToShow42, "drawable", getPackageName()));
        this.choice5.setBackgroundResource(getResources().getIdentifier(imgToShow52, "drawable", getPackageName()));
        this.dropLay1 = (LinearLayout) findViewById(R.id.dropLayout1);
        this.dropLay1.setTag(imgToShow12);
        this.dropLay2 = (LinearLayout) findViewById(R.id.dropLayout2);
        this.dropLay2.setTag(imgToShow22);
        this.dropLay3 = (LinearLayout) findViewById(R.id.dropLayout3);
        this.dropLay3.setTag(imgToShow32);
        this.dropLay4 = (LinearLayout) findViewById(R.id.dropLayout4);
        this.dropLay4.setTag(imgToShow42);
        this.dropLay5 = (LinearLayout) findViewById(R.id.dropLayout5);
        this.dropLay5.setTag(imgToShow52);
    }

    public void reset(View view) {
        this.option1.setVisibility(View.VISIBLE);
        this.option2.setVisibility(View.VISIBLE);
        this.option3.setVisibility(View.VISIBLE);
        this.choice1.setText("A for ");
        this.choice2.setText("O for ");
        this.choice3.setText("B for ");
        this.choice1.setTag(null);
        this.choice2.setTag(null);
        this.choice3.setTag(null);
        this.choice1.setTypeface(Typeface.DEFAULT);
        this.choice2.setTypeface(Typeface.DEFAULT);
        this.choice3.setTypeface(Typeface.DEFAULT);
        this.choice1.setOnDragListener(new ChoiceDragListener());
        this.choice2.setOnDragListener(new ChoiceDragListener());
        this.choice3.setOnDragListener(new ChoiceDragListener());
    }

    public void clickNext() {
        this.arrSet = new HashSet();
        this.arrList = new ArrayList();
        resetView();
        if (this.appType.equals("alphaToAlpha")) {
            makeUIAlphaToAlpha();
        } else if (this.appType.equals("shapeToshape")) {
            makeUIShapeToShape("shapeToshape", shapeWithColor.length);
        } else if (this.appType.equals("animalAndBaby")) {
            makeUIShapeToShape("animalAndBaby", animalBabyImages.length);
        } else if (this.appType.equals("matchImages")) {
            makeUIShapeToShape("matchImages", randomImages.length);
        } else {
            makeUI();
        }
    }

    public void resetView() {
        this.colorCount = 0;
        this.choice1 = (TextView) findViewById(R.id.dropImg1);
        this.choice2 = (TextView) findViewById(R.id.dropImg2);
        this.choice3 = (TextView) findViewById(R.id.dropImg3);
        this.choice4 = (TextView) findViewById(R.id.dropImg4);
        this.choice5 = (TextView) findViewById(R.id.dropImg5);
        if (this.appType.equals("alphaToAlpha")) {
            this.choice1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.choice2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.choice3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.choice4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.choice5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        } else if (!this.appType.equals("shapeToshape")) {
            this.choice1.setText("");
            this.choice2.setText("");
            this.choice3.setText("");
            this.choice4.setText("");
            this.choice5.setText("");
        }
        this.option1 = (TextView) findViewById(R.id.dragImg1);
        this.option2 = (TextView) findViewById(R.id.dragImg2);
        this.option3 = (TextView) findViewById(R.id.dragImg3);
        this.option4 = (TextView) findViewById(R.id.dragImg4);
        this.option5 = (TextView) findViewById(R.id.dragImg5);
        if (this.appType.equals("shapeToshape") || this.appType.equals("matchImages")) {
            this.option1.setOnTouchListener(new ChoiceTouchListener());
            this.option2.setOnTouchListener(new ChoiceTouchListener());
            this.option3.setOnTouchListener(new ChoiceTouchListener());
            this.option4.setOnTouchListener(new ChoiceTouchListener());
            this.option5.setOnTouchListener(new ChoiceTouchListener());
            this.choice1.setOnDragListener(new ChoiceDragListener());
            this.choice2.setOnDragListener(new ChoiceDragListener());
            this.choice3.setOnDragListener(new ChoiceDragListener());
            this.choice4.setOnDragListener(new ChoiceDragListener());
            this.choice5.setOnDragListener(new ChoiceDragListener());
            return;
        }
        this.option1.setOnTouchListener(new ChoiceTouchListener());
        this.option2.setOnTouchListener(new ChoiceTouchListener());
        this.option3.setOnTouchListener(new ChoiceTouchListener());
        this.option4.setOnTouchListener(new ChoiceTouchListener());
        this.option5.setOnTouchListener(new ChoiceTouchListener());
        this.choice1.setOnDragListener(new ChoiceDragListener());
        this.choice2.setOnDragListener(new ChoiceDragListener());
        this.choice3.setOnDragListener(new ChoiceDragListener());
        this.choice4.setOnDragListener(new ChoiceDragListener());
        this.choice5.setOnDragListener(new ChoiceDragListener());
        this.option1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.option5.setTextColor(ViewCompat.MEASURED_STATE_MASK);
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
        this.dropLay5 = (LinearLayout) findViewById(R.id.dropLayout5);
        this.dropLay5.setBackgroundColor(-1);
        this.dropLay5.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
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
        this.dragLay5 = (LinearLayout) findViewById(R.id.dragLayout5);
        this.dragLay5.setBackgroundColor(-1);
        this.dragLay5.setBackgroundDrawable(getResources().getDrawable(R.drawable.curve_shape));
    }

    public void showRatingDialogBox() {
    /*    final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.resultdialog);
        ImageView imageView2 = (ImageView) dialog.findViewById(R.id.resImage);
        ((TextView) dialog.findViewById(R.id.txtResult)).setText("Excellent.. Want to continue ?");

        Button dialogButtonYes = (Button) dialog.findViewById(R.id.button3);
        ((Button) dialog.findViewById(R.id.button2)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Matching.this.finish();
                dialog.dismiss();
            }
        });
        dialogButtonYes.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                Matching.this.clickNext();
            }
        });
        dialog.show();*/
    Toast.makeText(getApplicationContext(),   "Excellent.. Want to continue ?" , Toast.LENGTH_SHORT).show();
    }

    public void speakTheChoiceImageValue(View v2) {
        this.tts.speak(((TextView) v2).getTag().toString(), 0, null);
    }

    public void speakTheOptionImageValue(View v2) {
        String str;
        TextView txtView = (TextView) v2;
        String str2 = "";
        if (this.appType.equals("animalAndBaby")) {
            str = "its a " + txtView.getTag().toString().split("_")[0] + " baby";
        } else if (this.appType.equals("shapeToshape")) {
            str = txtView.getTag().toString().split("_")[0];
        } else {
            str = txtView.getTag().toString();
        }
        this.tts.setSpeechRate(1.0f);
        this.tts.speak(str, 0, null);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
