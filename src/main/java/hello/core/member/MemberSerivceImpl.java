package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberSerivceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberSerivceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return  memberRepository.findById(memberId);
    }



    //테스트용도
    public MemberRepository getMemberRepository(){
        return this.memberRepository;
    }
}
