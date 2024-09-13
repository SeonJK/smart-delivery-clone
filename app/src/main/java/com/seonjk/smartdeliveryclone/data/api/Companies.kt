package com.seonjk.smartdeliveryclone.data.api

data class Companies(
    /** 택배 회사 코드 */
    val code: String,
    /** 국제 택배 지원 여부 */
    val international: String,
    /** 택배 회사 이름 */
    val name: String
)
