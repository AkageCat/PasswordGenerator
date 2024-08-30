import java.security.SecureRandom;

public class Generator {
    public String generateAppleEasyToTypePassword() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder password = new StringBuilder();
        int[] numberPlaces = {0, 5, 7, 12, 14, 19};
        int numberPlace = numberPlaces[secureRandom.nextInt(numberPlaces.length)];

        int upperCasePlace = -1;
        while (upperCasePlace == -1) {
            int possibleUpperCasePlace = secureRandom.nextInt(20);
            if (possibleUpperCasePlace != 6 && possibleUpperCasePlace != 13 && possibleUpperCasePlace != numberPlace) {
                upperCasePlace = possibleUpperCasePlace;
            }
        }

        for (int i = 0; i < 20; i++) {
            if (i == 6 || i == 13) {
                password.append("-");
            } else if (i == numberPlace) {
                password.append(secureRandom.nextInt(10));
            } else if (i == upperCasePlace) {
                password.append((char) secureRandom.nextInt(65, 91));
            } else {
                password.append((char) secureRandom.nextInt(97, 123));
            }
        }
        return password.toString();
    }

    public String generatePasscode(int length) {
        StringBuilder passcode = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            passcode.append(secureRandom.nextInt(10));
        }
        return passcode.toString();
    }

    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            password.append((char) secureRandom.nextInt(33, 127));
        }
        return password.toString();
    }
}