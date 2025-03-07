package Classes;

public class Block {
    private int id;
    private int number;
    private String name;
    private String description;
    
    public Block(int id, int number, String name, String description) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.description = description;
    }
    
    public Block(int number, String name, String description) {
        this.number = number;
        this.name = name;
        this.description = description;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getBlockNumber() {
        return String.valueOf(number);
    }
    
    public String getLocation() {
        return name;
    }
    
    @Override
    public String toString() {
        return number + " - " + name;
    }
}