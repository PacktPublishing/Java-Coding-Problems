package modern.challenge;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class Main {

    public static void main(String[] args) {

        User user;
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();        
        
        User.UserBuilder userBuilder = new User.UserBuilder("monika", "klooi0988")
                .email("monika@gmail.com")
                .firstName("Monika")
                .lastName("Gunther");

        final Set<ConstraintViolation<User.UserBuilder>> violations
                = validator.validate(userBuilder);

        if (violations.isEmpty()) {
            user = userBuilder.build();

            System.out.println("User successfully created on: " + user.getCreated());
        } else {
            printConstraintViolations("UserBuilder Violations: ", violations);
        }
    }

    private static <T> void printConstraintViolations(
            String caption, Set<ConstraintViolation<T>> violations) {
        
        System.out.println(caption);

        violations.forEach((v) -> {
            System.out.println("\t" + v.getPropertyPath() + " " + v.getMessage());
        });
    }
}
