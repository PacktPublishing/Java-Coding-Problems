package modern.challenge;

public class User {
    
    private Data data;
    private String updatedAt;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }      

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" + "data=" + data + ", updatedAt=" + updatedAt + '}';
    }                   
}
