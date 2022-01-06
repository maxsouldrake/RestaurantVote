Restaurant Vote
===============================
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/f073203d69b74172b254581172434e7d)](https://www.codacy.com/gh/maxsouldrake/RestaurantVote/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=maxsouldrake/RestaurantVote&amp;utm_campaign=Badge_Grade)

### Test Project

### Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend

#### The task is:

Build a voting system for deciding where to have lunch.

- 2 types of users: admin and regular users
- Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
- Menu changes each day (admins do the updates)
- Users can vote on which restaurant they want to have lunch at
- Only one vote counted per user
- If user votes again the same day:
    - If it is before 11:00 we assume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed Each restaurant provides a new menu each day.

###[Swagger API](http://localhost:8080/swagger-ui/index.html)