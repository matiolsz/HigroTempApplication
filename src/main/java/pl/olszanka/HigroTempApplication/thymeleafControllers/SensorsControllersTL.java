package pl.olszanka.HigroTempApplication.thymeleafControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.olszanka.HigroTempApplication.domain.Room;
import pl.olszanka.HigroTempApplication.domain.Sensor;
import pl.olszanka.HigroTempApplication.service.SensorService;

import java.util.List;

@Controller
@RequestMapping("/sensorsTL")
public class SensorsControllersTL {

    SensorService sensorService;

    @Autowired
    private SensorsControllersTL(SensorService sensorService){
        this.sensorService = sensorService;
    }

    @GetMapping
    public String showSensors(Model model){
        List<Sensor> sensorsList = sensorService.findAll();
        model.addAttribute("sensorsList", sensorsList);
        return "sensors/list-sensors";
    }

}
