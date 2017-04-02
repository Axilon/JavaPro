package ru.bk.rom4ik2103;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBWorker {

    public static void saveToXMLFile(EstateAgency estateAgency, File file) {
        try {
            JAXBContext jaxbC = JAXBContext.newInstance(EstateAgency.class);
            Marshaller marSh = jaxbC.createMarshaller();
            marSh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marSh.marshal(estateAgency, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static EstateAgency loadFromXMLFile(File file) {
        JAXBContext jaxbC = null;
        try {
            jaxbC = JAXBContext.newInstance(EstateAgency.class);
            Unmarshaller unmarshaller = jaxbC.createUnmarshaller();
            EstateAgency trains = (EstateAgency) unmarshaller.unmarshal(file);
            return trains;
        } catch (JAXBException e) {
            e.printStackTrace();
        }return null;
    }
}
