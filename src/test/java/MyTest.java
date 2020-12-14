import com.sun.source.tree.LambdaExpressionTree;
import com.tz.pojo.Books;
import com.tz.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        Books books = new Books(6, "语文", 30, "中学语文");
        bookServiceImpl.updateBook(books);

        for (Books book : bookServiceImpl.queryAllBook()){
            System.out.println(book);
        }
    }
}
