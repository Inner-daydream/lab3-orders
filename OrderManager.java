import java.util.ArrayList;
import java.util.HashMap;

public class OrderManager {
    private HashMap<EventType, ArrayList<Order>> orders;
    public OrderManager() {
    }
    public void attach(OrderObserver observer, EventType type) {
    }
    public void dettach(OrderObserver observer , EventType type) {
    }

}
