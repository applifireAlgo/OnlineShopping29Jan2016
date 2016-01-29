package com.shoppingapp.app.server.businessservice.shoppingcontext.onlineshopping;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.shoppingapp.app.server.repository.CartRepository;
import com.shoppingapp.app.server.repository.ItemRepository;
import com.shoppingapp.app.shared.onlineshopping.Cart;
import com.shoppingapp.app.shared.onlineshopping.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AddToCartService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private CartRepository<Cart> cartRepository;

    public void addToCart(Cart entity) throws SpartanBusinessValidationFailedException, SpartanPersistenceException, Exception {
        if (entity.getItemQuantity() <= 0) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3007");
        }
        com.shoppingapp.app.shared.onlineshopping.Item item = itemRepository.findById(entity.getItemId());
        if (entity.getItemQuantity() > item.getItemStock()) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3008");
        }
        if (entity.getItemQuantity() != null) {
            entity.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
            entity.setItemPrice(item.getItemPrice());
            entity.setSubTotal(item.getItemPrice() * entity.getItemQuantity());
            com.shoppingapp.app.shared.onlineshopping.Cart cart1 = cartRepository.save(entity);
        }
    }
}
