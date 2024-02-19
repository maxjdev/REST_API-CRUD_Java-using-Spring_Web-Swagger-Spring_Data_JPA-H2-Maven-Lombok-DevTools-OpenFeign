package br.com.crudApi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @Author maxjdev
 */

@FeignClient(name = "randomuser", url = "https://randomuser.me/api/")
public interface RandomUserFeign {
    @GetMapping
    Map<String, Object> getRandomUser();
}
