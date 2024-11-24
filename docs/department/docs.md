### `GET /departments`

- **설명:** 모든 부서를 페이징하여 조회

- **요청 파라미터:**
    - `page` (int): 페이지 번호 (0부터 시작)
    - `size` (int): 페이지당 항목 수

- **응답:**
    - **200 OK**
        - **응답값:**
            - `departmentId`: 부서 ID
            - `departmentName`: 부서명
            - `manageId`: 관리자 ID
            - `locationId`: 위치 ID
            - `streetAddress`: 거리 주소
            - `postalCode`: 우편 번호
            - `city`: 도시
            - `stateProvince`: 주/도
            - `countryId`: 국가 ID
            - `countryName`: 국가명
            - `regionId`: 지역 ID
            - `regionName`: 지역명

      ```json
      {
        "content": [
          {
            "departmentId": 1,
            "departmentName": "HR",
            "manageId": 100,
            "locationId": 101,
            "streetAddress": "123 Main St",
            "postalCode": "12345",
            "city": "New York",
            "stateProvince": "NY",
            "countryId": "US",
            "countryName": "United States",
            "regionId": 1,
            "regionName": "North America"
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

### `PATCH /departments/{departmentId}/salary-increase`

- **설명:** 특정 부서의 직원들에게 급여 인상 적용

- **요청 파라미터:**
    - `departmentId` (int): 부서 ID

- **Request Body:**
    - `percentage` (double): 인상 비율

- **응답:**
    - **200 OK**
        - **응답값:**
            - `employeeId`: 직원 ID
            - `departmentId`: 부서 ID
            - `prevSalary`: 이전 급여
            - `newSalary`: 새로운 급여
            - `percentage`: 인상 비율(10% -> 0.1)
            - `hasSalaryIncreased`: 급여 인상 여부

      ```json
      [
        {
          "employeeId": 101,
          "departmentId": 1,
          "prevSalary": 50000.00,
          "newSalary": 55000.00,
          "percentage": 0.1,
          "hasSalaryIncreased": true
        },
        {
          "employeeId": 102,
          "departmentId": 1,
          "prevSalary": 60000.00,
          "newSalary": 66000.00,
          "percentage": 0.1,
          "hasSalaryIncreased": true
        }
      ]
      ```
