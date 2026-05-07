/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/6/2026
 * <p>
 * Description: DeviceController class handles ...
 */

package com.smtech.device_service.controller;

import com.smtech.device_service.dto.DeviceDto;
import com.smtech.device_service.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/device")
@Slf4j
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id) {
        DeviceDto deviceDto= deviceService.getDeviceById(id);

        if (deviceDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deviceDto);
    }

    @PostMapping
    public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto) {
        log.info("Creating device with name: " + deviceDto.getName());
        DeviceDto createdDevice= deviceService.createDevice(deviceDto);
        log.info("Created device with name: " + createdDevice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDevice);
    }
}
