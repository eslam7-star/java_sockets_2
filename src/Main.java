import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try (Socket s = new Socket("192.168.126.1",7777);
             Reader r = new InputStreamReader(s.getInputStream());
             Scanner scanner = new Scanner(r);
             PrintStream printStream = new PrintStream(s.getOutputStream());)
        {
            reader_handler rd = new reader_handler(scanner);
            Thread t1 = new Thread(rd);
            t1.start();
            while (s.isConnected()){
                Scanner keyboard = new Scanner(System.in);
                String str = keyboard.nextLine();
                printStream.println(str);
            }

        }catch (Exception e){
            System.out.println("Error :"+e.getMessage());
        }

    }
}