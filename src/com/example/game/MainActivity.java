package com.example.game;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));
    }
    static public class GraphicsView extends View
    {

		private static final String TAG = null;
		private float width,height;
		private int x,y,flag=0,count=1,flag2=0,flag3=0;
		private String print,result;
		private int colour;
		public GameMain game=new GameMain();
		
		
		public GraphicsView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		protected void onDraw(Canvas canvas) {
			
			int i,j;
			Paint background =new Paint();
			background.setColor(getResources().getColor(R.color.background));
			canvas.drawRect(0, 0, getWidth(), getHeight(), background);
			Paint dark =new Paint();
			dark.setColor(getResources().getColor(R.color.dark));
			
			width=getWidth()/3f;
			height=getHeight()/3f;
		
			//Horizontal Lines
			canvas.drawLine(0,height, getHeight(),height,dark);
			canvas.drawLine(0, 2*height, getHeight(),2*height,dark);
			canvas.drawLine(0, 3*height, getHeight(),3*height,dark);
			
			//Vertical Lines
			canvas.drawLine(width,0,width,getHeight(),dark);
			canvas.drawLine(2*width,0,2*width,getHeight(),dark);
			canvas.drawLine(3*width,0,3*width,getHeight(),dark);
			if(flag==1)
			{
				
			
			 Paint foreground=new Paint(Paint.ANTI_ALIAS_FLAG);
			// foreground.setColor(getResources().getColor(R.color.colorX));
			 foreground.setStyle(Style.FILL);
			 foreground.setTextSize(height*0.75f);
			 foreground.setTextScaleX(width/height);
			 foreground.setTextAlign(Paint.Align.CENTER);
			 FontMetrics fm=foreground.getFontMetrics();
			 float x1=width/2;
			 float y1=height/2-(fm.ascent+fm.descent)/2;
			 for(i=0;i<3;i++)
			 {
				 for(j=0;j<3;j++)
				 {
					 canvas.drawText(game.board[i][j], j*width+x1, i*height+y1, foreground);
				 }
			 }
			
			 		 result=game.gameCheck();
			 		 if(game.isDrawGame()==1)
			 		 {
			 			 Toast.makeText(getContext(), "It's a draw game", Toast.LENGTH_LONG).show();
			 		     flag2++;	///Stop priting won message again
			 		     flag3++;	 ///this flag is to stop input after the end of the game
			 		 }
			 		 if((result=="X" || result=="O") && flag2==0)
			 		 {
			 		     Toast.makeText(getContext(), result+" won the game", Toast.LENGTH_LONG).show();
			 		     flag2++;	///Stop priting won message again
			 		     flag3++;	 ///this flag is to stop input after the end of the game
			 		 }
			 	
			 		 
			}
		}
		public boolean onTouchEvent(MotionEvent event) {
			if(flag3==0)
			{
				if (event.getAction() != MotionEvent.ACTION_DOWN)
					return super.onTouchEvent(event);
			
				x=(int) ((int) event.getX()/width);
				y=(int) ((int) event.getY()/height);
				flag=1;
				//Log.d(TAG,"touched"+x+","+y);
			
				if(count%2!=0)
				{
					print="X";
					//colour=getResources().getColor(R.color.colorX);
					count++;
				}
				else
				{
					print="O";
					//colour=getResources().getColor(R.color.colorO);
					count++;
				}
				
				if(game.isAllReadyExist(x, y)==0)
				{
					game.inputData(x, y, print);
				}
				else
				{
					Toast.makeText(getContext(), "Allready selected the box", Toast.LENGTH_SHORT).show();
					count--;
				}
				
				invalidate();
				
				
				
		    }
			return true;
		}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
