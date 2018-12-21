package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        category.setId(4L);
        assertEquals(4L, category.getId().intValue());
        assertThat(category.getId(), is(4L));
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}