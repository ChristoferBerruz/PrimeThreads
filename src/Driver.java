public class Driver {
    public static void main(String[] args) {
        Factory factory = new Factory(3,10000000, 8, 1000);
        factory.compute();
        System.out.println(factory.getTotalPrimes());
        System.out.println(factory.getTotalRunningTime());
        factory.presentStats();
    }
}
