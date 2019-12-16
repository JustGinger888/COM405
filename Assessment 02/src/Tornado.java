public class Tornado extends Storm {

    public Tornado(String stormNameIn, String stormWindSpeedIn, String stormTempIn) {
        super(stormNameIn, stormWindSpeedIn, stormTempIn);
    }


    @Override
    protected int Calculations(String stormWindSpeedIn, String stormTempIn) {
        int windSpeed = Integer.parseInt(stormWindSpeedIn);
        if (40 <= windSpeed && windSpeed <= 72) {
            return 0;
        } else if (73 <= windSpeed && windSpeed <= 112) {
            return 1;
        } else if (112 <= windSpeed && windSpeed <= 157) {
            return 2;
        } else if (158 <= windSpeed && windSpeed <= 205) {
            return 3;
        } else if (206 <= windSpeed && windSpeed <= 260) {
            return 4;
        } else if (windSpeed > 261) {
            return 5;
        }
        return 6;
    }

    @Override
    protected String CategoryAdvice(String stormWindSpeedIn, String stormTempIn) {
        switch (Calculations(stormWindSpeedIn, stormTempIn)) {
            case 0:
                return "";
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
