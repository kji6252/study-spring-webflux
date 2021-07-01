# 202107001 webflux workshop
https://reactor.github.io/head-first-reactive-with-spring-and-reactor/
를 참조 하고 프로젝트를 구성 하였습니다.

* stock-quotes
  * Function Handler, Router 방식에서 RestController로 변경 했습니다.
  * Flux 의 Content-Type을 deprecated 된 application/stream-json 에서 application/x-ndjson 형식으로 변경 했습니다.
* stock-details
* trading-service

의 spring-boot App 을 instance 로 만든 뒤 서로 reactive 하게 연동 하는 예제 입니다.

https://docs.gradle.org/current/userguide/multi_project_builds.html
gradle의 멀티 프로젝트는 위 링크를 참조 하였습니다.
```shell
./gradlew -q projects
```

```shell
./gradlew -q run
```