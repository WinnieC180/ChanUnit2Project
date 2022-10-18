import javax.sound.sampled.Line;
import java.util.Scanner;

public class LinearEquationRunner {
    public static void main (String[] arg) {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("        Welcome!");
        System.out.println("-------------------------");
        System.out.println();

        System.out.print("Enter coordinate 1, i.e. (4, -4): ");
        String coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2, i.e. (4, -4): ");
        String coord2 = scan.nextLine();

        int index1 = coord1.indexOf(",");
        int index2 = coord2.indexOf(",");

        int x1 = Integer.parseInt(coord1.substring(1, index1));
        int x2 = Integer.parseInt(coord2.substring(1, index2));

        index1 = coord1.indexOf(" ");
        index2 = coord2.indexOf(" ");

        int y1 = Integer.parseInt(coord1.substring(index1+1, coord1.length()-1));
        int y2 = Integer.parseInt(coord2.substring(index2+1, coord2.length()-1));

        if (x1 == x2) {
            System.out.println();
            System.out.println("These points are on a vertical line: x = " + x1);
        } else {
            LinearEquation lineEquation = new LinearEquation(x1, y1, x2, y2);

            System.out.println();
            System.out.println("----- Line Info -----");
            System.out.println(lineEquation.lineInfo());
            System.out.println();
            System.out.print("Enter a value for x: ");
            double xValue = scan.nextDouble();
            scan.nextLine();
            System.out.println();
            System.out.println(lineEquation.coordinateForX(xValue));
        }
        scan.close();
    }
}
