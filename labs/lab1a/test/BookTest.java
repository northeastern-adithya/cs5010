import org.junit.Before;
import org.junit.Test;

import cs5010.hw01.publication.Book;
import cs5010.hw01.publication.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * This class represents test for Book.java.
 */
public class BookTest {

  private Book book;
  private Person author;

  /**
   * Set up to run before the test.
   */
  @Before
  public void setUp() {
    author = new Person("JK", "Rowling", 1978);
    book = new Book("Harry Potter", author, 10);
  }

  /**
   * Tests get title method.
   */
  @Test
  public void testGetTitle() {
    assertEquals("Harry Potter", book.getTitle());
  }

  /**
   * Tests get author method.
   */
  @Test
  public void testGetAuthor() {
    assertNotNull(book.getAuthor());
    assertEquals(author.getFirstName(), book.getAuthor().getFirstName());
    assertEquals(author.getLastName(), book.getAuthor().getLastName());
    assertEquals(author.getYearOfBirth(), book.getAuthor().getYearOfBirth());
  }

  /**
   * Tests get price method.
   */
  @Test
  public void testGetPrice() {
    assertEquals(10f, book.getPrice(), 0f);
  }

}