public class Buyers {

    private int customerName;

    public void entered() {
        System.out.println("Покупатель " + customerName + " зашел в автосалон");
    }

    public void bought() {
        System.out.println("Покупатель " + customerName + " уехал на новеньком авто");
    }

    public int getCustomerName() {
        return customerName;
    }

    public void setCustomerName(int customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "name = " + customerName;
    }

    public Buyers(int name) {
        this.customerName = name;
    }

}
