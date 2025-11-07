public class Key {

    private String keyCipher;
    private String keyId;


    public Key(String keyId){
        this.keyId = keyId;
        this.keyCipher = "";
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    public void setKeyCipher(String cipher) {
        this.keyCipher = cipher;
    }

    @Override
    public String toString() {
        return keyId;
    }
//    public String getKeyId() {
//        return keyId;
//    }
}
