package com.bottomUp.security;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.BottomUpUserDetail;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.domain.common.user.UserProfilePermissionData;
import com.bottomUp.service.common.CompanyService;
import com.bottomUp.service.common.user.UserPermissionService;
import com.bottomUp.service.common.user.UserService;
import com.bottomUp.service.docFeed.crud.DoctorService;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.Timestamp;
import java.util.*;


public class BottomUpUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Value("${login.fail.count}")
    private Integer failAttemptMaxCount;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private DoctorService doctorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData userData = null;
        BottomUpUserDetail echoUserDetail = null;

        List<GroupPermissionData> rolesPermissions = new ArrayList<GroupPermissionData>();
        try {
            userData = userService.getUserByUserName(username);

            if (userData == null || userData.getUserID() == null || userData.getUserID().equals(0)) {
                throw new BadCredentialsException("Invalid username entered");
            }

            if (userData.getStatus() == null || userData.getStatus().equals(0)) {
                throw new BadCredentialsException("Your account is deactivated. Please contact with administrator");
            }

            if (BooleanUtils.toBoolean(userData.getIsBlocked())) {
                throw new BadCredentialsException("Your account has been blocked. Please contact with administrator");
            }

            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

            if (userData.getCompanyID() == null && userData.getUserID() == 1) {
                grantedAuths.add(new SimpleGrantedAuthority("SUPER_ADMIN"));
            } else {

                rolesPermissions = userPermissionService.getUserPermissionByUserID(userData.getUserID());

                if (rolesPermissions != null && rolesPermissions.size() > 0) {
                    for (GroupPermissionData role : rolesPermissions) {
                        grantedAuths.add(new SimpleGrantedAuthority(role.getFunctionCode()));
                    }
                } else {
                    throw new BadCredentialsException("No Permission is assigned to this user");
                }


            }


            UserProfilePermissionData userProfilePermissionData = new UserProfilePermissionData();
            echoUserDetail  = new BottomUpUserDetail(userData.getUserName(), userData.getPassword(), grantedAuths);
            userProfilePermissionData.setUserID(userData.getUserID());
            userProfilePermissionData.setUserName(userData.getUserName());
            userProfilePermissionData.setCompanyID(userData.getCompanyID());
            userProfilePermissionData.setStatus(userData.getStatus());
            userProfilePermissionData.setGroupPermissionDataList(rolesPermissions);
            echoUserDetail.setUserProfilePermissionData(userProfilePermissionData);
            UserProfileData data = this.userService.getUserProfileByID(userData.getUserID());
            userProfilePermissionData.setProfileData(data);

            if (userData.getCompanyID() != null && userData.getUserID() != 1) {
                Map<String, Object> param = new HashMap<>();
                param.put("companyID", userData.getCompanyID());
                CompanyData companyData = companyService.getByID(userData.getCompanyID());

                DoctorData doctorData = doctorService.getByUser(userData.getUserID());
                if(doctorData != null){
                    echoUserDetail.setDoctorData(doctorData);
                }
                echoUserDetail.setCompanyData(companyData);
            }



        }catch (BottomUpException e){
            System.out.println(e);
        }


        return echoUserDetail;
    }

}
