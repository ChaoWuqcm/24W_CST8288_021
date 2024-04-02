package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * Entity class for Inventory

 */
public class Inventory {
    
    /**
     * The id of the inventory
     */
    private Integer id;

    /**
     * The name of the inventory
     */
    private String name;

    /**
     * The expiration date of the food
     */
    private LocalDate expirationDate;

    /**
     * The category of the food
     */
    private String category;

    /**
     * The tag of the food
     */
    private String tag;

    /**
     * The price of the food
     */
    private BigDecimal price;

    /**
     * The quantity of the food
     */
    private Integer quantity;

    /**
     *  Approaching
     */
    private Boolean approaching;

    /**
     * The location of the food
     */
    private LocalDateTime createdAt;

    // ============================== Getter And Setter ============================== //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getApproaching() {
        return approaching;
    }

    public void setApproaching(Boolean approaching) {
        this.approaching = approaching;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpirationDateWeb() {
        return Date.from(expirationDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public Date getCreatedAtWeb() {
        return Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
    }

    // ============================== Base Methods ============================== //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) && Objects.equals(name, inventory.name) && Objects.equals(expirationDate, inventory.expirationDate) && Objects.equals(category, inventory.category) && Objects.equals(tag, inventory.tag) && Objects.equals(price, inventory.price) && Objects.equals(quantity, inventory.quantity) && Objects.equals(approaching, inventory.approaching) && Objects.equals(createdAt, inventory.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expirationDate, category, tag, price, quantity, approaching, createdAt);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", category='" + category + '\'' +
                ", tag='" + tag + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", approaching='" + approaching + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
