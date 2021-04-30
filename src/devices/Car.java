package devices;

public class Car extends Device {
    public Double fuelConsumption;
    public Integer numberOfPistons;
    public Double carValue;
    private Integer chassisNumber;

    public Car(String producer, String model)
    {
        this.producer = producer;
        this.model = model;
    }

    public Car(String producer, String model, Integer chassisNumber)
    {
        this.producer = producer;
        this.model = model;
        this.chassisNumber = chassisNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        return (producer.equals(((Car) o).producer) && model.equals(((Car) o).model) && fuelConsumption == ((Car) o).fuelConsumption) && numberOfPistons == (((Car) o).numberOfPistons) && carValue == (((Car) o).carValue);
    }

    public String toString()
    {
        return "marka auta: " + producer + " model: " + model + " " + " zużycie paliwa: " + fuelConsumption + " liczba cylindrów: " + numberOfPistons + " wartość auta: " + carValue;
    }

    @Override
    public int hashCode()
    {
        return chassisNumber;
    }

    public void turnOn()
    {
        System.out.println("Auto uruchomione.");
    }
}
