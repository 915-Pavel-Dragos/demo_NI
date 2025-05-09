package GameStore.GameStore.project.model;

public class LoginResponse {
    private String token;

    private long expiresIn;

    // Getters
    public String getToken() { return this.token; }
    public long getExpiresIn() { return this.expiresIn; }

    // Setters
    public LoginResponse setToken(String new_token) { this.token = new_token; return this; }
    public LoginResponse setExpiresIn(long new_expiresIn) { this.expiresIn = new_expiresIn; return this;}
}