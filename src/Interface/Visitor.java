package src.Interface;

import src.Order.Order;
import src.Order.OrderGroup;

//visitor pattern
public interface Visitor {
    
    public void visit(Order order);
    public void visit(OrderGroup ordergroup);

}
