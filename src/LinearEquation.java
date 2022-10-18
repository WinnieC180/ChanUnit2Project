import java.math.RoundingMode;

public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)

 */
public LinearEquation(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
}


/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }



    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */

    public double yIntercept() {
        return roundedToHundredth((double) y1 - slope()*x1);
    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth( (double)(y2-y1)/(x2-x1));
    }

    public String equation() {
        int changeInX = x2-x1;
        int changeInY = y2-y1;
        String slope;
        String equation;

        if ((y2-y1)%(x2-x1) == 0) {
            slope = "" + (changeInY)/(changeInX);
        } else {
            slope = changeInY + "/" + changeInX;
        }

        if ((y2-y1)/(x2-x1) == 0) {
            equation = "y = ";
        } else if ((y2-y1)/(x2-x1) == 1 && slope() <0) {
            equation = "y = -x";
        }

        return "";
    }

    public String coordinateForX(double xValue) {
        double y = (slope() * xValue) + yIntercept();
        return "The point on the line is (" + xValue + ", " + roundedToHundredth(y) + ")";
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound *100.0) /100.0; //times 100.0 and then multiply it that way it will round to the hundredth and not just one int with .0
    }

    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")"
                + "\nThe equation of the line between these points is: " + equation()
                + "\nThe slope of this line is: " + roundedToHundredth(slope())
                + "\nThe y-intercept of the line is: " + yIntercept()
                + "\nThe distance between the two points is: " + distance();
    }

}
