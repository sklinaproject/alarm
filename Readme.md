1. Local 테스트 & 실행 확인
2. Dockerfile 수정
   - FROM openjdk:8u212-jdk-alpine   =>   FROM openjdk:11.0-slim
   git commit & push
3. github 접속 sklinaproject/repositories
   - Setting 탭 클릭
     secrets 메뉴 선택 -> alarm 과 같이 두 개 secrets 값 생성 ,DOCKERHUB_USERNAME : sklinaproject , DOCKERHUB_TOKEN : 70267f1b-40a5-4597-a6d9-a5e140cc978a
   - 태그 입력
     Code 탭 오른쪽 화면에 Create a new release 버튼 클릭  
     release 버전과 tags 입력 (alarm 참고)
   - Actions 탭 클릭 
     'set up a workflow yourself -> ' 클릭
     파일 이름 변경 main.yml => buildandpush.yml
     alarm/.github/workflows/buildandpush.yml 파일 내용 복사
     -> images: sklinaproject/alarm => sklinaproject/이미지명 으로 수정
     start commits 버튼 클릭
     완료시
4. https://hub.docker.com/ 접속
   repository 생성 확인
5. 테스트 
   https://3.36.186.10:8888/lab 접속
   docker run -d -p 8080:실행포트 sklinaproject/alarm
   docker ps -a => 컨테이너 실행확인
   docker logs 컨테이너ID => 로그확인
   curl -X GET localhost:8080/msgs => app 테스트
   완료후
   docker stop 컨테이너ID => 컨테이너 실행중지
   docker rm 컨테이너ID => 컨테이너 삭제
   docker image rm sklinaproject/alarm => 이미지 삭제
   
