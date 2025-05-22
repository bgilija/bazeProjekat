package app.View;

import app.App;
import app.Model.SeansaPrikaz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PregledSeansi extends VBox {

    private TableView<SeansaPrikaz> table;
    private ObservableList<SeansaPrikaz> listaSeansi;
    private Button btnPrikazi;
    private Button btnBack;
    private int seansaID;

    public PregledSeansi() {
        napraviElemente();
        napraviTabelu();
        dodajElemente();
        dodajAkcije();
        ucitajSeanseIzBaze();

    }
    private void napraviElemente()
    {
        listaSeansi = FXCollections.observableArrayList();
        table = new TableView<>(listaSeansi);
        btnBack = new Button("Back");
        btnPrikazi = new Button("Opstiji prikaz senase");
        btnPrikazi.setFont(new Font(15));
        btnBack.setFont(new Font(15));
    }
    private void dodajElemente()
    {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setSpacing(10);
        this.getChildren().addAll(table,btnPrikazi,btnBack);
    }

    private void dodajAkcije(){
        btnBack.setOnAction(e->{
            Scene scene=new Scene(new Informacije());
            App.stage.setScene(scene);
        });
        btnPrikazi.setOnAction(e->{
            seansaID= table.getSelectionModel().getSelectedItem().getSeansaId();
            Scene scene=new Scene(new OpstijiPregledSeanse(seansaID));

            App.stage.setScene(scene);
        });
    }
    private void napraviTabelu() {
        table.setMinWidth(800);

        TableColumn<SeansaPrikaz, Integer> colId = new TableColumn<>("ID Seanse");
        colId.setCellValueFactory(new PropertyValueFactory<>("seansaId"));

        TableColumn<SeansaPrikaz, LocalDate> colDatum = new TableColumn<>("Datum");
        colDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));

        TableColumn<SeansaPrikaz, LocalTime> colVreme = new TableColumn<>("Vreme");
        colVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));

        TableColumn<SeansaPrikaz, Integer> colTrajanje = new TableColumn<>("Trajanje (min)");
        colTrajanje.setCellValueFactory(new PropertyValueFactory<>("trajanje"));

        TableColumn<SeansaPrikaz, Integer> colBroj = new TableColumn<>("Broj seanse");
        colBroj.setCellValueFactory(new PropertyValueFactory<>("broj"));

        TableColumn<SeansaPrikaz, String> colBeleska = new TableColumn<>("Beleška");
        colBeleska.setCellValueFactory(new PropertyValueFactory<>("beleska"));

        TableColumn<SeansaPrikaz, String> colImeKlijenta = new TableColumn<>("Ime klijenta");
        colImeKlijenta.setCellValueFactory(new PropertyValueFactory<>("imeKlijenta"));

        TableColumn<SeansaPrikaz, String> colPrezimeKlijenta = new TableColumn<>("Prezime klijenta");
        colPrezimeKlijenta.setCellValueFactory(new PropertyValueFactory<>("prezimeKlijenta"));

        TableColumn<SeansaPrikaz, String> colImeKandidata = new TableColumn<>("Ime kandidata");
        colImeKandidata.setCellValueFactory(new PropertyValueFactory<>("imeKandidata"));

        TableColumn<SeansaPrikaz, String> colPrezimeKandidata = new TableColumn<>("Prezime kandidata");
        colPrezimeKandidata.setCellValueFactory(new PropertyValueFactory<>("prezimeKandidata"));

        table.getColumns().addAll(
                colId, colDatum, colVreme, colTrajanje, colBroj, colBeleska,
                colImeKlijenta, colPrezimeKlijenta, colImeKandidata, colPrezimeKandidata
        );
    }

    private void ucitajSeanseIzBaze() {
        String upit = "SELECT s.seansa_id, s.datum_seanse, s.vreme_seanse, " +
                "s.trajanje_u_minutima, s.br_seanse, s.beleska, " +
                "k.ime AS imeKlijenta, k.prezime AS prezimeKlijenta, " +
                "ka.ime AS imeKandidata, ka.prezime AS prezimeKandidata " +
                "FROM Seansa s " +
                "JOIN Klijent k ON s.Klijent_klijent_jmbg = k.klijent_jmbg " +
                "JOIN Kandidat ka ON s.Kandidat_jmbg = ka.jmbg";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(upit);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SeansaPrikaz sp = new SeansaPrikaz();
                sp.setSeansaId(rs.getInt("seansa_id"));
                sp.setDatum(rs.getDate("datum_seanse").toLocalDate());
                sp.setVreme(rs.getTime("vreme_seanse").toLocalTime());
                sp.setTrajanje(rs.getInt("trajanje_u_minutima"));
                sp.setBroj(rs.getInt("br_seanse"));
                sp.setBeleska(rs.getString("beleska"));
                sp.setImeKlijenta(rs.getString("imeKlijenta"));
                sp.setPrezimeKlijenta(rs.getString("prezimeKlijenta"));
                sp.setImeKandidata(rs.getString("imeKandidata"));
                sp.setPrezimeKandidata(rs.getString("prezimeKandidata"));
                listaSeansi.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
