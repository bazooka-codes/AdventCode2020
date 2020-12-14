import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> nums = new ArrayList<>();

        try
        {
            File inputFile = new File("Day1Input.txt");
            Scanner input = new Scanner(inputFile);

            while(input.hasNextLine())
            {
                String line = input.nextLine();
                nums.add(Integer.parseInt(line));
            }

            System.out.println("File imported successfully.");
            input.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file.");
        }

        for(int i = 0; i < nums.size() - 2; i++)
        {
            for(int j = i + 1; j < nums.size() - 1; j++)
            {
                for(int k = j + 1; k < nums.size(); k++)
                {
                    int num1, num2, num3;
                    num1 = nums.get(i);
                    num2 = nums.get(j);
                    num3 = nums.get(k);

                    if(num1 + num2 + num3 == 2020)
                    {
                        System.out.printf("FOUND: 2020 from %d and %d %d with sum %d!", num1, num2, num3, num1 * num2 * num3);
                    }
                }
            }
        }
    }
}