public class CarPark {
    private Car cars[] = new Car[15];
    private int emptySpaces = 0;

    public boolean AddCar(String carRegNoIN, String carColourIN, String carMakeIN, String carModelIN)
    {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = new Car(carRegNoIN, carColourIN, carMakeIN, carModelIN);
                return true;
            }
        }
        return false;
    }

    public int EmptySpaces()
    {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                emptySpaces++;
            }
        }
        return emptySpaces;
    }

    public void RemoveCar(String regNumIN){
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarRegNo().equals(regNumIN)) {
                cars[i] = null;
                break;
            }
        }
    }
}

