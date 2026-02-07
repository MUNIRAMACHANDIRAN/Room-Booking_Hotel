import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class HotelService {

    public void viewRooms() {
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM rooms");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getDouble(3) + " "
                        + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookRoom(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Room ID: ");
            int roomId = sc.nextInt();
            sc.nextLine();
            System.out.print("Customer Name: ");
            String name = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO bookings(room_id, customer_name, check_in) VALUES (?,?,?)");
            ps.setInt(1, roomId);
            ps.setString(2, name);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();

            con.createStatement().executeUpdate(
                "UPDATE rooms SET status='BOOKED' WHERE room_id=" + roomId);

            System.out.println("Room booked successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelBooking(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Booking ID: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM bookings WHERE booking_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Booking cancelled.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
