package app.View;

import app.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Informacije extends VBox {
    private Button btnpregledPsihoterapeuta;
    private Button btnPregledSeanse;
    private Button btnPregledPlacanja;
    private Button btnBack;

    public Informacije() {
        napraviElemente();
        dodajElemente();
        dodajAkcije();
    }

    private  void napraviElemente()
    {
        btnpregledPsihoterapeuta=new Button("Pregled psihoterapeuta");
        btnPregledPlacanja = new Button("Pregled svih pacanja");
        btnPregledSeanse = new Button("Pregled seansi");
        btnBack = new Button("Back");
    }
    private void dodajElemente()
    {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15,15,15,15));
        this.setSpacing(25);
        this.getChildren().addAll(btnPregledPlacanja,btnpregledPsihoterapeuta,btnPregledSeanse,btnBack);
        this.setMinHeight(600);
        this.setMinWidth(300);
    }
    private void dodajAkcije()
    {
        btnPregledPlacanja.setOnAction(e -> {
            Scene scene = new Scene(new PregledUplataIDugovanjaKlijenata());
            App.stage.setScene(scene);
        });
        btnpregledPsihoterapeuta.setOnAction(e -> {
            Scene scene = new Scene(new PPPshihoterapeuti());
            App.stage.setScene(scene);
        });
        btnPregledSeanse.setOnAction(e -> {
            Scene scene = new Scene(new PregledSeansi());
            App.stage.setScene(scene);
        });
        btnBack.setOnAction(e -> {
            Scene scene = new Scene(new PocetniEkran());
            App.stage.setScene(scene);
        });


    }
}
