package io.github.simple4tests.ohrm.datamodel;

import lombok.Data;

@Data
public class PersonalDetailsData {

    public String firstName;
    public boolean smoker;
    public String militaryService;

//    public String toReadableString() {
//        return String.format("firstName: %s\nsmoker: %s\nmilitaryService: %s", firstName, smoker, militaryService);
//    }
}
