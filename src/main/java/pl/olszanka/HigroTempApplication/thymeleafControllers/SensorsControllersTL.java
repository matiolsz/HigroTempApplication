package pl.olszanka.HigroTempApplication.thymeleafControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.olszanka.HigroTempApplication.domain.Room;
import pl.olszanka.HigroTempApplication.domain.Sensor;
import pl.olszanka.HigroTempApplication.domain.dto.SensorDTO;
import pl.olszanka.HigroTempApplication.service.RoomService;
import pl.olszanka.HigroTempApplication.service.SensorService;

import java.util.List;

@Controller
@RequestMapping("/sensorsTL")
public class SensorsControllersTL {

    SensorService sensorService;
    RoomService roomService;

    @Autowired
    private SensorsControllersTL(SensorService sensorService, RoomService roomService){
        this.sensorService = sensorService;
        this.roomService = roomService;
    }

    @GetMapping
    public String showSensors(Model model){
        List<Sensor> sensorsList = sensorService.findAll();
        List<Room> roomList = roomService.getAll();
        SensorDTO sensorDTO = new SensorDTO();
        model.addAttribute("sensorsList", sensorsList);
        model.addAttribute("roomList", roomList);
        return "sensors/list-sensors";
    }

    @PostMapping("/submitRoomToSensor/{id}")
    private String submitRoomToSensor(@PathVariable("id") Long id,Model model, SensorDTO sensorDTO){
        Long roomId = sensorDTO.getRoomId();
        List<Room> roomList = roomService.getAll();
        model.addAttribute("roomList", roomList);
        sensorService.addRoomToSensor(id,sensorDTO.getRoomId());
        return "redirect:/sensorsTL";
    }
}
