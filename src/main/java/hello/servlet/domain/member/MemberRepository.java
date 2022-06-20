package hello.servlet.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 현재 동시성 문제가 고려되어 있지 않아, 실무에서는 ConcurrentHashMap, Atomic 사용을 고려
 */
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    // 다음에서 static으로 싱글톤 기법을 유지하였기에 위 멤버에서 static 제외 가능하긴 하나, 그냥 적어주었다.
    public static MemberRepository getInstance() {
        return instance;
    }

    public MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
