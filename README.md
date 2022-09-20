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
<img src="https://user-images.githubusercontent.com/105259309/191200191-32fb72c3-d4cc-4722-b55d-7c3a1a5b4654.png" width="800" height="400">

### 2.회원가입 화면
<img src="https://user-images.githubusercontent.com/105259309/191204781-8f6701dc-a7df-439a-ab0a-fb22b4be88db.png" width="800" height="400">
    
### 3.로그인 화면
<img src="https://user-images.githubusercontent.com/105259309/191199906-d2562f1c-1fb5-4154-b586-571994e24c81.png" width="800" height="400">
    
#### 3.1 로그인 검사 실패
<img src="https://user-images.githubusercontent.com/105259309/191200906-6b01d012-30f6-4780-8ccf-50eff9e53e8c.png" width="400" height="200">

#### 3.2 로그인 검사 성공
<img src="https://user-images.githubusercontent.com/105259309/191203412-d55c46ed-f5b6-450a-bafd-d07d98f561ca.png" width="800" height="400">

### 4.게시판 화면
<img src="https://user-images.githubusercontent.com/105259309/191205193-5ca9e159-66a4-4357-89b1-305160ecb33e.png" width="800" height="400">
    
#### 4.1 글 등록 메시지
<img src="https://user-images.githubusercontent.com/105259309/191205437-bd823699-5f0d-4f5b-be32-7ba30ce30b6b.png" width="400" height="200">

#### 4.2 글 등록 성공
<img src="https://user-images.githubusercontent.com/105259309/191206050-34eb752e-5372-45bd-89ab-12bd88426e8e.png" width="800" height="600">
    
### 5.글 수정 
<img src="https://user-images.githubusercontent.com/105259309/191211201-93b97d98-ae74-4319-977d-d36fc7488296.png" width="800" height="600">
    
#### 5.1 글 수정 성공 메시지
<img src="https://user-images.githubusercontent.com/105259309/191210020-fe86af25-d638-42b4-94d0-565a6c9a3bbd.png" width="400" height="200">
    
#### 5.2 글 수정 성공 화면
<img src="https://user-images.githubusercontent.com/105259309/191211414-4e979582-edee-462d-a01e-952a714509ab.png" width="600" height="500">
<img src="https://user-images.githubusercontent.com/105259309/191211587-57ee5ef6-d0a7-4e3c-86e9-d0f5b5599c9d.png" width="600" height="500">
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
