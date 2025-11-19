Scheduler Server
================
> ## \< Project OverView >
> ### Reference to this project : https://teamsparta.notion.site/Kotlin-9-CH-3-Develop-2a42dc3ef514809c84b6f5306b699756
> ### RESTful API server that manages **Users & Schedules**
> ### Designed based on **3-layer architecture** (Controller / Service / Repository)
> ### Process & respond to requests in **JSON** format
> ### Uses **JPA + MySQL** with **JPA Auditing** for createdAt / modifiedAt
> ### **Cookie / Session 기반 인증 + Spring Filter(OncePerRequestFilter) 적용**
> ### \* This Project was implemented only up to **Lv4** (User & Schedule CRUD + Login)

---

> ## API Statement
> > - ### Schedule CRUD
> > - ### User CRUD (Sign Up / Read / Update / Delete)
> > - ### Login / Logout with HttpSession
> > - ### JPA Auditing (Auto `createdAt`, `modifiedAt`)
> > - ### Simple manual validation in Service layer (null / length check)
> > - ### Request / Response are wrapped by DTO (No Entity exposure)

---

> ## 1. Schedule API
> | Method | HTTP Type | URL                       | Description                                         | Auth Required |
> |--------|-----------|---------------------------|-----------------------------------------------------|--------------|
> | save   | POST      | `/schedules`              | Create schedule (logged-in user as author)          | ✅           |
> | getAll | GET       | `/schedules`              | Get all schedules (optionally filtered, if 적용시) | ✅           |
> | getOne | GET       | `/schedules/{scheduleId}` | Get one schedule                                   | ✅           |
> | update | PUT       | `/schedules/{scheduleId}` | Update schedule (owner only)                        | ✅           |
> | delete | DELETE    | `/schedules/{scheduleId}` | Delete schedule (owner only)                        | ✅           |

> ### 1-1. save (POST `/schedules`)
> - Description
    >   - 로그인된 유저의 `userId`(Session)를 기준으로 일정을 생성합니다.
>   - Request Body에는 **제목 / 내용만** 전달합니다.
>
> **\< Request Body >**
> ```json
> {
>   "title": "병원 일정",
>   "description": "251108_고대병원 스케줄"
> }
> ```
> **\< Response (201 Created) >**
> ```json
> {
>   "id": 1,
>   "title": "병원 일정",
>   "description": "251108_고대병원 스케줄",
>   "userId": 3,
>   "userName": "홍길동",
>   "createdAt": "2025-11-04T14:00:00",
>   "modifiedAt": "2025-11-04T14:00:00"
> }
> ```

> ### 1-2. getAll (GET `/schedules`)
> - Description
    >   - 전체 일정 목록을 조회합니다.
>   - 구현에 따라 **로그인한 유저의 일정만** 혹은 **전체 일정**을 반환하도록 변경 가능.
>   - `modifiedAt` 기준 내림차순 정렬 (최신 수정 일정이 먼저 노출).
>
> **\< Response (200 OK) >**
> ```json
> [
>   {
>     "id": 1,
>     "title": "병원 일정",
>     "description": "251108_고대병원 스케줄",
>     "userId": 3,
>     "userName": "홍길동",
>     "createdAt": "2025-11-04T14:00:00",
>     "modifiedAt": "2025-11-04T14:10:00"
>   },
>   {
>     "id": 2,
>     "title": "주간 회의",
>     "description": "기획안 검토",
>     "userId": 4,
>     "userName": "김개발",
>     "createdAt": "2025-11-05T09:00:00",
>     "modifiedAt": "2025-11-05T09:30:00"
>   }
> ]
> ```

> ### 1-3. getOne (GET `/schedules/{scheduleId}`)
> - Description
    >   - 특정 일정 1건을 조회합니다.
>   - 연관된 **작성 유저 정보(userId, userName)** 를 함께 반환합니다.
>
> **\< Response (200 OK) >**
> ```json
> {
>   "id": 1,
>   "title": "병원 일정",
>   "description": "251108_고대병원 스케줄",
>   "userId": 3,
>   "userName": "홍길동",
>   "createdAt": "2025-11-04T14:00:00",
>   "modifiedAt": "2025-11-04T14:10:00"
> }
> ```

> ### 1-4. update (PUT `/schedules/{scheduleId}`)
> - Description
    >   - 일정 내용을 수정합니다.
>   - 로그인한 유저(Session의 `userId`)가 해당 일정의 작성자일 때만 수정 가능합니다.
>
> **\< Request Body >**
> ```json
> {
>   "title": "병원 일정 - 변경",
>   "description": "251108_고대병원 스케줄 (수정)"
> }
> ```
> **\< Response (200 OK) >**
> ```json
> {
>   "id": 1,
>   "title": "병원 일정 - 변경",
>   "description": "251108_고대병원 스케줄 (수정)",
>   "userId": 3,
>   "userName": "홍길동",
>   "createdAt": "2025-11-04T14:00:00",
>   "modifiedAt": "2025-11-04T14:20:00"
> }
> ```

> ### 1-5. delete (DELETE `/schedules/{scheduleId}`)
> - Description
    >   - 일정을 삭제합니다.
>   - 로그인한 유저(Session의 `userId`)가 해당 일정의 작성자일 때만 삭제 가능합니다.
>   - 구현에 따라 문자열 메시지 또는 빈 Body를 반환할 수 있습니다.
>
> **\< Response (200 OK) – String 메시지 예시 >**
> ```json
> "일정이 성공적으로 삭제되었습니다."
> ```

---

> ## 2. User & Auth API
> | Method | HTTP Type | URL               | Description                          | Auth Required |
> |--------|-----------|-------------------|--------------------------------------|--------------|
> | signUp | POST      | `/users`          | 회원가입(Create User)                | ⛔           |
> | getAll | GET       | `/users`          | Get all users (optional name filter) | ✅ (필터에 따라) |
> | getOne | GET       | `/users/{userId}` | Get one user                         | ✅           |
> | update | PUT       | `/users/{userId}` | Update user info                     | ✅           |
> | delete | DELETE    | `/users/{userId}` | Delete user                          | ✅           |
> | login  | POST      | `/users/login`    | 로그인(세션 생성)                    | ⛔           |
> | logout | POST      | `/users/logout`   | 로그아웃(세션 종료)                  | ✅           |

> ### 2-1. signUp (POST `/users`)
> - Description
    >   - 새로운 유저를 생성(회원가입)합니다.
>   - `email` 은 중복 불가.
>   - `password` 는 추후 Lv6에서 암호화 예정 (현재는 평문 저장 기준).
>
> **\< Request Body >**
> ```json
> {
>   "name": "홍길동",
>   "email": "test@example.com",
>   "password": "1234"
> }
> ```
> **\< Response (201 Created) >**
> ```json
> {
>   "id": 3,
>   "name": "홍길동",
>   "email": "test@example.com",
>   "createdAt": "2025-11-04T13:50:00",
>   "modifiedAt": "2025-11-04T13:50:00"
> }
> ```
> \* 보안을 위해 **`password`는 응답에 포함되지 않습니다.**

> ### 2-2. getAll (GET `/users`)
> - Description
    >   - 전체 유저 목록을 조회합니다.
>   - `name` 을 Query Parameter로 전달하면 해당 이름(또는 일부 이름)에 해당하는 유저만 필터링할 수 있도록 확장 가능합니다.
>
> **\< Request Example >**
> - 전체 조회
    >   - `GET /users`
> - 이름 기준 조회 (예: name = "홍")
    >   - `GET /users?name=홍`
>
> **\< Response (200 OK) >**
> ```json
> [
>   {
>     "id": 3,
>     "name": "홍길동",
>     "email": "test@example.com",
>     "createdAt": "2025-11-04T13:50:00",
>     "modifiedAt": "2025-11-04T13:50:00"
>   },
>   {
>     "id": 4,
>     "name": "김개발",
>     "email": "dev@example.com",
>     "createdAt": "2025-11-05T09:10:00",
>     "modifiedAt": "2025-11-05T09:10:00"
>   }
> ]
> ```

> ### 2-3. getOne (GET `/users/{userId}`)
> **\< Response (200 OK) >**
> ```json
> {
>   "id": 3,
>   "name": "홍길동",
>   "email": "test@example.com",
>   "createdAt": "2025-11-04T13:50:00",
>   "modifiedAt": "2025-11-04T13:50:00"
> }
> ```

> ### 2-4. update (PUT `/users/{userId}`)
> - Description
    >   - 유저 정보를 수정합니다.
>   - 구현에 따라 **비밀번호 확인** 후 수정 가능하도록 처리할 수 있습니다.
>
> **\< Request Body >**
> ```json
> {
>   "name": "홍길동(수정)",
>   "email": "test2@example.com",
>   "password": "1234"  // 본인 확인용 현재 비밀번호
> }
> ```
> **\< Response (200 OK) >**
> ```json
> {
>   "id": 3,
>   "name": "홍길동(수정)",
>   "email": "test2@example.com",
>   "createdAt": "2025-11-04T13:50:00",
>   "modifiedAt": "2025-11-05T10:00:00"
> }
> ```

> ### 2-5. delete (DELETE `/users/{userId}`)
> - Description
    >   - 유저 정보를 삭제합니다.
>   - 구현에 따라 Request Body에 비밀번호를 함께 전달하여 검증 후 삭제할 수 있습니다.
>
> **\< Request Body (선택 예시) >**
> ```json
> {
>   "password": "1234"
> }
> ```
> **\< Response (200 OK) – String 메시지 예시 >**
> ```json
> "유저가 성공적으로 삭제되었습니다."
> ```

> ### 2-6. login (POST `/users/login`)
> - Description
    >   - 이메일 / 비밀번호를 기반으로 로그인합니다.
>   - 로그인 성공 시 **HttpSession** 을 생성하고, 세션에 `userId` 를 저장합니다.
>   - 실패 시 `401 Unauthorized` 또는 `400 Bad Request` 로 응답하도록 확장 가능합니다.
>
> **\< Request Body >**
> ```json
> {
>   "email": "test@example.com",
>   "password": "1234"
> }
> ```
> **\< Response (200 OK) >**
> ```json
> {
>   "id": 3,
>   "name": "홍길동",
>   "email": "test@example.com"
> }
> ```
> \* 세션에는 내부적으로 `userId = 3` 이 저장됩니다. (Cookie 기반 Session ID)

> ### 2-7. logout (POST `/users/logout`)
> - Description
    >   - 현재 요청의 세션을 무효화하여 로그아웃 처리합니다.
>
> **\< Response (200 OK) – 예시 1: 빈 Body >**
> ```json
> null
> ```
> 또는
>
> **\< Response (200 OK) – 예시 2: 메시지 Body >**
> ```json
> "로그아웃 되었습니다."
> ```

---

> ## 3. Auth & Filter (LoginCheckFilter)
> - **기술 스택**
    >   - `jakarta.servlet` 기반의 서블릿 필터
>   - `org.springframework.web.filter.OncePerRequestFilter` 상속
> - **동작 방식**
    >   1. 모든 요청에 대해 Filter가 선 실행됩니다.
>   2. 화이트리스트 URL은 세션 검사 없이 통과합니다.
       >      - 예) `/users` (POST - 회원가입), `/users/login`, `/`, `/error`
>   3. 그 외 URL은 HttpSession에서 `userId` 를 조회합니다.
       >      - 세션이 없거나, `userId` 가 없으면 → `401 Unauthorized` + JSON 메세지 반환
>      - 세션에 `userId` 가 존재하면 → 다음 필터 / 컨트롤러로 요청을 전달
> - **세션 키**
    >   - 로그인 성공 시: `session.setAttribute("userId", user.getId());`
>   - 로그아웃 시: `session.invalidate();`

---

> ## \< ERD >
> ```mermaid
> erDiagram
>     User {
>         BIGINT id PK
>         VARCHAR(30) name
>         VARCHAR(50) email
>         VARCHAR password
>         DATETIME created_at
>         DATETIME modified_at
>     }
>
>     Schedule {
>         BIGINT id PK
>         VARCHAR(30) title
>         VARCHAR(200) description
>         BIGINT user_id FK
>         DATETIME created_at
>         DATETIME modified_at
>     }
>
>     User ||--o{ Schedule : "writes"
> ```
> \* Comment Entity & Comment CRUD는 차후 **도전 과제(Lv7)** 에서 추가 예정입니다.
