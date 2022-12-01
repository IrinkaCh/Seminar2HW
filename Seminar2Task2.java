import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Seminar2Task2 {
        public static void main(String[] args) {
            Logger log = Logger.getLogger("Seminar2Task2");
            int[] numbers = new int[] { 1, 236, -7, 13, -49, 6, -99, 28 };
            int temp;
            try {
                FileHandler fh = new FileHandler("Seminar2Task2.log");
                log.addHandler(fh);
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
            } 
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length - 1 - i; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                        log.info(Arrays.toString(numbers));
                    }
                }
            }
            System.out.println(Arrays.toString(numbers));
        }
    }

