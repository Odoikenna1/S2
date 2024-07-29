import data.web.PostController;
import java.util.Scanner;

public class Main {
    private static PostController postController ;
    private static Scanner scan = new Scanner(System.in);
    private static String input(String prompt){
        System.out.println(prompt);
        return  scan.nextLine();
    }
    private static void display(String prompt){
        System.out.println(prompt);
    }
    private static void createPost(){
        String title = input("What is the title?");
        String content = input("What is the content?");
        display(postController.createPost(title, content));
    }
    private static void readPost(){
        int postId = Integer.parseInt(input("Enter the post Id you want to read: "));
        display(postController.getPost(postId));
    }
    private static void exit(){
         System.exit(0);
    }
    private static String gotToMainMenu(){
        String prompt = """
                ================
                || Blog - App ||
                ================
                1 -> Create Post
                2 -> Read Post
                """;
        display(prompt);
        return input("What do you want to do?");
    }
    public static void main(String... args){

        switch(gotToMainMenu()){
            case "1" -> createPost();
            case "2" -> readPost();
            case "0" -> exit();
            default -> gotToMainMenu();
        }
    }

}
