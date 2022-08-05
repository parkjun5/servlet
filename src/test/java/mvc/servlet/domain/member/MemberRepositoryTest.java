package mvc.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void saveTest() throws Exception {
        //given
        Member member = new Member();
        member.setAge(222);
        member.setUsername("유저");

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertThat(savedMember.getAge()).isEqualTo(222);
        assertThat(savedMember)
                .extracting("username")
                .isEqualTo("유저");
    }

    @Test
    void findTest() throws Exception {
        //given
        Member member = new Member();
        member.setAge(222);
        member.setUsername("유저");
        Member savedMember = memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(member.getId());
        //then
        assertThat(savedMember).isEqualTo(findMember);
    }

    @Test
    void findAllTest() throws Exception {
        //given
        Member member1 = memberRepository.save(new Member("member1", 1));
        Member member2 = memberRepository.save(new Member("member2", 12));
        Member member3 = memberRepository.save(new Member("member3", 133));


        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members).hasSize(3);
        assertThat(members).contains(member1, member2, member3);
    }

}