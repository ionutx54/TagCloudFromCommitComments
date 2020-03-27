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

public class Main {
    public static void main (String[] args) throws GitAPIException, IOException {

        //GitCommitParser gitCmtParser = new GitCommitParser("G:\\GIT_Repos\\alfe_cpp");
        GitCommitParser gitCmtParser = new GitCommitParser("G:\\GIT_Repos\\NephroDoctor");
        ExportArrayListToCsv exportArrayListToCsv = new ExportArrayListToCsv(gitCmtParser.Parser());
        exportArrayListToCsv.ExportMethod();

    }
}
