package src.Order;

import src.Interface.Visitor;
//composite pattern
public interface IOrder {

    public void setParrent(IOrder parrent);
    public void acceptVisitor(Visitor visitor);
}