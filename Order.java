import java.util.concurrent.atomic.AtomicLong;
public class Order {
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    final long id = NEXT_ID.getAndIncrement();
    private int itemCount;
    private double itemCost;
    private OrderManager manager;

    Order(OrderManager manager) {
        this.manager = manager;
    }

    public int getCount() {
        return itemCount;
    }
    public  void applyDiscount(double discount) {
        itemCost -= discount;
    }
    public double getTotalCost() {
        return itemCost;
    }
    public void addItem(double price) {
        itemCount++;
        itemCost += price;
        manager.notifyObservers(this, EventType.ITEM_ADDED);
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", itemCount=" + itemCount + ", itemCost=" + itemCost + "]";
    }
}
