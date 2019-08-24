package modern.challenge.test;

import com.vladmihalcea.sql.SQLStatementCountValidator;
import static com.vladmihalcea.sql.SQLStatementCountValidator.assertDeleteCount;
import static com.vladmihalcea.sql.SQLStatementCountValidator.assertInsertCount;
import static com.vladmihalcea.sql.SQLStatementCountValidator.assertSelectCount;
import static com.vladmihalcea.sql.SQLStatementCountValidator.assertUpdateCount;
import com.vladmihalcea.sql.exception.SQLUpdateCountMismatchException;
import modern.challenge.service.BookstoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(true)
public class CountSqlTest {

    @Autowired
    private BookstoreService bookstoreService;

    @Test(expected = SQLUpdateCountMismatchException.class)
    public void givenCRUDWhenTransactionThenTooManySqls() throws Exception {
        SQLStatementCountValidator.reset();

        bookstoreService.withoutTransactional();

        assertInsertCount(1);
        assertUpdateCount(0);
        assertDeleteCount(1);
        assertSelectCount(0);
    }

    @Test
    public void givenCRUDWhenTransactionThenExpectedNoOfSqls() throws Exception {

        SQLStatementCountValidator.reset();

        bookstoreService.withTransactional();

        assertInsertCount(1);
        assertUpdateCount(0);
        assertDeleteCount(1);
        assertSelectCount(0);
    }
}
