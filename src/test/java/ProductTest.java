import com.techelevator.view.*;
import junit.framework.Assert;
import org.junit.Test;

public class ProductTest {
    private Product chips = new Chips("Pringles", 1.68);
    private Product beverage = new Beverages("Watermelon Soda", 2.05);
    private Product Gum = new Gum("Hubba Bubba", 0.95);
    private Product candy = new Candy("Reeses Pieces", 3.68);
    private int amountSold;

    private int quantity;

    @Test
    public void when_Chips_is_sold_updates_quantity() {
//        Act - Testing must have quantity of 5 at beginning
        quantity = chips.getQuantity();

//        Assert - Quantity must equal 5
        Assert.assertEquals(5, quantity);

//        Act - One sold. Quantity must be 4.
        chips.sold();
        quantity = chips.getQuantity();

//        Assert - Quantity must equal 4.
        Assert.assertEquals(4, quantity);

//        Act - Two more sold. Quantity must be 2.
        chips.sold();
        chips.sold();
        quantity = chips.getQuantity();

//        Assert - Quantity must equal 2.
        Assert.assertEquals(2, quantity);
    }

    @Test
    public void when_Beverage_is_sold_updates_quantity() {
//        Act - Testing must have quantity of 5 at beginning
        quantity = beverage.getQuantity();

//        Assert - Quantity must equal 5
        Assert.assertEquals(5, quantity);

//        Act - One sold. Quantity must be 4.
        beverage.sold();
        quantity = beverage.getQuantity();

//        Assert - Quantity must equal 4.
        Assert.assertEquals(4, quantity);

//        Act - Two more sold. Quantity must be 2.
        beverage.sold();
        beverage.sold();
        quantity = beverage.getQuantity();

//        Assert - Quantity must equal 2.
        Assert.assertEquals(2, quantity);
    }
    @Test
    public void when_Gum_is_sold_updates_quantity() {
//        Act - Testing must have quantity of 5 at beginning
        quantity = Gum.getQuantity();

//        Assert - Quantity must equal 5
        Assert.assertEquals(5, quantity);

//        Act - One sold. Quantity must be 4.
        Gum.sold();
        quantity = Gum.getQuantity();

//        Assert - Quantity must equal 4.
        Assert.assertEquals(4, quantity);

//        Act - Two more sold. Quantity must be 2.
        Gum.sold();
        Gum.sold();
        quantity = Gum.getQuantity();

//        Assert - Quantity must equal 2.
        Assert.assertEquals(2, quantity);
    }

    @Test
    public void when_Candy_is_sold_updates_quantity() {
//        Act - Testing must have quantity of 5 at beginning
        quantity = candy.getQuantity();

//        Assert - Quantity must equal 5
        Assert.assertEquals(5, quantity);

//        Act - One sold. Quantity must be 4.
        candy.sold();
        quantity = candy.getQuantity();

//        Assert - Quantity must equal 4.
        Assert.assertEquals(4, quantity);

//        Act - Two more sold. Quantity must be 2.
        candy.sold();
        candy.sold();
        quantity = candy.getQuantity();

//        Assert - Quantity must equal 2.
        Assert.assertEquals(2, quantity);
    }

    @Test
    public void chips_amount_sold_is_updated_after_sale() {
//        Act - Testing must have quantity of 5 at beginning
        chips.setQuantity(5);
        amountSold = chips.getAmountSold();


//        Act - One sold. Quantity must be 4.
        chips.sold();
        quantity = chips.getQuantity();

//        Assert - Amount sold must be 1
        Assert.assertEquals(1, chips.getAmountSold());

//        Act - Two more sold. Quantity must be 2.
        chips.sold();
        chips.sold();
        quantity = chips.getQuantity();

//        Assert - Amount sold must equal 3.
        Assert.assertEquals(3, chips.getAmountSold());
    }

    @Test
    public void beverage_amount_sold_is_updated_after_sale() {
//        Act - Testing must have quantity of 5 at beginning
        beverage.setQuantity(5);
        amountSold = beverage.getAmountSold();


//        Act - One sold. Quantity must be 4.
        beverage.sold();
        quantity = beverage.getQuantity();

//        Assert - Amount sold must be 1
        Assert.assertEquals(1, beverage.getAmountSold());

//        Act - Two more sold. Quantity must be 2.
        beverage.sold();
        beverage.sold();
        quantity = beverage.getQuantity();

//        Assert - Amount sold must equal 3.
        Assert.assertEquals(3, beverage.getAmountSold());
    }

    @Test
    public void gum_amount_sold_is_updated_after_sale() {
//        Act - Testing must have quantity of 5 at beginning
        Gum.setQuantity(5);
        amountSold = Gum.getAmountSold();


//        Act - One sold. Quantity must be 4.
        Gum.sold();
        quantity = Gum.getQuantity();

//        Assert - Amount sold must be 1
        Assert.assertEquals(1, Gum.getAmountSold());

//        Act - Two more sold. Quantity must be 2.
        Gum.sold();
        Gum.sold();
        quantity = Gum.getQuantity();

//        Assert - Amount sold must equal 3.
        Assert.assertEquals(3, Gum.getAmountSold());
    }

    @Test
    public void candy_amount_sold_is_updated_after_sale() {
//        Act - Testing must have quantity of 5 at beginning
        candy.setQuantity(5);
        amountSold = candy.getAmountSold();


//        Act - One sold. Quantity must be 4.
        candy.sold();
        quantity = candy.getQuantity();

//        Assert - Amount sold must be 1
        Assert.assertEquals(1, candy.getAmountSold());

//        Act - Two more sold. Quantity must be 2.
        candy.sold();
        candy.sold();
        quantity = candy.getQuantity();

//        Assert - Amount sold must equal 3.
        Assert.assertEquals(3, candy.getAmountSold());
    }
}