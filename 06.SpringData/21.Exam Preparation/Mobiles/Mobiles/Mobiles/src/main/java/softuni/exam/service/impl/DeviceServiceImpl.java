package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceInputDto;
import softuni.exam.models.dto.DevicesInputDto;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final SaleService saleService;


    public DeviceServiceImpl(DeviceRepository deviceRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, SaleService saleService) {
        this.deviceRepository = deviceRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.saleService = saleService;
    }

    @Override
    public boolean areImported() {
        return deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/xml/devices.xml");
//        Path path = Paths.get("D:\\SpringData\\21.Exam Preparation\\Mobiles\\Mobiles\\Mobiles\\src\\main\\resources\\files\\xml\\devices.xml");
        return Files.readString(path);
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        DevicesInputDto devicesInputDto = xmlParser.fromXml(readDevicesFromFile(), DevicesInputDto.class);

        StringBuilder sb = new StringBuilder();
        for (DeviceInputDto inputDto : devicesInputDto.getInput()) {
            Device createdDevice = create(inputDto);
            if (createdDevice == null) {
                sb.append(String.format("Invalid device%n"));
            } else {
                sb.append(String.format("Successfully imported device of type %s with brand %s%n", createdDevice.getDeviceType(), createdDevice.getBrand()));
            }

        }

        return sb.toString();
    }

    private Device create(DeviceInputDto deviceInputDto) {
        if (!validationUtil.isValid(deviceInputDto)) {
            return null;
        }

        try {
            Device device = modelMapper.map(deviceInputDto, Device.class);

            Long saleId = deviceInputDto.getSale();
            if (saleId != null) {
//                Sale sale = saleService.getSaleById(saleId);
                Sale sale = saleService.getReferenceById(saleId);
                device.setSale(sale);
            }

            deviceRepository.save(device);
            return device;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportDevices() {
        List<Device> devices = deviceRepository.findExportable(DeviceType.SMART_PHONE, 1000.0, 128);

        StringBuilder sb = new StringBuilder();
        for (Device device : devices) {
            sb.append(String.format("Device brand: %s%n", device.getBrand()));
            sb.append(String.format("   *Model: %s%n", device.getModel()));
            sb.append(String.format("   **Storage: %d%n", device.getStorage()));
            sb.append(String.format("   ***Price: %.2f%n", device.getPrice()));
        }

        return sb.toString();
    }
}
