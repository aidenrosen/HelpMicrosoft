import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpMicrosoft
{
        private static Scanner tokenReader;
    public static void main(String[] args)
    {
        try
        {
            tokenReader = new Scanner(new File("token.txt"));
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        String myToken = tokenReader.nextLine();

        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();

        GithubHelper githubHelper = new GithubHelper(user, myToken);
        githubHelper.createRepo("testRepo");
    }

}
