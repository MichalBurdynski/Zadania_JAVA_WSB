package devices;

public class Phone extends Device {
    Double screenSize;
    String OSVersion;

    public String toString()
    {
        return "marka telefonu: " + producer + " model: " + model + " rozmiar ekranu: " + screenSize + " wersja systemu operacyjnego: " + OSVersion;
    }

    public void turnOn()
    {
        System.out.println("Telefon uruchomiony");
    }
}
