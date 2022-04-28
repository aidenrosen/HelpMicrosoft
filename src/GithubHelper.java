import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.CreateRepoResponse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GithubHelper
{
    private String repoPath, user, token, link;
    private GitSubprocessClient gitSubprocessClient;
    private GitHubApiClient gitHubApiClient;

    public GithubHelper(String user, String token)
    {
        this.user = user;
        this.token = token;

        gitHubApiClient = new GitHubApiClient(user, token);
    }

    public void createRepo(String filePath)
    {
        gitSubprocessClient = new GitSubprocessClient(filePath);
        repoPath = filePath;

        RequestParams requestParams = new RequestParams();
        requestParams.addParam("name", filePath);
        CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);
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

        File file = new File(".gitignore");
        try
        {
            Files.copy(Path.of(file.getPath()), Path.of(filePath + "/.gitignore"));
        } catch(IOException e)
        {
            System.out.println(file.getPath());
            throw new RuntimeException(e);
        }

        File readme = new File(filePath + "/README.md");

        try
        {
            readme.createNewFile();
            FileWriter readOut = new FileWriter(readme);
            readOut.write(filePath);
            readOut.close();
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        String gitRemoteAdd = gitSubprocessClient.gitRemoteAdd("origin", "https://github.com/" + user + "/" + filePath);
        gitSubprocessClient.gitAddAll();
        gitSubprocessClient.gitCommit("Initial Commit");
        gitSubprocessClient.gitPush("master");

        link = "https://github.com/" + user + "/" + filePath;
    }

    public String getLink()
    {
        return link;
    }
}
