import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.entry;

public class CollectionTest {
    @Test
    @DisplayName("map entry 断言")
    void map() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        assertThat(map)
                .containsEntry(1, "1")
                .containsEntry(2, "2")
                .containsEntry(3, "3");

        assertThat(map)
                .contains(entry(1, "1"))
                .contains(entry(2, "2"))
                .contains(entry(3, "3"));
    }


    @Test
    @DisplayName("list element 断言")
    void list() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);

        assertThat(list)
                .hasSize(4);

        assertThat(list)
                .contains(1)
                .contains(2)
                .contains(3)
                .contains(4);

        assertThat(list)
                .containsExactlyInAnyOrder(4, 2, 1, 3);

    }
}
