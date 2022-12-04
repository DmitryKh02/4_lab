import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dmitrii Khokhlov
 * @version 2.1
 * @see App#main(String[])
 * @see App#task(String)
 */

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter path to the file: ");
        String path = in.nextLine(); // /home/dmitrii/CODE/Java/4_lab/foreign_names.csv

        System.out.println("Enter sign separator: ");
        char sign = in.next().charAt(0);

        ArrayList<human> mArrayList = task(path, sign);
        int size = mArrayList.size();

        for (int index = 0; index < size; index++) {
            System.out.println("_____________________________");
            mArrayList.get(index).println();
            System.out.println("_____________________________");
        }

        in.close();
    }

    /**
     * Reads information line by line from a file
     * Takes it apart and create human object
     * 
     * @param path - path to the file
     * @param sign - separator
     * @return ArrayList - list on massive
     */
    static ArrayList<human> task(String path, char sign) {
        ArrayList<human> mList = new ArrayList<>();

        File file = new File("foreign_names.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                int ind = 0, length = line.length(), typeOfElements = 0;
                int _id = 0;
                String _name = "", _sex = "", _sdName = "", _bd = "", subLine = "";
                double _salary = 0;

                while (ind < length) {
                    if (line.charAt(ind) != sign) {
                        subLine += line.charAt(ind);
                    } else {
                        if (typeOfElements == 0 && _id == 0)
                            _id = Integer.parseInt(subLine);
                        else if (typeOfElements == 1 && _name == "")
                            _name = subLine;
                        else if (typeOfElements == 2 && _sex == "")
                            _sex = subLine;
                        else if (typeOfElements == 3 && _bd == "")
                            _bd = subLine;
                        else if (typeOfElements == 4 && _sdName == "")
                            _sdName = subLine;

                        subLine = "";
                        typeOfElements++;
                    }

                    ind++;
                }
                _salary = Integer.parseInt(subLine);
                subLine = "";
                human example = new human(_id, _name, _sex, _sdName, _salary, _bd);
                mList.add(example);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mList;
    }
}
