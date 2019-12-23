public abstract class Storm {

    protected String stormName;
    protected String stormWindSpeed;
    protected String stormTemp;

    public Storm(String stormNameIn, String stormWindSpeedIn, String stormTempIn){
        this.stormName = stormNameIn;
        this.stormWindSpeed = stormWindSpeedIn;
        this.stormTemp = stormTempIn;
    }

    public String getStormName() {
        return stormName;
    }

    public String getStormWindSpeed() {
        return stormWindSpeed;
    }

    public String getStormTemp() {
        return stormTemp;
    }

    protected abstract int Calculations(String stormWindSpeedIn, String stormTempIn);

    protected abstract String CategoryAdvice(String stormWindSpeedIn, String stormTempI);

}