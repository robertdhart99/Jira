import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    String fileUserName;
    String filePasswordEncrypted;
    String fileFirstName;
    String fileLastName;


    public void login(String userName, String password){ // should take in the username and password as paramaters. this is public so it can be accessed from outside but the rest of the methods here are private.
        checkUser(userName, encrypt(password));
    }
    public void createUser(String userName, String password){
        checkUserExists(userName);// returns a boolean - true for they do exist
        //if the above returns true so the user exists then have them enter again
        writeToFile(userName, encrypt(password));

        login(userName, password);// has them login after creating it to make sure
    }
    private String encrypt(String passwordToHash){

        // very basic and not all that secure - MD5
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return generatedPassword;
    }
    private boolean checkUser(String userName, String passwordEncrypted){
        //checks the file using the username then checks then compares the hashed passwords to see if they are the same.
        // should return true if user has correct password and false otherwise
    return true;
    }
    private void writeToFile(String userName, String passwordEncrypted){
        //writes to the user file when making a new user
        //file format: Bobbyhart9333, Bobby, Hart, 8390g3ugb2i0n29f0
        //                userName    first  last  hashed passWord
    }
    private boolean checkUserExists(String userName){
        // returns true if user exists and false if does not. we want it to be false
        //only checks usernames not passwords.
        return true;
    }

}
