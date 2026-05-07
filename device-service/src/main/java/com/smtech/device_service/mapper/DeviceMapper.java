package com.smtech.device_service.mapper;


import com.smtech.device_service.dto.DeviceDto;
import com.smtech.device_service.entity.Device;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toEntity(DeviceDto deviceDto);
    DeviceDto toDto(Device device);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(DeviceDto dto, @MappingTarget Device entity);
}
