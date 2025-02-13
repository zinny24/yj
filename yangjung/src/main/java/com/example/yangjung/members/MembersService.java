package com.example.yangjung.members;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembersService {

    @Autowired
    private MembersRepository membersRepository;

    public boolean isLogin(String userid, String passwd, HttpSession session) {
        Optional<Member> mem = membersRepository.findByUseridAndPasswd(userid, passwd);

        if( mem.isPresent() ) {
            Member info = mem.get();

            session.setAttribute("myMember", info);
            return true;

        }
        return false;
    }

}
