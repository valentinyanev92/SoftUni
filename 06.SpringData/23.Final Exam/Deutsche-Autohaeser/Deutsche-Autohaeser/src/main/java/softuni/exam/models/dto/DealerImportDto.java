package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dealers")
public class DealerImportDto {

    @XmlElement(name = "dealer")
    private List<DealerInputDto> dealers;

    public List<DealerInputDto> getDealerInputDto() {
        return dealers;
    }

    public void setDealerInputDto(List<DealerInputDto> dealerInputDto) {
        this.dealers = dealerInputDto;
    }
}
