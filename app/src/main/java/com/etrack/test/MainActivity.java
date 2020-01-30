package com.etrack.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   {

    public TableLayout t1;
    public TableRow tr1;
    public TableRow tr2;
    public TableRow tr3;
    public ImageView i11;
    public ImageButton i21;
    public ImageButton i12;
    public ImageButton i22;
    public ImageButton i31;
    public ImageButton i32;
//    ImageView imageView;
    DrawView draw;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    float downx = 0, downy = 0, upx = 0, upy = 0;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // imageView = (ImageView) this.findViewById(R.id.image);
        t1 = (TableLayout) findViewById(R.id.tableLayout1);
        tr1 = (TableRow) findViewById(R.id.tableRow1);
        tr2 = (TableRow) findViewById(R.id.tableRow2);
        tr3 = (TableRow) findViewById(R.id.tableRow3);
        i11 = (ImageButton) findViewById(R.id.ibACol1);
        i12 = (ImageButton) findViewById(R.id.ibCCol3);
        i21 = (ImageButton) findViewById(R.id.ibBCol1);
        i22 = (ImageButton) findViewById(R.id.ibACol3);
        i31 = (ImageButton) findViewById(R.id.ibCCol1);
        i32 = (ImageButton) findViewById(R.id.ibBCol3);

        rl = (RelativeLayout) findViewById(R.id.RelativeLayout1);

        Display currentDisplay = getWindowManager().getDefaultDisplay();
        float dw = currentDisplay.getWidth();
        float dh = currentDisplay.getHeight();

        bitmap = Bitmap.createBitmap((int) dw, (int) dh,
                Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        draw = new DrawView(this);
        rl.addView(draw);


        i11.setOnTouchListener(handleTouch);
        i22.setOnTouchListener(handleTouch);
        i11.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            public void onGlobalLayout() {
                int height = i11.getHeight();
                int width = i11.getWidth();
                int x = i11.getLeft();
                int y = i11.getTop();

                // don't forget to remove the listener to prevent being called again
                // by future layout events:
                i11.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
    private View.OnTouchListener handleTouch = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            int x = (int) event.getX();
            int y = (int) event.getY();

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    downx = event.getX();
                    downy = event.getY();

                    Log.i("TAG", "touched down");
                    Toast.makeText(getApplicationContext(), "ACTION_DOWN" + " " + downx + " " + downy, Toast.LENGTH_SHORT).show();
                    break;
                case MotionEvent.ACTION_MOVE:
                    upx = event.getX();
                    upy = event.getY();
                 //   canvas.drawLine(downx, downy, upx, upy, paint);
                    Toast.makeText(getApplicationContext(), "ACTION_MOVE" + " " + downx + " " + downy, Toast.LENGTH_SHORT).show();
                  //  draw.lines
                    Log.i("TAG", "moving: (" + x + ", " + y + ")");
                    break;
                case MotionEvent.ACTION_UP:
                    upx = event.getX();
                    upy = event.getY();
            //        if(canvas!= null)
             //  canvas.drawLine(downx, downy, upx, upy, paint);
                    onDraw(downx, downy, upx, upy);
                    i12.invalidate();
                    i11.invalidate();
                    Toast.makeText(getApplicationContext(), "ACTION_UP" + " " + downx + " " + downy, Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "touched up");
                    break;
            }

            return true;
        }
    };
    public void onDraw( float x1,float y1,float x2,float y2){
   /*     bmp = Bitmap.createBitmap(i11.getWidth(), i11.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);*/
        rl.draw(canvas);

        Paint pnt = new Paint();
        pnt.setColor(Color.RED);
        canvas.drawLine(x1, y1, x2, y2, pnt);
        //i11.setImageBitmap(bitmap);
       // i = 1;
    }



    public class DrawView extends  View {
        Paint paint = new Paint();
        ArrayList<Line> lines = new ArrayList<Line>();

        public DrawView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        public DrawView(Context context, AttributeSet attrs) {
            super(context, attrs);

            paint.setAntiAlias(true);
            paint.setStrokeWidth(12);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }

        @Override
        protected void onDraw(Canvas canvass) {
            for (Line l : lines) {
                canvas = canvass ;
                canvas.drawLine(l.startX, l.startY, l.stopX, l.stopY, paint);
                Log.i("TAG", l.startX +  l.startY + l.stopX + l.stopY + " ACTION_MOVE");
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Boolean a  = i11.isFocusableInTouchMode();
            Log.i("TAG", a + "");
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                lines.add(new Line(event.getX(), event.getY()));
                return true;
            } else if ((event.getAction() == MotionEvent.ACTION_MOVE || event
                    .getAction() == MotionEvent.ACTION_UP) && lines.size() > 0) {
                Line current = lines.get(lines.size() - 1);
                current.stopX = event.getX();
                current.stopY = event.getY();
                invalidate();
                return true;
            } else {
                return false;
            }
        }
    }
}
