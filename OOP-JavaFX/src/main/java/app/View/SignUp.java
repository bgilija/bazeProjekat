package app.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class SignUp  extends HBox {
    //psihoterapeut ima: psihoterapeut id, ime, prezime, mail ,da li je psiholog,
    // koji sertifikat ima* , broj telefona, datum rodjenja
//map<korisnicko ime, sifra
    private GridPane gridpane;
    private Label lblSignUp;
    private Label lbPrezime;
    private Label lbbrTelefona;

    private Label lbIme;
    private Label lbMail;
    private Label lbDatumRodjenja;
    private Label lbKorisnickoIme;
    private Label lbSifra;
    private TextField tfPrezime;
    private TextField tfbrTelefona;
    private  TextField tfIme;
    private TextField tfMail;
    private TextField tfDatumRodjenja;
    private TextField tfKorisnickoIme;
    private TextField tfSifra;
    private Button btnSignUp;
    public SignUp(){
        napraviElemente();
        dodajElemente();
        dodajAkcije();
    }

    private void napraviElemente()
    {
        lblSignUp=new Label("Sign up");
        lbbrTelefona=new Label("Broj telefona: ");
        lbSifra=new Label("Sifra:");
        lbDatumRodjenja=new Label("Datum rodjenja:");
        lbIme=new Label("Ime:");
        lbPrezime  = new Label("Prezime:");
        lbMail = new Label("E-mail:");
        lbKorisnickoIme = new Label("Korisnicko ime:");
        tfMail=new TextField();
        tfDatumRodjenja=new TextField();
        tfIme = new TextField();
        tfPrezime = new TextField();
        tfbrTelefona = new TextField();
        tfSifra = new TextField();
        tfKorisnickoIme = new TextField();
        btnSignUp = new Button("Sign up");
        gridpane = new GridPane();


    }

    private void dodajElemente()
    {
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.addColumn(0,lbIme, tfIme);
        gridpane.addColumn(1,lbPrezime, tfPrezime);
        gridpane.addColumn(2,lbbrTelefona, tfPrezime);
        gridpane.addColumn(3,lbMail, tfMail);
        gridpane.addColumn(4,lbDatumRodjenja, tfDatumRodjenja);
        gridpane.addColumn(5,lbKorisnickoIme, tfKorisnickoIme);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15,10,15,10));
        this.getChildren().addAll(lblSignUp,gridpane,btnSignUp);

    }
    private void dodajAkcije()
    {

    }
}
