package modern.challenge;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public final class User {

    private final String nickname;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Date created;

    private User(UserBuilder builder) {
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.created = builder.created;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
    }

    public static final class UserBuilder {

        @NotNull(message = "cannot be null")
        @Size(min = 3, max = 20, message
                = "must be between 3 and 20 characters")
        private final String nickname;

        @NotNull(message = "cannot be null")
        @Size(min = 6, max = 50, message
                = "must be between 6 and 50 characters")
        private final String password;

        @Size(min = 3, max = 20, message
                = "must be between 3 and 20 characters")
        private String firstname;

        @Size(min = 3, max = 20, message
                = "must be between 3 and 20 characters")
        private String lastname;

        @Email(message = "must be valid")
        private String email;

        private final Date created;

        public UserBuilder(String nickname, String password) {
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }

        public UserBuilder firstName(String firsname) {
            this.firstname = firsname;
            return this;
        }

        public UserBuilder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }
}
