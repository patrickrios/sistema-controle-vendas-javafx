package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.dao.ListableEntity;
import model.dao.ProductDAO;
import model.entity.EntityList;
import model.entity.Product;
import model.exception.EmptyArrayListException;

import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HomepageController implements Initializable
{
    @FXML
    private Label labelCurrentDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Date currentDate = new Date();
        DateFormat dff = DateFormat.getDateInstance(DateFormat.FULL);
        labelCurrentDate.setText(dff.format(currentDate));
        testInit();
    }
    
    //test only, must be deleted
    private void testInit() {
    	EntityList list = new EntityList(new ProductDAO());
    	
    	System.out.println("number of products: "+list.getPaginationInfo());
    	
    	try {
			for(Object obj : list.getItems()) {
				Product p = (Product)obj;
				System.out.println("product {id="+p.getId()+", name="+p.getName()+", code="+p.getCode()+" sale price="+p.getSalePrice()+", quant="+p.getQuantiy()+", min quant="+p.getMinimumQuantity()+"}");
			}
		} catch (EmptyArrayListException e) {
			System.out.println(e.toString());
		}
    }
}
