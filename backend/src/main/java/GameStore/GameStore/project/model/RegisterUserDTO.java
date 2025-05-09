package GameStore.GameStore.project.model;

public class RegisterUserDTO {
    private String email;
    private String password;
    private String fullName;

    // Getters
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public String getFullName() { return this.fullName; }

    // Setters 
    public void setEmail(String new_email) { this.email = new_email; }
    public void setPassword(String new_password) { this.password = new_password; }
    public void setFullName(String new_fullName) { this.fullName = new_fullName; }
}