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

// Create a window
var win = Ti.UI.createWindow({
	backgroundColor: "black"
});

// Create a new label
var label = Ti.UI.createLabel({
	color: "white",
	top: 0,
	left: 0,
	width: 200,
	height: 30,
	text: "Follow Me!"
});

// Add Touch Event Listener
win.addEventListener("touchend", function(event) {
	var animation = Ti.UI.createAnimation();
	
	// Animate by an offset
	animation.left = event.x-label.left;
	animation.top = event.y-label.top;
	
	// set the animation duration
	animation.duration = 1000;
	
	// animate our label to our mouse position
	label.animate(animation);
});

// add the label to our window
win.add(label);


// open our window
win.open();
