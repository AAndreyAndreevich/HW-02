package utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.ModelsLists;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JaxbUtil {
    private static final Logger logger = Logger.getLogger(JaxbUtil.class.getSimpleName());

    private JaxbUtil(){}

    public static void writer(ModelsLists modelLists) {
        try {
            JAXBContext context = JAXBContext.newInstance(ModelsLists.class);
            Marshaller marshaller = context.createMarshaller();
            try {
                Files.createDirectory(Paths.get("src\\xmlReqs"));
                logger.log(Level.INFO, "Папка создана");
            } catch (IOException ioEx) {
                logger.log(Level.SEVERE, "Ошибка {0}", ioEx.getMessage());
            }
            File createReq = new File("xmlReqs\\req.xml");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(modelLists, createReq);
        } catch (JAXBException jaxbE) {
            logger.log(Level.SEVERE, "Ошибка {0}", jaxbE.getMessage());
        }
        logger.log(Level.INFO, "Работа JAXB окончена");
    }
}