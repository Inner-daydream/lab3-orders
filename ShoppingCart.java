public class ShoppingCart {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        QuantityMonitor quantityMonitor = new QuantityMonitor(5, 10);
        PriceMonitor priceMonitor = new PriceMonitor(200, 20);
        manager.attach(priceMonitor, EventType.ITEM_ADDED);
        manager.attach(quantityMonitor, EventType.ITEM_ADDED);

        Order order = new Order(manager);
        order.addItem(100);
        System.out.println(order);
        order.addItem(101);
        order.addItem(33);
        order.addItem(10);
        System.out.println(order);
        for (int i = 0; i < 10; i++) {
            order.addItem(10);
        }
        System.out.println(order);
        Order secondOrder = new Order(manager);
        secondOrder.addItem(199);
        System.out.println(secondOrder);


    }
}
