package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.RoleModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<RoleModel> findAll();
}
