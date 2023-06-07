public class PriceMonitor implements OrderObserver {
    double discount;
    double priceThreshold;
    PriceMonitor(double priceThreshold, double discount) {
        this.priceThreshold = priceThreshold;
        this.discount = discount;
    }
    public void update(Order order) {
        if (order.getTotalCost() > priceThreshold) {
            order.applyDiscount(discount);
        }
    }
}
