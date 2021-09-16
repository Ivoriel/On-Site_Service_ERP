package pl.kosinski.request;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosinski.client.ClientCrudService;
import pl.kosinski.client.ClientInfoDto;
import pl.kosinski.common.RequestStatus;
import pl.kosinski.common.RequestType;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/requests")
@AllArgsConstructor
public class RequestCrudController {

    RequestCrudService requestCrudService;
    ClientCrudService clientCrudService;

    @GetMapping("")
    public String requestsHome(Model model) {
        model.addAttribute("requests", requestCrudService.findAllRequests());
        return "/requests/requestsHome";
    }

    @GetMapping("/create")
    public String createRequest(Model model) {
        model.addAttribute("request", new RequestInfoDto());
        return "/requests/create";
    }

    @PostMapping("/create")
    public String createRequest(@Valid RequestInfoDto requestInfoDto, BindingResult result) {
        if(result.hasErrors()) {
            return "/requests/create";
        }
        requestInfoDto = requestCrudService.saveRequest(requestInfoDto);
        return "redirect:/requests/details/" + requestInfoDto.getId();
    }

    @GetMapping("/details/{id}")
    public String getRequest(Model model, @PathVariable long id) {
        model.addAttribute("request", requestCrudService.findRequestbyId(id));
        return "/requests/details";
    }

    @GetMapping("/update/{id}")
    public String updateRequest(Model model, @PathVariable long id) {
        model.addAttribute("request", requestCrudService.findRequestbyId(id));
        return "/requests/update";
    }

    @PostMapping("/update/{id}")
    public String updateRequest(@Valid RequestInfoDto requestInfoDto, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "/requests/update/" + id;
        }
        requestInfoDto = requestCrudService.saveRequest(requestInfoDto);
        return "redirect:/requests/details/" + requestInfoDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteRequest(Model model, @PathVariable long id) {
        model.addAttribute("requestId", id);
        return "/requests/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteRequest(@PathVariable long id) {
        requestCrudService.deleteRequest(id);
        return "redirect:/requests";
    }

    @ModelAttribute("clients")
    public List<ClientInfoDto> clients() {
        return clientCrudService.findAllClients();
    }

    @ModelAttribute("types")
    public RequestType[] requestTypes() {
        return RequestType.values();
    }

    @ModelAttribute("statuses")
    public RequestStatus[] requestStatuses() {
        return RequestStatus.values();
    }

}
