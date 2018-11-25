import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        String resDirectory = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resources\\";
        String serializableObjectPath = resDirectory + "object.ser";

//        FootballPlayer player = new FootballPlayer("Ned", 30, "Real", 100000000);

//        try (FileOutputStream fos = new FileOutputStream(serializableObjectPath);
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(player);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try (FileInputStream fis = new FileInputStream(serializableObjectPath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            FootballPlayer  player = (FootballPlayer) ois.readObject();
            System.out.println(player);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
