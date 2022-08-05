package mvc.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private  int age;

    protected Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return age == member.age && Objects.equals(id, member.id) && Objects.equals(username, member.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, age);
    }
}
