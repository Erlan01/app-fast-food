package ai.ecma.order.aop;

import ai.ecma.lib.entity.User;
import ai.ecma.lib.enums.PermissionEnum;
import ai.ecma.lib.enums.RoleTypeEnum;
import ai.ecma.lib.payload.UserDto;
import ai.ecma.lib.repository.UserRepository;
import ai.ecma.order.exception.RestException;
import ai.ecma.order.mapper.UserMapper;
import ai.ecma.order.service.CacheService;
import ai.ecma.order.utils.AES;
import ai.ecma.order.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 21.01.2022
 */
@Aspect
@Order(1)
@Component
@RequiredArgsConstructor
public class CheckAuthAspect {
    private final CacheService cacheService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Before(value = "@annotation(checkAuth)")
    public void checkAuthExecutor(CheckAuth checkAuth) {
        check(checkAuth);
    }

    public void check(CheckAuth checkAuth) {
        PermissionEnum[] permissions = checkAuth.permissions();
        RoleTypeEnum[] roleTypeEnums = checkAuth.roles();
        Set<String> authoritiesForCheck = Arrays.stream(permissions).map(PermissionEnum::name).collect(Collectors.toSet());
        authoritiesForCheck.addAll(Arrays.stream(roleTypeEnums).map(RoleTypeEnum::name).collect(Collectors.toSet()));

        HttpServletRequest httpServletRequest = CommonUtils.getCurrentRequest();

        UserDto userDto = null;
        String requestFromBot = httpServletRequest.getHeader("RequestFromBot");
        if (Objects.nonNull(requestFromBot) && Boolean.parseBoolean(requestFromBot)) {
            String encryptedTelegramId = httpServletRequest.getHeader("telegramId");
            String telegramId = AES.decode(encryptedTelegramId);
            User user = userRepository.findByTelegramId(Long.valueOf(telegramId)).orElseThrow(() -> RestException.notFound("USER"));
            userDto = userMapper.toDto(user);

            userDto.setAuthorities(new HashSet<>(List.of(user.getRole().getName())));
            userDto.getAuthorities().addAll(user.getPermissions().stream().map(p -> p.getName().name()).collect(Collectors.toSet()));
        } else {
            String token = httpServletRequest.getHeader("Authorization");
            if (token == null) throw RestException.forbidden();
            userDto = cacheService.getUserByToken(token);
        }


        if (!authoritiesForCheck.isEmpty()) {
            Set<String> userAuthorities = userDto.getAuthorities();

            boolean exists = false;
            for (String authority : authoritiesForCheck) {
                exists = userAuthorities.contains(authority);
            }

            if (!exists) throw RestException.forbidden();
        }

        httpServletRequest.setAttribute("user", userDto);
    }
}
