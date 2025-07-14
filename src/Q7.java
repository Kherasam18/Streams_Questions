import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        String str = "A paragraph is a self-contained unit of discourse in writing that deals with a particular point or idea. It typically consists of several sentences that are unified and coherent, meaning they work together to express a single thought clearly. The length of a paragraph can vary, but it is generally defined by its content rather than a specific number of sentences. The purpose of a paragraph is to organize ideas and provide clarity in writing, ensuring that each paragraph focuses on a distinct topic or argument.";
        String[] word = str.split(" ");
        Map<String, Long> map = Arrays.stream(word)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
}
