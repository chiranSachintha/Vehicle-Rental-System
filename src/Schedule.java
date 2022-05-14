import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {
    Date pickUpDate;
    Date dropOffDate;
    public Schedule(String pickUpDate, String dropOffDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.pickUpDate = dateFormat.parse(pickUpDate);
        this.dropOffDate = dateFormat.parse(dropOffDate);
    }

    public String toString() {
        return pickUpDate.toString() + "-" + dropOffDate.toString();
    }
}
