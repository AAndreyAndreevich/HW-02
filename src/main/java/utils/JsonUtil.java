package utils;

import com.google.gson.GsonBuilder;
import model.ModelsLists;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {
    private static final Logger logger = Logger.getLogger(JsonUtil.class.getSimpleName());

    private JsonUtil() {}

    private static void students(ModelsLists modelsLists) {
        String studentsJson = JsonUtil.writeListToJson(modelsLists.getStudentList());
        DateFormat df = new SimpleDateFormat("dd-MMM-yyy HH-mm");
        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs\\students " +
                    (df.format(modelsLists.getDate().getTime())) + ".json");
            fos.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка {0}", e.getMessage());
        }
    }

    private static void universities(ModelsLists modelsLists) {
        String universitiesJson = JsonUtil.writeListToJson(modelsLists.getUniversityList());
        DateFormat df = new SimpleDateFormat("dd-MMM-yyy HH-mm");
        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs\\universities " +
                    (df.format(modelsLists.getDate().getTime())) + ".json");
            fos.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка {0}", e.getMessage());
        }
    }

    private static void statistics(ModelsLists modelsLists) {
        String statisticsJson = JsonUtil.writeListToJson(modelsLists.getStatisticsList());
        DateFormat df = new SimpleDateFormat("dd-MMM-yyy HH-mm");
        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs\\statistics " +
                    (df.format(modelsLists.getDate().getTime())) + ".json");
            fos.write(statisticsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка {0}", e.getMessage());
        }
    }

    public static void writer(ModelsLists modelsLists) {
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO,"Папка Json создана");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка {0}", e.getMessage());
        }
        students(modelsLists);
        universities(modelsLists);
        statistics(modelsLists);
        logger.log(Level.INFO, "Работа Json окончена");
    }

    private static String writeListToJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
}