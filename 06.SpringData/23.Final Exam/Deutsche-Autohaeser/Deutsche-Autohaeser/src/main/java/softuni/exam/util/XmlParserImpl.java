package softuni.exam.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import softuni.exam.models.dto.DealerImportDto;

import java.io.StringReader;

@Component
public class XmlParserImpl implements XmlParser {
    private final Unmarshaller unmarshaller;

    public XmlParserImpl() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DealerImportDto.class);
        this.unmarshaller = jaxbContext.createUnmarshaller();
    }


    @Override
    public <T> T fromFile(String xml, Class<T> tClass) throws JAXBException {
        try (StringReader reader = new StringReader(xml)) {
            return (T) unmarshaller.unmarshal(reader);
        }
    }
}
