package org.acme;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;


public class Input {
    
    private String person = null;
    private String address = null;
    private String secNumber = null;
    private boolean verifiedPerson = false;
    private boolean verifiedDebts = false;
    private boolean verifiedTaxes = false;
    private boolean verifiedPartners = false;

    private String key;

    @ProtoFactory
    public Input(String person, String address, String secNumber, boolean verifiedPerson, boolean verifiedDebts, boolean verifiedTaxes, boolean verifiedPartners) {
        this.person = person;
        this.address = address;
        this.secNumber = secNumber;
        this.verifiedPerson = verifiedPerson;
        this.verifiedDebts = verifiedDebts;
        this.verifiedTaxes = verifiedTaxes;
        this.verifiedPartners = verifiedPartners;
    }

    public String getKey(){
        return person+secNumber;
    }

    @ProtoField(number = 1)
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }

    @ProtoField(number = 2)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @ProtoField(number = 3)
    public String getSecNumber() {
        return secNumber;
    }
    public void setSecNumber(String secNumber) {
        this.secNumber = secNumber;
    }

    @ProtoField(number = 4, defaultValue = "false")
    public boolean isVerifiedPerson() {
        return verifiedPerson;
    }
    public void setVerifiedPerson(boolean verifiedPerson) {
        this.verifiedPerson = verifiedPerson;
    }

    @ProtoField(number = 5, defaultValue = "false")
    public boolean isVerifiedDebts() {
        return verifiedDebts;
    }
    public void setVerifiedDebts(boolean verifiedDebts) {
        this.verifiedDebts = verifiedDebts;
    }

    @ProtoField(number = 6, defaultValue = "false")
    public boolean isVerifiedTaxes() {
        return verifiedTaxes;
    }
    public void setVerifiedTaxes(boolean verifiedTaxes) {
        this.verifiedTaxes = verifiedTaxes;
    }

    @ProtoField(number = 7, defaultValue = "false")
    public boolean isVerifiedPartners() {
        return verifiedPartners;
    }
    public void setVerifiedPartners(boolean verifiedPartners) {
        this.verifiedPartners = verifiedPartners;
    }

}

    
    
