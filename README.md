# JUnit5 Practices

#### @DisplayNameGeneration
class에 붙여 사용할 수 있고, 각 테스트의 메소드명을 기반으로 DisplayName을 생성한다. 
DisplayNameGenerator 인터페이스를 구현해서 사용하도록 하자. 
구현된 클래스로는 밑줄만 공백으로 제거해주는 클래스(DisplayNameGenerator.ReplaceUnderscores)가 제공된다.
@ParameterizedTest의 name 속성으로도 DisplayName을 설정할 수 있다.  
  
application.properties에 기본 Generator를 설정할 수도 있다.  
```junit.jupiter.displayname.generator.default = org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores```

DisplayName이 결정되는 과정은 아래 순서에 따른다.
1. @DisplayName이 선언되어 있으면 그 값값  
2. @DisplayNameGeneration이 선언되어 있으면 DisplayNameGenerator에 의해 변환된 값  
3. 디폴트 DisplayNameGenerator가 설정되어 있으면 해당 Generator에 의해 변환된 값  
4. DisplayNameGenerator.Standard에 의해 변환된 값   

### reference
https://junit.org/junit5/docs/current/user-guide/