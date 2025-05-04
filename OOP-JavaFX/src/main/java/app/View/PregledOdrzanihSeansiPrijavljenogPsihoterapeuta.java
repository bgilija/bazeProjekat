package app.View;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PregledOdrzanihSeansiPrijavljenogPsihoterapeuta extends  HBox{
    private ComboBox<String> cbPsihoterapeuti;
    private Label lbNaslov;
    private Label lbIzborPsihoterapeuta;
    private Button btnIzaberi;
    private ObservableList<String> olSenase;
    private TableView twSeanse;
    private VBox vb;
    private VBox vb2;
    private HBox hb;

    public PregledOdrzanihSeansiPrijavljenogPsihoterapeuta(){
        napraviElemente();
        dodajElemente();
        dodajAkcije();
    }

    private void napraviElemente()
    {
        lbIzborPsihoterapeuta = new Label("Izaberite psihoterapeuta");
        lbNaslov = new Label("Pregled odrzabih seansi");
        btnIzaberi = new Button("Izaberi");
        twSeanse.setMinWidth(400);
        twSeanse = new TableView<>(olSenase);
        vb = new VBox();
        vb.setPadding(new Insets(15,10,15,10));
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(15,10,15,10));
        hb.setSpacing(10);
        vb2 = new VBox();
        vb2.setPadding(new Insets(15,10,15,10));
        vb2.setAlignment(Pos.CENTER);
        vb2.setSpacing(10);
        cbPsihoterapeuti = new ComboBox<>();
        //TODO dodati iteme u comboBox i zavrsiti tabelu
    /*
        TableColumn<**, String> col1 = new TableColumn<>("nazivkolone");
        TableColumn<** , String> col2 = new TableColumn<>("nazivkolone");
        TableColumn<**, String> col3 = new TableColumn<>("nazivkolone");

        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("kontinent"));
        col3.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        twNoviKlijenti.getColumns().addAll(col1, col2, col3);

     */
    }

    private void dodajElemente()
    {
        vb2.getChildren().addAll(lbIzborPsihoterapeuta, cbPsihoterapeuti);
        hb.getChildren().addAll(vb2, btnIzaberi);
        vb.getChildren().addAll(hb, twSeanse);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15,10,15,10));
        this.setSpacing(15);
        this.getChildren().addAll(lbNaslov, vb);
    }

    private void dodajAkcije()
    {

    }

}
