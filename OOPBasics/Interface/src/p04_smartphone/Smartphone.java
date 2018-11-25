package p04_smartphone;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Browserable {
    private List<String> phones;
    private List<String> sites;

    public Smartphone(String[] phones, String[] sites) {
        this.phones = new ArrayList<>();
        this.sites = new ArrayList<>();
        this.setPhones(phones);
        this.setSites(sites);
    }

    public List<String> getPhones() {
        return this.phones;
    }

    public List<String> getSites() {
        return this.sites;
    }

    private void setPhones(String[] phones) {
        boolean isValid = true;
        for (String phone : phones) {
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    isValid = false;
                }
            }
            if (isValid) {
                this.phones.add(phone);
            } else {
                this.phones.add("Invalid number!");
            }
            isValid = true;
        }
    }

    private void setSites(String[] sites) {
        boolean isValid = true;
        for (String site : sites) {
            for (int i = 0; i < site.length(); i++) {
                if (Character.isDigit(site.charAt(i))) {
                    isValid = false;
                }
            }
            if (isValid) {
                this.sites.add(site);
            } else {
                this.sites.add("Invalid URL!");
            }
            isValid = true;
        }
    }

    @Override
    public void browseSite() {
        for (String site : this.getSites()) {
            if ("Invalid URL!".equals(site)) {
                System.out.println(site);
            } else {
                System.out.println(String.format("Browsing: %s!", site));
            }
        }
    }

    @Override
    public void callNumber() {
        for (String phone : this.getPhones()) {
            if ("Invalid number!".equals(phone)) {
                System.out.println(phone);
            } else {
                System.out.println(String.format("Calling... %s", phone));
            }
        }
    }
}
