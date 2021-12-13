package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        try {
            humans = createHumans(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, createMaleList(humans));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    private List<Human> createHumans (List<String> inputData) {
        List<Human> humans = new ArrayList<>();
        for (String actual : inputData) {
            String[] line = actual.split(";");
            humans.add(new Human(line[0], line[1]));
        }
        return humans;
    }

    private List<String> createMaleList(List<Human> humanData) {
        List<String> males = new ArrayList<>();
        for (Human actual : humanData) {
            if (!actual.getIdentityNumber().startsWith("2")) {
                males.add(actual.getName() + ";" + actual.getIdentityNumber());
            }
        }
        return males;
    }
}
