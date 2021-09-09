package pl.kosinski.unit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientCrudController {

    private ClientCrudService clientCrudService;

    @GetMapping("")
    public String clientHome(Model model) {
        model.addAttribute("clients", clientCrudService.findAllClients());
        return "/clients/home";
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
        clientCrudService.saveClient(clientInfoDto);
        return "redirect:/clients";
    }

    @GetMapping("/update/{id}")
    public String updateClient(Model model, @PathVariable long id) {
        model.addAttribute("client", clientCrudService.findClientById(id));
        return "/clients/update";
    }

    @PutMapping("/update/{id}")
    public String updateClient(@Valid ClientInfoDto clientInfoDto, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "/clients/update/" + id;
        }
        clientCrudService.saveClient(clientInfoDto);
        return "redirect:/clients";
    }

    @DeleteMapping("")
    public String deleteClient(Model model) {
        clientCrudService.deleteClient(Long.parseLong((String)model.getAttribute("client")));
        return "redirect:/clients";
    }

}
