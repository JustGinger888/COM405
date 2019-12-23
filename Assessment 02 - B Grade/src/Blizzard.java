public class Blizzard extends Storm{

    public Blizzard(String stormNameIn, String stormWindSpeedIn, String stormTempIn){
        super(stormNameIn, stormWindSpeedIn, stormTempIn);
    }

    @Override
    protected int Calculations(String stormWindSpeedIn, String stormTempIn) {
        int windSpeed = Integer.parseInt(stormWindSpeedIn);
        int stormTemp = Integer.parseInt(stormTempIn);
        if (45<= windSpeed && stormTemp <= -12){
            return 2;
        }
        else if (35<= windSpeed && windSpeed <= 44){
            return 1;
        }
        return 3;
    }

    @Override
    protected String CategoryAdvice(String stormWindSpeedIn, String stormTempIn) {
        switch (Calculations(stormWindSpeedIn, stormTempIn)){
            case 1:
                return "Blizzard\nKeep warm, do not travel unless absolutely essential";
            case 2:
                return "Severe Blizzard\nKeep warm, avoid all travel";
            case 3:
                return "Snowstorm\nTake care and avoid travel if possible";
        }
        return "Error";
    }

}
