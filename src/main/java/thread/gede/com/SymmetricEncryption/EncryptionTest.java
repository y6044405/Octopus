package thread.gede.com.SymmetricEncryption;

import java.security.PrivateKey;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class EncryptionTest {

    private static final String key1 = "lianghuilonglong";

    private static final String key2 = "lianghuilonglona";

    private static final String iv = "aabbccddeeffgghh";

    public String encrypt(String text) throws Exception {
        PrivateKey keySpec = (PrivateKey) DigestUtil.toKey(key1, DigestUtil.RSA);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] b = cipher.doFinal(text.getBytes());
        String ret = Base64.encode(b);
        return ret;
    }

    public String deCiphering(String textDeCipher) throws Exception {
        byte[] b = Base64.decode(textDeCipher);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        PrivateKey keySpec = (PrivateKey) DigestUtil.toKey(key1, DigestUtil.RSA);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] ret = cipher.doFinal(b);
        return new String(ret, "utf-8");
    }

}
