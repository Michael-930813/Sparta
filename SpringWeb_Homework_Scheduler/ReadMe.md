Scheduler Server
================
## This is SpringWeb Server Project using SpringJPA & MySQL
### Process respond to requests received in json format
###

> ## API Statement
> ### Temp Message 
> 
>- ## Create
> 1. ### CreateSchedule
>
>    **< ERD >**
>   <br>1. CreateScheduleRequest
>   ```json
>   {
>      "id" : 1,
>      "title" : "병원 방문",
>      "description" : "4시 고대병원 진료 예약",
>      "writter" : "김재환",
>      "createtime" :"2025-11-04T14:00:00",
>      "updated_at": "2025-11-04T14:10:00" 
>   }
>   ```
>   <br>2. CreateScheduleResponce 
>   ```json
>   {
>      "id" : 1,
>      "title" : "병원 방문",
>      "content" : "4시 고대병원 진료 예약",
>      "writter" : "김재환",
>      "createtime" :"2025-11-04T14:00:00",
>      "updated_at": "2025-11-04T14:10:00" 
>   }
>   ```