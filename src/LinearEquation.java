public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /* constructor method */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    //method that calculates the distance
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    //method that calculates the y-intercept
    public double yIntercept() {
        return roundedToHundredth((double) y1 - slope()*x1);
    }

    //method that calculates the slope
    public double slope() {
        return roundedToHundredth( (double)(y2-y1)/(x2-x1));
    }

    public String equation() {
        int changeInX = x2-x1;
        int changeInY = y2-y1;
        String slope;
        String equation;
        double yInterceptValue = 0.0;

        //the mod method will see if the change in y divided by change in x will be a whole number or fraction
        if ((y2-y1)%(x2-x1) == 0) {
            //if the answer is a whole number then it will be printed as a whole number
            slope = "" + (Math.abs(changeInY))/(Math.abs(changeInX));
        } else {
            /*if the answer is a fraction this will make sure the slope
            is printed as a fraction not a decimal */
            slope = Math.abs(changeInY) + "/" + Math.abs(changeInX);
        }

        /* changing the variable of equation depending on the slope will make sure that if the
        slope is -1 or 1 it will not print the 1

        this if statement will create the first part of the equation
         */
        if (slope() == 0) {
            equation = "y = ";
        } else if (slope() == -1 && slope() <0) {
            equation = "y = -x";
        } else if (slope() == 1 && slope() >0) {
            equation = "y = x";
        } else if (slope() < 0 && slope()!=0.0 && slope()!=-1.0 && slope()!=1.0){
            equation = "y = " + "-" + slope + "x";
        } else {
            equation = "y = " + slope + "x";
        }

        /* this if statement will make sure the second part of the equation is added
        into the equation variable (the y intercept)

        this is a if and else if statement so if the y intercept is 0 it will not print a y intercept.
         */
        if (yIntercept() <0) {
            yInterceptValue = Math.abs(yIntercept());
            equation += " - " + yInterceptValue;
        } else if (yIntercept() > 0) {
            yInterceptValue = Math.abs(yIntercept());
            equation += " + " + yInterceptValue;
        }

        /* this if statement will make sure if there is no slope for example the
        equation is y = 8.0, this will make sure the "+" sign will not be printed
        and that no unnecessary spaces will be printed
         */
        if (slope() == 0 && yIntercept() > 0) {
            equation = "y = " + yInterceptValue;
        } else if (slope() == 0 && yIntercept() < 0) {
            equation = "y = " + "-" + yInterceptValue;
        }

        return equation;
    }

    public String coordinateForX(double xValue) {
        // the variable y will store the new point for y with the given x point
        double y = (slope() * xValue) + yIntercept();
        return "The point on the line is (" + xValue + ", " + roundedToHundredth(y) + ")";
    }

    public double roundedToHundredth(double toRound) {
        /* example of how it works
        if the parameter toRound is 3.14159 this method will then multiply it by 100 to make 314.159
        then the Math.round will change it to 314.0 and when that is divided by 100.0 it will be 3.14
         */
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