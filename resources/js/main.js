
function distance(x0, y0, x1, y1) {
    var dx = Math.abs(x0 - x1);
    var dy = Math.abs(y0 - y1);
    
    return Math.sqrt((dx * dx) + (dy * dy));
}


$(function() {
	// Creates canvas 320 × 200 at 10, 50
    var paper = Raphael(150, 80, 800, 800);
    var zero = paper.rect(0, 0, 5, 5);
    //fixed width for lines
    var width = 5;
    
    //point where our line will start
    var x0 = 0;
    var y0 = 0;

    //point we want to draw a line to
    var x1 = 150;
    var y1 = 270;

    var length = distance(x0,y0, x1,y1);	

    var rectangle = paper.rect(x0, y0, width, length);

    //need to workout how to transform the rectangle now
});
