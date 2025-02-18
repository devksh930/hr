package me.devksh930.hr.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LotterySalesReportQuery(
    @field:JsonProperty("구분") val category: String,
    @field:JsonProperty("연도") val year: Int,
    @field:JsonProperty("온라인복권(억원)") val onlineLottery: Int,
    @field:JsonProperty("전년대비증감률") val growthRate: String,
    @field:JsonProperty("전자복권(억원)") val electronicLottery: Int,
    @field:JsonProperty("즉석식인쇄복권(억원)") val instantLottery: Int,
    @field:JsonProperty("추첨식결합복권(억원)") val combinedLottery: Int,
    @field:JsonProperty("합 계(억원)") val totalAmount: Int
)
