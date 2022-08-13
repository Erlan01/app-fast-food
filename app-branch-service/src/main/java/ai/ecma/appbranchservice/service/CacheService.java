package ai.ecma.appbranchservice.service;

import ai.ecma.appbranchservice.exception.RestException;
import ai.ecma.appbranchservice.feign.AuthFeign;
import ai.ecma.lib.payload.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 17.02.2022
 */
@Service
@RequiredArgsConstructor
public class CacheService {
    private final AuthFeign authFeign;

    @Cacheable(value = "users", key = "#token")
    public UserDto getUserByToken(String token) {
        return authFeign.checkAuth(token).orElseThrow(RestException::forbidden);
    }

}
