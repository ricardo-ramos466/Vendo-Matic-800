import com.techelevator.view.Chips;
import com.techelevator.view.Product;
import com.techelevator.view.PurchaseMenu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PurchaseMenuTest {

    private Product chips = new Chips("Stale Pringles", 1.75);
    private PurchaseMenu purchaseMenu = new PurchaseMenu();
    private BigDecimal bigDecimal = new BigDecimal(0);


    @Before
    public void prep(){
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        purchaseMenu.setCurrentMoney(new BigDecimal(10.00));
    }
    @Test
    public void when_change_is_dispensed_current_money_is_set_to_zero() {
//        Act - make sure that current money is set to zero
        purchaseMenu.getChange();

//        Assert - check current money is set to zero
        Assert.assertEquals(bigDecimal, purchaseMenu.getCurrentMoney());
    }


    @Test
    public void when_money_is_fed_current_money_is_updated() {
//        Act - make sure to reset current money to zero
        purchaseMenu.setCurrentMoney(new BigDecimal(0));
        purchaseMenu.feedMoney(4);
        bigDecimal = new BigDecimal(4);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//        Assert - check current money = 4
        Assert.assertEquals(bigDecimal, purchaseMenu.getCurrentMoney());

//        Act - feed it more monies
        purchaseMenu.feedMoney(2);
        bigDecimal = new BigDecimal(6);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

//        Assert - check current money = 6

    }


}
