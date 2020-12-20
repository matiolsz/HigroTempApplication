package pl.olszanka.HigroTempApplication.thymeleafControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.olszanka.HigroTempApplication.domain.Measurement;
import pl.olszanka.HigroTempApplication.domain.Room;
import pl.olszanka.HigroTempApplication.service.RoomService;

import java.util.List;

@Controller
@RequestMapping("/roomsTL")
public class RoomsControllerTL {

    RoomService roomService;

    @Autowired
    private RoomsControllerTL(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public String showRooms(Model model){
        List<Room> roomList = roomService.getAll();
        model.addAttribute("roomList", roomList);
        return "list-rooms";
    }
}
