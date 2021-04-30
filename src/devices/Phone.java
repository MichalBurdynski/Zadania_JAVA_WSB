package devices;

public class Phone {
    String producer;
    String model;
    Double screenSize;
    String OSVersion;

    public String toString()
    {
        return "marka telefonu: " + producer + " model: " + model + " rozmiar ekranu: " + screenSize + " wersja systemu operacyjnego: " + OSVersion;
    }
}
