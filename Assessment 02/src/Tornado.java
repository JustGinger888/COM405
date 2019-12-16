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
                return "F0\nFind safe room/shelter, shield yourself from debris";
            case 1:
                return "F1\nFind safe room/shelter, shield yourself from debris";
            case 2:
                return "F2\nFind underground shelter, crouch near to the floor covering your head with your hand";
            case 3:
                return "F3\nFind underground shelter, crouch near to the floor covering your head with your hand";
            case 4:
                return "F4\nFind underground shelter, crouch near to the floor covering your head with your hand";
            case 5:
                return "F5\nFind underground shelter, crouch near to the floor covering your head with your hand";
            case 6:
                return "Unclassified\nThere is no need to panic";
        }
        return "Error";

    }
}
