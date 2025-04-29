package app.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LogIn extends HBox {
    private Label lblKorisnickoIme;

    private GridPane gp;
    private Label lblSifra;
    private TextField tfKorisnickoIme;
    private TextField tfSifra;
    private Button btnLogIn;
    private Label lblLogIn;
    public LogIn()
        {
            napraviElemente();
            dodajElemente();
            dodajAkcije();
        }

        private void napraviElemente()
        {
            gp=new GridPane();
            lblLogIn=new Label("Log in:");
            lblKorisnickoIme=new Label("Korisnicko ime:");
            lblSifra = new Label("Sifra:");
            tfSifra = new TextField();
            tfKorisnickoIme = new TextField();
            btnLogIn=new Button("log in");
        }

        private void dodajElemente()
        {
            gp.setVgap(10);
            gp.setHgap(10);
            gp.setAlignment(Pos.CENTER);
            gp.setPadding(new Insets(15,10,15,10));
            gp.addColumn(0, lblKorisnickoIme,tfKorisnickoIme);
            gp.addColumn(1, lblSifra, tfSifra);
            this.setAlignment(Pos.CENTER);
            this.setPadding(new Insets(15,10,15,10));
            this.setMinWidth(400);
            this.setMinHeight(500);
            this.getChildren().addAll(lblLogIn, gp, btnLogIn);

        }

        private void dodajAkcije()
        {

        }


}
