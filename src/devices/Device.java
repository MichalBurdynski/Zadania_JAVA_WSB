package devices;

public abstract class Device {
    public String producer;
    public String model;
    public Integer yearOfProduction;

    public String toString()
    {
        return " producent: " + producer + " model: " + model + " rok produkcji: " + yearOfProduction;
    }

    public abstract void turnOn();

}
