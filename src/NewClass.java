
import java.util.Scanner;

class TestClass {

    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        String UNIT = s.nextLine();                 // Reading input from STDIN

        UNIT = UNIT.replaceAll(",", " ");

        //  Arrays.sort(words);
        if (UNIT.contains("year")) {
            System.out.println("1year = 12month = 365day = " + 365 * 24 + "hour = " + 365 * 24 * 60 + "minute = " + 365 * 24 * 60 * 60 + "second");
        } else if (UNIT.contains("month")) {
            System.out.println("1month = 30day = " + 30 * 24 + "hour = " + 30 * 24 * 60 + "minute = " + 30 * 24 * 60 * 60 + "second");
        } else if (UNIT.contains("day")) {
            System.out.println("1day = " + 1 * 24 + "hour = " + 1 * 24 * 60 + "minute = " + 1 * 24 * 60 * 60 + "second");
        }

    }
}
