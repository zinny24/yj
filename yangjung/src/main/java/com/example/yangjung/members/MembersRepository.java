package com.example.yangjung.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembersRepository extends JpaRepository<Member, Long> {
    //아이디 + 비밀번호
    Optional<Member> findByUseridAndPasswd(String userid, String passwd);
}
