import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Michael von Bothmer
 * @author Andreas Braining
 * @author Richard Deterer
 *
 * Die Klasse ist dazu da, einen Text zu entschluesseln, der zuvor mittels Huffman-Codierung verschluesselt wurde.
 */
public class Huffman {
    /**
     * Die Funktion entschluesselt einen Text in einer Datei
     *
     * @param f die Datei die entschluesselt werden soll
     * @return den entschluesselten Text
     * @throws FileNotFoundException falls die Datai nicht gefunden wurde
     */
    public static String decode (File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(f);
        if (!scanner.hasNextLine())
            throw new RuntimeException();

        String codeword = scanner.nextLine();

        // Codierungen fuer die einzelnen Zeichen einlesen
        TreeMap<String, Character> map = new TreeMap<>();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        for (int i = 0; i < chars.length(); ++i) {
            if (!scanner.hasNextLine())
                throw new RuntimeException();

            String code = scanner.nextLine();
            map.put(code, chars.charAt(i));
        }

        // Codewort entschluesseln
        StringBuilder word = new StringBuilder();
        String code;
        int beginIndex = 0;
        int length = 0;
        while (beginIndex < codeword.length()) {
            do {
                length++;
                code = codeword.substring(beginIndex, beginIndex + length);
            } while (!map.containsKey(code));
            word.append(map.get(code));
            beginIndex += length;
            length = 1;
        }

        return word.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(Huffman.decode(new File("message.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}