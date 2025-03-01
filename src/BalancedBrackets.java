import java.util.LinkedList;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {

            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.add(0,c); //(0,c) helps me simulate LIFO since using remove() takes away the first element and not last.
                    break;
                case '}':
                    if (stack.peek() != '{' || stack.peek() == null) {
                        return "NO";
                    }
                    stack.remove();
                    break;

                case ']':
                    if (stack.peek() != '[' || stack.peek() == null) {
                        return "NO";
                    }
                    stack.remove();
                    break;
                case ')':
                    if (stack.peek() != '(' || stack.peek() == null) {
                        return "NO";
                    }
                    stack.remove();
                    break;
                default:
                    return "NO";
            }
        }
        if (stack.peek() == null) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) {
        // Sample inputs
        System.out.println(isBalanced("{[()]}"));       // Output: YES
        System.out.println(isBalanced("{[(])}"));       // Output: NO
        System.out.println(isBalanced("{{[[(())]]}}")); // Output: YES
    }
}


