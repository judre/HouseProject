/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author andre
 */
public class Order {
    
  int Order_orderId;
  int quantity;
  String legoBlockName;

    @Override
    public String toString() {
        return "Order{" + "User_userId=" + Order_orderId + ", quantity=" + quantity + ", legoBlockName=" + legoBlockName + '}';
    }

    public int getOrder_orderId() {
        return Order_orderId;
    }

    public void setOrder_orderId(int Order_orderId) {
        this.Order_orderId = Order_orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLegoBlockName() {
        return legoBlockName;
    }

    public void setLegoBlockName(String legoBlockName) {
        this.legoBlockName = legoBlockName;
    }

    public Order(int Order_orderId, int quantity, String legoBlockName) {
        this.Order_orderId = Order_orderId;
        this.quantity = quantity;
        this.legoBlockName = legoBlockName;
    }
}
