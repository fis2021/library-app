import lapp.exceptions.ShortPasswordException;
import lapp.exceptions.UsernameAlreadyExistsException;
import lapp.model.User;
import lapp.services.DatabaseService;
import lapp.services.FileSystemService;
import lapp.services.UserService;
import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {
    public static final String ADMIN = "admin1";

    @BeforeAll
    static void beforeAll(){
        System.out.println("before class");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after class");
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER=".test.library-app-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        DatabaseService.initDatabase();
    }

    @AfterEach
    void tearDown(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Database is initialized and there are no users")
    void testDatabaseIsInitializedAndNoUserIsPersisted(){
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is successfully persisted to Database")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException, ShortPasswordException {
        UserService.addUser(ADMIN,ADMIN,ADMIN,ADMIN,ADMIN);
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user.getUsername()).isEqualTo(ADMIN);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(ADMIN,ADMIN));
        assertThat(user.getEmail()).isEqualTo(ADMIN);
        assertThat(user.getPhone()).isEqualTo(ADMIN);
        assertThat(user.getFullName()).isEqualTo(ADMIN);
    }

    @Test
    @DisplayName("User can not be added twice")
    void testUserCanNotBeAddedTwice() {
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser(ADMIN,ADMIN,ADMIN,ADMIN,ADMIN);
            UserService.addUser(ADMIN,ADMIN,ADMIN,ADMIN,ADMIN);
        });
    }

}