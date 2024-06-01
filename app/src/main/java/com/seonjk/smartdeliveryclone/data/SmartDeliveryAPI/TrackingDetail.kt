package com.seonjk.smartdeliveryclone.data.SmartDeliveryAPI

data class TrackingDetail(
    /** 배송 상태 코드 */
    val code: String,
    /** 진행 상태 */
    val kind: String,
    /** 진행 단계 */
    val level: Int,
    /** 배송기사 이름 */
    val manName: String,
    /** 배송기사 전화번호 */
    val manPic: String,
    /** 비고 */
    val remark: String,
    /** 진행 위치(지점) 전화번호 */
    val telNo: String,
    /** 배송기사 전화번호 */
    val telNo2: String,
    /** 진행 시간 */
    val time: Int,
    /** 진행 시간 */
    val timeString: String,
    /** 진행 위치 지점 */
    val where: String
)
