Scheduler Server
================
> ## < Project OverView >
> ### Reference to this project : https://teamsparta.notion.site/Kotlin-9-CH-3-2a02dc3ef51481499784ded07a2138be
> ### RESTful API server that manages schedules & comments
> ### Designed based on 3-layer architecture
> ### Process respond to requests received in json format
> ### There may be some deficiencies because it was written based on the guide

> ## API Statement
> > - ### Schedule CRUD
> > - ### Schedule Comment CRUD
> > - ### JPA Auditing (Auto CreatedAt, ModifiedAt)
> > - ### Verification request data (@Valid)
>
> | TYPE   | Method | URL                      | Description                                                |
> |--------| --- |--------------------------|------------------------------------------------------------|
> | save   | POST | /schedules               | Create schedule                                            |
> | getAll | GET | /schedules               | Get All schedule(Optional author filter, Include Comments) |
> | getOne | GET |  /schedules/{scheduleId} | Get One schedule(Include Comments)                         |
> | update | PUT |  /schedules/{scheduleId} | Modified schedule(Verification password                    |
> | delete | DELETE | /schedules/{scheduleId} | Delete schedule(Verification password                      |
> 
> ## 1. save (POST "/schedules")
>   **< Request Body >**
>   ```json
>   {
>       "title" : "병원 일정",
>       "description" : "251108_고대병원 스케쥴",
>       "author" : "홍길동",
>       "password" : "23223"
>   }
>   ```
>   **< Response (201 Created) >**
 >   ```json
>   {
>       "title" : "병원 일정",
>       "description" : "251108_고대병원 스케쥴",
>       "author" : "홍길동",
>       "password" : "23223",
>       "createdAt" :"2025-11-04T14:00:00",
>       "modifiedAt": "2025-11-04T14:10:00" 
>   }
>   ```
> 
> ## 2. getAll (GET "/schedules")
>   **< Response (200 OK) >**
>   ```json
> [
>     {
>       "id" : 1,
>       "title" : "병원 일정",
>       "description" : "251108_고대병원 스케쥴",
>       "author" : "홍길동",
>       "password" : "abc123",
>       "createdAt" :"2025-11-04T14:00:00",
>       "modifiedAt": "2025-11-04T14:10:00" 
>     },
>     {
>       "id" : 2,
>       "title" : "주간 회의",
>       "description" : "기획안 검토",
>       "author" : "홍명자",
>       "password" : "abcd1234",
>       "createdAt" :"2025-11-05T14:00:00",
>       "modifiedAt": "2025-11-05T14:10:00" 
>     }
> ]
>   ```
> 
> ## 3. getOne (GET "/schedules/{scheduleId}")
>   **< Response (200 OK) >**
>   ```json
> {
>       "id" : 1,
>       "title" : "병원 일정",
>       "description" : "251108_고대병원 스케쥴",
>       "author" : "홍길동",
>       "password" : "abc123",
>       "createdAt" :"2025-11-04T14:00:00",
>       "modifiedAt": "2025-11-04T14:10:00",
>       "comments" : [
>         {
>             "id" : 1,
>             "commnet" : "병원 이때가는 것 맞아?",
>             "author" : "홍길순",
>             "createdAt" : "2025-11-04T14:32:00",
>             "modifiedAt": "2025-11-04T14:32:00"
>         },
>         {
>             "id" : 2,
>             "commnet" : "ㅇㅇ 맞아",
>             "author" : "홍길동",
>             "createdAt" : "2025-11-04T16:12:00",
>             "modifiedAt": "2025-11-04T16:12:00"
>         }
>     ]  
> }
>   ```
>
> ## 4. update (PUT "/schedules/{scheduleId}")
>   **< Request Body >**
>   ```json
>   {
>       "title" : "병원 일정",
>       "author" : "홍길동",
>       "password" : "23223"
>   }
>   ```
>   **< Response (200 OK) >**
>   ```json
>   {
>       "title" : "병원 일정",
>       "author" : "홍길동",
>       "createdAt" :"2025-11-04T14:00:00",
>       "modifiedAt": "2025-11-04T14:10:00" 
>   }
>   ```
> ## 5. delete (DELETE "/schedules/{scheduleId}")
>   **< Request Body>**
>   ```json
>   {
>       "password" : "1234"
>   }
>   ```
> 
> ## < ERD >
> ```mermaid
> erDiagram
>     Schedule {
>         BIGINT id PK
>         VARCHAR(30) title
>         VARCHAR(200) description
>         VARCHAR author
>         VARCHAR password
>         DATETIME created_at
>         DATETIME modified_at
>     }
>
>     Comment {
>         BIGINT id PK
>         VARCHAR(100) comment
>         VARCHAR author
>         VARCHAR password
>         DATETIME created_at
>         DATETIME modified_at
>         BIGINT schedule_id FK
>     }
>
>     Schedule ||--o{ Comment : "has many"
> ```