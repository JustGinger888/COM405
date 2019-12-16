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
                return "Category 1\nClose storm shutters and stay away from windows";
            case 2:
                return "Category 2\nClose storm shutters and stay away from windows";
            case 3:
                return "Category 3\nCoastal regions are encouraged to evacuate";
            case 4:
                return "Category 4\nEvacuate";
            case 5:
                return "Category 5\nEvacuate";
            case 6:
                return "Tropical Storm\nClose storm shutters and stay away from windows";
        }
        return "Error";
    }

}
