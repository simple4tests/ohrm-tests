package io.github.simple4tests.ohrm.datamodel;

public class PersonalDetailsData {

    public String firstName;
    public boolean smoker;
    public String militaryService;

    public String toReadableString() {
        return String.format("firstName: %s\nsmoker: %b\nmilitaryService: %s", firstName, smoker, militaryService);
    }
}
