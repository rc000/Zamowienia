package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.TypedQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import klienci.Address;
import klienci.Klient;
import zamowienia.Zamowienie;

public class ControllChooseClient implements Initializable {
	@FXML
	private TableView<Klient> tvClients;

	@FXML
	private TableColumn<Klient, String> tcName;
	@FXML
	private TableColumn<Klient, String> tcSurname;
	@FXML
	private TableColumn<Klient, String> tcStreet;
	@FXML
	private TableColumn<Klient, String> tcNrHome;
	@FXML
	private TableColumn<Klient, String> tcPlace;
	@FXML
	private TableColumn<Klient, String> tcPhone;
	@FXML
	private TableColumn<Klient, Integer> tcIDClient;
	@FXML
	private TableColumn<Klient, Integer> tcOrders;
	@FXML
	private Button bSelectClient;
	Klient klient_found;
	private ObservableList<Klient> lista;

	private List<Klient> znalezione;

	public ObservableList<Klient> getProduct(List<Klient> znalezione) {
		lista = FXCollections.observableArrayList();

		if (znalezione != null) {
			for (Klient k : znalezione) {

				TypedQuery<Address> query = Main.getC().getEm()
						.createQuery("select a from Address a where a.id=:idklient", Address.class);
				query.setParameter("idklient", k.getId());
				Address ad = query.getSingleResult();
				k.setAdres(ad);
				lista.add(k);

				// lista1.add(k.getAddress());
			}
		}
		return lista;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Main.getC().createEM();

		TypedQuery<Klient> query = Main.getC().getEm().createQuery("select k from Klient k", Klient.class);
		znalezione = query.getResultList();

		tcIDClient.setCellValueFactory(new PropertyValueFactory<Klient, Integer>("id"));
		tcName.setCellValueFactory(new PropertyValueFactory<Klient, String>("imie"));
		tcSurname.setCellValueFactory(new PropertyValueFactory<Klient, String>("nazwisko"));
		tcPhone.setCellValueFactory(new PropertyValueFactory<Klient, String>("nrtel"));
		tcOrders.setCellValueFactory(new PropertyValueFactory<Klient, Integer>("liczba_zamowien"));

		tcStreet.setCellValueFactory(cellData -> cellData.getValue().getAddress().ulicaProperty());
		tcNrHome.setCellValueFactory(cellData -> cellData.getValue().getAddress().nrDomuProperty());
		tcPlace.setCellValueFactory(cellData -> cellData.getValue().getAddress().miastoProperty());
		tvClients.setItems(getProduct(znalezione));
		// tvClients.setItems(getProduct1(znalezione1));

		// tcName.setCellValueFactory(new
		// PropertyValueFactory<Klient,String>("imie"));
		Main.getC().close();
	}

	@FXML
	public void ActionSelectClient(ActionEvent event) throws InterruptedException, Exception {


		Klient klient = tvClients.getSelectionModel().getSelectedItem();
		System.out.println(klient.getId());
       // 

       /* URL dodawanie = getClass().getResource("AddOrder.fxml");
		AnchorPane bar = FXMLLoader.load(dodawanie);
		*/
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/fxml/AddOrder.fxml"));
	        AnchorPane aPane = loader.load();

	        ControllAddOrder controller = loader.getController();
	        controller.bl();
	        controller.setKlient(klient);
		BorderPane border = Main.getBorder();
		border.setCenter(aPane);
       


	}

}
