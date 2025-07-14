import java.util.Arrays;
import java.util.List;

public class Q3 {

    @FunctionalInterface
    interface ValidationRule<T> {
        boolean test(T value);
    }

    private static <T> boolean validate(T value, List<ValidationRule<T>> rules) {
        return rules.stream().allMatch(rule -> rule.test(value));
    }

    public static void main(String[] args) {
        ValidationRule<String> notEmpty = s -> !s.isEmpty();
        ValidationRule<String> hasSpecialChar  = s -> s.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        ValidationRule<String> hasNumber = s -> s.matches(".*\\d.*");
        ValidationRule<String> isLonger = s -> s.length() > 8;

        String password = "Password1!";
        String passwordShort = "short";
        String passwordNoSpecialChar = "Password1";
        String passwordNoNumber = "Password!";
        String passwordEmpty = "";

        List<ValidationRule<String>> rules = Arrays.asList(notEmpty, hasSpecialChar, hasNumber, isLonger);

        System.out.println("--- Password Validation Results ---");
        System.out.println("'" + password + "' : " + validate(password, rules));
        System.out.println("'" + passwordShort + "' : " + validate(passwordShort, rules));
        System.out.println("'" + passwordNoSpecialChar + "' : " + validate(passwordNoSpecialChar, rules));
        System.out.println("'" + passwordEmpty + "' : " + validate(passwordEmpty, rules));
        System.out.println("'" + passwordNoNumber + "' : " + validate(passwordNoNumber, rules));
    }
}