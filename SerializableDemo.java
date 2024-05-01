import javax.imageio.IIOException;
import java.io.*;

/*
Serialization is a mechanism of converting the state of an object into a byte stream.
Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
This mechanism is used to persist the object.
Serialization and Deserialization are mainly used to create a copy of an object where you don't want to expose of object itself or
where the object is being modified.

NOTE: Only objects of those class can we serialized which are implementing the Serializable interface

Tip: If the class in not extending Serializable interface and you still want to create a clone the object then you can do via
a JSON string and the mapping each value to object of that class.
Example ObjectMapper obj = new ObjectMapper();
        Stirng JSON = obj.writeValueAsString(entityToBeDuplicated);
        ClassOfEntityToBeDuplicated copy = obj.readValue(JSON, ClassOfEntityToBeDuplicated.java)
 */

public class SerializableDemo implements Serializable {
    public int num;
    public String word;

    public SerializableDemo(int num, String word) {
        this.num = num;
        this.word = word;

    }

}

class Demo {
    public static void main(String[] args) {
        SerializableDemo obj = new SerializableDemo(1, "Demo");
        String fileNameStore = "file.ser";

        try {
            FileOutputStream file = new FileOutputStream(fileNameStore);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(obj);

            out.flush();
            out.close();
            file.close();

            System.out.println("Object has been serialized ");


        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        SerializableDemo obj2 = null;

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileNameStore);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            obj2 = (SerializableDemo) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + obj2.num);
            System.out.println("b = " + obj2.word);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");

        }
    }
}
