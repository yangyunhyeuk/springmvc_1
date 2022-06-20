package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
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
    void save() {
        // given
        Member member = new Member("yang", 28);

        // when
        Member saveMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void finaAll() {
        // given
        Member member1 = new Member("yang", 28);
        Member member2 = new Member("kim", 29);
        Member member3 = new Member("park", 30);

        Member saveMember1 = memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);
        Member saveMember3 = memberRepository.save(member3);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(saveMember1, saveMember2, saveMember3);

    }
}