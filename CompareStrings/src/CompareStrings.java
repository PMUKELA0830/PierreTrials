public class CompareStrings {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String string1 = "Greatest of all";
        String string2 = "greatest Of All";

        if(string1.equalsIgnoreCase(string2)){
            System.out.println("The strings " + string1 + " and "
            + string2 + " are equal.");
        }
    }
}
