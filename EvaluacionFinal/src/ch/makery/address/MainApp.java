package ch.makery.address;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonOverviewController;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

	private final ObservableList<Person> personData = FXCollections.observableArrayList();

	public MainApp() {
		// Add some sample data
		personData.add(new Person("Robert", "Urpi"));
		personData.add(new Person("Steve", "Chan"));
		personData.add(new Person("Ji", "Yon"));
		personData.add(new Person("Oliver", "Lien"));
		personData.add(new Person("Timo", "Opus"));
		personData.add(new Person("Luis", "Oviedo"));
		personData.add(new Person("Adriel", "Gonzales"));
		personData.add(new Person("Pepo", "Chauca"));
		personData.add(new Person("Aldair", "Martinez"));
	}
  

	public ObservableList<Person> getPersonData() {
		return personData;
	}
public boolean showPersonEditDialog(Person person) 
{
    try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

  
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        PersonEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPerson(person);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
  
    @Override
public void start(Stage primaryStage) 
{
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("AgendaApp");


    this.primaryStage.getIcons().add(new Image("file:resources/images/agenda iconoagenda.png"));

    initRootLayout();

    showPersonOverview();
}


    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}