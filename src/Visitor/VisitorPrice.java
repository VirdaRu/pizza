package src.Visitor;

import src.Interface.Visitor;
import src.Order.Order;
import src.Order.OrderGroup;

//visitor pattern
public class VisitorPrice implements Visitor{
    private double totalPrice = 0;

    @Override
    public void visit(Order order) {
        totalPrice += (order.getPizza().getCost() * order.getQuantity());        
    }

    @Override
    public void visit(OrderGroup ordergroup) {
        // TODO Auto-generated method stub
        
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    
}
