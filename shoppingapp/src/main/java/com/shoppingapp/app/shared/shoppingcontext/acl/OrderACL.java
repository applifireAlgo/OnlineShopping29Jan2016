package com.shoppingapp.app.shared.shoppingcontext.acl;
import com.shoppingapp.app.shared.onlineshopping.Cart;
import java.util.List;
import com.shoppingapp.app.shared.onlineshopping.OrderMain;

public class OrderACL {

    public OrderACL(List<Cart> _cart) {
        this.cartInput = _cart;
        this.doMapping();
    }

    private List<Cart> cartInput;

    private OrderMain ordermainOutput;

    public OrderMain getOrder() {
        return ordermainOutput;
    }

    public void doMapping() {
        ordermainOutput = new OrderMain();
        java.util.List<com.shoppingapp.app.shared.onlineshopping.OrderDetails> lstorderDetailsEntities = new java.util.ArrayList<com.shoppingapp.app.shared.onlineshopping.OrderDetails>();
        for (com.shoppingapp.app.shared.onlineshopping.Cart _orderDetails : cartInput) {
            com.shoppingapp.app.shared.onlineshopping.OrderDetails orderdetails = new com.shoppingapp.app.shared.onlineshopping.OrderDetails();
            orderdetails.setItemId(_orderDetails.getItemId());
            orderdetails.setItemPrice(_orderDetails.getItemPrice());
            orderdetails.setItemQuantity(_orderDetails.getItemQuantity());
            orderdetails.setSubTotal(_orderDetails.getSubTotal());
            lstorderDetailsEntities.add(orderdetails);
        }
        ordermainOutput.setOrderDetails(lstorderDetailsEntities);
    }
}
