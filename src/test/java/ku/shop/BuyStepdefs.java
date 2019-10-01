package ku.shop;

import cucumber.api.PendingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("เรามีสินค้าเหล่านี้")
    public void เรามีสินค้าเหล่านี้(DataTable table){
        Map<String,Double> data = table.asMap(String.class, Double.class);

        for (String name : data.keySet()) {
            double price = data.get(name);
            catalog.addProduct(name, price,1);
        }


    }

    @Given("ฉันมี (.+) with ราคา (.+) บาท จำนวน (.+)")
    public void add_product_with_price_exists(String name, double price,int num) {
        catalog.addProduct(name, price,num);
    }

    @Given("a product (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price,1);
    }
    @When("ฉันต้องการเช็ค (.+) with quantity (.+)")
    public void เช็คสินค้าเหล่านี้(String name, int quant) throws NotEnoughProductException{
        Product prod = catalog.getProduct(name);
        if (prod.getNum()>=quant){
            order.addItem(prod, quant);
            prod.setNum(prod.getNum()-quant);
        }
    }

    @When("ฉันซื้อ (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }


    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
    @Then("ไม่สามารถซื้อได้เนื่องจากสินค้าไม่เพียงพอ")
    public void quantity_is_not_enough() throws NotEnoughProductException {
        //throw new NotEnoughProductException("สินค้าไม่เพียงพอ");
        //expectedEx.expectMessage("สินค้าไม่เพียงพอ");
    }
}

