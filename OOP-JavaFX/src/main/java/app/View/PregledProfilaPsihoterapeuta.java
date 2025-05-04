package app.View;

import javafx.scene.layout.VBox;

import javafx.scene.control.Label;

//ime, prezime, id, brojTelefona,fakultet, uze usmerenje, bool psiholog,datum rodjenja, prebivaliste.
public class PregledProfilaPsihoterapeuta extends VBox {
    private Label lblNaslov;
    private Label lblIme;
    private Label lblPrezime;
    private Label lblBrTelefona;
    private Label lblFakultet;
    private Label lblUzeUsmerenje;
    private Label lblDatumRodjenja;
    private Label lblPrebivaliste;
    private Label lblPsiholog;
    public PregledProfilaPsihoterapeuta(
            String ime,
            String prezime,
            String brojTelefona,
            String fakultet,
            String uzeUsmerenje,
            boolean psiholog,
            String datumRodjenja,
            String prebivaliste
    ) {
        lblNaslov = new Label("Profil psihoterapeuta");
        lblIme = new Label("Ime: " + ime);
        lblPrezime = new Label("Prezime: " + prezime);
        lblBrTelefona = new Label("Broj telefona: " + brojTelefona);
        lblFakultet = new Label("Fakultet: " + fakultet);
        lblUzeUsmerenje = new Label("Uže usmerenje: " + uzeUsmerenje);
        lblPsiholog = new Label("Psiholog: " + (psiholog ? "Da" : "Ne"));
        lblDatumRodjenja = new Label("Datum rođenja: " + datumRodjenja);
        lblPrebivaliste = new Label("Prebivalište: " + prebivaliste);


        this.setSpacing(10);


        this.getChildren().addAll(
                lblNaslov,
                lblIme,
                lblPrezime,
                lblBrTelefona,
                lblFakultet,
                lblUzeUsmerenje,
                lblPsiholog,
                lblDatumRodjenja,
                lblPrebivaliste
        );
    }
}
