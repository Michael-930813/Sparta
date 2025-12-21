package chapter3.generic;

public class GenericBax<T> {
// - Var
    private T item;


// - Func
    // - Constructor
    public GenericBax(T item ) {
        this.item = item;
    }

    // - Get
    public T getItem() {
        return item;
    }

    // - Set
    public void setItem(T item) {
        this.item = item;
    }

    // - Print
    public void printItem() {
        System.out.println(this.item);
    }

    // - Another Generic <S> output
    public <S> void printBoxItem(S item) {
        System.out.println(item);
    }
}
