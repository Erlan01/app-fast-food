package ai.ecma.auth.service;

import ai.ecma.auth.common.MessageService;
import ai.ecma.auth.exception.RestException;
import ai.ecma.auth.mapper.UserMapper;
import ai.ecma.auth.payload.AddStaffDto;
import ai.ecma.auth.payload.EditUserDto;
import ai.ecma.auth.payload.UserPrincipal;
import ai.ecma.auth.payload.UserReqDto;
import ai.ecma.lib.entity.*;
import ai.ecma.lib.enums.RoleTypeEnum;
import ai.ecma.lib.payload.ApiResult;
import ai.ecma.lib.payload.UserDto;
import ai.ecma.lib.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 21.01.2022
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AttachmentRepository attachmentRepository;
    private final DistrictRepository districtRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final BranchRepository branchRepository;
    private final PermissionRoleRepository permissionRoleRepository;


    @Override
    public ApiResult<UserDto> me(UserPrincipal userPrincipal) {
        return ApiResult.successResponse(userMapper.toDto(userPrincipal.getUser()));
    }

    @Override
    public ApiResult<UserDto> checkAuth(UserPrincipal userPrincipal) {

        UserDto userDto = userMapper.toDto(userPrincipal.getUser());

        Collection<? extends GrantedAuthority> authorities = userPrincipal.getAuthorities();
        Set<String> collect = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        userDto.setAuthorities(collect);
        return ApiResult.successResponse(userDto);
    }


    @Override
    public ApiResult<?> edit(UUID id, UserReqDto userReqDto) {
        User user = userRepository.findById(id).orElseThrow(() -> RestException.notFound("USER"));
        District district = districtRepository.findById(userReqDto.getDistrictId()).orElseThrow(() -> RestException.notFound("DISTRICT"));
        Attachment attachment = attachmentRepository.findById(userReqDto.getPhotoId()).orElseThrow(() -> RestException.notFound("ATTACHMENT"));
        List<Address> addressList = addressRepository.findAllById(userReqDto.getDefaultAddressIds());
        if (addressList.isEmpty())
            throw RestException.notFound("ADDRESS");
        if (addressList.size() > 3)
            throw RestException.restThrow(MessageService.getMessage("DEFAULT_ADDRESS_MUST_BE_THREE"), HttpStatus.BAD_REQUEST);
        user.setFirstName(userReqDto.getFirstName());
        user.setLastName(userReqDto.getLastName());
        user.setPhoneNumber(userReqDto.getPhoneNumber());
        user.setBirthDate(userReqDto.getBirthDate());
        user.setLanguage(userReqDto.getLanguage());
        user.setPhoto(attachment);
        user.setDistrict(district);
        user.setDefaultAddress(addressList);

        userRepository.save(user);
        return ApiResult.successResponse(MessageService.successEdit("USER"));
    }

    @Override
    public ApiResult<EditUserDto> editUser(User user, EditUserDto dto) {
        User editingUser = userRepository.findById(user.getId()).orElseThrow(() -> RestException.notFound("USER"));
        editingUser.setFirstName(dto.getFirstName());
        editingUser.setLastName(dto.getLastName());
        editingUser.setPhoneNumber(dto.getPhoneNumber());
        editingUser.setBirthDate(dto.getBirthDate());
        Attachment photo = attachmentRepository.findById(dto.getPhotoId()).orElseThrow(() -> RestException.notFound("PHOTO"));
        editingUser.setPhoto(photo);
        userRepository.save(editingUser);

        return ApiResult.successResponse("Edited!");
    }

    @Override
    public ApiResult<?> addStaff(AddStaffDto staffDto) {
        Role role = roleRepository.findById(staffDto.getRoleId()).orElseThrow(() -> RestException.notFound("ROLE"));
        if (role.getRoleType().equals(RoleTypeEnum.OPERATOR)) {
            if (staffDto.getBranchIdList().size() != 1)
                throw RestException.restThrow(MessageService.getMessage("STAFF_LIST_MUST_BE_ONE"), HttpStatus.BAD_REQUEST);

        }
        List<PermissionRole> permissionRoleList = permissionRoleRepository.findAllByRoleId(role.getId());
        if (permissionRoleList.isEmpty())
            throw RestException.notFound("PERMISSION");
        List<Permission> permissions = permissionRoleList.stream().map(PermissionRole::getPermission).collect(Collectors.toList());

        List<Branch> branchList = branchRepository.findAllById(staffDto.getBranchIdList());

        User user = User.builder()
                .setFirstName(staffDto.getFirstName())
                .setLastName(staffDto.getLastName())
                .setPhoneNumber(staffDto.getPhoneNumber())
                .setRole(role)
                .setPermissions(new HashSet<>(permissions))
                .setBranches(new HashSet<>(branchList))
                .build();
        userRepository.save(user);
        return ApiResult.successResponse(MessageService.successSave("STAFF"));
    }
}
