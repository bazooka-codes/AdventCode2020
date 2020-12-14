import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 
{
    public static void main(String[] args)
    {
        int passCount = 0;

        try
        {
            File inputFile = new File("Day2Input.txt");
            Scanner input = new Scanner(inputFile);

            while(input.hasNextLine())
            {
                String line = input.nextLine();
                String[] splitLine = line.split(" ");
                String[] rangeSplit = splitLine[0].split("-");
                int rangeLow = Integer.parseInt(rangeSplit[0]);
                int rangeHigh = Integer.parseInt(rangeSplit[1]);
                char limChar = splitLine[1].charAt(0);
                String password = splitLine[2];
                boolean pass = false;

                /* For part 1
                int count = 0;
                for(int i = 0; i < password.length(); i++)
                {
                    if(password.charAt(i) == limChar)
                        count++;
                }*/

                if((password.charAt(rangeLow - 1) == limChar || password.charAt(rangeHigh - 1) == limChar) && !(password.charAt(rangeLow - 1) == limChar && password.charAt(rangeHigh - 1) == limChar))
                {
                    pass = true;
                    passCount++;
                }

                System.out.println(line + " Verdict: " + pass);
            }

            System.out.println("File imported successfully.");
            input.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file.");
        }

        System.out.println("Number of passes: " + passCount);
    }
}
