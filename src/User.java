import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String receivedUserName;
    String receivedFirstName;
    String receivedLastName;
    String receivedPassword;

    public User(String receivedUserName, String receivedFirstName, String receivedLastName, String receivedPassword) {
        this.receivedUserName = receivedUserName;
        this.receivedFirstName = receivedFirstName;
        this.receivedLastName = receivedLastName;
        this.receivedPassword = receivedPassword;
    }

    public String getReceivedUserName() {
        return receivedUserName;
    }

    public String getReceivedFirstName() {
        return receivedFirstName;
    }

    public String getReceivedLastName() {
        return receivedLastName;
    }

    public String getReceivedPassword() {
        return receivedPassword;
    }

    public void login(String userName, String password) { // should take in the username and password as paramaters. this is public so it can be accessed from outside but the rest of the methods here are private.
        checkUser(userName, encrypt(password));
    }

    public void createUser(String userName, String password) throws FileNotFoundException {
        checkUserExists(userName);// returns a boolean - true for they do exist
        //if the above returns true so the user exists then have them enter again
        writeToFile(userName, encrypt(password));

        login(userName, password);// has them login after creating it to make sure
    }

    private String encrypt(String passwordToHash) {

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
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }

    private boolean checkUser(String userName, String passwordEncrypted) {
        //checks the file using the username then checks then compares the hashed passwords to see if they are the same.
        // should return true if user has correct password and false otherwise
        return true;
    }

    private void writeToFile(String userName, String passwordEncrypted) {
        //writes to the user file when making a new user
        //file format: Bobbyhart9333, Bobby, Hart, 8390g3ugb2i0n29f0
        //                userName    first  last  hashed passWord
    }

    private boolean checkUserExists(String userName) throws FileNotFoundException {
        // returns true if user exists and false if does not. we want it to be false
        //only checks usernames not passwords.
        boolean userExists = false;
        ArrayList<User> users = new ArrayList<>();
        users = usersFromFile();
        for(User k: users)
        {
            if(userName.equals(k)){
                userExists = true;
            }
        }
        return userExists;
    }
    private ArrayList<User> usersFromFile() throws FileNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        Scanner in;
        String line;


        File file = new File(String.valueOf(Paths.get("user.txt")));
        in = new Scanner(file);
        while (in.hasNextLine()){
            line = in.nextLine();
            String split[] = line.trim().split(",");
            receivedUserName = split[0];
            receivedFirstName = split[1];
            receivedLastName = split[2];
            receivedPassword = split[3];
            users.add(new User(receivedUserName, receivedFirstName, receivedLastName, receivedPassword));

        }
        in.close();
        return users;
    }

}
