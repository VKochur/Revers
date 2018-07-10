package kvv.education.khasang.java_intern.string_revers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тестирование изменения порядка символов в словах текста
 */
public class ReverserTest {

    /**
     * Тестирование метода изменения текста путем обращения порядка символов в словах
     *
     * @throws Exception
     */
    @Test
    public void testSplitAndRevers() throws Exception {
        char[] separators = Reverser.PUNCTUATION_SEPARATORS;

        String msg = "тестирование на пустых строках";
        assertEquals(msg, "", Reverser.splitAndRevers("", separators));

        msg = "тестирование на строках состоящих только из сепараторов";
        assertEquals(msg, " ", Reverser.splitAndRevers(" ", separators));
        assertEquals(msg, "   ", Reverser.splitAndRevers("   ", separators));
        assertEquals(msg, ",! -:", Reverser.splitAndRevers(",! -:", separators));

        msg = "тестирование на строках без сепараторов";
        assertEquals(msg,"a", Reverser.splitAndRevers("a", separators));
        assertEquals(msg,"ab", Reverser.splitAndRevers("ba", separators));
        assertEquals(msg,"abcd", Reverser.splitAndRevers("dcba", separators));
        assertEquals(msg,"ab6cd", Reverser.splitAndRevers("dc6ba", separators));

        msg = "тестирование на смешанных строках";
        assertEquals(msg,"abcd 1234,534 09", Reverser.splitAndRevers("dcba 4321,435 90", separators));
        assertEquals(msg,"йывреп, йоротв - йитерт. ытревтеЧ!!! :-? йытяп\nйотсеш", Reverser.splitAndRevers("первый, второй - третий. Четверты!!! :-? пятый\nшестой", separators));
        //тестирование на строках начинающихся  и заканчивающихся сепараторами
        assertEquals(msg,"!!!?abcd 1234,534 09 !! ", Reverser.splitAndRevers("!!!?dcba 4321,435 90 !! ", separators));

        //изменим множество сепараторов
        separators = Reverser.SPACE_SEPARATORS;
        assertEquals(msg,",йывреп !йытревтеЧйитерт\nйоротв", Reverser.splitAndRevers("первый, второй\nтретийЧетвертый!", separators));

        msg = "тестирование на пустом массиве сепараторов";
        separators = Reverser.EMPTY_SEPARATORS;
        assertEquals(msg,"rwl; !543345 43242 646 5,234:321", Reverser.splitAndRevers("123:432,5 646 24234 543345! ;lwr", separators));
    }

    /**
     * Тестирование при null строке
     *
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void test2SplitAndRevers() throws Exception {
        Reverser.splitAndRevers(null, Reverser.EMPTY_SEPARATORS);
    }
}