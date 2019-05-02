import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Title:          PACKAGE_NAME
 * Authors:        Miles Maloney, Caden Keese
 * Last Modified:  2019-05-02
 * Description:
 * */
public class Flights {

    public static void main(String[] args) {
        CityGraph cg = loadFiles();

        // todo implement breadth first search

    }


    public static CityGraph loadFiles() {
        // get cityFile

        ArrayList<String> cities = new ArrayList<>();
        try {
            BufferedReader cf = new BufferedReader(new FileReader("cityFile"));
            String input;
            while ((input = cf.readLine()) != null) {
                cities.add(input);
            }
            cf.close();
        } catch (FileNotFoundException e) {
            System.out.println("'cityFile' file does not exist");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Could not read 'cityFile' file");
            e.printStackTrace();
            System.exit(1);
        }
        CityGraph cg = new CityGraph(cities.toArray(new String[0]));
        try {
            BufferedReader ff = new BufferedReader(new FileReader("flightFile"));
            String input;
            while ((input = ff.readLine()) != null) {
                cg.addEdgeFromArray(input.split(","));
            }
            ff.close();
        } catch (FileNotFoundException e) {
            System.out.println("'flightFile' file does not exist");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Could not read 'flightFile' file");
            e.printStackTrace();
            System.exit(1);
        }

        return cg;
    }




}
