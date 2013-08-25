package org.timen.timen;

import static org.junit.Assert.*;
import java.util.Locale;
import org.junit.Test;


public class TIMENTest {

  @Test
  public void testEnglishSimple() {
    TIMEN timen = new TIMEN(Locale.ENGLISH);
    String documentCreationTime = "2012-12-10";
    assertEquals("2012-12-10", timen.normalize("today", documentCreationTime));
    System.out.println("testing: next Monday (hacer con un fichero externo...)");
    assertEquals("2012-12-17", timen.normalize("next Monday", documentCreationTime));
    assertEquals("P10Y", timen.normalize("ten years", documentCreationTime));
    assertEquals("2010-03-19", timen.normalize("march 19, 2010", documentCreationTime));
    assertEquals("2012-09", timen.normalize("three-months ago", documentCreationTime));
    assertEquals("2010-03", timen.normalize("march 2010", documentCreationTime));
    assertEquals("PRESENT_REF", timen.normalize("currently", documentCreationTime));
    assertEquals("2011", timen.normalize("last year", documentCreationTime));
    assertEquals("2012-07", timen.normalize("five month now", documentCreationTime));
    //assertEquals("199", timen.normalize("1990s", documentCreationTime));
    timen.close();
  }

}
