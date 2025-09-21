package org.example.car_dealer.dtos.supplierDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SupplierInputDto {

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty(localName = "is-importer")
    private Boolean isImporter;

    public SupplierInputDto() {
    }

    public SupplierInputDto(String name, Boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}
