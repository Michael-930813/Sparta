package Chapter2;

public class Interface
{
    public static void main(String[] args)
    {
        System.out.println("===== Television Class =====");
        Television tv = new  Television();

        tv.TurnOn();
        tv.TurnOff();
        tv.OutputTV();

        System.out.println("===== AirConditioner Class =====");
        AirConditioner air = new  AirConditioner();

        air.TurnOn();
        air.TurnOff();

        System.out.println("===== Computer Class =====");
        Computer com = new  Computer();

        com.TurnOn();
        com.TurnOff();
    }
}

interface HomeAppliances
{
    void TurnOn();
    void TurnOff();
}

// - Television, AirConditioner, Computer
class Television implements HomeAppliances
{
    @Override
    public void TurnOn()
    {
        System.out.println("Television Turning ON");
    }
    public void TurnOff()
    {
        System.out.println("Television Turning OFF");
    }
    void OutputTV()
    {
        System.out.println("Output TV");
    }
}
class AirConditioner implements HomeAppliances
{
    public void TurnOn()
    {
        System.out.println("AirConditioner Turning ON");
    }
    public void TurnOff()
    {
        System.out.println("AirConditioner Turning OFF");
    }
}
class Computer implements HomeAppliances
{
    public void TurnOn()
    {
        System.out.println("Computer Turning ON");
    }
    public void TurnOff()
    {
        System.out.println("Computer Turning OFF");
    }
}