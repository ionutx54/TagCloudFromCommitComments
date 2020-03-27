import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import javax.naming.CompositeName;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GitCommitParser {

    private String Path;
    Typetester typetester = new Typetester();

    public GitCommitParser(String Path) {
        this.Path = Path;
    }

    public ArrayList<String> Parser() throws GitAPIException, IOException {
        String toProccess;
        ArrayList<String> text = new ArrayList<String>();
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repo = builder.setGitDir(new File(Path + "\\.git")).setMustExist(true).build();
        Git git = new Git(repo);
        Iterable<RevCommit> log = git.log().call();
        for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext(); ) {
            RevCommit rev = iterator.next();
            //typetester.printType(rev.getFullMessage());
            toProccess = rev.getFullMessage();
            toProccess = toProccess.replace(' ', ',');
            toProccess = toProccess.replace("\n", "").replace("\r", "");
            text.add(toProccess);
        }

        return text;
    }
}

