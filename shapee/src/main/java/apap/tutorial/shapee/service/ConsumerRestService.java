package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.TokoModel;
import apap.tutorial.shapee.rest.TokoDetail;
import reactor.core.publisher.Mono;

public interface ConsumerRestService {

    TokoModel getStroreByBranch(String branch);
    Mono<String> getStatus(String Owner);
    Mono<TokoDetail> postStatus();
}
