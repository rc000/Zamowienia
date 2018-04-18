package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.persistence.TypedQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import klienci.Address;
import klienci.Klient;
import zamowienia.Zamowienie;

public class ControllShowClientOrders  implements Initializable{

	@FXML
	private TableView<Zamowienie> tvOrders;
	@FXML
	private TableColumn<Zamowienie, Integer> tcId;
	@FXML
	private TableColumn<Zamowienie, String> tcName;
	@FXML
	private TableColumn<Zamowienie, String> tcColor;
	@FXML
	private TableColumn<Zamowienie, String> tcDimensions;
	@FXML
	private TableColumn<Zamowienie, Double> tcQuantity;
	@FXML
	private TableColumn<Zamowienie, Double> tcPrice;
	@FXML
	private TableColumn<Zamowienie, Double> tcCost;
	Klient klient;

	private ObservableList<Zamowienie> lista;

	private List<Zamowienie> znalezione;
	
	public ObservableList<Zamowienie> getProduct(List<Zamowienie> znalezione) {
		lista = FXCollections.observableArrayList();

		if (znalezione != null) {
			for (Zamowienie z : znalezione) {
				
				 
				  
					lista.add(z);

				//lista1.add(k.getAddress());
			}
		}
		return lista;
	}
	public void bl()
	{
		System.out.println("sdsd");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}

public void show()
{
	znalezione = new Vector<Zamowienie>();
	Main.getC().createEM();
 	 TypedQuery<Zamowienie> query= Main.getC().getEm().createQuery("select z from Zamowienie z where z.klientId=:idklient",Zamowienie.class);
	 query.setParameter("idklient", klient.getId());
	 //TypedQuery<Zamowienie> query= Main.getC().getEm().createQuery("select z from Zamowienie z",Zamowienie.class);

 	 znalezione =query.getResultList();
 	System.out.println( znalezione.size());
      tcId.setCellValueFactory(new PropertyValueFactory<Zamowienie,Integer>("id"));
      tcName.setCellValueFactory(new PropertyValueFactory<Zamowienie,String>("nazwa"));
      tcName.setCellValueFactory(new PropertyValueFactory<Zamowienie,String>("nazwa"));
      tcColor.setCellValueFactory(new PropertyValueFactory<Zamowienie,String>("Kolor"));
      tcDimensions.setCellValueFactory(new PropertyValueFactory<Zamowienie,String>("wymiary"));
      tcQuantity.setCellValueFactory(new PropertyValueFactory<Zamowienie,Double>("ilosc"));
      tcPrice.setCellValueFactory(new PropertyValueFactory<Zamowienie,Double>("cena"));
      tcCost.setCellValueFactory(new PropertyValueFactory<Zamowienie,Double>("koszt"));
	    tvOrders.setItems(getProduct(znalezione));
        Main.getC().close();

}
	public Klient getKlient() {
		return klient;
	}


	public void setKlient(Klient klient) {
		this.klient = klient;
	}

}
