package modern.challenge;

import javax.json.bind.annotation.JsonbProperty;

public class Data {

    private Integer id;
    private String email;
    @JsonbProperty("first_name")
    private String firstName;
    @JsonbProperty("last_name")
    private String lastName;
    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", email=" + email 
                + ", firstName=" + firstName + ", lastName=" + lastName + ", avatar=" + avatar + '}';
    }   
}
