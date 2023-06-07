import java.util.ArrayList;
import java.util.HashMap;

public class OrderManager {
    private HashMap<EventType, ArrayList<OrderObserver>> observers;
    public OrderManager() {
        this.observers = new HashMap<EventType, ArrayList<OrderObserver>>();
    }
    public void attach(OrderObserver observer, EventType type) {
        ArrayList<OrderObserver> subscribedObservers = this.observers.get(type);
        if (subscribedObservers == null) {
            subscribedObservers = new ArrayList<OrderObserver>();
        }
        subscribedObservers.add(observer);
        this.observers.put(type, subscribedObservers);
        
    }
    public void dettach(OrderObserver observer , EventType type) {
        ArrayList<OrderObserver> subscribedObservers = this.observers.get(type);
        if (subscribedObservers != null) {
            subscribedObservers.remove(observer);
        }
    }
    
    public void notifyObservers(Order order, EventType type) {
        ArrayList<OrderObserver> subscribedObservers = this.observers.get(type);
        if (subscribedObservers != null) {
            for (OrderObserver observer : subscribedObservers) {
                observer.update(order);
            }
        }
    }
}
