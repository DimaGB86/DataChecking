import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество, дата рождения, номер телефона, пол(f, m)");

        try {
            String input = scanner.nextLine();
            UserData userData = new UserData(input);
            saveUserDataToFile(userData);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (InvalidDataFormatException e) {
            System.err.println("Ошибка в формате введенных данных: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл:");
            e.printStackTrace();
        }
    }

    private static void saveUserDataToFile(UserData userData) throws IOException {
        String filename = userData.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(userData.toString());
            writer.newLine();
        }
    }
}