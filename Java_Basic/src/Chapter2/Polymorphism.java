package Chapter2;

public class Polymorphism
{
    public static void main(String[] args)
    {
        // - UpCast
        Animal animal = new Cat();
        animal.Live();
        animal.Breath();
        // animal.Scratch(); 불가

        // - DownCast
        Cat cat = (Cat)animal;
        cat.Scratch();
    }
}

class Organism
{
    void Live()
    {
        System.out.println("생명체는 살아간다");
    }
}

class Animal extends Organism
{
    void Breath()
    {
        System.out.println("동물은 숨을 쉰다");
    }
}

class Cat extends Animal
{
    @Override
    public void Live()
    {
        System.out.println("고양이는 살아간다");
    }
    @Override
    public void Breath()
    {
        System.out.println("고양이는 숨을 쉰다");
    }

    public void Scratch()
    {
        System.out.println("고양이는 스크래치!");
    }
}

class Dog extends Animal
{
    @Override
    public void Live()
    {
        System.out.println("개는 살아간다");
    }
    @Override
    public void Breath()
    {
        System.out.println("개는 숨을 쉰다");
    }

    public void Wag()
    {
        System.out.println("개는 꼬리를 흔들흔들");
    }
}