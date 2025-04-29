package app.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PPPshihoterapeuti extends VBox {
    private Label labela;
    //todo napaviti klasu psihoterapeut
    private TableView<String> tvPsihoterapeuti;
    private Button btnPocetna;
    private Button btnSort;
    private ObservableList<String> olPsihoterapeuti;
    private HBox hBox;

    public PPPshihoterapeuti() {
        napraviElemente();
        dodajElemente();
        dodajAkcije();
    }
    private void napraviElemente()
    {
        labela = new Label("Pregled podataka o psihoterapeutima Savetovališta");
        btnSort = new Button("Sortiraj");
        btnPocetna = new Button("Pocetna");
        //olPsihoterapeuti = FXCollections.observableList(Baza.getInstancOf.getPsihoterapeuti());
        tvPsihoterapeuti.setMinWidth(500);
        tvPsihoterapeuti = new TableView<>(olPsihoterapeuti);
        hBox=new HBox(5);
        hBox.setPadding(new Insets(15, 10, 10, 15));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btnPocetna, btnSort);
    /*
        TableColumn<Psihoterapeut, String> col1 = new TableColumn<>("nazivkolone");
        TableColumn<Psihoterapeut , String> col2 = new TableColumn<>("nazivkolone");
        TableColumn<Psihoterapeut, String> col3 = new TableColumn<>("nazivkolone");

        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("kontinent"));
        col3.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        tvPsihoterapeuti.getColumns().addAll(col1, col2, col3);

     */

    }
    private void dodajElemente()
    {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15, 10, 10, 15));
        this.getChildren().addAll(labela,tvPsihoterapeuti,hBox);
    }


    private void dodajAkcije()
    {

    }

}
