package com.example.repository;

import com.example.entity.domain.Member;
import com.example.entity.domain.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test(){
        Member kim = new Member("kim");
        kim.addPhone(new Phone("010-XXXX-XXXX"));
        kim.addPhone(new Phone("010-YYYY-YYYY"));

        Member dong = new Member("Dong");
        dong.addPhone(new Phone("010-ZZZZ-ZZZZ"));

        Member min = new Member("Min");

        memberRepository.save(kim);
        memberRepository.save(dong);
        memberRepository.save(min);

        List<Member> members = memberRepository.findAll();

        for( Member member : members ){
            System.out.println("***********" + member.toString());
        }
    }
}
