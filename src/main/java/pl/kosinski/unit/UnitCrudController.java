package pl.kosinski.unit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosinski.client.ClientCrudService;
import pl.kosinski.client.ClientInfoDto;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/units/form")
@AllArgsConstructor
public class UnitCrudController {

    private UnitCrudService unitCrudService;
    private ClientCrudService clientCrudService;

    @GetMapping("")
    public String unitHome(Model model) {
        model.addAttribute("units", unitCrudService.findAllUnits());
        return "/units/unitsHome";
    }

    @GetMapping("/create")
    public String createUnit(Model model) {
        model.addAttribute("unit", new UnitInfoDto());
        return "/units/create";
    }

    @PostMapping("/create")
    public String createUnit(@Valid UnitInfoDto unitInfoDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/units/create";
        }
        unitCrudService.saveUnit(unitInfoDto);
        return "redirect:/units/form";
    }

    @GetMapping("/details/{id}")
    public String getUnit(@PathVariable long id, Model model) {
        model.addAttribute("unit", unitCrudService.findUnitbyId(id));
        return "/units/details";
    }

    @GetMapping("/update/{id}")
    public String updateUnit(Model model, @PathVariable long id) {
        model.addAttribute("unit", unitCrudService.findUnitbyId(id));
        return "/units/update";
    }

    @PostMapping("/update/{id}")
    public String updateUnit(@Valid UnitInfoDto unitInfoDto, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "/units/update/" + id;
        }
        unitCrudService.saveUnit(unitInfoDto);
        return "redirect:/units/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUnit(@PathVariable long id, Model model) {
        model.addAttribute("unitId", id);
        return "/units/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUnit(@PathVariable long id) {
        unitCrudService.deleteUnit(id);
        return "redirect:/units/form";
    }

    @ModelAttribute("clients")
    public List<ClientInfoDto> clients() {
        return clientCrudService.findAllClients();
    }

}
