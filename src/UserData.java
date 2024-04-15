import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    public UserData(String input) throws InvalidDataFormatException {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            throw new InvalidDataFormatException("Invalid number of data elements");
        }

        lastName = parts[0];
        firstName = parts[1];
        middleName = parts[2];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            birthDate = dateFormat.parse(parts[3]);
        } catch (ParseException e) {
            throw new InvalidDataFormatException("Invalid date format for birth date");
        }

        try {
            phoneNumber = Long.parseLong(parts[4]);
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Invalid phone number format");
        }

        if (parts[5].length() != 1 || (!parts[5].equals("f") && !parts[5].equals("m"))) {
            throw new InvalidDataFormatException("Invalid gender format");
        }
        gender = parts[5].charAt(0);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return lastName + " " + firstName + " " + middleName + " " + dateFormat.format(birthDate) + " " + phoneNumber + " " + gender;
    }
}