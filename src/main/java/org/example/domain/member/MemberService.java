package org.example.domain.member;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long signup(MemberDto memberDto) {
        //중복 회원 검증 필요.


        //암호화후 DB저장.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        if(memberDto.getRole().equals("ROLE_COMPANY")){
            memberDto.setRole("ROLE_COMPANY");
        }
        else if(memberDto.getRole().equals("ROLE_MEMBER")){
            memberDto.setRole("ROLE_MEMBER");
        }

        return   memberRepository.save(memberDto.toEntity()).getId();
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //로그인을 하기 위해 가입된 user정보를 조회하는 메서드.
        Optional<Member> memberWrapper = memberRepository.findByUsername(username);
        Member member = memberWrapper.get();


        List<GrantedAuthority> authorities = new ArrayList<>();

        // username이 'admin'이면 admin 권한 부여.
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));

        } else{
            if(member.getRole().equals("ROLE_COMPANY")) {
                authorities.add(new SimpleGrantedAuthority(Role.COMPANY.getValue()));

            }else if(member.getRole().equals("ROLE_MEMBER")) {
                authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));

            }

        }

        return new User(member.getUsername(), member.getPassword(), authorities);
    }
}
