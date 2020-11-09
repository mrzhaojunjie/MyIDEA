import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.kuang.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class myTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        List<Books> books = bookServiceImpl.queryAllBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
