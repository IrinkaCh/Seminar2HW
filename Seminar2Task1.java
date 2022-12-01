import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Seminar2Task1 {
    public static void main(String[] args) {

        String st = parseJson("Seminar2Task1.json");
        String[] text;
        text = st.split(",");
        StringBuilder sqlText = new StringBuilder();
        sqlText.append("SELECT * FROM students WHERE ");
        for (int i = 0; i < text.length; i++) {
            text[i] = text[i].replaceFirst("\"", "");
            text[i] = text[i].replaceFirst("\"", "");
            if (!(text[i].contains("null"))) {
                text[i] = text[i].replace(":", " = ");
                sqlText.append(text[i]);
                if (i != 2) {
                    sqlText.append(" AND ");
                }
            }
        }
        System.out.println(sqlText.toString());
    }

    private static String parseJson(String path) {

        try (FileReader filer = new FileReader(path);) {
            try (Scanner scan1 = new Scanner(filer)) {
                final StringBuilder build = new StringBuilder();
                String s = "";
                while (scan1.hasNextLine()) {
                    build.append(scan1.nextLine());
                }
                s = build.toString();
                filer.close();
                s = s.replace(" ", "");
                s = s.replace("{", "");
                s = s.replace("}", "");
                System.out.println(s + "\n");
                return s;
            }
        } catch (FileNotFoundException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return "";

    }
}