package dao;

import entity.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Data access object for the inventory entity
 */
public class InventoryDao extends BaseDao<Inventory>{

    private static volatile InventoryDao instance;
    public static InventoryDao getInstance() {
        if (instance == null) {
            synchronized (InventoryDao.class) {
                if (instance == null) {
                    instance = new InventoryDao();
                }
            }
        }
        return instance;
    }

    /**
     * Gets the inventory by id
     *
     * @param id the id
     * @return the inventory
     */
    public Inventory queryById(int id) {
        String sql = "SELECT * FROM t_inventory WHERE id = ?";
        try {
            return executeQuery(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the inventory list
     *
     * @param query the query
     * @return the inventory list
     */
    public List<Inventory> queryList(Map<String, String> query) {
        StringBuilder sql = new StringBuilder("SELECT * FROM t_inventory WHERE 1 = 1 and approaching = 0");
        List<String> params = new ArrayList<>();
        for (Map.Entry<String, String> entry : query.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                sql.append(" AND ").append(entry.getKey()).append(" = ? ");
                params.add(entry.getValue());
            }
        }
        try {
            return executeQueryForList(sql.toString(), params.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds the inventory
     *
     * @param inventory the inventory
     */
    public void add(Inventory inventory) {
        String sql = "INSERT INTO t_inventory (name, expiration_date, category, tag, price, quantity, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            executeUpdate(sql, inventory.getName(), inventory.getExpirationDate(), inventory.getCategory(), inventory.getTag(), inventory.getPrice(), inventory.getQuantity(), inventory.getCreatedAt());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Edits the inventory
     *
     * @param inventory the inventory
     */
    public void edit(Inventory inventory) {
        String sql = "UPDATE t_inventory SET name = ?, expiration_date = ?, category = ?, tag = ?, price = ?, quantity = ? WHERE id = ?";
        try {
            executeUpdate(sql, inventory.getName(), inventory.getExpirationDate(), inventory.getCategory(), inventory.getTag(), inventory.getPrice(), inventory.getQuantity(), inventory.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes the inventory
     *
     * @param id the id
     */
    public void delete(int id) {
        String sql = "DELETE FROM t_inventory WHERE id = ?";
        try {
            executeUpdate(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets the expiration
     *
     * @param id the id
     */
    public void setExpiration(int id) {
        String sql = "UPDATE t_inventory SET approaching = 1 WHERE id = ?";
        try {
            executeUpdate(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates the quantity
     *
     * @param inventory the inventory
     */
    public void updateQuantity(Inventory inventory) {
        String sql = "UPDATE t_inventory SET quantity = ? WHERE id = ?";
        try {
            executeUpdate(sql, inventory.getQuantity(), inventory.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the normal list
     *
     * @param query the query
     * @return the normal list
     */
    public List<Inventory> queryNormalList(Map<String, String> query) {
        StringBuilder sql = new StringBuilder("SELECT * FROM t_inventory WHERE 1 = 1 and approaching = 0");
        List<String> params = new ArrayList<>();
        for (Map.Entry<String, String> entry : query.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                sql.append(" AND ").append(entry.getKey()).append(" = ? ");
                params.add(entry.getValue());
            }
        }
        try {
            return executeQueryForList(sql.toString(), params.toArray());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maps the result set to the inventory object
     *
     * @param resultSet the result set
     * @return the inventory object
     * @throws SQLException if an error occurs
     */
    @Override
    protected Inventory mapRowToObject(ResultSet resultSet) throws SQLException {
        Inventory inventory = new Inventory();
        Optional.of(resultSet.getInt("id"))
                .ifPresent(inventory::setId);
        Optional.ofNullable(resultSet.getString("name"))
                .ifPresent(inventory::setName);
        Optional.ofNullable(resultSet.getDate("expiration_date"))
                .ifPresent(expirationDate -> inventory.setExpirationDate(expirationDate.toLocalDate()));
        Optional.ofNullable(resultSet.getString("category"))
                .ifPresent(inventory::setCategory);
        Optional.ofNullable(resultSet.getString("tag"))
                .ifPresent(inventory::setTag);
        Optional.ofNullable(resultSet.getBigDecimal("price"))
                .ifPresent(inventory::setPrice);
        Optional.of(resultSet.getInt("quantity"))
                .ifPresent(inventory::setQuantity);
        Optional.of(resultSet.getBoolean("approaching"))
                .ifPresent(inventory::setApproaching);
        Optional.ofNullable(resultSet.getTimestamp("created_at"))
                .ifPresent(createdAt -> inventory.setCreatedAt(createdAt.toLocalDateTime()));
        return inventory;
    }

}
