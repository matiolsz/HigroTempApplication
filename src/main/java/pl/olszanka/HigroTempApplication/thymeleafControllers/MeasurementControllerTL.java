package pl.olszanka.HigroTempApplication.thymeleafControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.olszanka.HigroTempApplication.domain.Measurement;
import pl.olszanka.HigroTempApplication.service.MeasurementService;

import java.util.List;

@Controller
@RequestMapping("/measurementsTL")
public class MeasurementControllerTL {

    MeasurementService measurementService;

    @Autowired
    private MeasurementControllerTL(MeasurementService measurementService){
        this.measurementService = measurementService;
    }

    @GetMapping
    public String showMeasurements(Model model){
        List<Measurement> measurementList = measurementService.getAll();
        model.addAttribute("measurementList", measurementList);
        return "measurements/list-measurements";
    }
}
