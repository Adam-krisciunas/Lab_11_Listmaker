import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> Lines = new ArrayList<>();
    private static void quit(){
        boolean quitYN = false;
        quitYN = SafeInput.getYNConfirm(in, "Are you sure?");
        if(quitYN){
            System.exit(0);
        }
    }
    private static void add() {
        String LineItem = "";
        LineItem = SafeInput.getNonZeroLenString(in, "Enter the new line for the memo");
        Lines.add(LineItem);
    }

    private static void delete(){
        System.out.println("--------------------------------------------");
        if(Lines.size() == 0)
        {
            System.out.println("\nNothing to delete.\n");
            System.out.println("--------------------------------------------");
            return;
        }
        else
        {
            int ln = 0;

            for(String l:Lines){
                ln++;
                System.out.printf("\t%3d %-80s",ln, l);
            }

        }
        System.out.println("--------------------------------------------");
        int low = 1;
        int high = Lines.size();
        int target = SafeInput.getRangedInt(in,"enter the number of the line you want to delete", low, high);
        target--;
        Lines.remove(target);
    }
    private static void showList()
    {
        if(Lines.size() ==0)
        {
            System.out.println("\nThe list is currently empty.\n");
        }
        else
        {
            System.out.println("---------------------------------");
            for(String l:Lines)
                System.out.println("\t" + l);
            System.out.println("---------------------------------");
        }
    }
    public static void main(String[] args) {
        String menuPrompt = "A - Add, D - Delete, P - Print, Q - Quit";
        String cmd = "";
        boolean done = false;

        do {
            showList();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            switch (cmd)
            {
                case "A":
                    add();
                    break;

                case "D":
                    delete();
                    break;

                case "P":
                    showList();
                    break;

                case "Q":
                    quit();
                    break;

            }
        } while (!done);
    }
}