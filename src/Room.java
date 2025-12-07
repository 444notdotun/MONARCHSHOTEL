import exception.RoomNumberValidationException;
import exception.RoomValidationException;

import java.util.ArrayList;

public class Room {
    RoomStatus status = RoomStatus.UNBOOKED;
    private ArrayList<ArrayList<RoomStatus>>rooms= new ArrayList<>();
    private int hotelRoomType=3;
    private int roomsInType=3;
    private int roomNumber=100;
    private RoomType roomType=RoomType.SINGLE;
    private int totalRooms = 0;


    public Room(){
        for (int i = 0; i < hotelRoomType; i++) {
            rooms.add(new ArrayList<>());
        }
        for (int i = 0; i < hotelRoomType; i++) {
             for (int j = 0; j < roomsInType; j++) {
                 rooms.get(i).add(status);
                 totalRooms++;
             }
        }
    }


    public String availableRooms() {

        StringBuilder available=new StringBuilder();
       for(int j=0;j<hotelRoomType;j++) {
           for (int i = 0; i < roomsInType; i++) {
                   if (j ==1) {
                       roomType = RoomType.DOUBLE;
                   }
                   if (j ==2) {
                       roomType = RoomType.SUITE;
                   }
                   available.append(String.format("ROOM NUMBER:%-2d |TYPE:%-2S | PRICE:#%-2d%n", roomNumber,roomType, roomType.getPrice()));
                   roomNumber++;
           }
       }
        return available.toString();
    }


    public boolean setHotelRoomType(int roomType) {
        this.hotelRoomType=roomType;
        return true;
    }

    public boolean setRoomInType(int roomInType ){
        hotelRoomType=roomInType;
        return true;
    }

    public RoomType getType() {
        return roomType;
    }

    public int validateRoomType(String roomType){
        if(roomType.equalsIgnoreCase("DOUBLE")){
            this.roomType=RoomType.DOUBLE;
            return this.roomType.getRoomLevel();
        }
        if(roomType.equalsIgnoreCase("SUITE")){
            this.roomType=RoomType.SUITE;
            return this.roomType.getRoomLevel();
        }
        if(roomType.equalsIgnoreCase("SINGLE")){
            this.roomType=RoomType.SINGLE;
            return this.roomType.getRoomLevel();
        }
        throw new RoomValidationException("INVALID ROOM TYPE");
    }
    private int validateRoomNumber(int roomNumber){
        int newNumber=roomNumber%100;
        if(newNumber<1 | newNumber>totalRooms){
            throw new RoomNumberValidationException("INVALID ROOM NUMBER");
        }
        return newNumber;

    }

    public String maintenance(String type, int roomNumber) {
        int roomType=validateRoomType(type);
        int roomNo=validateRoomNumber(roomNumber);
        rooms.get(roomType).set(roomNo,RoomStatus.UNAVAILABLE);
        return "ROOM "+roomNo+" IS MARKED FOR MAINTENANCE";
    }


    public String allRooms() {
        this.roomNumber=100;
        StringBuilder allRooms=new StringBuilder();
        for(int j=0;j<hotelRoomType;j++) {
            for (int i = 0; i < roomsInType; i++) {
                if (rooms.get(j).get(i).equals(RoomStatus.UNBOOKED)) {
                    if (j ==1) {
                        roomType = RoomType.DOUBLE;
                    }
                    if (j ==2) {
                        roomType = RoomType.SUITE;
                    }
                    allRooms.append(String.format("ROOM NUMBER:%-2d |TYPE:%-2S | PRICE:#%-2d%n", roomNumber,roomType, roomType.getPrice()));
                    roomNumber++;
                }
            }
        }
        return allRooms.toString();
    }


}


