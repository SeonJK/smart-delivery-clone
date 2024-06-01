package com.seonjk.smartdeliveryclone.data.SmartDeliveryAPI

data class TrackingInfo(
    /** 택배사에서 광고용으로 사용하는 주소 */
    val adUrl: String,
    /** 배송 완료 여부 (true or false) */
    val complete: Boolean,
    /** 배송 완료 여부 (Y or N) */
    val completeYN: String,
    /** 배송예정 시간 */
    val estimate: String,
    /** 운송장 번호 */
    val invoiceNo: String,
    /** 상품이미지 url */
    val itemImage: String,
    /** 상품 이름 */
    val itemName: String,
    /**
     * 진행 단계
     * [level 1: 배송준비중, 2: 집화완료, 3: 배송중, 4: 지점 도착, 5: 배송출발, 6:배송 완료]
     * */
    val level: Int,
    /** 주문 번호 */
    val orderNumber: String,
    /** 상품 정보 */
    val productInfo: String,
    /** 받는 사람 주소 */
    val receiverAddr: String,
    /** 받는 사람 이름 */
    val receiverName: String,
    /** 수령인 정보 */
    val recipient: String,
    /** 조회 결과 */
    val result: String,
    /** 보내는 사람 */
    val senderName: String,
    /** 우편번호 */
    val zipCode: String,

    val firstDetail: TrackingDetail,
    val lastDetail: TrackingDetail,
    val lastStateDetail: TrackingDetail,
    val trackingDetails: Array<TrackingDetail>

)
