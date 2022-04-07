package src.Order;

import src.Interface.Visitor;
import java.util.LinkedList;
import java.util.List;

//composite pattern
public class OrderGroup implements IOrder {
    private IOrder parrent;
    private List<IOrder> orders = new LinkedList<IOrder> ();
    
    public void addChild(IOrder child){
        orders.add(child);
        child.setParrent(this);
    }

    @Override
    public void setParrent(IOrder parrent) {
        this.parrent = parrent;
    }
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
        for (IOrder iOrder : orders) {
            iOrder.acceptVisitor(visitor);
        }
    }
   

    
}
