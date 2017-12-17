
package Classes;

import ADTs.ListInterface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    
    public static boolean ValidateAccount(String username, String password, String fileName) {
        boolean isValid = false;
        ListInterface<User> userList = File.retrieveList(fileName);
        String tempUsername, tempPassword;
        for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
            tempUsername = userList.getEntry(i).getUsername();
            tempPassword = userList.getEntry(i).getPassword();
            if (tempUsername.equalsIgnoreCase(username) && tempPassword.equals(password)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
    public static boolean ValidateEmail(String email) {
        String EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher regrexMatcher = pattern.matcher(email);
        if (regrexMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ValidateContactNumber(String contactNumber) {
        String CONTACTNO_PATTERN = "^01[0-9]{1}-[0-9]{7,8}$";
        Pattern pattern = Pattern.compile(CONTACTNO_PATTERN);
        Matcher regrexMatcher = pattern.matcher(contactNumber);
        if (regrexMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ValidateIdentityCardNo(String identityCardNo) {
        String ICNO_PATTERN = "^[0-9]{6}-[0-9]{2}-[0-9]{4}$";
        Pattern pattern = Pattern.compile(ICNO_PATTERN);
        Matcher regrexMatcher = pattern.matcher(identityCardNo);
        if (regrexMatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static <T> boolean CheckDuplicateUsername(String username, ListInterface<T> list){
        boolean isDuplicate = false;
        ListInterface<User> userList = (ListInterface<User>)list;
        String tempUsername;
        for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
            tempUsername = userList.getEntry(i).getUsername();
            if (tempUsername.equalsIgnoreCase(username)) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }
}
