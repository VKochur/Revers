package kvv.education.khasang.java_intern.string_revers;

/**
 * Класc, предоставляющий метод реверса порядка букв в словах текста
 */
public class Reverser {

    /**
     * Примеры наборов разделителей
     */
    public static final char[] PUNCTUATION_SEPARATORS = {' ', '.', ',', '!', '?', '-', ':', '\n', '\"', '\''};
    public static final char[] SPACE_SEPARATORS = {' '};
    public static final char[] EMPTY_SEPARATORS = {};

    /**
     * Возвращает строку, в которой изменены слова из text: в словах изменен порядок букв на обратный.
     * Словом считается символ или последовательность символов, отделенная от других слов одним или несколькими сепараторами.
     * Сепаратором считается символ, являющийся элементом separators
     * Сепаратор или последовательность сепараторов словом не считается.
     * @param text на основе чего которой будет сгенерирована строка с "обратимыми" словами
     * @param separators символы, которые следует считать сепараторами
     * @return
     */
    public static String splitAndRevers(String text, char[] separators) {
        StringBuilder result = new StringBuilder();
        //указатель на начало очередного слова или на начало последовательности сепараторов
        int current = -1;
        int next;
        while (current != text.length() - 1) {
            //определим новое место справа относительно текущего указателя. Место где начинается очередное слово или последовательность сепараторов
            next = defineNextPosition(text, separators, current);
            //текущий указатель - перед позицией откуда ничинается,
            //новое место на позиции - позиция которой заканчивается искомая последовательность
            String word = text.substring(current + 1, next + 1);
            //надо определить что это, если не сепараторы, то обратим
            if (!isSeparator(word.charAt(0), separators)) {
                word = revers(word);
            }
            //передвинем текущий указатель
            current = next;
            result.append(word);
        }
        return result.toString();
    }

    /**
     * Определение новой позиции для указателя на символ text вправо от from.
     * Новая позиция характеризуется: максимально смещено вправо от указанного from, при соблюдении условия:
     * от from, до новой позиции все символы являются сепараторами, или все не являются.
     * @param text
     * @param separators сепаратры
     * @param from от какой позиции вправо ищется новая позиция
     * @return
     */
    private static int defineNextPosition(String text, char[] separators, int from) {
        if (from > text.length() - 1) {
            throw new IllegalStateException("Достигнут конец текста, указатель перемещать некуда");
        }
        int result = from + 1;
        //двигаемся пока впереди или подряд сепараторы, или подряд не сепараторы
        boolean isNextSeparator = isSeparator(text.charAt(result), separators);
        for (int i = from + 2; i < text.length(); i++) {
            if (isNextSeparator == isSeparator(text.charAt(i), separators)) {
                result = i;
            } else {
                break;
            }
        }
        return result;
    }

    private static boolean isSeparator(char c, char[] separators) {
        for (char separator : separators) {
            if (separator == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * Изменение порядка букв в слове на обратный
     * @param word
     * @return
     */
    private static String revers(String word) {
        char[] chars = word.toCharArray();
        int count = word.length() / 2;
        for (int i = 0; i < count; i++) {
            char tmp = chars[i];
            chars[i] = chars[word.length() - 1 - i];
            chars[word.length() - 1 - i] = tmp;
        }
        return String.valueOf(chars);
    }
}
