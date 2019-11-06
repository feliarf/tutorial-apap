package apap.tutorial.shapee.restcontroller;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.model.TokoModel;
import apap.tutorial.shapee.service.ConsumerRestService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
@JsonIgnoreProperties(value = "store", allowSetters = true)
public class ConsumerRestController {
    ConsumerRestService consumerRestService;

    @GetMapping(value="/store/{branch}")
    private TokoModel retrieveStore(@PathVariable("branch")String branch){
        try{
            branch = "Sudirman";
            return consumerRestService.getStroreByBranch("Sudirman");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Brach" + branch + "NotFound"
            );
        }
    }
}
