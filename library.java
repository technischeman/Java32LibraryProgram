import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class library {
    static int id = 1;
    static String name;
    static String author;
    static String publishing;
    static HashMap<Integer, String> librarymap = new HashMap();

    public static void main(String[] args) {
        librarymap.put(id, "Beyaz Gemi, Cengiz, 2000");
        id++;
        librarymap.put(id, "1984, George Orwell, 2000");
        id++;
        menu();


    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("1-to add book\n2-to list book\n3-to clean book\n4-looking for book\n5-id\n");
        System.out.println("=================");
        System.out.println("choose a choice: ");
        byte secenek = input.nextByte();
        switch (secenek) {
            case 1:
                add();
                break;
            case 2:
                tolist();
                break;
            case 3:
                clean();
                break;
            case 4:
                lookfor();
                break;
            case 5:
                findid();
                break;
            default:
                System.out.println("wrong number go menu");
                System.out.println("===================");
                turnmenu();

        }

    }

    public static void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("write book name: ");
        name = input.nextLine();
        System.out.println("author of the book: ");
        author = input.nextLine();
        System.out.println("history of the book:  ");
        publishing = input.nextLine();
        String kitapinfo = name + " " + author + " " + publishing + " ";
        librarymap.put(id++, kitapinfo);
        turnmenu();


    }

    public static void tolist() {
        for (Map.Entry<Integer, String> key : librarymap.entrySet()) {
            System.out.println(key);
        }
        turnmenu();

    }

    public static void clean() {
        Scanner input = new Scanner(System.in);
        int toclean;
        System.out.println("write a id to clean");
        toclean = input.nextInt();
        if (librarymap.containsKey(toclean)) {
            librarymap.remove(toclean);
            System.out.println("it is cleaned");
        } else {
            System.out.println("there is no so id and write name of book");
            String tocleanname=input.nextLine();
            boolean control=librarymap.containsValue(tocleanname);
            if(control==true){
                librarymap.remove(tocleanname);
                System.out.println("the book is cleaned");
            }else System.out.println("there is no so book");


        }


        turnmenu();

    }

    public static void lookfor() {
        String lookforwithAUTHOR,kitapinfo;
        Scanner input = new Scanner(System.in);
        System.out.println("look for a book with author: ");
        lookforwithAUTHOR = input.next();

        for (int i=1; i<=id ; i++) {
            if (librarymap.containsKey(i)){
                kitapinfo=librarymap.get(i);
                if (kitapinfo.contains(lookforwithAUTHOR)){
                    System.out.println("book is found;"+kitapinfo);
                    turnmenu();


                }
            }
        }
        System.out.println("===not found====");
        System.out.println("find book with id:");
        int lookforwithid = input.nextInt();
        if(librarymap.containsKey(lookforwithid)){
            System.out.println("book is found:" + librarymap.get(lookforwithid));
        }else System.out.println("there is no this book");

        turnmenu();
    }


    public static void findid() {
        int wantedid = 0;
        String foundbook = "";

        Scanner inputnew = new Scanner(System.in);
        System.out.println("id write : ");
        wantedid = inputnew.nextInt();
        if (librarymap.isEmpty()) {
            System.out.println("there is no book");
        } else if (librarymap.containsKey(wantedid)) {
            foundbook = librarymap.get(wantedid);
            System.out.println("looked book:" + foundbook);


        } else System.out.println("there is no this id");
        turnmenu();


    }

    public static int turnmenu() {
        int turnbutton;
        Scanner input = new Scanner(System.in);
        System.out.println("==write 0 to turn menu:");
        turnbutton = input.nextInt();
        if (turnbutton == 0) {
            menu();
        }else System.out.println("wrong number try again");
        return turnmenu();

    }
}

