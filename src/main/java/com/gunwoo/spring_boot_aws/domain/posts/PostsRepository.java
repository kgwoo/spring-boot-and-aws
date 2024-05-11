package com.gunwoo.spring_boot_aws.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}

/*
보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자입니다.
JPA에선 Repository라고 부르며 인터페이스로 생성한다.
단순히 인터페이스 생성 후, JpaRepository<Entity 클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.

주의점: Entity클래스와 기본 Repository는 함께 위치해야 한다.
나중에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면 이떄 Entity 클래스와 기본 Repository는 함께 움직여야 하므로 도메인 패키지에서 함께 관리해야한다.
*/