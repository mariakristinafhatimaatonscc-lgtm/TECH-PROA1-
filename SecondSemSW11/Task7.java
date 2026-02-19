import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime alarmTime = null;
        String filePath = "A Caring Friend.wav"; 

        while (alarmTime == null) {
            try {
                System.out.print("Enter alarm time (HH:MM:SS): ");
                String input = scanner.nextLine();
                alarmTime = LocalTime.parse(input, formatter);
                System.out.println("Alarm set for " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use HH:MM:SS");
            }
        }

        try {
            while (LocalTime.now().isBefore(alarmTime)) {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond());
            }

            System.out.println("\n*ALARM RINGING*");
            playSound(filePath, scanner);

        } catch (InterruptedException e) {
            System.out.println("Timer interrupted");
        }

        scanner.close();
    }

    
    static void playSound(String filePath, Scanner scanner) {
        File audioFile = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("Press ENTER to stop alarm ");
            scanner.nextLine();

            clip.stop();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file");
        } catch (LineUnavailableException e) {
            System.out.println("Audio unavailable");
        } catch (IOException e) {
            System.out.println("Error playing audio");
        }
    }
}
