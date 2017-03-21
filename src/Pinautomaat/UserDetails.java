// This class acts as a model class,holding getters,setters and properties
package Pinautomaat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author admin
 */
public class UserDetails {

    private final StringProperty Naam;
    private final StringProperty IBAN;
    private final StringProperty SALDO;

    //Default constructor
    public UserDetails(String Naam, String IBAN, String SALDO) {
        this.Naam = new SimpleStringProperty(Naam);
        this.IBAN = new SimpleStringProperty(IBAN);
        this.SALDO = new SimpleStringProperty(SALDO);
    }

    //Getters
    public String getNaam() {
        return Naam.get();
    }

    public String getIBAN() {
        return IBAN.get();
    }

    public String getSALDO() {
        return SALDO.get();
    }

    //Setters
    public void setNaam(String value) {
        Naam.set(value);
    }

    public void setIBAN(String value) {
        IBAN.set(value);
    }

    public void setSALDO(String value) {
        SALDO.set(value);
    }

    //Property values
    public StringProperty naamProperty() {
        return Naam;
    }

    public StringProperty IBANProperty() {
        return IBAN;
    }

    public StringProperty SALDOProperty() {
        return SALDO;
    }
}
