package uiTests.tests;

import org.codehaus.groovy.transform.SourceURIASTTransformation;

public class NameUtility {
    public static void main(String[] args) {
        System.out.println(convertNameToInitials("Arasm"));

    }


    public static String convertNameToInitials(String fullName) {
        if(fullName.length()==0){
            throw new RuntimeException("Please give a valid full name");
        }else if (!fullName.contains(" ")) {
            char firstInitial = fullName.charAt(0);
            return firstInitial + ".";
        } else if (fullName.indexOf(" ") == fullName.lastIndexOf(" ")) {
            int firstSpace = fullName.indexOf(" ");
            String firstName = fullName.substring(0, firstSpace);
            String lastName = fullName.substring(firstSpace + 1);
            char firstInitial = firstName.charAt(0);
            char lastInitial = lastName.charAt(0);
            return firstInitial + "." + lastInitial + ".";
        } else {
            int firstSpace = fullName.indexOf(" ");
            int lastSpace = fullName.lastIndexOf(" ");
            String firstName = fullName.substring(0, firstSpace);
            char firstInitial = firstName.charAt(0);

            String middleName = fullName.substring(firstSpace + 1, lastSpace);
            char middleInitial = middleName.charAt(0);

            String lastName = fullName.substring(lastSpace + 1);
            char lastInitial = lastName.charAt(0);

            return "" + firstInitial + "." + middleInitial + "." + lastInitial + ".";

        }
    }
}
