import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seminar2Task3 {
    
    public static void main(String[] args) throws FileNotFoundException {
        String path = "Seminar2Task3.json";
        File file = new File(path);
        Scanner scan = new Scanner(file);
        String Line0 = scan.nextLine();
        StringBuilder line = new StringBuilder();
        while (scan.hasNextLine()) {
            line.append(scan.nextLine());
        }
        Line0 = line.toString();
        StringBuilder line2 = new StringBuilder();
        for (int i = 0; i < Line0.length(); i++) {
            if (Line0.charAt(i) != '{'
                    && Line0.charAt(i) != '}'
                    && Line0.charAt(i) != '"'
                    && Line0.charAt(i) != '['
                    && Line0.charAt(i) != ']'
                    && Line0.charAt(i) != ' ') {
                char t = Line0.charAt(i);
                line2.append(t);
            }
        }
        String newLine = line2.toString();
        System.out.println(newLine);
        String[] tVal = newLine.split("[ : \\ ,]");
        ArrayList<String> student = new ArrayList();
        ArrayList<String> estimate = new ArrayList();
        ArrayList<String> subject = new ArrayList();
        for (int i = 1; i < tVal.length; i = i + 6) {
            student.add(tVal[i]);
        }
        for (int i = 3; i < tVal.length; i = i + 6) {
            estimate.add(tVal[i]);
        }
        for (int i = 5; i < tVal.length; i = i + 6) {
            subject.add(tVal[i]);
        }
        scan.close();
        System.out.println(student);
        System.out.println(estimate);
        System.out.println(subject);
        System.out.println("\n");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < student.size(); i++) {
            result.append(
                    "Студент " + student.get(i) + " получил " + estimate.get(i) + " по предмету " + subject.get(i) + "\n");
        }
        System.out.println(result);
    }
}
