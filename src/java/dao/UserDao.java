package dao;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Data access object for the user entity
 */
public class UserDao extends BaseDao<User>{

    private static volatile UserDao instance;
    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    /**
     * query user by id
     *
     * @param id id
     * @return user
     */
    public User getById(int id) {
        try {
            return this.executeQuery("SELECT * FROM t_user WHERE id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * query user by email
     *
     * @param email email
     * @return user
     */
    public User getByEmail(String email) {
        if (email == null || email.isEmpty()){
            return null;
        }
        try {
            return this.executeQuery("SELECT * FROM t_user WHERE email = ?", email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * create user
     *
     * @param email email
     * @param password password
     * @param name name
     * @param role role
     */
    public void create(String email, String password, String name, String role) {
        try {
            this.executeUpdate("INSERT INTO t_user (email, password, username, role) VALUES (?, ?, ?, ?)",
                    email, password, name, role);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * update user
     *
     * @param user user
     */
    public void update(User user) {
        try {
            this.executeUpdate("UPDATE t_user SET email = ?, username = ? WHERE id = ?",
                    user.getEmail(), user.getUsername(), user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * update password
     *
     * @param user user
     */
    public void updatePassword(User user) {
        try {
            this.executeUpdate("UPDATE t_user SET password = ? WHERE id = ?",
                    user.getPassword(), user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maps the result set to the user object
     *
     * @param resultSet the result set
     * @return the user object
     * @throws SQLException if an error occurs
     */
    @Override
    protected User mapRowToObject(ResultSet resultSet) throws SQLException {
        User user = new User();
        Optional.of(resultSet.getInt("id")).ifPresent(user::setId);
        Optional.ofNullable(resultSet.getString("email")).ifPresent(user::setEmail);
        Optional.ofNullable(resultSet.getString("password")).ifPresent(user::setPassword);
        Optional.ofNullable(resultSet.getString("username")).ifPresent(user::setUsername);
        Optional.ofNullable(resultSet.getString("role")).ifPresent(user::setRole);
        Optional.ofNullable(resultSet.getTimestamp("created_at"))
                .ifPresent(createdAt -> user.setCreatedAt(createdAt.toLocalDateTime()));
        return user;
    }



}
