## `GET /lottery/sales-report`

- **설명:** 로또 판매 보고서를 페이징하여 조회

- **요청 파라미터:**
    - `page` (int): 페이지 번호 (1부터 시작)
    - `size` (int): 페이지당 항목 수

- **응답:**
    - **200 OK**
        - **응답 값:**
            - `currentCount` (int): 현재 항목 수
            - `data` (array): 데이터 목록
                - `구분` (string): 구분
                - `연도` (int): 연도
                - `온라인복권(억원)` (int): 온라인복권(억원)
                - `전년대비증감률` (string): 전년대비증감률
                - `전자복권(억원)` (int): 전자복권(억원)
                - `즉석식인쇄복권(억원)` (int): 즉석식인쇄복권(억원)
                - `추첨식결합복권(억원)` (int): 추첨식결합복권(억원)
                - `합 계(억원)` (int): 합 계(억원)
            - `matchCount` (int): 전체 항목 수
            - `page` (int): 현재 페이지 번호
            - `perPage` (int): 페이지당 항목 수
            - `totalCount` (int): 전체 페이지 수

### 예시 응답

```json
{
  "currentCount": 20,
  "data": [
    {
      "구분": "발행액",
      "연도": 2008,
      "온라인복권(억원)": 22784,
      "전년대비증감률": "0.0200",
      "전자복권(억원)": 1074,
      "즉석식인쇄복권(억원)": 1200,
      "추첨식결합복권(억원)": 2340,
      "합 계(억원)": 27398
    },
    {
      "구분": "발행액",
      "연도": 2009,
      "온라인복권(억원)": 23572,
      "전년대비증감률": "0.0330",
      "전자복권(억원)": 1189,
      "즉석식인쇄복권(억원)": 1200,
      "추첨식결합복권(억원)": 2340,
      "합 계(억원)": 28301
    },
    ...
  ],
  "matchCount": 27,
  "page": 1,
  "perPage": 20,
  "totalCount": 27
}
```