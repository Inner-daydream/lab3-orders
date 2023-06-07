import java.util.concurrent.atomic.AtomicLong;
import java.util.Set;
public class Order {
    static final AtomicLong NEXT_ID = new AtomicLong(0);
    final long id = NEXT_ID.getAndIncrement();
    private int itemCount;
    private double itemCost;
    private OrderManager manager;
    private Set<OrderObserver> appliedDiscounts;

    Order(OrderManager manager) {
        this.manager = manager;
        this.appliedDiscounts = new java.util.HashSet<OrderObserver>();
    }

    public int getCount() {
        return itemCount;
    }
    public void applyDiscount(OrderObserver observer, double discount) {
        if (!appliedDiscounts.contains(observer)) {
            itemCost -= discount;
            appliedDiscounts.add(observer);
        }
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
