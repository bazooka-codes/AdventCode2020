import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3
{    
    public static void main(String[] args)
    {
        try
        {
            File inputFile = new File("Day3Input.txt");
            Scanner input = new Scanner(inputFile);
            int treeCount = 0;
            int currCol = 1;
            input.nextLine();

            while(input.hasNextLine())
            {
                input.nextLine();
                String line = input.nextLine();
                currCol += 1;
                if(currCol - 1 > line.length() - 1)
                    currCol %= line.length();
                char currChar = line.charAt(currCol - 1);

                if(currChar == '#')
                {
                    treeCount++;
                }
            }

            System.out.println("Trees encountered: " + treeCount);
            input.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file.");
        }
    }
}