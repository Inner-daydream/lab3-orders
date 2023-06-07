public class QuantityMonitor implements OrderObserver{
    int quantityThreshold;
    double discount;
    QuantityMonitor(int quantityThreshold, double discount) {
        this.quantityThreshold = quantityThreshold;
        this.discount = discount;
    }
    public void update(Order order) {      
        if (order.getCount() > quantityThreshold) {
            order.applyDiscount(this, discount);
        }
    }
}
