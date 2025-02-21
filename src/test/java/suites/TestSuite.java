package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ArticleTests;
import tests.ChangeAppConditionTests;
import tests.MyListTests;
import tests.SearchTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        SearchTests.class,
        ArticleTests.class,
        ChangeAppConditionTests.class,
        MyListTests.class
//        GetStatedTest.class,
})

public class TestSuite {
}
