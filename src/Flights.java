import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Title:          Project 3
 * Authors:        Miles Maloney, Caden Keese
 * Last Modified:  2019-05-06
 * Description: Main user Interface
 * */
public class Flights {

    public static void main(String[] args) {
        String cityFile = null,
          flightFile = null;
        Scanner kbd = new Scanner(System.in);


        do {
            cityFile = requestFile(cityFile, kbd, true);
            flightFile = requestFile(flightFile, kbd, false);
//            System.out.println("cityFile = " + cityFile);
//            System.out.println("flightFile = " + flightFile);
            CityGraph cg = loadFiles(cityFile, flightFile);


            do {
                String dest = null, origin = requestCity(kbd, cg, true);
                if (origin != null) {
                    dest = requestCity(kbd, cg, false);
                }
                if (dest != null) {
                    cg.calculatePath(origin, dest);
                }
            } while (getYN("Would you like to enter another origin and destination? (y/n)", kbd));

            cityFile = null;
            flightFile = null;
        } while (getYN("Would you like to use different city and flight files? (y/n)", kbd));
        System.out.println("Exiting...");
    }

    private static boolean getYN(String prompt, Scanner kbd) // get a yes or no answer, prompt must end with (y/n)
    {
        String answer;
        while (true) {
            System.out.println(prompt);
            answer = kbd.nextLine();
            if (answer.equals("y")) {
                return true;
            } else if (answer.equals("n")) {
                return false;
            }
            System.out.println("unrecognized Key Input\n please try again");
        }
    }

    private static String requestFile(String fileName, Scanner kbd, boolean isCityFile) {
        while (fileName == null) {
            System.out.println("What is the name of the " + ((isCityFile) ? "city" : "flight") + " file?");
            fileName = kbd.nextLine();
            if (!(new File(fileName)).exists()) {
                System.out.println(fileName + " doesn't exit");
                fileName = null;
            }
        }
        return fileName;
    }


    private static String requestCity(Scanner kbd, CityGraph cg, boolean isOrigin) {
        System.out.println("What city do you want to fly " + ((isOrigin) ? "from" : "to") + "?");
        System.out.println("Make sure to check case!");
        String input = kbd.nextLine();
        if (cg.indexOf(input) == -1) {
            System.out.println("USAir does not serve " + input);
            return null;
        } else {
            return input;
        }
    }


    private static CityGraph loadFiles(String cityFile, String flightFile) {
        // get cityFile

        ArrayList<String> cities = new ArrayList<>();
        try {
            BufferedReader cf = new BufferedReader(new FileReader(cityFile));
            String input;
            while ((input = cf.readLine()) != null) {
                cities.add(input);
            }
            cf.close();
        } catch (FileNotFoundException e) {
            System.out.println(cityFile + " file does not exist");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Could not read " + cityFile + " file");
            e.printStackTrace();
            System.exit(1);
        }
        CityGraph cg = new CityGraph(cities.toArray(new String[0]));
        try {
            BufferedReader ff = new BufferedReader(new FileReader(flightFile));
            String input;
            while ((input = ff.readLine()) != null) {
                cg.addEdgeFromArray(input.split(","));
            }
            ff.close();
        } catch (FileNotFoundException e) {
            System.out.println(flightFile + " file does not exist");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Could not read " + flightFile + " file");
            e.printStackTrace();
            System.exit(1);
        }

        return cg;
    }


}
