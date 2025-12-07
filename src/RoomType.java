public enum RoomType {
    SINGLE(10000,1),
    DOUBLE(15000,2),
    SUITE(25000,3);


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
