public class PhoneNumberValidator {
    public static boolean isValid(String phone){
        if (phone == null){
            return false;
        }

        if (phone.length() < 5 || phone.length() > 15){
            return false;
        }

        return phone.matches("[0-9 ()]+");
    }
}
