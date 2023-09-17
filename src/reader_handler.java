import java.util.Scanner;

public class reader_handler implements Runnable{

    Scanner scanner;
    public reader_handler(Scanner sc) {
        this.scanner = sc;
    }

    @Override
    public void run() {
        handler();
    }

    public void handler(){
        while (true){
            System.out.println(scanner.nextLine());
        }
    }

}
