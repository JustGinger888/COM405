package app;

/**
 * Enclosure Stores relevant details about the enclosures Enclosures can store a singular occupant
 */
public class Enclosure 
{

    private String[] userInputArray = new String[7];
    private int[] openEnclosures = new int[10];
    private String tempStringValue;
    Animal animal;    

    
    /*
    Checking the enclosure avalibility and diplaying appopriate messge based on contents
    */
    public void CheckAvailability(String[] enclosureArray)
    {
        boolean enclosureAva = false;
        int j = 0;
        for (int i = 1; i < enclosureArray.length; i++) 
        {
            if (enclosureArray[i] == null)
            {
                enclosureAva = true;
                openEnclosures[j] = i;
                j++;
            }
        }
        if (enclosureAva == true) 
        {
            System.out.print("Enclosure ");
            for (int i = 0; i < openEnclosures.length; i++) 
            {
                System.out.print(openEnclosures[i] + " ");
            }
            System.out.println(" Are Open");
        } 
        else 
        {
            System.out.print("No Enclosures Are Currently Open");   
        }
    }

    
    /*
    Pulling an occupants informmation and prompting user for options to take with data
    */
    public void PullOcupantInformation(String[] enclosureArray) 
    {
        System.out.println("Enter Enclosure Information You Would Like To Pull");
        int enclosurePullInput = Integer.parseInt(System.console().readLine());

        if (enclosurePullInput > 0 && enclosurePullInput < 11) 
        {
            if (enclosureArray[enclosurePullInput] == null) 
            {
                System.out.println("Empty Enclosure");
            } 
            else 
            {
                //Prompting for action to take with data
                System.out.println(enclosureArray[enclosurePullInput]);

                System.out.println("Would you like to Remove this Data or Exit? (R/X)");

                String removeAmmendData = System.console().readLine();
                switch (removeAmmendData.toLowerCase()) 
                {
                    case "r":
                        RemoveOccupantInformation(enclosureArray, enclosurePullInput);
                        break;

                    case "x":
                        System.out.println("Escape");
                        break;
                        
                    default:
                        System.out.println("Invalid Input, Escaping");
                        break;
                }
            }
        }
        else
        {
            System.out.println("Invalid Input");
        }
    }
    
    private void RemoveOccupantInformation(String[] enclosureArray, int enclosurePullInput)
    {
        System.out.println("Removing Data");
        enclosureArray[enclosurePullInput] = null;
    }

    
    /*
    adding occupant data to input array before constructing and compiling the animal
    */
    public void AddOccupantInformation(String[] enclosureArray)
    {
        int count = 0;
        String userResponse;
        Validation validInput = new Validation();
        
        do
        {
            //Animal Name
            if (count == 0) 
            {
                System.out.println("Enter Animal Name:");
                tempStringValue = System.console().readLine();
                if(validInput.ValidateString(tempStringValue))
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }
            }
            //Owner Name
            else if (count == 1) 
            {
                System.out.println("Enter Owner Name:");
                tempStringValue = System.console().readLine();
                if(validInput.ValidateString(tempStringValue))
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }

            }
            //Animal Age
            else if (count == 2) 
            {
                System.out.println("Enter Animal Age:");
                tempStringValue = System.console().readLine();
                if(validInput.ValidateInteger(tempStringValue))
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }
            }
            //Animal Gender
            else if (count == 3) 
            {
                System.out.println("Enter Animal Gender: (Male/Female)");
                tempStringValue = System.console().readLine();
                if(validInput.ValidateBoolean(tempStringValue))
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }
            }
            //Animal Breed
            else if (count == 4) 
            {
                System.out.println("Enter Animal Breed:");
                tempStringValue = System.console().readLine();
                if(validInput.ValidateString(tempStringValue))
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }
            }
            //General Notes
            else if (count == 5) 
            {
                System.out.println("Enter Notes:");
                tempStringValue = System.console().readLine();
                System.out.println("Is The Input Correct? Y/N");
                userResponse = System.console().readLine();
                if (userResponse.toLowerCase().equals("y")) 
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }
            }
            //Booking Length
            else if (count == 6) 
            {
                System.out.println("Enter Booking Length:");
                tempStringValue = System.console().readLine();
                if(validInput.ValidateInteger(tempStringValue))
                {
                    userInputArray[count] = tempStringValue;
                    count++;
                }
            }

        }while(count < 7);

        //Adding new Occupant and saving them to open Enclosure
        Animal animal = new Animal(userInputArray[0], userInputArray[1], userInputArray[2], userInputArray[3], userInputArray[4],userInputArray[5],userInputArray[6] );  
        SaveOccupantInformation(enclosureArray, animal);
    }

    /*
    Saving occupant info to enclosure by displaying open enclosure and propmpting user on where to assign occupant to
    */
    private void SaveOccupantInformation(String[] enclosureArray, Animal animal)
    {
        //display open enclosures
        CheckAvailability(enclosureArray);
        Validation validation = new Validation();
        boolean assignedOccupant = false;
        String intitialInputEnclosure;
        int inputEnclosure;

        //Check if input is valid, in range and prompts for overriding data
        do 
        {
            //assignment prompt
            do {
                System.out.println("Enter Enclosure number to assign animal to it:");
                intitialInputEnclosure = System.console().readLine();
            } while (!validation.ValidateInteger(intitialInputEnclosure));

            inputEnclosure = Integer.parseInt(intitialInputEnclosure);

            if (inputEnclosure > 0 && inputEnclosure < 11) 
            {
                if (quickEnclosureCheck(enclosureArray, inputEnclosure)) 
                {
                    enclosureArray[inputEnclosure] = compileOccupant(animal);
                    assignedOccupant = true;
                } 
                else 
                {
                    System.out.println("Do you want to ovveride data of pre existing occupant? Y/N");
                    String userChoice = System.console().readLine();
                    switch (userChoice.toLowerCase()) 
                    {
                        case "y":
                            System.out.println("Overiding Data");
                            enclosureArray[inputEnclosure] = compileOccupant(animal);
                            assignedOccupant = true;
                            break;
                        case "n":
                            System.out.println("No Data Overidden");
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                }
            } 
            else
            {
                System.out.println("Invalid Location");        
            }
        }while (assignedOccupant == false);
    }

    
    /*
    Quickly check whether enclosure is open to store data
    */
    public Boolean quickEnclosureCheck(String[] enclosureArray, int inputEnclosure)
    {
        if (enclosureArray[inputEnclosure] == null) {
            return true;
        }
        return false;
    }

    
    /*
    Compiling all of the occupant animals information into one large string to store
    */
    public String compileOccupant(Animal animal)
    {
        tempStringValue =   "Name   : "+ animal.GetAnimalName()+"\n"+
                            "Owner  : "+ animal.GetOwnerName()+"\n"+
                            "Age    : "+ animal.GetAnimalAge()+"\n"+
                            "Sex    : "+ animal.GetAnimalGender()+"\n"+
                            "Breed  : "+ animal.GetAnimalBreed()+"\n"+
                            "Notes  : "+ animal.GetGeneralNotes()+"\n"+
                            "Booking: "+ animal.GetBookingLength()+"\n"+
                            "Price  : "+ CalculateQuickPrice(Integer.parseInt(animal.GetBookingLength()));
        return tempStringValue;
    }

    
    /*
    Quick price calcculation based on company rates
    */
    private double CalculateQuickPrice(int stayLength)
    {
        Company company = new Company();
        double finalPrice;
        finalPrice = company.pricePerday*stayLength;
        return finalPrice;
    }
}