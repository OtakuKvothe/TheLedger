package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.swarnendu.parser.Parser;
import com.swarnendu.repository.Repository;
import mocks.RepositoryMock;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void testLoan() {
        Repository repo = new RepositoryMock();
        Parser parser = new Parser(repo);
        parser.execute("LOAN A B 100 1 2");
        assertEquals(((RepositoryMock)repo).result, "NewLoan");
    }

    @Test
    public void testPayment() {
        Repository repo = new RepositoryMock();
        Parser parser = new Parser(repo);
        parser.execute("PAYMENT A B 100 1");
        assertEquals(((RepositoryMock)repo).result, "ProcessPayment");
    }

    @Test
    public void testBalance() {
        Repository repo = new RepositoryMock();
        Parser parser = new Parser(repo);
        parser.execute("BALANCE A B 1");
        assertEquals(((RepositoryMock)repo).result, "ProcessBalance");
    }
}
