package com.gunwoo.spring_boot_aws.domain.posts;
import com.gunwoo.spring_boot_aws.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}


/*
어노테이션 순서를 주요 어노테이션을 클래스에 가깝게 둔다.
@Entity 는 JPA의 어노테이션이며, @Getter 와 @NoArgsConstructor는 롬복의 어노테이션

롬복은 코드를 단순화시켜 주지만 필수 어노테이션을 아니다. 그러나 보니 주요 어노테이션인 @Entity를 클래스에 가깝게 두고, 롬복 어노테이션을 그 위로 두었다.
코틀린 등의 새 언어 전환으로 롬복이 더이상 필요 없을 경우 쉽게 삭제할 수 있기 때문이다

@Entity
테이블과 링크될 클래스임을 나타낸다.
기본값으로 클래스의 카멜케이스 이름은 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
ex) SalesManager.java -> sales_manager table


어노테이션 설명
@NoArgsConstructor
기본 생성자 자동 추가
public Posts(){} 와 같은 효과

@Getter
클래스 내 모든 필드의 Getter 메소드를 자동생성

@Builder
해당 클래스의 빌더 패턴 클래스를 생성
생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함

서비스 초기 구축 단계에선 테이블 설계(여기선 Entity 설계)가 빈번하게 변경되는데, 이때 롬복의 어노테이션들은 코드 변경량을 최소화 시켜주기 떄문에 적극적으로 사용한다.


매우중요!
Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
*/