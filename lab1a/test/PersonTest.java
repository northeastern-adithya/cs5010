import org.junit.Before;
import org.junit.Test;

import cs5010.hw01.publication.Person;

import static org.junit.Assert.assertEquals;

/**
 * This class represents test for Person.java.
 */
public class PersonTest {
  private Person john;

  /**
   * Set up to run before the test.
   */
  @Before
  public void setUp() {

    john = new Person("John", "Doe", 1945);
  }

  /**
   * Test get first name method.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("John", john.getFirstName());

  }

  /**
   * Test get last name method.
   */
  @Test
  public void testGetLastName() {
    assertEquals("Doe", john.getLastName());
  }

  /**
   * Test get year of birth method.
   */
  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
  }
}