/*
 * Android Primer Presentation For MobileDevNJ
 * David Rodriguez
 * January 2012 Meetup
 * 
 * http://www.twitter.com/programmerdave
 * http://www.github.com/programmerdave
 * http://www.mobiledevnj.com
 * http://www.meetup.com/mobiledevnj
 * 
 * Feel free to use this code as you wish.
 */
 
 package com.mobiledevnj.followme;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FollowMeActivity extends Activity implements OnTouchListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set the content view to the main.xml layout specified in the res/layout folder
        setContentView(R.layout.main);
        
        // add a touch listener to the main layout
        ViewGroup vg = (ViewGroup) findViewById(R.id.mainLayout);
        vg.setOnTouchListener(this);
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int x = (int)event.getX();
		int y = (int)event.getY();
		
		// If we touch the screen, let's move the label
		if( event.getAction() == MotionEvent.ACTION_DOWN ) {
			
			// get the label in that's defined in our main.xml layout
			TextView label = (TextView) findViewById(R.id.followMeTextView);
			
			// Since android doesn't actually modify the position of the layout while animating, we have to reposition the layout first,
			// then "fake" the animation from the beginning position to the final position (By fake I mean, it's just drawing the animation, not actually modifying the position)
			RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) label.getLayoutParams();
			
			// save the beginning position
			int left = lp.leftMargin;
			int top = lp.topMargin;
			
			// set the final position of the label layout to our current touch position
			lp.leftMargin = x;
			lp.topMargin = y;
			label.setLayoutParams(lp);
			
			// now "fake" the animation by translating from our beginning position to our current position(which is the final position)
			TranslateAnimation anim = new TranslateAnimation(left-x, 0, top-y, 0);
			
			// set the animation duration
			anim.setDuration(1000);
			
			// animate the label
			label.startAnimation(anim);
		}
		
		return true;
	}
}