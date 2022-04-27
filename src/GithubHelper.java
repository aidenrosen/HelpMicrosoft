import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;

import java.io.*;
import java.util.Scanner;

public class GithubHelper
{
    private String repoPath, user, token;
    private GitSubprocessClient gitSubprocessClient;

    public GithubHelper(String user, String token)
    {
        this.user = user;
        this.token = token;

        GitHubApiClient gitHubApiClient = new GitHubApiClient(user, token);
    }

    public void createRepo(String filePath)
    {
        gitSubprocessClient = new GitSubprocessClient(filePath);
        repoPath = filePath;
        gitSubprocessClient.gitInit();


        //Create .gitignore
        Scanner modelScanner = null;
        try
        {
            modelScanner = new Scanner(new File("modelGitIgnore.txt"));
        } catch(FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        File gitignore = new File("testRepo/.gitignore");

        try
        {
            FileWriter out = new FileWriter(gitignore);
            if(gitignore.createNewFile())
            {
                do
                {
                    String line = modelScanner.nextLine();
                    out.write(line);
                    out.write("\n");
                } while (modelScanner.hasNext());
            }
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        File readme = new File("testRepo/README.md");
        try
        {
            readme.createNewFile();
            FileWriter readOut = new FileWriter(readme);
            readOut.write(filePath);
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        gitSubprocessClient.gitAddAll();
        gitSubprocessClient.gitCommit("Initial Commit");
        gitSubprocessClient.gitPush("master");

        System.out.println("Repo created");
    }
}
