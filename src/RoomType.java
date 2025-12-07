public enum RoomType {
    SINGLE(10000,0),
    DOUBLE(15000,1),
    SUITE(25000,2);


    private int price;
    private int roomLevel;

    RoomType(int price, int roomLevel){
        this.price = price;
        this.roomLevel = roomLevel;
    }

    public int getPrice(){
        return price;
    }

    public int getRoomLevel(){
        return roomLevel;
    }
}
