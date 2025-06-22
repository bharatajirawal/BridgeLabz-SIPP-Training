import java.util.HashSet;
import java.util.Random;

public class OTPUtility {

    public static int generateOTP() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); // 6-digit OTP
    }

    public static boolean areUniqueOTPs(int count) {
        HashSet<Integer> otpSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int otp = generateOTP();
            if (otpSet.contains(otp)) return false;
            otpSet.add(otp);
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 10;
        boolean unique = areUniqueOTPs(count);
        System.out.println("Generated " + count + " OTPs. All unique? " + unique);
    }
}
