import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 
{
    public static void main(String[] args) 
    {
        //byr, iyr, eyr, hgt, hcl, ecl, pid, cid
        int[] fields = {0, 0, 0, 0, 0, 0, 0, 0};
        int validCount = 0;
        try
        {
            File inputFile = new File("Day4Input.txt");
            Scanner input = new Scanner(inputFile);
            String batch = "";

            while(input.hasNextLine())
            {
                String line = input.nextLine();
                if(line.isEmpty())
                {
                    //This is a batch
                    batch = batch.stripLeading();
                    System.out.println(batch);
                    String[] splitPP = batch.split(" ");

                    for(int i = 0; i < splitPP.length; i++)
                    {
                        String[] splitField = splitPP[i].split(":");
                        if(splitField[0].equalsIgnoreCase("byr"))
                        {
                            if(splitField[1].length() == 4)
                            {
                                int year = Integer.parseInt(splitField[1]);
                                if(year >= 1920 && year <= 2002)
                                {
                                    fields[0] = 1;
                                    System.out.print("BYR valid ");
                                }
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("iyr"))
                        {
                            if (splitField[1].length() == 4) 
                            {
                                int year = Integer.parseInt(splitField[1]);
                                if (year >= 2010 && year <= 2020)
                                {
                                    fields[1] = 1;
                                    System.out.print("IYR Valid ");
                                }
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("eyr"))
                        {
                            if (splitField[1].length() == 4) 
                            {
                                int year = Integer.parseInt(splitField[1]);
                                if (year >= 2020 && year <= 2030)
                                {
                                    fields[2] = 1;
                                    System.out.print("EYR valid ");
                                }
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("hgt"))
                        {
                            if(splitField[1].contains("cm"))
                            {
                                splitField[1] = splitField[1].substring(0, splitField[1].length() - 2);
                                int height = Integer.parseInt(splitField[1]);
                                if(height >= 150 && height <= 193)
                                {
                                    fields[3] = 1;
                                    System.out.print("HGT Valid ");
                                }
                            }
                            else if(splitField[1].contains("in"))
                            {
                                splitField[1] = splitField[1].substring(0, splitField[1].length() - 2);
                                int height = Integer.parseInt(splitField[1]);
                                if(height >= 59 && height <= 76)
                                {
                                    fields[3] = 1;
                                    System.out.print("HGT VALID ");
                                }
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("hcl"))
                        {
                            if(splitField[1].charAt(0) == '#')
                            {
                                splitField[1] = splitField[1].substring(1, splitField[1].length());
                                if(splitField[1].length() == 6)
                                {
                                    boolean isValid = true;
                                    for(int j = 0; j <= 5; j++)
                                    {
                                        if(!Character.isDigit(splitField[1].charAt(j)) && !Character.toString(splitField[1].charAt(j)).matches("[a-f?]"))
                                        {
                                            isValid = false;
                                        }
                                    }

                                    if(isValid)
                                    {
                                        fields[4] = 1;
                                        System.out.print("HCL Valid ");
                                    }
                                }
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("ecl"))
                        {
                            if(splitField[1].equalsIgnoreCase("amb") || splitField[1].equalsIgnoreCase("blu") || splitField[1].equalsIgnoreCase("brn") || splitField[1].equalsIgnoreCase("gry") || splitField[1].equalsIgnoreCase("grn") || splitField[1].equalsIgnoreCase("hzl") || splitField[1].equalsIgnoreCase("oth"))
                            {
                                fields[5] = 1;
                                System.out.print("ECL Valid ");
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("pid"))
                        {
                            if(splitField[1].length() == 9)
                            {
                                boolean isValid = true;
                                for(int j = 0; j <= 8; j++)
                                {
                                    if(!Character.isDigit(splitField[1].charAt(j)))
                                    {
                                        isValid = false;
                                    }
                                }

                                if(isValid)
                                {
                                    fields[6] = 1;
                                    System.out.print("PID VALid ");
                                }
                            }
                        }
                        else if(splitField[0].equalsIgnoreCase("cid"))
                        {
                            fields[7] = 1;
                        }
                    }
                    
                    int count = 0;
                    for(int i = 0; i < fields.length; i++)
                    {
                        if(fields[i] == 1)
                        {
                            count++;
                        }

                    }
        
                    if(count == 8)
                    {
                        validCount++;
                        System.out.println("VALID");
                    }
                    else if(count == 7 && fields[7] == 0)
                    {
                        validCount++;
                        System.out.println("VALID");
                    }
                    else
                    {
                        System.out.println("NOT VALID");
                    }

                    for(int i = 0; i < fields.length; i++)
                    {
                        fields[i] = 0;
                    }
                    batch = "";
                }
                else
                {
                    batch += " ";
                    batch += line;
                }
            }

            System.out.println("Valid passports: " + validCount);
            input.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading file.");
        }
    }
}
