package app; 

/**
 * Company Stores details on the building Each building has only 10 enclosures
 */
public class Company 
{
    private String[] enclosureArray = new String[11];
    public double pricePerday = 18;
    String lengthOfStay;
    private double finalQuotePrice;
    private boolean escapeMenu = false;

    Enclosure enclosure = new Enclosure();
    Validation validation = new Validation();

    
    /*
    Starting the applicatioon by displaying the menu and looping till escaped
    */
    public void Start()
    {
        String menuInput;
        do
        {
            MenuChoices();
            System.out.println("Enter Menu Choice");
            menuInput = System.console().readLine();
            InputMenu(menuInput);
        }while (escapeMenu == false);

    }

    
    /*
    Menu that takes uset input and acts accordingly
    */
    private void InputMenu(String menuInput)
    {
        switch (menuInput) 
        {
            case "1":
                System.out.println("Picked Option 1");
                enclosure.CheckAvailability(enclosureArray);
                break;

            case "2":
                System.out.println("Picked Option 2");
                enclosure.AddOccupantInformation(enclosureArray);
                break;

            case "3":
                System.out.println("Picked Option 3");
                CalculatePrice();
                break;

            case "4":
                System.out.println("Picked Option 4");
                enclosure.PullOcupantInformation(enclosureArray);
                break;

            case "x":
                escapeMenu = true;
                break;
            
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    
    /*
    The Layout of the menu, just to see how it would display in the console
    */
    private void MenuChoices()
    {
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = =");
        System.out.println("| 1) Enclosure Availability Check                   |");
        System.out.println("| 2) Enter Details For New Occupant                 |");
        System.out.println("| 3) Calculate Price Of Stay                        |");
        System.out.println("| 4) Pull Enclosure Information                     |");
        System.out.println("| x) Exit Program                                   |");
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = =");
    }

    
    /*
    Calculate estimated price if for example a customer would like estimate for stay
    */
    private void CalculatePrice()
    {
        boolean isRunning = false;
        do
        {
            System.out.println("Enter Length Of Stay");
            lengthOfStay = System.console().readLine();
            if (validation.ValidateInteger(lengthOfStay)) 
            {
                isRunning = true;
                finalQuotePrice = pricePerday*(Integer.valueOf(lengthOfStay));
                System.out.println("£"+finalQuotePrice+" Will Be The Final Boarding Price");
            }
        }while(isRunning == false);
    }
}