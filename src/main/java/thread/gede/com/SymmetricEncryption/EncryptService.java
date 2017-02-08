package thread.gede.com.SymmetricEncryption;

public class EncryptService {

    public String encode(String password) throws Exception {
        Thread.sleep(100);
        return new EncryptionTest().encrypt(password);
    }

    public String decode(String textDeCipher) throws Exception {
        Thread.sleep(100);
        return new EncryptionTest().deCiphering(textDeCipher);
    }

}
