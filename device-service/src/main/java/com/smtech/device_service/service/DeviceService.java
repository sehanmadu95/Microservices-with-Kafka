/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/6/2026
 * <p>
 * Description: DeviceService class handles ...
 */

package com.smtech.device_service.service;

import com.smtech.device_service.dto.DeviceDto;
import com.smtech.device_service.entity.Device;
import com.smtech.device_service.exception.DeviceNotFoundException;
import com.smtech.device_service.mapper.DeviceMapper;
import com.smtech.device_service.repository.DeviceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    public DeviceDto getDeviceById(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device not found with id: " + id));

        return deviceMapper.toDto(device);
    }

    public DeviceDto createDevice(DeviceDto deviceDto) {
        Device device = deviceMapper.toEntity(deviceDto);
        Device savedDevice = deviceRepository.save(device);

        return deviceMapper.toDto(savedDevice);
    }

    public DeviceDto updateDevice(Long id, DeviceDto deviceDto) {
        Device existingDevice = deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device not found with id: " + id));
        deviceMapper.updateEntityFromDto(deviceDto, existingDevice);
        Device savedDevice = deviceRepository.save(existingDevice);

        return deviceMapper.toDto(savedDevice);
    }

    public ResponseEntity<String> deletDevice(Long id) {
        Device existingDevice = deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device not found with id: " + id));
        deviceRepository.delete(existingDevice);
        return new ResponseEntity<>("Device deleted", HttpStatus.OK);
    }
}
