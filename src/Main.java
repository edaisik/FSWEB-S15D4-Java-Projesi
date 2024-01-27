import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println("------------------------");

        System.out.println(checkForPalindromeQueue("abccba"));
        System.out.println(checkForPalindromeQueue("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeQueue("I did, did I?"));
        System.out.println(checkForPalindromeQueue("hello"));
        System.out.println(checkForPalindromeQueue("Don't node"));

        System.out.println("--------------------");
        System.out.println(convertBinary(5));
        System.out.println(convertBinary(6));
        System.out.println(convertBinary(13));

    }

    public static boolean checkForPalindrome(String text) {

        text = text.replaceAll("[.,'?\\-\\s]", "").toLowerCase(Locale.ENGLISH);

        Stack<Character> CharStack = new Stack<>();
        Stack<Character> stackTemp = new Stack<>();
        Stack<Character> stackReversed = new Stack<>();

        char[] chars = text.toCharArray();
        for (char c : chars) {
            CharStack.push(c);
            stackTemp.push(c);
        }

        for (char c : chars) {
            Character charTemp = stackTemp.pop();
            stackReversed.push(charTemp);
        }

        System.out.println("reversed=" + stackReversed);
        System.out.println("original=" + CharStack);

        if (CharStack.equals(stackReversed)) {
            return true;
        }



        return false;
    }

    public static boolean checkForPalindromeQueue(String text) {
        System.out.println("initial text= " + text);
        text = text.replaceAll("[.,'?\\-\\s]", "").toLowerCase(Locale.ENGLISH);

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        char[] chars = text.toCharArray();
        for (char c : chars) {
            stack.push(c);
            queue.offer(c);


        }
        System.out.println("queue" + queue);
        System.out.println("stack" + stack);

        while (!queue.isEmpty()) {
            Character character = queue.remove();

            if (character != stack.pop()) {
                return false;
            }
        }
        return true;


    }

    public static LinkedList<Integer> convertBinary(int number){

        Stack<Integer> remainStack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();

        while(number> 0 ){
            int remain = number % 2;
            remainStack.push(remain);
            number = number / 2;
        }

        Iterator<Integer> iterator = remainStack.iterator();
        while(iterator.hasNext()){
            Integer binary = iterator.next();
            result.push(binary);
        }




        return result;
    }
}