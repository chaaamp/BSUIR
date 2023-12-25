import java.util.Comparator;
public class PhoneComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone phone1, Phone phone2) {
        return phone1.getModel().compareTo(phone2.getModel());
    }
}