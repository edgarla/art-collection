package org.art.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArtCollectionApplicationTest {

  @Test
  void contextLoad() {
    ArtCollectionApplication application = new ArtCollectionApplication();
    Assertions.assertNotNull(application);
  }
}
