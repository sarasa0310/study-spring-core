package hello.core.singleton.state;

public class StatelessService {

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

}
