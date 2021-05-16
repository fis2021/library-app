package lapp.services;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    public static  String APPLICATION_FOLDER = ".library-app";
    private static final String USER_FOLDER = System.getProperty("user.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return getApplicationHomeFolder().resolve(Paths.get(".", path));
    }


    public static Path getApplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }


    public static void initDirectory() {
        System.out.print("\nFILE ");
        System.out.print("SYSTEM ");
        System.out.print("SERVICE");
        System.out.print(" - ");
        System.out.print("Initialising ");
        System.out.print(" Directory\n");
        Path applicationHomePath = getApplicationHomeFolder();
        //Path applicationHomePath =Paths.get(FileSystemService.USER_FOLDER,FileSystemService.APPLICATION_FOLDER);
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }



}
