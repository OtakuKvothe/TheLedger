package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.swarnendu.parser.CommandRunner;
import com.swarnendu.parser.Parser;
import com.swarnendu.repository.BorrowerRepository;
import com.swarnendu.repository.Repository;
import org.junit.jupiter.api.Test;

public class BorrowerRepositoryTest {

    @Test
    public void testNewLoan() {
        Repository repo = new BorrowerRepository();
        CommandRunner parser = new Parser(repo);
        parser.execute("LOAN A B 100 1 2");
        assertFalse(((BorrowerRepository)repo).isRepositoryEmpty());
    }
}
