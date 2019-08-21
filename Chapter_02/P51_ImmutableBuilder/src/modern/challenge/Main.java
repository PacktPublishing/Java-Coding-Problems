package modern.challenge;

import static modern.challenge.User.getBuilder;

public class Main {

    public static void main(String[] args) {

        // user with nickname and password
        User user1 = getBuilder("marin21", "hjju9887h").build();
        System.out.println("User 1 successfully created on: " + user1.getCreated());

        // user with nickname, password and email
        User user2 = getBuilder("ionk", "44fef22")
                .email("ion@gmail.com")
                .build();
        System.out.println("User 2 successfully created on: " + user2.getCreated());

        // user with nickname, password, email, firstname and lastname
        User user3 = getBuilder("monika", "klooi0988")
                .email("monika@gmail.com")
                .firstName("Monika")
                .lastName("Ghuenter")
                .build();
        System.out.println("User 3 successfully created on: " + user3.getCreated());
    }

}
