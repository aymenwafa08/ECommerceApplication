package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestProductinCart extends BaseTestClass{
	
  @Test(priority=0)
  public void selectsearchoption() throws InterruptedException {
	  Thread.sleep(3000);
	  selectcategory.selectmenu();
  }
  @Test(priority=1)
  public void productselection() throws InterruptedException {
	 products.selectdress();
	 Thread.sleep(2000);
	 productdetails.selectdresssize();
  }
  @Test(priority=2)
  public void addproductinbasket() throws InterruptedException {
	 productdetails.Addproducttobasket();
	 Thread.sleep(2000);
	 productinbasket.productinCart("Successfully added to your basket");
  }
}
