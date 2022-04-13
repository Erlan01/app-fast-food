package ai.ecma.order.utils;

import ai.ecma.order.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 09.03.2022
 */
@Component
public class AES {
    @Value("${aes.secret-key}")
    private static final String secretKey = "26h5lt0m-9zl9-3k"; //length of key is 16

    public static String encode(String plainText) {
        try {
            Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            String keyString = secretKey;
            byte[] key = keyString.getBytes(StandardCharsets.UTF_8);

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit

            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

            desCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] text = plainText.getBytes(StandardCharsets.UTF_8);
            byte[] textEncrypted = desCipher.doFinal(text);
            return Base64.getEncoder().encodeToString(textEncrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw RestException.attackResponse();
        }
    }

    public static String decode(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            String keyString = secretKey;
            byte[] key = keyString.getBytes(StandardCharsets.UTF_8);

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit


            SecretKey secretKey = new SecretKeySpec(key, "AES");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decode = Base64.getDecoder()
                    .decode(encryptedText);

            byte[] bytes = cipher.doFinal(decode);

            return new String(bytes);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw RestException.attackResponse();
        }
    }
}
