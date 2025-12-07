import exception.RoomValidationException;

public class Payment {
    Room room = new Room();
    double totalAmount;

    private double festivePeriod = 0.2;

    public double calculateTotalPayment(String typeOfRoom, int nights, String festive) {
        double payment = 0;
         room.validateRoomType(typeOfRoom);
       int   price = room.getType().getPrice();
       validatechoice(festive);
       if(festive.equalsIgnoreCase("yes")) {
         payment  = (price+(price*festivePeriod))*nights;
       }
       if(festive.equalsIgnoreCase("no")) {
           payment  = (price*nights);
       }
       totalAmount+=payment;

       return payment;
    }

    private void validatechoice(String choice){
        if(!choice.equalsIgnoreCase("yes") &&!choice.equalsIgnoreCase("no")){
            throw new IllegalArgumentException("Invalid choice");
        }
    }

    public double getTotalPayment() {
        return totalAmount;
    }
}
