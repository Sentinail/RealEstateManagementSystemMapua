/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.math.BigDecimal;

/**
 *
 * @author Sentinail
 */
public class Lot {
    private int id;
    private int blockId;
    private int blockNumber;
    private Integer customerId; // Nullable foreign key
    private String customer;
    private String location;
    private BigDecimal size;
    private BigDecimal price;
    private Status status;

    public enum Status {
        AVAILABLE, RESERVED, SOLD
    }
    
    // Constructor for existing lots (with ID) and with blockNumber and customer
    public Lot(int id, int blockId, int blockNumber, Integer customerId, String customer, String location, BigDecimal size, BigDecimal price, Status status) {
        this.id = id;
        this.blockNumber = blockNumber;
        this.blockId = blockId;
        this.customerId = customerId;
        this.customer = customer;
        this.location = location;
        this.size = size;
        this.price = price;
        this.status = status;
    }

    // Constructor for existing lots (with ID)
    public Lot(int id, int blockId, Integer customerId, String location, BigDecimal size, BigDecimal price, Status status) {
        this.id = id;
        this.blockId = blockId;
        this.customerId = customerId;
        this.location = location;
        this.size = size;
        this.price = price;
        this.status = status;
    }

    // Constructor for new lots (without ID)
    public Lot(int blockId, Integer customerId, String location, BigDecimal size, BigDecimal price, Status status) {
        this.blockId = blockId;
        this.customerId = customerId;
        this.location = location;
        this.size = size;
        this.price = price;
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlockId() {
        return blockId;
    }
    
    public int getBlockNumber() {
        return blockNumber;
    }
    
    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public Integer getCustomerId() {
        return customerId;
    }
    
    public String getCustomer() {
        return customer;
    } 
    
    public void setCustomer(String customer) {
        this.customer = customer;
    } 

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", blockId=" + blockId +
                ", customerId=" + customerId +
                ", location='" + location + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
