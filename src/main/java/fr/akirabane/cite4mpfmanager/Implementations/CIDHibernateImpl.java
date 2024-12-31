package fr.akirabane.cite4mpfmanager.Implementations;

import fr.akirabane.cite4mpfmanager.interfaces.CID;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CIDHibernateImpl implements CID {

    private int value;

    public CIDHibernateImpl() {}

    public CIDHibernateImpl(int value) {
        if (value < 0 || value > 99999 || String.valueOf(value).length() != 5) {
            throw new IllegalArgumentException("CID doit être 5 numéros, exemple : 87194. Valeur donnée : " + value
                    + ". Votre CID donné est de " + String.valueOf(value).length() + " numéros.");
        }
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getFormattedValue() {
        return String.format("%05d", value);
    }

    @Override
    public String toString() {
        return getFormattedValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CIDHibernateImpl that = (CIDHibernateImpl) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
