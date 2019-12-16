import java.util.stream.IntStream;

public class Hurricane extends Storm{

    public Hurricane(String stormNameIn, String stormWindSpeedIn, String stormTempIn){
        super(stormNameIn, stormWindSpeedIn, stormTempIn);
    }


    @Override
    protected int Calculations(String stormWindSpeedIn, String stormTempIn) {
        int windSpeed = Integer.parseInt(stormWindSpeedIn);
        if (74<= windSpeed && windSpeed <= 95){
            return 1;
        }
        else if (96<= windSpeed && windSpeed <= 110){
            return 2;
        }
        else if (111<= windSpeed && windSpeed <= 129){
            return 3;
        }
        else if (130<= windSpeed && windSpeed <= 156){
            return 4;
        }
        else if (windSpeed > 156){
            return 5;
        }
        return 6;
    }

    @Override
    protected String CategoryAdvice(String stormWindSpeedIn, String stormTempIn) {
        switch (Calculations(stormWindSpeedIn, stormTempIn)){
            case 1:
                return "";
            case 2:
                return "";
            case 3:
                return "";
            case 4:
                return "";
            case 5:
                return "";
            case 6:
                return "";
        }
        return "Error";
    }

}
