public class PriceMonitor implements OrderObserver {
    OrderManager manager;
    double discount;
    double priceThreshold;
    PriceMonitor(double priceThreshold, double discount) {
        this.priceThreshold = priceThreshold;
        this.discount = discount;
    }
    public void update(Order order) {
        if (order.getTotalCost() > priceThreshold) {
            order.applyDiscount(this, discount);

        }
    }
}
