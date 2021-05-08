package lapp.services;

import lapp.exceptions.AccountDoesNotExistException;
import lapp.exceptions.ShortPasswordException;
import lapp.exceptions.UsernameAlreadyExistsException;
import lapp.exceptions.WrongPasswordException;
import lapp.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static lapp.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .compressed()
                .filePath(getPathToFile("library-app.db").toFile())
                .openOrCreate("admin", "password");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String fullName, String email, String phone, String username, String password) throws UsernameAlreadyExistsException, ShortPasswordException {
        checkUserDoesNotAlreadyExist(username);
        checkPasswordLongEnough(password);
        userRepository.insert(new User( fullName, email, phone, username, encodePassword(username, password)));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException();
        }
    }

    private static void checkPasswordLongEnough(String password) throws ShortPasswordException {
        if (password.length() < 8)
                throw new ShortPasswordException();
    }

    public static void checkCredentials(String username, String password) throws WrongPasswordException, AccountDoesNotExistException {
        int found_username = 0;
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                found_username = 1;
                String user_pass_entered = encodePassword(username, password); //encrypt argument password
                if (!user_pass_entered.equals(user.getPassword())) {
                    throw new WrongPasswordException();
                }
            }
        }
        if (found_username == 0) {
            throw new AccountDoesNotExistException();
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

}