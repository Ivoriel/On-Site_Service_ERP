package pl.kosinski.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosinski.unit.UnitCrudService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients/form")
@AllArgsConstructor
public class ClientCrudController {

    private ClientCrudService clientCrudService;
    private UnitCrudService unitCrudService;

    @GetMapping("")
    public String clientHome(Model model) {
        model.addAttribute("clients", clientCrudService.findAllClients());
        return "/clients/clientsHome";
    }

    @GetMapping("/create")
    public String createClient(Model model) {
        model.addAttribute("client", new ClientInfoDto());
        return "/clients/create";
    }

    @PostMapping("/create")
    public String createClient(@Valid ClientInfoDto clientInfoDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/clients/create";
        }
        clientInfoDto = clientCrudService.saveClient(clientInfoDto);
        return "redirect:/clients/form/details/" + clientInfoDto.getId();
    }

    @GetMapping("/details/{id}")
    public String getClient(Model model, @PathVariable long id) {
        model.addAttribute("client", clientCrudService.findClientById(id));
        model.addAttribute("clientUnits", unitCrudService.getUnitsByClientId(id));
        return "/clients/details";
    }

    @GetMapping("/update/{id}")
    public String updateClient(Model model, @PathVariable long id) {
        model.addAttribute("client", clientCrudService.findClientById(id));
        return "/clients/update";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@Valid ClientInfoDto clientInfoDto, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "/clients/update/" + id;
        }
        clientInfoDto = clientCrudService.saveClient(clientInfoDto);
        return "redirect:/clients/form/details/" + clientInfoDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(Model model, @PathVariable long id) {
        model.addAttribute("clientId", id);
        return "/clients/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable long id) {
        clientCrudService.deleteClient(id);
        return "redirect:/clients";
    }

}
