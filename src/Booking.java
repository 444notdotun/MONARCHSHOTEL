import java.util.HashMap;

public class Booking {
    private int roomNumber;
    Room room=new Room();
    RoomType roomType=RoomType.SINGLE;
    RefGenerator generator=new RefGenerator();
    private String refnumber;
   private HashMap<String, Integer> totalBooking =new HashMap<String, Integer>();
    private int selectedRoom;
    private String booked;

    public String bookAroom(String typeOfRoom) {
        room.validateRoomType(typeOfRoom);
        roomType.getRoomLevel();
        this.selectedRoom =room.getRoomNumber();
        booked=typeOfRoom;

        for(int i = 0;i <3;i++){
            selectedRoom++;
          if( room.getRoom().get(roomType.getRoomLevel()).get(i) == RoomStatus.UNBOOKED){
              room.getRoom().get(roomType.getRoomLevel()).set(i,RoomStatus.BOOKED);
              this.refnumber=generator.script("A@@A##");
              totalBooking.put(refnumber,selectedRoom);
             return "ROOM BOOKED!";
          }
        }


        return  "NO ROOMS AVAILABLE!";
    }
    public String getRefnumber() {
        return refnumber;
    }


    public void cancelBooking(String bookingRef) {
        totalBooking.remove(bookingRef);
        room.validateRoomType(booked);
        for(int i = 0;i <3;i++){
           if(room.getRoom().get(roomType.getRoomLevel()).get(i) == RoomStatus.BOOKED){
               room.getRoom().get(roomType.getRoomLevel()).set(i,RoomStatus.UNBOOKED);
               refnumber=null;
           }
        }
    }

    public HashMap<String, Integer> getTotalBooking() {
        return totalBooking;
    }
}
