public class User {
    private String key = "sundance";
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
    private String encrypt(String password){
        //encrypts with the key and returns encrypted password
        String passwordToReturn = "";

        return passwordToReturn;
    }
    private boolean checkUser(String userName, String passwordEncrypted){
        //checks the file using the username then checks then compares the hashed passwords to see if they are the same.
        // should return true if user has correct password and false otherwise
    return true;
    }
    private void writeToFile(String userName, String passwordEncrypted){
        //writes to the user file when making a new user
    }
    private boolean checkUserExists(String userName){
        // returns true if user exists and false if does not. we want it to be false
        //only checks usernames not passwords.
        return true;
    }

}
