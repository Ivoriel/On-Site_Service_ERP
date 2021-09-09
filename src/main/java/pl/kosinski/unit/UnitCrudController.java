package pl.kosinski.unit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/units")
@AllArgsConstructor
public class UnitCrudController {

    private UnitCrudService unitCrudService;

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
        return "redirect:/units";
    }

    @GetMapping("/update/{id}")
    public String updateUnit(Model model, @PathVariable long id) {
        model.addAttribute("client", unitCrudService.findUnitbyId(id));
        return "/units/update";
    }

    @PutMapping("/update/{id}")
    public String updateClient(@Valid UnitInfoDto unitInfoDto, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "/units/update/" + id;
        }
        unitCrudService.saveUnit(unitInfoDto);
        return "redirect:/units";
    }

    @DeleteMapping("")
    public String deleteClient(Model model) {
        unitCrudService.deleteUnit(Long.parseLong((String)model.getAttribute("unit")));
        return "redirect:/clients";
    }

}
