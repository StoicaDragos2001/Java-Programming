public final class Validate {
    //Stoica Dragos-Stefan 2A5
    public static boolean ValidateInteger(String x){
        int stringToInt;
        try{
            stringToInt = Integer.parseInt(x);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
