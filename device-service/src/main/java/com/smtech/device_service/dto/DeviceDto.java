/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/6/2026
 * <p>
 * Description: DeviceDto class handles ...
 */

package com.smtech.device_service.dto;

import com.smtech.device_service.model.DeviceType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceDto {
    private Long id;
    private String name;
    private DeviceType type;
    private String location;
    private Long userId;
}
