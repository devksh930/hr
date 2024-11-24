### `GET /employees`

- **설명:** 모든 직원을 페이징하여 조회

- **요청 파라미터:**
    - `page` (int): 페이지 번호 (0부터 시작)
    - `size` (int): 페이지당 항목 수

- **응답:**
    - **200 OK**
        - **응답값:**
            - `id`: 직원 ID
            - `firstName`: 이름
            - `lastName`: 성
            - `email`: 이메일
            - `phoneNumber`: 전화번호
            - `hireDate`: 고용일
            - `departmentId`: 부서 ID
            - `departmentName`: 부서명
            - `jobId`: 직무 ID
            - `jobTitle`: 직무명

      ```json
      {
        "content": [
          {
            "id": 206,
            "firstName": "John",
            "lastName": "Doe",
            "email": "john.doe@example.com",
            "phoneNumber": "123-456-7890",
            "hireDate": "2021-01-01",
            "departmentId": "D1",
            "departmentName": "IT",
            "jobId": "IT_PROG",
            "jobTitle": "Software Developer"
          }
        ],
        "page": {
          "size": 10,
          "number": 0,
          "totalElements": 1,
          "totalPages": 1
        }
      }
      ```

### `GET /employees/{employeeId}`

- **설명:** 특정 직원의 상세 정보 조회

- **요청 파라미터:**
    - `employeeId` (int): 직원 ID

- **응답:**
    - **200 OK**
        - **응답값:**
            - `id`: 직원 ID
            - `firstName`: 이름
            - `lastName`: 성
            - `jobId`: 직무 ID
            - `jobTitle`: 직무명
            - `departmentId`: 부서 ID
            - `departmentName`: 부서명
            - `locationId`: 위치 ID
            - `city`: 도시
            - `stateProvince`: 주/도
            - `countryId`: 국가 ID
            - `countryName`: 국가명
            - `regionName`: 지역명
            - `salary`: 급여
            - `commissionPct`: 커미션 비율
            - `managerId`: 매니저 ID

      ```json
      {
        "id": 206,
        "firstName": "John",
        "lastName": "Doe",
        "jobId": "IT_PROG",
        "jobTitle": "Software Developer",
        "departmentId": 1,
        "departmentName": "IT",
        "locationId": 10,
        "city": "New York",
        "stateProvince": "NY",
        "countryId": "US",
        "countryName": "United States",
        "regionName": "North America",
        "salary": 70000.00,
        "commissionPct": 0.10,
        "managerId": 500
      }
      ```

### `PATCH /employees/{employeeId}`

- **설명:** 특정 직원의 정보를 변경

- **요청 파라미터:**
    - `employeeId` (int): 직원 ID

- **Request Body:**
    - `firstName` (string): 새로운 이름
    - `lastName` (string): 새로운 성
    - `email` (string): 새로운 이메일
    - `phoneNumber` (string): 새로운 전화번호
    - `hireDate` (LocalDate): 새로운 고용일

- **응답:**
    - **204 No Content**
        - **응답 헤더:**
            - `Location: /employees/{employeeId}`

### `PATCH /employees/{employeeId}/department`

- **설명:** 특정 직원의 부서를 변경

- **요청 파라미터:**
    - `employeeId` (int): 직원 ID

- **Request Body:**
    - `departmentId` (int): 새 부서 ID

- **응답:**
    - **204 No Content**
        - **응답 헤더:**
            - `Location: /employees/{employeeId}`

### `PATCH /employees/{employeeId}/job`

- **설명:** 특정 직원의 직무를 변경

- **요청 파라미터:**
    - `employeeId` (int): 직원 ID

- **Request Body:**
    - `jobId` (string): 새 직무 ID
    - `startDate` (LocalDate): 직무 시작일
    - `endDate` (LocalDate): 직무 종료일

- **응답:**
    - **204 No Content**
        - **응답 헤더:**
            - `Location: /employees/{employeeId}`

### `GET /employees/{employeeId}/job-history`

- **설명:** 특정 직원의 직무 이력을 페이징하여 조회

- **요청 파라미터:**
    - `employeeId` (int): 직원 ID
    - `page` (int): 페이지 번호 (0부터 시작)
    - `size` (int): 페이지당 항목 수

- **응답:**
    - **200 OK**
        - **응답값:**
            - `employeeId`: 직원 ID
            - `startDate`: 직무 시작일
            - `endDate`: 직무 종료일
            - `jobId`: 직무 ID
            - `jobTitle`: 직무명
            - `departmentId`: 부서 ID
            - `departmentName`: 부서명

      ```json
      {
        "content": [
          {
            "employeeId": 206,
            "startDate": "2020-01-01",
            "endDate": "2021-01-01",
            "jobId": "IT_PROG",
            "jobTitle": "Software Developer",
            "departmentId": 1,
            "departmentName": "IT"
          },
          {
            "employeeId": 206,
            "startDate": "2021-02-01",
            "endDate": "2022-01-01",
            "jobId": "SYS_ADM",
            "jobTitle": "System Administrator",
            "departmentId": 2,
            "departmentName": "HR"
          }
        ],
        "page": {
          "size": 10,
          "number": 0,
          "totalElements": 2,
          "totalPages": 1
        }
      }
      ```