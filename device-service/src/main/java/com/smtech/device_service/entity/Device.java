/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/6/2026
 * <p>
 * Description: Device class handles ...
 */

package com.smtech.device_service.entity;

import com.smtech.device_service.model.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "device")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DeviceType type;

    private String location;
    private Long userId;




}
