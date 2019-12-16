import java.util.regex.Pattern;

public class Validation
{

    private String userResponse;


    /*
    validating String by checking whether it contains a number
    */
    public boolean ValidateString(String tmp)
    {
        if (Pattern.compile( "[0-9]" ).matcher(tmp).find() || tmp.isEmpty())
        {
            System.out.println("Is The Input Correct? Y/N");
            userResponse = System.console().readLine();
            if (userResponse.toLowerCase().equals("y"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        return true;
    }


    /*
    validating integer by attempting to parse it from its intital string input
    */
    public boolean ValidateInteger(String tmp)
    {
        try
        {
            Integer.parseInt(tmp);
        }
        catch (Exception e)
        {
            System.out.println("Invallid input, numbers only");

            return false;

        }
        return true;
    }


    /*
    Validating bool value by converting input to lower case and seeing if it equals neccesary output
    */
    public boolean ValidateBoolean(String tmp)
    {
        if (tmp.toLowerCase().equals("male"))
        {
            return true;
        }

        else if (tmp.toLowerCase().equals("female"))
        {
            return true;
        }
        else
        {
            System.out.println("Is The Input Correct? Y/N");
            userResponse = System.console().readLine();
            if (userResponse.toLowerCase().equals("y"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}