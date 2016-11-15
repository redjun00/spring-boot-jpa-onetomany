package com.example;

import com.example.entity.domain.Member;
import com.example.entity.domain.Phone;
import com.example.repository.MemberRepository;
import com.example.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class SpringBootJpaOnetomayApplication implements CommandLineRunner {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaOnetomayApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

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
			System.out.println(member.toString());
		}

		memberRepository.deleteAll();
	}
}
