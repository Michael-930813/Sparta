package Chapter2;

public class Abstract
{
    public static  void main(String[] args)
    {
        PumpkinSweetPotato psp = new PumpkinSweetPotato();
        psp.Photosynthesis();
        psp.MakeStem();
        psp.SoftAndSweet();
    }
}

// - Abstruct 3 depth
class Plant
{
    public void Photosynthesis()
    {
        System.out.println("광합성");
    }
}

class SweetPotato extends Plant
{
    public void MakeStem()
    {
        System.out.println("고구마 줄기 생성");
    }
}

class PumpkinSweetPotato extends SweetPotato
{
    @Override
    public void MakeStem()
    {
        System.out.println("호박고구마 줄기 생성");
    }

    public void SoftAndSweet()
    {
        System.out.println("부드럽고 달다!");
    }
}