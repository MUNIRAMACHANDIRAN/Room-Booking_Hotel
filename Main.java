import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelService service = new HotelService();

        while (true) {
            System.out.println("\n--- HOTEL BOOKING SYSTEM ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> service.viewRooms();
                case 2 -> service.bookRoom(sc);
                case 3 -> service.cancelBooking(sc);
                case 4 -> System.exit(0);
            }
        }
    }
}
