import java.util.Scanner;
public class main {
    public main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Notebook nb= new Notebook();
        nb.storeNote("This is a first node");
        nb.storeNote("This is a second node");
        nb.storeNote("This is a third node");
        System.out.println("Total: " +nb.numberOfNotes());
        nb.showAllNodes();
        //nb.removeNote(1);
       nb.storeNote("This is a fourth node");
      // nb.showAllNodes();
      //  nb.showNote(2);
        System.out.println("Total: " +nb.numberOfNotes());
      //  nb.show();
        String phrase;
        System.out.print("Enter the phrase you want to delete:");
        Scanner ob= new Scanner(System.in);
        phrase=ob.nextLine();
        nb.remove(phrase);
        nb.show();
        nb.showAllNodes();
        nb.removeLast();
    }
}

