# Bedrock Chat Application

Spring Boot와 Spring AI, 그리고 AWS Bedrock을 활용한 간단한 동기식 채팅 애플리케이션입니다. Thymeleaf와 Bootstrap을 사용하여 직관적인 웹 인터페이스를 제공하며, 대화 내역은 사용자 세션(Session)에 저장되어 유지됩니다.

## 주요 기능

*   **AI 채팅**: AWS Bedrock 기반의 AI 모델과 대화할 수 있습니다.
*   **대화 내역 유지**: `HttpSession`을 활용하여 사용자의 대화 내역을 세션 동안 유지합니다.
*   **반응형 UI**: Bootstrap 5를 적용하여 깔끔하고 반응형인 채팅 인터페이스를 제공합니다.
*   **동기식 처리**: 전통적인 Form 전송 방식을 사용하여 구현되었습니다.

## 기술 스택

*   **Java**: 17
*   **Framework**: Spring Boot 3.5.10
*   **AI Integration**: Spring AI (AWS Bedrock Converse)
*   **Template Engine**: Thymeleaf
*   **Frontend**: Bootstrap 5.3
*   **Build Tool**: Gradle

## 프로젝트 구조

```
src/main/java/kr/java/bedrock
├── controller
│   └── AIController.java    # 채팅 요청 처리 및 뷰 반환
├── util
│   └── SessionUtil.java     # 세션 데이터 처리 및 형 변환 유틸리티
└── BedrockApplication.java  # 애플리케이션 진입점

src/main/resources
└── templates
    └── chat.html            # 채팅 UI (Thymeleaf + Bootstrap)
```

## 실행 방법

1.  **AWS 자격 증명 설정**:
    AWS Bedrock을 사용하기 위해 로컬 환경에 AWS 자격 증명(`~/.aws/credentials` 또는 환경 변수)이 설정되어 있어야 합니다.

2.  **애플리케이션 실행**:
    ```bash
    ./gradlew bootRun
    ```

3.  **접속**:
    웹 브라우저에서 `http://localhost:8080`으로 접속하여 채팅을 시작합니다.

## 개발 노트

*   **세션 관리**: `SessionUtil` 클래스를 통해 세션 데이터의 형 변환을 안전하게 처리하고, 초기화 로직을 캡슐화했습니다.
*   **UI**: `chat.html`에서 Thymeleaf 반복문을 사용하여 대화 내역을 렌더링하며, JavaScript를 통해 새 메시지 수신 시 스크롤을 자동으로 최하단으로 이동시킵니다.
