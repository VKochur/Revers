package kvv.education.khasang.java_intern.string_revers;

public class Main {

    public static void main(String[] args) {
        demoReverser();
    }

    private static void demoReverser() {
        final String TEXT = "Мама мыла раму, а папа курил трубку! Потом мама спросила: \"И долго ты будешь курить?!\"\n\"Бросаю...\" -лениво ответил отец. Затем пересел на диван, включил футбол.";
        final String TEXT2 = "     Однажды, в студенную зимнюю пору, я из лесу вышел. Был сильный мороз. ";
        show(TEXT, Reverser.PUNCTUATION_SEPARATORS);
        System.out.println();
        show(TEXT2, Reverser.SPACE_SEPARATORS);
    }

    private static void show(String text, char[] separators) {
        System.out.println("--------Исходник--------");
        System.out.println(text);
        System.out.println("-------Перевертыш-------");
        System.out.println(Reverser.splitAndRevers(text, separators));
    }
}
