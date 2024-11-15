public class Room {
    private int roomId;
    private String type;
    private double price;
    private boolean available;

    // Updated constructor
    public Room(int roomId, String type, double price, boolean available) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.available = available;
    }

    // Getter method for type
    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    // Other getters and setters as needed

  
     public double getRate()
     {
        return price;
     }
    // Setter method for availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", available=" + available +
                '}';
    }
}