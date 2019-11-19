public class Car {
    private String carRegNo;
    private String carColour;
    private String carMake;
    private String carModel;

    public Car(String carRegNoIN, String carColourIN, String carMakeIN, String carModelIN)
    {
        this.carRegNo = carRegNoIN;
        this.carColour = carColourIN;
        this.carMake = carMakeIN;
        this.carModel = carModelIN;
    }

    public String getCarRegNo() {
        return carRegNo;
    }

    public String getCarColour() {
        return carColour;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }
}
