package entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * User Entity

 */
public class User {

    /**
     * User ID
     */
    private Integer id;

    /**
     * User Email
     */
    private String email;

    /**
     * User Password
     */
    private String password;

    /**
     * User Username
     */
    private String username;

    /**
     * User Role (Retailers, Charitable Organizations, Consumers).
     */
    private String role;

    /**
     * User Created At
     */
    private LocalDateTime createdAt;


    // ============================== Getter And Setter ============================== //
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAtWeb() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }

    // ============================== Base Methods ============================== //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(username, user.username)
                && Objects.equals(role, user.role) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username, role, createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
