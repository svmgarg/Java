package collections.identityHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        CreditCard visa = new CreditCard("VISA", "04/12/2019");
        CreditCard master = new CreditCard("Master", "04/11/2020");
        CreditCard amex = new CreditCard("American Express", "04/10/2021");
        Map<CreditCard, String> cardToExpiry = new HashMap<>();
        Map<CreditCard, String> cardToExpiryIdenity = new IdentityHashMap<>(); // inserting objects to HashMap
        cardToExpiry.put(visa, visa.getExpiryDate());
        cardToExpiry.put(master, master.getExpiryDate());
        cardToExpiry.put(amex, amex.getExpiryDate()); // inserting objects to IdentityHashMap
        cardToExpiryIdenity.put(visa, visa.getExpiryDate());
        cardToExpiryIdenity.put(master, master.getExpiryDate());
        cardToExpiryIdenity.put(amex, amex.getExpiryDate());
        System.out.println("before modifying keys");
        String result = cardToExpiry.get(visa) != null ? "Yes" : "No";
        System.out.println("Does VISA card exists in HashMap? " + result);
        result = cardToExpiryIdenity.get(visa) != null ? "Yes" : "No";
        System.out.println("Does VISA card exists in IdenityHashMap? " + result); // modifying value object
        visa.setExpiryDate("02/11/2030");
        System.out.println("after modifying keys");
        result = cardToExpiry.get(visa) != null ? "Yes" : "No";
        System.out.println("Does VISA card exists in HashMap? " + result);
        result = cardToExpiryIdenity.get(visa) != null ? "Yes" : "No";
        System.out.println("Does VISA card exists in IdenityHashMap? " + result);
    }
}

class CreditCard {
    private String issuer;
    private String expiryDate;

    public CreditCard(String issuer, String expiryDate) {
        this.issuer = issuer;
        this.expiryDate = expiryDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiry) {
        this.expiryDate = expiry;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
        result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CreditCard other = (CreditCard) obj;
        if (expiryDate == null) {
            if (other.expiryDate != null) return false;
        } else if (!expiryDate.equals(other.expiryDate)) return false;
        if (issuer == null) {
            if (other.issuer != null) return false;
        } else if (!issuer.equals(other.issuer)) return false;
        return true;
    }

}
