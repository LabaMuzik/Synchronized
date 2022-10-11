import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Integer> shop = new ArrayList<>();

    public static void main(String[] args) {


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Buyers customer = new Buyers(i);
                synchronized (shop) {
                    customer.entered();
                    if (shop.isEmpty()) {
                        System.out.println("Машин нет");
                        try {
                            shop.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    customer.bought();
                    shop.remove(0);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Cars producer = new Cars ("Toyota");
                synchronized (shop) {
                    shop.add(producer.producedCar());
                    shop.notify();
                }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
    }
}