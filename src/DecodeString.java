import java.util.Stack;
public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentNumber = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentNumber);
                stringStack.push(currentString);

                currentString = "";
                currentNumber = 0;
            } else if (c == ']') {
                int count = countStack.pop();
                StringBuilder tmp = new StringBuilder(stringStack.pop());
                for (int i = 0; i < count; i++) {
                    tmp.append(currentString);
                }
                currentString = tmp.toString();
            } else {
                currentString = currentString + c;
            }
        }
        return currentString;
    }
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}

