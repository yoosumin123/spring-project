### ( JAVA를 이용한 게시판 )
# Spring-Project
## 목차  
[1.프로젝트 목적](#프로젝트-목적)   
[2.개발 일정](#개발-일정)  
[3.개발 도구](#개발-도구)  
[4.사용 기술](#사용-기술)  
[5.주요 기능](#주요-기능)  
[6.다이어그램](#다이어그램)
## 프로젝트 목적
* Spring 학습 web 개발
* 게시판 기능의 바탕이 되는 CRUD 학습
## 개발 일정
### 09.13~09.20
![소스트리](https://user-images.githubusercontent.com/105259309/191186965-a29d443b-3f17-4116-bfdc-e81f8cc67279.png)

## 개발 도구
|도구|버전|
|---|---|
|운영체제|windows|
|데이터베이스|sql-developer|
|개발 툴|eclipse 21-03|
|JDK|open JDK 11.0.2|
|WAS|tomcat 9.0|

## 사용 기술

### Back
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

### front
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">

### Database
<img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">


## 주요 기능
<details>
    <summary>상세 정보</summary>

**notion :** (https://coal-source-32b.notion.site/Spring-5625c754663a4d97af702dc1651d604c)
### 1.메인 화면
<img src="https://user-images.githubusercontent.com/105259309/194516612-1876bb69-bb2a-4d7c-9fe9-967352e0b610.PNG" width="800" height="400">

### 2.회원가입 화면
<img src="https://user-images.githubusercontent.com/105259309/194517188-21382b91-2164-4f4a-8b52-894beec76cf3.PNG" width="800" height="400">
    
### 3.로그인 화면
<img src="https://user-images.githubusercontent.com/105259309/194517606-66eb8844-3592-411f-bdad-a66bd60e0be3.PNG" width="800" height="400">
    
#### 3.1 로그인 검사 실패
<img src="https://user-images.githubusercontent.com/105259309/191200906-6b01d012-30f6-4780-8ccf-50eff9e53e8c.png" width="400" height="200">

#### 3.2 로그인 검사 성공
<img src="https://user-images.githubusercontent.com/105259309/194517894-10866b07-551c-40fb-8784-9b8b606ae1ff.PNG" width="800" height="400">

### 4.게시판 화면
<img src="https://user-images.githubusercontent.com/105259309/194518193-21b3d83b-a0b6-4a50-bd97-91adc970f559.PNG" width="800" height="400">
    
#### 4.1 글 등록 메시지
<img src="https://user-images.githubusercontent.com/105259309/191205437-bd823699-5f0d-4f5b-be32-7ba30ce30b6b.png" width="400" height="200">

#### 4.2 글 등록 성공
<img src="https://user-images.githubusercontent.com/105259309/194518352-42716201-7599-40b6-9265-7ba8a24c4b12.PNG" width="800" height="600">
    
### 5.글 수정 
<img src="https://user-images.githubusercontent.com/105259309/194518520-594b95b6-ec5f-45b0-bce6-29002752b3e0.PNG" width="800" height="600">
    
#### 5.1 글 수정 성공 메시지
<img src="https://user-images.githubusercontent.com/105259309/191210020-fe86af25-d638-42b4-94d0-565a6c9a3bbd.png" width="400" height="200">
    
#### 5.2 글 수정 성공 화면
<img src="https://user-images.githubusercontent.com/105259309/194518684-eaf99adc-6a7d-4361-9ae0-7c9b35626b70.PNG" width="600" height="500">
</details>


## 다이어그램
<details>
    <summary>ERD 설계</summary>
    
![erd](https://user-images.githubusercontent.com/105259309/191183404-98743968-7850-4261-9597-0814bc7f0063.png)

</details>

<details>
    <summary>Class 다이어그램</summary>

#### 1. board
![boardClass](https://user-images.githubusercontent.com/105259309/191207319-27141f72-9ffd-4d96-9f15-6d69fe783697.png)
    
#### 2. member
![boardClass](https://user-images.githubusercontent.com/105259309/191209119-e4d7d7cf-3bc8-49e0-9681-3b6c58ae2170.png)

</details>
