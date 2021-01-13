package org.acme;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Input {
    
    private String person = null;
    private String address = null;
    private String secNumber = null;
    private boolean verifiedPerson = false;
    private boolean verifiedDebts = false;
    private boolean verifiedTaxes = false;
    private boolean verifiedPartners = false;


    Input(String person, String address, String secNumber){
        this.person = person;
        this.address = address;
        this.secNumber = secNumber;
    }

    /**
     * @return the person
     */
    public String getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(String person) {
        this.person = person;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the secNumber
     */
    public String getSecNumber() {
        return secNumber;
    }

    /**
     * @param secNumber the secNumber to set
     */
    public void setSecNumber(String secNumber) {
        this.secNumber = secNumber;
    }

    /**
     * @return the verifiedPerson
     */
    public boolean isVerifiedPerson() {
        return verifiedPerson;
    }

    /**
     * @param verifiedPerson the verifiedPerson to set
     */
    public void setVerifiedPerson(boolean verifiedPerson) {
        this.verifiedPerson = verifiedPerson;
    }

    /**
     * @return the verifiedDebts
     */
    public boolean isVerifiedDebts() {
        return verifiedDebts;
    }

    /**
     * @param verifiedDebts the verifiedDebts to set
     */
    public void setVerifiedDebts(boolean verifiedDebts) {
        this.verifiedDebts = verifiedDebts;
    }

    /**
     * @return the verifiedTaxes
     */
    public boolean isVerifiedTaxes() {
        return verifiedTaxes;
    }

    /**
     * @param verifiedTaxes the verifiedTaxes to set
     */
    public void setVerifiedTaxes(boolean verifiedTaxes) {
        this.verifiedTaxes = verifiedTaxes;
    }

    /**
     * @return the verifiedPartners
     */
    public boolean isVerifiedPartners() {
        return verifiedPartners;
    }

    /**
     * @param verifiedPartners the verifiedPartners to set
     */
    public void setVerifiedPartners(boolean verifiedPartners) {
        this.verifiedPartners = verifiedPartners;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Input [address=" + address + ", person=" + person + ", secNumber=" + secNumber + ", verifiedDebts="
                + verifiedDebts + ", verifiedPartners=" + verifiedPartners + ", verifiedPerson=" + verifiedPerson
                + ", verifiedTaxes=" + verifiedTaxes + "]";
    }

    
    



}
