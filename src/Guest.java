public class Guest {

    private String name;
    private String email;
    private String number;
    Room room=new Room();


    public Guest(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String guestDetails() {
        StringBuilder details = new StringBuilder();

    }
}
