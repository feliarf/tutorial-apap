package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.TokoModel;
import apap.tutorial.shapee.repository.StoreDb;
import apap.tutorial.shapee.rest.Setting;
import apap.tutorial.shapee.rest.TokoDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ConsumerRestServiceImpl implements ConsumerRestService {

    private final WebClient webClient2;

    @Autowired
    private StoreDb storeDb;

    public ConsumerRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient2 = webClientBuilder.baseUrl(Setting.demoUrl).build();
    }

    @Override
    public TokoModel getStroreByBranch(String branch) {
        return getStroreByBranch(branch);
    }

    @Override
    public Mono<String> getStatus(String  Branch) {
        return this.webClient2.get().uri("/branch")
                .retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<TokoDetail> postStatus() {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("owner","Sasuka");
        data.add("number_of_staf","10");
        data.add("location","di sebelah sana samping sini");
        return this.webClient2.post().uri("1b9f0f25-7f24-4c84-bc83-3ded0830c3f8.mock.pstmn.io/api/v1/store")
                .syncBody(data)
                .retrieve()
                .bodyToMono(TokoDetail.class);
    }

}
