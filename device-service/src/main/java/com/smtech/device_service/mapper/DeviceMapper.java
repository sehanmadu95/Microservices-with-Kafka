package com.smtech.device_service.mapper;


import com.smtech.device_service.dto.DeviceDto;
import com.smtech.device_service.entity.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toEntity(DeviceDto deviceDto);
    DeviceDto toDto(Device device);
}
