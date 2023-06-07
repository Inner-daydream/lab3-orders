public class Order {
    private int id;
    private int itemCount;
    private double itemCost;
    
    public int getCount() {
        return itemCount;
    }
    public double getTotalCost() {
        return itemCost;
    }
    public void addItem(double price) {
    }
    @Override
    public String toString() {
        return "";
    }
    public void notifyObservers() {

    }
}
